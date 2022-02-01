package com.tencent.mobileqq.activity.recent.guidebanner;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.qqsettingme.api.IThemeUtilApi;
import com.tencent.mobileqq.mvvm.BaseRepository;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_8410;

class NewerGuideBannerRepository
  extends BaseRepository
{
  NewerGuideBannerSharePreferenceHelper a = NewerGuideBannerSharePreferenceHelper.a;
  private oidb_0x59f.Guidelines_8410 b;
  
  String a()
  {
    Object localObject1 = this.b;
    Object localObject2 = "";
    if (localObject1 == null) {
      return "";
    }
    localObject1 = localObject2;
    if (b())
    {
      localObject1 = localObject2;
      if (this.b.str_res_url_night.has()) {
        localObject1 = this.b.str_res_url_night.get();
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (this.b.str_res_url.has()) {
        localObject2 = this.b.str_res_url.get();
      }
    }
    return localObject2;
  }
  
  void a(oidb_0x59f.Guidelines_8410 paramGuidelines_8410)
  {
    this.b = paramGuidelines_8410;
  }
  
  boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = this.a.d(paramAppRuntime.getCurrentAccountUin());
    if (!TextUtils.isEmpty(paramAppRuntime)) {
      try
      {
        Object localObject = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE).parse(paramAppRuntime);
        paramAppRuntime = Calendar.getInstance();
        paramAppRuntime.setTime((Date)localObject);
        localObject = Calendar.getInstance();
        ((Calendar)localObject).setTime(new Date());
        if ((paramAppRuntime.get(0) == ((Calendar)localObject).get(0)) && (paramAppRuntime.get(1) == ((Calendar)localObject).get(1)))
        {
          int i = paramAppRuntime.get(6);
          int j = ((Calendar)localObject).get(6);
          if (i == j) {
            return true;
          }
        }
      }
      catch (Throwable paramAppRuntime)
      {
        QLog.e("NewerGuideBannerModel", 1, paramAppRuntime, new Object[0]);
      }
    }
    return false;
  }
  
  boolean b()
  {
    return ((IThemeUtilApi)QRoute.api(IThemeUtilApi.class)).isNowThemeIsNight(null, false, null);
  }
  
  String c()
  {
    oidb_0x59f.Guidelines_8410 localGuidelines_8410 = this.b;
    String str = "";
    if (localGuidelines_8410 == null) {
      return "";
    }
    if (localGuidelines_8410.str_jump_url.has()) {
      str = this.b.str_jump_url.get();
    }
    return str;
  }
  
  int d()
  {
    oidb_0x59f.Guidelines_8410 localGuidelines_8410 = this.b;
    if ((localGuidelines_8410 != null) && (localGuidelines_8410.uint32_jump_type.has())) {
      return this.b.uint32_jump_type.get();
    }
    return 0;
  }
  
  int e()
  {
    oidb_0x59f.Guidelines_8410 localGuidelines_8410 = this.b;
    if ((localGuidelines_8410 != null) && (localGuidelines_8410.uint32_banner_id.has())) {
      return this.b.uint32_banner_id.get();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerRepository
 * JD-Core Version:    0.7.0.1
 */