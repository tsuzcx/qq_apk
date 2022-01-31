package com.tencent.algo;

import android.graphics.Bitmap;
import com.microrapid.lensFlare.LensFlareCpuFilter;
import com.microrapid.opencv.GlowForgCpuFilter;
import com.tencent.algo.filter.DetailEnhanceFilter;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.filter.art.BokehFilter;
import com.tencent.filter.art.DepthFilter;
import com.tencent.filter.ttpic.NightFilter;
import com.tencent.view.FilterEngineFactory;
import com.tencent.view.FilterFactory;
import com.tencent.view.Photo;
import com.tencent.view.RendererUtils;
import java.util.HashMap;
import java.util.Map;

public class PtuFilterFactory
  extends FilterFactory
{
  public static BaseFilter createFilter(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return FilterFactory.createFilter(paramInt);
    case 218: 
      return new NightFilter();
    case 231: 
      return new DetailEnhanceFilter();
    case 126: 
      return new GlowForgCpuFilter();
    case 203: 
      return new LensFlareCpuFilter();
    case 82: 
      return new BokehFilter();
    }
    return new DepthFilter();
  }
  
  public static BaseFilter createFilter(String paramString, int paramInt)
  {
    paramString = createFilter(filterIdFromString(paramString, paramInt));
    HashMap localHashMap = new HashMap();
    localHashMap.put("effectIndex", Integer.valueOf(paramInt));
    paramString.setParameterDic(localHashMap);
    localHashMap.clear();
    return paramString;
  }
  
  public static int filterIdFromString(String paramString, int paramInt)
  {
    return FilterFactory.filterIdFromString(paramString, paramInt);
  }
  
  public static boolean isSupportOrignalProcess(int paramInt)
  {
    return FilterFactory.isSupportOrignalProcess(paramInt);
  }
  
  public static void renderBitmapByFilterID(Bitmap paramBitmap, int paramInt1, int paramInt2, float paramFloat)
  {
    BaseFilter localBaseFilter1 = createFilter(paramInt1);
    Object localObject1 = new HashMap();
    ((Map)localObject1).put("effectIndex", Integer.valueOf(paramInt2));
    localBaseFilter1.setParameterDic((Map)localObject1);
    ((Map)localObject1).clear();
    if (localBaseFilter1.isAdjustFilter()) {
      localBaseFilter1.setAdjustParam(paramFloat);
    }
    Object localObject2;
    if (localBaseFilter1.isGPUProcess())
    {
      localBaseFilter1.ApplyGLSLFilter(true, paramBitmap.getWidth(), paramBitmap.getHeight());
      if ((!localBaseFilter1.isAdjustFilter()) && (paramFloat < 1.0F))
      {
        localObject1 = FilterFactory.createFilter(117);
        localBaseFilter1.getLastFilter().setNextFilter((BaseFilter)localObject1, new int[] { -1 });
        ((BaseFilter)localObject1).setAdjustParam(paramFloat);
        ((BaseFilter)localObject1).ApplyGLSLFilter(true, paramBitmap.getWidth(), paramBitmap.getHeight());
      }
      localObject1 = new Frame();
      if (localBaseFilter1.isSupportForGloableRender())
      {
        localObject2 = QImage.BindBitmap(paramBitmap);
        localBaseFilter1.RendProcessImage((QImage)localObject2, (Frame)localObject1);
        ((QImage)localObject2).UnBindBitmap(paramBitmap);
      }
      for (;;)
      {
        localBaseFilter1.ClearGLSL();
        ((Frame)localObject1).clear();
        return;
        localObject2 = Photo.createWithoutRecycle(paramBitmap);
        localBaseFilter1.RenderProcess(((Photo)localObject2).texture(), ((Photo)localObject2).width(), ((Photo)localObject2).height(), ((Photo)localObject2).texture(), 0.0D, (Frame)localObject1);
        RendererUtils.saveTextureToBitmap(((Photo)localObject2).texture(), ((Photo)localObject2).width(), ((Photo)localObject2).height(), paramBitmap);
        ((Photo)localObject2).clear();
      }
    }
    localObject1 = QImage.Bitmap2QImage(paramBitmap);
    localBaseFilter1.ApplyFilter((QImage)localObject1);
    if ((!localBaseFilter1.isAdjustFilter()) && (paramFloat < 1.0F))
    {
      localObject2 = QImage.Bitmap2QImage(paramBitmap);
      BaseFilter localBaseFilter2 = FilterFactory.createFilter(1);
      localBaseFilter2.setAdjustParam(paramFloat);
      localBaseFilter2.ApplyGLSLFilter(true, ((QImage)localObject1).getWidth(), ((QImage)localObject1).getHeight());
      paramInt1 = RendererUtils.createTexture();
      GLSLRender.nativeTextImage((QImage)localObject1, paramInt1);
      localBaseFilter2.setTextureParam(paramInt1, 0);
      Frame localFrame = new Frame();
      localBaseFilter1.RendProcessImage((QImage)localObject2, localFrame);
      localFrame.clear();
      localBaseFilter2.ClearGLSL();
      RendererUtils.clearTexture(paramInt1);
      ((QImage)localObject2).ToBitmap(paramBitmap);
      ((QImage)localObject2).Dispose();
    }
    for (;;)
    {
      ((QImage)localObject1).Dispose();
      return;
      ((QImage)localObject1).ToBitmap(paramBitmap);
    }
  }
  
  public static void renderBitmapByFilterIDAsync(Bitmap paramBitmap, final int paramInt1, final int paramInt2, final float paramFloat, final Runnable paramRunnable)
  {
    paramBitmap = new Runnable()
    {
      public void run()
      {
        FilterEngineFactory.getInstance().usecurruntContext();
        PtuFilterFactory.renderBitmapByFilterID(this.val$src, paramInt1, paramInt2, paramFloat);
        if (paramRunnable != null) {
          paramRunnable.run();
        }
      }
    };
    FilterEngineFactory.getInstance().queue(paramBitmap);
  }
  
  public static void renderBitmapByFilterIDAsync(Bitmap paramBitmap, String paramString, int paramInt, float paramFloat, Runnable paramRunnable)
  {
    renderBitmapByFilterIDAsync(paramBitmap, filterIdFromString(paramString, paramInt), paramInt, paramFloat, paramRunnable);
  }
  
  public static void renderBitmapByFilterIDSync(Bitmap paramBitmap, final int paramInt1, final int paramInt2, final float paramFloat)
  {
    paramBitmap = new Runnable()
    {
      public void run()
      {
        FilterEngineFactory.getInstance().usecurruntContext();
        PtuFilterFactory.renderBitmapByFilterID(this.val$src, paramInt1, paramInt2, paramFloat);
        try
        {
          notify();
          return;
        }
        finally {}
      }
    };
    FilterEngineFactory.getInstance().queue(paramBitmap);
    try
    {
      paramBitmap.wait();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  public static void renderBitmapByFilterIDSync(Bitmap paramBitmap, String paramString, int paramInt, float paramFloat)
  {
    renderBitmapByFilterIDSync(paramBitmap, filterIdFromString(paramString, paramInt), paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.algo.PtuFilterFactory
 * JD-Core Version:    0.7.0.1
 */