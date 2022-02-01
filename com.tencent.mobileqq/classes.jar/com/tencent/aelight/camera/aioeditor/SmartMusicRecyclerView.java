package com.tencent.aelight.camera.aioeditor;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.videostory.widget.view.smartmusicview.CircleLayoutManager;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.List;
import qqcircle.QQCircleSmartMatchMusic.MusicInfo;

public class SmartMusicRecyclerView
  extends RecyclerView
{
  private CircleLayoutManager a;
  private SmartMusicAdapter b;
  private boolean c;
  private SmartMusicAdapter.SmartMusicVH d;
  private EditVideoSmartMusicPart.onSmartMusicViewListener e;
  private int f;
  private boolean g = true;
  
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
    this.a = new CircleLayoutManager(getContext(), AIOUtils.b(120.0F, getContext().getResources()));
    setLayoutManager(this.a);
    this.b = new SmartMusicAdapter();
    setAdapter(this.b);
    addOnScrollListener(new SmartMusicRecyclerView.1(this));
  }
  
  private void a(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      SmartMusicAdapter.SmartMusicVH localSmartMusicVH = this.d;
      if ((localSmartMusicVH != null) && (this.c) && (this.g))
      {
        localSmartMusicVH.a();
        this.d.d();
      }
      if (!this.c)
      {
        int i = this.a.a() + 1;
        paramRecyclerView.smoothScrollToPosition(i);
        b();
        this.d = ((SmartMusicAdapter.SmartMusicVH)paramRecyclerView.findViewHolderForAdapterPosition(i));
        paramRecyclerView = this.e;
        if ((paramRecyclerView != null) && (this.f != i))
        {
          this.f = i;
          paramRecyclerView.a(i, this.d);
        }
        this.c = true;
      }
    }
    if (((paramInt == 1) || (paramInt == 2)) && (paramInt == 1))
    {
      b();
      this.c = false;
    }
  }
  
  private void b()
  {
    SmartMusicAdapter.SmartMusicVH localSmartMusicVH = this.d;
    if (localSmartMusicVH != null)
    {
      localSmartMusicVH.a(false);
      this.d.b(false);
      this.d.b();
    }
  }
  
  public CircleLayoutManager getCircleLayoutManager()
  {
    return this.a;
  }
  
  public void setHasAutoSet(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setLastPosition(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setListener(EditVideoSmartMusicPart.onSmartMusicViewListener paramonSmartMusicViewListener)
  {
    this.e = paramonSmartMusicViewListener;
    SmartMusicAdapter localSmartMusicAdapter = this.b;
    if (localSmartMusicAdapter != null) {
      localSmartMusicAdapter.a(paramonSmartMusicViewListener);
    }
  }
  
  public void setMusicData(List<QQCircleSmartMatchMusic.MusicInfo> paramList)
  {
    if (paramList != null) {
      this.b.a(paramList);
    }
  }
  
  public void setNeedScale(boolean paramBoolean)
  {
    this.g = paramBoolean;
    getCircleLayoutManager().a(paramBoolean);
    if (this.d != null)
    {
      float f1;
      if (paramBoolean) {
        f1 = getCircleLayoutManager().b();
      } else {
        f1 = 1.0F;
      }
      this.d.itemView.setScaleY(f1);
      this.d.itemView.setScaleX(f1);
    }
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    int i = paramInt - 1;
    paramInt = i;
    if (i < 0) {
      paramInt = 0;
    }
    smoothScrollBy(0, getCircleLayoutManager().b(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.SmartMusicRecyclerView
 * JD-Core Version:    0.7.0.1
 */