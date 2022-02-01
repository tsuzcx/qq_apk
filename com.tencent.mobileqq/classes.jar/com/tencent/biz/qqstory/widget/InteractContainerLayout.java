package com.tencent.biz.qqstory.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.InteractPasterLayout;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.widget.InteractPasterWidget;
import com.tencent.biz.qqstory.view.widget.RateWidget;

public class InteractContainerLayout
  extends FrameLayout
{
  public StoryVideoItem.InteractPasterLayout a;
  private final InteractPasterWidget a;
  
  public InteractContainerLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InteractContainerLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInteractPasterWidget = new RateWidget(getContext());
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    addView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInteractPasterWidget.a(), paramContext);
    setVisibility(4);
    setClipChildren(false);
    setClickable(false);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$InteractPasterLayout == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInteractPasterWidget.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$InteractPasterLayout.b, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$InteractPasterLayout.c, paramInt1, paramInt2, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$InteractPasterLayout.d, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$InteractPasterLayout.e, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$InteractPasterLayout.f, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$InteractPasterLayout.g, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$InteractPasterLayout.h);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInteractPasterWidget.a();
  }
  
  public void a(StoryVideoItem.InteractPasterLayout paramInteractPasterLayout, int paramInt)
  {
    SLog.a("InteractContainerLayout", "bindRateView, layout=%s, rateResult=%s.", paramInteractPasterLayout, Integer.valueOf(paramInt));
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$InteractPasterLayout = paramInteractPasterLayout;
    if ((paramInteractPasterLayout == null) || (paramInteractPasterLayout.a.length < 1))
    {
      setVisibility(4);
      return;
    }
    setVisibility(0);
    RateWidget localRateWidget = (RateWidget)this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInteractPasterWidget;
    localRateWidget.a(paramInteractPasterLayout.a);
    localRateWidget.b(false);
    if (paramInt != -2147483648) {}
    for (float f = paramInt;; f = 0.0F)
    {
      localRateWidget.a(f);
      a(getWidth(), getHeight());
      return;
    }
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    SLog.a("InteractContainerLayout", "bindRateView, vid=%s", paramStoryVideoItem.mVid);
    a(paramStoryVideoItem.getInteractLayout(), paramStoryVideoItem.mRateResult);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    a(paramInt3 - paramInt1, paramInt4 - paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.InteractContainerLayout
 * JD-Core Version:    0.7.0.1
 */