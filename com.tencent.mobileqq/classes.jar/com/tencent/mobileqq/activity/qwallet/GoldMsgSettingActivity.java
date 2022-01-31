package com.tencent.mobileqq.activity.qwallet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qwallet.plugin.QWalletPayBridge;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;
import wvz;
import wwa;
import wwb;
import wwc;
import wwd;
import wwe;
import wwf;
import wwi;
import wwj;

public class GoldMsgSettingActivity
  extends IphoneTitleBarActivity
{
  private static String jdField_a_of_type_JavaLangString;
  public static boolean b;
  private int jdField_a_of_type_Int = -1;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new wvz(this);
  private View jdField_a_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new wwc(this);
  GoldConfigObserver jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldConfigObserver = new wwe(this);
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public wwi a;
  public boolean a;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new wwa(this);
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  private View.OnClickListener c = new wwb(this);
  
  public GoldMsgSettingActivity()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131364728));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364729));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131364730);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (this.jdField_a_of_type_Wwi != null) {
      this.jdField_a_of_type_Wwi.a(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  private void a(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131362822: 
    default: 
      return;
    case 2131364729: 
      GoldMsgChatHelper.a().a(this, this.app.getCurrentAccountUin());
      return;
    }
    paramView = new Intent(this, QQBrowserActivity.class);
    paramView.putExtra("uin", this.app.getCurrentAccountUin());
    paramView.putExtra("url", "https://kf.qq.com/touch/scene_product.html?scene_id=kf4146");
    startActivity(paramView);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean1);
    if (paramBoolean2)
    {
      if (paramBoolean1) {}
      do
      {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("viewTag", "goldmsg_open");
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("skip_confirm", "0");
          localJSONObject.put("extra_data", ((JSONObject)localObject1).toString());
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("json", localJSONObject.toString());
          ((Bundle)localObject1).putString("callbackSn", "0");
          PayBridgeActivity.a(this, 5, (Bundle)localObject1);
          if (QLog.isColorLevel()) {
            QLog.i("GoldMsgSettingActivity", 2, "open GoldWithoutPwd.");
          }
          return;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          return;
        }
        Object localObject2 = new GoldMsgSettingActivity.MyResultRecevicer(this, 2, null);
        Bundle localBundle = new Bundle();
        Object localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("PayInvokerId", 22);
        ((Bundle)localObject1).putString("_qwallet_payparams_tag", "goldmsg_close");
        Parcel localParcel = Parcel.obtain();
        ((GoldMsgSettingActivity.MyResultRecevicer)localObject2).writeToParcel(localParcel, 0);
        localParcel.setDataPosition(0);
        localObject2 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
        localParcel.recycle();
        ((Bundle)localObject1).putParcelable("_qwallet_payresult_receiver", (Parcelable)localObject2);
        ((Bundle)localObject1).putBundle("_qwallet_payparams_data", localBundle);
        QWalletPayBridge.getWalletDataByService(this, this.app, (Bundle)localObject1);
      } while (!QLog.isColorLevel());
      QLog.i("GoldMsgSettingActivity", 2, "close GoldWithoutPwd.");
      return;
    }
    QWalletSetting.a(jdField_a_of_type_JavaLangString, "goldmsg_withoutpwd", paramBoolean1);
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      a(paramBoolean1, paramBoolean2);
      return;
    }
    runOnUiThread(new wwd(this, paramBoolean1, paramBoolean2));
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j = 1;
    boolean bool = true;
    Object localObject;
    if (paramInt1 == 5)
    {
      i = j;
      if (-1 == paramInt2) {
        localObject = paramIntent.getStringExtra("result");
      }
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        i = j;
        if (localObject != null)
        {
          i = ((JSONObject)localObject).getInt("resultCode");
          if (i != 0) {
            continue;
          }
        }
      }
      catch (JSONException localJSONException1)
      {
        i = 1;
      }
      try
      {
        b(bool, false);
        if (QLog.isColorLevel()) {
          QLog.i("GoldMsgSettingActivity", 2, "open GoldWithoutPwd open:" + bool);
        }
        i = 0;
        if (i != 0) {
          b(false, false);
        }
        super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
        return;
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          i = 0;
        }
      }
      bool = false;
      continue;
      localJSONException1.printStackTrace();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130969018);
    setTitle(2131432266);
    setLeftButton(2131432275, this.jdField_b_of_type_AndroidViewView$OnClickListener);
    setRightButton(2131432274, this.c);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362822);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(true);
    }
    jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    paramBundle = (TicketManager)this.app.getManager(2);
    if (paramBundle != null) {
      this.jdField_b_of_type_JavaLangString = paramBundle.getSkey(jdField_a_of_type_JavaLangString);
    }
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldConfigObserver);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    findViewById(2131364713);
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("goldmsg_setting_type", -1);
      if (this.jdField_a_of_type_Int != -1) {
        break label266;
      }
      finish();
    }
    for (;;)
    {
      paramBundle = new GoldMsgSettingActivity.MyResultRecevicer(this, 1, null);
      this.jdField_a_of_type_Boolean = QWalletSetting.a(jdField_a_of_type_JavaLangString, "goldmsg_withoutpwd", false);
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt("PayInvokerId", 22);
      ((Bundle)localObject).putString("_qwallet_payparams_tag", "goldmsg_is_nopass");
      ((Bundle)localObject).putParcelable("_qwallet_payresult_receiver", paramBundle);
      ((Bundle)localObject).putBundle("_qwallet_payparams_data", new Bundle());
      QWalletPayBridge.getWalletDataByService(this, this.app, (Bundle)localObject);
      a();
      return true;
      label266:
      paramBundle = findViewById(2131364714);
      localObject = findViewById(2131364723);
      String str;
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        finish();
        break;
      case 0: 
        str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("goldmsg_frienduin");
        this.jdField_a_of_type_Wwi = new wwf(this, this, this.jdField_a_of_type_AndroidContentIntent, str, jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int);
        paramBundle.setVisibility(0);
        ((View)localObject).setVisibility(8);
        break;
      case 1: 
      case 3000: 
        str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("goldmsg_frienduin");
        this.jdField_a_of_type_Wwi = new wwj(this, this, this.jdField_a_of_type_AndroidContentIntent, str, jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int);
        paramBundle.setVisibility(8);
        ((View)localObject).setVisibility(0);
      }
    }
  }
  
  protected void doOnDestroy()
  {
    jdField_b_of_type_Boolean = true;
    super.doOnDestroy();
    if (this.app != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldConfigObserver);
      this.app = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.GoldMsgSettingActivity
 * JD-Core Version:    0.7.0.1
 */