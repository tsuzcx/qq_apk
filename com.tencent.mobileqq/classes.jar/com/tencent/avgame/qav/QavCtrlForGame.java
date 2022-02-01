package com.tencent.avgame.qav;

import android.content.Context;
import com.tencent.qav.controller.QavCtrl;

public class QavCtrlForGame
  extends QavCtrl
{
  public QavCtrlForGame(Context paramContext, MultiOperatorImplForGame paramMultiOperatorImplForGame)
  {
    super(paramContext, paramMultiOperatorImplForGame);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public MultiOperatorImplForGame b()
  {
    return (MultiOperatorImplForGame)super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.QavCtrlForGame
 * JD-Core Version:    0.7.0.1
 */