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
  public int a;
  public Context a;
  public OnLongClickAndTouchListener a;
  public SessionInfo a;
  private ArkHorizontalListView jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView;
  private LinkedList<T> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  public int b;
  
  public ArkHorizontalListViewAdapter(Context paramContext, SessionInfo paramSessionInfo, ArkHorizontalListView paramArkHorizontalListView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView = paramArkHorizontalListView;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener = paramOnLongClickAndTouchListener;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.setOverScrollMode(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.setOverScrollMode(2);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList.size();
  }
  
  public T a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < getCount() - 1)) {
      return (ArkAdapterItemInterface)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt - 1);
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    int j = this.jdField_a_of_type_JavaUtilLinkedList.size();
    int i = 0;
    while ((i < paramInt) && (i < j))
    {
      ArkAdapterItemInterface localArkAdapterItemInterface = (ArkAdapterItemInterface)this.jdField_a_of_type_JavaUtilLinkedList.removeLast();
      if (localArkAdapterItemInterface != null) {
        localArkAdapterItemInterface.destroyContainerByRemove();
      }
      i += 1;
    }
    notifyDataSetChanged();
    a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    View localView;
    if (this.jdField_a_of_type_Int != paramInt1)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getChild(0);
      if ((localView != null) && (!(localView instanceof LinearLayout)))
      {
        localView.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, -1));
        localView.requestLayout();
      }
      this.jdField_a_of_type_Int = paramInt1;
    }
    if (this.b != paramInt2)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getChild(getCount() - 1);
      if ((localView != null) && (!(localView instanceof LinearLayout)))
      {
        localView.setLayoutParams(new ViewGroup.LayoutParams(paramInt2, -1));
        localView.requestLayout();
      }
      this.b = paramInt2;
    }
  }
  
  public void a(int paramInt, T paramT)
  {
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramInt, paramT);
    notifyDataSetChanged();
    a();
  }
  
  public void a(ArkAioContainerWrapper paramArkAioContainerWrapper, int paramInt)
  {
    if ((paramInt == 1) || (paramInt == this.jdField_a_of_type_JavaUtilLinkedList.size()))
    {
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      int i = BaseChatItemLayout.o;
      int j = MessageForArkApp.dp2px(40.0F);
      int k = localResources.getDimensionPixelSize(2131296383);
      int m = localResources.getDimensionPixelSize(2131296375);
      int n = MessageForArkApp.dp2px(paramArkAioContainerWrapper.getWidth());
      i = ArkAppCenterUtil.d - (i * 2 + j + k) - n - m;
      if ((this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.a()) && (paramInt == 1))
      {
        if (this.jdField_a_of_type_Int != i)
        {
          this.jdField_a_of_type_Int = i;
          paramArkAioContainerWrapper = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getChild(0);
          if ((paramArkAioContainerWrapper != null) && (!(paramArkAioContainerWrapper instanceof LinearLayout)))
          {
            paramArkAioContainerWrapper.setLayoutParams(new ViewGroup.LayoutParams(this.jdField_a_of_type_Int, -1));
            paramArkAioContainerWrapper.requestLayout();
          }
        }
      }
      else if ((!this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.a()) && (paramInt == this.jdField_a_of_type_JavaUtilLinkedList.size()) && (this.b != i))
      {
        this.b = i;
        paramArkAioContainerWrapper = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getChild(paramInt + 1);
        if ((paramArkAioContainerWrapper != null) && (!(paramArkAioContainerWrapper instanceof LinearLayout)))
        {
          paramArkAioContainerWrapper.setLayoutParams(new ViewGroup.LayoutParams(this.b, -1));
          paramArkAioContainerWrapper.requestLayout();
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getVisibility() != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("ArkHorizontalListViewAdapter", 2, "refreshHeaderFooter set ark list visible as load success");
      }
    }
  }
  
  public void a(T paramT)
  {
    this.jdField_a_of_type_JavaUtilLinkedList.addLast(paramT);
    notifyDataSetChanged();
    a();
  }
  
  public void a(ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, T paramT)
  {
    Object localObject2 = paramT.getArkAppNameAndPath();
    String str = localObject2[0];
    Object localObject1 = localObject2[1];
    localObject2 = localObject2[2];
    paramT.clickTail(paramItemViewHolder, null, this.jdField_a_of_type_AndroidContentContext);
    if (localObject1 != null)
    {
      ArkAppCacheMgr.getAppIcon(str, new ArkHorizontalListViewAdapter.1(this, paramItemViewHolder));
      paramT = ArkAppCacheMgr.getApplicationDesc(str);
      if (paramT != null)
      {
        paramItemViewHolder.b.setVisibility(0);
        paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramT);
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
    while (i < this.jdField_a_of_type_JavaUtilLinkedList.size())
    {
      localObject = ((ArkAdapterItemInterface)this.jdField_a_of_type_JavaUtilLinkedList.get(i)).extendArkCardByOpen(paramArkAppContainer, paramString1, paramString2);
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
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilLinkedList.size())) {
      return (ArkAdapterItemInterface)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt);
    }
    return null;
  }
  
  public void b(int paramInt, T paramT)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilLinkedList.size()))
    {
      if (paramT == null) {
        return;
      }
      this.jdField_a_of_type_JavaUtilLinkedList.set(paramInt, paramT);
      paramInt += 1;
      int i = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getFirstVisiblePosition();
      if ((paramInt >= i) && (paramInt <= this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getLastVisiblePosition()))
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getChildAt(paramInt - i);
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
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList.size() + 2;
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
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558641, paramViewGroup, false);
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131362958));
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout = ((ArkAppRootLayout)paramView.findViewById(2131362960));
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131362973));
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)paramView.findViewById(2131370350));
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)paramView.findViewById(2131362947));
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131362963);
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131362959));
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject).b = ((LinearLayout)paramView.findViewById(2131362956));
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362955));
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362957));
        ViewParent localViewParent = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getParent();
        if ((localViewParent instanceof BaseChatItemLayout)) {
          ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = ((BaseChatItemLayout)localViewParent);
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
        i = this.jdField_a_of_type_Int;
      } else {
        i = this.b;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter
 * JD-Core Version:    0.7.0.1
 */