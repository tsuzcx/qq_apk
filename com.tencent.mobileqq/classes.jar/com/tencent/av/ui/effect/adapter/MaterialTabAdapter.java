package com.tencent.av.ui.effect.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.material.EffectMaterialManager;
import com.tencent.av.ui.effect.data.MaterialCategory;
import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.av.ui.effect.interfaces.IItemDownloadMgr;
import com.tencent.av.ui.effect.view.Avatar2DRecyclerView;
import com.tencent.av.ui.effect.view.MaterialRecyclerView;
import com.tencent.common.app.AppInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MaterialTabAdapter
  extends PagerAdapter
{
  public HashMap<Integer, MaterialRecyclerView> a = new HashMap();
  private AppInterface b;
  private Context c;
  private EffectMaterialManager d;
  private int e;
  private List<MaterialCategory> f;
  private IItemDownloadMgr g;
  private int h;
  private IEffectCallback i;
  
  public MaterialTabAdapter(Context paramContext, AppInterface paramAppInterface, int paramInt)
  {
    this.c = paramContext;
    this.b = paramAppInterface;
    this.e = paramInt;
    this.d = ((EffectMaterialManager)((VideoAppInterface)this.b).c(15));
  }
  
  private int a(int paramInt, String paramString)
  {
    if (paramInt != 2) {
      return paramInt;
    }
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1677668250: 
      if (paramString.equals("900003")) {
        j = 1;
      }
      break;
    case 1677668249: 
      if (paramString.equals("900002")) {
        j = 0;
      }
      break;
    case 1677668248: 
      if (paramString.equals("900001")) {
        j = 2;
      }
      break;
    }
    int j = -1;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2) {
          return paramInt;
        }
        return 203;
      }
      return 202;
    }
    return 201;
  }
  
  private MaterialRecyclerView a()
  {
    if (this.e == 6) {
      return new Avatar2DRecyclerView(this.c);
    }
    return new MaterialRecyclerView(this.c);
  }
  
  private void a(MaterialAdapter paramMaterialAdapter)
  {
    if (this.e == 1) {
      this.d.a(paramMaterialAdapter);
    }
  }
  
  private void a(MaterialAdapter paramMaterialAdapter, int paramInt, String paramString)
  {
    if (a(this.e, paramString) == 1)
    {
      this.d.a(paramMaterialAdapter, 1);
      if (paramInt == 0) {
        this.d.a(paramMaterialAdapter, 2);
      }
    }
    else
    {
      if (a(this.e, paramString) == 202)
      {
        this.d.a(paramMaterialAdapter, 4);
        return;
      }
      if (a(this.e, paramString) == 6)
      {
        this.d.a(paramMaterialAdapter, 3);
        this.d.a(paramMaterialAdapter, 5);
        return;
      }
      if (a(this.e, paramString) == 3)
      {
        this.d.a(paramMaterialAdapter, 6);
        return;
      }
      if (a(this.e, paramString) == 4)
      {
        this.d.a(paramMaterialAdapter, 7);
        return;
      }
      if (a(this.e, paramString) == 5) {
        this.d.a(paramMaterialAdapter, 8);
      }
    }
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext())
    {
      MaterialAdapter localMaterialAdapter = (MaterialAdapter)((MaterialRecyclerView)localIterator.next()).getAdapter();
      if ((localMaterialAdapter != null) && (localMaterialAdapter.a(paramString))) {
        localMaterialAdapter.a(paramLong, paramString, paramBoolean);
      }
    }
  }
  
  public void a(IEffectCallback paramIEffectCallback)
  {
    this.i = paramIEffectCallback;
  }
  
  public void a(IItemDownloadMgr paramIItemDownloadMgr)
  {
    this.g = paramIItemDownloadMgr;
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = (MaterialRecyclerView)this.a.get(Integer.valueOf(this.h));
    if (localObject != null)
    {
      localObject = (MaterialAdapter)((MaterialRecyclerView)localObject).getAdapter();
      if ((localObject != null) && (((MaterialAdapter)localObject).a(paramString))) {
        ((MaterialAdapter)localObject).a(paramString, paramInt);
      }
    }
  }
  
  public void a(List<MaterialCategory> paramList)
  {
    this.f = paramList;
  }
  
  public void destroyItem(@NonNull ViewGroup paramViewGroup, int paramInt, @NonNull Object paramObject)
  {
    paramObject = (MaterialRecyclerView)this.a.get(Integer.valueOf(paramInt));
    if (paramObject != null)
    {
      a((MaterialAdapter)paramObject.getAdapter());
      paramViewGroup.removeView((View)this.a.get(Integer.valueOf(paramInt)));
    }
  }
  
  public int getCount()
  {
    List localList = this.f;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object instantiateItem(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    MaterialRecyclerView localMaterialRecyclerView = (MaterialRecyclerView)this.a.get(Integer.valueOf(paramInt));
    Object localObject;
    if (localMaterialRecyclerView == null)
    {
      localMaterialRecyclerView = a();
      localObject = this.b;
      Context localContext = this.c;
      ArrayList localArrayList = (ArrayList)((MaterialCategory)this.f.get(paramInt)).d;
      int j = a(this.e, ((MaterialCategory)this.f.get(paramInt)).a);
      boolean bool;
      if ((paramInt == 0) && (this.d.b(this.e))) {
        bool = true;
      } else {
        bool = false;
      }
      localObject = new MaterialAdapter((AppInterface)localObject, localContext, localArrayList, localMaterialRecyclerView, j, bool);
      this.a.put(Integer.valueOf(paramInt), localMaterialRecyclerView);
    }
    else
    {
      localObject = (MaterialAdapter)localMaterialRecyclerView.getAdapter();
      ((MaterialAdapter)localObject).a((ArrayList)((MaterialCategory)this.f.get(paramInt)).d);
    }
    a((MaterialAdapter)localObject, paramInt, ((MaterialCategory)this.f.get(paramInt)).a);
    ((MaterialAdapter)localObject).a(this.g);
    ((MaterialAdapter)localObject).a(this.i);
    ((MaterialAdapter)localObject).a(((MaterialCategory)this.f.get(paramInt)).c);
    localMaterialRecyclerView.setAdapter((RecyclerView.Adapter)localObject);
    paramViewGroup.addView(localMaterialRecyclerView);
    return localMaterialRecyclerView;
  }
  
  public boolean isViewFromObject(@NonNull View paramView, @NonNull Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void setPrimaryItem(@NonNull ViewGroup paramViewGroup, int paramInt, @NonNull Object paramObject)
  {
    super.setPrimaryItem(paramViewGroup, paramInt, paramObject);
    this.h = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.adapter.MaterialTabAdapter
 * JD-Core Version:    0.7.0.1
 */