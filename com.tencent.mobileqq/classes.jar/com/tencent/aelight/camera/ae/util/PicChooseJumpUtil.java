package com.tencent.aelight.camera.ae.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.aelight.camera.ae.camera.ui.gallery.PhotoListCustomizationAECapture;
import com.tencent.aelight.camera.ae.camera.ui.gallery.PhotoPreviewCustomizationAECapture;
import com.tencent.aelight.camera.ae.play.AETemplateInfoFragment;
import com.tencent.aelight.camera.aebase.PhotoListCustomizationAECircle;
import com.tencent.aelight.camera.aebase.PhotoPreviewLogicAECircle;
import com.tencent.aelight.camera.aioeditor.PhotoListCustomizationAECamera;
import com.tencent.aelight.camera.api.IQIMCameraCapture;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAEPlay;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAEPlay;
import com.tencent.mobileqq.qroute.QRoute;

public class PicChooseJumpUtil
{
  public static void a(Activity paramActivity)
  {
    if (paramActivity == null)
    {
      AEQLog.d("PicChooseJumpUtil", "activity is null.");
      return;
    }
    String str = ((IQIMCameraCapture)QRoute.api(IQIMCameraCapture.class)).getQIMCameraCaptureActivityClass().getName();
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", 60000L);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", str);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("enter_from", 26);
    localIntent.putExtra("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationAECamera.a);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("pic_back_type_result", true);
    localIntent.putExtra("VIDEO_STORY_JUMP_TO_TYPE", ((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).getStoryShareType(paramActivity.getIntent()));
    localIntent.putExtra("VIDEO_STORY_FROM_TYPE", ((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).getAEFromType(paramActivity.getIntent()));
    localIntent.putExtra("edit_video_way", 11);
    localIntent.putExtra("edit_video_type", 10023);
    paramActivity.startActivityForResult(localIntent, 10006);
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    String str = ((IQIMCameraCapture)QRoute.api(IQIMCameraCapture.class)).getQIMCameraCaptureActivityClass().getName();
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", str);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("enter_from", 23);
    localIntent.putExtra("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationAEPlay.a);
    localIntent.putExtra("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationAEPlay.a);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
    localIntent.putExtra("VIDEO_STORY_FROM_TYPE", AETemplateInfoFragment.getFromType(paramActivity));
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    String str = ((IQIMCameraCapture)QRoute.api(IQIMCameraCapture.class)).getQIMCameraCaptureActivityClass().getName();
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", str);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("enter_from", 23);
    localIntent.putExtra("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationAECapture.a);
    localIntent.putExtra("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationAECapture.a);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 4);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra("MaterialConfig.minImageWidth", paramInt2);
    localIntent.putExtra("MaterialConfig.minImageHeight", paramInt3);
    localIntent.putExtra("MaterialConfig.needFace", paramBoolean);
    paramActivity.startActivityForResult(localIntent, paramInt1);
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    AEQLog.b("PicChooseJumpUtil", "[jumpForAECircle] Start");
    AEQLog.a("PicChooseJumpUtil", "[AE Profiler] jumpForAECircle Start");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("intent_key_uid_for_report", localIntent.getStringExtra("PhotoConst.UIN"));
    localIntent.setClass(paramContext, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 29);
    localIntent.putExtra("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationAECircle.a);
    localIntent.putExtra("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewLogicAECircle.a);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 9);
    localIntent.putExtra("PeakConstants.showGifTypeIcon", true);
    localIntent.putExtra("VIDEO_STORY_FROM_TYPE", AETemplateInfoFragment.getFromType(paramContext));
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).startActivityForResult(localIntent, 20000);
      return;
    }
    AEQLog.d("PicChooseJumpUtil", "jumpForAECircle activity is not Activity");
  }
  
  public static void b(Activity paramActivity, int paramInt)
  {
    String str = ((IQIMCameraCapture)QRoute.api(IQIMCameraCapture.class)).getQIMCameraCaptureActivityClass().getName();
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", str);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("enter_from", 23);
    localIntent.putExtra("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationAEPlay.a);
    localIntent.putExtra("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationAEPlay.a);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localIntent.putExtra("pic_choose_in_node_id", paramInt);
    localIntent.putExtra("VIDEO_STORY_FROM_TYPE", AETemplateInfoFragment.getFromType(paramActivity));
    paramActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.util.PicChooseJumpUtil
 * JD-Core Version:    0.7.0.1
 */