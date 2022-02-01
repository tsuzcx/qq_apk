package com.tencent.biz.qqcircle.fragments.main;

import aaak;
import aaam;
import aabd;
import aabp;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCircleLazyLoadTabEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.launchbean.QCircleFolderBean;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import uzt;
import uzw;
import voh;
import vtd;
import vtq;
import vtt;
import vud;
import vuf;
import vwy;
import vxq;

public class QCircleFolderRcmdTabFragment
  extends QCircleBaseTabFragment
  implements aaam
{
  public static String e = "QCircleFolderRcmdTabFragment";
  protected byte[] a;
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    label122:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Vwy != null) {
        this.jdField_a_of_type_Vwy.c(paramString);
      }
      if (this.jdField_a_of_type_Uzt != null)
      {
        ArrayList localArrayList = this.jdField_a_of_type_Uzt.getDataList();
        if (localArrayList != null)
        {
          int i = 0;
          int j = localArrayList.size();
          if (i < j) {
            if (!paramString.equals(((FeedCloudMeta.StFeed)localArrayList.get(i)).id.get())) {}
          }
          for (;;)
          {
            if (i < 0) {
              break label122;
            }
            try
            {
              this.jdField_a_of_type_Uzt.delete(i);
              this.jdField_a_of_type_Uzt.notifyItemRemoved(i);
              return;
            }
            catch (Throwable paramString)
            {
              QLog.e(e, 1, "onReceiveEvent() delete local feed error!", paramString);
              return;
            }
            i += 1;
            break;
            i = -1;
          }
        }
      }
    }
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Vwy != null) {
        this.jdField_a_of_type_Vwy.c(paramString);
      }
      if (this.jdField_a_of_type_Uzt != null)
      {
        ArrayList localArrayList = this.jdField_a_of_type_Uzt.getDataList();
        if (localArrayList != null)
        {
          int i = localArrayList.size() - 1;
          while (i >= 0)
          {
            if (paramString.equals(((FeedCloudMeta.StFeed)localArrayList.get(i)).poster.id.get())) {
              try
              {
                this.jdField_a_of_type_Uzt.delete(i);
                this.jdField_a_of_type_Uzt.notifyItemRemoved(i);
                return;
              }
              catch (Throwable paramString)
              {
                QLog.e(e, 1, "onReceiveEvent() delete local feed error!", paramString);
                return;
              }
            }
            i -= 1;
          }
        }
      }
    }
  }
  
  private void n()
  {
    if (!getUserVisibleHint()) {
      return;
    }
    QLog.d("QCircleEeveeRedPoint_" + e, 1, "[clearLocalOuterEntranceRedPoint");
    ThreadManager.getSubThreadHandler().post(new QCircleFolderRcmdTabFragment.2(this));
  }
  
  private void o()
  {
    if (!getUserVisibleHint()) {
      return;
    }
    QLog.d("QCircleEeveeRedPoint_" + e, 1, "sendOuterEntranceRedPointRequest");
    ThreadManager.getSubThreadHandler().post(new QCircleFolderRcmdTabFragment.3(this));
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Aabd.a().a().addOnScrollListener(new voh(this));
    aaak.a().a(this);
  }
  
  public void a(vxq<List<FeedCloudMeta.StFeed>> paramvxq)
  {
    super.a(paramvxq);
    if ((paramvxq != null) && (!paramvxq.b()))
    {
      QLog.d("QCircleEeveeRedPoint_" + e, 1, "handleFeedDataRsp is refresh clearLocalOuterEntranceRedPoint");
      n();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vwy != null)
    {
      if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length <= 0)) {
        break label49;
      }
      this.jdField_a_of_type_Vwy.a(vtt.a("allpush_reddot", this.jdField_a_of_type_ArrayOfByte));
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfByte = null;
      super.a(paramBoolean);
      return;
      label49:
      this.jdField_a_of_type_Vwy.b("allpush_reddot");
    }
  }
  
  public String b()
  {
    return jdField_c_of_type_JavaLangString;
  }
  
  public List<aabp> b()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Uzw = new uzw(new Bundle());
    this.jdField_a_of_type_Uzw.a(false);
    this.jdField_a_of_type_Uzw.a(a());
    localArrayList.add(this.jdField_a_of_type_Uzw);
    return localArrayList;
  }
  
  public void b()
  {
    super.b();
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Uzt != null) && (this.jdField_a_of_type_Uzt.getItemCount() > 0);
  }
  
  public int c()
  {
    return 3;
  }
  
  public String c()
  {
    return e;
  }
  
  public String d()
  {
    return "explore_page";
  }
  
  public void e()
  {
    super.e();
    n();
    o();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    localArrayList.add(QCircleLazyLoadTabEvent.class);
    return localArrayList;
  }
  
  public void m()
  {
    boolean bool2 = true;
    label79:
    int i;
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      QCircleFolderBean localQCircleFolderBean = (QCircleFolderBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      if ((localQCircleFolderBean.getQQCircleUnreadRedNum() <= 0) || (!c())) {
        break label168;
      }
      bool1 = true;
      this.jdField_c_of_type_Boolean = bool1;
      if (this.jdField_c_of_type_Boolean)
      {
        if (localQCircleFolderBean.getQQCircleUnreadRedNum() <= vtd.a()) {
          break label173;
        }
        bool1 = true;
        this.d = bool1;
      }
      this.jdField_a_of_type_ArrayOfByte = localQCircleFolderBean.getRedDotTransInfo();
      if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length <= 0)) {
        break label178;
      }
      i = 1;
      label110:
      this.f = localQCircleFolderBean.hasRedDotShownOnEntrance();
      if ((this.d) || (i != 0)) {
        break label183;
      }
    }
    label168:
    label173:
    label178:
    label183:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.b = bool1;
      QLog.d(e, 4, "enableMemCache:" + this.b);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label79;
      i = 0;
      break label110;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    aaak.a().b(this);
  }
  
  public void onDetach()
  {
    QLog.d(e, 1, "QCircleFolderRcmdTabFragment->onDetach");
    super.onDetach();
    vtt.a().b(c());
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFeedEvent)) && (((QCircleFeedEvent)paramSimpleBaseEvent).mState == 3))
    {
      localQCircleFeedEvent = (QCircleFeedEvent)paramSimpleBaseEvent;
      if (localQCircleFeedEvent.mState == 3) {
        a(((QCircleFeedEvent)paramSimpleBaseEvent).mTargetId);
      }
    }
    while (!(paramSimpleBaseEvent instanceof QCircleLazyLoadTabEvent))
    {
      QCircleFeedEvent localQCircleFeedEvent;
      do
      {
        return;
      } while (localQCircleFeedEvent.mState != 6);
      b(((QCircleFeedEvent)paramSimpleBaseEvent).mTargetId);
      return;
    }
    c();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    QLog.d(e, 1, "QCircleFolderRcmdTabFragment->setUserVisibleHint:" + paramBoolean);
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      vtt.a().a(c());
      vtt.a().c(c());
      vtq.a("", 23, 1);
      vud.a().a(new vuf().a("main").b("impression").a(a()));
      return;
    }
    vtt.a().d(c());
    vtt.a().b(c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.QCircleFolderRcmdTabFragment
 * JD-Core Version:    0.7.0.1
 */