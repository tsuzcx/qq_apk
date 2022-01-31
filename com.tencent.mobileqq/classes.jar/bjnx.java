import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.lifecycle.livedata.LiveData.1;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class bjnx<T>
{
  private static final Object jdField_b_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private bjnq<bjob<? super T>, bjnx<T>.bjnz> jdField_a_of_type_Bjnq = new bjnq();
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final Runnable jdField_a_of_type_JavaLangRunnable = new LiveData.1(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  private volatile Object c = jdField_b_of_type_JavaLangObject;
  private volatile Object d = jdField_b_of_type_JavaLangObject;
  
  private void a(bjnx<T>.bjnz parambjnx)
  {
    if (!parambjnx.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (!parambjnx.a())
      {
        parambjnx.a(false);
        return;
      }
    } while (parambjnx.jdField_a_of_type_Int >= this.jdField_b_of_type_Int);
    parambjnx.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    parambjnx.jdField_a_of_type_Bjob.a(this.c);
  }
  
  private static void a(String paramString)
  {
    if (!bjnj.a().a()) {
      throw new IllegalStateException("Cannot invoke " + paramString + " on a background thread");
    }
  }
  
  private void b(@Nullable bjnx<T>.bjnz parambjnx)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    bjnx<T>.bjnz localbjnx;
    if (parambjnx != null)
    {
      a(parambjnx);
      localbjnx = null;
    }
    for (;;)
    {
      parambjnx = localbjnx;
      if (this.jdField_b_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_Boolean = false;
      return;
      bjnu localbjnu = this.jdField_a_of_type_Bjnq.a();
      do
      {
        localbjnx = parambjnx;
        if (!localbjnu.hasNext()) {
          break;
        }
        a((bjnz)((Map.Entry)localbjnu.next()).getValue());
      } while (!this.jdField_b_of_type_Boolean);
      localbjnx = parambjnx;
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
  
  public void a(@NonNull bjnb parambjnb)
  {
    a("removeObservers");
    Iterator localIterator = this.jdField_a_of_type_Bjnq.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((bjnz)localEntry.getValue()).a(parambjnb)) {
        a((bjob)localEntry.getKey());
      }
    }
  }
  
  public void a(@NonNull bjnb parambjnb, @NonNull bjob<? super T> parambjob)
  {
    a("observe");
    if (parambjnb.a().a() == bjmz.a) {}
    bjny localbjny;
    do
    {
      return;
      localbjny = new bjny(this, parambjnb, parambjob);
      parambjob = (bjnz)this.jdField_a_of_type_Bjnq.a(parambjob, localbjny);
      if ((parambjob != null) && (!parambjob.a(parambjnb))) {
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
      }
    } while (parambjob != null);
    parambjnb.a().a(localbjny);
  }
  
  public void a(@NonNull bjob<? super T> parambjob)
  {
    a("removeObserver");
    parambjob = (bjnz)this.jdField_a_of_type_Bjnq.a(parambjob);
    if (parambjob == null) {
      return;
    }
    parambjob.a();
    parambjob.a(false);
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
    bjnj.a().b(this.jdField_a_of_type_JavaLangRunnable);
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
 * Qualified Name:     bjnx
 * JD-Core Version:    0.7.0.1
 */