package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountServiceImpl;
import com.tencent.mobileqq.utils.api.IContactUtils;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

@RoutePage(desc="小号助手绑定Activity", path="/base/subAccount/bind")
public class SubAccountBindActivity
  extends SubAccountBaseActivity
{
  public static final int ERROR_ACCOUNT_BLACK = 1233;
  public static final int ERROR_ACCOUNT_FREEDOM = 1232;
  public static final int ERROR_ACCOUNT_LH_EXPIRED = 1241;
  public static final int ERROR_ACCOUNT_LOCK = 1242;
  public static final int ERROR_ACCOUNT_LOGIN_FAILED = 1240;
  public static final int ERROR_ACCOUNT_NOT_EXIST = 1218;
  public static final int SUBACCOUNTBINDACTIVITY_CLOSE_DIALOG = 1990;
  public static final int SUBACCOUNTBINDACTIVITY_FINISH = 1981;
  private static final String TAG = "Q.subaccount.SubAccountBindActivity";
  private List<SimpleAccount> accountList;
  private LinearLayout accountListLinearLayout;
  AvatarObserver avatarObserver = new SubAccountBindActivity.6(this);
  BusinessObserver fob = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getFriendListObserver(new SubAccountBindActivity.5(this));
  private boolean isGetBindFromThis = false;
  MqqHandler mHandler = new SubAccountBindActivity.1(this);
  View.OnClickListener onAddAccountClick = new SubAccountBindActivity.4(this);
  View.OnClickListener onSelectAccountClick = new SubAccountBindActivity.3(this);
  SubAccountBindObserver sabo = new SubAccountBindActivity.2(this);
  
  private SimpleAccount findSimpleAccountByUin(String paramString)
  {
    Iterator localIterator = this.accountList.iterator();
    while (localIterator.hasNext())
    {
      SimpleAccount localSimpleAccount = (SimpleAccount)localIterator.next();
      if (paramString.equals(localSimpleAccount.getUin())) {
        return localSimpleAccount;
      }
    }
    return null;
  }
  
  private void initAccountList()
  {
    Object localObject = this.accountList;
    if (localObject == null) {
      this.accountList = new ArrayList();
    } else {
      ((List)localObject).clear();
    }
    localObject = getAppRuntime().getApplication().getAllAccounts();
    if (localObject != null)
    {
      this.accountList.addAll((Collection)localObject);
      localObject = findSimpleAccountByUin(this.app.getAccount());
      this.accountList.remove(localObject);
      localObject = ((SubAccountServiceImpl)this.app.getRuntimeService(ISubAccountService.class, null)).getAllSubUin();
      if (localObject != null)
      {
        int j = ((List)localObject).size();
        int i = 0;
        while (i < j)
        {
          SimpleAccount localSimpleAccount = findSimpleAccountByUin((String)((List)localObject).get(i));
          this.accountList.remove(localSimpleAccount);
          i += 1;
        }
      }
    }
    localObject = this.accountList;
    if (localObject != null) {
      ((List)localObject).add(null);
    }
  }
  
  private void updateAccountListView()
  {
    Object localObject1 = this.accountListLinearLayout;
    if (localObject1 != null)
    {
      if (((LinearLayout)localObject1).getChildCount() <= 0) {
        return;
      }
      int j = this.accountListLinearLayout.getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject1 = this.accountListLinearLayout.getChildAt(i);
        Object localObject2 = ((View)localObject1).getTag();
        if (localObject2 == null) {
          return;
        }
        int k = ((Integer)localObject2).intValue();
        SimpleAccount localSimpleAccount = (SimpleAccount)this.accountList.get(k);
        if (localSimpleAccount == null) {
          return;
        }
        ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131368343);
        TextView localTextView1 = (TextView)((View)localObject1).findViewById(2131371697);
        TextView localTextView2 = (TextView)((View)localObject1).findViewById(2131361863);
        localObject1 = (ImageView)((View)localObject1).findViewById(2131364592);
        localObject2 = ((IContactUtils)QRoute.api(IContactUtils.class)).getAccountNickName(this.app, localSimpleAccount.getUin());
        localObject1 = localObject2;
        if (localSimpleAccount.isLogined()) {
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = localObject2;
            if (!((String)localObject2).equals(localSimpleAccount.getUin())) {}
          }
          else
          {
            localObject1 = ((IContactUtils)QRoute.api(IContactUtils.class)).getFriendNickName(this.app, localSimpleAccount.getUin());
          }
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = localSimpleAccount.getUin();
        }
        localTextView1.setText((CharSequence)localObject2);
        localTextView2.setText(localSimpleAccount.getUin());
        localObject1 = FaceDrawable.getFaceDrawable(this.app, 1, localSimpleAccount.getUin());
        if (localObject1 != null) {
          localImageView.setBackgroundDrawable((Drawable)localObject1);
        }
        i += 1;
      }
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
    super.setContentView(2131562890);
    setTitle(2131719312);
    setContentBackgroundResource(2130838739);
    this.accountListLinearLayout = ((LinearLayout)findViewById(2131361866));
    if (!refreshAccountList(true)) {
      return false;
    }
    this.app.setHandler(getClass(), this.mHandler);
    addObserver(this.fob);
    addObserver(this.avatarObserver);
    addObserver(this.sabo);
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.sabo);
    removeObserver(this.fob);
    removeObserver(this.avatarObserver);
    this.app.removeHandler(getClass());
    super.doOnDestroy();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected boolean refreshAccountList(boolean paramBoolean)
  {
    initAccountList();
    Object localObject;
    if ((paramBoolean) && (this.accountList.size() == 1) && (this.accountList.get(0) == null))
    {
      localObject = new Intent();
      ((Intent)localObject).setClass(this, SubLoginActivity.class);
      ((Intent)localObject).putExtra("fromWhere", this.fromWhere);
      startActivity((Intent)localObject);
      finish();
      return false;
    }
    this.accountListLinearLayout.removeAllViews();
    int i = 0;
    while (i < this.accountList.size())
    {
      if (this.accountList.get(i) == null)
      {
        localObject = getLayoutInflater().inflate(2131558442, this.accountListLinearLayout, false);
        ((TextView)((View)localObject).findViewById(2131371780)).setText(2131719302);
        ((View)localObject).setOnClickListener(this.onAddAccountClick);
        ((View)localObject).setTag(null);
        this.accountListLinearLayout.addView((View)localObject);
      }
      else
      {
        localObject = getLayoutInflater().inflate(2131558443, this.accountListLinearLayout, false);
        if ((localObject instanceof FormItemRelativeLayout))
        {
          FormItemRelativeLayout localFormItemRelativeLayout = (FormItemRelativeLayout)localObject;
          localFormItemRelativeLayout.setNeedFocusBg(true);
          localFormItemRelativeLayout.setBGType(2);
        }
        ((View)localObject).setTag(Integer.valueOf(i));
        ((ImageView)((View)localObject).findViewById(2131368343)).setScaleType(ImageView.ScaleType.FIT_CENTER);
        ((View)localObject).setOnClickListener(this.onSelectAccountClick);
        this.accountListLinearLayout.addView((View)localObject);
      }
      i += 1;
    }
    updateAccountListView();
    return true;
  }
  
  void updateFace(String paramString, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new SubAccountBindActivity.7(this, paramString, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBindActivity
 * JD-Core Version:    0.7.0.1
 */