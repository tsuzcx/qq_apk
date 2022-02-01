package com.tencent.biz.pubaccount.weishi_new.download;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import mqq.util.WeakReference;

public class WSDownloadAppDialog
  extends QQCustomDialog
{
  private static WeakReference<WSDownloadAppDialog> a;
  
  public WSDownloadAppDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    b();
  }
  
  public static void a()
  {
    Object localObject = a;
    if (localObject != null)
    {
      localObject = (WSDownloadAppDialog)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if (WeishiDownloadUtil.f()) {
          WSLog.c("WeishiDownloadUtil", "关闭qzone弹窗");
        } else {
          WSLog.c("WeishiDownloadUtil", "关闭qq弹窗");
        }
        ((WSDownloadAppDialog)localObject).dismiss();
        return;
      }
      if (WeishiDownloadUtil.f())
      {
        WSLog.d("WeishiDownloadUtil", "qzone弹窗 is null");
        return;
      }
      WSLog.d("WeishiDownloadUtil", "qq弹窗 is null");
      return;
    }
    WSLog.d("WeishiDownloadUtil", "download弹窗 mWeakRefrence is null");
  }
  
  public static void a(int paramInt, WSDownloadParams paramWSDownloadParams)
  {
    if (paramWSDownloadParams != null)
    {
      if (paramWSDownloadParams.mStReportItem == null) {
        return;
      }
      paramWSDownloadParams.mStReportItem.downloadscene = WeishiDownloadUtil.a(paramWSDownloadParams.mScene, paramWSDownloadParams.mLinkStrategyType, paramWSDownloadParams.mEventId);
      UserActionReportPresenter.a(paramInt, paramWSDownloadParams.mStReportItem);
    }
  }
  
  public static void a(Activity paramActivity)
  {
    try
    {
      if (WeishiDownloadUtil.f()) {
        WSLog.d("WeishiDownloadUtil", "弹出qzone弹窗---");
      } else {
        WSLog.d("WeishiDownloadUtil", "弹出qq弹窗");
      }
      if ((a == null) || (a.get() == null))
      {
        paramActivity = new WSDownloadAppDialog(paramActivity, 2131953338);
        paramActivity.setTitle("正在下载腾讯微视APP");
        paramActivity.setMessage("️⬆完成安装即可领取最高188红包⬆");
        paramActivity.setPositiveButton(HardCodeUtil.a(2131899883), new WSDownloadAppDialog.1());
        a = new WeakReference(paramActivity);
      }
      ((WSDownloadAppDialog)a.get()).show();
      return;
    }
    catch (Exception paramActivity)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showDownloadDialog error:");
      localStringBuilder.append(paramActivity.getLocalizedMessage());
      WSLog.d("WeishiDownloadUtil", localStringBuilder.toString());
    }
  }
  
  public static boolean a(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    paramWSDownloadParams.mTestId = WSReportDc00898.b();
    return WeishiDownloadUtil.a(paramActivity, paramWSDownloadParams, true, 3);
  }
  
  private void b()
  {
    setContentView(2131624611);
    setCanceledOnTouchOutside(true);
  }
  
  public static void b(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    if (a(paramActivity, paramWSDownloadParams))
    {
      a(115, paramWSDownloadParams);
      a(paramActivity);
      return;
    }
    Log.e("WeishiDownloadUtil", "QQ download start error");
  }
  
  public static void c(Activity paramActivity, WSDownloadParams paramWSDownloadParams)
  {
    if (WeishiDownloadUtil.g())
    {
      b(paramActivity, paramWSDownloadParams);
      return;
    }
    WSDownloadAppDialog localWSDownloadAppDialog = new WSDownloadAppDialog(paramActivity, 2131953338);
    localWSDownloadAppDialog.setTitle(HardCodeUtil.a(2131913912));
    localWSDownloadAppDialog.setMessage("️⬆完成安装即可领取最高188红包⬆");
    localWSDownloadAppDialog.setPositiveButton(HardCodeUtil.a(2131899883), new WSDownloadAppDialog.4(paramActivity, paramWSDownloadParams));
    localWSDownloadAppDialog.setNegativeButton(HardCodeUtil.a(2131898212), new WSDownloadAppDialog.5(paramWSDownloadParams));
    localWSDownloadAppDialog.show();
    WSReportDc00898.a(paramWSDownloadParams.mScene, true, false);
    a(124, paramWSDownloadParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.WSDownloadAppDialog
 * JD-Core Version:    0.7.0.1
 */