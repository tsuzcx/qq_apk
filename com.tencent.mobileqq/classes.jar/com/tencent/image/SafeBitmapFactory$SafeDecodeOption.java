package com.tencent.image;

import android.graphics.BitmapFactory.Options;
import java.util.HashMap;

public class SafeBitmapFactory$SafeDecodeOption
{
  public String dataSourceType = "";
  public long flashTestThreshold = -1L;
  public boolean inNeedCache = true;
  public boolean inNeedFlashBackTest = true;
  public BitmapFactory.Options inOptions = null;
  public int isBeforeFlashBackPic = -1;
  public int isBeforeFlashBackPicRegion = -1;
  public boolean isGetBitmap = false;
  public boolean isInJustDecodeBounds = false;
  public int isPng = -1;
  public boolean needFlashBackTest = false;
  public boolean needRegionDecode = false;
  public long pxThreshold = -1L;
  public long ram = -1L;
  public int ramThreshold = -1;
  public int rawHeight = -1;
  public int rawWidth = -1;
  public int regionDecodeOpen = -1;
  public long runTime = -1L;
  
  public HashMap<String, String> getInfo()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RegionDecodeInfo{  isGetBitmap=");
    localStringBuilder.append(this.isGetBitmap);
    localStringBuilder.append(", runTime=");
    localStringBuilder.append(this.runTime);
    localStringBuilder.append(", needRegionDecode=");
    localStringBuilder.append(this.needRegionDecode);
    localStringBuilder.append(", inNeedCache=");
    localStringBuilder.append(this.inNeedCache);
    localStringBuilder.append(", inNeedFlashBackTest=");
    localStringBuilder.append(this.inNeedFlashBackTest);
    Object localObject = this.inOptions;
    String str = "";
    if (localObject != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", inSampleSize=");
      ((StringBuilder)localObject).append(this.inOptions.inSampleSize);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", isInJustDecodeBounds=");
    localStringBuilder.append(this.isInJustDecodeBounds);
    int i = this.regionDecodeOpen;
    boolean bool2 = false;
    boolean bool1;
    if (i == -1)
    {
      localObject = "";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", regionDecodeOpen=");
      if (this.regionDecodeOpen == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((StringBuilder)localObject).append(bool1);
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    if (this.dataSourceType.equals(""))
    {
      localObject = "";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", dataSourceType=");
      ((StringBuilder)localObject).append(this.dataSourceType);
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    if (this.rawWidth == -1)
    {
      localObject = "";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", rawWidth=");
      ((StringBuilder)localObject).append(this.rawWidth);
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    if (this.rawHeight == -1)
    {
      localObject = "";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", rawHeight=");
      ((StringBuilder)localObject).append(this.rawHeight);
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    if (this.isPng == -1)
    {
      localObject = "";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", isPng=");
      if (this.isPng == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((StringBuilder)localObject).append(bool1);
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", needFlashBackTest=");
    localStringBuilder.append(this.needFlashBackTest);
    if (this.isBeforeFlashBackPic == -1)
    {
      localObject = "";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", isBeforeFlashBackPic=");
      bool1 = bool2;
      if (this.isBeforeFlashBackPic == 1) {
        bool1 = true;
      }
      ((StringBuilder)localObject).append(bool1);
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    if (this.ram == -1L)
    {
      localObject = "";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", ram=");
      ((StringBuilder)localObject).append(this.ram);
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    if (this.ramThreshold == -1)
    {
      localObject = "";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", ramThreshold=");
      ((StringBuilder)localObject).append(this.ramThreshold);
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    if (this.pxThreshold == -1L)
    {
      localObject = "";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", pxThreshold=");
      ((StringBuilder)localObject).append(this.pxThreshold);
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    if (this.flashTestThreshold == -1L)
    {
      localObject = str;
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", flashTestThreshold=");
      ((StringBuilder)localObject).append(this.flashTestThreshold);
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.SafeBitmapFactory.SafeDecodeOption
 * JD-Core Version:    0.7.0.1
 */