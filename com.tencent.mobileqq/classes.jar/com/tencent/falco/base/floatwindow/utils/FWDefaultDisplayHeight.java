package com.tencent.falco.base.floatwindow.utils;

import android.content.Context;
import com.tencent.falco.base.floatwindow.interfaces.OnDisplayHeight;
import org.jetbrains.annotations.NotNull;

public class FWDefaultDisplayHeight
  implements OnDisplayHeight
{
  public int getDisplayRealHeight(@NotNull Context paramContext)
  {
    return DisplayUtils.rejectedNavHeight(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.utils.FWDefaultDisplayHeight
 * JD-Core Version:    0.7.0.1
 */