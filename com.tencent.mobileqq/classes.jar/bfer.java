import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class bfer
  implements Handler.Callback
{
  public int a;
  protected Context a;
  protected Handler a;
  private bepv jdField_a_of_type_Bepv;
  private bfes jdField_a_of_type_Bfes;
  public String a;
  private List<bfer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  protected String b;
  private int c = 1;
  
  public bfer(Context paramContext, int paramInt, bepv parambepv)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramInt;
    this.jdField_a_of_type_Bepv = parambepv;
    paramContext = (begt)getClass().getAnnotation(begt.class);
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
  
  public bepv a()
  {
    return this.jdField_a_of_type_Bepv;
  }
  
  public bfer a(bfer parambfer)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(parambfer)) {
      this.jdField_a_of_type_JavaUtilList.add(parambfer);
    }
    return this;
  }
  
  public bfer a(bfes parambfes)
  {
    this.jdField_a_of_type_Bfes = parambfes;
    return this;
  }
  
  public List<bfer> a()
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
    besl.b("minisdk-start_BaseTask", "Task end: " + this.jdField_b_of_type_JavaLangString + " retCode=" + paramInt + " msg=" + paramString);
    a(3);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_Bfes != null) {
      this.jdField_a_of_type_Bfes.onTaskDone(this);
    }
  }
  
  public boolean a(bfer parambfer)
  {
    if ((parambfer == null) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilList.contains(parambfer)) {
      return true;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      boolean bool = ((bfer)localIterator.next()).a(parambfer);
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
    besl.b("minisdk-start_BaseTask", "Task end: " + this.jdField_b_of_type_JavaLangString + " succ=" + true);
    a(3);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bfes != null) {
      this.jdField_a_of_type_Bfes.onTaskDone(this);
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
    } while (this.jdField_a_of_type_Bfes == null);
    this.jdField_a_of_type_Bfes.onTaskDone(this);
    return;
    a(2);
    if (this.jdField_a_of_type_Bfes != null) {
      this.jdField_a_of_type_Bfes.onTaskBegin(this);
    }
    besl.b("minisdk-start_BaseTask", "Task begin: " + this.jdField_b_of_type_JavaLangString);
    try
    {
      d();
      return;
    }
    catch (Throwable localThrowable)
    {
      besl.d("minisdk-start_BaseTask", "task exception!", localThrowable);
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
 * Qualified Name:     bfer
 * JD-Core Version:    0.7.0.1
 */