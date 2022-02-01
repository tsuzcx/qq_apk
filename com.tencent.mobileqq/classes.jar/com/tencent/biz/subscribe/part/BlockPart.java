package com.tencent.biz.subscribe.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.subscribe.part.block.BlockMerger;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import java.util.ArrayList;
import java.util.List;

public class BlockPart
  extends Part
{
  protected final ArrayList<MultiViewBlock> a = new ArrayList();
  protected BlockContainer b;
  private final int d;
  private int e;
  private int f;
  
  public BlockPart()
  {
    this(0);
  }
  
  public BlockPart(int paramInt)
  {
    this(paramInt, null);
  }
  
  public BlockPart(int paramInt, List<MultiViewBlock> paramList)
  {
    this(paramInt, paramList, 3, 1);
  }
  
  public BlockPart(int paramInt1, List<MultiViewBlock> paramList, int paramInt2, int paramInt3)
  {
    if (paramList != null) {
      this.a.addAll(paramList);
    }
    this.f = paramInt2;
    this.e = paramInt3;
    this.d = paramInt1;
  }
  
  public BlockContainer a()
  {
    return this.b;
  }
  
  protected BlockContainer a(Context paramContext)
  {
    return new BlockContainer(paramContext);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((a() != null) && (a().getBlockMerger() != null)) {
      a().getBlockMerger().a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    int i = this.d;
    if (i != 0) {
      this.b = ((BlockContainer)paramView.findViewById(i));
    }
    if (this.b == null) {
      this.b = a(paramView.getContext());
    }
    this.b.setLayoutManagerType(this.f, this.e);
    this.b.setBlockWrapper(this);
    this.b.setParentFragment(d());
    this.b.a(this.a);
    this.b.e();
  }
  
  public String b()
  {
    return "BlockPart";
  }
  
  public boolean c()
  {
    BlockContainer localBlockContainer = this.b;
    if ((localBlockContainer != null) && (localBlockContainer.b())) {
      return true;
    }
    return super.c();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if ((a() != null) && (a().getBlockMerger() != null)) {
      a().getBlockMerger().onActivityDestroyed(paramActivity);
    }
    if (a() != null) {
      a().c();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if ((a() != null) && (a().getBlockMerger() != null)) {
      a().getBlockMerger().onActivityPaused(paramActivity);
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if ((a() != null) && (a().getBlockMerger() != null)) {
      a().getBlockMerger().onActivityResumed(paramActivity);
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if ((a() != null) && (a().getBlockMerger() != null)) {
      a().getBlockMerger().onActivityStarted(paramActivity);
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if ((a() != null) && (a().getBlockMerger() != null)) {
      a().getBlockMerger().onActivityStopped(paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.BlockPart
 * JD-Core Version:    0.7.0.1
 */