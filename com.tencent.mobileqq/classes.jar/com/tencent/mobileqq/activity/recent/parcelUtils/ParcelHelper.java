package com.tencent.mobileqq.activity.recent.parcelUtils;

import ajib;
import ajic;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class ParcelHelper
{
  public static ArrayList<Field> a(Object paramObject)
  {
    paramObject = paramObject.getClass();
    ArrayList localArrayList = new ArrayList(16);
    if (paramObject != Object.class) {}
    for (;;)
    {
      int i;
      try
      {
        Field[] arrayOfField = paramObject.getDeclaredFields();
        int j = arrayOfField.length;
        i = 0;
        if (i < j)
        {
          Field localField = arrayOfField[i];
          if ((((localField.getModifiers() & 0x10) != 0) && ((localField.getModifiers() & 0x8) != 0)) || (localField.isAnnotationPresent(ajib.class)) || (("$jacocoData".endsWith(localField.getName())) && (localField.getType() == [Z.class))) {
            break label153;
          }
          localField.setAccessible(true);
          localArrayList.add(localField);
        }
      }
      catch (Exception localException)
      {
        QLog.d("ParcelHelper", 2, new Object[] { "cls null error", localException.getStackTrace() });
        paramObject = paramObject.getSuperclass();
      }
      break;
      return localArrayList;
      label153:
      i += 1;
    }
  }
  
  private static void a(Object paramObject)
  {
    if (!paramObject.getClass().isAnnotationPresent(ajic.class)) {
      throw new RuntimeException("Object to Parcel must describe @ParcelObject");
    }
  }
  
  /* Error */
  public static boolean a(Object paramObject, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +25 -> 28
    //   6: ldc 63
    //   8: iconst_2
    //   9: iconst_2
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: ldc 103
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: aload_0
    //   21: invokevirtual 12	java/lang/Object:getClass	()Ljava/lang/Class;
    //   24: aastore
    //   25: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   28: aconst_null
    //   29: astore_3
    //   30: aconst_null
    //   31: astore 5
    //   33: invokestatic 109	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   36: astore 4
    //   38: aload 4
    //   40: astore 5
    //   42: aload 4
    //   44: astore_3
    //   45: aload 4
    //   47: aload_1
    //   48: iconst_0
    //   49: aload_1
    //   50: arraylength
    //   51: invokevirtual 113	android/os/Parcel:unmarshall	([BII)V
    //   54: aload 4
    //   56: astore 5
    //   58: aload 4
    //   60: astore_3
    //   61: aload 4
    //   63: iconst_0
    //   64: invokevirtual 116	android/os/Parcel:setDataPosition	(I)V
    //   67: aload 4
    //   69: astore 5
    //   71: aload 4
    //   73: astore_3
    //   74: aload 4
    //   76: invokevirtual 119	android/os/Parcel:readInt	()I
    //   79: istore_2
    //   80: sipush 147
    //   83: iload_2
    //   84: if_icmpeq +62 -> 146
    //   87: aload 4
    //   89: astore 5
    //   91: aload 4
    //   93: astore_3
    //   94: ldc 63
    //   96: iconst_1
    //   97: iconst_2
    //   98: anewarray 4	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: ldc 121
    //   105: aastore
    //   106: dup
    //   107: iconst_1
    //   108: iload_2
    //   109: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   112: aastore
    //   113: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   116: aload 4
    //   118: ifnull +8 -> 126
    //   121: aload 4
    //   123: invokevirtual 131	android/os/Parcel:recycle	()V
    //   126: iconst_0
    //   127: ireturn
    //   128: astore_0
    //   129: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq -6 -> 126
    //   135: ldc 63
    //   137: iconst_2
    //   138: ldc 133
    //   140: aload_0
    //   141: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   144: iconst_0
    //   145: ireturn
    //   146: aload 4
    //   148: astore 5
    //   150: aload 4
    //   152: astore_3
    //   153: aload_0
    //   154: invokestatic 138	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper:a	(Ljava/lang/Object;)V
    //   157: aload 4
    //   159: astore 5
    //   161: aload 4
    //   163: astore_3
    //   164: aload 4
    //   166: invokevirtual 141	android/os/Parcel:readString	()Ljava/lang/String;
    //   169: astore_1
    //   170: aload 4
    //   172: astore 5
    //   174: aload 4
    //   176: astore_3
    //   177: aload_0
    //   178: invokevirtual 12	java/lang/Object:getClass	()Ljava/lang/Class;
    //   181: invokevirtual 142	java/lang/Class:getName	()Ljava/lang/String;
    //   184: aload_1
    //   185: invokevirtual 145	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   188: ifne +74 -> 262
    //   191: aload 4
    //   193: astore 5
    //   195: aload 4
    //   197: astore_3
    //   198: ldc 63
    //   200: iconst_1
    //   201: iconst_4
    //   202: anewarray 4	java/lang/Object
    //   205: dup
    //   206: iconst_0
    //   207: ldc 147
    //   209: aastore
    //   210: dup
    //   211: iconst_1
    //   212: aload_1
    //   213: aastore
    //   214: dup
    //   215: iconst_2
    //   216: ldc 149
    //   218: aastore
    //   219: dup
    //   220: iconst_3
    //   221: aload_0
    //   222: invokevirtual 12	java/lang/Object:getClass	()Ljava/lang/Class;
    //   225: invokevirtual 142	java/lang/Class:getName	()Ljava/lang/String;
    //   228: aastore
    //   229: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   232: aload 4
    //   234: ifnull -108 -> 126
    //   237: aload 4
    //   239: invokevirtual 131	android/os/Parcel:recycle	()V
    //   242: iconst_0
    //   243: ireturn
    //   244: astore_0
    //   245: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq -122 -> 126
    //   251: ldc 63
    //   253: iconst_2
    //   254: ldc 133
    //   256: aload_0
    //   257: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   260: iconst_0
    //   261: ireturn
    //   262: aload 4
    //   264: astore 5
    //   266: aload 4
    //   268: astore_3
    //   269: aload_0
    //   270: invokestatic 151	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper:a	(Ljava/lang/Object;)Ljava/util/ArrayList;
    //   273: astore_1
    //   274: aload 4
    //   276: astore 5
    //   278: aload 4
    //   280: astore_3
    //   281: aload_0
    //   282: invokestatic 156	ajif:a	(Ljava/lang/Object;)Lajid;
    //   285: aload_0
    //   286: aload 4
    //   288: aload_1
    //   289: invokevirtual 161	ajid:a	(Ljava/lang/Object;Landroid/os/Parcel;Ljava/util/ArrayList;)V
    //   292: aload 4
    //   294: ifnull +8 -> 302
    //   297: aload 4
    //   299: invokevirtual 131	android/os/Parcel:recycle	()V
    //   302: iconst_1
    //   303: ireturn
    //   304: astore_0
    //   305: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   308: ifeq -6 -> 302
    //   311: ldc 63
    //   313: iconst_2
    //   314: ldc 133
    //   316: aload_0
    //   317: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   320: goto -18 -> 302
    //   323: astore_1
    //   324: aconst_null
    //   325: astore_0
    //   326: aload_1
    //   327: athrow
    //   328: astore_1
    //   329: aload_0
    //   330: astore_3
    //   331: aload_1
    //   332: astore_0
    //   333: aload_3
    //   334: ifnull +7 -> 341
    //   337: aload_3
    //   338: invokevirtual 131	android/os/Parcel:recycle	()V
    //   341: aload_0
    //   342: athrow
    //   343: astore_0
    //   344: aload 5
    //   346: astore_3
    //   347: ldc 63
    //   349: iconst_1
    //   350: ldc 163
    //   352: aload_0
    //   353: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   356: aload 5
    //   358: ifnull -232 -> 126
    //   361: aload 5
    //   363: invokevirtual 131	android/os/Parcel:recycle	()V
    //   366: iconst_0
    //   367: ireturn
    //   368: astore_0
    //   369: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   372: ifeq -246 -> 126
    //   375: ldc 63
    //   377: iconst_2
    //   378: ldc 133
    //   380: aload_0
    //   381: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   384: iconst_0
    //   385: ireturn
    //   386: astore_1
    //   387: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   390: ifeq -49 -> 341
    //   393: ldc 63
    //   395: iconst_2
    //   396: ldc 133
    //   398: aload_1
    //   399: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   402: goto -61 -> 341
    //   405: astore_0
    //   406: goto -73 -> 333
    //   409: astore_1
    //   410: aload 4
    //   412: astore_0
    //   413: goto -87 -> 326
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	paramObject	Object
    //   0	416	1	paramArrayOfByte	byte[]
    //   79	30	2	i	int
    //   29	318	3	localObject1	Object
    //   36	375	4	localParcel	android.os.Parcel
    //   31	331	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   121	126	128	java/lang/Throwable
    //   237	242	244	java/lang/Throwable
    //   297	302	304	java/lang/Throwable
    //   33	38	323	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$FieldChangedException
    //   326	328	328	finally
    //   33	38	343	java/lang/Throwable
    //   45	54	343	java/lang/Throwable
    //   61	67	343	java/lang/Throwable
    //   74	80	343	java/lang/Throwable
    //   94	116	343	java/lang/Throwable
    //   153	157	343	java/lang/Throwable
    //   164	170	343	java/lang/Throwable
    //   177	191	343	java/lang/Throwable
    //   198	232	343	java/lang/Throwable
    //   269	274	343	java/lang/Throwable
    //   281	292	343	java/lang/Throwable
    //   361	366	368	java/lang/Throwable
    //   337	341	386	java/lang/Throwable
    //   33	38	405	finally
    //   45	54	405	finally
    //   61	67	405	finally
    //   74	80	405	finally
    //   94	116	405	finally
    //   153	157	405	finally
    //   164	170	405	finally
    //   177	191	405	finally
    //   198	232	405	finally
    //   269	274	405	finally
    //   281	292	405	finally
    //   347	356	405	finally
    //   45	54	409	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$FieldChangedException
    //   61	67	409	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$FieldChangedException
    //   74	80	409	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$FieldChangedException
    //   94	116	409	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$FieldChangedException
    //   153	157	409	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$FieldChangedException
    //   164	170	409	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$FieldChangedException
    //   177	191	409	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$FieldChangedException
    //   198	232	409	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$FieldChangedException
    //   269	274	409	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$FieldChangedException
    //   281	292	409	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$FieldChangedException
  }
  
  /* Error */
  public static byte[] a(Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 109	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore_1
    //   6: aload_1
    //   7: astore_2
    //   8: aload_1
    //   9: iconst_0
    //   10: invokevirtual 116	android/os/Parcel:setDataPosition	(I)V
    //   13: aload_1
    //   14: astore_2
    //   15: aload_1
    //   16: sipush 147
    //   19: invokevirtual 169	android/os/Parcel:writeInt	(I)V
    //   22: aload_1
    //   23: astore_2
    //   24: aload_0
    //   25: invokestatic 138	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper:a	(Ljava/lang/Object;)V
    //   28: aload_1
    //   29: astore_2
    //   30: aload_1
    //   31: aload_0
    //   32: invokevirtual 12	java/lang/Object:getClass	()Ljava/lang/Class;
    //   35: invokevirtual 142	java/lang/Class:getName	()Ljava/lang/String;
    //   38: invokevirtual 172	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   41: aload_1
    //   42: astore_2
    //   43: aload_0
    //   44: invokestatic 151	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper:a	(Ljava/lang/Object;)Ljava/util/ArrayList;
    //   47: astore 4
    //   49: aload_1
    //   50: astore_2
    //   51: aload_0
    //   52: invokestatic 156	ajif:a	(Ljava/lang/Object;)Lajid;
    //   55: aload_0
    //   56: aload 4
    //   58: aload_1
    //   59: invokevirtual 175	ajid:a	(Ljava/lang/Object;Ljava/util/ArrayList;Landroid/os/Parcel;)Z
    //   62: pop
    //   63: aload_1
    //   64: astore_2
    //   65: aload_1
    //   66: invokevirtual 179	android/os/Parcel:marshall	()[B
    //   69: astore 4
    //   71: aload 4
    //   73: astore_0
    //   74: aload_0
    //   75: astore_2
    //   76: aload_1
    //   77: ifnull +9 -> 86
    //   80: aload_1
    //   81: invokevirtual 131	android/os/Parcel:recycle	()V
    //   84: aload_0
    //   85: astore_2
    //   86: aload_2
    //   87: areturn
    //   88: astore_0
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: astore_2
    //   93: aload_0
    //   94: athrow
    //   95: astore_0
    //   96: aload_2
    //   97: ifnull +7 -> 104
    //   100: aload_2
    //   101: invokevirtual 131	android/os/Parcel:recycle	()V
    //   104: aload_0
    //   105: athrow
    //   106: astore_2
    //   107: aconst_null
    //   108: astore_1
    //   109: aload_0
    //   110: ifnull +51 -> 161
    //   113: aload_0
    //   114: invokevirtual 12	java/lang/Object:getClass	()Ljava/lang/Class;
    //   117: astore_0
    //   118: ldc 63
    //   120: iconst_1
    //   121: iconst_4
    //   122: anewarray 4	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: ldc 181
    //   129: aastore
    //   130: dup
    //   131: iconst_1
    //   132: aload_0
    //   133: aastore
    //   134: dup
    //   135: iconst_2
    //   136: ldc 183
    //   138: aastore
    //   139: dup
    //   140: iconst_3
    //   141: aload_2
    //   142: aastore
    //   143: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   146: aload_3
    //   147: astore_2
    //   148: aload_1
    //   149: ifnull -63 -> 86
    //   152: aload_1
    //   153: invokevirtual 131	android/os/Parcel:recycle	()V
    //   156: aconst_null
    //   157: areturn
    //   158: astore_0
    //   159: aconst_null
    //   160: areturn
    //   161: ldc 185
    //   163: astore_0
    //   164: goto -46 -> 118
    //   167: astore_1
    //   168: aload_0
    //   169: areturn
    //   170: astore_1
    //   171: goto -67 -> 104
    //   174: astore_0
    //   175: aconst_null
    //   176: astore_2
    //   177: goto -81 -> 96
    //   180: astore_0
    //   181: aload_1
    //   182: astore_2
    //   183: goto -87 -> 96
    //   186: astore_2
    //   187: goto -78 -> 109
    //   190: astore_0
    //   191: goto -100 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramObject	Object
    //   5	148	1	localParcel	android.os.Parcel
    //   167	1	1	localThrowable1	java.lang.Throwable
    //   170	12	1	localThrowable2	java.lang.Throwable
    //   7	94	2	localObject1	Object
    //   106	36	2	localThrowable3	java.lang.Throwable
    //   147	36	2	localObject2	Object
    //   186	1	2	localThrowable4	java.lang.Throwable
    //   1	146	3	localObject3	Object
    //   47	25	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	88	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$UnsupportedFieldTypeException
    //   8	13	95	finally
    //   15	22	95	finally
    //   24	28	95	finally
    //   30	41	95	finally
    //   43	49	95	finally
    //   51	63	95	finally
    //   65	71	95	finally
    //   93	95	95	finally
    //   2	6	106	java/lang/Throwable
    //   152	156	158	java/lang/Throwable
    //   80	84	167	java/lang/Throwable
    //   100	104	170	java/lang/Throwable
    //   2	6	174	finally
    //   113	118	180	finally
    //   118	146	180	finally
    //   8	13	186	java/lang/Throwable
    //   15	22	186	java/lang/Throwable
    //   24	28	186	java/lang/Throwable
    //   30	41	186	java/lang/Throwable
    //   43	49	186	java/lang/Throwable
    //   51	63	186	java/lang/Throwable
    //   65	71	186	java/lang/Throwable
    //   8	13	190	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$UnsupportedFieldTypeException
    //   15	22	190	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$UnsupportedFieldTypeException
    //   24	28	190	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$UnsupportedFieldTypeException
    //   30	41	190	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$UnsupportedFieldTypeException
    //   43	49	190	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$UnsupportedFieldTypeException
    //   51	63	190	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$UnsupportedFieldTypeException
    //   65	71	190	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$UnsupportedFieldTypeException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.parcelUtils.ParcelHelper
 * JD-Core Version:    0.7.0.1
 */