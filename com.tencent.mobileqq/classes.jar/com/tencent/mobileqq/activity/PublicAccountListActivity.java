package com.tencent.mobileqq.activity;

import Override;
import aenz;
import aeoa;
import aeob;
import aeoc;
import aeod;
import aeoe;
import aeof;
import aeog;
import aeoh;
import aeoi;
import aeoj;
import aeok;
import aeol;
import aeom;
import aeon;
import aeoo;
import aeoq;
import aeor;
import aeos;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anvi;
import anvx;
import aoan;
import aoav;
import ayqy;
import bbbq;
import bhfm;
import bipq;
import bkyc;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import olh;

public class PublicAccountListActivity
  extends BaseActivity
  implements bipq, ThreadExcutor.IThreadListener
{
  aeoo jdField_a_of_type_Aeoo = null;
  aeoq jdField_a_of_type_Aeoq;
  aeor jdField_a_of_type_Aeor = new aeor(this);
  public Dialog a;
  public Drawable a;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aenz(this);
  public LayoutInflater a;
  public View.OnClickListener a;
  public View a;
  public EditText a;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  public LinearLayout a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private anvi jdField_a_of_type_Anvi = new aeob(this);
  aoan jdField_a_of_type_Aoan;
  private aoav jdField_a_of_type_Aoav = new aeoc(this);
  private ayqy jdField_a_of_type_Ayqy = new aeod(this);
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  public PinnedDividerListView a;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new aeoe(this);
  public XListView a;
  Runnable jdField_a_of_type_JavaLangRunnable = new PublicAccountListActivity.2(this);
  private Comparator<aeon> jdField_a_of_type_JavaUtilComparator = new aeog(this);
  List<aeon> jdField_a_of_type_JavaUtilList = new ArrayList();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public boolean a;
  View jdField_b_of_type_AndroidViewView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public List<aeon> b;
  private boolean jdField_b_of_type_Boolean;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public View d;
  TextView d;
  View e;
  View f;
  View g;
  
  public PublicAccountListActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aeof(this);
  }
  
  private aeon a(PublicAccountInfo paramPublicAccountInfo)
  {
    aeon localaeon = new aeon(paramPublicAccountInfo);
    localaeon.a(ChnToSpell.a(paramPublicAccountInfo.name, 2));
    localaeon.b(ChnToSpell.a(paramPublicAccountInfo.name, 1));
    return localaeon;
  }
  
  private boolean a(aeon paramaeon)
  {
    if ((paramaeon != null) && (paramaeon.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo == null)) {}
    return false;
  }
  
  @TargetApi(14)
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131373324));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131379020);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369278));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369231));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369262));
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.e = super.findViewById(2131365191);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)super.findViewById(2131373321));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)super.findViewById(2131368807));
    this.f = super.findViewById(2131373254);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694937);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131694948);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131689550);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b(53).e(5).d(5).a();
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (AppSetting.c)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText() + anvx.a(2131708223));
    }
  }
  
  private void f()
  {
    View localView = super.getLayoutInflater().inflate(2131559661, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131377155));
    ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366280)).setOnTouchListener(new aeoh(this));
    ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363845)).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(localView);
    this.jdField_a_of_type_Aeoo = new aeoo(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Aeoo);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    g();
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
    this.jdField_a_of_type_AndroidAppDialog.getWindow().setSoftInputMode(36);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559668);
    Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = 0;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject).gravity = 51;
    this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject = (InputMethodManager)super.getSystemService("input_method");
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131377153));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130838911));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559667, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_d_of_type_AndroidViewView);
    this.jdField_d_of_type_AndroidViewView.setTag("");
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Aeoq = new aeoq(this, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aeoq);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new aeol(this, (InputMethodManager)localObject));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131376947);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131366280));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new aeos(this));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131368378));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new aeom(this));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131376602));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aeoa(this));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131368211);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365538));
    ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131377214)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void h()
  {
    if (this.g == null)
    {
      ViewStub localViewStub = (ViewStub)super.findViewById(2131366179);
      if (localViewStub == null) {
        return;
      }
      this.g = localViewStub.inflate();
      this.g.findViewById(2131377214).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    this.g.setVisibility(0);
    this.e.setVisibility(8);
  }
  
  private void i()
  {
    if (this.g != null) {
      this.g.setVisibility(8);
    }
    this.e.setVisibility(0);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      bbbq localbbbq = (bbbq)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localbbbq.a("101000.101001");
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1)) {
        olh.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X80060E2", "0X80060E2", 0, 0, "", "", "", "", false);
      }
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      localbbbq.a(localAppInfo);
    }
  }
  
  public void a()
  {
    Object localObject = (InputMethodManager)super.getSystemService("input_method");
    int i = this.jdField_a_of_type_AndroidViewView.getHeight();
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
    localTranslateAnimation1.setDuration(300L);
    localTranslateAnimation1.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation1);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
    localTranslateAnimation2.setDuration(300L);
    localTranslateAnimation1.setAnimationListener(new aeoi(this, localTranslateAnimation1, localTranslateAnimation2, i));
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new aeoj(this, i, localTranslateAnimation2, (InputMethodManager)localObject));
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    localObject = (Button)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363845);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new aeok(this));
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Aeoq.notifyDataSetChanged();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Aeoo.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
  }
  
  protected void b()
  {
    Object localObject = (ViewGroup)super.findViewById(2131376760);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = super.findViewById(2131379020);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)super.findViewById(2131369231);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  public void b(String paramString)
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_AndroidViewView.getLayoutParams().height = -1;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Aeoq.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    paramString = paramString.toLowerCase();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      aeon localaeon = (aeon)localIterator.next();
      String str = localaeon.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.displayNumber;
      if ((str != null) && (str.equalsIgnoreCase(paramString)))
      {
        localArrayList4.add(localaeon);
      }
      else
      {
        str = localaeon.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name.toLowerCase();
        if ((str.equals(paramString)) || (localaeon.b.equals(paramString)) || (localaeon.jdField_a_of_type_JavaLangString.equals(paramString))) {
          localArrayList1.add(localaeon);
        } else if ((str.indexOf(paramString) == 0) || (localaeon.b.indexOf(paramString) == 0) || (localaeon.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0)) {
          localArrayList2.add(localaeon);
        } else if ((str.indexOf(paramString) > 0) || (localaeon.b.indexOf(paramString) > 0) || (localaeon.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0)) {
          localArrayList3.add(localaeon);
        }
      }
    }
    Collections.sort(localArrayList4, this.jdField_a_of_type_Aeor);
    Collections.sort(localArrayList1, this.jdField_a_of_type_Aeor);
    Collections.sort(localArrayList2, this.jdField_a_of_type_Aeor);
    Collections.sort(localArrayList3, this.jdField_a_of_type_Aeor);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList4);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList1);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList3);
    if (this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131694957, new Object[] { paramString }));
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidViewView.setTag(paramString);
      this.jdField_a_of_type_Aeoq.notifyDataSetChanged();
      long l2 = System.currentTimeMillis();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("PublicAccountListActivity", 2, "refreshSearchResultList:" + paramString + "," + (l2 - l1) + "," + this.jdField_a_of_type_JavaUtilList.size() + "," + this.jdField_b_of_type_JavaUtilList.size());
      return;
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    ArrayList localArrayList = this.jdField_a_of_type_Aoan.b();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      i();
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext()) {
        this.jdField_b_of_type_JavaUtilList.add(a((PublicAccountInfo)localIterator.next()));
      }
      if (localArrayList.size() < 15) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aeoo.a();
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      continue;
      h();
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Aoan = ((aoan)this.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER));
    super.setContentView(2131559660);
    this.jdField_a_of_type_AndroidViewLayoutInflater = super.getLayoutInflater();
    d();
    e();
    f();
    if (this.jdField_a_of_type_Aoan.jdField_a_of_type_Boolean) {
      c();
    }
    for (;;)
    {
      b();
      super.addObserver(this.jdField_a_of_type_Aoav);
      super.addObserver(this.jdField_a_of_type_Anvi);
      this.app.registObserver(this.jdField_a_of_type_Ayqy);
      this.jdField_a_of_type_MqqOsMqqHandler = new bkyc(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
      this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      return true;
      ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, this, true);
    }
  }
  
  public void doOnDestroy()
  {
    super.removeObserver(this.jdField_a_of_type_Aoav);
    super.removeObserver(this.jdField_a_of_type_Anvi);
    if (this.jdField_a_of_type_Aeoo != null) {
      this.jdField_a_of_type_Aeoo.c();
    }
    if (this.jdField_a_of_type_Aeoq != null) {
      this.jdField_a_of_type_Aeoq.c();
    }
    super.doOnDestroy();
    this.app.unRegistObserver(this.jdField_a_of_type_Ayqy);
    this.app.removeHandler(getClass());
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_b_of_type_Boolean = true;
    try
    {
      getWindow().setSoftInputMode(48);
      label18:
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.destroyDrawingCache();
        this.jdField_a_of_type_AndroidViewView.requestLayout();
        this.jdField_a_of_type_AndroidViewView.invalidate();
      }
      j();
      return;
    }
    catch (Exception localException)
    {
      break label18;
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    getWindow().setSoftInputMode(16);
  }
  
  public void onAdded() {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onPostRun()
  {
    runOnUiThread(new PublicAccountListActivity.3(this));
  }
  
  public void onPreRun() {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      bhfm.a("pubAcc_follow_list_display", null, "");
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountListActivity
 * JD-Core Version:    0.7.0.1
 */