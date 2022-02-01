package com.tencent.mobileqq.activity;

import addcontacts.AccountSearchPb.record;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.search.business.addcontact.model.SearchResult;
import com.tencent.mobileqq.search.model.SearchResultItem;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddFriendActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(this);
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  ContactSearchFacade.ISearchListener jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade$ISearchListener = new AddFriendActivity.1(this);
  private ContactSearchFacade jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  String jdField_a_of_type_JavaLangString = "";
  private final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$", 2);
  private boolean jdField_a_of_type_Boolean = false;
  String jdField_b_of_type_JavaLangString;
  private final Pattern jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile("[^0-9]");
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c = false;
  private boolean d = false;
  
  private void a(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2, String paramString)
  {
    g();
    Iterator localIterator;
    if ((paramBoolean) && (paramInt2 == 0))
    {
      localIterator = null;
      paramString = null;
    }
    for (;;)
    {
      Object localObject1;
      int i;
      try
      {
        Object localObject2 = (ArrayList)paramObject;
        localObject1 = localIterator;
        if (localObject2 != null)
        {
          localObject1 = localIterator;
          if (((ArrayList)localObject2).size() > 0)
          {
            localIterator = ((ArrayList)localObject2).iterator();
            localObject1 = paramString;
            if (localIterator.hasNext())
            {
              localObject1 = (SearchResult)localIterator.next();
              if ((localObject1 == null) || (((SearchResult)localObject1).a != 80000000) || (((SearchResult)localObject1).b == null) || (((SearchResult)localObject1).b.size() == 0)) {
                continue;
              }
              localObject2 = ((SearchResult)localObject1).b.iterator();
              i = 0;
              if (!((Iterator)localObject2).hasNext()) {
                break label406;
              }
              AccountSearchPb.record localrecord = (AccountSearchPb.record)((Iterator)localObject2).next();
              if (localrecord == null) {
                continue;
              }
              if (localrecord.uin.get() != 0L) {
                break label397;
              }
              continue;
            }
          }
        }
        if ((localObject1 != null) && (((SearchResult)localObject1).b != null) && (((SearchResult)localObject1).b.size() != 0))
        {
          if (((SearchResult)localObject1).b.size() == 1)
          {
            a(this, new SearchResultItem((AccountSearchPb.record)((SearchResult)localObject1).b.get(0)), this.app, false, 1);
            return;
          }
          a((SearchResult)localObject1);
          return;
        }
        a(2131718615);
        return;
      }
      catch (Exception paramString)
      {
        a(2131692482);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onSearchResult | searchType = ");
          ((StringBuilder)localObject1).append(paramInt1);
          ((StringBuilder)localObject1).append(" | isSuccess = ");
          ((StringBuilder)localObject1).append(paramBoolean);
          ((StringBuilder)localObject1).append(" | rsCode = ");
          ((StringBuilder)localObject1).append(paramInt2);
          ((StringBuilder)localObject1).append(" | data = ");
          ((StringBuilder)localObject1).append(paramObject);
          QLog.d("AddFriendActivity", 2, ((StringBuilder)localObject1).toString(), paramString);
        }
        return;
      }
      if (!TextUtils.isEmpty(paramString))
      {
        a(paramString);
        return;
      }
      a(2131692482);
      return;
      label397:
      i += 1;
      continue;
      label406:
      if (i != 0) {
        paramString = (String)localObject1;
      }
    }
  }
  
  public static void a(Activity paramActivity, SearchResultItem paramSearchResultItem, QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt)
  {
    if (paramSearchResultItem == null) {
      return;
    }
    long l2 = paramSearchResultItem.jdField_a_of_type_Long;
    if ((paramQQAppInterface != null) && (RobotUtils.a(paramQQAppInterface, String.valueOf(l2))))
    {
      RobotUtils.a(paramActivity, null, String.valueOf(l2));
      return;
    }
    String str;
    if (paramQQAppInterface == null) {
      str = "";
    }
    long l1;
    try
    {
      str = paramQQAppInterface.getCurrentAccountUin();
      l1 = Long.parseLong(str);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      l1 = 0L;
    }
    int i = 3001;
    int j = 0;
    AllInOne localAllInOne;
    if (l2 != 0L)
    {
      if (l2 == l1)
      {
        i = 0;
      }
      else if (paramSearchResultItem.jdField_a_of_type_Byte == 1)
      {
        i = 0;
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
      }
      localAllInOne = new AllInOne(String.valueOf(l2), j);
    }
    else
    {
      if (paramSearchResultItem.jdField_b_of_type_Byte == 1) {
        j = 31;
      } else {
        j = 36;
      }
      localAllInOne = new AllInOne(paramSearchResultItem.jdField_b_of_type_JavaLangString, j);
      if (paramSearchResultItem.jdField_b_of_type_Byte != 1) {
        i = 0;
      }
    }
    if ((l2 != 0L) && (i != 0) && (paramInt != 0) && (paramSearchResultItem.jdField_b_of_type_ArrayOfByte != null) && (paramSearchResultItem.jdField_b_of_type_ArrayOfByte.length > 0) && (paramQQAppInterface != null)) {
      ((IFriendHandlerService)paramQQAppInterface.getRuntimeService(IFriendHandlerService.class, "")).cacheToken(String.valueOf(l2), i, paramInt, paramSearchResultItem.jdField_b_of_type_ArrayOfByte);
    }
    localAllInOne.profileEntryType = 98;
    localAllInOne.nickname = paramSearchResultItem.jdField_a_of_type_JavaLangString;
    localAllInOne.chatCookie = paramSearchResultItem.jdField_a_of_type_ArrayOfByte;
    localAllInOne.sourceID = i;
    localAllInOne.subSourceId = paramInt;
    if (paramActivity.getIntent().getStringExtra("param_return_addr") != null)
    {
      paramSearchResultItem = ProfileUtils.getIntent(paramActivity, localAllInOne);
      paramSearchResultItem.putExtra("param_return_addr", paramActivity.getIntent().getStringExtra("param_return_addr"));
      paramSearchResultItem.putExtra("AllInOne", localAllInOne);
      paramActivity.startActivity(paramSearchResultItem);
      return;
    }
    ProfileUtils.openProfileCardForResult(paramActivity, localAllInOne, 100);
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
    if (paramString != null) {
      if (paramBoolean1) {
        localIntent.putExtra("troopuin", paramString);
      } else {
        localIntent.putExtra("uin", paramString);
      }
    }
    paramContext.startActivity(localIntent);
  }
  
  private static boolean a(String paramString)
  {
    if (paramString != null) {
      return paramString.matches("^\\d{5,}$");
    }
    return false;
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
  
  private void b(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2, String paramString)
  {
    g();
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof ArrayList)))
    {
      paramString = (ArrayList)paramObject;
      if (paramString.size() == 1)
      {
        paramObject = ((SearchResult)paramString.get(0)).b;
        if ((paramObject != null) && (paramObject.size() == 1))
        {
          paramObject = (AccountSearchPb.record)paramObject.get(0);
          paramInt1 = ((SearchResult)paramString.get(0)).a;
          paramString = String.valueOf(paramObject.code.get());
          if ((paramInt1 == 80000001) && (!TextUtils.isEmpty(paramString)) && (TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramString)))
          {
            paramString = paramObject.bytes_join_group_auth.get().toStringUtf8();
            TroopUtils.a(this, TroopInfoUIUtil.a(String.valueOf(paramObject.code.get()), paramString, 105), 2);
            finish();
            overridePendingTransition(0, 0);
            return;
          }
        }
      }
    }
    if (!paramBoolean)
    {
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        a(2131694426);
        return;
      }
      a(2131692482);
      return;
    }
    a(2131719986);
  }
  
  private void c()
  {
    Button localButton = (Button)findViewById(2131364050);
    TextView localTextView = (TextView)findViewById(2131379735);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366324));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379656));
    if (this.jdField_a_of_type_Boolean)
    {
      setTitle(2131718618);
      localTextView.setText(2131718610);
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(25) });
      localTextView.setVisibility(8);
      findViewById(2131377071).setVisibility(8);
      Object localObject1 = findViewById(2131362217);
      Object localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((FrameLayout.LayoutParams)localObject2).height = -1;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = findViewById(2131362223);
      localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = -1;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    else
    {
      setTitle(2131718617);
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131718609);
      localTextView.setText(2131718609);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    localButton.setOnClickListener(this);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_JavaLangString);
      localTextView.setFocusable(true);
      localTextView.setFocusableInTouchMode(true);
      localTextView.requestFocus();
      return;
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
    if (this.jdField_a_of_type_JavaLangString.equals(""))
    {
      a(2131691961);
      return;
    }
    if (this.jdField_a_of_type_JavaLangString.length() < 5)
    {
      a(2131692070);
      return;
    }
    if (this.jdField_a_of_type_JavaLangString.indexOf("@") != -1)
    {
      if (!this.jdField_a_of_type_JavaUtilRegexPattern.matcher(this.jdField_a_of_type_JavaLangString).matches()) {
        a(HardCodeUtil.a(2131700087));
      }
    }
    else
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaUtilRegexPattern.matcher(this.jdField_a_of_type_JavaLangString).replaceAll("");
      if (this.jdField_a_of_type_JavaLangString.length() < 5)
      {
        a(2131691961);
        return;
      }
    }
    if (NetworkUtil.isNetSupport(this))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_a_of_type_JavaLangString, 80000000, 0.0D, 0.0D, 0);
      b(2131692484);
      InputMethodManager localInputMethodManager = this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
      if (localInputMethodManager != null) {
        localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
      }
    }
    else
    {
      QQToast.a(this, 2131694424, 0).b(getTitleBarHeight());
    }
  }
  
  private void e()
  {
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
    if (this.jdField_b_of_type_JavaLangString.trim().equals(""))
    {
      a(2131718610);
      return;
    }
    if (NetworkUtil.isNetSupport(this))
    {
      b(2131718626);
      f();
      InputMethodManager localInputMethodManager = this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
      if (localInputMethodManager != null) {
        localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
      }
    }
    else
    {
      QQToast.a(this, 2131694424, 0).b(getTitleBarHeight());
    }
  }
  
  private void f()
  {
    if (a(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_b_of_type_JavaLangString, 80000001, 0.0D, 0.0D, 0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AddFriendActivity", 2, "少于5位数字，直接显示找不到群号");
    }
    g();
    a(2131719986);
  }
  
  private void g()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
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
  
  void a(SearchResult paramSearchResult)
  {
    if ((paramSearchResult != null) && (paramSearchResult.b != null))
    {
      if (paramSearchResult.b.size() == 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList(paramSearchResult.b.size());
      paramSearchResult = paramSearchResult.b.iterator();
      while (paramSearchResult.hasNext())
      {
        AccountSearchPb.record localrecord = (AccountSearchPb.record)paramSearchResult.next();
        if (localrecord != null) {
          localArrayList.add(new SearchResultItem(localrecord));
        }
      }
      if (localArrayList.size() == 0) {
        return;
      }
      paramSearchResult = new Intent(this, SearchFriendListActivity.class);
      paramSearchResult.putParcelableArrayListExtra("param_search_result_item_list", localArrayList);
      paramSearchResult.putExtra("param_return_addr", getIntent().getStringExtra("param_return_addr"));
      startActivity(paramSearchResult);
    }
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
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {
      return;
    }
    if (paramInt1 == 100) {
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendActivity", 2, "onCreate");
    }
    super.doOnCreate(paramBundle);
    b();
    paramBundle = getActivity().getWindow();
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && ((!this.jdField_a_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))) {
      paramBundle.setSoftInputMode(4);
    } else {
      paramBundle.setSoftInputMode(2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade = new ContactSearchFacade(this.app);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade$ISearchListener);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
    super.setContentView(View.inflate(this, 2131558504, null));
    setContentBackgroundResource(2130838739);
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendActivity", 2, "onDestroy");
    }
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
    InputMethodManager localInputMethodManager = this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
    if (localInputMethodManager != null)
    {
      localInputMethodManager.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
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
    if (paramView.getId() == 2131364050)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      if (!isFinishing()) {
        if (!this.jdField_a_of_type_Boolean) {
          d();
        } else {
          e();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected String setLastActivityName()
  {
    if ((this.centerView != null) && (this.centerView.getText() != null) && (this.centerView.getText().length() != 0) && (!this.c)) {
      return this.centerView.getText().toString();
    }
    return getString(2131690706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendActivity
 * JD-Core Version:    0.7.0.1
 */