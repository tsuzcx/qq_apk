import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bfnc
  implements View.OnClickListener
{
  bfnc(bfmy parambfmy) {}
  
  public void onClick(View paramView)
  {
    switch (bfmy.a(this.a))
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bhzm.c("NewUpgradeDialog", "onclick right btn  state = STATE_INIT");
      bfmy.a(this.a);
      continue;
      bfmy.b(this.a);
      bhzm.c("NewUpgradeDialog", "onclick right btn  state = STATE_COMPLETE");
      continue;
      bhzm.c("NewUpgradeDialog", "onclick right btn  state = STATE_CANCEL");
      continue;
      bfmy.c(this.a);
      bhzm.c("NewUpgradeDialog", "onclick right btn  state = STATE_PAUSE");
      continue;
      this.a.c();
      bhzm.c("NewUpgradeDialog", "onclick right btn  state = STATE_DOWNLOADING");
      continue;
      bhzm.c("NewUpgradeDialog", "onclick right btn  state = STATE_WAIT");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfnc
 * JD-Core Version:    0.7.0.1
 */