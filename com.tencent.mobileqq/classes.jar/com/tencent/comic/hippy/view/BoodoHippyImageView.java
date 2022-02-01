package com.tencent.comic.hippy.view;

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
    float f1 = (float)Math.sqrt(paramInt3);
    float f2 = paramInt1;
    if (f1 > f2) {
      f1 = f2;
    }
    float f3 = paramInt2;
    f2 = f1;
    if (f1 > f3) {
      f2 = f3;
    }
    return f2;
  }
  
  /* Error */
  private void handleGuassian()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 48	com/tencent/comic/hippy/view/BoodoHippyImageView:mSourceDrawable	Lcom/tencent/mtt/supportui/adapters/image/IDrawableTarget;
    //   4: invokeinterface 54 1 0
    //   9: astore 7
    //   11: aload 7
    //   13: ifnull +270 -> 283
    //   16: aload 7
    //   18: invokevirtual 60	android/graphics/Bitmap:isRecycled	()Z
    //   21: ifeq +6 -> 27
    //   24: goto +259 -> 283
    //   27: aload 7
    //   29: astore 4
    //   31: aload 7
    //   33: astore 5
    //   35: aload 7
    //   37: astore 6
    //   39: aload 7
    //   41: invokevirtual 64	android/graphics/Bitmap:getWidth	()I
    //   44: istore_2
    //   45: aload 7
    //   47: astore 4
    //   49: aload 7
    //   51: astore 5
    //   53: aload 7
    //   55: astore 6
    //   57: aload 7
    //   59: invokevirtual 67	android/graphics/Bitmap:getHeight	()I
    //   62: istore_3
    //   63: aload 7
    //   65: astore 4
    //   67: aload 7
    //   69: astore 5
    //   71: aload 7
    //   73: astore 6
    //   75: aload_0
    //   76: iload_2
    //   77: iload_3
    //   78: aload_0
    //   79: getfield 69	com/tencent/comic/hippy/view/BoodoHippyImageView:mBlurRadius	I
    //   82: invokespecial 71	com/tencent/comic/hippy/view/BoodoHippyImageView:getBlurRate	(III)F
    //   85: fstore_1
    //   86: aload 7
    //   88: astore 4
    //   90: aload 7
    //   92: astore 5
    //   94: aload 7
    //   96: astore 6
    //   98: aload 7
    //   100: iload_2
    //   101: i2f
    //   102: fload_1
    //   103: fdiv
    //   104: f2i
    //   105: iload_3
    //   106: i2f
    //   107: fload_1
    //   108: fdiv
    //   109: f2i
    //   110: iconst_1
    //   111: invokestatic 75	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   114: astore 7
    //   116: aload 7
    //   118: astore 4
    //   120: aload 7
    //   122: astore 5
    //   124: aload 7
    //   126: astore 6
    //   128: aload 7
    //   130: aload_0
    //   131: getfield 69	com/tencent/comic/hippy/view/BoodoHippyImageView:mBlurRadius	I
    //   134: i2f
    //   135: fload_1
    //   136: fdiv
    //   137: f2i
    //   138: invokestatic 81	com/tencent/mobileqq/utils/StackBlur:a	(Landroid/graphics/Bitmap;I)V
    //   141: aload 7
    //   143: astore 4
    //   145: aload 7
    //   147: astore 5
    //   149: aload 7
    //   151: astore 8
    //   153: aload 7
    //   155: astore 6
    //   157: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +105 -> 265
    //   163: aload 7
    //   165: astore 4
    //   167: aload 7
    //   169: astore 5
    //   171: aload 7
    //   173: astore 6
    //   175: ldc 88
    //   177: iconst_2
    //   178: iconst_4
    //   179: anewarray 90	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: ldc 91
    //   186: aastore
    //   187: dup
    //   188: iconst_1
    //   189: aload_0
    //   190: getfield 69	com/tencent/comic/hippy/view/BoodoHippyImageView:mBlurRadius	I
    //   193: invokestatic 97	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   196: aastore
    //   197: dup
    //   198: iconst_2
    //   199: ldc 99
    //   201: aastore
    //   202: dup
    //   203: iconst_3
    //   204: fload_1
    //   205: invokestatic 104	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   208: aastore
    //   209: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   212: aload 7
    //   214: astore 8
    //   216: goto +49 -> 265
    //   219: astore 5
    //   221: goto +52 -> 273
    //   224: astore 6
    //   226: aload 5
    //   228: astore 4
    //   230: ldc 88
    //   232: iconst_1
    //   233: aload 6
    //   235: iconst_0
    //   236: anewarray 90	java/lang/Object
    //   239: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   242: aload 5
    //   244: astore 8
    //   246: goto +19 -> 265
    //   249: aload 6
    //   251: astore 4
    //   253: ldc 88
    //   255: iconst_1
    //   256: ldc 114
    //   258: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: aload 6
    //   263: astore 8
    //   265: aload_0
    //   266: aload 8
    //   268: aconst_null
    //   269: invokevirtual 121	com/tencent/comic/hippy/view/BoodoHippyImageView:onGaussianBlurComplete	(Landroid/graphics/Bitmap;Ljava/util/Map;)V
    //   272: return
    //   273: aload_0
    //   274: aload 4
    //   276: aconst_null
    //   277: invokevirtual 121	com/tencent/comic/hippy/view/BoodoHippyImageView:onGaussianBlurComplete	(Landroid/graphics/Bitmap;Ljava/util/Map;)V
    //   280: aload 5
    //   282: athrow
    //   283: ldc 88
    //   285: iconst_1
    //   286: ldc 123
    //   288: invokestatic 117	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: return
    //   292: astore 4
    //   294: goto -45 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	this	BoodoHippyImageView
    //   85	120	1	f	float
    //   44	57	2	i	int
    //   62	44	3	j	int
    //   29	246	4	localObject1	Object
    //   292	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   33	137	5	localBitmap1	Bitmap
    //   219	62	5	localObject2	Object
    //   37	137	6	localBitmap2	Bitmap
    //   224	38	6	localException	java.lang.Exception
    //   9	204	7	localBitmap3	Bitmap
    //   151	116	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   39	45	219	finally
    //   57	63	219	finally
    //   75	86	219	finally
    //   98	116	219	finally
    //   128	141	219	finally
    //   157	163	219	finally
    //   175	212	219	finally
    //   230	242	219	finally
    //   253	261	219	finally
    //   39	45	224	java/lang/Exception
    //   57	63	224	java/lang/Exception
    //   75	86	224	java/lang/Exception
    //   98	116	224	java/lang/Exception
    //   128	141	224	java/lang/Exception
    //   157	163	224	java/lang/Exception
    //   175	212	224	java/lang/Exception
    //   39	45	292	java/lang/OutOfMemoryError
    //   57	63	292	java/lang/OutOfMemoryError
    //   75	86	292	java/lang/OutOfMemoryError
    //   98	116	292	java/lang/OutOfMemoryError
    //   128	141	292	java/lang/OutOfMemoryError
    //   157	163	292	java/lang/OutOfMemoryError
    //   175	212	292	java/lang/OutOfMemoryError
  }
  
  private void init()
  {
    this.mBlurRadius = 0;
    this.mBlurBitmap = null;
    this.mBlurBitmapKey = null;
  }
  
  protected Bitmap getBitmap()
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setBlurRadius blurRadius:");
      localStringBuilder.append(paramInt);
      QLog.d("hippyImageView", 2, localStringBuilder.toString());
    }
  }
  
  protected boolean shouldSetContent()
  {
    if ((this.mBlurRadius > 0) && (this.mSourceDrawable != null) && (this.mSourceDrawable.getBitmap() != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getUrl());
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(this.mBlurRadius);
      localObject = ((StringBuilder)localObject).toString();
      if (((String)localObject).equals(this.mBlurBitmapKey)) {
        return true;
      }
      this.mBlurBitmapKey = ((String)localObject);
      ThreadManagerV2.excute(new BoodoHippyImageView.1(this), 16, null, false);
      return false;
    }
    return super.shouldSetContent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.hippy.view.BoodoHippyImageView
 * JD-Core Version:    0.7.0.1
 */