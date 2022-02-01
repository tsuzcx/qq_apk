package com.tencent.av.wtogether.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.wtogether.callback.C2CFileClickListener;
import com.tencent.av.wtogether.callback.GroupClickListener;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.av.wtogether.util.WTBusinessForWebPlugin;
import com.tencent.av.wtogether.view.QBaseContentView;
import com.tencent.av.wtogether.view.QGroupListContentView;
import com.tencent.av.wtogether.view.QRecentC2CAVFileListContentView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.search.activity.ContactSearchActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class AVRecentFileSelectFragment
  extends PublicBaseFragment
  implements View.OnClickListener, C2CFileClickListener, GroupClickListener
{
  private int a = 0;
  private int b;
  private String c;
  private ChooseFileInfo d = new ChooseFileInfo(0);
  private BaseActivity e;
  private QQAppInterface f;
  private View g;
  private RadioButton h;
  private RadioButton i;
  private TextView j;
  private LinearLayout k;
  private RelativeLayout l;
  private RelativeLayout m;
  private QQBlurView n;
  private Button o;
  private QBaseContentView p;
  private HashMap<Integer, QBaseContentView> q = new HashMap();
  private BroadcastReceiver r = new AVRecentFileSelectFragment.3(this);
  
  private static Intent a(int paramInt1, int paramInt2, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_type", paramInt1);
    localIntent.putExtra("watch_together_uinType", paramInt2);
    localIntent.putExtra("watch_together_uin", paramString);
    return localIntent;
  }
  
  private void a(int paramInt)
  {
    Object localObject = c(paramInt);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("show view with invalid type(");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(")");
      QLog.e("AVRecentFileSelectFragment", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (this.p != localObject)
    {
      this.o.setEnabled(false);
      QBaseContentView localQBaseContentView = this.p;
      if (localQBaseContentView != null)
      {
        localQBaseContentView.d();
        this.m.removeView(this.p);
      }
      this.p = ((QBaseContentView)localObject);
      this.p.c();
      a(this.p.getScrollableView());
      this.m.addView(this.p);
    }
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    paramString = a(paramInt1, paramInt2, paramString);
    paramString.putExtra("public_fragment_window_feature", 1);
    PublicFragmentActivity.Launcher.a(paramActivity, paramString, PublicFragmentActivity.class, AVRecentFileSelectFragment.class, paramInt3);
  }
  
  private void a(ListView paramListView)
  {
    Object localObject = new RelativeLayout(this.e);
    ((RelativeLayout)localObject).addView(new View(this.e), new RelativeLayout.LayoutParams(-1, AIOUtils.b(50.0F, getResources())));
    paramListView.addFooterView((View)localObject);
    localObject = this.n;
    if (localObject != null)
    {
      ((QQBlurView)localObject).c();
      this.n = null;
    }
    this.n = ((QQBlurView)this.g.findViewById(2131449300));
    this.n.setVisibility(0);
    this.n.a(paramListView);
    paramListView = this.n;
    paramListView.b(paramListView);
    this.n.c(-1);
    this.n.a(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
    paramListView = this.n;
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = true;
    } else {
      bool = false;
    }
    paramListView.setEnableBlur(bool);
    this.n.setDisableBlurDrawableRes(2130852377);
    this.n.b(0);
    this.n.a(8.0F);
    this.n.a(8);
    this.n.d();
    this.n.a();
  }
  
  private QBaseContentView b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return null;
      }
      localObject = new QGroupListContentView(this.e, this);
      ((QBaseContentView)localObject).a();
      return localObject;
    }
    Object localObject = new QRecentC2CAVFileListContentView(this.e, this);
    ((QBaseContentView)localObject).a();
    return localObject;
  }
  
  private void b()
  {
    Intent localIntent = new Intent(this.e, ContactSearchActivity.class);
    localIntent.putExtra("fromType", 2);
    localIntent.putExtra("contactSearchSource", 33751869);
    localIntent.putExtra("ContactCombineType", 2);
    localIntent.putExtra("key_from_type", this.a);
    localIntent.putExtra("watch_together_uinType", this.b);
    localIntent.putExtra("watch_together_uin", this.c);
    this.e.startActivityForResult(localIntent, 2020);
  }
  
  private QBaseContentView c(int paramInt)
  {
    QBaseContentView localQBaseContentView = (QBaseContentView)this.q.get(Integer.valueOf(paramInt));
    if (localQBaseContentView != null) {
      return localQBaseContentView;
    }
    localQBaseContentView = b(paramInt);
    if (localQBaseContentView != null)
    {
      localQBaseContentView.setFocusable(false);
      this.q.put(Integer.valueOf(paramInt), localQBaseContentView);
    }
    return localQBaseContentView;
  }
  
  private void c()
  {
    this.h = ((RadioButton)this.g.findViewById(2131444379));
    this.i = ((RadioButton)this.g.findViewById(2131434429));
    this.j = ((TextView)this.g.findViewById(2131445516));
    this.k = ((LinearLayout)this.g.findViewById(2131446824));
    this.l = ((RelativeLayout)this.g.findViewById(2131446823));
    this.m = ((RelativeLayout)this.g.findViewById(2131437285));
    this.o = ((Button)this.g.findViewById(2131450032));
    f();
  }
  
  private void d()
  {
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.o.setOnClickListener(this);
  }
  
  private void e()
  {
    if (FontSettingManager.getFontLevel() > 17.0F)
    {
      float f1 = getResources().getDisplayMetrics().density;
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(55.0F * f1), (int)(f1 * 30.0F));
      this.h.setLayoutParams(localLayoutParams);
      this.h.setTextSize(14.0F);
      this.i.setLayoutParams(localLayoutParams);
      this.i.setTextSize(14.0F);
    }
  }
  
  private void f()
  {
    boolean bool = QQTheme.isNowSimpleUI();
    ColorStateList localColorStateList;
    if (bool) {
      localColorStateList = getResources().getColorStateList(2131168193);
    } else {
      localColorStateList = getResources().getColorStateList(2131168206);
    }
    this.h.setTextColor(localColorStateList);
    this.i.setTextColor(localColorStateList);
    if (bool)
    {
      this.h.setPadding(0, 0, 0, 0);
      this.h.setGravity(17);
      this.i.setPadding(0, 0, 0, 0);
      this.i.setGravity(17);
      return;
    }
    this.h.setPadding(0, 0, ViewUtils.dpToPx(10.0F), 0);
    this.h.setGravity(21);
    this.i.setPadding(ViewUtils.dpToPx(10.0F), 0, 0, 0);
    this.i.setGravity(19);
  }
  
  public void a()
  {
    BaseActivity localBaseActivity = this.e;
    if (localBaseActivity != null)
    {
      localBaseActivity.superFinish();
      QLog.d("AVRecentFileSelectFragment", 2, "finish");
    }
  }
  
  public void a(ChooseFileInfo paramChooseFileInfo)
  {
    paramChooseFileInfo.a = this.a;
    if (!AppNetConnInfo.isWifiConn())
    {
      PopupDialog.a(this.e, 230, null, getString(2131893744), 2131887648, 2131888568, new AVRecentFileSelectFragment.1(this, paramChooseFileInfo), new AVRecentFileSelectFragment.2(this));
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enter video[");
    ((StringBuilder)localObject).append(paramChooseFileInfo);
    ((StringBuilder)localObject).append("]");
    QLog.d("AVRecentFileSelectFragment", 1, ((StringBuilder)localObject).toString());
    localObject = new Intent();
    ((Intent)localObject).putExtra("watch_together_uinType", this.b);
    ((Intent)localObject).putExtra("watch_together_uin", this.c);
    ((Intent)localObject).putExtra("ChooseFileInfo", paramChooseFileInfo);
    this.e.setResult(-1, (Intent)localObject);
    this.e.superFinish();
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity != null)
    {
      this.d.c = AVUtil.c(this.f.getCurrentAccountUin());
      localObject = this.d;
      ((ChooseFileInfo)localObject).d = 0L;
      ((ChooseFileInfo)localObject).e = 3;
      ((ChooseFileInfo)localObject).f = "/";
      ((ChooseFileInfo)localObject).g = paramFileManagerEntity.Uuid;
      this.d.h = paramFileManagerEntity.strFileMd5;
      this.d.i = AVUtil.c(this.c);
      this.d.j = paramFileManagerEntity.fileSize;
      this.d.k = paramFileManagerEntity.fileName;
    }
    Object localObject = this.o;
    boolean bool;
    if (paramFileManagerEntity != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((Button)localObject).setEnabled(bool);
  }
  
  public void a(String paramString1, String paramString2)
  {
    AVGroupFileSelectFragment.a(this.e, AVUtil.c(paramString1), paramString2, this.a, this.b, this.c, 2020);
  }
  
  public void a(boolean paramBoolean)
  {
    this.o.setEnabled(paramBoolean);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 2020) && (paramIntent != null))
    {
      this.e.setResult(-1, paramIntent);
      this.e.superFinish();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131450032: 
      a(this.d);
      ReportController.b(null, "dc00898", "", "", "0X800B627", "0X800B627", 0, 0, "", "", "", "");
      return;
    case 2131446823: 
      b();
      return;
    case 2131445516: 
      a();
      return;
    case 2131444379: 
      this.k.setVisibility(8);
      a(1);
      return;
    }
    this.k.setVisibility(0);
    a(2);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.e = getBaseActivity();
    WTBusinessForWebPlugin.b.push(this.e);
    this.e.registerReceiver(this.r, new IntentFilter("tencent.av.v2q.StopVideoChat"));
    paramBundle = this.e.getIntent();
    if (paramBundle == null)
    {
      QLog.e("AVRecentFileSelectFragment", 1, "intent is null");
      a();
      return;
    }
    this.a = paramBundle.getIntExtra("key_from_type", 0);
    this.b = paramBundle.getIntExtra("watch_together_uinType", -1);
    this.c = paramBundle.getStringExtra("watch_together_uin");
    this.f = ((QQAppInterface)this.e.getAppInterface());
    int i1 = this.a;
    if (i1 != 0) {
      ReportController.b(null, "dc00898", "", "", "0X800B622", "0X800B622", i1, 0, "", "", "", "");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.g = paramLayoutInflater.inflate(2131625832, null);
    c();
    d();
    e();
    return this.g;
  }
  
  public void onDestroy()
  {
    QLog.i("AVRecentFileSelectFragment", 2, "onDestroy");
    Iterator localIterator = this.q.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i1 = ((Integer)localIterator.next()).intValue();
      QBaseContentView localQBaseContentView = (QBaseContentView)this.q.get(Integer.valueOf(i1));
      if (localQBaseContentView != null) {
        localQBaseContentView.b();
      }
    }
    this.q.clear();
    this.m.removeView(this.p);
    WTBusinessForWebPlugin.b.pop();
    this.e.unregisterReceiver(this.r);
    super.onDestroy();
  }
  
  public void onPause()
  {
    QLog.i("AVRecentFileSelectFragment", 2, "onPause");
    super.onPause();
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    f();
  }
  
  public void onResume()
  {
    QLog.i("AVRecentFileSelectFragment", 2, "onResume");
    super.onResume();
  }
  
  public void onStart()
  {
    QLog.i("AVRecentFileSelectFragment", 2, "onStart");
    super.onStart();
  }
  
  public void onStop()
  {
    QLog.i("AVRecentFileSelectFragment", 2, "onStop");
    super.onStop();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.h.performClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.fragment.AVRecentFileSelectFragment
 * JD-Core Version:    0.7.0.1
 */