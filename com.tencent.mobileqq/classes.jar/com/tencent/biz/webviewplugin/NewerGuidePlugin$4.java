package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.avatar.dynamicavatar.MX3DynamicAvatarRecordActivity;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.io.File;
import java.util.ArrayList;

class NewerGuidePlugin$4
  implements ActionSheet.OnButtonClickListener
{
  NewerGuidePlugin$4(NewerGuidePlugin paramNewerGuidePlugin, ArrayList paramArrayList, ActionSheet paramActionSheet, Activity paramActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    switch (((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).intValue())
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        return;
      }
      paramView = DynamicAvatarRecordActivity.class;
      if (CameraCompatibleList.d(CameraCompatibleList.c)) {
        paramView = MX3DynamicAvatarRecordActivity.class;
      }
      paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, paramView);
      paramView.putExtra("param_source", 1);
      paramView.putExtra("param_from_newer_guide", true);
      this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin.startActivityForResult(paramView, (byte)100);
      continue;
      paramView = FaceUtil.a();
      paramInt = ProfileCardUtil.b(this.jdField_a_of_type_AndroidAppActivity);
      Object localObject = new Intent();
      ((Intent)localObject).setClass(this.jdField_a_of_type_AndroidAppActivity, NewPhotoListActivity.class);
      ((Intent)localObject).putExtra("enter_from", 50);
      ((Intent)localObject).putExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME", "ACTION_NEWER_GUIDE_SELECT_AVATAR_RESULT");
      ((Intent)localObject).putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      ((Intent)localObject).putExtra("Business_Origin", 100);
      ((Intent)localObject).putExtra("BUSINESS_ORIGIN_NEW", 100);
      ((Intent)localObject).putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
      ((Intent)localObject).putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      ((Intent)localObject).putExtra("PhotoConst.IS_SINGLE_MODE", true);
      ((Intent)localObject).putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
      ((Intent)localObject).putExtra("PhotoConst.TARGET_PATH", paramView);
      ((Intent)localObject).putExtra("PhotoConst.CLIP_WIDTH", paramInt);
      ((Intent)localObject).putExtra("PhotoConst.CLIP_HEIGHT", paramInt);
      ((Intent)localObject).putExtra("PhotoConst.TARGET_WIDTH", 1080);
      ((Intent)localObject).putExtra("PhotoConst.TARGET_HEIGHT", 1080);
      ((Intent)localObject).putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
      ((Intent)localObject).putExtra("PhotoConst.32_Bit_Config", true);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
      continue;
      if (!QavCameraUsage.b(BaseApplicationImpl.getContext()))
      {
        paramView = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "photo/");
        localObject = new File(paramView);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        paramView = new File(paramView + System.currentTimeMillis() + ".jpg");
        localObject = new Intent();
        NewerGuidePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin, FileProvider7Helper.setSystemCapture(this.jdField_a_of_type_AndroidAppActivity, paramView, (Intent)localObject));
        this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin.startActivityForResult((Intent)localObject, (byte)101);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewerGuidePlugin.4
 * JD-Core Version:    0.7.0.1
 */