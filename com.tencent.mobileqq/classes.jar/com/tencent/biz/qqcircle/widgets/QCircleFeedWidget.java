package com.tencent.biz.qqcircle.widgets;

import allb;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleCommonAnimationEvent;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.widgets.childViewPresent.QCircleFeedItemPicPresent;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.mobileqq.app.BaseActivity;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import trr;
import uay;
import udd;
import udf;
import udk;
import udl;
import udp;
import udu;
import udv;
import yej;
import yel;

public class QCircleFeedWidget
  extends BaseWidgetView
  implements yel
{
  int jdField_a_of_type_Int;
  private allb jdField_a_of_type_Allb = new uay(this);
  private QCircleFeedItemPicPresent jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent;
  private Object jdField_a_of_type_JavaLangObject;
  private udd jdField_a_of_type_Udd;
  private udf jdField_a_of_type_Udf;
  private udk jdField_a_of_type_Udk;
  private udl jdField_a_of_type_Udl;
  private udp jdField_a_of_type_Udp;
  private udu jdField_a_of_type_Udu;
  private udv jdField_a_of_type_Udv;
  private int c;
  
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
    return 2131560538;
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentUpdateEvent.class);
    localArrayList.add(QCirclePolyPraiseUpdateEvent.class);
    localArrayList.add(QCirclePushUpdateEvent.class);
    localArrayList.add(QCircleCommonAnimationEvent.class);
    return localArrayList;
  }
  
  public udu a()
  {
    return this.jdField_a_of_type_Udu;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_Udl = new udl();
    this.jdField_a_of_type_Udl.a((ViewStub)paramView.findViewById(2131372512));
    this.jdField_a_of_type_Udk = new udk();
    this.jdField_a_of_type_Udk.a((ViewStub)paramView.findViewById(2131372511));
    this.jdField_a_of_type_Udf = new udf(paramContext);
    this.jdField_a_of_type_Udf.a((ViewStub)paramView.findViewById(2131372509));
    this.jdField_a_of_type_Udd = new udd();
    this.jdField_a_of_type_Udd.a((ViewStub)paramView.findViewById(2131372507));
    if (this.jdField_a_of_type_Int == 3)
    {
      this.jdField_a_of_type_Udu = new udu();
      this.jdField_a_of_type_Udu.a((ViewStub)paramView.findViewById(2131372517));
    }
    if (this.jdField_a_of_type_Int == 2)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent = new QCircleFeedItemPicPresent();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent.a((ViewStub)paramView.findViewById(2131372513));
    }
    this.jdField_a_of_type_Udv = new udv();
    this.jdField_a_of_type_Udv.a((ViewStub)paramView.findViewById(2131372516));
    this.jdField_a_of_type_Udp = new udp();
    this.jdField_a_of_type_Udp.a((ViewStub)paramView.findViewById(2131373150));
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)))
    {
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject;
      if (!(paramSimpleBaseEvent instanceof QCircleCommentUpdateEvent)) {
        break label53;
      }
      paramSimpleBaseEvent = (QCircleCommentUpdateEvent)paramSimpleBaseEvent;
      if (this.jdField_a_of_type_Udf != null) {
        this.jdField_a_of_type_Udf.a(paramSimpleBaseEvent);
      }
    }
    label53:
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
        } while (this.jdField_a_of_type_Udf == null);
        this.jdField_a_of_type_Udf.a((QCirclePolyPraiseUpdateEvent)paramSimpleBaseEvent);
        return;
        if (!(paramSimpleBaseEvent instanceof QCirclePushUpdateEvent)) {
          break;
        }
      } while (this.jdField_a_of_type_Udf == null);
      this.jdField_a_of_type_Udf.a((QCirclePushUpdateEvent)paramSimpleBaseEvent);
      return;
    } while ((!(paramSimpleBaseEvent instanceof QCircleCommonAnimationEvent)) || (this.jdField_a_of_type_Udf == null));
    this.jdField_a_of_type_Udf.a((QCircleCommonAnimationEvent)paramSimpleBaseEvent);
  }
  
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, int paramInt)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.c = paramInt;
    if (this.jdField_a_of_type_Udl != null)
    {
      if ((a() instanceof trr)) {
        this.jdField_a_of_type_Udl.a((trr)a());
      }
      this.jdField_a_of_type_Udl.a(a());
      this.jdField_a_of_type_Udl.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Udk != null)
    {
      if ((a() instanceof trr)) {
        this.jdField_a_of_type_Udk.a((trr)a());
      }
      this.jdField_a_of_type_Udk.a(a());
      this.jdField_a_of_type_Udk.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent != null)
    {
      if ((a() instanceof trr)) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent.a((trr)a());
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent.a(a());
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Udu != null)
    {
      if ((a() instanceof trr)) {
        this.jdField_a_of_type_Udu.a((trr)a());
      }
      this.jdField_a_of_type_Udu.a(a());
      this.jdField_a_of_type_Udu.a(paramObject, paramInt);
      this.jdField_a_of_type_Udu.a(getTag(), paramObject);
    }
    if (this.jdField_a_of_type_Udf != null)
    {
      if ((a() instanceof trr)) {
        this.jdField_a_of_type_Udf.a((trr)a());
      }
      this.jdField_a_of_type_Udf.a(a());
      this.jdField_a_of_type_Udf.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Udd != null)
    {
      if ((a() instanceof trr)) {
        this.jdField_a_of_type_Udd.a((trr)a());
      }
      this.jdField_a_of_type_Udd.a(a());
      this.jdField_a_of_type_Udd.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Udv != null)
    {
      if ((a() instanceof trr)) {
        this.jdField_a_of_type_Udv.a((trr)a());
      }
      this.jdField_a_of_type_Udv.a(a());
      this.jdField_a_of_type_Udv.a(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Udp != null)
    {
      if ((a() instanceof trr)) {
        this.jdField_a_of_type_Udp.a((trr)a());
      }
      this.jdField_a_of_type_Udp.a(a());
      this.jdField_a_of_type_Udp.a(paramObject, paramInt);
    }
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(Context paramContext, int paramInt)
  {
    super.b(paramContext, paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    yej.a().a(this);
    if ((getContext() instanceof BaseActivity)) {
      ((BaseActivity)getContext()).addObserver(this.jdField_a_of_type_Allb);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    yej.a().b(this);
    if ((getContext() instanceof BaseActivity)) {
      ((BaseActivity)getContext()).removeObserver(this.jdField_a_of_type_Allb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedWidget
 * JD-Core Version:    0.7.0.1
 */