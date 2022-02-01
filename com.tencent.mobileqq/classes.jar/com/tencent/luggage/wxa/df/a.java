package com.tencent.luggage.wxa.df;

import android.os.Parcel;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.w;
import org.apache.commons.lang.StringUtils;

public final class a
  implements com.tencent.luggage.wxa.hp.a
{
  static w a()
  {
    return a.a.a();
  }
  
  /* Error */
  public Object a(Parcel paramParcel)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 28	android/os/Parcel:readString	()Ljava/lang/String;
    //   4: astore_3
    //   5: aload_3
    //   6: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: aload_1
    //   15: invokevirtual 28	android/os/Parcel:readString	()Ljava/lang/String;
    //   18: astore 4
    //   20: aload 4
    //   22: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifne +197 -> 222
    //   28: invokestatic 35	com/tencent/luggage/wxa/df/a:a	()Lcom/tencent/luggage/wxa/qz/w;
    //   31: astore 5
    //   33: aload 5
    //   35: aload 4
    //   37: invokevirtual 41	com/tencent/luggage/wxa/qz/w:d	(Ljava/lang/String;)[B
    //   40: astore_1
    //   41: aload_1
    //   42: ifnonnull +56 -> 98
    //   45: aload_1
    //   46: astore_2
    //   47: ldc 43
    //   49: ldc 45
    //   51: iconst_1
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: aload 5
    //   59: aastore
    //   60: invokestatic 51	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: aload 5
    //   65: aload 4
    //   67: invokevirtual 55	com/tencent/luggage/wxa/qz/w:f	(Ljava/lang/String;)V
    //   70: getstatic 60	com/tencent/luggage/wxa/qz/c:a	Z
    //   73: ifne +14 -> 87
    //   76: aload_1
    //   77: ifnull +15 -> 92
    //   80: aload_1
    //   81: arraylength
    //   82: ldc 61
    //   84: if_icmplt +8 -> 92
    //   87: aload 5
    //   89: invokevirtual 64	com/tencent/luggage/wxa/qz/w:e	()V
    //   92: aconst_null
    //   93: areturn
    //   94: astore_3
    //   95: goto +50 -> 145
    //   98: aload 5
    //   100: aload 4
    //   102: invokevirtual 55	com/tencent/luggage/wxa/qz/w:f	(Ljava/lang/String;)V
    //   105: getstatic 60	com/tencent/luggage/wxa/qz/c:a	Z
    //   108: ifne +18 -> 126
    //   111: aload_1
    //   112: astore_2
    //   113: aload_1
    //   114: ifnull +120 -> 234
    //   117: aload_1
    //   118: astore_2
    //   119: aload_1
    //   120: arraylength
    //   121: ldc 61
    //   123: if_icmplt +111 -> 234
    //   126: aload 5
    //   128: invokevirtual 64	com/tencent/luggage/wxa/qz/w:e	()V
    //   131: aload_1
    //   132: astore_2
    //   133: goto +101 -> 234
    //   136: astore_1
    //   137: aconst_null
    //   138: astore_2
    //   139: goto +52 -> 191
    //   142: astore_3
    //   143: aconst_null
    //   144: astore_1
    //   145: aload_1
    //   146: astore_2
    //   147: ldc 43
    //   149: aload_3
    //   150: ldc 66
    //   152: iconst_0
    //   153: anewarray 4	java/lang/Object
    //   156: invokestatic 69	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   159: aload 5
    //   161: aload 4
    //   163: invokevirtual 55	com/tencent/luggage/wxa/qz/w:f	(Ljava/lang/String;)V
    //   166: getstatic 60	com/tencent/luggage/wxa/qz/c:a	Z
    //   169: ifne +14 -> 183
    //   172: aload_1
    //   173: ifnull +15 -> 188
    //   176: aload_1
    //   177: arraylength
    //   178: ldc 61
    //   180: if_icmplt +8 -> 188
    //   183: aload 5
    //   185: invokevirtual 64	com/tencent/luggage/wxa/qz/w:e	()V
    //   188: aconst_null
    //   189: areturn
    //   190: astore_1
    //   191: aload 5
    //   193: aload 4
    //   195: invokevirtual 55	com/tencent/luggage/wxa/qz/w:f	(Ljava/lang/String;)V
    //   198: getstatic 60	com/tencent/luggage/wxa/qz/c:a	Z
    //   201: ifne +14 -> 215
    //   204: aload_2
    //   205: ifnull +15 -> 220
    //   208: aload_2
    //   209: arraylength
    //   210: ldc 61
    //   212: if_icmplt +8 -> 220
    //   215: aload 5
    //   217: invokevirtual 64	com/tencent/luggage/wxa/qz/w:e	()V
    //   220: aload_1
    //   221: athrow
    //   222: aload_1
    //   223: invokevirtual 73	android/os/Parcel:readInt	()I
    //   226: newarray byte
    //   228: astore_2
    //   229: aload_1
    //   230: aload_2
    //   231: invokevirtual 77	android/os/Parcel:readByteArray	([B)V
    //   234: aload_3
    //   235: invokestatic 83	org/joor/Reflect:on	(Ljava/lang/String;)Lorg/joor/Reflect;
    //   238: invokevirtual 87	org/joor/Reflect:create	()Lorg/joor/Reflect;
    //   241: invokevirtual 91	org/joor/Reflect:get	()Ljava/lang/Object;
    //   244: checkcast 93	com/tencent/luggage/wxa/qu/a
    //   247: astore_1
    //   248: aload_1
    //   249: aload_2
    //   250: invokevirtual 96	com/tencent/luggage/wxa/qu/a:a	([B)Lcom/tencent/luggage/wxa/qu/a;
    //   253: pop
    //   254: aload_1
    //   255: areturn
    //   256: astore_1
    //   257: ldc 43
    //   259: ldc 98
    //   261: iconst_1
    //   262: anewarray 4	java/lang/Object
    //   265: dup
    //   266: iconst_0
    //   267: aload_1
    //   268: aastore
    //   269: invokestatic 51	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   272: aconst_null
    //   273: areturn
    //   274: astore_1
    //   275: aconst_null
    //   276: areturn
    //   277: astore_2
    //   278: aload_1
    //   279: astore_2
    //   280: goto -46 -> 234
    //   283: astore_1
    //   284: aconst_null
    //   285: areturn
    //   286: astore_2
    //   287: goto -67 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	a
    //   0	290	1	paramParcel	Parcel
    //   46	204	2	localObject	Object
    //   277	1	2	localThrowable1	Throwable
    //   279	1	2	localParcel	Parcel
    //   286	1	2	localThrowable2	Throwable
    //   4	2	3	str1	String
    //   94	1	3	localThrowable3	Throwable
    //   142	93	3	localThrowable4	Throwable
    //   18	176	4	str2	String
    //   31	185	5	localw	w
    // Exception table:
    //   from	to	target	type
    //   47	63	94	java/lang/Throwable
    //   33	41	136	finally
    //   33	41	142	java/lang/Throwable
    //   47	63	190	finally
    //   147	159	190	finally
    //   234	254	256	java/lang/Exception
    //   63	76	274	java/lang/Throwable
    //   80	87	274	java/lang/Throwable
    //   87	92	274	java/lang/Throwable
    //   98	111	277	java/lang/Throwable
    //   119	126	277	java/lang/Throwable
    //   126	131	277	java/lang/Throwable
    //   159	172	283	java/lang/Throwable
    //   176	183	283	java/lang/Throwable
    //   183	188	283	java/lang/Throwable
    //   191	204	286	java/lang/Throwable
    //   208	215	286	java/lang/Throwable
    //   215	220	286	java/lang/Throwable
  }
  
  public void a(@NonNull Object paramObject, Parcel paramParcel)
  {
    if (paramObject == null)
    {
      paramParcel.writeString(null);
      return;
    }
    Object localObject = (com.tencent.luggage.wxa.qu.a)paramObject;
    paramParcel.writeString(localObject.getClass().getName());
    int j = 0;
    byte[] arrayOfByte;
    try
    {
      localObject = ((com.tencent.luggage.wxa.qu.a)localObject).b();
    }
    catch (Exception localException)
    {
      o.b("MicroMsg.XIPC.MMProtoBufTransfer", "writeToParcel, e = %s", new Object[] { localException });
      arrayOfByte = new byte[0];
    }
    w localw = a();
    int i;
    if (arrayOfByte.length <= 102400)
    {
      i = j;
      if (c.a)
      {
        i = j;
        if (arrayOfByte.length <= 0) {}
      }
    }
    else
    {
      i = j;
      if (localw != null) {
        try
        {
          long l = localw.c();
          if (l >= 20971520L)
          {
            o.b("MicroMsg.XIPC.MMProtoBufTransfer", "mmkv totalSize[%d] too large, skip use mmkv", new Object[] { Long.valueOf(l) });
            i = j;
          }
          else
          {
            String str1 = r.c();
            String str2 = paramObject.getClass().getName();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramObject.hashCode());
            localStringBuilder.append("");
            paramObject = localStringBuilder.toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(SystemClock.elapsedRealtimeNanos());
            localStringBuilder.append("");
            paramObject = StringUtils.join(new String[] { str1, str2, paramObject, localStringBuilder.toString() }, "$");
            localw.a(paramObject, arrayOfByte);
            i = j;
            if (localw.e(paramObject))
            {
              paramParcel.writeString(paramObject);
              i = 1;
            }
          }
        }
        catch (Throwable paramObject)
        {
          o.a("MicroMsg.XIPC.MMProtoBufTransfer", paramObject, "encode bytes to mmkv", new Object[0]);
          i = j;
        }
      }
    }
    if (i == 0)
    {
      paramParcel.writeString(null);
      paramParcel.writeInt(arrayOfByte.length);
      paramParcel.writeByteArray(arrayOfByte);
    }
  }
  
  public boolean a(Object paramObject)
  {
    return paramObject instanceof com.tencent.luggage.wxa.qu.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.df.a
 * JD-Core Version:    0.7.0.1
 */