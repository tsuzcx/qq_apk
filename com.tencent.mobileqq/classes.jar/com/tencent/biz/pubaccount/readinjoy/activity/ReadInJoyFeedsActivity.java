package com.tencent.biz.pubaccount.readinjoy.activity;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
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
import anvx;
import bdla;
import bhcu;
import bleh;
import blek;
import bmhv;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.view.LeftRedDotRadioButton;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import mqq.os.MqqHandler;
import olh;
import oqo;
import oqu;
import org.json.JSONObject;
import ose;
import otm;
import otn;
import oto;
import pjj;
import pkh;
import pno;
import pqf;
import prm;
import prp;
import pvj;
import pvm;
import pvp;
import pvq;
import sfq;
import sqp;
import tto;
import uqx;
import usu;
import uuq;
import uvs;

public class ReadInJoyFeedsActivity
  extends ReadInJoyBaseActivity
  implements View.OnClickListener, View.OnTouchListener, Observer
{
  private long jdField_a_of_type_Long;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  protected AccountDetailTopGestureLayout a;
  public Map<Integer, oqu> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
  private oto jdField_a_of_type_Oto;
  protected pvq a;
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
    this.jdField_a_of_type_Pvq = new otn(this);
  }
  
  private void a(blek paramblek)
  {
    if (paramblek.jdField_a_of_type_Int == 3) {
      pkh.jdField_a_of_type_Int = -2;
    }
    for (;;)
    {
      QLog.d("ReadInJoyBaseActivity", 1, "readinjoy setting feeds type:" + pkh.jdField_a_of_type_Int);
      return;
      if (paramblek.jdField_a_of_type_Int == 4) {
        pkh.jdField_a_of_type_Int = -1;
      } else if (paramblek.jdField_a_of_type_Int == 5) {
        pkh.jdField_a_of_type_Int = 1;
      } else if (paramblek.jdField_a_of_type_Int == 6) {
        pkh.jdField_a_of_type_Int = 0;
      }
    }
  }
  
  private void a(blek paramblek, KandianMergeManager paramKandianMergeManager)
  {
    if (paramKandianMergeManager.d()) {
      paramKandianMergeManager = getString(2131719728);
    }
    for (int i = 2130842532;; i = 2130842533)
    {
      paramblek.jdField_a_of_type_Int = 0;
      paramblek.jdField_a_of_type_JavaLangString = paramKandianMergeManager;
      paramblek.c = paramblek.jdField_a_of_type_JavaLangString;
      paramblek.jdField_b_of_type_Int = i;
      return;
      paramKandianMergeManager = getString(2131699159);
    }
  }
  
  private void a(KandianMergeManager paramKandianMergeManager)
  {
    if (!paramKandianMergeManager.d()) {}
    for (boolean bool = true;; bool = false)
    {
      paramKandianMergeManager.b(bool);
      if (!bool) {
        break;
      }
      QQToast.a(this, getResources().getString(2131699158), 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299080));
      olh.a(null, "CliOper", "", "", "0X80067D6", "0X80067D6", 0, 0, "", "", "", pqf.a(), false);
      return;
    }
    olh.a(null, "CliOper", "", "", "0X800705C", "0X800705C", 0, 0, "", "", "", pqf.a(), false);
  }
  
  private void a(List<blek> paramList) {}
  
  private void a(boolean paramBoolean)
  {
    Object localObject2 = (KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    Object localObject1 = getString(2131694596);
    ArrayList localArrayList = new ArrayList();
    blek localblek = new blek();
    a(localblek, (KandianMergeManager)localObject2);
    localArrayList.add(localblek);
    localblek = new blek();
    localblek.jdField_a_of_type_Int = 1;
    localblek.jdField_a_of_type_JavaLangString = ((String)localObject1);
    localblek.c = localblek.jdField_a_of_type_JavaLangString;
    localblek.jdField_b_of_type_Int = 2130842530;
    localArrayList.add(localblek);
    if (paramBoolean)
    {
      localblek = new blek();
      localblek.jdField_a_of_type_Int = 2;
      if (!bmhv.d(getAppRuntime())) {
        break label318;
      }
    }
    label318:
    for (localObject1 = anvx.a(2131712255);; localObject1 = anvx.a(2131712470))
    {
      localblek.jdField_a_of_type_JavaLangString = ((String)localObject1);
      localblek.jdField_b_of_type_Int = 2130849326;
      localblek.c = localblek.jdField_a_of_type_JavaLangString;
      localArrayList.add(localblek);
      a(localArrayList);
      localObject1 = new blek();
      ((blek)localObject1).jdField_a_of_type_Int = 7;
      ((blek)localObject1).jdField_a_of_type_JavaLangString = anvx.a(2131712460);
      ((blek)localObject1).jdField_b_of_type_Int = 2130842534;
      localArrayList.add(localObject1);
      localObject1 = new blek();
      ((blek)localObject1).jdField_a_of_type_Int = 8;
      ((blek)localObject1).jdField_a_of_type_JavaLangString = anvx.a(2131712352);
      ((blek)localObject1).jdField_b_of_type_Int = 2130842531;
      localArrayList.add(localObject1);
      if (paramBoolean) {}
      localObject1 = bleh.a(this, localArrayList, new otm(this, (KandianMergeManager)localObject2));
      localObject2 = this.jdField_b_of_type_AndroidViewViewGroup;
      ((bleh)localObject1).showAsDropDown((View)localObject2, ((View)localObject2).getWidth() - getResources().getDimensionPixelSize(2131298811) - getResources().getDimensionPixelSize(2131298807), getResources().getDimensionPixelSize(2131298139));
      return;
    }
  }
  
  private void b()
  {
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376762));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131376226));
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840365);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131712506));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_Int != 5)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690676));
      }
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(8);
      f();
    }
  }
  
  private void b(blek paramblek, KandianMergeManager paramKandianMergeManager)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    switch (paramblek.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      a(paramKandianMergeManager);
      return;
    case 1: 
      c();
      return;
    case 2: 
      paramblek = getAppRuntime();
      if (!bmhv.d(getAppRuntime())) {}
      for (;;)
      {
        bmhv.b(paramblek, bool1);
        pvm.a().b();
        return;
        bool1 = false;
      }
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      a(paramblek);
      return;
    case 7: 
      d();
      return;
    case 8: 
      e();
      return;
    case 9: 
      paramblek = getAppRuntime();
      if (!bmhv.f(getAppRuntime())) {}
      for (bool1 = bool2;; bool1 = false)
      {
        bmhv.e(paramblek, bool1);
        return;
      }
    }
    paramblek = getAppRuntime();
    if (!bmhv.h(getAppRuntime())) {}
    for (bool1 = bool3;; bool1 = false)
    {
      bmhv.g(paramblek, bool1);
      return;
    }
  }
  
  private void c()
  {
    ThreadManager.postImmediately(new ReadInJoyFeedsActivity.6(this), null, true);
    startActivity(new Intent(this, ReadInJoySettingActivity.class));
    bdla.b(null, "CliOper", "", "", "0X800705B", "0X800705B", 0, 0, "", "", "", pqf.a());
  }
  
  private void c(int paramInt)
  {
    this.jdField_c_of_type_AndroidViewViewGroup.removeAllViews();
    oqu localoqu;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.setSelected(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setSelected(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setChecked(false);
      d(0);
      pvj.a().g();
      localObject = (oqu)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localObject == null)
      {
        localObject = new oqo(this);
        ((oqu)localObject).a(this.jdField_c_of_type_AndroidViewViewGroup);
        ((oqu)localObject).a();
        localoqu = (oqu)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(1));
        if (localoqu != null) {
          localoqu.c();
        }
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject);
      }
    }
    while (paramInt != 1) {
      for (;;)
      {
        return;
        ((oqu)localObject).b();
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.setSelected(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.setChecked(false);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setSelected(true);
    e(0);
    pvj.a().f();
    Object localObject = (oqu)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      localObject = new ose(this);
      ((oqu)localObject).a(this.jdField_c_of_type_AndroidViewViewGroup);
      ((oqu)localObject).a();
    }
    for (;;)
    {
      localoqu = (oqu)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(0));
      if (localoqu != null) {
        localoqu.c();
      }
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject);
      return;
      ((oqu)localObject).b();
    }
  }
  
  private void d()
  {
    String str = pkh.a();
    if (TextUtils.isEmpty(str)) {
      QLog.e("ReadInJoyBaseActivity", 2, "click personal page , but uin is empty !");
    }
    for (;;)
    {
      olh.a(null, "CliOper", "", "", "0X8007384", "0X8007384", 0, 0, "", "", "", pqf.a(), false);
      return;
      pkh.a(this, pjj.g + bhcu.encodeToString(str.getBytes(), 2));
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
  
  private void e()
  {
    olh.a(null, "CliOper", "", "", "0X8007383", "0X8007383", 0, 0, "", "", "", pqf.a(), false);
    if (Boolean.valueOf(bmhv.u(pkh.a())).booleanValue())
    {
      tto.a(this, anvx.a(2131712264), tto.a(pkh.a()) + "&adtag=1&privateLetters=", null);
      return;
    }
    pkh.a(this, pjj.d);
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
  
  private void f()
  {
    oqo localoqo = new oqo(this);
    localoqo.a(this.jdField_c_of_type_AndroidViewViewGroup);
    localoqo.a();
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_e_of_type_Int), localoqo);
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
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
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
      if (prm.a())
      {
        i = j;
        if (TextUtils.isEmpty(usu.h)) {}
      }
    }
    try
    {
      i = new JSONObject(usu.h).optInt("releaseServiceMinMem", 80);
      long l = DeviceInfoUtil.getSystemAvaialbeMemory();
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
        ((HashMap)localObject).put("param_totalMem", String.valueOf(DeviceInfoUtil.getSystemTotalMemory()));
        ((HashMap)localObject).put("param_availableMem", String.valueOf(l));
        ((HashMap)localObject).put("param_cpuNum", String.valueOf(DeviceInfoUtil.getCpuNumber()));
        ((HashMap)localObject).put("param_cpuFreq", String.valueOf(DeviceInfoUtil.getCpuFrequency()));
        ((HashMap)localObject).put("param_releaseType", String.valueOf(0));
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseActivity", 2, "releaseWebCoreServiceReport:" + ((HashMap)localObject).toString());
        }
        StatisticCollector.getInstance(this).collectPerformance(this.app.getCurrentAccountUin(), "actReadInJoyReleaseWebService", true, 0L, 0L, (HashMap)localObject, "");
      }
      catch (Exception localException1)
      {
        Object localObject;
        label283:
        break label283;
      }
      localObject = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        ((oqu)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).a(paramInt1, paramInt2, paramIntent);
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
    sqp.a().a(this);
    super.doOnCreate(paramBundle);
    bmhv.c(this.app);
    bmhv.d(this.app);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramBundle = getIntent();
    Bundle localBundle = paramBundle.getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("key_notification_click_action", false))) {
      ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).h();
    }
    this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("from_search", false);
    this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("from_javascript", false);
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("launch_from", 5);
    pvm.a().a();
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    int i = NetworkUtil.getSystemNetwork(getApplication());
    if ((i == 4) || (i == 1)) {
      ThreadManager.post(new ReadInJoyFeedsActivity.1(this), 5, null, true);
    }
    ThreadManager.executeOnSubThread(new ReadInJoyFeedsActivity.MyRunnable(this, this));
    setContentView(2131560240);
    getWindow().setBackgroundDrawable(null);
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout = new AccountDetailTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout);
    }
    paramBundle = (pvp)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    pvj.a().h();
    pvj.a().d();
    setTitle(usu.b(this.app, this.app.getApp()));
    b();
    this.jdField_b_of_type_AndroidViewViewGroup.setOnTouchListener(this);
    this.jdField_a_of_type_Oto = new oto((oqu)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.jdField_e_of_type_Int)));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this, this.jdField_a_of_type_Oto);
    if (this.app.getMessageFacade() != null) {
      this.app.getMessageFacade().addObserver(this);
    }
    if (bmhv.a(this.app)) {
      uqx.a().c(this.app);
    }
    pvm.a().a(this.jdField_a_of_type_Pvq);
    bmhv.a(this.app);
    this.jdField_b_of_type_Int = prp.jdField_a_of_type_Int;
    uvs.a(1, true, 0L, this.jdField_b_of_type_Int, 0);
    pno.a(this.app);
    return true;
  }
  
  public void doOnDestroy()
  {
    pvm.a().b(this.jdField_a_of_type_Pvq);
    super.doOnDestroy();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
    if (l > 0L) {
      olh.a(null, "CliOper", "", "", "0X80066F7", "0X80066F7", 0, 0, Long.toString(l / 1000L), "", "", pqf.b(), false);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      ((oqu)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).d();
    }
    if (this.app.getMessageFacade() != null) {
      this.app.getMessageFacade().deleteObserver(this);
    }
    localObject = (pvp)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    pvj.a().i();
    sqp.a().b(this);
    PreloadManager.a().b();
    PreloadManager.a().e();
    uvs.a(1, false, this.jdField_a_of_type_Long, this.jdField_b_of_type_Int, this.jdField_d_of_type_Int);
    PublicAccountImageCollectionPreloadManager.a().d();
    PublicAccountImageCollectionPreloadManager.a().c();
    WebProcessManager.g();
    WebProcessManager.h();
    sfq.a();
    sfq.a().b();
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
      ((oqu)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).g();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      uuq.a("KANDIAN_FEEDS_STAGE_1_COST", null);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((oqu)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).h();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    pvj.a().j();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((oqu)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).e();
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_e_of_type_Long += this.jdField_d_of_type_Long - this.jdField_c_of_type_Long;
    pvj.a().k();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((oqu)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).f();
    }
  }
  
  public void finish()
  {
    super.finish();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((oqu)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).n();
    }
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
      if (bmhv.a(this.app))
      {
        a(false);
        continue;
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.a()) {
          olh.a(null, "CliOper", "", "", "0X80067D0", "0X80067D0", 0, 0, "", "", "", pqf.a(), false);
        }
        for (;;)
        {
          if (this.jdField_e_of_type_Int != 0) {
            break label168;
          }
          ((oqu)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.jdField_e_of_type_Int))).a(true);
          break;
          olh.a(null, "CliOper", "", "", "0X80067CF", "0X80067CF", 0, 0, "", "", "", pqf.a(), false);
        }
        label168:
        this.jdField_e_of_type_Int = 0;
        c(this.jdField_e_of_type_Int);
        ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b(0);
        continue;
        uuq.a(null, "KANDIAN_TO_SUBSCRIPT_COST");
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a()) {
          olh.a(null, "CliOper", "", "", "0X80067D2", "0X80067D2", 0, 0, "", "", "", pqf.a(), false);
        }
        for (;;)
        {
          if (this.jdField_e_of_type_Int != 1) {
            break label311;
          }
          ((oqu)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.jdField_e_of_type_Int))).a(true);
          break;
          olh.a(null, "CliOper", "", "", "0X80067D1", "0X80067D1", 0, 0, "", "", "", pqf.a(), false);
        }
        label311:
        this.jdField_e_of_type_Int = 1;
        c(this.jdField_e_of_type_Int);
        ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b(1);
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity
 * JD-Core Version:    0.7.0.1
 */