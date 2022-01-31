import java.io.File;

public class birk
  extends bire
{
  public String n;
  public String o;
  
  public String a()
  {
    File localFile = new File(this.o);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return this.o + File.separator + this.f;
  }
  
  public String b()
  {
    File localFile = new File(this.o);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return this.o + File.separator;
  }
  
  public String c()
  {
    File localFile = new File(this.n);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return this.n + File.separator + this.f;
  }
  
  public boolean d()
  {
    Object localObject = new File(a());
    if (!((File)localObject).exists()) {}
    do
    {
      return false;
      localObject = ((File)localObject).list();
    } while ((localObject == null) || (localObject.length <= 0));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     birk
 * JD-Core Version:    0.7.0.1
 */