package com.tencent.mobileqq.app.automator.step;

import anri;
import ansg;
import baey;
import bdxs;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.face.FaceDrawable;
import java.util.ArrayList;
import java.util.Iterator;

public class GetSelfInfo
  extends AsyncStep
{
  public int a()
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (this.a.app.mFirstGetSubAccountName)
    {
      localObject = (bdxs)this.a.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
      if (localObject == null) {
        break label187;
      }
    }
    label187:
    for (Object localObject = ((bdxs)localObject).a();; localObject = null)
    {
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        this.a.app.mFirstGetSubAccountName = false;
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localFriendListHandler.getFriendInfo((String)((Iterator)localObject).next());
        }
      }
      localObject = (anri)this.a.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      if (localObject != null) {
        ((anri)localObject).d();
      }
      baey.a(this.a.app);
      ((ansg)this.a.app.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).e();
      FaceDrawable.getUserFaceDrawable(this.a.app, this.a.app.getAccount(), (byte)3);
      return 7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSelfInfo
 * JD-Core Version:    0.7.0.1
 */