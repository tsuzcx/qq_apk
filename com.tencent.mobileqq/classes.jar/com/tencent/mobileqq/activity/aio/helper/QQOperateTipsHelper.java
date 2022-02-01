package com.tencent.mobileqq.activity.aio.helper;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.panel.PanelListener;
import com.tencent.mobileqq.activity.aio.tips.QQOperateTips;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import java.util.ArrayList;
import java.util.List;

public class QQOperateTipsHelper
  implements ILifeCycleHelper, PanelListener
{
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private QQOperateTips jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips;
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new QQOperateTipsHelper.1(this);
  protected List<QQOperationViopTipTask> a;
  
  public QQOperateTipsHelper(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
  }
  
  @NonNull
  public String getTag()
  {
    return "QQOperateTipsHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 10, 15 };
  }
  
  public void onHideAllPanel() {}
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 10)
      {
        if (paramInt != 15) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips = null;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips = new QQOperateTips(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, this.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    }
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2) {}
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2)
  {
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    paramInt2 = this.jdField_a_of_type_JavaUtilList.size();
    if (paramInt1 != 0)
    {
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a();
      if ((paramInt1 == 5) || (paramInt1 == 6)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a();
      }
    }
    else if ((paramInt2 != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips != null) && (!((FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(24)).c()))
    {
      QQOperationViopTipTask localQQOperationViopTipTask = (QQOperationViopTipTask)this.jdField_a_of_type_JavaUtilList.get(paramInt2 - 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips.a(localQQOperationViopTipTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QQOperateTipsHelper
 * JD-Core Version:    0.7.0.1
 */