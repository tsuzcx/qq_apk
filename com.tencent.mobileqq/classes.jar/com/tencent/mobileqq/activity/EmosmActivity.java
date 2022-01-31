package com.tencent.mobileqq.activity;

import aare;
import aarf;
import aarg;
import aarh;
import aari;
import aarj;
import aark;
import aarl;
import aarm;
import aarn;
import aaro;
import ajhm;
import ajhn;
import ajjy;
import ancr;
import ancw;
import andg;
import andk;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import anfi;
import anfv;
import anfw;
import arnz;
import awqx;
import badq;
import bbms;
import bbmy;
import bbom;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
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
  public int a;
  ajhn jdField_a_of_type_Ajhn = new aare(this);
  public ancr<EmoticonPackage> a;
  andg jdField_a_of_type_Andg = new aarg(this);
  andk jdField_a_of_type_Andk = new aarh(this);
  public Button a;
  public TextView a;
  anfv jdField_a_of_type_Anfv;
  anfw jdField_a_of_type_Anfw;
  public arnz a;
  public bbms a;
  bbom jdField_a_of_type_Bbom = new aari(this);
  public DragSortListView a;
  TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  public Runnable a;
  public WeakReference<Activity> a;
  public ArrayList<EmoticonPackage> a;
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
  
  private void a(EmoticonResp paramEmoticonResp)
  {
    int i;
    if (paramEmoticonResp != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_Ancr.getCount())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.jdField_a_of_type_Ancr.getItem(i);
        if (!localEmoticonPackage.epId.equals(paramEmoticonResp.delEpId + "")) {
          break label88;
        }
        if (localEmoticonPackage.type != 1) {
          break label83;
        }
      }
      label83:
      for (i = 5;; i = 4)
      {
        arnz.d(String.valueOf(paramEmoticonResp.resultcode), i);
        return;
      }
      label88:
      i += 1;
    }
  }
  
  public ancw a(DragSortListView paramDragSortListView)
  {
    paramDragSortListView = new ancw(paramDragSortListView);
    paramDragSortListView.d(2131299819);
    paramDragSortListView.e(2131298697);
    paramDragSortListView.b(true);
    paramDragSortListView.a(true);
    paramDragSortListView.a(0);
    paramDragSortListView.b(0);
    paramDragSortListView.c(2);
    return paramDragSortListView;
  }
  
  public void a()
  {
    bbmy localbbmy = new bbmy(this);
    localbbmy.a(2130839253);
    localbbmy.d(1500);
    localbbmy.a(ajjy.a(2131638249));
    localbbmy.b(0);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Ancr.b(true);
    int i = 0;
    for (;;)
    {
      EmoticonPackage localEmoticonPackage;
      if (i < this.jdField_a_of_type_Ancr.getCount())
      {
        localEmoticonPackage = (EmoticonPackage)this.jdField_a_of_type_Ancr.getItem(i);
        if (!localEmoticonPackage.epId.equals(paramInt + "")) {
          break label174;
        }
        this.jdField_a_of_type_Ancr.a(localEmoticonPackage);
        if (localEmoticonPackage.type != 1) {
          break label169;
        }
      }
      label169:
      for (paramInt = 5;; paramInt = 4)
      {
        arnz.d("0", paramInt);
        String str = localEmoticonPackage.epId;
        if ((3 != localEmoticonPackage.jobType) && (1 != localEmoticonPackage.jobType) && (5 != localEmoticonPackage.jobType)) {
          ThreadManager.getFileThreadHandler().post(new EmosmActivity.2(this, str));
        }
        if (3 == localEmoticonPackage.jobType) {
          awqx.b(this.app, "CliOper", "", "", "MbGuanli", "MbDianjiShanchu", 0, 0, "", "", "", "");
        }
        return;
      }
      label174:
      i += 1;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bbms.dismiss();
    if ((this.jdField_b_of_type_Int == 2) && (this.jdField_a_of_type_Ancr.getCount() == 0)) {
      awqx.b(this.app, "CliOper", "", "", "0X80060AA", "0X80060AA", 0, 0, "", "", "", "");
    }
  }
  
  void c()
  {
    String str = super.getIntent().getStringExtra("options");
    try
    {
      if (TextUtils.isEmpty(str))
      {
        this.leftView.setText(2131626451);
        return;
      }
      str = new JSONObject(str).optString("leftText", getString(2131626451));
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
    if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (this.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    this.jdField_a_of_type_Arnz.a(0, new aaro(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131493484);
    super.setContentBackgroundResource(2130838503);
    super.setTitle(2131626677);
    c();
    this.jdField_a_of_type_AndroidWidgetTextView = this.rightViewText;
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131626667);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aarj(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131298204));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131300223));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new aark(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)super.findViewById(2131310972));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131626451));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131626452));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_Bbom);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = ((DragSortListView)super.findViewById(16908298));
      paramBundle = a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setFloatViewManager(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnTouchListener(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDelImmediately(false);
      this.jdField_a_of_type_Arnz = ((arnz)this.app.getManager(14));
      paramBundle = super.getIntent();
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("extra_launch_mode", 1);
      this.jdField_a_of_type_JavaLangRunnable = new EmosmActivity.5(this);
      this.jdField_a_of_type_JavaLangRunnable.run();
      this.jdField_a_of_type_Ancr = new ancr(this, this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Ancr.jdField_a_of_type_Int = -16745986;
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setAdapter(this.jdField_a_of_type_Ancr);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDropListener(this.jdField_a_of_type_Andg);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setRemoveListener(this.jdField_a_of_type_Andk);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnItemClickListener(new aarl(this));
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Anfv = new aarm(this);
      anfi.a().a(this.jdField_a_of_type_Anfv);
      this.jdField_a_of_type_Anfw = new aarn(this);
      anfi.a().a(this.jdField_a_of_type_Anfw);
      this.jdField_a_of_type_Int = paramBundle.getIntExtra("extra_launch_source", 2);
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 1))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131626667);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
        this.jdField_a_of_type_Ancr.a(false);
        this.jdField_a_of_type_Ancr.notifyDataSetChanged();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
      this.jdField_a_of_type_Bbms = new bbms(this);
      awqx.b(this.app, "CliOper", "", "", "ep_mall", "View_mine", 0, 0, "", "", "", "");
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
    anfi.a().b(this.jdField_a_of_type_Anfv);
    anfi.a().b(this.jdField_a_of_type_Anfw);
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmosmActivity", 2, "emosm activity ..............onPause");
    }
    super.doOnPause();
    super.removeObserver(this.jdField_a_of_type_Ajhn);
  }
  
  public void doOnResume()
  {
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("EmosmActivity", 2, "emosm activity ..............onResume");
    }
    super.addObserver(this.jdField_a_of_type_Ajhn);
    ((ajhm)this.app.a(12)).a(0, 0);
    super.doOnResume();
  }
  
  public void e()
  {
    if (this.c) {
      this.jdField_a_of_type_Arnz.a(0, new aarf(this));
    }
  }
  
  public void finish()
  {
    anfi.a().b(this.jdField_a_of_type_Anfv);
    anfi.a().b(this.jdField_a_of_type_Anfw);
    this.jdField_a_of_type_Ancr.b();
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
      if (!badq.d(this))
      {
        paramView = new bbmy(this);
        paramView.a(2130839253);
        paramView.d(1500);
        paramView.a(ajjy.a(2131638248));
        paramView.b(0);
        return;
      }
      this.jdField_a_of_type_Bbms.a(getString(2131626463));
      this.jdField_a_of_type_Bbms.show();
      localObject = this.jdField_a_of_type_Ancr.a();
    } while (((List)localObject).size() <= 0);
    URLDrawable.clearMemoryCache();
    paramView = (ajhm)this.app.a(12);
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
    awqx.b(this.app, "CliOper", "", "", "EmosSetting", "EpDelete", 0, 0, "", "", "", "");
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