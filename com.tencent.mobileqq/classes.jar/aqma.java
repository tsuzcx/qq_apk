import android.app.Activity;

public class aqma
{
  public aqml a(int paramInt, aqng paramaqng)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new aqmq();
    case 3: 
      return new aqmp();
    case 2: 
      return new aqmu();
    }
    return new aqmr();
  }
  
  public aqng a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new aqnj();
    case 3: 
      return new aqnh();
    case 2: 
      return new aqno();
    }
    return new aqnm();
  }
  
  public aqon a(Activity paramActivity, int paramInt, aqng paramaqng)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      if ((paramaqng instanceof aqnj)) {
        return new aqoz(paramActivity, (aqnj)paramaqng);
      }
      aqmd.a().a().a("MVPFactory", 4, "createView type is PIC, presenter is error!");
      return null;
    case 3: 
      if ((paramaqng instanceof aqnh)) {
        return new aqot(paramActivity, (aqnh)paramaqng);
      }
      aqmd.a().a().a("MVPFactory", 4, "createView type is FILE_PIC, presenter is error!");
      return null;
    case 2: 
      if ((paramaqng instanceof aqno)) {
        return new aqpt(paramActivity, (aqno)paramaqng);
      }
      aqmd.a().a().a("MVPFactory", 4, "createView type is VIDEO, presenter is error!");
      return null;
    }
    if ((paramaqng instanceof aqnm)) {
      return new aqpp(paramActivity, (aqnm)paramaqng);
    }
    aqmd.a().a().a("MVPFactory", 4, "createView type is FILE_VIDEO, presenter is error!");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqma
 * JD-Core Version:    0.7.0.1
 */