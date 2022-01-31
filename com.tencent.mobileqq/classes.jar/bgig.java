import android.app.Activity;

public class bgig
  implements bghv<Boolean>
{
  public static bgig a()
  {
    return new bgig();
  }
  
  public Boolean a(bghl parambghl)
  {
    if (parambghl == null) {
      return Boolean.valueOf(false);
    }
    parambghl.a(new bgih(this));
    if ((parambghl.b()) && (parambghl.a() != null))
    {
      parambghl = parambghl.a();
      if ((parambghl != null) && (!parambghl.isFinishing())) {
        parambghl.finish();
      }
    }
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgig
 * JD-Core Version:    0.7.0.1
 */