package com.tencent.mobileqq.activity.miniaio;

import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.qphone.base.util.QLog;

class MiniMsgTabFragment$1
  implements ShareActionSheet.OnItemClickListener
{
  MiniMsgTabFragment$1(MiniMsgTabFragment paramMiniMsgTabFragment) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    int i = paramActionSheetItem.action;
    int j = paramActionSheetItem.uinType;
    paramActionSheetItem = paramActionSheetItem.uin;
    if (i != 2)
    {
      if (i != 3) {
        if (i != 6) {
          if (i != 14) {
            if (i != 26) {
              if (i != 70) {
                if (i != 128) {
                  if (i != 151) {
                    if (i != 9) {
                      if (i != 10) {
                        if (i != 158) {
                          if (i == 159) {}
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      switch (i)
      {
      default: 
        paramActionSheetItem = new StringBuilder();
        paramActionSheetItem.append("handleShareChatItemClick with invalid case:");
        paramActionSheetItem.append(i);
        QLog.e("MiniMsgTabFragment", 1, paramActionSheetItem.toString());
        return;
      case 83: 
        if (this.a.getBaseActivity() != null)
        {
          ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchPermissionSettingFragmentForResult(this.a.getBaseActivity(), MiniMsgTabFragment.a(this.a), MiniMsgTabFragment.b(this.a), 5);
          return;
        }
        QLog.e("MiniMsgTabFragment", 1, "handleShareChatItemClick getActivity is null when ACTION_SETTING");
        return;
      case 81: 
        MiniMsgTabFragment.a(this.a, 9, null);
        return;
      case 79: 
      case 80: 
        MiniMsgTabFragment.a(this.a, 3, null);
        return;
      case 78: 
        if (MiniMsgTabFragment.a(this.a) == -1) {
          break;
        }
        if (MiniMsgTabFragment.a(this.a))
        {
          ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMainPageFragmentForMiniGame(this.a.getBaseActivity(), MiniMsgTabFragment.a(this.a), 1, true);
          return;
        }
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMainPageFragment(this.a.getBaseActivity(), MiniMsgTabFragment.a(this.a), MiniMsgTabFragment.a(this.a));
        return;
      case 76: 
      case 77: 
        MiniMsgTabFragment.a(this.a, 8, null);
        return;
      case 74: 
      case 75: 
        MiniMsgTabFragment.a(this.a, 2, null);
        return;
        MiniMsgTabFragment.a(this.a, 16, null);
        return;
        MiniMsgTabFragment.a(this.a, 15, null);
        return;
        MiniMsgTabFragment.a(this.a, 7, null);
        return;
        MiniMsgTabFragment.a(this.a, 6, null);
        return;
        MiniMsgTabFragment.a(this.a, 11, null);
        return;
        MiniMsgTabFragment.a(this.a, 14, null);
        return;
      case 82: 
        MiniMsgTabFragment.a(this.a, 13, null);
        return;
        paramActionSheetItem = "3636666661";
      case 72: 
        MiniMsgTabFragment.a(this.a, paramActionSheetItem, j);
        return;
        MiniMsgTabFragment.a(this.a, 10, null);
        return;
        MiniMsgTabFragment.a(this.a, 17, null);
        return;
        MiniMsgTabFragment.a(this.a, 5, null);
        return;
      }
    }
    else
    {
      MiniMsgTabFragment.a(this.a, 1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment.1
 * JD-Core Version:    0.7.0.1
 */