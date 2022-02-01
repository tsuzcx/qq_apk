package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.profilecommon.utils.ProfileCommonUtils;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import java.util.ArrayList;
import java.util.Iterator;

public class GetSelfInfo
  extends AsyncStep
{
  protected int doStep()
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)this.mAutomator.a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (this.mAutomator.a.mFirstGetSubAccountName)
    {
      Object localObject2 = this.mAutomator.a;
      Object localObject1 = null;
      localObject2 = (ISubAccountService)((QQAppInterface)localObject2).getRuntimeService(ISubAccountService.class, null);
      if (localObject2 != null) {
        localObject1 = ((ISubAccountService)localObject2).getAllSubUin();
      }
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        this.mAutomator.a.mFirstGetSubAccountName = false;
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localFriendListHandler.getFriendInfo((String)((Iterator)localObject1).next());
        }
      }
    }
    ProfileServiceUtils.getIProfileProtocolService(this.mAutomator.a).getProfileDetailForLogin();
    ProfileCommonUtils.a(this.mAutomator.a);
    ((ConfigHandler)this.mAutomator.a.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).e();
    FaceDrawable.getUserFaceDrawable(this.mAutomator.a, this.mAutomator.a.getAccount(), (byte)3);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSelfInfo
 * JD-Core Version:    0.7.0.1
 */