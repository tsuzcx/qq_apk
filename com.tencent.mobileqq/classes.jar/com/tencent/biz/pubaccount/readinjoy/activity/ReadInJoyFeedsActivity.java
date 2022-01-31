package com.tencent.biz.pubaccount.readinjoy.activity;

import ajya;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import axrn;
import bbdh;
import bbfj;
import bfut;
import bfuw;
import bhvy;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.view.LeftRedDotRadioButton;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import mqq.os.MqqHandler;
import nol;
import nsy;
import ntd;
import nuo;
import nvx;
import nvy;
import nvz;
import onh;
import org.json.JSONObject;
import osg;
import osj;
import osl;
import osm;
import qkb;
import qvk;
import sdc;
import sfe;
import sgu;
import shu;

public class ReadInJoyFeedsActivity
  extends ReadInJoyBaseActivity
  implements View.OnClickListener, View.OnTouchListener, Observer
{
  private long jdField_a_of_type_Long;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  protected AccountDetailTopGestureLayout a;
  public Map<Integer, ntd> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
  private nvz jdField_a_of_type_Nvz;
  protected osm a;
  public boolean a;
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  
  public ReadInJoyFeedsActivity()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Osm = new nvy(this);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject2 = (KandianMergeManager)this.app.getManager(162);
    int i;
    Object localObject3;
    ArrayList localArrayList;
    if (((KandianMergeManager)localObject2).d())
    {
      localObject1 = getString(2131720576);
      i = 2130841968;
      localObject3 = getString(2131695050);
      localArrayList = new ArrayList();
      bfuw localbfuw = new bfuw();
      localbfuw.jdField_a_of_type_Int = 0;
      localbfuw.jdField_a_of_type_JavaLangString = ((String)localObject1);
      localbfuw.c = localbfuw.jdField_a_of_type_JavaLangString;
      localbfuw.jdField_b_of_type_Int = i;
      localArrayList.add(localbfuw);
      localObject1 = new bfuw();
      ((bfuw)localObject1).jdField_a_of_type_Int = 1;
      ((bfuw)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject3);
      ((bfuw)localObject1).c = ((bfuw)localObject1).jdField_a_of_type_JavaLangString;
      ((bfuw)localObject1).jdField_b_of_type_Int = 2130841966;
      localArrayList.add(localObject1);
      if (paramBoolean)
      {
        localObject3 = new bfuw();
        ((bfuw)localObject3).jdField_a_of_type_Int = 2;
        if (!bhvy.d(getAppRuntime())) {
          break label364;
        }
      }
    }
    label364:
    for (Object localObject1 = ajya.a(2131712804);; localObject1 = ajya.a(2131713019))
    {
      ((bfuw)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject1);
      ((bfuw)localObject3).jdField_b_of_type_Int = 2130848346;
      ((bfuw)localObject3).c = ((bfuw)localObject3).jdField_a_of_type_JavaLangString;
      localArrayList.add(localObject3);
      localObject1 = new bfuw();
      ((bfuw)localObject1).jdField_a_of_type_Int = 7;
      ((bfuw)localObject1).jdField_a_of_type_JavaLangString = ajya.a(2131713009);
      ((bfuw)localObject1).jdField_b_of_type_Int = 2130841970;
      localArrayList.add(localObject1);
      localObject1 = new bfuw();
      ((bfuw)localObject1).jdField_a_of_type_Int = 8;
      ((bfuw)localObject1).jdField_a_of_type_JavaLangString = ajya.a(2131712901);
      ((bfuw)localObject1).jdField_b_of_type_Int = 2130841967;
      localArrayList.add(localObject1);
      if (paramBoolean) {}
      localObject1 = bfut.a(this, localArrayList, new nvx(this, (KandianMergeManager)localObject2));
      localObject2 = this.jdField_b_of_type_AndroidViewViewGroup;
      ((bfut)localObject1).showAsDropDown((View)localObject2, ((View)localObject2).getWidth() - getResources().getDimensionPixelSize(2131298619) - getResources().getDimensionPixelSize(2131298615), getResources().getDimensionPixelSize(2131297957));
      return;
      localObject1 = getString(2131699666);
      i = 2130841969;
      break;
    }
  }
  
  private void b()
  {
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131375331));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131374833));
    int i = getIntent().getIntExtra("readinjoy_show_tab", -1);
    int j = getIntent().getIntExtra("tab_tab_index", 0);
    if (i >= 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(0);
      this.jdField_e_of_type_Int = j;
      c(j);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839753);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajya.a(2131713055));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_Int != 5)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690572));
      }
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(8);
      c();
    }
  }
  
  private void c()
  {
    nsy localnsy = new nsy(this);
    localnsy.a(this.jdField_c_of_type_AndroidViewViewGroup);
    localnsy.a();
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_e_of_type_Int), localnsy);
  }
  
  private void c(int paramInt)
  {
    this.jdField_c_of_type_AndroidViewViewGroup.removeAllViews();
    ntd localntd;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.setSelected(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setSelected(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setChecked(false);
      d(0);
      osg.a().g();
      localObject = (ntd)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localObject == null)
      {
        localObject = new nsy(this);
        ((ntd)localObject).a(this.jdField_c_of_type_AndroidViewViewGroup);
        ((ntd)localObject).a();
        localntd = (ntd)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(1));
        if (localntd != null) {
          localntd.c();
        }
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject);
      }
    }
    while (paramInt != 1) {
      for (;;)
      {
        return;
        ((ntd)localObject).b();
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.setSelected(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.setChecked(false);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setSelected(true);
    e(0);
    osg.a().f();
    Object localObject = (ntd)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      localObject = new nuo(this);
      ((ntd)localObject).a(this.jdField_c_of_type_AndroidViewViewGroup);
      ((ntd)localObject).a();
    }
    for (;;)
    {
      localntd = (ntd)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(0));
      if (localntd != null) {
        localntd.c();
      }
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject);
      return;
      ((ntd)localObject).b();
    }
  }
  
  private void d(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.a(false);
  }
  
  private void e(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(false);
  }
  
  public int a()
  {
    return this.jdField_e_of_type_Int;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      ThreadManager.post(new ReadInJoyFeedsActivity.3(this), 5, null, true);
    }
  }
  
  public void a(int paramInt)
  {
    Boolean localBoolean = Boolean.valueOf(true);
    if ((this.jdField_c_of_type_Int != 5) || (6 == this.jdField_c_of_type_Int) || (this.jdField_b_of_type_Boolean)) {
      localBoolean = Boolean.valueOf(false);
    }
    if (localBoolean.booleanValue()) {
      runOnUiThread(new ReadInJoyFeedsActivity.4(this, paramInt));
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_d_of_type_Int |= paramInt;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j = 80;
    int i;
    if (paramInt1 == 9992)
    {
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("isNeedFinish", false))) {
        finish();
      }
    }
    else if (paramInt1 == 9991)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseActivity", 2, "back from article detail");
      }
      if (onh.f())
      {
        i = j;
        if (TextUtils.isEmpty(sfe.h)) {}
      }
    }
    try
    {
      i = new JSONObject(sfe.h).optInt("releaseServiceMinMem", 80);
      long l = bbdh.e();
      if (l >>> 20 <= i)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseActivity", 2, "back from article detail, release web core service");
        }
        WebProcessManager.g();
      }
      try
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
        ((HashMap)localObject).put("param_totalMem", String.valueOf(bbdh.d()));
        ((HashMap)localObject).put("param_availableMem", String.valueOf(l));
        ((HashMap)localObject).put("param_cpuNum", String.valueOf(bbdh.b()));
        ((HashMap)localObject).put("param_cpuFreq", String.valueOf(bbdh.a()));
        ((HashMap)localObject).put("param_releaseType", String.valueOf(0));
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseActivity", 2, "releaseWebCoreServiceReport:" + ((HashMap)localObject).toString());
        }
        axrn.a(this).a(this.app.getCurrentAccountUin(), "actReadInJoyReleaseWebService", true, 0L, 0L, (HashMap)localObject, "");
      }
      catch (Exception localException1)
      {
        Object localObject;
        label287:
        break label287;
      }
      localObject = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        ((ntd)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).a(paramInt1, paramInt2, paramIntent);
      }
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    qvk.a().a(this);
    super.doOnCreate(paramBundle);
    bhvy.c(this.app);
    bhvy.d(this.app);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramBundle = getIntent();
    Bundle localBundle = paramBundle.getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("key_notification_click_action", false))) {
      ((KandianMergeManager)this.app.getManager(162)).g();
    }
    this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("from_search", false);
    this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("from_javascript", false);
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("launch_from", 5);
    osj.a().a();
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    int i = bbfj.a(getApplication());
    if ((i == 4) || (i == 1)) {
      ThreadManager.post(new ReadInJoyFeedsActivity.1(this), 5, null, true);
    }
    ThreadManager.executeOnSubThread(new ReadInJoyFeedsActivity.MyRunnable(this, this));
    setContentView(2131559931);
    getWindow().setBackgroundDrawable(null);
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout = new AccountDetailTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout);
    }
    paramBundle = (osl)this.app.getManager(163);
    osg.a().h();
    osg.a().d();
    setTitle(sfe.b(this.app, this.app.getApp()));
    b();
    this.jdField_b_of_type_AndroidViewViewGroup.setOnTouchListener(this);
    this.jdField_a_of_type_Nvz = new nvz((ntd)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.jdField_e_of_type_Int)));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this, this.jdField_a_of_type_Nvz);
    if (this.app.a() != null) {
      this.app.a().addObserver(this);
    }
    if (bhvy.a(this.app)) {
      sdc.a().c(this.app);
    }
    osj.a().a(this.jdField_a_of_type_Osm);
    bhvy.a(this.app);
    this.jdField_b_of_type_Int = onh.jdField_d_of_type_Int;
    shu.a(1, true, 0L, this.jdField_b_of_type_Int, 0);
    onh.g(this.app);
    return true;
  }
  
  public void doOnDestroy()
  {
    osj.a().b(this.jdField_a_of_type_Osm);
    super.doOnDestroy();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
    if (l > 0L) {
      nol.a(null, "CliOper", "", "", "0X80066F7", "0X80066F7", 0, 0, Long.toString(l / 1000L), "", "", onh.d(), false);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      ((ntd)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).d();
    }
    if (this.app.a() != null) {
      this.app.a().deleteObserver(this);
    }
    localObject = (osl)this.app.getManager(163);
    osg.a().i();
    qvk.a().b(this);
    PreloadManager.a().b();
    PreloadManager.a().e();
    shu.a(1, false, this.jdField_a_of_type_Long, this.jdField_b_of_type_Int, this.jdField_d_of_type_Int);
    PublicAccountImageCollectionPreloadManager.a().d();
    PublicAccountImageCollectionPreloadManager.a().c();
    WebProcessManager.g();
    WebProcessManager.h();
    qkb.a();
    qkb.a().b();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("from_search", false);
    this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("from_javascript", false);
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("launch_from", 5);
    int i = getIntent().getIntExtra("readinjoy_show_tab", -1);
    int j = getIntent().getIntExtra("tab_tab_index", 0);
    if (i >= 0)
    {
      this.jdField_e_of_type_Int = j;
      c(j);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ntd)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).g();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      sgu.a("KANDIAN_FEEDS_STAGE_1_COST", null);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ntd)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).h();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    osg.a().j();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ntd)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).e();
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_e_of_type_Long += this.jdField_d_of_type_Long - this.jdField_c_of_type_Long;
    osg.a().k();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ntd)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).f();
    }
  }
  
  public void finish()
  {
    super.finish();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ntd)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).o();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131368441: 
      do
      {
        return;
      } while (!bhvy.a(this.app));
      a(false);
      return;
    case 2131368476: 
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.a()) {
        nol.a(null, "CliOper", "", "", "0X80067D0", "0X80067D0", 0, 0, "", "", "", onh.c(), false);
      }
      while (this.jdField_e_of_type_Int == 0)
      {
        ((ntd)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.jdField_e_of_type_Int))).a(true);
        return;
        nol.a(null, "CliOper", "", "", "0X80067CF", "0X80067CF", 0, 0, "", "", "", onh.c(), false);
      }
      this.jdField_e_of_type_Int = 0;
      c(this.jdField_e_of_type_Int);
      ((KandianMergeManager)this.app.getManager(162)).b(0);
      return;
    }
    sgu.a(null, "KANDIAN_TO_SUBSCRIPT_COST");
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a()) {
      nol.a(null, "CliOper", "", "", "0X80067D2", "0X80067D2", 0, 0, "", "", "", onh.c(), false);
    }
    while (this.jdField_e_of_type_Int == 1)
    {
      ((ntd)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.jdField_e_of_type_Int))).a(true);
      return;
      nol.a(null, "CliOper", "", "", "0X80067D1", "0X80067D1", 0, 0, "", "", "", onh.c(), false);
    }
    this.jdField_e_of_type_Int = 1;
    c(this.jdField_e_of_type_Int);
    ((KandianMergeManager)this.app.getManager(162)).b(1);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean) && ((paramObject instanceof MessageRecord)) && (KandianMergeManager.a((MessageRecord)paramObject, this.app) == -1) && (!((MessageRecord)paramObject).isSendFromLocal())) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity
 * JD-Core Version:    0.7.0.1
 */