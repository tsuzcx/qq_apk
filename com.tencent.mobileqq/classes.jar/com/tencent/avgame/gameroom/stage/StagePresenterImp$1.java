package com.tencent.avgame.gameroom.stage;

import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.qphone.base.util.QLog;
import mxl;
import myc;
import nal;
import nbo;
import nbp;
import nbq;

public class StagePresenterImp$1
  implements Runnable
{
  public StagePresenterImp$1(nbq paramnbq) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StagePresenterImp", 2, "realStartRunnale");
    }
    myc localmyc = mxl.a().a();
    if (!localmyc.a()) {
      return;
    }
    nbq.a(this.this$0, localmyc);
    if (localmyc.d(mxl.a().a().getAccount()))
    {
      this.this$0.jdField_a_of_type_Nal.a().a();
      this.this$0.jdField_a_of_type_Nal.a().b(this.this$0.jdField_a_of_type_Nbp.a());
    }
    this.this$0.jdField_a_of_type_Nal.a().f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.StagePresenterImp.1
 * JD-Core Version:    0.7.0.1
 */