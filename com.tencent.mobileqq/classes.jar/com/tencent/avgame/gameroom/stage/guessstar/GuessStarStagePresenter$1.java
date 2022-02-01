package com.tencent.avgame.gameroom.stage.guessstar;

import android.content.res.Resources;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import nal;
import nbn;
import ncg;
import ndt;

public class GuessStarStagePresenter$1
  implements Runnable
{
  public GuessStarStagePresenter$1(ncg paramncg) {}
  
  public void run()
  {
    if ((!ncg.a(this.this$0)) || (this.this$0.jdField_a_of_type_Nbn == null) || (this.this$0.jdField_a_of_type_Nbm == null) || (!(this.this$0.jdField_a_of_type_Nbm instanceof GuessStarStageView))) {}
    do
    {
      do
      {
        return;
      } while (!((GuessStarStageView)this.this$0.jdField_a_of_type_Nbm).isShown());
      localObject = ndt.b().a();
    } while ((localObject == null) || (((AVGameSession)localObject).e));
    Object localObject = BaseApplicationImpl.getContext().getResources().getString(2131690310);
    this.this$0.jdField_a_of_type_Nbn.a().a((String)localObject);
    ncg.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarStagePresenter.1
 * JD-Core Version:    0.7.0.1
 */