package com.tencent.biz.qqcircle.richframework.part.list.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.utils.QCircleThreadManager;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PublicListInnerFragment
  extends QCircleBaseFragment
{
  protected BlockPart c;
  protected BaseListBlock d;
  
  public int a()
  {
    return -1;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    u();
  }
  
  protected void a(BaseListBlock paramBaseListBlock)
  {
    this.d = paramBaseListBlock;
  }
  
  public String b()
  {
    return "PublicListInnerFragment";
  }
  
  protected int c()
  {
    BaseListBlock localBaseListBlock = this.d;
    if ((localBaseListBlock != null) && (localBaseListBlock.getContentLayoutId() != 0)) {
      return this.d.getContentLayoutId();
    }
    return 2131626922;
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    this.c = new BlockPart(2131431490, w(), 3, 1);
    localArrayList.add(this.c);
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((BaseListBlock)localObject).getCustomParts();
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        localArrayList.addAll((Collection)localObject);
      }
    }
    return localArrayList;
  }
  
  protected String f()
  {
    BaseListBlock localBaseListBlock = this.d;
    if (localBaseListBlock != null) {
      return localBaseListBlock.getDaTongPageId();
    }
    return "";
  }
  
  protected int j()
  {
    BaseListBlock localBaseListBlock = this.d;
    if (localBaseListBlock != null) {
      return localBaseListBlock.getStatusBarColor();
    }
    return 0;
  }
  
  protected void l() {}
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean) {
      QCircleThreadManager.a().c().postDelayed(new PublicListInnerFragment.2(this), 100L);
    }
  }
  
  protected void u()
  {
    this.c.i().setEnableRefresh(true);
    this.c.i().setEnableLoadMore(true);
    this.c.i().setParentFragment(this);
    this.c.i().getBlockMerger().b(3);
    this.c.i().getRecyclerView().setBackgroundColor(QCircleSkinHelper.getInstance().getColor(2131167059));
    this.c.i().getRecyclerView().addOnScrollListener(new PublicListInnerFragment.1(this));
  }
  
  protected boolean v()
  {
    return false;
  }
  
  protected List<MultiViewBlock> w()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.d);
    return localArrayList;
  }
  
  public BlockContainer x()
  {
    BlockPart localBlockPart = this.c;
    if (localBlockPart != null) {
      return localBlockPart.i();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.part.list.base.PublicListInnerFragment
 * JD-Core Version:    0.7.0.1
 */