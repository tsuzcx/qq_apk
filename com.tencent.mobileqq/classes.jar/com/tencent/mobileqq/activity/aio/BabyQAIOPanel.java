package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class BabyQAIOPanel
  extends FrameLayout
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private BabyQAIOPanel.PanelDataAdapter jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel$PanelDataAdapter;
  private FriendChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreFriendChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<BabyQAIOPanel.GridItemData> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public BabyQAIOPanel(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public BabyQAIOPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    BabyQHandler localBabyQHandler = (BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
    if ((localBabyQHandler.jdField_a_of_type_JavaUtilHashMap != null) && (!localBabyQHandler.jdField_a_of_type_JavaUtilHashMap.isEmpty()) && (localBabyQHandler.jdField_a_of_type_JavaUtilArrayList != null) && (!localBabyQHandler.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      Iterator localIterator = localBabyQHandler.jdField_a_of_type_JavaUtilArrayList.iterator();
      int i = 1;
      while (localIterator.hasNext())
      {
        Object localObject1 = (String)localIterator.next();
        Object localObject2;
        String str;
        Object localObject3;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = (String[])localBabyQHandler.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
          if ((localObject2 != null) && (localObject2.length == 2))
          {
            str = localObject2[0];
            localObject3 = localObject2[1];
          }
        }
        try
        {
          int j = Integer.parseInt(str);
          localObject2 = new BabyQAIOPanel.GridItemData();
          ((BabyQAIOPanel.GridItemData)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
          ((BabyQAIOPanel.GridItemData)localObject2).jdField_a_of_type_Int = j;
          ((BabyQAIOPanel.GridItemData)localObject2).jdField_a_of_type_Boolean = "1".equalsIgnoreCase((String)localObject3);
          ((BabyQAIOPanel.GridItemData)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable = localBabyQHandler.a(j);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("loadDatas | item.drawable is :");
            if (((BabyQAIOPanel.GridItemData)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
              str = "null";
            } else {
              str = "not null";
            }
            ((StringBuilder)localObject3).append(str);
            ((StringBuilder)localObject3).append(", itemCode : ");
            ((StringBuilder)localObject3).append(j);
            QLog.d("Q.BabyQ", 2, ((StringBuilder)localObject3).toString());
          }
          if (((BabyQAIOPanel.GridItemData)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          }
          for (;;)
          {
            i = 0;
            break;
            if (((String)localObject1).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690825)))
            {
              ((BabyQAIOPanel.GridItemData)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839118);
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
            }
            else if (((String)localObject1).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690823)))
            {
              ((BabyQAIOPanel.GridItemData)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839116);
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
            }
            else
            {
              if (!((String)localObject1).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690824))) {
                break;
              }
              ((BabyQAIOPanel.GridItemData)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839117);
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
            }
          }
        }
        catch (Exception localException)
        {
          label460:
          break label460;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("initDatas|get item code error :  ");
          ((StringBuilder)localObject1).append(str);
          QLog.d("Q.BabyQ", 2, ((StringBuilder)localObject1).toString());
        }
      }
      if (i != 0) {
        c();
      }
    }
    else
    {
      c();
    }
  }
  
  private void c()
  {
    BabyQAIOPanel.GridItemData localGridItemData = new BabyQAIOPanel.GridItemData();
    localGridItemData.jdField_a_of_type_Boolean = false;
    localGridItemData.jdField_a_of_type_Int = 1;
    localGridItemData.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690823);
    localGridItemData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839116);
    this.jdField_a_of_type_JavaUtilArrayList.add(localGridItemData);
    localGridItemData = new BabyQAIOPanel.GridItemData();
    localGridItemData.jdField_a_of_type_Boolean = false;
    localGridItemData.jdField_a_of_type_Int = 2;
    localGridItemData.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690824);
    localGridItemData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839117);
    this.jdField_a_of_type_JavaUtilArrayList.add(localGridItemData);
    localGridItemData = new BabyQAIOPanel.GridItemData();
    localGridItemData.jdField_a_of_type_Boolean = false;
    localGridItemData.jdField_a_of_type_Int = 3;
    localGridItemData.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690825);
    localGridItemData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839118);
    this.jdField_a_of_type_JavaUtilArrayList.add(localGridItemData);
  }
  
  public void a()
  {
    b();
    BabyQAIOPanel.PanelDataAdapter localPanelDataAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel$PanelDataAdapter;
    if (localPanelDataAdapter != null) {
      localPanelDataAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(FriendChatPie paramFriendChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramFriendChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreFriendChatPie = paramFriendChatPie;
    setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165620));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131367814));
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(2);
    b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel$PanelDataAdapter = new BabyQAIOPanel.PanelDataAdapter(this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel$PanelDataAdapter);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof BabyQAIOPanel.GridItemViewHolder)))
    {
      localObject = (BabyQAIOPanel.GridItemViewHolder)paramView.getTag();
      String str = ((BabyQAIOPanel.GridItemViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreFriendChatPie.a.append(str);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreFriendChatPie.R();
      BabyQHandler localBabyQHandler = (BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
      if (localBabyQHandler.a(str))
      {
        localBabyQHandler.a(str);
        a();
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800806D", "0X800806D", ((BabyQAIOPanel.GridItemViewHolder)localObject).jdField_a_of_type_Int, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BabyQAIOPanel
 * JD-Core Version:    0.7.0.1
 */