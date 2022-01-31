import android.app.Activity;

public class aqly
{
  public aqmj a(int paramInt, aqne paramaqne)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new aqmo();
    case 3: 
      return new aqmn();
    case 2: 
      return new aqms();
    }
    return new aqmp();
  }
  
  public aqne a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new aqnh();
    case 3: 
      return new aqnf();
    case 2: 
      return new aqnm();
    }
    return new aqnk();
  }
  
  public aqol a(Activity paramActivity, int paramInt, aqne paramaqne)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      if ((paramaqne instanceof aqnh)) {
        return new aqox(paramActivity, (aqnh)paramaqne);
      }
      aqmb.a().a().a("MVPFactory", 4, "createView type is PIC, presenter is error!");
      return null;
    case 3: 
      if ((paramaqne instanceof aqnf)) {
        return new aqor(paramActivity, (aqnf)paramaqne);
      }
      aqmb.a().a().a("MVPFactory", 4, "createView type is FILE_PIC, presenter is error!");
      return null;
    case 2: 
      if ((paramaqne instanceof aqnm)) {
        return new aqpr(paramActivity, (aqnm)paramaqne);
      }
      aqmb.a().a().a("MVPFactory", 4, "createView type is VIDEO, presenter is error!");
      return null;
    }
    if ((paramaqne instanceof aqnk)) {
      return new aqpn(paramActivity, (aqnk)paramaqne);
    }
    aqmb.a().a().a("MVPFactory", 4, "createView type is FILE_VIDEO, presenter is error!");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqly
 * JD-Core Version:    0.7.0.1
 */