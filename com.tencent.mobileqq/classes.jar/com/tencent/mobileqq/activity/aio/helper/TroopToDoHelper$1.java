package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.TodoInfoPresenter.ErrorType;
import com.tencent.mobileqq.activity.aio.TodoInfoPresenter.ITodoInfoListener;
import com.tencent.mobileqq.data.trooptodo.TroopToDoBannerModel;
import com.tencent.qphone.base.util.QLog;

class TroopToDoHelper$1
  implements TodoInfoPresenter.ITodoInfoListener
{
  TroopToDoHelper$1(TroopToDoHelper paramTroopToDoHelper) {}
  
  public void a(TodoInfoPresenter.ErrorType paramErrorType)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ITodoInfoListener.onError invoke, errorType = ");
    localStringBuilder.append(paramErrorType);
    QLog.e("TroopToDoHelper-TodoInfo", 4, localStringBuilder.toString());
  }
  
  public void a(TroopToDoBannerModel paramTroopToDoBannerModel)
  {
    QLog.i("TroopToDoHelper-TodoInfo", 4, "ITodoInfoListener.onData invoke, start onShow");
    TroopToDoHelper.a(this.a, paramTroopToDoBannerModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopToDoHelper.1
 * JD-Core Version:    0.7.0.1
 */