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
  protected Throwable doInBackground(Void... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	androidx/print/PrintHelper$1:val$cancellationSignal	Landroid/os/CancellationSignal;
    //   4: invokevirtual 59	android/os/CancellationSignal:isCanceled	()Z
    //   7: ifeq +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: new 61	android/print/pdf/PrintedPdfDocument
    //   15: dup
    //   16: aload_0
    //   17: getfield 24	androidx/print/PrintHelper$1:this$0	Landroidx/print/PrintHelper;
    //   20: getfield 67	androidx/print/PrintHelper:mContext	Landroid/content/Context;
    //   23: aload_0
    //   24: getfield 28	androidx/print/PrintHelper$1:val$pdfAttributes	Landroid/print/PrintAttributes;
    //   27: invokespecial 70	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
    //   30: astore 4
    //   32: aload_0
    //   33: getfield 30	androidx/print/PrintHelper$1:val$bitmap	Landroid/graphics/Bitmap;
    //   36: aload_0
    //   37: getfield 28	androidx/print/PrintHelper$1:val$pdfAttributes	Landroid/print/PrintAttributes;
    //   40: invokevirtual 76	android/print/PrintAttributes:getColorMode	()I
    //   43: invokestatic 80	androidx/print/PrintHelper:convertBitmapForColorMode	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   46: astore_3
    //   47: aload_0
    //   48: getfield 26	androidx/print/PrintHelper$1:val$cancellationSignal	Landroid/os/CancellationSignal;
    //   51: invokevirtual 59	android/os/CancellationSignal:isCanceled	()Z
    //   54: istore_2
    //   55: iload_2
    //   56: ifeq +5 -> 61
    //   59: aconst_null
    //   60: areturn
    //   61: aload 4
    //   63: iconst_1
    //   64: invokevirtual 84	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
    //   67: astore 5
    //   69: getstatic 88	androidx/print/PrintHelper:IS_MIN_MARGINS_HANDLING_CORRECT	Z
    //   72: ifeq +22 -> 94
    //   75: new 90	android/graphics/RectF
    //   78: dup
    //   79: aload 5
    //   81: invokevirtual 96	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
    //   84: invokevirtual 102	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
    //   87: invokespecial 105	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
    //   90: astore_1
    //   91: goto +59 -> 150
    //   94: new 61	android/print/pdf/PrintedPdfDocument
    //   97: dup
    //   98: aload_0
    //   99: getfield 24	androidx/print/PrintHelper$1:this$0	Landroidx/print/PrintHelper;
    //   102: getfield 67	androidx/print/PrintHelper:mContext	Landroid/content/Context;
    //   105: aload_0
    //   106: getfield 32	androidx/print/PrintHelper$1:val$attributes	Landroid/print/PrintAttributes;
    //   109: invokespecial 70	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
    //   112: astore 6
    //   114: aload 6
    //   116: iconst_1
    //   117: invokevirtual 84	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
    //   120: astore 7
    //   122: new 90	android/graphics/RectF
    //   125: dup
    //   126: aload 7
    //   128: invokevirtual 96	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
    //   131: invokevirtual 102	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
    //   134: invokespecial 105	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
    //   137: astore_1
    //   138: aload 6
    //   140: aload 7
    //   142: invokevirtual 109	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
    //   145: aload 6
    //   147: invokevirtual 112	android/print/pdf/PrintedPdfDocument:close	()V
    //   150: aload_3
    //   151: invokevirtual 117	android/graphics/Bitmap:getWidth	()I
    //   154: aload_3
    //   155: invokevirtual 120	android/graphics/Bitmap:getHeight	()I
    //   158: aload_1
    //   159: aload_0
    //   160: getfield 34	androidx/print/PrintHelper$1:val$fittingMode	I
    //   163: invokestatic 124	androidx/print/PrintHelper:getMatrix	(IILandroid/graphics/RectF;I)Landroid/graphics/Matrix;
    //   166: astore 6
    //   168: getstatic 88	androidx/print/PrintHelper:IS_MIN_MARGINS_HANDLING_CORRECT	Z
    //   171: ifeq +6 -> 177
    //   174: goto +27 -> 201
    //   177: aload 6
    //   179: aload_1
    //   180: getfield 128	android/graphics/RectF:left	F
    //   183: aload_1
    //   184: getfield 131	android/graphics/RectF:top	F
    //   187: invokevirtual 137	android/graphics/Matrix:postTranslate	(FF)Z
    //   190: pop
    //   191: aload 5
    //   193: invokevirtual 141	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
    //   196: aload_1
    //   197: invokevirtual 147	android/graphics/Canvas:clipRect	(Landroid/graphics/RectF;)Z
    //   200: pop
    //   201: aload 5
    //   203: invokevirtual 141	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
    //   206: aload_3
    //   207: aload 6
    //   209: aconst_null
    //   210: invokevirtual 151	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
    //   213: aload 4
    //   215: aload 5
    //   217: invokevirtual 109	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
    //   220: aload_0
    //   221: getfield 26	androidx/print/PrintHelper$1:val$cancellationSignal	Landroid/os/CancellationSignal;
    //   224: invokevirtual 59	android/os/CancellationSignal:isCanceled	()Z
    //   227: istore_2
    //   228: iload_2
    //   229: ifeq +38 -> 267
    //   232: aload 4
    //   234: invokevirtual 112	android/print/pdf/PrintedPdfDocument:close	()V
    //   237: aload_0
    //   238: getfield 36	androidx/print/PrintHelper$1:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   241: astore_1
    //   242: aload_1
    //   243: ifnull +10 -> 253
    //   246: aload_0
    //   247: getfield 36	androidx/print/PrintHelper$1:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   250: invokevirtual 154	android/os/ParcelFileDescriptor:close	()V
    //   253: aload_3
    //   254: aload_0
    //   255: getfield 30	androidx/print/PrintHelper$1:val$bitmap	Landroid/graphics/Bitmap;
    //   258: if_acmpeq +7 -> 265
    //   261: aload_3
    //   262: invokevirtual 157	android/graphics/Bitmap:recycle	()V
    //   265: aconst_null
    //   266: areturn
    //   267: aload 4
    //   269: new 159	java/io/FileOutputStream
    //   272: dup
    //   273: aload_0
    //   274: getfield 36	androidx/print/PrintHelper$1:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   277: invokevirtual 163	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   280: invokespecial 166	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   283: invokevirtual 170	android/print/pdf/PrintedPdfDocument:writeTo	(Ljava/io/OutputStream;)V
    //   286: aload 4
    //   288: invokevirtual 112	android/print/pdf/PrintedPdfDocument:close	()V
    //   291: aload_0
    //   292: getfield 36	androidx/print/PrintHelper$1:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   295: astore_1
    //   296: aload_1
    //   297: ifnull +10 -> 307
    //   300: aload_0
    //   301: getfield 36	androidx/print/PrintHelper$1:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   304: invokevirtual 154	android/os/ParcelFileDescriptor:close	()V
    //   307: aload_3
    //   308: aload_0
    //   309: getfield 30	androidx/print/PrintHelper$1:val$bitmap	Landroid/graphics/Bitmap;
    //   312: if_acmpeq +63 -> 375
    //   315: aload_3
    //   316: invokevirtual 157	android/graphics/Bitmap:recycle	()V
    //   319: aconst_null
    //   320: areturn
    //   321: astore_1
    //   322: aload 4
    //   324: invokevirtual 112	android/print/pdf/PrintedPdfDocument:close	()V
    //   327: aload_0
    //   328: getfield 36	androidx/print/PrintHelper$1:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   331: astore 4
    //   333: aload 4
    //   335: ifnull +10 -> 345
    //   338: aload_0
    //   339: getfield 36	androidx/print/PrintHelper$1:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   342: invokevirtual 154	android/os/ParcelFileDescriptor:close	()V
    //   345: aload_3
    //   346: aload_0
    //   347: getfield 30	androidx/print/PrintHelper$1:val$bitmap	Landroid/graphics/Bitmap;
    //   350: if_acmpeq +7 -> 357
    //   353: aload_3
    //   354: invokevirtual 157	android/graphics/Bitmap:recycle	()V
    //   357: aload_1
    //   358: athrow
    //   359: astore_1
    //   360: aload_1
    //   361: areturn
    //   362: astore_1
    //   363: goto -110 -> 253
    //   366: astore_1
    //   367: goto -60 -> 307
    //   370: astore 4
    //   372: goto -27 -> 345
    //   375: aconst_null
    //   376: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	this	1
    //   0	377	1	paramVarArgs	Void[]
    //   54	175	2	bool	boolean
    //   46	308	3	localBitmap	Bitmap
    //   30	304	4	localObject1	java.lang.Object
    //   370	1	4	localIOException	java.io.IOException
    //   67	149	5	localPage1	android.graphics.pdf.PdfDocument.Page
    //   112	96	6	localObject2	java.lang.Object
    //   120	21	7	localPage2	android.graphics.pdf.PdfDocument.Page
    // Exception table:
    //   from	to	target	type
    //   61	91	321	finally
    //   94	150	321	finally
    //   150	174	321	finally
    //   177	201	321	finally
    //   201	228	321	finally
    //   267	286	321	finally
    //   0	10	359	java/lang/Throwable
    //   12	55	359	java/lang/Throwable
    //   232	242	359	java/lang/Throwable
    //   246	253	359	java/lang/Throwable
    //   253	265	359	java/lang/Throwable
    //   286	296	359	java/lang/Throwable
    //   300	307	359	java/lang/Throwable
    //   307	319	359	java/lang/Throwable
    //   322	333	359	java/lang/Throwable
    //   338	345	359	java/lang/Throwable
    //   345	357	359	java/lang/Throwable
    //   357	359	359	java/lang/Throwable
    //   246	253	362	java/io/IOException
    //   300	307	366	java/io/IOException
    //   338	345	370	java/io/IOException
  }
  
  protected void onPostExecute(Throwable paramThrowable)
  {
    if (this.val$cancellationSignal.isCanceled())
    {
      this.val$writeResultCallback.onWriteCancelled();
      return;
    }
    if (paramThrowable == null)
    {
      this.val$writeResultCallback.onWriteFinished(new PageRange[] { PageRange.ALL_PAGES });
      return;
    }
    Log.e("PrintHelper", "Error writing printed content", paramThrowable);
    this.val$writeResultCallback.onWriteFailed(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.print.PrintHelper.1
 * JD-Core Version:    0.7.0.1
 */