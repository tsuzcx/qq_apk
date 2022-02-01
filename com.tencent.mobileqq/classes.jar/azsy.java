import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.profile.lifeachivement.LifeAchivementHelper.1;
import com.tencent.qphone.base.util.QLog;

public class azsy
{
  public static String a(int paramInt)
  {
    String str = "";
    if ((paramInt >= 1) && (paramInt < 10000)) {
      str = String.valueOf(paramInt);
    }
    do
    {
      return str;
      if ((paramInt >= 10000) && (paramInt < 100000000))
      {
        if (paramInt % 10000 < 500) {
          return paramInt / 10000 + "万";
        }
        f = paramInt * 1.0F / 10000.0F;
        return Math.round(f * 10.0F) * 1.0F / 10.0F + "万";
      }
    } while (paramInt < 100000000);
    if (paramInt % 100000000 < 5000000) {
      return paramInt / 100000000 + "亿";
    }
    float f = paramInt * 1.0F / 1.0E+008F;
    return Math.round(f * 10.0F) * 1.0F / 10.0F + "亿";
  }
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LifeAchivementHelper", 2, String.format("jumpToLifeAchivementMiniAppAddPage miniAppUrl=%s", new Object[] { "mqqapi://miniapp/open?_atype=0&_mappid=1110348796&_mvid=&_path=pages%2Findex%2Findex&_vt=3&referer=2062&via=2062_3&_sig=1925072163" }));
    }
    MiniAppLauncher.startMiniApp(paramContext, "mqqapi://miniapp/open?_atype=0&_mappid=1110348796&_mvid=&_path=pages%2Findex%2Findex&_vt=3&referer=2062&via=2062_3&_sig=1925072163", 2062, null);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramString = "mqqapi://miniapp/open?_atype=0&_mappid=1110348796&_mvid=&_path=pages%2Fachievement%2Fachievement&_vt=3&referer=2062&via=2062_3&_sig=831969013&openid=" + paramString;
    if (QLog.isColorLevel()) {
      QLog.d("LifeAchivementHelper", 2, String.format("jumpToLifeAchivementMiniAppAchivementListPage miniAppUrl=%s", new Object[] { paramString }));
    }
    MiniAppLauncher.startMiniApp(paramContext, paramString, 2062, null);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramString = "mqqapi://miniapp/open?_atype=0&_mappid=1110348796&_mvid=&_path=pages%2Fachievement%2Fachievement&_vt=3&referer=2062&via=2062_3&_sig=831969013&openid=" + paramString + "&achievement_id=" + paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("LifeAchivementHelper", 2, String.format("jumpToLifeAchivementMiniAppAchiivementDetailPage miniAppUrl=%s", new Object[] { paramString }));
    }
    MiniAppLauncher.startMiniApp(paramContext, paramString, 2062, null);
  }
  
  public static void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.setClickable(false);
    paramView.postDelayed(new LifeAchivementHelper.1(paramView), 500L);
  }
  
  public static boolean a(Card paramCard, birs parambirs, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2;
    boolean bool3;
    label31:
    boolean bool1;
    if ((parambirs == null) || (parambirs.a(10)))
    {
      bool2 = true;
      if ((paramCard == null) || (paramCard.switch_life_achievement == 1)) {
        break label116;
      }
      bool3 = true;
      if (!paramBoolean1) {
        break label128;
      }
      if ((!bool2) || (!bool3)) {
        break label122;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LifeAchivementHelper", 2, String.format("shouldShowAchivementPanelOrNot configEnable:%s,switchEnable:%s,hasLifeAchivement:%s,isSelf:%s,result:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool1) }));
      }
      return bool1;
      bool2 = false;
      break;
      label116:
      bool3 = false;
      break label31;
      label122:
      bool1 = false;
      continue;
      label128:
      if ((bool2) && (bool3) && (paramBoolean2)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azsy
 * JD-Core Version:    0.7.0.1
 */