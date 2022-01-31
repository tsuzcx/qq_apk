import android.view.View;
import android.view.View.OnClickListener;

class badv
  implements View.OnClickListener
{
  badv(badr parambadr) {}
  
  public void onClick(View paramView)
  {
    switch (badr.a(this.a))
    {
    default: 
      return;
    case 1: 
      bcds.c("NewUpgradeDialog", "onclick right btn  state = STATE_INIT");
      badr.a(this.a);
      return;
    case 4: 
      badr.b(this.a);
      bcds.c("NewUpgradeDialog", "onclick right btn  state = STATE_COMPLETE");
      return;
    case 10: 
      bcds.c("NewUpgradeDialog", "onclick right btn  state = STATE_CANCEL");
      return;
    case 3: 
      badr.c(this.a);
      bcds.c("NewUpgradeDialog", "onclick right btn  state = STATE_PAUSE");
      return;
    case 2: 
      this.a.c();
      bcds.c("NewUpgradeDialog", "onclick right btn  state = STATE_DOWNLOADING");
      return;
    }
    bcds.c("NewUpgradeDialog", "onclick right btn  state = STATE_WAIT");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     badv
 * JD-Core Version:    0.7.0.1
 */