import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class bdxz
  implements Handler.Callback
{
  public int a;
  protected Context a;
  protected Handler a;
  private bdlq jdField_a_of_type_Bdlq;
  private bdya jdField_a_of_type_Bdya;
  public String a;
  private List<bdxz> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  protected Handler b;
  protected String b;
  private int c = 1;
  
  public bdxz(Context paramContext, int paramInt, bdlq parambdlq)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramInt;
    this.jdField_a_of_type_Bdlq = parambdlq;
    paramContext = (bdcu)getClass().getAnnotation(bdcu.class);
    if (paramContext != null)
    {
      paramContext = paramContext.a();
      if (!TextUtils.isEmpty(paramContext)) {
        this.jdField_b_of_type_JavaLangString = paramContext;
      }
    }
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public bdlq a()
  {
    return this.jdField_a_of_type_Bdlq;
  }
  
  public bdxz a(bdxz parambdxz)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(parambdxz)) {
      this.jdField_a_of_type_JavaUtilList.add(parambdxz);
    }
    return this;
  }
  
  public bdxz a(bdya parambdya)
  {
    this.jdField_a_of_type_Bdya = parambdya;
    return this;
  }
  
  public List<bdxz> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.jdField_b_of_type_Int = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    bdnw.b("minisdk-start_BaseTask", "Task end: " + this.jdField_b_of_type_JavaLangString + " retCode=" + paramInt + " msg=" + paramString);
    a(3);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_Bdya != null) {
      this.jdField_a_of_type_Bdya.onTaskDone(this);
    }
  }
  
  public void a(Looper paramLooper)
  {
    if (this.jdField_b_of_type_AndroidOsHandler == null) {
      this.jdField_b_of_type_AndroidOsHandler = new Handler(paramLooper, this);
    }
  }
  
  public boolean a(bdxz parambdxz)
  {
    if ((parambdxz == null) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilList.contains(parambdxz)) {
      return true;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      boolean bool = ((bdxz)localIterator.next()).a(parambdxz);
      if (bool) {
        return bool;
      }
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Int = 1;
  }
  
  public void c()
  {
    bdnw.b("minisdk-start_BaseTask", "Task end: " + this.jdField_b_of_type_JavaLangString + " succ=" + true);
    a(3);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bdya != null) {
      this.jdField_a_of_type_Bdya.onTaskDone(this);
    }
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Int == 3;
  }
  
  public abstract void d();
  
  public boolean d()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void e()
  {
    if (this.jdField_b_of_type_Int == 2) {}
    do
    {
      return;
      if (this.jdField_b_of_type_Int != 3) {
        break;
      }
    } while (this.jdField_a_of_type_Bdya == null);
    this.jdField_a_of_type_Bdya.onTaskDone(this);
    return;
    a(2);
    if (this.jdField_a_of_type_Bdya != null) {
      this.jdField_a_of_type_Bdya.onTaskBegin(this);
    }
    bdnw.b("minisdk-start_BaseTask", "Task begin: " + this.jdField_b_of_type_JavaLangString);
    try
    {
      d();
      return;
    }
    catch (Throwable localThrowable)
    {
      bdnw.d("minisdk-start_BaseTask", "task exception!", localThrowable);
      f();
    }
  }
  
  public void f()
  {
    a(-1, "");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdxz
 * JD-Core Version:    0.7.0.1
 */