package com.tencent.avgame.gamelobby.rv;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.avgame.gamelobby.data.IBaseData;
import com.tencent.avgame.gamelobby.data.IBaseDataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class BaseAdapter
  extends RecyclerView.Adapter<BaseViewHolder<? extends IBaseData>>
{
  private boolean b = false;
  private BaseViewHolder.Factory c;
  private ViewHolderContext d;
  private HashMap<Integer, BaseAdapter.BaseViewConfig> e;
  private IBaseDataSource f = null;
  private List<BaseViewHolder> g = new ArrayList();
  
  public BaseAdapter()
  {
    this(false);
  }
  
  public BaseAdapter(ViewHolderContext paramViewHolderContext)
  {
    this(paramViewHolderContext, false);
  }
  
  public BaseAdapter(ViewHolderContext paramViewHolderContext, boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.d = paramViewHolderContext;
    this.c = new BaseViewHolder.Factory();
    this.e = new HashMap();
  }
  
  public BaseAdapter(boolean paramBoolean)
  {
    this(null, false);
  }
  
  @NonNull
  public BaseViewHolder<? extends IBaseData> a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    BaseAdapter.BaseViewConfig localBaseViewConfig = (BaseAdapter.BaseViewConfig)this.e.get(Integer.valueOf(paramInt));
    Object localObject;
    if (this.b)
    {
      localObject = localBaseViewConfig.c;
      if ((!a) && (localObject == null)) {
        throw new AssertionError("ViewHolder未被注册");
      }
      paramViewGroup = this.c.a(localBaseViewConfig.a, paramViewGroup, (Class)localObject);
    }
    else
    {
      localObject = localBaseViewConfig.b;
      if ((!a) && (localObject == null)) {
        throw new AssertionError("ViewHolderFactory未注册");
      }
      localObject = ((BaseViewHolder.ViewHolderFactory)localObject).a(this.d, localBaseViewConfig.a, paramViewGroup);
      paramViewGroup = (ViewGroup)localObject;
      if (!a) {
        if (localObject != null) {
          paramViewGroup = (ViewGroup)localObject;
        } else {
          throw new AssertionError();
        }
      }
    }
    paramViewGroup.a(localBaseViewConfig.d);
    this.g.add(paramViewGroup);
    return paramViewGroup;
  }
  
  public void a()
  {
    Object localObject = this.g.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((BaseViewHolder)((Iterator)localObject).next()).a();
    }
    localObject = this.d;
    if (localObject != null) {
      ((ViewHolderContext)localObject).b();
    }
    this.g.clear();
  }
  
  public void a(@NonNull int paramInt, @NonNull BaseAdapter.BaseViewConfig paramBaseViewConfig)
  {
    this.e.put(Integer.valueOf(paramInt), paramBaseViewConfig);
  }
  
  public void a(IBaseDataSource paramIBaseDataSource)
  {
    this.f = paramIBaseDataSource;
  }
  
  public void a(@NonNull BaseViewHolder<? extends IBaseData> paramBaseViewHolder, int paramInt)
  {
    IBaseDataSource localIBaseDataSource = this.f;
    if (localIBaseDataSource != null) {
      paramBaseViewHolder.b(this.d, localIBaseDataSource.d(paramInt), paramInt);
    }
  }
  
  public int getItemCount()
  {
    IBaseDataSource localIBaseDataSource = this.f;
    if (localIBaseDataSource != null) {
      return localIBaseDataSource.a();
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((IBaseDataSource)localObject).c(paramInt));
      if (localObject != null) {
        return ((Integer)localObject).intValue();
      }
    }
    return 0;
  }
  
  public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof GridLayoutManager))
    {
      paramRecyclerView = (GridLayoutManager)paramRecyclerView;
      paramRecyclerView.setSpanSizeLookup(new BaseAdapter.1(this, paramRecyclerView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.BaseAdapter
 * JD-Core Version:    0.7.0.1
 */