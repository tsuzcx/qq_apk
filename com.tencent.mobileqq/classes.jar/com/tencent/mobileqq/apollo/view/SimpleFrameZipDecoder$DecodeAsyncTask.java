package com.tencent.mobileqq.apollo.view;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import java.lang.ref.WeakReference;

class SimpleFrameZipDecoder$DecodeAsyncTask
  extends AsyncTask<Integer, Void, Bitmap>
{
  private int jdField_a_of_type_Int;
  private WeakReference<SimpleFrameZipDecoder> jdField_a_of_type_JavaLangRefWeakReference;
  
  public SimpleFrameZipDecoder$DecodeAsyncTask(SimpleFrameZipDecoder paramSimpleFrameZipDecoder, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramSimpleFrameZipDecoder);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  /* Error */
  protected Bitmap a(Integer... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 21	com/tencent/mobileqq/apollo/view/SimpleFrameZipDecoder$DecodeAsyncTask:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   4: invokevirtual 33	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   7: checkcast 35	com/tencent/mobileqq/apollo/view/SimpleFrameZipDecoder
    //   10: astore_2
    //   11: aconst_null
    //   12: astore 4
    //   14: aconst_null
    //   15: astore 6
    //   17: aconst_null
    //   18: astore 5
    //   20: aload 6
    //   22: astore_3
    //   23: aload_2
    //   24: ifnull +317 -> 341
    //   27: aload 6
    //   29: astore_3
    //   30: aload_1
    //   31: ifnull +310 -> 341
    //   34: aload 6
    //   36: astore_3
    //   37: aload_1
    //   38: arraylength
    //   39: ifle +302 -> 341
    //   42: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +36 -> 81
    //   48: new 43	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   55: astore_3
    //   56: aload_3
    //   57: ldc 46
    //   59: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_3
    //   64: aload_1
    //   65: iconst_0
    //   66: aaload
    //   67: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: ldc 55
    //   73: iconst_2
    //   74: aload_3
    //   75: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: new 43	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   88: astore_3
    //   89: aload_3
    //   90: aload_2
    //   91: getfield 66	com/tencent/mobileqq/apollo/view/SimpleFrameZipDecoder:a	Ljava/lang/String;
    //   94: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload_3
    //   99: aload_1
    //   100: iconst_0
    //   101: aaload
    //   102: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: new 68	java/io/BufferedInputStream
    //   109: dup
    //   110: new 70	java/io/FileInputStream
    //   113: dup
    //   114: aload_3
    //   115: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokespecial 73	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   121: invokespecial 76	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   124: astore_2
    //   125: aload_2
    //   126: astore_1
    //   127: aload_2
    //   128: invokestatic 82	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   131: astore 4
    //   133: aload 4
    //   135: astore_3
    //   136: aload_2
    //   137: ifnull +204 -> 341
    //   140: aload_2
    //   141: invokevirtual 85	java/io/BufferedInputStream:close	()V
    //   144: aload 4
    //   146: areturn
    //   147: astore_2
    //   148: new 43	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   155: astore_1
    //   156: aload_1
    //   157: ldc 87
    //   159: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload_1
    //   164: aload_2
    //   165: invokevirtual 90	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   168: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: ldc 55
    //   174: iconst_1
    //   175: aload_1
    //   176: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: aload 4
    //   184: areturn
    //   185: astore_3
    //   186: goto +17 -> 203
    //   189: astore_3
    //   190: goto +57 -> 247
    //   193: astore_1
    //   194: aload 4
    //   196: astore_2
    //   197: goto +96 -> 293
    //   200: astore_3
    //   201: aconst_null
    //   202: astore_2
    //   203: aload_2
    //   204: astore_1
    //   205: ldc 55
    //   207: iconst_1
    //   208: aload_3
    //   209: invokevirtual 90	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   212: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: aload 6
    //   217: astore_3
    //   218: aload_2
    //   219: ifnull +122 -> 341
    //   222: aload_2
    //   223: invokevirtual 85	java/io/BufferedInputStream:close	()V
    //   226: aconst_null
    //   227: areturn
    //   228: astore_2
    //   229: new 43	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   236: astore_1
    //   237: aload 5
    //   239: astore 4
    //   241: goto -85 -> 156
    //   244: astore_3
    //   245: aconst_null
    //   246: astore_2
    //   247: aload_2
    //   248: astore_1
    //   249: ldc 55
    //   251: iconst_1
    //   252: aload_3
    //   253: invokevirtual 94	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   256: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: aload 6
    //   261: astore_3
    //   262: aload_2
    //   263: ifnull +78 -> 341
    //   266: aload_2
    //   267: invokevirtual 85	java/io/BufferedInputStream:close	()V
    //   270: aconst_null
    //   271: areturn
    //   272: astore_2
    //   273: new 43	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   280: astore_1
    //   281: aload 5
    //   283: astore 4
    //   285: goto -129 -> 156
    //   288: astore_3
    //   289: aload_1
    //   290: astore_2
    //   291: aload_3
    //   292: astore_1
    //   293: aload_2
    //   294: ifnull +45 -> 339
    //   297: aload_2
    //   298: invokevirtual 85	java/io/BufferedInputStream:close	()V
    //   301: goto +38 -> 339
    //   304: astore_2
    //   305: new 43	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   312: astore_3
    //   313: aload_3
    //   314: ldc 87
    //   316: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload_3
    //   321: aload_2
    //   322: invokevirtual 90	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   325: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: ldc 55
    //   331: iconst_1
    //   332: aload_3
    //   333: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   339: aload_1
    //   340: athrow
    //   341: aload_3
    //   342: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	DecodeAsyncTask
    //   0	343	1	paramVarArgs	Integer[]
    //   10	131	2	localObject1	java.lang.Object
    //   147	18	2	localThrowable1	java.lang.Throwable
    //   196	27	2	localObject2	java.lang.Object
    //   228	1	2	localThrowable2	java.lang.Throwable
    //   246	21	2	localObject3	java.lang.Object
    //   272	1	2	localThrowable3	java.lang.Throwable
    //   290	8	2	arrayOfInteger	Integer[]
    //   304	18	2	localThrowable4	java.lang.Throwable
    //   22	114	3	localObject4	java.lang.Object
    //   185	1	3	localThrowable5	java.lang.Throwable
    //   189	1	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   200	9	3	localThrowable6	java.lang.Throwable
    //   217	1	3	localObject5	java.lang.Object
    //   244	9	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   261	1	3	localObject6	java.lang.Object
    //   288	4	3	localObject7	java.lang.Object
    //   312	30	3	localStringBuilder	java.lang.StringBuilder
    //   12	272	4	localObject8	java.lang.Object
    //   18	264	5	localObject9	java.lang.Object
    //   15	245	6	localObject10	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   140	144	147	java/lang/Throwable
    //   127	133	185	java/lang/Throwable
    //   127	133	189	java/lang/OutOfMemoryError
    //   42	81	193	finally
    //   81	125	193	finally
    //   42	81	200	java/lang/Throwable
    //   81	125	200	java/lang/Throwable
    //   222	226	228	java/lang/Throwable
    //   42	81	244	java/lang/OutOfMemoryError
    //   81	125	244	java/lang/OutOfMemoryError
    //   266	270	272	java/lang/Throwable
    //   127	133	288	finally
    //   205	215	288	finally
    //   249	259	288	finally
    //   297	301	304	java/lang/Throwable
  }
  
  protected void a(Bitmap paramBitmap)
  {
    super.onPostExecute(paramBitmap);
    SimpleFrameZipDecoder localSimpleFrameZipDecoder = (SimpleFrameZipDecoder)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localSimpleFrameZipDecoder != null) && (paramBitmap != null) && (!paramBitmap.isRecycled())) {
      localSimpleFrameZipDecoder.a(paramBitmap, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.SimpleFrameZipDecoder.DecodeAsyncTask
 * JD-Core Version:    0.7.0.1
 */