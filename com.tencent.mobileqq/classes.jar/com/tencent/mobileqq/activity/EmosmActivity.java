package com.tencent.mobileqq.activity;

import Override;
import aemz;
import aena;
import aenb;
import aenc;
import aend;
import aene;
import aenf;
import aeng;
import aenh;
import aeni;
import aenj;
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
import anwx;
import anwy;
import anzj;
import ashn;
import ashp;
import ashz;
import asid;
import askc;
import askp;
import askq;
import axfj;
import bdll;
import bhnv;
import bjbs;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.widget.QQBlurView;
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
  public int a;
  public View a;
  public Button a;
  public TextView a;
  anwy jdField_a_of_type_Anwy = new aemz(this);
  public ashn<EmoticonPackage> a;
  ashz jdField_a_of_type_Ashz = new aenc(this);
  asid jdField_a_of_type_Asid = new aend(this);
  askp jdField_a_of_type_Askp;
  askq jdField_a_of_type_Askq;
  public axfj a;
  public bjbs a;
  public DragSortListView a;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  public Runnable a;
  public WeakReference<Activity> a;
  public ArrayList<EmoticonPackage> a;
  public boolean a;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public boolean c;
  View d;
  public boolean d;
  View e;
  View f;
  public View g;
  View h;
  View i;
  private View j;
  
  public EmosmActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  }
  
  private void a(EmoticonResp paramEmoticonResp)
  {
    int k;
    if (paramEmoticonResp != null) {
      k = 0;
    }
    for (;;)
    {
      if (k < this.jdField_a_of_type_Ashn.getCount())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.jdField_a_of_type_Ashn.getItem(k);
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
        axfj.d(String.valueOf(paramEmoticonResp.resultcode), k);
        return;
      }
      label88:
      k += 1;
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131363601));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131363601));
    this.j = findViewById(2131377868);
    this.j.setBackgroundColor(getResources().getColor(2131165621));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(findViewById(2131365981));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
    Drawable localDrawable = getResources().getDrawable(2130850350);
    localDrawable.setAlpha(235);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(localDrawable);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
  }
  
  public ashp a(DragSortListView paramDragSortListView)
  {
    paramDragSortListView = new ashp(paramDragSortListView);
    paramDragSortListView.d(2131365763);
    paramDragSortListView.e(2131364580);
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
    localQQToast.a(2130839555);
    localQQToast.d(1500);
    localQQToast.a(anzj.a(2131702933));
    localQQToast.b(0);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Ashn.b(true);
    int k = 0;
    for (;;)
    {
      EmoticonPackage localEmoticonPackage;
      if (k < this.jdField_a_of_type_Ashn.getCount())
      {
        localEmoticonPackage = (EmoticonPackage)this.jdField_a_of_type_Ashn.getItem(k);
        if (!localEmoticonPackage.epId.equals(paramInt + "")) {
          break label177;
        }
        this.jdField_a_of_type_Ashn.a(localEmoticonPackage);
        if (localEmoticonPackage.type != 1) {
          break label172;
        }
      }
      label172:
      for (paramInt = 5;; paramInt = 4)
      {
        axfj.d("0", paramInt);
        String str = localEmoticonPackage.epId;
        if ((3 != localEmoticonPackage.jobType) && (1 != localEmoticonPackage.jobType) && (5 != localEmoticonPackage.jobType)) {
          ThreadManager.getFileThreadHandler().post(new EmosmActivity.2(this, str));
        }
        if (3 == localEmoticonPackage.jobType) {
          bdll.b(this.app, "CliOper", "", "", "MbGuanli", "MbDianjiShanchu", 0, 0, "", "", "", "");
        }
        return;
      }
      label177:
      k += 1;
    }
  }
  
  public void a(boolean paramBoolean)
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
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean) {
      setTitle(String.format(getResources().getString(2131691935), new Object[] { Integer.valueOf(0) }));
    }
    this.jdField_a_of_type_Bjbs.dismiss();
    if ((this.jdField_b_of_type_Int == 2) && (this.jdField_a_of_type_Ashn.getCount() == 0)) {
      bdll.b(this.app, "CliOper", "", "", "0X80060AA", "0X80060AA", 0, 0, "", "", "", "");
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
        this.leftView.setText(2131691736);
        return;
      }
      str = new JSONObject(str).optString("leftText", getString(2131691736));
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
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Axfj.a(0, new aenj(this));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131559156);
    super.setContentBackgroundResource(2130838778);
    super.setTitle(2131691943);
    c();
    this.jdField_a_of_type_AndroidWidgetTextView = this.rightViewText;
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691934);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aene(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131364047));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366209));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new aenf(this));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = ((DragSortListView)super.findViewById(16908298));
      paramBundle = a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setFloatViewManager(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnTouchListener(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDelImmediately(false);
      this.jdField_a_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getContext(), 2131559157, null);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365970);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365971);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365972));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(2130839637));
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365966);
      this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131365967);
      this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131365968);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(2130839637));
      this.g = this.jdField_a_of_type_AndroidViewView.findViewById(2131365983);
      this.h = this.jdField_a_of_type_AndroidViewView.findViewById(2131365984);
      this.i = this.jdField_a_of_type_AndroidViewView.findViewById(2131365985);
      this.g.setBackgroundResource(2130839637);
      this.g.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Axfj = ((axfj)this.app.getManager(14));
      paramBundle = super.getIntent();
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("extra_launch_mode", 1);
      this.jdField_a_of_type_JavaLangRunnable = new EmosmActivity.5(this);
      this.jdField_a_of_type_JavaLangRunnable.run();
      this.jdField_a_of_type_Ashn = new ashn(this, this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Ashn.jdField_a_of_type_Int = -16745986;
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setAdapter(this.jdField_a_of_type_Ashn);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDropListener(this.jdField_a_of_type_Ashz);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setRemoveListener(this.jdField_a_of_type_Asid);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnItemClickListener(new aeng(this));
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Askp = new aenh(this);
      askc.a().a(this.jdField_a_of_type_Askp);
      this.jdField_a_of_type_Askq = new aeni(this);
      askc.a().a(this.jdField_a_of_type_Askq);
      this.jdField_a_of_type_Int = paramBundle.getIntExtra("extra_launch_source", 2);
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 1))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691934);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
        this.jdField_a_of_type_Ashn.a(false);
        this.jdField_a_of_type_Ashn.notifyDataSetChanged();
      }
      g();
      b(1);
      this.jdField_a_of_type_Bjbs = new bjbs(this);
      super.addObserver(this.jdField_a_of_type_Anwy);
      bdll.b(this.app, "CliOper", "", "", "ep_mall", "View_mine", 0, 0, "", "", "", "");
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
    super.removeObserver(this.jdField_a_of_type_Anwy);
    askc.a().b(this.jdField_a_of_type_Askp);
    askc.a().b(this.jdField_a_of_type_Askq);
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
    ((anwx)this.app.a(12)).a(0, 0);
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
    this.jdField_a_of_type_Axfj.a(0, new aena(this));
  }
  
  public void f()
  {
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_Axfj.a(0, new aenb(this));
    }
  }
  
  public void finish()
  {
    askc.a().b(this.jdField_a_of_type_Askp);
    askc.a().b(this.jdField_a_of_type_Askq);
    this.jdField_a_of_type_Ashn.b();
    super.finish();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_b_of_type_Int != 1)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691934);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
        this.jdField_a_of_type_Ashn.a(false);
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
      if (!bhnv.d(this))
      {
        localObject1 = new QQToast(this);
        ((QQToast)localObject1).a(2130839555);
        ((QQToast)localObject1).d(1500);
        ((QQToast)localObject1).a(anzj.a(2131702932));
        ((QQToast)localObject1).b(0);
      }
      else
      {
        this.jdField_a_of_type_Bjbs.a(getString(2131691748));
        this.jdField_a_of_type_Bjbs.show();
        Object localObject2 = this.jdField_a_of_type_Ashn.a();
        if (((List)localObject2).size() > 0)
        {
          URLDrawable.clearMemoryCache();
          localObject1 = (anwx)this.app.a(12);
          ArrayList localArrayList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            localArrayList.add(Integer.valueOf(Integer.parseInt(((EmoticonPackage)((Iterator)localObject2).next()).epId)));
          }
          ((anwx)localObject1).a(localArrayList);
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          if (QLog.isColorLevel()) {
            QLog.d("EmosmActivity", 2, "delete packages:" + localArrayList.toString());
          }
          bdll.b(this.app, "CliOper", "", "", "EmosSetting", "EpDelete", 0, 0, "", "", "", "");
          if (this.jdField_b_of_type_Int == 1)
          {
            bdll.b(this.app, "dc00898", "", "", "0X800AB12", "0X800AB12", localArrayList.size(), 0, "", "", "", "");
          }
          else
          {
            bdll.b(this.app, "dc00898", "", "", "0X800AB19", "0X800AB19", localArrayList.size(), 0, "", "", "", "");
            continue;
            startActivity(new Intent(this, FavEmosmManageActivity.class));
            bdll.b(this.app, "dc00898", "", "", "0X800AB0B", "0X800AB0B", 0, 0, "", "", "", "");
            continue;
            localObject1 = new Intent(this, FavEmosmManageActivity.class);
            ((Intent)localObject1).putExtra("camera_emo_mode", 1);
            startActivity((Intent)localObject1);
            bdll.b(this.app, "dc00898", "", "", "0X800AB0C", "0X800AB0C", 0, 0, "", "", "", "");
            continue;
            b(2);
            bdll.b(this.app, "dc00898", "", "", "0X800AB0D", "0X800AB0D", 0, 0, "", "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity
 * JD-Core Version:    0.7.0.1
 */