package com.tencent.mapsdk.raster.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.mapsdk.rastercore.d.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public final class BitmapDescriptorFactory
{
  public static BitmapDescriptor defaultMarker()
  {
    return fromAsset("marker.png");
  }
  
  public static BitmapDescriptor fromAsset(String paramString)
  {
    try
    {
      paramString = BitmapDescriptorFactory.class.getResourceAsStream("/assets/" + paramString);
      Bitmap localBitmap = BitmapFactory.decodeStream(paramString);
      paramString.close();
      paramString = fromBitmap(localBitmap);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static BitmapDescriptor fromBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    return new BitmapDescriptor(paramBitmap);
  }
  
  public static BitmapDescriptor fromFile(String paramString)
  {
    try
    {
      paramString = new FileInputStream(new File(paramString));
      Bitmap localBitmap = BitmapFactory.decodeStream(paramString);
      paramString.close();
      paramString = fromBitmap(localBitmap);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static BitmapDescriptor fromPath(String paramString)
  {
    try
    {
      paramString = fromBitmap(BitmapFactory.decodeFile(paramString));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  /* Error */
  public static BitmapDescriptor fromResource(int paramInt)
  {
    // Byte code:
    //   0: invokestatic 83	com/tencent/mapsdk/rastercore/d/f:a	()Landroid/content/Context;
    //   3: astore_1
    //   4: aload_1
    //   5: ifnull +26 -> 31
    //   8: aload_1
    //   9: invokevirtual 89	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   12: iload_0
    //   13: invokevirtual 95	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   16: astore_1
    //   17: aload_1
    //   18: invokestatic 46	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   21: invokestatic 55	com/tencent/mapsdk/raster/model/BitmapDescriptorFactory:fromBitmap	(Landroid/graphics/Bitmap;)Lcom/tencent/mapsdk/raster/model/BitmapDescriptor;
    //   24: astore_2
    //   25: aload_1
    //   26: invokestatic 100	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   29: aload_2
    //   30: areturn
    //   31: aconst_null
    //   32: invokestatic 100	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   35: aconst_null
    //   36: areturn
    //   37: astore_1
    //   38: aconst_null
    //   39: astore_1
    //   40: aload_1
    //   41: invokestatic 100	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   44: aconst_null
    //   45: areturn
    //   46: astore_1
    //   47: aconst_null
    //   48: astore_3
    //   49: aload_1
    //   50: astore_2
    //   51: aload_3
    //   52: invokestatic 100	com/tencent/mapsdk/rastercore/c:a	(Ljava/io/Closeable;)V
    //   55: aload_2
    //   56: athrow
    //   57: astore_2
    //   58: aload_1
    //   59: astore_3
    //   60: goto -9 -> 51
    //   63: astore_2
    //   64: goto -24 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramInt	int
    //   3	23	1	localObject1	Object
    //   37	1	1	localException1	Exception
    //   39	2	1	localCloseable	java.io.Closeable
    //   46	13	1	localObject2	Object
    //   24	32	2	localObject3	Object
    //   57	1	2	localObject4	Object
    //   63	1	2	localException2	Exception
    //   48	12	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	37	java/lang/Exception
    //   8	17	37	java/lang/Exception
    //   0	4	46	finally
    //   8	17	46	finally
    //   17	25	57	finally
    //   17	25	63	java/lang/Exception
  }
  
  public static BitmapDescriptor fromView(View paramView)
  {
    Object localObject = null;
    try
    {
      Context localContext = f.a();
      if (localContext != null)
      {
        localObject = new FrameLayout(localContext);
        ((FrameLayout)localObject).addView(paramView);
        ((FrameLayout)localObject).destroyDrawingCache();
        localObject = fromBitmap(getViewBitmap((View)localObject));
      }
      return localObject;
    }
    catch (Exception paramView) {}
    return null;
  }
  
  private static Bitmap getViewBitmap(View paramView)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    paramView.buildDrawingCache();
    return paramView.getDrawingCache().copy(Bitmap.Config.ARGB_8888, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.BitmapDescriptorFactory
 * JD-Core Version:    0.7.0.1
 */