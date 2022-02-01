package com.tencent.biz.richframework.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import java.util.ArrayList;
import java.util.List;

public class BlockPart
  extends Part
{
  private final int a;
  private int b;
  protected final ArrayList<MultiViewBlock> c = new ArrayList();
  protected BlockContainer d;
  private int e;
  private boolean f;
  
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
      this.c.addAll(paramList);
    }
    this.e = paramInt2;
    this.b = paramInt3;
    this.a = paramInt1;
  }
  
  protected BlockContainer a(Context paramContext)
  {
    return new BlockContainer(paramContext);
  }
  
  public String a()
  {
    return "BlockPart";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((i() != null) && (i().getBlockMerger() != null)) {
      i().getBlockMerger().onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    int i = this.a;
    if (i != 0) {
      this.d = ((BlockContainer)paramView.findViewById(i));
    }
    if (this.d == null) {
      this.d = a(paramView.getContext());
    }
    this.d.setEnablePageRecyclerViewPool(this.f);
    this.d.setLayoutManagerType(this.e, this.b);
    this.d.setBlockWrapper(this);
    this.d.setParentFragment(j());
    this.d.a(this.c);
    this.d.g();
  }
  
  public boolean ah_()
  {
    if ((i() != null) && (i().d())) {
      return true;
    }
    return super.ah_();
  }
  
  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (i() != null) {
      i().setEnablePageRecyclerViewPool(paramBoolean);
    }
  }
  
  public IStatusViewProvider bc_()
  {
    if (i() != null) {
      return i().getStatusInterface();
    }
    return null;
  }
  
  public BlockContainer i()
  {
    return this.d;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    if ((i() != null) && (i().getBlockMerger() != null)) {
      i().getBlockMerger().onActivityDestroyed(paramActivity);
    }
    if (i() != null) {
      i().e();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if ((i() != null) && (i().getBlockMerger() != null)) {
      i().getBlockMerger().onActivityPaused(paramActivity);
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if ((i() != null) && (i().getBlockMerger() != null)) {
      i().getBlockMerger().onActivityResumed(paramActivity);
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if ((i() != null) && (i().getBlockMerger() != null)) {
      i().getBlockMerger().onActivityStarted(paramActivity);
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if ((i() != null) && (i().getBlockMerger() != null)) {
      i().getBlockMerger().onActivityStopped(paramActivity);
    }
  }
  
  public ArrayList<MultiViewBlock> r()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.BlockPart
 * JD-Core Version:    0.7.0.1
 */