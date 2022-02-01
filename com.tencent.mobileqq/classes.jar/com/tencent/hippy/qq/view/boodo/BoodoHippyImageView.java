package com.tencent.hippy.qq.view.boodo;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mtt.hippy.views.image.HippyImageView;
import com.tencent.mtt.supportui.adapters.image.IDrawableTarget;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class BoodoHippyImageView
  extends HippyImageView
{
  private Bitmap mBlurBitmap = null;
  private String mBlurBitmapKey = null;
  private int mBlurRadius;
  
  public BoodoHippyImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  private float getBlurRate(int paramInt1, int paramInt2, int paramInt3)
  {
    float f2 = (float)Math.sqrt(paramInt3);
    float f1 = f2;
    if (f2 > paramInt1) {
      f1 = paramInt1;
    }
    f2 = f1;
    if (f1 > paramInt2) {
      f2 = paramInt2;
    }
    return f2;
  }
  
  /* Error */
  private void handleGuassian()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 48	com/tencent/hippy/qq/view/boodo/BoodoHippyImageView:mSourceDrawable	Lcom/tencent/mtt/supportui/adapters/image/IDrawableTarget;
    //   4: invokeinterface 54 1 0
    //   9: astore 7
    //   11: aload 7
    //   13: ifnull +11 -> 24
    //   16: aload 7
    //   18: invokevirtual 60	android/graphics/Bitmap:isRecycled	()Z
    //   21: ifeq +12 -> 33
    //   24: ldc 62
    //   26: iconst_1
    //   27: ldc 64
    //   29: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: return
    //   33: aload 7
    //   35: astore 5
    //   37: aload 7
    //   39: astore 6
    //   41: aload 7
    //   43: astore 4
    //   45: aload 7
    //   47: invokevirtual 74	android/graphics/Bitmap:getWidth	()I
    //   50: istore_2
    //   51: aload 7
    //   53: astore 5
    //   55: aload 7
    //   57: astore 6
    //   59: aload 7
    //   61: astore 4
    //   63: aload 7
    //   65: invokevirtual 77	android/graphics/Bitmap:getHeight	()I
    //   68: istore_3
    //   69: aload 7
    //   71: astore 5
    //   73: aload 7
    //   75: astore 6
    //   77: aload 7
    //   79: astore 4
    //   81: aload_0
    //   82: iload_2
    //   83: iload_3
    //   84: aload_0
    //   85: getfield 79	com/tencent/hippy/qq/view/boodo/BoodoHippyImageView:mBlurRadius	I
    //   88: invokespecial 81	com/tencent/hippy/qq/view/boodo/BoodoHippyImageView:getBlurRate	(III)F
    //   91: fstore_1
    //   92: aload 7
    //   94: astore 5
    //   96: aload 7
    //   98: astore 6
    //   100: aload 7
    //   102: astore 4
    //   104: aload 7
    //   106: iload_2
    //   107: i2f
    //   108: fload_1
    //   109: fdiv
    //   110: f2i
    //   111: iload_3
    //   112: i2f
    //   113: fload_1
    //   114: fdiv
    //   115: f2i
    //   116: iconst_1
    //   117: invokestatic 85	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   120: astore 7
    //   122: aload 7
    //   124: astore 5
    //   126: aload 7
    //   128: astore 6
    //   130: aload 7
    //   132: astore 4
    //   134: aload 7
    //   136: aload_0
    //   137: getfield 79	com/tencent/hippy/qq/view/boodo/BoodoHippyImageView:mBlurRadius	I
    //   140: i2f
    //   141: fload_1
    //   142: fdiv
    //   143: f2i
    //   144: invokestatic 91	com/tencent/mobileqq/utils/StackBlur:a	(Landroid/graphics/Bitmap;I)V
    //   147: aload 7
    //   149: astore 5
    //   151: aload 7
    //   153: astore 6
    //   155: aload 7
    //   157: astore 4
    //   159: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq +52 -> 214
    //   165: aload 7
    //   167: astore 5
    //   169: aload 7
    //   171: astore 6
    //   173: aload 7
    //   175: astore 4
    //   177: ldc 62
    //   179: iconst_2
    //   180: iconst_4
    //   181: anewarray 96	java/lang/Object
    //   184: dup
    //   185: iconst_0
    //   186: ldc 97
    //   188: aastore
    //   189: dup
    //   190: iconst_1
    //   191: aload_0
    //   192: getfield 79	com/tencent/hippy/qq/view/boodo/BoodoHippyImageView:mBlurRadius	I
    //   195: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: aastore
    //   199: dup
    //   200: iconst_2
    //   201: ldc 105
    //   203: aastore
    //   204: dup
    //   205: iconst_3
    //   206: fload_1
    //   207: invokestatic 110	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   210: aastore
    //   211: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   214: aload_0
    //   215: aload 7
    //   217: aconst_null
    //   218: invokevirtual 118	com/tencent/hippy/qq/view/boodo/BoodoHippyImageView:onGaussianBlurComplete	(Landroid/graphics/Bitmap;Ljava/util/Map;)V
    //   221: return
    //   222: astore 4
    //   224: aload 5
    //   226: astore 4
    //   228: ldc 62
    //   230: iconst_1
    //   231: ldc 120
    //   233: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload_0
    //   237: aload 5
    //   239: aconst_null
    //   240: invokevirtual 118	com/tencent/hippy/qq/view/boodo/BoodoHippyImageView:onGaussianBlurComplete	(Landroid/graphics/Bitmap;Ljava/util/Map;)V
    //   243: return
    //   244: astore 4
    //   246: ldc 62
    //   248: iconst_1
    //   249: aload 4
    //   251: iconst_0
    //   252: anewarray 96	java/lang/Object
    //   255: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   258: aload_0
    //   259: aload 6
    //   261: aconst_null
    //   262: invokevirtual 118	com/tencent/hippy/qq/view/boodo/BoodoHippyImageView:onGaussianBlurComplete	(Landroid/graphics/Bitmap;Ljava/util/Map;)V
    //   265: return
    //   266: astore 5
    //   268: aload_0
    //   269: aload 4
    //   271: aconst_null
    //   272: invokevirtual 118	com/tencent/hippy/qq/view/boodo/BoodoHippyImageView:onGaussianBlurComplete	(Landroid/graphics/Bitmap;Ljava/util/Map;)V
    //   275: aload 5
    //   277: athrow
    //   278: astore 5
    //   280: aload 6
    //   282: astore 4
    //   284: goto -16 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	BoodoHippyImageView
    //   91	116	1	f	float
    //   50	57	2	i	int
    //   68	44	3	j	int
    //   43	133	4	localBitmap1	Bitmap
    //   222	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   226	1	4	localBitmap2	Bitmap
    //   244	26	4	localException	java.lang.Exception
    //   282	1	4	localBitmap3	Bitmap
    //   35	203	5	localBitmap4	Bitmap
    //   266	10	5	localObject1	java.lang.Object
    //   278	1	5	localObject2	java.lang.Object
    //   39	242	6	localBitmap5	Bitmap
    //   9	207	7	localBitmap6	Bitmap
    // Exception table:
    //   from	to	target	type
    //   45	51	222	java/lang/OutOfMemoryError
    //   63	69	222	java/lang/OutOfMemoryError
    //   81	92	222	java/lang/OutOfMemoryError
    //   104	122	222	java/lang/OutOfMemoryError
    //   134	147	222	java/lang/OutOfMemoryError
    //   159	165	222	java/lang/OutOfMemoryError
    //   177	214	222	java/lang/OutOfMemoryError
    //   45	51	244	java/lang/Exception
    //   63	69	244	java/lang/Exception
    //   81	92	244	java/lang/Exception
    //   104	122	244	java/lang/Exception
    //   134	147	244	java/lang/Exception
    //   159	165	244	java/lang/Exception
    //   177	214	244	java/lang/Exception
    //   45	51	266	finally
    //   63	69	266	finally
    //   81	92	266	finally
    //   104	122	266	finally
    //   134	147	266	finally
    //   159	165	266	finally
    //   177	214	266	finally
    //   228	236	266	finally
    //   246	258	278	finally
  }
  
  private void init()
  {
    this.mBlurRadius = 0;
    this.mBlurBitmap = null;
    this.mBlurBitmapKey = null;
  }
  
  public Bitmap getBitmap()
  {
    if (this.mBlurRadius > 0) {
      return this.mBlurBitmap;
    }
    return super.getBitmap();
  }
  
  public void onGaussianBlurComplete(Bitmap paramBitmap, Map paramMap)
  {
    this.mBlurBitmap = paramBitmap;
    post(new BoodoHippyImageView.2(this));
  }
  
  public void setBlurRadius(int paramInt)
  {
    this.mBlurRadius = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("hippyImageView", 2, "setBlurRadius blurRadius:" + paramInt);
    }
  }
  
  public boolean shouldSetContent()
  {
    if ((this.mBlurRadius > 0) && (this.mSourceDrawable != null) && (this.mSourceDrawable.getBitmap() != null))
    {
      String str = getUrl() + "_" + this.mBlurRadius;
      if (str.equals(this.mBlurBitmapKey)) {
        return true;
      }
      this.mBlurBitmapKey = str;
      ThreadManagerV2.excute(new BoodoHippyImageView.1(this), 16, null, false);
      return false;
    }
    return super.shouldSetContent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.boodo.BoodoHippyImageView
 * JD-Core Version:    0.7.0.1
 */