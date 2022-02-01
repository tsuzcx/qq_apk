package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;

class ApolloRender$4
  extends IApolloRunnableTask
{
  ApolloRender$4(ApolloRender paramApolloRender, int paramInt1, int paramInt2) {}
  
  public String a()
  {
    return "addOnCommonScript";
  }
  
  public void run()
  {
    if ((ApolloRender.getCurrentRenderView() instanceof IApolloRenderView)) {}
    for (int i = ((IApolloRenderView)ApolloRender.getCurrentRenderView()).getInitHeight();; i = 0)
    {
      int j = i;
      if (i == 0) {
        j = (int)DeviceInfoUtil.j();
      }
      String str = ApolloActionHelperImpl.getInitViewScript(this.a, this.b, j);
      ApolloRender.access$300(this.this$0).a(str);
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, new Object[] { "addOnCommonScript:", str });
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.4
 * JD-Core Version:    0.7.0.1
 */