package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.view.LayoutInflater;
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
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import thh;
import thi;
import thj;
import thk;
import thl;
import thm;
import thn;
import tho;
import thp;
import thq;
import thr;
import ths;
import tht;
import thu;
import thv;
import thw;
import thx;

public class PublicAccountListActivity
  extends BaseActivity
  implements ThreadExcutor.IThreadListener, IndexView.OnIndexChangedListener
{
  public Dialog a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new thh(this);
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new thn(this);
  public View a;
  public EditText a;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  public LinearLayout a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  PublicAccountListActivity.ListAdapter jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$ListAdapter = null;
  PublicAccountListActivity.SearchResultAdapter jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultAdapter;
  PublicAccountListActivity.SearchResultComparator jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultComparator = new PublicAccountListActivity.SearchResultComparator(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new thj(this);
  public PublicAccountDataManager a;
  private PublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new thk(this);
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new thl(this);
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new thm(this);
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  Runnable jdField_a_of_type_JavaLangRunnable = new thp(this);
  private Comparator jdField_a_of_type_JavaUtilComparator = new tho(this);
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public boolean a;
  View jdField_b_of_type_AndroidViewView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  List jdField_b_of_type_JavaUtilList = new ArrayList();
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
  }
  
  private thx a(PublicAccountInfo paramPublicAccountInfo)
  {
    thx localthx = new thx(paramPublicAccountInfo);
    localthx.a(ChnToSpell.a(paramPublicAccountInfo.name, 2));
    localthx.b(ChnToSpell.a(paramPublicAccountInfo.name, 1));
    return localthx;
  }
  
  private boolean a(thx paramthx)
  {
    if ((paramthx != null) && (paramthx.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo == null)) {}
    return false;
  }
  
  @TargetApi(14)
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131365655));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131362594);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363381));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363245));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363428));
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.e = super.findViewById(2131363828);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)super.findViewById(2131363829));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)super.findViewById(2131363830));
    this.f = super.findViewById(2131365656);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131437771);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131437770);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131434478);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(53).d(5).c(5).a();
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (AppSetting.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText() + "返回按钮");
    }
  }
  
  private void h()
  {
    View localView = super.getLayoutInflater().inflate(2130969219, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131365657));
    ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368322)).setOnTouchListener(new thr(this));
    ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368321)).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(localView);
    this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$ListAdapter = new PublicAccountListActivity.ListAdapter(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$ListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    i();
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
    this.jdField_a_of_type_AndroidAppDialog.getWindow().setSoftInputMode(36);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130969226);
    Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = 0;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject).gravity = 51;
    this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject = (InputMethodManager)super.getSystemService("input_method");
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365669));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130838214));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969225, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_d_of_type_AndroidViewView);
    this.jdField_d_of_type_AndroidViewView.setTag("");
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultAdapter = new PublicAccountListActivity.SearchResultAdapter(this, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new thv(this, (InputMethodManager)localObject));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131362840);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131368322));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new PublicAccountListActivity.SearchTextWatcher(this));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131368323));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new thw(this));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363923));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new thi(this));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365658);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365659));
    ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131365660)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void j()
  {
    if (this.g == null)
    {
      ViewStub localViewStub = (ViewStub)super.findViewById(2131363116);
      if (localViewStub == null) {
        return;
      }
      this.g = localViewStub.inflate();
      this.g.findViewById(2131365660).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    this.g.setVisibility(0);
    this.e.setVisibility(8);
  }
  
  private void k()
  {
    if (this.g != null) {
      this.g.setVisibility(8);
    }
    this.e.setVisibility(0);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(35);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a("101000.101001");
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1)) {
        PublicAccountReportUtils.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X80060E2", "0X80060E2", 0, 0, "", "", "", "", false);
      }
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      localRedTouchManager.a(localAppInfo);
    }
  }
  
  public void a() {}
  
  protected void a(String paramString)
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_AndroidViewView.getLayoutParams().height = -1;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultAdapter.notifyDataSetChanged();
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
      thx localthx = (thx)localIterator.next();
      String str = localthx.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.displayNumber;
      if ((str != null) && (str.equalsIgnoreCase(paramString)))
      {
        localArrayList4.add(localthx);
      }
      else
      {
        str = localthx.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name.toLowerCase();
        if ((str.equals(paramString)) || (localthx.b.equals(paramString)) || (localthx.jdField_a_of_type_JavaLangString.equals(paramString))) {
          localArrayList1.add(localthx);
        } else if ((str.indexOf(paramString) == 0) || (localthx.b.indexOf(paramString) == 0) || (localthx.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0)) {
          localArrayList2.add(localthx);
        } else if ((str.indexOf(paramString) > 0) || (localthx.b.indexOf(paramString) > 0) || (localthx.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0)) {
          localArrayList3.add(localthx);
        }
      }
    }
    Collections.sort(localArrayList4, this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultComparator);
    Collections.sort(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultComparator);
    Collections.sort(localArrayList2, this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultComparator);
    Collections.sort(localArrayList3, this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultComparator);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList4);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList1);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList3);
    if (this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131430103, new Object[] { paramString }));
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidViewView.setTag(paramString);
      this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultAdapter.notifyDataSetChanged();
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
  
  public void b()
  {
    runOnUiThread(new thq(this));
  }
  
  public void b(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$ListAdapter.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
  }
  
  public void c()
  {
    Object localObject = (InputMethodManager)super.getSystemService("input_method");
    int i = this.jdField_a_of_type_AndroidViewView.getHeight();
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
    localTranslateAnimation1.setDuration(300L);
    localTranslateAnimation1.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation1);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
    localTranslateAnimation2.setDuration(300L);
    localTranslateAnimation1.setAnimationListener(new ths(this, localTranslateAnimation1, localTranslateAnimation2, i));
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new tht(this, i, localTranslateAnimation2, (InputMethodManager)localObject));
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    localObject = (Button)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131368321);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new thu(this));
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void d()
  {
    Object localObject = (ViewGroup)super.findViewById(2131363244);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = super.findViewById(2131362594);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)super.findViewById(2131363245);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager = ((PublicAccountDataManager)this.app.getManager(55));
    super.setContentView(2130969218);
    this.jdField_a_of_type_AndroidViewLayoutInflater = super.getLayoutInflater();
    f();
    g();
    h();
    if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager.jdField_a_of_type_Boolean) {
      e();
    }
    for (;;)
    {
      d();
      super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
      super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
      this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      return true;
      ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, this, true);
    }
  }
  
  protected void doOnDestroy()
  {
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$ListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$ListAdapter.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultAdapter.X_();
    }
    super.doOnDestroy();
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.app.removeHandler(getClass());
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected void doOnResume()
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
      l();
      return;
    }
    catch (Exception localException)
    {
      break label18;
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    getWindow().setSoftInputMode(16);
  }
  
  public void e()
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager.b();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      k();
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
      this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$ListAdapter.a();
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      continue;
      j();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      PAStartupTracker.a("pubAcc_follow_list_display", null, "");
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountListActivity
 * JD-Core Version:    0.7.0.1
 */