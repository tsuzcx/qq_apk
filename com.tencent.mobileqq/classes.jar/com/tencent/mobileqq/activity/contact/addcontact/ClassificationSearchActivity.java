package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.biz.lebasearch.SearchProtocol.SearchObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.search.ReadInJoySearchTipsContainer;
import com.tencent.mobileqq.kandian.biz.search.api.OnTipClickListener;
import com.tencent.mobileqq.kandian.biz.search.entity.TipsInfo;
import com.tencent.mobileqq.kandian.biz.search.entity.WordItem;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.business.addcontact.model.SearchResult;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.XListView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClassificationSearchActivity
  extends SearchBaseActivity
  implements ReadInJoySearchHistoryAdapter.OnItemClickObserver
{
  public static int a = 1;
  private static SearchResult jdField_a_of_type_ComTencentMobileqqSearchBusinessAddcontactModelSearchResult;
  public static String a = "is_from";
  public static int b = 2;
  static String jdField_b_of_type_JavaLangString = "";
  public static int c = 3;
  static String jdField_c_of_type_JavaLangString = "";
  public static int d = 4;
  public static int e = 5;
  protected Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ClassificationSearchActivity.6(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new ClassificationSearchActivity.12(this);
  View jdField_a_of_type_AndroidViewView;
  private TextView.OnEditorActionListener jdField_a_of_type_AndroidWidgetTextView$OnEditorActionListener = new ClassificationSearchActivity.7(this);
  SearchProtocol.SearchObserver jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver = new ClassificationSearchActivity.8(this);
  ReadInJoySearchTipsContainer jdField_a_of_type_ComTencentMobileqqKandianBizSearchReadInJoySearchTipsContainer;
  OnTipClickListener jdField_a_of_type_ComTencentMobileqqKandianBizSearchApiOnTipClickListener = new ClassificationSearchActivity.10(this);
  protected ReadInJoyObserver a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  List<ReadInJoySearchHistoryEntity> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  ReadInJoySearchTipsContainer jdField_b_of_type_ComTencentMobileqqKandianBizSearchReadInJoySearchTipsContainer;
  OnTipClickListener jdField_b_of_type_ComTencentMobileqqKandianBizSearchApiOnTipClickListener = new ClassificationSearchActivity.11(this);
  List<WordItem> jdField_b_of_type_JavaUtilList = new ArrayList();
  View jdField_c_of_type_AndroidViewView;
  List<ChannelInfo> jdField_c_of_type_JavaUtilList = new ArrayList();
  View d;
  View e;
  int jdField_f_of_type_Int = 0;
  View jdField_f_of_type_AndroidViewView;
  
  public ClassificationSearchActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ClassificationSearchActivity.9(this);
    this.jdField_a_of_type_AndroidOsHandler = new ClassificationSearchActivity.16(this);
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 80000003: 
      return HardCodeUtil.a(2131702122);
    case 80000002: 
      if (UniteSearchActivity.jdField_d_of_type_Int == 12)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131702123));
        localStringBuilder.append(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, getApplicationContext()));
        return localStringBuilder.toString();
      }
      return HardCodeUtil.a(2131702130);
    case 80000001: 
      return HardCodeUtil.a(2131702126);
    }
    return HardCodeUtil.a(2131702120);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, SearchResult paramSearchResult)
  {
    jdField_a_of_type_ComTencentMobileqqSearchBusinessAddcontactModelSearchResult = paramSearchResult;
    jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("last_hint");
    paramActivity.startActivityForResult(paramIntent, 1);
  }
  
  private void b(String paramString)
  {
    Object localObject = paramString.trim();
    try
    {
      paramString = URLEncoder.encode((String)localObject, "utf-8");
      localObject = paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      label14:
      String str;
      break label14;
    }
    str = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getReadinjoySearchUrl();
    if (str != null)
    {
      paramString = str;
      if (str.contains("keyword")) {
        paramString = str.replace("keyword", (CharSequence)localObject);
      }
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("https://so.mp.qq.com/search/index?key=");
      paramString.append((String)localObject);
      paramString.append("&_wv=3&_bid=2321");
      paramString = paramString.toString();
    }
    localObject = new ActivityURIRequest(this, "/pubaccount/browser");
    ((ActivityURIRequest)localObject).extra().putString("url", paramString);
    QRoute.startUri((URIRequest)localObject, null);
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = this.jdField_c_of_type_JavaUtilList;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return;
      }
      this.jdField_b_of_type_ComTencentMobileqqKandianBizSearchReadInJoySearchTipsContainer.setOnTipsClickListener(this.jdField_a_of_type_ComTencentMobileqqKandianBizSearchApiOnTipClickListener);
      localObject = new ArrayList();
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ChannelInfo localChannelInfo = (ChannelInfo)localIterator.next();
        TipsInfo localTipsInfo = new TipsInfo();
        localTipsInfo.word = localChannelInfo.mChannelName;
        localTipsInfo.frameColor = localChannelInfo.mFrameColor;
        localTipsInfo.textColor = localChannelInfo.mFontColor;
        ((List)localObject).add(localTipsInfo);
      }
      this.jdField_b_of_type_ComTencentMobileqqKandianBizSearchReadInJoySearchTipsContainer.a((List)localObject);
      if (paramBoolean) {
        f();
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizSearchReadInJoySearchTipsContainer.setOnTipsClickListener(this.jdField_b_of_type_ComTencentMobileqqKandianBizSearchApiOnTipClickListener);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((WordItem)localIterator.next());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizSearchReadInJoySearchTipsContainer.b(localArrayList);
    if (paramBoolean) {
      f();
    }
  }
  
  private void e()
  {
    this.jdField_d_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131559969, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    this.jdField_d_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_d_of_type_AndroidViewView.findViewById(2131377060));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131559603, null);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizSearchReadInJoySearchTipsContainer = ((ReadInJoySearchTipsContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131378745));
    int i = this.jdField_f_of_type_Int;
    if ((i == jdField_a_of_type_Int) || (i == jdField_d_of_type_Int)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizSearchReadInJoySearchTipsContainer.setMaxLines(-1);
    }
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377061);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131378762);
    this.jdField_b_of_type_ComTencentMobileqqKandianBizSearchReadInJoySearchTipsContainer = ((ReadInJoySearchTipsContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131364462));
    this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364461);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void f()
  {
    List localList = this.jdField_b_of_type_JavaUtilList;
    if ((localList == null) || (localList.size() == 0))
    {
      localList = this.jdField_c_of_type_JavaUtilList;
      if ((localList == null) || (localList.isEmpty()))
      {
        localList = this.jdField_a_of_type_JavaUtilList;
        if ((localList == null) || (localList.size() == 0)) {
          break label205;
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(this.jdField_d_of_type_AndroidViewView);
    localList = this.jdField_c_of_type_JavaUtilList;
    if ((localList != null) && (!localList.isEmpty())) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    } else {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    localList = this.jdField_b_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() != 0)) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    } else {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() != 0)) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    } else {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
    a(true);
    return;
    label205:
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.d();
      a(false);
    }
  }
  
  protected SearchBaseFragment a()
  {
    if (jdField_a_of_type_ComTencentMobileqqSearchBusinessAddcontactModelSearchResult == null)
    {
      int i = this.jdField_f_of_type_Int;
      if ((i == jdField_a_of_type_Int) || (i == jdField_d_of_type_Int) || (i == jdField_e_of_type_Int) || (i == jdField_b_of_type_Int) || (i == jdField_c_of_type_Int)) {
        return ClassificationSearchFragment.a(this.jdField_f_of_type_Int);
      }
    }
    return ClassificationSearchFragment.a(jdField_a_of_type_ComTencentMobileqqSearchBusinessAddcontactModelSearchResult);
  }
  
  public void a()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    Object localObject = new ClassificationSearchActivity.15(this);
    localQQCustomDialog.setPositiveButton(2131696022, (DialogInterface.OnClickListener)localObject);
    localQQCustomDialog.setNegativeButton(2131696021, (DialogInterface.OnClickListener)localObject);
    localObject = getString(2131696023);
    localQQCustomDialog.setTitle(2131697265);
    TextView localTextView = new TextView(this);
    localTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(getResources().getColor(2131165473));
    localTextView.setText((CharSequence)localObject);
    localTextView.setGravity(1);
    localQQCustomDialog.addView(localTextView);
    localQQCustomDialog.show();
  }
  
  public void a(ReadInJoySearchHistoryEntity paramReadInJoySearchHistoryEntity)
  {
    if (this.jdField_f_of_type_Int == jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramReadInJoySearchHistoryEntity.keyWord);
      if (!TextUtils.isEmpty(paramReadInJoySearchHistoryEntity.keyWord)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
      }
      b(paramReadInJoySearchHistoryEntity.keyWord);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006819", "0X8006819", 0, 0, paramReadInJoySearchHistoryEntity.keyWord, "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(paramReadInJoySearchHistoryEntity.keyWord, false);
  }
  
  public void a(String paramString)
  {
    ThreadManager.post(new ClassificationSearchActivity.13(this, paramString), 10, null, true);
  }
  
  protected void a(List<ReadInJoySearchHistoryEntity> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (paramBoolean) {
      f();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() == null)
    {
      paramList = new ReadInJoySearchHistoryAdapter(this, paramList, this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(paramList);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() instanceof HeaderViewListAdapter))
    {
      ReadInJoySearchHistoryAdapter localReadInJoySearchHistoryAdapter = (ReadInJoySearchHistoryAdapter)((HeaderViewListAdapter)this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter()).getWrappedAdapter();
      if (localReadInJoySearchHistoryAdapter != null) {
        localReadInJoySearchHistoryAdapter.a(paramList);
      }
    }
    else
    {
      ((ReadInJoySearchHistoryAdapter)this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter()).a(paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (ThemeUtil.isInNightMode(this.app))
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a.setBackgroundColor(-1);
        localView = this.jdField_f_of_type_AndroidViewView;
        if (localView != null) {
          ((ViewGroup)localView.getParent()).removeView(this.jdField_f_of_type_AndroidViewView);
        }
        this.jdField_f_of_type_AndroidViewView = new View(this);
        this.jdField_f_of_type_AndroidViewView.setBackgroundColor(1996488704);
        addContentView(this.jdField_f_of_type_AndroidViewView, new ViewGroup.LayoutParams(-1, -1));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a.setBackgroundColor(0);
      }
      View localView = this.jdField_f_of_type_AndroidViewView;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
  }
  
  protected void b()
  {
    super.b();
    Intent localIntent = getIntent();
    if (localIntent.hasExtra(jdField_a_of_type_JavaLangString)) {
      this.jdField_f_of_type_Int = localIntent.getIntExtra(jdField_a_of_type_JavaLangString, 0);
    }
  }
  
  protected void c()
  {
    super.c();
    Object localObject = jdField_a_of_type_ComTencentMobileqqSearchBusinessAddcontactModelSearchResult;
    if (localObject != null)
    {
      localObject = a(((SearchResult)localObject).jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetEditText.setHint((CharSequence)localObject);
    }
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ClassificationSearchActivity.2(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(this.jdField_a_of_type_AndroidWidgetTextView$OnEditorActionListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ClassificationSearchActivity.3(this));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (AppSetting.d)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetEditText;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131702127));
      localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
      ((EditText)localObject).setContentDescription(localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new ClassificationSearchActivity.4(this));
    int i = this.jdField_f_of_type_Int;
    if ((i == jdField_a_of_type_Int) || (i == jdField_d_of_type_Int))
    {
      e();
      Looper.myQueue().addIdleHandler(new ClassificationSearchActivity.5(this));
    }
  }
  
  public void d()
  {
    ThreadManager.post(new ClassificationSearchActivity.14(this), 10, null, true);
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
    boolean bool = super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_d_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    }
    this.jdField_a_of_type_Boolean = true;
    int i = this.jdField_f_of_type_Int;
    if (i == jdField_a_of_type_Int)
    {
      d();
      SearchProtocol.a(this.app, this, this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver);
      ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
      if (((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().b() == 0)
      {
        ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a(1, 1);
        return bool;
      }
    }
    else if (i == jdField_d_of_type_Int)
    {
      a(null, true);
      SearchProtocol.a(this.app, this, this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver);
    }
    return bool;
  }
  
  protected void doOnDestroy()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    int i = this.jdField_f_of_type_Int;
    if ((i == jdField_a_of_type_Int) || (i == jdField_d_of_type_Int) || (i == jdField_e_of_type_Int)) {
      ((ClassificationSearchFragment)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment).a(true);
    }
    if (((ClassificationSearchFragment)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment).a())
    {
      Looper.myQueue().addIdleHandler(new ClassificationSearchActivity.1(this));
      ((ClassificationSearchFragment)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment).a(false);
    }
    if (this.jdField_f_of_type_Int == jdField_a_of_type_Int)
    {
      if (!TextUtils.isEmpty(jdField_c_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(jdField_c_of_type_JavaLangString);
      }
      else if (!TextUtils.isEmpty(""))
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_a_of_type_AndroidWidgetEditText.setHint("");
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(HardCodeUtil.a(2131702134));
      }
      f();
    }
    if (this.jdField_f_of_type_Int == jdField_d_of_type_Int)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(HardCodeUtil.a(2131702125));
      f();
    }
    if (this.jdField_f_of_type_Int == jdField_b_of_type_Int)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(HardCodeUtil.a(2131702116));
      f();
      if ((!TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(jdField_b_of_type_JavaLangString, false);
      }
    }
    if (this.jdField_f_of_type_Int == jdField_c_of_type_Int)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().equals("")) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.d();
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(HardCodeUtil.a(2131702117));
    }
    if (this.jdField_f_of_type_Int == jdField_e_of_type_Int)
    {
      if (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().equals("")) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.d();
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(HardCodeUtil.a(2131702121));
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (((ClassificationSearchFragment)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment).a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.d();
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity
 * JD-Core Version:    0.7.0.1
 */