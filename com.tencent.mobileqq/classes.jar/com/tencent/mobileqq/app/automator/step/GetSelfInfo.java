package com.tencent.mobileqq.app.automator.step;

import alpk;
import alqf;
import badd;
import bdbk;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import java.util.ArrayList;
import java.util.Iterator;

public class GetSelfInfo
  extends AsyncStep
{
  public int a()
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)this.a.app.a(1);
    if (this.a.app.c)
    {
      localObject = (badd)this.a.app.getManager(61);
      if (localObject == null) {
        break label170;
      }
    }
    label170:
    for (Object localObject = ((badd)localObject).a();; localObject = null)
    {
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        this.a.app.c = false;
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localFriendListHandler.b((String)((Iterator)localObject).next());
        }
      }
      localObject = (alpk)this.a.app.a(2);
      if (localObject != null) {
        ((alpk)localObject).d();
      }
      ((alqf)this.a.app.a(4)).d();
      bdbk.a(this.a.app, this.a.app.getAccount(), (byte)3);
      return 7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSelfInfo
 * JD-Core Version:    0.7.0.1
 */