package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.emosm.view.DragSortController;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.emosm.view.DragSortListView.DropListener;
import com.tencent.mobileqq.emosm.view.DragSortListView.RemoveListener;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class EmosmActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  EmoticonObserver jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver = new EmosmActivity.1(this);
  DragSortAdapter<EmoticonPackage> jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter;
  DragSortListView.DropListener jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener = new EmosmActivity.12(this);
  DragSortListView.RemoveListener jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener = new EmosmActivity.13(this);
  DragSortListView jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView;
  EmoticonPackageChangedListener jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener;
  EmoticonPackageDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener;
  EmoticonManager jdField_a_of_type_ComTencentMobileqqModelEmoticonManager;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  public QQProgressDialog a;
  Runnable jdField_a_of_type_JavaLangRunnable;
  WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  ArrayList<EmoticonPackage> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  boolean jdField_c_of_type_Boolean = false;
  View jdField_d_of_type_AndroidViewView;
  boolean jdField_d_of_type_Boolean;
  View e;
  View f;
  View g;
  View h;
  View i;
  private View j;
  
  private void a(EmoticonResp paramEmoticonResp)
  {
    int k;
    if (paramEmoticonResp != null) {
      k = 0;
    }
    for (;;)
    {
      if (k < this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.getCount())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.getItem(k);
        if (!localEmoticonPackage.epId.equals(paramEmoticonResp.delEpId + "")) {
          break label88;
        }
        if (localEmoticonPackage.type != 1) {
          break label83;
        }
      }
      label83:
      for (k = 5;; k = 4)
      {
        EmoticonManager.d(String.valueOf(paramEmoticonResp.resultcode), k);
        return;
      }
      label88:
      k += 1;
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131363792));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131363792));
    this.j = findViewById(2131378327);
    this.j.setBackgroundColor(getResources().getColor(2131165637));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(findViewById(2131366284));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
    Drawable localDrawable = getResources().getDrawable(2130850777);
    localDrawable.setAlpha(235);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(localDrawable);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
  }
  
  public DragSortController a(DragSortListView paramDragSortListView)
  {
    paramDragSortListView = new DragSortController(paramDragSortListView);
    paramDragSortListView.d(2131366057);
    paramDragSortListView.e(2131364798);
    paramDragSortListView.b(true);
    paramDragSortListView.a(true);
    paramDragSortListView.a(0);
    paramDragSortListView.b(0);
    paramDragSortListView.c(2);
    return paramDragSortListView;
  }
  
  void a()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130839690);
    localQQToast.d(1500);
    localQQToast.a(HardCodeUtil.a(2131704062));
    localQQToast.b(0);
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.b(true);
    int k = 0;
    for (;;)
    {
      EmoticonPackage localEmoticonPackage;
      if (k < this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.getCount())
      {
        localEmoticonPackage = (EmoticonPackage)this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.getItem(k);
        if (!localEmoticonPackage.epId.equals(paramInt + "")) {
          break label177;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.a(localEmoticonPackage);
        if (localEmoticonPackage.type != 1) {
          break label172;
        }
      }
      label172:
      for (paramInt = 5;; paramInt = 4)
      {
        EmoticonManager.d("0", paramInt);
        String str = localEmoticonPackage.epId;
        if ((3 != localEmoticonPackage.jobType) && (1 != localEmoticonPackage.jobType) && (5 != localEmoticonPackage.jobType)) {
          ThreadManager.getFileThreadHandler().post(new EmosmActivity.2(this, str));
        }
        if (3 == localEmoticonPackage.jobType) {
          ReportController.b(this.app, "CliOper", "", "", "MbGuanli", "MbDianjiShanchu", 0, 0, "", "", "", "");
        }
        return;
      }
      label177:
      k += 1;
    }
  }
  
  void a(boolean paramBoolean)
  {
    boolean bool2 = true;
    float f2 = 0.5F;
    Object localObject = this.jdField_c_of_type_AndroidViewView;
    float f1;
    label41:
    label61:
    label81:
    label101:
    label119:
    boolean bool1;
    if (paramBoolean)
    {
      f1 = 0.5F;
      ((View)localObject).setAlpha(f1);
      localObject = this.jdField_c_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label190;
      }
      f1 = 0.5F;
      ((TextView)localObject).setAlpha(f1);
      localObject = this.e;
      if (!paramBoolean) {
        break label195;
      }
      f1 = 0.5F;
      ((View)localObject).setAlpha(f1);
      localObject = this.f;
      if (!paramBoolean) {
        break label200;
      }
      f1 = 0.5F;
      ((View)localObject).setAlpha(f1);
      localObject = this.h;
      if (!paramBoolean) {
        break label205;
      }
      f1 = 0.5F;
      ((View)localObject).setAlpha(f1);
      localObject = this.i;
      if (!paramBoolean) {
        break label210;
      }
      f1 = f2;
      ((View)localObject).setAlpha(f1);
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (paramBoolean) {
        break label215;
      }
      bool1 = true;
      label138:
      ((View)localObject).setEnabled(bool1);
      localObject = this.jdField_d_of_type_AndroidViewView;
      if (paramBoolean) {
        break label221;
      }
      bool1 = true;
      label158:
      ((View)localObject).setEnabled(bool1);
      localObject = this.g;
      if (paramBoolean) {
        break label227;
      }
    }
    label190:
    label195:
    label200:
    label205:
    label210:
    label215:
    label221:
    label227:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ((View)localObject).setEnabled(paramBoolean);
      return;
      f1 = 1.0F;
      break;
      f1 = 1.0F;
      break label41;
      f1 = 1.0F;
      break label61;
      f1 = 1.0F;
      break label81;
      f1 = 1.0F;
      break label101;
      f1 = 1.0F;
      break label119;
      bool1 = false;
      break label138;
      bool1 = false;
      break label158;
    }
  }
  
  void b()
  {
    if (this.jdField_b_of_type_Boolean) {
      setTitle(String.format(getResources().getString(2131692202), new Object[] { Integer.valueOf(0) }));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    if ((this.jdField_b_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.getCount() == 0)) {
      ReportController.b(this.app, "CliOper", "", "", "0X80060AA", "0X80060AA", 0, 0, "", "", "", "");
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_b_of_type_Int == paramInt) {
      return;
    }
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_d_of_type_Boolean = false;
    runOnUiThread(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  void c()
  {
    String str = super.getIntent().getStringExtra("options");
    try
    {
      if (TextUtils.isEmpty(str))
      {
        this.leftView.setText(2131691995);
        return;
      }
      str = new JSONObject(str).optString("leftText", getString(2131691995));
      this.leftView.setText(str);
      return;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmosmActivity", 2, localJSONException.getMessage());
      }
    }
  }
  
  void d()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(0, new EmosmActivity.9(this));
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
    boolean bool = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131559226);
    super.setContentBackgroundResource(2130838979);
    super.setTitle(2131692210);
    c();
    this.jdField_a_of_type_AndroidWidgetTextView = this.rightViewText;
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692201);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new EmosmActivity.3(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131364253));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366516));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new EmosmActivity.4(this));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = ((DragSortListView)super.findViewById(16908298));
      paramBundle = a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setFloatViewManager(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnTouchListener(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDelImmediately(false);
      this.jdField_a_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getContext(), 2131559227, null);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366273);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366274);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366275));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(2130839773));
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366269);
      this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131366270);
      this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131366271);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(2130839773));
      this.g = this.jdField_a_of_type_AndroidViewView.findViewById(2131366286);
      this.h = this.jdField_a_of_type_AndroidViewView.findViewById(2131366287);
      this.i = this.jdField_a_of_type_AndroidViewView.findViewById(2131366288);
      this.g.setBackgroundResource(2130839773);
      this.g.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager = ((EmoticonManager)this.app.getManager(QQManagerFactory.EMOTICON_MANAGER));
      paramBundle = super.getIntent();
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("extra_launch_mode", 1);
      this.jdField_a_of_type_JavaLangRunnable = new EmosmActivity.5(this);
      this.jdField_a_of_type_JavaLangRunnable.run();
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter = new DragSortAdapter(this, this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.jdField_a_of_type_Int = -16745986;
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDropListener(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setRemoveListener(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnItemClickListener(new EmosmActivity.6(this));
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener = new EmosmActivity.7(this);
      EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new EmosmActivity.8(this);
      EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
      this.jdField_a_of_type_Int = paramBundle.getIntExtra("extra_launch_source", 2);
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 1))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692201);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.a(false);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.notifyDataSetChanged();
      }
      g();
      b(1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this);
      super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
      ReportController.b(this.app, "CliOper", "", "", "ep_mall", "View_mine", 0, 0, "", "", "", "");
      bool = true;
    }
    catch (OutOfMemoryError paramBundle)
    {
      do
      {
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = null;
      } while (!QLog.isColorLevel());
      QLog.e("EmosmActivity", 2, paramBundle.getMessage());
    }
    return bool;
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener);
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
    }
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmosmActivity", 2, "emosm activity ..............onPause");
    }
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
    }
  }
  
  public void doOnResume()
  {
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("EmosmActivity", 2, "emosm activity ..............onResume");
    }
    ((EmoticonHandler)this.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).a(0, 0);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
    }
    super.doOnResume();
  }
  
  void e()
  {
    if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(0, new EmosmActivity.10(this));
  }
  
  public void f()
  {
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(0, new EmosmActivity.11(this));
    }
  }
  
  public void finish()
  {
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener);
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.b();
    super.finish();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_b_of_type_Int != 1)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692201);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.a(false);
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        a(this.jdField_b_of_type_Boolean);
      }
      b(1);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1;
      if (!NetworkUtil.d(this))
      {
        localObject1 = new QQToast(this);
        ((QQToast)localObject1).a(2130839690);
        ((QQToast)localObject1).d(1500);
        ((QQToast)localObject1).a(HardCodeUtil.a(2131704061));
        ((QQToast)localObject1).b(0);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131692007));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.a();
        if (((List)localObject2).size() > 0)
        {
          URLDrawable.clearMemoryCache();
          localObject1 = (EmoticonHandler)this.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM);
          ArrayList localArrayList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            localArrayList.add(Integer.valueOf(Integer.parseInt(((EmoticonPackage)((Iterator)localObject2).next()).epId)));
          }
          ((EmoticonHandler)localObject1).a(localArrayList);
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          if (QLog.isColorLevel()) {
            QLog.d("EmosmActivity", 2, "delete packages:" + localArrayList.toString());
          }
          ReportController.b(this.app, "CliOper", "", "", "EmosSetting", "EpDelete", 0, 0, "", "", "", "");
          if (this.jdField_b_of_type_Int == 1)
          {
            ReportController.b(this.app, "dc00898", "", "", "0X800AB12", "0X800AB12", localArrayList.size(), 0, "", "", "", "");
          }
          else
          {
            ReportController.b(this.app, "dc00898", "", "", "0X800AB19", "0X800AB19", localArrayList.size(), 0, "", "", "", "");
            continue;
            startActivity(new Intent(this, FavEmosmManageActivity.class));
            ReportController.b(this.app, "dc00898", "", "", "0X800AB0B", "0X800AB0B", 0, 0, "", "", "", "");
            continue;
            localObject1 = new Intent(this, FavEmosmManageActivity.class);
            ((Intent)localObject1).putExtra("camera_emo_mode", 1);
            startActivity((Intent)localObject1);
            ReportController.b(this.app, "dc00898", "", "", "0X800AB0C", "0X800AB0C", 0, 0, "", "", "", "");
            continue;
            b(2);
            ReportController.b(this.app, "dc00898", "", "", "0X800AB0D", "0X800AB0D", 0, 0, "", "", "", "");
          }
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onRestart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "emosm activity ..............onRestart");
    }
    super.onRestart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity
 * JD-Core Version:    0.7.0.1
 */