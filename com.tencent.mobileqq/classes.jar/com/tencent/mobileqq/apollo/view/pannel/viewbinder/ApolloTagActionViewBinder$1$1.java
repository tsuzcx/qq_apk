package com.tencent.mobileqq.apollo.view.pannel.viewbinder;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ApolloTagActionViewBinder$1$1
  implements ApolloTagActionViewBinder.IApolloTagDataListener
{
  ApolloTagActionViewBinder$1$1(ApolloTagActionViewBinder.1 param1) {}
  
  public void a()
  {
    QLog.e("ApolloActionWithTagsViewBinder", 1, "[getTagListByPkgId] onFail");
  }
  
  public void a(List<String> paramList)
  {
    ThreadManagerV2.getUIHandlerV2().post(new ApolloTagActionViewBinder.1.1.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloTagActionViewBinder.1.1
 * JD-Core Version:    0.7.0.1
 */