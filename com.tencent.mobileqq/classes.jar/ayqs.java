import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ForwardStep.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ayqs
{
  protected long a;
  private ayqs jdField_a_of_type_Ayqs;
  protected String a;
  protected AtomicBoolean a;
  private ayqs[] jdField_a_of_type_ArrayOfAyqs;
  public AtomicBoolean b = new AtomicBoolean(false);
  
  ayqs(ayqr paramayqr)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaLangString = "ForwardStep";
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 4, this.jdField_a_of_type_JavaLangString + "|doStep");
    }
    if ((this.jdField_a_of_type_ArrayOfAyqs != null) && (this.jdField_a_of_type_ArrayOfAyqs.length > 0))
    {
      ayqs[] arrayOfayqs = this.jdField_a_of_type_ArrayOfAyqs;
      int m = arrayOfayqs.length;
      int j = 0;
      int i = 1;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        ayqs localayqs = arrayOfayqs[j];
        QLog.d("Q.share.ForwardSdkShareProcessor", 1, new Object[] { localayqs.jdField_a_of_type_JavaLangString, "|finished=", Boolean.valueOf(localayqs.a()), ", processing=", Boolean.valueOf(localayqs.b()) });
        if (!localayqs.a())
        {
          if (!localayqs.b()) {
            localayqs.a();
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
  
  void a(ayqs[] paramArrayOfayqs)
  {
    this.jdField_a_of_type_ArrayOfAyqs = paramArrayOfayqs;
    if ((this.jdField_a_of_type_ArrayOfAyqs != null) && (this.jdField_a_of_type_ArrayOfAyqs.length > 0))
    {
      paramArrayOfayqs = this.jdField_a_of_type_ArrayOfAyqs;
      int j = paramArrayOfayqs.length;
      int i = 0;
      while (i < j)
      {
        paramArrayOfayqs[i].jdField_a_of_type_Ayqs = this;
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
    aqgh.a(this.jdField_a_of_type_JavaLangString, l);
    if ((this.jdField_a_of_type_Ayqs != null) && (!this.b.get())) {
      this.jdField_a_of_type_Ayqr.a.a.post(new ForwardSdkShareProcessor.ForwardStep.1(this));
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
    this.jdField_a_of_type_Ayqr.d();
  }
  
  protected abstract void d();
  
  protected void e()
  {
    if (a()) {}
    for (;;)
    {
      return;
      this.b.set(true);
      if ((this.jdField_a_of_type_ArrayOfAyqs != null) && (this.jdField_a_of_type_ArrayOfAyqs.length > 0))
      {
        ayqs[] arrayOfayqs = this.jdField_a_of_type_ArrayOfAyqs;
        int j = arrayOfayqs.length;
        int i = 0;
        while (i < j)
        {
          arrayOfayqs[i].e();
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
 * Qualified Name:     ayqs
 * JD-Core Version:    0.7.0.1
 */