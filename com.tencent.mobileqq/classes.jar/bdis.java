import android.view.View;
import android.view.View.OnClickListener;

class bdis
  implements View.OnClickListener
{
  bdis(bdio parambdio) {}
  
  public void onClick(View paramView)
  {
    switch (bdio.a(this.a))
    {
    default: 
      return;
    case 1: 
      bflp.c("NewUpgradeDialog", "onclick right btn  state = STATE_INIT");
      bdio.a(this.a);
      return;
    case 4: 
      bdio.b(this.a);
      bflp.c("NewUpgradeDialog", "onclick right btn  state = STATE_COMPLETE");
      return;
    case 10: 
      bflp.c("NewUpgradeDialog", "onclick right btn  state = STATE_CANCEL");
      return;
    case 3: 
      bdio.c(this.a);
      bflp.c("NewUpgradeDialog", "onclick right btn  state = STATE_PAUSE");
      return;
    case 2: 
      this.a.c();
      bflp.c("NewUpgradeDialog", "onclick right btn  state = STATE_DOWNLOADING");
      return;
    }
    bflp.c("NewUpgradeDialog", "onclick right btn  state = STATE_WAIT");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdis
 * JD-Core Version:    0.7.0.1
 */