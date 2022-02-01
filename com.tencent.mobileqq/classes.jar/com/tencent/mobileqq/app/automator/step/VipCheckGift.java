package com.tencent.mobileqq.app.automator.step;

import bbpl;
import bgrd;
import bgre;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.app.NewIntent;

public class VipCheckGift
  extends AsyncStep
{
  public int a()
  {
    Object localObject = (bgre)this.a.app.getManager(76);
    bgrd localbgrd = ((bgre)localObject).a();
    if (localbgrd != null)
    {
      if ((localbgrd.d != 0L) || (localbgrd.a == 0L)) {
        break label54;
      }
      ((bgre)localObject).a(localbgrd.a);
    }
    for (;;)
    {
      return 7;
      label54:
      if (localbgrd.d == 2L)
      {
        localObject = new NewIntent(this.a.app.getApplication(), bbpl.class);
        ((NewIntent)localObject).setAction("gif_ui_show");
        ((NewIntent)localObject).putExtra("gif_ui_show_bid", 0);
        ((NewIntent)localObject).putExtra("gif_ui_show_seq", localbgrd.a);
        this.a.app.startServlet((NewIntent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.VipCheckGift
 * JD-Core Version:    0.7.0.1
 */