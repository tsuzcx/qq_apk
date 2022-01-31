package com.tencent.biz.videostory.widget.view.smartmusicview;

import NS_QQ_STORY_META.META.StMusic;
import aepi;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;
import zbw;
import zcg;
import zch;
import zck;
import zcl;

public class SmartMusicRecyclerView
  extends RecyclerView
{
  private int jdField_a_of_type_Int;
  private zbw jdField_a_of_type_Zbw;
  private zcg jdField_a_of_type_Zcg;
  private zch jdField_a_of_type_Zch;
  private zck jdField_a_of_type_Zck;
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
    this.jdField_a_of_type_Zbw = new zbw(getContext(), aepi.a(120.0F, getContext().getResources()));
    setLayoutManager(this.jdField_a_of_type_Zbw);
    this.jdField_a_of_type_Zch = new zch();
    setAdapter(this.jdField_a_of_type_Zch);
    addOnScrollListener(new zcl(this));
  }
  
  private void a(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      if ((this.jdField_a_of_type_Zck != null) && (this.jdField_a_of_type_Boolean) && (this.b))
      {
        this.jdField_a_of_type_Zck.a();
        this.jdField_a_of_type_Zck.d();
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        int i = this.jdField_a_of_type_Zbw.a() + 1;
        paramRecyclerView.smoothScrollToPosition(i);
        b();
        this.jdField_a_of_type_Zck = ((zck)paramRecyclerView.findViewHolderForAdapterPosition(i));
        if ((this.jdField_a_of_type_Zcg != null) && (this.jdField_a_of_type_Int != i))
        {
          this.jdField_a_of_type_Int = i;
          this.jdField_a_of_type_Zcg.a(i, this.jdField_a_of_type_Zck);
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
    if (this.jdField_a_of_type_Zck != null)
    {
      this.jdField_a_of_type_Zck.a(false);
      this.jdField_a_of_type_Zck.b(false);
      this.jdField_a_of_type_Zck.b();
    }
  }
  
  public zbw a()
  {
    return this.jdField_a_of_type_Zbw;
  }
  
  public void setHasAutoSet(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setLastPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setListener(zcg paramzcg)
  {
    this.jdField_a_of_type_Zcg = paramzcg;
    if (this.jdField_a_of_type_Zch != null) {
      this.jdField_a_of_type_Zch.a(paramzcg);
    }
  }
  
  public void setMusicData(List<META.StMusic> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_Zch.a(paramList);
    }
  }
  
  public void setNeedScale(boolean paramBoolean)
  {
    this.b = paramBoolean;
    a().a(paramBoolean);
    if (this.jdField_a_of_type_Zck != null) {
      if (!paramBoolean) {
        break label55;
      }
    }
    label55:
    for (float f = a().a();; f = 1.0F)
    {
      this.jdField_a_of_type_Zck.itemView.setScaleY(f);
      this.jdField_a_of_type_Zck.itemView.setScaleX(f);
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