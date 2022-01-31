package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;
import tud;
import tuf;
import tug;
import tuh;
import tui;
import tuj;

public class SubAccountUgActivity
  extends SubAccountBaseActivity
  implements View.OnClickListener, Observer
{
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new tuh(this);
  SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new tud(this);
  public String a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new tug(this);
  boolean jdField_a_of_type_Boolean;
  public boolean b;
  
  public SubAccountUgActivity()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private void a(SubAccountControll paramSubAccountControll, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "showUnbindDialog() subUin=" + paramString);
    }
    if ((paramSubAccountControll == null) || (paramString == null) || (paramString.length() <= 4)) {}
    for (;;)
    {
      return;
      if ((isResume()) && (SubAccountControll.a(this.app, paramString)))
      {
        c();
        paramString = paramSubAccountControll.a(paramString);
        int j = paramString.size();
        int i = 0;
        while (i < j)
        {
          Pair localPair = (Pair)paramString.get(i);
          paramSubAccountControll.a(this.app, this, localPair, new tuf(this, paramSubAccountControll, localPair));
          i += 1;
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    View localView = findViewById(2131375202);
    if (localView != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      if (paramBoolean) {
        localView.setPadding(localView.getPaddingLeft(), AIOUtils.a(260.0F, getResources()), localView.getPaddingRight(), localView.getPaddingBottom());
      }
    }
    else
    {
      return;
    }
    localView.setPadding(localView.getPaddingLeft(), 0, localView.getPaddingRight(), localView.getPaddingBottom());
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    View localView = findViewById(2131375202);
    TextView localTextView1 = (TextView)findViewById(2131375199);
    TextView localTextView2 = (TextView)findViewById(2131375200);
    ImageView localImageView = (ImageView)findViewById(2131375197);
    ((Button)findViewById(2131375201)).setText(2131436321);
    localView.setVisibility(8);
    localTextView1.setText(2131436310);
    localTextView2.setVisibility(8);
    localImageView.setImageResource(2130846107);
  }
  
  public void b()
  {
    if (this.leftView != null)
    {
      Object localObject = this.app.a();
      if (localObject == null) {
        break label97;
      }
      int i = ((QQMessageFacade)localObject).b();
      if (i > 0)
      {
        localObject = Integer.toString(i);
        if (i > 99) {
          localObject = "99+";
        }
        this.leftView.setText(getString(2131433297) + "(" + (String)localObject + ")");
      }
    }
    else
    {
      return;
    }
    this.leftView.setText(getString(2131433297));
    return;
    label97:
    this.leftView.setText(getString(2131433297));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("subAccount");
    SubAccountManager localSubAccountManager = (SubAccountManager)this.app.getManager(60);
    this.jdField_a_of_type_Boolean = localSubAccountManager.a(this.jdField_a_of_type_JavaLangString);
    boolean bool1 = false;
    paramBundle = SubAccountControll.a(this.app, this.jdField_a_of_type_JavaLangString);
    boolean bool2;
    if (paramBundle != null)
    {
      bool2 = ((Boolean)paramBundle.first).booleanValue();
      bool1 = ((Boolean)paramBundle.second).booleanValue();
    }
    for (;;)
    {
      if (bool1)
      {
        SubAccountAssistantForward.a(this.app, this, this.jdField_a_of_type_JavaLangString);
        finish();
        return false;
      }
      super.setContentView(2130971623);
      setTitle(2131436308);
      findViewById(2131362840).setOnClickListener(this);
      ImageView localImageView2 = (ImageView)findViewById(2131375198);
      ImageView localImageView1 = (ImageView)findViewById(2131375197);
      TextView localTextView1 = (TextView)findViewById(2131375199);
      TextView localTextView2 = (TextView)findViewById(2131375200);
      Button localButton = (Button)findViewById(2131375201);
      View localView = findViewById(2131375202);
      Object localObject = this.app.a(this.app.getAccount(), false);
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = ImageUtil.a();
      }
      localImageView2.setImageBitmap(paramBundle);
      localTextView1.setTextColor(getResources().getColor(2131494214));
      localTextView2.setVisibility(8);
      int i;
      if (this.jdField_a_of_type_Boolean)
      {
        if (!bool2) {
          break label645;
        }
        paramBundle = localSubAccountManager.a(this.jdField_a_of_type_JavaLangString);
        if (paramBundle == null) {
          break label640;
        }
        i = ((Integer)paramBundle.first).intValue();
        if (i != 0) {
          switch (i)
          {
          default: 
            i = 0;
          }
        }
      }
      for (;;)
      {
        int j = i;
        if (i == 0) {
          j = 2131436312;
        }
        localTextView1.setTextColor(getResources().getColor(2131494214));
        paramBundle = this.app.a(this.jdField_a_of_type_JavaLangString, false);
        if (paramBundle != null) {
          localImageView1.setImageBitmap(paramBundle);
        }
        localObject = ContactUtils.c(this.app, this.jdField_a_of_type_JavaLangString, true);
        if (localObject != null)
        {
          paramBundle = (Bundle)localObject;
          if (((String)localObject).length() != 0) {}
        }
        else
        {
          paramBundle = this.jdField_a_of_type_JavaLangString;
        }
        localTextView1.setText(getString(j, new Object[] { paramBundle }));
        if (j == 2131436312)
        {
          localTextView2.setVisibility(0);
          label468:
          localButton.setText(2131436322);
          localView.setVisibility(0);
          ((Button)localView.findViewById(2131375203)).setOnClickListener(this);
          ((Button)localView.findViewById(2131375205)).setOnClickListener(this);
        }
        for (;;)
        {
          localButton.setOnClickListener(this);
          addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
          addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
          b();
          this.app.a().addObserver(this);
          this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
          if (isInMultiWindow()) {
            a(true);
          }
          return true;
          i = 2131436359;
          break;
          i = 2131436357;
          break;
          i = 2131436358;
          break;
          i = 2131436359;
          break;
          i = 2131436359;
          break;
          i = 2131436312;
          break;
          localTextView2.setVisibility(8);
          break label468;
          localImageView1.setImageResource(2130846107);
        }
        label640:
        i = 0;
        break;
        label645:
        i = 0;
      }
      bool2 = false;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.app.removeHandler(getClass());
    this.app.a().deleteObserver(this);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131375202: 
    case 2131375204: 
    default: 
      return;
    case 2131375201: 
      localObject = new Intent();
      if (this.jdField_a_of_type_Boolean)
      {
        ((Intent)localObject).putExtra("is_need_bind", false);
        ((Intent)localObject).putExtra("subuin", this.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).setClass(this, SubLoginActivity.class);
        ((Intent)localObject).putExtra("fromWhere", this.b);
        startActivity((Intent)localObject);
        return;
      }
      ((Intent)localObject).setClass(paramView.getContext(), SubAccountBindActivity.class);
      ((Intent)localObject).putExtra("fromWhere", this.b);
      startActivity((Intent)localObject);
      return;
    case 2131375203: 
      paramView = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
      paramView.a(2131436339);
      paramView.a(getResources().getString(2131436332), 3);
      paramView.c(2131433015);
      paramView.a(new tui(this, paramView));
      paramView.show();
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    paramView = "https://aq.qq.com/cn2/findpsw/mobile_web_find_input_account?source_id=2756";
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramView = String.format(Locale.getDefault(), "%s&account=%s", new Object[] { "https://aq.qq.com/cn2/findpsw/mobile_web_find_input_account?source_id=2756", localObject });
    }
    localObject = new Intent(this, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("reqType", 3);
    ((Intent)localObject).putExtra("url", paramView);
    startActivity((Intent)localObject);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    a(paramBoolean);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof MessageRecord)) && (!((MessageRecord)paramObject).isSendFromLocal())) {
      runOnUiThread(new tuj(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountUgActivity
 * JD-Core Version:    0.7.0.1
 */