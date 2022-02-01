package com.tencent.biz.qqcircle.widgets.childViewPresent;

import aaak;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import bhtq;
import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.widgets.QCirclePaiTongKuanIconView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StImageBusiData;
import qqcircle.QQCircleFeedBase.StSimulateData;
import vrd;
import vtn;
import vwk;
import wdq;
import wdr;
import wds;
import wdt;

public class QCircleFeedItemPicPresenter$MultiPicAdapter
  extends PagerAdapter
{
  private final ArrayList<FeedCloudMeta.StImage> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final LinkedList<View> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  public QCircleFeedItemPicPresenter$MultiPicAdapter(QCircleFeedItemPicPresenter paramQCircleFeedItemPicPresenter) {}
  
  private View a(wdt paramwdt, FeedCloudMeta.StImage paramStImage, int paramInt)
  {
    String str = paramStImage.picUrl.get();
    URLImageView localURLImageView = paramwdt.jdField_a_of_type_ComTencentImageURLImageView;
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130846618);
    localURLDrawableOptions.mFailedDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130844021);
    Object localObject;
    if (QCircleFeedItemPicPresenter.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter) != 0) {
      if ((paramStImage.width.get() != 0) && (paramStImage.height.get() != 0))
      {
        localObject = vwk.a((FeedCloudMeta.StFeed)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.jdField_a_of_type_JavaLangObject, paramStImage.width.get(), paramStImage.height.get());
        ViewGroup.LayoutParams localLayoutParams = localURLImageView.getLayoutParams();
        localLayoutParams.width = ((Integer)((Pair)localObject).first).intValue();
        localLayoutParams.height = ((Integer)((Pair)localObject).second).intValue();
        localURLDrawableOptions.mRequestWidth = localLayoutParams.width;
        localURLDrawableOptions.mRequestHeight = localLayoutParams.height;
      }
    }
    for (;;)
    {
      localObject = "";
      if ((localURLImageView.getTag(2131373990) instanceof String)) {
        localObject = (String)localURLImageView.getTag(2131373990);
      }
      localURLImageView.setTag(2131373990, str);
      if (!((String)localObject).equals(str))
      {
        localObject = new vrd().a(str).a((URLImageView)localURLImageView).b(false).a(true).c(localURLDrawableOptions.mRequestWidth).b(localURLDrawableOptions.mRequestHeight);
        QCircleFeedPicLoader.a().a((vrd)localObject, new wdq(this));
      }
      localURLImageView.setOnClickListener(new wdr(this, paramInt, localURLImageView, paramStImage));
      aaak.a().a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter);
      a(paramwdt, paramStImage);
      return paramwdt.jdField_a_of_type_AndroidWidgetFrameLayout;
      if (localURLImageView.getLayoutParams() != null)
      {
        localURLDrawableOptions.mRequestWidth = localURLImageView.getLayoutParams().width;
        localURLDrawableOptions.mRequestHeight = localURLImageView.getLayoutParams().height;
      }
    }
  }
  
  private wdt a(ViewGroup paramViewGroup)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramViewGroup.getContext());
    URLImageView localURLImageView;
    if (QCircleFeedItemPicPresenter.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter) == 0)
    {
      i = -1;
      localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
      localURLImageView = new URLImageView(paramViewGroup.getContext());
      localURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      if (QCircleFeedItemPicPresenter.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter) != 0) {
        break label188;
      }
    }
    label188:
    for (int i = -1;; i = QCircleFeedItemPicPresenter.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter))
    {
      localFrameLayout.addView(localURLImageView, new ViewGroup.LayoutParams(-1, i));
      paramViewGroup = new QCirclePaiTongKuanIconView(paramViewGroup.getContext());
      Object localObject = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject).topMargin = bhtq.a(12.0F);
      ((FrameLayout.LayoutParams)localObject).rightMargin = bhtq.a(10.0F);
      ((FrameLayout.LayoutParams)localObject).gravity = 53;
      localFrameLayout.addView(paramViewGroup, (ViewGroup.LayoutParams)localObject);
      localObject = new wdt(this);
      ((wdt)localObject).jdField_a_of_type_AndroidWidgetFrameLayout = localFrameLayout;
      ((wdt)localObject).jdField_a_of_type_ComTencentImageURLImageView = localURLImageView;
      ((wdt)localObject).jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePaiTongKuanIconView = paramViewGroup;
      return localObject;
      i = QCircleFeedItemPicPresenter.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter);
      break;
    }
  }
  
  private void a(wdt paramwdt, FeedCloudMeta.StImage paramStImage)
  {
    try
    {
      QQCircleFeedBase.StImageBusiData localStImageBusiData = new QQCircleFeedBase.StImageBusiData();
      localStImageBusiData.mergeFrom(paramStImage.busiData.get().toByteArray());
      if ((localStImageBusiData.simulate_date.get() != null) && (localStImageBusiData.simulate_date.is_show_button.get() == 1) && (Build.VERSION.SDK_INT >= 21))
      {
        paramwdt.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePaiTongKuanIconView.setVisibility(0);
        paramStImage = localStImageBusiData.simulate_date.simulate_name.get();
        if (paramStImage.equals("")) {
          paramwdt.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePaiTongKuanIconView.a();
        }
        for (;;)
        {
          paramwdt.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePaiTongKuanIconView.setOnClickListener(new wds(this, localStImageBusiData));
          vtn.a(86, 1, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.b());
          return;
          paramwdt.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePaiTongKuanIconView.setTongKuanText(paramStImage);
        }
      }
      paramwdt.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePaiTongKuanIconView.setVisibility(8);
    }
    catch (Exception paramwdt)
    {
      QLog.e("QCircleFeedItemPicPresent", 1, "exception:", paramwdt);
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public View a(ViewGroup paramViewGroup, int paramInt)
  {
    FeedCloudMeta.StImage localStImage = (FeedCloudMeta.StImage)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Object localObject;
    wdt localwdt;
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      localObject = (View)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
      localwdt = (wdt)((View)localObject).getTag();
    }
    for (;;)
    {
      paramViewGroup.addView((View)localObject);
      return a(localwdt, localStImage, paramInt);
      localwdt = a(paramViewGroup);
      localObject = localwdt.jdField_a_of_type_AndroidWidgetFrameLayout;
      ((View)localObject).setTag(localwdt);
    }
  }
  
  public void a(List<FeedCloudMeta.StImage> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    notifyDataSetChanged();
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (View)paramObject;
    paramViewGroup.removeView(paramObject);
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramObject);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (getCount() == 0) {
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childViewPresent.QCircleFeedItemPicPresenter.MultiPicAdapter
 * JD-Core Version:    0.7.0.1
 */