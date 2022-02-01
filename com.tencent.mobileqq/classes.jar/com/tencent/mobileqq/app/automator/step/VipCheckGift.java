package com.tencent.mobileqq.app.automator.step;

import bcwf;
import bibt;
import bibu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.app.NewIntent;

public class VipCheckGift
  extends AsyncStep
{
  public int a()
  {
    Object localObject = (bibu)this.a.app.getManager(QQManagerFactory.VIP_GIF_MANAGER);
    bibt localbibt = ((bibu)localObject).a();
    if (localbibt != null)
    {
      if ((localbibt.d != 0L) || (localbibt.a == 0L)) {
        break label55;
      }
      ((bibu)localObject).a(localbibt.a);
    }
    for (;;)
    {
      return 7;
      label55:
      if (localbibt.d == 2L)
      {
        localObject = new NewIntent(this.a.app.getApplication(), bcwf.class);
        ((NewIntent)localObject).setAction("gif_ui_show");
        ((NewIntent)localObject).putExtra("gif_ui_show_bid", 0);
        ((NewIntent)localObject).putExtra("gif_ui_show_seq", localbibt.a);
        this.a.app.startServlet((NewIntent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.VipCheckGift
 * JD-Core Version:    0.7.0.1
 */