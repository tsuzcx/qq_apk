package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.data.troop.TroopInfoExt;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;

class TodoInfoPresenter$2
  extends TroopObserver
{
  TodoInfoPresenter$2(TodoInfoPresenter paramTodoInfoPresenter) {}
  
  protected void onGetTroopInfoExtComplete(boolean paramBoolean, String paramString, TroopInfoExt paramTroopInfoExt)
  {
    TodoInfoPresenter.a(this.a, paramBoolean, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.TodoInfoPresenter.2
 * JD-Core Version:    0.7.0.1
 */