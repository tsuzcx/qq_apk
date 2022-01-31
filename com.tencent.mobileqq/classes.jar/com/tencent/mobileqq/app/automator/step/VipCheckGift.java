package com.tencent.mobileqq.app.automator.step;

import axcx;
import bbzt;
import bbzu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.app.NewIntent;

public class VipCheckGift
  extends AsyncStep
{
  public int a()
  {
    Object localObject = (bbzu)this.a.app.getManager(76);
    bbzt localbbzt = ((bbzu)localObject).a();
    if (localbbzt != null)
    {
      if ((localbbzt.d != 0L) || (localbbzt.a == 0L)) {
        break label54;
      }
      ((bbzu)localObject).a(localbbzt.a);
    }
    for (;;)
    {
      return 7;
      label54:
      if (localbbzt.d == 2L)
      {
        localObject = new NewIntent(this.a.app.getApplication(), axcx.class);
        ((NewIntent)localObject).setAction("gif_ui_show");
        ((NewIntent)localObject).putExtra("gif_ui_show_bid", 0);
        ((NewIntent)localObject).putExtra("gif_ui_show_seq", localbbzt.a);
        this.a.app.startServlet((NewIntent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.VipCheckGift
 * JD-Core Version:    0.7.0.1
 */