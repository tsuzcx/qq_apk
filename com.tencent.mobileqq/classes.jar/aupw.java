import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class aupw
{
  public static HashMap<Integer, String> a = new HashMap();
  
  static
  {
    a.put(Integer.valueOf(10001), BaseApplication.getContext().getString(2131719320));
    a.put(Integer.valueOf(10002), BaseApplication.getContext().getString(2131719318));
    a.put(Integer.valueOf(10003), BaseApplication.getContext().getString(2131720283));
    a.put(Integer.valueOf(10004), BaseApplication.getContext().getString(2131691359));
    a.put(Integer.valueOf(10005), BaseApplication.getContext().getString(2131719315));
    a.put(Integer.valueOf(10006), BaseApplication.getContext().getString(2131719332));
    a.put(Integer.valueOf(10007), BaseApplication.getContext().getString(2131719319));
  }
  
  public static String a(int paramInt)
  {
    return (String)a.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aupw
 * JD-Core Version:    0.7.0.1
 */