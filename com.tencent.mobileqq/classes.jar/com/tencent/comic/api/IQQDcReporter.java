package com.tencent.comic.api;

import android.content.Context;
import com.tencent.comic.data.VipComicDC01327ReportData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process={"all"})
public abstract interface IQQDcReporter
  extends QRouteApi
{
  public abstract String getColdStartImei(Context paramContext);
  
  @Deprecated
  public abstract String getImei(Context paramContext);
  
  public abstract String getQimei();
  
  public abstract void reportDC00145(AppInterface paramAppInterface, String paramString1, Context paramContext, String paramString2, String paramString3, String paramString4, String paramString5, String... paramVarArgs);
  
  public abstract void reportDC00145(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String... paramVarArgs);
  
  public abstract void reportDC00145_2(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String... paramVarArgs);
  
  public abstract void reportDC00145_3(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String... paramVarArgs);
  
  public abstract void reportDC01327(AppInterface paramAppInterface, VipComicDC01327ReportData paramVipComicDC01327ReportData);
  
  public abstract void reportDCEvent(BaseQQAppInterface paramBaseQQAppInterface, String paramString, List<String> paramList);
  
  public abstract void reportDCSqliteProfile(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String... paramVarArgs);
  
  public abstract void reportTechReport2021(String paramString);
  
  public abstract void reportVasStatus(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString4, String paramString5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.comic.api.IQQDcReporter
 * JD-Core Version:    0.7.0.1
 */