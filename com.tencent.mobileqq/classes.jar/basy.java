import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ForwardStep.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class basy
{
  protected long a;
  private basy jdField_a_of_type_Basy;
  protected String a;
  protected AtomicBoolean a;
  private basy[] jdField_a_of_type_ArrayOfBasy;
  public AtomicBoolean b = new AtomicBoolean(false);
  
  basy(basx parambasx)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaLangString = "ForwardStep";
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 4, this.jdField_a_of_type_JavaLangString + "|doStep");
    }
    if ((this.jdField_a_of_type_ArrayOfBasy != null) && (this.jdField_a_of_type_ArrayOfBasy.length > 0))
    {
      basy[] arrayOfbasy = this.jdField_a_of_type_ArrayOfBasy;
      int m = arrayOfbasy.length;
      int j = 0;
      int i = 1;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        basy localbasy = arrayOfbasy[j];
        QLog.d("Q.share.ForwardSdkShareProcessor", 1, new Object[] { localbasy.jdField_a_of_type_JavaLangString, "|finished=", Boolean.valueOf(localbasy.a()), ", processing=", Boolean.valueOf(localbasy.b()) });
        if (!localbasy.a())
        {
          if (!localbasy.b()) {
            localbasy.a();
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
  
  void a(basy[] paramArrayOfbasy)
  {
    this.jdField_a_of_type_ArrayOfBasy = paramArrayOfbasy;
    if ((this.jdField_a_of_type_ArrayOfBasy != null) && (this.jdField_a_of_type_ArrayOfBasy.length > 0))
    {
      paramArrayOfbasy = this.jdField_a_of_type_ArrayOfBasy;
      int j = paramArrayOfbasy.length;
      int i = 0;
      while (i < j)
      {
        paramArrayOfbasy[i].jdField_a_of_type_Basy = this;
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
    aseh.a(this.jdField_a_of_type_JavaLangString, l);
    if ((this.jdField_a_of_type_Basy != null) && (!this.b.get())) {
      this.jdField_a_of_type_Basx.a.a.post(new ForwardSdkShareProcessor.ForwardStep.1(this));
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
    this.jdField_a_of_type_Basx.d();
  }
  
  protected abstract void d();
  
  protected void e()
  {
    if (a()) {}
    for (;;)
    {
      return;
      this.b.set(true);
      if ((this.jdField_a_of_type_ArrayOfBasy != null) && (this.jdField_a_of_type_ArrayOfBasy.length > 0))
      {
        basy[] arrayOfbasy = this.jdField_a_of_type_ArrayOfBasy;
        int j = arrayOfbasy.length;
        int i = 0;
        while (i < j)
        {
          arrayOfbasy[i].e();
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
 * Qualified Name:     basy
 * JD-Core Version:    0.7.0.1
 */