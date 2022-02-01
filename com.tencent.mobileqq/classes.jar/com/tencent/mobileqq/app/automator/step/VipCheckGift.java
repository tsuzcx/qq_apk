package com.tencent.mobileqq.app.automator.step;

import bcwb;
import biku;
import bikv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.app.NewIntent;

public class VipCheckGift
  extends AsyncStep
{
  public int a()
  {
    Object localObject = (bikv)this.a.app.getManager(76);
    biku localbiku = ((bikv)localObject).a();
    if (localbiku != null)
    {
      if ((localbiku.d != 0L) || (localbiku.a == 0L)) {
        break label54;
      }
      ((bikv)localObject).a(localbiku.a);
    }
    for (;;)
    {
      return 7;
      label54:
      if (localbiku.d == 2L)
      {
        localObject = new NewIntent(this.a.app.getApplication(), bcwb.class);
        ((NewIntent)localObject).setAction("gif_ui_show");
        ((NewIntent)localObject).putExtra("gif_ui_show_bid", 0);
        ((NewIntent)localObject).putExtra("gif_ui_show_seq", localbiku.a);
        this.a.app.startServlet((NewIntent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.VipCheckGift
 * JD-Core Version:    0.7.0.1
 */