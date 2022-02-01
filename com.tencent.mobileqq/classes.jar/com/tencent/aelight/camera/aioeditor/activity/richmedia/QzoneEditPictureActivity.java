package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem.TextMap;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.TextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicArgs;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.editor.params.EditVideoParams.EditSource;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.widget.QzoneGuideBubbleHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class QzoneEditPictureActivity
  extends EditPicActivity
{
  private QzoneEditPicturePartManager a;
  
  public static Intent a(Activity paramActivity, String paramString)
  {
    paramActivity = EditPicActivity.startEditPic(paramActivity, paramString, true, true, true, true, true, false, false, false, 3, 99, 0, false, null);
    paramActivity.putExtra("TEMP_PARAM", paramActivity.getLongExtra("TEMP_PARAM", 0L) | 0x200);
    return paramActivity;
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    return EditPicActivity.startEditPic(paramActivity, paramString, true, true, true, paramBoolean, true, false, false, false, paramInt1, paramInt2, paramInt3, false, null);
  }
  
  private void a()
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QzoneEditPictureActivity.1(this));
  }
  
  private void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Object localObject;
    if (paramIntent != null)
    {
      localObject = this.a;
      if ((localObject != null) && (((QzoneEditPicturePartManager)localObject).a()))
      {
        paramIntent.putExtra("key_content", this.a.jdField_c_of_type_JavaLangString);
        paramIntent.putExtra("key_priv", this.a.jdField_a_of_type_Int);
        paramIntent.putExtra("key_priv_uin_list", this.a.jdField_a_of_type_JavaUtilArrayList);
        paramIntent.putExtra("key_font_id", this.a.b);
        paramIntent.putExtra("key_font_format_type", this.a.jdField_c_of_type_Int);
        paramIntent.putExtra("key_font_url", this.a.jdField_d_of_type_JavaLangString);
        paramIntent.putExtra("key_super_font_id", this.a.jdField_d_of_type_Int);
        paramIntent.putExtra("key_super_font_info", this.a.e);
        paramIntent.putExtra("key_timer_delete", this.a.b());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("EditPic mSetTimerDelete: ");
        ((StringBuilder)localObject).append(this.a.b());
        QLog.i("QzoneEditPictureActivit", 2, ((StringBuilder)localObject).toString());
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QzoneEditPictureActivity finish --- resultCode : ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.i("QzoneEditPictureActivit", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramIntent != null) && (paramInt1 != 0))
    {
      boolean bool = paramIntent.getBooleanExtra("go_publish_activity", false);
      if (paramIntent.getBooleanExtra("extra_directly_back", false))
      {
        paramIntent.setClass(this, NewPhotoListActivity.class);
        paramIntent.addFlags(872415232);
        startActivity(paramIntent);
        setResult(-1);
        super.finish(paramInt1, paramIntent, paramInt2, paramInt3, paramBoolean);
        return;
      }
      if (!bool)
      {
        QZoneHelper.launchQZone(this, "", paramIntent, -1);
        super.finish(-1, null, 2130772056, 0, paramBoolean);
        return;
      }
      super.finish(-1, paramIntent, 2130772056, 0, paramBoolean);
      return;
    }
    super.finish(paramInt1, paramIntent, paramInt2, paramInt3, paramBoolean);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if ((getIntent() != null) && (getIntent().getBooleanExtra("go_publish_activity", false)))
    {
      this.a = new QzoneEditPicturePartManager(this, true);
      setEditVideoPartManager(this.a);
    }
    else
    {
      this.a = new QzoneEditPicturePartManager(this, false);
      setEditVideoPartManager(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnCreate do nothing, use original manager ");
      localStringBuilder.append(super.getClass().getName());
      QZLog.d("QzoneEditPictureActivit", 2, localStringBuilder.toString());
    }
    boolean bool = super.doOnCreate(paramBundle);
    if (EditPicPartManager.a((int)getIntent().getLongExtra("TEMP_PARAM", 0L), 64))
    {
      a();
      return bool;
    }
    paramBundle = findViewById(2064122522);
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    return bool;
  }
  
  public void finish(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramIntent, paramInt2, paramInt3, false);
  }
  
  public void finish(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    a(paramInt1, paramIntent, paramInt2, paramInt3, paramBoolean);
  }
  
  public Intent getPublishIntent(GenerateContext paramGenerateContext)
  {
    Intent localIntent;
    if (this.mEditVideoPartManager.jdField_a_of_type_AndroidContentIntent == null) {
      localIntent = getIntent();
    } else {
      localIntent = this.mEditVideoPartManager.jdField_a_of_type_AndroidContentIntent;
    }
    String str = localIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
    Object localObject1 = localIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME");
    if ((str != null) && (localObject1 != null))
    {
      localIntent.setClassName((String)localObject1, str);
      localIntent.putExtra("open_chatfragment_fromphoto", true);
    }
    ArrayList localArrayList = new ArrayList();
    if ((!paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGeneratePicArgs.c) && (paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGeneratePicArgs.jdField_b_of_type_Boolean))
    {
      localObject1 = paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGeneratePicArgs.jdField_b_of_type_JavaLangString;
      if (getIntent().getIntExtra("camera_type", -1) != -1)
      {
        FileUtils.deleteFile(paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGeneratePicArgs.a);
        new File(paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGeneratePicArgs.a);
        ImageUtil.a(this, paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGeneratePicArgs.a);
      }
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    }
    else
    {
      QLog.d("QzoneEditPictureActivit", 1, "send sourcePath");
      localObject1 = this.mEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a.a();
    }
    localArrayList.add(localObject1);
    Object localObject2 = null;
    localObject1 = localObject2;
    if (this.mEditVideoPartManager != null)
    {
      localObject1 = localObject2;
      if (this.mEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle != null)
      {
        localObject1 = localObject2;
        if (this.mEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.a() != null)
        {
          localObject1 = localObject2;
          if (this.mEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.a().a() != null) {
            localObject1 = this.mEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.a().a().jdField_a_of_type_JavaUtilArrayList;
          }
        }
      }
    }
    localObject2 = new JSONArray();
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (TextLayer.TextItem)((Iterator)localObject1).next();
        if ((((TextLayer.TextItem)localObject3).a != null) && (((TextLayer.TextItem)localObject3).a.a() != null)) {
          ((JSONArray)localObject2).put(((TextLayer.TextItem)localObject3).a.a().toString());
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("EditPicActivity getPublishIntent, content is: ");
      ((StringBuilder)localObject1).append(((JSONArray)localObject2).toString());
      QLog.i("DText", 2, ((StringBuilder)localObject1).toString());
    }
    if (((JSONArray)localObject2).length() > 0) {
      localIntent.putExtra("dynamic_text", ((JSONArray)localObject2).toString());
    }
    localIntent.putExtra(PublishParam.a, paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraStructEditorPublishParam);
    boolean bool;
    if ((!paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGeneratePicArgs.c) && (paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGeneratePicArgs.jdField_b_of_type_Boolean)) {
      bool = false;
    } else {
      bool = true;
    }
    localIntent.putExtra("PhotoConst.SEND_ORIGIN", bool);
    Object localObject3 = localIntent.getStringExtra("PATH");
    int i = localIntent.getIntExtra("p_e_s_type", -1);
    if (i != 1)
    {
      if (i != 3) {
        if (i != 9)
        {
          if ((i != 6) && (i != 7))
          {
            localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
            break label747;
          }
        }
        else
        {
          localObject2 = localIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new ArrayList();
          }
          ((ArrayList)localObject1).addAll(localArrayList);
          localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject1);
          localIntent.putExtra("go_publish_activity", true);
          break label747;
        }
      }
      localObject2 = localIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      int j = ((ArrayList)localObject1).indexOf(localObject3);
      if (j != -1) {
        ((ArrayList)localObject1).set(j, localArrayList.get(0));
      }
      localIntent.putExtra("extra_directly_back", true);
      localIntent.putExtra("DirectBackToQzone", true);
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject1);
    }
    else
    {
      localIntent.putExtra("go_publish_activity", true);
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    }
    label747:
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sendPhotoForPhotoPlus,photoEditSourceType = ");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(",SINGLE_PHOTO_PATH = ");
      ((StringBuilder)localObject1).append((String)localArrayList.get(0));
      ((StringBuilder)localObject1).append(",PHOTO_PATHS = ");
      ((StringBuilder)localObject1).append(localArrayList);
      QLog.d("QzoneEditPictureActivit", 2, ((StringBuilder)localObject1).toString());
    }
    localIntent.putExtra("PhotoConst.USE_URL_PATH", true);
    i = 0;
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", false);
    localIntent.putExtra("PhotoConst.QZONE_SINGLE_PHOTO_PATH_EDITED", (String)localArrayList.get(0));
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localArrayList.get(0));
    if (bool) {
      i = 2;
    }
    localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", i);
    localIntent.putExtra("PhotoConst.SEND_FLAG", true);
    localIntent.addFlags(603979776);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sendPhotoForPhotoPlus , activity = ");
      ((StringBuilder)localObject1).append(this);
      ((StringBuilder)localObject1).append(",flag = ");
      ((StringBuilder)localObject1).append(localIntent.getFlags());
      ((StringBuilder)localObject1).append(",data = ");
      ((StringBuilder)localObject1).append(localIntent.getExtras());
      QLog.d("QzoneEditPictureActivit", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = localIntent;
    if (str != null)
    {
      localObject1 = localIntent;
      if (str.contains("ForwardRecentActivity")) {
        localObject1 = compactAPI21SystemShare(localIntent);
      }
    }
    ((Intent)localObject1).putExtra("VIDEO_LOCATE_DESCRIPTION", paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoLocationDescription);
    ((Intent)localObject1).putExtra("VIDEO_LOCAL_LONGITUDE", paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoLongitude);
    ((Intent)localObject1).putExtra("VIDEO_LOCAL_LATITUDE", paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoLatitude);
    return localObject1;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    QzoneGuideBubbleHelper.getInstance().dismissGuideBubble();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPictureActivity
 * JD-Core Version:    0.7.0.1
 */