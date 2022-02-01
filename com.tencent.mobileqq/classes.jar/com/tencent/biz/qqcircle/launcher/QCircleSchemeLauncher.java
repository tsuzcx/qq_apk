package com.tencent.biz.qqcircle.launcher;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.launcher.parser.QCircleAggregationSchemeParser;
import com.tencent.biz.qqcircle.launcher.parser.QCircleBaseSchemeParser;
import com.tencent.biz.qqcircle.launcher.parser.QCircleContentDetailSchemeParser;
import com.tencent.biz.qqcircle.launcher.parser.QCircleFlutterTransSchemeParser;
import com.tencent.biz.qqcircle.launcher.parser.QCircleFolderSchemeParser;
import com.tencent.biz.qqcircle.launcher.parser.QCircleHippySchemeParser;
import com.tencent.biz.qqcircle.launcher.parser.QCircleHybridSchemeParser;
import com.tencent.biz.qqcircle.launcher.parser.QCircleMessageBoxSchemeParser;
import com.tencent.biz.qqcircle.launcher.parser.QCircleMessageNoticeSchemeParser;
import com.tencent.biz.qqcircle.launcher.parser.QCircleNewPublishSchemeParser;
import com.tencent.biz.qqcircle.launcher.parser.QCirclePersonDetailSchemeParser;
import com.tencent.biz.qqcircle.launcher.parser.QCirclePolymerizeDetailSchemeParser;
import com.tencent.biz.qqcircle.launcher.parser.QCirclePolymerizeSchemeParser;
import com.tencent.biz.qqcircle.launcher.parser.QCirclePrivateSettingSchemeParser;
import com.tencent.biz.qqcircle.launcher.parser.QCirclePublishSchemeParser;
import com.tencent.biz.qqcircle.launcher.parser.QCircleQQPublishSchemeParser;
import com.tencent.biz.qqcircle.launcher.parser.QCircleSearchSchemeParser;
import com.tencent.biz.qqcircle.utils.QCircleThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import java.util.HashMap;
import java.util.Map;

public class QCircleSchemeLauncher
{
  private static final Map<String, QCircleBaseSchemeParser> a = new HashMap();
  
  static
  {
    a.put("openAggregation", new QCircleAggregationSchemeParser());
    a.put("opendetail", new QCircleContentDetailSchemeParser());
    a.put("openfluttertranview", new QCircleFlutterTransSchemeParser());
    Object localObject = new QCircleFolderSchemeParser();
    a.put("openfolder", localObject);
    a.put("openpymk", localObject);
    a.put("openhippy", new QCircleHippySchemeParser());
    a.put("openwebview", new QCircleHybridSchemeParser());
    a.put("openmessagelist", new QCircleMessageBoxSchemeParser());
    a.put("opennoticelist", new QCircleMessageNoticeSchemeParser());
    a.put("openpublish", new QCircleNewPublishSchemeParser());
    a.put("openmainpage", new QCirclePersonDetailSchemeParser());
    a.put("openpolymerizedetail", new QCirclePolymerizeDetailSchemeParser());
    localObject = new QCirclePolymerizeSchemeParser();
    a.put("opentag", localObject);
    a.put("openpolymerize", localObject);
    a.put("openPrivacySetting", new QCirclePrivateSettingSchemeParser());
    a.put("opencamera", new QCirclePublishSchemeParser());
    a.put("opencirclesearch", new QCircleSearchSchemeParser());
    a.put("openqqpublish", new QCircleQQPublishSchemeParser());
  }
  
  public static void a(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    a(paramQCircleSchemeBean);
    b(paramContext, paramQCircleSchemeBean);
  }
  
  private static void a(QCircleSchemeBean paramQCircleSchemeBean)
  {
    QCircleThreadManager.a().a(new QCircleSchemeLauncher.1(paramQCircleSchemeBean));
  }
  
  public static void b(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    Object localObject = paramQCircleSchemeBean.getSchemeAction();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchQCircleByScheme actionName");
    localStringBuilder.append((String)localObject);
    QLog.d("QCircleSchemeLauncher", 1, localStringBuilder.toString());
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    localObject = (QCircleBaseSchemeParser)a.get(localObject);
    if (localObject == null) {
      return;
    }
    ((QCircleBaseSchemeParser)localObject).a(paramContext, paramQCircleSchemeBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher
 * JD-Core Version:    0.7.0.1
 */