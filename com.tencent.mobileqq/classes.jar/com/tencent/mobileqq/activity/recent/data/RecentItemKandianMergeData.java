package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import bmhv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.RecentUser;
import pkh;

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
    if (bmhv.C(BaseApplicationImpl.getApplication().getRuntime()) == 1) {}
    for (this.mUnreadFlag = 1;; this.mUnreadFlag = 2)
    {
      this.mExtraInfoColor = BaseApplicationImpl.getApplication().getResources().getColor(2131167138);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
  }
  
  public long getFaceExtraFlag()
  {
    Object localObject = (QQAppInterface)pkh.a();
    if (localObject == null) {
      return super.getFaceExtraFlag();
    }
    localObject = ((QQAppInterface)localObject).getMessageFacade();
    if (localObject != null)
    {
      localObject = ((QQMessageFacade)localObject).getLastMsgForMsgTab(this.mUser.uin, this.mUser.getType());
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
      prp.b = pkh.b();
    }
    return super.getFaceExtraFlag();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemKandianMergeData
 * JD-Core Version:    0.7.0.1
 */