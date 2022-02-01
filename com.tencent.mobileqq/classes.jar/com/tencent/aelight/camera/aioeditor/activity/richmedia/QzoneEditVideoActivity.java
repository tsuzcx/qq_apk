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
  private static final String jdField_a_of_type_JavaLangString = "QzoneEditVideoActivity";
  private QzEditVideoPartManager jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager;
  private QzoneVerticalVideoTopicInfo jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo;
  private boolean jdField_a_of_type_Boolean = false;
  
  private void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    b(paramIntent);
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
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
  
  private boolean a()
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
  
  private boolean a(Intent paramIntent)
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
      if (a().getIntent() != null) {
        a().getIntent().putExtra("from_qzone_slideshow", true);
      }
      int k = paramIntent.getIntExtra("key_font_id", -1);
      int m = paramIntent.getIntExtra("key_font_format_type", 0);
      localObject3 = paramIntent.getStringExtra("key_font_url");
      int n = paramIntent.getIntExtra("key_super_font_id", -1);
      String str = paramIntent.getStringExtra("key_super_font_info");
      boolean bool1 = paramIntent.getBooleanExtra("key_generate_gif", false);
      boolean bool2 = paramIntent.getBooleanExtra("key_timer_delete", false);
      boolean bool3 = paramIntent.getBooleanExtra("key_sync_to_qqstory", false);
      PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
      int i;
      if (localPublishParam.f <= 5) {
        i = localPublishParam.f;
      } else {
        i = 0;
      }
      int i1 = (int)localPublishParam.jdField_a_of_type_Long;
      boolean bool4 = paramIntent.getBooleanExtra("param.isUploadOrigin", false);
      a(localPublishParam.k, i, localPublishParam.j, localPublishParam.jdField_c_of_type_JavaLangString, localPublishParam.b, i1, null, (String)localObject1, j, (ArrayList)localObject2, false, k, m, (String)localObject3, n, str, bool1, bool2, bool3, bool4);
      return true;
    }
    return false;
  }
  
  private void b(@Nullable Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager;
      if (localObject != null)
      {
        paramIntent.putExtra("key_content", ((QzEditVideoPartManager)localObject).jdField_c_of_type_JavaLangString);
        paramIntent.putExtra("key_topic_sync_qzone", this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_b_of_type_Boolean);
        paramIntent.putExtra("key_priv", this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_Int);
        paramIntent.putExtra("key_priv_uin_list", this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_JavaUtilArrayList);
        paramIntent.putExtra("key_font_id", this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_b_of_type_Int);
        paramIntent.putExtra("key_font_format_type", this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_c_of_type_Int);
        paramIntent.putExtra("key_font_url", this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_d_of_type_JavaLangString);
        paramIntent.putExtra("key_super_font_id", this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_d_of_type_Int);
        paramIntent.putExtra("key_super_font_info", this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_e_of_type_JavaLangString);
        paramIntent.putExtra("key_timer_delete", this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.l);
        paramIntent.putExtra("key_sync_to_qqstory", this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.j);
        paramIntent.putExtra("param.isUploadOrigin", this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.k);
        if ((QzoneSlideShowPhotoListManager.a().a() == 14) || (QzoneSlideShowPhotoListManager.a().a() == 19)) {
          a(paramIntent);
        }
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QzoneEditVideoActivity ");
        localStringBuilder.append(paramIntent.getExtras());
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.i = a();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("mIsQzoneVip", false);
  }
  
  private void d()
  {
    boolean bool = getIntent().getBooleanExtra("enable_input_text", true);
    QzEditVideoPartManager localQzEditVideoPartManager = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager;
    localQzEditVideoPartManager.jdField_d_of_type_Boolean = bool;
    localQzEditVideoPartManager.jdField_e_of_type_Boolean = getIntent().getBooleanExtra("enable_sync_qzone", false);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.f = getIntent().getBooleanExtra("enable_priv_list", true);
    if (!TextUtils.isEmpty(getIntent().getStringExtra("topic_id"))) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_c_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_b_of_type_Int = getIntent().getIntExtra("key_font_id", -1);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_d_of_type_Int = getIntent().getIntExtra("key_super_font_id", -1);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("key_super_font_info");
  }
  
  private void e()
  {
    this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo = ((QzoneVerticalVideoTopicInfo)getIntent().getParcelableExtra("key_qzone_topic"));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager = new QzEditVideoPartManager(this);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager;
    d();
    c();
    e();
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
          paramIntent.append(HardCodeUtil.a(2131711681));
          paramIntent.append((String)localObject);
          QQToast.a(this, paramIntent.toString(), 0).a();
          finish();
          return;
        }
        doOnPause();
        doOnStop();
        doOnDestroy();
        setIntent(paramIntent);
        doOnCreate(null);
        doOnResume();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.dismissLoadingDialog();
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
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.showLoadingDialog(HardCodeUtil.a(2131711677), false, 500L);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.u_();
      this.jdField_a_of_type_Boolean = true;
      ((CaptureComboManager)QIMManager.a(5)).a(this);
      QzoneSlideShowPhotoListManager.a().a(this, new QzoneEditVideoActivity.1(this), 2);
      return;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    QzEditVideoPartManager localQzEditVideoPartManager = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager;
    if (localQzEditVideoPartManager != null) {
      localQzEditVideoPartManager.n = true;
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    findViewById(2064122522).setVisibility(8);
    return bool;
  }
  
  protected void doOnDestroy()
  {
    if ((!this.jdField_a_of_type_Boolean) && (QzoneSlideShowPhotoListManager.a().b() == 22)) {
      if (QzoneSlideShowPhotoListManager.a().a() == 19)
      {
        QzoneSlideShowPhotoListManager.a().b(14);
      }
      else if (QzoneSlideShowPhotoListManager.a().a() == 14)
      {
        QzoneSlideShowPhotoListManager.a().c(20);
        QzoneSlideShowPhotoListManager.a().b(99);
      }
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    super.doOnDestroy();
  }
  
  public void finish(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.n)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditVideoActivity
 * JD-Core Version:    0.7.0.1
 */