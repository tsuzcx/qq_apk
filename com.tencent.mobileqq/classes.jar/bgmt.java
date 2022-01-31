import com.tencent.qqmini.sdk.log.QMLog;

public class bgmt
  implements bgmc<Boolean>
{
  private int a;
  
  private static bgmt a(int paramInt)
  {
    bgmt localbgmt = new bgmt();
    localbgmt.a = paramInt;
    return localbgmt;
  }
  
  public static Boolean a(bglv parambglv)
  {
    return (Boolean)parambglv.a(a(2));
  }
  
  public static Boolean b(bglv parambglv)
  {
    return (Boolean)parambglv.a(a(1));
  }
  
  public Boolean a(bgls parambgls)
  {
    parambgls = parambgls.a();
    if (parambgls == null)
    {
      QMLog.e("UpdateUIEvent", "Failed to perform " + this + ". page is null");
      return Boolean.valueOf(false);
    }
    switch (this.a)
    {
    default: 
      return Boolean.valueOf(false);
    case 2: 
      return Boolean.valueOf(parambgls.a());
    }
    return Boolean.valueOf(parambgls.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgmt
 * JD-Core Version:    0.7.0.1
 */