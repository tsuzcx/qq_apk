package com.tencent.mobileqq.apollo.model;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
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
  
  public ApolloSkeletonBounding(String paramString1, String paramString2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12)
  {
    this(paramString1, paramString2, null, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
  }
  
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
    if (!TextUtils.isEmpty(this.extraInfoString))
    {
      Object localObject = this.extraInfoString.split("&");
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
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
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
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ApolloSkeletonBounding{name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", x=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", y=");
    localStringBuilder.append(this.y);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.width);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.height);
    localStringBuilder.append(", bubbleX=");
    localStringBuilder.append(this.bubbleX);
    localStringBuilder.append(", bubbleY=");
    localStringBuilder.append(this.bubbleY);
    localStringBuilder.append(", bubbleWidth=");
    localStringBuilder.append(this.bubbleWidth);
    localStringBuilder.append(", bubbleHeight=");
    localStringBuilder.append(this.bubbleHeight);
    localStringBuilder.append(", giftX=");
    localStringBuilder.append(this.giftX);
    localStringBuilder.append(", giftY=");
    localStringBuilder.append(this.giftY);
    localStringBuilder.append(", giftWidth=");
    localStringBuilder.append(this.giftWidth);
    localStringBuilder.append(", giftHeight=");
    localStringBuilder.append(this.giftHeight);
    localStringBuilder.append(", brand1X=");
    localStringBuilder.append(this.brand1X);
    localStringBuilder.append(", brand1Y=");
    localStringBuilder.append(this.brand1Y);
    localStringBuilder.append(", brand1Width=");
    localStringBuilder.append(this.brand1Width);
    localStringBuilder.append(", brand1Height=");
    localStringBuilder.append(this.brand1Height);
    localStringBuilder.append(", brand2X=");
    localStringBuilder.append(this.brand2X);
    localStringBuilder.append(", brand2Y=");
    localStringBuilder.append(this.brand2Y);
    localStringBuilder.append(", brand2Width=");
    localStringBuilder.append(this.brand2Width);
    localStringBuilder.append(", brand2Height=");
    localStringBuilder.append(this.brand2Height);
    localStringBuilder.append(", extendString='");
    localStringBuilder.append(this.extendString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", extraInfoString='");
    localStringBuilder.append(this.extraInfoString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", extraInfoMap=");
    localStringBuilder.append(this.extraInfoMap);
    localStringBuilder.append(", brandMode=");
    localStringBuilder.append(this.brandMode);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void updateData(ApolloSkeletonBounding paramApolloSkeletonBounding)
  {
    this.x = paramApolloSkeletonBounding.x;
    this.y = paramApolloSkeletonBounding.y;
    this.width = paramApolloSkeletonBounding.width;
    this.height = paramApolloSkeletonBounding.height;
    this.bubbleX = paramApolloSkeletonBounding.bubbleX;
    this.bubbleY = paramApolloSkeletonBounding.bubbleY;
    this.bubbleWidth = paramApolloSkeletonBounding.bubbleWidth;
    this.bubbleHeight = paramApolloSkeletonBounding.bubbleHeight;
    this.giftX = paramApolloSkeletonBounding.giftX;
    this.giftY = paramApolloSkeletonBounding.giftY;
    this.giftWidth = paramApolloSkeletonBounding.giftWidth;
    this.giftHeight = paramApolloSkeletonBounding.giftHeight;
    this.brand1X = paramApolloSkeletonBounding.brand1X;
    this.brand1Y = paramApolloSkeletonBounding.brand1Y;
    this.brand1Width = paramApolloSkeletonBounding.brand1Width;
    this.brand1Height = paramApolloSkeletonBounding.brand1Height;
    this.brand2X = paramApolloSkeletonBounding.brand2X;
    this.brand2Y = paramApolloSkeletonBounding.brand2Y;
    this.brand2Width = paramApolloSkeletonBounding.brand2Width;
    this.brand2Height = paramApolloSkeletonBounding.brand2Height;
    this.extraInfoString = paramApolloSkeletonBounding.extraInfoString;
    parseExtraInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.model.ApolloSkeletonBounding
 * JD-Core Version:    0.7.0.1
 */