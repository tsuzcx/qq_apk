package com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.bitmap.BitmapAdjustJobSegment;
import com.tencent.biz.qqstory.takevideo.bitmap.BlurJobSegment;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.IMPFrameListener;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.IMPlayerEndListener;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

public class EditVideoPlayer
  extends EditVideoPart
  implements EditVideoPlayerExport, MultiBlockVideoPlayer.VideoLoadListener, ImageViewVideoPlayer.IMPFrameListener, ImageViewVideoPlayer.IMPlayerEndListener
{
  protected float a;
  public long a;
  protected Handler a;
  protected ImageView a;
  protected EditRecordVideoSource a;
  protected ImageViewVideoPlayer a;
  protected List<MultiBlockVideoPlayer.RecordVideoBlockInfo> a;
  protected boolean a;
  protected Handler b;
  protected boolean b;
  
  public EditVideoPlayer(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Float = 0.2F;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper());
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    float f = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.d * 1.0F / this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_c_of_type_Int;
    SLog.c("Q.qqstory.record.EditVideoPlayer", "updateVideoDrawablePlayerUI width" + paramInt1 + "heightRatio=" + f + "dst_height" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.d + "dst_width=" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.updateUISize(paramInt1, paramInt2, f, false, ScreenUtil.dip2px(5.0F));
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.mPlayerState == 3)
    {
      SLog.b("Q.qqstory.record.EditVideoPlayer", "pausePreview");
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.stopPlayer();
      EditMusicExport localEditMusicExport = (EditMusicExport)a(EditMusicExport.class);
      if (localEditMusicExport != null) {
        localEditMusicExport.X_();
      }
      return;
    }
    SLog.d("Q.qqstory.record.EditVideoPlayer", "pausePreview but the player has not started : " + this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.mPlayerState);
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.mPlayerState == 2) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.mPlayerState == 4))
    {
      SLog.b("Q.qqstory.record.EditVideoPlayer", "restartPreview");
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.startPlayer();
      EditMusicExport localEditMusicExport = (EditMusicExport)a(EditMusicExport.class);
      if (localEditMusicExport != null) {
        localEditMusicExport.g();
      }
      return;
    }
    SLog.d("Q.qqstory.record.EditVideoPlayer", "restartPreview but the player is not stopping : " + this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.mPlayerState);
  }
  
  private void l()
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 8));
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new EditVideoPlayer.3(this));
  }
  
  public void U_()
  {
    super.U_();
    NativeVideoImage.resumeAll();
    switch (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b)
    {
    case 0: 
    case 2: 
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      k();
    }
  }
  
  public void V_()
  {
    super.V_();
    SLog.d("Q.qqstory.record.EditVideoPlayer", "onStop stop play");
    b(false);
  }
  
  public long a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (paramInt < ((List)localObject).size()))
      {
        localObject = (MultiBlockVideoPlayer.RecordVideoBlockInfo)((List)localObject).get(paramInt);
        return ((MultiBlockVideoPlayer.RecordVideoBlockInfo)localObject).d - ((MultiBlockVideoPlayer.RecordVideoBlockInfo)localObject).jdField_c_of_type_Long;
      }
    }
    return -1L;
  }
  
  public Bitmap a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new IllegalStateException("not supported while EditVideoParams.ENABLE_MULTI_VIDEO_FRAGMENT is off");
    }
    if (Looper.myLooper() == this.jdField_a_of_type_AndroidOsHandler.getLooper())
    {
      localObject = this.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (paramInt < ((List)localObject).size())) {}
      for (localObject = (MultiBlockVideoPlayer.RecordVideoBlockInfo)((List)localObject).get(paramInt); localObject == null; localObject = null) {
        return null;
      }
      return a((MultiBlockVideoPlayer.RecordVideoBlockInfo)localObject);
    }
    Object localObject = new Bitmap[1];
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoPlayer.4(this, paramInt, (Bitmap[])localObject, localCountDownLatch));
    try
    {
      SLog.b("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap waiting ...");
      localCountDownLatch.await();
      SLog.a("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap done bitmap = %s", localObject[0]);
      return localObject[0];
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        SLog.c("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap error", localInterruptedException);
      }
    }
  }
  
  protected Bitmap a(@NonNull MultiBlockVideoPlayer.RecordVideoBlockInfo paramRecordVideoBlockInfo)
  {
    Bitmap localBitmap = null;
    Object localObject = (EditFilterExport)a(EditFilterExport.class);
    int j;
    int i;
    if (localObject != null)
    {
      j = ((EditFilterExport)localObject).a(paramRecordVideoBlockInfo.jdField_c_of_type_Int);
      i = ((EditFilterExport)localObject).a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a());
      SLog.a("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap for %d, playModeNeeded = %d, currentPlayMode = %d", Integer.valueOf(paramRecordVideoBlockInfo.jdField_c_of_type_Int), Integer.valueOf(j), Integer.valueOf(i));
    }
    for (;;)
    {
      localObject = (EditDoodleExport)a(EditDoodleExport.class);
      int k;
      byte[] arrayOfByte;
      if (localObject != null)
      {
        k = ((EditDoodleExport)localObject).a();
        arrayOfByte = ((EditDoodleExport)localObject).a(paramRecordVideoBlockInfo.jdField_c_of_type_Int);
      }
      for (localObject = ((EditDoodleExport)localObject).a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a());; localObject = null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer)) {}
        try
        {
          VideoSourceHelper.nativeSetPlayMode(j);
          VideoSourceHelper.nativeSetMosaic(k, arrayOfByte);
          SLog.a("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap, playMode=%d, info=%s", Integer.valueOf(j), paramRecordVideoBlockInfo);
          if (j == 1)
          {
            localBitmap = ((MultiBlockVideoPlayer)this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(paramRecordVideoBlockInfo.b - 1L, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.a(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.b());
            return localBitmap;
          }
          paramRecordVideoBlockInfo = ((MultiBlockVideoPlayer)this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(paramRecordVideoBlockInfo.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.a(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.b());
          return paramRecordVideoBlockInfo;
        }
        finally
        {
          VideoSourceHelper.nativeSetPlayMode(i);
          VideoSourceHelper.nativeSetMosaic(k, (byte[])localObject);
        }
        arrayOfByte = null;
        k = 0;
      }
      i = 0;
      j = 0;
    }
  }
  
  public List<? extends VideoFragmentInfo> a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer))
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      if (localList != null)
      {
        int i = localList.size();
        if (i > 1) {}
        for (MultiBlockVideoPlayer.RecordVideoBlockInfo localRecordVideoBlockInfo = (MultiBlockVideoPlayer.RecordVideoBlockInfo)localList.get(i - 1); (localRecordVideoBlockInfo != null) && (localRecordVideoBlockInfo.b - localRecordVideoBlockInfo.jdField_a_of_type_Long < 11L); localRecordVideoBlockInfo = null) {
          return Collections.unmodifiableList(localList.subList(0, i - 1));
        }
        return Collections.unmodifiableList(localList);
      }
    }
    return Collections.emptyList();
  }
  
  public void a()
  {
    GloableValue.a();
    a(0, null);
    a(false);
    a(0);
    MultiBlockVideoPlayer.a();
    boolean bool = EditVideoPartManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.b, 32768);
    SLog.d("Q.qqstory.record.EditVideoPlayer", "recordMultiVideoFragment = %s, supportMultiVideoFragment = %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(false) });
    if (bool) {}
    this.jdField_a_of_type_Boolean = false;
    Object localObject;
    label278:
    String str2;
    String str1;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource = ((EditRecordVideoSource)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = ((ImageViewVideoPlayer)a(2131367175));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131367205));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setCyclePlay(true);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPlayerEndListener(this);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPFrameListener(this);
      if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer))) {
        ((MultiBlockVideoPlayer)this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).setVideoLoadListener(this);
      }
      a(TakeVideoUtils.a(a()), TakeVideoUtils.b(a()));
      localObject = RMVideoStateMgr.a().a.a();
      if (localObject == null) {
        break label460;
      }
      SLog.c("Q.qqstory.record.EditVideoPlayer", "get player cover success.");
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setVisibility(8);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
        break label471;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setNeedPlayAudio(false);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_JavaLangString)) {
        break label534;
      }
      SLog.d("Q.qqstory.record.EditVideoPlayer", "onCreate init play");
      str2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_JavaLangString;
      localObject = null;
      str1 = null;
      Bundle localBundle = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_AndroidOsBundle;
      if (localBundle == null) {
        break label548;
      }
      bool = localBundle.getBoolean("SecurityChecked", false);
      if (!bool) {
        break label545;
      }
      localObject = localBundle.getString("AFPath");
      str1 = localBundle.getString("VFPath");
    }
    for (;;)
    {
      if (bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.initEditPlayer(CodecParam.RECORD_MAX_TIME, (int)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_Int, str2, (String)localObject, str1);
        label395:
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.mRequireAudioFocus = false;
        SLog.d("Q.qqstory.record.EditVideoPlayer", "onCreate init player, securityChecked=%s, afFilePath=%s, vfFilePath=%s", new Object[] { Boolean.valueOf(bool), localObject, str1 });
      }
      for (;;)
      {
        a(EditVideoPlayerExport.class, this);
        return;
        SLog.d("Q.qqstory.record.EditVideoPlayer", "edit source type mismatch !");
        a().a(0, null, 0, 0);
        return;
        label460:
        SLog.e("Q.qqstory.record.EditVideoPlayer", "get player cover return null!");
        break;
        label471:
        VideoEditReport.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent().getLongExtra("stop_record_time", 0L);
        VideoEditReport.b = System.currentTimeMillis();
        break label278;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.initPlayer(CodecParam.RECORD_MAX_TIME, (int)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_Int, str2, false);
        break label395;
        label534:
        SLog.d("Q.qqstory.record.EditVideoPlayer", "onCreate init player failed !");
      }
      label545:
      continue;
      label548:
      bool = false;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoPlayer.6(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat)
  {
    VideoSourceHelper.nativeSetSlideMode(paramInt2, paramFloat);
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    if (!this.jdField_a_of_type_Boolean) {
      paramGenerateContext.a.hasFragments = false;
    }
    for (;;)
    {
      return;
      Object localObject1 = this.jdField_a_of_type_JavaUtilList;
      if ((localObject1 == null) || (((List)localObject1).size() <= 0))
      {
        paramGenerateContext.a.hasFragments = false;
        return;
      }
      paramGenerateContext.a.hasFragments = false;
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (MultiBlockVideoPlayer.RecordVideoBlockInfo)((Iterator)localObject2).next();
        if (localObject1 == null)
        {
          SLog.e("Q.qqstory.record.EditVideoPlayer", "editVideoPrePublish error. RecordVideoBlockInfo is null.");
        }
        else if (((MultiBlockVideoPlayer.RecordVideoBlockInfo)localObject1).jdField_c_of_type_Int == paramInt)
        {
          paramGenerateContext.a.hasFragments = true;
          localObject2 = new JSONObject();
        }
      }
      try
      {
        ((JSONObject)localObject2).put("vfFrameIndexStart", ((MultiBlockVideoPlayer.RecordVideoBlockInfo)localObject1).jdField_a_of_type_Long);
        ((JSONObject)localObject2).put("vfFrameIndexEnd", ((MultiBlockVideoPlayer.RecordVideoBlockInfo)localObject1).b);
        ((JSONObject)localObject2).put("afTimeStart", ((MultiBlockVideoPlayer.RecordVideoBlockInfo)localObject1).jdField_c_of_type_Long);
        ((JSONObject)localObject2).put("afTimeEnd", ((MultiBlockVideoPlayer.RecordVideoBlockInfo)localObject1).d);
        paramGenerateContext.a.fragments = ((JSONObject)localObject2).toString();
        SLog.b("Q.qqstory.record.EditVideoPlayer", "fragments = %s.", paramGenerateContext.a.fragments);
        SLog.b("Q.qqstory.record.EditVideoPlayer", "editVideoPrePublish : %s", paramGenerateContext.a.fragments);
        if (paramGenerateContext.a.hasFragments) {
          continue;
        }
        SLog.e("Q.qqstory.record.EditVideoPlayer", "editVideoPrePublish, can not find RecordVideoBlockInfo with fragment index %d", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    case 2: 
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      k();
    case 10: 
      return;
    }
    b(true);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoPlayer.5(this, paramInt, paramArrayOfByte));
  }
  
  public void a(Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer)) {
      ((MultiBlockVideoPlayer)this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(paramBitmap);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean) {}
  
  protected void a(MultiBlockVideoPlayer.RecordVideoBlockInfo paramRecordVideoBlockInfo)
  {
    SLog.a("Q.qqstory.record.EditVideoPlayer", "updateVideoFrameBitmap info=%s", paramRecordVideoBlockInfo);
    Object localObject = a(paramRecordVideoBlockInfo);
    if (localObject != null)
    {
      Bitmap localBitmap = BitmapUtils.a((Bitmap)localObject, this.jdField_a_of_type_Float, false);
      a((Bitmap)localObject);
      if (localBitmap != null)
      {
        localObject = new ArrayList(this.jdField_a_of_type_JavaUtilList);
        MultiBlockVideoPlayer.RecordVideoBlockInfo localRecordVideoBlockInfo = (MultiBlockVideoPlayer.RecordVideoBlockInfo)((List)localObject).get(paramRecordVideoBlockInfo.jdField_c_of_type_Int);
        ((List)localObject).set(paramRecordVideoBlockInfo.jdField_c_of_type_Int, localRecordVideoBlockInfo.a(localBitmap));
        this.jdField_a_of_type_JavaUtilList = ((List)localObject);
        l();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SLog.a("Q.qqstory.record.EditVideoPlayer", "setPlayMute mute = %s", Boolean.valueOf(paramBoolean));
    VideoSourceHelper.nativeSetPlayAFMute(paramBoolean);
  }
  
  protected boolean a(Message paramMessage)
  {
    if (paramMessage.what == 3)
    {
      switch (paramMessage.arg1)
      {
      }
      for (;;)
      {
        return true;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.startPlayer();
        continue;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.stopPlayer();
        continue;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.resetPlay();
      }
    }
    if ((paramMessage.what == 6) && (this.jdField_a_of_type_Boolean))
    {
      int i = paramMessage.arg2;
      int j = paramMessage.arg1;
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer)) {
        this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoPlayer.1(this, i, j));
      }
    }
    return false;
  }
  
  public void d()
  {
    super.d();
    SLog.d("Q.qqstory.record.EditVideoPlayer", "onDestroy release play");
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.stopPlayer();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.releasePlayer();
    GloableValue.b();
    MultiBlockVideoPlayer.a();
  }
  
  public void f()
  {
    super.f();
    SLog.d("Q.qqstory.record.EditVideoPlayer", "onPause stop play");
    b(false);
    NativeVideoImage.pauseAll();
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Boolean) && (MultiBlockVideoPlayer.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer))) {
      this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoPlayer.7(this));
    }
  }
  
  public void h()
  {
    b(false);
  }
  
  public void i()
  {
    k();
  }
  
  public void j() {}
  
  public void onCurrentFrame(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    Object localObject;
    long l2;
    long l1;
    if ((paramInt == 1) && (this.jdField_a_of_type_Long == 0L) && (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a()))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      localObject = QQStoryContext.a().a();
      VideoEditReport.a(this.jdField_a_of_type_Long, (String)localObject);
      SLog.b("Q.qqstory.record.EditVideoPlayer", "onCurrentFrame:" + paramInt + ", mPreivewContentTime:" + this.jdField_a_of_type_Long);
      if (0L != 0L) {
        break label229;
      }
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.jdField_a_of_type_AndroidOsBundle;
      if (localObject == null) {
        break label229;
      }
      l2 = ((Bundle)localObject).getLong("startEditVideoTime", 0L);
      l1 = SystemClock.uptimeMillis();
    }
    for (;;)
    {
      long l4 = l1;
      long l3 = l2;
      if (l2 == 0L)
      {
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
        l4 = l1;
        l3 = l2;
        if (localObject != null)
        {
          l3 = ((Activity)localObject).getIntent().getLongExtra("stop_record_time", 0L);
          l4 = System.currentTimeMillis();
        }
      }
      if (l3 != 0L) {
        StoryReportor.b("video_edit", "startEditVideoTime", this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b(), 0, new String[] { String.valueOf(l4 - l3) });
      }
      return;
      label229:
      l1 = 0L;
      l2 = 0L;
    }
  }
  
  public void onDrawLastFrameEnd()
  {
    SLog.b("Q.qqstory.record.EditVideoPlayer", "onDrawLastFrameEnd : mBlurLastFrame = " + this.jdField_b_of_type_Boolean);
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.mLastFramePicture;
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.getCurrentBitmap();
    }
    if (localBitmap1 != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
      if (this.jdField_b_of_type_Boolean) {
        Stream.of(localBitmap1).map(new ThreadOffFunction("Q.qqstory.record.EditVideoPlayer", 2)).map(new BitmapAdjustJobSegment(0.2F, false)).map(new BlurJobSegment(10)).map(new UIThreadOffFunction(this)).subscribe(new EditVideoPlayer.2(this));
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void onPlayerEnd()
  {
    SLog.e("Q.qqstory.record.EditVideoPlayer", "onPlayerEnd");
  }
  
  public void onPlayerRecyle()
  {
    EditMusicExport localEditMusicExport = (EditMusicExport)a(EditMusicExport.class);
    if (localEditMusicExport != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "onPlayerRecyle2()");
      }
      localEditMusicExport.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPlayer
 * JD-Core Version:    0.7.0.1
 */