package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;

public class CloseableBitmap
{
  Reference a;
  
  public CloseableBitmap(Bitmap paramBitmap, Releaser paramReleaser)
  {
    this.a = new Reference(paramBitmap, paramReleaser);
    if (QLog.isColorLevel()) {
      Utils.a(toString(), "onCreate", true);
    }
  }
  
  public CloseableBitmap(Reference paramReference)
  {
    paramReference.a();
    this.a = paramReference;
    if (QLog.isColorLevel()) {
      Utils.a(toString(), "createFromClone", true);
    }
  }
  
  public Bitmap a()
  {
    return (Bitmap)this.a.a();
  }
  
  public CloseableBitmap a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        Utils.a(toString(), "clone", true);
      }
      CloseableBitmap localCloseableBitmap = new CloseableBitmap(this.a);
      return localCloseableBitmap;
    }
    finally {}
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/biz/pubaccount/readinjoy/view/imageloader/CloseableBitmap:a	Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/Reference;
    //   6: ifnull +34 -> 40
    //   9: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +13 -> 25
    //   15: aload_0
    //   16: invokevirtual 28	com/tencent/biz/pubaccount/readinjoy/view/imageloader/CloseableBitmap:toString	()Ljava/lang/String;
    //   19: ldc 54
    //   21: iconst_1
    //   22: invokestatic 35	com/tencent/biz/pubaccount/readinjoy/view/imageloader/Utils:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   25: aload_0
    //   26: getfield 18	com/tencent/biz/pubaccount/readinjoy/view/imageloader/CloseableBitmap:a	Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/Reference;
    //   29: invokevirtual 57	com/tencent/biz/pubaccount/readinjoy/view/imageloader/Reference:b	()V
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield 18	com/tencent/biz/pubaccount/readinjoy/view/imageloader/CloseableBitmap:a	Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/Reference;
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: aload_0
    //   41: invokevirtual 28	com/tencent/biz/pubaccount/readinjoy/view/imageloader/CloseableBitmap:toString	()Ljava/lang/String;
    //   44: ldc 59
    //   46: invokestatic 62	com/tencent/biz/pubaccount/readinjoy/view/imageloader/Utils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: goto -12 -> 37
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	CloseableBitmap
    //   52	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	52	finally
    //   25	37	52	finally
    //   37	39	52	finally
    //   40	49	52	finally
    //   53	55	52	finally
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("zimage.closeable@").append(hashCode()).append("_bitmap@");
    if ((this.a != null) && (this.a.a() != null)) {}
    for (Integer localInteger = Integer.valueOf(((Bitmap)this.a.a()).hashCode());; localInteger = null) {
      return localInteger;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.CloseableBitmap
 * JD-Core Version:    0.7.0.1
 */