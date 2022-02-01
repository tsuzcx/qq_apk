import com.tencent.qphone.base.util.QLog;

public class awzb
{
  private awyk jdField_a_of_type_Awyk;
  private awyl jdField_a_of_type_Awyl;
  private awyn jdField_a_of_type_Awyn;
  private awyq jdField_a_of_type_Awyq;
  private awzc jdField_a_of_type_Awzc;
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfacePlayManager", 2, "func init begins, magicfaceDecoder:" + this.jdField_a_of_type_Awyl);
    }
    if (this.jdField_a_of_type_Awyl == null)
    {
      boolean bool = bhlo.d();
      long l = Math.min(bhlo.g(), bhlo.h());
      if ((!bool) || (l < 720L)) {
        break label118;
      }
      this.jdField_a_of_type_Awyl = new awyi();
      if (QLog.isColorLevel()) {
        QLog.d("MagicfacePlayManager", 2, "func init, use [SuperBigDecoder]");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Awyl.a(this.jdField_a_of_type_Awyn);
      if (QLog.isColorLevel()) {
        QLog.d("MagicfacePlayManager", 2, "func init ends.");
      }
      return;
      label118:
      if ("xbig".equalsIgnoreCase(awyq.a()))
      {
        this.jdField_a_of_type_Awyl = new awyr();
        if (QLog.isColorLevel()) {
          QLog.d("MagicfacePlayManager", 2, "func init, use [XBigDecoder]");
        }
      }
      else
      {
        this.jdField_a_of_type_Awyl = new awyo();
        if (QLog.isColorLevel()) {
          QLog.d("MagicfacePlayManager", 2, "func init, use [FFMepgDecoder]");
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Awyl != null) {
      this.jdField_a_of_type_Awyl.a(paramInt);
    }
  }
  
  public void a(awym paramawym)
  {
    if (this.jdField_a_of_type_Awyl != null) {
      this.jdField_a_of_type_Awyl.a(paramawym);
    }
  }
  
  public void a(awyn paramawyn)
  {
    this.jdField_a_of_type_Awyn = paramawyn;
  }
  
  public void a(awyp paramawyp)
  {
    if ((this.jdField_a_of_type_Awyk != null) && (paramawyp.a.equalsIgnoreCase(this.jdField_a_of_type_Awyk.a))) {}
    for (;;)
    {
      this.jdField_a_of_type_Awyl.a(this.jdField_a_of_type_Awyk);
      this.jdField_a_of_type_Awyl.d();
      return;
      this.jdField_a_of_type_Awyk = this.jdField_a_of_type_Awyq.a(paramawyp.a, paramawyp.b);
      this.jdField_a_of_type_Awyk.a = paramawyp.a;
      this.jdField_a_of_type_Awyk.b = paramawyp.b;
    }
  }
  
  public void a(awyq paramawyq)
  {
    this.jdField_a_of_type_Awyq = paramawyq;
  }
  
  public void a(awzc paramawzc)
  {
    this.jdField_a_of_type_Awzc = paramawzc;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Awzc != null) {
      this.jdField_a_of_type_Awzc.a(this.jdField_a_of_type_Awyq.b(paramString));
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Awzc != null) {
      this.jdField_a_of_type_Awzc.a(this.jdField_a_of_type_Awyq.b(paramString), paramInt, 3);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Awyl != null) {
      this.jdField_a_of_type_Awyl.e();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Awyl != null) {
      this.jdField_a_of_type_Awyl.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awzb
 * JD-Core Version:    0.7.0.1
 */