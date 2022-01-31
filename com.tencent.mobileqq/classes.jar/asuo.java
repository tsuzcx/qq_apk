import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class asuo
{
  public static HashMap<Integer, String> a = new HashMap();
  
  static
  {
    a.put(Integer.valueOf(10001), BaseApplication.getContext().getString(2131718822));
    a.put(Integer.valueOf(10002), BaseApplication.getContext().getString(2131718820));
    a.put(Integer.valueOf(10003), BaseApplication.getContext().getString(2131719734));
    a.put(Integer.valueOf(10004), BaseApplication.getContext().getString(2131691305));
    a.put(Integer.valueOf(10005), BaseApplication.getContext().getString(2131718817));
    a.put(Integer.valueOf(10006), BaseApplication.getContext().getString(2131718834));
    a.put(Integer.valueOf(10007), BaseApplication.getContext().getString(2131718821));
  }
  
  public static String a(int paramInt)
  {
    return (String)a.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asuo
 * JD-Core Version:    0.7.0.1
 */