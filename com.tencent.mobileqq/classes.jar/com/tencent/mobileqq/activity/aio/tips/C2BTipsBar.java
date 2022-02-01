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
  private static final String a = HardCodeUtil.a(2131899513);
  private static final String b = HardCodeUtil.a(2131899514);
  private String c;
  private String d;
  private String e;
  private int f;
  private Set<String> g;
  private BaseActivity h;
  private TipsManager i;
  private String j;
  private int k;
  private Handler l;
  private QidianManager m;
  
  public C2BTipsBar(BaseActivity paramBaseActivity, TipsManager paramTipsManager)
  {
    this.h = paramBaseActivity;
    this.i = paramTipsManager;
    this.m = ((QidianManager)paramBaseActivity.app.getManager(QQManagerFactory.QIDIAN_MANAGER));
    paramBaseActivity = SharedPreferencesProxyManager.getInstance().getProxy("qidian_sp", 0);
    this.d = paramBaseActivity.getString("sp_c2b_tip_content", a);
    this.c = paramBaseActivity.getString("sp_c2b_tip_url", "https://m.qidian.qq.com/agreement/verified.html");
    this.e = paramBaseActivity.getString("sp_c2b_tip_highlight", b);
    this.f = paramBaseActivity.getInt("sp_c2b_tip_is_show", 1);
    this.g = paramBaseActivity.getStringSet("sp_c2b_tip_uins_shown", new HashSet());
    this.k = paramBaseActivity.getInt("sp_c2b_tip_hide_time", 60);
    this.l = new Handler(this);
  }
  
  public static boolean b(String paramString)
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
  
  public static void d()
  {
    SharedPreferences.Editor localEditor = SharedPreferencesProxyManager.getInstance().getProxy("qidian_sp", 0).edit();
    localEditor.remove("sp_c2b_tip_content");
    localEditor.remove("sp_c2b_tip_url");
    localEditor.remove("sp_c2b_tip_highlight");
    localEditor.remove("sp_c2b_tip_is_show");
    localEditor.remove("sp_c2b_tip_hide_time");
    localEditor.apply();
  }
  
  public int a()
  {
    return 59;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.h).inflate(2131624143, null);
    TextView localTextView = (TextView)paramVarArgs.findViewById(2131428116);
    SpannableString localSpannableString = new SpannableString(this.d);
    int n = 0;
    while (n < this.d.length())
    {
      n = this.d.indexOf(this.e, n);
      if (n < 0) {
        break;
      }
      localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#12b7f5")), n, this.e.length() + n, 33);
      n += this.e.length();
    }
    localTextView.setText(localSpannableString);
    paramVarArgs.setOnClickListener(this);
    paramVarArgs.findViewById(2131428115).setOnClickListener(this);
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(String paramString)
  {
    if (this.f != 0)
    {
      if (this.g.contains(paramString)) {
        return;
      }
      this.j = paramString;
      this.i.a(this, new Object[0]);
      this.l.removeMessages(1);
      this.l.sendEmptyMessageDelayed(1, this.k * 1000);
    }
  }
  
  public int b()
  {
    return 22;
  }
  
  public int[] c()
  {
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (this.i.a() == this)) {
      this.i.c();
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
    case 2131428115: 
      localObject = new HashSet(this.g);
      ((HashSet)localObject).add(this.j);
      SharedPreferences.Editor localEditor = SharedPreferencesProxyManager.getInstance().getProxy("qidian_sp", 0).edit();
      localEditor.putStringSet("sp_c2b_tip_uins_shown", (Set)localObject);
      localEditor.apply();
      this.g = ((Set)localObject);
      this.l.removeMessages(1);
      this.i.c();
      ReportController.b(this.h.app, "dc00899", "Qidian", this.j, "0X8009789", "CloseLawTip", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), this.m.h(this.j), "8.8.17", "");
      break;
    case 2131428114: 
      localObject = new Intent(this.h, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.c);
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      this.h.startActivity((Intent)localObject);
      ReportController.b(this.h.app, "dc00899", "Qidian", this.j, "0X8009788", "ClickLawTip", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), this.m.h(this.j), "8.8.17", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.C2BTipsBar
 * JD-Core Version:    0.7.0.1
 */