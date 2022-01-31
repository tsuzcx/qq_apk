package com.tencent.biz.qqstory.utils;

import android.text.TextUtils;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;

public class RedPointUtils
{
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return ((MsgTabStoryNodeConfigManager)paramQQAppInterface.getManager(251)).a;
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(int paramInt1, String paramString, int paramInt2)
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    localAppInfo.path.set("null");
    localAppInfo.num.set(0);
    localAppInfo.type.set(-1);
    localAppInfo.iNewFlag.set(0);
    localAppInfo.appset.set(-1);
    if (paramInt1 != -1)
    {
      localAppInfo.uiAppId.set(0);
      localAppInfo.type.set(paramInt1);
      localAppInfo.iNewFlag.set(1);
      localAppInfo.appset.set(paramInt2);
      localAppInfo.mission_level.set(0);
      BusinessInfoCheckUpdate.RedDisplayInfo localRedDisplayInfo = new BusinessInfoCheckUpdate.RedDisplayInfo();
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(paramInt1);
      if (!TextUtils.isEmpty(paramString)) {
        localRedTypeInfo.red_content.set(paramString);
      }
      localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
      localRedDisplayInfo.tab_display_info.set(localRedTypeInfo);
      localRedDisplayInfo.red_type_info.add(localRedTypeInfo);
      localAppInfo.red_display_info.set(localRedDisplayInfo);
    }
    return localAppInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.RedPointUtils
 * JD-Core Version:    0.7.0.1
 */