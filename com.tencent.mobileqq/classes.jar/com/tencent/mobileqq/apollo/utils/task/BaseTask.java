package com.tencent.mobileqq.apollo.utils.task;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseTask
  implements Handler.Callback
{
  public int a;
  protected long a;
  protected Context a;
  protected Handler a;
  private BaseTask.Callback jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskBaseTask$Callback;
  private List<BaseTask> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long = 0L;
  public String b;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 1;
  private long jdField_c_of_type_Long = -1L;
  
  public BaseTask(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public BaseTask a(BaseTask.Callback paramCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskBaseTask$Callback = paramCallback;
    return this;
  }
  
  public BaseTask a(BaseTask paramBaseTask)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramBaseTask)) {
      this.jdField_a_of_type_JavaUtilList.add(paramBaseTask);
    }
    return this;
  }
  
  public List<BaseTask> a()
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
    this.jdField_a_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long);
    QLog.i("TaskFlow", 1, "Task end: " + getClass().getSimpleName() + " retCode=" + paramInt + " msg=" + paramString);
    a(3);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskBaseTask$Callback != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskBaseTask$Callback.a(this);
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Int == 3;
  }
  
  @NonNull
  public String b()
  {
    return getClass().getSimpleName();
  }
  
  protected abstract void b();
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Int == 2) {}
    do
    {
      return;
      if (this.jdField_b_of_type_Int != 3) {
        break;
      }
      this.jdField_b_of_type_Boolean = true;
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskBaseTask$Callback == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskBaseTask$Callback.a(this);
    return;
    a(2);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskBaseTask$Callback != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskBaseTask$Callback.b(this);
    }
    QLog.i("TaskFlow", 1, "Task begin: " + getClass().getSimpleName());
    try
    {
      d();
      b();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("TaskFlow", 1, "task exception!", localThrowable);
      f();
    }
  }
  
  protected final void d()
  {
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long);
    QLog.i("TaskFlow", 1, "Task end: " + getClass().getSimpleName() + " succ=" + true);
    a(3);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskBaseTask$Callback != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsTaskBaseTask$Callback.a(this);
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long);
    a(-1, "");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.BaseTask
 * JD-Core Version:    0.7.0.1
 */