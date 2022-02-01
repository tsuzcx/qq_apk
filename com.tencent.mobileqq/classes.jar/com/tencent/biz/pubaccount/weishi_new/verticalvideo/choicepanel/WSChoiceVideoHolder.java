package com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel;

import UserGrowth.stSimpleMetaFeed;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.drama.checkable.OnCheckedListener;
import com.tencent.biz.pubaccount.weishi_new.drama.checkable.WSAbsCheckableHolder;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView;

public class WSChoiceVideoHolder
  extends WSAbsCheckableHolder<WSVerticalItemData>
{
  private static final int jdField_a_of_type_Int = WSFeedUtils.a(5.0F);
  private static final int b = Color.parseColor("#282828");
  private GradientDrawable jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
  private FeedRichTextView jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  private RoundCornerImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView;
  
  public WSChoiceVideoHolder(ViewGroup paramViewGroup, OnCheckedListener<WSVerticalItemData> paramOnCheckedListener)
  {
    super(paramViewGroup, 1929641985, paramOnCheckedListener);
    d();
    b();
    c();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView = ((RoundCornerImageView)this.itemView.findViewById(1929576450));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.setCorner(jdField_a_of_type_Int, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)this.itemView.findViewById(1929576464));
  }
  
  private void c()
  {
    WSChoiceVideoHolder.1 local1 = new WSChoiceVideoHolder.1(this);
    this.itemView.setOnClickListener(local1);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnClickListener(local1);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView.setOnClickListener(local1);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = new GradientDrawable();
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setShape(0);
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(Color.parseColor("#515151"));
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setCornerRadius(jdField_a_of_type_Int);
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData)
  {
    super.a(paramWSVerticalItemData);
    if (paramWSVerticalItemData != null)
    {
      if (paramWSVerticalItemData.a() == null) {
        return;
      }
      a(paramWSVerticalItemData.a());
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(paramWSVerticalItemData.a().feed_desc);
      WSPicLoader.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundCornerImageView, paramWSVerticalItemData.a(), this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable, "", true, 0);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.itemView.setBackgroundColor(b);
      return;
    }
    this.itemView.setBackgroundColor(-16777216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel.WSChoiceVideoHolder
 * JD-Core Version:    0.7.0.1
 */