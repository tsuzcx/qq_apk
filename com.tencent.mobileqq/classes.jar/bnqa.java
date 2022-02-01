import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class bnqa
  extends ViewModel
{
  private MutableLiveData<Boolean> a = new MutableLiveData();
  private MutableLiveData<Boolean> b = new MutableLiveData();
  private MutableLiveData<Boolean> c = new MutableLiveData();
  private MutableLiveData<Boolean> d = new MutableLiveData();
  private MutableLiveData<Boolean> e = new MutableLiveData();
  
  public MutableLiveData<Boolean> a()
  {
    return this.a;
  }
  
  public boolean a()
  {
    if (this.b.getValue() != null) {
      return ((Boolean)this.b.getValue()).booleanValue();
    }
    return false;
  }
  
  public MutableLiveData<Boolean> b()
  {
    return this.b;
  }
  
  public boolean b()
  {
    if (this.c.getValue() != null) {
      return ((Boolean)this.c.getValue()).booleanValue();
    }
    return false;
  }
  
  public MutableLiveData<Boolean> c()
  {
    return this.c;
  }
  
  public MutableLiveData<Boolean> d()
  {
    return this.d;
  }
  
  public MutableLiveData<Boolean> e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqa
 * JD-Core Version:    0.7.0.1
 */