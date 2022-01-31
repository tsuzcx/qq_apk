import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.widget.ImageView;

class biwj
  implements bjos<biwo>
{
  biwj(biwh parambiwh) {}
  
  public void a(@Nullable biwo parambiwo)
  {
    if (parambiwo == null) {
      return;
    }
    biwh localbiwh = this.a;
    boolean bool;
    if (parambiwo == biwo.c)
    {
      bool = true;
      biwh.a(localbiwh, bool);
      biwh.a(this.a).notifyDataSetChanged();
      parambiwo = biwh.a(this.a);
      if (!biwh.a(this.a)) {
        break label69;
      }
    }
    label69:
    for (int i = 2130837591;; i = 2130837592)
    {
      parambiwo.setImageResource(i);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwj
 * JD-Core Version:    0.7.0.1
 */