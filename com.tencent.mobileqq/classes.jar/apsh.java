import android.content.Intent;

public class apsh
{
  public long a;
  private apsi a;
  public long b;
  public long c;
  public long d;
  public long e;
  
  public apsh(apsi paramapsi)
  {
    this.jdField_a_of_type_Apsi = paramapsi;
  }
  
  public void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Apsi != null)
    {
      long l2 = System.currentTimeMillis();
      this.jdField_a_of_type_Apsi.a();
      long l1 = System.currentTimeMillis();
      this.jdField_a_of_type_Long = (l1 - l2);
      this.jdField_a_of_type_Apsi.a(paramIntent);
      l2 = System.currentTimeMillis();
      this.b = (l2 - l1);
      this.jdField_a_of_type_Apsi.a(null);
      l1 = System.currentTimeMillis();
      this.c = (l1 - l2);
      this.jdField_a_of_type_Apsi.b();
      l2 = System.currentTimeMillis();
      this.d = (l2 - l1);
      this.jdField_a_of_type_Apsi.c();
      this.e = (System.currentTimeMillis() - l2);
      if (apsm.a().a().a())
      {
        paramIntent = "buildParamsTime : " + this.jdField_a_of_type_Long + ", buildPresenterTime " + this.b + ", buildViewTime " + this.c + ", buildModelTime " + this.d + ", buildCompleteTime " + this.e;
        apsm.a().a().a("GalleryDirector", 4, paramIntent);
      }
      return;
    }
    apsm.a().a().a("GalleryDirector", 4, "Gallery builder is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apsh
 * JD-Core Version:    0.7.0.1
 */