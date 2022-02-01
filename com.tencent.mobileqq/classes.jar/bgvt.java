import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgvt
  implements View.OnClickListener
{
  bgvt(bgvp parambgvp) {}
  
  public void onClick(View paramView)
  {
    switch (bgvp.a(this.a))
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bjko.c("NewUpgradeDialog", "onclick right btn  state = STATE_INIT");
      bgvp.a(this.a);
      continue;
      bgvp.b(this.a);
      bjko.c("NewUpgradeDialog", "onclick right btn  state = STATE_COMPLETE");
      continue;
      bjko.c("NewUpgradeDialog", "onclick right btn  state = STATE_CANCEL");
      continue;
      bgvp.c(this.a);
      bjko.c("NewUpgradeDialog", "onclick right btn  state = STATE_PAUSE");
      continue;
      this.a.c();
      bjko.c("NewUpgradeDialog", "onclick right btn  state = STATE_DOWNLOADING");
      continue;
      bjko.c("NewUpgradeDialog", "onclick right btn  state = STATE_WAIT");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvt
 * JD-Core Version:    0.7.0.1
 */