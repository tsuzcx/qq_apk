package com.tencent.mobileqq.apollo.process.ui.framework;

import akun;
import akwd;
import akyg;
import akyp;
import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import bhtd;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public abstract class FrameworkView
  extends RelativeLayout
{
  public akun a;
  public akyg a;
  protected bhtd a;
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
  
  public void a(akyg paramakyg, bhtd parambhtd, akun paramakun, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.jdField_a_of_type_Akyg = paramakyg;
    this.jdField_a_of_type_Bhtd = parambhtd;
    this.jdField_a_of_type_Akun = paramakun;
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId == 3112) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId == 4698)) {}
    akyp localakyp;
    do
    {
      do
      {
        return false;
        if ((this.jdField_a_of_type_Akyg != null) && (this.jdField_a_of_type_Akyg.d())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("cmframe_FrameworkView", 2, "isShowExitGuide current game start not success:" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
      return false;
      localakyp = akwd.a();
    } while ((localakyp == null) || (!localakyp.a()));
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
      } while ((this.jdField_a_of_type_Akyg == null) || (!this.jdField_a_of_type_Akyg.a()));
      QLog.d("cmframe_FrameworkView", 1, "[onBackEvent] apollo game is running");
      this.jdField_a_of_type_Akyg.h();
    } while (this.jdField_a_of_type_MqqUtilWeakReference.get() == null);
    ((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).overridePendingTransition(0, 0);
  }
  
  public void g()
  {
    try
    {
      if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131376043);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.framework.FrameworkView
 * JD-Core Version:    0.7.0.1
 */