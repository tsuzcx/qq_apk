package com.tencent.mobileqq.ark;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
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
    if ((paramInt <= 0) || (paramInt >= getCount() - 1)) {
      return null;
    }
    return (ArkAdapterItemInterface)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt - 1);
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
    int i;
    if ((paramInt == 1) || (paramInt == this.jdField_a_of_type_JavaUtilLinkedList.size()))
    {
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      i = BaseChatItemLayout.o;
      int j = MessageForArkApp.dp2px(40.0F);
      int k = localResources.getDimensionPixelSize(2131296404);
      int m = localResources.getDimensionPixelSize(2131296396);
      int n = MessageForArkApp.dp2px(paramArkAioContainerWrapper.getWidth());
      i = ArkAppCenterUtil.d - (i * 2 + j + k) - n - m;
      if ((!this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.a()) || (paramInt != 1)) {
        break label185;
      }
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
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getVisibility() != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.setVisibility(0);
        if (QLog.isColorLevel()) {
          QLog.d("ArkHorizontalListViewAdapter", 2, "refreshHeaderFooter set ark list visible as load success");
        }
      }
      return;
      label185:
      if ((!this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.a()) && (paramInt == this.jdField_a_of_type_JavaUtilLinkedList.size()) && (this.b != i))
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
    while ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null) {
      return;
    }
    ArkAppMgr.getInstance().getAppPathByName(str, (String)localObject2, "0.0.0.1", null, new ArkHorizontalListViewAdapter.2(this, str, paramItemViewHolder));
  }
  
  public boolean a(ArkAppContainer paramArkAppContainer)
  {
    return false;
  }
  
  public boolean a(ArkAppContainer paramArkAppContainer, String paramString1, String paramString2)
  {
    QLog.d("ArkOpenView", 1, "ArkHorizontalListViewAdapter OpenCardView containerWrapper=" + paramArkAppContainer + ", view=" + paramString1 + ", meta=" + paramString2);
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilLinkedList.size())
      {
        ArkAdapterItemInterface localArkAdapterItemInterface = ((ArkAdapterItemInterface)this.jdField_a_of_type_JavaUtilLinkedList.get(i)).extendArkCardByOpen(paramArkAppContainer, paramString1, paramString2);
        if (localArkAdapterItemInterface != null) {
          a(i + 1, localArkAdapterItemInterface);
        }
      }
      else
      {
        return false;
      }
      i += 1;
    }
  }
  
  public T b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilLinkedList.size())) {
      return null;
    }
    return (ArkAdapterItemInterface)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt);
  }
  
  public void b(int paramInt, T paramT)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilLinkedList.size()) || (paramT == null)) {}
    Object localObject;
    do
    {
      do
      {
        int i;
        do
        {
          return;
          this.jdField_a_of_type_JavaUtilLinkedList.set(paramInt, paramT);
          paramInt += 1;
          i = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getFirstVisiblePosition();
        } while ((paramInt < i) || (paramInt > this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getLastVisiblePosition()));
        localObject = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getChildAt(paramInt - i);
      } while (localObject == null);
      localObject = (ArkHorizontalListViewAdapter.ItemViewHolder)((View)localObject).getTag();
    } while (localObject == null);
    paramT.attachArkView(this, (ArkHorizontalListViewAdapter.ItemViewHolder)localObject, paramInt);
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
    if ((paramInt == 0) || (paramInt == getCount() - 1)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2;
    if (getItemViewType(paramInt) == 1)
    {
      ArkAdapterItemInterface localArkAdapterItemInterface = a(paramInt);
      if (paramView == null)
      {
        localObject1 = new ArkHorizontalListViewAdapter.ItemViewHolder();
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558742, paramViewGroup, false);
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363009));
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout = ((ArkAppRootLayout)paramView.findViewById(2131363011));
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363025));
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)paramView.findViewById(2131370713));
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)paramView.findViewById(2131362998));
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363015);
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363010));
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject1).b = ((LinearLayout)paramView.findViewById(2131363007));
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363006));
        ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363008));
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getParent();
        if ((localObject2 instanceof BaseChatItemLayout)) {
          ((ArkHorizontalListViewAdapter.ItemViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = ((BaseChatItemLayout)localObject2);
        }
        paramView.setTag(localObject1);
      }
      for (;;)
      {
        localObject2 = paramView;
        if (localArkAdapterItemInterface != null)
        {
          localArkAdapterItemInterface.attachArkView(this, (ArkHorizontalListViewAdapter.ItemViewHolder)localObject1, paramInt);
          localObject2 = paramView;
        }
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
        return localObject2;
        localObject1 = (ArkHorizontalListViewAdapter.ItemViewHolder)paramView.getTag();
      }
    }
    Object localObject1 = paramView;
    if (paramView == null) {
      localObject1 = new View(paramViewGroup.getContext());
    }
    if (paramInt == 0) {}
    for (int i = this.jdField_a_of_type_Int;; i = this.b)
    {
      ((View)localObject1).setLayoutParams(new ViewGroup.LayoutParams(i, -1));
      ((View)localObject1).setVisibility(0);
      localObject2 = localObject1;
      break;
    }
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