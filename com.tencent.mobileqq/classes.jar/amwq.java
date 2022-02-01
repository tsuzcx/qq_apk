import android.text.TextUtils;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.ads.CmGameBannerAds.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class amwq
{
  private int a;
  
  public amwq(int paramInt)
  {
    this.a = paramInt;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("bannerId", paramInt1);
      localJSONObject.put("errCode", paramInt3);
      amwn.a().callbackFromRequest(paramLong, paramInt2, "sc.game_ad_banner_load.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameBannerAds", 1, localThrowable, new Object[0]);
    }
  }
  
  public void a() {}
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameBannerAds", 2, new Object[] { "[loadBannerAd], bannerId:", Integer.valueOf(paramInt2), ",viewId:", Integer.valueOf(paramInt1) });
    }
    ThreadManager.getUIHandler().post(new CmGameBannerAds.1(this, paramLong, paramInt2));
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    boolean bool;
    do
    {
      do
      {
        for (;;)
        {
          return;
          try
          {
            paramString2 = new JSONObject(paramString2);
            int i = paramString2.optInt("bannerId");
            if (!"cs.game_ad_banner_close.local".equals(paramString1)) {
              if ("cs.game_ad_banner_load.local".equals(paramString1))
              {
                a(paramLong, paramString2.optInt("viewId"), i);
                return;
              }
            }
          }
          catch (Throwable paramString1)
          {
            QLog.e("cmgame_process.CmGameBannerAds", 1, paramString1, new Object[0]);
            return;
          }
        }
      } while (("cs.game_ad_banner_show.local".equals(paramString1)) || ("cs.game_ad_banner_hide.local".equals(paramString1)));
      bool = "cs.game_ad_banner_resize.local".equals(paramString1);
    } while (!bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwq
 * JD-Core Version:    0.7.0.1
 */