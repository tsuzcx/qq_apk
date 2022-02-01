package com.tencent.avgame.gameroom.stage;

import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.qphone.base.util.QLog;
import myk;
import mze;
import nbp;
import ndb;
import ndc;
import ndd;

public class StagePresenterImp$1
  implements Runnable
{
  public StagePresenterImp$1(ndd paramndd) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StagePresenterImp", 2, "realStartRunnale");
    }
    mze localmze = myk.a().a();
    if (!localmze.a()) {
      return;
    }
    ndd.a(this.this$0, localmze);
    if (localmze.d(myk.a().a().getAccount()))
    {
      this.this$0.jdField_a_of_type_Nbp.a().a();
      this.this$0.jdField_a_of_type_Nbp.a().b(this.this$0.jdField_a_of_type_Ndc.a());
    }
    this.this$0.jdField_a_of_type_Nbp.a().f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.StagePresenterImp.1
 * JD-Core Version:    0.7.0.1
 */