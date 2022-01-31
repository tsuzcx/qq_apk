import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.HashMap;

public class awaq
{
  public static void a(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", String.valueOf(paramInt1));
    localHashMap.put("idType", String.valueOf(paramInt2));
    axrl.a(BaseApplication.getContext()).a(null, "OrderMediaMsgAddTimeout", false, 0L, 0L, localHashMap, "");
  }
  
  public static void a(int paramInt, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("totalSize", String.valueOf(paramInt));
    localHashMap.put("totalCost", String.valueOf(paramLong));
    axrl.a(BaseApplication.getContext()).a(null, "OrderMediaMsgCompleteInfo", true, paramLong, paramInt, localHashMap, "");
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", String.valueOf(paramInt));
    axrl localaxrl = axrl.a(BaseApplication.getContext());
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localaxrl.a(null, "OrderMediaMsgSendTimeout", paramBoolean, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("totalSize", String.valueOf(paramInt1));
    localHashMap.put("mediaSize", String.valueOf(paramInt2));
    axrl localaxrl = axrl.a(BaseApplication.getContext());
    if (paramInt2 > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localaxrl.a(null, "OrderMediaMsgMultiSeperate", bool, 0L, paramInt1, localHashMap, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awaq
 * JD-Core Version:    0.7.0.1
 */