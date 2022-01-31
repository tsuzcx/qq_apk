package com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ImageData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.BaseItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.ItemCreator;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.SimpleViewCreator;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastAttachedAdCreator;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastBannerAdCreator;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastCommentCreator;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastImageViewCreator;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastLinkViewCreator;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastRecommendAdCreator;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastRecommendCreator;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastTextViewCreator;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastTitleViewCreator;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastVideoViewCreator;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mll;
import mlm;

public class WebFastAdapter
  extends BaseAdapter
  implements OnItemClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new mlm(this);
  private BaseItemViewHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemBaseItemViewHolder;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private List jdField_a_of_type_JavaUtilList;
  private ItemCreator[] jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewFastwebItemItemCreator;
  
  public WebFastAdapter(Context paramContext, List paramList, FaceDecoder paramFaceDecoder)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    a();
  }
  
  private ItemCreator a(BaseData paramBaseData)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewFastwebItemItemCreator.length)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewFastwebItemItemCreator[i].a(paramBaseData)) {
        return this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewFastwebItemItemCreator[i];
      }
      i += 1;
    }
    throw new IllegalArgumentException("no suitable creator");
  }
  
  private void a()
  {
    this.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewFastwebItemItemCreator = new ItemCreator[] { new WebFastTextViewCreator(), new WebFastTitleViewCreator(), new WebFastImageViewCreator(), new WebFastLinkViewCreator(), new WebFastVideoViewCreator(), new WebFastRecommendCreator(), new SimpleViewCreator(), new WebFastRecommendAdCreator(), new WebFastBannerAdCreator(), new WebFastAttachedAdCreator(), new WebFastCommentCreator(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder) };
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    BaseData localBaseData = (BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramView == null)
    {
      paramView = a(localBaseData);
      if (paramView != null)
      {
        paramViewGroup = paramView.a(this.jdField_a_of_type_AndroidContentContext, localBaseData, paramViewGroup);
        paramViewGroup.a(this);
        paramView = paramViewGroup.jdField_a_of_type_AndroidViewView;
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      paramViewGroup.a(paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, localBaseData, paramBoolean);
      return paramView;
      throw new NullPointerException();
      paramViewGroup = (BaseItemViewHolder)paramView.getTag();
    }
  }
  
  public void a(BaseData paramBaseData)
  {
    switch (paramBaseData.d)
    {
    default: 
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (BaseData)localIterator.next();
        if (((BaseData)localObject).d == 3)
        {
          localObject = (ImageData)localObject;
          this.jdField_a_of_type_JavaUtilArrayList.add(ReadInJoyUtils.f(((ImageData)localObject).a));
        }
      }
    }
    int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(ReadInJoyUtils.f(((ImageData)paramBaseData).a));
    TroopNoticeJsHandler.a((Activity)this.jdField_a_of_type_AndroidContentContext, i, this.jdField_a_of_type_JavaUtilArrayList, true, "", 1000);
  }
  
  public void a(BaseItemViewHolder paramBaseItemViewHolder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemBaseItemViewHolder = paramBaseItemViewHolder;
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(0, "复制");
    BubbleContextMenu.a(paramBaseItemViewHolder.jdField_a_of_type_AndroidViewView, localQQCustomMenu, this.jdField_a_of_type_AndroidViewView$OnClickListener, new mll(this, paramBaseItemViewHolder));
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return (BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    BaseData localBaseData = (BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    return a(localBaseData).a(localBaseData);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return a(paramInt, paramView, paramViewGroup, false);
  }
  
  public int getViewTypeCount()
  {
    return 14;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter
 * JD-Core Version:    0.7.0.1
 */