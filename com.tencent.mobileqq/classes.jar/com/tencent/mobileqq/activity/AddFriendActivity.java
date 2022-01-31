package com.tencent.mobileqq.activity;

import SummaryCard.RespSearch;
import SummaryCard.SearchInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade;
import com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade.ISearchListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import rhx;
import rhy;
import rhz;
import ria;
import rib;

public class AddFriendActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new rib(this);
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  ContactSearchFacade.ISearchListener jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade$ISearchListener = new rhx(this);
  private ContactSearchFacade jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade;
  private TroopHandler jdField_a_of_type_ComTencentMobileqqAppTroopHandler;
  public TroopObserver a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  String jdField_a_of_type_JavaLangString = "";
  private final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$", 2);
  private boolean jdField_a_of_type_Boolean;
  public String b;
  private final Pattern jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile("[^0-9]");
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c;
  private boolean d;
  
  public AddFriendActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new rhy(this);
  }
  
  public static void a(Activity paramActivity, SearchInfo paramSearchInfo, String paramString, byte[] paramArrayOfByte, boolean paramBoolean, int paramInt)
  {
    int i = 1;
    long l = paramSearchInfo.lUIN;
    if (l != 0L)
    {
      if (l == Long.parseLong(paramString)) {
        i = 0;
      }
      for (;;)
      {
        paramString = new ProfileActivity.AllInOne(l + "", i);
        paramString.jdField_h_of_type_Int = 98;
        paramString.jdField_h_of_type_JavaLangString = paramSearchInfo.strNick;
        paramString.b = paramArrayOfByte;
        paramString.l = paramInt;
        if (paramActivity.getIntent().getStringExtra("param_return_addr") == null) {
          break;
        }
        paramSearchInfo = ProfileActivity.a(paramActivity, paramString);
        paramSearchInfo.putExtra("param_return_addr", paramActivity.getIntent().getStringExtra("param_return_addr"));
        paramSearchInfo.putExtra("AllInOne", paramString);
        paramActivity.startActivity(paramSearchInfo);
        return;
        if (paramSearchInfo.bIsFriend != 1) {
          if (paramBoolean) {
            i = 37;
          } else {
            i = 35;
          }
        }
      }
    }
    if (paramSearchInfo.bInContact == 1) {}
    for (i = 31;; i = 36)
    {
      paramString = new ProfileActivity.AllInOne(paramSearchInfo.strMobile, i);
      if (paramSearchInfo.bInContact == 1) {
        paramString.i = 3001;
      }
      break;
    }
    ProfileActivity.a(paramActivity, paramString, 100);
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    Intent localIntent = new Intent(paramContext, AddFriendActivity.class);
    localIntent.putExtra("btroop", paramBoolean1);
    localIntent.putExtra("performAutoAction", paramBoolean2);
    if (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity)))
    {
      localIntent.addFlags(1073741824);
      localIntent.putExtra("needFinish", true);
    }
    if (paramString != null)
    {
      if (!paramBoolean1) {
        break label85;
      }
      localIntent.putExtra("troopuin", paramString);
    }
    for (;;)
    {
      paramContext.startActivity(localIntent);
      return;
      label85:
      localIntent.putExtra("uin", paramString);
    }
  }
  
  private static boolean a(String paramString)
  {
    boolean bool = false;
    if (paramString != null) {
      bool = paramString.matches("^\\d{5,}$");
    }
    return bool;
  }
  
  private void b()
  {
    Intent localIntent = getIntent();
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("uin");
    this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("troopuin");
    this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("btroop", false);
    this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("performAutoAction", true);
    this.c = localIntent.getBooleanExtra("needFinish", false);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void c()
  {
    Button localButton = (Button)findViewById(2131362883);
    TextView localTextView = (TextView)findViewById(2131362881);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131362866));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362884));
    if (this.jdField_a_of_type_Boolean)
    {
      setTitle(2131434748);
      localTextView.setText(2131434750);
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(25) });
      localTextView.setVisibility(8);
      findViewById(2131362882).setVisibility(8);
      Object localObject1 = findViewById(2131362879);
      Object localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((FrameLayout.LayoutParams)localObject2).height = -1;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = findViewById(2131362880);
      localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = -1;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      localButton.setOnClickListener(this);
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_JavaLangString);
      localTextView.setFocusable(true);
      localTextView.setFocusableInTouchMode(true);
      localTextView.requestFocus();
      return;
      setTitle(2131434747);
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131434749);
      localTextView.setText(2131434749);
    }
    if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_b_of_type_JavaLangString);
      localTextView.setFocusable(true);
      localTextView.setFocusableInTouchMode(true);
      localTextView.requestFocus();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString().trim();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.trim();
    if (this.jdField_a_of_type_JavaLangString.equals("")) {
      a(2131434436);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_JavaLangString.length() < 5)
      {
        a(2131434437);
        return;
      }
      if (this.jdField_a_of_type_JavaLangString.indexOf("@") != -1)
      {
        if (!this.jdField_a_of_type_JavaUtilRegexPattern.matcher(this.jdField_a_of_type_JavaLangString).matches()) {
          a("非法的邮箱地址");
        }
      }
      else
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaUtilRegexPattern.matcher(this.jdField_a_of_type_JavaLangString).replaceAll("");
        if (this.jdField_a_of_type_JavaLangString.length() < 5)
        {
          a(2131434436);
          return;
        }
      }
      if (!NetworkUtil.d(this)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_a_of_type_JavaLangString);
      b(2131434439);
    } while (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    return;
    QQToast.a(this, 2131434811, 0).b(getTitleBarHeight());
  }
  
  private void e()
  {
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
    if (this.jdField_b_of_type_JavaLangString.trim().equals("")) {
      a(2131434750);
    }
    do
    {
      return;
      if (!NetworkUtil.d(this)) {
        break;
      }
      b(2131434441);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      f();
    } while (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    return;
    QQToast.a(this, 2131434811, 0).b(getTitleBarHeight());
  }
  
  private void f()
  {
    if (a(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(this.jdField_b_of_type_JavaLangString, 3001);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AddFriendActivity", 2, "少于5位数字，直接显示找不到群号");
    }
    g();
    a(2131434954);
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void a()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_b_of_type_Boolean)) {
      d();
    }
    if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_Boolean)) {
      e();
    }
  }
  
  public void a(int paramInt)
  {
    runOnUiThread(new rhz(this, paramInt));
  }
  
  public void a(RespSearch paramRespSearch)
  {
    Intent localIntent = new Intent(this, SearchFriendListActivity.class);
    localIntent.putExtra("param_search_resp", paramRespSearch.toByteArray());
    localIntent.putExtra("param_return_addr", getIntent().getStringExtra("param_return_addr"));
    startActivity(localIntent);
  }
  
  public void a(String paramString)
  {
    runOnUiThread(new ria(this, paramString));
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt2)
    {
    }
    do
    {
      return;
    } while (paramInt1 != 100);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendActivity", 2, "onCreate");
    }
    super.doOnCreate(paramBundle);
    b();
    paramBundle = getActivity().getWindow();
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))) {
      paramBundle.setSoftInputMode(2);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade = new ContactSearchFacade(this.app);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade$ISearchListener);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.app.a(20));
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
      super.setContentView(View.inflate(this, 2130968618, null));
      setContentBackgroundResource(2130838214);
      c();
      return true;
      paramBundle.setSoftInputMode(4);
    }
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendActivity", 2, "onDestroy");
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade = null;
    super.doOnDestroy();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.d))
    {
      this.d = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null)
    {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = null;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362883)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      if (!isFinishing())
      {
        if (this.jdField_a_of_type_Boolean) {
          break label36;
        }
        d();
      }
    }
    return;
    label36:
    e();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected String setLastActivityName()
  {
    if ((this.centerView == null) || (this.centerView.getText() == null) || (this.centerView.getText().length() == 0) || (this.c)) {
      return getString(2131433698);
    }
    return this.centerView.getText().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendActivity
 * JD-Core Version:    0.7.0.1
 */