package com.tencent.biz.qcircleshadow.lib.variation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.QCircleHostClassHelper;
import com.tencent.mobileqq.qqforward.api.IForwardOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleForwardInfoReportBean;
import cooperation.qqcircle.beans.QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo;

public class HostForwardUtils
{
  private static final String BUNDLE_KEY_UIN = "uin";
  private static final String BUNDLE_KEY_UIN_NAME = "uinname";
  private static final String BUNDLE_KEY_UIN_TYPE = "uintype";
  private static final int CALLBACK_CODE_CLICK = 0;
  private static final int CALLBACK_CODE_SEND_OK = -1;
  private static final String HOST_FORWARD_DIALOG_RECENTLY_FLAG = "host_forward_dialog_recently_flag";
  private static final String HOST_FORWARD_RECENTLY_CHAT_FLAG = "host_forward_recently_chat_flag";
  private static final String HOST_FORWARD_TYPE_KEY = "host_forward_type_key";
  private static final String KEY_FORWARD_REPORT_BEAN = "KEY_FORWARD_REPORT_BEAN";
  private static final String KEY_QCIRCLE_CLICK = "key_qcircle_click";
  private static final String KEY_QCIRCLE_FORWARD = "key_qcircle_forward";
  private static final String KEY_QCIRCLE_REPORT_EXTRA = "key_qcircle_report_extra";
  private static final String KEY_QCIRCLE_REPORT_PAGE_ID = "key_qcircle_report_page_id";
  private static final String KEY_QCIRCLE_REPORT_PARENT_PAGE_ID = "key_qcircle_report_parent_page_id";
  private static final String TAG = "RHF-HostForwardUtils";
  private IForwardOption mForwardOption = (IForwardOption)QRoute.api(IForwardOption.class);
  
  public static String HOST_FORWARD_DIALOG_RECENTLY_FLAG()
  {
    return "host_forward_dialog_recently_flag";
  }
  
  public static String HOST_FORWARD_RECENTLY_CHAT_FLAG()
  {
    return "host_forward_recently_chat_flag";
  }
  
  public static String HOST_FORWARD_TYPE_KEY()
  {
    return "host_forward_type_key";
  }
  
  public static String KEY_FORWARD_REPORT_BEAN()
  {
    return "KEY_FORWARD_REPORT_BEAN";
  }
  
  private ResultReceiver createResultReceiver()
  {
    return new HostForwardUtils.1(this, new Handler(Looper.getMainLooper()));
  }
  
  private void handleReceiveResult(int paramInt, Bundle paramBundle)
  {
    HostForwardUtils.ForwardInfoEntity localForwardInfoEntity = parseForwardInfoEntity(paramBundle);
    int j = parseForwardPageId(paramBundle);
    int k = parseForwardParentPageId(paramBundle);
    QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo localQCircleForwardExtraTypeInfo = parseForwardExtra(paramBundle);
    String str = parseRecentlyFlag(paramBundle);
    boolean bool = isRecentlyClickFlag(paramBundle);
    int i;
    if (paramBundle == null) {
      i = 0;
    } else {
      i = paramBundle.size();
    }
    paramBundle = localForwardInfoEntity.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("size: ");
    localStringBuilder.append(i);
    localStringBuilder.append(" | recentlyFlag: ");
    localStringBuilder.append(str);
    localStringBuilder.append(" | resultCode: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" | isRecentlyClickFlag: ");
    localStringBuilder.append(bool);
    localStringBuilder.append(" | pageId: ");
    localStringBuilder.append(j);
    localStringBuilder.append(" | parentPageId: ");
    localStringBuilder.append(k);
    localStringBuilder.append(" | entityToStr: ");
    localStringBuilder.append(paramBundle);
    QLog.d("RHF-HostForwardUtils", 1, new Object[] { "[handleReceiveResult] ", localStringBuilder.toString() });
    paramBundle = new QCircleForwardInfoReportBean();
    paramBundle.setForwardEntity(localForwardInfoEntity);
    paramBundle.setPageId(j);
    paramBundle.setParentPageId(k);
    paramBundle.setReportExtra(localQCircleForwardExtraTypeInfo);
    if ((paramInt == 0) && (bool))
    {
      notifyRecentlyClick(str, paramBundle);
      return;
    }
    if (paramInt == -1) {
      notifyResultCallback(str, paramBundle);
    }
  }
  
  private boolean isRecentlyClickFlag(Bundle paramBundle)
  {
    return (paramBundle != null) && (paramBundle.getBoolean("key_qcircle_click"));
  }
  
  private void notifyRecentlyClick(String paramString, @NonNull QCircleForwardInfoReportBean paramQCircleForwardInfoReportBean)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("report_share_qq_to_recently_click");
    localIntent.putExtra("host_forward_type_key", paramString);
    localIntent.putExtra("KEY_FORWARD_REPORT_BEAN", paramQCircleForwardInfoReportBean);
    BaseApplication.getContext().sendBroadcast(localIntent);
  }
  
