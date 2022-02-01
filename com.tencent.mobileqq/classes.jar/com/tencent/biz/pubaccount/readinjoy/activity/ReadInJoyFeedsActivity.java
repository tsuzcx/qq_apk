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
import anzj;
import bdmc;
import bhlo;
import bhnv;
import blol;
import bloo;
import bnrf;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.view.LeftRedDotRadioButton;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.mobileqq.webprocess.WebProcessManager;
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
import ocd;
import ohf;
import ohl;
import oiv;
import oke;
import okf;
import okg;
import org.json.JSONObject;
import ozs;
import pfa;
import pfd;
import pfg;
import pfh;
import rlz;
import rxg;
import twk;
import tyi;
import uae;
import ubg;

public class ReadInJoyFeedsActivity
  extends ReadInJoyBaseActivity
  implements View.OnClickListener, View.OnTouchListener, Observer
{
  private long jdField_a_of_type_Long;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  protected AccountDetailTopGestureLayout a;
  public Map<Integer, ohl> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
  private okg jdField_a_of_type_Okg;
  protected pfh a;
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
    this.jdField_a_of_type_Pfh = new okf(this);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject2 = (KandianMergeManager)this.app.getManager(162);
    int i;
    Object localObject3;
    ArrayList localArrayList;
    if (((KandianMergeManager)localObject2).d())
    {
      localObject1 = getString(2131719020);
      i = 2130842456;
      localObject3 = getString(2131694281);
      localArrayList = new ArrayList();
      bloo localbloo = new bloo();
      localbloo.jdField_a_of_type_Int = 0;
      localbloo.jdField_a_of_type_JavaLangString = ((String)localObject1);
      localbloo.c = localbloo.jdField_a_of_type_JavaLangString;
      localbloo.jdField_b_of_type_Int = i;
      localArrayList.add(localbloo);
      localObject1 = new bloo();
      ((bloo)localObject1).jdField_a_of_type_Int = 1;
      ((bloo)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject3);
      ((bloo)localObject1).c = ((bloo)localObject1).jdField_a_of_type_JavaLangString;
      ((bloo)localObject1).jdField_b_of_type_Int = 2130842454;
      localArrayList.add(localObject1);
      if (paramBoolean)
      {
        localObject3 = new bloo();
        ((bloo)localObject3).jdField_a_of_type_Int = 2;
        if (!bnrf.d(getAppRuntime())) {
          break label364;
        }
      }
    }
    label364:
    for (Object localObject1 = anzj.a(2131711676);; localObject1 = anzj.a(2131711891))
    {
      ((bloo)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject1);
      ((bloo)localObject3).jdField_b_of_type_Int = 2130849323;
      ((bloo)localObject3).c = ((bloo)localObject3).jdField_a_of_type_JavaLangString;
      localArrayList.add(localObject3);
      localObject1 = new bloo();
      ((bloo)localObject1).jdField_a_of_type_Int = 7;
      ((bloo)localObject1).jdField_a_of_type_JavaLangString = anzj.a(2131711881);
      ((bloo)localObject1).jdField_b_of_type_Int = 2130842458;
      localArrayList.add(localObject1);
      localObject1 = new bloo();
      ((bloo)localObject1).jdField_a_of_type_Int = 8;
      ((bloo)localObject1).jdField_a_of_type_JavaLangString = anzj.a(2131711773);
      ((bloo)localObject1).jdField_b_of_type_Int = 2130842455;
      localArrayList.add(localObject1);
      if (paramBoolean) {}
      localObject1 = blol.a(this, localArrayList, new oke(this, (KandianMergeManager)localObject2));
      localObject2 = this.jdField_b_of_type_AndroidViewViewGroup;
      ((blol)localObject1).showAsDropDown((View)localObject2, ((View)localObject2).getWidth() - getResources().getDimensionPixelSize(2131298742) - getResources().getDimensionPixelSize(2131298738), getResources().getDimensionPixelSize(2131298071));
      return;
      localObject1 = getString(2131698580);
      i = 2130842457;
      break;
    }
  }
  
  private void b()
  {
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376733));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131376213));
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840291);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anzj.a(2131711927));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_Int != 5)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690559));
      }
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(8);
      c();
    }
  }
  
  private void c()
  {
    ohf localohf = new ohf(this);
    localohf.a(this.jdField_c_of_type_AndroidViewViewGroup);
    localohf.a();
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_e_of_type_Int), localohf);
  }
  
  private void c(int paramInt)
  {
    this.jdField_c_of_type_AndroidViewViewGroup.removeAllViews();
    ohl localohl;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.setSelected(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setSelected(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setChecked(false);
      d(0);
      pfa.a().g();
      localObject = (ohl)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localObject == null)
      {
        localObject = new ohf(this);
        ((ohl)localObject).a(this.jdField_c_of_type_AndroidViewViewGroup);
        ((ohl)localObject).a();
        localohl = (ohl)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(1));
        if (localohl != null) {
          localohl.c();
        }
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject);
      }
    }
    while (paramInt != 1) {
      for (;;)
      {
        return;
        ((ohl)localObject).b();
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.setSelected(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.setChecked(false);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setSelected(true);
    e(0);
    pfa.a().f();
    Object localObject = (ohl)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      localObject = new oiv(this);
      ((ohl)localObject).a(this.jdField_c_of_type_AndroidViewViewGroup);
      ((ohl)localObject).a();
    }
    for (;;)
    {
      localohl = (ohl)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(0));
      if (localohl != null) {
        localohl.c();
      }
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject);
      return;
      ((ohl)localObject).b();
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
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
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
      if (ozs.h())
      {
        i = j;
        if (TextUtils.isEmpty(tyi.h)) {}
      }
    }
    try
    {
      i = new JSONObject(tyi.h).optInt("releaseServiceMinMem", 80);
      long l = bhlo.e();
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
        ((HashMap)localObject).put("param_totalMem", String.valueOf(bhlo.d()));
        ((HashMap)localObject).put("param_availableMem", String.valueOf(l));
        ((HashMap)localObject).put("param_cpuNum", String.valueOf(bhlo.b()));
        ((HashMap)localObject).put("param_cpuFreq", String.valueOf(bhlo.a()));
        ((HashMap)localObject).put("param_releaseType", String.valueOf(0));
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseActivity", 2, "releaseWebCoreServiceReport:" + ((HashMap)localObject).toString());
        }
        bdmc.a(this).a(this.app.getCurrentAccountUin(), "actReadInJoyReleaseWebService", true, 0L, 0L, (HashMap)localObject, "");
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
        ((ohl)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).a(paramInt1, paramInt2, paramIntent);
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
    rxg.a().a(this);
    super.doOnCreate(paramBundle);
    bnrf.c(this.app);
    bnrf.d(this.app);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramBundle = getIntent();
    Bundle localBundle = paramBundle.getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("key_notification_click_action", false))) {
      ((KandianMergeManager)this.app.getManager(162)).h();
    }
    this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("from_search", false);
    this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("from_javascript", false);
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("launch_from", 5);
    pfd.a().a();
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    int i = bhnv.a(getApplication());
    if ((i == 4) || (i == 1)) {
      ThreadManager.post(new ReadInJoyFeedsActivity.1(this), 5, null, true);
    }
    ThreadManager.executeOnSubThread(new ReadInJoyFeedsActivity.MyRunnable(this, this));
    setContentView(2131560187);
    getWindow().setBackgroundDrawable(null);
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout = new AccountDetailTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout);
    }
    paramBundle = (pfg)this.app.getManager(163);
    pfa.a().h();
    pfa.a().d();
    setTitle(tyi.b(this.app, this.app.getApp()));
    b();
    this.jdField_b_of_type_AndroidViewViewGroup.setOnTouchListener(this);
    this.jdField_a_of_type_Okg = new okg((ohl)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.jdField_e_of_type_Int)));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this, this.jdField_a_of_type_Okg);
    if (this.app.a() != null) {
      this.app.a().addObserver(this);
    }
    if (bnrf.a(this.app)) {
      twk.a().c(this.app);
    }
    pfd.a().a(this.jdField_a_of_type_Pfh);
    bnrf.a(this.app);
    this.jdField_b_of_type_Int = ozs.jdField_d_of_type_Int;
    ubg.a(1, true, 0L, this.jdField_b_of_type_Int, 0);
    ozs.g(this.app);
    return true;
  }
  
  public void doOnDestroy()
  {
    pfd.a().b(this.jdField_a_of_type_Pfh);
    super.doOnDestroy();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
    if (l > 0L) {
      ocd.a(null, "CliOper", "", "", "0X80066F7", "0X80066F7", 0, 0, Long.toString(l / 1000L), "", "", ozs.f(), false);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      ((ohl)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).d();
    }
    if (this.app.a() != null) {
      this.app.a().deleteObserver(this);
    }
    localObject = (pfg)this.app.getManager(163);
    pfa.a().i();
    rxg.a().b(this);
    PreloadManager.a().b();
    PreloadManager.a().e();
    ubg.a(1, false, this.jdField_a_of_type_Long, this.jdField_b_of_type_Int, this.jdField_d_of_type_Int);
    PublicAccountImageCollectionPreloadManager.a().d();
    PublicAccountImageCollectionPreloadManager.a().c();
    WebProcessManager.g();
    WebProcessManager.h();
    rlz.a();
    rlz.a().b();
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
      ((ohl)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).g();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      uae.a("KANDIAN_FEEDS_STAGE_1_COST", null);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ohl)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).h();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    pfa.a().j();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ohl)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).e();
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_e_of_type_Long += this.jdField_d_of_type_Long - this.jdField_c_of_type_Long;
    pfa.a().k();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ohl)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).f();
    }
  }
  
  public void finish()
  {
    super.finish();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ohl)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).o();
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
      if (bnrf.a(this.app))
      {
        a(false);
        continue;
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.a()) {
          ocd.a(null, "CliOper", "", "", "0X80067D0", "0X80067D0", 0, 0, "", "", "", ozs.e(), false);
        }
        for (;;)
        {
          if (this.jdField_e_of_type_Int != 0) {
            break label180;
          }
          ((ohl)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.jdField_e_of_type_Int))).a(true);
          break;
          ocd.a(null, "CliOper", "", "", "0X80067CF", "0X80067CF", 0, 0, "", "", "", ozs.e(), false);
        }
        label180:
        this.jdField_e_of_type_Int = 0;
        c(this.jdField_e_of_type_Int);
        ((KandianMergeManager)this.app.getManager(162)).b(0);
        continue;
        uae.a(null, "KANDIAN_TO_SUBSCRIPT_COST");
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a()) {
          ocd.a(null, "CliOper", "", "", "0X80067D2", "0X80067D2", 0, 0, "", "", "", ozs.e(), false);
        }
        for (;;)
        {
          if (this.jdField_e_of_type_Int != 1) {
            break label335;
          }
          ((ohl)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.jdField_e_of_type_Int))).a(true);
          break;
          ocd.a(null, "CliOper", "", "", "0X80067D1", "0X80067D1", 0, 0, "", "", "", ozs.e(), false);
        }
        label335:
        this.jdField_e_of_type_Int = 1;
        c(this.jdField_e_of_type_Int);
        ((KandianMergeManager)this.app.getManager(162)).b(1);
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