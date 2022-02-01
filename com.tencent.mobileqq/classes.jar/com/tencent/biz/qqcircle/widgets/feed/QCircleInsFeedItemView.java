package com.tencent.biz.qqcircle.widgets.feed;

import aaak;
import aaam;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.view.View;
import android.view.ViewStub;
import anuw;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleCommonAnimationEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedCommentEllipseEvent;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.launchbean.QCircleLayerBean;
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
import uyx;
import var;
import wcx;
import wdb;
import wdg;
import wdm;
import wdn;
import wdu;
import wdz;
import web;
import wee;
import wef;
import weg;

public class QCircleInsFeedItemView
  extends QCircleBaseWidgetView
  implements aaam
{
  int jdField_a_of_type_Int;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private anuw jdField_a_of_type_Anuw = new weg(this);
  private QCircleDoubleClickLayout jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoubleClickLayout;
  private QCircleFeedItemPicPresenter jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter;
  private Object jdField_a_of_type_JavaLangObject;
  private wcx jdField_a_of_type_Wcx;
  private wdb jdField_a_of_type_Wdb;
  private wdg jdField_a_of_type_Wdg;
  private wdm jdField_a_of_type_Wdm;
  private wdn jdField_a_of_type_Wdn;
  private wdu jdField_a_of_type_Wdu;
  private wdz jdField_a_of_type_Wdz;
  private web jdField_a_of_type_Web;
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
    return 2131560715;
  }
  
  public String a()
  {
    return "QCircleInsFeedItemView";
  }
  
  public wdz a()
  {
    return this.jdField_a_of_type_Wdz;
  }
  
  public void a()
  {
    boolean bool = true;
    QCircleLayerBean localQCircleLayerBean;
    if ((a() != null) && (a().pageType != 69))
    {
      localQCircleLayerBean = null;
      if (this.jdField_a_of_type_Wdz == null) {
        break label70;
      }
      localQCircleLayerBean = this.jdField_a_of_type_Wdz.a();
      if (localQCircleLayerBean != null) {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_feeddetail_recom  ", 1) != 0) {
          break label95;
        }
      }
    }
    for (;;)
    {
      localQCircleLayerBean.setSingleFeed(bool);
      uyx.a(getContext(), localQCircleLayerBean);
      return;
      label70:
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter == null) {
        break;
      }
      localQCircleLayerBean = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.c());
      break;
      label95:
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
    this.jdField_a_of_type_Wdn = new wdn();
    this.jdField_a_of_type_Wdn.a((ViewStub)paramView.findViewById(2131373258));
    this.jdField_a_of_type_Wdn.a(this);
    this.jdField_a_of_type_Wdg = new wdg();
    this.jdField_a_of_type_Wdg.a((ViewStub)paramView.findViewById(2131373256));
    this.jdField_a_of_type_Wdg.a(this);
    this.jdField_a_of_type_Wdb = new wdb(paramContext);
    this.jdField_a_of_type_Wdb.a((ViewStub)paramView.findViewById(2131373254));
    this.jdField_a_of_type_Wdb.a(this);
    this.jdField_a_of_type_Wcx = new wcx();
    this.jdField_a_of_type_Wcx.a((ViewStub)paramView.findViewById(2131373252));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoubleClickLayout = ((QCircleDoubleClickLayout)paramView.findViewById(2131373255));
    if (this.jdField_a_of_type_Int == 3)
    {
      this.jdField_a_of_type_Wdz = new wdz();
      this.jdField_a_of_type_Wdz.a((ViewStub)paramView.findViewById(2131373263));
    }
    if (this.jdField_a_of_type_Int == 2)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter = new QCircleFeedItemPicPresenter();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.a((ViewStub)paramView.findViewById(2131373259));
      this.jdField_a_of_type_Wdn.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter);
    }
    this.jdField_a_of_type_Wdm = new wdm();
    this.jdField_a_of_type_Wdm.a((ViewStub)paramView.findViewById(2131373257));
    this.jdField_a_of_type_Web = new web();
    this.jdField_a_of_type_Web.a((ViewStub)paramView.findViewById(2131373262));
    this.jdField_a_of_type_Wdu = new wdu();
    this.jdField_a_of_type_Wdu.a((ViewStub)paramView.findViewById(2131373946));
  }
  
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, int paramInt)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.b = paramInt;
    if (this.jdField_a_of_type_Wdn != null)
    {
      if ((a() instanceof var)) {
        this.jdField_a_of_type_Wdn.a((var)a());
      }
      this.jdField_a_of_type_Wdn.a(a());
      this.jdField_a_of_type_Wdn.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Wdg != null)
    {
      if ((a() instanceof var)) {
        this.jdField_a_of_type_Wdg.a((var)a());
      }
      this.jdField_a_of_type_Wdg.a(a());
      this.jdField_a_of_type_Wdg.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoubleClickLayout != null)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoubleClickLayout.a();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoubleClickLayout.setOnDoubleClickListener(new wee(this, paramObject));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoubleClickLayout.setOnLongClickListener(new wef(this));
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter != null)
    {
      if ((a() instanceof var)) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.a((var)a());
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.a(a());
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Wdz != null)
    {
      if ((a() instanceof var)) {
        this.jdField_a_of_type_Wdz.a((var)a());
      }
      this.jdField_a_of_type_Wdz.a(a());
      this.jdField_a_of_type_Wdz.a(paramObject, paramInt);
      this.jdField_a_of_type_Wdz.a(getTag(), paramObject);
    }
    if (this.jdField_a_of_type_Wdb != null)
    {
      if ((a() instanceof var)) {
        this.jdField_a_of_type_Wdb.a((var)a());
      }
      this.jdField_a_of_type_Wdb.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
      this.jdField_a_of_type_Wdb.a(a());
      this.jdField_a_of_type_Wdb.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Wcx != null)
    {
      if ((a() instanceof var)) {
        this.jdField_a_of_type_Wcx.a((var)a());
      }
      this.jdField_a_of_type_Wcx.a(a());
      this.jdField_a_of_type_Wcx.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Web != null)
    {
      if ((a() instanceof var)) {
        this.jdField_a_of_type_Web.a((var)a());
      }
      this.jdField_a_of_type_Web.a(a());
      this.jdField_a_of_type_Web.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Wdm != null)
    {
      if ((a() instanceof var)) {
        this.jdField_a_of_type_Wdm.a((var)a());
      }
      this.jdField_a_of_type_Wdm.a(a());
      this.jdField_a_of_type_Wdm.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Wdu != null)
    {
      if ((a() instanceof var)) {
        this.jdField_a_of_type_Wdu.a((var)a());
      }
      this.jdField_a_of_type_Wdu.a(a());
      this.jdField_a_of_type_Wdu.a(paramObject, paramInt);
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
    aaak.a().a(this);
    if ((getContext() instanceof BaseActivity)) {
      ((BaseActivity)getContext()).addObserver(this.jdField_a_of_type_Anuw);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    aaak.a().b(this);
    if ((getContext() instanceof BaseActivity)) {
      ((BaseActivity)getContext()).removeObserver(this.jdField_a_of_type_Anuw);
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.a();
    }
    if (this.jdField_a_of_type_Wdz != null) {
      this.jdField_a_of_type_Wdz.a();
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
      if (this.jdField_a_of_type_Wdb != null) {
        this.jdField_a_of_type_Wdb.a(paramSimpleBaseEvent);
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
          } while (this.jdField_a_of_type_Wdb == null);
          this.jdField_a_of_type_Wdb.a((QCirclePolyPraiseUpdateEvent)paramSimpleBaseEvent);
          return;
          if (!(paramSimpleBaseEvent instanceof QCirclePushUpdateEvent)) {
            break;
          }
        } while (this.jdField_a_of_type_Wdb == null);
        this.jdField_a_of_type_Wdb.a((QCirclePushUpdateEvent)paramSimpleBaseEvent);
        return;
        if (!(paramSimpleBaseEvent instanceof QCircleCommonAnimationEvent)) {
          break;
        }
      } while (this.jdField_a_of_type_Wdb == null);
      this.jdField_a_of_type_Wdb.a((QCircleCommonAnimationEvent)paramSimpleBaseEvent);
      return;
    } while ((!(paramSimpleBaseEvent instanceof QCircleFeedCommentEllipseEvent)) || (this.jdField_a_of_type_Wdb == null));
    this.jdField_a_of_type_Wdb.a((QCircleFeedCommentEllipseEvent)paramSimpleBaseEvent);
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
    this.jdField_a_of_type_Wdn.a(a());
    this.jdField_a_of_type_Wdg.a(a());
    this.jdField_a_of_type_Wdb.a(a());
    this.jdField_a_of_type_Wcx.a(a());
    if (this.jdField_a_of_type_Wdz != null) {
      this.jdField_a_of_type_Wdz.a(a());
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.a(a());
    }
    this.jdField_a_of_type_Wdm.a(a());
    this.jdField_a_of_type_Web.a(a());
    this.jdField_a_of_type_Wdu.a(a());
  }
  
  public void setShareRecyclerViewPool(RecyclerView.RecycledViewPool paramRecycledViewPool)
  {
    this.jdField_a_of_type_Wdb.a(paramRecycledViewPool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView
 * JD-Core Version:    0.7.0.1
 */