import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;

class bnkl
  implements Observer<Boolean>
{
  bnkl(bnkd parambnkd) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean == null) {}
    do
    {
      return;
      if (bnkd.a(this.a).a())
      {
        bnkd.a(this.a).setVisibility(8);
        return;
      }
      if (bnkd.a(this.a).b())
      {
        if (!bnkd.a(this.a))
        {
          AEBottomListScrollView localAEBottomListScrollView = bnkd.a(this.a);
          if (paramBoolean.booleanValue()) {}
          for (int i = 0;; i = 4)
          {
            localAEBottomListScrollView.setVisibility(i);
            return;
          }
        }
        bnkd.a(this.a).setVisibility(8);
        return;
      }
    } while (!bnkd.a(this.a).c());
    bnkd.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnkl
 * JD-Core Version:    0.7.0.1
 */