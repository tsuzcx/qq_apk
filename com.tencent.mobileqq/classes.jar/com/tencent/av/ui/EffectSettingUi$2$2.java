package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;
import mft;

public class EffectSettingUi$2$2
  implements Runnable
{
  public EffectSettingUi$2$2(mft parammft, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Mft.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Mft.a.jdField_a_of_type_AndroidWidgetLinearLayout == null);
      this.jdField_a_of_type_Mft.a.a(this.jdField_a_of_type_Long, false);
      bool = this.jdField_a_of_type_Mft.a.isShown();
      if ((this.jdField_a_of_type_Boolean) && (bool)) {
        this.jdField_a_of_type_Mft.a.b(this.jdField_a_of_type_Long, true);
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("AVRedBag", 1, "onStatusChanged, remoteHasVideo[" + this.b + "], peerSupportRedBag[" + this.c + "], isInGameMode[" + this.jdField_a_of_type_Boolean + "], isshow[" + bool + "], seq[" + this.jdField_a_of_type_Long + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.EffectSettingUi.2.2
 * JD-Core Version:    0.7.0.1
 */