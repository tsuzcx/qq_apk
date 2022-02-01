package com.tencent.biz.videostory.widget.view.smartmusicview;

import NS_QQ_STORY_META.META.StMusic;
import abcs;
import abdc;
import abdd;
import abdg;
import abdh;
import agej;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

public class SmartMusicRecyclerView
  extends RecyclerView
{
  private int jdField_a_of_type_Int;
  private abcs jdField_a_of_type_Abcs;
  private abdc jdField_a_of_type_Abdc;
  private abdd jdField_a_of_type_Abdd;
  private abdg jdField_a_of_type_Abdg;
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
    this.jdField_a_of_type_Abcs = new abcs(getContext(), agej.a(120.0F, getContext().getResources()));
    setLayoutManager(this.jdField_a_of_type_Abcs);
    this.jdField_a_of_type_Abdd = new abdd();
    setAdapter(this.jdField_a_of_type_Abdd);
    addOnScrollListener(new abdh(this));
  }
  
  private void a(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      if ((this.jdField_a_of_type_Abdg != null) && (this.jdField_a_of_type_Boolean) && (this.b))
      {
        this.jdField_a_of_type_Abdg.a();
        this.jdField_a_of_type_Abdg.d();
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        int i = this.jdField_a_of_type_Abcs.a() + 1;
        paramRecyclerView.smoothScrollToPosition(i);
        b();
        this.jdField_a_of_type_Abdg = ((abdg)paramRecyclerView.findViewHolderForAdapterPosition(i));
        if ((this.jdField_a_of_type_Abdc != null) && (this.jdField_a_of_type_Int != i))
        {
          this.jdField_a_of_type_Int = i;
          this.jdField_a_of_type_Abdc.a(i, this.jdField_a_of_type_Abdg);
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
    if (this.jdField_a_of_type_Abdg != null)
    {
      this.jdField_a_of_type_Abdg.a(false);
      this.jdField_a_of_type_Abdg.b(false);
      this.jdField_a_of_type_Abdg.b();
    }
  }
  
  public abcs a()
  {
    return this.jdField_a_of_type_Abcs;
  }
  
  public void setHasAutoSet(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setLastPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setListener(abdc paramabdc)
  {
    this.jdField_a_of_type_Abdc = paramabdc;
    if (this.jdField_a_of_type_Abdd != null) {
      this.jdField_a_of_type_Abdd.a(paramabdc);
    }
  }
  
  public void setMusicData(List<META.StMusic> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_Abdd.a(paramList);
    }
  }
  
  public void setNeedScale(boolean paramBoolean)
  {
    this.b = paramBoolean;
    a().a(paramBoolean);
    if (this.jdField_a_of_type_Abdg != null) {
      if (!paramBoolean) {
        break label55;
      }
    }
    label55:
    for (float f = a().a();; f = 1.0F)
    {
      this.jdField_a_of_type_Abdg.itemView.setScaleY(f);
      this.jdField_a_of_type_Abdg.itemView.setScaleX(f);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicRecyclerView
 * JD-Core Version:    0.7.0.1
 */