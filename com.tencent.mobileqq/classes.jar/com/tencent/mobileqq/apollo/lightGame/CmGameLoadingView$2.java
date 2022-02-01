package com.tencent.mobileqq.apollo.lightGame;

import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.ICmGameConfirmListener;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;

class CmGameLoadingView$2
  implements Runnable
{
  CmGameLoadingView$2(CmGameLoadingView paramCmGameLoadingView, CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong, CmGameStartChecker.ICmGameConfirmListener paramICmGameConfirmListener) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CmGameLoadingView", 2, "onDownloadConfirm close gameUI");
      }
      CmGameServerQIPCModule.a().b(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    }
    String str = String.format(HardCodeUtil.a(2131702147), new Object[] { Float.valueOf((float)this.jdField_a_of_type_Long * 1.0F / 1024.0F / 1024.0F) });
    this.this$0.setProgressViewVisibility(false);
    this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    this.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.this$0.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.this$0.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131702140));
    this.this$0.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new CmGameLoadingView.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView.2
 * JD-Core Version:    0.7.0.1
 */