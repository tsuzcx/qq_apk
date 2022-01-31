import android.content.Intent;

public class aqly
{
  public long a;
  private aqlz a;
  public long b;
  public long c;
  public long d;
  public long e;
  
  public aqly(aqlz paramaqlz)
  {
    this.jdField_a_of_type_Aqlz = paramaqlz;
  }
  
  public void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aqlz != null)
    {
      long l2 = System.currentTimeMillis();
      this.jdField_a_of_type_Aqlz.a();
      long l1 = System.currentTimeMillis();
      this.jdField_a_of_type_Long = (l1 - l2);
      this.jdField_a_of_type_Aqlz.a(paramIntent);
      l2 = System.currentTimeMillis();
      this.b = (l2 - l1);
      this.jdField_a_of_type_Aqlz.a(null);
      l1 = System.currentTimeMillis();
      this.c = (l1 - l2);
      this.jdField_a_of_type_Aqlz.b();
      l2 = System.currentTimeMillis();
      this.d = (l2 - l1);
      this.jdField_a_of_type_Aqlz.c();
      this.e = (System.currentTimeMillis() - l2);
      if (aqmd.a().a().a())
      {
        paramIntent = "buildParamsTime : " + this.jdField_a_of_type_Long + ", buildPresenterTime " + this.b + ", buildViewTime " + this.c + ", buildModelTime " + this.d + ", buildCompleteTime " + this.e;
        aqmd.a().a().a("GalleryDirector", 4, paramIntent);
      }
      return;
    }
    aqmd.a().a().a("GalleryDirector", 4, "Gallery builder is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqly
 * JD-Core Version:    0.7.0.1
 */