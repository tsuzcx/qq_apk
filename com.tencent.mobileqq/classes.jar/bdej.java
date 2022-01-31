import android.view.View;
import android.view.View.OnClickListener;

class bdej
  implements View.OnClickListener
{
  bdej(bdef parambdef) {}
  
  public void onClick(View paramView)
  {
    switch (bdef.a(this.a))
    {
    default: 
      return;
    case 1: 
      bfhg.c("NewUpgradeDialog", "onclick right btn  state = STATE_INIT");
      bdef.a(this.a);
      return;
    case 4: 
      bdef.b(this.a);
      bfhg.c("NewUpgradeDialog", "onclick right btn  state = STATE_COMPLETE");
      return;
    case 10: 
      bfhg.c("NewUpgradeDialog", "onclick right btn  state = STATE_CANCEL");
      return;
    case 3: 
      bdef.c(this.a);
      bfhg.c("NewUpgradeDialog", "onclick right btn  state = STATE_PAUSE");
      return;
    case 2: 
      this.a.c();
      bfhg.c("NewUpgradeDialog", "onclick right btn  state = STATE_DOWNLOADING");
      return;
    }
    bfhg.c("NewUpgradeDialog", "onclick right btn  state = STATE_WAIT");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdej
 * JD-Core Version:    0.7.0.1
 */