  private void notifyResultCallback(String paramString, @NonNull QCircleForwardInfoReportBean paramQCircleForwardInfoReportBean)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("report_share_qq_to_forward_result");
    localIntent.putExtra("host_forward_type_key", paramString);
    localIntent.putExtra("KEY_FORWARD_REPORT_BEAN", paramQCircleForwardInfoReportBean);
    BaseApplication.getContext().sendBroadcast(localIntent);
  }
  
  private QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo parseForwardExtra(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    paramBundle = paramBundle.getSerializable("key_qcircle_report_extra");
    if ((paramBundle instanceof QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo)) {
      return (QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo)paramBundle;
    }
    return null;
  }
  
  private HostForwardUtils.ForwardInfoEntity parseForwardInfoEntity(Bundle paramBundle)
  {
    HostForwardUtils.ForwardInfoEntity localForwardInfoEntity = new HostForwardUtils.ForwardInfoEntity();
    if (paramBundle == null) {
      return localForwardInfoEntity;
    }
    try
    {
      localForwardInfoEntity.setForwardUinType(paramBundle.getInt("uintype"));
      localForwardInfoEntity.setForwardUin(paramBundle.getString("uin"));
      localForwardInfoEntity.setForwardName(paramBundle.getString("uinname"));
      QLog.d("RHF-HostForwardUtils", 1, new Object[] { "[parseForwardInfoEntity] result data: ", localForwardInfoEntity.toString() });
      return localForwardInfoEntity;
    }
    catch (Throwable paramBundle)
    {
      QLog.e("RHF-HostForwardUtils", 1, "[parseForwardInfoEntity] error: ", paramBundle);
    }
    return localForwardInfoEntity;
  }
  
  private int parseForwardPageId(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return 0;
    }
    return paramBundle.getInt("key_qcircle_report_page_id", 0);
  }
  
  private int parseForwardParentPageId(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return 0;
    }
    return paramBundle.getInt("key_qcircle_report_parent_page_id", 0);
  }
  
  private String parseRecentlyFlag(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "host_forward_recently_chat_flag";
    }
    return paramBundle.getString("host_forward_type_key", "host_forward_recently_chat_flag");
  }
  
  public void addForwardType(Intent paramIntent, String paramString)
  {
    if (paramIntent == null)
    {
      QLog.w("RHF-HostForwardUtils", 1, "[addForwardType] intent should not be null.");
      return;
    }
    paramIntent.putExtra("host_forward_type_key", paramString);
  }
  
  public void registerForwardReportParam(Intent paramIntent, int paramInt1, int paramInt2, QCircleForwardInfoReportBean.QCircleForwardExtraTypeInfo paramQCircleForwardExtraTypeInfo)
  {
    if (paramIntent == null)
    {
      QLog.w("RHF-HostForwardUtils", 1, "[registerForwardResultReceiver] intent should not be null.");
      return;
    }
    paramIntent.putExtra("key_qcircle_report_page_id", paramInt1);
    paramIntent.putExtra("key_qcircle_report_parent_page_id", paramInt2);
    paramIntent.putExtra("key_qcircle_report_extra", paramQCircleForwardExtraTypeInfo);
  }
  
  public void registerForwardResultReceiver(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QLog.w("RHF-HostForwardUtils", 1, "[registerForwardResultReceiver] intent should not be null.");
      return;
    }
    paramIntent.putExtra("PARAM_ActivityResultReceiver", createResultReceiver());
    paramIntent.putExtra("key_qcircle_forward", true);
  }
  
  public void startForwardActivityForResult(Context paramContext, Intent paramIntent)
  {
    if (paramContext == null)
    {
      QLog.d("RHF-HostForwardUtils", 1, "[startForwardActivityForResult] context not is null.");
      return;
    }
    if (!(paramContext instanceof Activity))
    {
      QLog.d("RHF-HostForwardUtils", 1, "[startForwardActivityForResult] context not is Activity");
      return;
    }
    addForwardType(paramIntent, "host_forward_dialog_recently_flag");
    registerForwardResultReceiver(paramIntent);
    Class localClass = QCircleHostClassHelper.getForwardRecentTranslucentActivityClass();
    this.mForwardOption.startForwardActivityForResult((Activity)paramContext, paramIntent, localClass, 19005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.variation.HostForwardUtils
 * JD-Core Version:    0.7.0.1
 */