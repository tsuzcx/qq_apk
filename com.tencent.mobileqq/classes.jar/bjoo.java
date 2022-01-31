import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.lifecycle.livedata.LiveData.1;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class bjoo<T>
{
  private static final Object jdField_b_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private bjoh<bjos<? super T>, bjoo<T>.bjoq> jdField_a_of_type_Bjoh = new bjoh();
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final Runnable jdField_a_of_type_JavaLangRunnable = new LiveData.1(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  private volatile Object c = jdField_b_of_type_JavaLangObject;
  private volatile Object d = jdField_b_of_type_JavaLangObject;
  
  private void a(bjoo<T>.bjoq parambjoo)
  {
    if (!parambjoo.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (!parambjoo.a())
      {
        parambjoo.a(false);
        return;
      }
    } while (parambjoo.jdField_a_of_type_Int >= this.jdField_b_of_type_Int);
    parambjoo.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    parambjoo.jdField_a_of_type_Bjos.a(this.c);
  }
  
  private static void a(String paramString)
  {
    if (!bjoa.a().a()) {
      throw new IllegalStateException("Cannot invoke " + paramString + " on a background thread");
    }
  }
  
  private void b(@Nullable bjoo<T>.bjoq parambjoo)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    bjoo<T>.bjoq localbjoo;
    if (parambjoo != null)
    {
      a(parambjoo);
      localbjoo = null;
    }
    for (;;)
    {
      parambjoo = localbjoo;
      if (this.jdField_b_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_Boolean = false;
      return;
      bjol localbjol = this.jdField_a_of_type_Bjoh.a();
      do
      {
        localbjoo = parambjoo;
        if (!localbjol.hasNext()) {
          break;
        }
        a((bjoq)((Map.Entry)localbjol.next()).getValue());
      } while (!this.jdField_b_of_type_Boolean);
      localbjoo = parambjoo;
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
  
  public void a(@NonNull bjns parambjns)
  {
    a("removeObservers");
    Iterator localIterator = this.jdField_a_of_type_Bjoh.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((bjoq)localEntry.getValue()).a(parambjns)) {
        a((bjos)localEntry.getKey());
      }
    }
  }
  
  public void a(@NonNull bjns parambjns, @NonNull bjos<? super T> parambjos)
  {
    a("observe");
    if (parambjns.a().a() == bjnq.a) {}
    bjop localbjop;
    do
    {
      return;
      localbjop = new bjop(this, parambjns, parambjos);
      parambjos = (bjoq)this.jdField_a_of_type_Bjoh.a(parambjos, localbjop);
      if ((parambjos != null) && (!parambjos.a(parambjns))) {
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
      }
    } while (parambjos != null);
    parambjns.a().a(localbjop);
  }
  
  public void a(@NonNull bjos<? super T> parambjos)
  {
    a("removeObserver");
    parambjos = (bjoq)this.jdField_a_of_type_Bjoh.a(parambjos);
    if (parambjos == null) {
      return;
    }
    parambjos.a();
    parambjos.a(false);
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
    bjoa.a().b(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected void b() {}
  
  public void b(T paramT)
  {
    a("setValue");
    this.jdField_b_of_type_Int += 1;
    this.c = paramT;
    b(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjoo
 * JD-Core Version:    0.7.0.1
 */