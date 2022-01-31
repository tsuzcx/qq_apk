import QQService.EVIPSPEC;
import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qvip.QVipBigClubSVIP9Config;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import mqq.app.AppRuntime;

public class bblt
{
  private static long[] a = { 0L, 0L };
  
  public static int a(bblu parambblu)
  {
    if ((parambblu == bblu.jdField_a_of_type_Bblu) || (parambblu == bblu.b)) {}
    do
    {
      return 2130846159;
      if (parambblu == bblu.c) {
        return 2130846158;
      }
      if (parambblu == bblu.d) {
        return 2130846160;
      }
    } while ((parambblu != bblu.e) && (parambblu != bblu.f));
    return 2130846157;
  }
  
  public static String a(int paramInt1, int paramInt2, long paramLong)
  {
    return a(paramInt1, paramInt2, paramLong, false);
  }
  
  private static String a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (String str = amzd.c().mAPngIconUrl;; str = amzd.c().mAPngIconUrlNew_Gray)
    {
      if (paramBoolean) {
        paramLong = 0L;
      }
      return String.format(str, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    }
  }
  
  public static String a(aogm paramaogm)
  {
    int i = VipUtils.a(paramaogm);
    i = (i & 0xF) << 8 | i >> 8;
    if ((i & 0xFF) == 3) {
      return String.format(amzd.c().mAPngIconUrl, new Object[] { Integer.valueOf(i), Integer.valueOf(paramaogm.mBigVipLevel), Integer.valueOf(paramaogm.mTemplateId) });
    }
    if ((i & 0xFF) == 2) {
      return String.format(amzd.c().mAPngIconUrl, new Object[] { Integer.valueOf(i), Integer.valueOf(paramaogm.mVipLevel), Integer.valueOf(paramaogm.mTemplateId) });
    }
    return null;
  }
  
  public static String a(AppRuntime paramAppRuntime, String paramString, EVIPSPEC paramEVIPSPEC)
  {
    Object localObject = (ajxl)paramAppRuntime.getManager(51);
    if (localObject != null)
    {
      localObject = ((ajxl)localObject).e(paramString);
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
  
  public static String a(AppRuntime paramAppRuntime, String paramString, bblu parambblu, boolean paramBoolean)
  {
    paramAppRuntime = (ajxl)paramAppRuntime.getManager(51);
    if (paramAppRuntime != null)
    {
      paramAppRuntime = paramAppRuntime.e(paramString);
      if (paramAppRuntime != null)
      {
        int i;
        if ((parambblu == bblu.e) || (parambblu == bblu.f))
        {
          i = paramAppRuntime.getServiceLevel(EVIPSPEC.E_SP_BIGCLUB);
          return a(parambblu.jdField_a_of_type_Int, i, paramAppRuntime.bigClubTemplateId, paramBoolean);
        }
        if ((parambblu == bblu.c) || (parambblu == bblu.d))
        {
          i = paramAppRuntime.getServiceLevel(EVIPSPEC.E_SP_SUPERVIP);
          return a(parambblu.jdField_a_of_type_Int, i, paramAppRuntime.superVipTemplateId, paramBoolean);
        }
        if ((parambblu == bblu.jdField_a_of_type_Bblu) || (parambblu == bblu.b))
        {
          i = paramAppRuntime.getServiceLevel(EVIPSPEC.E_SP_QQVIP);
          return a(parambblu.jdField_a_of_type_Int, i, 0L, paramBoolean);
        }
      }
    }
    return a(0, 0, 0L, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramString = amzd.c().getVipIconSettingsUrl(paramString);
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
    paramAppRuntime = (ajxl)paramAppRuntime.getManager(51);
    if (paramAppRuntime != null)
    {
      paramAppRuntime = paramAppRuntime.e(paramString);
      if (paramAppRuntime != null) {
        return new int[] { paramAppRuntime.nameplateVipType, paramAppRuntime.grayNameplateFlag };
      }
    }
    return new int[] { 0, 0 };
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
      axqy.b(null, "dc00898", "", "", "qq_vip", paramString, i, 1, paramInt, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bblt
 * JD-Core Version:    0.7.0.1
 */