package com.tencent.mobileqq.activity;

import absu;
import absv;
import absw;
import absx;
import absy;
import absz;
import abta;
import abtb;
import abtc;
import abtd;
import abte;
import abtf;
import abtg;
import abth;
import abti;
import abtj;
import abtl;
import abtm;
import abtn;
import ajxj;
import ajya;
import akdh;
import akdn;
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
import atzn;
import avps;
import bbfq;
import bcnf;
import bfnk;
import bfpt;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
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
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import nol;

public class PublicAccountListActivity
  extends BaseActivity
  implements bcnf, ThreadExcutor.IThreadListener
{
  abtj jdField_a_of_type_Abtj = null;
  abtl jdField_a_of_type_Abtl;
  abtm jdField_a_of_type_Abtm = new abtm(this);
  private ajxj jdField_a_of_type_Ajxj = new absw(this);
  akdh jdField_a_of_type_Akdh;
  private akdn jdField_a_of_type_Akdn = new absx(this);
  public Dialog a;
  public Drawable a;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new absu(this);
  public LayoutInflater a;
  public View.OnClickListener a;
  public View a;
  public EditText a;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  public LinearLayout a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private atzn jdField_a_of_type_Atzn = new absy(this);
  private bfpt jdField_a_of_type_Bfpt = new absz(this);
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  public PinnedDividerListView a;
  public XListView a;
  Runnable jdField_a_of_type_JavaLangRunnable = new PublicAccountListActivity.2(this);
  private Comparator<abti> jdField_a_of_type_JavaUtilComparator = new abtb(this);
  List<abti> jdField_a_of_type_JavaUtilList = new ArrayList();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public boolean a;
  View jdField_b_of_type_AndroidViewView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public List<abti> b;
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
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new abta(this);
  }
  
  private abti a(PublicAccountInfo paramPublicAccountInfo)
  {
    abti localabti = new abti(paramPublicAccountInfo);
    localabti.a(ChnToSpell.a(paramPublicAccountInfo.name, 2));
    localabti.b(ChnToSpell.a(paramPublicAccountInfo.name, 1));
    return localabti;
  }
  
  private boolean a(abti paramabti)
  {
    if ((paramabti != null) && (paramabti.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo == null)) {}
    return false;
  }
  
  @TargetApi(14)
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131372103));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131377369);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368472));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368429));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368457));
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.e = super.findViewById(2131364721);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)super.findViewById(2131372100));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)super.findViewById(2131368074));
    this.f = super.findViewById(2131372030);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this.jdField_a_of_type_Bfpt);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695524);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131695533);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131689628);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(53).d(5).c(5).a();
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (AppSetting.d)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText() + ajya.a(2131708775));
    }
  }
  
  private void f()
  {
    View localView = super.getLayoutInflater().inflate(2131559436, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131375675));
    ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365763)).setOnTouchListener(new abtc(this));
    ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363479)).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(localView);
    this.jdField_a_of_type_Abtj = new abtj(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Abtj);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    g();
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
    this.jdField_a_of_type_AndroidAppDialog.getWindow().setSoftInputMode(36);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559443);
    Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = 0;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject).gravity = 51;
    this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject = (InputMethodManager)super.getSystemService("input_method");
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131375673));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130838514));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559442, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_d_of_type_AndroidViewView);
    this.jdField_d_of_type_AndroidViewView.setTag("");
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Abtl = new abtl(this, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Abtl);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this.jdField_a_of_type_Bfpt);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new abtg(this, (InputMethodManager)localObject));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131375493);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365763));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new abtn(this));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131367678));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new abth(this));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131375189));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new absv(this));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131367524);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365042));
    ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131375726)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void h()
  {
    if (this.g == null)
    {
      ViewStub localViewStub = (ViewStub)super.findViewById(2131365675);
      if (localViewStub == null) {
        return;
      }
      this.g = localViewStub.inflate();
      this.g.findViewById(2131375726).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
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
      avps localavps = (avps)this.app.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localavps.a("101000.101001");
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1)) {
        nol.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X80060E2", "0X80060E2", 0, 0, "", "", "", "", false);
      }
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      localavps.a(localAppInfo);
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
    localTranslateAnimation1.setAnimationListener(new abtd(this, localTranslateAnimation1, localTranslateAnimation2, i));
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new abte(this, i, localTranslateAnimation2, (InputMethodManager)localObject));
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    localObject = (Button)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363479);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new abtf(this));
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Abtl.notifyDataSetChanged();
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
      i = this.jdField_a_of_type_Abtj.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
  }
  
  protected void b()
  {
    Object localObject = (ViewGroup)super.findViewById(2131375329);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = super.findViewById(2131377369);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)super.findViewById(2131368429);
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
      this.jdField_a_of_type_Abtl.notifyDataSetChanged();
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
      abti localabti = (abti)localIterator.next();
      String str = localabti.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.displayNumber;
      if ((str != null) && (str.equalsIgnoreCase(paramString)))
      {
        localArrayList4.add(localabti);
      }
      else
      {
        str = localabti.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name.toLowerCase();
        if ((str.equals(paramString)) || (localabti.b.equals(paramString)) || (localabti.jdField_a_of_type_JavaLangString.equals(paramString))) {
          localArrayList1.add(localabti);
        } else if ((str.indexOf(paramString) == 0) || (localabti.b.indexOf(paramString) == 0) || (localabti.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0)) {
          localArrayList2.add(localabti);
        } else if ((str.indexOf(paramString) > 0) || (localabti.b.indexOf(paramString) > 0) || (localabti.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0)) {
          localArrayList3.add(localabti);
        }
      }
    }
    Collections.sort(localArrayList4, this.jdField_a_of_type_Abtm);
    Collections.sort(localArrayList1, this.jdField_a_of_type_Abtm);
    Collections.sort(localArrayList2, this.jdField_a_of_type_Abtm);
    Collections.sort(localArrayList3, this.jdField_a_of_type_Abtm);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList4);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList1);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList3);
    if (this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131695542, new Object[] { paramString }));
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidViewView.setTag(paramString);
      this.jdField_a_of_type_Abtl.notifyDataSetChanged();
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
    ArrayList localArrayList = this.jdField_a_of_type_Akdh.b();
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
      this.jdField_a_of_type_Abtj.a();
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      continue;
      h();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Akdh = ((akdh)this.app.getManager(56));
    super.setContentView(2131559435);
    this.jdField_a_of_type_AndroidViewLayoutInflater = super.getLayoutInflater();
    d();
    e();
    f();
    if (this.jdField_a_of_type_Akdh.jdField_a_of_type_Boolean) {
      c();
    }
    for (;;)
    {
      b();
      super.addObserver(this.jdField_a_of_type_Akdn);
      super.addObserver(this.jdField_a_of_type_Ajxj);
      this.app.registObserver(this.jdField_a_of_type_Atzn);
      this.jdField_a_of_type_MqqOsMqqHandler = new bfnk(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
      this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      return true;
      ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, this, true);
    }
  }
  
  public void doOnDestroy()
  {
    super.removeObserver(this.jdField_a_of_type_Akdn);
    super.removeObserver(this.jdField_a_of_type_Ajxj);
    if (this.jdField_a_of_type_Abtj != null) {
      this.jdField_a_of_type_Abtj.c();
    }
    if (this.jdField_a_of_type_Abtl != null) {
      this.jdField_a_of_type_Abtl.c();
    }
    super.doOnDestroy();
    this.app.unRegistObserver(this.jdField_a_of_type_Atzn);
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
  
  public void onPostRun()
  {
    runOnUiThread(new PublicAccountListActivity.3(this));
  }
  
  public void onPreRun() {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      bbfq.a("pubAcc_follow_list_display", null, "");
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountListActivity
 * JD-Core Version:    0.7.0.1
 */