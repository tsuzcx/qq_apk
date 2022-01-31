package com.tencent.biz.pubaccount.readinjoy.view;

import actj;
import ajxj;
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
import baxy;
import bfos;
import bfpt;
import bfpu;
import bfxm;
import bhvy;
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
import ntd;
import omt;
import onh;
import oou;
import ory;
import osg;
import osm;
import ovk;
import oxx;
import oyc;
import oyd;
import qao;
import qoi;
import qtv;
import qvf;
import rbo;
import rbp;
import rbq;
import rbr;
import rbx;
import rel;
import reo;
import rer;
import res;
import ret;
import reu;
import rev;
import rnv;
import sgu;
import shu;

public class ReadInJoyProteusFamilyListViewGroup
  extends ReadInJoyBaseListViewGroup
  implements View.OnClickListener, bfpt, bfpu, qvf, rbo, rbp, rbq, rbr, rbx
{
  private long jdField_a_of_type_Long = -1L;
  private ajxj jdField_a_of_type_Ajxj = new res(this);
  private SparseArray<oxx> jdField_a_of_type_AndroidUtilSparseArray;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected baxy a;
  private bfos jdField_a_of_type_Bfos = new reo(this);
  private bfxm jdField_a_of_type_Bfxm = new rev(this);
  private SlideActiveAnimController jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController;
  private ory jdField_a_of_type_Ory = new rer(this);
  private osm jdField_a_of_type_Osm;
  private rel jdField_a_of_type_Rel;
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  List<KandianProgressView> jdField_b_of_type_JavaUtilList = new ArrayList();
  Map<String, KandianProgressView> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = -1;
  private long jdField_c_of_type_Long = -1L;
  private List<rnv> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = true;
  private int d = -1;
  
  public ReadInJoyProteusFamilyListViewGroup(ntd paramntd, int paramInt1, int paramInt2, int paramInt3, omt paramomt, int paramInt4)
  {
    super(paramntd, paramInt1, paramomt);
    this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(paramInt4, this);
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_b_of_type_Long = paramInt3;
    this.jdField_c_of_type_Boolean = qoi.b();
    setId(2131374812);
    this.jdField_a_of_type_AndroidUtilSparseArray = oyc.a(this);
    n();
    r();
    this.jdField_a_of_type_Omt.jdField_c_of_type_Long = bhvy.a((QQAppInterface)onh.a());
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131376714));
    this.jdField_a_of_type_Baxy = new baxy(a(), ((BaseActivity)a()).app);
    this.jdField_a_of_type_Rel = new rel(BaseActivity.sTopActivity, BaseActivity.sTopActivity.getLayoutInflater(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_AndroidUtilSparseArray, a());
    a(new ret(this, "onListViewGroupInit"));
    t();
    if (QLog.isColorLevel()) {
      QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, "initUI before mListView.setPadding :" + this.jdField_a_of_type_Ntd + a());
    }
    p();
    o();
    q();
    s();
    ((BaseActivity)a()).app.addObserver(this.jdField_a_of_type_Ajxj);
    ((KandianMergeManager)onh.a().getManager(162)).a(this.jdField_a_of_type_Ory);
    this.jdField_a_of_type_Osm = new reu(this);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(this.jdField_a_of_type_Bfxm);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_Bfos);
  }
  
  private void p()
  {
    Activity localActivity;
    View localView2;
    if ((this.jdField_a_of_type_Ntd instanceof ovk))
    {
      localActivity = a();
      if (localActivity.findViewById(2131361942) == null) {
        break label189;
      }
      localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131361942);
      localView1 = localActivity.findViewById(2131376469);
      localView2 = findViewById(2131366608);
      i = getResources().getDimensionPixelOffset(2131298585);
      i = actj.a(50.0F, getResources()) + ImmersiveUtils.getStatusBarHeight(getContext()) + i;
      localView2.setPadding(0, i, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setPadding(0, i, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.initPaddingManual();
      if (QLog.isColorLevel()) {
        QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, "initUI 看点 mListView.setPadding :" + i);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = new SlideActiveAnimController(this.jdField_a_of_type_Int, localActivity, localReadInjoySlideAnimLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, localView1, localActivity.findViewById(16908307), new ReadInJoyProteusFamilyListViewGroup.4(this, localView1, i, localView2));
    }
    label189:
    while (localActivity.findViewById(2131361943) == null) {
      return;
    }
    ReadInjoySlideAnimLayout localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131361943);
    View localView1 = localActivity.findViewById(2131377375);
    int i = actj.a(50.0F, getResources());
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
      localView2 = findViewById(2131366608);
      localView2.setPadding(0, i, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = new SlideActiveAnimController(this.jdField_a_of_type_Int, localActivity, localReadInjoySlideAnimLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, localView1, null, new ReadInJoyProteusFamilyListViewGroup.5(this, localView1, i, localView2));
      return;
    }
  }
  
  private void q()
  {
    this.jdField_a_of_type_Rel.b(b());
    this.jdField_a_of_type_Rel.a(this.jdField_b_of_type_Long);
    this.jdField_a_of_type_Rel.a(this);
    this.jdField_a_of_type_Rel.a(this);
    this.jdField_a_of_type_Rel.a(this);
    this.jdField_a_of_type_Rel.a(this);
    this.jdField_a_of_type_Rel.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_Rel);
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
    View localView = findViewById(2131372594);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  private void t()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372598));
    if (oou.c(this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131372597));
      return;
    }
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131372596));
  }
  
  public rel a()
  {
    return this.jdField_a_of_type_Rel;
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
      osg.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      this.jdField_a_of_type_Rel.notifyDataSetChanged();
      shu.a(paramArticleInfo);
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
  
  public void a(Map<Long, qao> paramMap, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinJoyProteusFamilyListViewGroup_" + this.jdField_a_of_type_Int, 2, "detachFromViewGroup()");
    }
  }
  
  public void a(Set<Long> paramSet, Map<Long, qao> paramMap) {}
  
  public void a(oyd paramoyd)
  {
    if (paramoyd == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        long l1 = SystemClock.currentThreadTimeMillis();
        paramoyd.a((oxx)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i));
        long l2 = SystemClock.currentThreadTimeMillis();
        QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, new Object[] { "execute handler job , id : ", Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i)), ", jobName : ", paramoyd.a(), ", cost : ", Long.valueOf(l2 - l1) });
        i += 1;
      }
    }
  }
  
  public void a(qtv paramqtv1, qtv paramqtv2) {}
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, 1);
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, List<BaseArticleInfo> paramList)
  {
    this.jdField_a_of_type_Rel.a(paramList);
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
  
  public void c(Map<Integer, qao> paramMap) {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g()
  {
    ((BaseActivity)a()).app.removeObserver(this.jdField_a_of_type_Ajxj);
  }
  
  public void j()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      sgu.a(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE");
      osg.a().a(this.jdField_a_of_type_Int, 20, 9223372036854775807L, true);
      return;
    }
    QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, new Object[] { "has loaded article, mChannelID = ", Integer.valueOf(this.jdField_a_of_type_Int) });
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Rel != null) {
      this.jdField_a_of_type_Rel.notifyDataSetChanged();
    }
  }
  
  public void l() {}
  
  public void m() {}
  
  public void onClick(View paramView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void setAdapterData(List<BaseArticleInfo> paramList, int paramInt)
  {
    this.jdField_a_of_type_Rel.a(paramList);
  }
  
  public void setChannelType(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyProteusFamilyListViewGroup
 * JD-Core Version:    0.7.0.1
 */