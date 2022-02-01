import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

class bmxj
  implements Observer<Boolean>
{
  bmxj(bmxa parambmxa) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    bnrh.b(this.a.a, "getBeautyFilterPanelVisibleLiveData--isShow=" + paramBoolean);
    bmxa.d(this.a, Boolean.TRUE.equals(paramBoolean));
    bmxa.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxj
 * JD-Core Version:    0.7.0.1
 */