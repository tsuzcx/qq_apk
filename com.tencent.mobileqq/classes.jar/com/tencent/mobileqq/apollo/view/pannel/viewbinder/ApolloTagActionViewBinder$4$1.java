package com.tencent.mobileqq.apollo.view.pannel.viewbinder;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ApolloTagActionViewBinder$4$1
  implements ApolloTagActionViewBinder.IApolloTagActionDataListener
{
  ApolloTagActionViewBinder$4$1(ApolloTagActionViewBinder.4 param4) {}
  
  public void a()
  {
    QLog.e("ApolloActionWithTagsViewBinder", 1, "[getActionIdListByPkgIdAndTagName] onFail");
  }
  
  public void a(List<Integer> paramList)
  {
    ThreadManagerV2.getUIHandlerV2().post(new ApolloTagActionViewBinder.4.1.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloTagActionViewBinder.4.1
 * JD-Core Version:    0.7.0.1
 */