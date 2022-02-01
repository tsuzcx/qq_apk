import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.view.AECompoundButton;

class bltg
  implements Observer<bltn>
{
  bltg(bltd parambltd) {}
  
  public void a(@Nullable bltn parambltn)
  {
    if (parambltn == null) {
      return;
    }
    bltd.e(this.a).setSelected(parambltn.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bltg
 * JD-Core Version:    0.7.0.1
 */