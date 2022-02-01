package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import anvi;
import bmhv;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.XListView.DrawFinishedListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import oqu;
import pjt;
import pkh;
import pmz;
import pnb;
import pnr;
import pnt;
import pnu;
import pnv;
import pnw;
import pob;
import pvb;
import pvj;
import pzj;
import rot;
import spk;
import sqk;
import szj;
import tay;
import tbb;
import tbc;
import tbd;
import tbe;
import uuq;
import uvs;

public class ReadInJoyProteusFamilyListViewGroup
  extends ReadInJoyBaseListViewGroup
  implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, pnt, pnu, pnv, pnw, sqk, szj
{
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private anvi jdField_a_of_type_Anvi = new tbe(this);
  private SlideActiveAnimController jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController;
  protected FaceDecoder a;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new tbb(this);
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new tbc(this);
  pmz jdField_a_of_type_Pmz;
  public pob a;
  private pvb jdField_a_of_type_Pvb = new tbd(this);
  private tay jdField_a_of_type_Tay;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  
  public ReadInJoyProteusFamilyListViewGroup(oqu paramoqu, int paramInt1, int paramInt2, int paramInt3, pjt parampjt, int paramInt4)
  {
    super(paramoqu, paramInt1, parampjt);
    this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(paramInt4, this);
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Long = paramInt3;
    setId(2131376202);
    this.jdField_a_of_type_Pob = new pob();
    this.jdField_a_of_type_Pob.a(this);
    this.jdField_a_of_type_Pmz = new pmz(new pnb().a(this.jdField_a_of_type_Pjt).a(this.jdField_a_of_type_Int).a(a()).a(this.jdField_a_of_type_Long).d(paramInt2).a(this.jdField_a_of_type_Oqu));
    m();
    r();
    this.jdField_a_of_type_Pjt.c = bmhv.a((QQAppInterface)pkh.a());
  }
  
  private int b()
  {
    if (this.jdField_b_of_type_Int != -1) {
      return this.jdField_b_of_type_Int;
    }
    return a().getIntent().getIntExtra("channel_type", 0);
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131378302));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(a(), ((BaseActivity)a()).app);
    this.jdField_a_of_type_Tay = new tay(BaseActivity.sTopActivity, BaseActivity.sTopActivity.getLayoutInflater(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Pob.a(), a());
    this.jdField_a_of_type_Pob.a(this.jdField_a_of_type_Pob.a(), this.jdField_a_of_type_Tay);
    this.jdField_a_of_type_Pob.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, "initUI before mListView.setPadding :" + this.jdField_a_of_type_Oqu + a());
    }
    o();
    n();
    q();
    s();
    ((BaseActivity)a()).app.addObserver(this.jdField_a_of_type_Anvi);
    ((KandianMergeManager)pkh.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(this.jdField_a_of_type_Pvb);
  }
  
  private void n()
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
  }
  
  private void o()
  {
    Activity localActivity;
    View localView2;
    if ((this.jdField_a_of_type_Oqu instanceof pzj))
    {
      localActivity = a();
      if (localActivity.findViewById(2131362002) == null) {
        break label189;
      }
      localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131362002);
      localView1 = localActivity.findViewById(2131378030);
      localView2 = findViewById(2131367180);
      i = getResources().getDimensionPixelOffset(2131298776);
      i = AIOUtils.dp2px(50.0F, getResources()) + ImmersiveUtils.getStatusBarHeight(getContext()) + i;
      localView2.setPadding(0, i, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setPadding(0, i, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.initPaddingManual();
      if (QLog.isColorLevel()) {
        QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, "initUI 看点 mListView.setPadding :" + i);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = new SlideActiveAnimController(this.jdField_a_of_type_Int, localActivity, localReadInjoySlideAnimLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, localView1, localActivity.findViewById(16908307), new ReadInJoyProteusFamilyListViewGroup.2(this, localView1, i, localView2));
    }
    label189:
    while (localActivity.findViewById(2131362003) == null) {
      return;
    }
    ReadInjoySlideAnimLayout localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131362003);
    View localView1 = localActivity.findViewById(2131379027);
    int i = AIOUtils.dp2px(50.0F, getResources());
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
      localView2 = findViewById(2131367180);
      localView2.setPadding(0, i, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = new SlideActiveAnimController(this.jdField_a_of_type_Int, localActivity, localReadInjoySlideAnimLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, localView1, null, new ReadInJoyProteusFamilyListViewGroup.3(this, localView1, i, localView2));
      return;
    }
  }
  
  private void q()
  {
    this.jdField_a_of_type_Tay.b(b());
    this.jdField_a_of_type_Tay.a(this.jdField_a_of_type_Long);
    pnr localpnr = new pnr().a(this).a(this).a(this).a(this);
    this.jdField_a_of_type_Tay.a(localpnr);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_Tay);
  }
  
  private void r()
  {
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyProteusFamilyListViewGroup.4(this), 3000L);
  }
  
  private void s()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    View localView = findViewById(2131373860);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  public pmz a()
  {
    return this.jdField_a_of_type_Pmz;
  }
  
  public tay a()
  {
    return this.jdField_a_of_type_Tay;
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
      pvj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      this.jdField_a_of_type_Tay.notifyDataSetChanged();
      uvs.a(paramArticleInfo);
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
  
  public void a(Map<Long, rot> paramMap, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinJoyProteusFamilyListViewGroup_" + this.jdField_a_of_type_Int, 2, "detachFromViewGroup()");
    }
  }
  
  public void a(Set<Long> paramSet, Map<Long, rot> paramMap) {}
  
  public void a(spk paramspk1, spk paramspk2) {}
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, 1);
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, List<BaseArticleInfo> paramList)
  {
    this.jdField_a_of_type_Tay.a(paramList);
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
  
  public void c(Map<Integer, rot> paramMap) {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g()
  {
    ((BaseActivity)a()).app.removeObserver(this.jdField_a_of_type_Anvi);
  }
  
  public void j()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      uuq.a(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE");
      pvj.a().a(this.jdField_a_of_type_Int, 20, 9223372036854775807L, true);
      return;
    }
    QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, new Object[] { "has loaded article, mChannelID = ", Integer.valueOf(this.jdField_a_of_type_Int) });
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Tay != null) {
      this.jdField_a_of_type_Tay.notifyDataSetChanged();
    }
  }
  
  public void l() {}
  
  public void onClick(View paramView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
  
  public void p() {}
  
  public void setAdapterData(List<BaseArticleInfo> paramList, int paramInt)
  {
    this.jdField_a_of_type_Tay.a(paramList);
  }
  
  public void setChannelType(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyProteusFamilyListViewGroup
 * JD-Core Version:    0.7.0.1
 */