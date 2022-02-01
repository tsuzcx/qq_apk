package com.tencent.falco.base.floatwindow.permission.romutils;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/falco/base/floatwindow/permission/romutils/PhoneRomUtils;", "", "()V", "TAG", "", "checkIs360Rom", "", "checkIsHuaweiRom", "checkIsMeizuRom", "checkIsMiuiRom", "checkIsOppoRom", "checkIsVivoRom", "getEmuiVersion", "", "getMiuiVersion", "", "getSystemProperty", "propName", "floatwindow_release"}, k=1, mv={1, 1, 15})
public final class PhoneRomUtils
{
  public static final PhoneRomUtils INSTANCE = new PhoneRomUtils();
  private static final String TAG = "PhoneRomUtils";
  
  @JvmStatic
  public static final double getEmuiVersion()
  {
    try
    {
      String str = getSystemProperty("ro.build.version.emui");
      if (str == null) {
        Intrinsics.throwNpe();
      }
      int i = StringsKt.indexOf$default((CharSequence)str, "_", 0, false, 6, null);
      if (str != null)
      {
        str = str.substring(i + 1);
        Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).substring(startIndex)");
        return Double.parseDouble(str);
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 4.0D;
  }
  
  /* Error */
  @JvmStatic
  @org.jetbrains.annotations.Nullable
  public static final String getSystemProperty(@org.jetbrains.annotations.NotNull String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 102
    //   3: invokestatic 105	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aconst_null
    //   7: checkcast 107	java/io/BufferedReader
    //   10: astore_2
    //   11: aload_2
    //   12: astore_1
    //   13: invokestatic 113	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   16: astore_3
    //   17: aload_2
    //   18: astore_1
    //   19: new 115	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   26: astore 4
    //   28: aload_2
    //   29: astore_1
    //   30: aload 4
    //   32: ldc 118
    //   34: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_2
    //   39: astore_1
    //   40: aload 4
    //   42: aload_0
    //   43: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_2
    //   48: astore_1
    //   49: aload_3
    //   50: aload 4
    //   52: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokevirtual 130	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   58: astore_3
    //   59: aload_2
    //   60: astore_1
    //   61: aload_3
    //   62: ldc 132
    //   64: invokestatic 78	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   67: aload_2
    //   68: astore_1
    //   69: new 107	java/io/BufferedReader
    //   72: dup
    //   73: new 134	java/io/InputStreamReader
    //   76: dup
    //   77: aload_3
    //   78: invokevirtual 140	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   81: invokespecial 143	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   84: checkcast 145	java/io/Reader
    //   87: sipush 1024
    //   90: invokespecial 148	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   93: astore_3
    //   94: aload_3
    //   95: invokevirtual 151	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   98: astore_1
    //   99: aload_1
    //   100: ldc 153
    //   102: invokestatic 78	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   105: aload_3
    //   106: invokevirtual 156	java/io/BufferedReader:close	()V
    //   109: aload_3
    //   110: invokevirtual 156	java/io/BufferedReader:close	()V
    //   113: aload_1
    //   114: areturn
    //   115: astore_0
    //   116: ldc 34
    //   118: ldc 158
    //   120: aload_0
    //   121: checkcast 160	java/lang/Throwable
    //   124: invokestatic 166	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   127: pop
    //   128: aload_1
    //   129: areturn
    //   130: astore_0
    //   131: aload_3
    //   132: astore_1
    //   133: goto +88 -> 221
    //   136: astore_1
    //   137: aload_3
    //   138: astore_2
    //   139: aload_1
    //   140: astore_3
    //   141: goto +8 -> 149
    //   144: astore_0
    //   145: goto +76 -> 221
    //   148: astore_3
    //   149: aload_2
    //   150: astore_1
    //   151: new 115	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   158: astore 4
    //   160: aload_2
    //   161: astore_1
    //   162: aload 4
    //   164: ldc 168
    //   166: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_2
    //   171: astore_1
    //   172: aload 4
    //   174: aload_0
    //   175: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_2
    //   180: astore_1
    //   181: ldc 34
    //   183: aload 4
    //   185: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: aload_3
    //   189: checkcast 160	java/lang/Throwable
    //   192: invokestatic 166	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   195: pop
    //   196: aload_2
    //   197: ifnull +22 -> 219
    //   200: aload_2
    //   201: invokevirtual 156	java/io/BufferedReader:close	()V
    //   204: aconst_null
    //   205: areturn
    //   206: astore_0
    //   207: ldc 34
    //   209: ldc 158
    //   211: aload_0
    //   212: checkcast 160	java/lang/Throwable
    //   215: invokestatic 166	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   218: pop
    //   219: aconst_null
    //   220: areturn
    //   221: aload_1
    //   222: ifnull +23 -> 245
    //   225: aload_1
    //   226: invokevirtual 156	java/io/BufferedReader:close	()V
    //   229: goto +16 -> 245
    //   232: astore_1
    //   233: ldc 34
    //   235: ldc 158
    //   237: aload_1
    //   238: checkcast 160	java/lang/Throwable
    //   241: invokestatic 166	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   244: pop
    //   245: aload_0
    //   246: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	paramString	String
    //   12	121	1	localObject1	Object
    //   136	4	1	localIOException1	java.io.IOException
    //   150	76	1	localObject2	Object
    //   232	6	1	localIOException2	java.io.IOException
    //   10	191	2	localObject3	Object
    //   16	125	3	localObject4	Object
    //   148	41	3	localIOException3	java.io.IOException
    //   26	158	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   109	113	115	java/io/IOException
    //   94	109	130	finally
    //   94	109	136	java/io/IOException
    //   13	17	144	finally
    //   19	28	144	finally
    //   30	38	144	finally
    //   40	47	144	finally
    //   49	59	144	finally
    //   61	67	144	finally
    //   69	94	144	finally
    //   151	160	144	finally
    //   162	170	144	finally
    //   172	179	144	finally
    //   181	196	144	finally
    //   13	17	148	java/io/IOException
    //   19	28	148	java/io/IOException
    //   30	38	148	java/io/IOException
    //   40	47	148	java/io/IOException
    //   49	59	148	java/io/IOException
    //   61	67	148	java/io/IOException
    //   69	94	148	java/io/IOException
    //   200	204	206	java/io/IOException
    //   225	229	232	java/io/IOException
  }
  
  public final boolean checkIs360Rom()
  {
    Object localObject = Build.MANUFACTURER;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Build.MANUFACTURER");
    localObject = (CharSequence)localObject;
    CharSequence localCharSequence = (CharSequence)"QiKU";
    boolean bool = false;
    if (!StringsKt.contains$default((CharSequence)localObject, localCharSequence, false, 2, null))
    {
      localObject = Build.MANUFACTURER;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "Build.MANUFACTURER");
      if (!StringsKt.contains$default((CharSequence)localObject, (CharSequence)"360", false, 2, null)) {}
    }
    else
    {
      bool = true;
    }
    return bool;
  }
  
