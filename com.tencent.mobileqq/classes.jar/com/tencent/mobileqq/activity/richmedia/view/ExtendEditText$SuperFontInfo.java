package com.tencent.mobileqq.activity.richmedia.view;

import android.graphics.Color;
import android.text.TextUtils;
import java.util.ArrayList;

public class ExtendEditText$SuperFontInfo
{
  public String a = "";
  public int b = 0;
  public boolean c = false;
  public String d = "";
  public String e = "";
  public String f = "";
  public int g = -1;
  public long h = 0L;
  public String i = "";
  public int j = 0;
  public int k = 0;
  public int l = 0;
  public String m = "";
  public ArrayList<String> n = null;
  public ArrayList<Double> o = null;
  public int p = 0;
  public ArrayList<String> q = null;
  public int r = 0;
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    String str = paramString.trim();
    paramString = str;
    if (!str.startsWith("#"))
    {
      paramString = new StringBuilder();
      paramString.append("#");
      paramString.append(str);
      paramString = paramString.toString();
    }
    try
    {
      int i1 = Color.parseColor(paramString);
      return i1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public static SuperFontInfo c(String paramString)
  {
    SuperFontInfo localSuperFontInfo = new SuperFontInfo();
    localSuperFontInfo.b(paramString);
    return localSuperFontInfo;
  }
  
  /* Error */
  public void b(String paramString)
  {
    // Byte code:
    //   0: new 118	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 120	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_0
    //   10: aload_1
    //   11: ldc 122
    //   13: invokevirtual 125	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16: putfield 49	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:g	I
    //   19: aload_0
    //   20: aload_1
    //   21: ldc 127
    //   23: invokevirtual 131	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   26: putfield 51	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:h	J
    //   29: aload_0
    //   30: aload_1
    //   31: ldc 133
    //   33: invokevirtual 137	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   36: putfield 53	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:i	Ljava/lang/String;
    //   39: aload_0
    //   40: aload_1
    //   41: ldc 139
    //   43: invokevirtual 125	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   46: putfield 55	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:j	I
    //   49: aload_0
    //   50: aload_1
    //   51: ldc 141
    //   53: invokevirtual 125	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   56: putfield 57	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:k	I
    //   59: aload_0
    //   60: aload_1
    //   61: ldc 143
    //   63: invokevirtual 125	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   66: putfield 59	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:l	I
    //   69: aload_0
    //   70: aload_1
    //   71: ldc 145
    //   73: invokevirtual 137	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: putfield 61	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:m	Ljava/lang/String;
    //   79: iconst_0
    //   80: istore 4
    //   82: aload_1
    //   83: ldc 147
    //   85: invokevirtual 151	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   88: astore 5
    //   90: aload 5
    //   92: ifnonnull +8 -> 100
    //   95: iconst_0
    //   96: istore_2
    //   97: goto +9 -> 106
    //   100: aload 5
    //   102: invokevirtual 157	org/json/JSONArray:length	()I
    //   105: istore_2
    //   106: aload_0
    //   107: new 159	java/util/ArrayList
    //   110: dup
    //   111: invokespecial 160	java/util/ArrayList:<init>	()V
    //   114: putfield 63	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:n	Ljava/util/ArrayList;
    //   117: iconst_0
    //   118: istore_3
    //   119: iload_3
    //   120: iload_2
    //   121: if_icmpge +31 -> 152
    //   124: aload_0
    //   125: getfield 63	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:n	Ljava/util/ArrayList;
    //   128: aload 5
    //   130: iload_3
    //   131: invokevirtual 164	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   134: invokevirtual 168	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   137: pop
    //   138: iload_3
    //   139: iconst_1
    //   140: iadd
    //   141: istore_3
    //   142: goto -23 -> 119
    //   145: astore 5
    //   147: aload 5
    //   149: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   152: aload_0
    //   153: new 159	java/util/ArrayList
    //   156: dup
    //   157: invokespecial 160	java/util/ArrayList:<init>	()V
    //   160: putfield 65	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:o	Ljava/util/ArrayList;
    //   163: aload_1
    //   164: ldc 170
    //   166: invokevirtual 151	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   169: astore 5
    //   171: aload 5
    //   173: ifnonnull +8 -> 181
    //   176: iconst_0
    //   177: istore_2
    //   178: goto +149 -> 327
    //   181: aload 5
    //   183: invokevirtual 157	org/json/JSONArray:length	()I
    //   186: istore_2
    //   187: goto +140 -> 327
    //   190: iload_3
    //   191: iload_2
    //   192: if_icmpge +34 -> 226
    //   195: aload_0
    //   196: getfield 65	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:o	Ljava/util/ArrayList;
    //   199: aload 5
    //   201: iload_3
    //   202: invokevirtual 174	org/json/JSONArray:getDouble	(I)D
    //   205: invokestatic 180	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   208: invokevirtual 168	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   211: pop
    //   212: iload_3
    //   213: iconst_1
    //   214: iadd
    //   215: istore_3
    //   216: goto -26 -> 190
    //   219: astore 5
    //   221: aload 5
    //   223: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   226: aload_0
    //   227: aload_1
    //   228: ldc 182
    //   230: invokevirtual 125	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   233: putfield 67	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:p	I
    //   236: aload_0
    //   237: new 159	java/util/ArrayList
    //   240: dup
    //   241: invokespecial 160	java/util/ArrayList:<init>	()V
    //   244: putfield 69	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:q	Ljava/util/ArrayList;
    //   247: aload_1
    //   248: ldc 184
    //   250: invokevirtual 151	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   253: astore 5
    //   255: aload 5
    //   257: ifnonnull +11 -> 268
    //   260: iconst_0
    //   261: istore_2
    //   262: iload 4
    //   264: istore_3
    //   265: goto +12 -> 277
    //   268: aload 5
    //   270: invokevirtual 157	org/json/JSONArray:length	()I
    //   273: istore_2
    //   274: iload 4
    //   276: istore_3
    //   277: iload_3
    //   278: iload_2
    //   279: if_icmpge +31 -> 310
    //   282: aload_0
    //   283: getfield 69	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:q	Ljava/util/ArrayList;
    //   286: aload 5
    //   288: iload_3
    //   289: invokevirtual 164	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   292: invokevirtual 168	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   295: pop
    //   296: iload_3
    //   297: iconst_1
    //   298: iadd
    //   299: istore_3
    //   300: goto -23 -> 277
    //   303: astore 5
    //   305: aload 5
    //   307: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   310: aload_0
    //   311: aload_1
    //   312: ldc 186
    //   314: invokevirtual 125	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   317: putfield 71	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:r	I
    //   320: return
    //   321: astore_1
    //   322: aload_1
    //   323: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   326: return
    //   327: iconst_0
    //   328: istore_3
    //   329: goto -139 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	this	SuperFontInfo
    //   0	332	1	paramString	String
    //   96	184	2	i1	int
    //   118	211	3	i2	int
    //   80	195	4	i3	int
    //   88	41	5	localJSONArray1	org.json.JSONArray
    //   145	3	5	localException1	Exception
    //   169	31	5	localJSONArray2	org.json.JSONArray
    //   219	3	5	localException2	Exception
    //   253	34	5	localJSONArray3	org.json.JSONArray
    //   303	3	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   82	90	145	java/lang/Exception
    //   100	106	145	java/lang/Exception
    //   106	117	145	java/lang/Exception
    //   124	138	145	java/lang/Exception
    //   163	171	219	java/lang/Exception
    //   181	187	219	java/lang/Exception
    //   195	212	219	java/lang/Exception
    //   247	255	303	java/lang/Exception
    //   268	274	303	java/lang/Exception
    //   282	296	303	java/lang/Exception
    //   0	79	321	java/lang/Exception
    //   147	152	321	java/lang/Exception
    //   152	163	321	java/lang/Exception
    //   221	226	321	java/lang/Exception
    //   226	247	321	java/lang/Exception
    //   305	310	321	java/lang/Exception
    //   310	320	321	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.ExtendEditText.SuperFontInfo
 * JD-Core Version:    0.7.0.1
 */