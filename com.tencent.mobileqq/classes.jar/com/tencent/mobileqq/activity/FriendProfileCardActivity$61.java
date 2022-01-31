package com.tencent.mobileqq.activity;

import avsm;
import awqt;
import azqs;
import bddf;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Locale;

class FriendProfileCardActivity$61
  implements Runnable
{
  FriendProfileCardActivity$61(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    avsm localavsm;
    Object localObject1;
    if (this.this$0.a.a.a == 0)
    {
      localavsm = (avsm)this.this$0.app.getManager(160);
      i = localavsm.a();
      localObject1 = null;
    }
    Object localObject2;
    switch (i)
    {
    default: 
      localObject2 = null;
      if (localObject1 != null)
      {
        azqs.b(this.this$0.app, "dc00898", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
        azqs.b(this.this$0.app, "dc00898", "", "", (String)localObject2, (String)localObject2, 0, 0, "", "", "", "");
      }
      localavsm.a(true);
      if (bddf.b())
      {
        localObject2 = Locale.getDefault().getCountry();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = this.this$0.app;
        if (this.this$0.a.a.a != 0) {
          break label235;
        }
      }
      break;
    }
    label235:
    for (int i = 1;; i = 2)
    {
      azqs.b((QQAppInterface)localObject2, "dc00898", "", "", "0X8008CA2", "0X8008CA2", i, 0, "", "", (String)localObject1, "");
      return;
      localObject1 = "0X8007394";
      localObject2 = "0X8007393";
      break;
      localObject1 = "0X8007399";
      localObject2 = "0X8007398";
      break;
      localObject1 = "0X80073B9";
      localObject2 = "0X80073BA";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.61
 * JD-Core Version:    0.7.0.1
 */