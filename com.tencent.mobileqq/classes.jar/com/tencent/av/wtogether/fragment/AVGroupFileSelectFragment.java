package com.tencent.av.wtogether.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.wtogether.callback.GroupFileClickListener;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.av.wtogether.util.WTBusinessForWebPlugin;
import com.tencent.av.wtogether.view.GroupFileSearchDialog;
import com.tencent.av.wtogether.view.GroupFileSearchDialog.ClickListener;
import com.tencent.av.wtogether.view.QBaseContentView;
import com.tencent.av.wtogether.view.QGroupAVFileListContentView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Stack;

public class AVGroupFileSelectFragment
  extends PublicBaseFragment
  implements View.OnClickListener, GroupFileClickListener, GroupFileSearchDialog.ClickListener
{
  private BaseActivity a;
  private QQAppInterface b;
  private View c;
  private long d;
  private String e;
  private int f = 0;
  private int g;
  private String h;
  private ChooseFileInfo i = new ChooseFileInfo(1);
  private TextView j;
  private TextView k;
  private RelativeLayout l;
  private RelativeLayout m;
  private QQBlurView n;
  private Button o;
  private QBaseContentView p;
  private Dialog q = null;
  
  private static Intent a(int paramInt1, int paramInt2, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_type", paramInt1);
    localIntent.putExtra("watch_together_uinType", paramInt2);
    localIntent.putExtra("watch_together_uin", paramString);
    return localIntent;
  }
  
  public static void a(Activity paramActivity, long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    QLog.d("AVGroupFileSelectFragment", 2, "startFragment");
    paramString2 = a(paramInt1, paramInt2, paramString2);
    paramString2.putExtra("public_fragment_window_feature", 1);
    paramString2.putExtra("key_troop_uin", paramLong);
    paramString2.putExtra("key_troop_name", paramString1);
    PublicFragmentActivity.Launcher.a(paramActivity, paramString2, PublicFragmentActivity.class, AVGroupFileSelectFragment.class, paramInt3);
  }
  
  private void a(ListView paramListView)
  {
    Object localObject = new RelativeLayout(this.a);
    ((RelativeLayout)localObject).addView(new View(this.a), new RelativeLayout.LayoutParams(-1, AIOUtils.b(50.0F, getResources())));
    paramListView.addFooterView((View)localObject);
    localObject = this.n;
    if (localObject != null)
    {
      ((QQBlurView)localObject).c();
      this.n = null;
    }
    this.n = ((QQBlurView)this.c.findViewById(2131449300));
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
  
  private void c()
  {
    if (this.q != null) {
      return;
    }
    b();
    ReportController.b(null, "dc00898", "", "", "0X800B626", "0X800B626", 0, 0, "", "", "", "");
  }
  
  private void d()
  {
    this.j = ((TextView)this.c.findViewById(2131429216));
    this.k = ((TextView)this.c.findViewById(2131436227));
    this.k.setText(this.e);
    this.l = ((RelativeLayout)this.c.findViewById(2131446823));
    this.m = ((RelativeLayout)this.c.findViewById(2131437285));
    this.o = ((Button)this.c.findViewById(2131450032));
  }
  
  private void e()
  {
    this.j.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.o.setOnClickListener(this);
  }
  
  private void f()
  {
    this.p = new QGroupAVFileListContentView(this.a, this, this.d);
    this.o.setEnabled(false);
    this.p.a();
    a(this.p.getScrollableView());
    this.m.addView(this.p);
  }
  
  public void a()
  {
    BaseActivity localBaseActivity = this.a;
    if (localBaseActivity != null)
    {
      localBaseActivity.superFinish();
      this.a.overridePendingTransition(2130772344, 2130772347);
      QLog.d("AVGroupFileSelectFragment", 2, "finish");
    }
  }
  
  public void a(ChooseFileInfo paramChooseFileInfo)
  {
    paramChooseFileInfo.a = this.f;
    paramChooseFileInfo.c = AVUtil.c(this.b.getCurrentAccountUin());
    paramChooseFileInfo.i = AVUtil.c(this.h);
    if (!AppNetConnInfo.isWifiConn())
    {
      PopupDialog.a(this.a, 230, null, getString(2131893744), 2131887648, 2131888568, new AVGroupFileSelectFragment.1(this, paramChooseFileInfo), new AVGroupFileSelectFragment.2(this));
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enter video ");
    ((StringBuilder)localObject).append(paramChooseFileInfo);
    QLog.d("AVGroupFileSelectFragment", 1, ((StringBuilder)localObject).toString());
    localObject = new Intent();
    ((Intent)localObject).putExtra("watch_together_uinType", this.g);
    ((Intent)localObject).putExtra("watch_together_uin", this.h);
    ((Intent)localObject).putExtra("ChooseFileInfo", paramChooseFileInfo);
    this.a.setResult(-1, (Intent)localObject);
    this.a.superFinish();
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity != null)
    {
      this.i.d = paramFileManagerEntity.TroopUin;
      this.i.e = paramFileManagerEntity.busId;
      localObject = this.i;
      ((ChooseFileInfo)localObject).f = "/";
      ((ChooseFileInfo)localObject).g = paramFileManagerEntity.Uuid;
      this.i.h = paramFileManagerEntity.strFileMd5;
      this.i.j = paramFileManagerEntity.fileSize;
      this.i.k = paramFileManagerEntity.fileName;
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
  
  protected void b()
  {
    this.p.d();
    this.q = new GroupFileSearchDialog(this.a, this.b, this.d, this);
    this.q.setTitle(HardCodeUtil.a(2131912606));
    this.q.setCanceledOnTouchOutside(true);
    int i1 = this.k.getHeight();
    float f1 = -i1;
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, f1);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, f1, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new AVGroupFileSelectFragment.3(this));
    localTranslateAnimation2.setAnimationListener(new AVGroupFileSelectFragment.4(this, i1));
    this.q.setOnDismissListener(new AVGroupFileSelectFragment.5(this, i1, localTranslateAnimation2));
    this.c.startAnimation(localTranslateAnimation1);
  }
  
  public void b(ChooseFileInfo paramChooseFileInfo)
  {
    a(paramChooseFileInfo);
    ReportController.b(null, "dc00898", "", "", "0X800B629", "0X800B629", 0, 0, "", "", "", "");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 9999) && (paramIntent != null))
    {
      this.a.setResult(-1, paramIntent);
      this.a.superFinish();
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131429216)
    {
      if (i1 != 2131446823)
      {
        if (i1 != 2131450032) {
          return;
        }
        a(this.i);
        ReportController.b(null, "dc00898", "", "", "0X800B628", "0X800B628", 0, 0, "", "", "", "");
        return;
      }
      c();
      return;
    }
    a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = getBaseActivity();
    WTBusinessForWebPlugin.b.push(this.a);
    paramBundle = this.a.getIntent();
    if (paramBundle == null)
    {
      QLog.e("AVGroupFileSelectFragment", 2, "intent is null");
      a();
      return;
    }
    this.d = paramBundle.getLongExtra("key_troop_uin", 0L);
    this.e = paramBundle.getStringExtra("key_troop_name");
    this.f = paramBundle.getIntExtra("key_from_type", 0);
    this.g = paramBundle.getIntExtra("watch_together_uinType", -1);
    this.h = paramBundle.getStringExtra("watch_together_uin");
    this.b = ((QQAppInterface)this.a.getAppInterface());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.c = paramLayoutInflater.inflate(2131625833, null);
    d();
    e();
    return this.c;
  }
  
  public void onDestroy()
  {
    QLog.i("AVGroupFileSelectFragment", 2, "onDestroy");
    this.p.b();
    this.m.removeView(this.p);
    WTBusinessForWebPlugin.b.pop();
    super.onDestroy();
  }
  
  public void onPause()
  {
    QLog.i("AVGroupFileSelectFragment", 2, "onPause");
    this.p.d();
    super.onPause();
  }
  
  public void onResume()
  {
    QLog.i("AVGroupFileSelectFragment", 2, "onResume");
    this.p.c();
    super.onResume();
  }
  
  public void onStart()
  {
    QLog.i("AVGroupFileSelectFragment", 2, "onStart");
    super.onStart();
  }
  
  public void onStop()
  {
    QLog.i("AVGroupFileSelectFragment", 2, "onStop");
    super.onStop();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.fragment.AVGroupFileSelectFragment
 * JD-Core Version:    0.7.0.1
 */