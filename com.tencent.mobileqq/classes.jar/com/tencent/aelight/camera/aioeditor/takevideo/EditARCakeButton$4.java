package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import com.tencent.aelight.camera.aioeditor.share.AIOShareObject;
import com.tencent.aelight.camera.aioeditor.share.IAIOShareHelper;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;

class EditARCakeButton$4
  implements ShareActionSheet.OnItemClickListener
{
  EditARCakeButton$4(EditARCakeButton paramEditARCakeButton) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    paramShareActionSheet.dismiss();
    if (paramActionSheetItem == null)
    {
      AEQLog.d("EditARCakeButton", "weird, handle share action, action item is null");
      return;
    }
    paramShareActionSheet = new StringBuilder();
    paramShareActionSheet.append("handle share action, action = ");
    paramShareActionSheet.append(paramActionSheetItem.action);
    AEQLog.b("EditARCakeButton", paramShareActionSheet.toString());
    Activity localActivity = this.a.u.getActivity();
    AIOShareObject localAIOShareObject = EditARCakeButton.a(this.a);
    if (localActivity != null)
    {
      if (localActivity.isFinishing()) {
        return;
      }
      if (localAIOShareObject == null)
      {
        AEQLog.d("EditARCakeButton", "weird, handle share action, share object is null");
        return;
      }
      int i = paramActionSheetItem.action;
      if (i != 2)
      {
        if (i != 50)
        {
          if (i != 64)
          {
            if (i != 72)
            {
              if ((i == 9) || (i == 10))
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("handle action send to ");
                if (paramActionSheetItem.action == 9) {
                  paramShareActionSheet = "wechat";
                } else {
                  paramShareActionSheet = "wechat timeline";
                }
                localStringBuilder.append(paramShareActionSheet);
                AEQLog.b("EditARCakeButton", localStringBuilder.toString());
                paramShareActionSheet = (IAIOShareHelper)QRoute.api(IAIOShareHelper.class);
                i = paramActionSheetItem.action;
                paramActionSheetItem = this.a;
                paramShareActionSheet.shareToWX(localActivity, i, EditARCakeButton.a(paramActionSheetItem, EditARCakeButton.g(paramActionSheetItem)), localAIOShareObject, EditARCakeButton.h(this.a));
              }
            }
            else
            {
              AEQLog.b("EditARCakeButton", "handle action send to specific friend");
              localAIOShareObject.a(1);
              ((IAIOShareHelper)QRoute.api(IAIOShareHelper.class)).shareToQQ(localActivity, paramActionSheetItem.uinType, paramActionSheetItem.uin, localAIOShareObject);
            }
          }
          else
          {
            AEQLog.b("EditARCakeButton", "handle action open short video by other app");
            EditARCakeButton.a(this.a, localActivity, localAIOShareObject.b());
          }
        }
        else
        {
          AEQLog.b("EditARCakeButton", "handle action send to qzone");
          ((IAIOShareHelper)QRoute.api(IAIOShareHelper.class)).shareToQZone(localActivity, localAIOShareObject);
        }
      }
      else
      {
        AEQLog.b("EditARCakeButton", "handle action send to friend");
        localAIOShareObject.a(2);
        ((IAIOShareHelper)QRoute.api(IAIOShareHelper.class)).shareToQQ(localActivity, -1, null, localAIOShareObject);
      }
      EditARCakeButton.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditARCakeButton.4
 * JD-Core Version:    0.7.0.1
 */