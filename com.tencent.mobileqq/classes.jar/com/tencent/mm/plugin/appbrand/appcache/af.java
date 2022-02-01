package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.hg.f;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class af
  extends ModulePkgInfo
  implements Parcelable, Iterable<ModulePkgInfo>
{
  public static final Parcelable.Creator<af> CREATOR = new af.2();
  static af.a a;
  public int b;
  public long c;
  @Deprecated
  public boolean d;
  public final LinkedList<ModulePkgInfo> e = new LinkedList();
  @Nullable
  public ai f = null;
  private volatile transient Map<String, String> g;
  
  static
  {
    f.a("appbrandcommon", af.class.getClassLoader());
  }
  
  public af()
  {
    this.name = "__APP__";
    this.independent = true;
  }
  
  public af(Parcel paramParcel)
  {
    this();
    readFromParcel(paramParcel);
  }
  
  /* Error */
  public static String a(i parami)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 88	com/tencent/luggage/wxa/rt/i:l	()Ljava/lang/String;
    //   4: astore 4
    //   6: aload_0
    //   7: invokevirtual 88	com/tencent/luggage/wxa/rt/i:l	()Ljava/lang/String;
    //   10: invokestatic 93	com/tencent/luggage/wxa/rt/k:c	(Ljava/lang/String;)J
    //   13: lstore_2
    //   14: iconst_1
    //   15: istore_1
    //   16: ldc 95
    //   18: ldc 97
    //   20: iconst_2
    //   21: anewarray 99	java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: aload 4
    //   28: aastore
    //   29: dup
    //   30: iconst_1
    //   31: lload_2
    //   32: invokestatic 105	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   35: aastore
    //   36: invokestatic 110	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: getstatic 115	android/os/Build$VERSION:SDK_INT	I
    //   42: bipush 29
    //   44: if_icmplt +6 -> 50
    //   47: goto +5 -> 52
    //   50: iconst_0
    //   51: istore_1
    //   52: aconst_null
    //   53: astore 6
    //   55: iload_1
    //   56: ifne +34 -> 90
    //   59: aload_0
    //   60: invokevirtual 117	com/tencent/luggage/wxa/rt/i:b	()Ljava/lang/String;
    //   63: iconst_0
    //   64: invokestatic 120	com/tencent/luggage/wxa/rt/k:c	(Ljava/lang/String;Z)Ljava/lang/String;
    //   67: invokestatic 125	com/tencent/mm/plugin/appbrand/appstorage/MD5JNI:a	(Ljava/lang/String;)Ljava/lang/String;
    //   70: astore 4
    //   72: goto +21 -> 93
    //   75: astore 4
    //   77: ldc 95
    //   79: aload 4
    //   81: ldc 127
    //   83: iconst_0
    //   84: anewarray 99	java/lang/Object
    //   87: invokestatic 130	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: aconst_null
    //   91: astore 4
    //   93: aload 4
    //   95: astore 5
    //   97: aload 4
    //   99: invokestatic 136	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   102: ifeq +104 -> 206
    //   105: aload 4
    //   107: astore 5
    //   109: aload_0
    //   110: invokestatic 139	com/tencent/luggage/wxa/rt/k:a	(Lcom/tencent/luggage/wxa/rt/i;)Ljava/io/InputStream;
    //   113: astore 7
    //   115: aload 6
    //   117: astore 5
    //   119: aload 7
    //   121: sipush 16384
    //   124: invokestatic 144	com/tencent/luggage/wxa/gl/c:a	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   127: astore_0
    //   128: aload_0
    //   129: astore 5
    //   131: aload 7
    //   133: ifnull +73 -> 206
    //   136: aload_0
    //   137: astore 5
    //   139: aload 7
    //   141: invokevirtual 149	java/io/InputStream:close	()V
    //   144: aload_0
    //   145: areturn
    //   146: astore_0
    //   147: goto +9 -> 156
    //   150: astore_0
    //   151: aload_0
    //   152: astore 5
    //   154: aload_0
    //   155: athrow
    //   156: aload 7
    //   158: ifnull +29 -> 187
    //   161: aload 5
    //   163: ifnull +15 -> 178
    //   166: aload 4
    //   168: astore 5
    //   170: aload 7
    //   172: invokevirtual 149	java/io/InputStream:close	()V
    //   175: goto +12 -> 187
    //   178: aload 4
    //   180: astore 5
    //   182: aload 7
    //   184: invokevirtual 149	java/io/InputStream:close	()V
    //   187: aload 4
    //   189: astore 5
    //   191: aload_0
    //   192: athrow
    //   193: astore_0
    //   194: ldc 95
    //   196: aload_0
    //   197: ldc 151
    //   199: iconst_0
    //   200: anewarray 99	java/lang/Object
    //   203: invokestatic 130	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: aload 5
    //   208: areturn
    //   209: astore 5
    //   211: goto -24 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	parami	i
    //   15	41	1	i	int
    //   13	19	2	l	long
    //   4	67	4	str	String
    //   75	5	4	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   91	97	4	localCharSequence	java.lang.CharSequence
    //   95	112	5	localObject1	Object
    //   209	1	5	localThrowable	java.lang.Throwable
    //   53	63	6	localObject2	Object
    //   113	70	7	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   59	72	75	java/lang/UnsatisfiedLinkError
    //   119	128	146	finally
    //   154	156	146	finally
    //   119	128	150	java/lang/Throwable
    //   109	115	193	java/io/IOException
    //   139	144	193	java/io/IOException
    //   170	175	193	java/io/IOException
    //   182	187	193	java/io/IOException
    //   191	193	193	java/io/IOException
    //   170	175	209	java/lang/Throwable
  }
  
  public static void a(af.a parama)
  {
    a = parama;
  }
  
  public static String b(String paramString)
  {
    if ("__APP__".equals(paramString)) {
      return paramString;
    }
    return k.b(paramString);
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return a(new i(paramString));
  }
  
  public String a(String paramString1, String paramString2)
  {
    if ("__APP__".equals(paramString2)) {
      return paramString2;
    }
    synchronized (this.e)
    {
      if (this.g == null) {
        a(paramString1);
      }
      String str2 = (String)this.g.get(paramString2);
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = paramString2;
      }
      o.d("Luggage.WXA.WxaPkgWrappingInfo", "getModuleNameForURLFetch appId:%s, retrace module %s -> %s", new Object[] { paramString1, paramString2, str1 });
      return str1;
    }
  }
  
  void a(String paramString)
  {
    synchronized (this.e)
    {
      if ((!this.e.isEmpty()) && (this.g == null))
      {
        this.g = new ArrayMap();
        Iterator localIterator = this.e.iterator();
        while (localIterator.hasNext())
        {
          ModulePkgInfo localModulePkgInfo = (ModulePkgInfo)localIterator.next();
          localModulePkgInfo.pkgVersion = this.pkgVersion;
          String str = b(localModulePkgInfo.name);
          if (!str.equals(localModulePkgInfo.name))
          {
            o.d("Luggage.WXA.WxaPkgWrappingInfo", "setupModuleEnv, appId:%s, module mapped %s -> %s", new Object[] { paramString, localModulePkgInfo.name, str });
            this.g.put(str, localModulePkgInfo.name);
            localModulePkgInfo.name = str;
          }
        }
        o.d("Luggage.WXA.WxaPkgWrappingInfo", "setupModuleEnv, appId:%s, NameMap.size:%d", new Object[] { paramString, Integer.valueOf(this.g.size()) });
        return;
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public final void assignFrom(ModulePkgInfo paramModulePkgInfo)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    paramModulePkgInfo.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    if ((paramModulePkgInfo instanceof af)) {
      readFromParcel(localParcel);
    } else {
      super.readFromParcel(localParcel);
    }
    this.independent = true;
    localParcel.recycle();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean isAssignable(ModulePkgInfo paramModulePkgInfo)
  {
    if ((paramModulePkgInfo instanceof af)) {
      return (super.isAssignable(paramModulePkgInfo)) && (this.pkgVersion == paramModulePkgInfo.pkgVersion);
    }
    return super.isAssignable(paramModulePkgInfo);
  }
  
  @NonNull
  public Iterator<ModulePkgInfo> iterator()
  {
    return new af.1(this);
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    super.readFromParcel(paramParcel);
    this.b = paramParcel.readInt();
    this.pkgVersion = paramParcel.readInt();
    this.c = paramParcel.readLong();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.d = bool;
    paramParcel.readTypedList(this.e, ModulePkgInfo.CREATOR);
    this.f = ((ai)paramParcel.readParcelable(ai.class.getClassLoader()));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WxaPkgWrappingInfo{pkgDebugType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", pkgVersion=");
    localStringBuilder.append(this.pkgVersion);
    localStringBuilder.append(", pkgCreateTime=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", localPkg=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", md5='");
    localStringBuilder.append(this.md5);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pkgPath='");
    localStringBuilder.append(this.pkgPath);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.af
 * JD-Core Version:    0.7.0.1
 */