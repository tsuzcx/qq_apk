import android.view.View;
import android.view.View.OnClickListener;

class bbsn
  implements View.OnClickListener
{
  bbsn(bbsm parambbsm) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131373685: 
      this.a.dismiss();
      return;
    case 2131373683: 
      if (this.a.a != null) {
        this.a.a.a();
      }
      this.a.dismiss();
      return;
    }
    if (this.a.a != null) {
      this.a.a.b();
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbsn
 * JD-Core Version:    0.7.0.1
 */