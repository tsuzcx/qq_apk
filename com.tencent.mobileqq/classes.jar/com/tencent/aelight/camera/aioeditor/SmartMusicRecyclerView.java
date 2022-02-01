package com.tencent.aelight.camera.aioeditor;

import NS_QQ_STORY_META.META.StMusic;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.videostory.widget.view.smartmusicview.CircleLayoutManager;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.List;

public class SmartMusicRecyclerView
  extends RecyclerView
{
  private int jdField_a_of_type_Int;
  private EditVideoSmartMusicPart.onSmartMusicViewListener jdField_a_of_type_ComTencentAelightCameraAioeditorEditVideoSmartMusicPart$onSmartMusicViewListener;
  private SmartMusicAdapter.SmartMusicVH jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter$SmartMusicVH;
  private SmartMusicAdapter jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter;
  private CircleLayoutManager jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewCircleLayoutManager;
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
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewCircleLayoutManager = new CircleLayoutManager(getContext(), AIOUtils.b(120.0F, getContext().getResources()));
    setLayoutManager(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewCircleLayoutManager);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter = new SmartMusicAdapter();
    setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter);
    addOnScrollListener(new SmartMusicRecyclerView.1(this));
  }
  
  private void a(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      SmartMusicAdapter.SmartMusicVH localSmartMusicVH = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter$SmartMusicVH;
      if ((localSmartMusicVH != null) && (this.jdField_a_of_type_Boolean) && (this.b))
      {
        localSmartMusicVH.a();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter$SmartMusicVH.d();
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        int i = this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewCircleLayoutManager.a() + 1;
        paramRecyclerView.smoothScrollToPosition(i);
        b();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter$SmartMusicVH = ((SmartMusicAdapter.SmartMusicVH)paramRecyclerView.findViewHolderForAdapterPosition(i));
        paramRecyclerView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorEditVideoSmartMusicPart$onSmartMusicViewListener;
        if ((paramRecyclerView != null) && (this.jdField_a_of_type_Int != i))
        {
          this.jdField_a_of_type_Int = i;
          paramRecyclerView.a(i, this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter$SmartMusicVH);
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
    SmartMusicAdapter.SmartMusicVH localSmartMusicVH = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter$SmartMusicVH;
    if (localSmartMusicVH != null)
    {
      localSmartMusicVH.a(false);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter$SmartMusicVH.b(false);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter$SmartMusicVH.b();
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
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorEditVideoSmartMusicPart$onSmartMusicViewListener = paramonSmartMusicViewListener;
    SmartMusicAdapter localSmartMusicAdapter = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter;
    if (localSmartMusicAdapter != null) {
      localSmartMusicAdapter.a(paramonSmartMusicViewListener);
    }
  }
  
  public void setMusicData(List<META.StMusic> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter.a(paramList);
    }
  }
  
  public void setNeedScale(boolean paramBoolean)
  {
    this.b = paramBoolean;
    a().a(paramBoolean);
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter$SmartMusicVH != null)
    {
      float f;
      if (paramBoolean) {
        f = a().a();
      } else {
        f = 1.0F;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter$SmartMusicVH.itemView.setScaleY(f);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorSmartMusicAdapter$SmartMusicVH.itemView.setScaleX(f);
    }
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    int i = paramInt - 1;
    paramInt = i;
    if (i < 0) {
      paramInt = 0;
    }
    smoothScrollBy(0, a().a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.SmartMusicRecyclerView
 * JD-Core Version:    0.7.0.1
 */