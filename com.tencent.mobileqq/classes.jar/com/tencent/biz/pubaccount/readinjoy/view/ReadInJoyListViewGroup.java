package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anvi;
import anvx;
import bmhv;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView.DrawFinishedListener;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import oqu;
import pjt;
import pkh;
import pkk;
import pko;
import plm;
import pmu;
import pmz;
import pnb;
import pno;
import pnr;
import pns;
import pnt;
import pnu;
import pnv;
import pnw;
import pny;
import pob;
import ppo;
import ppq;
import ppx;
import pqb;
import pqk;
import pqo;
import pqt;
import pqw;
import prp;
import psu;
import pvj;
import pvm;
import pvq;
import pwb;
import pwq;
import qcn;
import qcr;
import qcw;
import rbi;
import rjm;
import rnz;
import rot;
import rzb;
import sgg;
import spk;
import sqk;
import szc;
import szj;
import tai;
import taj;
import tak;
import tal;
import tam;
import tan;
import tao;
import tnf;
import uhx;
import uuq;
import uur;
import uvp;
import uvs;
import uvx;

public class ReadInJoyListViewGroup
  extends ReadInJoyBaseListViewGroup
  implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, pnt, pnu, pnv, pnw, sqk, szj
{
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anvi jdField_a_of_type_Anvi = new tao(this);
  protected FaceDecoder a;
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new tan(this);
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Function1<Canvas, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1 = new tak(this);
  public pmz a;
  pns jdField_a_of_type_Pns;
  public pob a;
  ppo jdField_a_of_type_Ppo;
  ppq jdField_a_of_type_Ppq;
  ppx jdField_a_of_type_Ppx;
  pqb jdField_a_of_type_Pqb;
  pqk jdField_a_of_type_Pqk;
  psu jdField_a_of_type_Psu;
  private pvq jdField_a_of_type_Pvq = new tai(this);
  private rzb jdField_a_of_type_Rzb = new taj(this);
  private szc jdField_a_of_type_Szc;
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private Function1<Canvas, Unit> jdField_b_of_type_KotlinJvmFunctionsFunction1 = new tal(this);
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = -1L;
  
  public ReadInJoyListViewGroup(oqu paramoqu, int paramInt1, int paramInt2, int paramInt3, pjt parampjt)
  {
    this(paramoqu, paramInt1, paramInt2, paramInt3, parampjt, 2131560331);
  }
  
  public ReadInJoyListViewGroup(oqu paramoqu, int paramInt1, int paramInt2, int paramInt3, pjt parampjt, int paramInt4)
  {
    super(paramoqu, paramInt1, parampjt);
    this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(paramInt4, this);
    this.jdField_b_of_type_Long = paramInt3;
    setId(2131376202);
    this.jdField_a_of_type_Pob = new pob();
    this.jdField_a_of_type_Pob.a(this);
    this.jdField_a_of_type_Pqb = new pqb();
    this.jdField_a_of_type_Psu = new psu();
    this.jdField_a_of_type_Ppo = new ppo();
    this.jdField_a_of_type_Ppx = new ppx();
    this.jdField_a_of_type_Pjt.jdField_c_of_type_Long = bmhv.a((QQAppInterface)pkh.a());
    this.jdField_a_of_type_Pmz = new pmz(new pnb().a(this.jdField_a_of_type_Pjt).a(this.jdField_a_of_type_Int).a(a()).a(this.jdField_b_of_type_Long).d(paramInt2).a(this.jdField_a_of_type_Oqu).a(this.jdField_a_of_type_Ppx).a(this));
    this.jdField_a_of_type_Ppq = new ppq().a(this.jdField_a_of_type_Int).a(a());
    this.jdField_a_of_type_Pqk = new pqk(new pqo().a(this.jdField_a_of_type_Int).a(a()));
    a(paramInt1, paramInt2);
    this.jdField_a_of_type_Pmz.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    this.jdField_a_of_type_Pmz.a().a(this.jdField_a_of_type_Szc);
    this.jdField_a_of_type_Pqk.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    this.jdField_a_of_type_Ppq.a(this.jdField_a_of_type_Szc);
    this.jdField_a_of_type_Pob.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
  }
  
  public ReadInJoyListViewGroup(oqu paramoqu, int paramInt1, int paramInt2, pjt parampjt)
  {
    this(paramoqu, paramInt1, paramInt2, -1, parampjt);
  }
  
