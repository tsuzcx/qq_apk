package com.tencent.avgame.gameroom.stage.guessstar;

import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import ncq;
import neg;
import nfa;
import ngu;
import nhn;

public class GuessStarStagePresenter$1
  implements Runnable
{
  public GuessStarStagePresenter$1(nfa paramnfa) {}
  
  public void run()
  {
    if ((!nfa.a(this.this$0)) || (this.this$0.jdField_a_of_type_Neg == null) || (this.this$0.jdField_a_of_type_Nee == null) || (!(this.this$0.jdField_a_of_type_Nee instanceof GuessStarStageView))) {}
    do
    {
      do
      {
        return;
      } while (!((GuessStarStageView)this.this$0.jdField_a_of_type_Nee).isShown());
      localObject = ngu.b().a();
    } while ((localObject == null) || (((nhn)localObject).e));
    Object localObject = BaseApplicationImpl.getContext().getResources().getString(2131690352);
    this.this$0.jdField_a_of_type_Neg.a().a((String)localObject);
    nfa.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.GuessStarStagePresenter.1
 * JD-Core Version:    0.7.0.1
 */