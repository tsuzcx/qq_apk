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
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
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

@RoutePage(desc="添加好友页面", path="/base/activity/AddFriendActivity")
public class AddFriendActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener
{
  private static final int MAX_ALLOWED_TROOP_KEYWORK_LENGTH = 25;
  private static final int MSG_AUTO_ACTION = 1;
  private static final String PARAM_IS_TROOP = "btroop";
  private static final String PARAM_NEED_FINICH = "needFinish";
  private static final String PARAM_PERFORM_AUTO_ACTION = "performAutoAction";
  private static final String PARAM_TROOP_UIN = "troopuin";
  private static final String PARAM_UIN = "uin";
  private static final int REQUEST_CODE_ADD_FRIEND = 100;
  private static final String TAG = "AddFriendActivity";
  private final Pattern VERIFY_DIGITAL_PATTERN = Pattern.compile("[^0-9]");
  private final Pattern VERIFY_EMAIL_PATTERN = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$", 2);
  private Handler handler = new WeakReferenceHandler(this);
  private boolean isInitialized = false;
  private boolean isNeedFinish = false;
  QQProgressDialog mDlgProgress;
  private EditText mEtKeyword;
  private InputMethodManager mIm;
  private boolean mPerformAutoAction = true;
  String mSearchKeyword = "";
  private boolean mSearchTroop = false;
  String mSearchTrpCode;
  private TextView mTvErrMsg;
  private ContactSearchFacade searchFacade;
  ContactSearchFacade.ISearchListener searchListener = new AddFriendActivity.1(this);
  
