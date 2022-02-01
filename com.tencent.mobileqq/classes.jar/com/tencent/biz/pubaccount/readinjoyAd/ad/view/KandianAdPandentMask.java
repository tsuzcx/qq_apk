package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.app.Activity;
import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskConfigMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskDataMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskReportMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.ChannelIdCheckStep;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.ListView;
import java.io.File;
import org.json.JSONObject;

public class KandianAdPandentMask
{
  @Nullable
  private KandianAdPandent a;
  
  public static void a(JSONObject paramJSONObject)
  {
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setShowStatus(4);
    SuperMaskDataMgr.a.a();
  }
  
  public void a()
  {
    KandianAdPandent localKandianAdPandent = this.a;
    if (localKandianAdPandent != null) {
      localKandianAdPandent.a();
    }
  }
  
  public void a(Activity paramActivity, ListView paramListView, JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("res_path");
    String str2 = paramJSONObject.optString("animFileName");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(str2);
    str2 = localStringBuilder.toString();
    int i = paramJSONObject.optInt("superMaskType");
    if (!FileUtil.b(str2))
    {
      SuperMaskReportMgr.a.a("fileNotExists", "");
      a(paramJSONObject);
      return;
    }
    if (!new ChannelIdCheckStep().a())
    {
      a(paramJSONObject);
      return;
    }
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoySuperMaskAd", "real show superMask");
    if (SuperMaskDataMgr.a.b()) {
      this.a = new KandianCompetitiveAdPandentView(paramActivity, paramListView, str1);
    } else {
      this.a = new KandianAdPandentMask.KandianAdPandentView(paramActivity, paramListView, str2);
    }
    this.a.a(i);
    SuperMaskConfigMgr.a.b(((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).getChannelID());
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setShowStatus(2);
  }
  
  public void b()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((KandianAdPandent)localObject).setViewVisibility(8);
      localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("real gone mask ");
      localStringBuilder.append(this.a);
      ((IRIJAdLogService)localObject).d("ReadInJoySuperMaskAd", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.KandianAdPandentMask
 * JD-Core Version:    0.7.0.1
 */