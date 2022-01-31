package com.tencent.mobileqq.app.automator.step;

import awdn;
import bawl;
import bawm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.app.NewIntent;

public class VipCheckGift
  extends AsyncStep
{
  public int a()
  {
    Object localObject = (bawm)this.a.app.getManager(76);
    bawl localbawl = ((bawm)localObject).a();
    if (localbawl != null)
    {
      if ((localbawl.d != 0L) || (localbawl.a == 0L)) {
        break label54;
      }
      ((bawm)localObject).a(localbawl.a);
    }
    for (;;)
    {
      return 7;
      label54:
      if (localbawl.d == 2L)
      {
        localObject = new NewIntent(this.a.app.getApplication(), awdn.class);
        ((NewIntent)localObject).setAction("gif_ui_show");
        ((NewIntent)localObject).putExtra("gif_ui_show_bid", 0);
        ((NewIntent)localObject).putExtra("gif_ui_show_seq", localbawl.a);
        this.a.app.startServlet((NewIntent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.VipCheckGift
 * JD-Core Version:    0.7.0.1
 */