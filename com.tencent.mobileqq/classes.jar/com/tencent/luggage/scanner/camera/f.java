package com.tencent.luggage.scanner.camera;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import com.tencent.luggage.wxa.qz.o;
import java.util.List;

public class f
  extends a
{
  private boolean r()
  {
    if ((this.a != null) && (a())) {
      try
      {
        List localList = this.a.getParameters().getSupportedFlashModes();
        if ((localList != null) && (localList.contains("torch"))) {
          return true;
        }
        o.d("Luggage.WxScanCamera", "camera not support flash!!");
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isFlashSupported error: ");
        localStringBuilder.append(localException.getMessage());
        o.b("Luggage.WxScanCamera", localStringBuilder.toString());
      }
    }
    return false;
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if (this.a != null)
      {
        Object localObject1 = this.a.getParameters();
        localObject2 = ((Camera.Parameters)localObject1).get("zoom-supported");
        if ((!ScanUtil.isNullOrNil((String)localObject2)) && (Boolean.parseBoolean((String)localObject2)))
        {
          localObject1 = ((Camera.Parameters)localObject1).getZoomRatios();
          if (localObject1 == null) {
            return;
          }
          if (((List)localObject1).size() <= 0) {
            return;
          }
          if (paramBoolean)
          {
            this.n = (((List)localObject1).size() / 5);
            if (((Integer)((List)localObject1).get(this.n)).intValue() > 150) {
              this.n = a((List)localObject1, 150);
            }
          }
          else
          {
            this.n = 0;
          }
          int i = ((List)localObject1).size();
          double d = i;
          Double.isNaN(d);
          i = (int)(d / 1.5D);
          this.o = i;
          o.e("Luggage.WxScanCamera", "divideRatio: %f,max zoom: %d", new Object[] { Double.valueOf(1.5D), Integer.valueOf(this.o) });
          if (this.o < this.n) {
            this.o = this.n;
          } else if (((Integer)((List)localObject1).get(this.o)).intValue() > 400) {
            this.o = a((List)localObject1, 400);
          }
          o.d("Luggage.WxScanCamera", "default zoom:%d,default ratio:%d,max zoom:%d,max ratio:%d", new Object[] { Integer.valueOf(this.n), ((List)localObject1).get(this.n), Integer.valueOf(this.o), ((List)localObject1).get(this.o) });
          return;
        }
        o.d("Luggage.WxScanCamera", "not support zoom");
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("init zoom exception! ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      o.b("Luggage.WxScanCamera", ((StringBuilder)localObject2).toString());
    }
    return;
  }
  
  public boolean m()
  {
    return this.k;
  }
  
  public boolean n()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void o()
  {
    o.d("Luggage.WxScanCamera", String.format("openFlash, camera: %s, isPreviewing: %s", new Object[] { this.a, Boolean.valueOf(a()) }));
    if ((this.a != null) && (a())) {
      try
      {
        this.k = true;
        Camera.Parameters localParameters = this.a.getParameters();
        localObject = localParameters.getSupportedFlashModes();
        if ((localObject != null) && (((List)localObject).contains("torch")))
        {
          localParameters.setFlashMode("torch");
          this.a.setParameters(localParameters);
          o.d("Luggage.WxScanCamera", "open flash");
          return;
        }
        o.d("Luggage.WxScanCamera", "camera not support flash!!");
        return;
      }
      catch (Exception localException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openFlash error: ");
        ((StringBuilder)localObject).append(localException.getMessage());
        o.b("Luggage.WxScanCamera", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void p()
  {
    o.d("Luggage.WxScanCamera", String.format("closeFlash, camera: %s, isPreviewing: %s", new Object[] { this.a, Boolean.valueOf(a()) }));
    if ((this.a != null) && (a())) {
      try
      {
        this.k = false;
        Camera.Parameters localParameters = this.a.getParameters();
        localObject = localParameters.getSupportedFlashModes();
        if ((localObject != null) && (((List)localObject).contains("off")))
        {
          localParameters.setFlashMode("off");
          this.a.setParameters(localParameters);
          o.d("Luggage.WxScanCamera", "close flash");
          return;
        }
        o.d("Luggage.WxScanCamera", "camera not support close flash!!");
        return;
      }
      catch (Exception localException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("closeFlash error: ");
        ((StringBuilder)localObject).append(localException.getMessage());
        o.b("Luggage.WxScanCamera", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public int q()
  {
    return this.a.getParameters().getPreviewFormat();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.camera.f
 * JD-Core Version:    0.7.0.1
 */