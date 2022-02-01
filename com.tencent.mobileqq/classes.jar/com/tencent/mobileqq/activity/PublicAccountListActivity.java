package com.tencent.mobileqq.activity;

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
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class PublicAccountListActivity
  extends BaseActivity
  implements ThreadExcutor.IThreadListener, IndexView.OnIndexChangedListener
{
  Dialog jdField_a_of_type_AndroidAppDialog;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new PublicAccountListActivity.2(this);
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new PublicAccountListActivity.15(this);
  View jdField_a_of_type_AndroidViewView;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  IPublicAccountDataManager jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountDataManager;
  private IPublicAccountObserver jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver;
  PublicAccountListActivity.ListAdapter jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$ListAdapter = null;
  PublicAccountListActivity.SearchResultAdapter jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultAdapter;
  PublicAccountListActivity.SearchResultComparator jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultComparator = new PublicAccountListActivity.SearchResultComparator(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new PublicAccountListActivity.12(this);
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new PublicAccountListActivity.13(this);
  private RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new PublicAccountListActivity.14(this);
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  Runnable jdField_a_of_type_JavaLangRunnable = new PublicAccountListActivity.3(this);
  private Comparator<PublicAccountListActivity.InnerPAInfo> jdField_a_of_type_JavaUtilComparator = new PublicAccountListActivity.16(this);
  List<PublicAccountListActivity.InnerPAInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  List<PublicAccountListActivity.InnerPAInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  View jdField_d_of_type_AndroidViewView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  View e;
  View f;
  View g;
  
  private PublicAccountListActivity.InnerPAInfo a(PublicAccountInfo paramPublicAccountInfo)
  {
    PublicAccountListActivity.InnerPAInfo localInnerPAInfo = new PublicAccountListActivity.InnerPAInfo(paramPublicAccountInfo);
    localInnerPAInfo.a(ChnToSpell.a(paramPublicAccountInfo.name, 2));
    localInnerPAInfo.b(ChnToSpell.a(paramPublicAccountInfo.name, 1));
    return localInnerPAInfo;
  }
  
  private boolean a(PublicAccountListActivity.InnerPAInfo paramInnerPAInfo)
  {
    if ((paramInnerPAInfo != null) && (paramInnerPAInfo.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo == null)) {}
    return false;
  }
  
  @TargetApi(14)
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131373221));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131378803);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369249));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369202));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369233));
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.e = super.findViewById(2131365203);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)super.findViewById(2131373218));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)super.findViewById(2131368761));
    this.f = super.findViewById(2131373160);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695165);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131695179);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131689589);
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this, this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.b(53).e(5).d(5).a();
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (AppSetting.d)
    {
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      localTextView.setContentDescription(localTextView.getText());
      localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_AndroidWidgetTextView.getText());
      localStringBuilder.append(HardCodeUtil.a(2131708756));
      localTextView.setContentDescription(localStringBuilder.toString());
    }
  }
  
  private void f()
  {
    View localView = super.getLayoutInflater().inflate(2131559613, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131377019));
    ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366333)).setOnTouchListener(new PublicAccountListActivity.5(this));
    ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363868)).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(localView);
    this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$ListAdapter = new PublicAccountListActivity.ListAdapter(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$ListAdapter);
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
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559620);
    Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = 0;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject).gravity = 51;
    this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject = (InputMethodManager)super.getSystemService("input_method");
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131377016));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130838739));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559619, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_d_of_type_AndroidViewView);
    this.jdField_d_of_type_AndroidViewView.setTag("");
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultAdapter = new PublicAccountListActivity.SearchResultAdapter(this, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new PublicAccountListActivity.9(this, (InputMethodManager)localObject));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131376809);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131366333));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new PublicAccountListActivity.SearchTextWatcher(this));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131368340));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new PublicAccountListActivity.10(this));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131376483));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new PublicAccountListActivity.11(this));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131368186);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365536));
    ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131377072)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void h()
  {
    if (this.g == null)
    {
      ViewStub localViewStub = (ViewStub)super.findViewById(2131366238);
      if (localViewStub == null) {
        return;
      }
      this.g = localViewStub.inflate();
      this.g.findViewById(2131377072).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    this.g.setVisibility(0);
    this.e.setVisibility(8);
  }
  
  private void i()
  {
    View localView = this.g;
    if (localView != null) {
      localView.setVisibility(8);
    }
    this.e.setVisibility(0);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath("101000.101001");
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1)) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X80060E2", "0X80060E2", 0, 0, "", "", "", "", false);
      }
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a(localAppInfo);
      localIRedTouchManager.onReportRedPointExposure(localAppInfo);
    }
  }
  
  protected void a()
  {
    Object localObject = (InputMethodManager)super.getSystemService("input_method");
    int i = this.jdField_a_of_type_AndroidViewView.getHeight();
    float f1 = -i;
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, f1);
    localTranslateAnimation1.setDuration(300L);
    localTranslateAnimation1.setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation1);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, f1, 0.0F);
    localTranslateAnimation2.setDuration(300L);
    localTranslateAnimation1.setAnimationListener(new PublicAccountListActivity.6(this, localTranslateAnimation1, localTranslateAnimation2, i));
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new PublicAccountListActivity.7(this, i, localTranslateAnimation2, (InputMethodManager)localObject));
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    localObject = (Button)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363868);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new PublicAccountListActivity.8(this));
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void a(String paramString)
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_AndroidViewView.getLayoutParams().height = -1;
    if ((paramString != null) && (paramString.trim().length() != 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      paramString = paramString.toLowerCase();
      Object localObject = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        PublicAccountListActivity.InnerPAInfo localInnerPAInfo = (PublicAccountListActivity.InnerPAInfo)localIterator.next();
        String str = localInnerPAInfo.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.displayNumber;
        if ((str != null) && (str.equalsIgnoreCase(paramString)))
        {
          localArrayList3.add(localInnerPAInfo);
        }
        else
        {
          str = localInnerPAInfo.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name.toLowerCase();
          if ((!str.equals(paramString)) && (!localInnerPAInfo.b.equals(paramString)) && (!localInnerPAInfo.jdField_a_of_type_JavaLangString.equals(paramString)))
          {
            if ((str.indexOf(paramString) != 0) && (localInnerPAInfo.b.indexOf(paramString) != 0) && (localInnerPAInfo.jdField_a_of_type_JavaLangString.indexOf(paramString) != 0))
            {
              if ((str.indexOf(paramString) > 0) || (localInnerPAInfo.b.indexOf(paramString) > 0) || (localInnerPAInfo.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0)) {
                localArrayList2.add(localInnerPAInfo);
              }
            }
            else {
              localArrayList1.add(localInnerPAInfo);
            }
          }
          else {
            ((List)localObject).add(localInnerPAInfo);
          }
        }
      }
      Collections.sort(localArrayList3, this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultComparator);
      Collections.sort((List)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultComparator);
      Collections.sort(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultComparator);
      Collections.sort(localArrayList2, this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultComparator);
      this.jdField_a_of_type_JavaUtilList.addAll(localArrayList3);
      this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
      this.jdField_a_of_type_JavaUtilList.addAll(localArrayList1);
      this.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
      if (this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131695188, new Object[] { paramString }));
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      }
      else
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      }
      this.jdField_d_of_type_AndroidViewView.setTag(paramString);
      this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultAdapter.notifyDataSetChanged();
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("refreshSearchResultList:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(l2 - l1);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList.size());
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaUtilList.size());
        QLog.i("PublicAccountListActivity", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultAdapter.notifyDataSetChanged();
  }
  
  protected void b()
  {
    Object localObject = (ViewGroup)super.findViewById(2131376636);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = super.findViewById(2131378803);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)super.findViewById(2131369202);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  void c()
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountDataManager.getPublicAccountListNotIVR();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      i();
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext()) {
        this.jdField_b_of_type_JavaUtilList.add(a((PublicAccountInfo)localIterator.next()));
      }
      if (localArrayList.size() < 15) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      }
    }
    else
    {
      h();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$ListAdapter.a();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
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
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountDataManager = ((IPublicAccountDataManager)this.app.getRuntimeService(IPublicAccountDataManager.class, "all"));
    super.setContentView(2131559612);
    this.jdField_a_of_type_AndroidViewLayoutInflater = super.getLayoutInflater();
    d();
    e();
    f();
    if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountDataManager.isCached()) {
      c();
    } else {
      ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, this, true);
    }
    b();
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver = ((IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class));
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.setOnCallback(new PublicAccountListActivity.1(this));
    super.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.getBusinessObserver());
    super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.getBusinessObserver());
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$ListAdapter;
    if (localObject != null) {
      ((PublicAccountListActivity.ListAdapter)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$SearchResultAdapter;
    if (localObject != null) {
      ((PublicAccountListActivity.SearchResultAdapter)localObject).c();
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
      View localView = this.jdField_a_of_type_AndroidViewView;
      if (localView != null)
      {
        localView.destroyDrawingCache();
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
  
  protected void doOnStop()
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
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$ListAdapter.a(paramString);
    if (i != -1)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
      paramString.setSelection(i + paramString.getHeaderViewsCount());
    }
  }
  
  public void onPostRun()
  {
    runOnUiThread(new PublicAccountListActivity.4(this));
  }
  
  public void onPreRun() {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountListActivity
 * JD-Core Version:    0.7.0.1
 */