package com.tencent.biz.pubaccount.readinjoyAd.ad.manager;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import nnr;
import org.json.JSONObject;
import tns;

public final class GiftPackageManager$1
  implements Runnable
{
  public GiftPackageManager$1(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    try
    {
      Object localObject = new Bundle();
      JSONObject localJSONObject = tns.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, this.c, this.d);
      nnr.a(new Bundle());
      ((Bundle)localObject).putString("data", localJSONObject.toString());
      localObject = nnr.a(BaseApplicationImpl.getContext(), "https://ag.qq.com/api/actionReport", "GET", (Bundle)localObject, null);
      if (localObject != null) {
        new JSONObject(new String((byte[])localObject));
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.manager.GiftPackageManager.1
 * JD-Core Version:    0.7.0.1
 */