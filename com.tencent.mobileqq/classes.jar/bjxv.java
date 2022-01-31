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
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import dov.com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.3;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.4;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.5;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.6;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.7;
import dov.com.tencent.biz.qqstory.takevideo.MultiBlockVideoPlayer;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr;
import dov.com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

public class bjxv
  extends bjxl
  implements bjxx, bjzr, bldm, bldn
{
  public float a;
  public long a;
  protected Handler a;
  protected ImageView a;
  public EditRecordVideoSource a;
  public ImageViewVideoPlayer a;
  public List<bjzq> a;
  protected boolean a;
  public Handler b;
  protected boolean b;
  
  public bjxv(@NonNull bjxn parambjxn)
  {
    super(parambjxn);
    this.jdField_a_of_type_Float = 0.2F;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper());
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    float f = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.d * 1.0F / this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_c_of_type_Int;
    ved.c("Q.qqstory.record.EditVideoPlayer", "updateVideoDrawablePlayerUI width" + paramInt1 + "heightRatio=" + f + "dst_height" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.d + "dst_width=" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_c_of_type_Int);
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(paramInt1, paramInt2, f, false, blcq.a(5.0F));
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int == 3)
    {
      ved.b("Q.qqstory.record.EditVideoPlayer", "pausePreview");
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.c();
      bjtk localbjtk = (bjtk)a(bjtk.class);
      if (localbjtk != null) {
        localbjtk.ab_();
      }
      return;
    }
    ved.d("Q.qqstory.record.EditVideoPlayer", "pausePreview but the player has not started : " + this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int);
  }
  
  private void o()
  {
    if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int == 4))
    {
      ved.b("Q.qqstory.record.EditVideoPlayer", "restartPreview");
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.b();
      bjtk localbjtk = (bjtk)a(bjtk.class);
      if (localbjtk != null) {
        localbjtk.d();
      }
      return;
    }
    ved.d("Q.qqstory.record.EditVideoPlayer", "restartPreview but the player is not stopping : " + this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Int);
  }
  
  private void p()
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      this.jdField_a_of_type_Bjxn.a(Message.obtain(null, 8));
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new EditVideoPlayer.3(this));
  }
  
  public int a()
  {
    return 0;
  }
  
  public long a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (paramInt < ((List)localObject).size()))
      {
        localObject = (bjzq)((List)localObject).get(paramInt);
        return ((bjzq)localObject).d - ((bjzq)localObject).jdField_c_of_type_Long;
      }
    }
    return -1L;
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
      for (localObject = (bjzq)((List)localObject).get(paramInt); localObject == null; localObject = null) {
        return null;
      }
      return a((bjzq)localObject);
    }
    Object localObject = new Bitmap[1];
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoPlayer.4(this, paramInt, (Bitmap[])localObject, localCountDownLatch));
    try
    {
      ved.b("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap waiting ...");
      localCountDownLatch.await();
      ved.a("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap done bitmap = %s", localObject[0]);
      return localObject[0];
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        ved.c("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap error", localInterruptedException);
      }
    }
  }
  
  public Bitmap a(@NonNull bjzq parambjzq)
  {
    Bitmap localBitmap = null;
    Object localObject = (bjsv)a(bjsv.class);
    int j;
    int i;
    if (localObject != null)
    {
      j = ((bjsv)localObject).a(parambjzq.jdField_c_of_type_Int);
      i = ((bjsv)localObject).a(this.jdField_a_of_type_Bjxn.a());
      ved.a("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap for %d, playModeNeeded = %d, currentPlayMode = %d", Integer.valueOf(parambjzq.jdField_c_of_type_Int), Integer.valueOf(j), Integer.valueOf(i));
    }
    for (;;)
    {
      localObject = (bjsu)a(bjsu.class);
      int k;
      byte[] arrayOfByte;
      if (localObject != null)
      {
        k = ((bjsu)localObject).a();
        arrayOfByte = ((bjsu)localObject).a(parambjzq.jdField_c_of_type_Int);
      }
      for (localObject = ((bjsu)localObject).a(this.jdField_a_of_type_Bjxn.a());; localObject = null)
      {
        if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer)) {}
        try
        {
          VideoSourceHelper.nativeSetPlayMode(j);
          VideoSourceHelper.nativeSetMosaic(k, arrayOfByte);
          ved.a("Q.qqstory.record.EditVideoPlayer", "generateVideoFrameBitmap, playMode=%d, info=%s", Integer.valueOf(j), parambjzq);
          if (j == 1)
          {
            localBitmap = ((MultiBlockVideoPlayer)this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(parambjzq.b - 1L, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.a(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.b());
            return localBitmap;
          }
          parambjzq = ((MultiBlockVideoPlayer)this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(parambjzq.jdField_a_of_type_Long, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.a(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.b());
          return parambjzq;
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
  
  public List<? extends bkaa> a()
  {
    if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer))
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      if (localList != null)
      {
        int i = localList.size();
        if (i > 1) {}
        for (bjzq localbjzq = (bjzq)localList.get(i - 1); (localbjzq != null) && (localbjzq.b - localbjzq.jdField_a_of_type_Long < 3L); localbjzq = null) {
          return Collections.unmodifiableList(localList.subList(0, i - 1));
        }
        return Collections.unmodifiableList(localList);
      }
    }
    return Collections.emptyList();
  }
  
  public void a()
  {
    blan.a();
    a(0, null);
    a(false);
    b(0);
    MultiBlockVideoPlayer.a();
    boolean bool1 = bjxn.a(this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Long, 262144);
    boolean bool2 = VideoEnvironment.b(7);
    ved.d("Q.qqstory.record.EditVideoPlayer", "recordMultiVideoFragment = %s, supportMultiVideoFragment = %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    Object localObject;
    label272:
    label290:
    String str2;
    String str1;
    if ((bool1) && (bool2))
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (!(this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource)) {
        break label459;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource = ((EditRecordVideoSource)this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = ((ImageViewVideoPlayer)a(2131366413));
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131366443));
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setCyclePlay(true);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPlayerEndListener(this);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPFrameListener(this);
      if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer))) {
        ((MultiBlockVideoPlayer)this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).setVideoLoadListener(this);
      }
      a(bjzx.a(a()), bjzx.b(a()));
      localObject = RMVideoStateMgr.a().a.a();
      if (localObject == null) {
        break label481;
      }
      ved.c("Q.qqstory.record.EditVideoPlayer", "get player cover success.");
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setVisibility(8);
      if (!this.jdField_a_of_type_Bjxn.a()) {
        break label492;
      }
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setNeedPlayAudio(false);
      if (TextUtils.isEmpty(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_JavaLangString)) {
        break label555;
      }
      ved.d("Q.qqstory.record.EditVideoPlayer", "onCreate init play");
      str2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_JavaLangString;
      localObject = null;
      str1 = null;
      Bundle localBundle = this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle;
      if (localBundle == null) {
        break label569;
      }
      bool1 = localBundle.getBoolean("SecurityChecked", false);
      if (!bool1) {
        break label566;
      }
      localObject = localBundle.getString("AFPath");
      str1 = localBundle.getString("VFPath");
    }
    for (;;)
    {
      if (bool1)
      {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(axim.jdField_c_of_type_Int, (int)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_Long, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_Int, str2, (String)localObject, str1);
        label410:
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_b_of_type_Boolean = false;
        ved.d("Q.qqstory.record.EditVideoPlayer", "onCreate init player, securityChecked=%s, afFilePath=%s, vfFilePath=%s", new Object[] { Boolean.valueOf(bool1), localObject, str1 });
      }
      for (;;)
      {
        a(bjxx.class, this);
        return;
        bool1 = false;
        break;
        label459:
        ved.d("Q.qqstory.record.EditVideoPlayer", "edit source type mismatch !");
        a().a(0, null, 0, 0);
        return;
        label481:
        ved.e("Q.qqstory.record.EditVideoPlayer", "get player cover return null!");
        break label272;
        label492:
        vej.jdField_a_of_type_Long = this.jdField_a_of_type_Bjyv.getActivity().getIntent().getLongExtra("stop_record_time", 0L);
        vej.b = System.currentTimeMillis();
        break label290;
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(axim.jdField_c_of_type_Int, (int)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_Long, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditRecordVideoSource.jdField_a_of_type_Int, str2, false);
        break label410;
        label555:
        ved.d("Q.qqstory.record.EditVideoPlayer", "onCreate init player failed !");
      }
      label566:
      continue;
      label569:
      bool1 = false;
    }
  }
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    Object localObject;
    long l2;
    long l1;
    if ((paramInt == 1) && (this.jdField_a_of_type_Long == 0L) && (!this.jdField_a_of_type_Bjxn.a()))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      localObject = QQStoryContext.a().a();
      vej.a(this.jdField_a_of_type_Long, (String)localObject);
      ved.b("Q.qqstory.record.EditVideoPlayer", "onCurrentFrame:" + paramInt + ", mPreivewContentTime:" + this.jdField_a_of_type_Long);
      if (0L != 0L) {
        break label229;
      }
      localObject = this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle;
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
        localObject = this.jdField_a_of_type_Bjyv.getActivity();
        l4 = l1;
        l3 = l2;
        if (localObject != null)
        {
          l3 = ((Activity)localObject).getIntent().getLongExtra("stop_record_time", 0L);
          l4 = System.currentTimeMillis();
        }
      }
      if (l3 != 0L) {
        vei.b("video_edit", "startEditVideoTime", this.jdField_a_of_type_Bjxn.b(), 0, new String[] { String.valueOf(l4 - l3) });
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
  
  public void a(int paramInt, @NonNull bkld parambkld)
  {
    super.a(paramInt, parambkld);
    if (!this.jdField_a_of_type_Boolean) {
      parambkld.a.hasFragments = false;
    }
    for (;;)
    {
      return;
      Object localObject1 = this.jdField_a_of_type_JavaUtilList;
      if ((localObject1 == null) || (((List)localObject1).size() <= 0))
      {
        parambkld.a.hasFragments = false;
        return;
      }
      parambkld.a.hasFragments = false;
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (bjzq)((Iterator)localObject2).next();
        if (localObject1 == null)
        {
          ved.e("Q.qqstory.record.EditVideoPlayer", "editVideoPrePublish error. RecordVideoBlockInfo is null.");
        }
        else if (((bjzq)localObject1).jdField_c_of_type_Int == paramInt)
        {
          parambkld.a.hasFragments = true;
          localObject2 = new JSONObject();
        }
      }
      try
      {
        ((JSONObject)localObject2).put("vfFrameIndexStart", ((bjzq)localObject1).jdField_a_of_type_Long);
        ((JSONObject)localObject2).put("vfFrameIndexEnd", ((bjzq)localObject1).b);
        ((JSONObject)localObject2).put("afTimeStart", ((bjzq)localObject1).jdField_c_of_type_Long);
        ((JSONObject)localObject2).put("afTimeEnd", ((bjzq)localObject1).d);
        parambkld.a.fragments = ((JSONObject)localObject2).toString();
        ved.b("Q.qqstory.record.EditVideoPlayer", "fragments = %s.", parambkld.a.fragments);
        ved.b("Q.qqstory.record.EditVideoPlayer", "editVideoPrePublish : %s", parambkld.a.fragments);
        if (parambkld.a.hasFragments) {
          continue;
        }
        ved.e("Q.qqstory.record.EditVideoPlayer", "editVideoPrePublish, can not find RecordVideoBlockInfo with fragment index %d", new Object[] { Integer.valueOf(paramInt) });
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
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoPlayer.5(this, paramInt, paramArrayOfByte));
  }
  
  public void a(long paramLong, boolean paramBoolean) {}
  
  public void a(Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer)) {
      ((MultiBlockVideoPlayer)this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer).a(paramBitmap);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void a(bjzq parambjzq)
  {
    ved.a("Q.qqstory.record.EditVideoPlayer", "updateVideoFrameBitmap info=%s", parambjzq);
    Object localObject = a(parambjzq);
    if (localObject != null)
    {
      Bitmap localBitmap = vxv.a((Bitmap)localObject, this.jdField_a_of_type_Float, false);
      a((Bitmap)localObject);
      if (localBitmap != null)
      {
        localObject = new ArrayList(this.jdField_a_of_type_JavaUtilList);
        bjzq localbjzq = (bjzq)((List)localObject).get(parambjzq.jdField_c_of_type_Int);
        ((List)localObject).set(parambjzq.jdField_c_of_type_Int, localbjzq.a(localBitmap));
        this.jdField_a_of_type_JavaUtilList = ((List)localObject);
        p();
      }
    }
  }
  
  public void a(TransferData paramTransferData) {}
  
  public void a(boolean paramBoolean)
  {
    ved.a("Q.qqstory.record.EditVideoPlayer", "setPlayMute mute = %s", Boolean.valueOf(paramBoolean));
    VideoSourceHelper.nativeSetPlayAFMute(paramBoolean);
  }
  
  public boolean a(long paramLong)
  {
    return false;
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
    if ((paramMessage.what == 6) && (this.jdField_a_of_type_Boolean))
    {
      int i = paramMessage.arg2;
      int j = paramMessage.arg1;
      if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer instanceof MultiBlockVideoPlayer)) {
        this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoPlayer.1(this, i, j));
      }
    }
    return false;
  }
  
  public void aW_()
  {
    super.aW_();
    ved.d("Q.qqstory.record.EditVideoPlayer", "onStop stop play");
    b(false);
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      o();
    case 10: 
      return;
    }
    b(true);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoPlayer.6(this, paramInt));
  }
  
  public void b(long paramLong, boolean paramBoolean) {}
  
  public void ba_()
  {
    super.ba_();
    ved.d("Q.qqstory.record.EditVideoPlayer", "onPause stop play");
    b(false);
    NativeVideoImage.pauseAll();
  }
  
  public void c()
  {
    ved.e("Q.qqstory.record.EditVideoPlayer", "onPlayerEnd");
  }
  
  public void d()
  {
    bjtk localbjtk = (bjtk)a(bjtk.class);
    if (localbjtk != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "onPlayerRecyle2()");
      }
      localbjtk.b();
    }
  }
  
  public void f()
  {
    super.f();
    NativeVideoImage.resumeAll();
    switch (this.jdField_a_of_type_Bjxn.jdField_a_of_type_Int)
    {
    case 0: 
    case 2: 
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      o();
    }
  }
  
  public void g()
  {
    super.g();
    ved.d("Q.qqstory.record.EditVideoPlayer", "onDestroy release play");
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.c();
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.e();
    blan.b();
    MultiBlockVideoPlayer.a();
  }
  
  public void i()
  {
    ved.b("Q.qqstory.record.EditVideoPlayer", "onDrawLastFrameEnd : mBlurLastFrame = " + this.jdField_b_of_type_Boolean);
    Bitmap localBitmap2 = this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_AndroidGraphicsBitmap;
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a();
    }
    if (localBitmap1 != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
      if (this.jdField_b_of_type_Boolean) {
        Stream.of(localBitmap1).map(new ThreadOffFunction("Q.qqstory.record.EditVideoPlayer", 2)).map(new bkac(0.2F, false)).map(new bkad(10)).map(new UIThreadOffFunction(this)).subscribe(new bjxw(this));
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_Boolean) && (MultiBlockVideoPlayer.class.isInstance(this.jdField_a_of_type_DovComTencentMobileqqShortvideoWidgetImageViewVideoPlayer))) {
      this.jdField_a_of_type_AndroidOsHandler.post(new EditVideoPlayer.7(this));
    }
  }
  
  public void k()
  {
    b(false);
  }
  
  public void l()
  {
    o();
  }
  
  public void n() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjxv
 * JD-Core Version:    0.7.0.1
 */