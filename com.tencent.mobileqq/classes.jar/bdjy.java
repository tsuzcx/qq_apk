import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.startup.step.InitMemoryCache;
import com.tencent.mobileqq.startup.step.LoadDex;
import com.tencent.mobileqq.startup.step.OldApplication;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.startup.step.StartService;
import com.tencent.mobileqq.startup.step.Step;
import com.tencent.mobileqq.startup.step.Update;

public class bdjy
  implements bdjz
{
  private static bdjz a;
  
  public static void a()
  {
    a = (bdjz)BaseApplicationImpl.sApplication.getClassLoader().loadClass("com.tencent.mobileqq.startup.step.Step$AfterDexStepFactory").newInstance();
  }
  
  public static Step b(int paramInt, bdho parambdho, int[] paramArrayOfInt)
  {
    Object localObject;
    switch (paramInt)
    {
    case 5: 
    case 6: 
    case 7: 
    case 11: 
    case 12: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    default: 
      if (a != null) {
        localObject = a.a(paramInt, parambdho, paramArrayOfInt);
      }
      break;
    }
    for (;;)
    {
      ((Step)localObject).mId = paramInt;
      ((Step)localObject).mDirector = parambdho;
      if (paramInt == 0) {
        Step.access$002((Step)localObject, paramArrayOfInt);
      }
      return localObject;
      localObject = new LoadDex();
      continue;
      localObject = new InitMemoryCache();
      continue;
      localObject = new OldApplication();
      continue;
      localObject = new SetSplash();
      continue;
      localObject = new CheckPermission();
      continue;
      localObject = new Update();
      continue;
      localObject = new StartService();
      continue;
      localObject = new Step();
    }
  }
  
  public Step a(int paramInt, bdho parambdho, int[] paramArrayOfInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdjy
 * JD-Core Version:    0.7.0.1
 */