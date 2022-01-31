import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.lifecycle.livedata.LiveData.1;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class bhwc<T>
{
  private static final Object jdField_b_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private bhvv<bhwg<? super T>, bhwc<T>.bhwe> jdField_a_of_type_Bhvv = new bhvv();
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final Runnable jdField_a_of_type_JavaLangRunnable = new LiveData.1(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  private volatile Object c = jdField_b_of_type_JavaLangObject;
  private volatile Object d = jdField_b_of_type_JavaLangObject;
  
  private void a(bhwc<T>.bhwe parambhwc)
  {
    if (!parambhwc.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (!parambhwc.a())
      {
        parambhwc.a(false);
        return;
      }
    } while (parambhwc.jdField_a_of_type_Int >= this.jdField_b_of_type_Int);
    parambhwc.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    parambhwc.jdField_a_of_type_Bhwg.a(this.c);
  }
  
  private static void a(String paramString)
  {
    if (!bhvo.a().a()) {
      throw new IllegalStateException("Cannot invoke " + paramString + " on a background thread");
    }
  }
  
  private void b(@Nullable bhwc<T>.bhwe parambhwc)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    bhwc<T>.bhwe localbhwc;
    if (parambhwc != null)
    {
      a(parambhwc);
      localbhwc = null;
    }
    for (;;)
    {
      parambhwc = localbhwc;
      if (this.jdField_b_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_Boolean = false;
      return;
      bhvz localbhvz = this.jdField_a_of_type_Bhvv.a();
      do
      {
        localbhwc = parambhwc;
        if (!localbhvz.hasNext()) {
          break;
        }
        a((bhwe)((Map.Entry)localbhvz.next()).getValue());
      } while (!this.jdField_b_of_type_Boolean);
      localbhwc = parambhwc;
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
  
  public void a(@NonNull bhvg parambhvg)
  {
    a("removeObservers");
    Iterator localIterator = this.jdField_a_of_type_Bhvv.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((bhwe)localEntry.getValue()).a(parambhvg)) {
        a((bhwg)localEntry.getKey());
      }
    }
  }
  
  public void a(@NonNull bhvg parambhvg, @NonNull bhwg<? super T> parambhwg)
  {
    a("observe");
    if (parambhvg.a().a() == bhve.a) {}
    bhwd localbhwd;
    do
    {
      return;
      localbhwd = new bhwd(this, parambhvg, parambhwg);
      parambhwg = (bhwe)this.jdField_a_of_type_Bhvv.a(parambhwg, localbhwd);
      if ((parambhwg != null) && (!parambhwg.a(parambhvg))) {
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
      }
    } while (parambhwg != null);
    parambhvg.a().a(localbhwd);
  }
  
  public void a(@NonNull bhwg<? super T> parambhwg)
  {
    a("removeObserver");
    parambhwg = (bhwe)this.jdField_a_of_type_Bhvv.a(parambhwg);
    if (parambhwg == null) {
      return;
    }
    parambhwg.a();
    parambhwg.a(false);
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
    bhvo.a().b(this.jdField_a_of_type_JavaLangRunnable);
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
 * Qualified Name:     bhwc
 * JD-Core Version:    0.7.0.1
 */