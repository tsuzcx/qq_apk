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
    int i;
    String str2;
    Object localObject1;
    String str1;
    Object localObject2;
    if ((localBabyQHandler.jdField_a_of_type_JavaUtilHashMap != null) && (!localBabyQHandler.jdField_a_of_type_JavaUtilHashMap.isEmpty()) && (localBabyQHandler.jdField_a_of_type_JavaUtilArrayList != null) && (!localBabyQHandler.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      Iterator localIterator = localBabyQHandler.jdField_a_of_type_JavaUtilArrayList.iterator();
      i = 1;
      while (localIterator.hasNext())
      {
        str2 = (String)localIterator.next();
        if (!TextUtils.isEmpty(str2))
        {
          localObject1 = (String[])localBabyQHandler.jdField_a_of_type_JavaUtilHashMap.get(str2);
          if ((localObject1 != null) && (localObject1.length == 2))
          {
            str1 = localObject1[0];
            localObject2 = localObject1[1];
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        int j = Integer.parseInt(str1);
        localObject1 = new BabyQAIOPanel.GridItemData();
        ((BabyQAIOPanel.GridItemData)localObject1).jdField_a_of_type_JavaLangString = str2;
        ((BabyQAIOPanel.GridItemData)localObject1).jdField_a_of_type_Int = j;
        ((BabyQAIOPanel.GridItemData)localObject1).jdField_a_of_type_Boolean = "1".equalsIgnoreCase((String)localObject2);
        ((BabyQAIOPanel.GridItemData)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = localBabyQHandler.a(j);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("loadDatas | item.drawable is :");
          if (((BabyQAIOPanel.GridItemData)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
            break label304;
          }
          str1 = "null";
          QLog.d("Q.BabyQ", 2, str1 + ", itemCode : " + j);
        }
        if (((BabyQAIOPanel.GridItemData)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
          break label310;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        i = 0;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.BabyQ", 2, "initDatas|get item code error :  " + str1);
      break;
      label304:
      str1 = "not null";
      continue;
      label310:
      if (localException.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690896)))
      {
        ((BabyQAIOPanel.GridItemData)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839264);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        i = 0;
      }
      else if (localException.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690894)))
      {
        ((BabyQAIOPanel.GridItemData)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839262);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        i = 0;
      }
      else if (localException.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690895)))
      {
        ((BabyQAIOPanel.GridItemData)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839263);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        i = 0;
        continue;
        if (i != 0) {
          c();
        }
        return;
        c();
        return;
      }
    }
  }
  
  private void c()
  {
    BabyQAIOPanel.GridItemData localGridItemData = new BabyQAIOPanel.GridItemData();
    localGridItemData.jdField_a_of_type_Boolean = false;
    localGridItemData.jdField_a_of_type_Int = 1;
    localGridItemData.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690894);
    localGridItemData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839262);
    this.jdField_a_of_type_JavaUtilArrayList.add(localGridItemData);
    localGridItemData = new BabyQAIOPanel.GridItemData();
    localGridItemData.jdField_a_of_type_Boolean = false;
    localGridItemData.jdField_a_of_type_Int = 2;
    localGridItemData.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690895);
    localGridItemData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839263);
    this.jdField_a_of_type_JavaUtilArrayList.add(localGridItemData);
    localGridItemData = new BabyQAIOPanel.GridItemData();
    localGridItemData.jdField_a_of_type_Boolean = false;
    localGridItemData.jdField_a_of_type_Int = 3;
    localGridItemData.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131690896);
    localGridItemData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130839264);
    this.jdField_a_of_type_JavaUtilArrayList.add(localGridItemData);
  }
  
  public void a()
  {
    b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel$PanelDataAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel$PanelDataAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(FriendChatPie paramFriendChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramFriendChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreFriendChatPie = paramFriendChatPie;
    setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165639));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131368062));
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreFriendChatPie.ao();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BabyQAIOPanel
 * JD-Core Version:    0.7.0.1
 */