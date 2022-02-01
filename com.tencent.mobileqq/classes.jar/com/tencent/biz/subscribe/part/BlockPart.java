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
  private final int a;
  protected BlockContainer a;
  protected final ArrayList<MultiViewBlock> a;
  private int b;
  private int c;
  
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
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
    this.c = paramInt2;
    this.b = paramInt3;
    this.jdField_a_of_type_Int = paramInt1;
  }
  
  public BlockContainer a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer;
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
    if ((a() != null) && (a().a() != null)) {
      a().a().a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (this.jdField_a_of_type_Int != 0) {
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer = ((BlockContainer)paramView.findViewById(this.jdField_a_of_type_Int));
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer == null) {
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer = a(paramView.getContext());
    }
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setLayoutManagerType(this.c, this.b);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setBlockWrapper(this);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setParentFragment(a());
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.c();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer != null) && (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a())) {
      return true;
    }
    return super.a();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().onActivityDestroyed(paramActivity);
    }
    if (a() != null) {
      a().b();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().onActivityPaused(paramActivity);
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().onActivityResumed(paramActivity);
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().onActivityStarted(paramActivity);
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().onActivityStopped(paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.BlockPart
 * JD-Core Version:    0.7.0.1
 */