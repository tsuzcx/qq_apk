package com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel;

import UserGrowth.stSimpleMetaFeed;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.drama.checkable.OnCheckedListener;
import com.tencent.biz.pubaccount.weishi_new.drama.checkable.WSAbsCheckableHolder;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.richtext.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView;

public class WSChoiceVideoHolder
  extends WSAbsCheckableHolder<WSVerticalItemData>
{
  private static final int b = WSFeedUtils.a(5.0F);
  private static final int c = Color.parseColor("#282828");
  private RoundCornerImageView d;
  private FeedRichTextView e;
  private GradientDrawable f;
  
  public WSChoiceVideoHolder(ViewGroup paramViewGroup, OnCheckedListener<WSVerticalItemData> paramOnCheckedListener)
  {
    super(paramViewGroup, 1929773061, paramOnCheckedListener);
    e();
    c();
    d();
  }
  
  private void c()
  {
    this.d = ((RoundCornerImageView)this.itemView.findViewById(1929707525));
    this.d.setCorner(b, 0);
    this.e = ((FeedRichTextView)this.itemView.findViewById(1929707577));
  }
  
  private void d()
  {
    WSChoiceVideoHolder.1 local1 = new WSChoiceVideoHolder.1(this);
    this.itemView.setOnClickListener(local1);
    this.e.setOnClickListener(local1);
    this.d.setOnClickListener(local1);
  }
  
  private void e()
  {
    this.f = new GradientDrawable();
    this.f.setShape(0);
    this.f.setColor(Color.parseColor("#515151"));
    this.f.setCornerRadius(b);
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData)
  {
    super.a(paramWSVerticalItemData);
    if (paramWSVerticalItemData != null)
    {
      if (paramWSVerticalItemData.b() == null) {
        return;
      }
      a(paramWSVerticalItemData.a());
      this.e.setText(paramWSVerticalItemData.b().feed_desc);
      WSPicLoader.a().a(this.d, paramWSVerticalItemData.b(), this.f, "", true, 0);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.itemView.setBackgroundColor(c);
      return;
    }
    this.itemView.setBackgroundColor(-16777216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel.WSChoiceVideoHolder
 * JD-Core Version:    0.7.0.1
 */