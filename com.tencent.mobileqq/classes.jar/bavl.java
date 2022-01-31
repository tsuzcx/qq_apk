import android.content.Intent;

public class bavl
{
  public bavo a;
  
  public bavl(Intent paramIntent)
  {
    this.a = new bavo(paramIntent.getStringExtra("lh_uin"), paramIntent.getStringExtra("lh_light"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bavl
 * JD-Core Version:    0.7.0.1
 */