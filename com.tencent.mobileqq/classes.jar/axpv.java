import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class axpv
{
  public static HashMap<Integer, String> a = new HashMap();
  
  static
  {
    a.put(Integer.valueOf(10001), BaseApplication.getContext().getString(2131717538));
    a.put(Integer.valueOf(10002), BaseApplication.getContext().getString(2131717536));
    a.put(Integer.valueOf(10003), BaseApplication.getContext().getString(2131718330));
    a.put(Integer.valueOf(10004), BaseApplication.getContext().getString(2131691138));
    a.put(Integer.valueOf(10005), BaseApplication.getContext().getString(2131717533));
    a.put(Integer.valueOf(10006), BaseApplication.getContext().getString(2131717550));
    a.put(Integer.valueOf(10007), BaseApplication.getContext().getString(2131717537));
  }
  
  public static String a(int paramInt)
  {
    return (String)a.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axpv
 * JD-Core Version:    0.7.0.1
 */