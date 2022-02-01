package com.tencent.mobileqq.apollo.script;

import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IApolloRunnableTask;
import com.tencent.mobileqq.cmshow.engine.script.Script;

final class SpriteUtil$1
  extends IApolloRunnableTask
{
  SpriteUtil$1(Script paramScript, ApolloEngine paramApolloEngine) {}
  
  public int a()
  {
    if (this.a.i() != 0) {
      return this.a.i();
    }
    return super.a();
  }
  
  public void run()
  {
    String str = this.a.e();
    if (this.b != null)
    {
      this.a.b();
      this.b.execScriptString(str);
      this.a.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUtil.1
 * JD-Core Version:    0.7.0.1
 */