package com.tencent.av.ui.effect.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.avatar2d.Avatar2dItem;
import com.tencent.av.business.manager.avatar2d.EffectAvatar2dManager;
import com.tencent.av.business.manager.material.EffectMaterialManager;
import com.tencent.av.ui.QavListItemBase;
import com.tencent.av.ui.QavListItemBase.IClickCallback;
import com.tencent.av.ui.QavListItemBase.IDownloadCallback;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.av.ui.effect.interfaces.IItemDownloadMgr;
import com.tencent.av.ui.effect.view.MaterialRecyclerView;
import com.tencent.av.ui.effect.view.QavEffectAvatar2dItemView;
import com.tencent.av.ui.effect.view.QavEffectMaterialItemView;
import com.tencent.av.ui.effect.view.QavVoiceChangeMaterialItemView;
import com.tencent.av.ui.effect.viewholder.MaterialViewHolder;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class MaterialAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements QavListItemBase.IDownloadCallback, Observer
{
  protected volatile int a = -1;
  protected int b = -1;
  boolean c = true;
  IItemDownloadMgr d;
  IEffectCallback e;
  long f = 0L;
  private final Context g;
  private AppInterface h;
  private Resources i;
  private EffectMaterialManager j;
  private MaterialRecyclerView k;
  private ArrayList<QavListItemBase.ItemInfo> l = new ArrayList();
  private int m;
  private boolean n;
  private final QavListItemBase.IClickCallback o = new MaterialAdapter.2(this);
  
  public MaterialAdapter(AppInterface paramAppInterface, Context paramContext, ArrayList<QavListItemBase.ItemInfo> paramArrayList, MaterialRecyclerView paramMaterialRecyclerView, int paramInt, boolean paramBoolean)
  {
    this.h = paramAppInterface;
    this.g = paramContext;
    this.i = this.g.getResources();
    this.k = paramMaterialRecyclerView;
    this.m = paramInt;
    this.j = ((EffectMaterialManager)((VideoAppInterface)this.h).c(15));
    this.n = paramBoolean;
    a(paramArrayList);
    this.k.setOnTouchListener(new MaterialAdapter.1(this));
  }
  
  protected void a(long paramLong, int paramInt)
  {
    if (paramInt >= 0)
    {
      if (this.l.size() <= paramInt) {
        return;
      }
      QavListItemBase.ItemInfo localItemInfo = (QavListItemBase.ItemInfo)this.l.get(paramInt);
      if ((!TextUtils.isEmpty(localItemInfo.a)) && (!localItemInfo.a.equals("0")))
      {
        if (localItemInfo.d)
        {
          a(paramLong, localItemInfo);
          return;
        }
        if ((!localItemInfo.e) && (!TextUtils.isEmpty(localItemInfo.a)))
        {
          IItemDownloadMgr localIItemDownloadMgr = this.d;
          if (localIItemDownloadMgr != null)
          {
            localIItemDownloadMgr.startDownloadTemplate(this.h, paramLong, localItemInfo, this);
            localItemInfo.e = true;
            return;
          }
          throw new IllegalArgumentException("mIItemDownloadMgr is null, please call setItemDownloadMgr");
        }
        return;
      }
      a(paramLong, localItemInfo);
    }
  }
  
  void a(long paramLong, QavListItemBase.ItemInfo paramItemInfo)
  {
    if (this.e == null) {
      return;
    }
    if ((TextUtils.isEmpty(paramItemInfo.a)) || (paramItemInfo.a.equals("0")) || (paramItemInfo.d)) {
      this.e.a(paramLong, paramItemInfo);
    }
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    b(paramLong, paramString, paramBoolean);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, QavListItemBase.ItemInfo paramItemInfo, int paramInt)
  {
    boolean bool1;
    if (!TextUtils.isEmpty(this.j.b()))
    {
      boolean bool2 = paramItemInfo.a.equals(this.j.b());
      bool1 = bool2;
      if (bool2)
      {
        this.a = paramInt;
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = false;
    }
    paramViewHolder = (QavListItemBase)paramViewHolder.itemView;
    if ((this.c) && (bool1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramViewHolder.a(paramInt, bool1, false, paramItemInfo, this.o);
  }
  
  public void a(IEffectCallback paramIEffectCallback)
  {
    this.e = paramIEffectCallback;
  }
  
  public void a(IItemDownloadMgr paramIItemDownloadMgr)
  {
    this.d = paramIItemDownloadMgr;
  }
  
  public void a(String paramString, int paramInt)
  {
    b(paramString, paramInt);
  }
  
  public void a(ArrayList<QavListItemBase.ItemInfo> paramArrayList)
  {
    this.l.clear();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      this.l.addAll(paramArrayList);
    }
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean a(String paramString)
  {
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equals(((QavListItemBase.ItemInfo)localIterator.next()).a)) {
        return true;
      }
    }
    return false;
  }
  
  public void b(long paramLong, String paramString, boolean paramBoolean)
  {
    this.k.post(new MaterialAdapter.3(this, paramString, paramBoolean, paramLong));
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder, QavListItemBase.ItemInfo paramItemInfo, int paramInt)
  {
    Avatar2dItem localAvatar2dItem = (Avatar2dItem)((EffectAvatar2dManager)((VideoAppInterface)this.h).c(16)).c();
    boolean bool2;
    if (paramItemInfo.f == 7)
    {
      if (localAvatar2dItem == null)
      {
        this.a = 0;
        if (paramInt == 0)
        {
          bool1 = true;
          break label187;
        }
      }
      else if (!TextUtils.isEmpty(this.j.f()))
      {
        bool2 = ((QavListItemBase.ItemInfo)this.l.get(paramInt)).a.equals(this.j.f());
        bool1 = bool2;
        if (!bool2) {
          break label187;
        }
        this.a = paramInt;
        bool1 = bool2;
        break label187;
      }
    }
    else if ((paramItemInfo.f == 6) && (!TextUtils.isEmpty(this.j.e())))
    {
      bool2 = ((QavListItemBase.ItemInfo)this.l.get(paramInt)).a.equals(this.j.e());
      bool1 = bool2;
      if (!bool2) {
        break label187;
      }
      this.a = paramInt;
      bool1 = bool2;
      break label187;
    }
    boolean bool1 = false;
    label187:
    paramViewHolder = (QavListItemBase)paramViewHolder.itemView;
    if ((this.c) && (bool1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramViewHolder.a(paramInt, bool1, false, paramItemInfo, this.o);
  }
  
  public void b(String paramString, int paramInt)
  {
    d(paramString, paramInt);
  }
  
  public void c(RecyclerView.ViewHolder paramViewHolder, QavListItemBase.ItemInfo paramItemInfo, int paramInt)
  {
    boolean bool1;
    if (!TextUtils.isEmpty(this.j.d()))
    {
      boolean bool2 = ((QavListItemBase.ItemInfo)this.l.get(paramInt)).a.equals(this.j.d());
      bool1 = bool2;
      if (bool2)
      {
        this.a = paramInt;
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = false;
    }
    paramViewHolder = (QavListItemBase)paramViewHolder.itemView;
    if ((this.c) && (bool1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramViewHolder.a(paramInt, bool1, false, paramItemInfo, this.o);
  }
  
  void c(String paramString, int paramInt)
  {
    int i4 = ((GridLayoutManager)this.k.getLayoutManager()).findFirstVisibleItemPosition();
    int i6 = ((GridLayoutManager)this.k.getLayoutManager()).findLastVisibleItemPosition();
    int i1 = i4;
    Object localObject2;
    for (;;)
    {
      localObject2 = null;
      if (i1 > i6) {
        break;
      }
      if (i1 >= 0)
      {
        if (i1 >= this.l.size()) {
          break;
        }
        localObject3 = (QavListItemBase.ItemInfo)this.l.get(i1);
        if ((localObject3 != null) && (((QavListItemBase.ItemInfo)localObject3).a.equals(paramString)))
        {
          View localView = this.k.getChildAt(i1 - i4);
          localObject4 = localObject2;
          localObject1 = localObject3;
          if (!(localView instanceof QavListItemBase)) {
            break label178;
          }
          localObject4 = localObject2;
          localObject1 = localObject3;
          if (!this.k.getAdapter().equals(this)) {
            break label178;
          }
          localObject4 = (QavListItemBase)localView;
          localObject1 = localObject3;
          break label178;
        }
      }
      i1 += 1;
    }
    Object localObject1 = null;
    Object localObject4 = localObject2;
    label178:
    int i3 = i1;
    Object localObject3 = localObject1;
    if (localObject1 == null)
    {
      i3 = i1;
      localObject3 = localObject1;
      if (paramInt == 101)
      {
        int i5 = this.l.size();
        i3 = 0;
        int i2;
        for (;;)
        {
          i2 = i1;
          localObject2 = localObject1;
          if (i3 >= i4) {
            break;
          }
          i2 = i1;
          localObject2 = localObject1;
          if (i3 >= i5) {
            break;
          }
          localObject2 = (QavListItemBase.ItemInfo)this.l.get(i3);
          if ((localObject2 != null) && (((QavListItemBase.ItemInfo)localObject2).a.equals(paramString)))
          {
            i2 = i3;
            break;
          }
          i3 += 1;
        }
        i3 = i2;
        localObject3 = localObject2;
        if (localObject2 == null)
        {
          i1 = i6 + 1;
          for (;;)
          {
            i3 = i2;
            localObject3 = localObject2;
            if (i1 >= i5) {
              break;
            }
            localObject3 = (QavListItemBase.ItemInfo)this.l.get(i1);
            if ((localObject3 != null) && (((QavListItemBase.ItemInfo)localObject3).a.equals(paramString)))
            {
              i3 = i1;
              break;
            }
            i1 += 1;
          }
        }
      }
    }
    if (localObject3 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateManager", 2, String.format("onProgressUpdate, index[%s], [%s][%s], progress[%s]", new Object[] { Integer.valueOf(i3), ((QavListItemBase.ItemInfo)localObject3).a, ((QavListItemBase.ItemInfo)localObject3).c, Integer.valueOf(paramInt) }));
      }
      if (paramInt == -1)
      {
        ((QavListItemBase.ItemInfo)localObject3).e = false;
      }
      else if (paramInt == 101)
      {
        ((QavListItemBase.ItemInfo)localObject3).e = false;
        ((QavListItemBase.ItemInfo)localObject3).d = true;
      }
      else
      {
        i1 = paramInt;
        if (paramInt == 100) {
          i1 = 99;
        }
        ((QavListItemBase.ItemInfo)localObject3).e = true;
        paramInt = i1;
      }
      if (localObject4 != null) {
        ((QavListItemBase)localObject4).a(paramInt);
      }
    }
  }
  
  public void d(RecyclerView.ViewHolder paramViewHolder, QavListItemBase.ItemInfo paramItemInfo, int paramInt)
  {
    boolean bool1;
    if (!TextUtils.isEmpty(this.j.g()))
    {
      boolean bool2 = ((QavListItemBase.ItemInfo)this.l.get(paramInt)).a.equals(this.j.g());
      bool1 = bool2;
      if (bool2)
      {
        this.a = paramInt;
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = false;
    }
    paramViewHolder = (QavListItemBase)paramViewHolder.itemView;
    if ((this.c) && (bool1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramViewHolder.a(paramInt, bool1, false, paramItemInfo, this.o);
  }
  
  public void d(String paramString, int paramInt)
  {
    ThreadManager.getUIHandler().post(new MaterialAdapter.4(this, paramString, paramInt));
  }
  
  public void e(RecyclerView.ViewHolder paramViewHolder, QavListItemBase.ItemInfo paramItemInfo, int paramInt)
  {
    boolean bool1;
    if (!TextUtils.isEmpty(this.j.h()))
    {
      boolean bool2 = ((QavListItemBase.ItemInfo)this.l.get(paramInt)).a.equals(this.j.h());
      bool1 = bool2;
      if (bool2)
      {
        this.a = paramInt;
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = false;
    }
    paramViewHolder = (QavListItemBase)paramViewHolder.itemView;
    if ((this.c) && (bool1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramViewHolder.a(paramInt, bool1, false, paramItemInfo, this.o);
  }
  
  public void f(RecyclerView.ViewHolder paramViewHolder, QavListItemBase.ItemInfo paramItemInfo, int paramInt)
  {
    boolean bool1;
    if (!TextUtils.isEmpty(this.j.i()))
    {
      boolean bool2 = ((QavListItemBase.ItemInfo)this.l.get(paramInt)).a.equals(this.j.i());
      bool1 = bool2;
      if (bool2)
      {
        this.a = paramInt;
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = false;
    }
    paramViewHolder = (QavListItemBase)paramViewHolder.itemView;
    if ((this.c) && (bool1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramViewHolder.a(paramInt, bool1, false, paramItemInfo, this.o);
  }
  
  public int getItemCount()
  {
    ArrayList localArrayList = this.l;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (((QavListItemBase.ItemInfo)this.l.get(paramInt)).f == 2) {
      return 1;
    }
    if (((QavListItemBase.ItemInfo)this.l.get(paramInt)).f != 6)
    {
      if (((QavListItemBase.ItemInfo)this.l.get(paramInt)).f == 7) {
        return 2;
      }
      return 0;
    }
    return 2;
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 2)
    {
      if ((this.m == 1) && (this.n)) {
        a((ArrayList)this.j.c());
      }
    }
    else if (paramInt == 1)
    {
      if (this.m == 1) {
        notifyDataSetChanged();
      }
    }
    else if (paramInt == 3)
    {
      if ((this.m == 6) && (((QavListItemBase.ItemInfo)this.l.get(0)).f == 6))
      {
        this.j.d("0");
        notifyDataSetChanged();
      }
    }
    else if (paramInt == 4)
    {
      if (this.m == 202) {
        notifyDataSetChanged();
      }
    }
    else if (paramInt == 5)
    {
      if (this.m == 6) {
        notifyDataSetChanged();
      }
    }
    else if (paramInt == 6)
    {
      if (this.m == 3) {
        notifyDataSetChanged();
      }
    }
    else if (paramInt == 7)
    {
      if (this.m == 4) {
        notifyDataSetChanged();
      }
    }
    else if ((paramInt == 8) && (this.m == 5)) {
      notifyDataSetChanged();
    }
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    QavListItemBase.ItemInfo localItemInfo = (QavListItemBase.ItemInfo)this.l.get(paramInt);
    if (localItemInfo == null) {
      QLog.e("MaterialAdapter", 1, "onBindViewHolder: itemInfo == null");
    }
    int i1 = this.m;
    if (i1 != 1)
    {
      if (i1 != 3)
      {
        if (i1 != 4)
        {
          if (i1 != 5)
          {
            if (i1 != 6)
            {
              switch (i1)
              {
              default: 
                return;
              case 202: 
                c(paramViewHolder, localItemInfo, paramInt);
                return;
              }
              ((QavListItemBase)paramViewHolder.itemView).a(paramInt, false, false, localItemInfo, this.o);
              return;
            }
            b(paramViewHolder, localItemInfo, paramInt);
            return;
          }
          f(paramViewHolder, localItemInfo, paramInt);
          return;
        }
        e(paramViewHolder, localItemInfo, paramInt);
        return;
      }
      d(paramViewHolder, localItemInfo, paramInt);
      return;
    }
    a(paramViewHolder, localItemInfo, paramInt);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1)
    {
      paramViewGroup = new QavVoiceChangeMaterialItemView(this.g);
      paramViewGroup.a(0, 0);
    }
    else if (paramInt == 2)
    {
      paramViewGroup = new QavEffectAvatar2dItemView(this.g);
      paramViewGroup.a(0, 0);
    }
    else
    {
      paramViewGroup = new QavEffectMaterialItemView(this.g);
      paramViewGroup.a(0, 0);
    }
    return new MaterialViewHolder(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.adapter.MaterialAdapter
 * JD-Core Version:    0.7.0.1
 */