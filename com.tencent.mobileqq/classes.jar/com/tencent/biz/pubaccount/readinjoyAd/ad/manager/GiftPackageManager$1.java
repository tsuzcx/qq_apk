package com.tencent.biz.pubaccount.readinjoyAd.ad.manager;

import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import org.json.JSONObject;

final class GiftPackageManager$1
  implements Runnable
{
  GiftPackageManager$1(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    try
    {
      Object localObject = new Bundle();
      JSONObject localJSONObject = GiftPackageManager.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, this.c, this.d);
      HttpUtil.addCookie(new Bundle());
      ((Bundle)localObject).putString("data", localJSONObject.toString());
      localObject = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), "https://ag.qq.com/api/actionReport", "GET", (Bundle)localObject, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.manager.GiftPackageManager.1
 * JD-Core Version:    0.7.0.1
 */