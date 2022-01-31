import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;

class bmjm
  implements View.OnClickListener
{
  bmjm(bmjl parambmjl) {}
  
  public void onClick(View paramView)
  {
    if (bmjl.a(this.a) != null)
    {
      if ((bmjl.a(this.a).b() != 1) || (bmjl.a(this.a) != 1)) {
        break label64;
      }
      bmjl.a(this.a);
      bmjl.a(this.a).setImageResource(2130847143);
      bmjl.a(this.a, 2);
    }
    label64:
    while ((bmjl.a(this.a).b() != 2) || (bmjl.a(this.a) != 2)) {
      return;
    }
    bmjl.b(this.a);
    bmjl.a(this.a).setImageResource(2130847144);
    bmjl.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjm
 * JD-Core Version:    0.7.0.1
 */