package com.tencent.mobileqq.activity.aio.coreui.pluspanel;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.activity.aio.pluspanel.PluginData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.PanelRecycleBin;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.List;

public class PanelAdapter
  extends PagerAdapter
{
  public boolean a = false;
  private ArrayList<PluginData> b = new ArrayList();
  private ViewGroup c;
  private View.OnLongClickListener d;
  private View.OnClickListener e;
  private int f = 4;
  private int g = 2;
  private PanelRecycleBin h = new PanelRecycleBin();
  private Context i;
  private QQAppInterface j;
  private boolean k;
  private boolean l;
  
  PanelAdapter(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.i = paramContext;
    this.j = paramQQAppInterface;
  }
  
  private int a(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView.getTag() instanceof PanelAdapter.PageData)) {
      return PanelAdapter.PageData.b((PanelAdapter.PageData)paramRecyclerView.getTag());
    }
    return 0;
  }
  
  private void a(int paramInt, RecyclerView paramRecyclerView)
  {
    int m = ViewUtils.dpToPx(20.0F);
    paramRecyclerView.setPadding(m, 0, m, 0);
    a(paramRecyclerView, paramInt);
    List localList = a(paramInt);
    Object localObject = paramRecyclerView.getAdapter();
    if ((localObject instanceof PlusPanelAppListAdapter))
    {
      localObject = (PlusPanelAppListAdapter)localObject;
      ((PlusPanelAppListAdapter)localObject).a(localList);
      try
      {
        paramRecyclerView.post(new PanelAdapter.2(this, (PlusPanelAppListAdapter)localObject));
        return;
      }
      catch (Exception paramRecyclerView)
      {
        QLog.e("PanelIconAdapter", 1, paramRecyclerView.getMessage());
        return;
      }
    }
    localObject = new PlusPanelAppListAdapter(this.j, this.e, this.d);
    ((PlusPanelAppListAdapter)localObject).a(this.k);
    ((PlusPanelAppListAdapter)localObject).b(this.l);
    ((PlusPanelAppListAdapter)localObject).a(localList);
    paramRecyclerView.setAdapter((RecyclerView.Adapter)localObject);
  }
  
  private void a(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramRecyclerView.getTag() instanceof PanelAdapter.PageData))
    {
      paramRecyclerView.setTag(new PanelAdapter.PageData(paramInt, PanelAdapter.PageData.a((PanelAdapter.PageData)paramRecyclerView.getTag()), null));
      return;
    }
    paramRecyclerView.setTag(new PanelAdapter.PageData(paramInt, 0, null));
  }
  
  private void b(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView.getTag() instanceof PanelAdapter.PageData)) {
      paramRecyclerView.setTag(new PanelAdapter.PageData(PanelAdapter.PageData.b((PanelAdapter.PageData)paramRecyclerView.getTag()), XPanelContainer.d, null));
    } else {
      paramRecyclerView.setTag(new PanelAdapter.PageData(0, XPanelContainer.d, null));
    }
    QLog.d("PanelIconAdapter", 1, new Object[] { "updateRecyclerViewAddedHeight -> XPanelContainer.mExternalPanelheight : ", Integer.valueOf(XPanelContainer.a), ", XPanelContainer.mDefaultExternalPanelheight : ", Integer.valueOf(XPanelContainer.b), ", XPanelContainer.mAddedHeight -> ", Integer.valueOf(XPanelContainer.d) });
  }
  
  private int c(RecyclerView paramRecyclerView)
  {
    if ((paramRecyclerView.getTag() instanceof PanelAdapter.PageData)) {
      return PanelAdapter.PageData.a((PanelAdapter.PageData)paramRecyclerView.getTag());
    }
    return 0;
  }
  
  public int a()
  {
    return this.f;
  }
  
  List<PluginData> a(int paramInt)
  {
    int m = this.f * this.g;
    paramInt *= m;
    ArrayList localArrayList = this.b;
    if ((localArrayList != null) && (localArrayList.size() > 0) && (paramInt >= 0) && (paramInt < this.b.size()))
    {
      m = Math.min(this.b.size(), m + paramInt);
      return this.b.subList(paramInt, m);
    }
    return new ArrayList(0);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.e = paramOnClickListener;
  }
  
  public void a(View.OnLongClickListener paramOnLongClickListener)
  {
    this.d = paramOnLongClickListener;
  }
  
  public void a(ArrayList<PluginData> paramArrayList)
  {
    this.b = paramArrayList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    if (this.c == null) {
      return;
    }
    if (paramInt >= 0)
    {
      int m = 0;
      while (m < this.c.getChildCount())
      {
        RecyclerView localRecyclerView = (RecyclerView)this.c.getChildAt(m);
        if ((localRecyclerView != null) && (paramInt == a(localRecyclerView)))
        {
          a(paramInt, localRecyclerView);
          return;
        }
        m += 1;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    RecyclerView localRecyclerView = (RecyclerView)paramObject;
    ((ViewGroup)paramView).removeView(localRecyclerView);
    this.h.addScrapView((View)paramObject);
  }
  
  public int getCount()
  {
    if ((this.f != 0) && (this.g != 0))
    {
      ArrayList localArrayList = this.b;
      if (localArrayList != null)
      {
        int m = localArrayList.size();
        int n = this.f;
        int i1 = this.g;
        return (m + n * i1 - 1) / (n * i1);
      }
    }
    return 0;
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (this.a) {
      return -2;
    }
    if (((paramObject instanceof RecyclerView)) && (a((RecyclerView)paramObject) >= getCount())) {
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("instantiateItem ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("PanelIconAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = (RecyclerView)this.h.getScrapView();
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      int m = c((RecyclerView)localObject2);
      QLog.d("PanelIconAdapter", 1, new Object[] { "reuseViewAddedHeight -> ", Integer.valueOf(m), ", XPanelContainer.mAddedHeight -> ", Integer.valueOf(XPanelContainer.d), ", XPanelContainer.mDefaultExternalPanelheight: ", Integer.valueOf(XPanelContainer.b), ", XPanelContainer.mExternalPanelheight: ", Integer.valueOf(XPanelContainer.a) });
      localObject1 = localObject2;
      if (m != XPanelContainer.d)
      {
        this.h.clearScrapViews();
        localObject1 = null;
      }
    }
    ViewGroup localViewGroup = (ViewGroup)paramView;
    this.c = localViewGroup;
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new RecyclerView(this.i, null);
      b((RecyclerView)localObject2);
      ((RecyclerView)localObject2).setOverScrollMode(2);
      ((RecyclerView)localObject2).setLayoutManager(new PanelAdapter.1(this, this.i, a()));
    }
    a(paramInt, (RecyclerView)localObject2);
    if ((((RecyclerView)localObject2).getParent() != paramView) && (paramInt < getCount())) {
      localViewGroup.addView((View)localObject2);
    }
    return localObject2;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.pluspanel.PanelAdapter
 * JD-Core Version:    0.7.0.1
 */