package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
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
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import sjf;
import sjg;
import sjh;
import sji;
import sjj;
import sjk;
import sjl;
import sjm;
import sjn;
import sjo;
import sjp;
import sjq;
import sjt;

public class EmosmActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public int a;
  public Button a;
  public TextView a;
  EmoticonObserver jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver = new sjf(this);
  public DragSortAdapter a;
  DragSortListView.DropListener jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener = new sjh(this);
  DragSortListView.RemoveListener jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener = new sji(this);
  public DragSortListView a;
  EmoticonPackageChangedListener jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener;
  EmoticonPackageDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener;
  public EmoticonManager a;
  public QQProgressDialog a;
  TabBarView.OnTabChangeListener jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = new sjj(this);
  TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  public Runnable a;
  public WeakReference a;
  public ArrayList a;
  public boolean a;
  public int b;
  TextView b;
  public boolean b;
  public boolean c;
  
  public EmosmActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  }
  
  public DragSortController a(DragSortListView paramDragSortListView)
  {
    paramDragSortListView = new DragSortController(paramDragSortListView);
    paramDragSortListView.d(2131361849);
    paramDragSortListView.e(2131361850);
    paramDragSortListView.b(true);
    paramDragSortListView.a(true);
    paramDragSortListView.a(0);
    paramDragSortListView.b(0);
    paramDragSortListView.c(2);
    return paramDragSortListView;
  }
  
  public void a()
  {
    QQToast localQQToast = new QQToast(this);
    localQQToast.a(2130838710);
    localQQToast.d(1500);
    localQQToast.a("鉴权错误，删除失败");
    localQQToast.b(0);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.b(true);
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.getCount())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.getItem(i);
        if (!localEmoticonPackage.epId.equals(paramInt + "")) {
          break label153;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.a(localEmoticonPackage);
        String str = localEmoticonPackage.epId;
        if ((3 != localEmoticonPackage.jobType) && (1 != localEmoticonPackage.jobType) && (5 != localEmoticonPackage.jobType)) {
          ThreadManager.getFileThreadHandler().post(new sjk(this, str));
        }
        if (3 == localEmoticonPackage.jobType) {
          ReportController.b(this.app, "CliOper", "", "", "MbGuanli", "MbDianjiShanchu", 0, 0, "", "", "", "");
        }
      }
      return;
      label153:
      i += 1;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    if ((this.jdField_b_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.getCount() == 0)) {
      ReportController.b(this.app, "CliOper", "", "", "0X80060AA", "0X80060AA", 0, 0, "", "", "", "");
    }
  }
  
  void c()
  {
    String str = super.getIntent().getStringExtra("options");
    try
    {
      if (TextUtils.isEmpty(str))
      {
        this.leftView.setText(2131436237);
        return;
      }
      str = new JSONObject(str).optString("leftText", getString(2131436237));
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
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(0, new sjt(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2130968987);
    super.setContentBackgroundResource(2130838210);
    super.setTitle(2131436051);
    c();
    this.jdField_a_of_type_AndroidWidgetTextView = this.rightViewText;
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131436053);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new sjl(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131364568));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364570));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new sjm(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)super.findViewById(2131364569));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131436237));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131436238));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = ((DragSortListView)super.findViewById(16908298));
      paramBundle = a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setFloatViewManager(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnTouchListener(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDelImmediately(false);
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager = ((EmoticonManager)this.app.getManager(13));
      paramBundle = super.getIntent();
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("extra_launch_mode", 1);
      this.jdField_a_of_type_JavaLangRunnable = new sjn(this);
      this.jdField_a_of_type_JavaLangRunnable.run();
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter = new DragSortAdapter(this, this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.jdField_a_of_type_Int = -16745986;
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDropListener(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setRemoveListener(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnItemClickListener(new sjo(this));
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener = new sjp(this);
      EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new sjq(this);
      EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
      this.jdField_a_of_type_Int = paramBundle.getIntExtra("extra_launch_source", 2);
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 1))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131436053);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.a(false);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.notifyDataSetChanged();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this);
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
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener);
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmosmActivity", 2, "emosm activity ..............onPause");
    }
    super.doOnPause();
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
  }
  
  protected void doOnResume()
  {
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("EmosmActivity", 2, "emosm activity ..............onResume");
    }
    super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
    ((EmoticonHandler)this.app.a(12)).a(0, 0);
    super.doOnResume();
  }
  
  public void e()
  {
    if (this.c) {
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(0, new sjg(this));
    }
  }
  
  public void finish()
  {
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageChangedListener);
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.b();
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (!NetworkUtil.d(this))
      {
        paramView = new QQToast(this);
        paramView.a(2130838710);
        paramView.d(1500);
        paramView.a("无网络连接，删除失败");
        paramView.b(0);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131436075));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      localObject = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.a();
    } while (((List)localObject).size() <= 0);
    URLDrawable.clearMemoryCache();
    paramView = (EmoticonHandler)this.app.a(12);
    ArrayList localArrayList = new ArrayList();
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(Integer.valueOf(Integer.parseInt(((EmoticonPackage)((Iterator)localObject).next()).epId)));
    }
    paramView.a(localArrayList);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    if (QLog.isColorLevel()) {
      QLog.d("EmosmActivity", 2, "delete packages:" + localArrayList.toString());
    }
    ReportController.b(this.app, "CliOper", "", "", "EmosSetting", "EpDelete", 0, 0, "", "", "", "");
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