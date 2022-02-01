import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class bdwu
{
  public static bdwu a;
  
  public static bdwu a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bdwu();
      }
      return a;
    }
    finally {}
  }
  
  public int a()
  {
    return bgnt.a(BaseApplication.getContext());
  }
  
  public String a()
  {
    try
    {
      String str = AppNetConnInfo.getCurrentAPN();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwu
 * JD-Core Version:    0.7.0.1
 */