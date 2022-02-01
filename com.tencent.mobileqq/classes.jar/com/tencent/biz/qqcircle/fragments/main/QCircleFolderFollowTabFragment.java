package com.tencent.biz.qqcircle.fragments.main;

import aaak;
import aaam;
import aabd;
import aabe;
import aabj;
import aabp;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.events.QCircleCloseBannerEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedListRefreshEvent;
import com.tencent.biz.qqcircle.events.QCircleLazyLoadTabEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.launchbean.QCircleFolderBean;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.update.HippyQQLibraryManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleCounter.RedPointInfo;
import uzg;
import uzj;
import uzt;
import uzw;
import vbe;
import vgi;
import voc;
import vod;
import voe;
import vtd;
import vtf;
import vtq;
import vtt;
import vud;
import vuf;
import vwy;
import vxq;
import vzy;

public class QCircleFolderFollowTabFragment
  extends QCircleBaseTabFragment
  implements aaam
{
  public static String e;
  private uzj jdField_a_of_type_Uzj;
  private vgi jdField_a_of_type_Vgi;
  private vzy jdField_a_of_type_Vzy;
  private boolean g;
  private boolean h;
  
  static
  {
    jdField_e_of_type_JavaLangString = "QCircleFolderFollowTabFragment";
  }
  
  @NotNull
  private View a(@Nullable ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560746, null);
    paramViewGroup.setOnClickListener(new vod(this));
    return paramViewGroup;
  }
  
  private void a(long paramLong)
  {
    if (!d())
    {
      QLog.d("QCircleEeveeRedPoint_" + jdField_e_of_type_JavaLangString, 1, "[sendClearFollowTabRedPointRequest] return. isRealVisibleToUser = false");
      return;
    }
    QLog.d("QCircleEeveeRedPoint_" + jdField_e_of_type_JavaLangString, 1, "[sendClearFollowTabRedPointRequest]");
    ThreadManager.getSubThreadHandler().post(new QCircleFolderFollowTabFragment.5(this, paramLong));
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      break label7;
    }
    label7:
    label94:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Uzt != null)
      {
        ArrayList localArrayList = this.jdField_a_of_type_Uzt.getDataList();
        if (localArrayList == null) {
          break;
        }
        int i = localArrayList.size() - 1;
        for (;;)
        {
          if (i < 0) {
            break label94;
          }
          FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)localArrayList.get(i);
          if (paramString.equals(localStFeed.poster.id.get()))
          {
            if (this.jdField_a_of_type_Vwy == null) {
              break;
            }
            this.jdField_a_of_type_Vwy.c(localStFeed.id.get());
            return;
          }
          i -= 1;
        }
      }
    }
  }
  
  private boolean d()
  {
    return this.h;
  }
  
  private void n()
  {
    if ((this.f) && (!c()))
    {
      this.jdField_a_of_type_Vzy = a();
      if (this.jdField_a_of_type_Vzy != null)
      {
        this.f = false;
        this.jdField_a_of_type_Vzy.a();
        QLog.d(jdField_e_of_type_JavaLangString, 1, "checkNeedShowRedDot result:true");
      }
    }
  }
  
  private void o()
  {
    uzg.b();
    uzg.a();
    uzg.a(getActivity());
    if (this.jdField_a_of_type_Uzt != null) {
      this.jdField_a_of_type_Uzt.b();
    }
    HippyQQLibraryManager.getInstance().preDownload();
  }
  
  private void p()
  {
    if (!d())
    {
      QLog.d("QCircleEeveeRedPoint_" + jdField_e_of_type_JavaLangString, 1, "[clearLocalRedPoint] return. isRealVisibleToUser = false");
      return;
    }
    QLog.d("QCircleEeveeRedPoint_" + jdField_e_of_type_JavaLangString, 1, "[clearLocalRedPoint]");
    ThreadManager.getSubThreadHandler().post(new QCircleFolderFollowTabFragment.4(this));
  }
  
  private void q()
  {
    if (!d())
    {
      QLog.d("QCircleEeveeRedPoint_" + jdField_e_of_type_JavaLangString, 1, "[sendClearOuterEntranceRedPointRequest] return. isRealVisibleToUser = false");
      return;
    }
    QLog.d("QCircleEeveeRedPoint_" + jdField_e_of_type_JavaLangString, 1, "[sendClearOuterEntranceRedPointRequest] ");
    ThreadManager.getSubThreadHandler().post(new QCircleFolderFollowTabFragment.6(this));
  }
  
  public void a(int paramInt)
  {
    this.h = true;
    super.a(paramInt);
    if (this.jdField_a_of_type_Vzy != null) {
      this.jdField_a_of_type_Vzy.a(false);
    }
    long l1 = vtd.c();
    long l2 = vtd.b();
    if (l1 > l2) {
      a(l1);
    }
    QLog.d(jdField_e_of_type_JavaLangString, 1, "[onPageSelected] followTabFeedListLastPreRspTimestamp: " + l1 + ", followTabFeedListLastRspTimestamp: " + l2);
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Aabd.a().a().a(a(paramViewGroup));
    this.jdField_a_of_type_Aabd.a().a().addOnScrollListener(new voc(this));
    aaak.a().a(this);
  }
  
  public void a(List<aabe> paramList)
  {
    super.a(paramList);
    this.jdField_a_of_type_Vgi = new vgi();
    this.jdField_a_of_type_Vgi.a(a());
    paramList.add(this.jdField_a_of_type_Vgi);
  }
  
  public void a(vbe paramvbe)
  {
    super.a(paramvbe);
    this.h = c();
  }
  
  public void a(vxq<List<FeedCloudMeta.StFeed>> paramvxq)
  {
    super.a(paramvxq);
    if ((paramvxq != null) && (!paramvxq.b()))
    {
      QLog.d(jdField_e_of_type_JavaLangString, 1, "handleFeedDataRsp is refresh clearLocalRedPoint");
      p();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 1;
    boolean bool = d();
    QLog.d(jdField_e_of_type_JavaLangString, 1, "[refreshData] isRealVisibleToUser : " + bool);
    g();
    if (this.jdField_a_of_type_Vwy != null)
    {
      vwy localvwy = this.jdField_a_of_type_Vwy;
      if (bool) {
        i = 0;
      }
      localvwy.a(paramBoolean, i);
    }
  }
  
  public String b()
  {
    return jdField_b_of_type_JavaLangString;
  }
  
  public List<aabp> b()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Uzj = new uzj(new Bundle());
    this.jdField_a_of_type_Uzj.a(false);
    this.jdField_a_of_type_Uzj.a(a());
    this.jdField_a_of_type_Uzw = new uzw(new Bundle());
    this.jdField_a_of_type_Uzw.a(false);
    this.jdField_a_of_type_Uzw.a(a());
    localArrayList.add(this.jdField_a_of_type_Uzj);
    localArrayList.add(this.jdField_a_of_type_Uzw);
    return localArrayList;
  }
  
  public void b()
  {
    this.h = false;
    super.b();
  }
  
  public int c()
  {
    return 1;
  }
  
  public String c()
  {
    return jdField_e_of_type_JavaLangString;
  }
  
  public String d()
  {
    return "follow_page";
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_Vwy.b().observe(this, new voe(this));
  }
  
  public void e()
  {
    super.e();
    p();
    q();
    if (d())
    {
      long l1 = vtd.c();
      long l2 = vtd.b();
      if (l1 > l2) {
        a(l1);
      }
      QLog.d(jdField_e_of_type_JavaLangString, 1, "[setUserVisibleHint] followTabFeedListLastPreRspTimestamp: " + l1 + ", followTabFeedListLastRspTimestamp: " + l2);
    }
  }
  
  public void g()
  {
    super.g();
    n();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    localArrayList.add(QCircleCloseBannerEvent.class);
    localArrayList.add(QCircleLazyLoadTabEvent.class);
    localArrayList.add(QCircleFeedListRefreshEvent.class);
    return localArrayList;
  }
  
  public void m()
  {
    boolean bool2 = true;
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      Object localObject = (QCircleFolderBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      if ((((QCircleFolderBean)localObject).getQQCircleUnreadRedNum() <= 0) || (!c())) {
        break label192;
      }
      bool1 = true;
      this.c = bool1;
      if (this.c)
      {
        if (((QCircleFolderBean)localObject).getQQCircleUnreadRedNum() <= vtd.a()) {
          break label197;
        }
        bool1 = true;
        label76:
        this.d = bool1;
      }
      localObject = ((vtf)BaseApplicationImpl.getApplication().getRuntime().getManager(376)).b("circle_entrance");
      if (localObject == null) {
        break label207;
      }
      localObject = ((QQCircleCounter.RedPointInfo)localObject).rptRedInfo.get();
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label207;
      }
    }
    label192:
    label197:
    label207:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_e_of_type_Boolean = bool1;
      this.f = bool1;
      if ((!this.jdField_e_of_type_Boolean) && (!this.d)) {}
      for (bool1 = bool2;; bool1 = false)
      {
        this.jdField_b_of_type_Boolean = bool1;
        QLog.d(jdField_e_of_type_JavaLangString, 4, "enableMemCache:" + this.jdField_b_of_type_Boolean);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label76;
      }
    }
  }
  
  public void onDestroy()
  {
    uzg.c();
    uzg.b(getActivity());
    super.onDestroy();
    aaak.a().b(this);
    uym.a = false;
    if (this.jdField_a_of_type_Vzy != null) {
      this.jdField_a_of_type_Vzy.c();
    }
  }
  
  public void onDetach()
  {
    QLog.d(jdField_e_of_type_JavaLangString, 1, "QCircleFolderFollowTabFragment->onDetach");
    super.onDetach();
    vtt.a().b(c());
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Vzy != null) {
      this.jdField_a_of_type_Vzy.d();
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    QCircleFeedEvent localQCircleFeedEvent;
    if ((paramSimpleBaseEvent instanceof QCircleFeedEvent))
    {
      localQCircleFeedEvent = (QCircleFeedEvent)paramSimpleBaseEvent;
      if (localQCircleFeedEvent.mState == 3) {
        if (this.jdField_a_of_type_Vwy != null) {
          this.jdField_a_of_type_Vwy.c(((QCircleFeedEvent)paramSimpleBaseEvent).mTargetId);
        }
      }
    }
    label41:
    do
    {
      do
      {
        do
        {
          break label41;
          do
          {
            return;
          } while (localQCircleFeedEvent.mState != 6);
          a(((QCircleFeedEvent)paramSimpleBaseEvent).mTargetId);
          return;
          if (!(paramSimpleBaseEvent instanceof QCircleCloseBannerEvent)) {
            break;
          }
        } while (this.jdField_a_of_type_Vwy == null);
        this.jdField_a_of_type_Vwy.b().removeObservers(this);
        this.jdField_a_of_type_Vwy.b().postValue(null);
        return;
        if (!(paramSimpleBaseEvent instanceof QCircleLazyLoadTabEvent)) {
          break;
        }
        c();
      } while (this.g);
      o();
      this.g = true;
      return;
    } while ((!(paramSimpleBaseEvent instanceof QCircleFeedListRefreshEvent)) || (((QCircleFeedListRefreshEvent)paramSimpleBaseEvent).mPageType != 1));
    a(false);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    QLog.d(jdField_e_of_type_JavaLangString, 1, "QCircleFolderFollowTabFragment->setUserVisibleHint:" + paramBoolean);
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      vtt.a().a(c());
      vtt.a().c(c());
      vtq.a("", 22, 1);
      vud.a().a(new vuf().a("main").b("impression").a(a()));
      return;
    }
    vtt.a().d(c());
    vtt.a().b(c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.QCircleFolderFollowTabFragment
 * JD-Core Version:    0.7.0.1
 */