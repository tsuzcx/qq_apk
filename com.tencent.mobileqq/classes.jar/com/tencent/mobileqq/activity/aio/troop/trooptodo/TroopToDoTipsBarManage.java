package com.tencent.mobileqq.activity.aio.troop.trooptodo;

import androidx.annotation.VisibleForTesting;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.QQAppInterface;

public class TroopToDoTipsBarManage
{
  @VisibleForTesting
  protected TroopToDoTipsBar a;
  private AIOContext b;
  private TroopToDoController c;
  private QQAppInterface d;
  
  public TroopToDoTipsBarManage(AIOContext paramAIOContext, TroopToDoController paramTroopToDoController, QQAppInterface paramQQAppInterface)
  {
    this.b = paramAIOContext;
    this.c = paramTroopToDoController;
    this.d = paramQQAppInterface;
  }
  
  public TroopToDoTipsBar a()
  {
    if (this.a == null) {
      this.a = new TroopToDoTipsBar(this.b, this.d, this.c);
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.troop.trooptodo.TroopToDoTipsBarManage
 * JD-Core Version:    0.7.0.1
 */