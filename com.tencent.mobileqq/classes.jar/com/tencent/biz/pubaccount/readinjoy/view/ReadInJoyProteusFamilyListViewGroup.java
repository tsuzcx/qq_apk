package com.tencent.biz.pubaccount.readinjoy.view;

import aepi;
import altm;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import bdbb;
import bhtv;
import bhuw;
import bhux;
import bicq;
import bkbq;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import nwi;
import ore;
import ors;
import otf;
import owq;
import owy;
import oxe;
import pao;
import pdc;
import pdh;
import pdi;
import qkk;
import rdm;
import rjk;
import rkw;
import rrl;
import rrm;
import rrn;
import rro;
import rru;
import ruh;
import ruk;
import run;
import ruo;
import rup;
import ruq;
import rur;
import sdu;
import syp;
import szp;

public class ReadInJoyProteusFamilyListViewGroup
  extends ReadInJoyBaseListViewGroup
  implements View.OnClickListener, bhuw, bhux, rkw, rrl, rrm, rrn, rro, rru
{
  private long jdField_a_of_type_Long = -1L;
  private altm jdField_a_of_type_Altm = new ruo(this);
  private SparseArray<pdc> jdField_a_of_type_AndroidUtilSparseArray;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected bdbb a;
  private bhtv jdField_a_of_type_Bhtv = new ruk(this);
  private bicq jdField_a_of_type_Bicq = new rur(this);
  private SlideActiveAnimController jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController;
  private owq jdField_a_of_type_Owq = new run(this);
  private oxe jdField_a_of_type_Oxe;
  private ruh jdField_a_of_type_Ruh;
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  List<KandianProgressView> jdField_b_of_type_JavaUtilList = new ArrayList();
  Map<String, KandianProgressView> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = -1;
  private long jdField_c_of_type_Long = -1L;
  private List<sdu> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = true;
  private int d = -1;
  
  public ReadInJoyProteusFamilyListViewGroup(nwi paramnwi, int paramInt1, int paramInt2, int paramInt3, ore paramore, int paramInt4)
  {
    super(paramnwi, paramInt1, paramore);
    this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(paramInt4, this);
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_b_of_type_Long = paramInt3;
    this.jdField_c_of_type_Boolean = rdm.b();
    setId(2131375326);
    this.jdField_a_of_type_AndroidUtilSparseArray = pdh.a(this);
    n();
    r();
    this.jdField_a_of_type_Ore.jdField_c_of_type_Long = bkbq.a((QQAppInterface)ors.a());
  }
  
  private int b()
  {
    if (this.jdField_c_of_type_Int != -1) {
      return this.jdField_c_of_type_Int;
    }
    return a().getIntent().getIntExtra("channel_type", 0);
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131377278));
    this.jdField_a_of_type_Bdbb = new bdbb(a(), ((BaseActivity)a()).app);
    this.jdField_a_of_type_Ruh = new ruh(BaseActivity.sTopActivity, BaseActivity.sTopActivity.getLayoutInflater(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_AndroidUtilSparseArray, a());
    a(new rup(this, "onListViewGroupInit"));
    t();
    if (QLog.isColorLevel()) {
      QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, "initUI before mListView.setPadding :" + this.jdField_a_of_type_Nwi + a());
    }
    p();
    o();
    q();
    s();
    ((BaseActivity)a()).app.addObserver(this.jdField_a_of_type_Altm);
    ((KandianMergeManager)ors.a().getManager(162)).a(this.jdField_a_of_type_Owq);
    this.jdField_a_of_type_Oxe = new ruq(this);
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setContentBackground(new ColorDrawable(-1));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setBackgroundColor(-1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setChannelId(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOnItemLongClickListener(this);
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOverScrollTouchMode(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOverScrollFlingMode(1);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(this.jdField_a_of_type_Bicq);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_Bhtv);
  }
  
  private void p()
  {
    Activity localActivity;
    View localView2;
    if ((this.jdField_a_of_type_Nwi instanceof pao))
    {
      localActivity = a();
      if (localActivity.findViewById(2131361944) == null) {
        break label189;
      }
      localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131361944);
      localView1 = localActivity.findViewById(2131377023);
      localView2 = findViewById(2131366732);
      i = getResources().getDimensionPixelOffset(2131298612);
      i = aepi.a(50.0F, getResources()) + ImmersiveUtils.getStatusBarHeight(getContext()) + i;
      localView2.setPadding(0, i, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setPadding(0, i, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.initPaddingManual();
      if (QLog.isColorLevel()) {
        QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, "initUI 看点 mListView.setPadding :" + i);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = new SlideActiveAnimController(this.jdField_a_of_type_Int, localActivity, localReadInjoySlideAnimLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, localView1, localActivity.findViewById(16908307), new ReadInJoyProteusFamilyListViewGroup.4(this, localView1, i, localView2));
    }
    label189:
    while (localActivity.findViewById(2131361945) == null) {
      return;
    }
    ReadInjoySlideAnimLayout localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131361945);
    View localView1 = localActivity.findViewById(2131377964);
    int i = aepi.a(50.0F, getResources());
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i += ImmersiveUtils.getStatusBarHeight(getContext());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setPadding(0, i, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.initPaddingManual();
      if (QLog.isColorLevel()) {
        QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, "initUI 消息看点 mListView.setPadding heightDef=" + i);
      }
      localView2 = findViewById(2131366732);
      localView2.setPadding(0, i, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = new SlideActiveAnimController(this.jdField_a_of_type_Int, localActivity, localReadInjoySlideAnimLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, localView1, null, new ReadInJoyProteusFamilyListViewGroup.5(this, localView1, i, localView2));
      return;
    }
  }
  
  private void q()
  {
    this.jdField_a_of_type_Ruh.b(b());
    this.jdField_a_of_type_Ruh.a(this.jdField_b_of_type_Long);
    this.jdField_a_of_type_Ruh.a(this);
    this.jdField_a_of_type_Ruh.a(this);
    this.jdField_a_of_type_Ruh.a(this);
    this.jdField_a_of_type_Ruh.a(this);
    this.jdField_a_of_type_Ruh.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_Ruh);
  }
  
  private void r()
  {
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyProteusFamilyListViewGroup.6(this), 3000L);
  }
  
  private void s()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    View localView = findViewById(2131372977);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  private void t()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372981));
    if (otf.c(this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131372980));
      return;
    }
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131372979));
  }
  
  public ruh a()
  {
    return this.jdField_a_of_type_Ruh;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReadinJoyProteusFamilyListViewGroup", 2, "jumpToGallery failed: atlas has undercarriage");
      }
      owy.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      this.jdField_a_of_type_Ruh.notifyDataSetChanged();
      szp.a(paramArticleInfo);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("ReadinJoyProteusFamilyListViewGroup", 2, "rowKey is empty");
  }
  
  public void a(View paramView, ArticleInfo paramArticleInfo, int paramInt) {}
  
  public void a(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, long paramLong) {}
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt) {}
  
  public void a(Map<Integer, Boolean> paramMap) {}
  
  public void a(Map<Long, qkk> paramMap, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinJoyProteusFamilyListViewGroup_" + this.jdField_a_of_type_Int, 2, "detachFromViewGroup()");
    }
  }
  
  public void a(Set<Long> paramSet, Map<Long, qkk> paramMap) {}
  
  public void a(pdi parampdi)
  {
    if (parampdi == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        long l1 = SystemClock.currentThreadTimeMillis();
        parampdi.a((pdc)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i));
        long l2 = SystemClock.currentThreadTimeMillis();
        QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, new Object[] { "execute handler job , id : ", Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i)), ", jobName : ", parampdi.a(), ", cost : ", Long.valueOf(l2 - l1) });
        i += 1;
      }
    }
  }
  
  public void a(rjk paramrjk1, rjk paramrjk2) {}
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, 1);
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, List<BaseArticleInfo> paramList)
  {
    this.jdField_a_of_type_Ruh.a(paramList);
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
  
  public void b() {}
  
  public void b(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt) {}
  
  public void b(Map<Integer, Boolean> paramMap)
  {
    paramMap.put(Integer.valueOf(this.jdField_a_of_type_Int), Boolean.valueOf(true));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null) {
      return;
    }
    a(true);
  }
  
  public void c(Map<Integer, qkk> paramMap) {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g()
  {
    ((BaseActivity)a()).app.removeObserver(this.jdField_a_of_type_Altm);
  }
  
  public void j()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      syp.a(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE");
      owy.a().a(this.jdField_a_of_type_Int, 20, 9223372036854775807L, true);
      return;
    }
    QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, new Object[] { "has loaded article, mChannelID = ", Integer.valueOf(this.jdField_a_of_type_Int) });
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Ruh != null) {
      this.jdField_a_of_type_Ruh.notifyDataSetChanged();
    }
  }
  
  public void l() {}
  
  public void m() {}
  
  public void onClick(View paramView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void setAdapterData(List<BaseArticleInfo> paramList, int paramInt)
  {
    this.jdField_a_of_type_Ruh.a(paramList);
  }
  
  public void setChannelType(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyProteusFamilyListViewGroup
 * JD-Core Version:    0.7.0.1
 */