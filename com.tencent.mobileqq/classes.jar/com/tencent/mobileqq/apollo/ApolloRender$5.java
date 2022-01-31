package com.tencent.mobileqq.apollo;

import aiii;
import aiwi;
import babp;
import com.tencent.qphone.base.util.QLog;

class ApolloRender$5
  extends IApolloRunnableTask
{
  ApolloRender$5(ApolloRender paramApolloRender, int paramInt1, int paramInt2) {}
  
  public String a()
  {
    return "addOnCommonScript";
  }
  
  public void run()
  {
    if ((ApolloRender.getRenderViewByThreadId() instanceof aiii)) {}
    for (int i = ((aiii)ApolloRender.getRenderViewByThreadId()).getInitHeight();; i = 0)
    {
      int j = i;
      if (i == 0) {
        j = (int)babp.j();
      }
      String str = aiwi.b(this.a, this.b, j);
      ApolloRender.access$300(this.this$0).a(str);
      if (QLog.isColorLevel()) {
        QLog.d("sava_ApolloRender", 2, new Object[] { "addOnCommonScript:", str });
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.5
 * JD-Core Version:    0.7.0.1
 */