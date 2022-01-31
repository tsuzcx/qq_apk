package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.emoticonview.PanelRecycleBin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.Iterator;
import java.util.List;

public class ApolloPanelAdapter
  extends PagerAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  public BaseChatPie a;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  PanelRecycleBin jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin = new PanelRecycleBin();
  private List jdField_a_of_type_JavaUtilList;
  PanelRecycleBin b = new PanelRecycleBin();
  PanelRecycleBin c = new PanelRecycleBin();
  PanelRecycleBin d = new PanelRecycleBin();
  
  public ApolloPanelAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    super.notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if ((paramObject == null) || (paramViewGroup == null)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            ApolloLinearLayout localApolloLinearLayout;
            do
            {
              do
              {
                return;
                if (((paramObject instanceof View)) && (((View)paramObject).getId() == 2131363133) && (this.d != null))
                {
                  this.d.a((View)paramObject);
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloPanelAdapter", 2, "add to game pool view position = " + paramInt);
                  }
                }
                if (!(paramObject instanceof ApolloLinearLayout)) {
                  break label269;
                }
                localApolloLinearLayout = (ApolloLinearLayout)paramObject;
                localApolloLinearLayout.a();
                paramViewGroup.removeView(localApolloLinearLayout);
                if (localApolloLinearLayout.d != 4) {
                  break;
                }
              } while (this.b == null);
              this.b.a((View)paramObject);
            } while (!QLog.isColorLevel());
            QLog.d("ApolloPanelAdapter", 2, "add to reusePool view position = " + paramInt);
            return;
            if (localApolloLinearLayout.d != 2) {
              break;
            }
          } while (this.c == null);
          this.c.a((View)paramObject);
        } while (!QLog.isColorLevel());
        QLog.d("ApolloPanelAdapter", 2, "add to reusePool view position = " + paramInt);
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin == null);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.a((View)paramObject);
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanelAdapter", 2, "add to reusePool view position = " + paramInt);
    return;
    label269:
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    int j;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      j = 0;
    }
    Iterator localIterator;
    int i;
    do
    {
      return j;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
      j = i;
    } while (!localIterator.hasNext());
    ApolloViewBinder localApolloViewBinder = (ApolloViewBinder)localIterator.next();
    if ((localApolloViewBinder != null) && ((localApolloViewBinder instanceof ApolloViewBinder))) {
      i += localApolloViewBinder.a();
    }
    for (;;)
    {
      break;
    }
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    int j = 0;
    ApolloViewBinder localApolloViewBinder;
    int i;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localApolloViewBinder = (ApolloViewBinder)((Iterator)localObject1).next();
      i = j;
      if (localApolloViewBinder != null)
      {
        i = j;
        if ((localApolloViewBinder instanceof ApolloViewBinder))
        {
          int k = localApolloViewBinder.a();
          j += k;
          i = j;
          if (paramInt + 1 <= j)
          {
            i = k - (j - paramInt);
            if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin == null) || (localApolloViewBinder.c != 0)) {
              break label694;
            }
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.a();
            localObject1 = localObject2;
            if (!(localObject2 instanceof ApolloLinearLayout)) {
              localObject1 = null;
            }
            localObject2 = localObject1;
            if (QLog.isColorLevel())
            {
              QLog.d("ApolloPanelAdapter", 2, "reuse view position =" + paramInt);
              localObject2 = localObject1;
            }
            label166:
            localObject1 = localObject2;
            if (this.b != null)
            {
              localObject1 = localObject2;
              if (localApolloViewBinder.d == 4)
              {
                localObject1 = this.b.a();
                localObject2 = localObject1;
                if (!(localObject1 instanceof ApolloLinearLayout)) {
                  localObject2 = null;
                }
                localObject1 = localObject2;
                if (QLog.isColorLevel())
                {
                  QLog.d("ApolloPanelAdapter", 2, "reuse view position =" + paramInt);
                  localObject1 = localObject2;
                }
              }
            }
            localObject2 = localObject1;
            if (this.c != null)
            {
              localObject2 = localObject1;
              if (localApolloViewBinder.d == 2)
              {
                localObject2 = this.c.a();
                localObject1 = localObject2;
                if (!(localObject2 instanceof ApolloLinearLayout)) {
                  localObject1 = null;
                }
                localObject2 = localObject1;
                if (QLog.isColorLevel())
                {
                  QLog.d("ApolloPanelAdapter", 2, "reuse view position =" + paramInt);
                  localObject2 = localObject1;
                }
              }
            }
            localObject1 = localObject2;
            if (this.d != null)
            {
              localObject1 = localObject2;
              if (localApolloViewBinder.d == 100)
              {
                localObject1 = localObject2;
                if (localApolloViewBinder.c != 8)
                {
                  localObject2 = this.d.a();
                  localObject1 = localObject2;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("ApolloPanelAdapter", 2, "reuse game view position =" + paramInt);
                    localObject1 = localObject2;
                  }
                }
              }
            }
            if (localObject1 == null) {
              break label691;
            }
            localObject2 = ((View)localObject1).getTag();
            if ((localObject2 == null) || (!(localObject2 instanceof Integer)) || (((Integer)((View)localObject1).getTag()).intValue() == XPanelContainer.d)) {
              break label691;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin != null) {
              this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.a();
            }
            if (this.b != null) {
              this.b.a();
            }
            if (this.c != null) {
              this.c.a();
            }
            if (this.d != null) {
              this.d.a();
            }
            localObject1 = null;
            label528:
            if (localObject1 == null)
            {
              localObject2 = localApolloViewBinder.a(i);
              localObject1 = localObject2;
              if ((localObject2 instanceof ApolloLinearLayout))
              {
                ((ApolloLinearLayout)localObject2).setCallback(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
                ((ApolloLinearLayout)localObject2).setSessionInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
                localObject1 = localObject2;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanelAdapter", 2, "instantiateItem position = " + paramInt);
      }
      if ((localObject1 != null) && (((View)localObject1).getParent() != paramViewGroup) && (paramInt < getCount()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanelAdapter", 2, "addView position = " + paramInt);
        }
        paramViewGroup.addView((View)localObject1);
      }
      return localObject1;
      localApolloViewBinder.a((View)localObject1, i);
      continue;
      j = i;
      break;
      label691:
      break label528;
      label694:
      localObject2 = null;
      break label166;
      localObject1 = null;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanelAdapter
 * JD-Core Version:    0.7.0.1
 */