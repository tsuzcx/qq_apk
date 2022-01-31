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
    int j = 1;
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder().append("");
    if (this.isGetBitmap)
    {
      i = 1;
      localHashMap.put("isGetBitmap", i);
      localHashMap.put("runTime", "" + this.runTime);
      localStringBuilder = new StringBuilder().append("");
      if (!this.needRegionDecode) {
        break label684;
      }
      i = 1;
      label101:
      localHashMap.put("needRegionDecode", i);
      localStringBuilder = new StringBuilder().append("");
      if (!this.inNeedCache) {
        break label689;
      }
      i = 1;
      label140:
      localHashMap.put("needCache", i);
      localStringBuilder = new StringBuilder().append("");
      if (!this.inNeedFlashBackTest) {
        break label694;
      }
      i = 1;
      label179:
      localHashMap.put("inNeedFlashBackTest", i);
      if (this.inOptions != null) {
        localHashMap.put("inSampleSize", "" + this.inOptions.inSampleSize);
      }
      localStringBuilder = new StringBuilder().append("");
      if (!this.needFlashBackTest) {
        break label699;
      }
      i = 1;
      label257:
      localHashMap.put("needFlashBackTest", i);
      localStringBuilder = new StringBuilder().append("");
      if (!this.isInJustDecodeBounds) {
        break label704;
      }
    }
    label684:
    label689:
    label694:
    label699:
    label704:
    for (int i = j;; i = 0)
    {
      localHashMap.put("isInJustDecodeBounds", i);
      if (this.regionDecodeOpen != -1) {
        localHashMap.put("regionDecodeOpen", "" + this.regionDecodeOpen);
      }
      if (!this.dataSourceType.equals("")) {
        localHashMap.put("dataSourceType", this.dataSourceType);
      }
      if (this.rawWidth != -1) {
        localHashMap.put("rawWidth", "" + this.rawWidth);
      }
      if (this.rawHeight != -1) {
        localHashMap.put("rawHeight", "" + this.rawHeight);
      }
      if (this.isPng != -1) {
        localHashMap.put("isPng", "" + this.isPng);
      }
      if (this.isBeforeFlashBackPic != -1) {
        localHashMap.put("isBeforeFlashBackPic", "" + this.isBeforeFlashBackPic);
      }
      if (this.ram != -1L) {
        localHashMap.put("ram", "" + this.ram);
      }
      if (this.ramThreshold != -1) {
        localHashMap.put("ramThreshold", "" + this.ramThreshold);
      }
      if (this.pxThreshold != -1L) {
        localHashMap.put("pxThreshold", "" + this.pxThreshold);
      }
      if (this.flashTestThreshold != -1L) {
        localHashMap.put("flashTestThreshold", "" + this.flashTestThreshold);
      }
      return localHashMap;
      i = 0;
      break;
      i = 0;
      break label101;
      i = 0;
      break label140;
      i = 0;
      break label179;
      i = 0;
      break label257;
    }
  }
  
  public String toString()
  {
    boolean bool2 = true;
    StringBuilder localStringBuilder = new StringBuilder().append("RegionDecodeInfo{  isGetBitmap=").append(this.isGetBitmap).append(", runTime=").append(this.runTime).append(", needRegionDecode=").append(this.needRegionDecode).append(", inNeedCache=").append(this.inNeedCache).append(", inNeedFlashBackTest=").append(this.inNeedFlashBackTest);
    if (this.inOptions != null)
    {
      localObject = ", inSampleSize=" + this.inOptions.inSampleSize;
      localStringBuilder = localStringBuilder.append((String)localObject).append(", isInJustDecodeBounds=").append(this.isInJustDecodeBounds);
      if (this.regionDecodeOpen != -1) {
        break label352;
      }
      localObject = "";
      localStringBuilder = localStringBuilder.append((String)localObject);
      if (!this.dataSourceType.equals("")) {
        break label392;
      }
      localObject = "";
      label158:
      localStringBuilder = localStringBuilder.append((String)localObject);
      if (this.rawWidth != -1) {
        break label418;
      }
      localObject = "";
      label177:
      localStringBuilder = localStringBuilder.append((String)localObject);
      if (this.rawHeight != -1) {
        break label444;
      }
      localObject = "";
      label196:
      localStringBuilder = localStringBuilder.append((String)localObject);
      if (this.isPng != -1) {
        break label470;
      }
      localObject = "";
      localStringBuilder = localStringBuilder.append((String)localObject).append(", needFlashBackTest=").append(this.needFlashBackTest);
      if (this.isBeforeFlashBackPic != -1) {
        break label510;
      }
      localObject = "";
      localStringBuilder = localStringBuilder.append((String)localObject);
      if (this.ram != -1L) {
        break label550;
      }
      localObject = "";
      label268:
      localStringBuilder = localStringBuilder.append((String)localObject);
      if (this.ramThreshold != -1) {
        break label576;
      }
      localObject = "";
      label287:
      localStringBuilder = localStringBuilder.append((String)localObject);
      if (this.pxThreshold != -1L) {
        break label602;
      }
      localObject = "";
      label309:
      localStringBuilder = localStringBuilder.append((String)localObject);
      if (this.flashTestThreshold != -1L) {
        break label628;
      }
    }
    label352:
    label628:
    for (Object localObject = "";; localObject = ", flashTestThreshold=" + this.flashTestThreshold)
    {
      return (String)localObject + '}';
      localObject = "";
      break;
      localObject = new StringBuilder().append(", regionDecodeOpen=");
      if (this.regionDecodeOpen == 1) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        localObject = bool1;
        break;
      }
      localObject = ", dataSourceType=" + this.dataSourceType;
      break label158;
      localObject = ", rawWidth=" + this.rawWidth;
      break label177;
      localObject = ", rawHeight=" + this.rawHeight;
      break label196;
      localObject = new StringBuilder().append(", isPng=");
      if (this.isPng == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        localObject = bool1;
        break;
      }
      label510:
      localObject = new StringBuilder().append(", isBeforeFlashBackPic=");
      if (this.isBeforeFlashBackPic == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        localObject = bool1;
        break;
      }
      localObject = ", ram=" + this.ram;
      break label268;
      localObject = ", ramThreshold=" + this.ramThreshold;
      break label287;
      localObject = ", pxThreshold=" + this.pxThreshold;
      break label309;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.SafeBitmapFactory.SafeDecodeOption
 * JD-Core Version:    0.7.0.1
 */