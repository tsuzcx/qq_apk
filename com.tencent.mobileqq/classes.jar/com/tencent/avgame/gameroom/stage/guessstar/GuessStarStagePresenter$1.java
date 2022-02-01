package com.tencent.avgame.gameroom.stage.guessstar;

import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import nio;
import nky;
import nls;
import nnm;
import nof;

public class GuessStarStagePresenter$1
  implements Runnable
{
  public GuessStarStagePresenter$1(nls paramnls) {}
  
  public void run()
  {
    if ((!nls.a(this.this$0)) || (this.this$0.jdField_a_of_type_Nky == null) || (this.this$0.jdField_a_of_type_Nkw == null) || (!(this.this$0.jdField_a_of_type_Nkw instanceof GuessStarStageView))) {}
    do
    {
      do
      {
        return;
      } while (!((GuessStarStageView)this.this$0.jdField_a_of_type_Nkw).isShown());
      localObject = nnm.b().a();
    } while ((localObject == null) || (((nof)localObject).e));
    Object localObject = BaseApplicationImpl.getContext().getResources().getString(2131690392);
    this.this$0.jdField_a_of_type_Nky.a().a((String)localObject);
    nls.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarStagePresenter.1
 * JD-Core Version:    0.7.0.1
 */