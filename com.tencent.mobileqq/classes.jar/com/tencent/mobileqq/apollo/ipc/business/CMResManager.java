package com.tencent.mobileqq.apollo.ipc.business;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.statistics.ApolloQualityReportUtil;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.CrossEngineResManager;
import com.tencent.mobileqq.apollo.utils.CrossEngineResManager.LoadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResDownloaderFacade;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnFaceDataDownloadListener;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager.ApolloDressInfoListener;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager.ApolloRoleInfoListener;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager.ApolloUserDressInfoListener;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class CMResManager
  implements ICMResManager
{
  private Scene a(int paramInt)
  {
    if (paramInt == 1) {
      return Scene.MAKE_UP_3D;
    }
    return Scene.WEB_STORE_OR_GAME;
  }
  
  private static boolean b()
  {
    return CMResUtil.a();
  }
  
  private AppInterface c()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      QLog.i("[cmshow]CEResManager", 2, "onRemoteInvoke cannot get QQAppInterface");
      return null;
    }
    return (QQAppInterface)localAppRuntime;
  }
  
  public void a(int paramInt1, int paramInt2, IApolloResManager.ApolloRoleInfoListener paramApolloRoleInfoListener)
  {
    QLog.d("[cmshow]CEResManager", 1, " handleGetDressInfo ");
    long l = System.currentTimeMillis();
    TraceReportUtil.a(132, String.valueOf(l));
    int i;
    if (b()) {
      i = 7;
    } else {
      i = 3;
    }
    TraceReportUtil.a(132, String.valueOf(l), i);
    ApolloResManagerFacade.a.a(a(paramInt2)).a(c(), paramInt1, new CMResManager.2(this, paramApolloRoleInfoListener, l));
  }
  
  public void a(CrossEngineResManager.LoadListener paramLoadListener)
  {
    CrossEngineResManager.b(paramLoadListener);
  }
  
  public void a(String paramString, int paramInt, IApolloResDownloader.OnFaceDataDownloadListener paramOnFaceDataDownloadListener)
  {
    QLog.d("[cmshow]CEResManager", 1, " handleCheckFaceDataDownload ");
    long l = System.currentTimeMillis();
    TraceReportUtil.a(132, String.valueOf(l));
    boolean bool = b();
    int j = 8;
    int i;
    if (bool) {
      i = 8;
    } else {
      i = 4;
    }
    TraceReportUtil.a(132, String.valueOf(l), i);
    if (TextUtils.isEmpty(paramString))
    {
      if (paramOnFaceDataDownloadListener != null) {
        paramOnFaceDataDownloadListener.a(false, -1);
      }
      ApolloQualityReportUtil.a("apollo_face_data", String.valueOf(System.currentTimeMillis() - l), "url isEmpty");
      if (b()) {
        paramInt = j;
      } else {
        paramInt = 4;
      }
      TraceReportUtil.a(132, String.valueOf(l), paramInt, -1, new Object[] { "url isEmpty" });
      TraceReportUtil.b(132, String.valueOf(l));
      return;
    }
    ApolloResDownloaderFacade.a.a(a(paramInt)).a(c(), paramString, new CMResManager.1(this, paramOnFaceDataDownloadListener, l));
  }
  
  public void a(String paramString, int paramInt, IApolloResManager.ApolloUserDressInfoListener paramApolloUserDressInfoListener)
  {
    QLog.d("[cmshow]CEResManager", 1, " handleGetUserRes ");
    long l = System.currentTimeMillis();
    TraceReportUtil.a(132, null, String.valueOf(l));
    boolean bool = b();
    int j = 5;
    int i;
    if (bool) {
      i = 5;
    } else {
      i = 1;
    }
    TraceReportUtil.a(132, String.valueOf(l), i);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new StringBuilder();
      paramString.append("static getApolloUserRes errMsg : ");
      paramString.append("uin isEmpty");
      QLog.d("[cmshow]CEResManager", 1, paramString.toString());
      if (paramApolloUserDressInfoListener != null) {
        paramApolloUserDressInfoListener.a(null, "uin isEmpty", -1);
      }
      ApolloQualityReportUtil.a("apollo_user_res", String.valueOf(System.currentTimeMillis() - l), "uin isEmpty");
      if (b()) {
        paramInt = j;
      } else {
        paramInt = 1;
      }
      TraceReportUtil.a(132, String.valueOf(l), paramInt, -1, new Object[] { "uin isEmpty" });
      TraceReportUtil.b(132, String.valueOf(l));
      return;
    }
    ApolloResManagerFacade.a.a(a(paramInt)).a(paramString, new CMResManager.4(this, paramApolloUserDressInfoListener, l));
  }
  
  public void a(ArrayList<Integer> paramArrayList, int paramInt, IApolloResManager.ApolloDressInfoListener paramApolloDressInfoListener)
  {
    QLog.d("[cmshow]CEResManager", 1, " handleGetDressInfo ");
    long l = System.currentTimeMillis();
    TraceReportUtil.a(132, null, String.valueOf(l));
    int i;
    if (b()) {
      i = 6;
    } else {
      i = 2;
    }
    TraceReportUtil.a(132, String.valueOf(l), i);
    ApolloResManagerFacade.a.a(a(paramInt)).a(c(), paramArrayList, new CMResManager.3(this, paramApolloDressInfoListener, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.business.CMResManager
 * JD-Core Version:    0.7.0.1
 */