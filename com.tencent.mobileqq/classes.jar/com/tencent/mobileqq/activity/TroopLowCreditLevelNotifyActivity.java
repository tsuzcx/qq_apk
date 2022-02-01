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
  protected Context a;
  protected Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  protected TroopObserver a;
  protected TroopAppObserver a;
  protected QQProgressDialog a;
  protected String a;
  public View[] a;
  public boolean[] a;
  protected TextView b;
  protected String b;
  protected TextView c;
  protected TextView d;
  
  public TroopLowCreditLevelNotifyActivity()
  {
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[4];
    this.jdField_a_of_type_ArrayOfBoolean = new boolean[4];
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiTroopAppObserver = new TroopLowCreditLevelNotifyActivity.2(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new TroopLowCreditLevelNotifyActivity.3(this);
  }
  
  private String a(String paramString, long paramLong)
  {
    String str = this.app.getCurrentAccountUin();
    Object localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_JavaLangString);
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
    paramString = paramString.replace("$GCODE$", this.jdField_a_of_type_JavaLangString).replace("$CLIENTVER$", "android8.7.0").replace("$UIN$", str).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", (CharSequence)localObject).replace("$ENTERSOURCE$", "1");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("&credit=1");
    return ((StringBuilder)localObject).toString();
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379202));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379316));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379377));
    this.c = ((TextView)findViewById(2131370496));
    this.d = ((TextView)findViewById(2131371429));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369009));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131378064));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    setTitle(2131697556);
    this.c.setText(2131697564);
    this.d.setText(2131697563);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    a(2131697608, 2131697512, this.jdField_a_of_type_ArrayOfBoolean[0], 0);
    a(2131697604, 2131697512, this.jdField_a_of_type_ArrayOfBoolean[1], 1);
    a(2131697605, 2131697510, this.jdField_a_of_type_ArrayOfBoolean[2], 2);
    a(2131697607, 2131697511, this.jdField_a_of_type_ArrayOfBoolean[3], 3);
    Bitmap localBitmap = this.app.getTroopFaceBitmap(this.jdField_a_of_type_JavaLangString, (byte)3, false, false);
    if (localBitmap != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
    else
    {
      localBitmap = ImageUtil.f();
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    }
    if (b())
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public oidb_0xe83.AppInfo a(long paramLong)
  {
    Object localObject1 = ((ITroopAppService)this.app.getRuntimeService(ITroopAppService.class, "all")).getTroopAppListData(this.jdField_a_of_type_JavaLangString);
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
          if (i < ((List)localObject1).size())
          {
            localObject2 = (oidb_0xe83.AppInfo)((List)localObject1).get(i);
            long l = ((oidb_0xe83.AppInfo)localObject2).appid.get();
            if (l == paramLong) {
              return localObject2;
            }
            i += 1;
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
      int i = 0;
    }
  }
  
  public void a()
  {
    Object localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        if ((((TroopInfo)localObject).dwAdditionalFlag & 1L) == 1L) {
          i = 1;
        } else {
          i = 0;
        }
        if ((((TroopInfo)localObject).dwCmdUinUinFlag & 1L) == 1L)
        {
          j = 1;
          break label74;
        }
        j = 0;
        break label74;
      }
    }
    int j = 0;
    int i = 0;
    label74:
    if ((i == 0) && (j == 0))
    {
      localObject = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(getString(2131719632)).setMessage(HardCodeUtil.a(2131715260));
      ((QQCustomDialog)localObject).setPositiveButton(2131697558, new TroopLowCreditLevelNotifyActivity.1(this));
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
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        QLog.i("troop.credit.act", 2, localStringBuilder.toString());
      }
      ((ITroopBatchInfohandler)localObject).a(this.jdField_a_of_type_JavaLangString, true);
      c();
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562967, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131369163);
    TextView localTextView2 = (TextView)localView.findViewById(2131369087);
    TextView localTextView3 = (TextView)localView.findViewById(2131369156);
    localTextView1.setText(paramInt1);
    localTextView2.setText(paramInt2);
    if (paramBoolean) {
      localTextView3.setVisibility(0);
    } else {
      localTextView3.setVisibility(8);
    }
    localView.setOnClickListener(this);
    this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt3] = localView;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
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
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("troopUin");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    Object localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        this.jdField_b_of_type_JavaLangString = ((TroopInfo)localObject).getTroopDisplayName();
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sp_tp_credit_md_stat_");
      ((StringBuilder)localObject).append(this.app.getCurrentAccountUin());
      localObject = getSharedPreferences(((StringBuilder)localObject).toString(), 0).getString(this.jdField_a_of_type_JavaLangString, "");
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
        this.jdField_a_of_type_ArrayOfBoolean[0] = ((JSONObject)localObject).optBoolean("TROOP_INFO_ITEM");
        this.jdField_a_of_type_ArrayOfBoolean[1] = ((JSONObject)localObject).optBoolean("TROOP_ANNOUNCE_ITEM");
        this.jdField_a_of_type_ArrayOfBoolean[2] = ((JSONObject)localObject).optBoolean("TROOP_FILE_ITEM");
        this.jdField_a_of_type_ArrayOfBoolean[3] = ((JSONObject)localObject).optBoolean("TROOP_ALBUM_ITEM");
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
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sp_tp_credit_md_stat_");
      ((StringBuilder)localObject1).append(this.app.getCurrentAccountUin());
      localObject2 = getSharedPreferences(((StringBuilder)localObject1).toString(), 0).edit();
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("TROOP_INFO_ITEM", this.jdField_a_of_type_ArrayOfBoolean[0]);
      ((JSONObject)localObject1).put("TROOP_ANNOUNCE_ITEM", this.jdField_a_of_type_ArrayOfBoolean[1]);
      ((JSONObject)localObject1).put("TROOP_FILE_ITEM", this.jdField_a_of_type_ArrayOfBoolean[2]);
      ((JSONObject)localObject1).put("TROOP_ALBUM_ITEM", this.jdField_a_of_type_ArrayOfBoolean[3]);
      ((SharedPreferences.Editor)localObject2).putString(this.jdField_a_of_type_JavaLangString, ((JSONObject)localObject1).toString());
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
  
  public boolean b()
  {
    int i = 0;
    for (;;)
    {
      boolean[] arrayOfBoolean = this.jdField_a_of_type_ArrayOfBoolean;
      if (i >= arrayOfBoolean.length) {
        break;
      }
      if (arrayOfBoolean[i] == 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131697562);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  protected void d()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = -1;
    if (paramInt2 == -1)
    {
      switch (paramInt1)
      {
      default: 
        paramInt1 = i;
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
        this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt1].findViewById(2131369156).setVisibility(0);
        this.jdField_a_of_type_ArrayOfBoolean[paramInt1] = true;
      }
      if (b())
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("doOnCreate:");
      paramBundle.append(this.jdField_a_of_type_JavaLangString);
      paramBundle.append(",");
      paramBundle.append(this.jdField_b_of_type_JavaLangString);
      QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, paramBundle.toString());
    }
    if (!a())
    {
      finish();
      return false;
    }
    super.setContentView(2131562968);
    e();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiTroopAppObserver);
    a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiTroopAppObserver);
    b();
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    if (paramView.getId() == 2131378064)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("https://qqweb.qq.com/m/business/qunlevel/index.html?gc=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("&from=0&_wv=1027");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      startActivity((Intent)localObject2);
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView;
      if (paramView == localObject1[0])
      {
        localObject2 = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
        localObject1 = null;
        if (localObject2 != null) {
          localObject1 = ((TroopManager)localObject2).b(this.jdField_a_of_type_JavaLangString);
        }
        if (localObject1 != null)
        {
          localObject2 = TroopInfoUIUtil.a(this.jdField_a_of_type_JavaLangString, 28, ((TroopInfo)localObject1).troopLat, ((TroopInfo)localObject1).troopLon, 0, "");
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
          c();
          localObject1 = (ITroopAppHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_APP_HANDLER);
          if (localObject1 != null)
          {
            localObject2 = this.jdField_a_of_type_JavaLangString;
            int i;
            if (StudyModeManager.a()) {
              i = 1;
            } else {
              i = -1;
            }
            ((ITroopAppHandler)localObject1).a((String)localObject2, false, 0, 1, i);
          }
        }
      }
      else if (paramView == localObject1[2])
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("param_from", 1000);
        TroopFileProxyActivity.a(this, (Intent)localObject1, 1002, this.app.getCurrentAccountUin());
      }
      else if (paramView == localObject1[3])
      {
        localObject1 = QZoneHelper.UserInfo.getInstance();
        ((QZoneHelper.UserInfo)localObject1).qzone_uin = this.app.getCurrentAccountUin();
        ((QZoneHelper.UserInfo)localObject1).nickname = this.app.getCurrentNickname();
        QZoneHelper.forwardToQunAlbumList(this, (QZoneHelper.UserInfo)localObject1, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 3, 1003, "qunnotice");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopLowCreditLevelNotifyActivity
 * JD-Core Version:    0.7.0.1
 */