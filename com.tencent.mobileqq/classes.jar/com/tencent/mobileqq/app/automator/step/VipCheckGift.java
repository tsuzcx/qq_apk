package com.tencent.mobileqq.app.automator.step;

import azck;
import bedd;
import bede;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.app.NewIntent;

public class VipCheckGift
  extends AsyncStep
{
  public int a()
  {
    Object localObject = (bede)this.a.app.getManager(76);
    bedd localbedd = ((bede)localObject).a();
    if (localbedd != null)
    {
      if ((localbedd.d != 0L) || (localbedd.a == 0L)) {
        break label54;
      }
      ((bede)localObject).a(localbedd.a);
    }
    for (;;)
    {
      return 7;
      label54:
      if (localbedd.d == 2L)
      {
        localObject = new NewIntent(this.a.app.getApplication(), azck.class);
        ((NewIntent)localObject).setAction("gif_ui_show");
        ((NewIntent)localObject).putExtra("gif_ui_show_bid", 0);
        ((NewIntent)localObject).putExtra("gif_ui_show_seq", localbedd.a);
        this.a.app.startServlet((NewIntent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.VipCheckGift
 * JD-Core Version:    0.7.0.1
 */