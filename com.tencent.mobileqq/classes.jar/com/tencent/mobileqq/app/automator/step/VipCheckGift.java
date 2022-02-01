package com.tencent.mobileqq.app.automator.step;

import bcdj;
import bhkf;
import bhkg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.app.NewIntent;

public class VipCheckGift
  extends AsyncStep
{
  public int a()
  {
    Object localObject = (bhkg)this.a.app.getManager(76);
    bhkf localbhkf = ((bhkg)localObject).a();
    if (localbhkf != null)
    {
      if ((localbhkf.d != 0L) || (localbhkf.a == 0L)) {
        break label54;
      }
      ((bhkg)localObject).a(localbhkf.a);
    }
    for (;;)
    {
      return 7;
      label54:
      if (localbhkf.d == 2L)
      {
        localObject = new NewIntent(this.a.app.getApplication(), bcdj.class);
        ((NewIntent)localObject).setAction("gif_ui_show");
        ((NewIntent)localObject).putExtra("gif_ui_show_bid", 0);
        ((NewIntent)localObject).putExtra("gif_ui_show_seq", localbhkf.a);
        this.a.app.startServlet((NewIntent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.VipCheckGift
 * JD-Core Version:    0.7.0.1
 */