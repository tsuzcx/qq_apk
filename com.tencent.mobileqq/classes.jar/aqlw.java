import android.content.Intent;

public class aqlw
{
  public long a;
  private aqlx a;
  public long b;
  public long c;
  public long d;
  public long e;
  
  public aqlw(aqlx paramaqlx)
  {
    this.jdField_a_of_type_Aqlx = paramaqlx;
  }
  
  public void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aqlx != null)
    {
      long l2 = System.currentTimeMillis();
      this.jdField_a_of_type_Aqlx.a();
      long l1 = System.currentTimeMillis();
      this.jdField_a_of_type_Long = (l1 - l2);
      this.jdField_a_of_type_Aqlx.a(paramIntent);
      l2 = System.currentTimeMillis();
      this.b = (l2 - l1);
      this.jdField_a_of_type_Aqlx.a(null);
      l1 = System.currentTimeMillis();
      this.c = (l1 - l2);
      this.jdField_a_of_type_Aqlx.b();
      l2 = System.currentTimeMillis();
      this.d = (l2 - l1);
      this.jdField_a_of_type_Aqlx.c();
      this.e = (System.currentTimeMillis() - l2);
      if (aqmb.a().a().a())
      {
        paramIntent = "buildParamsTime : " + this.jdField_a_of_type_Long + ", buildPresenterTime " + this.b + ", buildViewTime " + this.c + ", buildModelTime " + this.d + ", buildCompleteTime " + this.e;
        aqmb.a().a().a("GalleryDirector", 4, paramIntent);
      }
      return;
    }
    aqmb.a().a().a("GalleryDirector", 4, "Gallery builder is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqlw
 * JD-Core Version:    0.7.0.1
 */