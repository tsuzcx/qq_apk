package com.tencent.mobileqq.activity;

import aeup;
import aeur;
import aewb;
import ajjy;
import akgw;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Parcelable;
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
import azgu;
import azlj;
import badq;
import bbms;
import bbmy;
import befq;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResultItem;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import zww;

public class AddFriendActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener
{
  private aeup jdField_a_of_type_Aeup;
  aeur jdField_a_of_type_Aeur = new zww(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new befq(this);
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  bbms jdField_a_of_type_Bbms;
  String jdField_a_of_type_JavaLangString = "";
  private final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$", 2);
  private boolean jdField_a_of_type_Boolean;
  String jdField_b_of_type_JavaLangString;
  private final Pattern jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile("[^0-9]");
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c;
  private boolean d;
  
  private void a(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2, String paramString)
  {
    g();
    if ((!paramBoolean) || (paramInt2 != 0))
    {
      if (!TextUtils.isEmpty(paramString))
      {
        a(paramString);
        return;
      }
      a(2131626967);
      return;
    }
    label289:
    label342:
    label348:
    label360:
    for (;;)
    {
      aewb localaewb;
      int i;
      try
      {
        paramString = (ArrayList)paramObject;
        if ((paramString == null) || (paramString.size() <= 0)) {
          break label342;
        }
        Iterator localIterator1 = paramString.iterator();
        paramString = null;
        if (!localIterator1.hasNext()) {
          break label360;
        }
        localaewb = (aewb)localIterator1.next();
        if ((localaewb == null) || (localaewb.a != 80000000) || (localaewb.b == null) || (localaewb.b.size() == 0)) {
          continue;
        }
        Iterator localIterator2 = localaewb.b.iterator();
        i = 0;
        if (!localIterator2.hasNext()) {
          break label348;
        }
        AccountSearchPb.record localrecord = (AccountSearchPb.record)localIterator2.next();
        if ((localrecord == null) || (localrecord.uin.get() == 0L)) {
          continue;
        }
        i += 1;
        continue;
        if ((paramString != null) && (paramString.b != null) && (paramString.b.size() != 0)) {
          break label289;
        }
        a(2131653258);
        return;
      }
      catch (Exception paramString)
      {
        a(2131626967);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AddFriendActivity", 2, "onSearchResult | searchType = " + paramInt1 + " | isSuccess = " + paramBoolean + " | rsCode = " + paramInt2 + " | data = " + paramObject, paramString);
      return;
      if (paramString.b.size() == 1)
      {
        a(this, new SearchResultItem((AccountSearchPb.record)paramString.b.get(0)), this.app, false, 1);
        return;
      }
      a(paramString);
      return;
      paramString = null;
      continue;
      if (i != 0) {
        paramString = localaewb;
      }
    }
  }
  
  public static void a(Activity paramActivity, SearchResultItem paramSearchResultItem, QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt)
  {
    if (paramSearchResultItem == null) {
      return;
    }
    long l3 = paramSearchResultItem.jdField_a_of_type_Long;
    if ((paramQQAppInterface != null) && (azgu.b(paramQQAppInterface, String.valueOf(l3))))
    {
      azgu.a(paramActivity, null, String.valueOf(l3));
      return;
    }
    long l1 = 0L;
    Object localObject;
    if (paramQQAppInterface == null) {
      localObject = "";
    }
    try
    {
      long l2 = Long.parseLong((String)localObject);
      l1 = l2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        int j;
        localThrowable.printStackTrace();
        continue;
        if (paramSearchResultItem.jdField_a_of_type_Byte == 1)
        {
          j = 1;
        }
        else if (paramBoolean)
        {
          j = 37;
          i = 3020;
        }
        else
        {
          j = 35;
          i = 3001;
          continue;
          if (paramSearchResultItem.jdField_b_of_type_Byte == 1) {}
          for (i = 31;; i = 36)
          {
            localAllInOne = new ProfileActivity.AllInOne(paramSearchResultItem.jdField_b_of_type_JavaLangString, i);
            if (paramSearchResultItem.jdField_b_of_type_Byte != 1) {
              break label390;
            }
            i = 3001;
            break;
          }
          paramQQAppInterface = paramQQAppInterface.a();
        }
      }
      ProfileActivity.a(paramActivity, localAllInOne, 100);
      return;
    }
    int i = 0;
    if (l3 != 0L) {
      if (l3 == l1)
      {
        j = 0;
        localObject = new ProfileActivity.AllInOne(String.valueOf(l3), j);
      }
    }
    label390:
    for (;;)
    {
      if ((l3 != 0L) && (i != 0) && (paramInt != 0) && (paramSearchResultItem.jdField_b_of_type_ArrayOfByte != null) && (paramSearchResultItem.jdField_b_of_type_ArrayOfByte.length > 0) && (paramQQAppInterface != null))
      {
        paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
        if (paramQQAppInterface != null) {
          break label373;
        }
        paramQQAppInterface = null;
        if (paramQQAppInterface != null) {
          paramQQAppInterface.a(String.valueOf(l3), i, paramInt, paramSearchResultItem.jdField_b_of_type_ArrayOfByte);
        }
      }
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 98;
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = paramSearchResultItem.jdField_a_of_type_JavaLangString;
      ((ProfileActivity.AllInOne)localObject).jdField_b_of_type_ArrayOfByte = paramSearchResultItem.jdField_a_of_type_ArrayOfByte;
      ((ProfileActivity.AllInOne)localObject).i = i;
      ((ProfileActivity.AllInOne)localObject).l = paramInt;
      if (paramActivity.getIntent().getStringExtra("param_return_addr") != null)
      {
        paramSearchResultItem = ProfileActivity.a(paramActivity, (ProfileActivity.AllInOne)localObject);
        paramSearchResultItem.putExtra("param_return_addr", paramActivity.getIntent().getStringExtra("param_return_addr"));
        paramSearchResultItem.putExtra("AllInOne", (Parcelable)localObject);
        paramActivity.startActivity(paramSearchResultItem);
        return;
        localObject = paramQQAppInterface.getCurrentAccountUin();
        break;
      }
      ProfileActivity.AllInOne localAllInOne;
      label373:
      i = 0;
    }
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
        break label90;
      }
      localIntent.putExtra("troopuin", paramString);
    }
    for (;;)
    {
      paramContext.startActivity(localIntent);
      return;
      label90:
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
    if (this.jdField_a_of_type_Bbms == null) {
      this.jdField_a_of_type_Bbms = new bbms(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_Bbms.c(paramInt);
    this.jdField_a_of_type_Bbms.show();
  }
  
  private void b(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2, String paramString)
  {
    g();
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof ArrayList)))
    {
      paramString = (ArrayList)paramObject;
      if (paramString.size() == 1)
      {
        paramObject = ((aewb)paramString.get(0)).b;
        if ((paramObject != null) && (paramObject.size() == 1))
        {
          paramObject = (AccountSearchPb.record)paramObject.get(0);
          paramInt1 = ((aewb)paramString.get(0)).a;
          paramString = String.valueOf(paramObject.code.get());
          if ((paramInt1 == 80000001) && (!TextUtils.isEmpty(paramString)) && (TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramString)))
          {
            paramString = paramObject.bytes_join_group_auth.get().toStringUtf8();
            azlj.a(this, TroopInfoActivity.a(String.valueOf(paramObject.code.get()), paramString, 105), 2);
            finish();
            overridePendingTransition(0, 0);
            return;
          }
        }
      }
    }
    if (!paramBoolean)
    {
      if (!badq.d(BaseApplication.getContext()))
      {
        a(2131628951);
        return;
      }
      a(2131626967);
      return;
    }
    a(2131654649);
  }
  
  private void c()
  {
    Button localButton = (Button)findViewById(2131298095);
    TextView localTextView = (TextView)findViewById(2131312397);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131300160));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312330));
    if (this.jdField_a_of_type_Boolean)
    {
      setTitle(2131653262);
      localTextView.setText(2131653252);
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(25) });
      localTextView.setVisibility(8);
      findViewById(2131309962).setVisibility(8);
      Object localObject1 = findViewById(2131296556);
      Object localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((FrameLayout.LayoutParams)localObject2).height = -1;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = findViewById(2131296562);
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
      setTitle(2131653261);
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131653251);
      localTextView.setText(2131653251);
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
      a(2131626501);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_JavaLangString.length() < 5)
      {
        a(2131626606);
        return;
      }
      if (this.jdField_a_of_type_JavaLangString.indexOf("@") != -1)
      {
        if (!this.jdField_a_of_type_JavaUtilRegexPattern.matcher(this.jdField_a_of_type_JavaLangString).matches()) {
          a(ajjy.a(2131634069));
        }
      }
      else
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaUtilRegexPattern.matcher(this.jdField_a_of_type_JavaLangString).replaceAll("");
        if (this.jdField_a_of_type_JavaLangString.length() < 5)
        {
          a(2131626501);
          return;
        }
      }
      if (!badq.d(this)) {
        break;
      }
      this.jdField_a_of_type_Aeup.a(this.jdField_a_of_type_JavaLangString, 80000000, 0.0D, 0.0D, 0);
      b(2131626978);
    } while (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    return;
    bbmy.a(this, 2131628948, 0).b(getTitleBarHeight());
  }
  
  private void e()
  {
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
    if (this.jdField_b_of_type_JavaLangString.trim().equals("")) {
      a(2131653252);
    }
    do
    {
      return;
      if (!badq.d(this)) {
        break;
      }
      b(2131653276);
      f();
    } while (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    return;
    bbmy.a(this, 2131628948, 0).b(getTitleBarHeight());
  }
  
  private void f()
  {
    if (a(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Aeup.a(this.jdField_b_of_type_JavaLangString, 80000001, 0.0D, 0.0D, 0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AddFriendActivity", 2, "少于5位数字，直接显示找不到群号");
    }
    g();
    a(2131654649);
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
      this.jdField_a_of_type_Bbms.dismiss();
    }
  }
  
  void a()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_b_of_type_Boolean)) {
      d();
    }
    if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_Boolean)) {
      e();
    }
  }
  
  void a(int paramInt)
  {
    runOnUiThread(new AddFriendActivity.2(this, paramInt));
  }
  
  void a(aewb paramaewb)
  {
    if ((paramaewb == null) || (paramaewb.b == null) || (paramaewb.b.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList(paramaewb.b.size());
      paramaewb = paramaewb.b.iterator();
      while (paramaewb.hasNext())
      {
        AccountSearchPb.record localrecord = (AccountSearchPb.record)paramaewb.next();
        if (localrecord != null) {
          localArrayList.add(new SearchResultItem(localrecord));
        }
      }
    } while (localArrayList.size() == 0);
    paramaewb = new Intent(this, SearchFriendListActivity.class);
    paramaewb.putParcelableArrayListExtra("param_search_result_item_list", localArrayList);
    paramaewb.putExtra("param_return_addr", getIntent().getStringExtra("param_return_addr"));
    startActivity(paramaewb);
  }
  
  void a(String paramString)
  {
    runOnUiThread(new AddFriendActivity.3(this, paramString));
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
  
  public boolean doOnCreate(Bundle paramBundle)
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
      this.jdField_a_of_type_Aeup = new aeup(this.app);
      this.jdField_a_of_type_Aeup.a(this.jdField_a_of_type_Aeur);
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
      super.setContentView(View.inflate(this, 2131492927, null));
      setContentBackgroundResource(2130838503);
      c();
      return true;
      paramBundle.setSoftInputMode(4);
    }
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendActivity", 2, "onDestroy");
    }
    this.jdField_a_of_type_Aeup.d();
    this.jdField_a_of_type_Aeup = null;
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
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      a();
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131298095)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      if (!isFinishing())
      {
        if (this.jdField_a_of_type_Boolean) {
          break label37;
        }
        d();
      }
    }
    return;
    label37:
    e();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public String setLastActivityName()
  {
    if ((this.centerView == null) || (this.centerView.getText() == null) || (this.centerView.getText().length() == 0) || (this.c)) {
      return getString(2131625011);
    }
    return this.centerView.getText().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendActivity
 * JD-Core Version:    0.7.0.1
 */