package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.freshnews.BlockableEditTextView;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.hotchat.app.HotChatHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class HotChatAnnounceActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  BlockableEditTextView a;
  BlockableEditTextView b;
  View c;
  View d;
  TextView e;
  QQProgressDialog f;
  String g;
  boolean h;
  String i;
  String j;
  String k;
  String l;
  HotChatObserver m = new HotChatAnnounceActivity.1(this);
  
  private void a()
  {
    try
    {
      if ((this.f == null) && (!isFinishing()))
      {
        this.f = new QQProgressDialog(this, getTitleBarHeight());
        this.f.c(2131892360);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    QQProgressDialog localQQProgressDialog = this.f;
    if ((localQQProgressDialog != null) && (!localQQProgressDialog.isShowing())) {
      this.f.show();
    }
  }
  
  private void b()
  {
    try
    {
      if ((this.f != null) && (this.f.isShowing()))
      {
        this.f.dismiss();
        this.f.cancel();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    this.f = null;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131627468);
    setTitle(HardCodeUtil.a(2131903510));
    setRightButton(2131891171, this);
    setLeftViewName(2131887440);
    this.a = ((BlockableEditTextView)super.findViewById(2131428377));
    this.a.addTextChangedListener(new HotChatAnnounceActivity.2(this));
    this.b = ((BlockableEditTextView)super.findViewById(2131437260));
    this.b.addTextChangedListener(new HotChatAnnounceActivity.3(this));
    this.d = super.findViewById(2131449953);
    this.d.setOnClickListener(this);
    this.e = ((TextView)super.findViewById(2131437141));
    this.c = super.findViewById(2131437271);
    paramBundle = getIntent();
    this.g = paramBundle.getStringExtra("TROOPUIN");
    this.h = paramBundle.getBooleanExtra("CANADDLINK", false);
    this.i = paramBundle.getStringExtra("ANNOUCE");
    this.j = paramBundle.getStringExtra("LINK");
    if (this.h) {
      this.c.setVisibility(0);
    } else {
      this.c.setVisibility(8);
    }
    this.a.setText(this.i);
    this.b.setText(this.j);
    paramBundle = this.j;
    if ((paramBundle != null) && (paramBundle.trim().length() > 0)) {
      this.d.setEnabled(true);
    }
    this.app.addObserver(this.m);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.m != null) {
      this.app.removeObserver(this.m);
    }
  }
  
  public void finish()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    View localView = getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView == this.rightViewText)
    {
      if (!NetworkUtil.isNetSupport(this))
      {
        QQToast.makeText(this, 0, 2131889169, 0).show(getTitleBarHeight());
        return;
      }
      String str = this.a.getText().toString();
      localObject = this.b.getText().toString();
      if (TextUtils.isEmpty(str))
      {
        QQToast.makeText(this, 0, HardCodeUtil.a(2131903515), 0).show(getTitleBarHeight());
        return;
      }
      if (str.getBytes().length / 3 > 40)
      {
        QQToast.makeText(this, 0, HardCodeUtil.a(2131903509), 0).show(getTitleBarHeight());
        return;
      }
      if (localObject != null)
      {
        paramView = (View)localObject;
        if (!TextUtils.isEmpty(((String)localObject).trim())) {}
      }
      else
      {
        paramView = null;
      }
      if ((!TextUtils.isEmpty(paramView)) && (paramView.length() > 1024))
      {
        QQToast.makeText(this, 0, HardCodeUtil.a(2131903517), 0).show(getTitleBarHeight());
        return;
      }
      localObject = (HotChatHandler)this.app.getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName());
      HotChatInfo localHotChatInfo = ((HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).c(this.g);
      a();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onClick.contnet=");
        localStringBuilder.append(str);
        localStringBuilder.append(",link=");
        localStringBuilder.append(paramView);
        QLog.i("HotChatAnnounceActivity", 2, localStringBuilder.toString());
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8005D54", "0X8005D54", 0, 0, "", "", "", "");
      boolean bool;
      if (localHotChatInfo.userCreate == 1) {
        bool = ((HotChatHandler)localObject).setUserCreateHotChatAnnounce(localHotChatInfo.troopUin, str);
      } else {
        bool = ((HotChatHandler)localObject).setHotChatAnnounce(localHotChatInfo.uuid.getBytes(), str, paramView);
      }
      this.k = str;
      this.l = paramView;
      if (!bool)
      {
        b();
        QQToast.makeText(this, 0, HardCodeUtil.a(2131903513), 0).show(getTitleBarHeight());
      }
    }
    else if (paramView == this.d)
    {
      localObject = this.b.getText().toString();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramView = (View)localObject;
        if (!((String)localObject).startsWith("http"))
        {
          paramView = new StringBuilder();
          paramView.append("http://");
          paramView.append((String)localObject);
          paramView = paramView.toString();
        }
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView);
        startActivity((Intent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.activity.HotChatAnnounceActivity
 * JD-Core Version:    0.7.0.1
 */