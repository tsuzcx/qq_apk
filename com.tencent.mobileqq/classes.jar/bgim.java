import com.tencent.qqmini.sdk.log.QMLog;

public class bgim
  implements bghv<Boolean>
{
  private int a;
  
  private static bgim a(int paramInt)
  {
    bgim localbgim = new bgim();
    localbgim.a = paramInt;
    return localbgim;
  }
  
  public static Boolean a(bgho parambgho)
  {
    return (Boolean)parambgho.a(a(2));
  }
  
  public static Boolean b(bgho parambgho)
  {
    return (Boolean)parambgho.a(a(1));
  }
  
  public Boolean a(bghl parambghl)
  {
    parambghl = parambghl.a();
    if (parambghl == null)
    {
      QMLog.e("UpdateUIEvent", "Failed to perform " + this + ". page is null");
      return Boolean.valueOf(false);
    }
    switch (this.a)
    {
    default: 
      return Boolean.valueOf(false);
    case 2: 
      return Boolean.valueOf(parambghl.a());
    }
    return Boolean.valueOf(parambghl.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgim
 * JD-Core Version:    0.7.0.1
 */