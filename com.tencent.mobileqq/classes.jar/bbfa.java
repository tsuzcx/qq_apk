import android.view.View;
import android.view.View.OnClickListener;

class bbfa
  implements View.OnClickListener
{
  bbfa(bbew parambbew) {}
  
  public void onClick(View paramView)
  {
    switch (bbew.a(this.a))
    {
    default: 
      return;
    case 1: 
      bdht.c("NewUpgradeDialog", "onclick right btn  state = STATE_INIT");
      bbew.a(this.a);
      return;
    case 4: 
      bbew.b(this.a);
      bdht.c("NewUpgradeDialog", "onclick right btn  state = STATE_COMPLETE");
      return;
    case 10: 
      bdht.c("NewUpgradeDialog", "onclick right btn  state = STATE_CANCEL");
      return;
    case 3: 
      bbew.c(this.a);
      bdht.c("NewUpgradeDialog", "onclick right btn  state = STATE_PAUSE");
      return;
    case 2: 
      this.a.c();
      bdht.c("NewUpgradeDialog", "onclick right btn  state = STATE_DOWNLOADING");
      return;
    }
    bdht.c("NewUpgradeDialog", "onclick right btn  state = STATE_WAIT");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfa
 * JD-Core Version:    0.7.0.1
 */