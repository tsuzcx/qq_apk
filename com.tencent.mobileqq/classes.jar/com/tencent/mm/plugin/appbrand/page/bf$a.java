package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import org.joor.Reflect;

public class bf$a
  implements bf
{
  public <WIDGET extends View> WIDGET a(@NonNull Context paramContext, @NonNull Class<WIDGET> paramClass)
  {
    return (View)paramClass.cast(Reflect.on(paramClass).create(new Object[] { paramContext }).get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bf.a
 * JD-Core Version:    0.7.0.1
 */