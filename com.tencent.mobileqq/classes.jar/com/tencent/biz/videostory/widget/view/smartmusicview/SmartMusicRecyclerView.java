package com.tencent.biz.videostory.widget.view.smartmusicview;

import NS_QQ_STORY_META.META.StMusic;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.List;

public class SmartMusicRecyclerView
  extends RecyclerView
{
  private int jdField_a_of_type_Int;
  private CircleLayoutManager jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewCircleLayoutManager;
  private EditVideoSmartMusicPart.onSmartMusicViewListener jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewEditVideoSmartMusicPart$onSmartMusicViewListener;
  private SmartMusicAdapter.SmartMusicVH jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH;
  private SmartMusicAdapter jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter;
  private boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  
  public SmartMusicRecyclerView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public SmartMusicRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SmartMusicRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewCircleLayoutManager = new CircleLayoutManager(getContext(), AIOUtils.a(120.0F, getContext().getResources()));
    setLayoutManager(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewCircleLayoutManager);
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter = new SmartMusicAdapter();
    setAdapter(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter);
    addOnScrollListener(new SmartMusicRecyclerView.1(this));
  }
  
  private void a(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      if ((this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH != null) && (this.jdField_a_of_type_Boolean) && (this.b))
      {
        this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH.a();
        this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH.d();
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        int i = this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewCircleLayoutManager.a() + 1;
        paramRecyclerView.smoothScrollToPosition(i);
        b();
        this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH = ((SmartMusicAdapter.SmartMusicVH)paramRecyclerView.findViewHolderForAdapterPosition(i));
        if ((this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewEditVideoSmartMusicPart$onSmartMusicViewListener != null) && (this.jdField_a_of_type_Int != i))
        {
          this.jdField_a_of_type_Int = i;
          this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewEditVideoSmartMusicPart$onSmartMusicViewListener.a(i, this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH);
        }
        this.jdField_a_of_type_Boolean = true;
      }
    }
    if (((paramInt == 1) || (paramInt == 2)) && (paramInt == 1))
    {
      b();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH != null)
    {
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH.a(false);
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH.b(false);
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH.b();
    }
  }
  
  public CircleLayoutManager a()
  {
    return this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewCircleLayoutManager;
  }
  
  public void setHasAutoSet(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setLastPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setListener(EditVideoSmartMusicPart.onSmartMusicViewListener paramonSmartMusicViewListener)
  {
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewEditVideoSmartMusicPart$onSmartMusicViewListener = paramonSmartMusicViewListener;
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter != null) {
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter.a(paramonSmartMusicViewListener);
    }
  }
  
  public void setMusicData(List<META.StMusic> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter.a(paramList);
    }
  }
  
  public void setNeedScale(boolean paramBoolean)
  {
    this.b = paramBoolean;
    a().a(paramBoolean);
    if (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH != null) {
      if (!paramBoolean) {
        break label55;
      }
    }
    label55:
    for (float f = a().a();; f = 1.0F)
    {
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH.itemView.setScaleY(f);
      this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter$SmartMusicVH.itemView.setScaleX(f);
      return;
    }
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    if (paramInt - 1 < 0) {
      paramInt = 0;
    }
    for (;;)
    {
      smoothScrollBy(0, a().a(paramInt));
      return;
      paramInt -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicRecyclerView
 * JD-Core Version:    0.7.0.1
 */