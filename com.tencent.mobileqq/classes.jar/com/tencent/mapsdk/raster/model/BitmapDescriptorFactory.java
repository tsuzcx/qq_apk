package com.tencent.mapsdk.raster.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.mapsdk.rastercore.d.e;
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
  
  public static BitmapDescriptor fromResource(int paramInt)
  {
    BitmapDescriptor localBitmapDescriptor = null;
    try
    {
      Context localContext = e.a();
      if (localContext != null) {
        localBitmapDescriptor = fromBitmap(BitmapFactory.decodeStream(localContext.getResources().openRawResource(paramInt)));
      }
      return localBitmapDescriptor;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static BitmapDescriptor fromView(View paramView)
  {
    Object localObject = null;
    try
    {
      Context localContext = e.a();
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