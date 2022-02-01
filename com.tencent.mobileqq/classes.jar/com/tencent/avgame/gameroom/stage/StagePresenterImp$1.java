package com.tencent.avgame.gameroom.stage;

import android.os.Build.VERSION;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.qphone.base.util.QLog;
import mxh;
import mzl;
import mzq;
import naf;
import ncq;
import neh;
import nei;
import nej;

public class StagePresenterImp$1
  implements Runnable
{
  public StagePresenterImp$1(nej paramnej) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StagePresenterImp", 2, "realStartRunnale");
    }
    naf localnaf = mzl.a().a();
    if (!localnaf.a()) {}
    do
    {
      return;
      nej.a(this.this$0, localnaf);
      if (localnaf.d(mzl.a().a().getAccount()))
      {
        this.this$0.jdField_a_of_type_Ncq.a().a();
        this.this$0.jdField_a_of_type_Ncq.a().b(this.this$0.jdField_a_of_type_Nei.a());
      }
      this.this$0.jdField_a_of_type_Ncq.a().f();
      localnaf.a().a();
    } while (Build.VERSION.SDK_INT < 16);
    mxh.a().a(localnaf.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.StagePresenterImp.1
 * JD-Core Version:    0.7.0.1
 */