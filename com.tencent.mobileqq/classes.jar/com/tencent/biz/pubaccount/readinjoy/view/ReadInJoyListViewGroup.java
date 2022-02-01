package com.tencent.biz.pubaccount.readinjoy.view;

import amsu;
import amtj;
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
import bkwm;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
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
import oiy;
import pak;
import pay;
import pbj;
import pbn;
import pcl;
import pdt;
import pdy;
import pea;
import peo;
import pep;
import peq;
import per;
import pes;
import pet;
import pev;
import pey;
import pgk;
import pgm;
import pgt;
import pgw;
import pgz;
import phc;
import phy;
import pkm;
import pkp;
import pkt;
import ple;
import plt;
import prq;
import pru;
import prz;
import qpd;
import qxg;
import rbt;
import rcn;
import rmm;
import rtr;
import sdg;
import sef;
import sls;
import slz;
import smx;
import smy;
import smz;
import sna;
import snb;
import snc;
import snd;
import szx;
import ttq;
import ugt;
import ugu;
import uhs;
import uhv;
import uia;

public class ReadInJoyListViewGroup
  extends ReadInJoyBaseListViewGroup
  implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, peq, per, pes, pet, sef, slz
{
  private long jdField_a_of_type_Long;
  private amsu jdField_a_of_type_Amsu = new snd(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected FaceDecoder a;
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new snc(this);
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Function1<Canvas, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1 = new smz(this);
  public pdy a;
  pep jdField_a_of_type_Pep;
  public pey a;
  pgk jdField_a_of_type_Pgk;
  pgm jdField_a_of_type_Pgm;
  pgt jdField_a_of_type_Pgt;
  pgw jdField_a_of_type_Pgw;
  pgz jdField_a_of_type_Pgz;
  phy jdField_a_of_type_Phy;
  private pkt jdField_a_of_type_Pkt = new smx(this);
  private rmm jdField_a_of_type_Rmm = new smy(this);
  private sls jdField_a_of_type_Sls;
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private Function1<Canvas, Unit> jdField_b_of_type_KotlinJvmFunctionsFunction1 = new sna(this);
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = -1L;
  
  public ReadInJoyListViewGroup(oiy paramoiy, int paramInt1, int paramInt2, int paramInt3, pak parampak)
  {
    this(paramoiy, paramInt1, paramInt2, paramInt3, parampak, 2131560285);
  }
  
  public ReadInJoyListViewGroup(oiy paramoiy, int paramInt1, int paramInt2, int paramInt3, pak parampak, int paramInt4)
  {
    super(paramoiy, paramInt1, parampak);
    this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(paramInt4, this);
    this.jdField_b_of_type_Long = paramInt3;
    setId(2131375955);
    this.jdField_a_of_type_Pey = new pey();
    this.jdField_a_of_type_Pey.a(this);
    this.jdField_a_of_type_Pgw = new pgw();
    this.jdField_a_of_type_Phy = new phy();
    this.jdField_a_of_type_Pgk = new pgk();
    this.jdField_a_of_type_Pgt = new pgt();
    this.jdField_a_of_type_Pak.jdField_c_of_type_Long = bkwm.a((QQAppInterface)pay.a());
    this.jdField_a_of_type_Pdy = new pdy(new pea().a(this.jdField_a_of_type_Pak).a(this.jdField_a_of_type_Int).a(a()).a(this.jdField_b_of_type_Long).d(paramInt2).a(this.jdField_a_of_type_Oiy).a(this.jdField_a_of_type_Pgt).a(this));
    this.jdField_a_of_type_Pgm = new pgm().a(this.jdField_a_of_type_Int).a(a());
    this.jdField_a_of_type_Pgz = new pgz(new phc().a(this.jdField_a_of_type_Int).a(a()));
    a(paramInt1, paramInt2);
    this.jdField_a_of_type_Pdy.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    this.jdField_a_of_type_Pdy.a().a(this.jdField_a_of_type_Sls);
    this.jdField_a_of_type_Pgz.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    this.jdField_a_of_type_Pgm.a(this.jdField_a_of_type_Sls);
    this.jdField_a_of_type_Pey.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
  }
  
  public ReadInJoyListViewGroup(oiy paramoiy, int paramInt1, int paramInt2, pak parampak)
  {
    this(paramoiy, paramInt1, paramInt2, -1, parampak);
  }
  
  public ReadInJoyListViewGroup(oiy paramoiy, int paramInt, pak parampak)
  {
    this(paramoiy, paramInt, -1, parampak);
  }
  
  public static ArticleInfo a(ArticleInfo paramArticleInfo)
  {
    return pgk.a(paramArticleInfo);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131378014));
    if (paramInt1 == 41695)
    {
      this.jdField_a_of_type_Pgt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, a());
      pdy.a(this.jdField_a_of_type_Int);
    }
    if (paramInt1 == 56) {
      this.jdField_a_of_type_Long = a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
    }
    if (pcl.c(this.jdField_a_of_type_Int)) {
      pbj.a().a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(a(), ((BaseActivity)a()).app);
    this.jdField_a_of_type_Sls = new sls(a(), a().getLayoutInflater(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, this.jdField_a_of_type_Pey.a());
    this.jdField_a_of_type_Pey.a(this.jdField_a_of_type_Pey.a(), this.jdField_a_of_type_Sls);
    this.jdField_a_of_type_Pey.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_b_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, "initUI before mListView.setPadding :" + this.jdField_a_of_type_Oiy + a());
    }
    s();
    b(paramInt2);
    t();
    this.jdField_a_of_type_Pgt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, a(), this.jdField_a_of_type_Int);
    ((BaseActivity)a()).app.addObserver(this.jdField_a_of_type_Amsu);
    this.jdField_a_of_type_Pgz.h();
    pkp.a().a(this.jdField_a_of_type_Pkt);
    pkp.a().a(this.jdField_a_of_type_Rmm);
  }
  
  private void a(int paramInt, Runnable paramRunnable)
  {
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.9(this, paramRunnable), paramInt);
  }
  
  private void a(String paramString)
  {
    a(paramString, null);
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    findViewById(2131373643).setVisibility(8);
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = ((ViewStub)findViewById(2131371695)).inflate();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131375916));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131375915));
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
      this.jdField_a_of_type_Pgt.a(this, this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130839320));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166892));
    }
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_Sls.b(paramInt);
    this.jdField_a_of_type_Sls.a(this.jdField_b_of_type_Long);
    peo localpeo = new peo().a(this).a(this).a(this).a(this);
    this.jdField_a_of_type_Sls.a(localpeo);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_Sls);
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
        str = getResources().getString(2131717396);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(true, str);
      if (!bkwm.i()) {
        break;
      }
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.5(this), 1500L);
      return;
      str = getResources().getString(2131717395);
      continue;
      if (this.jdField_a_of_type_Int == 40677)
      {
        if ((paramBoolean) && (paramInt > 0)) {
          str = String.format(getResources().getString(2131717235), new Object[] { Integer.valueOf(paramInt * 2) });
        } else {
          str = getResources().getString(2131717234);
        }
      }
      else if (this.jdField_a_of_type_Int == 40531)
      {
        if ((paramBoolean) && (paramInt > 0)) {
          str = String.format(getResources().getString(2131717235), new Object[] { Integer.valueOf(paramInt) });
        } else {
          str = getResources().getString(2131717233);
        }
      }
      else if ((paramBoolean) && (paramInt > 0)) {
        str = String.format(getResources().getString(2131717235), new Object[] { Integer.valueOf(paramInt) });
      } else {
        str = getResources().getString(2131717234);
      }
    }
  }
  
  private boolean b()
  {
    boolean bool = a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", false);
    a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", false);
    return bool;
  }
  
  private void s()
  {
    if (!pay.r())
    {
      QLog.d("ReadInJoyListViewGroup", 2, "ListView overdraw switch close");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setContentBackground(2130838891);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_Pey.a);
    if ((this.jdField_a_of_type_Int == 0) || (pcl.c(this.jdField_a_of_type_Int))) {
      qxg.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
    }
  }
  
  private void t()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    View localView = findViewById(2131373643);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
    this.jdField_a_of_type_Pgt.a(this, this.jdField_a_of_type_Int);
  }
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  }
  
  public pdy a()
  {
    return this.jdField_a_of_type_Pdy;
  }
  
  public pey a()
  {
    return this.jdField_a_of_type_Pey;
  }
  
  public pgt a()
  {
    return this.jdField_a_of_type_Pgt;
  }
  
  public sls a()
  {
    return this.jdField_a_of_type_Sls;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "OnResume()");
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "onResume, mChannelID= ", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    this.jdField_a_of_type_Pey.b();
    if (this.jdField_a_of_type_Pdy.e()) {
      j();
    }
    if (System.currentTimeMillis() - this.jdField_c_of_type_Long > 10000L)
    {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.2(this));
    }
    if (this.jdField_a_of_type_Sls != null) {
      this.jdField_a_of_type_Sls.d();
    }
    this.jdField_a_of_type_Pgt.b();
    this.jdField_a_of_type_Pgz.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.invalidate();
    if ((this.jdField_a_of_type_Int == 0) || (pcl.c(this.jdField_a_of_type_Int))) {
      qxg.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Pgz.i();
    rbt.a(a());
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyListViewGroup", 2, "refreshListByChannelID channelID = " + paramInt + " mChannelID = " + this.jdField_a_of_type_Int);
    }
    if ((paramInt == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Sls != null)) {
      this.jdField_a_of_type_Pdy.b(true, 1001, true);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Pey.a(paramInt1, paramInt2, paramIntent);
    paramIntent = new pev(paramInt1, paramInt2, paramIntent, this.jdField_a_of_type_Sls, a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Pdy);
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
    this.jdField_a_of_type_Sls.a(paramInt, paramIntent);
  }
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Pdy.a(paramInt, paramArticleInfo, paramString1, paramString2);
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    ugt.a(null, "KANDIAN_NEW_FEEDS_ON_CHANNEL_ARTICLE_LOADED");
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Sls == null)) {
      return;
    }
    this.jdField_a_of_type_Pey.a(paramInt, paramList);
    this.jdField_a_of_type_Pdy.a(paramInt, paramList, new snb(this));
    ugt.a("KANDIAN_NEW_FEEDS_ON_CHANNEL_ARTICLE_LOADED", null);
    ugt.a("KANDIAN_NEW_FEEDS_LOAD_ARTICLE", null);
    ugt.a(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE_FINISH_TO_MEASURE");
  }
  
  public void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Pey.a(paramContext, paramArticleInfo, paramString, paramInt2);
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
    pay.a = paramArticleInfo;
    this.jdField_a_of_type_Pey.a(paramView, paramArticleInfo, paramInt);
    this.jdField_a_of_type_Pgk.a(paramView, paramArticleInfo, paramInt, this.jdField_a_of_type_Pgm);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, long paramLong)
  {
    int i = 0;
    ArticleInfo localArticleInfo = (ArticleInfo)paramBaseArticleInfo;
    if (pay.s(localArticleInfo)) {
      if ((pay.m(localArticleInfo)) || (pay.c(localArticleInfo)))
      {
        this.jdField_a_of_type_Pgk.a(localArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt, this.jdField_a_of_type_Pgm);
        paramInt = 4;
        this.jdField_a_of_type_Pgk.a(paramInt, this.jdField_a_of_type_Pgm);
      }
    }
    do
    {
      return;
      if (pay.e(localArticleInfo))
      {
        paramInt = i;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("ReadInJoyListViewGroup", 2, "atlas native has undercarriage");
        paramInt = i;
        break;
      }
      this.jdField_a_of_type_Pgk.b(localArticleInfo, this.jdField_a_of_type_Pgm);
      paramInt = 2;
      break;
      a(null, paramBaseArticleInfo, paramView, paramInt, paramLong);
    } while (paramBaseArticleInfo == null);
    paramBaseArticleInfo.invalidateProteusTemplateBean();
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    this.jdField_a_of_type_Pgt.a(paramTopBannerInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Sls);
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    this.jdField_a_of_type_Pdy.a().b(paramInt);
    this.jdField_a_of_type_Pey.a(paramReadInJoyBaseListView, paramInt);
    this.jdField_a_of_type_Pgw.a(this.jdField_a_of_type_Int, paramInt);
    this.jdField_a_of_type_Pdy.b();
    this.jdField_a_of_type_Pdy.b(paramInt);
    this.jdField_a_of_type_Pdy.h();
    this.jdField_a_of_type_Pgt.a();
    if (this.jdField_a_of_type_Int == 0) {
      uhv.d();
    }
    prq.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    RecommendFeedsDiandianEntranceManager.a().a();
  }
  
  public void a(AdapterView<?> paramAdapterView, BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, long paramLong)
  {
    pbn localpbn = new pbn(Integer.valueOf(0));
    this.jdField_a_of_type_Pgk.a(paramView);
    ArticleInfo localArticleInfo = (ArticleInfo)paramBaseArticleInfo;
    String str;
    if (localArticleInfo != null)
    {
      str = paramBaseArticleInfo.innerUniqueID;
      this.jdField_a_of_type_Pey.a(paramAdapterView, paramView, paramInt, paramLong);
      this.jdField_a_of_type_Pgk.a(paramBaseArticleInfo, this.jdField_a_of_type_Int);
      pay.a = localArticleInfo;
      if (this.jdField_a_of_type_Pgk.a(paramBaseArticleInfo, paramView, paramInt, localpbn, localArticleInfo, this.jdField_a_of_type_Pgm, this.jdField_a_of_type_AndroidOsHandler)) {
        return;
      }
      this.jdField_a_of_type_Pgk.a(paramInt, localArticleInfo, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Pgm);
    }
    for (paramAdapterView = str;; paramAdapterView = "")
    {
      this.jdField_a_of_type_Pgk.a(((Integer)localpbn.a()).intValue(), this.jdField_a_of_type_Pgm);
      QLog.d("ReadInJoyListViewGroup", 1, "onItemClick, rowkey= " + paramAdapterView);
      return;
    }
  }
  
  public void a(Map<Integer, Boolean> paramMap) {}
  
  public void a(Map<Long, rcn> paramMap, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "detachFromViewGroup()");
    }
    this.jdField_a_of_type_Pey.a(paramMap, paramBoolean);
    this.jdField_a_of_type_Pgw.a(paramMap, paramBoolean, uhv.a(this.jdField_a_of_type_Int), pay.e(this.jdField_a_of_type_Int), this.jdField_a_of_type_Pdy.e(), this.jdField_a_of_type_Int, getContext(), this.jdField_a_of_type_Pdy.a().a(), this.jdField_a_of_type_Oiy, this.jdField_a_of_type_Pdy.a().e(), this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Pdy.j();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b(false);
    }
    a().getIntent().putExtra("from_search", false);
  }
  
  public void a(Map<Long, rcn> paramMap, boolean paramBoolean, Map<Long, uia> paramMap1, String paramString)
  {
    this.jdField_a_of_type_Pgw.a(paramMap, paramBoolean, paramMap1, paramString, getContext(), this.jdField_a_of_type_Int, this.jdField_a_of_type_Pdy.a().a(), this.jdField_a_of_type_Oiy, this.jdField_a_of_type_Pdy.a().e(), this.jdField_a_of_type_Long);
  }
  
  public void a(Set<Long> paramSet, Map<Long, rcn> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "attachToViewGroup()");
    }
    this.jdField_a_of_type_Pey.a(paramSet, paramMap);
    if (this.jdField_a_of_type_Sls != null) {
      this.jdField_a_of_type_Sls.a(paramSet, paramMap);
    }
    this.jdField_a_of_type_Pdy.i();
    this.jdField_a_of_type_Pgz.a();
    ugt.a(null, "KANDIAN_FEEDS_STAGE_2_COST");
    if (!this.jdField_a_of_type_Pdy.e()) {
      j();
    }
  }
  
  public void a(sdg paramsdg1, sdg paramsdg2)
  {
    ((prz)this.jdField_a_of_type_Pey.a(2)).k();
  }
  
  public void a(szx paramszx)
  {
    this.jdField_a_of_type_Pgt.a(paramszx, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
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
      this.jdField_a_of_type_Pdy.f();
    } while (!this.jdField_a_of_type_Pdy.a().d());
    this.jdField_a_of_type_Pey.a(paramBoolean, paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.post(new ReadInJoyListViewGroup.1(this, paramBoolean));
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b(paramInt);
    }
    for (;;)
    {
      prq.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      return;
      a(2, null);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<ArticleInfo> paramList1)
  {
    this.jdField_a_of_type_Pdy.a(paramBoolean, paramInt, paramLong, paramList, paramList1);
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Sls == null)) {
      return;
    }
    this.jdField_a_of_type_Pey.a(paramBoolean1, paramInt, paramList, paramBoolean2);
    int j = pkm.a().a(Integer.valueOf(paramInt));
    if (this.jdField_a_of_type_Pdy.a().d())
    {
      if ((paramList != null) && (j == 1)) {
        this.jdField_a_of_type_Sls.c(0);
      }
      this.jdField_a_of_type_Pdy.a().d(false);
    }
    qpd.a().a();
    Object localObject = new StringBuilder().append("onChannelRefreshed, success = ").append(paramBoolean1).append(", refreshedArticleSize = ").append(j).append(", articleSeqList size = ");
    if (paramList != null) {}
    for (int i = paramList.size();; i = 0)
    {
      QLog.d("ReadInJoyListViewGroup", 1, i);
      if (!paramBoolean1) {
        break label669;
      }
      if ((paramList == null) || (j <= 0) || (paramList.size() <= 0)) {
        break label606;
      }
      if (!QLog.isColorLevel()) {
        break label298;
      }
      localObject = new StringBuilder("onChannelRefreshed ");
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        ((StringBuilder)localObject).append("recommendSeq = " + localLong + ",\n ");
      }
    }
    QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 1, ((StringBuilder)localObject).toString());
    label298:
    if (!this.jdField_a_of_type_Sls.b) {
      this.jdField_a_of_type_Sls.a(false);
    }
    this.jdField_a_of_type_Sls.b = true;
    rtr.a().c(true);
    this.jdField_a_of_type_Pdy.a(pkm.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
    this.jdField_a_of_type_Sls.a(0);
    if ((paramInt == 56) || (paramInt == 0))
    {
      localObject = pay.a();
      if (localObject != null) {
        ((ttq)((AppRuntime)localObject).getManager(307)).a(getContext(), paramInt);
      }
    }
    if (paramInt == 70) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoMoreData(paramBoolean2);
    }
    if ((paramInt == 0) || (pcl.c(this.jdField_a_of_type_Int))) {
      ple.a().a.a(2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    }
    b(paramBoolean1, j);
    if (this.jdField_a_of_type_Int == 70) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.jdField_c_of_type_Int = 0;
    }
    if ((this.jdField_a_of_type_Int == 56) && (this.jdField_a_of_type_Pdy.a().g())) {
      if (this.jdField_a_of_type_Pgt.a() != null) {
        break label696;
      }
    }
    label669:
    label696:
    for (paramInt = 0;; paramInt = 1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setSelectionFromTop(paramInt, 0);
      this.jdField_a_of_type_Pdy.a().a(false);
      if ((pcl.a(this.jdField_a_of_type_Int)) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView instanceof ReadInJoyDailyXListView))) {
        ((ReadInJoyDailyXListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView).g();
      }
      this.jdField_a_of_type_Pdy.c(paramList);
      this.jdField_a_of_type_Pdy.b(paramList);
      AbstractGifImage.resumeAll();
      pru.a(this.jdField_a_of_type_Sls.b(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Sls);
      pdt.a(this.jdField_a_of_type_Sls.b(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      return;
      label606:
      if (!this.jdField_a_of_type_Sls.isEmpty()) {
        break;
      }
      if (this.jdField_a_of_type_Int == 70)
      {
        a(getResources().getString(2131717393), getResources().getDrawable(2130849318));
        break;
      }
      a(getResources().getString(2131717478));
      break;
      if (!this.jdField_a_of_type_Sls.isEmpty()) {
        break;
      }
      a(getResources().getString(2131717437));
      break;
    }
  }
  
  public boolean a()
  {
    Boolean localBoolean = this.jdField_a_of_type_Pey.a();
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    return this.jdField_a_of_type_Pgt.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Pep != null) {
      this.jdField_a_of_type_Pep.a(this.jdField_a_of_type_Pdy.a().c());
    }
    if (this.jdField_a_of_type_Sls != null) {
      this.jdField_a_of_type_Sls.a(2, null);
    }
    this.jdField_a_of_type_Pey.e();
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Sls == null) || (paramList == null)) {}
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
        rtr.a().c(true);
        this.jdField_a_of_type_Pdy.a(pkm.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
        this.jdField_a_of_type_Sls.a(0);
        return;
      }
    } while (!this.jdField_a_of_type_Sls.isEmpty());
    a(getResources().getString(2131717478));
  }
  
  public void b(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    int i = 0;
    paramReadInJoyBaseListView = this.jdField_a_of_type_Pdy.a();
    boolean bool;
    if (paramInt == 4)
    {
      bool = true;
      paramReadInJoyBaseListView.g(bool);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyListViewGroup", 2, "loadmorechannel " + this.jdField_a_of_type_Int + " " + paramInt + " " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.jdField_c_of_type_Int);
      }
      paramReadInJoyBaseListView = pay.a();
      if ((paramReadInJoyBaseListView == null) || (this.jdField_a_of_type_Int != 56) || (this.jdField_b_of_type_Long != 1001L)) {
        break label216;
      }
      if (((KandianMergeManager)paramReadInJoyBaseListView.getManager(162)).g()) {
        i = 4;
      }
      i |= 0x2;
    }
    for (;;)
    {
      int j;
      if ((this.jdField_a_of_type_Int == 40830) || (pcl.c(this.jdField_a_of_type_Int)))
      {
        j = this.jdField_b_of_type_Int;
        this.jdField_b_of_type_Int = (j + 1);
      }
      for (;;)
      {
        pkm.a().a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Pdy.a().a(), paramInt, i, j);
        pgw.a(this.jdField_a_of_type_Int);
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
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Sls == null))
    {
      this.jdField_a_of_type_Pdy.a().g(false);
      return;
    }
    this.jdField_a_of_type_Pey.b(paramBoolean1, paramInt, paramList, paramBoolean2);
    this.jdField_a_of_type_Pdy.a(paramBoolean1, paramInt, paramList, paramBoolean2);
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
    if ((paramInt != this.jdField_a_of_type_Int) || (paramList == null) || (this.jdField_a_of_type_Sls == null)) {
      return;
    }
    this.jdField_a_of_type_Sls.b(pkm.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList));
    this.jdField_a_of_type_Sls.notifyDataSetChanged();
  }
  
  public void c(Map<Integer, rcn> paramMap)
  {
    this.jdField_a_of_type_Pey.a(paramMap);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "onPause()");
    }
    this.jdField_a_of_type_Pey.c();
    if (this.jdField_a_of_type_Sls != null) {
      this.jdField_a_of_type_Sls.e();
    }
    this.jdField_a_of_type_Pgt.c();
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Pdy.c();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "mListView onSaveInstanceState cost: ", Long.valueOf(System.currentTimeMillis() - l) });
    }
  }
  
  public void d(Map<Integer, rcn> paramMap)
  {
    this.jdField_a_of_type_Pgw.a(paramMap);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      ugu.a.a(paramCanvas, true, this.jdField_b_of_type_KotlinJvmFunctionsFunction1);
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    pdt.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      ugu.a.a(paramCanvas, true, this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "onStart()");
    }
    this.jdField_a_of_type_Pey.d();
    qpd.a().b();
    if ((this.jdField_a_of_type_Int == 0) && (!this.jdField_a_of_type_Pdy.a().d())) {
      a(1500, new ReadInJoyListViewGroup.3(this));
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "onStop()");
    }
    this.jdField_a_of_type_Pey.d();
    this.jdField_a_of_type_Pdy.e();
    qpd.a().c();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Pey.a();
    bkwm.a(System.currentTimeMillis(), (QQAppInterface)pay.a());
    this.jdField_a_of_type_Pdy.c(this.jdField_a_of_type_Pgm.a());
    ((BaseActivity)a()).app.removeObserver(this.jdField_a_of_type_Amsu);
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Sls.b();
    this.jdField_a_of_type_Sls.a();
    this.jdField_a_of_type_Sls.a(null);
    this.jdField_a_of_type_Sls = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)
    {
      pdt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = null;
    }
    bkwm.b(((BaseActivity)a()).app);
    if (this.jdField_a_of_type_Pgz != null) {
      this.jdField_a_of_type_Pgz.c();
    }
    if (this.jdField_a_of_type_Pgt != null) {
      this.jdField_a_of_type_Pgt.d();
    }
    uhs.a();
    prq.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    if (pcl.c(a())) {
      pbj.a().b();
    }
    rbt.b(a());
    this.jdField_a_of_type_Pdy.a();
    pkp.a().b(this.jdField_a_of_type_Pkt);
    pkp.a().b(this.jdField_a_of_type_Rmm);
  }
  
  public void k()
  {
    this.jdField_a_of_type_Pgz.d();
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.e();
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Sls != null) {
      this.jdField_a_of_type_Sls.notifyDataSetChanged();
    }
  }
  
  public void n()
  {
    this.jdField_a_of_type_Pgt.e();
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
      t();
      pay.b(3);
      this.jdField_a_of_type_Pdy.b(true, 3, false);
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
      Object localObject = this.jdField_a_of_type_Sls.getItem(i);
      ArticleInfo localArticleInfo = null;
      if ((localObject instanceof ArticleInfo))
      {
        localArticleInfo = (ArticleInfo)localObject;
        if (!pay.r(localArticleInfo)) {}
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
    ((prz)this.jdField_a_of_type_Pey.a(2)).j();
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(amtj.a(2131712063));
    }
  }
  
  public void r()
  {
    QLog.d("ReadInJoyListViewGroup", 1, "invalidAllArticles");
    if (this.jdField_a_of_type_Sls != null) {
      this.jdField_a_of_type_Sls.i();
    }
  }
  
  public void setNotifyEndRefresh(pep parampep)
  {
    this.jdField_a_of_type_Pep = parampep;
  }
  
  public void setRefreshHeader(int paramInt)
  {
    this.jdField_a_of_type_Pgt.a(paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, a(), this.jdField_a_of_type_Int);
  }
  
  public void setSkinHeader(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Pgt.a(paramInt, paramBoolean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, a(), this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup
 * JD-Core Version:    0.7.0.1
 */