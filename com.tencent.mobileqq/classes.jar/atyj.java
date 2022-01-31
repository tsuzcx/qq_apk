import android.view.View;
import android.view.View.OnClickListener;

class atyj
  implements View.OnClickListener
{
  atyj(atyi paramatyi) {}
  
  public void onClick(View paramView)
  {
    if (((paramView.getTag() instanceof atyk)) && (this.a.a != null))
    {
      atyk localatyk = (atyk)paramView.getTag();
      this.a.a.a(this.a, paramView, localatyk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atyj
 * JD-Core Version:    0.7.0.1
 */