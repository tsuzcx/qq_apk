package com.tencent.mobileqq.apollo.web.jsmodule;

import com.tencent.mobileqq.apollo.store.IApolloActivityJsCallBack;

class Makeup2DJsModule$3$1
  implements Runnable
{
  Makeup2DJsModule$3$1(Makeup2DJsModule.3 param3, int[] paramArrayOfInt) {}
  
  public void run()
  {
    String str = ((IApolloActivityJsCallBack)this.b.a).a(this.a);
    Makeup2DJsModule localMakeup2DJsModule = this.b.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.b);
    localStringBuilder.append("&&");
    localStringBuilder.append(this.b.b);
    localStringBuilder.append("(");
    localStringBuilder.append(str);
    localStringBuilder.append(");");
    localMakeup2DJsModule.d(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Makeup2DJsModule.3.1
 * JD-Core Version:    0.7.0.1
 */