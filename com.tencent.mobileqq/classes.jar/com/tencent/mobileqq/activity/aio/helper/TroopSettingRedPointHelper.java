package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
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
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.c == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqTroopRedpointTroopsettingredpointCenterProcessor = new CenterProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_JavaLangString = "troop";
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.c.findViewById(2131376829);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.c.findViewById(2131369501);
      b();
      c();
      RedPointUIData localRedPointUIData = new RedPointUIData();
      localRedPointUIData.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localRedPointUIData.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localRedPointUIData.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localRedPointUIData.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
      localRedPointUIData.jdField_b_of_type_JavaUtilList = this.jdField_b_of_type_JavaUtilList;
      localRedPointUIData.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
      localRedPointUIData.jdField_b_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView;
      localRedPointUIData.jdField_a_of_type_ComTencentMobileqqTroopRedpointOnHandleClickEvent = new TroopSettingRedPointHelper.1(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopRedpointTroopsettingredpointCenterProcessor.b();
      this.jdField_a_of_type_ComTencentMobileqqTroopRedpointDrawRedPointUIComponent = new DrawRedPointUIComponent(localRedPointUIData);
      this.jdField_a_of_type_ComTencentMobileqqTroopRedpointCleanRedPointUIComponent = new CleanRedPointUIComponent(localRedPointUIData);
    } while (!QLog.isColorLevel());
    QLog.d("TroopSettingRedHelper", 2, "onCreate : mUin = " + this.jdField_a_of_type_JavaLangString);
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(2));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(4));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(5));
  }
  
  private void c()
  {
    this.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(1));
    this.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(4));
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopRedpointTroopsettingredpointCenterProcessor != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopRedpointTroopsettingredpointCenterProcessor.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopRedpointTroopsettingredpointCenterProcessor = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopRedpointDrawRedPointUIComponent != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopRedpointDrawRedPointUIComponent.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopRedpointDrawRedPointUIComponent = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopRedpointCleanRedPointUIComponent != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopRedpointCleanRedPointUIComponent.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopRedpointCleanRedPointUIComponent = null;
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
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
    return new int[] { 7, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 7: 
      a();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopSettingRedPointHelper
 * JD-Core Version:    0.7.0.1
 */