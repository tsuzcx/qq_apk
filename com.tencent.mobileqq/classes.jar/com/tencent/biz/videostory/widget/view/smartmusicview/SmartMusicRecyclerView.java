package com.tencent.biz.videostory.widget.view.smartmusicview;

import NS_QQ_STORY_META.META.StMusic;
import actj;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;
import xio;
import xiy;
import xiz;
import xjc;
import xjd;

public class SmartMusicRecyclerView
  extends RecyclerView
{
  private int jdField_a_of_type_Int;
  private xio jdField_a_of_type_Xio;
  private xiy jdField_a_of_type_Xiy;
  private xiz jdField_a_of_type_Xiz;
  private xjc jdField_a_of_type_Xjc;
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
    this.jdField_a_of_type_Xio = new xio(getContext(), actj.a(120.0F, getContext().getResources()));
    setLayoutManager(this.jdField_a_of_type_Xio);
    this.jdField_a_of_type_Xiz = new xiz();
    setAdapter(this.jdField_a_of_type_Xiz);
    addOnScrollListener(new xjd(this));
  }
  
  private void a(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      if ((this.jdField_a_of_type_Xjc != null) && (this.jdField_a_of_type_Boolean) && (this.b))
      {
        this.jdField_a_of_type_Xjc.a();
        this.jdField_a_of_type_Xjc.d();
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        int i = this.jdField_a_of_type_Xio.a() + 1;
        paramRecyclerView.smoothScrollToPosition(i);
        b();
        this.jdField_a_of_type_Xjc = ((xjc)paramRecyclerView.findViewHolderForAdapterPosition(i));
        if ((this.jdField_a_of_type_Xiy != null) && (this.jdField_a_of_type_Int != i))
        {
          this.jdField_a_of_type_Int = i;
          this.jdField_a_of_type_Xiy.a(i, this.jdField_a_of_type_Xjc);
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
    if (this.jdField_a_of_type_Xjc != null)
    {
      this.jdField_a_of_type_Xjc.a(false);
      this.jdField_a_of_type_Xjc.b(false);
      this.jdField_a_of_type_Xjc.b();
    }
  }
  
  public xio a()
  {
    return this.jdField_a_of_type_Xio;
  }
  
  public void setHasAutoSet(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setLastPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setListener(xiy paramxiy)
  {
    this.jdField_a_of_type_Xiy = paramxiy;
    if (this.jdField_a_of_type_Xiz != null) {
      this.jdField_a_of_type_Xiz.a(paramxiy);
    }
  }
  
  public void setMusicData(List<META.StMusic> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_Xiz.a(paramList);
    }
  }
  
  public void setNeedScale(boolean paramBoolean)
  {
    this.b = paramBoolean;
    a().a(paramBoolean);
    if (this.jdField_a_of_type_Xjc != null) {
      if (!paramBoolean) {
        break label55;
      }
    }
    label55:
    for (float f = a().a();; f = 1.0F)
    {
      this.jdField_a_of_type_Xjc.itemView.setScaleY(f);
      this.jdField_a_of_type_Xjc.itemView.setScaleX(f);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicRecyclerView
 * JD-Core Version:    0.7.0.1
 */