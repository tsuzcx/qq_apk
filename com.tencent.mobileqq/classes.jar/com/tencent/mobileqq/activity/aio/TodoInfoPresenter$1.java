package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.troop.trooptodo.TroopTodoInfoObserver;
import java.util.List;
import tencent.im.oidb.cmd0xf8e.oidb_0xf8e.InfoValue;
import tencent.im.oidb.cmd0xf8e.oidb_0xf8e.UserNode;

class TodoInfoPresenter$1
  extends TroopTodoInfoObserver
{
  TodoInfoPresenter$1(TodoInfoPresenter paramTodoInfoPresenter) {}
  
  public void a(int paramInt1, List<oidb_0xf8e.UserNode> paramList, int paramInt2, int paramInt3, long paramLong)
  {
    TodoInfoPresenter.a(this.a, paramInt1, paramList, paramInt2, paramInt3, paramLong);
  }
  
  public void a(int paramInt1, oidb_0xf8e.InfoValue paramInfoValue, int paramInt2, int paramInt3)
  {
    TodoInfoPresenter.a(this.a, paramInt1, paramInfoValue, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.TodoInfoPresenter.1
 * JD-Core Version:    0.7.0.1
 */