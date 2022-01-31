package com.tencent.mobileqq.ark;

import aaui;
import aauj;
import aaul;
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
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
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
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class ArkHorizontalListViewAdapter
  extends BaseAdapter
  implements ArkAppContainer.ArkAppModuleCallback
{
  public int a;
  public Context a;
  public OnLongClickAndTouchListener a;
  public SessionInfo a;
  private ArkHorizontalListView jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
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
  
  public ArkAdapterItemInterface a(int paramInt)
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
      localView = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.b(0);
      if ((localView != null) && (!(localView instanceof LinearLayout)))
      {
        localView.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, -1));
        localView.requestLayout();
      }
      this.jdField_a_of_type_Int = paramInt1;
    }
    if (this.b != paramInt2)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.b(getCount() - 1);
      if ((localView != null) && (!(localView instanceof LinearLayout)))
      {
        localView.setLayoutParams(new ViewGroup.LayoutParams(paramInt2, -1));
        localView.requestLayout();
      }
      this.b = paramInt2;
    }
  }
  
  public void a(int paramInt, ArkAdapterItemInterface paramArkAdapterItemInterface)
  {
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramInt, paramArkAdapterItemInterface);
    notifyDataSetChanged();
    a();
  }
  
  public void a(ArkAioContainerWrapper paramArkAioContainerWrapper, int paramInt)
  {
    int i;
    if ((paramInt == 1) || (paramInt == this.jdField_a_of_type_JavaUtilLinkedList.size()))
    {
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      i = BaseChatItemLayout.n;
      int j = AIOUtils.a(40.0F, localResources);
      int k = localResources.getDimensionPixelSize(2131558619);
      int m = localResources.getDimensionPixelSize(2131558622);
      int n = AIOUtils.a(paramArkAioContainerWrapper.getWidth(), localResources);
      i = BaseChatItemLayout.c - (i * 2 + j + k) - n - m;
      if ((!this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.b()) || (paramInt != 1)) {
        break label189;
      }
      if (this.jdField_a_of_type_Int != i)
      {
        this.jdField_a_of_type_Int = i;
        paramArkAioContainerWrapper = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.b(0);
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
      label189:
      if ((!this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.b()) && (paramInt == this.jdField_a_of_type_JavaUtilLinkedList.size()) && (this.b != i))
      {
        this.b = i;
        paramArkAioContainerWrapper = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.b(paramInt + 1);
        if ((paramArkAioContainerWrapper != null) && (!(paramArkAioContainerWrapper instanceof LinearLayout)))
        {
          paramArkAioContainerWrapper.setLayoutParams(new ViewGroup.LayoutParams(this.b, -1));
          paramArkAioContainerWrapper.requestLayout();
        }
      }
    }
  }
  
  public void a(ArkAdapterItemInterface paramArkAdapterItemInterface)
  {
    this.jdField_a_of_type_JavaUtilLinkedList.addLast(paramArkAdapterItemInterface);
    notifyDataSetChanged();
    a();
  }
  
  public void a(ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, ArkAdapterItemInterface paramArkAdapterItemInterface)
  {
    Object localObject = paramArkAdapterItemInterface.getArkAppNameAndPath();
    String str = localObject[0];
    localObject = localObject[1];
    paramArkAdapterItemInterface.clickTail(paramItemViewHolder, this.jdField_a_of_type_AndroidContentContext);
    if (localObject != null)
    {
      ArkAppCenter.a((String)localObject, new aaui(this, paramItemViewHolder));
      ArkAppCenter.a().post(new aauj(this, (String)localObject, paramItemViewHolder));
    }
    do
    {
      return;
      paramArkAdapterItemInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    } while (paramArkAdapterItemInterface == null);
    ((ArkAppCenter)paramArkAdapterItemInterface.getManager(120)).a().a(str, "0.0.0.1", null, new aaul(this, paramItemViewHolder));
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
  
  public ArkAdapterItemInterface b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilLinkedList.size())) {
      return null;
    }
    return (ArkAdapterItemInterface)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt);
  }
  
  public void b(int paramInt, ArkAdapterItemInterface paramArkAdapterItemInterface)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilLinkedList.size()) || (paramArkAdapterItemInterface == null)) {}
    Object localObject;
    do
    {
      do
      {
        int i;
        do
        {
          return;
          this.jdField_a_of_type_JavaUtilLinkedList.set(paramInt, paramArkAdapterItemInterface);
          paramInt += 1;
          i = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getFirstVisiblePosition();
        } while ((paramInt < i) || (paramInt > this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getLastVisiblePosition()));
        localObject = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.getChildAt(paramInt - i);
      } while (localObject == null);
      localObject = (ArkHorizontalListViewAdapter.ItemViewHolder)((View)localObject).getTag();
    } while (localObject == null);
    paramArkAdapterItemInterface.attachArkView(this, (ArkHorizontalListViewAdapter.ItemViewHolder)localObject, paramInt);
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
    if (getItemViewType(paramInt) == 1)
    {
      if (paramView == null)
      {
        paramView = new ArkHorizontalListViewAdapter.ItemViewHolder();
        localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968705, paramViewGroup, false);
        paramView.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131363310));
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout = ((ArkAppRootLayout)((View)localObject).findViewById(2131363308));
        paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131363311));
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)((View)localObject).findViewById(2131363313));
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)((View)localObject).findViewById(2131363312));
        paramView.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131363315);
        paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject).findViewById(2131363316));
        paramView.b = ((LinearLayout)((View)localObject).findViewById(2131363317));
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131363318));
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131363319));
        ((View)localObject).setTag(paramView);
        paramViewGroup = paramView;
        paramView = (View)localObject;
      }
      for (;;)
      {
        localObject = a(paramInt);
        if (localObject != null) {
          ((ArkAdapterItemInterface)localObject).attachArkView(this, paramViewGroup, paramInt);
        }
        return paramView;
        paramViewGroup = (ArkHorizontalListViewAdapter.ItemViewHolder)paramView.getTag();
      }
    }
    Object localObject = paramView;
    if (paramView == null) {
      localObject = new View(paramViewGroup.getContext());
    }
    if (paramInt == 0) {}
    for (paramInt = this.jdField_a_of_type_Int;; paramInt = this.b)
    {
      ((View)localObject).setLayoutParams(new ViewGroup.LayoutParams(paramInt, -1));
      ((View)localObject).setVisibility(0);
      return localObject;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter
 * JD-Core Version:    0.7.0.1
 */