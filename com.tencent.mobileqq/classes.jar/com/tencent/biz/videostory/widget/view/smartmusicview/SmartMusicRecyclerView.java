package com.tencent.biz.videostory.widget.view.smartmusicview;

import NS_QQ_STORY_META.META.StMusic;
import aekt;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;
import yxh;
import yxr;
import yxs;
import yxv;
import yxw;

public class SmartMusicRecyclerView
  extends RecyclerView
{
  private int jdField_a_of_type_Int;
  private yxh jdField_a_of_type_Yxh;
  private yxr jdField_a_of_type_Yxr;
  private yxs jdField_a_of_type_Yxs;
  private yxv jdField_a_of_type_Yxv;
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
    this.jdField_a_of_type_Yxh = new yxh(getContext(), aekt.a(120.0F, getContext().getResources()));
    setLayoutManager(this.jdField_a_of_type_Yxh);
    this.jdField_a_of_type_Yxs = new yxs();
    setAdapter(this.jdField_a_of_type_Yxs);
    addOnScrollListener(new yxw(this));
  }
  
  private void a(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      if ((this.jdField_a_of_type_Yxv != null) && (this.jdField_a_of_type_Boolean) && (this.b))
      {
        this.jdField_a_of_type_Yxv.a();
        this.jdField_a_of_type_Yxv.d();
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        int i = this.jdField_a_of_type_Yxh.a() + 1;
        paramRecyclerView.smoothScrollToPosition(i);
        b();
        this.jdField_a_of_type_Yxv = ((yxv)paramRecyclerView.findViewHolderForAdapterPosition(i));
        if ((this.jdField_a_of_type_Yxr != null) && (this.jdField_a_of_type_Int != i))
        {
          this.jdField_a_of_type_Int = i;
          this.jdField_a_of_type_Yxr.a(i, this.jdField_a_of_type_Yxv);
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
    if (this.jdField_a_of_type_Yxv != null)
    {
      this.jdField_a_of_type_Yxv.a(false);
      this.jdField_a_of_type_Yxv.b(false);
      this.jdField_a_of_type_Yxv.b();
    }
  }
  
  public yxh a()
  {
    return this.jdField_a_of_type_Yxh;
  }
  
  public void setHasAutoSet(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setLastPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setListener(yxr paramyxr)
  {
    this.jdField_a_of_type_Yxr = paramyxr;
    if (this.jdField_a_of_type_Yxs != null) {
      this.jdField_a_of_type_Yxs.a(paramyxr);
    }
  }
  
  public void setMusicData(List<META.StMusic> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_Yxs.a(paramList);
    }
  }
  
  public void setNeedScale(boolean paramBoolean)
  {
    this.b = paramBoolean;
    a().a(paramBoolean);
    if (this.jdField_a_of_type_Yxv != null) {
      if (!paramBoolean) {
        break label55;
      }
    }
    label55:
    for (float f = a().a();; f = 1.0F)
    {
      this.jdField_a_of_type_Yxv.itemView.setScaleY(f);
      this.jdField_a_of_type_Yxv.itemView.setScaleX(f);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicRecyclerView
 * JD-Core Version:    0.7.0.1
 */