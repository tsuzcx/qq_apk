import android.app.Activity;

public class bgmn
  implements bgmc<Boolean>
{
  public static bgmn a()
  {
    return new bgmn();
  }
  
  public Boolean a(bgls parambgls)
  {
    if (parambgls == null) {
      return Boolean.valueOf(false);
    }
    parambgls.a(new bgmo(this));
    if ((parambgls.b()) && (parambgls.a() != null))
    {
      parambgls = parambgls.a();
      if ((parambgls != null) && (!parambgls.isFinishing())) {
        parambgls.finish();
      }
    }
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgmn
 * JD-Core Version:    0.7.0.1
 */