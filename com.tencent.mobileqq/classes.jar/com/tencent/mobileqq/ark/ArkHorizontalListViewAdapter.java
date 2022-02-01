package com.tencent.mobileqq.ark;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkAppModuleCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedList;

public class ArkHorizontalListViewAdapter<T extends ArkAdapterItemInterface>
  extends BaseAdapter
  implements ArkAppContainer.ArkAppModuleCallback
{
  public Context a;
  public SessionInfo b;
  public int c;
  public int d;
  public OnLongClickAndTouchListener e;
  private ArkHorizontalListView f;
  private LinkedList<T> g = new LinkedList();
  
  public ArkHorizontalListViewAdapter(Context paramContext, SessionInfo paramSessionInfo, ArkHorizontalListView paramArkHorizontalListView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    this.a = paramContext;
    this.b = paramSessionInfo;
    this.f = paramArkHorizontalListView;
    this.e = paramOnLongClickAndTouchListener;
  }
  
  private void b()
  {
    if (this.g.size() > 1)
    {
      this.f.setOverScrollMode(0);
      return;
    }
    this.f.setOverScrollMode(2);
  }
  
  public int a()
  {
    return this.g.size();
  }
  
  public T a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < getCount() - 1)) {
      return (ArkAdapterItemInterface)this.g.get(paramInt - 1);
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    View localView;
    if (this.c != paramInt1)
    {
      localView = this.f.getChild(0);
      if ((localView != null) && (!(localView instanceof LinearLayout)))
      {
        localView.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, -1));
        localView.requestLayout();
      }
      this.c = paramInt1;
    }
    if (this.d != paramInt2)
    {
      localView = this.f.getChild(getCount() - 1);
      if ((localView != null) && (!(localView instanceof LinearLayout)))
      {
        localView.setLayoutParams(new ViewGroup.LayoutParams(paramInt2, -1));
        localView.requestLayout();
      }
      this.d = paramInt2;
    }
  }
  
  public void a(int paramInt, T paramT)
  {
    this.g.add(paramInt, paramT);
    notifyDataSetChanged();
    b();
  }
  
  public void a(ArkAioContainerWrapper paramArkAioContainerWrapper, int paramInt)
  {
    if ((paramInt == 1) || (paramInt == this.g.size()))
    {
      Resources localResources = this.a.getResources();
      int i = BaseChatItemLayout.getTextPaddingAlignHead();
      int j = MessageForArkApp.dp2px(40.0F);
      int k = localResources.getDimensionPixelSize(2131296615);
      int m = localResources.getDimensionPixelSize(2131296605);
      int n = MessageForArkApp.dp2px(paramArkAioContainerWrapper.getWidth());
      i = ArkAppCenterUtil.d - (i * 2 + j + k) - n - m;
      if ((this.f.getIsSend()) && (paramInt == 1))
      {
        if (this.c != i)
        {
          this.c = i;
          paramArkAioContainerWrapper = this.f.getChild(0);
          if ((paramArkAioContainerWrapper != null) && (!(paramArkAioContainerWrapper instanceof LinearLayout)))
          {
            paramArkAioContainerWrapper.setLayoutParams(new ViewGroup.LayoutParams(this.c, -1));
            paramArkAioContainerWrapper.requestLayout();
          }
        }
      }
      else if ((!this.f.getIsSend()) && (paramInt == this.g.size()) && (this.d != i))
      {
        this.d = i;
        paramArkAioContainerWrapper = this.f.getChild(paramInt + 1);
        if ((paramArkAioContainerWrapper != null) && (!(paramArkAioContainerWrapper instanceof LinearLayout)))
        {
          paramArkAioContainerWrapper.setLayoutParams(new ViewGroup.LayoutParams(this.d, -1));
          paramArkAioContainerWrapper.requestLayout();
        }
      }
    }
    if (this.f.getVisibility() != 0)
    {
      this.f.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("ArkHorizontalListViewAdapter", 2, "refreshHeaderFooter set ark list visible as load success");
      }
    }
  }
  
  public void a(T paramT)
  {
    this.g.addLast(paramT);
    notifyDataSetChanged();
    b();
  }
  
  public void a(ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, T paramT)
  {
    Object localObject2 = paramT.getArkAppNameAndPath();
    String str = localObject2[0];
    Object localObject1 = localObject2[1];
    localObject2 = localObject2[2];
    paramT.clickTail(paramItemViewHolder, null, this.a);
    if (localObject1 != null)
    {
      ArkAppCacheMgr.getAppIcon(str, new ArkHorizontalListViewAdapter.1(this, paramItemViewHolder));
      paramT = ArkAppCacheMgr.getApplicationDesc(str);
      if (paramT != null)
      {
        paramItemViewHolder.h.setVisibility(0);
        paramItemViewHolder.j.setText(paramT);
      }
    }
    else
    {
      if ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null) {
        return;
      }
      ArkAppMgr.getInstance().getAppPathByName(str, "0.0.0.1", new ArkHorizontalListViewAdapter.2(this, str, paramItemViewHolder));
    }
  }
  
  public boolean a(ArkAppContainer paramArkAppContainer)
  {
    return false;
  }
  
  public boolean a(ArkAppContainer paramArkAppContainer, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ArkHorizontalListViewAdapter OpenCardView containerWrapper=");
    ((StringBuilder)localObject).append(paramArkAppContainer);
    ((StringBuilder)localObject).append(", view=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", meta=");
    ((StringBuilder)localObject).append(paramString2);
    QLog.d("ArkOpenView", 1, ((StringBuilder)localObject).toString());
    int i = 0;
    while (i < this.g.size())
    {
      localObject = ((ArkAdapterItemInterface)this.g.get(i)).extendArkCardByOpen(paramArkAppContainer, paramString1, paramString2);
      if (localObject != null)
      {
        a(i + 1, (ArkAdapterItemInterface)localObject);
        return false;
      }
      i += 1;
    }
    return false;
  }
  
  public T b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.g.size())) {
      return (ArkAdapterItemInterface)this.g.get(paramInt);
    }
    return null;
  }
  
  public void b(int paramInt, T paramT)
  {
    if ((paramInt >= 0) && (paramInt < this.g.size()))
    {
      if (paramT == null) {
        return;
      }
      this.g.set(paramInt, paramT);
      paramInt += 1;
      int i = this.f.getFirstVisiblePosition();
      if ((paramInt >= i) && (paramInt <= this.f.getLastVisiblePosition()))
      {
        Object localObject = this.f.getChildAt(paramInt - i);
        if (localObject != null)
        {
          localObject = (ArkHorizontalListViewAdapter.ItemViewHolder)((View)localObject).getTag();
          if (localObject != null) {
            paramT.attachArkView(this, (ArkHorizontalListViewAdapter.ItemViewHolder)localObject, paramInt);
          }
        }
      }
    }
  }
  
  public void c(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    int j = this.g.size();
    int i = 0;
    while ((i < paramInt) && (i < j))
    {
      ArkAdapterItemInterface localArkAdapterItemInterface = (ArkAdapterItemInterface)this.g.removeLast();
      if (localArkAdapterItemInterface != null) {
        localArkAdapterItemInterface.destroyContainerByRemove();
      }
      i += 1;
    }
    notifyDataSetChanged();
    b();
  }
  
  public int getCount()
  {
    return this.g.size() + 2;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != getCount() - 1)) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (getItemViewType(paramInt) == 1)
    {
      ArkAdapterItemInterface localArkAdapterItemInterface = a(paramInt);
      if (paramView == null)
      {
        localObject = new ArkHorizontalListViewAdapter.ItemViewHolder();
        paramView = LayoutInflater.from(this.a).inflate(2131624256, paramViewGroup, false);
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject).a = ((LinearLayout)paramView.findViewById(2131428757));
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject).b = ((ArkAppRootLayout)paramView.findViewById(2131428759));
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject).d = ((RelativeLayout)paramView.findViewById(2131428772));
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject).c = ((ArkAppLoadLayout)paramView.findViewById(2131437612));
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject).e = ((ArkAppView)paramView.findViewById(2131428746));
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject).f = paramView.findViewById(2131428762);
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject).g = ((Button)paramView.findViewById(2131428758));
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject).h = ((LinearLayout)paramView.findViewById(2131428755));
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject).i = ((ImageView)paramView.findViewById(2131428754));
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject).j = ((TextView)paramView.findViewById(2131428756));
        ViewParent localViewParent = this.f.getParent();
        if ((localViewParent instanceof BaseChatItemLayout)) {
          ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject).k = ((BaseChatItemLayout)localViewParent);
        }
        paramView.setTag(localObject);
      }
      else
      {
        localObject = (ArkHorizontalListViewAdapter.ItemViewHolder)paramView.getTag();
      }
      if (localArkAdapterItemInterface != null) {
        localArkAdapterItemInterface.attachArkView(this, (ArkHorizontalListViewAdapter.ItemViewHolder)localObject, paramInt);
      }
    }
    else
    {
      localObject = paramView;
      if (paramView == null) {
        localObject = new View(paramViewGroup.getContext());
      }
      int i;
      if (paramInt == 0) {
        i = this.c;
      } else {
        i = this.d;
      }
      ((View)localObject).setLayoutParams(new ViewGroup.LayoutParams(i, -1));
      ((View)localObject).setVisibility(0);
      paramView = (View)localObject;
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter
 * JD-Core Version:    0.7.0.1
 */