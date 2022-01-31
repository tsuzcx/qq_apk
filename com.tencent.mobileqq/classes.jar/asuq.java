import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class asuq
{
  public static HashMap<Integer, String> a = new HashMap();
  
  static
  {
    a.put(Integer.valueOf(10001), BaseApplication.getContext().getString(2131718833));
    a.put(Integer.valueOf(10002), BaseApplication.getContext().getString(2131718831));
    a.put(Integer.valueOf(10003), BaseApplication.getContext().getString(2131719745));
    a.put(Integer.valueOf(10004), BaseApplication.getContext().getString(2131691305));
    a.put(Integer.valueOf(10005), BaseApplication.getContext().getString(2131718828));
    a.put(Integer.valueOf(10006), BaseApplication.getContext().getString(2131718845));
    a.put(Integer.valueOf(10007), BaseApplication.getContext().getString(2131718832));
  }
  
  public static String a(int paramInt)
  {
    return (String)a.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asuq
 * JD-Core Version:    0.7.0.1
 */