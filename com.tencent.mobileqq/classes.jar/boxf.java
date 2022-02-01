import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

class boxf
  implements Observer<Boolean>
{
  boxf(boxb paramboxb) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      boxb.a(this.a).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boxf
 * JD-Core Version:    0.7.0.1
 */