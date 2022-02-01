package com.tencent.biz.qqcircle.fragments.main;

import android.arch.lifecycle.MutableLiveData;
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
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import tlg;
import uxx;
import uya;
import uyk;
import uym;
import vee;
import vly;
import vlz;
import vma;
import vmb;
import vqu;
import vrf;
import vri;
import vrr;
import vrt;
import vtz;
import vud;
import vup;
import zwp;
import zwr;
import zxi;
import zxj;
import zxo;
import zxu;

public class QCircleFolderFollowTabFragment
  extends QCircleBaseTabFragment
  implements zwr
{
  public static String i = "QCircleFolderFollowTabFragment";
  private uya jdField_a_of_type_Uya;
  private uym jdField_a_of_type_Uym;
  private vee jdField_a_of_type_Vee;
  private vud jdField_a_of_type_Vud;
  private boolean b;
  
  @NotNull
  private View a(@Nullable ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560725, null);
    paramViewGroup.setOnClickListener(new vlz(this));
    return paramViewGroup;
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
      if (this.jdField_a_of_type_Uyk != null)
      {
        ArrayList localArrayList = this.jdField_a_of_type_Uyk.getDataList();
        if (localArrayList == null) {
          break;
        }
        int j = localArrayList.size() - 1;
        for (;;)
        {
          if (j < 0) {
            break label94;
          }
          FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)localArrayList.get(j);
          if (paramString.equals(localStFeed.poster.id.get()))
          {
            if (this.jdField_a_of_type_Vtz == null) {
              break;
            }
            this.jdField_a_of_type_Vtz.b(localStFeed.id.get());
            return;
          }
          j -= 1;
        }
      }
    }
  }
  
  private void m()
  {
    uxx.b();
    uxx.a();
    uxx.a(getActivity());
    if (this.jdField_a_of_type_Uyk != null) {
      this.jdField_a_of_type_Uyk.b();
    }
    tlg.a();
  }
  
  private void n()
  {
    ((vqu)BaseApplicationImpl.getApplication().getRuntime().getManager(376)).a("circle_entrance", null);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Zxi.a().a().a(a(paramViewGroup));
    this.jdField_a_of_type_Zxi.a().a().addOnScrollListener(new vly(this));
    zwp.a().a(this);
  }
  
  public void a(List<zxj> paramList)
  {
    super.a(paramList);
    this.jdField_a_of_type_Vee = new vee();
    this.jdField_a_of_type_Vee.a(a());
    paramList.add(this.jdField_a_of_type_Vee);
  }
  
  public void a(vup<List<FeedCloudMeta.StFeed>> paramvup)
  {
    super.a(paramvup);
    if ((paramvup != null) && (!paramvup.b()))
    {
      QLog.d(i, 1, "handleFeedDataRsp is refresh reportRedPoint");
      n();
    }
  }
  
  public String b()
  {
    return jdField_b_of_type_JavaLangString;
  }
  
  public List<zxu> b()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Uya = new uya(new Bundle());
    this.jdField_a_of_type_Uya.a(false);
    this.jdField_a_of_type_Uya.a(a());
    this.jdField_a_of_type_Uym = new uym(new Bundle());
    this.jdField_a_of_type_Uym.a(false);
    this.jdField_a_of_type_Uym.a(a());
    localArrayList.add(this.jdField_a_of_type_Uya);
    localArrayList.add(this.jdField_a_of_type_Uym);
    return localArrayList;
  }
  
  public void b()
  {
    super.b();
  }
  
  public int c()
  {
    return 1;
  }
  
  public String c()
  {
    return i;
  }
  
  public String d()
  {
    return "follow_page";
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_Vud = ((vud)a(vud.class));
    this.jdField_a_of_type_Vud.a().observe(this, new vma(this));
    this.jdField_a_of_type_Vtz.c().observe(this, new vmb(this));
  }
  
  public void e()
  {
    super.e();
    n();
  }
  
  public void g()
  {
    QLog.d(i, 1, "customRefreshData");
    if (this.jdField_a_of_type_Vud != null)
    {
      QLog.d(i, 1, "mMessageNoticeViewModel pullLastestInfo");
      this.jdField_a_of_type_Vud.a(getActivity());
    }
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
  
  public void onDestroy()
  {
    uxx.c();
    uxx.b(getActivity());
    super.onDestroy();
    zwp.a().b(this);
    uxb.a = false;
  }
  
  public void onDetach()
  {
    QLog.d(i, 1, "QCircleFolderFollowTabFragment->onDetach");
    super.onDetach();
    vri.a().b(c());
  }
  
  public void onPause()
  {
    super.onPause();
    if (getUserVisibleHint()) {
      vri.a().d(c());
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    QCircleFeedEvent localQCircleFeedEvent;
    if ((paramSimpleBaseEvent instanceof QCircleFeedEvent))
    {
      localQCircleFeedEvent = (QCircleFeedEvent)paramSimpleBaseEvent;
      if (localQCircleFeedEvent.mState == 3) {
        if (this.jdField_a_of_type_Vtz != null) {
          this.jdField_a_of_type_Vtz.b(((QCircleFeedEvent)paramSimpleBaseEvent).mTargetId);
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
        } while (this.jdField_a_of_type_Vtz == null);
        this.jdField_a_of_type_Vtz.c().removeObservers(this);
        this.jdField_a_of_type_Vtz.c().postValue(null);
        return;
        if (!(paramSimpleBaseEvent instanceof QCircleLazyLoadTabEvent)) {
          break;
        }
        c();
      } while (this.jdField_b_of_type_Boolean);
      m();
      this.jdField_b_of_type_Boolean = true;
      return;
    } while ((!(paramSimpleBaseEvent instanceof QCircleFeedListRefreshEvent)) || (((QCircleFeedListRefreshEvent)paramSimpleBaseEvent).mPageType != 1));
    a(false);
  }
  
  public void onResume()
  {
    super.onResume();
    if (getUserVisibleHint()) {
      vri.a().c(c());
    }
    g();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    QLog.d(i, 1, "QCircleFolderFollowTabFragment->setUserVisibleHint:" + paramBoolean);
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      if (vri.a().d()) {
        vri.a().a(c(), getActivity().getIntent());
      }
      vri.a().a(c());
      vri.a().c(c());
      vrf.a("", 22, 1);
      vrr.a().a(new vrt().a("main").b("impression").a(a()));
      return;
    }
    vri.a().d(c());
    vri.a().b(c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.QCircleFolderFollowTabFragment
 * JD-Core Version:    0.7.0.1
 */