  private void dismissJuhua()
  {
    QQProgressDialog localQQProgressDialog = this.mDlgProgress;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.mDlgProgress.dismiss();
    }
  }
  
  private void doSearchTroop()
  {
    if (guessIsTroopUin(this.mSearchTrpCode))
    {
      this.searchFacade.a(this.mSearchTrpCode, 80000001, 0.0D, 0.0D, 0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AddFriendActivity", 2, "少于5位数字，直接显示找不到群号");
    }
    dismissJuhua();
    showErrMsg(2131917591);
  }
  
  private static boolean guessIsTroopUin(String paramString)
  {
    if (paramString != null) {
      return paramString.matches("^\\d{5,}$");
    }
    return false;
  }
  
  private void handleSearchFrdResult(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2, String paramString)
  {
    dismissJuhua();
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
              if ((localObject1 == null) || (((SearchResult)localObject1).a != 80000000) || (((SearchResult)localObject1).e == null) || (((SearchResult)localObject1).e.size() == 0)) {
                continue;
              }
              localObject2 = ((SearchResult)localObject1).e.iterator();
              i = 0;
              if (!((Iterator)localObject2).hasNext()) {
                break label409;
              }
              AccountSearchPb.record localrecord = (AccountSearchPb.record)((Iterator)localObject2).next();
              if (localrecord == null) {
                continue;
              }
              if (localrecord.uin.get() != 0L) {
                break label400;
              }
              continue;
            }
          }
        }
        if ((localObject1 != null) && (((SearchResult)localObject1).e != null) && (((SearchResult)localObject1).e.size() != 0))
        {
          if (((SearchResult)localObject1).e.size() == 1)
          {
            startProfileCardActivity(this, new SearchResultItem((AccountSearchPb.record)((SearchResult)localObject1).e.get(0)), this.app, false, 1);
            return;
          }
          startResultListActivity((SearchResult)localObject1);
          return;
        }
        showErrMsg(2131916116);
        return;
      }
      catch (Exception paramString)
      {
        showErrMsg(2131889470);
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
        showErrMsg(paramString);
        return;
      }
      showErrMsg(2131889470);
      return;
      label400:
      i += 1;
      continue;
      label409:
      if (i != 0) {
        paramString = (String)localObject1;
      }
    }
  }
  
  private void handleSearchTroopResult(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2, String paramString)
  {
    dismissJuhua();
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof ArrayList)))
    {
      paramString = (ArrayList)paramObject;
      if (paramString.size() == 1)
      {
        paramObject = ((SearchResult)paramString.get(0)).e;
        if ((paramObject != null) && (paramObject.size() == 1))
        {
          paramObject = (AccountSearchPb.record)paramObject.get(0);
          paramInt1 = ((SearchResult)paramString.get(0)).a;
          paramString = String.valueOf(paramObject.code.get());
          if ((paramInt1 == 80000001) && (!TextUtils.isEmpty(paramString)) && (TextUtils.equals(this.mSearchTrpCode, paramString)))
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
        showErrMsg(2131892106);
        return;
      }
      showErrMsg(2131889470);
      return;
    }
    showErrMsg(2131917591);
  }
  
  private void initParams()
  {
    Intent localIntent = getIntent();
    this.mSearchKeyword = localIntent.getStringExtra("uin");
    this.mSearchTrpCode = localIntent.getStringExtra("troopuin");
    this.mSearchTroop = localIntent.getBooleanExtra("btroop", false);
    this.mPerformAutoAction = localIntent.getBooleanExtra("performAutoAction", true);
    this.isNeedFinish = localIntent.getBooleanExtra("needFinish", false);
  }
  
  private void initUI()
  {
    Button localButton = (Button)findViewById(2131430008);
    TextView localTextView = (TextView)findViewById(2131448540);
    this.mEtKeyword = ((EditText)findViewById(2131432626));
    this.mEtKeyword.addTextChangedListener(this);
    this.mTvErrMsg = ((TextView)findViewById(2131448432));
    if (this.mSearchTroop)
    {
      setTitle(2131916119);
      localTextView.setText(2131916111);
      this.mEtKeyword.setFilters(new InputFilter[] { new InputFilter.LengthFilter(25) });
      localTextView.setVisibility(8);
      findViewById(2131445440).setVisibility(8);
      Object localObject1 = findViewById(2131427798);
      Object localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((FrameLayout.LayoutParams)localObject2).height = -1;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = findViewById(2131427804);
      localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = -1;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = (RelativeLayout.LayoutParams)this.mTvErrMsg.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      this.mTvErrMsg.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    else
    {
      setTitle(2131916118);
      this.mEtKeyword.setHint(2131916110);
      localTextView.setText(2131916110);
    }
    this.mTvErrMsg.setVisibility(4);
    localButton.setOnClickListener(this);
    if (!TextUtils.isEmpty(this.mSearchKeyword))
    {
      this.mEtKeyword.setText(this.mSearchKeyword);
      localTextView.setFocusable(true);
      localTextView.setFocusableInTouchMode(true);
      localTextView.requestFocus();
      return;
    }
    if ((this.mSearchTroop) && (!TextUtils.isEmpty(this.mSearchTrpCode)))
    {
      this.mEtKeyword.setText(this.mSearchTrpCode);
      localTextView.setFocusable(true);
      localTextView.setFocusableInTouchMode(true);
      localTextView.requestFocus();
      return;
    }
    this.mEtKeyword.setText("");
    this.mEtKeyword.requestFocus();
  }
  
  private void searchFriend()
  {
    this.mSearchKeyword = this.mEtKeyword.getEditableText().toString().trim();
    this.mSearchKeyword = this.mSearchKeyword.trim();
    if (this.mSearchKeyword.equals(""))
    {
      showErrMsg(2131888928);
      return;
    }
    if (this.mSearchKeyword.length() < 5)
    {
      showErrMsg(2131889039);
      return;
    }
    if (this.mSearchKeyword.indexOf("@") != -1)
    {
      if (!this.VERIFY_EMAIL_PATTERN.matcher(this.mSearchKeyword).matches()) {
        showErrMsg(HardCodeUtil.a(2131898132));
      }
    }
    else
    {
      this.mSearchKeyword = this.VERIFY_DIGITAL_PATTERN.matcher(this.mSearchKeyword).replaceAll("");
      if (this.mSearchKeyword.length() < 5)
      {
        showErrMsg(2131888928);
        return;
      }
    }
    if (NetworkUtil.isNetSupport(this))
    {
      this.searchFacade.a(this.mSearchKeyword, 80000000, 0.0D, 0.0D, 0);
      showJuhua(2131889472);
      InputMethodManager localInputMethodManager = this.mIm;
      if (localInputMethodManager != null) {
        localInputMethodManager.hideSoftInputFromWindow(this.mEtKeyword.getWindowToken(), 0);
      }
    }
    else
    {
      QQToast.makeText(this, 2131892104, 0).show(getTitleBarHeight());
    }
  }
  
  private void searchTroop()
  {
    this.mSearchTrpCode = this.mEtKeyword.getEditableText().toString();
    if (this.mSearchTrpCode.trim().equals(""))
    {
      showErrMsg(2131916111);
      return;
    }
    if (NetworkUtil.isNetSupport(this))
    {
      showJuhua(2131916127);
      doSearchTroop();
      InputMethodManager localInputMethodManager = this.mIm;
      if (localInputMethodManager != null) {
        localInputMethodManager.hideSoftInputFromWindow(this.mEtKeyword.getWindowToken(), 0);
      }
    }
    else
    {
      QQToast.makeText(this, 2131892104, 0).show(getTitleBarHeight());
    }
  }
  
  private void showJuhua(int paramInt)
  {
    if (this.mDlgProgress == null) {
      this.mDlgProgress = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.mDlgProgress.c(paramInt);
    this.mDlgProgress.show();
  }
  
  public static void startActivity(Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2)
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
  
  public static void startProfileCardActivity(Activity paramActivity, SearchResultItem paramSearchResultItem, QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt)
  {
    if (paramSearchResultItem == null) {
      return;
    }
    long l2 = paramSearchResultItem.a;
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
      else if (paramSearchResultItem.e == 1)
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
      if (paramSearchResultItem.f == 1) {
        j = 31;
      } else {
        j = 36;
      }
      localAllInOne = new AllInOne(paramSearchResultItem.d, j);
      if (paramSearchResultItem.f != 1) {
        i = 0;
      }
    }
    if ((l2 != 0L) && (i != 0) && (paramInt != 0) && (paramSearchResultItem.i != null) && (paramSearchResultItem.i.length > 0) && (paramQQAppInterface != null)) {
      ((IFriendHandlerService)paramQQAppInterface.getRuntimeService(IFriendHandlerService.class, "")).cacheToken(String.valueOf(l2), i, paramInt, paramSearchResultItem.i);
    }
    localAllInOne.profileEntryType = 98;
    localAllInOne.nickname = paramSearchResultItem.c;
    localAllInOne.chatCookie = paramSearchResultItem.h;
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
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.mTvErrMsg.setVisibility(4);
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
    initParams();
    paramBundle = getActivity().getWindow();
    if ((TextUtils.isEmpty(this.mSearchKeyword)) && ((!this.mSearchTroop) || (TextUtils.isEmpty(this.mSearchTrpCode)))) {
      paramBundle.setSoftInputMode(4);
    } else {
      paramBundle.setSoftInputMode(2);
    }
    this.searchFacade = new ContactSearchFacade(this.app);
    this.searchFacade.a(this.searchListener);
    this.mIm = ((InputMethodManager)getSystemService("input_method"));
    super.setContentView(View.inflate(this, 2131624057, null));
    setContentBackgroundResource(2130838958);
    initUI();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendActivity", 2, "onDestroy");
    }
    this.searchFacade.e();
    this.searchFacade = null;
    super.doOnDestroy();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.isInitialized))
    {
      this.isInitialized = true;
      this.handler.sendEmptyMessage(1);
    }
  }
  
  public void finish()
  {
    super.finish();
    InputMethodManager localInputMethodManager = this.mIm;
    if (localInputMethodManager != null)
    {
      localInputMethodManager.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
      this.mIm = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      performAutoAction();
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131430008)
    {
      this.mTvErrMsg.setVisibility(4);
      if (!isFinishing()) {
        if (!this.mSearchTroop) {
          searchFriend();
        } else {
          searchTroop();
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
  
  void performAutoAction()
  {
    if ((!TextUtils.isEmpty(this.mSearchKeyword)) && (this.mPerformAutoAction)) {
      searchFriend();
    }
    if ((this.mSearchTroop) && (!TextUtils.isEmpty(this.mSearchTrpCode)) && (this.mPerformAutoAction)) {
      searchTroop();
    }
  }
  
  protected String setLastActivityName()
  {
    if ((this.centerView != null) && (this.centerView.getText() != null) && (this.centerView.getText().length() != 0) && (!this.isNeedFinish)) {
      return this.centerView.getText().toString();
    }
    return getString(2131887625);
  }
  
  void showErrMsg(int paramInt)
  {
    runOnUiThread(new AddFriendActivity.2(this, paramInt));
  }
  
  void showErrMsg(String paramString)
  {
    runOnUiThread(new AddFriendActivity.3(this, paramString));
  }
  
  void startResultListActivity(SearchResult paramSearchResult)
  {
    if ((paramSearchResult != null) && (paramSearchResult.e != null))
    {
      if (paramSearchResult.e.size() == 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList(paramSearchResult.e.size());
      paramSearchResult = paramSearchResult.e.iterator();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendActivity
 * JD-Core Version:    0.7.0.1
 */