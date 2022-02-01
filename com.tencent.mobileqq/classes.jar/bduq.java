import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ForwardStep.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class bduq
{
  protected long a;
  private bduq jdField_a_of_type_Bduq;
  protected String a;
  protected AtomicBoolean a;
  private bduq[] jdField_a_of_type_ArrayOfBduq;
  public AtomicBoolean b = new AtomicBoolean(false);
  
  bduq(bdup parambdup)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaLangString = "ForwardStep";
  }
  
  public void a()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, this.jdField_a_of_type_JavaLangString + "|doStep");
    if ((this.jdField_a_of_type_ArrayOfBduq != null) && (this.jdField_a_of_type_ArrayOfBduq.length > 0))
    {
      bduq[] arrayOfbduq = this.jdField_a_of_type_ArrayOfBduq;
      int m = arrayOfbduq.length;
      int j = 0;
      int i = 1;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        bduq localbduq = arrayOfbduq[j];
        QLog.d("Q.share.ForwardSdkShareProcessor", 1, new Object[] { localbduq.jdField_a_of_type_JavaLangString, "|finished=", Boolean.valueOf(localbduq.a()), ", processing=", Boolean.valueOf(localbduq.b()) });
        if (!localbduq.a())
        {
          if (!localbduq.b()) {
            localbduq.a();
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
  
  void a(bduq[] paramArrayOfbduq)
  {
    this.jdField_a_of_type_ArrayOfBduq = paramArrayOfbduq;
    if ((this.jdField_a_of_type_ArrayOfBduq != null) && (this.jdField_a_of_type_ArrayOfBduq.length > 0))
    {
      paramArrayOfbduq = this.jdField_a_of_type_ArrayOfBduq;
      int j = paramArrayOfbduq.length;
      int i = 0;
      while (i < j)
      {
        paramArrayOfbduq[i].jdField_a_of_type_Bduq = this;
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
    aukw.a(this.jdField_a_of_type_JavaLangString, l);
    if ((this.jdField_a_of_type_Bduq != null) && (!this.b.get())) {
      this.jdField_a_of_type_Bdup.a.a.post(new ForwardSdkShareProcessor.ForwardStep.1(this));
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
    this.jdField_a_of_type_Bdup.d();
  }
  
  protected abstract void d();
  
  protected void e()
  {
    if (a()) {}
    for (;;)
    {
      return;
      this.b.set(true);
      if ((this.jdField_a_of_type_ArrayOfBduq != null) && (this.jdField_a_of_type_ArrayOfBduq.length > 0))
      {
        bduq[] arrayOfbduq = this.jdField_a_of_type_ArrayOfBduq;
        int j = arrayOfbduq.length;
        int i = 0;
        while (i < j)
        {
          arrayOfbduq[i].e();
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
 * Qualified Name:     bduq
 * JD-Core Version:    0.7.0.1
 */