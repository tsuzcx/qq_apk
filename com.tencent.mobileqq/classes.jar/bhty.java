import QQService.EVIPSPEC;
import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qvip.QVipBigClubSVIP9Config;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.io.File;
import mqq.app.AppRuntime;

public class bhty
{
  private static long[] a = { 0L, 0L };
  
  public static int a(bhtz parambhtz)
  {
    if ((parambhtz == bhtz.b) || (parambhtz == bhtz.c)) {}
    do
    {
      return 2130847070;
      if (parambhtz == bhtz.d) {
        return 2130847069;
      }
      if (parambhtz == bhtz.e) {
        return 2130847071;
      }
    } while ((parambhtz != bhtz.f) && (parambhtz != bhtz.g));
    return 2130847067;
  }
  
  public static String a(int paramInt1, int paramInt2, long paramLong)
  {
    return a(paramInt1, paramInt2, paramLong, false);
  }
  
  private static String a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (String str = armt.c().mAPngIconUrl;; str = armt.c().mAPngIconUrlNewGray)
    {
      if (paramBoolean) {
        paramLong = 0L;
      }
      return String.format(str, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return paramString1 + File.separator + paramString2 + ".png";
  }
  
  public static String a(AppRuntime paramAppRuntime, String paramString, EVIPSPEC paramEVIPSPEC)
  {
    Object localObject = (anyw)paramAppRuntime.getManager(51);
    if (localObject != null)
    {
      localObject = ((anyw)localObject).e(paramString);
      if (localObject != null)
      {
        int i;
        if (paramEVIPSPEC == EVIPSPEC.E_SP_BIGCLUB)
        {
          i = VipUtils.a(paramAppRuntime, paramString, EVIPSPEC.E_SP_BIGCLUB);
          return a((i & 0xF) << 8 | i >> 8, ((Friends)localObject).getServiceLevel(paramEVIPSPEC), ((Friends)localObject).bigClubTemplateId, false);
        }
        if (paramEVIPSPEC == EVIPSPEC.E_SP_SUPERVIP)
        {
          i = VipUtils.a(paramAppRuntime, paramString, EVIPSPEC.E_SP_SUPERVIP);
          return a((i & 0xF) << 8 | i >> 8, ((Friends)localObject).getServiceLevel(paramEVIPSPEC), ((Friends)localObject).superVipTemplateId, false);
        }
        if (paramEVIPSPEC == EVIPSPEC.E_SP_QQVIP)
        {
          i = VipUtils.a(paramAppRuntime, paramString, EVIPSPEC.E_SP_QQVIP);
          return a((i & 0xF) << 8 | i >> 8, ((Friends)localObject).getServiceLevel(paramEVIPSPEC), 0L, false);
        }
      }
    }
    return a(0, 0, 0L, false);
  }
  
  public static String a(AppRuntime paramAppRuntime, String paramString, bhtz parambhtz, boolean paramBoolean)
  {
    paramAppRuntime = (anyw)paramAppRuntime.getManager(51);
    if (paramAppRuntime != null)
    {
      paramAppRuntime = paramAppRuntime.e(paramString);
      if (paramAppRuntime != null)
      {
        int i;
        if ((parambhtz == bhtz.f) || (parambhtz == bhtz.g))
        {
          i = paramAppRuntime.getServiceLevel(EVIPSPEC.E_SP_BIGCLUB);
          return a(parambhtz.a, i, paramAppRuntime.bigClubTemplateId, paramBoolean);
        }
        if ((parambhtz == bhtz.d) || (parambhtz == bhtz.e))
        {
          i = paramAppRuntime.getServiceLevel(EVIPSPEC.E_SP_SUPERVIP);
          return a(parambhtz.a, i, paramAppRuntime.superVipTemplateId, paramBoolean);
        }
        if ((parambhtz == bhtz.b) || (parambhtz == bhtz.c))
        {
          i = paramAppRuntime.getServiceLevel(EVIPSPEC.E_SP_QQVIP);
          return a(parambhtz.a, i, 0L, paramBoolean);
        }
      }
    }
    return a(0, 0, 0L, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramString = armt.c().getVipIconSettingsUrl(paramString);
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("uin", paramQQAppInterface);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, paramString, 256L, localIntent, false, -1);
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt > 0;
  }
  
  public static int[] a(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = (anyw)paramAppRuntime.getManager(51);
    if (paramAppRuntime != null)
    {
      paramAppRuntime = paramAppRuntime.e(paramString);
      if (paramAppRuntime != null) {
        return new int[] { paramAppRuntime.nameplateVipType, paramAppRuntime.grayNameplateFlag };
      }
    }
    return new int[] { 0, 0 };
  }
  
  private static String b(asxh paramasxh)
  {
    int i = VipUtils.a(paramasxh);
    i = (i & 0xF) << 8 | i >> 8;
    if ((i & 0xFF) == 3) {
      return a(i, paramasxh.mBigVipLevel, paramasxh.mTemplateId, false);
    }
    if ((i & 0xFF) == 2) {
      return a(i, paramasxh.mVipLevel, paramasxh.mTemplateId, false);
    }
    return null;
  }
  
  public static boolean b(int paramInt)
  {
    return paramInt == 1;
  }
  
  private static void c(String paramString, int paramInt, boolean paramBoolean)
  {
    long l;
    if ("VIA_SETTINGME".equals(paramString))
    {
      l = System.currentTimeMillis();
      if (Math.abs(l - a[0]) >= 3000L) {}
    }
    do
    {
      do
      {
        return;
        a[0] = l;
        e("0X800AA99", paramInt, paramBoolean);
        return;
        if (!"VIA_PROFILECARD".equals(paramString)) {
          break;
        }
        l = System.currentTimeMillis();
      } while (Math.abs(l - a[1]) < 3000L);
      a[1] = l;
      e("0X800AA9A", paramInt, paramBoolean);
      return;
      if ("VIA_AIO_TITLE".equals(paramString))
      {
        e("0X800AA9B", paramInt, paramBoolean);
        return;
      }
    } while (!"VIA_AIO_CHATSETTINGS".equals(paramString));
    e("0X800AA9C", paramInt, paramBoolean);
  }
  
  private static void d(String paramString, int paramInt, boolean paramBoolean)
  {
    if ("VIA_SETTINGME".equals(paramString)) {
      e("0X800AA9D", paramInt, paramBoolean);
    }
    do
    {
      return;
      if ("VIA_PROFILECARD".equals(paramString))
      {
        e("0X800AA9E", paramInt, paramBoolean);
        return;
      }
      if ("VIA_AIO_TITLE".equals(paramString))
      {
        e("0X800AA9F", paramInt, paramBoolean);
        return;
      }
    } while (!"VIA_AIO_CHATSETTINGS".equals(paramString));
    e("0X800AAA0", paramInt, paramBoolean);
  }
  
  private static void e(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 9;; i = 0)
    {
      bdll.b(null, "dc00898", "", "", "qq_vip", paramString, i, 1, paramInt, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhty
 * JD-Core Version:    0.7.0.1
 */