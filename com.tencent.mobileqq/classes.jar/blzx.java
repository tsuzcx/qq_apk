import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.lifecycle.livedata.LiveData.1;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class blzx<T>
{
  private static final Object jdField_b_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private blzq<bmac<? super T>, blzx<T>.bmaa> jdField_a_of_type_Blzq = new blzq();
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final Runnable jdField_a_of_type_JavaLangRunnable = new LiveData.1(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  private volatile Object c = jdField_b_of_type_JavaLangObject;
  private volatile Object d = jdField_b_of_type_JavaLangObject;
  
  private void a(blzx<T>.bmaa paramblzx)
  {
    if (!paramblzx.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (!paramblzx.a())
      {
        paramblzx.a(false);
        return;
      }
    } while (paramblzx.jdField_a_of_type_Int >= this.jdField_b_of_type_Int);
    paramblzx.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    paramblzx.jdField_a_of_type_Bmac.a(this.c);
  }
  
  private static void a(String paramString)
  {
    if (!blzj.a().a()) {
      throw new IllegalStateException("Cannot invoke " + paramString + " on a background thread");
    }
  }
  
  private void b(@Nullable blzx<T>.bmaa paramblzx)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    blzx<T>.bmaa localblzx;
    if (paramblzx != null)
    {
      a(paramblzx);
      localblzx = null;
    }
    for (;;)
    {
      paramblzx = localblzx;
      if (this.jdField_b_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_Boolean = false;
      return;
      blzu localblzu = this.jdField_a_of_type_Blzq.a();
      do
      {
        localblzx = paramblzx;
        if (!localblzu.hasNext()) {
          break;
        }
        a((bmaa)((Map.Entry)localblzu.next()).getValue());
      } while (!this.jdField_b_of_type_Boolean);
      localblzx = paramblzx;
    }
  }
  
  @Nullable
  public T a()
  {
    Object localObject = this.c;
    if (localObject != jdField_b_of_type_JavaLangObject) {
      return localObject;
    }
    return null;
  }
  
  protected void a() {}
  
  public void a(@NonNull blzb paramblzb)
  {
    a("removeObservers");
    Iterator localIterator = this.jdField_a_of_type_Blzq.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((bmaa)localEntry.getValue()).a(paramblzb)) {
        b((bmac)localEntry.getKey());
      }
    }
  }
  
  public void a(@NonNull blzb paramblzb, @NonNull bmac<? super T> parambmac)
  {
    a("observe");
    if (paramblzb.a().a() == blyz.a) {}
    blzz localblzz;
    do
    {
      return;
      localblzz = new blzz(this, paramblzb, parambmac);
      parambmac = (bmaa)this.jdField_a_of_type_Blzq.a(parambmac, localblzz);
      if ((parambmac != null) && (!parambmac.a(paramblzb))) {
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
      }
    } while (parambmac != null);
    paramblzb.a().a(localblzz);
  }
  
  public void a(@NonNull bmac<? super T> parambmac)
  {
    a("observeForever");
    blzy localblzy = new blzy(this, parambmac);
    parambmac = (bmaa)this.jdField_a_of_type_Blzq.a(parambmac, localblzy);
    if ((parambmac != null) && ((parambmac instanceof blzz))) {
      throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }
    if (parambmac != null) {
      return;
    }
    localblzy.a(true);
  }
  
  protected void a(T paramT)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      int i;
      if (this.d == jdField_b_of_type_JavaLangObject)
      {
        i = 1;
        this.d = paramT;
        if (i == 0) {
          QLog.d("debug", 4, "!postTask");
        }
      }
      else
      {
        i = 0;
      }
    }
    blzj.a().b(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected void b() {}
  
  public void b(@NonNull bmac<? super T> parambmac)
  {
    a("removeObserver");
    parambmac = (bmaa)this.jdField_a_of_type_Blzq.a(parambmac);
    if (parambmac == null) {
      return;
    }
    parambmac.a();
    parambmac.a(false);
  }
  
  public void b(T paramT)
  {
    a("setValue");
    this.jdField_b_of_type_Int += 1;
    this.c = paramT;
    b(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blzx
 * JD-Core Version:    0.7.0.1
 */