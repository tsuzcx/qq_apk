import android.view.View;
import android.view.View.OnClickListener;

class bbfo
  implements View.OnClickListener
{
  bbfo(bbfk parambbfk) {}
  
  public void onClick(View paramView)
  {
    switch (bbfk.a(this.a))
    {
    default: 
      return;
    case 1: 
      bdii.c("NewUpgradeDialog", "onclick right btn  state = STATE_INIT");
      bbfk.a(this.a);
      return;
    case 4: 
      bbfk.b(this.a);
      bdii.c("NewUpgradeDialog", "onclick right btn  state = STATE_COMPLETE");
      return;
    case 10: 
      bdii.c("NewUpgradeDialog", "onclick right btn  state = STATE_CANCEL");
      return;
    case 3: 
      bbfk.c(this.a);
      bdii.c("NewUpgradeDialog", "onclick right btn  state = STATE_PAUSE");
      return;
    case 2: 
      this.a.c();
      bdii.c("NewUpgradeDialog", "onclick right btn  state = STATE_DOWNLOADING");
      return;
    }
    bdii.c("NewUpgradeDialog", "onclick right btn  state = STATE_WAIT");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfo
 * JD-Core Version:    0.7.0.1
 */