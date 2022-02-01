package com.tencent.mobileqq.activity.recent.parcelUtils;

import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation.NotParcel;
import com.tencent.mobileqq.activity.recent.parcelUtils.annotation.ParcelAnnotation.ParcelObject;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class ParcelHelper
{
  public static ArrayList<Field> a(Object paramObject)
  {
    paramObject = paramObject.getClass();
    ArrayList localArrayList = new ArrayList(16);
    for (;;)
    {
      if (paramObject != Object.class) {
        try
        {
          Field[] arrayOfField = paramObject.getDeclaredFields();
          int j = arrayOfField.length;
          int i = 0;
          while (i < j)
          {
            Field localField = arrayOfField[i];
            if ((((localField.getModifiers() & 0x10) == 0) || ((localField.getModifiers() & 0x8) == 0)) && (!localField.isAnnotationPresent(ParcelAnnotation.NotParcel.class)) && ((!"$jacocoData".endsWith(localField.getName())) || (localField.getType() != [Z.class)))
            {
              localField.setAccessible(true);
              localArrayList.add(localField);
            }
            i += 1;
          }
        }
        catch (Exception localException)
        {
          QLog.d("ParcelHelper", 2, new Object[] { "cls null error", localException.getStackTrace() });
          paramObject = paramObject.getSuperclass();
        }
      }
    }
    return localArrayList;
  }
  
  private static void a(Object paramObject)
  {
    if (paramObject.getClass().isAnnotationPresent(ParcelAnnotation.ParcelObject.class)) {
      return;
    }
    throw new RuntimeException("Object to Parcel must describe @ParcelObject");
  }
  
  /* Error */
  public static boolean a(Object paramObject, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +25 -> 28
    //   6: ldc 67
    //   8: iconst_2
    //   9: iconst_2
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: ldc 106
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: aload_0
    //   21: invokevirtual 17	java/lang/Object:getClass	()Ljava/lang/Class;
    //   24: aastore
    //   25: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   28: aconst_null
    //   29: astore 4
    //   31: aconst_null
    //   32: astore 5
    //   34: aconst_null
    //   35: astore_3
    //   36: invokestatic 112	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   39: astore 6
    //   41: aload 6
    //   43: astore_3
    //   44: aload 6
    //   46: astore 4
    //   48: aload 6
    //   50: astore 5
    //   52: aload 6
    //   54: aload_1
    //   55: iconst_0
    //   56: aload_1
    //   57: arraylength
    //   58: invokevirtual 116	android/os/Parcel:unmarshall	([BII)V
    //   61: aload 6
    //   63: astore_3
    //   64: aload 6
    //   66: astore 4
    //   68: aload 6
    //   70: astore 5
    //   72: aload 6
    //   74: iconst_0
    //   75: invokevirtual 119	android/os/Parcel:setDataPosition	(I)V
    //   78: aload 6
    //   80: astore_3
    //   81: aload 6
    //   83: astore 4
    //   85: aload 6
    //   87: astore 5
    //   89: aload 6
    //   91: invokevirtual 122	android/os/Parcel:readInt	()I
    //   94: istore_2
    //   95: sipush 147
    //   98: iload_2
    //   99: if_icmpeq +66 -> 165
    //   102: aload 6
    //   104: astore_3
    //   105: aload 6
    //   107: astore 4
    //   109: aload 6
    //   111: astore 5
    //   113: ldc 67
    //   115: iconst_1
    //   116: iconst_2
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: ldc 124
    //   124: aastore
    //   125: dup
    //   126: iconst_1
    //   127: iload_2
    //   128: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   131: aastore
    //   132: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   135: aload 6
    //   137: ifnull +26 -> 163
    //   140: aload 6
    //   142: invokevirtual 133	android/os/Parcel:recycle	()V
    //   145: iconst_0
    //   146: ireturn
    //   147: astore_0
    //   148: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +12 -> 163
    //   154: ldc 67
    //   156: iconst_2
    //   157: ldc 135
    //   159: aload_0
    //   160: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   163: iconst_0
    //   164: ireturn
    //   165: aload 6
    //   167: astore_3
    //   168: aload 6
    //   170: astore 4
    //   172: aload 6
    //   174: astore 5
    //   176: aload_0
    //   177: invokestatic 140	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper:a	(Ljava/lang/Object;)V
    //   180: aload 6
    //   182: astore_3
    //   183: aload 6
    //   185: astore 4
    //   187: aload 6
    //   189: astore 5
    //   191: aload 6
    //   193: invokevirtual 143	android/os/Parcel:readString	()Ljava/lang/String;
    //   196: astore_1
    //   197: aload 6
    //   199: astore_3
    //   200: aload 6
    //   202: astore 4
    //   204: aload 6
    //   206: astore 5
    //   208: aload_0
    //   209: invokevirtual 17	java/lang/Object:getClass	()Ljava/lang/Class;
    //   212: invokevirtual 144	java/lang/Class:getName	()Ljava/lang/String;
    //   215: aload_1
    //   216: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   219: ifne +78 -> 297
    //   222: aload 6
    //   224: astore_3
    //   225: aload 6
    //   227: astore 4
    //   229: aload 6
    //   231: astore 5
    //   233: ldc 67
    //   235: iconst_1
    //   236: iconst_4
    //   237: anewarray 4	java/lang/Object
    //   240: dup
    //   241: iconst_0
    //   242: ldc 149
    //   244: aastore
    //   245: dup
    //   246: iconst_1
    //   247: aload_1
    //   248: aastore
    //   249: dup
    //   250: iconst_2
    //   251: ldc 151
    //   253: aastore
    //   254: dup
    //   255: iconst_3
    //   256: aload_0
    //   257: invokevirtual 17	java/lang/Object:getClass	()Ljava/lang/Class;
    //   260: invokevirtual 144	java/lang/Class:getName	()Ljava/lang/String;
    //   263: aastore
    //   264: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   267: aload 6
    //   269: ifnull +26 -> 295
    //   272: aload 6
    //   274: invokevirtual 133	android/os/Parcel:recycle	()V
    //   277: iconst_0
    //   278: ireturn
    //   279: astore_0
    //   280: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   283: ifeq +12 -> 295
    //   286: ldc 67
    //   288: iconst_2
    //   289: ldc 135
    //   291: aload_0
    //   292: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   295: iconst_0
    //   296: ireturn
    //   297: aload 6
    //   299: astore_3
    //   300: aload 6
    //   302: astore 4
    //   304: aload 6
    //   306: astore 5
    //   308: aload_0
    //   309: invokestatic 153	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper:a	(Ljava/lang/Object;)Ljava/util/ArrayList;
    //   312: astore_1
    //   313: aload 6
    //   315: astore_3
    //   316: aload 6
    //   318: astore 4
    //   320: aload 6
    //   322: astore 5
    //   324: aload_0
    //   325: invokestatic 158	com/tencent/mobileqq/activity/recent/parcelUtils/processor/ParcelProcessorFactory:a	(Ljava/lang/Object;)Lcom/tencent/mobileqq/activity/recent/parcelUtils/processor/BaseParcelProcessor;
    //   328: aload_0
    //   329: aload 6
    //   331: aload_1
    //   332: invokevirtual 163	com/tencent/mobileqq/activity/recent/parcelUtils/processor/BaseParcelProcessor:a	(Ljava/lang/Object;Landroid/os/Parcel;Ljava/util/ArrayList;)V
    //   335: aload 6
    //   337: ifnull +26 -> 363
    //   340: aload 6
    //   342: invokevirtual 133	android/os/Parcel:recycle	()V
    //   345: iconst_1
    //   346: ireturn
    //   347: astore_0
    //   348: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   351: ifeq +12 -> 363
    //   354: ldc 67
    //   356: iconst_2
    //   357: ldc 135
    //   359: aload_0
    //   360: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   363: iconst_1
    //   364: ireturn
    //   365: astore_0
    //   366: goto +52 -> 418
    //   369: astore_0
    //   370: aload 4
    //   372: astore_3
    //   373: ldc 67
    //   375: iconst_1
    //   376: ldc 165
    //   378: aload_0
    //   379: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   382: aload 4
    //   384: ifnull +26 -> 410
    //   387: aload 4
    //   389: invokevirtual 133	android/os/Parcel:recycle	()V
    //   392: iconst_0
    //   393: ireturn
    //   394: astore_0
    //   395: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   398: ifeq +12 -> 410
    //   401: ldc 67
    //   403: iconst_2
    //   404: ldc 135
    //   406: aload_0
    //   407: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   410: iconst_0
    //   411: ireturn
    //   412: astore_0
    //   413: aload 5
    //   415: astore_3
    //   416: aload_0
    //   417: athrow
    //   418: aload_3
    //   419: ifnull +26 -> 445
    //   422: aload_3
    //   423: invokevirtual 133	android/os/Parcel:recycle	()V
    //   426: goto +19 -> 445
    //   429: astore_1
    //   430: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   433: ifeq +12 -> 445
    //   436: ldc 67
    //   438: iconst_2
    //   439: ldc 135
    //   441: aload_1
    //   442: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   445: aload_0
    //   446: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	447	0	paramObject	Object
    //   0	447	1	paramArrayOfByte	byte[]
    //   94	34	2	i	int
    //   35	388	3	localObject1	Object
    //   29	359	4	localObject2	Object
    //   32	382	5	localObject3	Object
    //   39	302	6	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   140	145	147	java/lang/Throwable
    //   272	277	279	java/lang/Throwable
    //   340	345	347	java/lang/Throwable
    //   36	41	365	finally
    //   52	61	365	finally
    //   72	78	365	finally
    //   89	95	365	finally
    //   113	135	365	finally
    //   176	180	365	finally
    //   191	197	365	finally
    //   208	222	365	finally
    //   233	267	365	finally
    //   308	313	365	finally
    //   324	335	365	finally
    //   373	382	365	finally
    //   416	418	365	finally
    //   36	41	369	java/lang/Throwable
    //   52	61	369	java/lang/Throwable
    //   72	78	369	java/lang/Throwable
    //   89	95	369	java/lang/Throwable
    //   113	135	369	java/lang/Throwable
    //   176	180	369	java/lang/Throwable
    //   191	197	369	java/lang/Throwable
    //   208	222	369	java/lang/Throwable
    //   233	267	369	java/lang/Throwable
    //   308	313	369	java/lang/Throwable
    //   324	335	369	java/lang/Throwable
    //   387	392	394	java/lang/Throwable
    //   36	41	412	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$FieldChangedException
    //   52	61	412	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$FieldChangedException
    //   72	78	412	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$FieldChangedException
    //   89	95	412	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$FieldChangedException
    //   113	135	412	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$FieldChangedException
    //   176	180	412	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$FieldChangedException
    //   191	197	412	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$FieldChangedException
    //   208	222	412	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$FieldChangedException
    //   233	267	412	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$FieldChangedException
    //   308	313	412	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$FieldChangedException
    //   324	335	412	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$FieldChangedException
    //   422	426	429	java/lang/Throwable
  }
  
  /* Error */
  public static byte[] a(Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: invokestatic 112	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_2
    //   8: aload_2
    //   9: astore_1
    //   10: aload_2
    //   11: iconst_0
    //   12: invokevirtual 119	android/os/Parcel:setDataPosition	(I)V
    //   15: aload_2
    //   16: astore_1
    //   17: aload_2
    //   18: sipush 147
    //   21: invokevirtual 171	android/os/Parcel:writeInt	(I)V
    //   24: aload_2
    //   25: astore_1
    //   26: aload_0
    //   27: invokestatic 140	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper:a	(Ljava/lang/Object;)V
    //   30: aload_2
    //   31: astore_1
    //   32: aload_2
    //   33: aload_0
    //   34: invokevirtual 17	java/lang/Object:getClass	()Ljava/lang/Class;
    //   37: invokevirtual 144	java/lang/Class:getName	()Ljava/lang/String;
    //   40: invokevirtual 174	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   43: aload_2
    //   44: astore_1
    //   45: aload_0
    //   46: invokestatic 153	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper:a	(Ljava/lang/Object;)Ljava/util/ArrayList;
    //   49: astore_3
    //   50: aload_2
    //   51: astore_1
    //   52: aload_0
    //   53: invokestatic 158	com/tencent/mobileqq/activity/recent/parcelUtils/processor/ParcelProcessorFactory:a	(Ljava/lang/Object;)Lcom/tencent/mobileqq/activity/recent/parcelUtils/processor/BaseParcelProcessor;
    //   56: aload_0
    //   57: aload_3
    //   58: aload_2
    //   59: invokevirtual 177	com/tencent/mobileqq/activity/recent/parcelUtils/processor/BaseParcelProcessor:a	(Ljava/lang/Object;Ljava/util/ArrayList;Landroid/os/Parcel;)Z
    //   62: pop
    //   63: aload_2
    //   64: astore_1
    //   65: aload_2
    //   66: invokevirtual 181	android/os/Parcel:marshall	()[B
    //   69: astore_3
    //   70: aload_2
    //   71: ifnull +7 -> 78
    //   74: aload_2
    //   75: invokevirtual 133	android/os/Parcel:recycle	()V
    //   78: aload_3
    //   79: areturn
    //   80: astore_0
    //   81: goto +79 -> 160
    //   84: astore_3
    //   85: goto +16 -> 101
    //   88: astore_0
    //   89: aload_2
    //   90: astore_1
    //   91: goto +67 -> 158
    //   94: astore_0
    //   95: goto +65 -> 160
    //   98: astore_3
    //   99: aconst_null
    //   100: astore_2
    //   101: aload_0
    //   102: ifnull +78 -> 180
    //   105: aload_2
    //   106: astore_1
    //   107: aload_0
    //   108: invokevirtual 17	java/lang/Object:getClass	()Ljava/lang/Class;
    //   111: astore_0
    //   112: goto +3 -> 115
    //   115: aload_2
    //   116: astore_1
    //   117: ldc 67
    //   119: iconst_1
    //   120: iconst_4
    //   121: anewarray 4	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: ldc 183
    //   128: aastore
    //   129: dup
    //   130: iconst_1
    //   131: aload_0
    //   132: aastore
    //   133: dup
    //   134: iconst_2
    //   135: ldc 185
    //   137: aastore
    //   138: dup
    //   139: iconst_3
    //   140: aload_3
    //   141: aastore
    //   142: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   145: aload_2
    //   146: ifnull +7 -> 153
    //   149: aload_2
    //   150: invokevirtual 133	android/os/Parcel:recycle	()V
    //   153: aconst_null
    //   154: areturn
    //   155: astore_0
    //   156: aload_3
    //   157: astore_1
    //   158: aload_0
    //   159: athrow
    //   160: aload_1
    //   161: ifnull +7 -> 168
    //   164: aload_1
    //   165: invokevirtual 133	android/os/Parcel:recycle	()V
    //   168: aload_0
    //   169: athrow
    //   170: astore_0
    //   171: aload_3
    //   172: areturn
    //   173: astore_0
    //   174: aconst_null
    //   175: areturn
    //   176: astore_1
    //   177: goto -9 -> 168
    //   180: ldc 187
    //   182: astore_0
    //   183: goto -68 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	paramObject	Object
    //   3	162	1	localObject1	Object
    //   176	1	1	localThrowable1	java.lang.Throwable
    //   7	143	2	localParcel	android.os.Parcel
    //   1	78	3	localObject2	Object
    //   84	1	3	localThrowable2	java.lang.Throwable
    //   98	74	3	localThrowable3	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   10	15	80	finally
    //   17	24	80	finally
    //   26	30	80	finally
    //   32	43	80	finally
    //   45	50	80	finally
    //   52	63	80	finally
    //   65	70	80	finally
    //   107	112	80	finally
    //   117	145	80	finally
    //   10	15	84	java/lang/Throwable
    //   17	24	84	java/lang/Throwable
    //   26	30	84	java/lang/Throwable
    //   32	43	84	java/lang/Throwable
    //   45	50	84	java/lang/Throwable
    //   52	63	84	java/lang/Throwable
    //   65	70	84	java/lang/Throwable
    //   10	15	88	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$UnsupportedFieldTypeException
    //   17	24	88	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$UnsupportedFieldTypeException
    //   26	30	88	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$UnsupportedFieldTypeException
    //   32	43	88	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$UnsupportedFieldTypeException
    //   45	50	88	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$UnsupportedFieldTypeException
    //   52	63	88	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$UnsupportedFieldTypeException
    //   65	70	88	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$UnsupportedFieldTypeException
    //   4	8	94	finally
    //   158	160	94	finally
    //   4	8	98	java/lang/Throwable
    //   4	8	155	com/tencent/mobileqq/activity/recent/parcelUtils/ParcelHelper$UnsupportedFieldTypeException
    //   74	78	170	java/lang/Throwable
    //   149	153	173	java/lang/Throwable
    //   164	168	176	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.parcelUtils.ParcelHelper
 * JD-Core Version:    0.7.0.1
 */