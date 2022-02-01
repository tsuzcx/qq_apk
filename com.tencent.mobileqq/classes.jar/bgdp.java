import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgdp
  implements View.OnClickListener
{
  bgdp(bgdl parambgdl) {}
  
  public void onClick(View paramView)
  {
    switch (bgdl.a(this.a))
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bisy.c("NewUpgradeDialog", "onclick right btn  state = STATE_INIT");
      bgdl.a(this.a);
      continue;
      bgdl.b(this.a);
      bisy.c("NewUpgradeDialog", "onclick right btn  state = STATE_COMPLETE");
      continue;
      bisy.c("NewUpgradeDialog", "onclick right btn  state = STATE_CANCEL");
      continue;
      bgdl.c(this.a);
      bisy.c("NewUpgradeDialog", "onclick right btn  state = STATE_PAUSE");
      continue;
      this.a.c();
      bisy.c("NewUpgradeDialog", "onclick right btn  state = STATE_DOWNLOADING");
      continue;
      bisy.c("NewUpgradeDialog", "onclick right btn  state = STATE_WAIT");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgdp
 * JD-Core Version:    0.7.0.1
 */