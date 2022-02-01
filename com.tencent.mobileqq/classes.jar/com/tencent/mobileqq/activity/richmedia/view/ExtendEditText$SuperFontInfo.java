package com.tencent.mobileqq.activity.richmedia.view;

import android.graphics.Color;
import android.text.TextUtils;
import java.util.ArrayList;

public class ExtendEditText$SuperFontInfo
{
  public int a;
  public long a;
  public String a;
  public ArrayList<String> a;
  public boolean a;
  public int b;
  public String b;
  public ArrayList<Double> b;
  public int c;
  public String c;
  public ArrayList<String> c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g = 0;
  
  public ExtendEditText$SuperFontInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_b_of_type_JavaUtilArrayList = null;
    this.jdField_f_of_type_Int = 0;
    this.jdField_c_of_type_JavaUtilArrayList = null;
  }
  
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
      int i = Color.parseColor(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public static SuperFontInfo a(String paramString)
  {
    SuperFontInfo localSuperFontInfo = new SuperFontInfo();
    localSuperFontInfo.a(paramString);
    return localSuperFontInfo;
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: new 107	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 109	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_0
    //   10: aload_1
    //   11: ldc 111
    //   13: invokevirtual 114	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16: putfield 38	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:jdField_b_of_type_Int	I
    //   19: aload_0
    //   20: aload_1
    //   21: ldc 116
    //   23: invokevirtual 120	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   26: putfield 40	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:jdField_a_of_type_Long	J
    //   29: aload_0
    //   30: aload_1
    //   31: ldc 122
    //   33: invokevirtual 126	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   36: putfield 42	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   39: aload_0
    //   40: aload_1
    //   41: ldc 128
    //   43: invokevirtual 114	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   46: putfield 44	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:jdField_c_of_type_Int	I
    //   49: aload_0
    //   50: aload_1
    //   51: ldc 130
    //   53: invokevirtual 114	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   56: putfield 46	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:jdField_d_of_type_Int	I
    //   59: aload_0
    //   60: aload_1
    //   61: ldc 132
    //   63: invokevirtual 114	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   66: putfield 48	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:jdField_e_of_type_Int	I
    //   69: aload_0
    //   70: aload_1
    //   71: ldc 134
    //   73: invokevirtual 126	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: putfield 50	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   79: iconst_0
    //   80: istore 4
    //   82: aload_1
    //   83: ldc 136
    //   85: invokevirtual 140	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   88: astore 5
    //   90: aload 5
    //   92: ifnonnull +8 -> 100
    //   95: iconst_0
    //   96: istore_2
    //   97: goto +9 -> 106
    //   100: aload 5
    //   102: invokevirtual 146	org/json/JSONArray:length	()I
    //   105: istore_2
    //   106: aload_0
    //   107: new 148	java/util/ArrayList
    //   110: dup
    //   111: invokespecial 149	java/util/ArrayList:<init>	()V
    //   114: putfield 52	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   117: iconst_0
    //   118: istore_3
    //   119: iload_3
    //   120: iload_2
    //   121: if_icmpge +31 -> 152
    //   124: aload_0
    //   125: getfield 52	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   128: aload 5
    //   130: iload_3
    //   131: invokevirtual 153	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   134: invokevirtual 157	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   137: pop
    //   138: iload_3
    //   139: iconst_1
    //   140: iadd
    //   141: istore_3
    //   142: goto -23 -> 119
    //   145: astore 5
    //   147: aload 5
    //   149: invokevirtual 100	java/lang/Exception:printStackTrace	()V
    //   152: aload_0
    //   153: new 148	java/util/ArrayList
    //   156: dup
    //   157: invokespecial 149	java/util/ArrayList:<init>	()V
    //   160: putfield 54	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   163: aload_1
    //   164: ldc 159
    //   166: invokevirtual 140	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   169: astore 5
    //   171: aload 5
    //   173: ifnonnull +8 -> 181
    //   176: iconst_0
    //   177: istore_2
    //   178: goto +149 -> 327
    //   181: aload 5
    //   183: invokevirtual 146	org/json/JSONArray:length	()I
    //   186: istore_2
    //   187: goto +140 -> 327
    //   190: iload_3
    //   191: iload_2
    //   192: if_icmpge +34 -> 226
    //   195: aload_0
    //   196: getfield 54	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   199: aload 5
    //   201: iload_3
    //   202: invokevirtual 163	org/json/JSONArray:getDouble	(I)D
    //   205: invokestatic 169	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   208: invokevirtual 157	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   211: pop
    //   212: iload_3
    //   213: iconst_1
    //   214: iadd
    //   215: istore_3
    //   216: goto -26 -> 190
    //   219: astore 5
    //   221: aload 5
    //   223: invokevirtual 100	java/lang/Exception:printStackTrace	()V
    //   226: aload_0
    //   227: aload_1
    //   228: ldc 171
    //   230: invokevirtual 114	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   233: putfield 56	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:jdField_f_of_type_Int	I
    //   236: aload_0
    //   237: new 148	java/util/ArrayList
    //   240: dup
    //   241: invokespecial 149	java/util/ArrayList:<init>	()V
    //   244: putfield 58	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   247: aload_1
    //   248: ldc 173
    //   250: invokevirtual 140	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   253: astore 5
    //   255: aload 5
    //   257: ifnonnull +11 -> 268
    //   260: iconst_0
    //   261: istore_2
    //   262: iload 4
    //   264: istore_3
    //   265: goto +12 -> 277
    //   268: aload 5
    //   270: invokevirtual 146	org/json/JSONArray:length	()I
    //   273: istore_2
    //   274: iload 4
    //   276: istore_3
    //   277: iload_3
    //   278: iload_2
    //   279: if_icmpge +31 -> 310
    //   282: aload_0
    //   283: getfield 58	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   286: aload 5
    //   288: iload_3
    //   289: invokevirtual 153	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   292: invokevirtual 157	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   295: pop
    //   296: iload_3
    //   297: iconst_1
    //   298: iadd
    //   299: istore_3
    //   300: goto -23 -> 277
    //   303: astore 5
    //   305: aload 5
    //   307: invokevirtual 100	java/lang/Exception:printStackTrace	()V
    //   310: aload_0
    //   311: aload_1
    //   312: ldc 175
    //   314: invokevirtual 114	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   317: putfield 60	com/tencent/mobileqq/activity/richmedia/view/ExtendEditText$SuperFontInfo:g	I
    //   320: return
    //   321: astore_1
    //   322: aload_1
    //   323: invokevirtual 100	java/lang/Exception:printStackTrace	()V
    //   326: return
    //   327: iconst_0
    //   328: istore_3
    //   329: goto -139 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	this	SuperFontInfo
    //   0	332	1	paramString	String
    //   96	184	2	i	int
    //   118	211	3	j	int
    //   80	195	4	k	int
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.ExtendEditText.SuperFontInfo
 * JD-Core Version:    0.7.0.1
 */