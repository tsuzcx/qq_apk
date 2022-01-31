import android.view.View;
import android.view.View.OnClickListener;

class avpn
  implements View.OnClickListener
{
  avpn(avpm paramavpm) {}
  
  public void onClick(View paramView)
  {
    if (((paramView.getTag() instanceof avpo)) && (this.a.a != null))
    {
      avpo localavpo = (avpo)paramView.getTag();
      this.a.a.a(this.a, paramView, localavpo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avpn
 * JD-Core Version:    0.7.0.1
 */