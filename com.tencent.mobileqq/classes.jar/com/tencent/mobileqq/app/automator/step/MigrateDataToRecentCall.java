package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.qphone.base.util.QLog;

public class MigrateDataToRecentCall
  extends AsyncStep
{
  protected int a()
  {
    boolean bool = false;
    EntityManagerFactory localEntityManagerFactory = this.a.b.getEntityManagerFactory();
    if ((localEntityManagerFactory instanceof QQEntityManagerFactory))
    {
      bool = ((QQEntityManagerFactory)localEntityManagerFactory).isUpdateFromLowV74();
      ((QQEntityManagerFactory)localEntityManagerFactory).resetUpdateFromLowV74();
    }
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQInitHandler", 2, "DB updated from low than v74,migrate recent call data..");
      }
      ((QCallFacade)this.a.b.getManager(37)).a();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.MigrateDataToRecentCall
 * JD-Core Version:    0.7.0.1
 */