  public ReadInJoyListViewGroup(oqu paramoqu, int paramInt, pjt parampjt)
  {
    this(paramoqu, paramInt, -1, parampjt);
  }
  
  public static ArticleInfo a(ArticleInfo paramArticleInfo)
  {
    return ppo.a(paramArticleInfo);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131378302));
    if (paramInt1 == 41695)
    {
      this.jdField_a_of_type_Ppx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, a());
      pmz.a(this.jdField_a_of_type_Int);
    }
    if (paramInt1 == 56) {
      this.jdField_a_of_type_Long = a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
    }
    if (plm.c(this.jdField_a_of_type_Int)) {
      pkk.a().a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(a(), ((BaseActivity)a()).app);
    this.jdField_a_of_type_Szc = new szc(a(), a().getLayoutInflater(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, this.jdField_a_of_type_Pob.a());
    this.jdField_a_of_type_Pob.a(this.jdField_a_of_type_Pob.a(), this.jdField_a_of_type_Szc);
    this.jdField_a_of_type_Pob.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_b_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, "initUI before mListView.setPadding :" + this.jdField_a_of_type_Oqu + a());
    }
    s();
    b(paramInt2);
    u();
    this.jdField_a_of_type_Ppx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, a(), this.jdField_a_of_type_Int);
    ((BaseActivity)a()).app.addObserver(this.jdField_a_of_type_Anvi);
    this.jdField_a_of_type_Pqk.a();
    this.jdField_a_of_type_Pqk.i();
    pvm.a().a(this.jdField_a_of_type_Pvq);
    pvm.a().a(this.jdField_a_of_type_Rzb);
  }
  
  private void a(int paramInt, Runnable paramRunnable)
  {
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.9(this, paramRunnable), paramInt);
  }
  
  private void a(int paramInt1, List<Long> paramList, boolean paramBoolean, int paramInt2)
  {
    if ((paramList != null) && (paramInt2 > 0) && (paramList.size() > 0))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder("onChannelRefreshed ");
        localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          localLong = (Long)localIterator.next();
          localStringBuilder.append("recommendSeq = " + localLong + ",\n ");
        }
        QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 1, localStringBuilder.toString());
      }
      if (!this.jdField_a_of_type_Szc.b) {
        this.jdField_a_of_type_Szc.a(false);
      }
      this.jdField_a_of_type_Szc.b = true;
      sgg.a().c(true);
      this.jdField_a_of_type_Pmz.a(pvj.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
      this.jdField_a_of_type_Szc.a(0);
      a(paramInt1, paramBoolean);
    }
    while (!this.jdField_a_of_type_Szc.isEmpty())
    {
      StringBuilder localStringBuilder;
      Iterator localIterator;
      Long localLong;
      return;
    }
    if (this.jdField_a_of_type_Int == 70)
    {
      a(getResources().getString(2131717759), getResources().getDrawable(2130849410));
      return;
    }
    a(getResources().getString(2131717844));
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 56) || (paramInt == 0))
    {
      AppRuntime localAppRuntime = pkh.a();
      if (localAppRuntime != null) {
        ((uhx)localAppRuntime.getManager(QQManagerFactory.KANDIAN_AD_EXPOSURE_MANAGER)).a(getContext(), paramInt);
      }
    }
    if (paramInt == 70) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoMoreData(paramBoolean);
    }
    if ((paramInt == 0) || (plm.c(this.jdField_a_of_type_Int))) {
      pwb.a().a.a(2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    }
  }
  
  private void a(String paramString)
  {
    a(paramString, null);
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    findViewById(2131373860).setVisibility(8);
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = ((ViewStub)findViewById(2131371883)).inflate();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376163));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376162));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    if (paramDrawable != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      if (this.jdField_a_of_type_Int == 70) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-4473925);
      }
    }
    for (((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = AIOUtils.dp2px(20.0F, getResources());; ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = AIOUtils.dp2px(10.0F, getResources()))
    {
      this.jdField_a_of_type_Ppx.a(this, this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130839341));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166906));
    }
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_Szc.b(paramInt);
    this.jdField_a_of_type_Szc.a(this.jdField_b_of_type_Long);
    pnr localpnr = new pnr().a(this).a(this).a(this).a(this);
    this.jdField_a_of_type_Szc.a(localpnr);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_Szc);
  }
  
  private void b(boolean paramBoolean, int paramInt)
  {
    if (b())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.h();
      return;
    }
    String str;
    if (this.jdField_a_of_type_Int == 70) {
      if ((paramBoolean) && (paramInt > 0)) {
        str = getResources().getString(2131717762);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(true, str);
      if (!bmhv.l()) {
        break;
      }
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.5(this), 1500L);
      return;
      str = getResources().getString(2131717761);
      continue;
      if (this.jdField_a_of_type_Int == 40677)
      {
        if ((paramBoolean) && (paramInt > 0)) {
          str = String.format(getResources().getString(2131717599), new Object[] { Integer.valueOf(paramInt * 2) });
        } else {
          str = getResources().getString(2131717598);
        }
      }
      else if (this.jdField_a_of_type_Int == 40531)
      {
        if ((paramBoolean) && (paramInt > 0)) {
          str = String.format(getResources().getString(2131717599), new Object[] { Integer.valueOf(paramInt) });
        } else {
          str = getResources().getString(2131717597);
        }
      }
      else if ((paramBoolean) && (paramInt > 0)) {
        str = String.format(getResources().getString(2131717599), new Object[] { Integer.valueOf(paramInt) });
      } else {
        str = getResources().getString(2131717598);
      }
    }
  }
  
  private boolean b()
  {
    boolean bool = a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", false);
    a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", false);
    return bool;
  }
  
  private void c(int paramInt)
  {
    if (RecommendFeedsDiandianEntranceManager.a(bmhv.f()))
    {
      QLog.d("ReadInJoyListViewGroup", 1, "request 0xdcb");
      RecommendFeedsDiandianEntranceManager.a().b();
      return;
    }
    QLog.d("ReadInJoyListViewGroup", 1, "request 0x6cf");
    this.jdField_a_of_type_Pmz.c(paramInt);
  }
  
  private void s()
  {
    if (!pqt.d())
    {
      QLog.d("ReadInJoyListViewGroup", 2, "ListView overdraw switch close");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setContentBackground(2130838911);
      int i = Color.parseColor("#f8f8f8");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setBackgroundColor(i);
    }
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_Pob.a);
    if ((this.jdField_a_of_type_Int == 0) || (plm.c(this.jdField_a_of_type_Int))) {
      rjm.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_Int == 70) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.jdField_c_of_type_Int = 0;
    }
    if ((this.jdField_a_of_type_Int == 56) && (this.jdField_a_of_type_Pmz.a().g())) {
      if (this.jdField_a_of_type_Ppx.a() != null) {
        break label103;
      }
    }
    label103:
    for (int i = 0;; i = 1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setSelectionFromTop(i, 0);
      this.jdField_a_of_type_Pmz.a().a(false);
      if ((plm.a(this.jdField_a_of_type_Int)) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView instanceof ReadInJoyDailyXListView))) {
        ((ReadInJoyDailyXListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView).g();
      }
      return;
    }
  }
  
  private void u()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    View localView = findViewById(2131373860);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
    this.jdField_a_of_type_Ppx.a(this, this.jdField_a_of_type_Int);
  }
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  }
  
  public pmz a()
  {
    return this.jdField_a_of_type_Pmz;
  }
  
  public pob a()
  {
    return this.jdField_a_of_type_Pob;
  }
  
  public ppx a()
  {
    return this.jdField_a_of_type_Ppx;
  }
  
  public szc a()
  {
    return this.jdField_a_of_type_Szc;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "OnResume()");
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "onResume, mChannelID= ", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    this.jdField_a_of_type_Pob.b();
    if (this.jdField_a_of_type_Pmz.e()) {
      j();
    }
    if (System.currentTimeMillis() - this.jdField_c_of_type_Long > 10000L)
    {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.2(this));
    }
    if (this.jdField_a_of_type_Szc != null) {
      this.jdField_a_of_type_Szc.d();
    }
    this.jdField_a_of_type_Ppx.b();
    this.jdField_a_of_type_Pqk.b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.invalidate();
    if ((this.jdField_a_of_type_Int == 0) || (plm.c(this.jdField_a_of_type_Int))) {
      rjm.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Pqk.j();
    rnz.a(a());
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyListViewGroup", 2, "refreshListByChannelID channelID = " + paramInt + " mChannelID = " + this.jdField_a_of_type_Int);
    }
    if ((paramInt == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Szc != null)) {
      this.jdField_a_of_type_Pmz.b(true, 1001, true);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Pob.a(paramInt1, paramInt2, paramIntent);
    paramIntent = new pny(paramInt1, paramInt2, paramIntent, this.jdField_a_of_type_Szc, a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Pmz);
    if (paramInt1 == 9993)
    {
      if (paramInt2 == 1) {
        c();
      }
      return;
    }
    paramIntent.a(paramInt1);
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    this.jdField_a_of_type_Szc.a(paramInt, paramIntent);
  }
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Pmz.a(paramInt, paramArticleInfo, paramString1, paramString2);
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    uuq.a(null, "KANDIAN_NEW_FEEDS_ON_CHANNEL_ARTICLE_LOADED");
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Szc == null)) {
      return;
    }
    this.jdField_a_of_type_Pob.a(paramInt, paramList);
    this.jdField_a_of_type_Pmz.a(paramInt, paramList, new tam(this));
    uuq.a("KANDIAN_NEW_FEEDS_ON_CHANNEL_ARTICLE_LOADED", null);
    uuq.a("KANDIAN_NEW_FEEDS_LOAD_ARTICLE", null);
    uuq.a(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE_FINISH_TO_MEASURE");
  }
  
  public void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Pob.a(paramContext, paramArticleInfo, paramString, paramInt2);
  }
  
  public void a(Configuration paramConfiguration)
  {
    if ((paramConfiguration == null) || (paramConfiguration.hashCode() == this.jdField_c_of_type_Int) || ((!LiuHaiUtils.e()) && (!LiuHaiUtils.d()))) {
      return;
    }
    this.jdField_c_of_type_Int = paramConfiguration.hashCode();
    ThreadManager.getUIHandler().post(new ReadInJoyListViewGroup.7(this));
  }
  
  public void a(View paramView, ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo == null) {
      return;
    }
    pqx.a = paramArticleInfo;
    this.jdField_a_of_type_Pob.a(paramView, paramArticleInfo, paramInt);
    this.jdField_a_of_type_Ppo.a(paramView, paramArticleInfo, paramInt, this.jdField_a_of_type_Ppq);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, long paramLong)
  {
    int i = 0;
    ArticleInfo localArticleInfo = (ArticleInfo)paramBaseArticleInfo;
    if (pqw.g(localArticleInfo)) {
      if ((pqw.m(localArticleInfo)) || (pqw.b(localArticleInfo)))
      {
        this.jdField_a_of_type_Ppo.a(localArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt, this.jdField_a_of_type_Ppq);
        paramInt = 4;
        this.jdField_a_of_type_Ppo.a(paramInt, this.jdField_a_of_type_Ppq);
      }
    }
    do
    {
      return;
      if (pqw.d(localArticleInfo))
      {
        paramInt = i;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("ReadInJoyListViewGroup", 2, "atlas native has undercarriage");
        paramInt = i;
        break;
      }
      this.jdField_a_of_type_Ppo.b(localArticleInfo, this.jdField_a_of_type_Ppq);
      paramInt = 2;
      break;
      a(null, paramBaseArticleInfo, paramView, paramInt, paramLong);
    } while (paramBaseArticleInfo == null);
    paramBaseArticleInfo.invalidateProteusTemplateBean();
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    this.jdField_a_of_type_Ppx.a(paramTopBannerInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Szc);
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    this.jdField_a_of_type_Pmz.a().b(paramInt);
    this.jdField_a_of_type_Pob.a(paramReadInJoyBaseListView, paramInt);
    this.jdField_a_of_type_Pqb.a(this.jdField_a_of_type_Int, paramInt);
    this.jdField_a_of_type_Pmz.b();
    this.jdField_a_of_type_Pmz.h();
    this.jdField_a_of_type_Ppx.a();
    if (this.jdField_a_of_type_Int == 0) {
      uvs.d();
    }
    qcn.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    c(paramInt);
  }
  
  public void a(AdapterView<?> paramAdapterView, BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, long paramLong)
  {
    pko localpko = new pko(Integer.valueOf(0));
    this.jdField_a_of_type_Ppo.a(paramView);
    ArticleInfo localArticleInfo = (ArticleInfo)paramBaseArticleInfo;
    String str;
    if (localArticleInfo != null)
    {
      str = paramBaseArticleInfo.innerUniqueID;
      this.jdField_a_of_type_Pob.a(paramAdapterView, paramView, paramInt, paramLong);
      this.jdField_a_of_type_Ppo.a(paramBaseArticleInfo, this.jdField_a_of_type_Int);
      pqx.a = localArticleInfo;
      if (this.jdField_a_of_type_Ppo.a(paramBaseArticleInfo, paramView, paramInt, localpko, localArticleInfo, this.jdField_a_of_type_Ppq, this.jdField_a_of_type_AndroidOsHandler)) {
        return;
      }
      this.jdField_a_of_type_Ppo.a(paramInt, localArticleInfo, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Ppq);
    }
    for (paramAdapterView = str;; paramAdapterView = "")
    {
      this.jdField_a_of_type_Ppo.a(((Integer)localpko.a()).intValue(), this.jdField_a_of_type_Ppq);
      QLog.d("ReadInJoyListViewGroup", 1, "onItemClick, rowkey= " + paramAdapterView);
      return;
    }
  }
  
  public void a(Map<Integer, Boolean> paramMap) {}
  
  public void a(Map<Long, rot> paramMap, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "detachFromViewGroup()");
    }
    this.jdField_a_of_type_Pob.a(paramMap, paramBoolean);
    this.jdField_a_of_type_Pqb.a(paramMap, paramBoolean, uvs.a(this.jdField_a_of_type_Int), prp.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_Pmz.e(), this.jdField_a_of_type_Int, getContext(), this.jdField_a_of_type_Pmz.a().a(), this.jdField_a_of_type_Oqu, this.jdField_a_of_type_Pmz.a().e(), this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Pmz.j();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b(false);
    }
    a().getIntent().putExtra("from_search", false);
  }
  
  public void a(Map<Long, rot> paramMap, boolean paramBoolean, Map<Long, uvx> paramMap1, String paramString)
  {
    this.jdField_a_of_type_Pqb.a(paramMap, paramBoolean, paramMap1, paramString, getContext(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Pmz.a().a(), this.jdField_a_of_type_Oqu, this.jdField_a_of_type_Pmz.a().e(), this.jdField_a_of_type_Long);
  }
  
  public void a(Set<Long> paramSet, Map<Long, rot> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "attachToViewGroup()");
    }
    this.jdField_a_of_type_Pob.a(paramSet, paramMap);
    if (this.jdField_a_of_type_Szc != null) {
      this.jdField_a_of_type_Szc.a(paramSet, paramMap);
    }
    this.jdField_a_of_type_Pmz.i();
    this.jdField_a_of_type_Pqk.b();
    uuq.a(null, "KANDIAN_FEEDS_STAGE_2_COST");
    if (!this.jdField_a_of_type_Pmz.e()) {
      j();
    }
  }
  
  public void a(spk paramspk1, spk paramspk2)
  {
    ((qcw)this.jdField_a_of_type_Pob.a(2)).k();
  }
  
  public void a(tnf paramtnf)
  {
    this.jdField_a_of_type_Ppx.a(paramtnf, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, 1);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (paramInt != 8) {
        break;
      }
      this.jdField_a_of_type_Pmz.f();
    } while (!this.jdField_a_of_type_Pmz.a().d());
    this.jdField_a_of_type_Pob.a(paramBoolean, paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.post(new ReadInJoyListViewGroup.1(this, paramBoolean));
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b(paramInt);
    }
    for (;;)
    {
      qcn.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      return;
      a(2, null);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<ArticleInfo> paramList1)
  {
    this.jdField_a_of_type_Pmz.a(paramBoolean, paramInt, paramLong, paramList, paramList1);
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Szc == null)) {
      return;
    }
    this.jdField_a_of_type_Pob.a(paramBoolean1, paramInt, paramList, paramBoolean2);
    int j = pvj.a().a(Integer.valueOf(paramInt));
    if (this.jdField_a_of_type_Pmz.a().d())
    {
      if ((paramList != null) && (j == 1)) {
        this.jdField_a_of_type_Szc.c(0);
      }
      this.jdField_a_of_type_Pmz.a().d(false);
    }
    rbi.a().a();
    StringBuilder localStringBuilder = new StringBuilder().append("onChannelRefreshed, success = ").append(paramBoolean1).append(", refreshedArticleSize = ").append(j).append(", articleSeqList size = ");
    int i;
    if (paramList != null)
    {
      i = paramList.size();
      QLog.d("ReadInJoyListViewGroup", 1, i);
      if (!paramBoolean1) {
        break label247;
      }
      a(paramInt, paramList, paramBoolean2, j);
    }
    for (;;)
    {
      b(paramBoolean1, j);
      t();
      this.jdField_a_of_type_Pmz.d(paramList);
      this.jdField_a_of_type_Pmz.b(paramList);
      this.jdField_a_of_type_Pmz.c(paramList);
      AbstractGifImage.resumeAll();
      qcr.a(this.jdField_a_of_type_Szc.b(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Szc);
      pmu.a(this.jdField_a_of_type_Szc.b(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      return;
      i = 0;
      break;
      label247:
      if (this.jdField_a_of_type_Szc.isEmpty()) {
        a(getResources().getString(2131717803));
      }
    }
  }
  
  public boolean a()
  {
    Boolean localBoolean = this.jdField_a_of_type_Pob.a();
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    return this.jdField_a_of_type_Ppx.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Pns != null) {
      this.jdField_a_of_type_Pns.a(this.jdField_a_of_type_Pmz.a().c());
    }
    if (this.jdField_a_of_type_Szc != null) {
      this.jdField_a_of_type_Szc.a(2, null);
    }
    this.jdField_a_of_type_Pob.e();
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Szc == null) || (paramList == null)) {}
    do
    {
      return;
      if (paramList.size() > 0)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder("refreshChannelData ");
          localStringBuilder.append("channelID : ").append(paramInt).append("\n");
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            Long localLong = (Long)localIterator.next();
            localStringBuilder.append("recommendSeq = " + localLong + ",\n ");
          }
          QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 1, localStringBuilder.toString());
        }
        sgg.a().c(true);
        this.jdField_a_of_type_Pmz.a(pvj.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
        this.jdField_a_of_type_Szc.a(0);
        return;
      }
    } while (!this.jdField_a_of_type_Szc.isEmpty());
    a(getResources().getString(2131717844));
  }
  
  public void b(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    int i = 0;
    paramReadInJoyBaseListView = this.jdField_a_of_type_Pmz.a();
    boolean bool;
    if (paramInt == 4)
    {
      bool = true;
      paramReadInJoyBaseListView.g(bool);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyListViewGroup", 2, "loadmorechannel " + this.jdField_a_of_type_Int + " " + paramInt + " " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.jdField_c_of_type_Int);
      }
      paramReadInJoyBaseListView = pkh.a();
      if ((paramReadInJoyBaseListView == null) || (this.jdField_a_of_type_Int != 56) || (this.jdField_b_of_type_Long != 1001L)) {
        break label216;
      }
      if (((KandianMergeManager)paramReadInJoyBaseListView.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).g()) {
        i = 4;
      }
      i |= 0x2;
    }
    for (;;)
    {
      int j;
      if ((this.jdField_a_of_type_Int == 40830) || (plm.c(this.jdField_a_of_type_Int)))
      {
        j = this.jdField_b_of_type_Int;
        this.jdField_b_of_type_Int = (j + 1);
      }
      for (;;)
      {
        pvj.a().a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Pmz.a().a(), paramInt, i, j);
        pqb.a(this.jdField_a_of_type_Int);
        return;
        bool = false;
        break;
        j = 1;
      }
      label216:
      i = 0;
    }
  }
  
  public void b(Map<Integer, Boolean> paramMap)
  {
    paramMap.put(Integer.valueOf(this.jdField_a_of_type_Int), Boolean.valueOf(true));
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Szc == null))
    {
      this.jdField_a_of_type_Pmz.a().g(false);
      return;
    }
    this.jdField_a_of_type_Pob.b(paramBoolean1, paramInt, paramList, paramBoolean2);
    this.jdField_a_of_type_Pmz.a(paramBoolean1, paramInt, paramList, paramBoolean2);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null) {
      return;
    }
    a(true);
  }
  
  public void c(int paramInt, List<Long> paramList)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (paramList == null) || (this.jdField_a_of_type_Szc == null)) {
      return;
    }
    this.jdField_a_of_type_Szc.b(pvj.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList));
    this.jdField_a_of_type_Szc.notifyDataSetChanged();
  }
  
  public void c(Map<Integer, rot> paramMap)
  {
    this.jdField_a_of_type_Pob.a(paramMap);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "onPause()");
    }
    this.jdField_a_of_type_Pob.c();
    if (this.jdField_a_of_type_Szc != null) {
      this.jdField_a_of_type_Szc.e();
    }
    this.jdField_a_of_type_Ppx.c();
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Pmz.c();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "mListView onSaveInstanceState cost: ", Long.valueOf(System.currentTimeMillis() - l) });
    }
  }
  
  public void d(Map<Integer, rot> paramMap)
  {
    this.jdField_a_of_type_Pqb.a(paramMap);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      uur.a.a(paramCanvas, true, this.jdField_b_of_type_KotlinJvmFunctionsFunction1);
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    pmu.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      uur.a.a(paramCanvas, true, this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "onStart()");
    }
    this.jdField_a_of_type_Pob.d();
    rbi.a().b();
    if ((this.jdField_a_of_type_Int == 0) && (!this.jdField_a_of_type_Pmz.a().d())) {
      a(1500, new ReadInJoyListViewGroup.3(this));
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "onStop()");
    }
    this.jdField_a_of_type_Pob.d();
    this.jdField_a_of_type_Pmz.e();
    rbi.a().c();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Pob.a();
    bmhv.a(System.currentTimeMillis(), (QQAppInterface)pkh.a());
    this.jdField_a_of_type_Pmz.d(this.jdField_a_of_type_Ppq.a());
    ((BaseActivity)a()).app.removeObserver(this.jdField_a_of_type_Anvi);
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Szc.b();
    this.jdField_a_of_type_Szc.a();
    this.jdField_a_of_type_Szc.a(null);
    this.jdField_a_of_type_Szc = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)
    {
      pmu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = null;
    }
    bmhv.b(((BaseActivity)a()).app);
    if (this.jdField_a_of_type_Pqk != null) {
      this.jdField_a_of_type_Pqk.d();
    }
    if (this.jdField_a_of_type_Ppx != null) {
      this.jdField_a_of_type_Ppx.d();
    }
    uvp.a();
    qcn.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    if (plm.c(a())) {
      pkk.a().b();
    }
    rnz.b(a());
    this.jdField_a_of_type_Pmz.a();
    pvm.a().b(this.jdField_a_of_type_Pvq);
    pvm.a().b(this.jdField_a_of_type_Rzb);
  }
  
  public void k()
  {
    this.jdField_a_of_type_Pqk.e();
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.e();
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Szc != null) {
      this.jdField_a_of_type_Szc.notifyDataSetChanged();
    }
  }
  
  public void n()
  {
    this.jdField_a_of_type_Ppx.e();
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.j();
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
      u();
      pno.a(3);
      this.jdField_a_of_type_Pmz.b(true, 3, false);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    EventCollector.getInstance().onViewClicked(paramView);
    int i;
    if ((paramAdapterView instanceof ReadInJoyXListView))
    {
      i = ((ReadInJoyXListView)paramAdapterView).getHeaderViewsCount();
      if (paramInt - i >= 0) {
        i = paramInt - i;
      }
    }
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_Szc.getItem(i);
      ArticleInfo localArticleInfo = null;
      if ((localObject instanceof ArticleInfo))
      {
        localArticleInfo = (ArticleInfo)localObject;
        if (!pqw.r(localArticleInfo)) {}
      }
      do
      {
        do
        {
          return;
          i = paramInt;
          break;
        } while (localArticleInfo.mFeedType == 20);
        QLog.d("ReadInJoyListViewGroup", 1, "onItemClick pos : " + paramInt + ", id : " + paramLong + ", data : " + localArticleInfo);
        a(paramAdapterView, localArticleInfo, paramView, paramInt, i);
      } while (localArticleInfo == null);
      localArticleInfo.invalidateProteusTemplateBean();
      return;
      i = paramInt;
    }
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
  
  public void p()
  {
    ((qcw)this.jdField_a_of_type_Pob.a(2)).j();
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(anvx.a(2131712410));
    }
  }
  
  public void r()
  {
    QLog.d("ReadInJoyListViewGroup", 1, "invalidAllArticles");
    if (this.jdField_a_of_type_Szc != null) {
      this.jdField_a_of_type_Szc.i();
    }
  }
  
  public void setNotifyEndRefresh(pns parampns)
  {
    this.jdField_a_of_type_Pns = parampns;
  }
  
  public void setRefreshHeader(int paramInt)
  {
    this.jdField_a_of_type_Ppx.a(paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, a(), this.jdField_a_of_type_Int);
  }
  
  public void setSkinHeader(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ppx.a(paramInt, paramBoolean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, a(), this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup
 * JD-Core Version:    0.7.0.1
 */