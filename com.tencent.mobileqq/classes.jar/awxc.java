import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class awxc
{
  public static HashMap<Integer, String> a = new HashMap();
  
  static
  {
    a.put(Integer.valueOf(10001), BaseApplication.getContext().getString(2131717407));
    a.put(Integer.valueOf(10002), BaseApplication.getContext().getString(2131717405));
    a.put(Integer.valueOf(10003), BaseApplication.getContext().getString(2131718195));
    a.put(Integer.valueOf(10004), BaseApplication.getContext().getString(2131691138));
    a.put(Integer.valueOf(10005), BaseApplication.getContext().getString(2131717402));
    a.put(Integer.valueOf(10006), BaseApplication.getContext().getString(2131717419));
    a.put(Integer.valueOf(10007), BaseApplication.getContext().getString(2131717406));
  }
  
  public static String a(int paramInt)
  {
    return (String)a.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxc
 * JD-Core Version:    0.7.0.1
 */