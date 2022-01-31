import android.app.Activity;

public class apsj
{
  public apsu a(int paramInt, aptf paramaptf)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new apsz();
    case 3: 
      return new apsy();
    case 2: 
      return new aptd();
    }
    return new apta();
  }
  
  public aptf a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new apti();
    case 3: 
      return new aptg();
    case 2: 
      return new aptm();
    }
    return new aptk();
  }
  
  public apul a(Activity paramActivity, int paramInt, aptf paramaptf)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      if ((paramaptf instanceof apti)) {
        return new apux(paramActivity, (apti)paramaptf);
      }
      apsm.a().a().a("MVPFactory", 4, "createView type is PIC, presenter is error!");
      return null;
    case 3: 
      if ((paramaptf instanceof aptg)) {
        return new apur(paramActivity, (aptg)paramaptf);
      }
      apsm.a().a().a("MVPFactory", 4, "createView type is FILE_PIC, presenter is error!");
      return null;
    case 2: 
      if ((paramaptf instanceof aptm)) {
        return new apvq(paramActivity, (aptm)paramaptf);
      }
      apsm.a().a().a("MVPFactory", 4, "createView type is VIDEO, presenter is error!");
      return null;
    }
    if ((paramaptf instanceof aptk)) {
      return new apvm(paramActivity, (aptk)paramaptf);
    }
    apsm.a().a().a("MVPFactory", 4, "createView type is FILE_VIDEO, presenter is error!");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apsj
 * JD-Core Version:    0.7.0.1
 */