  public final boolean checkIsHuaweiRom()
  {
    String str = Build.MANUFACTURER;
    Intrinsics.checkExpressionValueIsNotNull(str, "Build.MANUFACTURER");
    return StringsKt.contains$default((CharSequence)str, (CharSequence)"HUAWEI", false, 2, null);
  }
  
  public final boolean checkIsMeizuRom()
  {
    String str = getSystemProperty("ro.build.display.id");
    CharSequence localCharSequence = (CharSequence)str;
    boolean bool2 = TextUtils.isEmpty(localCharSequence);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (str == null) {
      Intrinsics.throwNpe();
    }
    if (!StringsKt.contains$default(localCharSequence, (CharSequence)"flyme", false, 2, null))
    {
      str = str.toLowerCase();
      Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).toLowerCase()");
      if (!StringsKt.contains$default((CharSequence)str, (CharSequence)"flyme", false, 2, null)) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public final boolean checkIsMiuiRom()
  {
    return TextUtils.isEmpty((CharSequence)getSystemProperty("ro.miui.ui.version.name")) ^ true;
  }
  
  public final boolean checkIsOppoRom()
  {
    Object localObject = Build.MANUFACTURER;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Build.MANUFACTURER");
    localObject = (CharSequence)localObject;
    CharSequence localCharSequence = (CharSequence)"OPPO";
    boolean bool = false;
    if (!StringsKt.contains$default((CharSequence)localObject, localCharSequence, false, 2, null))
    {
      localObject = Build.MANUFACTURER;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "Build.MANUFACTURER");
      if (!StringsKt.contains$default((CharSequence)localObject, (CharSequence)"oppo", false, 2, null)) {}
    }
    else
    {
      bool = true;
    }
    return bool;
  }
  
  public final boolean checkIsVivoRom()
  {
    Object localObject = Build.MANUFACTURER;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Build.MANUFACTURER");
    localObject = (CharSequence)localObject;
    CharSequence localCharSequence = (CharSequence)"VIVO";
    boolean bool = false;
    if (!StringsKt.contains$default((CharSequence)localObject, localCharSequence, false, 2, null))
    {
      localObject = Build.MANUFACTURER;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "Build.MANUFACTURER");
      if (!StringsKt.contains$default((CharSequence)localObject, (CharSequence)"vivo", false, 2, null)) {}
    }
    else
    {
      bool = true;
    }
    return bool;
  }
  
  public final int getMiuiVersion()
  {
    String str = getSystemProperty("ro.miui.ui.version.name");
    if (str != null) {}
    try
    {
      localObject = str.substring(1);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.String).substring(startIndex)");
      int i = Integer.parseInt((String)localObject);
      return i;
    }
    catch (Exception localException)
    {
      Object localObject;
      label29:
      break label29;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("get miui version code error, version : ");
    ((StringBuilder)localObject).append(str);
    Log.e("PhoneRomUtils", ((StringBuilder)localObject).toString());
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.permission.romutils.PhoneRomUtils
 * JD-Core Version:    0.7.0.1
 */