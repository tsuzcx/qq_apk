package com.tencent.biz.qqcircle.widgets;

import alpq;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleCommonAnimationEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedCommentEllipseEvent;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.widgets.childViewPresent.QCircleFeedItemPicPresent;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.mobileqq.app.BaseActivity;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import trw;
import udm;
import udn;
import ugc;
import uge;
import ugj;
import ugk;
import ugl;
import ugp;
import ugu;
import ugv;
import yiw;
import yiy;

public class QCircleFeedWidget
  extends BaseWidgetView
  implements yiy
{
  int jdField_a_of_type_Int;
  private alpq jdField_a_of_type_Alpq = new udn(this);
  private QCircleDoubleClickLayout jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoubleClickLayout;
  private QCircleFeedItemPicPresent jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent;
  private Object jdField_a_of_type_JavaLangObject;
  private ugc jdField_a_of_type_Ugc;
  private uge jdField_a_of_type_Uge;
  private ugj jdField_a_of_type_Ugj;
  private ugk jdField_a_of_type_Ugk;
  private ugl jdField_a_of_type_Ugl;
  private ugp jdField_a_of_type_Ugp;
  private ugu jdField_a_of_type_Ugu;
  private ugv jdField_a_of_type_Ugv;
  private int b;
  
  public QCircleFeedWidget(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleFeedWidget(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public int a()
  {
    return 2131560540;
  }
  
  public ugu a()
  {
    return this.jdField_a_of_type_Ugu;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_Ugl = new ugl();
    this.jdField_a_of_type_Ugl.a((ViewStub)paramView.findViewById(2131372534));
    this.jdField_a_of_type_Ugj = new ugj();
    this.jdField_a_of_type_Ugj.a((ViewStub)paramView.findViewById(2131372532));
    this.jdField_a_of_type_Uge = new uge(paramContext);
    this.jdField_a_of_type_Uge.a((ViewStub)paramView.findViewById(2131372530));
    this.jdField_a_of_type_Ugc = new ugc();
    this.jdField_a_of_type_Ugc.a((ViewStub)paramView.findViewById(2131372528));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoubleClickLayout = ((QCircleDoubleClickLayout)paramView.findViewById(2131372531));
    if (this.jdField_a_of_type_Int == 3)
    {
      this.jdField_a_of_type_Ugu = new ugu();
      this.jdField_a_of_type_Ugu.a((ViewStub)paramView.findViewById(2131372539));
    }
    if (this.jdField_a_of_type_Int == 2)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent = new QCircleFeedItemPicPresent();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent.a((ViewStub)paramView.findViewById(2131372535));
    }
    this.jdField_a_of_type_Ugk = new ugk();
    this.jdField_a_of_type_Ugk.a((ViewStub)paramView.findViewById(2131372533));
    this.jdField_a_of_type_Ugv = new ugv();
    this.jdField_a_of_type_Ugv.a((ViewStub)paramView.findViewById(2131372538));
    this.jdField_a_of_type_Ugp = new ugp();
    this.jdField_a_of_type_Ugp.a((ViewStub)paramView.findViewById(2131373179));
  }
  
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, int paramInt)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.b = paramInt;
    if (this.jdField_a_of_type_Ugl != null)
    {
      if ((a() instanceof trw)) {
        this.jdField_a_of_type_Ugl.a((trw)a());
      }
      this.jdField_a_of_type_Ugl.a(a());
      this.jdField_a_of_type_Ugl.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Ugj != null)
    {
      if ((a() instanceof trw)) {
        this.jdField_a_of_type_Ugj.a((trw)a());
      }
      this.jdField_a_of_type_Ugj.a(a());
      this.jdField_a_of_type_Ugj.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoubleClickLayout != null)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoubleClickLayout.a();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoubleClickLayout.setOnDoubleClickListener(new udm(this, paramObject));
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent != null)
    {
      if ((a() instanceof trw)) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent.a((trw)a());
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent.a(a());
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Ugu != null)
    {
      if ((a() instanceof trw)) {
        this.jdField_a_of_type_Ugu.a((trw)a());
      }
      this.jdField_a_of_type_Ugu.a(a());
      this.jdField_a_of_type_Ugu.a(paramObject, paramInt);
      this.jdField_a_of_type_Ugu.a(getTag(), paramObject);
    }
    if (this.jdField_a_of_type_Uge != null)
    {
      if ((a() instanceof trw)) {
        this.jdField_a_of_type_Uge.a((trw)a());
      }
      this.jdField_a_of_type_Uge.a(a());
      this.jdField_a_of_type_Uge.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Ugc != null)
    {
      if ((a() instanceof trw)) {
        this.jdField_a_of_type_Ugc.a((trw)a());
      }
      this.jdField_a_of_type_Ugc.a(a());
      this.jdField_a_of_type_Ugc.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Ugv != null)
    {
      if ((a() instanceof trw)) {
        this.jdField_a_of_type_Ugv.a((trw)a());
      }
      this.jdField_a_of_type_Ugv.a(a());
      this.jdField_a_of_type_Ugv.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Ugk != null)
    {
      if ((a() instanceof trw)) {
        this.jdField_a_of_type_Ugk.a((trw)a());
      }
      this.jdField_a_of_type_Ugk.a(a());
      this.jdField_a_of_type_Ugk.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Ugp != null)
    {
      if ((a() instanceof trw)) {
        this.jdField_a_of_type_Ugp.a((trw)a());
      }
      this.jdField_a_of_type_Ugp.a(a());
      this.jdField_a_of_type_Ugp.a(paramObject, paramInt);
    }
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(Context paramContext, int paramInt)
  {
    super.b(paramContext, paramInt);
    this.jdField_a_of_type_Int = paramInt;
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
    yiw.a().a(this);
    if ((getContext() instanceof BaseActivity)) {
      ((BaseActivity)getContext()).addObserver(this.jdField_a_of_type_Alpq);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    yiw.a().b(this);
    if ((getContext() instanceof BaseActivity)) {
      ((BaseActivity)getContext()).removeObserver(this.jdField_a_of_type_Alpq);
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent.a();
    }
    if (this.jdField_a_of_type_Ugu != null) {
      this.jdField_a_of_type_Ugu.a();
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
      if (this.jdField_a_of_type_Uge != null) {
        this.jdField_a_of_type_Uge.a(paramSimpleBaseEvent);
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
          } while (this.jdField_a_of_type_Uge == null);
          this.jdField_a_of_type_Uge.a((QCirclePolyPraiseUpdateEvent)paramSimpleBaseEvent);
          return;
          if (!(paramSimpleBaseEvent instanceof QCirclePushUpdateEvent)) {
            break;
          }
        } while (this.jdField_a_of_type_Uge == null);
        this.jdField_a_of_type_Uge.a((QCirclePushUpdateEvent)paramSimpleBaseEvent);
        return;
        if (!(paramSimpleBaseEvent instanceof QCircleCommonAnimationEvent)) {
          break;
        }
      } while (this.jdField_a_of_type_Uge == null);
      this.jdField_a_of_type_Uge.a((QCircleCommonAnimationEvent)paramSimpleBaseEvent);
      return;
    } while ((!(paramSimpleBaseEvent instanceof QCircleFeedCommentEllipseEvent)) || (this.jdField_a_of_type_Uge == null));
    this.jdField_a_of_type_Uge.a((QCircleFeedCommentEllipseEvent)paramSimpleBaseEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedWidget
 * JD-Core Version:    0.7.0.1
 */