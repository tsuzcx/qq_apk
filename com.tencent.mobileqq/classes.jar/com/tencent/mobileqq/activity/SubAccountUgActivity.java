package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.api.IQQAvatarCompatibleService;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControllUtil;
import com.tencent.mobileqq.subaccount.SubAccountUgActivityInterface;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountServiceImpl;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.api.IContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

@RoutePage(desc="小号助手绑定Activity", path="/base/subAccount/ug")
public class SubAccountUgActivity
  extends SubAccountBaseActivity
  implements View.OnClickListener, SubAccountUgActivityInterface, Observer
{
  public static final int SUBACCOUNTUGACTIVITY_FINISH = 1980;
  boolean mBindClick;
  SubAccountBindObserver mBindObserver = new SubAccountUgActivity.1(this);
  MqqHandler mHandler = new SubAccountUgActivity.3(this);
  boolean mHasBindAccount;
  boolean mIsFromAssociatedActivity = false;
  BusinessObserver mMsgObserver = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getMessageObserver(new SubAccountUgActivity.4(this));
  String subUin = "";
  
  private void updateLayoutForMultiWindow(boolean paramBoolean)
  {
    View localView = findViewById(2131446553);
    if (localView != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      if (paramBoolean)
      {
        localView.setPadding(localView.getPaddingLeft(), ViewUtils.dip2px(260.0F), localView.getPaddingRight(), localView.getPaddingBottom());
        return;
      }
      localView.setPadding(localView.getPaddingLeft(), 0, localView.getPaddingRight(), localView.getPaddingBottom());
    }
  }
  
  public void bindSwitchUnbind()
  {
    this.mHasBindAccount = false;
    View localView = findViewById(2131446553);
    TextView localTextView1 = (TextView)findViewById(2131446557);
    TextView localTextView2 = (TextView)findViewById(2131446558);
    ImageView localImageView = (ImageView)findViewById(2131446556);
    ((Button)findViewById(2131446554)).setText(2131916892);
    localView.setVisibility(8);
    localTextView1.setText(2131916900);
    localTextView2.setVisibility(8);
    localImageView.setImageResource(2130852698);
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
    this.subUin = getIntent().getStringExtra("subAccount");
    this.mIsFromAssociatedActivity = getIntent().getBooleanExtra("from_associated_activity", false);
    SubAccountServiceImpl localSubAccountServiceImpl = (SubAccountServiceImpl)this.app.getRuntimeService(ISubAccountService.class, null);
    this.mHasBindAccount = localSubAccountServiceImpl.isSubAccountUin(this.subUin);
    paramBundle = SubAccountControllUtil.d(this.app, this.subUin);
    boolean bool2;
    boolean bool1;
    if (paramBundle != null)
    {
      bool2 = ((Boolean)paramBundle.first).booleanValue();
      bool1 = ((Boolean)paramBundle.second).booleanValue();
    }
    else
    {
      bool1 = false;
      bool2 = false;
    }
    if (bool1)
    {
      SubAccountAssistantForward.a(this.app, this, this.subUin);
      finish();
      return false;
    }
    super.setContentView(2131629344);
    setTitle(2131916856);
    findViewById(2131445137).setOnClickListener(this);
    ImageView localImageView2 = (ImageView)findViewById(2131446555);
    ImageView localImageView1 = (ImageView)findViewById(2131446556);
    ((ThemeImageView)findViewById(2131446552)).setMaskShape(ThemeImageWrapper.MODE_OTHER);
    TextView localTextView1 = (TextView)findViewById(2131446557);
    TextView localTextView2 = (TextView)findViewById(2131446558);
    Button localButton = (Button)findViewById(2131446554);
    View localView = findViewById(2131446553);
    Object localObject = getFaceBitmap(this.app.getAccount(), false);
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = BaseImageUtil.k();
    }
    localImageView2.setImageBitmap(paramBundle);
    localTextView1.setTextColor(getResources().getColor(2131167993));
    localTextView2.setVisibility(8);
    if (this.mHasBindAccount)
    {
      int k = 2131916895;
      if (bool2)
      {
        paramBundle = localSubAccountServiceImpl.getServerError(this.subUin);
        if (paramBundle != null) {
          j = ((Integer)paramBundle.first).intValue();
        } else {
          j = 0;
        }
        if (j != 0)
        {
          i = k;
          if (j == 1200) {
            break label408;
          }
          if (j != 1214)
          {
            if (j != 1215)
            {
              i = k;
              if (j == 1232) {
                break label408;
              }
              i = k;
              if (j == 1233) {
                break label408;
              }
            }
            else
            {
              i = 2131916894;
              break label408;
            }
          }
          else
          {
            i = 2131916896;
            break label408;
          }
        }
        else
        {
          i = 2131916898;
          break label408;
        }
      }
      int i = 0;
      label408:
      int j = i;
      if (i == 0) {
        j = 2131916898;
      }
      localTextView1.setTextColor(getResources().getColor(2131167993));
      paramBundle = getFaceBitmap(this.subUin, false);
      if (paramBundle != null) {
        localImageView1.setImageBitmap(paramBundle);
      }
      localObject = ((IContactUtils)QRoute.api(IContactUtils.class)).getBuddyNickName(this.app, this.subUin, true);
      if (localObject != null)
      {
        paramBundle = (Bundle)localObject;
        if (((String)localObject).length() != 0) {}
      }
      else
      {
        paramBundle = this.subUin;
      }
      localTextView1.setText(getString(j, new Object[] { paramBundle }));
      if (j == 2131916898) {
        localTextView2.setVisibility(0);
      } else {
        localTextView2.setVisibility(8);
      }
      localButton.setText(2131916891);
      localView.setVisibility(0);
      ((Button)localView.findViewById(2131446547)).setOnClickListener(this);
      ((Button)localView.findViewById(2131446546)).setOnClickListener(this);
    }
    else
    {
      localImageView1.setImageResource(2130852698);
    }
    localButton.setOnClickListener(this);
    addObserver(this.mBindObserver);
    addObserver(this.mMsgObserver);
    updateUnreadNumOnTitleBar();
    ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "")).addObserver(this);
    this.app.setHandler(getClass(), this.mHandler);
    if (isInMultiWindow()) {
      updateLayoutForMultiWindow(true);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.mBindObserver);
    removeObserver(this.mMsgObserver);
    this.app.removeHandler(getClass());
    ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "")).deleteObserver(this);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public Bitmap getFaceBitmap(int paramInt1, String paramString, byte paramByte1, boolean paramBoolean, byte paramByte2, int paramInt2)
  {
    return ((IQQAvatarCompatibleService)this.app.getRuntimeService(IQQAvatarCompatibleService.class, "")).getFaceBitmap(paramInt1, paramString, paramByte1, 100, paramBoolean, paramByte2, paramInt2);
  }
  
  public Bitmap getFaceBitmap(int paramInt1, String paramString, byte paramByte, boolean paramBoolean, int paramInt2)
  {
    return getFaceBitmap(paramInt1, paramString, paramByte, paramBoolean, (byte)1, paramInt2);
  }
  
  public Bitmap getFaceBitmap(String paramString, boolean paramBoolean)
  {
    return getFaceBitmap(1, paramString, (byte)3, paramBoolean, 0);
  }
  
  public String getSubUin()
  {
    return this.subUin;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject1;
    if (i == 2131446554)
    {
      localObject1 = new Intent();
      if (this.mHasBindAccount)
      {
        ((Intent)localObject1).putExtra("is_need_bind", false);
        ((Intent)localObject1).putExtra("subuin", this.subUin);
        ((Intent)localObject1).setClass(this, SubLoginActivity.class);
        ((Intent)localObject1).putExtra("fromWhere", this.fromWhere);
        ((Intent)localObject1).putExtra("fromWhereExactly", 3);
        startActivity((Intent)localObject1);
      }
      else
      {
        ((Intent)localObject1).setClass(paramView.getContext(), SubAccountBindActivity.class);
        ((Intent)localObject1).putExtra("fromWhere", this.fromWhere);
        ((Intent)localObject1).putExtra("fromWhereExactly", 3);
        startActivity((Intent)localObject1);
      }
    }
    else if (i == 2131446547)
    {
      localObject1 = (ActionSheet)ActionSheetHelper.b(getActivity(), null);
      ((ActionSheet)localObject1).setMainTitle(2131916893);
      ((ActionSheet)localObject1).addButton(getResources().getString(2131917711), 3);
      ((ActionSheet)localObject1).addCancelButton(2131887648);
      ((ActionSheet)localObject1).setOnButtonClickListener(new SubAccountUgActivity.5(this, (ActionSheet)localObject1));
      ((ActionSheet)localObject1).show();
    }
    else if (i == 2131446546)
    {
      Object localObject2 = this.subUin;
      localObject1 = "https://ti.qq.com/safe/forgetpw?source_id=2756";
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = String.format(Locale.getDefault(), "%s&account=%s", new Object[] { "https://ti.qq.com/safe/forgetpw?source_id=2756", localObject2 });
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("uin", this.subUin);
      ((Intent)localObject2).putExtra("reqType", 3);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      RouteUtils.a(this, (Intent)localObject2, "/base/browser");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    updateLayoutForMultiWindow(paramBoolean);
  }
  
  public void showUnbindDialog(ISubAccountControlService paramISubAccountControlService, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showUnbindDialog() subUin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramISubAccountControlService != null) && (paramString != null))
    {
      if (paramString.length() <= 4) {
        return;
      }
      if ((isResume()) && (SubAccountControllUtil.e(this.app, paramString)))
      {
        hideJuhua();
        paramString = paramISubAccountControlService.popWaittingHintPair(paramString);
        int j = paramString.size();
        int i = 0;
        while (i < j)
        {
          localObject = (Pair)paramString.get(i);
          paramISubAccountControlService.showHintDialog(this.app, this, (Pair)localObject, new SubAccountUgActivity.2(this, paramISubAccountControlService, (Pair)localObject));
          i += 1;
        }
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof MessageRecord)) && (!((MessageRecord)paramObject).isSendFromLocal())) {
      runOnUiThread(new SubAccountUgActivity.6(this));
    }
  }
  
  void updateUnreadNumOnTitleBar()
  {
    if ((this.leftView != null) && (!this.mIsFromAssociatedActivity))
    {
      Object localObject = (IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "");
      StringBuilder localStringBuilder = new StringBuilder(HardCodeUtil.a(2131901576));
      localStringBuilder.append(getString(2131917002));
      if (localObject != null)
      {
        int i = ((IMessageFacade)localObject).getUnreadMsgsNum();
        if (i > 0)
        {
          localObject = Integer.toString(i);
          if (i > 99) {
            localObject = "99+";
          }
          this.leftView.setText("");
          this.mLeftBackIcon.setVisibility(4);
          this.mLeftBackText.setVisibility(0);
          this.mLeftBackText.setText((CharSequence)localObject);
          this.leftView.setContentDescription("");
          this.leftView.bringToFront();
          localStringBuilder.append(i);
          localStringBuilder.append("条未读");
        }
        else
        {
          this.leftView.setText("");
          this.mLeftBackText.setVisibility(8);
        }
      }
      else
      {
        this.leftView.setText("");
        this.mLeftBackText.setVisibility(8);
      }
      this.leftView.setContentDescription(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountUgActivity
 * JD-Core Version:    0.7.0.1
 */