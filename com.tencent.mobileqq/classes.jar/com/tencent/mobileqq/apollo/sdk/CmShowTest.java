package com.tencent.mobileqq.apollo.sdk;

import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.apollo.api.sdk.PlayActionConfig;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class CmShowTest
{
  private static int a = 0;
  
  private static void b(RelativeLayout paramRelativeLayout)
  {
    QLog.i("CmShowTest", 1, "init relativeLayout:" + paramRelativeLayout);
    CmShowRenderView localCmShowRenderView = new CmShowRenderView(paramRelativeLayout.getContext());
    paramRelativeLayout.addView(localCmShowRenderView, new RelativeLayout.LayoutParams(-1, -1));
    localCmShowRenderView.a(new CmShowTest.2(localCmShowRenderView), "1725000451", "1174992642", 0);
  }
  
  private static void d(CmShowRenderView paramCmShowRenderView)
  {
    QLog.i("CmShowTest", 1, "testMainAction");
    PlayActionConfig localPlayActionConfig = new PlayActionConfig();
    localPlayActionConfig.a = 3000272;
    localPlayActionConfig.jdField_b_of_type_Int = 101;
    localPlayActionConfig.c = 2;
    localPlayActionConfig.jdField_b_of_type_Boolean = false;
    paramCmShowRenderView.a(localPlayActionConfig);
  }
  
  private static void e(CmShowRenderView paramCmShowRenderView)
  {
    QLog.i("CmShowTest", 1, "testPostAction");
    PlayActionConfig localPlayActionConfig = new PlayActionConfig();
    localPlayActionConfig.a = 3000272;
    localPlayActionConfig.jdField_b_of_type_Int = 102;
    localPlayActionConfig.jdField_b_of_type_Boolean = false;
    localPlayActionConfig.c = 3;
    paramCmShowRenderView.a(localPlayActionConfig);
  }
  
  private static void f(CmShowRenderView paramCmShowRenderView)
  {
    ThreadManager.getUIHandler().postDelayed(new CmShowTest.4(paramCmShowRenderView), 5000L);
    ThreadManager.getUIHandler().postDelayed(new CmShowTest.5(paramCmShowRenderView), 10000L);
    ThreadManager.getUIHandler().postDelayed(new CmShowTest.6(paramCmShowRenderView), 15000L);
    ThreadManager.getUIHandler().postDelayed(new CmShowTest.7(paramCmShowRenderView), 20000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowTest
 * JD-Core Version:    0.7.0.1
 */