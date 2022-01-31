package com.tencent.mobileqq.activity.contact.addcontact;

import ahbv;
import ahbw;
import ahbx;
import ahby;
import ahbz;
import ahca;
import ahcb;
import ahcc;
import ahcd;
import ahce;
import ahcf;
import ahcg;
import ahch;
import ahci;
import ahcz;
import ahda;
import ahea;
import alpo;
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
import bdcd;
import bdfq;
import bhtf;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer.TipsInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.XListView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nfu;
import nrt;
import owy;
import oxb;
import oxe;
import ruy;
import swy;

public class ClassificationSearchActivity
  extends SearchBaseActivity
  implements ahda
{
  public static int a;
  private static ahea jdField_a_of_type_Ahea;
  public static String a;
  public static int b;
  static String jdField_b_of_type_JavaLangString = "";
  public static int c;
  static String jdField_c_of_type_JavaLangString = "";
  public static int d;
  public static int e;
  protected Handler a;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new ahby(this);
  View jdField_a_of_type_AndroidViewView;
  ReadInJoySearchTipsContainer jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  List<ReadInJoySearchHistoryEntity> jdField_a_of_type_JavaUtilList = new ArrayList();
  nfu jdField_a_of_type_Nfu = new ahch(this);
  protected oxe a;
  ruy jdField_a_of_type_Ruy = new ahbw(this);
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  ReadInJoySearchTipsContainer jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer;
  public List<SearchProtocol.WordItem> b;
  ruy jdField_b_of_type_Ruy = new ahbx(this);
  View jdField_c_of_type_AndroidViewView;
  public List<ChannelInfo> c;
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
    this.jdField_a_of_type_Oxe = new ahci(this);
    this.jdField_a_of_type_AndroidOsHandler = new ahca(this);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, ahea paramahea)
  {
    jdField_a_of_type_Ahea = paramahea;
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
    localObject = swy.jdField_c_of_type_JavaLangString;
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
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer.setOnTipsClickListener(this.jdField_a_of_type_Ruy);
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer.setOnTipsClickListener(this.jdField_b_of_type_Ruy);
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
    this.jdField_d_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131559832, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    this.jdField_d_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_d_of_type_AndroidViewView.findViewById(2131376207));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131559478, null);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer = ((ReadInJoySearchTipsContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131377844));
    if ((this.jdField_f_of_type_Int == jdField_a_of_type_Int) || (this.jdField_f_of_type_Int == jdField_d_of_type_Int)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer.setmMaxLines(-1);
    }
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131376209);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377863);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer = ((ReadInJoySearchTipsContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131364112));
    this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364111);
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
    if ((jdField_a_of_type_Ahea == null) && ((this.jdField_f_of_type_Int == jdField_a_of_type_Int) || (this.jdField_f_of_type_Int == jdField_d_of_type_Int) || (this.jdField_f_of_type_Int == jdField_e_of_type_Int) || (this.jdField_f_of_type_Int == jdField_b_of_type_Int) || (this.jdField_f_of_type_Int == jdField_c_of_type_Int))) {
      return ClassificationSearchFragment.a(this.jdField_f_of_type_Int);
    }
    return ClassificationSearchFragment.a(jdField_a_of_type_Ahea);
  }
  
  public void a()
  {
    bdfq localbdfq = bdcd.a(this, 230);
    Object localObject = new ahbz(this);
    localbdfq.setPositiveButton(2131696446, (DialogInterface.OnClickListener)localObject);
    localbdfq.setNegativeButton(2131696445, (DialogInterface.OnClickListener)localObject);
    localObject = getString(2131696447);
    localbdfq.setTitle(2131697697);
    TextView localTextView = new TextView(this);
    localTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(getResources().getColor(2131165448));
    localTextView.setText((CharSequence)localObject);
    localTextView.setGravity(1);
    localbdfq.addView(localTextView);
    localbdfq.show();
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
      nrt.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006819", "0X8006819", 0, 0, paramReadInJoySearchHistoryEntity.keyWord, "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(paramReadInJoySearchHistoryEntity.keyWord, false);
  }
  
  public void a(String paramString)
  {
    ThreadManager.post(new ClassificationSearchActivity.13(this, paramString), 10, null, true);
  }
  
  public void a(List<ReadInJoySearchHistoryEntity> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (paramBoolean) {
      f();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() == null)
    {
      paramList = new ahcz(this, paramList, this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(paramList);
    }
    ahcz localahcz;
    do
    {
      return;
      if (!(this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() instanceof bhtf)) {
        break;
      }
      localahcz = (ahcz)((bhtf)this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter()).getWrappedAdapter();
    } while (localahcz == null);
    localahcz.a(paramList);
    return;
    ((ahcz)this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter()).a(paramList);
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
    if (jdField_a_of_type_Ahea != null)
    {
      str = "";
      switch (jdField_a_of_type_Ahea.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(str);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ahcb(this));
      this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new ahcc(this));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ahcd(this));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ahce(this));
      if (AppSetting.c) {
        this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(alpo.a(2131702307) + this.jdField_d_of_type_JavaLangString);
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new ahcf(this));
      if ((this.jdField_f_of_type_Int == jdField_a_of_type_Int) || (this.jdField_f_of_type_Int == jdField_d_of_type_Int))
      {
        e();
        Looper.myQueue().addIdleHandler(new ahcg(this));
      }
      return;
      str = alpo.a(2131702300);
      continue;
      str = alpo.a(2131702306);
      continue;
      if (UniteSearchActivity.jdField_d_of_type_Int == 12)
      {
        str = alpo.a(2131702303) + swy.a(this.app, getApplicationContext());
      }
      else
      {
        str = alpo.a(2131702310);
        continue;
        str = alpo.a(2131702302);
      }
    }
  }
  
  public void d()
  {
    ThreadManager.post(new ClassificationSearchActivity.14(this), 10, null, true);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
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
      SearchProtocol.a(this.app, this, this.jdField_a_of_type_Nfu);
      oxb.a().a(this.jdField_a_of_type_Oxe);
      if (owy.a().b() == 0) {
        owy.a().a(1, 1);
      }
    }
    while (this.jdField_f_of_type_Int != jdField_d_of_type_Int) {
      return bool;
    }
    a(null, true);
    SearchProtocol.a(this.app, this, this.jdField_a_of_type_Nfu);
    return bool;
  }
  
  public void doOnDestroy()
  {
    oxb.a().b(this.jdField_a_of_type_Oxe);
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_f_of_type_Int == jdField_a_of_type_Int) || (this.jdField_f_of_type_Int == jdField_d_of_type_Int) || (this.jdField_f_of_type_Int == jdField_e_of_type_Int)) {
      ((ClassificationSearchFragment)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment).a(true);
    }
    if (((ClassificationSearchFragment)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment).a())
    {
      Looper.myQueue().addIdleHandler(new ahbv(this));
      ((ClassificationSearchFragment)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment).a(false);
    }
    if (this.jdField_f_of_type_Int == jdField_a_of_type_Int)
    {
      if (TextUtils.isEmpty(jdField_c_of_type_JavaLangString)) {
        break label313;
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      f();
      if (this.jdField_f_of_type_Int == jdField_d_of_type_Int)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(alpo.a(2131702305));
        f();
      }
      if (this.jdField_f_of_type_Int == jdField_b_of_type_Int)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(alpo.a(2131702296));
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
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(alpo.a(2131702297));
      }
      if (this.jdField_f_of_type_Int == jdField_e_of_type_Int)
      {
        if (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().equals("")) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.d();
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(alpo.a(2131702301));
      }
      return;
      label313:
      if (!TextUtils.isEmpty(""))
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_a_of_type_AndroidWidgetEditText.setHint("");
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(alpo.a(2131702314));
      }
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (((ClassificationSearchFragment)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment).a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.d();
    }
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity
 * JD-Core Version:    0.7.0.1
 */