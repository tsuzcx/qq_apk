package com.tencent.avgame.gameroom.stage;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import nbp;
import nci;
import ndb;
import ndd;

public class StagePresenterImp$2
  implements Runnable
{
  public StagePresenterImp$2(ndd paramndd) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StagePresenterImp", 2, "realStartRunnale");
    }
    View localView = this.this$0.a.a().a();
    this.this$0.a.a().c(localView);
    this.this$0.a.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.StagePresenterImp.2
 * JD-Core Version:    0.7.0.1
 */