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
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import dov.com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.2;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.3;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.4;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.5;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.6;
import dov.com.tencent.biz.qqstory.takevideo.MultiBlockVideoPlayer;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr;
import dov.com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

public class boub
  extends botu
  implements boud, bovd, bpui, bpuj
{
  public float a;
  protected Handler a;
  protected ImageView a;
  public EditRecordVideoSource a;
  public ImageViewVideoPlayer a;
  public List<bovc> a;
  protected boolean a;
  public long b;
  protected Handler b;
  protected boolean b;
  
  public boub(@NonNull botw parambotw)
  {
    super(parambotw);
    this.jdField_a_of_type_Float = 0.2F;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper());
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    float f = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.d * 1.0F / this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_c_of_type_Int;
    ykq.c("Q.qqstory.record.EditVideoPlayer", "updateVideoDrawablePlayerUI width" + paramInt1 + "heightRatio=" + f + "dst_height" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.d + "dst_width=" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_c_of_type_Int);
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(paramInt1, paramInt2, f, false, bptp.a(5.0F));
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int == 3)
    {
      ykq.b("Q.qqstory.record.EditVideoPlayer", "pausePreview");
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.c();
      bosc localbosc = (bosc)a(bosc.class);
      if (localbosc != null) {
        localbosc.c();
      }
      return;
    }
    ykq.d("Q.qqstory.record.EditVideoPlayer", "pausePreview but the player has not started : " + this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int);
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int == 4))
    {
      ykq.b("Q.qqstory.record.EditVideoPlayer", "restartPreview");
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.b();
      bosc localbosc = (bosc)a(bosc.class);
      if (localbosc != null) {
        localbosc.d();
      }
      return;
    }
    ykq.d("Q.qqstory.record.EditVideoPlayer", "restartPreview but the player is not stopping : " + this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int);
  }
  
  private void q()
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      this.jdField_a_of_type_Botw.a(Message.obtain(null, 8));
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new EditVideoPlayer.2(this));
  }
  
  public Bitmap a(int paramInt)
  {
    if ((!this.jdField_a_of_type_Boolean) && (QLog.isColorLevel())) {
      QLog.d("Q.qqstory.record.EditVideoPlayer", 2, "generateVideoFrameBitmap enableMultiVideoFragment:" + this.jdField_a_of_type_Boolean);
    }
    if (Looper.myLooper() == this.jdField_a_of_type_AndroidOsHandler.getLooper())
    {
      localObject = this.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (paramInt < ((List)localObject).size())) {}
      for (localObject = (bovc)((List)localObject).get(paramInt); localObject == null; localObject = null) {
        return null;
      }
      return a((bovc)localObject);
    }
    Object localObject = new Bitmap[1];
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoPlayer.3(this, paramInt, (Bitmap[])localObject, localCountDownLatch));
    try
    {
      ykq.b("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap waiting ...");
      localCountDownLatch.await();
      ykq.a("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap done bitmap = %s", localObject[0]);
      return localObject[0];
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        ykq.c("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap error", localInterruptedException);
      }
    }
  }
  
  public Bitmap a(@NonNull bovc parambovc)
  {
    Bitmap localBitmap = null;
    Object localObject = (bort)a(bort.class);
    int j;
    int i;
    if (localObject != null)
    {
      j = ((bort)localObject).a(parambovc.jdField_c_of_type_Int);
      i = ((bort)localObject).a(this.jdField_a_of_type_Botw.a());
      ykq.a("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap for %d, playModeNeeded = %d, currentPlayMode = %d", Integer.valueOf(parambovc.jdField_c_of_type_Int), Integer.valueOf(j), Integer.valueOf(i));
    }
    for (;;)
    {
      localObject = (bors)a(bors.class);
      int k;
      byte[] arrayOfByte;
      if (localObject != null)
      {
        k = ((bors)localObject).a();
        arrayOfByte = ((bors)localObject).a(parambovc.jdField_c_of_type_Int);
      }
      for (localObject = ((bors)localObject).a(this.jdField_a_of_type_Botw.a());; localObject = null)
      {
        if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer)) {}
        try
        {
          VideoSourceHelper.nativeSetPlayMode(j);
          VideoSourceHelper.nativeSetMosaic(k, arrayOfByte);
          ykq.a("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap, playMode=%d, info=%s", Integer.valueOf(j), parambovc);
          if (j == 1)
          {
            localBitmap = ((MultiBlockVideoPlayer)this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(parambovc.jdField_b_of_type_Long - 1L, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.a(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.b());
            return localBitmap;
          }
          parambovc = ((MultiBlockVideoPlayer)this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(parambovc.jdField_a_of_type_Long, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.a(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.b());
          return parambovc;
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
  
  public void a()
  {
    bprm.a();
    a(0, null);
    a(false);
    b(0);
    MultiBlockVideoPlayer.a();
    ykq.d("Q.qqstory.record.EditVideoPlayer", "recordMultiVideoFragment = %s, supportMultiVideoFragment = %s", new Object[] { Boolean.valueOf(false), Boolean.valueOf(VideoEnvironment.getAVCodecSurpportFeature(7)) });
    this.jdField_a_of_type_Boolean = false;
    Object localObject;
    label261:
    String str2;
    String str1;
    boolean bool;
    if ((this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource = ((EditRecordVideoSource)this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = ((ImageViewVideoPlayer)a(2131366983));
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131367013));
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setCyclePlay(true);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPlayerEndListener(this);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPFrameListener(this);
      if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer))) {
        ((MultiBlockVideoPlayer)this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).setVideoLoadListener(this);
      }
      a(bovj.a(a()), bovj.b(a()));
      localObject = RMVideoStateMgr.a().a.a();
      if (localObject == null) {
        break label443;
      }
      ykq.c("Q.qqstory.record.EditVideoPlayer", "get player cover success.");
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setVisibility(8);
      if (!this.jdField_a_of_type_Botw.a()) {
        break label454;
      }
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setNeedPlayAudio(false);
      if (TextUtils.isEmpty(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_JavaLangString)) {
        break label517;
      }
      ykq.d("Q.qqstory.record.EditVideoPlayer", "onCreate init play");
      str2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_JavaLangString;
      localObject = null;
      str1 = null;
      Bundle localBundle = this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle;
      if (localBundle == null) {
        break label531;
      }
      bool = localBundle.getBoolean("SecurityChecked", false);
      if (!bool) {
        break label528;
      }
      localObject = localBundle.getString("AFPath");
      str1 = localBundle.getString("VFPath");
    }
    for (;;)
    {
      if (bool)
      {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(CodecParam.RECORD_MAX_TIME, (int)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_Long, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_Int, str2, (String)localObject, str1);
        label378:
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_b_of_type_Boolean = false;
        ykq.d("Q.qqstory.record.EditVideoPlayer", "onCreate init player, securityChecked=%s, afFilePath=%s, vfFilePath=%s", new Object[] { Boolean.valueOf(bool), localObject, str1 });
      }
      for (;;)
      {
        a(boud.class, this);
        return;
        ykq.d("Q.qqstory.record.EditVideoPlayer", "edit source type mismatch !");
        a().a(0, null, 0, 0);
        return;
        label443:
        ykq.e("Q.qqstory.record.EditVideoPlayer", "get player cover return null!");
        break;
        label454:
        ykw.jdField_a_of_type_Long = this.jdField_a_of_type_Bouo.getActivity().getIntent().getLongExtra("stop_record_time", 0L);
        ykw.jdField_b_of_type_Long = System.currentTimeMillis();
        break label261;
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(CodecParam.RECORD_MAX_TIME, (int)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_Long, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_Int, str2, false);
        break label378;
        label517:
        ykq.d("Q.qqstory.record.EditVideoPlayer", "onCreate init player failed !");
      }
      label528:
      continue;
      label531:
      bool = false;
    }
  }
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    Object localObject;
    long l2;
    long l1;
    if ((paramInt == 1) && (this.jdField_b_of_type_Long == 0L) && (!this.jdField_a_of_type_Botw.a()))
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      localObject = QQStoryContext.a().a();
      ykw.a(this.jdField_b_of_type_Long, (String)localObject);
      ykq.b("Q.qqstory.record.EditVideoPlayer", "onCurrentFrame:" + paramInt + ", mPreivewContentTime:" + this.jdField_b_of_type_Long);
      if (0L != 0L) {
        break label229;
      }
      localObject = this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle;
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
        localObject = this.jdField_a_of_type_Bouo.getActivity();
        l4 = l1;
        l3 = l2;
        if (localObject != null)
        {
          l3 = ((Activity)localObject).getIntent().getLongExtra("stop_record_time", 0L);
          l4 = System.currentTimeMillis();
        }
      }
      if (l3 != 0L) {
        ykv.b("video_edit", "startEditVideoTime", this.jdField_a_of_type_Botw.b(), 0, new String[] { String.valueOf(l4 - l3) });
      }
      return;
      label229:
      l1 = 0L;
      l2 = 0L;
    }
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat)
  {
    VideoSourceHelper.nativeSetSlideMode(paramInt2, paramFloat);
  }
  
  public void a(int paramInt, @NonNull bpel parambpel)
  {
    super.a(paramInt, parambpel);
    if (!this.jdField_a_of_type_Boolean) {
      parambpel.a.hasFragments = false;
    }
    for (;;)
    {
      return;
      Object localObject1 = this.jdField_a_of_type_JavaUtilList;
      if ((localObject1 == null) || (((List)localObject1).size() <= 0))
      {
        parambpel.a.hasFragments = false;
        return;
      }
      parambpel.a.hasFragments = false;
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (bovc)((Iterator)localObject2).next();
        if (localObject1 == null)
        {
          ykq.e("Q.qqstory.record.EditVideoPlayer", "editVideoPrePublish error. RecordVideoBlockInfo is null.");
        }
        else if (((bovc)localObject1).jdField_c_of_type_Int == paramInt)
        {
          parambpel.a.hasFragments = true;
          localObject2 = new JSONObject();
        }
      }
      try
      {
        ((JSONObject)localObject2).put("vfFrameIndexStart", ((bovc)localObject1).jdField_a_of_type_Long);
        ((JSONObject)localObject2).put("vfFrameIndexEnd", ((bovc)localObject1).jdField_b_of_type_Long);
        ((JSONObject)localObject2).put("afTimeStart", ((bovc)localObject1).jdField_c_of_type_Long);
        ((JSONObject)localObject2).put("afTimeEnd", ((bovc)localObject1).d);
        parambpel.a.fragments = ((JSONObject)localObject2).toString();
        ykq.b("Q.qqstory.record.EditVideoPlayer", "fragments = %s.", parambpel.a.fragments);
        ykq.b("Q.qqstory.record.EditVideoPlayer", "editVideoPrePublish : %s", parambpel.a.fragments);
        if (parambpel.a.hasFragments) {
          continue;
        }
        ykq.e("Q.qqstory.record.EditVideoPlayer", "editVideoPrePublish, can not find RecordVideoBlockInfo with fragment index %d", new Object[] { Integer.valueOf(paramInt) });
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
    n();
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoPlayer.4(this, paramInt, paramArrayOfByte));
  }
  
  public void a(Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer)) {
      ((MultiBlockVideoPlayer)this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(paramBitmap);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void a(TransferData paramTransferData) {}
  
  public void a(boolean paramBoolean)
  {
    ykq.a("Q.qqstory.record.EditVideoPlayer", "setPlayMute mute = %s", Boolean.valueOf(paramBoolean));
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
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.b();
        continue;
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.c();
        continue;
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.d();
      }
    }
    return false;
  }
  
  public void aG_()
  {
    n();
  }
  
  public void aH_()
  {
    super.aH_();
    ykq.d("Q.qqstory.record.EditVideoPlayer", "onPause stop play");
    b(false);
    NativeVideoImage.pauseAll();
  }
  
  public void aI_()
  {
    super.aI_();
    NativeVideoImage.resumeAll();
    switch (this.jdField_a_of_type_Botw.jdField_a_of_type_Int)
    {
    default: 
      n();
    }
  }
  
  public void aL_()
  {
    super.aL_();
    ykq.d("Q.qqstory.record.EditVideoPlayer", "onStop stop play");
    b(false);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (MultiBlockVideoPlayer.class.isInstance(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer))) {
      this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoPlayer.6(this));
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoPlayer.5(this, paramInt));
  }
  
  public void c()
  {
    ykq.e("Q.qqstory.record.EditVideoPlayer", "onPlayerEnd");
  }
  
  public void d()
  {
    bosc localbosc = (bosc)a(bosc.class);
    if (localbosc != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "onPlayerRecyle2()");
      }
      localbosc.b();
    }
  }
  
  public void g()
  {
    super.g();
    ykq.d("Q.qqstory.record.EditVideoPlayer", "onDestroy release play");
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.c();
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.e();
    bprm.b();
    MultiBlockVideoPlayer.a();
  }
  
  public void i()
  {
    ykq.b("Q.qqstory.record.EditVideoPlayer", "onDrawLastFrameEnd : mBlurLastFrame = " + this.jdField_b_of_type_Boolean);
    Bitmap localBitmap2 = this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_AndroidGraphicsBitmap;
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a();
    }
    if (localBitmap1 != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
      if (this.jdField_b_of_type_Boolean) {
        Stream.of(localBitmap1).map(new ThreadOffFunction("Q.qqstory.record.EditVideoPlayer", 2)).map(new bovn(0.2F, false)).map(new bovo(10)).map(new UIThreadOffFunction(this)).subscribe(new bouc(this));
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void k() {}
  
  public void l()
  {
    b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boub
 * JD-Core Version:    0.7.0.1
 */