import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ForwardStep.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ayqu
{
  protected long a;
  private ayqu jdField_a_of_type_Ayqu;
  protected String a;
  protected AtomicBoolean a;
  private ayqu[] jdField_a_of_type_ArrayOfAyqu;
  public AtomicBoolean b = new AtomicBoolean(false);
  
  ayqu(ayqt paramayqt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaLangString = "ForwardStep";
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 4, this.jdField_a_of_type_JavaLangString + "|doStep");
    }
    if ((this.jdField_a_of_type_ArrayOfAyqu != null) && (this.jdField_a_of_type_ArrayOfAyqu.length > 0))
    {
      ayqu[] arrayOfayqu = this.jdField_a_of_type_ArrayOfAyqu;
      int m = arrayOfayqu.length;
      int j = 0;
      int i = 1;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        ayqu localayqu = arrayOfayqu[j];
        QLog.d("Q.share.ForwardSdkShareProcessor", 1, new Object[] { localayqu.jdField_a_of_type_JavaLangString, "|finished=", Boolean.valueOf(localayqu.a()), ", processing=", Boolean.valueOf(localayqu.b()) });
        if (!localayqu.a())
        {
          if (!localayqu.b()) {
            localayqu.a();
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
  
  void a(ayqu[] paramArrayOfayqu)
  {
    this.jdField_a_of_type_ArrayOfAyqu = paramArrayOfayqu;
    if ((this.jdField_a_of_type_ArrayOfAyqu != null) && (this.jdField_a_of_type_ArrayOfAyqu.length > 0))
    {
      paramArrayOfayqu = this.jdField_a_of_type_ArrayOfAyqu;
      int j = paramArrayOfayqu.length;
      int i = 0;
      while (i < j)
      {
        paramArrayOfayqu[i].jdField_a_of_type_Ayqu = this;
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
    aqgj.a(this.jdField_a_of_type_JavaLangString, l);
    if ((this.jdField_a_of_type_Ayqu != null) && (!this.b.get())) {
      this.jdField_a_of_type_Ayqt.a.a.post(new ForwardSdkShareProcessor.ForwardStep.1(this));
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
    this.jdField_a_of_type_Ayqt.d();
  }
  
  protected abstract void d();
  
  protected void e()
  {
    if (a()) {}
    for (;;)
    {
      return;
      this.b.set(true);
      if ((this.jdField_a_of_type_ArrayOfAyqu != null) && (this.jdField_a_of_type_ArrayOfAyqu.length > 0))
      {
        ayqu[] arrayOfayqu = this.jdField_a_of_type_ArrayOfAyqu;
        int j = arrayOfayqu.length;
        int i = 0;
        while (i < j)
        {
          arrayOfayqu[i].e();
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
 * Qualified Name:     ayqu
 * JD-Core Version:    0.7.0.1
 */