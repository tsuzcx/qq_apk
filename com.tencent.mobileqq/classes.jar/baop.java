import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ForwardStep.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class baop
{
  protected long a;
  private baop jdField_a_of_type_Baop;
  protected String a;
  protected AtomicBoolean a;
  private baop[] jdField_a_of_type_ArrayOfBaop;
  public AtomicBoolean b = new AtomicBoolean(false);
  
  baop(baoo parambaoo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaLangString = "ForwardStep";
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 4, this.jdField_a_of_type_JavaLangString + "|doStep");
    }
    if ((this.jdField_a_of_type_ArrayOfBaop != null) && (this.jdField_a_of_type_ArrayOfBaop.length > 0))
    {
      baop[] arrayOfbaop = this.jdField_a_of_type_ArrayOfBaop;
      int m = arrayOfbaop.length;
      int j = 0;
      int i = 1;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        baop localbaop = arrayOfbaop[j];
        QLog.d("Q.share.ForwardSdkShareProcessor", 1, new Object[] { localbaop.jdField_a_of_type_JavaLangString, "|finished=", Boolean.valueOf(localbaop.a()), ", processing=", Boolean.valueOf(localbaop.b()) });
        if (!localbaop.a())
        {
          if (!localbaop.b()) {
            localbaop.a();
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
  
  void a(baop[] paramArrayOfbaop)
  {
    this.jdField_a_of_type_ArrayOfBaop = paramArrayOfbaop;
    if ((this.jdField_a_of_type_ArrayOfBaop != null) && (this.jdField_a_of_type_ArrayOfBaop.length > 0))
    {
      paramArrayOfbaop = this.jdField_a_of_type_ArrayOfBaop;
      int j = paramArrayOfbaop.length;
      int i = 0;
      while (i < j)
      {
        paramArrayOfbaop[i].jdField_a_of_type_Baop = this;
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
    arzy.a(this.jdField_a_of_type_JavaLangString, l);
    if ((this.jdField_a_of_type_Baop != null) && (!this.b.get())) {
      this.jdField_a_of_type_Baoo.a.a.post(new ForwardSdkShareProcessor.ForwardStep.1(this));
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
    this.jdField_a_of_type_Baoo.d();
  }
  
  protected abstract void d();
  
  protected void e()
  {
    if (a()) {}
    for (;;)
    {
      return;
      this.b.set(true);
      if ((this.jdField_a_of_type_ArrayOfBaop != null) && (this.jdField_a_of_type_ArrayOfBaop.length > 0))
      {
        baop[] arrayOfbaop = this.jdField_a_of_type_ArrayOfBaop;
        int j = arrayOfbaop.length;
        int i = 0;
        while (i < j)
        {
          arrayOfbaop[i].e();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baop
 * JD-Core Version:    0.7.0.1
 */