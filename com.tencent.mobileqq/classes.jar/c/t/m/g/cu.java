package c.t.m.g;

import java.util.HashMap;

public final class cu
{
  public static boolean a = false;
  public static boolean b = false;
  public static boolean c;
  public static boolean d = false;
  public static boolean e = true;
  public static boolean f = false;
  public static boolean g = false;
  public static boolean h = false;
  public static volatile dt i = null;
  public static df j = df.a;
  
  public static final int a(String paramString)
  {
    if ((paramString.startsWith("fc4")) || (paramString.startsWith("dc4"))) {
      return 4;
    }
    if ((paramString.startsWith("fc3")) || (paramString.startsWith("dc3"))) {
      return 3;
    }
    if ((paramString.startsWith("fc2")) || (paramString.startsWith("dc2"))) {
      return 2;
    }
    if ((paramString.startsWith("fc1")) || (paramString.startsWith("fc")) || (paramString.startsWith("dc"))) {
      return 1;
    }
    return -1;
  }
  
  public static final String a()
  {
    return "fc4.";
  }
  
  public static final String a(int paramInt)
  {
    String str = "https://analytics.map.qq.com/?sf";
    if (paramInt > 1) {
      str = "https://analytics.map.qq.com/?sf" + paramInt;
    }
    while (paramInt == 1) {
      return str;
    }
    return "";
  }
  
  public static HashMap<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("D_CH_ID", "fc_sdk");
    localHashMap.put("D_FC_SRC", "209");
    localHashMap.put("D_UP_INTERVAL", "1800000");
    localHashMap.put("D_UP_USE_HTTPS", "true");
    localHashMap.put("D_MAX_1F_SIZE", "102400");
    localHashMap.put("D_NUM_UP", "1");
    localHashMap.put("D_MAX_BUF_WF", "25600");
    localHashMap.put("D_MAX_FOLDER_SIZE", "104857600");
    localHashMap.put("D_MAX_DAY_RENAME", "3");
    localHashMap.put("D_MAX_DAY_DELETE", "30");
    localHashMap.put("D_MAX_SIZE_UP_1DAY", "10485760");
    localHashMap.put("D_UP_NET", "w");
    localHashMap.put("D_POS_COLL", "false");
    localHashMap.put("D_WRITE_MAC", "false");
    localHashMap.put("D_UP_WF_INFO", "true");
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.cu
 * JD-Core Version:    0.7.0.1
 */