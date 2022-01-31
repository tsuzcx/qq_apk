import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.lifecycle.livedata.LiveData.1;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class bmej<T>
{
  private static final Object jdField_b_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private bmec<bmeo<? super T>, bmej<T>.bmem> jdField_a_of_type_Bmec = new bmec();
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final Runnable jdField_a_of_type_JavaLangRunnable = new LiveData.1(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  private volatile Object c = jdField_b_of_type_JavaLangObject;
  private volatile Object d = jdField_b_of_type_JavaLangObject;
  
  private void a(bmej<T>.bmem parambmej)
  {
    if (!parambmej.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (!parambmej.a())
      {
        parambmej.a(false);
        return;
      }
    } while (parambmej.jdField_a_of_type_Int >= this.jdField_b_of_type_Int);
    parambmej.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    parambmej.jdField_a_of_type_Bmeo.a(this.c);
  }
  
  private static void a(String paramString)
  {
    if (!bmdv.a().a()) {
      throw new IllegalStateException("Cannot invoke " + paramString + " on a background thread");
    }
  }
  
  private void b(@Nullable bmej<T>.bmem parambmej)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    bmej<T>.bmem localbmej;
    if (parambmej != null)
    {
      a(parambmej);
      localbmej = null;
    }
    for (;;)
    {
      parambmej = localbmej;
      if (this.jdField_b_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_Boolean = false;
      return;
      bmeg localbmeg = this.jdField_a_of_type_Bmec.a();
      do
      {
        localbmej = parambmej;
        if (!localbmeg.hasNext()) {
          break;
        }
        a((bmem)((Map.Entry)localbmeg.next()).getValue());
      } while (!this.jdField_b_of_type_Boolean);
      localbmej = parambmej;
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
  
  public void a(@NonNull bmdn parambmdn)
  {
    a("removeObservers");
    Iterator localIterator = this.jdField_a_of_type_Bmec.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((bmem)localEntry.getValue()).a(parambmdn)) {
        b((bmeo)localEntry.getKey());
      }
    }
  }
  
  public void a(@NonNull bmdn parambmdn, @NonNull bmeo<? super T> parambmeo)
  {
    a("observe");
    if (parambmdn.a().a() == bmdl.a) {}
    bmel localbmel;
    do
    {
      return;
      localbmel = new bmel(this, parambmdn, parambmeo);
      parambmeo = (bmem)this.jdField_a_of_type_Bmec.a(parambmeo, localbmel);
      if ((parambmeo != null) && (!parambmeo.a(parambmdn))) {
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
      }
    } while (parambmeo != null);
    parambmdn.a().a(localbmel);
  }
  
  public void a(@NonNull bmeo<? super T> parambmeo)
  {
    a("observeForever");
    bmek localbmek = new bmek(this, parambmeo);
    parambmeo = (bmem)this.jdField_a_of_type_Bmec.a(parambmeo, localbmek);
    if ((parambmeo != null) && ((parambmeo instanceof bmel))) {
      throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }
    if (parambmeo != null) {
      return;
    }
    localbmek.a(true);
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
    bmdv.a().b(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected void b() {}
  
  public void b(@NonNull bmeo<? super T> parambmeo)
  {
    a("removeObserver");
    parambmeo = (bmem)this.jdField_a_of_type_Bmec.a(parambmeo);
    if (parambmeo == null) {
      return;
    }
    parambmeo.a();
    parambmeo.a(false);
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
 * Qualified Name:     bmej
 * JD-Core Version:    0.7.0.1
 */