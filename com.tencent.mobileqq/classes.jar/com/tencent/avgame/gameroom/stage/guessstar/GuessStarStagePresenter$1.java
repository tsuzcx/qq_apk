package com.tencent.avgame.gameroom.stage.guessstar;

import android.content.res.Resources;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import nbp;
import nda;
import ndt;
import nfm;

public class GuessStarStagePresenter$1
  implements Runnable
{
  public GuessStarStagePresenter$1(ndt paramndt) {}
  
  public void run()
  {
    if ((!ndt.a(this.this$0)) || (this.this$0.jdField_a_of_type_Nda == null) || (this.this$0.jdField_a_of_type_Ncz == null) || (!(this.this$0.jdField_a_of_type_Ncz instanceof GuessStarStageView))) {}
    do
    {
      do
      {
        return;
      } while (!((GuessStarStageView)this.this$0.jdField_a_of_type_Ncz).isShown());
      localObject = nfm.b().a();
    } while ((localObject == null) || (((AVGameSession)localObject).e));
    Object localObject = BaseApplicationImpl.getContext().getResources().getString(2131690314);
    this.this$0.jdField_a_of_type_Nda.a().a((String)localObject);
    ndt.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarStagePresenter.1
 * JD-Core Version:    0.7.0.1
 */