import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;

class blpz
  implements Observer<Boolean>
{
  blpz(blpr paramblpr) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean == null) {}
    do
    {
      return;
      if (blpr.a(this.a).a())
      {
        this.a.a.setVisibility(8);
        return;
      }
      if (blpr.a(this.a).b())
      {
        if (!blpr.a(this.a))
        {
          AEBottomListScrollView localAEBottomListScrollView = this.a.a;
          if (paramBoolean.booleanValue()) {}
          for (int i = 0;; i = 4)
          {
            localAEBottomListScrollView.setVisibility(i);
            return;
          }
        }
        this.a.a.setVisibility(8);
        return;
      }
    } while (!blpr.a(this.a).c());
    this.a.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpz
 * JD-Core Version:    0.7.0.1
 */