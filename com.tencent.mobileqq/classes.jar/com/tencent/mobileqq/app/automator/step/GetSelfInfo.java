package com.tencent.mobileqq.app.automator.step;

import amov;
import ampt;
import ayzn;
import bcqt;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
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
    FriendListHandler localFriendListHandler = (FriendListHandler)this.a.app.getBusinessHandler(1);
    if (this.a.app.mFirstGetSubAccountName)
    {
      localObject = (bcqt)this.a.app.getManager(61);
      if (localObject == null) {
        break label180;
      }
    }
    label180:
    for (Object localObject = ((bcqt)localObject).a();; localObject = null)
    {
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        this.a.app.mFirstGetSubAccountName = false;
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localFriendListHandler.getFriendInfo((String)((Iterator)localObject).next());
        }
      }
      localObject = (amov)this.a.app.getBusinessHandler(2);
      if (localObject != null) {
        ((amov)localObject).d();
      }
      ayzn.a(this.a.app);
      ((ampt)this.a.app.getBusinessHandler(4)).e();
      FaceDrawable.getUserFaceDrawable(this.a.app, this.a.app.getAccount(), (byte)3);
      return 7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSelfInfo
 * JD-Core Version:    0.7.0.1
 */