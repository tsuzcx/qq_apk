import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhdq
  implements View.OnClickListener
{
  bhdq(bhdm parambhdm) {}
  
  public void onClick(View paramView)
  {
    switch (bhdm.a(this.a))
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bjtx.c("NewUpgradeDialog", "onclick right btn  state = STATE_INIT");
      bhdm.a(this.a);
      continue;
      bhdm.b(this.a);
      bjtx.c("NewUpgradeDialog", "onclick right btn  state = STATE_COMPLETE");
      continue;
      bjtx.c("NewUpgradeDialog", "onclick right btn  state = STATE_CANCEL");
      continue;
      bhdm.c(this.a);
      bjtx.c("NewUpgradeDialog", "onclick right btn  state = STATE_PAUSE");
      continue;
      this.a.c();
      bjtx.c("NewUpgradeDialog", "onclick right btn  state = STATE_DOWNLOADING");
      continue;
      bjtx.c("NewUpgradeDialog", "onclick right btn  state = STATE_WAIT");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhdq
 * JD-Core Version:    0.7.0.1
 */