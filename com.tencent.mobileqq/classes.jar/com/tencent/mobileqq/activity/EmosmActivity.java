package com.tencent.mobileqq.activity;

import abas;
import abat;
import abau;
import abav;
import abaw;
import abax;
import abay;
import abaz;
import abba;
import abbb;
import abbc;
import ajvn;
import ajvo;
import ajya;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import anth;
import antj;
import antt;
import antx;
import anvw;
import anwj;
import anwk;
import askf;
import axqy;
import bbfj;
import bcqf;
import bcql;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.widget.QQBlurView;
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
  ajvo jdField_a_of_type_Ajvo = new abas(this);
  public View a;
  public Button a;
  public TextView a;
  public anth<EmoticonPackage> a;
  antt jdField_a_of_type_Antt = new abav(this);
  antx jdField_a_of_type_Antx = new abaw(this);
  anwj jdField_a_of_type_Anwj;
  anwk jdField_a_of_type_Anwk;
  public askf a;
  public bcqf a;
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
      if (k < this.jdField_a_of_type_Anth.getCount())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.jdField_a_of_type_Anth.getItem(k);
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
        askf.d(String.valueOf(paramEmoticonResp.resultcode), k);
        return;
      }
      label88:
      k += 1;
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131363346));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131363346));
    this.j = findViewById(2131376348);
    this.j.setBackgroundColor(getResources().getColor(2131165549));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(findViewById(2131365614));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
    Drawable localDrawable = getResources().getDrawable(2130849248);
    localDrawable.setAlpha(235);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(localDrawable);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
  }
  
  public antj a(DragSortListView paramDragSortListView)
  {
    paramDragSortListView = new antj(paramDragSortListView);
    paramDragSortListView.d(2131365398);
    paramDragSortListView.e(2131364254);
    paramDragSortListView.b(true);
    paramDragSortListView.a(true);
    paramDragSortListView.a(0);
    paramDragSortListView.b(0);
    paramDragSortListView.c(2);
    return paramDragSortListView;
  }
  
  public void a()
  {
    bcql localbcql = new bcql(this);
    localbcql.a(2130839277);
    localbcql.d(1500);
    localbcql.a(ajya.a(2131704045));
    localbcql.b(0);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Anth.b(true);
    int k = 0;
    for (;;)
    {
      EmoticonPackage localEmoticonPackage;
      if (k < this.jdField_a_of_type_Anth.getCount())
      {
        localEmoticonPackage = (EmoticonPackage)this.jdField_a_of_type_Anth.getItem(k);
        if (!localEmoticonPackage.epId.equals(paramInt + "")) {
          break label177;
        }
        this.jdField_a_of_type_Anth.a(localEmoticonPackage);
        if (localEmoticonPackage.type != 1) {
          break label172;
        }
      }
      label172:
      for (paramInt = 5;; paramInt = 4)
      {
        askf.d("0", paramInt);
        String str = localEmoticonPackage.epId;
        if ((3 != localEmoticonPackage.jobType) && (1 != localEmoticonPackage.jobType) && (5 != localEmoticonPackage.jobType)) {
          ThreadManager.getFileThreadHandler().post(new EmosmActivity.2(this, str));
        }
        if (3 == localEmoticonPackage.jobType) {
          axqy.b(this.app, "CliOper", "", "", "MbGuanli", "MbDianjiShanchu", 0, 0, "", "", "", "");
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
      setTitle(String.format(getResources().getString(2131692254), new Object[] { Integer.valueOf(0) }));
    }
    this.jdField_a_of_type_Bcqf.dismiss();
    if ((this.jdField_b_of_type_Int == 2) && (this.jdField_a_of_type_Anth.getCount() == 0)) {
      axqy.b(this.app, "CliOper", "", "", "0X80060AA", "0X80060AA", 0, 0, "", "", "", "");
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
        this.leftView.setText(2131692037);
        return;
      }
      str = new JSONObject(str).optString("leftText", getString(2131692037));
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
    this.jdField_a_of_type_Askf.a(0, new abbc(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131559047);
    super.setContentBackgroundResource(2130838514);
    super.setTitle(2131692264);
    c();
    this.jdField_a_of_type_AndroidWidgetTextView = this.rightViewText;
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692253);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new abax(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131363758));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365820));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new abay(this));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = ((DragSortListView)super.findViewById(16908298));
      paramBundle = a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setFloatViewManager(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnTouchListener(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDelImmediately(false);
      this.jdField_a_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getContext(), 2131559048, null);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365603);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365604);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365605));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(2130839372));
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365599);
      this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131365600);
      this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131365601);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(2130839372));
      this.g = this.jdField_a_of_type_AndroidViewView.findViewById(2131365616);
      this.h = this.jdField_a_of_type_AndroidViewView.findViewById(2131365617);
      this.i = this.jdField_a_of_type_AndroidViewView.findViewById(2131365618);
      this.g.setBackgroundResource(2130839372);
      this.g.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Askf = ((askf)this.app.getManager(14));
      paramBundle = super.getIntent();
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("extra_launch_mode", 1);
      this.jdField_a_of_type_JavaLangRunnable = new EmosmActivity.5(this);
      this.jdField_a_of_type_JavaLangRunnable.run();
      this.jdField_a_of_type_Anth = new anth(this, this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Anth.jdField_a_of_type_Int = -16745986;
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setAdapter(this.jdField_a_of_type_Anth);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDropListener(this.jdField_a_of_type_Antt);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setRemoveListener(this.jdField_a_of_type_Antx);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnItemClickListener(new abaz(this));
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Anwj = new abba(this);
      anvw.a().a(this.jdField_a_of_type_Anwj);
      this.jdField_a_of_type_Anwk = new abbb(this);
      anvw.a().a(this.jdField_a_of_type_Anwk);
      this.jdField_a_of_type_Int = paramBundle.getIntExtra("extra_launch_source", 2);
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 1))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692253);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
        this.jdField_a_of_type_Anth.a(false);
        this.jdField_a_of_type_Anth.notifyDataSetChanged();
      }
      g();
      b(1);
      this.jdField_a_of_type_Bcqf = new bcqf(this);
      super.addObserver(this.jdField_a_of_type_Ajvo);
      axqy.b(this.app, "CliOper", "", "", "ep_mall", "View_mine", 0, 0, "", "", "", "");
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
    super.removeObserver(this.jdField_a_of_type_Ajvo);
    anvw.a().b(this.jdField_a_of_type_Anwj);
    anvw.a().b(this.jdField_a_of_type_Anwk);
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
    ((ajvn)this.app.a(12)).a(0, 0);
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
    this.jdField_a_of_type_Askf.a(0, new abat(this));
  }
  
  public void f()
  {
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_Askf.a(0, new abau(this));
    }
  }
  
  public void finish()
  {
    anvw.a().b(this.jdField_a_of_type_Anwj);
    anvw.a().b(this.jdField_a_of_type_Anwk);
    this.jdField_a_of_type_Anth.b();
    super.finish();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_b_of_type_Int != 1)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692253);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
        this.jdField_a_of_type_Anth.a(false);
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
    default: 
    case 2131363758: 
      do
      {
        return;
        if (!bbfj.d(this))
        {
          paramView = new bcql(this);
          paramView.a(2130839277);
          paramView.d(1500);
          paramView.a(ajya.a(2131704044));
          paramView.b(0);
          return;
        }
        this.jdField_a_of_type_Bcqf.a(getString(2131692049));
        this.jdField_a_of_type_Bcqf.show();
        localObject = this.jdField_a_of_type_Anth.a();
      } while (((List)localObject).size() <= 0);
      URLDrawable.clearMemoryCache();
      paramView = (ajvn)this.app.a(12);
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
      axqy.b(this.app, "CliOper", "", "", "EmosSetting", "EpDelete", 0, 0, "", "", "", "");
      if (this.jdField_b_of_type_Int == 1)
      {
        axqy.b(this.app, "dc00898", "", "", "0X800AB12", "0X800AB12", localArrayList.size(), 0, "", "", "", "");
        return;
      }
      axqy.b(this.app, "dc00898", "", "", "0X800AB19", "0X800AB19", localArrayList.size(), 0, "", "", "", "");
      return;
    case 2131365603: 
      startActivity(new Intent(this, FavEmosmManageActivity.class));
      axqy.b(this.app, "dc00898", "", "", "0X800AB0B", "0X800AB0B", 0, 0, "", "", "", "");
      return;
    case 2131365599: 
      paramView = new Intent(this, FavEmosmManageActivity.class);
      paramView.putExtra("camera_emo_mode", 1);
      startActivity(paramView);
      axqy.b(this.app, "dc00898", "", "", "0X800AB0C", "0X800AB0C", 0, 0, "", "", "", "");
      return;
    }
    b(2);
    axqy.b(this.app, "dc00898", "", "", "0X800AB0D", "0X800AB0D", 0, 0, "", "", "", "");
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