import android.view.View;
import android.view.View.OnClickListener;

class bdrh
  implements View.OnClickListener
{
  bdrh(bdrg parambdrg) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131374138: 
      this.a.dismiss();
      return;
    case 2131374136: 
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdrh
 * JD-Core Version:    0.7.0.1
 */