package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.CameraCompatibleConstants;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationCrop;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.avatar.dynamicavatar.MX3DynamicAvatarRecordActivity;
import com.tencent.mobileqq.qroute.QRoute;
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
  
  public void onClick(View paramView, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size()))
    {
      paramInt = ((Integer)this.a.get(paramInt)).intValue();
      Object localObject;
      if (paramInt != 13)
      {
        if (paramInt != 22)
        {
          if (paramInt != 24)
          {
            if (paramInt == 33)
            {
              paramView = new Intent();
              paramView.putExtra("url", NewerGuidePlugin.c());
              RouteUtils.a(this.c, paramView, "/base/browser");
              ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("set_profile", "photo_settings", "click", null);
            }
          }
          else
          {
            paramView = FaceUtil.a();
            paramInt = ProfileCardUtil.b(this.c);
            localObject = new Intent();
            ((Intent)localObject).setClass(this.c, NewPhotoListActivity.class);
            ((Intent)localObject).putExtra("enter_from", 50);
            ((Intent)localObject).putExtra("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationCrop.a);
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
            this.c.startActivity((Intent)localObject);
          }
        }
        else
        {
          paramView = DynamicAvatarRecordActivity.class;
          if (((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProduct(CameraCompatibleConstants.c)) {
            paramView = MX3DynamicAvatarRecordActivity.class;
          }
          paramView = new Intent(this.c, paramView);
          paramView.putExtra("param_source", 1);
          paramView.putExtra("param_from_newer_guide", true);
          this.d.startActivityForResult(paramView, (byte)100);
        }
      }
      else if (!QavCameraUsage.b(BaseApplicationImpl.getContext()))
      {
        paramView = new StringBuilder();
        paramView.append(AppConstants.SDCARD_PATH);
        paramView.append("photo/");
        paramView = VFSAssistantUtils.getSDKPrivatePath(paramView.toString());
        localObject = new File(paramView);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramView);
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        ((StringBuilder)localObject).append(".jpg");
        paramView = new File(((StringBuilder)localObject).toString());
        localObject = new Intent();
        NewerGuidePlugin.a(this.d, FileProvider7Helper.setSystemCapture(this.c, paramView, (Intent)localObject));
        this.d.startActivityForResult((Intent)localObject, (byte)101);
      }
    }
    try
    {
      this.b.dismiss();
      return;
    }
    catch (Exception paramView) {}
    this.b.dismiss();
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewerGuidePlugin.4
 * JD-Core Version:    0.7.0.1
 */