package com.tencent.biz.qqcircle.widgets.childViewPresent;

import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedPicPositionEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;
import uxc;
import uxk;
import uxx;
import uzb;
import vrg;
import vri;
import vse;
import vzg;
import vzz;
import zwp;
import zwr;

public class QCircleFeedItemPicPresenter
  extends vzg
  implements zwr
{
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleBaseFragment jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBaseFragment;
  private QCircleFeedItemPicPresenter.MultiPicAdapter jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter$MultiPicAdapter;
  private boolean jdField_a_of_type_Boolean;
  private int b = ImmersiveUtils.a();
  private int c;
  private int d;
  private int e;
  
  private void a(FeedCloudMeta.StImage paramStImage)
  {
    if ((paramStImage.width.get() != 0) && (paramStImage.height.get() != 0))
    {
      this.c = ((int)(Math.max(Math.min(paramStImage.height.get() / paramStImage.width.get(), 1.333333F), 0.5625F) * this.b));
      b();
    }
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0)) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      }
    }
    while (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) && (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getLayoutParams() != null))
    {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getLayoutParams().height = this.c;
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.requestLayout();
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter$MultiPicAdapter != null)
    {
      int i = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter$MultiPicAdapter.a();
      if (i > 1) {
        a(paramInt % i + 1 + "/" + i);
      }
    }
    else
    {
      return;
    }
    a("");
  }
  
  private void c(int paramInt)
  {
    if (!(this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)) {
      return;
    }
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject;
    int[] arrayOfInt = vse.a(localStFeed);
    String str;
    ArrayList localArrayList;
    if (localStFeed.images.size() > paramInt)
    {
      str = ((FeedCloudMeta.StImage)localStFeed.images.get(paramInt)).picId.get() + "";
      localArrayList = new ArrayList();
      localArrayList.add(vri.a("ext1", "1"));
      if (paramInt >= this.d) {
        break label195;
      }
      localArrayList.add(vri.a("ext2", "1"));
    }
    for (;;)
    {
      localArrayList.add(vri.a("ext3", localStFeed.images.size() + ""));
      vrg.a(2, 1, arrayOfInt[0], arrayOfInt[1], localStFeed, 1, this.jdField_a_of_type_Int, str, localArrayList, b());
      this.d = paramInt;
      return;
      str = "";
      break;
      label195:
      if (paramInt > this.d) {
        localArrayList.add(vri.a("ext2", "2"));
      }
    }
  }
  
  public QCircleInitBean a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (!c()) && (this.jdField_a_of_type_Uzb != null))
    {
      QQCircleFeedBase.StFeedListBusiReqData localStFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
      localStFeedListBusiReqData.tabAttachInfo.set(this.jdField_a_of_type_Uzb.a());
      Object localObject = this.jdField_a_of_type_Uzb.a();
      if (localObject != null)
      {
        localStFeedListBusiReqData.tagId.set(((QCircleInitBean)localObject).getTagInfo().tagId.get());
        localStFeedListBusiReqData.tagName.set(((QCircleInitBean)localObject).getTagInfo().tagName.get());
      }
      localObject = new uxk();
      ((uxk)localObject).a((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
      ((uxk)localObject).a(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType);
      ((uxk)localObject).a(localStFeedListBusiReqData);
      ((uxk)localObject).b(paramInt);
      ((uxk)localObject).a(a().clone().setElementIdStr("content"));
      return ((uxk)localObject).a();
    }
    return null;
  }
  
  public String a()
  {
    return "QCircleFeedItemPicPresent";
  }
  
  public void a()
  {
    zwp.a().b(this);
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(paramInt);
    b(paramInt);
  }
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373890));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373891));
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131373857));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter$MultiPicAdapter = new QCircleFeedItemPicPresenter.MultiPicAdapter(this);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter$MultiPicAdapter);
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBaseFragment = uxx.a(this.jdField_a_of_type_AndroidViewView.getContext());
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new vzz(this));
    }
  }
  
  public void a(Object paramObject, int paramInt)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Int = paramInt;
    FeedCloudMeta.StFeed localStFeed1;
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mFeed = ((FeedCloudMeta.StFeed)paramObject);
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mPlayScene = 1;
      localStFeed1 = (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject;
      FeedCloudMeta.StFeed localStFeed2 = uxc.a(localStFeed1.id.get());
      paramObject = localStFeed1.images.get();
      if (localStFeed2 == null) {
        break label207;
      }
      paramObject = localStFeed2.images.get();
    }
    label181:
    label207:
    for (;;)
    {
      if (paramObject.size() > 0)
      {
        a((FeedCloudMeta.StImage)paramObject.get(0));
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter$MultiPicAdapter.a(paramObject);
        if (!this.jdField_a_of_type_Boolean) {
          break label181;
        }
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(this.e);
        b(this.e);
      }
      while (localStFeed1.images.get().size() > 1)
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        return;
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0);
        b(0);
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      return;
    }
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
      return this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem();
    }
    return 0;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedPicPositionEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFeedPicPositionEvent)) && (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) && ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)) && (((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).id.get().equals(((QCircleFeedPicPositionEvent)paramSimpleBaseEvent).mFeedId)) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter$MultiPicAdapter != null) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter$MultiPicAdapter.getCount() > ((QCircleFeedPicPositionEvent)paramSimpleBaseEvent).mPicPosition) && (a() != null) && (a().getContext().hashCode() != paramSimpleBaseEvent.mHashCode))
    {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(((QCircleFeedPicPositionEvent)paramSimpleBaseEvent).mPicPosition);
      this.e = ((QCircleFeedPicPositionEvent)paramSimpleBaseEvent).mPicPosition;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childViewPresent.QCircleFeedItemPicPresenter
 * JD-Core Version:    0.7.0.1
 */