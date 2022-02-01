package com.tencent.mobileqq.applets.data;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.utils.StringUtil;
import tencent.im.oidb.qqconnect.Appinfo;

public class AppletsAccountInfo
  extends Entity
{
  private static final String TABLENAME = "applets_account_info";
  @notColumn
  public AppletInfo appInfo;
  public byte[] appInfoDetail;
  public String faceUrl;
  public String faceUrlSimple;
  public String nick;
  @unique
  public String uin;
  
  public AppletInfo convertToAppletInfo(qqconnect.Appinfo paramAppinfo)
  {
    AppletInfo localAppletInfo = new AppletInfo();
    if (paramAppinfo != null)
    {
      if (paramAppinfo.appid.has()) {
        localAppletInfo.appid = paramAppinfo.appid.get();
      }
      if (paramAppinfo.app_type.has()) {
        localAppletInfo.appType = paramAppinfo.app_type.get();
      }
      if (paramAppinfo.platform.has()) {
        localAppletInfo.platform = paramAppinfo.platform.get();
      }
      if (paramAppinfo.app_name.has()) {
        localAppletInfo.appName = paramAppinfo.app_name.get();
      }
      if (paramAppinfo.app_state.has()) {
        localAppletInfo.appState = paramAppinfo.app_state.get();
      }
      if (paramAppinfo.iphone_url_scheme.has()) {
        localAppletInfo.iphoneUrlScheme = paramAppinfo.iphone_url_scheme.get();
      }
      if (paramAppinfo.android_pack_name.has()) {
        localAppletInfo.packName = paramAppinfo.android_pack_name.get();
      }
      if (paramAppinfo.icon_url.has()) {
        localAppletInfo.icon_url = paramAppinfo.icon_url.get();
      }
      if (paramAppinfo.source_url.has()) {
        localAppletInfo.sourceUrl = paramAppinfo.source_url.get();
      }
      if (paramAppinfo.icon_small_url.has()) {
        localAppletInfo.smallUrl = paramAppinfo.icon_small_url.get();
      }
      if (paramAppinfo.icon_middle_url.has()) {
        localAppletInfo.middleUrl = paramAppinfo.icon_middle_url.get();
      }
    }
    return localAppletInfo;
  }
  
  public String getTableName()
  {
    return "applets_account_info";
  }
  
  public String toString()
  {
    String str = StringUtil.getSimpleUinForPrint(String.valueOf(this.uin));
    StringBuilder localStringBuilder = new StringBuilder("--AppletsAccountInfo--");
    localStringBuilder.append(",shortUin:");
    localStringBuilder.append(str);
    localStringBuilder.append(",nick:");
    localStringBuilder.append(this.nick);
    localStringBuilder.append(",face_url:");
    localStringBuilder.append(this.faceUrl);
    localStringBuilder.append(",face_url_simple:");
    localStringBuilder.append(this.faceUrlSimple);
    localStringBuilder.append(",appInfo:");
    localStringBuilder.append(this.appInfo);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.applets.data.AppletsAccountInfo
 * JD-Core Version:    0.7.0.1
 */