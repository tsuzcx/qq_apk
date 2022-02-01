package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;

@Deprecated
public class RecentItemKandianMergeData
  extends AbsRecentUserBusinessBaseData
{
  public static final int NEW_EXPOSURE_BIT = 536870912;
  public static final int OLD_EXPOSURE_BIT = 1;
  private static String TAG = "RecentItemKandianMergeData";
  
  public RecentItemKandianMergeData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getKandianConfigBadgeSwitch() == 1) {
      this.mUnreadFlag = 1;
    } else {
      this.mUnreadFlag = 2;
    }
    this.mExtraInfoColor = BaseApplicationImpl.getApplication().getResources().getColor(2131168153);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      super.a(paramQQAppInterface, paramContext);
    }
  }
  
  public long getFaceExtraFlag()
  {
    Object localObject = ((QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime()).getMessageFacade();
    if (localObject != null)
    {
      localObject = ((QQMessageFacade)localObject).r(this.mUser.uin, this.mUser.getType());
      if (localObject == null) {
        return super.getFaceExtraFlag();
      }
      if ((localObject instanceof MessageForStructing))
      {
        localObject = (MessageForStructing)localObject;
        if (((MessageForStructing)localObject).structingMsg == null) {
          ((MessageForStructing)localObject).parse();
        }
      }
      ((IRIJKanDianFolderStatus)QRoute.api(IRIJKanDianFolderStatus.class)).setReportLastRedPntPosition(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getMergeKanDianPosInMsgTab());
    }
    return super.getFaceExtraFlag();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemKandianMergeData
 * JD-Core Version:    0.7.0.1
 */