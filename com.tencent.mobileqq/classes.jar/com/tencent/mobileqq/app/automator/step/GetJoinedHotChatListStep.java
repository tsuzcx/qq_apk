package com.tencent.mobileqq.app.automator.step;

import ajkc;
import ajkn;
import ajxq;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetJoinedHotChatListStep
  extends AsyncStep
{
  private ajkn a;
  
  public int a()
  {
    if (!HotChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app)) {
      return 7;
    }
    ajkc localajkc = (ajkc)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(35);
    this.jdField_a_of_type_Ajkn = new ajxq(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Ajkn);
    localajkc.a();
    return 2;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ajkn != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Ajkn);
      this.jdField_a_of_type_Ajkn = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetJoinedHotChatListStep
 * JD-Core Version:    0.7.0.1
 */