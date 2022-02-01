package com.tencent.mobileqq.activity.qqsettingme;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.vas.VasApngUtil;
import java.util.HashSet;
import java.util.List;
import mqq.app.AppRuntime;

public class QQSettingMeRedTouchUtil
{
  protected static void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramAppInfo != null) && (paramAppInfo.red_display_info != null))
    {
      if (paramAppInfo.red_display_info.red_type_info == null) {
        return;
      }
      paramAppInfo = paramAppInfo.red_display_info.red_type_info.get();
      int i = paramAppInfo.size() - 1;
      while (i >= 0)
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.get(i);
        if (localRedTypeInfo.red_type.get() == 15) {
          VasApngUtil.getApngURLDrawable(localRedTypeInfo.red_content.get(), VasApngUtil.VIP_APNG_TAGS, URLDrawableHelperConstants.a);
        }
        i -= 1;
      }
    }
  }
  
  protected static void a(AppRuntime paramAppRuntime, BusinessInfoCheckUpdate.AppInfo paramAppInfo, HashSet<Integer> paramHashSet)
  {
    if ((paramAppInfo != null) && (paramAppInfo.iNewFlag.get() != 0))
    {
      int i = paramAppInfo.uiAppId.get();
      if (!paramHashSet.contains(Integer.valueOf(i)))
      {
        paramHashSet.add(Integer.valueOf(i));
        ((IRedTouchManager)paramAppRuntime.getRuntimeService(IRedTouchManager.class, "")).reportLevelOneRedInfo(i, 30);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeRedTouchUtil
 * JD-Core Version:    0.7.0.1
 */