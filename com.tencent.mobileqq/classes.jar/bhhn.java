import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class bhhn
  implements Handler.Callback
{
  public int a;
  protected Context a;
  private bgqg jdField_a_of_type_Bgqg;
  private bhho jdField_a_of_type_Bhho;
  private List<bhhn> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  protected Handler b;
  public String b;
  private int c;
  protected String c;
  
  public bhhn(Context paramContext, int paramInt, bgqg parambgqg)
  {
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Bgqg = parambgqg;
    paramContext = (bghi)getClass().getAnnotation(bghi.class);
    if (paramContext != null)
    {
      paramContext = paramContext.a();
      if (!TextUtils.isEmpty(paramContext)) {
        this.jdField_c_of_type_JavaLangString = paramContext;
      }
    }
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public bgqg a()
  {
    return this.jdField_a_of_type_Bgqg;
  }
  
  public bhhn a(bhhn parambhhn)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(parambhhn)) {
      this.jdField_a_of_type_JavaUtilList.add(parambhhn);
    }
    return this;
  }
  
  public bhhn a(bhho parambhho)
  {
    this.jdField_a_of_type_Bhho = parambhho;
    return this;
  }
  
  public List<bhhn> a()
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
    QMLog.i("minisdk-start_BaseTask", "Task end: " + this.jdField_c_of_type_JavaLangString + " retCode=" + paramInt + " msg=" + paramString);
    a(3);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_Bhho != null) {
      this.jdField_a_of_type_Bhho.onTaskDone(this);
    }
  }
  
  public boolean a(bhhn parambhhn)
  {
    if ((parambhhn == null) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilList.contains(parambhhn)) {
      return true;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      boolean bool = ((bhhn)localIterator.next()).a(parambhhn);
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
    QMLog.i("minisdk-start_BaseTask", "Task end: " + this.jdField_c_of_type_JavaLangString + " succ=" + true);
    a(3);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bhho != null) {
      this.jdField_a_of_type_Bhho.onTaskDone(this);
    }
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Int == 3;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void e()
  {
    a(-1, "");
  }
  
  public abstract void f();
  
  public void g()
  {
    if (this.jdField_b_of_type_Int == 2) {}
    do
    {
      return;
      if (this.jdField_b_of_type_Int != 3) {
        break;
      }
    } while (this.jdField_a_of_type_Bhho == null);
    this.jdField_a_of_type_Bhho.onTaskDone(this);
    return;
    a(2);
    if (this.jdField_a_of_type_Bhho != null) {
      this.jdField_a_of_type_Bhho.onTaskBegin(this);
    }
    QMLog.i("minisdk-start_BaseTask", "Task begin: " + this.jdField_c_of_type_JavaLangString);
    try
    {
      f();
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_BaseTask", "task exception!", localThrowable);
      e();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhhn
 * JD-Core Version:    0.7.0.1
 */