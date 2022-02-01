package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.api.handler.ITroopBatchInfohandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppHandler;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.troop.troopapps.api.TroopAppObserver;
import com.tencent.mobileqq.troop.troopcard.api.ITroopInfoActivityApi;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.troop.TroopFileProxyActivity;
import java.util.List;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.AppInfo;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.RspBody;

public class TroopLowCreditLevelNotifyActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public View[] a = new View[4];
  public boolean[] b = new boolean[4];
  protected Context c;
  protected ImageView d;
  protected TextView e;
  protected TextView f;
  protected TextView g;
  protected TextView h;
  protected LinearLayout i;
  protected Button j;
  protected String k = "";
  protected String l = "";
  protected TroopAppObserver m = new TroopLowCreditLevelNotifyActivity.2(this);
  protected TroopObserver n = new TroopLowCreditLevelNotifyActivity.3(this);
  protected QQProgressDialog o;
  
  private String a(String paramString, long paramLong)
  {
    String str = this.app.getCurrentAccountUin();
    Object localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).f(this.k);
      if (localObject != null)
      {
        if ((((TroopInfo)localObject).dwAdditionalFlag & 1L) == 1L)
        {
          localObject = "0";
          break label87;
        }
        if ((((TroopInfo)localObject).dwCmdUinUinFlag & 1L) == 1L)
        {
          localObject = "1";
          break label87;
        }
      }
    }
    localObject = "2";
    label87:
    paramString = paramString.replace("$GCODE$", this.k).replace("$CLIENTVER$", "android8.8.17").replace("$UIN$", str).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", (CharSequence)localObject).replace("$ENTERSOURCE$", "1");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("&credit=1");
    return ((StringBuilder)localObject).toString();
  }
  
  private void g()
  {
    this.c = this;
    this.d = ((ImageView)findViewById(2131447939));
    this.e = ((TextView)findViewById(2131448053));
    this.f = ((TextView)findViewById(2131448117));
    this.g = ((TextView)findViewById(2131437768));
    this.h = ((TextView)findViewById(2131438796));
    this.i = ((LinearLayout)findViewById(2131435969));
    this.j = ((Button)findViewById(2131446564));
    this.j.setOnClickListener(this);
    setTitle(2131895329);
    this.g.setText(2131895337);
    this.h.setText(2131895336);
    this.e.setText(this.l);
    this.f.setText(this.k);
    a(2131895381, 2131895285, this.b[0], 0);
    a(2131895377, 2131895285, this.b[1], 1);
    a(2131895378, 2131895283, this.b[2], 2);
    a(2131895380, 2131895284, this.b[3], 3);
    Bitmap localBitmap = this.app.getTroopFaceBitmap(this.k, (byte)3, false, false);
    if (localBitmap != null)
    {
      this.d.setImageBitmap(localBitmap);
    }
    else
    {
      localBitmap = ImageUtil.k();
      this.d.setImageBitmap(localBitmap);
    }
    if (d())
    {
      this.j.setEnabled(true);
      return;
    }
    this.j.setEnabled(false);
  }
  
  public oidb_0xe83.AppInfo a(long paramLong)
  {
    Object localObject1 = ((ITroopAppService)this.app.getRuntimeService(ITroopAppService.class, "all")).getTroopAppListData(this.k);
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        localObject2 = new oidb_0xe83.RspBody();
        ((oidb_0xe83.RspBody)localObject2).mergeFrom((byte[])localObject1);
        localObject1 = ((oidb_0xe83.RspBody)localObject2).infos.get();
        if (localObject1 != null)
        {
          if (((List)localObject1).size() != 0) {
            break label194;
          }
          return null;
          if (i1 < ((List)localObject1).size())
          {
            localObject2 = (oidb_0xe83.AppInfo)((List)localObject1).get(i1);
            long l1 = ((oidb_0xe83.AppInfo)localObject2).appid.get();
            if (l1 == paramLong) {
              return localObject2;
            }
            i1 += 1;
            continue;
          }
        }
        else
        {
          return null;
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getAppInfo: ");
          ((StringBuilder)localObject2).append(paramLong);
          ((StringBuilder)localObject2).append(", ");
          ((StringBuilder)localObject2).append(localException.toString());
          QLog.e("troop.credit.TroopLowCreditLevelNotifyActivity", 2, ((StringBuilder)localObject2).toString());
        }
      }
      return null;
      label194:
      int i1 = 0;
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    View localView = LayoutInflater.from(this.c).inflate(2131629575, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131436136);
    TextView localTextView2 = (TextView)localView.findViewById(2131436051);
    TextView localTextView3 = (TextView)localView.findViewById(2131436129);
    localTextView1.setText(paramInt1);
    localTextView2.setText(paramInt2);
    if (paramBoolean) {
      localTextView3.setVisibility(0);
    } else {
      localTextView3.setVisibility(8);
    }
    localView.setOnClickListener(this);
    this.a[paramInt3] = localView;
    this.i.addView(localView);
  }
  
  public void a(oidb_0xe83.AppInfo paramAppInfo)
  {
    Object localObject = new Intent(this, QQBrowserActivity.class);
    paramAppInfo = a(paramAppInfo.url.get(), paramAppInfo.appid.get());
    ((Intent)localObject).putExtra("url", paramAppInfo);
    ((Intent)localObject).putExtra("webStyle", "noBottomBar");
    ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
    startActivityForResult((Intent)localObject, 1001);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openTroopAnnounce:");
      ((StringBuilder)localObject).append(paramAppInfo);
      QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean a()
  {
    this.k = getIntent().getStringExtra("troopUin");
    if (TextUtils.isEmpty(this.k)) {
      return false;
    }
    Object localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).f(this.k);
      if (localObject != null)
      {
        this.l = ((TroopInfo)localObject).getTroopDisplayName();
        if (TextUtils.isEmpty(this.l)) {
          this.l = this.k;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sp_tp_credit_md_stat_");
      ((StringBuilder)localObject).append(this.app.getCurrentAccountUin());
      localObject = getSharedPreferences(((StringBuilder)localObject).toString(), 0).getString(this.k, "");
      try
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("initParams, modifyStatusJson:");
          localStringBuilder.append((String)localObject);
          QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, localStringBuilder.toString());
        }
        localObject = new JSONObject((String)localObject);
        this.b[0] = ((JSONObject)localObject).optBoolean("TROOP_INFO_ITEM");
        this.b[1] = ((JSONObject)localObject).optBoolean("TROOP_ANNOUNCE_ITEM");
        this.b[2] = ((JSONObject)localObject).optBoolean("TROOP_FILE_ITEM");
        this.b[3] = ((JSONObject)localObject).optBoolean("TROOP_ALBUM_ITEM");
        return true;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("initParams:");
          localStringBuilder.append(localException.toString());
          QLog.e("troop.credit.TroopLowCreditLevelNotifyActivity", 2, localStringBuilder.toString());
        }
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    Object localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).f(this.k);
      if (localObject != null)
      {
        if ((((TroopInfo)localObject).dwAdditionalFlag & 1L) == 1L) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if ((((TroopInfo)localObject).dwCmdUinUinFlag & 1L) == 1L)
        {
          i2 = 1;
          break label74;
        }
        i2 = 0;
        break label74;
      }
    }
    int i2 = 0;
    int i1 = 0;
    label74:
    if ((i1 == 0) && (i2 == 0))
    {
      localObject = DialogUtil.a(this.c, 230).setTitle(getString(2131917233)).setMessage(HardCodeUtil.a(2131912742));
      ((QQCustomDialog)localObject).setPositiveButton(2131895331, new TroopLowCreditLevelNotifyActivity.1(this));
      ((QQCustomDialog)localObject).setNegativeButton("", null);
      ((QQCustomDialog)localObject).setCancelable(false);
      ((QQCustomDialog)localObject).show();
      return;
    }
    localObject = (ITroopBatchInfohandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_BATCH_INFO_HANDLER);
    if (localObject != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTroopCreditInfo:");
        localStringBuilder.append(this.k);
        QLog.i("troop.credit.act", 2, localStringBuilder.toString());
      }
      ((ITroopBatchInfohandler)localObject).a(this.k, true);
      e();
    }
  }
  
  public void c()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sp_tp_credit_md_stat_");
      ((StringBuilder)localObject1).append(this.app.getCurrentAccountUin());
      localObject2 = getSharedPreferences(((StringBuilder)localObject1).toString(), 0).edit();
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("TROOP_INFO_ITEM", this.b[0]);
      ((JSONObject)localObject1).put("TROOP_ANNOUNCE_ITEM", this.b[1]);
      ((JSONObject)localObject1).put("TROOP_FILE_ITEM", this.b[2]);
      ((JSONObject)localObject1).put("TROOP_ALBUM_ITEM", this.b[3]);
      ((SharedPreferences.Editor)localObject2).putString(this.k, ((JSONObject)localObject1).toString());
      ((SharedPreferences.Editor)localObject2).commit();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("saveStatus:");
        ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
        QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, ((StringBuilder)localObject2).toString());
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("saveStatus:");
        ((StringBuilder)localObject2).append(localException.toString());
        QLog.e("troop.credit.TroopLowCreditLevelNotifyActivity", 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public boolean d()
  {
    int i1 = 0;
    for (;;)
    {
      boolean[] arrayOfBoolean = this.b;
      if (i1 >= arrayOfBoolean.length) {
        break;
      }
      if (arrayOfBoolean[i1] == 0) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i1 = -1;
    if (paramInt2 == -1)
    {
      switch (paramInt1)
      {
      default: 
        paramInt1 = i1;
        break;
      case 1003: 
        paramInt1 = 3;
        break;
      case 1002: 
        paramInt1 = 2;
        break;
      case 1001: 
        paramInt1 = 1;
        break;
      case 1000: 
        paramInt1 = 0;
      }
      if (paramInt1 >= 0)
      {
        this.a[paramInt1].findViewById(2131436129).setVisibility(0);
        this.b[paramInt1] = true;
      }
      if (d())
      {
        this.j.setEnabled(true);
        return;
      }
      this.j.setEnabled(false);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("doOnCreate:");
      paramBundle.append(this.k);
      paramBundle.append(",");
      paramBundle.append(this.l);
      QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, paramBundle.toString());
    }
    if (!a())
    {
      finish();
      return false;
    }
    super.setContentView(2131629576);
    g();
    addObserver(this.n);
    addObserver(this.m);
    b();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.n);
    removeObserver(this.m);
    c();
  }
  
  protected void e()
  {
    if (this.o == null) {
      this.o = new QQProgressDialog(this);
    }
    this.o.c(2131895335);
    this.o.b(getTitleBarHeight());
    this.o.show();
  }
  
  protected void f()
  {
    QQProgressDialog localQQProgressDialog = this.o;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.o.dismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    if (paramView.getId() == 2131446564)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("https://qqweb.qq.com/m/business/qunlevel/index.html?gc=");
      ((StringBuilder)localObject1).append(this.k);
      ((StringBuilder)localObject1).append("&from=0&_wv=1027");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      startActivity((Intent)localObject2);
    }
    else
    {
      localObject1 = this.a;
      if (paramView == localObject1[0])
      {
        localObject2 = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
        localObject1 = null;
        if (localObject2 != null) {
          localObject1 = ((TroopManager)localObject2).f(this.k);
        }
        if (localObject1 != null)
        {
          localObject2 = TroopInfoUIUtil.a(this.k, 28, ((TroopInfo)localObject1).troopLat, ((TroopInfo)localObject1).troopLon, 0, "");
          ((Bundle)localObject2).putInt("troop_type_ex", ((TroopInfo)localObject1).troopTypeExt);
          ((ITroopInfoActivityApi)QRoute.api(ITroopInfoActivityApi.class)).openTroopProfileForResult(this, (Bundle)localObject2, 1000);
        }
      }
      else if (paramView == localObject1[1])
      {
        localObject1 = a(1101236949L);
        if (localObject1 != null)
        {
          a((oidb_0xe83.AppInfo)localObject1);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "onClick, appInfo for announce is null, req from server");
          }
          e();
          localObject1 = (ITroopAppHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_APP_HANDLER);
          if (localObject1 != null)
          {
            localObject2 = this.k;
            int i1;
            if (StudyModeManager.h()) {
              i1 = 1;
            } else {
              i1 = -1;
            }
            ((ITroopAppHandler)localObject1).a((String)localObject2, false, 0, 1, i1);
          }
        }
      }
      else if (paramView == localObject1[2])
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra(TroopFileProxyActivity.b, this.k);
        ((Intent)localObject1).putExtra("param_from", 1000);
        TroopFileProxyActivity.a(this, (Intent)localObject1, 1002, this.app.getCurrentAccountUin());
      }
      else if (paramView == localObject1[3])
      {
        localObject1 = QZoneHelper.UserInfo.getInstance();
        ((QZoneHelper.UserInfo)localObject1).qzone_uin = this.app.getCurrentAccountUin();
        ((QZoneHelper.UserInfo)localObject1).nickname = this.app.getCurrentNickname();
        QZoneHelper.forwardToQunAlbumList(this, (QZoneHelper.UserInfo)localObject1, this.k, this.l, 3, 1003, "qunnotice");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopLowCreditLevelNotifyActivity
 * JD-Core Version:    0.7.0.1
 */