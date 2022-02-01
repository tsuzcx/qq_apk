package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.redpoint.CleanRedPointUIComponent;
import com.tencent.mobileqq.troop.redpoint.DrawRedPointUIComponent;
import com.tencent.mobileqq.troop.redpoint.RedPointUIData;
import com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.CenterProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class TroopSettingRedPointHelper
  implements ILifeCycleHelper
{
  private View jdField_a_of_type_AndroidViewView = null;
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private CleanRedPointUIComponent jdField_a_of_type_ComTencentMobileqqTroopRedpointCleanRedPointUIComponent;
  private DrawRedPointUIComponent jdField_a_of_type_ComTencentMobileqqTroopRedpointDrawRedPointUIComponent;
  private CenterProcessor jdField_a_of_type_ComTencentMobileqqTroopRedpointTroopsettingredpointCenterProcessor;
  private String jdField_a_of_type_JavaLangString = "";
  private List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private View jdField_b_of_type_AndroidViewView = null;
  private String jdField_b_of_type_JavaLangString = "";
  private List<Integer> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public TroopSettingRedPointHelper(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
      if ((localObject != null) && (((TroopChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList != null))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.c == null) {
          return;
        }
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        localObject = ((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(this.jdField_a_of_type_JavaLangString);
        if (localObject != null)
        {
          if (((TroopInfo)localObject).isExited()) {
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopRedpointTroopsettingredpointCenterProcessor = new CenterProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
          this.jdField_b_of_type_JavaLangString = "troop";
          this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.c.findViewById(2131376321);
          this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.c.findViewById(2131369216);
          b();
          c();
          localObject = new RedPointUIData();
          ((RedPointUIData)localObject).jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          ((RedPointUIData)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          ((RedPointUIData)localObject).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          ((RedPointUIData)localObject).jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
          ((RedPointUIData)localObject).jdField_b_of_type_JavaUtilList = this.jdField_b_of_type_JavaUtilList;
          ((RedPointUIData)localObject).jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
          ((RedPointUIData)localObject).jdField_b_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView;
          ((RedPointUIData)localObject).jdField_a_of_type_ComTencentMobileqqTroopRedpointOnHandleClickEvent = new TroopSettingRedPointHelper.1(this);
          this.jdField_a_of_type_ComTencentMobileqqTroopRedpointTroopsettingredpointCenterProcessor.b();
          this.jdField_a_of_type_ComTencentMobileqqTroopRedpointDrawRedPointUIComponent = new DrawRedPointUIComponent((RedPointUIData)localObject);
          this.jdField_a_of_type_ComTencentMobileqqTroopRedpointCleanRedPointUIComponent = new CleanRedPointUIComponent((RedPointUIData)localObject);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onCreate : mUin = ");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
            QLog.d("TroopSettingRedHelper", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(2));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(5));
  }
  
  private void c()
  {
    this.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(1));
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopRedpointTroopsettingredpointCenterProcessor;
    if (localObject != null)
    {
      ((CenterProcessor)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqTroopRedpointTroopsettingredpointCenterProcessor = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopRedpointDrawRedPointUIComponent;
    if (localObject != null)
    {
      ((DrawRedPointUIComponent)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqTroopRedpointDrawRedPointUIComponent = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopRedpointCleanRedPointUIComponent;
    if (localObject != null)
    {
      ((CleanRedPointUIComponent)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqTroopRedpointCleanRedPointUIComponent = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    localObject = this.jdField_b_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_b_of_type_AndroidViewView = null;
  }
  
  public String getTag()
  {
    return "TroopSettingRedHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 8, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 8)
    {
      if (paramInt != 15) {
        return;
      }
      d();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopSettingRedPointHelper
 * JD-Core Version:    0.7.0.1
 */