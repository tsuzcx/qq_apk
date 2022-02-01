package com.tencent.avgame.gameroom.stage;

import android.os.Build.VERSION;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.qphone.base.util.QLog;
import lfm;
import nfc;
import nfh;
import nfv;
import nio;
import nkz;
import nla;
import nlb;

public class StagePresenterImp$1
  implements Runnable
{
  public StagePresenterImp$1(nlb paramnlb) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StagePresenterImp", 2, "realStartRunnale");
    }
    nfv localnfv = nfc.a().a();
    if (!localnfv.a()) {}
    do
    {
      return;
      nlb.a(this.this$0, localnfv);
      if (localnfv.d(nfc.a().a().getAccount()))
      {
        this.this$0.jdField_a_of_type_Nio.a().a();
        this.this$0.jdField_a_of_type_Nio.a().b(this.this$0.jdField_a_of_type_Nla.a());
      }
      this.this$0.jdField_a_of_type_Nio.a().f();
      localnfv.a().a();
    } while (Build.VERSION.SDK_INT < 16);
    lfm.a().a(localnfv.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.StagePresenterImp.1
 * JD-Core Version:    0.7.0.1
 */