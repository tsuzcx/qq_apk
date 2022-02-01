package com.tencent.biz.qqcircle.widgets.feed;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.view.View;
import android.view.ViewStub;
import aniz;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleCommonAnimationEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedCommentEllipseEvent;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout;
import com.tencent.biz.qqcircle.widgets.childViewPresent.QCircleFeedItemPicPresenter;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.app.BaseActivity;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import uxo;
import uzb;
import vzh;
import vzl;
import vzq;
import vzw;
import vzx;
import wae;
import waj;
import wal;
import wao;
import wap;
import waq;
import zwp;
import zwr;

public class QCircleInsFeedItemView
  extends QCircleBaseWidgetView
  implements zwr
{
  int jdField_a_of_type_Int;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private aniz jdField_a_of_type_Aniz = new waq(this);
  private QCircleDoubleClickLayout jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoubleClickLayout;
  private QCircleFeedItemPicPresenter jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter;
  private Object jdField_a_of_type_JavaLangObject;
  private vzh jdField_a_of_type_Vzh;
  private vzl jdField_a_of_type_Vzl;
  private vzq jdField_a_of_type_Vzq;
  private vzw jdField_a_of_type_Vzw;
  private vzx jdField_a_of_type_Vzx;
  private wae jdField_a_of_type_Wae;
  private waj jdField_a_of_type_Waj;
  private wal jdField_a_of_type_Wal;
  private int b;
  
  public QCircleInsFeedItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleInsFeedItemView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public int a()
  {
    return 2131560698;
  }
  
  public String a()
  {
    return "QCircleInsFeedItemView";
  }
  
  public waj a()
  {
    return this.jdField_a_of_type_Waj;
  }
  
  public void a()
  {
    boolean bool = true;
    QCircleInitBean localQCircleInitBean;
    if ((a() != null) && (a().pageType != 69))
    {
      localQCircleInitBean = null;
      if (this.jdField_a_of_type_Waj == null) {
        break label66;
      }
      localQCircleInitBean = this.jdField_a_of_type_Waj.a();
      if (localQCircleInitBean != null) {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_feeddetail_recom  ", 1) != 0) {
          break label91;
        }
      }
    }
    for (;;)
    {
      localQCircleInitBean.isSingleFeed = bool;
      uxo.a(localQCircleInitBean);
      return;
      label66:
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter == null) {
        break;
      }
      localQCircleInitBean = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.c());
      break;
      label91:
      bool = false;
    }
  }
  
  public void a(Context paramContext, int paramInt)
  {
    super.a(paramContext, paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_Vzx = new vzx();
    this.jdField_a_of_type_Vzx.a((ViewStub)paramView.findViewById(2131373145));
    this.jdField_a_of_type_Vzx.a(this);
    this.jdField_a_of_type_Vzq = new vzq();
    this.jdField_a_of_type_Vzq.a((ViewStub)paramView.findViewById(2131373143));
    this.jdField_a_of_type_Vzq.a(this);
    this.jdField_a_of_type_Vzl = new vzl(paramContext);
    this.jdField_a_of_type_Vzl.a((ViewStub)paramView.findViewById(2131373141));
    this.jdField_a_of_type_Vzl.a(this);
    this.jdField_a_of_type_Vzh = new vzh();
    this.jdField_a_of_type_Vzh.a((ViewStub)paramView.findViewById(2131373139));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoubleClickLayout = ((QCircleDoubleClickLayout)paramView.findViewById(2131373142));
    if (this.jdField_a_of_type_Int == 3)
    {
      this.jdField_a_of_type_Waj = new waj();
      this.jdField_a_of_type_Waj.a((ViewStub)paramView.findViewById(2131373150));
    }
    if (this.jdField_a_of_type_Int == 2)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter = new QCircleFeedItemPicPresenter();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.a((ViewStub)paramView.findViewById(2131373146));
      this.jdField_a_of_type_Vzx.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter);
    }
    this.jdField_a_of_type_Vzw = new vzw();
    this.jdField_a_of_type_Vzw.a((ViewStub)paramView.findViewById(2131373144));
    this.jdField_a_of_type_Wal = new wal();
    this.jdField_a_of_type_Wal.a((ViewStub)paramView.findViewById(2131373149));
    this.jdField_a_of_type_Wae = new wae();
    this.jdField_a_of_type_Wae.a((ViewStub)paramView.findViewById(2131373816));
  }
  
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, int paramInt)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.b = paramInt;
    if (this.jdField_a_of_type_Vzx != null)
    {
      if ((a() instanceof uzb)) {
        this.jdField_a_of_type_Vzx.a((uzb)a());
      }
      this.jdField_a_of_type_Vzx.a(a());
      this.jdField_a_of_type_Vzx.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Vzq != null)
    {
      if ((a() instanceof uzb)) {
        this.jdField_a_of_type_Vzq.a((uzb)a());
      }
      this.jdField_a_of_type_Vzq.a(a());
      this.jdField_a_of_type_Vzq.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoubleClickLayout != null)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoubleClickLayout.a();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoubleClickLayout.setOnDoubleClickListener(new wao(this, paramObject));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoubleClickLayout.setOnLongClickListener(new wap(this));
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter != null)
    {
      if ((a() instanceof uzb)) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.a((uzb)a());
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.a(a());
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Waj != null)
    {
      if ((a() instanceof uzb)) {
        this.jdField_a_of_type_Waj.a((uzb)a());
      }
      this.jdField_a_of_type_Waj.a(a());
      this.jdField_a_of_type_Waj.a(paramObject, paramInt);
      this.jdField_a_of_type_Waj.a(getTag(), paramObject);
    }
    if (this.jdField_a_of_type_Vzl != null)
    {
      if ((a() instanceof uzb)) {
        this.jdField_a_of_type_Vzl.a((uzb)a());
      }
      this.jdField_a_of_type_Vzl.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
      this.jdField_a_of_type_Vzl.a(a());
      this.jdField_a_of_type_Vzl.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Vzh != null)
    {
      if ((a() instanceof uzb)) {
        this.jdField_a_of_type_Vzh.a((uzb)a());
      }
      this.jdField_a_of_type_Vzh.a(a());
      this.jdField_a_of_type_Vzh.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Wal != null)
    {
      if ((a() instanceof uzb)) {
        this.jdField_a_of_type_Wal.a((uzb)a());
      }
      this.jdField_a_of_type_Wal.a(a());
      this.jdField_a_of_type_Wal.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Vzw != null)
    {
      if ((a() instanceof uzb)) {
        this.jdField_a_of_type_Vzw.a((uzb)a());
      }
      this.jdField_a_of_type_Vzw.a(a());
      this.jdField_a_of_type_Vzw.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Wae != null)
    {
      if ((a() instanceof uzb)) {
        this.jdField_a_of_type_Wae.a((uzb)a());
      }
      this.jdField_a_of_type_Wae.a(a());
      this.jdField_a_of_type_Wae.a(paramObject, paramInt);
    }
  }
  
  public int b()
  {
    return this.b;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentUpdateEvent.class);
    localArrayList.add(QCirclePolyPraiseUpdateEvent.class);
    localArrayList.add(QCirclePushUpdateEvent.class);
    localArrayList.add(QCircleCommonAnimationEvent.class);
    localArrayList.add(QCircleFeedCommentEllipseEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    zwp.a().a(this);
    if ((getContext() instanceof BaseActivity)) {
      ((BaseActivity)getContext()).addObserver(this.jdField_a_of_type_Aniz);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    zwp.a().b(this);
    if ((getContext() instanceof BaseActivity)) {
      ((BaseActivity)getContext()).removeObserver(this.jdField_a_of_type_Aniz);
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.a();
    }
    if (this.jdField_a_of_type_Waj != null) {
      this.jdField_a_of_type_Waj.a();
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)))
    {
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject;
      if (!(paramSimpleBaseEvent instanceof QCircleCommentUpdateEvent)) {
        break label53;
      }
      paramSimpleBaseEvent = (QCircleCommentUpdateEvent)paramSimpleBaseEvent;
      if (this.jdField_a_of_type_Vzl != null) {
        this.jdField_a_of_type_Vzl.a(paramSimpleBaseEvent);
      }
    }
    label53:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!(paramSimpleBaseEvent instanceof QCirclePolyPraiseUpdateEvent)) {
              break;
            }
          } while (this.jdField_a_of_type_Vzl == null);
          this.jdField_a_of_type_Vzl.a((QCirclePolyPraiseUpdateEvent)paramSimpleBaseEvent);
          return;
          if (!(paramSimpleBaseEvent instanceof QCirclePushUpdateEvent)) {
            break;
          }
        } while (this.jdField_a_of_type_Vzl == null);
        this.jdField_a_of_type_Vzl.a((QCirclePushUpdateEvent)paramSimpleBaseEvent);
        return;
        if (!(paramSimpleBaseEvent instanceof QCircleCommonAnimationEvent)) {
          break;
        }
      } while (this.jdField_a_of_type_Vzl == null);
      this.jdField_a_of_type_Vzl.a((QCircleCommonAnimationEvent)paramSimpleBaseEvent);
      return;
    } while ((!(paramSimpleBaseEvent instanceof QCircleFeedCommentEllipseEvent)) || (this.jdField_a_of_type_Vzl == null));
    this.jdField_a_of_type_Vzl.a((QCircleFeedCommentEllipseEvent)paramSimpleBaseEvent);
  }
  
  public void setPicInitialItemPos(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.a(paramInt);
    }
  }
  
  public void setRecyclerView(RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    super.setReportBean(paramQCircleReportBean);
    this.jdField_a_of_type_Vzx.a(a());
    this.jdField_a_of_type_Vzq.a(a());
    this.jdField_a_of_type_Vzl.a(a());
    this.jdField_a_of_type_Vzh.a(a());
    if (this.jdField_a_of_type_Waj != null) {
      this.jdField_a_of_type_Waj.a(a());
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.a(a());
    }
    this.jdField_a_of_type_Vzw.a(a());
    this.jdField_a_of_type_Wal.a(a());
    this.jdField_a_of_type_Wae.a(a());
  }
  
  public void setShareRecyclerViewPool(RecyclerView.RecycledViewPool paramRecycledViewPool)
  {
    this.jdField_a_of_type_Vzl.a(paramRecycledViewPool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView
 * JD-Core Version:    0.7.0.1
 */