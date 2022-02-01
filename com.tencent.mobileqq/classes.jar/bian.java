import android.content.Intent;

public class bian
{
  public biaq a;
  
  public bian(Intent paramIntent)
  {
    this.a = new biaq(paramIntent.getStringExtra("lh_uin"), paramIntent.getStringExtra("lh_light"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bian
 * JD-Core Version:    0.7.0.1
 */