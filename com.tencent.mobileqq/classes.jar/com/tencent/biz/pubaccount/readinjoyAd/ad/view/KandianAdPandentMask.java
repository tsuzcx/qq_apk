package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.app.Activity;
import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskConfigMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskDataMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskReportMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskUIMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.ChannelIdCheckStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.widget.ListView;
import java.io.File;
import org.json.JSONObject;

public class KandianAdPandentMask
{
  @Nullable
  private KandianAdPandentMask.KandianAdPandentView a;
  
  public static void a(JSONObject paramJSONObject)
  {
    SuperMaskUIMgr.a.a(4);
    SuperMaskDataMgr.a.a();
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public void a(Activity paramActivity, ListView paramListView, JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("res_path");
    String str2 = paramJSONObject.optString("animFileName");
    str1 = str1 + File.separator + str2;
    int i = paramJSONObject.optInt("superMaskType");
    if (!FileUtil.a(str1))
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
    ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "real show superMask");
    this.a = new KandianAdPandentMask.KandianAdPandentView(paramActivity, paramListView, str1);
    this.a.a(i);
    SuperMaskConfigMgr.a.b(SuperMaskUIMgr.a.b());
    SuperMaskUIMgr.a.a(2);
  }
  
  public boolean a()
  {
    return (this.a != null) && (KandianAdPandentMask.KandianAdPandentView.a(this.a));
  }
  
  public void b()
  {
    if (this.a != null)
    {
      this.a.setVisibility(8);
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "real gone mask " + this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.KandianAdPandentMask
 * JD-Core Version:    0.7.0.1
 */