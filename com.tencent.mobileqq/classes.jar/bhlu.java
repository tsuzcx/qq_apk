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

public abstract class bhlu
  implements Handler.Callback
{
  public int a;
  protected Context a;
  private bgun jdField_a_of_type_Bgun;
  private bhlv jdField_a_of_type_Bhlv;
  private List<bhlu> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  protected Handler b;
  public String b;
  private int c;
  protected String c;
  
  public bhlu(Context paramContext, int paramInt, bgun parambgun)
  {
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Bgun = parambgun;
    paramContext = (bglp)getClass().getAnnotation(bglp.class);
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
  
  public bgun a()
  {
    return this.jdField_a_of_type_Bgun;
  }
  
  public bhlu a(bhlu parambhlu)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(parambhlu)) {
      this.jdField_a_of_type_JavaUtilList.add(parambhlu);
    }
    return this;
  }
  
  public bhlu a(bhlv parambhlv)
  {
    this.jdField_a_of_type_Bhlv = parambhlv;
    return this;
  }
  
  public List<bhlu> a()
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
    if (this.jdField_a_of_type_Bhlv != null) {
      this.jdField_a_of_type_Bhlv.onTaskDone(this);
    }
  }
  
  public boolean a(bhlu parambhlu)
  {
    if ((parambhlu == null) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilList.contains(parambhlu)) {
      return true;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      boolean bool = ((bhlu)localIterator.next()).a(parambhlu);
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
    if (this.jdField_a_of_type_Bhlv != null) {
      this.jdField_a_of_type_Bhlv.onTaskDone(this);
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
    } while (this.jdField_a_of_type_Bhlv == null);
    this.jdField_a_of_type_Bhlv.onTaskDone(this);
    return;
    a(2);
    if (this.jdField_a_of_type_Bhlv != null) {
      this.jdField_a_of_type_Bhlv.onTaskBegin(this);
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
 * Qualified Name:     bhlu
 * JD-Core Version:    0.7.0.1
 */