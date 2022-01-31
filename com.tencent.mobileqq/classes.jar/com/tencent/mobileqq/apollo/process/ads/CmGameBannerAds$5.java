package com.tencent.mobileqq.apollo.process.ads;

import aany;
import aatp;
import akwd;
import akwg;
import akwi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.gdtad.api.banner.GdtBannerAd;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class CmGameBannerAds$5
  implements Runnable
{
  public CmGameBannerAds$5(akwg paramakwg, int paramInt1, int paramInt2, int paramInt3, long paramLong) {}
  
  public void run()
  {
    Object localObject1;
    try
    {
      localObject1 = akwg.a(this.this$0);
      if (localObject1 == null) {
        return;
      }
      akwi localakwi = (akwi)akwg.a(this.this$0).get(Integer.valueOf(this.jdField_a_of_type_Int));
      if (localakwi == null) {
        return;
      }
      if (localakwi.jdField_a_of_type_AndroidViewView != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameBannerAds", 2, "banner view exists, show it.");
        }
        localakwi.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
    }
    catch (Throwable localThrowable1)
    {
      QLog.e("cmgame_process.CmGameBannerAds", 1, localThrowable1, new Object[0]);
      return;
    }
    Object localObject2 = localThrowable1.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd;
    if ((localObject2 != null) && (((GdtBannerAd)localObject2).isLoaded()) && (!((GdtBannerAd)localObject2).isInvalidated()))
    {
      int i = aatp.a(akwg.a(this.this$0), 1080, 1026);
      int j = aatp.a(akwg.a(this.this$0), 1080, 249);
      localObject2 = ((GdtBannerAd)localObject2).render((Context)localObject1, i, j);
      if ((localObject2 != null) && (((aany)localObject2).a() != null))
      {
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, j);
        int k = akwg.b(this.this$0);
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameBannerAds", 2, new Object[] { "screenH:", Integer.valueOf(k) });
        }
        if (k <= 0)
        {
          QLog.i("cmgame_process.CmGameBannerAds", 1, "view height isn't correct.");
          return;
        }
        localLayoutParams.topMargin = (k - this.b - j);
        localLayoutParams.leftMargin = this.c;
        localObject1 = (FrameLayout)((Activity)localObject1).findViewById(2131363073);
        if (localObject1 != null)
        {
          ((FrameLayout)localObject1).addView(((aany)localObject2).a(), localLayoutParams);
          localThrowable1.jdField_a_of_type_AndroidViewView = ((aany)localObject2).a();
        }
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("bannerId", this.jdField_a_of_type_Int);
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("x", this.c);
          ((JSONObject)localObject1).put("y", this.b);
          ((JSONObject)localObject1).put("w", i);
          ((JSONObject)localObject1).put("h", j);
          localJSONObject.put("style", localObject1);
          akwd.a().callbackFromRequest(this.jdField_a_of_type_Long, 0, "sc.game_ad_banner_show.local", localJSONObject.toString());
          return;
        }
        catch (Throwable localThrowable2)
        {
          QLog.e("cmgame_process.CmGameBannerAds", 1, localThrowable2, new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ads.CmGameBannerAds.5
 * JD-Core Version:    0.7.0.1
 */