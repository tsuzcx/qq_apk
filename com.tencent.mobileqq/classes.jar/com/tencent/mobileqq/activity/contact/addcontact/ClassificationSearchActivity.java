package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
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
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.biz.lebasearch.SearchProtocol.SearchObserver;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer.OnTipClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer.TipsInfo;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.XListView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wmw;
import wmx;
import wmy;
import wmz;
import wna;
import wnb;
import wnc;
import wne;
import wnf;
import wng;
import wnh;
import wni;
import wnj;
import wnk;
import wnl;
import wnm;

public class ClassificationSearchActivity
  extends SearchBaseActivity
  implements ReadInJoySearchHistoryAdapter.OnItemClickObserver
{
  public static int a;
  private static SearchResult jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult;
  public static String a;
  public static int b;
  static String jdField_b_of_type_JavaLangString = "";
  public static int c;
  static String jdField_c_of_type_JavaLangString = "";
  public static int d;
  public static int e;
  public Handler a;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new wmz(this);
  View jdField_a_of_type_AndroidViewView;
  SearchProtocol.SearchObserver jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver = new wnl(this);
  protected ReadInJoyObserver a;
  ReadInJoySearchTipsContainer.OnTipClickListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer$OnTipClickListener = new wmx(this);
  ReadInJoySearchTipsContainer jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  ReadInJoySearchTipsContainer.OnTipClickListener jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer$OnTipClickListener = new wmy(this);
  ReadInJoySearchTipsContainer jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer;
  public List b;
  View jdField_c_of_type_AndroidViewView;
  public List c;
  View d;
  View e;
  public int f;
  View f;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 3;
    jdField_d_of_type_Int = 4;
    jdField_e_of_type_Int = 5;
    jdField_a_of_type_JavaLangString = "is_from";
  }
  
  public ClassificationSearchActivity()
  {
    this.jdField_f_of_type_Int = 0;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new wnm(this);
    this.jdField_a_of_type_AndroidOsHandler = new wne(this);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, SearchResult paramSearchResult)
  {
    jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult = paramSearchResult;
    jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("last_hint");
    paramActivity.startActivityForResult(paramIntent, 1);
  }
  
  private void b(String paramString)
  {
    paramString = paramString.trim();
    try
    {
      localObject = URLEncoder.encode(paramString, "utf-8");
      paramString = (String)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject;
        continue;
        paramString = localUnsupportedEncodingException;
      }
    }
    localObject = PublicAccountConfigUtil.jdField_c_of_type_JavaLangString;
    if (localObject != null)
    {
      if (!((String)localObject).contains("keyword")) {}
    }
    else {
      for (paramString = ((String)localObject).replace("keyword", paramString);; paramString = "https://so.mp.qq.com/search/index?key=" + paramString + "&_wv=3&_bid=2321")
      {
        localObject = new Intent(this, PublicAccountBrowser.class);
        ((Intent)localObject).putExtra("url", paramString);
        startActivity((Intent)localObject);
        return;
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.isEmpty())) {}
    do
    {
      return;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer.setOnTipsClickListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer$OnTipClickListener);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ChannelInfo localChannelInfo = (ChannelInfo)localIterator.next();
        ReadInJoySearchTipsContainer.TipsInfo localTipsInfo = new ReadInJoySearchTipsContainer.TipsInfo();
        localTipsInfo.word = localChannelInfo.mChannelName;
        localTipsInfo.frameColor = localChannelInfo.mFrameColor;
        localTipsInfo.textColor = localChannelInfo.mFontColor;
        localArrayList.add(localTipsInfo);
      }
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer.a(localArrayList);
    } while (!paramBoolean);
    f();
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer.setOnTipsClickListener(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer$OnTipClickListener);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((SearchProtocol.WordItem)localIterator.next());
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer.b(localArrayList);
    } while (!paramBoolean);
    f();
  }
  
  private void e()
  {
    this.jdField_d_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130969517, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    this.jdField_d_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_d_of_type_AndroidViewView.findViewById(2131363951));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130969207, null);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer = ((ReadInJoySearchTipsContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131362733));
    if ((this.jdField_f_of_type_Int == jdField_a_of_type_Int) || (this.jdField_f_of_type_Int == jdField_d_of_type_Int)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer.setmMaxLines(-1);
    }
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365622);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365620);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer = ((ReadInJoySearchTipsContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131365619));
    this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365617);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void f()
  {
    if (((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() == 0)) && ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.isEmpty())) && ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.d();
        a(false);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(this.jdField_d_of_type_AndroidViewView);
    if ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() != 0)) {
        break label197;
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      label144:
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0)) {
        break label208;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      a(true);
      return;
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      break;
      label197:
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      break label144;
      label208:
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  protected SearchBaseFragment a()
  {
    if ((jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult == null) && ((this.jdField_f_of_type_Int == jdField_a_of_type_Int) || (this.jdField_f_of_type_Int == jdField_d_of_type_Int) || (this.jdField_f_of_type_Int == jdField_e_of_type_Int) || (this.jdField_f_of_type_Int == jdField_b_of_type_Int) || (this.jdField_f_of_type_Int == jdField_c_of_type_Int))) {
      return ClassificationSearchFragment.a(this.jdField_f_of_type_Int);
    }
    return ClassificationSearchFragment.a(jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult);
  }
  
  public void a()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    Object localObject = new wnc(this);
    localQQCustomDialog.setPositiveButton(2131430529, (DialogInterface.OnClickListener)localObject);
    localQQCustomDialog.setNegativeButton(2131430528, (DialogInterface.OnClickListener)localObject);
    localObject = getString(2131430527);
    localQQCustomDialog.setTitle(2131430486);
    TextView localTextView = new TextView(this);
    localTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(getResources().getColor(2131492879));
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
      PublicAccountReportUtils.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006819", "0X8006819", 0, 0, paramReadInJoySearchHistoryEntity.keyWord, "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(paramReadInJoySearchHistoryEntity.keyWord, false);
  }
  
  public void a(String paramString)
  {
    ThreadManager.post(new wna(this, paramString), 10, null, true);
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (paramBoolean) {
      f();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() == null)
    {
      paramList = new ReadInJoySearchHistoryAdapter(this, paramList, this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(paramList);
    }
    ReadInJoySearchHistoryAdapter localReadInJoySearchHistoryAdapter;
    do
    {
      return;
      if (!(this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() instanceof HeaderViewListAdapter)) {
        break;
      }
      localReadInJoySearchHistoryAdapter = (ReadInJoySearchHistoryAdapter)((HeaderViewListAdapter)this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter()).getWrappedAdapter();
    } while (localReadInJoySearchHistoryAdapter == null);
    localReadInJoySearchHistoryAdapter.a(paramList);
    return;
    ((ReadInJoySearchHistoryAdapter)this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter()).a(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    if (ThemeUtil.isInNightMode(this.app))
    {
      if (!paramBoolean) {
        break label89;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a.setBackgroundColor(-1);
      if (this.jdField_f_of_type_AndroidViewView != null) {
        ((ViewGroup)this.jdField_f_of_type_AndroidViewView.getParent()).removeView(this.jdField_f_of_type_AndroidViewView);
      }
      this.jdField_f_of_type_AndroidViewView = new View(this);
      this.jdField_f_of_type_AndroidViewView.setBackgroundColor(1996488704);
      addContentView(this.jdField_f_of_type_AndroidViewView, new ViewGroup.LayoutParams(-1, -1));
    }
    label89:
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a.setBackgroundColor(0);
      }
    } while (this.jdField_f_of_type_AndroidViewView == null);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
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
    String str;
    if (jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult != null)
    {
      str = "";
      switch (jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(str);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new wnf(this));
      this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new wng(this));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new wnh(this));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new wni(this));
      if (AppSetting.b) {
        this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription("搜索栏" + this.jdField_d_of_type_JavaLangString);
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new wnj(this));
      if ((this.jdField_f_of_type_Int == jdField_a_of_type_Int) || (this.jdField_f_of_type_Int == jdField_d_of_type_Int))
      {
        e();
        Looper.myQueue().addIdleHandler(new wnk(this));
      }
      return;
      str = "网络查找人";
      continue;
      str = "网络查找群";
      continue;
      if (UniteSearchActivity.jdField_d_of_type_Int == 12)
      {
        str = "网络查找" + PublicAccountConfigUtil.a(this.app, getApplicationContext());
      }
      else
      {
        str = "网络查找公众号";
        continue;
        str = "网络查找相关文章";
      }
    }
  }
  
  public void d()
  {
    ThreadManager.post(new wnb(this), 10, null, true);
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
    if (this.jdField_f_of_type_Int == jdField_a_of_type_Int)
    {
      d();
      SearchProtocol.a(this.app, this, this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver);
      ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
      if (ReadInJoyLogicEngine.a().b() == 0) {
        ReadInJoyLogicEngine.a().a(1, 1);
      }
    }
    while (this.jdField_f_of_type_Int != jdField_d_of_type_Int) {
      return bool;
    }
    a(null, true);
    SearchProtocol.a(this.app, this, this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver);
    return bool;
  }
  
  protected void doOnDestroy()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_f_of_type_Int == jdField_a_of_type_Int) || (this.jdField_f_of_type_Int == jdField_d_of_type_Int) || (this.jdField_f_of_type_Int == jdField_e_of_type_Int)) {
      ((ClassificationSearchFragment)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment).a(true);
    }
    if (((ClassificationSearchFragment)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment).a())
    {
      Looper.myQueue().addIdleHandler(new wmw(this));
      ((ClassificationSearchFragment)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment).a(false);
    }
    if (this.jdField_f_of_type_Int == jdField_a_of_type_Int)
    {
      if (TextUtils.isEmpty(jdField_c_of_type_JavaLangString)) {
        break label301;
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      f();
      if (this.jdField_f_of_type_Int == jdField_d_of_type_Int)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint("搜索相关文章");
        f();
      }
      if (this.jdField_f_of_type_Int == jdField_b_of_type_Int)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint("搜索相关文章");
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
        this.jdField_a_of_type_AndroidWidgetEditText.setHint("搜索公众号");
      }
      if (this.jdField_f_of_type_Int == jdField_e_of_type_Int)
      {
        if (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().equals("")) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.d();
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setHint("搜索公众号");
      }
      return;
      label301:
      if (!TextUtils.isEmpty(""))
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_a_of_type_AndroidWidgetEditText.setHint("");
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint("搜索相关文章");
      }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity
 * JD-Core Version:    0.7.0.1
 */