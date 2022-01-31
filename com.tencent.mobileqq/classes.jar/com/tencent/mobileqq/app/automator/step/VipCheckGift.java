package com.tencent.mobileqq.app.automator.step;

import axcv;
import bbzf;
import bbzg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.app.NewIntent;

public class VipCheckGift
  extends AsyncStep
{
  public int a()
  {
    Object localObject = (bbzg)this.a.app.getManager(76);
    bbzf localbbzf = ((bbzg)localObject).a();
    if (localbbzf != null)
    {
      if ((localbbzf.d != 0L) || (localbbzf.a == 0L)) {
        break label54;
      }
      ((bbzg)localObject).a(localbbzf.a);
    }
    for (;;)
    {
      return 7;
      label54:
      if (localbbzf.d == 2L)
      {
        localObject = new NewIntent(this.a.app.getApplication(), axcv.class);
        ((NewIntent)localObject).setAction("gif_ui_show");
        ((NewIntent)localObject).putExtra("gif_ui_show_bid", 0);
        ((NewIntent)localObject).putExtra("gif_ui_show_seq", localbbzf.a);
        this.a.app.startServlet((NewIntent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.VipCheckGift
 * JD-Core Version:    0.7.0.1
 */