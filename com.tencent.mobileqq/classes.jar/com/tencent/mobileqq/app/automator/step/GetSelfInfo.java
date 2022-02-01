package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.profilecommon.utils.ProfileCommonUtils;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import java.util.ArrayList;
import java.util.Iterator;

public class GetSelfInfo
  extends AsyncStep
{
  public int a()
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (this.a.a.mFirstGetSubAccountName)
    {
      localObject = (SubAccountManager)this.a.a.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
      if (localObject == null) {
        break label177;
      }
    }
    label177:
    for (Object localObject = ((SubAccountManager)localObject).a();; localObject = null)
    {
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        this.a.a.mFirstGetSubAccountName = false;
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localFriendListHandler.getFriendInfo((String)((Iterator)localObject).next());
        }
      }
      ProfileServiceUtils.getIProfileProtocolService(this.a.a).getProfileDetailForLogin();
      ProfileCommonUtils.a(this.a.a);
      ((ConfigHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).e();
      FaceDrawable.getUserFaceDrawable(this.a.a, this.a.a.getAccount(), (byte)3);
      return 7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSelfInfo
 * JD-Core Version:    0.7.0.1
 */