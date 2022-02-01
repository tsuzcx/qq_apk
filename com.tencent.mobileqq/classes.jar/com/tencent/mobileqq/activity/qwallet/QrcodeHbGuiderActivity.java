package com.tencent.mobileqq.activity.qwallet;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.widget.ImmersionBar;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.CommonUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import org.json.JSONException;
import org.json.JSONObject;

@RoutePage(desc="QQ钱包-面对面红包引导界面", path="/qwallet/redpacket/QrcodeHbGuider")
public class QrcodeHbGuiderActivity
  extends FragmentActivity
  implements View.OnClickListener
{
  private String mAppInfo;
  private TextView mBackView;
  private int mComeFrom = 2;
  private TextView mConfirmView;
  public boolean mIsEndReport = true;
  private String mOptType;
  private long mReportSeq = 0L;
  private Button mSendBtn;
  private TextView mTitleText;
  private String mUin;
  
  private void init()
  {
    new ImmersionBar(this, -468046, findViewById(2131378435));
    initView();
    initParams();
    initListener();
  }
  
  private void initListener()
  {
    this.mSendBtn.setOnClickListener(this);
    this.mBackView.setOnClickListener(this);
    this.mConfirmView.setOnClickListener(this);
  }
  
  private void initParams()
  {
    this.mUin = this.app.getCurrentUin();
    this.mAppInfo = getIntent().getStringExtra("app_info");
    this.mReportSeq = getIntent().getLongExtra("vacreport_key_seq", 0L);
    if (this.mReportSeq == 0L) {
      this.mReportSeq = VACDReportUtil.a(null, "qqwallet", "gotoF2fredpack", "GuiderAct.create", "", 0, null);
    }
    for (;;)
    {
      String str = getIntent().getStringExtra("from_plugin");
      this.mOptType = str;
      if ((!TextUtils.isEmpty(str)) && ("131".equals(str))) {
        this.mComeFrom = 1;
      }
      if (TextUtils.isEmpty(str))
      {
        go2QrcodeHbPage(QWalletHelperImpl.readQRTokenConfig(this, this.mUin), "");
        this.mIsEndReport = false;
        finish();
      }
      return;
      VACDReportUtil.a(this.mReportSeq, null, "GuiderAct.create", null, 0, null);
    }
  }
  
  private void initView()
  {
    this.mSendBtn = ((Button)findViewById(2131374248));
    this.mTitleText = ((TextView)findViewById(2131369534));
    this.mTitleText.setText(HardCodeUtil.a(2131711166));
    this.mBackView = ((TextView)findViewById(2131369487));
    this.mConfirmView = ((TextView)findViewById(2131369518));
    this.mConfirmView.setText(HardCodeUtil.a(2131711165));
  }
  
  public void addUploadData(String paramString)
  {
    String str = this.mUin;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Tenpay_mqq");
    localStringBuilder.append("|");
    localStringBuilder.append(str);
    localStringBuilder.append("||");
    localStringBuilder.append(this.mOptType);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString);
    localStringBuilder.append("|0|1|0|android.");
    try
    {
      localStringBuilder.append(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
      localStringBuilder.append("|");
      localStringBuilder.append(CommonUtil.a());
      localStringBuilder.append("|");
      localStringBuilder.append(this.mComeFrom);
      localStringBuilder.append(".");
      if (!TextUtils.isEmpty(this.mAppInfo)) {
        localStringBuilder.append(this.mAppInfo.replace("|", ","));
      }
      localStringBuilder.append("|");
      VACDReportUtil.a(this.mReportSeq, null, paramString, "op_type=" + this.mOptType, 0, "");
      StatisticCollector.getInstance(BaseApplication.getContext()).reportToPCliOper(this.app, localStringBuilder.toString());
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    setContentView(2131560687);
    init();
    addUploadData("face2face.index.show");
    return true;
  }
  
  public void finish()
  {
    if ((this.mIsEndReport) && (this.mReportSeq != 0L)) {
      VACDReportUtil.endReport(this.mReportSeq, "GuiderAct.finish", null, 0, null);
    }
    super.finish();
  }
  
  public void go2HbList()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("userId", this.mUin);
      localJSONObject.put("viewTag", "redgiftRecord");
      localJSONObject.put("comeForm", 2);
      localJSONObject.put("extra_data", new JSONObject().toString());
      Bundle localBundle = new Bundle();
      localBundle.putString("json", localJSONObject.toString());
      localBundle.putString("callbackSn", "0");
      localBundle.putLong("vacreport_key_seq", this.mReportSeq);
      PayBridgeActivity.tenpay(this, 5, localBundle);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void go2QrcodeHbPage(String paramString1, String paramString2)
  {
    paramString2 = new JSONObject();
    if (TextUtils.isEmpty(this.mUin)) {
      return;
    }
    try
    {
      paramString2.put("userId", this.mUin);
      paramString2.put("viewTag", "qrcodeHb");
      paramString2.put("comeForm", 2);
      JSONObject localJSONObject = new JSONObject();
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.putOpt("qrToken", paramString1);
      }
      paramString2.put("extra_data", localJSONObject.toString());
      paramString1 = new Bundle();
      paramString1.putString("json", paramString2.toString());
      paramString1.putString("callbackSn", "0");
      paramString1.putLong("vacreport_key_seq", this.mReportSeq);
      PayBridgeActivity.tenpay(this, 5, paramString1);
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void go2SendHb()
  {
    long l = VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", null, 0, null);
    Intent localIntent = new Intent();
    localIntent.setClass(this, SendHbActivity.class);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("channel", "2048");
      localJSONObject.put("recv_uin", this.mUin);
      localIntent.putExtra("extra_data", localJSONObject.toString());
      localIntent.putExtra("come_from", 2);
      localIntent.putExtra("app_info", this.mAppInfo);
      localIntent.addFlags(536870912);
      localIntent.putExtra("vacreport_key_seq", l);
      startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      go2SendHb();
      addUploadData("face2face.index.go");
      finish();
      continue;
      addUploadData("face2face.index.back");
      finish();
      continue;
      go2HbList();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      addUploadData("face2face.index.keyback");
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QrcodeHbGuiderActivity
 * JD-Core Version:    0.7.0.1
 */