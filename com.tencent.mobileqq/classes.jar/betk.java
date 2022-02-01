import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ForwardStep.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class betk
{
  protected long a;
  private betk jdField_a_of_type_Betk;
  protected String a;
  protected AtomicBoolean a;
  private betk[] jdField_a_of_type_ArrayOfBetk;
  public AtomicBoolean b = new AtomicBoolean(false);
  
  betk(betj parambetj)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaLangString = "ForwardStep";
  }
  
  public void a()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, this.jdField_a_of_type_JavaLangString + "|doStep");
    if ((this.jdField_a_of_type_ArrayOfBetk != null) && (this.jdField_a_of_type_ArrayOfBetk.length > 0))
    {
      betk[] arrayOfbetk = this.jdField_a_of_type_ArrayOfBetk;
      int m = arrayOfbetk.length;
      int j = 0;
      int i = 1;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        betk localbetk = arrayOfbetk[j];
        QLog.d("Q.share.ForwardSdkShareProcessor", 1, new Object[] { localbetk.jdField_a_of_type_JavaLangString, "|finished=", Boolean.valueOf(localbetk.a()), ", processing=", Boolean.valueOf(localbetk.b()) });
        if (!localbetk.a())
        {
          if (!localbetk.b()) {
            localbetk.a();
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
  
  void a(betk[] paramArrayOfbetk)
  {
    this.jdField_a_of_type_ArrayOfBetk = paramArrayOfbetk;
    if ((this.jdField_a_of_type_ArrayOfBetk != null) && (this.jdField_a_of_type_ArrayOfBetk.length > 0))
    {
      paramArrayOfbetk = this.jdField_a_of_type_ArrayOfBetk;
      int j = paramArrayOfbetk.length;
      int i = 0;
      while (i < j)
      {
        paramArrayOfbetk[i].jdField_a_of_type_Betk = this;
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
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.jdField_a_of_type_Long != 0L) {
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, this.jdField_a_of_type_JavaLangString + "|finished,cost=" + l);
    avcw.a(this.jdField_a_of_type_JavaLangString, l);
    if ((this.jdField_a_of_type_Betk != null) && (!this.b.get())) {
      this.jdField_a_of_type_Betj.a.a.post(new ForwardSdkShareProcessor.ForwardStep.1(this));
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
    this.jdField_a_of_type_Betj.d();
  }
  
  protected abstract void d();
  
  protected void e()
  {
    if (a()) {}
    for (;;)
    {
      return;
      this.b.set(true);
      if ((this.jdField_a_of_type_ArrayOfBetk != null) && (this.jdField_a_of_type_ArrayOfBetk.length > 0))
      {
        betk[] arrayOfbetk = this.jdField_a_of_type_ArrayOfBetk;
        int j = arrayOfbetk.length;
        int i = 0;
        while (i < j)
        {
          arrayOfbetk[i].e();
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
 * Qualified Name:     betk
 * JD-Core Version:    0.7.0.1
 */