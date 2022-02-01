package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.avatar2d.EffectAvatar2dManager;
import com.tencent.av.business.manager.material.EffectMaterialManager;
import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.av.ui.effect.interfaces.IItemDownloadMgr;
import com.tencent.av.utils.AudioHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class QAVPtvTemplateAdapter
  extends BaseAdapter
{
  public static int c;
  public static int d;
  public static int e;
  public ArrayList<QavListItemBase.ItemInfo> a = new ArrayList();
  public Context b;
  boolean f = false;
  HorizontalListView g;
  boolean h = true;
  AppInterface i;
  protected volatile int j = -1;
  protected int k = -1;
  IEffectCallback l;
  IItemDownloadMgr m;
  public boolean n = false;
  float o = 6.25F;
  long p = 0L;
  private Resources q;
  private View r = null;
  private QavListItemBase.IClickCallback s = new QAVPtvTemplateAdapter.4(this);
  private QavListItemBase.IDownloadCallback t = new QAVPtvTemplateAdapter.5(this);
  
  public QAVPtvTemplateAdapter(AppInterface paramAppInterface, Context paramContext, ArrayList<QavListItemBase.ItemInfo> paramArrayList, HorizontalListView paramHorizontalListView)
  {
    this(paramAppInterface, paramContext, paramArrayList, paramHorizontalListView, 6.25F);
  }
  
  public QAVPtvTemplateAdapter(AppInterface paramAppInterface, Context paramContext, ArrayList<QavListItemBase.ItemInfo> paramArrayList, HorizontalListView paramHorizontalListView, float paramFloat)
  {
    this.i = paramAppInterface;
    this.b = paramContext;
    this.q = this.b.getResources();
    this.g = paramHorizontalListView;
    this.o = paramFloat;
    a(paramArrayList);
    c = a(this.q, a());
    d = a(this.q, a(), 0.1666667F);
    e = c + AIOUtils.b(30.0F, this.q);
    if (this.o < 6.0F) {
      e = this.q.getDimensionPixelSize(2131298327);
    }
    if (QLog.isDevelopLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("init, w[");
      paramAppInterface.append(c);
      paramAppInterface.append("], h[");
      paramAppInterface.append(e);
      paramAppInterface.append("], half[");
      paramAppInterface.append(d);
      paramAppInterface.append("]");
      QLog.i("QAVPtvTemplateAdapter", 4, paramAppInterface.toString());
    }
    this.g.addOnLayoutChangeListener(new QAVPtvTemplateAdapter.1(this));
    this.g.setOnScrollStateChangedListener(new QAVPtvTemplateAdapter.2(this));
    paramAppInterface = this.g.getLayoutParams();
    paramAppInterface.width = -1;
    paramAppInterface.height = e;
    this.g.setLayoutParams(paramAppInterface);
  }
  
  public static int a(Resources paramResources, float paramFloat)
  {
    return (int)(paramResources.getDisplayMetrics().widthPixels / paramFloat + 0.5F);
  }
  
  public static int a(Resources paramResources, float paramFloat1, float paramFloat2)
  {
    return (int)(paramResources.getDisplayMetrics().widthPixels / paramFloat1 * paramFloat2 + 0.5F);
  }
  
  public float a()
  {
    return this.o;
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (this.f)
    {
      View localView1 = this.g.getChild(paramInt1);
      View localView2 = this.g.getChild(paramInt2);
      if ((paramInt2 != paramInt1) && (localView1 != null) && ((localView1 instanceof QavListItemBase))) {
        ((QavListItemBase)localView1).setHighlight(false);
      }
      if ((localView2 != null) && ((localView2 instanceof QavListItemBase))) {
        ((QavListItemBase)localView2).setHighlight(true);
      }
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (paramInt >= 0)
    {
      if (this.a.size() <= paramInt) {
        return;
      }
      QavListItemBase.ItemInfo localItemInfo = (QavListItemBase.ItemInfo)this.a.get(paramInt);
      if (!TextUtils.isEmpty(localItemInfo.a))
      {
        if (localItemInfo.a.equals("0")) {
          return;
        }
        if ((!localItemInfo.d) && (!localItemInfo.e) && (!TextUtils.isEmpty(localItemInfo.a)))
        {
          IItemDownloadMgr localIItemDownloadMgr = this.m;
          if (localIItemDownloadMgr != null)
          {
            localIItemDownloadMgr.startDownloadTemplate(this.i, paramLong, localItemInfo, this.t);
            localItemInfo.e = true;
            return;
          }
          throw new IllegalArgumentException("mIItemDownloadMgr is null, pealse call setItemDownloadMgr");
        }
      }
    }
  }
  
  void a(long paramLong, QavListItemBase.ItemInfo paramItemInfo)
  {
    if (this.l == null) {
      return;
    }
    if ((TextUtils.isEmpty(paramItemInfo.a)) || (paramItemInfo.a.equals("0")) || (paramItemInfo.d)) {
      this.l.a(paramLong, paramItemInfo);
    }
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    this.g.post(new QAVPtvTemplateAdapter.6(this, paramString, paramBoolean, paramLong));
  }
  
  void a(View paramView, QavListItemBase.ItemInfo paramItemInfo, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    paramView = paramView.findViewById(2131441060);
    if ((paramView != null) && (paramItemInfo != null))
    {
      paramView.setContentDescription(paramItemInfo.k);
      ViewCompat.setAccessibilityDelegate(paramView, new QAVPtvTemplateAdapter.3(this, paramInt));
    }
  }
  
  public void a(IEffectCallback paramIEffectCallback)
  {
    this.l = paramIEffectCallback;
  }
  
  public void a(IItemDownloadMgr paramIItemDownloadMgr)
  {
    this.m = paramIItemDownloadMgr;
  }
  
  public void a(String paramString, int paramInt)
  {
    c(paramString, paramInt);
  }
  
  public void a(ArrayList<QavListItemBase.ItemInfo> paramArrayList)
  {
    this.a.clear();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      this.a.addAll(paramArrayList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean a(int paramInt)
  {
    int i1 = this.j;
    int i2 = this.a.size();
    boolean bool;
    if ((this.j != paramInt) && (paramInt >= 0) && (paramInt < i2))
    {
      this.j = paramInt;
      notifyDataSetChanged();
      bool = true;
    }
    else
    {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSelectedIndex, ret[");
    localStringBuilder.append(bool);
    localStringBuilder.append("], index[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], mCurSelectedPosition[");
    localStringBuilder.append(i1);
    localStringBuilder.append("->");
    localStringBuilder.append(this.j);
    localStringBuilder.append("], size[");
    localStringBuilder.append(i2);
    localStringBuilder.append("]");
    QLog.w("QAVPtvTemplateAdapter", 1, localStringBuilder.toString());
    return bool;
  }
  
  public QavListItemBase.ItemInfo b()
  {
    int i1 = this.k;
    if ((i1 >= 0) && (i1 < this.a.size())) {
      return (QavListItemBase.ItemInfo)this.a.get(this.k);
    }
    return null;
  }
  
  public QavListItemBase.ItemInfo b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (QavListItemBase.ItemInfo)this.a.get(paramInt);
    }
    return null;
  }
  
  protected void b(long paramLong, int paramInt)
  {
    if (paramInt >= 0)
    {
      if (this.a.size() <= paramInt) {
        return;
      }
      QavListItemBase.ItemInfo localItemInfo = (QavListItemBase.ItemInfo)this.a.get(paramInt);
      if ((!TextUtils.isEmpty(localItemInfo.a)) && (!localItemInfo.a.equals("0")))
      {
        if (localItemInfo.d)
        {
          a(paramLong, localItemInfo);
          return;
        }
        if ((!localItemInfo.e) && (!TextUtils.isEmpty(localItemInfo.a)))
        {
          IItemDownloadMgr localIItemDownloadMgr = this.m;
          if (localIItemDownloadMgr != null)
          {
            localIItemDownloadMgr.startDownloadTemplate(this.i, paramLong, localItemInfo, this.t);
            localItemInfo.e = true;
            return;
          }
          throw new IllegalArgumentException("mIItemDownloadMgr is null, pealse call setItemDownloadMgr");
        }
        return;
      }
      a(paramLong, localItemInfo);
    }
  }
  
  void b(String paramString, int paramInt)
  {
    int i4 = this.g.getFirstVisiblePosition();
    int i6 = this.g.getLastVisiblePosition();
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
        if (i1 >= this.a.size()) {
          break;
        }
        localObject3 = (QavListItemBase.ItemInfo)this.a.get(i1);
        if ((localObject3 != null) && (((QavListItemBase.ItemInfo)localObject3).a.equals(paramString)))
        {
          View localView = this.g.getChildAt(i1 - i4);
          localObject4 = localObject2;
          localObject1 = localObject3;
          if (!(localView instanceof QavListItemBase)) {
            break label160;
          }
          localObject4 = localObject2;
          localObject1 = localObject3;
          if (!this.g.getAdapter().equals(this)) {
            break label160;
          }
          localObject4 = (QavListItemBase)localView;
          localObject1 = localObject3;
          break label160;
        }
      }
      i1 += 1;
    }
    Object localObject1 = null;
    Object localObject4 = localObject2;
    label160:
    int i3 = i1;
    Object localObject3 = localObject1;
    if (localObject1 == null)
    {
      i3 = i1;
      localObject3 = localObject1;
      if (paramInt == 101)
      {
        int i5 = this.a.size();
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
          localObject2 = (QavListItemBase.ItemInfo)this.a.get(i3);
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
            localObject3 = (QavListItemBase.ItemInfo)this.a.get(i1);
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
  
  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  void c(int paramInt)
  {
    if (this.g.getFirstVisiblePosition() >= paramInt)
    {
      this.g.smoothScrollToPositionFromLeftOrRight(paramInt, 0, 200);
      return;
    }
    if (this.g.getLastVisiblePosition() <= paramInt)
    {
      View localView = this.g.getChild(paramInt);
      if ((localView == null) || (localView.getRight() > this.g.getRight()))
      {
        int i1;
        if (paramInt == getCount() - 1) {
          i1 = this.q.getDisplayMetrics().widthPixels - c;
        } else {
          i1 = c * 5;
        }
        this.g.smoothScrollToPositionFromLeftOrRight(paramInt, -i1, 200);
      }
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    ThreadManager.getUIHandler().post(new QAVPtvTemplateAdapter.7(this, paramString, paramInt));
  }
  
  public int getCount()
  {
    if (this.a.isEmpty()) {
      return 0;
    }
    return this.a.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    QavListItemBase.ItemInfo localItemInfo = b(paramInt);
    Object localObject2 = null;
    if (localItemInfo == null)
    {
      a(paramView, null, paramInt);
      localObject2 = paramView;
    }
    else
    {
      Object localObject1;
      Object localObject3;
      if ("-1".equals(localItemInfo.a))
      {
        localObject1 = localObject2;
        if (paramView != null)
        {
          localObject1 = localObject2;
          if (paramView.getId() == Integer.valueOf(localItemInfo.a).intValue()) {
            localObject1 = paramView;
          }
        }
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject3 = this.r;
          localObject2 = localObject1;
          if (localObject3 != null) {
            localObject2 = localObject3;
          }
        }
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new View(this.b);
          ((View)localObject1).setId(Integer.valueOf(localItemInfo.a).intValue());
          ((View)localObject1).setLayoutParams(new AbsListView.LayoutParams(d, -1));
          this.r = ((View)localObject1);
        }
        localObject2 = localObject1;
        if (AudioHelper.a(0) == 1)
        {
          ((View)localObject1).setBackgroundColor(-256);
          localObject2 = localObject1;
        }
      }
      else
      {
        if (!(paramView instanceof QavListItemBase))
        {
          if (localItemInfo.f == 2)
          {
            localObject1 = new VoiceChangeItemView2(this.b);
          }
          else
          {
            localObject2 = new QavPtvTemplateItemView(this.b);
            ((QavPtvTemplateItemView)localObject2).j = this.n;
            localObject1 = localObject2;
            if (this.o < 6.0F)
            {
              localObject3 = ((QavPtvTemplateItemView)localObject2).findViewById(2131441226);
              localObject1 = localObject2;
              if ((localObject3 instanceof LinearLayout))
              {
                ((LinearLayout)localObject3).setGravity(49);
                localObject1 = localObject2;
              }
            }
          }
          ((QavListItemBase)localObject1).a(c, e);
        }
        else
        {
          localObject1 = (QavListItemBase)paramView;
        }
        if (AudioHelper.a(0) == 1)
        {
          ((QavListItemBase)localObject1).a(localItemInfo, paramInt);
          this.g.setBackgroundColor(-1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getView, itemView[");
          ((StringBuilder)localObject2).append(localObject1.hashCode());
          ((StringBuilder)localObject2).append("], mListView[");
          ((StringBuilder)localObject2).append(this.g.hashCode());
          ((StringBuilder)localObject2).append("], position[");
          ((StringBuilder)localObject2).append(paramInt);
          ((StringBuilder)localObject2).append("], getPosition[");
          ((StringBuilder)localObject2).append(((QavListItemBase)localObject1).getPosition());
          ((StringBuilder)localObject2).append("], mFullItemWidth[");
          ((StringBuilder)localObject2).append(c);
          ((StringBuilder)localObject2).append("], mListViewHeight[");
          ((StringBuilder)localObject2).append(e);
          ((StringBuilder)localObject2).append("], mListView.Height[");
          ((StringBuilder)localObject2).append(this.g.getMeasuredHeight());
          ((StringBuilder)localObject2).append("|");
          ((StringBuilder)localObject2).append(this.g.getHeight());
          ((StringBuilder)localObject2).append("], itemView.Height[");
          ((StringBuilder)localObject2).append(((QavListItemBase)localObject1).getMeasuredHeight());
          ((StringBuilder)localObject2).append("|");
          ((StringBuilder)localObject2).append(((QavListItemBase)localObject1).getHeight());
          ((StringBuilder)localObject2).append("], info[");
          ((StringBuilder)localObject2).append(localItemInfo);
          ((StringBuilder)localObject2).append("]");
          QLog.w("QAVPtvTemplateAdapter", 1, ((StringBuilder)localObject2).toString());
        }
        ((QavListItemBase)localObject1).b(c, e);
        int i1;
        if (paramInt == this.j) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (localItemInfo.f == 7)
        {
          localObject2 = (EffectAvatar2dManager)((VideoAppInterface)this.i).c(16);
          localObject3 = (EffectMaterialManager)((VideoAppInterface)this.i).c(15);
          if (((EffectAvatar2dManager)localObject2).c() == null)
          {
            if (paramInt == 0)
            {
              this.j = 0;
            }
            else
            {
              i1 = 0;
              break label723;
            }
          }
          else
          {
            if (!((EffectMaterialManager)localObject3).r().equals(localItemInfo.a)) {
              break label712;
            }
            this.j = paramInt;
          }
          for (;;)
          {
            i1 = 1;
            break label723;
            label712:
            if (paramInt != this.j) {
              break;
            }
          }
        }
        label723:
        boolean bool1;
        if ((this.f) && (i1 != 0)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        boolean bool2 = this.h;
        localObject3 = this.s;
        localObject2 = localObject1;
        ((QavListItemBase)localObject2).a(paramInt, bool1, bool2, localItemInfo, (QavListItemBase.IClickCallback)localObject3);
        a((View)localObject1, localItemInfo, paramInt);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject2;
  }
  
  public void notifyDataSetChanged()
  {
    this.r = null;
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QAVPtvTemplateAdapter
 * JD-Core Version:    0.7.0.1
 */