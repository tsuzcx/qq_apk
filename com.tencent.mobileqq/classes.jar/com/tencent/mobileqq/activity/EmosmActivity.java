package com.tencent.mobileqq.activity;

import acrr;
import acrs;
import acrt;
import acru;
import acrv;
import acrw;
import acrx;
import acry;
import acrz;
import acsa;
import acsb;
import alna;
import alnb;
import alpo;
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
import apkp;
import apkr;
import aplb;
import aplf;
import apne;
import apnr;
import apns;
import aube;
import azmj;
import bdee;
import bepp;
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
  alnb jdField_a_of_type_Alnb = new acrr(this);
  public View a;
  public Button a;
  public TextView a;
  public apkp<EmoticonPackage> a;
  aplb jdField_a_of_type_Aplb = new acru(this);
  aplf jdField_a_of_type_Aplf = new acrv(this);
  apnr jdField_a_of_type_Apnr;
  apns jdField_a_of_type_Apns;
  public aube a;
  public bepp a;
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
      if (k < this.jdField_a_of_type_Apkp.getCount())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.jdField_a_of_type_Apkp.getItem(k);
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
        aube.d(String.valueOf(paramEmoticonResp.resultcode), k);
        return;
      }
      label88:
      k += 1;
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131363384));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)findViewById(2131363384));
    this.j = findViewById(2131376852);
    this.j.setBackgroundColor(getResources().getColor(2131165585));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(findViewById(2131365697));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
    Drawable localDrawable = getResources().getDrawable(2130849679);
    localDrawable.setAlpha(235);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(localDrawable);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
  }
  
  public apkr a(DragSortListView paramDragSortListView)
  {
    paramDragSortListView = new apkr(paramDragSortListView);
    paramDragSortListView.d(2131365482);
    paramDragSortListView.e(2131364319);
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
    localQQToast.a(2130839366);
    localQQToast.d(1500);
    localQQToast.a(alpo.a(2131704417));
    localQQToast.b(0);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Apkp.b(true);
    int k = 0;
    for (;;)
    {
      EmoticonPackage localEmoticonPackage;
      if (k < this.jdField_a_of_type_Apkp.getCount())
      {
        localEmoticonPackage = (EmoticonPackage)this.jdField_a_of_type_Apkp.getItem(k);
        if (!localEmoticonPackage.epId.equals(paramInt + "")) {
          break label177;
        }
        this.jdField_a_of_type_Apkp.a(localEmoticonPackage);
        if (localEmoticonPackage.type != 1) {
          break label172;
        }
      }
      label172:
      for (paramInt = 5;; paramInt = 4)
      {
        aube.d("0", paramInt);
        String str = localEmoticonPackage.epId;
        if ((3 != localEmoticonPackage.jobType) && (1 != localEmoticonPackage.jobType) && (5 != localEmoticonPackage.jobType)) {
          ThreadManager.getFileThreadHandler().post(new EmosmActivity.2(this, str));
        }
        if (3 == localEmoticonPackage.jobType) {
          azmj.b(this.app, "CliOper", "", "", "MbGuanli", "MbDianjiShanchu", 0, 0, "", "", "", "");
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
      setTitle(String.format(getResources().getString(2131692330), new Object[] { Integer.valueOf(0) }));
    }
    this.jdField_a_of_type_Bepp.dismiss();
    if ((this.jdField_b_of_type_Int == 2) && (this.jdField_a_of_type_Apkp.getCount() == 0)) {
      azmj.b(this.app, "CliOper", "", "", "0X80060AA", "0X80060AA", 0, 0, "", "", "", "");
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
        this.leftView.setText(2131692092);
        return;
      }
      str = new JSONObject(str).optString("leftText", getString(2131692092));
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
    this.jdField_a_of_type_Aube.a(0, new acsb(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131559088);
    super.setContentBackgroundResource(2130838591);
    super.setTitle(2131692340);
    c();
    this.jdField_a_of_type_AndroidWidgetTextView = this.rightViewText;
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692329);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new acrw(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131363814));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365906));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new acrx(this));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = ((DragSortListView)super.findViewById(16908298));
      paramBundle = a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setFloatViewManager(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnTouchListener(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDelImmediately(false);
      this.jdField_a_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getContext(), 2131559089, null);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365686);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365687);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365688));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(2130839453));
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365682);
      this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131365683);
      this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131365684);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(2130839453));
      this.g = this.jdField_a_of_type_AndroidViewView.findViewById(2131365699);
      this.h = this.jdField_a_of_type_AndroidViewView.findViewById(2131365700);
      this.i = this.jdField_a_of_type_AndroidViewView.findViewById(2131365701);
      this.g.setBackgroundResource(2130839453);
      this.g.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Aube = ((aube)this.app.getManager(14));
      paramBundle = super.getIntent();
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("extra_launch_mode", 1);
      this.jdField_a_of_type_JavaLangRunnable = new EmosmActivity.5(this);
      this.jdField_a_of_type_JavaLangRunnable.run();
      this.jdField_a_of_type_Apkp = new apkp(this, this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Apkp.jdField_a_of_type_Int = -16745986;
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setAdapter(this.jdField_a_of_type_Apkp);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDropListener(this.jdField_a_of_type_Aplb);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setRemoveListener(this.jdField_a_of_type_Aplf);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnItemClickListener(new acry(this));
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Apnr = new acrz(this);
      apne.a().a(this.jdField_a_of_type_Apnr);
      this.jdField_a_of_type_Apns = new acsa(this);
      apne.a().a(this.jdField_a_of_type_Apns);
      this.jdField_a_of_type_Int = paramBundle.getIntExtra("extra_launch_source", 2);
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 1))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692329);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
        this.jdField_a_of_type_Apkp.a(false);
        this.jdField_a_of_type_Apkp.notifyDataSetChanged();
      }
      g();
      b(1);
      this.jdField_a_of_type_Bepp = new bepp(this);
      super.addObserver(this.jdField_a_of_type_Alnb);
      azmj.b(this.app, "CliOper", "", "", "ep_mall", "View_mine", 0, 0, "", "", "", "");
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
    super.removeObserver(this.jdField_a_of_type_Alnb);
    apne.a().b(this.jdField_a_of_type_Apnr);
    apne.a().b(this.jdField_a_of_type_Apns);
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
    ((alna)this.app.a(12)).a(0, 0);
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
    this.jdField_a_of_type_Aube.a(0, new acrs(this));
  }
  
  public void f()
  {
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_Aube.a(0, new acrt(this));
    }
  }
  
  public void finish()
  {
    apne.a().b(this.jdField_a_of_type_Apnr);
    apne.a().b(this.jdField_a_of_type_Apns);
    this.jdField_a_of_type_Apkp.b();
    super.finish();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_b_of_type_Int != 1)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692329);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
        this.jdField_a_of_type_Apkp.a(false);
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
    case 2131363814: 
      do
      {
        return;
        if (!bdee.d(this))
        {
          paramView = new QQToast(this);
          paramView.a(2130839366);
          paramView.d(1500);
          paramView.a(alpo.a(2131704416));
          paramView.b(0);
          return;
        }
        this.jdField_a_of_type_Bepp.a(getString(2131692104));
        this.jdField_a_of_type_Bepp.show();
        localObject = this.jdField_a_of_type_Apkp.a();
      } while (((List)localObject).size() <= 0);
      URLDrawable.clearMemoryCache();
      paramView = (alna)this.app.a(12);
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
      azmj.b(this.app, "CliOper", "", "", "EmosSetting", "EpDelete", 0, 0, "", "", "", "");
      if (this.jdField_b_of_type_Int == 1)
      {
        azmj.b(this.app, "dc00898", "", "", "0X800AB12", "0X800AB12", localArrayList.size(), 0, "", "", "", "");
        return;
      }
      azmj.b(this.app, "dc00898", "", "", "0X800AB19", "0X800AB19", localArrayList.size(), 0, "", "", "", "");
      return;
    case 2131365686: 
      startActivity(new Intent(this, FavEmosmManageActivity.class));
      azmj.b(this.app, "dc00898", "", "", "0X800AB0B", "0X800AB0B", 0, 0, "", "", "", "");
      return;
    case 2131365682: 
      paramView = new Intent(this, FavEmosmManageActivity.class);
      paramView.putExtra("camera_emo_mode", 1);
      startActivity(paramView);
      azmj.b(this.app, "dc00898", "", "", "0X800AB0C", "0X800AB0C", 0, 0, "", "", "", "");
      return;
    }
    b(2);
    azmj.b(this.app, "dc00898", "", "", "0X800AB0D", "0X800AB0D", 0, 0, "", "", "", "");
  }
  
  protected void onRestart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "emosm activity ..............onRestart");
    }
    super.onRestart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity
 * JD-Core Version:    0.7.0.1
 */