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
    int i;
    try
    {
      String str1 = getSystemProperty("ro.build.version.emui");
      if (str1 == null) {
        Intrinsics.throwNpe();
      }
      i = StringsKt.indexOf$default((CharSequence)str1, "_", 0, false, 6, null);
      if (str1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return 4.0D;
    }
    String str2 = localException.substring(i + 1);
    Intrinsics.checkExpressionValueIsNotNull(str2, "(this as java.lang.String).substring(startIndex)");
    double d = Double.parseDouble(str2);
    return d;
  }
  
  /* Error */
  @JvmStatic
  @org.jetbrains.annotations.Nullable
  public static final String getSystemProperty(@org.jetbrains.annotations.NotNull String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: ldc 102
    //   5: invokestatic 105	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   8: aconst_null
    //   9: checkcast 107	java/io/BufferedReader
    //   12: astore_2
    //   13: invokestatic 113	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   16: new 115	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   23: ldc 118
    //   25: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokevirtual 130	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   38: astore_1
    //   39: aload_1
    //   40: ldc 132
    //   42: invokestatic 90	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   45: new 107	java/io/BufferedReader
    //   48: dup
    //   49: new 134	java/io/InputStreamReader
    //   52: dup
    //   53: aload_1
    //   54: invokevirtual 140	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   57: invokespecial 143	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   60: checkcast 145	java/io/Reader
    //   63: sipush 1024
    //   66: invokespecial 148	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   69: astore_1
    //   70: aload_1
    //   71: invokevirtual 151	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   74: astore_2
    //   75: aload_2
    //   76: ldc 153
    //   78: invokestatic 90	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   81: aload_1
    //   82: invokevirtual 156	java/io/BufferedReader:close	()V
    //   85: aload_1
    //   86: invokevirtual 156	java/io/BufferedReader:close	()V
    //   89: aload_2
    //   90: astore_0
    //   91: aload_0
    //   92: areturn
    //   93: astore_0
    //   94: ldc 34
    //   96: ldc 158
    //   98: aload_0
    //   99: checkcast 160	java/lang/Throwable
    //   102: invokestatic 166	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   105: pop
    //   106: goto -17 -> 89
    //   109: astore 4
    //   111: aload_2
    //   112: astore_1
    //   113: aload 4
    //   115: astore_2
    //   116: ldc 34
    //   118: new 115	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   125: ldc 168
    //   127: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_0
    //   131: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: aload_2
    //   138: checkcast 160	java/lang/Throwable
    //   141: invokestatic 166	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   144: pop
    //   145: aload_3
    //   146: astore_0
    //   147: aload_1
    //   148: ifnull -57 -> 91
    //   151: aload_1
    //   152: invokevirtual 156	java/io/BufferedReader:close	()V
    //   155: aconst_null
    //   156: areturn
    //   157: astore_0
    //   158: ldc 34
    //   160: ldc 158
    //   162: aload_0
    //   163: checkcast 160	java/lang/Throwable
    //   166: invokestatic 166	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   169: pop
    //   170: aconst_null
    //   171: areturn
    //   172: astore_1
    //   173: aload_2
    //   174: astore_0
    //   175: aload_0
    //   176: ifnull +7 -> 183
    //   179: aload_0
    //   180: invokevirtual 156	java/io/BufferedReader:close	()V
    //   183: aload_1
    //   184: athrow
    //   185: astore_0
    //   186: ldc 34
    //   188: ldc 158
    //   190: aload_0
    //   191: checkcast 160	java/lang/Throwable
    //   194: invokestatic 166	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   197: pop
    //   198: goto -15 -> 183
    //   201: astore_2
    //   202: aload_1
    //   203: astore_0
    //   204: aload_2
    //   205: astore_1
    //   206: goto -31 -> 175
    //   209: astore_2
    //   210: aload_1
    //   211: astore_0
    //   212: aload_2
    //   213: astore_1
    //   214: goto -39 -> 175
    //   217: astore_2
    //   218: goto -102 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	paramString	String
    //   38	114	1	localObject1	Object
    //   172	31	1	localObject2	Object
    //   205	9	1	localObject3	Object
    //   12	162	2	localObject4	Object
    //   201	4	2	localObject5	Object
    //   209	4	2	localObject6	Object
    //   217	1	2	localIOException1	java.io.IOException
    //   1	145	3	localObject7	Object
    //   109	5	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   85	89	93	java/io/IOException
    //   13	70	109	java/io/IOException
    //   151	155	157	java/io/IOException
    //   13	70	172	finally
    //   179	183	185	java/io/IOException
    //   70	85	201	finally
    //   116	145	209	finally
    //   70	85	217	java/io/IOException
  }
  
  public final boolean checkIs360Rom()
  {
    String str = Build.MANUFACTURER;
    Intrinsics.checkExpressionValueIsNotNull(str, "Build.MANUFACTURER");
    if (!StringsKt.contains$default((CharSequence)str, (CharSequence)"QiKU", false, 2, null))
    {
      str = Build.MANUFACTURER;
      Intrinsics.checkExpressionValueIsNotNull(str, "Build.MANUFACTURER");
    }
    return StringsKt.contains$default((CharSequence)str, (CharSequence)"360", false, 2, null);
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
    if (TextUtils.isEmpty((CharSequence)str)) {
      return false;
    }
    if (str == null) {
      Intrinsics.throwNpe();
    }
    if (!StringsKt.contains$default((CharSequence)str, (CharSequence)"flyme", false, 2, null))
    {
      str = str.toLowerCase();
      Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).toLowerCase()");
    }
    return StringsKt.contains$default((CharSequence)str, (CharSequence)"flyme", false, 2, null);
  }
  
  public final boolean checkIsMiuiRom()
  {
    return !TextUtils.isEmpty((CharSequence)getSystemProperty("ro.miui.ui.version.name"));
  }
  
  public final boolean checkIsOppoRom()
  {
    String str = Build.MANUFACTURER;
    Intrinsics.checkExpressionValueIsNotNull(str, "Build.MANUFACTURER");
    if (!StringsKt.contains$default((CharSequence)str, (CharSequence)"OPPO", false, 2, null))
    {
      str = Build.MANUFACTURER;
      Intrinsics.checkExpressionValueIsNotNull(str, "Build.MANUFACTURER");
    }
    return StringsKt.contains$default((CharSequence)str, (CharSequence)"oppo", false, 2, null);
  }
  
  public final boolean checkIsVivoRom()
  {
    String str = Build.MANUFACTURER;
    Intrinsics.checkExpressionValueIsNotNull(str, "Build.MANUFACTURER");
    if (!StringsKt.contains$default((CharSequence)str, (CharSequence)"VIVO", false, 2, null))
    {
      str = Build.MANUFACTURER;
      Intrinsics.checkExpressionValueIsNotNull(str, "Build.MANUFACTURER");
    }
    return StringsKt.contains$default((CharSequence)str, (CharSequence)"vivo", false, 2, null);
  }
  
  public final int getMiuiVersion()
  {
    String str1 = getSystemProperty("ro.miui.ui.version.name");
    if (str1 != null) {
      try
      {
        String str2 = str1.substring(1);
        Intrinsics.checkExpressionValueIsNotNull(str2, "(this as java.lang.String).substring(startIndex)");
        int i = Integer.parseInt(str2);
        return i;
      }
      catch (Exception localException)
      {
        Log.e("PhoneRomUtils", "get miui version code error, version : " + str1);
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.permission.romutils.PhoneRomUtils
 * JD-Core Version:    0.7.0.1
 */