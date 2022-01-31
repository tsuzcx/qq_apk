package com.tencent.biz.qqcircle.widgets.childViewPresent;

import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import bdcs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tql;
import udo;

public class QCircleFeedItemPicPresent$MultiPicAdapter
  extends PagerAdapter
{
  private final ArrayList<FeedCloudMeta.StImage> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final LinkedList<View> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  public QCircleFeedItemPicPresent$MultiPicAdapter(QCircleFeedItemPicPresent paramQCircleFeedItemPicPresent) {}
  
  private View a(View paramView, FeedCloudMeta.StImage paramStImage, int paramInt)
  {
    String str = paramStImage.picUrl.get();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130846089);
    if (QCircleFeedItemPicPresent.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent) != 0) {
      if ((paramStImage.width.get() != 0) && (paramStImage.height.get() != 0))
      {
        float f = paramStImage.height.get() / paramStImage.width.get();
        paramStImage = paramView.getLayoutParams();
        int j = (int)(QCircleFeedItemPicPresent.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent) / f);
        int i = j;
        if (j > QCircleFeedItemPicPresent.b(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent)) {
          i = QCircleFeedItemPicPresent.b(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent);
        }
        paramStImage.width = i;
        paramStImage.height = QCircleFeedItemPicPresent.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent);
        localURLDrawableOptions.mRequestWidth = paramStImage.width;
        localURLDrawableOptions.mRequestHeight = paramStImage.height;
      }
    }
    for (;;)
    {
      paramStImage = "";
      if ((paramView.getTag(2131373170) instanceof String)) {
        paramStImage = (String)paramView.getTag(2131373170);
      }
      paramView.setTag(2131373170, str);
      if (!paramStImage.equals(str)) {
        tql.a(str, (URLImageView)paramView, localURLDrawableOptions, bdcs.c(str));
      }
      paramView.setOnClickListener(new udo(this, paramInt));
      return paramView;
      if (paramView.getLayoutParams() != null)
      {
        localURLDrawableOptions.mRequestWidth = paramView.getLayoutParams().width;
        localURLDrawableOptions.mRequestHeight = paramView.getLayoutParams().height;
      }
    }
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new URLImageView(paramViewGroup.getContext());
    paramViewGroup.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (QCircleFeedItemPicPresent.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent) == 0) {}
    for (int i = -1;; i = QCircleFeedItemPicPresent.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresent))
    {
      paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
      return paramViewGroup;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public View a(ViewGroup paramViewGroup, int paramInt)
  {
    FeedCloudMeta.StImage localStImage = (FeedCloudMeta.StImage)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {}
    for (View localView = (View)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();; localView = a(paramViewGroup))
    {
      paramViewGroup.addView(localView);
      return a(localView, localStImage, paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childViewPresent.QCircleFeedItemPicPresent.MultiPicAdapter
 * JD-Core Version:    0.7.0.1
 */