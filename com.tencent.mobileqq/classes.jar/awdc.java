import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class awdc
{
  public static HashMap<Integer, String> a = new HashMap();
  
  static
  {
    a.put(Integer.valueOf(10001), BaseApplication.getContext().getString(2131717774));
    a.put(Integer.valueOf(10002), BaseApplication.getContext().getString(2131717772));
    a.put(Integer.valueOf(10003), BaseApplication.getContext().getString(2131718572));
    a.put(Integer.valueOf(10004), BaseApplication.getContext().getString(2131691177));
    a.put(Integer.valueOf(10005), BaseApplication.getContext().getString(2131717769));
    a.put(Integer.valueOf(10006), BaseApplication.getContext().getString(2131717786));
    a.put(Integer.valueOf(10007), BaseApplication.getContext().getString(2131717773));
  }
  
  public static String a(int paramInt)
  {
    return (String)a.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awdc
 * JD-Core Version:    0.7.0.1
 */