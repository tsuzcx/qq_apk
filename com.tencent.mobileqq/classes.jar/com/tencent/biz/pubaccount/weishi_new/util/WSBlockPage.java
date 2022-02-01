package com.tencent.biz.pubaccount.weishi_new.util;

import UserGrowth.stJumpInfo;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Vertical;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;

public class WSBlockPage
{
  private void a(String paramString1, String paramString2, stJumpInfo paramstJumpInfo, int paramInt1, int paramInt2)
  {
    if (paramstJumpInfo == null) {
      return;
    }
    WSVerticalBeaconReport.a(paramString1, paramString2, paramInt1, paramstJumpInfo);
    WSReportDC898Vertical.c(paramstJumpInfo.url, paramInt2, paramstJumpInfo.id);
  }
  
  public void a(WSVerticalPageFragment paramWSVerticalPageFragment, int paramInt1, int paramInt2)
  {
    if (paramWSVerticalPageFragment == null) {
      return;
    }
    stJumpInfo localstJumpInfo = WSGlobalConfig.a().f(paramInt2);
    if (localstJumpInfo == null) {
      return;
    }
    String str2 = localstJumpInfo.schema_url;
    String str1;
    if (!TextUtils.isEmpty(localstJumpInfo.h5url)) {
      str1 = localstJumpInfo.h5url;
    } else {
      str1 = localstJumpInfo.url;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("schemaUrl:");
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append(",h5url:");
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(",jumpurl:");
    ((StringBuilder)localObject).append(localstJumpInfo.url);
    WSLog.b("WSBlockPage", ((StringBuilder)localObject).toString());
    localObject = paramWSVerticalPageFragment.k();
    String str3 = paramWSVerticalPageFragment.l();
    WeishiUtils.a(paramWSVerticalPageFragment.getBaseActivity(), str2, str1, "", 5, new WSBlockPage.1(this, paramWSVerticalPageFragment, (String)localObject, str3, localstJumpInfo, paramInt1));
    paramWSVerticalPageFragment = new StringBuilder();
    paramWSVerticalPageFragment.append("reportBlockPage, id:");
    paramWSVerticalPageFragment.append(localstJumpInfo.id);
    paramWSVerticalPageFragment.append(" ,pageType:");
    paramWSVerticalPageFragment.append(5);
    WSLog.b("WSBlockPage", paramWSVerticalPageFragment.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSBlockPage
 * JD-Core Version:    0.7.0.1
 */