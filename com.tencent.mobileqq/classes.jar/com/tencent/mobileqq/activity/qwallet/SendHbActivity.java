package com.tencent.mobileqq.activity.qwallet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.fragment.BaseHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.FragmentInterface;
import com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.SendHbLogic;
import com.tencent.mobileqq.activity.qwallet.fragment.SendHbMainFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.busylogic.ConfigLogic;
import com.tencent.mobileqq.activity.qwallet.fragment.busylogic.HbSkinLogic;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.activity.qwallet.widget.ImmersionBar;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.QwUtils;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import cooperation.qwallet.pluginshare.HbInfo;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RoutePage(desc="QQ钱包-发红包界面", path="/qwallet/redpacket/sendhb")
public class SendHbActivity
  extends FragmentActivity
  implements View.OnClickListener
{
  private static final int BROADCAST_VIDEO_TYPE = 999;
  private static final int ERR_IDIOM_RECOMMEND = 66249000;
  private static final int ERR_NOT_REGISTER = 66238025;
  private static final String RECEIVER_ACTION = "com.qwallet.report";
  private static final int REPORT_CODE_CANCEL = -1;
  private static final int REPORT_CODE_OK = 0;
  private static final String TAG = "SendHbActivity";
  private static final String TAG_Hb_CALLBACK = "sendHbCallback";
  private static final String TAG_QRCODE_Hb_CALLBACK = "qrcodeHbCallback";
  private static final int TYPE_LOGIC_FROM_AIO = 0;
  private static final int TYPE_LOGIC_FROM_SELECTOR = 1;
  private static final int TYPE_LOGIC_WRAP_AND_SHARE = 2;
  private String callbackSn;
  private QWalletPayProgressDialog dialog;
  private BaseHbFragment fragment = null;
  private HbSkinLogic hbSkinLogic;
  List<Integer> hb_callbacks = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(32768), Integer.valueOf(16384), Integer.valueOf(128), Integer.valueOf(256), Integer.valueOf(512), Integer.valueOf(2048) }));
  private String hb_from_type;
  Intent intent = new Intent();
  private boolean isActivityPause = false;
  private boolean isConfirm;
  private String mAppInfo;
  private int mComeFrom;
  private ConfigLogic mConfigLogic;
  private String mCount = "";
  public String mGroupCount;
  public String mGroupId;
  private BroadcastReceiver mHbReceiver = new SendHbActivity.1(this);
  private Intent mIntent;
  private boolean mIsBackKeyPressed = false;
  private boolean mIsTheme;
  private boolean mIs_H5;
  private String mListId;
  private int mLogicType = 0;
  private JSONObject mPaySuccessObj;
  private BroadcastReceiver mReceiver = new SendHbActivity.6(this);
  private String mRecvNick;
  private String mRecvType;
  private String mRecvTypeUpload;
  private String mRecvUin;
  public long mReportSeq;
  private View mSendLayout;
  public String mThemeType;
  private String mTotalAmount = "";
  private String mUin;
  private ImageView mViewShadow = null;
  private Map<String, String> mapParams;
  public int nChannel;
  private int nConfirm = -1;
  private int reportCode = 0;
  private View rootView;
  private ImageButton send_close;
  private View stateBar;
  
  private void addFragment()
  {
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    if (this.fragment != null)
    {
      ((FrameLayout)findViewById(2131365510)).setVisibility(0);
      localFragmentTransaction.add(2131365510, this.fragment);
      localFragmentTransaction.commit();
    }
  }
  
  private Bundle buildParamsBundle()
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.mapParams.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localBundle.putString(str, (String)this.mapParams.get(str));
    }
    localBundle.putString("channel", String.valueOf(this.nChannel));
    return localBundle;
  }
  
  private Map<String, String> conbineExtraParams(String paramString)
  {
    QLog.i("SendHbActivity", 2, "extra_data = " + paramString);
    paramString = QWalletTools.a(paramString);
    String str = (String)paramString.remove("extra_info");
    if (!TextUtils.isEmpty(str)) {
      paramString.putAll(QWalletTools.a(str));
    }
    paramString.put("send_name", this.mRecvNick);
    paramString.put("send_uin", this.mUin);
    return paramString;
  }
  
  private void finishIfHiddenMakeView()
  {
    if (QWalletTools.a(this.mapParams, "makeHb_type", "0").equals("1")) {
      finish();
    }
  }
  
  private void initCustomHb()
  {
    int i = 1;
    Object localObject;
    if ("1".equals(QWalletTools.a(this.mapParams, "makeHb_type", "0")))
    {
      this.rootView.setVisibility(8);
      this.mTotalAmount = ((String)this.mapParams.get("total_amount"));
      this.mCount = ((String)this.mapParams.get("total_num"));
      if (this.hb_from_type.equals("100"))
      {
        localObject = getMapPacketExtra();
        ((Map)localObject).put("type", "1");
        new SendHbLogic(this).a((Map)localObject);
        return;
      }
      new SendHbLogic(this).a();
      return;
    }
    if ((this.mIs_H5) && ("h5".equals(this.mapParams.get("invoke_from"))) && (this.nChannel == 2048))
    {
      new SendHbLogic(this).a("", this.mUin);
      finish();
      return;
    }
    if ((this.mIsTheme) || (this.nChannel == 64))
    {
      initThemeFragment();
      if (!(this.fragment instanceof SendHbMainFragment)) {
        new ImmersionBar(this, -1308622848, this.stateBar);
      }
      addFragment();
      return;
    }
    switch (this.nChannel)
    {
    default: 
      if (this.nChannel == 4096) {
        if (("1".equals(this.mRecvType)) || ("7".equals(this.mRecvType)) || ("6".equals(this.mRecvType))) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      localObject = getString(2131696747);
      if (this.nChannel == 512) {
        localObject = getString(2131697027);
      }
      boolean bool = getIntent().getBooleanExtra("isFromPanel", false);
      Bundle localBundle = buildParamsBundle();
      localBundle.putBoolean("isFromPanel", bool);
      localBundle.putInt("tabMask", i);
      localBundle.putString("hbTitle", (String)localObject);
      this.fragment = new SendHbMainFragment();
      this.fragment.setArguments(localBundle);
      break;
      initQzoneFragment();
      break;
      this.fragment = new ThemeHbFragment();
      this.fragment.setArguments(buildParamsBundle());
      break;
      i = 2;
      continue;
      if (!HbInfo.a.contains(this.mRecvType)) {
        if (this.nChannel == 2048) {
          i = 3;
        } else if (this.nChannel == 512) {
          i = 3;
        } else {
          i = 0;
        }
      }
    }
  }
  
  private void initData()
  {
    this.mUin = this.app.getCurrentAccountUin();
    this.mRecvNick = this.app.getCurrentNickname();
    this.mIsTheme = this.mIntent.getBooleanExtra("theme", false);
    this.hbSkinLogic = new HbSkinLogic(this);
    this.mConfigLogic = new ConfigLogic();
    this.mReportSeq = this.mIntent.getLongExtra("vacreport_key_seq", 0L);
    this.mIs_H5 = this.mIntent.getBooleanExtra("is_H5", false);
    this.mComeFrom = this.mIntent.getIntExtra("come_from", 1);
    this.callbackSn = this.mIntent.getStringExtra("callbackSn");
    this.mAppInfo = this.mIntent.getStringExtra("app_info");
    String str = this.mIntent.getStringExtra("extra_data");
    this.mapParams = conbineExtraParams(str);
    initReportFromOncreate(str);
    initLogicType(str);
    this.hb_from_type = QWalletTools.a(this.mapParams, "hb_from_type", "0");
    this.mRecvUin = ((String)this.mapParams.get("recv_uin"));
    this.mRecvType = ((String)this.mapParams.get("recv_type"));
    this.mRecvTypeUpload = this.mRecvType;
    this.nChannel = QwUtils.a(this.mapParams.get("channel"), 1);
    QLog.i("SendHbActivity", 2, "mChannel = " + this.nChannel);
    if (!this.mIsTheme) {
      this.mThemeType = ((String)this.mapParams.get("theme_type"));
    }
    try
    {
      if ((!TextUtils.isEmpty(this.mThemeType)) && (Integer.valueOf(this.mThemeType).intValue() > 1)) {
        this.mIsTheme = true;
      }
      if (TextUtils.isEmpty(this.mThemeType)) {
        this.mThemeType = this.mIntent.getStringExtra("theme_type");
      }
      if (5 == this.nChannel) {
        this.nChannel = 16;
      }
      if (6 == this.nChannel) {
        this.nChannel = 32;
      }
      if ((5 == this.nChannel) || (16 == this.nChannel) || (128 == this.nChannel) || (256 == this.nChannel))
      {
        this.mRecvNick = ContactUtils.q(this.app, this.mUin);
        if (TextUtils.isEmpty(this.mRecvNick)) {
          this.mRecvNick = this.app.getCurrentNickname();
        }
      }
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
  
  private void initLogicType(String paramString)
  {
    if (paramString.contains("recv_uin"))
    {
      if (paramString.contains("hb_from"))
      {
        this.mLogicType = 1;
        return;
      }
      this.mLogicType = 0;
      return;
    }
    this.mLogicType = 2;
  }
  
  private void initReportFromOncreate(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("isH5=").append(this.mIs_H5);
    localStringBuilder.append("&comeFrom=").append(this.mComeFrom);
    localStringBuilder.append("&callbackSn=").append(this.callbackSn);
    localStringBuilder.append("&appInfo=").append(this.mAppInfo);
    localStringBuilder.append("&extra=").append(paramString);
    if (this.mReportSeq == 0L)
    {
      this.mReportSeq = VACDReportUtil.a(null, "qqwallet", "makeHongbao", "hbinvoke", localStringBuilder.toString(), 0, null);
      return;
    }
    VACDReportUtil.a(this.mReportSeq, null, "hbinvoke", localStringBuilder.toString(), 0, null);
  }
  
  private void initThemeFragment()
  {
    boolean bool = false;
    Object localObject;
    if (TextUtils.isEmpty(this.mThemeType))
    {
      localObject = this.mIntent.getStringExtra("theme_config");
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    for (String str = "hb_theme_";; str = "")
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        if (!((JSONObject)localObject).has("hb_theme_id")) {
          continue;
        }
        this.mThemeType = ((JSONObject)localObject).optString(String.format("%sid", new Object[] { str }));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
        Bundle localBundle = buildParamsBundle();
        localBundle.putString("theme_type", this.mThemeType);
        if (64 != this.nChannel) {
          break label183;
        }
        this.mIsTheme = true;
        this.mGroupId = this.mIntent.getStringExtra("group_id");
        this.mGroupCount = this.mIntent.getStringExtra("group_member_number");
        this.fragment = new ThemeHbFragment();
        localBundle.putString("group_count", this.mGroupCount);
        if ((!"2".equals(this.mRecvType)) && (!"3".equals(this.mRecvType))) {
          break label233;
        }
        bool = true;
        localBundle.putBoolean("isGroupThemeHb", bool);
        this.fragment.setArguments(localBundle);
      }
      if (!TextUtils.isEmpty(this.mThemeType)) {
        break;
      }
      QLog.i("SendHbActivity", 2, "params error, no theme id...");
      QQToast.a(this, "params error, no theme id...", 0).a();
      finish();
      return;
    }
    label183:
    label233:
    return;
  }
  
  private void initView()
  {
    this.stateBar = findViewById(2131378435);
    this.rootView = findViewById(2131377356);
    this.mSendLayout = findViewById(2131377788);
    this.send_close = ((ImageButton)findViewById(2131377770));
    this.send_close.setOnClickListener(this);
    ((Button)findViewById(2131377785)).setOnClickListener(this);
  }
  
  private String mul(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new BigDecimal(paramString1);
      paramString2 = new BigDecimal(paramString2);
      paramString1 = new DecimalFormat("#0.00").format(paramString1.multiply(paramString2).doubleValue());
      return paramString1;
    }
    catch (Exception paramString1) {}
    return "0";
  }
  
  private void pay(String paramString)
  {
    if ((this.fragment != null) && ((this.fragment instanceof FragmentInterface))) {
      ((FragmentInterface)this.fragment).a();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tokenId", paramString);
      localJSONObject.put("comeForm", this.mComeFrom);
      localJSONObject.put("h5_success", true);
      localJSONObject.put("appInfo", this.mAppInfo);
      paramString = new Bundle();
      paramString.putString("json", localJSONObject.toString());
      paramString.putString("callbackSn", "0");
      paramString.putLong("vacreport_key_seq", this.mReportSeq);
      PayBridgeActivity.tenpay(this, 9, paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void preMConnect()
  {
    Bundle localBundle = new Bundle();
    Object localObject = (TicketManager)this.app.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(this.mUin);; localObject = "")
    {
      localBundle.putString("uin", this.mUin);
      localBundle.putString("skey", (String)localObject);
      localBundle.putString("skey_type", "2");
      localBundle.putInt("PayInvokerId", 21);
      QWalletPayBridge.launchBackground(BaseApplicationImpl.sApplication, this.app, localBundle);
      return;
    }
  }
  
  private void registBroadcast()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      registerReceiver(this.mReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void registerHbBroadCast()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.qwallet.report");
    registerReceiver(this.mHbReceiver, localIntentFilter);
  }
  
  private void setNightMaskVisible(boolean paramBoolean)
  {
    if (this.mViewShadow == null)
    {
      this.mViewShadow = new ImageView(this);
      this.mViewShadow.setImageDrawable(new ColorDrawable(Color.parseColor("#77000000")));
      this.mViewShadow.setPadding(0, 0, 0, 0);
      this.mViewShadow.setScaleType(ImageView.ScaleType.FIT_XY);
      ((FrameLayout)getWindow().getDecorView()).addView(this.mViewShadow, new ViewGroup.LayoutParams(-1, -1));
    }
    ImageView localImageView = this.mViewShadow;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  private void showShareUI()
  {
    this.rootView.setVisibility(0);
    this.mSendLayout.setVisibility(0);
    if (this.stateBar != null) {
      this.stateBar.setBackgroundColor(-1308622848);
    }
    addUploadData(this.mUin, getProcessType(), "hongbao.wrapped.show", "", "");
  }
  
  private String yuan2Fen(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Long.toString(Double.valueOf(mul(paramString, "100")).doubleValue());
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  public void addCommonHbUploadData(String paramString1, String paramString2, int paramInt)
  {
    addUploadData(this.mUin, getProcessType(), paramString1, paramString2, "");
  }
  
  public void addHbUploadData(String paramString)
  {
    addUploadData(this.mUin, getProcessType(), paramString, "", "");
  }
  
  public void addQZoneHbUploadData(int paramInt1, String paramString, int paramInt2)
  {
    addUploadData(this.mUin, paramInt1, paramString, "", "");
  }
  
  public void addUploadData(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    QWalletTools.a(this.app, paramString1, this.mComeFrom, this.mAppInfo, this.mReportSeq, paramInt, paramString2, paramString3, paramString4);
  }
  
  public void callForwardPage(String paramString, ArrayList<String> paramArrayList)
  {
    Intent localIntent = new Intent(this, SelectMemberActivity.class);
    if ("2".equals(paramString)) {
      localIntent.putExtra("param_only_discussion_member", true);
    }
    for (;;)
    {
      localIntent.putExtra("param_title", getString(2131696629));
      localIntent.putExtra("param_min", 0);
      localIntent.putExtra("param_done_button_wording", getString(2131718991));
      localIntent.putExtra("param_done_button_highlight_wording", getString(2131718992));
      localIntent.putExtra("param_max", 5);
      localIntent.putExtra("param_entrance", 25);
      if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
        break label211;
      }
      paramString = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        new ResultRecord().uin = str;
        paramString.add(SelectMemberActivity.a(str, "", 0, this.mUin));
      }
      if ("3".equals(paramString)) {
        localIntent.putExtra("param_only_troop_member", true);
      }
    }
    localIntent.putExtra("param_selected_records_for_create_discussion", paramString);
    label211:
    localIntent.putExtra("group_uin", this.mRecvUin);
    paramString = getCurrentAccountUin();
    if (!TextUtils.isEmpty(paramString))
    {
      paramArrayList = new ArrayList();
      paramArrayList.add(paramString);
      localIntent.putExtra("param_uins_hide", paramArrayList);
    }
    startActivityForResult(localIntent, 1024);
  }
  
  public void cancelCallBack()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("resultCode", -1);
      label17:
      Intent localIntent = new Intent();
      localIntent.putExtra("callbackSn", this.callbackSn);
      localIntent.putExtra("PayInvokerId", 5);
      localIntent.putExtra("result", localJSONObject.toString());
      setResult(0, localIntent);
      return;
    }
    catch (Exception localException)
    {
      break label17;
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
  
  public void doOnBackPressed()
  {
    QLog.i("SendHbActivity", 2, "SendHbActivity doOnBackPressed...");
    setResult(0, new Intent());
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    this.mIntent = localIntent;
    localIntent.putExtra("fling_action_key", 0);
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    try
    {
      registerHbBroadCast();
      setProgressBarIndeterminateVisibility(false);
      setRequestedOrientation(1);
      setContentView(2131560690);
      initData();
      initView();
      initCustomHb();
      registBroadcast();
      QWalletHelperImpl.preloadQWallet(this.app);
      if (QWalletHelperImpl.isNeedPreConnect(this, this.mUin, "type_mqq_and_myun")) {
        preMConnect();
      }
      return true;
    }
    catch (OutOfMemoryError paramBundle) {}
    return false;
  }
  
  public void doOnDestroy()
  {
    this.hbSkinLogic.a();
    try
    {
      if (this.mReportSeq != 0L) {
        VACDReportUtil.endReport(this.mReportSeq, "hongbao.wrap.destroy", null, this.reportCode, null);
      }
      if (this.mReceiver != null) {
        unregisterReceiver(this.mReceiver);
      }
      this.mReceiver = null;
      unregisterReceiver(this.mHbReceiver);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.isActivityPause = true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.isActivityPause = false;
    addUploadData(this.mUin, getProcessType(), "hongbao.wrap.show", "", "");
    setNightMaskVisible("1103".equals(ThemeUtil.getCurrentThemeId()));
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.hbSkinLogic.b();
  }
  
  public ConfigLogic getConfigLogic()
  {
    return this.mConfigLogic;
  }
  
  public int getForwardItem()
  {
    String str = QWalletTools.a(QWalletTools.a((String)this.mapParams.get("selector")), "friend_type", "1");
    int i = 0;
    if (str.equals("1")) {
      i = 1;
    }
    do
    {
      return i;
      if (str.equals("2")) {
        return 16;
      }
      if (str.equals("3")) {
        return 256;
      }
      if (str.equals("1|2")) {
        return 17;
      }
      if (str.equals("1|3")) {
        return 257;
      }
      if (str.equals("2|3")) {
        return 272;
      }
    } while (!str.equals("1|2|3"));
    return 273;
  }
  
  public HbSkinLogic getHbSkinLogic()
  {
    return this.hbSkinLogic;
  }
  
  public Map<String, String> getMapPacketExtra()
  {
    HashMap localHashMap = new HashMap(this.mapParams);
    localHashMap.put("name", this.mRecvNick);
    if (2048 != this.nChannel) {
      localHashMap.put("recv_type", this.mRecvTypeUpload);
    }
    localHashMap.put("hb_from_type", this.hb_from_type + "");
    return localHashMap;
  }
  
  public Map<String, String> getMapPacketJson()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("userId", this.mUin);
    localHashMap.put("viewTag", "sendHb");
    localHashMap.put("comeForm", "2");
    localHashMap.put("appInfo", this.mAppInfo);
    return localHashMap;
  }
  
  protected int getProcessType()
  {
    int i;
    if (this.mIs_H5) {
      i = 131;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SendHbActivity", 2, "getProcessType: processFlag:" + i);
      }
      return i;
      if (TextUtils.isEmpty(this.mRecvType))
      {
        if (HbInfo.b.contains(this.mRecvType)) {
          i = 133;
        } else {
          i = 132;
        }
      }
      else {
        i = 499;
      }
    }
  }
  
  public int getTitleBarHeight(Context paramContext)
  {
    try
    {
      int i = paramContext.getResources().getDimensionPixelSize(2131299166);
      float f = paramContext.getResources().getDisplayMetrics().density;
      return i - (int)(f * 5.0F);
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public void initQzoneFragment()
  {
    this.fragment = new QzoneHbFragment();
    Bundle localBundle = buildParamsBundle();
    this.fragment.setArguments(localBundle);
  }
  
  /* Error */
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc 29
    //   2: iconst_2
    //   3: new 256	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 1085
    //   13: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: iload_1
    //   17: invokevirtual 517	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20: ldc_w 1087
    //   23: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: iload_2
    //   27: invokevirtual 517	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 273	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: ldc 29
    //   38: iconst_2
    //   39: new 256	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   46: ldc_w 1089
    //   49: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_3
    //   53: invokevirtual 1092	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 273	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: aload_0
    //   63: getfield 107	com/tencent/mobileqq/activity/qwallet/SendHbActivity:fragment	Lcom/tencent/mobileqq/activity/qwallet/fragment/BaseHbFragment;
    //   66: ifnull +13 -> 79
    //   69: aload_0
    //   70: getfield 107	com/tencent/mobileqq/activity/qwallet/SendHbActivity:fragment	Lcom/tencent/mobileqq/activity/qwallet/fragment/BaseHbFragment;
    //   73: iload_1
    //   74: iload_2
    //   75: aload_3
    //   76: invokevirtual 1094	com/tencent/mobileqq/activity/qwallet/fragment/BaseHbFragment:onActivityResult	(IILandroid/content/Intent;)V
    //   79: aload_0
    //   80: iconst_0
    //   81: putfield 105	com/tencent/mobileqq/activity/qwallet/SendHbActivity:isActivityPause	Z
    //   84: aload_3
    //   85: ifnull +1204 -> 1289
    //   88: iload_2
    //   89: iconst_m1
    //   90: if_icmpne +1199 -> 1289
    //   93: aload_3
    //   94: ldc_w 906
    //   97: invokevirtual 481	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   100: astore 6
    //   102: aconst_null
    //   103: astore 5
    //   105: aload 6
    //   107: ifnull +203 -> 310
    //   110: aload 6
    //   112: invokevirtual 1097	java/lang/String:length	()I
    //   115: ifle +195 -> 310
    //   118: new 575	org/json/JSONObject
    //   121: dup
    //   122: aload 6
    //   124: invokespecial 577	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   127: astore 4
    //   129: ldc 29
    //   131: iconst_2
    //   132: new 256	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 1099
    //   142: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload 4
    //   147: invokevirtual 1092	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 273	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aload 4
    //   158: ifnull +1144 -> 1302
    //   161: aload 4
    //   163: ldc_w 1101
    //   166: invokevirtual 594	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   169: astore 5
    //   171: aload 4
    //   173: ldc_w 904
    //   176: iconst_m1
    //   177: invokevirtual 1104	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   180: istore_2
    //   181: aload_0
    //   182: iload_2
    //   183: putfield 128	com/tencent/mobileqq/activity/qwallet/SendHbActivity:reportCode	I
    //   186: aload 4
    //   188: ldc_w 1106
    //   191: invokevirtual 594	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   194: astore_3
    //   195: aload_3
    //   196: ifnull +125 -> 321
    //   199: aload_3
    //   200: invokevirtual 1097	java/lang/String:length	()I
    //   203: ifle +118 -> 321
    //   206: new 575	org/json/JSONObject
    //   209: dup
    //   210: aload_3
    //   211: invokespecial 577	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   214: astore_3
    //   215: aload_0
    //   216: getfield 128	com/tencent/mobileqq/activity/qwallet/SendHbActivity:reportCode	I
    //   219: ifeq +44 -> 263
    //   222: aload_0
    //   223: aload_0
    //   224: getfield 170	com/tencent/mobileqq/activity/qwallet/SendHbActivity:mUin	Ljava/lang/String;
    //   227: aload_0
    //   228: invokevirtual 805	com/tencent/mobileqq/activity/qwallet/SendHbActivity:getProcessType	()I
    //   231: new 256	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   238: aload 5
    //   240: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc_w 1108
    //   246: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: iload_2
    //   250: invokevirtual 517	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   253: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: ldc 111
    //   258: ldc 111
    //   260: invokevirtual 811	com/tencent/mobileqq/activity/qwallet/SendHbActivity:addUploadData	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload_0
    //   264: getfield 1110	com/tencent/mobileqq/activity/qwallet/SendHbActivity:dialog	Lcooperation/qwallet/plugin/QWalletPayProgressDialog;
    //   267: invokevirtual 1115	cooperation/qwallet/plugin/QWalletPayProgressDialog:dismiss	()V
    //   270: iload_2
    //   271: ifne +730 -> 1001
    //   274: aload_3
    //   275: ifnull +726 -> 1001
    //   278: iload_1
    //   279: lookupswitch	default:+25->304, 5:+47->326, 9:+371->650
    //   305: astore_3
    //   306: aload_3
    //   307: invokevirtual 536	java/lang/Exception:printStackTrace	()V
    //   310: aconst_null
    //   311: astore 4
    //   313: goto -184 -> 129
    //   316: astore_3
    //   317: aload_3
    //   318: invokevirtual 536	java/lang/Exception:printStackTrace	()V
    //   321: aconst_null
    //   322: astore_3
    //   323: goto -108 -> 215
    //   326: aload_0
    //   327: getfield 1117	com/tencent/mobileqq/activity/qwallet/SendHbActivity:isConfirm	Z
    //   330: ifeq +211 -> 541
    //   333: aload_0
    //   334: iconst_0
    //   335: putfield 1117	com/tencent/mobileqq/activity/qwallet/SendHbActivity:isConfirm	Z
    //   338: aload_0
    //   339: iconst_m1
    //   340: putfield 117	com/tencent/mobileqq/activity/qwallet/SendHbActivity:nConfirm	I
    //   343: aload_3
    //   344: ldc_w 1119
    //   347: invokevirtual 1121	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   350: istore_1
    //   351: iconst_1
    //   352: iload_1
    //   353: if_icmpeq +8 -> 361
    //   356: iconst_2
    //   357: iload_1
    //   358: if_icmpne +120 -> 478
    //   361: aload_0
    //   362: getfield 503	com/tencent/mobileqq/activity/qwallet/SendHbActivity:mRecvUin	Ljava/lang/String;
    //   365: invokestatic 290	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   368: ifeq +19 -> 387
    //   371: aload_0
    //   372: invokespecial 1123	com/tencent/mobileqq/activity/qwallet/SendHbActivity:showShareUI	()V
    //   375: aload_0
    //   376: aload_3
    //   377: ldc_w 1125
    //   380: invokevirtual 594	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   383: putfield 167	com/tencent/mobileqq/activity/qwallet/SendHbActivity:mListId	Ljava/lang/String;
    //   386: return
    //   387: sipush 256
    //   390: aload_0
    //   391: getfield 249	com/tencent/mobileqq/activity/qwallet/SendHbActivity:nChannel	I
    //   394: if_icmpeq +68 -> 462
    //   397: sipush 128
    //   400: aload_0
    //   401: getfield 249	com/tencent/mobileqq/activity/qwallet/SendHbActivity:nChannel	I
    //   404: if_icmpeq +58 -> 462
    //   407: sipush 512
    //   410: aload_0
    //   411: getfield 249	com/tencent/mobileqq/activity/qwallet/SendHbActivity:nChannel	I
    //   414: if_icmpeq +48 -> 462
    //   417: sipush 2048
    //   420: aload_0
    //   421: getfield 249	com/tencent/mobileqq/activity/qwallet/SendHbActivity:nChannel	I
    //   424: if_icmpeq +38 -> 462
    //   427: aload_0
    //   428: getfield 1127	com/tencent/mobileqq/activity/qwallet/SendHbActivity:mPaySuccessObj	Lorg/json/JSONObject;
    //   431: ifnull +868 -> 1299
    //   434: aload_0
    //   435: getfield 1127	com/tencent/mobileqq/activity/qwallet/SendHbActivity:mPaySuccessObj	Lorg/json/JSONObject;
    //   438: astore_3
    //   439: aload_0
    //   440: getfield 249	com/tencent/mobileqq/activity/qwallet/SendHbActivity:nChannel	I
    //   443: sipush 16384
    //   446: if_icmpne +10 -> 456
    //   449: aload_0
    //   450: aload 4
    //   452: invokevirtual 1131	com/tencent/mobileqq/activity/qwallet/SendHbActivity:onFaceHbResult	(Lorg/json/JSONObject;)V
    //   455: return
    //   456: aload_0
    //   457: aload_3
    //   458: invokevirtual 1134	com/tencent/mobileqq/activity/qwallet/SendHbActivity:onCommonHbResult	(Lorg/json/JSONObject;)V
    //   461: return
    //   462: sipush 2048
    //   465: aload_0
    //   466: getfield 249	com/tencent/mobileqq/activity/qwallet/SendHbActivity:nChannel	I
    //   469: if_icmpne -165 -> 304
    //   472: aload_0
    //   473: aload_3
    //   474: invokevirtual 1137	com/tencent/mobileqq/activity/qwallet/SendHbActivity:onQrcodeHbResult	(Lorg/json/JSONObject;)V
    //   477: return
    //   478: sipush 256
    //   481: aload_0
    //   482: getfield 249	com/tencent/mobileqq/activity/qwallet/SendHbActivity:nChannel	I
    //   485: if_icmpeq +22 -> 507
    //   488: sipush 128
    //   491: aload_0
    //   492: getfield 249	com/tencent/mobileqq/activity/qwallet/SendHbActivity:nChannel	I
    //   495: if_icmpeq +12 -> 507
    //   498: aload_0
    //   499: getfield 249	com/tencent/mobileqq/activity/qwallet/SendHbActivity:nChannel	I
    //   502: ldc 133
    //   504: if_icmpne +9 -> 513
    //   507: aload_0
    //   508: aload_3
    //   509: invokevirtual 1140	com/tencent/mobileqq/activity/qwallet/SendHbActivity:onRewardHbResult	(Lorg/json/JSONObject;)V
    //   512: return
    //   513: sipush 512
    //   516: aload_0
    //   517: getfield 249	com/tencent/mobileqq/activity/qwallet/SendHbActivity:nChannel	I
    //   520: if_icmpne +9 -> 529
    //   523: aload_0
    //   524: aload_3
    //   525: invokevirtual 1143	com/tencent/mobileqq/activity/qwallet/SendHbActivity:onVisitHbResult	(Lorg/json/JSONObject;)V
    //   528: return
    //   529: aload_0
    //   530: aload_0
    //   531: ldc_w 1144
    //   534: invokevirtual 382	com/tencent/mobileqq/activity/qwallet/SendHbActivity:getString	(I)Ljava/lang/String;
    //   537: invokevirtual 1148	com/tencent/mobileqq/activity/qwallet/SendHbActivity:showToast	(Ljava/lang/CharSequence;)V
    //   540: return
    //   541: bipush 64
    //   543: aload_0
    //   544: getfield 249	com/tencent/mobileqq/activity/qwallet/SendHbActivity:nChannel	I
    //   547: if_icmpeq +12 -> 559
    //   550: aload_0
    //   551: getfield 249	com/tencent/mobileqq/activity/qwallet/SendHbActivity:nChannel	I
    //   554: bipush 64
    //   556: if_icmpne +71 -> 627
    //   559: new 575	org/json/JSONObject
    //   562: dup
    //   563: invokespecial 667	org/json/JSONObject:<init>	()V
    //   566: astore 4
    //   568: aload 4
    //   570: ldc_w 1150
    //   573: aload_3
    //   574: ldc_w 1150
    //   577: invokevirtual 594	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   580: invokevirtual 1153	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   583: pop
    //   584: aload 4
    //   586: ldc_w 330
    //   589: aload_0
    //   590: getfield 113	com/tencent/mobileqq/activity/qwallet/SendHbActivity:mTotalAmount	Ljava/lang/String;
    //   593: invokevirtual 1153	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   596: pop
    //   597: aload_0
    //   598: iconst_m1
    //   599: aload_0
    //   600: iload_2
    //   601: ldc 111
    //   603: aload 4
    //   605: invokevirtual 687	org/json/JSONObject:toString	()Ljava/lang/String;
    //   608: invokevirtual 1157	com/tencent/mobileqq/activity/qwallet/SendHbActivity:onGroupHbBack	(ILjava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   611: invokevirtual 910	com/tencent/mobileqq/activity/qwallet/SendHbActivity:setResult	(ILandroid/content/Intent;)V
    //   614: aload_0
    //   615: invokevirtual 322	com/tencent/mobileqq/activity/qwallet/SendHbActivity:finish	()V
    //   618: return
    //   619: astore_3
    //   620: aload_3
    //   621: invokevirtual 698	org/json/JSONException:printStackTrace	()V
    //   624: goto -27 -> 597
    //   627: aload_0
    //   628: aload_3
    //   629: ldc_w 1159
    //   632: invokevirtual 1121	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   635: putfield 117	com/tencent/mobileqq/activity/qwallet/SendHbActivity:nConfirm	I
    //   638: aload_0
    //   639: aload_3
    //   640: ldc_w 1150
    //   643: invokevirtual 594	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   646: invokespecial 1161	com/tencent/mobileqq/activity/qwallet/SendHbActivity:pay	(Ljava/lang/String;)V
    //   649: return
    //   650: aload_3
    //   651: ldc_w 1163
    //   654: iconst_m1
    //   655: invokevirtual 1104	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   658: ifne +32 -> 690
    //   661: aload_0
    //   662: getfield 103	com/tencent/mobileqq/activity/qwallet/SendHbActivity:mLogicType	I
    //   665: iconst_2
    //   666: if_icmpeq +8 -> 674
    //   669: aload_0
    //   670: invokevirtual 322	com/tencent/mobileqq/activity/qwallet/SendHbActivity:finish	()V
    //   673: return
    //   674: aload_0
    //   675: aload_3
    //   676: ldc_w 1125
    //   679: invokevirtual 594	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   682: putfield 167	com/tencent/mobileqq/activity/qwallet/SendHbActivity:mListId	Ljava/lang/String;
    //   685: aload_0
    //   686: invokespecial 1123	com/tencent/mobileqq/activity/qwallet/SendHbActivity:showShareUI	()V
    //   689: return
    //   690: aload_3
    //   691: ldc_w 1165
    //   694: invokevirtual 594	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   697: astore 4
    //   699: new 1167	java/lang/StringBuffer
    //   702: dup
    //   703: invokespecial 1168	java/lang/StringBuffer:<init>	()V
    //   706: astore 5
    //   708: aload 5
    //   710: ldc_w 1170
    //   713: invokevirtual 1173	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   716: pop
    //   717: aload 5
    //   719: aload_0
    //   720: getfield 115	com/tencent/mobileqq/activity/qwallet/SendHbActivity:mCount	Ljava/lang/String;
    //   723: invokevirtual 1173	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   726: pop
    //   727: aload 5
    //   729: ldc_w 1175
    //   732: invokevirtual 1173	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   735: pop
    //   736: ldc_w 315
    //   739: aload_0
    //   740: getfield 374	com/tencent/mobileqq/activity/qwallet/SendHbActivity:mRecvType	Ljava/lang/String;
    //   743: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   746: ifne +42 -> 788
    //   749: ldc_w 376
    //   752: aload_0
    //   753: getfield 374	com/tencent/mobileqq/activity/qwallet/SendHbActivity:mRecvType	Ljava/lang/String;
    //   756: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   759: ifne +29 -> 788
    //   762: ldc_w 1177
    //   765: aload_0
    //   766: getfield 374	com/tencent/mobileqq/activity/qwallet/SendHbActivity:mRecvType	Ljava/lang/String;
    //   769: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   772: ifne +16 -> 788
    //   775: ldc_w 1179
    //   778: aload_0
    //   779: getfield 374	com/tencent/mobileqq/activity/qwallet/SendHbActivity:mRecvType	Ljava/lang/String;
    //   782: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   785: ifeq +146 -> 931
    //   788: aload 5
    //   790: ldc_w 1181
    //   793: invokevirtual 1173	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   796: pop
    //   797: aload 5
    //   799: ldc_w 1183
    //   802: invokevirtual 1173	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   805: pop
    //   806: aload 5
    //   808: aload_0
    //   809: getfield 249	com/tencent/mobileqq/activity/qwallet/SendHbActivity:nChannel	I
    //   812: invokevirtual 1186	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   815: pop
    //   816: aload 5
    //   818: ldc_w 1188
    //   821: invokevirtual 1173	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   824: pop
    //   825: aload 5
    //   827: aload_0
    //   828: getfield 113	com/tencent/mobileqq/activity/qwallet/SendHbActivity:mTotalAmount	Ljava/lang/String;
    //   831: invokevirtual 1173	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   834: pop
    //   835: aload_0
    //   836: aload_0
    //   837: getfield 170	com/tencent/mobileqq/activity/qwallet/SendHbActivity:mUin	Ljava/lang/String;
    //   840: aload_0
    //   841: invokevirtual 805	com/tencent/mobileqq/activity/qwallet/SendHbActivity:getProcessType	()I
    //   844: ldc_w 1190
    //   847: aload 5
    //   849: invokevirtual 1191	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   852: aconst_null
    //   853: invokevirtual 811	com/tencent/mobileqq/activity/qwallet/SendHbActivity:addUploadData	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   856: aload 4
    //   858: ifnull -554 -> 304
    //   861: aload_0
    //   862: getfield 503	com/tencent/mobileqq/activity/qwallet/SendHbActivity:mRecvUin	Ljava/lang/String;
    //   865: invokestatic 290	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   868: ifne +30 -> 898
    //   871: aload_0
    //   872: getfield 117	com/tencent/mobileqq/activity/qwallet/SendHbActivity:nConfirm	I
    //   875: iconst_1
    //   876: if_icmpeq +22 -> 898
    //   879: aload_0
    //   880: getfield 148	com/tencent/mobileqq/activity/qwallet/SendHbActivity:hb_callbacks	Ljava/util/List;
    //   883: aload_0
    //   884: getfield 249	com/tencent/mobileqq/activity/qwallet/SendHbActivity:nChannel	I
    //   887: invokestatic 137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   890: invokeinterface 429 2 0
    //   895: ifeq +84 -> 979
    //   898: aload_3
    //   899: ldc_w 1193
    //   902: invokevirtual 594	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   905: astore 4
    //   907: sipush 2048
    //   910: aload_0
    //   911: getfield 249	com/tencent/mobileqq/activity/qwallet/SendHbActivity:nChannel	I
    //   914: if_icmpne +54 -> 968
    //   917: aload_0
    //   918: ldc 35
    //   920: aload 4
    //   922: invokevirtual 1196	com/tencent/mobileqq/activity/qwallet/SendHbActivity:sendConfirmRequest	(Ljava/lang/String;Ljava/lang/String;)V
    //   925: aload_0
    //   926: aload_3
    //   927: putfield 1127	com/tencent/mobileqq/activity/qwallet/SendHbActivity:mPaySuccessObj	Lorg/json/JSONObject;
    //   930: return
    //   931: ldc_w 616
    //   934: aload_0
    //   935: getfield 374	com/tencent/mobileqq/activity/qwallet/SendHbActivity:mRecvType	Ljava/lang/String;
    //   938: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   941: ifeq +15 -> 956
    //   944: aload 5
    //   946: ldc_w 1198
    //   949: invokevirtual 1173	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   952: pop
    //   953: goto -156 -> 797
    //   956: aload 5
    //   958: ldc_w 1200
    //   961: invokevirtual 1173	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   964: pop
    //   965: goto -168 -> 797
    //   968: aload_0
    //   969: ldc 32
    //   971: aload 4
    //   973: invokevirtual 1196	com/tencent/mobileqq/activity/qwallet/SendHbActivity:sendConfirmRequest	(Ljava/lang/String;Ljava/lang/String;)V
    //   976: goto -51 -> 925
    //   979: aload_0
    //   980: getfield 249	com/tencent/mobileqq/activity/qwallet/SendHbActivity:nChannel	I
    //   983: sipush 16384
    //   986: if_icmpne +9 -> 995
    //   989: aload_0
    //   990: aload_3
    //   991: invokevirtual 1131	com/tencent/mobileqq/activity/qwallet/SendHbActivity:onFaceHbResult	(Lorg/json/JSONObject;)V
    //   994: return
    //   995: aload_0
    //   996: aload_3
    //   997: invokevirtual 1134	com/tencent/mobileqq/activity/qwallet/SendHbActivity:onCommonHbResult	(Lorg/json/JSONObject;)V
    //   1000: return
    //   1001: iload_2
    //   1002: ifle +211 -> 1213
    //   1005: aload_0
    //   1006: getfield 1117	com/tencent/mobileqq/activity/qwallet/SendHbActivity:isConfirm	Z
    //   1009: ifeq +51 -> 1060
    //   1012: sipush 256
    //   1015: aload_0
    //   1016: getfield 249	com/tencent/mobileqq/activity/qwallet/SendHbActivity:nChannel	I
    //   1019: if_icmpeq +13 -> 1032
    //   1022: sipush 128
    //   1025: aload_0
    //   1026: getfield 249	com/tencent/mobileqq/activity/qwallet/SendHbActivity:nChannel	I
    //   1029: if_icmpne +80 -> 1109
    //   1032: new 155	android/content/Intent
    //   1035: dup
    //   1036: invokespecial 156	android/content/Intent:<init>	()V
    //   1039: astore_3
    //   1040: aload_3
    //   1041: ldc_w 1101
    //   1044: aload 6
    //   1046: invokevirtual 854	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1049: pop
    //   1050: aload_0
    //   1051: iconst_m1
    //   1052: aload_3
    //   1053: invokevirtual 910	com/tencent/mobileqq/activity/qwallet/SendHbActivity:setResult	(ILandroid/content/Intent;)V
    //   1056: aload_0
    //   1057: invokevirtual 322	com/tencent/mobileqq/activity/qwallet/SendHbActivity:finish	()V
    //   1060: aload_0
    //   1061: ldc_w 1201
    //   1064: invokevirtual 382	com/tencent/mobileqq/activity/qwallet/SendHbActivity:getString	(I)Ljava/lang/String;
    //   1067: astore_3
    //   1068: iload_2
    //   1069: ldc 18
    //   1071: if_icmpne +66 -> 1137
    //   1074: aload_0
    //   1075: sipush 230
    //   1078: aconst_null
    //   1079: aload 5
    //   1081: aconst_null
    //   1082: aload_0
    //   1083: ldc_w 1202
    //   1086: invokevirtual 382	com/tencent/mobileqq/activity/qwallet/SendHbActivity:getString	(I)Ljava/lang/String;
    //   1089: new 1204	com/tencent/mobileqq/activity/qwallet/SendHbActivity$2
    //   1092: dup
    //   1093: aload_0
    //   1094: invokespecial 1205	com/tencent/mobileqq/activity/qwallet/SendHbActivity$2:<init>	(Lcom/tencent/mobileqq/activity/qwallet/SendHbActivity;)V
    //   1097: aconst_null
    //   1098: invokestatic 1210	com/tencent/mobileqq/utils/DialogUtil:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1101: invokevirtual 1215	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   1104: aload_0
    //   1105: invokespecial 163	com/tencent/mobileqq/activity/qwallet/SendHbActivity:finishIfHiddenMakeView	()V
    //   1108: return
    //   1109: aload_0
    //   1110: getfield 503	com/tencent/mobileqq/activity/qwallet/SendHbActivity:mRecvUin	Ljava/lang/String;
    //   1113: invokestatic 290	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1116: ifne -56 -> 1060
    //   1119: aload_0
    //   1120: getfield 1127	com/tencent/mobileqq/activity/qwallet/SendHbActivity:mPaySuccessObj	Lorg/json/JSONObject;
    //   1123: ifnull -63 -> 1060
    //   1126: aload_0
    //   1127: aload_0
    //   1128: getfield 1127	com/tencent/mobileqq/activity/qwallet/SendHbActivity:mPaySuccessObj	Lorg/json/JSONObject;
    //   1131: invokevirtual 1134	com/tencent/mobileqq/activity/qwallet/SendHbActivity:onCommonHbResult	(Lorg/json/JSONObject;)V
    //   1134: goto -74 -> 1060
    //   1137: iload_2
    //   1138: ldc 16
    //   1140: if_icmpne +51 -> 1191
    //   1143: aload 5
    //   1145: invokestatic 290	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1148: ifne +43 -> 1191
    //   1151: aload_0
    //   1152: invokevirtual 1218	com/tencent/mobileqq/activity/qwallet/SendHbActivity:isFinishing	()Z
    //   1155: ifne -51 -> 1104
    //   1158: aload_0
    //   1159: sipush 230
    //   1162: aconst_null
    //   1163: aload 5
    //   1165: aconst_null
    //   1166: aload_0
    //   1167: ldc_w 1219
    //   1170: invokevirtual 382	com/tencent/mobileqq/activity/qwallet/SendHbActivity:getString	(I)Ljava/lang/String;
    //   1173: new 1221	com/tencent/mobileqq/activity/qwallet/SendHbActivity$3
    //   1176: dup
    //   1177: aload_0
    //   1178: invokespecial 1222	com/tencent/mobileqq/activity/qwallet/SendHbActivity$3:<init>	(Lcom/tencent/mobileqq/activity/qwallet/SendHbActivity;)V
    //   1181: aconst_null
    //   1182: invokestatic 1210	com/tencent/mobileqq/utils/DialogUtil:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1185: invokevirtual 1215	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   1188: goto -84 -> 1104
    //   1191: aload 5
    //   1193: ifnull +12 -> 1205
    //   1196: aload_0
    //   1197: aload 5
    //   1199: invokevirtual 1148	com/tencent/mobileqq/activity/qwallet/SendHbActivity:showToast	(Ljava/lang/CharSequence;)V
    //   1202: goto -98 -> 1104
    //   1205: aload_0
    //   1206: aload_3
    //   1207: invokevirtual 1148	com/tencent/mobileqq/activity/qwallet/SendHbActivity:showToast	(Ljava/lang/CharSequence;)V
    //   1210: goto -106 -> 1104
    //   1213: iload_2
    //   1214: bipush 246
    //   1216: if_icmpge +35 -> 1251
    //   1219: aload_0
    //   1220: new 256	java/lang/StringBuilder
    //   1223: dup
    //   1224: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   1227: ldc_w 1223
    //   1230: invokestatic 1227	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1233: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1236: iload_2
    //   1237: invokevirtual 517	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1240: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1243: invokevirtual 1148	com/tencent/mobileqq/activity/qwallet/SendHbActivity:showToast	(Ljava/lang/CharSequence;)V
    //   1246: aload_0
    //   1247: invokespecial 163	com/tencent/mobileqq/activity/qwallet/SendHbActivity:finishIfHiddenMakeView	()V
    //   1250: return
    //   1251: new 155	android/content/Intent
    //   1254: dup
    //   1255: invokespecial 156	android/content/Intent:<init>	()V
    //   1258: astore_3
    //   1259: aload_3
    //   1260: ldc_w 716
    //   1263: iconst_5
    //   1264: invokevirtual 859	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1267: pop
    //   1268: aload_3
    //   1269: ldc_w 906
    //   1272: aload 6
    //   1274: invokevirtual 854	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1277: pop
    //   1278: aload_0
    //   1279: iconst_m1
    //   1280: aload_3
    //   1281: invokevirtual 910	com/tencent/mobileqq/activity/qwallet/SendHbActivity:setResult	(ILandroid/content/Intent;)V
    //   1284: aload_0
    //   1285: invokespecial 163	com/tencent/mobileqq/activity/qwallet/SendHbActivity:finishIfHiddenMakeView	()V
    //   1288: return
    //   1289: aload_0
    //   1290: invokespecial 163	com/tencent/mobileqq/activity/qwallet/SendHbActivity:finishIfHiddenMakeView	()V
    //   1293: return
    //   1294: astore 7
    //   1296: goto -1026 -> 270
    //   1299: goto -860 -> 439
    //   1302: aconst_null
    //   1303: astore_3
    //   1304: goto -1041 -> 263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1307	0	this	SendHbActivity
    //   0	1307	1	paramInt1	int
    //   0	1307	2	paramInt2	int
    //   0	1307	3	paramIntent	Intent
    //   127	845	4	localObject1	Object
    //   103	1095	5	localObject2	Object
    //   100	1173	6	str	String
    //   1294	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   118	129	305	java/lang/Exception
    //   206	215	316	java/lang/Exception
    //   568	597	619	org/json/JSONException
    //   263	270	1294	java/lang/Exception
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131377785)
    {
      addUploadData(this.mUin, getProcessType(), "hongbao.wrapped.send", "", "");
      sendPackedHb();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131377770)
      {
        String str2 = getString(2131696888) + getString(2131696556);
        String str1 = getString(2131696842);
        if (this.mIsTheme)
        {
          str2 = getString(2131696888);
          str1 = getString(2131696640);
        }
        showDialog(str2, str1, getString(2131696891));
        if (this.mIsBackKeyPressed) {
          addUploadData(this.mUin, getProcessType(), "hongbao.wrapped.keyback", "", "");
        } else {
          addUploadData(this.mUin, getProcessType(), "hongbao.wrapped.close", "", "");
        }
      }
    }
  }
  
  /* Error */
  protected void onCommonHbResult(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc 29
    //   2: iconst_2
    //   3: new 256	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 1255
    //   13: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_1
    //   17: invokevirtual 1092	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokestatic 273	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aload_1
    //   27: ifnonnull +4 -> 31
    //   30: return
    //   31: new 1167	java/lang/StringBuffer
    //   34: dup
    //   35: aload_1
    //   36: ldc_w 1165
    //   39: invokevirtual 594	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   42: invokestatic 1260	android/net/Uri:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   45: invokespecial 1261	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   48: astore_2
    //   49: aload_1
    //   50: ldc_w 1193
    //   53: invokevirtual 594	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_3
    //   57: aload_3
    //   58: invokestatic 290	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   61: ifne +17 -> 78
    //   64: aload_2
    //   65: ldc_w 1263
    //   68: invokevirtual 1173	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   71: pop
    //   72: aload_2
    //   73: aload_3
    //   74: invokevirtual 1173	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   77: pop
    //   78: aload_1
    //   79: ldc_w 1265
    //   82: invokevirtual 594	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   85: astore_3
    //   86: aload_3
    //   87: invokestatic 290	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   90: ifne +17 -> 107
    //   93: aload_2
    //   94: ldc_w 1267
    //   97: invokevirtual 1173	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   100: pop
    //   101: aload_2
    //   102: aload_3
    //   103: invokevirtual 1173	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   106: pop
    //   107: aload_1
    //   108: ldc_w 1269
    //   111: invokevirtual 594	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   114: astore_3
    //   115: aload_3
    //   116: invokestatic 290	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   119: ifne +17 -> 136
    //   122: aload_2
    //   123: ldc_w 1271
    //   126: invokevirtual 1173	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   129: pop
    //   130: aload_2
    //   131: aload_3
    //   132: invokevirtual 1173	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   135: pop
    //   136: aload_1
    //   137: ldc_w 1273
    //   140: invokevirtual 594	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   143: astore_1
    //   144: aload_1
    //   145: invokestatic 290	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   148: ifne +17 -> 165
    //   151: aload_2
    //   152: ldc_w 1275
    //   155: invokevirtual 1173	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   158: pop
    //   159: aload_2
    //   160: aload_1
    //   161: invokevirtual 1173	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   164: pop
    //   165: new 575	org/json/JSONObject
    //   168: dup
    //   169: invokespecial 667	org/json/JSONObject:<init>	()V
    //   172: astore_1
    //   173: new 575	org/json/JSONObject
    //   176: dup
    //   177: invokespecial 667	org/json/JSONObject:<init>	()V
    //   180: astore_3
    //   181: aload_3
    //   182: ldc_w 1165
    //   185: aload_2
    //   186: invokevirtual 1191	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   189: invokevirtual 672	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   192: pop
    //   193: aload_1
    //   194: ldc_w 904
    //   197: iconst_0
    //   198: invokevirtual 677	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   201: pop
    //   202: aload_1
    //   203: ldc_w 1101
    //   206: ldc_w 1277
    //   209: invokevirtual 672	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   212: pop
    //   213: aload_1
    //   214: ldc_w 1106
    //   217: aload_3
    //   218: invokevirtual 672	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   221: pop
    //   222: ldc 29
    //   224: iconst_2
    //   225: new 256	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   232: ldc_w 1279
    //   235: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_1
    //   239: invokevirtual 1092	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 273	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: new 155	android/content/Intent
    //   251: dup
    //   252: invokespecial 156	android/content/Intent:<init>	()V
    //   255: astore_2
    //   256: aload_2
    //   257: ldc_w 477
    //   260: aload_0
    //   261: getfield 483	com/tencent/mobileqq/activity/qwallet/SendHbActivity:callbackSn	Ljava/lang/String;
    //   264: invokevirtual 854	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   267: pop
    //   268: aload_2
    //   269: ldc_w 716
    //   272: iconst_5
    //   273: invokevirtual 859	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   276: pop
    //   277: aload_2
    //   278: ldc_w 906
    //   281: aload_1
    //   282: invokevirtual 687	org/json/JSONObject:toString	()Ljava/lang/String;
    //   285: invokevirtual 854	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   288: pop
    //   289: aload_0
    //   290: iconst_m1
    //   291: aload_2
    //   292: invokevirtual 910	com/tencent/mobileqq/activity/qwallet/SendHbActivity:setResult	(ILandroid/content/Intent;)V
    //   295: aload_0
    //   296: invokevirtual 322	com/tencent/mobileqq/activity/qwallet/SendHbActivity:finish	()V
    //   299: return
    //   300: astore_1
    //   301: aload_1
    //   302: invokevirtual 536	java/lang/Exception:printStackTrace	()V
    //   305: return
    //   306: astore_2
    //   307: goto -85 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	SendHbActivity
    //   0	310	1	paramJSONObject	JSONObject
    //   48	244	2	localObject1	Object
    //   306	1	2	localException	Exception
    //   56	162	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   31	78	300	java/lang/Exception
    //   78	107	300	java/lang/Exception
    //   107	136	300	java/lang/Exception
    //   136	165	300	java/lang/Exception
    //   165	173	300	java/lang/Exception
    //   222	299	300	java/lang/Exception
    //   173	222	306	java/lang/Exception
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onFaceHbPacket(String paramString)
  {
    this.mTotalAmount = paramString;
    try
    {
      Object localObject = getMapPacketExtra();
      ((Map)localObject).put("total_num", QWalletTools.a(this.mapParams, "total_num", "1"));
      ((Map)localObject).put("total_amount", yuan2Fen(paramString));
      ((Map)localObject).put("channel", String.valueOf(this.nChannel));
      ((Map)localObject).put("recv_uin", this.mRecvUin);
      ((Map)localObject).put("bus_type", this.mapParams.get("bus_type"));
      ((Map)localObject).put("recv_type", "1");
      ((Map)localObject).put("type", "1");
      paramString = getMapPacketJson();
      paramString.put("extra_data", new JSONObject((Map)localObject).toString());
      localObject = new Bundle();
      ((Bundle)localObject).putString("json", new JSONObject(paramString).toString());
      ((Bundle)localObject).putString("callbackSn", "0");
      ((Bundle)localObject).putLong("vacreport_key_seq", this.mReportSeq);
      PayBridgeActivity.tenpay(this, 5, (Bundle)localObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  protected void onFaceHbResult(JSONObject paramJSONObject)
  {
    QLog.i("SendHbActivity", 2, "onFaceHbResult bundle_data = " + paramJSONObject);
    Object localObject = paramJSONObject.optJSONObject("data");
    if (localObject == null) {}
    for (;;)
    {
      QLog.i("SendHbActivity", 2, "onFaceHbResult final data = " + paramJSONObject);
      localObject = new Intent();
      ((Intent)localObject).putExtra("callbackSn", this.callbackSn);
      ((Intent)localObject).putExtra("PayInvokerId", 5);
      JSONObject localJSONObject = new JSONObject();
      label250:
      for (;;)
      {
        try
        {
          StringBuilder localStringBuilder = new StringBuilder();
          int i = paramJSONObject.optInt("retcode", -1);
          paramJSONObject.printStackTrace();
        }
        catch (Exception paramJSONObject)
        {
          try
          {
            ((Intent)localObject).putExtra("result", i + "");
            ((Intent)localObject).putExtra("retmsg", paramJSONObject.optString("retmsg"));
            localJSONObject.put("send_listid", paramJSONObject.optString("send_listid"));
            if (i == 0) {
              addUploadData(this.mUin, getProcessType(), "bqredpacket.pay.expose", "", "");
            }
            QLog.i("SendHbActivity", 2, "onFaceHbResult back jdata = " + localJSONObject);
            ((Intent)localObject).putExtra("data", localJSONObject.toString());
            setResult(-1, (Intent)localObject);
            finish();
            return;
          }
          catch (Exception paramJSONObject)
          {
            break label250;
          }
          paramJSONObject = paramJSONObject;
          i = -1;
        }
      }
      paramJSONObject = (JSONObject)localObject;
    }
  }
  
  public Intent onGroupHbBack(int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    if (paramInt == 0) {
      localIntent.putExtra("data", paramString2);
    }
    for (;;)
    {
      localIntent.putExtra("result", paramInt);
      return localIntent;
      localIntent.putExtra("retmsg", paramString1);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    QLog.i("SendHbActivity", 2, "SendHbActivity onKeyDown keyCode = " + paramInt + " event = " + paramKeyEvent);
    if (paramInt == 4)
    {
      this.mIsBackKeyPressed = true;
      if (this.fragment != null)
      {
        if ((this.fragment instanceof SendHbMainFragment)) {
          ((SendHbMainFragment)this.fragment).a();
        }
        addHbUploadData("theme.pack.keyback");
        cancelCallBack();
        this.reportCode = -1;
        finish();
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onQrcodeHbResult(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    for (;;)
    {
      Object localObject;
      String str;
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("userId", this.mUin);
        ((JSONObject)localObject).put("viewTag", "qrcodeHb");
        ((JSONObject)localObject).put("comeForm", 2);
        JSONObject localJSONObject = new JSONObject();
        str = parseQrcodeHb(paramJSONObject);
        if (!TextUtils.isEmpty(str)) {
          localJSONObject.putOpt("qrData", str);
        }
        localJSONObject.putOpt("comeFrom", Integer.valueOf(this.mComeFrom));
        saveQrToken(paramJSONObject.optString("qr_token"));
        ((JSONObject)localObject).put("extra_data", localJSONObject.toString());
        paramJSONObject = new Bundle();
        paramJSONObject.putString("json", ((JSONObject)localObject).toString());
        paramJSONObject.putString("callbackSn", "0");
        paramJSONObject.putLong("vacreport_key_seq", this.mReportSeq);
        localObject = QWalletTools.a(this.mapParams, "from_plugin", "");
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          PayBridgeActivity.tenpay(this, 5, paramJSONObject);
          finish();
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
      if ("1".equals(localObject))
      {
        paramJSONObject = new Intent();
        paramJSONObject.putExtra("qrData", str);
        setResult(-1, paramJSONObject);
      }
    }
  }
  
  protected void onRewardHbResult(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("retmsg", paramJSONObject.toString());
    setResult(-1, localIntent);
    finish();
  }
  
  protected void onVisitHbResult(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    Intent localIntent = new Intent();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("send_name", this.mRecvNick);
      localJSONObject.putOpt("send_uin", this.mUin);
      localJSONObject.putOpt("send_listid", paramJSONObject.optString("send_listid"));
      localJSONObject.putOpt("amount", paramJSONObject.optString("amount"));
      localJSONObject.putOpt("feedsid", this.mapParams.get("feedsid"));
      localJSONObject.putOpt("channel", this.nChannel + "");
      paramJSONObject = new JSONObject();
    }
    catch (JSONException paramJSONObject)
    {
      try
      {
        paramJSONObject.putOpt("resultCode", Integer.valueOf(0));
        paramJSONObject.putOpt("retmsg", "");
        paramJSONObject.putOpt("data", localJSONObject.toString());
        localIntent.putExtra("result", paramJSONObject.toString());
        localIntent.putExtra("callbackSn", this.callbackSn);
        localIntent.putExtra("PayInvokerId", 5);
        setResult(-1, localIntent);
        finish();
        return;
        paramJSONObject = paramJSONObject;
        paramJSONObject.printStackTrace();
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public String parseQrcodeHb(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return "";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("wishing", paramJSONObject.optString("wishing"));
      localJSONObject.put("total_num", paramJSONObject.optString("total_num"));
      localJSONObject.put("recv_num", paramJSONObject.optString("recv_num"));
      localJSONObject.put("qr_data", paramJSONObject.optString("qr_data"));
      localJSONObject.put("send_listid", paramJSONObject.optString("send_listid"));
      paramJSONObject = new JSONArray();
      paramJSONObject.put(localJSONObject);
      paramJSONObject = paramJSONObject.toString();
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return "";
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void saveQrToken(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QWalletHelperImpl.saveQRTokenConfig(this, paramString, this.mUin);
  }
  
  protected void sendConfirmRequest(String paramString1, String paramString2)
  {
    int i = 1;
    QLog.i("SendHbActivity", 2, "sendConfirmRequest viewtag = " + paramString1 + " sp_data = " + paramString2);
    this.isConfirm = true;
    this.dialog = new QWalletPayProgressDialog(this);
    this.dialog.show();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("sp_data", paramString2);
        if (32768 == this.nChannel)
        {
          if (this.mRecvType.equals("1"))
          {
            localJSONObject.put("channel", i);
            paramString2 = new JSONObject();
            paramString2.put("userId", this.mUin);
            paramString2.put("viewTag", paramString1);
            paramString2.put("comeForm", 2);
            paramString2.put("appInfo", this.mAppInfo);
            paramString2.put("extra_data", localJSONObject.toString());
            PayBridgeActivity.tenpay(this, paramString2.toString(), 5, "0");
          }
        }
        else
        {
          localJSONObject.put("channel", String.valueOf(this.nChannel));
          continue;
        }
        i = 1024;
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
  }
  
  public void sendPackedHb()
  {
    this.intent.putExtra("hb_id", this.mListId);
    this.intent.putExtra("send_uin", this.mUin);
    this.intent.putExtra("hb_type", "1");
    this.intent.putExtra("forward_text", getString(2131697026));
    HashMap localHashMap = QWalletTools.a((String)this.mapParams.get("selector"));
    int i = QWalletTools.a(localHashMap, "type", 0);
    if (this.mIsTheme) {
      this.intent.putExtra("item", 1);
    }
    for (;;)
    {
      this.intent.putExtra("forward_type", 17);
      this.intent.putExtra("invoke_from", "qwallet");
      ForwardBaseOption.a(this, this.intent);
      return;
      if ((this.hb_from_type.equals("100")) && (i == 1))
      {
        this.intent.putExtra("item", getForwardItem());
        this.intent.putExtra("title", QWalletTools.a(localHashMap, "title", HardCodeUtil.a(2131713769)));
      }
    }
  }
  
  public void showCommonHbToast(CharSequence paramCharSequence)
  {
    showToast(paramCharSequence);
  }
  
  public void showDialog(String paramString1, String paramString2, String paramString3)
  {
    DialogUtil.a(this, 230, null, paramString1, paramString2, paramString3, new SendHbActivity.4(this), new SendHbActivity.5(this)).show();
  }
  
  public void showQzoneHbToast(CharSequence paramCharSequence)
  {
    showToast(paramCharSequence);
  }
  
  public void showThemeHbToast(CharSequence paramCharSequence)
  {
    showToast(paramCharSequence);
  }
  
  public void showToast(CharSequence paramCharSequence)
  {
    if ((!this.isActivityPause) && (!isFinishing())) {
      QQToast.a(this, paramCharSequence, 0).b(getTitleBarHeight(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.SendHbActivity
 * JD-Core Version:    0.7.0.1
 */