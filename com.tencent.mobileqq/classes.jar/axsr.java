import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.HashMap;

public class axsr
{
  public static void a(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", String.valueOf(paramInt1));
    localHashMap.put("idType", String.valueOf(paramInt2));
    azmz.a(BaseApplication.getContext()).a(null, "OrderMediaMsgAddTimeout", false, 0L, 0L, localHashMap, "");
  }
  
  public static void a(int paramInt, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("totalSize", String.valueOf(paramInt));
    localHashMap.put("totalCost", String.valueOf(paramLong));
    azmz.a(BaseApplication.getContext()).a(null, "OrderMediaMsgCompleteInfo", true, paramLong, paramInt, localHashMap, "");
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", String.valueOf(paramInt));
    azmz localazmz = azmz.a(BaseApplication.getContext());
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localazmz.a(null, "OrderMediaMsgSendTimeout", paramBoolean, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("totalSize", String.valueOf(paramInt1));
    localHashMap.put("mediaSize", String.valueOf(paramInt2));
    azmz localazmz = azmz.a(BaseApplication.getContext());
    if (paramInt2 > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localazmz.a(null, "OrderMediaMsgMultiSeperate", bool, 0L, paramInt1, localHashMap, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axsr
 * JD-Core Version:    0.7.0.1
 */