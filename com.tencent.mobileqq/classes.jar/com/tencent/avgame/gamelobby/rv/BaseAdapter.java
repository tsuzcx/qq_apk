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
  private IBaseDataSource jdField_a_of_type_ComTencentAvgameGamelobbyDataIBaseDataSource = null;
  private BaseViewHolder.Factory jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseViewHolder$Factory;
  private ViewHolderContext jdField_a_of_type_ComTencentAvgameGamelobbyRvViewHolderContext;
  private HashMap<Integer, BaseAdapter.BaseViewConfig> jdField_a_of_type_JavaUtilHashMap;
  private List<BaseViewHolder> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean b = false;
  
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
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvViewHolderContext = paramViewHolderContext;
    this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseViewHolder$Factory = new BaseViewHolder.Factory();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public BaseAdapter(boolean paramBoolean)
  {
    this(null, false);
  }
  
  @NonNull
  public BaseViewHolder<? extends IBaseData> a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    BaseAdapter.BaseViewConfig localBaseViewConfig = (BaseAdapter.BaseViewConfig)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    Object localObject;
    if (this.b)
    {
      localObject = localBaseViewConfig.jdField_a_of_type_JavaLangClass;
      if ((!jdField_a_of_type_Boolean) && (localObject == null)) {
        throw new AssertionError("ViewHolder未被注册");
      }
      paramViewGroup = this.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseViewHolder$Factory.a(localBaseViewConfig.jdField_a_of_type_Int, paramViewGroup, (Class)localObject);
    }
    else
    {
      localObject = localBaseViewConfig.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseViewHolder$ViewHolderFactory;
      if ((!jdField_a_of_type_Boolean) && (localObject == null)) {
        throw new AssertionError("ViewHolderFactory未注册");
      }
      localObject = ((BaseViewHolder.ViewHolderFactory)localObject).a(this.jdField_a_of_type_ComTencentAvgameGamelobbyRvViewHolderContext, localBaseViewConfig.jdField_a_of_type_Int, paramViewGroup);
      paramViewGroup = (ViewGroup)localObject;
      if (!jdField_a_of_type_Boolean) {
        if (localObject != null) {
          paramViewGroup = (ViewGroup)localObject;
        } else {
          throw new AssertionError();
        }
      }
    }
    paramViewGroup.a(localBaseViewConfig.jdField_a_of_type_ComTencentAvgameGamelobbyRvBaseViewHolder$OnClickListener);
    this.jdField_a_of_type_JavaUtilList.add(paramViewGroup);
    return paramViewGroup;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((BaseViewHolder)((Iterator)localObject).next()).a();
    }
    localObject = this.jdField_a_of_type_ComTencentAvgameGamelobbyRvViewHolderContext;
    if (localObject != null) {
      ((ViewHolderContext)localObject).a();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(@NonNull int paramInt, @NonNull BaseAdapter.BaseViewConfig paramBaseViewConfig)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramBaseViewConfig);
  }
  
  public void a(IBaseDataSource paramIBaseDataSource)
  {
    this.jdField_a_of_type_ComTencentAvgameGamelobbyDataIBaseDataSource = paramIBaseDataSource;
  }
  
  public void a(@NonNull BaseViewHolder<? extends IBaseData> paramBaseViewHolder, int paramInt)
  {
    IBaseDataSource localIBaseDataSource = this.jdField_a_of_type_ComTencentAvgameGamelobbyDataIBaseDataSource;
    if (localIBaseDataSource != null) {
      paramBaseViewHolder.b(this.jdField_a_of_type_ComTencentAvgameGamelobbyRvViewHolderContext, localIBaseDataSource.b(paramInt), paramInt);
    }
  }
  
  public int getItemCount()
  {
    IBaseDataSource localIBaseDataSource = this.jdField_a_of_type_ComTencentAvgameGamelobbyDataIBaseDataSource;
    if (localIBaseDataSource != null) {
      return localIBaseDataSource.a();
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvgameGamelobbyDataIBaseDataSource;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((IBaseDataSource)localObject).a(paramInt));
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