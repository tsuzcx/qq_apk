package com.tencent.mobileqq.activity.activateFriend;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsObserver;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.emoticonview.api.IAIOEmoticonPanelService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.PanelCallback;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class SendBirthdayWishesActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener, EmoticonCallback, XPanelContainer.PanelCallback
{
  ActivateFriendsManager a;
  ImageButton b;
  Button c;
  EditText d;
  XPanelContainer e;
  View f;
  TextView g;
  ActivateFriendGrid h;
  int i = 1;
  long[] j;
  long[] k;
  QQProgressDialog l;
  ActivateFriendsObserver m = new SendBirthdayWishesActivity.2(this);
  boolean n = false;
  private MqqHandler o = new MqqHandler(Looper.getMainLooper());
  private Runnable p = new SendBirthdayWishesActivity.3(this);
  
  private void a(int paramInt)
  {
    int i2 = this.i;
    if (i2 == 2)
    {
      int i1 = 0;
      if (paramInt == 0)
      {
        if (i2 == 1) {
          paramInt = 2131886406;
        } else {
          paramInt = 2131886404;
        }
        i1 = 2;
      }
      else if (paramInt == 1)
      {
        paramInt = 2131886425;
      }
      else if (paramInt == 2)
      {
        paramInt = 2131886418;
        i1 = 1;
      }
      else
      {
        paramInt = 0;
      }
      QQToast.makeText(this, i1, paramInt, 1).show(getTitleBarHeight());
    }
  }
  
  private void c()
  {
    setRightHighlightButton(2131887648, new SendBirthdayWishesActivity.1(this));
    int i1 = this.i;
    Object localObject1;
    if (i1 == 1)
    {
      if (this.j.length == 1) {
        i1 = 2131886423;
      } else {
        i1 = 2131886424;
      }
      localObject1 = getString(i1);
    }
    else if (i1 == 3)
    {
      localObject1 = "";
    }
    else
    {
      localObject1 = getString(2131886422);
    }
    setTitle((CharSequence)localObject1);
    enableRightHighlight(true);
    this.leftView.setVisibility(8);
    this.d = ((EditText)findViewById(2131435808));
    this.d.setMaxLines(8);
    this.d.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    this.e = ((XPanelContainer)findViewById(2131445137));
    this.e.setOnPanelChangeListener(this);
    this.e.a(this.d);
    try
    {
      localObject1 = getResources().getDrawable(2130839229);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        localException.printStackTrace();
      }
      localObject2 = getResources().getDrawable(2130852164);
    }
    this.e.setBackgroundDrawable((Drawable)localObject2);
    this.b = ((ImageButton)findViewById(2131432400));
    this.b.setOnClickListener(this);
    this.c = ((Button)findViewById(2131433920));
    this.c.setOnClickListener(this);
    this.f = findViewById(2131436180);
    this.f.setOnClickListener(this);
    Object localObject2 = new StateListDrawable();
    int i2 = 0;
    Object localObject3 = getResources().getDrawable(2130852118);
    ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject3);
    localObject3 = getResources().getDrawable(2130852117);
    ((StateListDrawable)localObject2).addState(new int[0], (Drawable)localObject3);
    this.c.setBackgroundDrawable((Drawable)localObject2);
    boolean bool = ((Boolean)SkinEngine.getInstances().getThemeConfig("aio_big_input_bar", Boolean.FALSE)).booleanValue();
    localObject2 = findViewById(2131435809);
    if (bool)
    {
      localObject3 = ((View)localObject2).findViewById(2131446058);
      ((View)localObject3).setBackgroundResource(2130839241);
      ((View)localObject3).setVisibility(0);
      ((View)localObject2).getBackground().setVisible(false, false);
    }
    else
    {
      ((View)localObject2).getBackground().setVisible(true, false);
      ((View)localObject2).findViewById(2131446058).setVisibility(8);
    }
    this.g = ((TextView)findViewById(2131445610));
    localObject2 = this.g;
    if (this.i == 1) {
      i1 = 2131886428;
    } else {
      i1 = 2131886427;
    }
    ((TextView)localObject2).setText(i1);
    this.g.setBackgroundColor(getResources().getColor(2131167963));
    this.h = ((ActivateFriendGrid)findViewById(2131433777));
    this.h.setCheckAbilityEnable(false);
    this.h.setSkinable(true);
    localObject2 = findViewById(2131433834);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.g.getText());
    long[] arrayOfLong = this.j;
    int i3 = arrayOfLong.length;
    i1 = i2;
    while (i1 < i3)
    {
      long l1 = arrayOfLong[i1];
      ((StringBuilder)localObject3).append(ContactUtils.d(this.app, String.valueOf(l1)));
      ((StringBuilder)localObject3).append(",");
      i1 += 1;
    }
    ((View)localObject2).setContentDescription(((StringBuilder)localObject3).toString());
  }
  
  private void d()
  {
    int i2 = this.i;
    int i1 = 0;
    if (i2 == 1) {
      localObject1 = String.format(getString(2131886419), new Object[] { getIntent().getStringExtra("key_roam_city") });
    }
    try
    {
      localObject1 = ActivateFriendsManager.a(this);
    }
    catch (Exception localException)
    {
      label51:
      break label51;
    }
    Object localObject1 = getString(2131886412);
    this.d.setText((CharSequence)localObject1);
    this.d.setSelection(((String)localObject1).length());
    this.d.addTextChangedListener(this);
    localObject1 = new ArrayList(this.j.length);
    for (;;)
    {
      Object localObject2 = this.j;
      if (i1 >= localObject2.length) {
        break;
      }
      localObject2 = new ActivateFriendItem(this.i, localObject2[i1]);
      if (this.i == 2) {
        ((ActivateFriendItem)localObject2).birthSendTime = this.k[i1];
      }
      ((ArrayList)localObject1).add(localObject2);
      i1 += 1;
    }
    this.h.setData(this.app, (ArrayList)localObject1);
  }
  
  void a()
  {
    if (this.l == null) {
      this.l = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.l.c(2131886170);
    this.l.show();
    this.l.setCancelable(false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 2)
    {
      ((IAIOEmoticonPanelService)QRoute.api(IAIOEmoticonPanelService.class)).setOpenStartTime(System.currentTimeMillis());
      StartupTracker.a(null, "AIO_EmoticonPanel_OpenDuration");
    }
    this.o.post(new SendBirthdayWishesActivity.4(this, paramInt2));
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (!this.n)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004E0B", "0X8004E0B", 0, 0, "", "", "", "");
      this.n = true;
    }
  }
  
  public View b(int paramInt)
  {
    if (paramInt == 2)
    {
      SystemEmoticonPanel localSystemEmoticonPanel = new SystemEmoticonPanel(this, this);
      View localView = localSystemEmoticonPanel.findViewById(2131444153);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.bottomMargin = AIOUtils.b(15.0F, getResources());
      localView.setLayoutParams(localLayoutParams);
      localSystemEmoticonPanel.setBackgroundResource(2130845510);
      return localSystemEmoticonPanel;
    }
    return null;
  }
  
  void b()
  {
    QQProgressDialog localQQProgressDialog = this.l;
    if (localQQProgressDialog != null) {
      localQQProgressDialog.dismiss();
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean c(int paramInt)
  {
    return false;
  }
  
  public void delete()
  {
    if (this.d.getSelectionStart() == 0) {
      return;
    }
    try
    {
      Editable localEditable = this.d.getEditableText();
      int i1 = this.d.getSelectionStart();
      int i2 = android.text.TextUtils.getOffsetBefore(this.d.getText(), i1);
      if (i1 != i2)
      {
        localEditable.delete(Math.min(i1, i2), Math.max(i1, i2));
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131627254);
    getWindow().setBackgroundDrawable(null);
    getWindow().setSoftInputMode(20);
    this.a = ((ActivateFriendsManager)this.app.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS));
    this.i = getIntent().getIntExtra("key_msg_type", this.i);
    this.j = getIntent().getLongArrayExtra("key_friend_list");
    this.k = getIntent().getLongArrayExtra("key_time_list");
    paramBundle = this.j;
    long[] arrayOfLong;
    if ((paramBundle != null) && (paramBundle.length != 0)) {
      if (this.i == 2)
      {
        arrayOfLong = this.k;
        if ((arrayOfLong == null) || (paramBundle.length != arrayOfLong.length)) {}
      }
      else
      {
        c();
        d();
        this.app.registObserver(this.m);
        return true;
      }
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("intent data is invaild, msgType = ");
      paramBundle.append(this.i);
      paramBundle.append(" | uin count = ");
      arrayOfLong = this.j;
      int i2 = -1;
      if (arrayOfLong != null) {
        i1 = arrayOfLong.length;
      } else {
        i1 = -1;
      }
      paramBundle.append(i1);
      paramBundle.append(" | time count = ");
      arrayOfLong = this.k;
      int i1 = i2;
      if (arrayOfLong != null) {
        i1 = arrayOfLong.length;
      }
      paramBundle.append(i1);
      QLog.d("ActivateFriend.SendActivity", 2, paramBundle.toString());
    }
    finish();
    return false;
  }
  
  protected void doOnDestroy()
  {
    this.app.unRegistObserver(this.m);
    this.h.b();
    super.doOnDestroy();
  }
  
  public void emoticonMall() {}
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130771995);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    if (this.e.getCurrentPanel() != 0)
    {
      this.e.b();
      return true;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004E0A", "0X8004E0A", 0, 0, "", "", "", "");
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.b)
    {
      if (this.e.getCurrentPanel() == 2) {
        this.e.a(1);
      } else {
        this.e.a(2);
      }
    }
    else if (paramView == this.c)
    {
      Object localObject1 = this.d.getEditableText().toString();
      if (((String)localObject1).length() != 0) {
        if (!NetworkUtil.isNetSupport(this))
        {
          QQToast.makeText(this, 2131892104, 0).show(getTitleBarHeight());
        }
        else
        {
          Object localObject2 = BusinessUtils.a((String)localObject1, 560, 20, null, new ArrayList());
          if ((QLog.isColorLevel()) && (((ArrayList)localObject2).size() > 1))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onclick | bytes = ");
            localStringBuilder.append(((String)localObject1).getBytes().length);
            localStringBuilder.append(" | partArray.size = ");
            localStringBuilder.append(((ArrayList)localObject2).size());
            QLog.d("ActivateFriend.SendActivity", 2, localStringBuilder.toString());
          }
          if (((ArrayList)localObject2).size() > 1)
          {
            QQToast.makeText(this, 2131916265, 0).show(getTitleBarHeight());
          }
          else
          {
            this.a.a(this.i, this.j, this.k, (String)localObject1);
            localObject1 = this.app;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(this.j.length);
            ((StringBuilder)localObject2).append("");
            ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8004E09", "0X8004E09", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
            ReportController.b(this.app, "dc00898", "", "", "0X8007AE9", "0X8007AE9", this.j.length, 0, "", "", "", "");
            a();
          }
        }
      }
    }
    else if (paramView == this.f)
    {
      if (this.e.getCurrentPanel() == 1) {
        this.e.b();
      }
      finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onHidePopup(EmoticonInfo paramEmoticonInfo) {}
  
  public boolean onLongClick(EmoticonInfo paramEmoticonInfo)
  {
    return true;
  }
  
  public void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void send() {}
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo instanceof SystemEmoticonInfo))
    {
      int i1 = this.d.getSelectionStart();
      int i2 = this.d.getSelectionEnd();
      if ((i1 >= 0) && (i2 >= 0) && (i2 >= i1)) {
        this.d.getEditableText().replace(i1, i2, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(((SystemEmoticonInfo)paramEmoticonInfo).code));
      }
    }
  }
  
  public void setting() {}
  
  public void v()
  {
    ((IAIOEmoticonPanelService)QRoute.api(IAIOEmoticonPanelService.class)).removeStickerMask(this.e.getCurrentPanelView());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.SendBirthdayWishesActivity
 * JD-Core Version:    0.7.0.1
 */