package com.sixgod.pluginsdk.component;

import com.sixgod.pluginsdk.SixGodHelper;

final class c
  implements Runnable
{
  c(ContainerActivity paramContainerActivity) {}
  
  public final void run()
  {
    SixGodHelper.loadPlugin(this.a.getApplicationContext(), this.a.d);
    this.a.runOnUiThread(new d(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.component.c
 * JD-Core Version:    0.7.0.1
 */