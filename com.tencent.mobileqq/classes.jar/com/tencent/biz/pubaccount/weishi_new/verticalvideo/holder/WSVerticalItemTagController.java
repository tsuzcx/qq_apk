package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stVideoTag;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;

public class WSVerticalItemTagController
  extends AbsWsUIGroup<WSVerticalItemData>
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSVerticalVideoHolder jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder;
  
  public WSVerticalItemTagController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder = paramWSVerticalVideoHolder;
  }
  
  private boolean a(stVideoTag paramstVideoTag)
  {
    WSVerticalVideoHolder localWSVerticalVideoHolder = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localWSVerticalVideoHolder != null)
    {
      if (localWSVerticalVideoHolder.a == null) {
        return false;
      }
      bool1 = bool2;
      if (paramstVideoTag.tagId == 6)
      {
        bool1 = bool2;
        if (TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.a.a(), "recommend_tab"))
        {
          bool1 = bool2;
          if (a() == 0) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a();
    if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.a() instanceof stSimpleMetaFeed))) {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = localWSVerticalItemData.a();
    }
  }
  
  protected int b()
  {
    return 2131560045;
  }
  
  protected void b()
  {
    Object localObject1 = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
    if (localObject1 != null)
    {
      stVideoTag localstVideoTag = ((stSimpleMetaFeed)localObject1).videoTag;
      if ((localstVideoTag != null) && (!TextUtils.isEmpty(localstVideoTag.text)) && (!a(localstVideoTag)))
      {
        a(0);
        if ((!TextUtils.isEmpty(localstVideoTag.textColor)) && (localstVideoTag.textColor.startsWith("#")))
        {
          localObject1 = localstVideoTag.textColor;
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("#");
          ((StringBuilder)localObject1).append(localstVideoTag.textColor);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        if ((!TextUtils.isEmpty(localstVideoTag.bgColor)) && (localstVideoTag.bgColor.startsWith("#")))
        {
          localObject2 = localstVideoTag.bgColor;
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("#");
          ((StringBuilder)localObject2).append(localstVideoTag.bgColor);
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setCornerRadius(WeishiUIUtil.d);
        if (!WeishiUIUtil.a((String)localObject2)) {
          localObject2 = "#80000000";
        }
        localGradientDrawable.setColor(Color.parseColor((String)localObject2));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localstVideoTag.text);
        Object localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
        if (!WeishiUIUtil.a((String)localObject1)) {
          localObject1 = "#FFFFFF";
        }
        ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject1));
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(localGradientDrawable);
        return;
      }
    }
    a(8);
  }
  
  protected void c() {}
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380474));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemTagController
 * JD-Core Version:    0.7.0.1
 */