package com.tencent.mobileqq.app.automator.step;

import ayyb;
import bdyu;
import bdyv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.app.NewIntent;

public class VipCheckGift
  extends AsyncStep
{
  public int a()
  {
    Object localObject = (bdyv)this.a.app.getManager(76);
    bdyu localbdyu = ((bdyv)localObject).a();
    if (localbdyu != null)
    {
      if ((localbdyu.d != 0L) || (localbdyu.a == 0L)) {
        break label54;
      }
      ((bdyv)localObject).a(localbdyu.a);
    }
    for (;;)
    {
      return 7;
      label54:
      if (localbdyu.d == 2L)
      {
        localObject = new NewIntent(this.a.app.getApplication(), ayyb.class);
        ((NewIntent)localObject).setAction("gif_ui_show");
        ((NewIntent)localObject).putExtra("gif_ui_show_bid", 0);
        ((NewIntent)localObject).putExtra("gif_ui_show_seq", localbdyu.a);
        this.a.app.startServlet((NewIntent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.VipCheckGift
 * JD-Core Version:    0.7.0.1
 */