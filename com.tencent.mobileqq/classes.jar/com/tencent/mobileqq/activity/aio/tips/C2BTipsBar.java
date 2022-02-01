package com.tencent.mobileqq.activity.aio.tips;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class C2BTipsBar
  implements Handler.Callback, View.OnClickListener, TipsBarTask
{
  private static final String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131701490);
  private static final String jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131701491);
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QidianManager jdField_a_of_type_ComTencentQidianQidianManager;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private int jdField_b_of_type_Int;
  private String c;
  private String d;
  private String e;
  private String f;
  
  public C2BTipsBar(BaseActivity paramBaseActivity, TipsManager paramTipsManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_ComTencentQidianQidianManager = ((QidianManager)paramBaseActivity.app.getManager(QQManagerFactory.QIDIAN_MANAGER));
    paramBaseActivity = SharedPreferencesProxyManager.getInstance().getProxy("qidian_sp", 0);
    this.d = paramBaseActivity.getString("sp_c2b_tip_content", jdField_a_of_type_JavaLangString);
    this.c = paramBaseActivity.getString("sp_c2b_tip_url", "https://m.qidian.qq.com/agreement/verified.html");
    this.e = paramBaseActivity.getString("sp_c2b_tip_highlight", jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Int = paramBaseActivity.getInt("sp_c2b_tip_is_show", 1);
    this.jdField_a_of_type_JavaUtilSet = paramBaseActivity.getStringSet("sp_c2b_tip_uins_shown", new HashSet());
    this.jdField_b_of_type_Int = paramBaseActivity.getInt("sp_c2b_tip_hide_time", 60);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
  }
  
  public static void a()
  {
    SharedPreferences.Editor localEditor = SharedPreferencesProxyManager.getInstance().getProxy("qidian_sp", 0).edit();
    localEditor.remove("sp_c2b_tip_content");
    localEditor.remove("sp_c2b_tip_url");
    localEditor.remove("sp_c2b_tip_highlight");
    localEditor.remove("sp_c2b_tip_is_show");
    localEditor.remove("sp_c2b_tip_hide_time");
    localEditor.apply();
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (!"lawtip".equals(paramString.getString("type"))) {
        return false;
      }
      localObject = SharedPreferencesProxyManager.getInstance().getProxy("qidian_sp", 0).edit();
      ((SharedPreferences.Editor)localObject).putString("sp_c2b_tip_content", paramString.getString("content"));
      ((SharedPreferences.Editor)localObject).putString("sp_c2b_tip_url", paramString.getString("url"));
      ((SharedPreferences.Editor)localObject).putString("sp_c2b_tip_highlight", paramString.getString("highlight"));
      ((SharedPreferences.Editor)localObject).putInt("sp_c2b_tip_is_show", paramString.getInt("show"));
      ((SharedPreferences.Editor)localObject).putInt("sp_c2b_tip_hide_time", paramString.getInt("hideTime"));
      ((SharedPreferences.Editor)localObject).apply();
      return true;
    }
    catch (JSONException paramString)
    {
      Object localObject;
      paramString.printStackTrace();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parse config error:");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.d("C2BTipsBar", 2, ((StringBuilder)localObject).toString());
      }
    }
    return false;
  }
  
  public int a()
  {
    return 59;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131558585, null);
    TextView localTextView = (TextView)paramVarArgs.findViewById(2131362507);
    SpannableString localSpannableString = new SpannableString(this.d);
    int i = 0;
    while (i < this.d.length())
    {
      i = this.d.indexOf(this.e, i);
      if (i < 0) {
        break;
      }
      localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#12b7f5")), i, this.e.length() + i, 33);
      i += this.e.length();
    }
    localTextView.setText(localSpannableString);
    paramVarArgs.setOnClickListener(this);
    paramVarArgs.findViewById(2131362506).setOnClickListener(this);
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      if (this.jdField_a_of_type_JavaUtilSet.contains(paramString)) {
        return;
      }
      this.f = paramString;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0]);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, this.jdField_b_of_type_Int * 1000);
    }
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 22;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a() == this)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131362506: 
      localObject = new HashSet(this.jdField_a_of_type_JavaUtilSet);
      ((HashSet)localObject).add(this.f);
      SharedPreferences.Editor localEditor = SharedPreferencesProxyManager.getInstance().getProxy("qidian_sp", 0).edit();
      localEditor.putStringSet("sp_c2b_tip_uins_shown", (Set)localObject);
      localEditor.apply();
      this.jdField_a_of_type_JavaUtilSet = ((Set)localObject);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00899", "Qidian", this.f, "0X8009789", "CloseLawTip", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.f), "8.7.0", "");
      break;
    case 2131362505: 
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.c);
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00899", "Qidian", this.f, "0X8009788", "ClickLawTip", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.f), "8.7.0", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.C2BTipsBar
 * JD-Core Version:    0.7.0.1
 */