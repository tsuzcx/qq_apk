package androidx.print;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter.WriteResultCallback;
import android.util.Log;

class PrintHelper$1
  extends AsyncTask<Void, Void, Throwable>
{
  PrintHelper$1(PrintHelper paramPrintHelper, CancellationSignal paramCancellationSignal, PrintAttributes paramPrintAttributes1, Bitmap paramBitmap, PrintAttributes paramPrintAttributes2, int paramInt, ParcelFileDescriptor paramParcelFileDescriptor, PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback) {}
  
  /* Error */
  protected Throwable a(Void... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	androidx/print/PrintHelper$1:jdField_a_of_type_AndroidOsCancellationSignal	Landroid/os/CancellationSignal;
    //   4: invokevirtual 47	android/os/CancellationSignal:isCanceled	()Z
    //   7: ifeq +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: new 49	android/print/pdf/PrintedPdfDocument
    //   15: dup
    //   16: aload_0
    //   17: getfield 18	androidx/print/PrintHelper$1:jdField_a_of_type_AndroidxPrintPrintHelper	Landroidx/print/PrintHelper;
    //   20: getfield 54	androidx/print/PrintHelper:a	Landroid/content/Context;
    //   23: aload_0
    //   24: getfield 22	androidx/print/PrintHelper$1:jdField_a_of_type_AndroidPrintPrintAttributes	Landroid/print/PrintAttributes;
    //   27: invokespecial 57	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
    //   30: astore 4
    //   32: aload_0
    //   33: getfield 24	androidx/print/PrintHelper$1:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   36: aload_0
    //   37: getfield 22	androidx/print/PrintHelper$1:jdField_a_of_type_AndroidPrintPrintAttributes	Landroid/print/PrintAttributes;
    //   40: invokevirtual 63	android/print/PrintAttributes:getColorMode	()I
    //   43: invokestatic 66	androidx/print/PrintHelper:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   46: astore_3
    //   47: aload_0
    //   48: getfield 20	androidx/print/PrintHelper$1:jdField_a_of_type_AndroidOsCancellationSignal	Landroid/os/CancellationSignal;
    //   51: invokevirtual 47	android/os/CancellationSignal:isCanceled	()Z
    //   54: istore_2
    //   55: iload_2
    //   56: ifne +317 -> 373
    //   59: aload 4
    //   61: iconst_1
    //   62: invokevirtual 70	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
    //   65: astore 5
    //   67: getstatic 73	androidx/print/PrintHelper:b	Z
    //   70: ifeq +112 -> 182
    //   73: new 75	android/graphics/RectF
    //   76: dup
    //   77: aload 5
    //   79: invokevirtual 81	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
    //   82: invokevirtual 87	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
    //   85: invokespecial 90	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
    //   88: astore_1
    //   89: aload_3
    //   90: invokevirtual 95	android/graphics/Bitmap:getWidth	()I
    //   93: aload_3
    //   94: invokevirtual 98	android/graphics/Bitmap:getHeight	()I
    //   97: aload_1
    //   98: aload_0
    //   99: getfield 28	androidx/print/PrintHelper$1:jdField_a_of_type_Int	I
    //   102: invokestatic 101	androidx/print/PrintHelper:a	(IILandroid/graphics/RectF;I)Landroid/graphics/Matrix;
    //   105: astore 6
    //   107: getstatic 73	androidx/print/PrintHelper:b	Z
    //   110: ifeq +169 -> 279
    //   113: aload 5
    //   115: invokevirtual 105	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
    //   118: aload_3
    //   119: aload 6
    //   121: aconst_null
    //   122: invokevirtual 111	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
    //   125: aload 4
    //   127: aload 5
    //   129: invokevirtual 115	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
    //   132: aload_0
    //   133: getfield 20	androidx/print/PrintHelper$1:jdField_a_of_type_AndroidOsCancellationSignal	Landroid/os/CancellationSignal;
    //   136: invokevirtual 47	android/os/CancellationSignal:isCanceled	()Z
    //   139: istore_2
    //   140: iload_2
    //   141: ifeq +165 -> 306
    //   144: aload 4
    //   146: invokevirtual 118	android/print/pdf/PrintedPdfDocument:close	()V
    //   149: aload_0
    //   150: getfield 30	androidx/print/PrintHelper$1:jdField_a_of_type_AndroidOsParcelFileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   153: astore_1
    //   154: aload_1
    //   155: ifnull +10 -> 165
    //   158: aload_0
    //   159: getfield 30	androidx/print/PrintHelper$1:jdField_a_of_type_AndroidOsParcelFileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   162: invokevirtual 121	android/os/ParcelFileDescriptor:close	()V
    //   165: aload_3
    //   166: aload_0
    //   167: getfield 24	androidx/print/PrintHelper$1:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   170: if_acmpeq +203 -> 373
    //   173: aload_3
    //   174: invokevirtual 124	android/graphics/Bitmap:recycle	()V
    //   177: aconst_null
    //   178: areturn
    //   179: astore_1
    //   180: aload_1
    //   181: areturn
    //   182: new 49	android/print/pdf/PrintedPdfDocument
    //   185: dup
    //   186: aload_0
    //   187: getfield 18	androidx/print/PrintHelper$1:jdField_a_of_type_AndroidxPrintPrintHelper	Landroidx/print/PrintHelper;
    //   190: getfield 54	androidx/print/PrintHelper:a	Landroid/content/Context;
    //   193: aload_0
    //   194: getfield 26	androidx/print/PrintHelper$1:b	Landroid/print/PrintAttributes;
    //   197: invokespecial 57	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
    //   200: astore 6
    //   202: aload 6
    //   204: iconst_1
    //   205: invokevirtual 70	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
    //   208: astore 7
    //   210: new 75	android/graphics/RectF
    //   213: dup
    //   214: aload 7
    //   216: invokevirtual 81	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
    //   219: invokevirtual 87	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
    //   222: invokespecial 90	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
    //   225: astore_1
    //   226: aload 6
    //   228: aload 7
    //   230: invokevirtual 115	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
    //   233: aload 6
    //   235: invokevirtual 118	android/print/pdf/PrintedPdfDocument:close	()V
    //   238: goto -149 -> 89
    //   241: astore_1
    //   242: aload 4
    //   244: invokevirtual 118	android/print/pdf/PrintedPdfDocument:close	()V
    //   247: aload_0
    //   248: getfield 30	androidx/print/PrintHelper$1:jdField_a_of_type_AndroidOsParcelFileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   251: astore 4
    //   253: aload 4
    //   255: ifnull +10 -> 265
    //   258: aload_0
    //   259: getfield 30	androidx/print/PrintHelper$1:jdField_a_of_type_AndroidOsParcelFileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   262: invokevirtual 121	android/os/ParcelFileDescriptor:close	()V
    //   265: aload_3
    //   266: aload_0
    //   267: getfield 24	androidx/print/PrintHelper$1:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   270: if_acmpeq +7 -> 277
    //   273: aload_3
    //   274: invokevirtual 124	android/graphics/Bitmap:recycle	()V
    //   277: aload_1
    //   278: athrow
    //   279: aload 6
    //   281: aload_1
    //   282: getfield 128	android/graphics/RectF:left	F
    //   285: aload_1
    //   286: getfield 131	android/graphics/RectF:top	F
    //   289: invokevirtual 137	android/graphics/Matrix:postTranslate	(FF)Z
    //   292: pop
    //   293: aload 5
    //   295: invokevirtual 105	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
    //   298: aload_1
    //   299: invokevirtual 141	android/graphics/Canvas:clipRect	(Landroid/graphics/RectF;)Z
    //   302: pop
    //   303: goto -190 -> 113
    //   306: aload 4
    //   308: new 143	java/io/FileOutputStream
    //   311: dup
    //   312: aload_0
    //   313: getfield 30	androidx/print/PrintHelper$1:jdField_a_of_type_AndroidOsParcelFileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   316: invokevirtual 147	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   319: invokespecial 150	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   322: invokevirtual 154	android/print/pdf/PrintedPdfDocument:writeTo	(Ljava/io/OutputStream;)V
    //   325: aload 4
    //   327: invokevirtual 118	android/print/pdf/PrintedPdfDocument:close	()V
    //   330: aload_0
    //   331: getfield 30	androidx/print/PrintHelper$1:jdField_a_of_type_AndroidOsParcelFileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   334: astore_1
    //   335: aload_1
    //   336: ifnull +10 -> 346
    //   339: aload_0
    //   340: getfield 30	androidx/print/PrintHelper$1:jdField_a_of_type_AndroidOsParcelFileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   343: invokevirtual 121	android/os/ParcelFileDescriptor:close	()V
    //   346: aload_3
    //   347: aload_0
    //   348: getfield 24	androidx/print/PrintHelper$1:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   351: if_acmpeq +22 -> 373
    //   354: aload_3
    //   355: invokevirtual 124	android/graphics/Bitmap:recycle	()V
    //   358: aconst_null
    //   359: areturn
    //   360: astore 4
    //   362: goto -97 -> 265
    //   365: astore_1
    //   366: goto -20 -> 346
    //   369: astore_1
    //   370: goto -205 -> 165
    //   373: aconst_null
    //   374: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	this	1
    //   0	375	1	paramVarArgs	Void[]
    //   54	87	2	bool	boolean
    //   46	309	3	localBitmap	Bitmap
    //   30	296	4	localObject1	java.lang.Object
    //   360	1	4	localIOException	java.io.IOException
    //   65	229	5	localPage1	android.graphics.pdf.PdfDocument.Page
    //   105	175	6	localObject2	java.lang.Object
    //   208	21	7	localPage2	android.graphics.pdf.PdfDocument.Page
    // Exception table:
    //   from	to	target	type
    //   0	10	179	java/lang/Throwable
    //   12	55	179	java/lang/Throwable
    //   144	154	179	java/lang/Throwable
    //   158	165	179	java/lang/Throwable
    //   165	177	179	java/lang/Throwable
    //   242	253	179	java/lang/Throwable
    //   258	265	179	java/lang/Throwable
    //   265	277	179	java/lang/Throwable
    //   277	279	179	java/lang/Throwable
    //   325	335	179	java/lang/Throwable
    //   339	346	179	java/lang/Throwable
    //   346	358	179	java/lang/Throwable
    //   59	89	241	finally
    //   89	113	241	finally
    //   113	140	241	finally
    //   182	238	241	finally
    //   279	303	241	finally
    //   306	325	241	finally
    //   258	265	360	java/io/IOException
    //   339	346	365	java/io/IOException
    //   158	165	369	java/io/IOException
  }
  
  protected void a(Throwable paramThrowable)
  {
    if (this.jdField_a_of_type_AndroidOsCancellationSignal.isCanceled())
    {
      this.jdField_a_of_type_AndroidPrintPrintDocumentAdapter$WriteResultCallback.onWriteCancelled();
      return;
    }
    if (paramThrowable == null)
    {
      this.jdField_a_of_type_AndroidPrintPrintDocumentAdapter$WriteResultCallback.onWriteFinished(new PageRange[] { PageRange.ALL_PAGES });
      return;
    }
    Log.e("PrintHelper", "Error writing printed content", paramThrowable);
    this.jdField_a_of_type_AndroidPrintPrintDocumentAdapter$WriteResultCallback.onWriteFailed(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.print.PrintHelper.1
 * JD-Core Version:    0.7.0.1
 */