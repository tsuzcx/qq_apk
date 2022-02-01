package com.tencent.mobileqq.apollo.process.ui.framework;

import amnt;
import ampj;
import amrk;
import amrt;
import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import bkgm;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public abstract class FrameworkView
  extends RelativeLayout
{
  public amnt a;
  public amrk a;
  protected bkgm a;
  public CmGameStartChecker.StartCheckParam a;
  public WeakReference<Activity> a;
  
  public FrameworkView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference((Activity)paramContext);
  }
  
  public FrameworkView(Context paramContext, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    super(paramContext);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference((Activity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
  }
  
  public void a() {}
  
  public void a(amrk paramamrk, bkgm parambkgm, amnt paramamnt, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.jdField_a_of_type_Amrk = paramamrk;
    this.jdField_a_of_type_Bkgm = parambkgm;
    this.jdField_a_of_type_Amnt = paramamnt;
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId == 3112) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId == 4698)) {}
    amrt localamrt;
    do
    {
      do
      {
        return false;
        if ((this.jdField_a_of_type_Amrk != null) && (this.jdField_a_of_type_Amrk.d())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("cmframe_FrameworkView", 2, "isShowExitGuide current game start not success:" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
      return false;
      localamrt = ampj.a();
    } while ((localamrt == null) || (!localamrt.a()));
    return true;
  }
  
  public abstract void d();
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.disableMinGame)) {
      if ((this.jdField_a_of_type_MqqUtilWeakReference.get() != null) && ((this.jdField_a_of_type_MqqUtilWeakReference.get() instanceof ApolloGameActivity))) {
        ((ApolloGameActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).e();
      }
    }
    do
    {
      do
      {
        return;
        QLog.i("cmframe_FrameworkView", 1, "[onBackEvent]");
      } while ((this.jdField_a_of_type_Amrk == null) || (!this.jdField_a_of_type_Amrk.a()));
      QLog.d("cmframe_FrameworkView", 1, "[onBackEvent] apollo game is running");
      this.jdField_a_of_type_Amrk.h();
    } while (this.jdField_a_of_type_MqqUtilWeakReference.get() == null);
    ((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).overridePendingTransition(0, 0);
  }
  
  public void g()
  {
    try
    {
      if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131376797);
        if (localRelativeLayout != null) {
          localRelativeLayout.removeView(this);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmframe_FrameworkView", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.framework.FrameworkView
 * JD-Core Version:    0.7.0.1
 */