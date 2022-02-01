package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.storage.StorageReport;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil.DownloadInfoListener;
import com.tencent.mobileqq.utils.JumpQqPimSecureUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.CircleProgressBar;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class QQSettingCleanActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, IUniformDownloaderListener, HttpDownloadUtil.DownloadInfoListener
{
  public static final String[] a = { "sdcard/Tencent/MobileQQ", "sdcard/Tencent/QQ_Images", "sdcard/Tencent/QQfile_recv", "sdcard/Tencent/QQ_Collection", "sdcard/Tencent/QQ_Favorite", "sdcard/Tencent/QQ_Video", "sdcard/Tencent/QQfile_share", "sdcard/Tencent/QQHomework_recv", "sdcard/Tencent/QQHomework_attach", "sdcard/Tencent/AIO_FORWARD", "sdcard/Tencent/QQ_business" };
  public static final String b = HardCodeUtil.a(2131908394);
  public static final ArrayList<String> z = new ArrayList(2);
  public QQSettingCleanActivity.RefreshHandler A = new QQSettingCleanActivity.RefreshHandler(this);
  public QQProgressDialog c;
  public Button d;
  public Button e;
  public View f;
  public View g;
  public View h;
  public View i;
  public TextView j;
  public CircleProgressBar k;
  public TextView l;
  public TextView m;
  public TextView n;
  public TextView o;
  public LinearLayout p;
  public TextView q;
  public ProgressBar r;
  public long s = 0L;
  public long t = 0L;
  public long u = 0L;
  public long v = 0L;
  public long w = 0L;
  public long x = 0L;
  public boolean y = false;
  
  private String a(long paramLong)
  {
    if (paramLong <= 0L) {
      return null;
    }
    if (paramLong < 1024L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong);
      localStringBuilder.append("B");
      return localStringBuilder.toString();
    }
    if (paramLong < 1048576L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.format("%.1f", new Object[] { Float.valueOf((float)paramLong / 1024.0F) }));
      localStringBuilder.append("K");
      return localStringBuilder.toString();
    }
    if (paramLong < 1073741824L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.format("%.1f", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F) }));
      localStringBuilder.append("M");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("%.1f", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F / 1024.0F) }));
    localStringBuilder.append("G");
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, QQSettingMsgHistoryActivity.class);
    localIntent.putExtra("set_display_type", 1);
    paramContext.startActivity(localIntent);
  }
  
  protected IUniformDownloadMgr a()
  {
    return (IUniformDownloadMgr)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "");
  }
  
  public void a(int paramInt, Bundle paramBundle) {}
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    this.y = false;
    runOnUiThread(new QQSettingCleanActivity.ShowTask(this, 4));
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    this.y = false;
    runOnUiThread(new QQSettingCleanActivity.ShowTask(this, 4));
    ReportController.b(this.app, "dc00898", "", "", "0X8007911", "0X8007911", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
  }
  
  public void b()
  {
    this.k.a();
    this.k.setPercent(0);
    StorageReport.c().post(new QQSettingCleanActivity.ScanSpaceTask(this));
  }
  
  public void b(int paramInt, Bundle paramBundle) {}
  
  public void c(int paramInt, Bundle paramBundle)
  {
    runOnUiThread(new QQSettingCleanActivity.ShowTask(this, 4));
  }
  
  public void d(int paramInt, Bundle paramBundle) {}
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131627797);
    setTitle(getString(2131897251));
    this.d = ((Button)findViewById(2131430748));
    this.e = ((Button)findViewById(2131430747));
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f = findViewById(2131442121);
    this.g = findViewById(2131442116);
    this.h = findViewById(2131439709);
    this.i = findViewById(2131428986);
    ((GradientDrawable)this.f.getBackground()).setColor(Color.parseColor("#00d1a4"));
    ((GradientDrawable)this.g.getBackground()).setColor(Color.parseColor("#fea356"));
    ((GradientDrawable)this.h.getBackground()).setColor(Color.parseColor("#529eff"));
    ((GradientDrawable)this.i.getBackground()).setColor(Color.parseColor("#e6e6e7"));
    this.j = ((TextView)findViewById(2131442294));
    this.k = ((CircleProgressBar)findViewById(2131445295));
    this.l = ((TextView)findViewById(2131442120));
    this.m = ((TextView)findViewById(2131442117));
    this.n = ((TextView)findViewById(2131439708));
    this.o = ((TextView)findViewById(2131428985));
    this.p = ((LinearLayout)findViewById(2131446191));
    this.q = ((TextView)findViewById(2131430749));
    this.r = ((ProgressBar)findViewById(2131432119));
    StorageReport.a().a(false);
    paramBundle = FMSettings.a().getDefaultRecvPath();
    String str = FMSettings.a().getOtherRecvPath();
    z.clear();
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(paramBundle))
    {
      z.add(paramBundle);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" need scan file path1 = ");
      localStringBuilder.append(paramBundle);
      QLog.d("QQCleanActivity", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(str))
    {
      z.add(str);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" need scan file path2 = ");
      localStringBuilder.append(str);
      QLog.d("QQCleanActivity", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" need scan file path1 = ");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append(" path2 = ");
      localStringBuilder.append(str);
      QLog.d("QQCleanActivity", 2, localStringBuilder.toString());
    }
    b();
    ThreadManager.executeOnNetWorkThread(new QQSettingCleanActivity.GetApkSizeTask(this));
    return true;
  }
  
  protected void doOnDestroy()
  {
    QQProgressDialog localQQProgressDialog = this.c;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      dismissDialog(1);
    }
    a().removeOuterListenner("https://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean");
    StorageReport.d();
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (StorageReport.a().b())
    {
      StorageReport.a().a(false);
      b();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131430748: 
      ReportController.b(this.app, "dc00898", "", "", "0X8007543", "0X8007543", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
      localObject = new Intent(getActivity(), QQSettingMsgHistoryActivity.class);
      ((Intent)localObject).putExtra("set_display_type", 2);
      getActivity().startActivity((Intent)localObject);
      break;
    case 2131430747: 
      ReportController.b(this.app, "dc00898", "", "", "0X8007544", "0X8007544", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
      if (!JumpQqPimSecureUtil.a(this))
      {
        ReportController.b(this.app, "dc00898", "", "", "0X8007912", "0X8007912", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
        localObject = DialogUtil.a(this, 230).setTitle(getString(2131916728)).setMessage(getString(2131916738)).setPositiveButton(getString(2131916732), new QQSettingCleanActivity.2(this)).setNegativeButton(getString(2131887648), new QQSettingCleanActivity.1(this));
        if ((localObject != null) && (!((Dialog)localObject).isShowing()) && (!isFinishing()))
        {
          ((Dialog)localObject).setCancelable(false);
          ((Dialog)localObject).show();
        }
      }
      else
      {
        ReportController.b(this.app, "dc00898", "", "", "0X8007913", "0X8007913", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
        JumpQqPimSecureUtil.a(this, "mobileqq", 9502721);
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    if (paramInt != 1) {
      return super.onCreateDialog(paramInt);
    }
    this.c = null;
    this.c = new QQProgressDialog(this, getTitleBarHeight());
    this.c.a(getString(2131887798));
    this.c.c(true);
    this.c.a(false);
    this.c.b(true);
    return this.c;
  }
  
  public boolean onRespDownloadInfo(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo.resultCode == 0)
    {
      long l1 = paramDownloadInfo.respContentLength;
      if ((NetworkUtil.isNetSupport(this)) && (l1 > 0L))
      {
        paramDownloadInfo = new Bundle();
        paramDownloadInfo.putString("_filename_from_dlg", b);
        paramDownloadInfo.putLong("_filesize_from_dlg", l1);
        paramDownloadInfo.putString("big_brother_source_key", "biz_src_tmm");
        paramDownloadInfo.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_tmm");
        this.y = true;
        runOnUiThread(new QQSettingCleanActivity.ShowTask(this, 2));
        a().startDownload("https://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean", paramDownloadInfo, this);
        return true;
      }
    }
    else
    {
      runOnUiThread(new QQSettingCleanActivity.ShowTask(this, 3));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingCleanActivity
 * JD-Core Version:    0.7.0.1
 */