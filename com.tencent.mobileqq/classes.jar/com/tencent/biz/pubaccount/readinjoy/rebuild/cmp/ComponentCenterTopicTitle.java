package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;

public class ComponentCenterTopicTitle
  extends ComponentTitle
  implements ComponentView
{
  TextView a;
  TextView b;
  
  public ComponentCenterTopicTitle(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentCenterTopicTitle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentCenterTopicTitle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2130969587, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367011));
    this.b = ((TextView)findViewById(2131363561));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramObject);
      paramObject = paramObject.a();
      if ((paramObject != null) && (paramObject.mSocialFeedInfo != null) && (paramObject.mSocialFeedInfo.a != null) && (paramObject.mSocialFeedInfo.a.a != null) && (!paramObject.mSocialFeedInfo.a.a.isEmpty()))
      {
        paramObject = (TopicRecommendFeedsInfo.TopicRecommendInfo)paramObject.mSocialFeedInfo.a.a.get(0);
        String str = paramObject.c + paramObject.a;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        if (paramObject.b <= 0) {
          break label176;
        }
        paramObject = String.format("- %s人正在参与 -", new Object[] { ReadInJoyHelper.a(paramObject.b) });
        this.b.setText(paramObject);
        this.b.setVisibility(0);
      }
    }
    for (;;)
    {
      b();
      return;
      label176:
      this.b.setVisibility(8);
    }
  }
  
  public void b() {}
  
  public void setReadedStatus(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentCenterTopicTitle
 * JD-Core Version:    0.7.0.1
 */