package com.tencent.mobileqq.app.automator.step;

import com.tencent.comic.api.IQQComicService;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.IPatchBundleDataHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qroute.QRoute;

public class QQComicStep
  extends AsyncStep
{
  protected int doStep()
  {
    this.mAutomator.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(new QQComicStep.1(this), true);
    ((IQQComicService)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQComicService.class)).startUp();
    ((IPatchBundleDataHandler)QRoute.api(IPatchBundleDataHandler.class)).onAppAsyncStepStart();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.QQComicStep
 * JD-Core Version:    0.7.0.1
 */