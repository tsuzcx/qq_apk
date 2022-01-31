import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ForwardStep.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class axql
{
  protected long a;
  private axql jdField_a_of_type_Axql;
  protected String a;
  protected AtomicBoolean a;
  private axql[] jdField_a_of_type_ArrayOfAxql;
  public AtomicBoolean b = new AtomicBoolean(false);
  
  axql(axqk paramaxqk)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaLangString = "ForwardStep";
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 4, this.jdField_a_of_type_JavaLangString + "|doStep");
    }
    if ((this.jdField_a_of_type_ArrayOfAxql != null) && (this.jdField_a_of_type_ArrayOfAxql.length > 0))
    {
      axql[] arrayOfaxql = this.jdField_a_of_type_ArrayOfAxql;
      int m = arrayOfaxql.length;
      int j = 0;
      int i = 1;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        axql localaxql = arrayOfaxql[j];
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.share.ForwardSdkShareProcessor", 4, this.jdField_a_of_type_JavaLangString + "|finished=" + localaxql.a() + ",processing=" + localaxql.b());
        }
        if (!localaxql.a())
        {
          if (!localaxql.b()) {
            localaxql.a();
          }
          i = 0;
        }
        j += 1;
      }
    }
    int k = 1;
    if ((k != 0) && (!a()) && (!b()))
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      d();
    }
  }
  
  void a(axql[] paramArrayOfaxql)
  {
    this.jdField_a_of_type_ArrayOfAxql = paramArrayOfaxql;
    if ((this.jdField_a_of_type_ArrayOfAxql != null) && (this.jdField_a_of_type_ArrayOfAxql.length > 0))
    {
      paramArrayOfaxql = this.jdField_a_of_type_ArrayOfAxql;
      int j = paramArrayOfaxql.length;
      int i = 0;
      while (i < j)
      {
        paramArrayOfaxql[i].jdField_a_of_type_Axql = this;
        i += 1;
      }
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void b()
  {
    long l = 0L;
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 4, this.jdField_a_of_type_JavaLangString + "|doNextStep");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.jdField_a_of_type_Long != 0L) {
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, this.jdField_a_of_type_JavaLangString + "|finished,cost=" + l);
    }
    apmt.a(this.jdField_a_of_type_JavaLangString, l);
    if ((this.jdField_a_of_type_Axql != null) && (!this.b.get())) {
      this.jdField_a_of_type_Axqk.a.a.post(new ForwardSdkShareProcessor.ForwardStep.1(this));
    }
  }
  
  protected boolean b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void c()
  {
    long l = 0L;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.jdField_a_of_type_Long != 0L) {
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, this.jdField_a_of_type_JavaLangString + "|doError,cost=" + l);
    this.jdField_a_of_type_Axqk.d();
  }
  
  protected abstract void d();
  
  protected void e()
  {
    if (a()) {}
    for (;;)
    {
      return;
      this.b.set(true);
      if ((this.jdField_a_of_type_ArrayOfAxql != null) && (this.jdField_a_of_type_ArrayOfAxql.length > 0))
      {
        axql[] arrayOfaxql = this.jdField_a_of_type_ArrayOfAxql;
        int j = arrayOfaxql.length;
        int i = 0;
        while (i < j)
        {
          arrayOfaxql[i].e();
          i += 1;
        }
      }
    }
  }
  
  public void f()
  {
    long l = 0L;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.jdField_a_of_type_Long != 0L) {
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, this.jdField_a_of_type_JavaLangString + "|doCancel,cost=" + l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axql
 * JD-Core Version:    0.7.0.1
 */