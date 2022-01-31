import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class bffi
  implements Handler.Callback
{
  public int a;
  protected Context a;
  protected Handler a;
  private beqm jdField_a_of_type_Beqm;
  private bffj jdField_a_of_type_Bffj;
  public String a;
  private List<bffi> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  protected String b;
  private int c = 1;
  
  public bffi(Context paramContext, int paramInt, beqm parambeqm)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramInt;
    this.jdField_a_of_type_Beqm = parambeqm;
    paramContext = (behk)getClass().getAnnotation(behk.class);
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
  
  public beqm a()
  {
    return this.jdField_a_of_type_Beqm;
  }
  
  public bffi a(bffi parambffi)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(parambffi)) {
      this.jdField_a_of_type_JavaUtilList.add(parambffi);
    }
    return this;
  }
  
  public bffi a(bffj parambffj)
  {
    this.jdField_a_of_type_Bffj = parambffj;
    return this;
  }
  
  public List<bffi> a()
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
    betc.b("minisdk-start_BaseTask", "Task end: " + this.jdField_b_of_type_JavaLangString + " retCode=" + paramInt + " msg=" + paramString);
    a(3);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_Bffj != null) {
      this.jdField_a_of_type_Bffj.onTaskDone(this);
    }
  }
  
  public boolean a(bffi parambffi)
  {
    if ((parambffi == null) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilList.contains(parambffi)) {
      return true;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      boolean bool = ((bffi)localIterator.next()).a(parambffi);
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
    betc.b("minisdk-start_BaseTask", "Task end: " + this.jdField_b_of_type_JavaLangString + " succ=" + true);
    a(3);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bffj != null) {
      this.jdField_a_of_type_Bffj.onTaskDone(this);
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
    } while (this.jdField_a_of_type_Bffj == null);
    this.jdField_a_of_type_Bffj.onTaskDone(this);
    return;
    a(2);
    if (this.jdField_a_of_type_Bffj != null) {
      this.jdField_a_of_type_Bffj.onTaskBegin(this);
    }
    betc.b("minisdk-start_BaseTask", "Task begin: " + this.jdField_b_of_type_JavaLangString);
    try
    {
      d();
      return;
    }
    catch (Throwable localThrowable)
    {
      betc.d("minisdk-start_BaseTask", "task exception!", localThrowable);
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
 * Qualified Name:     bffi
 * JD-Core Version:    0.7.0.1
 */