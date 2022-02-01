import android.content.Intent;

public class bgqd
{
  public bgqg a;
  
  public bgqd(Intent paramIntent)
  {
    this.a = new bgqg(paramIntent.getStringExtra("lh_uin"), paramIntent.getStringExtra("lh_light"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgqd
 * JD-Core Version:    0.7.0.1
 */