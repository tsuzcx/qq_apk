package com.tencent.mobileqq.apollo.api.model;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import java.util.HashMap;
import java.util.Map;

public class ApolloSkeletonBounding
{
  public float brand1Height;
  public float brand1Width;
  public float brand1X;
  public float brand1Y;
  public float brand2Height;
  public float brand2Width;
  public float brand2X;
  public float brand2Y;
  public int brandMode;
  public float bubbleHeight;
  public float bubbleWidth;
  public float bubbleX;
  public float bubbleY;
  public String extendString;
  public Map<String, String> extraInfoMap;
  public String extraInfoString;
  public float giftHeight;
  public float giftWidth;
  public float giftX;
  public float giftY;
  public float height;
  public String name;
  public float width;
  public float x;
  public float y;
  
  public ApolloSkeletonBounding(String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16, float paramFloat17, float paramFloat18, float paramFloat19, float paramFloat20)
  {
    this.name = paramString1;
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.width = paramFloat3;
    this.height = paramFloat4;
    this.bubbleX = paramFloat5;
    this.bubbleY = paramFloat6;
    this.bubbleWidth = paramFloat7;
    this.bubbleHeight = paramFloat8;
    this.giftX = paramFloat9;
    this.giftY = paramFloat10;
    this.giftWidth = paramFloat11;
    this.giftHeight = paramFloat12;
    this.brand1X = paramFloat13;
    this.brand1Y = paramFloat14;
    this.brand1Width = paramFloat15;
    this.brand1Height = paramFloat16;
    this.brand2X = paramFloat17;
    this.brand2Y = paramFloat18;
    this.brand2Width = paramFloat19;
    this.brand2Height = paramFloat20;
    this.extendString = paramString2;
    this.extraInfoString = paramString3;
    parseExtraInfo();
  }
  
  private void parseExtraInfo()
  {
    this.extraInfoMap = new HashMap();
    Object localObject;
    if (!TextUtils.isEmpty(this.extraInfoString))
    {
      localObject = this.extraInfoString.split("&");
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          String[] arrayOfString = localObject[i].split("=");
          if ((arrayOfString != null) && (arrayOfString.length == 2)) {
            this.extraInfoMap.put(arrayOfString[0], arrayOfString[1]);
          }
          i += 1;
        }
      }
      localObject = (String)this.extraInfoMap.get("bubbleID");
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      this.brandMode = Integer.parseInt((String)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloSkeletonBounding", 1, "parse bubbleID exception=", localException);
    }
  }
  
  public String toString()
  {
    return "ApolloSkeletonBounding{name='" + this.name + '\'' + ", x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + ", bubbleX=" + this.bubbleX + ", bubbleY=" + this.bubbleY + ", bubbleWidth=" + this.bubbleWidth + ", bubbleHeight=" + this.bubbleHeight + ", giftX=" + this.giftX + ", giftY=" + this.giftY + ", giftWidth=" + this.giftWidth + ", giftHeight=" + this.giftHeight + ", brand1X=" + this.brand1X + ", brand1Y=" + this.brand1Y + ", brand1Width=" + this.brand1Width + ", brand1Height=" + this.brand1Height + ", brand2X=" + this.brand2X + ", brand2Y=" + this.brand2Y + ", brand2Width=" + this.brand2Width + ", brand2Height=" + this.brand2Height + ", extendString='" + this.extendString + '\'' + ", extraInfoString='" + this.extraInfoString + '\'' + ", extraInfoMap=" + this.extraInfoMap + ", brandMode=" + this.brandMode + '}';
  }
  
  public void updateData(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16, float paramFloat17, float paramFloat18, float paramFloat19, float paramFloat20, String paramString)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.width = paramFloat3;
    this.height = paramFloat4;
    this.bubbleX = paramFloat5;
    this.bubbleY = paramFloat6;
    this.bubbleWidth = paramFloat7;
    this.bubbleHeight = paramFloat8;
    this.giftX = paramFloat9;
    this.giftY = paramFloat10;
    this.giftWidth = paramFloat11;
    this.giftHeight = paramFloat12;
    this.brand1X = paramFloat13;
    this.brand1Y = paramFloat14;
    this.brand1Width = paramFloat15;
    this.brand1Height = paramFloat16;
    this.brand2X = paramFloat17;
    this.brand2Y = paramFloat18;
    this.brand2Width = paramFloat19;
    this.brand2Height = paramFloat20;
    this.extraInfoString = paramString;
    parseExtraInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.model.ApolloSkeletonBounding
 * JD-Core Version:    0.7.0.1
 */