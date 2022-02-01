package com.tencent.biz.qqcircle.launcher.parser;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.HashMap;
import qqcircle.QQCircleFeedBase.StSimulateData;

public class QCirclePolymerizeSchemeParser
  extends QCircleBaseSchemeParser
{
  private void a(HashMap<String, String> paramHashMap, QCirclePolymerizationBean paramQCirclePolymerizationBean)
  {
    String str = (String)paramHashMap.get("tagid");
    paramHashMap = (String)paramHashMap.get("tagname");
    FeedCloudMeta.StTagInfo localStTagInfo = new FeedCloudMeta.StTagInfo();
    if (!TextUtils.isEmpty(str)) {
      localStTagInfo.tagId.set(str);
    }
    if (!TextUtils.isEmpty(paramHashMap)) {
      localStTagInfo.tagName.set(paramHashMap);
    }
    paramQCirclePolymerizationBean.setTagInfo(localStTagInfo);
  }
  
  private void b(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    if (paramQCircleSchemeBean != null)
    {
      if (paramQCircleSchemeBean.getAttrs() == null) {
        return;
      }
      HashMap localHashMap = paramQCircleSchemeBean.getAttrs();
      String str = (String)localHashMap.get("sourcetype");
      if (str == null) {
        return;
      }
      QCirclePolymerizationBean localQCirclePolymerizationBean = new QCirclePolymerizationBean();
      a(paramQCircleSchemeBean, localQCirclePolymerizationBean);
      if (str.equals(String.valueOf(7))) {
        a(localHashMap, localQCirclePolymerizationBean);
      } else if (str.equals(String.valueOf(16))) {
        b(localHashMap, localQCirclePolymerizationBean);
      } else if (str.equals(String.valueOf(20))) {
        c(localHashMap, localQCirclePolymerizationBean);
      }
      a(localQCirclePolymerizationBean, localHashMap);
      localQCirclePolymerizationBean.setPolymerizationType(Integer.valueOf(str).intValue());
      localQCirclePolymerizationBean.setExt1From(5);
      QCircleLauncher.a(paramContext, localQCirclePolymerizationBean);
    }
  }
  
  private void b(HashMap<String, String> paramHashMap, QCirclePolymerizationBean paramQCirclePolymerizationBean)
  {
    Object localObject = (String)paramHashMap.get("poiname");
    FeedCloudMeta.StPoiInfoV2 localStPoiInfoV2 = new FeedCloudMeta.StPoiInfoV2();
    localStPoiInfoV2.name.set((String)localObject);
    localObject = new FeedCloudMeta.StGPSV2();
    ((FeedCloudMeta.StGPSV2)localObject).lat.set(Long.parseLong((String)paramHashMap.get("lat")));
    ((FeedCloudMeta.StGPSV2)localObject).lon.set(Long.parseLong((String)paramHashMap.get("lon")));
    ((FeedCloudMeta.StGPSV2)localObject).alt.set(Long.parseLong((String)paramHashMap.get("alt")));
    localStPoiInfoV2.gps.set((MessageMicro)localObject);
    paramQCirclePolymerizationBean.setPoiInfo(localStPoiInfoV2);
  }
  
  private void c(HashMap<String, String> paramHashMap, QCirclePolymerizationBean paramQCirclePolymerizationBean)
  {
    String str1 = (String)paramHashMap.get("filterid");
    String str2 = (String)paramHashMap.get("filtername");
    QQCircleFeedBase.StSimulateData localStSimulateData = new QQCircleFeedBase.StSimulateData();
    if (!TextUtils.isEmpty(str1)) {
      localStSimulateData.material_id.set(str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      localStSimulateData.simulate_name.set(str2);
    }
    localStSimulateData.simulate_schema.set(HostStaticInvokeHelper.getQCircleSchemeFromJumpUtil(str1, ""));
    paramQCirclePolymerizationBean.setSimulateData(localStSimulateData);
    paramHashMap = (String)paramHashMap.get("ext1from");
    try
    {
      if (!TextUtils.isEmpty(paramHashMap))
      {
        paramQCirclePolymerizationBean.setExt1From(Integer.parseInt(paramHashMap));
        return;
      }
    }
    catch (NumberFormatException paramHashMap)
    {
      paramQCirclePolymerizationBean = new StringBuilder();
      paramQCirclePolymerizationBean.append("launchPublishFragmentByScheme parseNumError:");
      paramQCirclePolymerizationBean.append(paramHashMap.getMessage());
      QLog.e("QCircleBaseSchemeParser", 1, paramQCirclePolymerizationBean.toString());
    }
  }
  
  public void a(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    HashMap localHashMap = paramQCircleSchemeBean.getAttrs();
    if (("opentag".equals(paramQCircleSchemeBean.getSchemeAction())) && (localHashMap != null)) {
      localHashMap.put("sourcetype", String.valueOf(7));
    }
    b(paramContext, paramQCircleSchemeBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launcher.parser.QCirclePolymerizeSchemeParser
 * JD-Core Version:    0.7.0.1
 */