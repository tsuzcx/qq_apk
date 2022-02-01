package com.tencent.mobileqq.ar.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.qphone.base.util.QLog;

public class PromotionUtils$ARCardPromotionInfo
  extends PromotionUtils.BasePromotionInfo
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  private boolean m = false;
  private int n = 0;
  private boolean o = true;
  
  public void a(AppInterface paramAppInterface, Bundle paramBundle)
  {
    this.a = paramBundle.getString("PromotionID");
    this.b = paramBundle.getString("PromotionWords");
    this.c = paramBundle.getString("PromotionIconUrl");
    this.d = paramBundle.getString("PromotionUserFrom");
    this.e = paramBundle.getString("PromotionUserTo");
    this.f = paramBundle.getString("PromotionUserShareId");
    if ((!TextUtils.isEmpty(this.h)) && (TextUtils.equals(this.h, "1"))) {
      this.m = true;
    }
    try
    {
      this.d = NearbyURLSafeUtil.c(this.d);
      this.e = NearbyURLSafeUtil.c(this.e);
      label109:
      if ((!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(this.e)))
      {
        if (this.e.equals(paramAppInterface.getCurrentAccountUin()))
        {
          this.o = false;
          this.n = 1;
        }
        if (this.d.equals(paramAppInterface.getCurrentAccountUin()))
        {
          this.o = false;
          this.n = 2;
        }
      }
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("ARRelationShipPromotion, mPromotionId[");
      paramAppInterface.append(this.a);
      paramAppInterface.append("], mPromotionWords[");
      paramAppInterface.append(this.b);
      paramAppInterface.append("], mPromotionIconUrl[");
      paramAppInterface.append(this.c);
      paramAppInterface.append("], mRecoglizeMask[");
      paramAppInterface.append(this.g);
      paramAppInterface.append("], isMasterState[");
      paramAppInterface.append(this.o);
      paramAppInterface.append("]");
      QLog.w("ScanTorchActivity", 1, paramAppInterface.toString());
      return;
    }
    catch (Exception paramBundle)
    {
      break label109;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.utils.PromotionUtils.ARCardPromotionInfo
 * JD-Core Version:    0.7.0.1
 */