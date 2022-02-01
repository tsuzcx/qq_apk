package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.shortvideo.util.PtvFilterUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoUi;
import com.tencent.aelight.camera.qqstory.api.IMediaCodecSendTask;
import com.tencent.aelight.camera.struct.editor.FlowComponentInterface;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.aelight.camera.struct.editor.VideoSendPublicParamBase;
import com.tencent.biz.qqstory.takevideo.slideshow.QzoneSlideShowPhotoListManager;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import java.io.File;
import java.util.ArrayList;

public class QzoneEditVideoActivity
  extends EditVideoActivity
{
  private static final String c = "QzoneEditVideoActivity";
  private QzEditVideoPartManager d;
  private boolean e = false;
  private QzoneVerticalVideoTopicInfo f;
  
  private void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    b(paramIntent);
    if (QLog.isColorLevel())
    {
      String str = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QzoneEditVideoActivity finish --- resultCode : ");
      localStringBuilder.append(paramInt1);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    super.finish(paramInt1, paramIntent, paramInt2, paramInt3, paramBoolean);
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, FlowComponentInterface paramFlowComponentInterface, String paramString5, int paramInt3, ArrayList<String> paramArrayList, boolean paramBoolean1, int paramInt4, int paramInt5, String paramString6, int paramInt6, String paramString7, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString1 = new File(paramString2).getParent();
    if (!TextUtils.isEmpty(paramString4)) {
      PtvFilterUtils.a(paramString1, paramString4);
    }
    VideoSendPublicParamBase localVideoSendPublicParamBase = new VideoSendPublicParamBase();
    localVideoSendPublicParamBase.mContext = this;
    localVideoSendPublicParamBase.mVideoCacheDir = paramString1;
    localVideoSendPublicParamBase.mEncodeMode = paramInt1;
    localVideoSendPublicParamBase.mVideoFilePath = paramString2;
    localVideoSendPublicParamBase.mThumbFilePath = paramString3;
    localVideoSendPublicParamBase.mThumbWidth = 0;
    localVideoSendPublicParamBase.mThumbHeight = 0;
    localVideoSendPublicParamBase.fakeVid = paramString4;
    localVideoSendPublicParamBase.recordTime = paramInt2;
    localVideoSendPublicParamBase.mUserCallBack = paramFlowComponentInterface;
    localVideoSendPublicParamBase.mContent = paramString5;
    localVideoSendPublicParamBase.mPriv = paramInt3;
    localVideoSendPublicParamBase.mPrivUinList = paramArrayList;
    localVideoSendPublicParamBase.topicSyncQzone = paramBoolean1;
    localVideoSendPublicParamBase.fontId = paramInt4;
    localVideoSendPublicParamBase.fontFormatType = paramInt5;
    localVideoSendPublicParamBase.fontUrl = paramString6;
    localVideoSendPublicParamBase.superFontId = paramInt6;
    localVideoSendPublicParamBase.superFontInfo = paramString7;
    localVideoSendPublicParamBase.generateGif = paramBoolean2;
    localVideoSendPublicParamBase.timerDelete = paramBoolean3;
    localVideoSendPublicParamBase.isUploadOrigin = paramBoolean5;
    localVideoSendPublicParamBase.entrySource = 3;
    localVideoSendPublicParamBase.mUin = "";
    localVideoSendPublicParamBase.mUinType = 0;
    localVideoSendPublicParamBase.mTroopUin = "";
    ((IMediaCodecSendTask)QRoute.api(IMediaCodecSendTask.class)).execute(localVideoSendPublicParamBase);
  }
  
  private void b(@Nullable Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Object localObject = this.d;
      if (localObject != null)
      {
        paramIntent.putExtra("key_content", ((QzEditVideoPartManager)localObject).g);
        paramIntent.putExtra("key_topic_sync_qzone", this.d.i);
        paramIntent.putExtra("key_priv", this.d.d);
        paramIntent.putExtra("key_priv_uin_list", this.d.c);
        paramIntent.putExtra("key_font_id", this.d.o);
        paramIntent.putExtra("key_font_format_type", this.d.p);
        paramIntent.putExtra("key_font_url", this.d.q);
        paramIntent.putExtra("key_super_font_id", this.d.r);
        paramIntent.putExtra("key_super_font_info", this.d.s);
        paramIntent.putExtra("key_timer_delete", this.d.z);
        paramIntent.putExtra("key_sync_to_qqstory", this.d.x);
        paramIntent.putExtra("param.isUploadOrigin", this.d.y);
        if ((QzoneSlideShowPhotoListManager.a().d() == 14) || (QzoneSlideShowPhotoListManager.a().d() == 19)) {
          c(paramIntent);
        }
        localObject = c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QzoneEditVideoActivity ");
        localStringBuilder.append(paramIntent.getExtras());
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
    }
  }
  
  private boolean c(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Object localObject2 = paramIntent.getStringExtra("key_content");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      int j = paramIntent.getIntExtra("key_priv", 1);
      Object localObject3 = (ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list");
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new ArrayList();
      }
      if (c().getIntent() != null) {
        c().getIntent().putExtra("from_qzone_slideshow", true);
      }
      int k = paramIntent.getIntExtra("key_font_id", -1);
      int m = paramIntent.getIntExtra("key_font_format_type", 0);
      localObject3 = paramIntent.getStringExtra("key_font_url");
      int n = paramIntent.getIntExtra("key_super_font_id", -1);
      String str = paramIntent.getStringExtra("key_super_font_info");
      boolean bool1 = paramIntent.getBooleanExtra("key_generate_gif", false);
      boolean bool2 = paramIntent.getBooleanExtra("key_timer_delete", false);
      boolean bool3 = paramIntent.getBooleanExtra("key_sync_to_qqstory", false);
      PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.a);
      int i;
      if (localPublishParam.n <= 5) {
        i = localPublishParam.n;
      } else {
        i = 0;
      }
      int i1 = (int)localPublishParam.j;
      boolean bool4 = paramIntent.getBooleanExtra("param.isUploadOrigin", false);
      a(localPublishParam.u, i, localPublishParam.t, localPublishParam.c, localPublishParam.b, i1, null, (String)localObject1, j, (ArrayList)localObject2, false, k, m, (String)localObject3, n, str, bool1, bool2, bool3, bool4);
      return true;
    }
    return false;
  }
  
  private void e()
  {
    this.d.u = h();
    this.d.h = getIntent().getBooleanExtra("mIsQzoneVip", false);
  }
  
  private void f()
  {
    boolean bool = getIntent().getBooleanExtra("enable_input_text", true);
    QzEditVideoPartManager localQzEditVideoPartManager = this.d;
    localQzEditVideoPartManager.k = bool;
    localQzEditVideoPartManager.l = getIntent().getBooleanExtra("enable_sync_qzone", false);
    this.d.m = getIntent().getBooleanExtra("enable_priv_list", true);
    if (!TextUtils.isEmpty(getIntent().getStringExtra("topic_id"))) {
      this.d.j = true;
    }
    this.d.o = getIntent().getIntExtra("key_font_id", -1);
    this.d.r = getIntent().getIntExtra("key_super_font_id", -1);
    this.d.s = getIntent().getStringExtra("key_super_font_info");
  }
  
  private void g()
  {
    this.f = ((QzoneVerticalVideoTopicInfo)getIntent().getParcelableExtra("key_qzone_topic"));
    this.d.w = this.f;
  }
  
  private boolean h()
  {
    Intent localIntent = getIntent();
    boolean bool2 = false;
    int i = localIntent.getIntExtra("entry_source", 0);
    boolean bool1 = bool2;
    if (i != 3)
    {
      bool1 = bool2;
      if (i != 5) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected void a()
  {
    this.d = new QzEditVideoPartManager(this);
    this.b = this.d;
    f();
    e();
    g();
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Object localObject = paramIntent.getExtras();
      if (localObject != null)
      {
        localObject = (EditVideoParams)((Bundle)localObject).getParcelable(EditVideoParams.class.getName());
        if (localObject != null) {
          localObject = ((EditVideoParams)localObject).a();
        } else {
          localObject = "can not find EditVideoParams";
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramIntent = new StringBuilder();
          paramIntent.append(HardCodeUtil.a(2131909319));
          paramIntent.append((String)localObject);
          QQToast.makeText(this, paramIntent.toString(), 0).show();
          finish();
          return;
        }
        doOnPause();
        doOnStop();
        doOnDestroy();
        setIntent(paramIntent);
        doOnCreate(null);
        doOnResume();
        this.d.H.dismissLoadingDialog();
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 666) && (paramIntent != null) && (paramIntent.getBooleanExtra("key_is_qzone_slide_show_edited", false)))
    {
      paramIntent = paramIntent.getParcelableArrayListExtra("qzone_slide_show_matters");
      QzoneSlideShowPhotoListManager.a().b(paramIntent);
      QzoneSlideShowPhotoListManager.a().a(paramIntent);
      getIntent().putExtra("from_qzone_slideshow", true);
      getIntent().putExtra("edit_video_type", 10001);
      getIntent().putExtra("qq_sub_business_id", 3);
      getIntent().putExtra("qzone_slide_enable_mask", 50043L);
      this.d.H.showLoadingDialog(HardCodeUtil.a(2131909315), false, 500L);
      this.d.av_();
      this.e = true;
      ((CaptureComboManager)QIMManager.a(5)).a(this);
      QzoneSlideShowPhotoListManager.a().a(this, new QzoneEditVideoActivity.1(this), 2);
      return;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    QzEditVideoPartManager localQzEditVideoPartManager = this.d;
    if (localQzEditVideoPartManager != null) {
      localQzEditVideoPartManager.B = true;
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    findViewById(2063991341).setVisibility(8);
    return bool;
  }
  
  protected void doOnDestroy()
  {
    if ((!this.e) && (QzoneSlideShowPhotoListManager.a().e() == 22)) {
      if (QzoneSlideShowPhotoListManager.a().d() == 19)
      {
        QzoneSlideShowPhotoListManager.a().b(14);
      }
      else if (QzoneSlideShowPhotoListManager.a().d() == 14)
      {
        QzoneSlideShowPhotoListManager.a().c(20);
        QzoneSlideShowPhotoListManager.a().b(99);
      }
    }
    if (this.e) {
      this.e = false;
    }
    super.doOnDestroy();
  }
  
  public void finish(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3)
  {
    if (this.d.B)
    {
      a(paramInt1, paramIntent, paramInt2, paramInt3, false);
      return;
    }
    a(paramInt1, paramIntent, paramInt2, paramInt3, true);
  }
  
  public void finish(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    a(paramInt1, paramIntent, paramInt2, paramInt3, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditVideoActivity
 * JD-Core Version:    0.7.0.1
 */