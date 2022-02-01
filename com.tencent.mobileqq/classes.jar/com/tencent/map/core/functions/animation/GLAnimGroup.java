package com.tencent.map.core.functions.animation;

import java.util.ArrayList;
import java.util.Iterator;
import javax.microedition.khronos.opengles.GL10;

public class GLAnimGroup
  extends GLAnim
{
  private ArrayList<GLAnim> a = new ArrayList();
  
  public GLAnimGroup(GLAnim... paramVarArgs)
  {
    super(0L);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.a.add(paramVarArgs[i]);
      l = Math.max(l, paramVarArgs[i].getDuration());
      i += 1;
    }
    this.duration = l;
  }
  
  protected void onRestart()
  {
    super.onRestart();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((GLAnim)localIterator.next()).start();
    }
  }
  
  protected void performDraw(GL10 paramGL10, long paramLong)
  {
    if ((this.a == null) || (this.a.isEmpty())) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        GLAnim localGLAnim = (GLAnim)localIterator.next();
        if (!localGLAnim.isFinished()) {
          localGLAnim.draw(paramGL10);
        }
      }
    }
  }
  
  public void start()
  {
    super.start();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((GLAnim)localIterator.next()).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.core.functions.animation.GLAnimGroup
 * JD-Core Version:    0.7.0.1
 */