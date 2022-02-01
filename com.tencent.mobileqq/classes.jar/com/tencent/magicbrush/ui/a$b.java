package com.tencent.magicbrush.ui;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "", "(Ljava/lang/String;I)V", "ChoreographerInJsThread", "ChoreographerInMainThread", "EglSurfaceSwapLocker", "SchedulerLocker", "NativeLocker", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public enum a$b
{
  static
  {
    b localb1 = new b("ChoreographerInJsThread", 0);
    a = localb1;
    b localb2 = new b("ChoreographerInMainThread", 1);
    b = localb2;
    b localb3 = new b("EglSurfaceSwapLocker", 2);
    c = localb3;
    b localb4 = new b("SchedulerLocker", 3);
    d = localb4;
    b localb5 = new b("NativeLocker", 4);
    e = localb5;
    f = new b[] { localb1, localb2, localb3, localb4, localb5 };
  }
  
  protected a$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.a.b
 * JD-Core Version:    0.7.0.1
 */