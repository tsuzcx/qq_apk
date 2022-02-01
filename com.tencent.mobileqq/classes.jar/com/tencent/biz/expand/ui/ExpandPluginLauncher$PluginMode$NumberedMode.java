package com.tencent.biz.expand.ui;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/ui/ExpandPluginLauncher$PluginMode$NumberedMode;", "Lcom/tencent/biz/expand/ui/ExpandPluginLauncher$PluginMode;", "mode", "", "(I)V", "getMode", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandPluginLauncher$PluginMode$NumberedMode
  extends ExpandPluginLauncher.PluginMode
{
  private final int a;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof NumberedMode))
      {
        paramObject = (NumberedMode)paramObject;
        if (this.a != paramObject.a) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.a;
  }
  
  @NotNull
  public String toString()
  {
    return "NumberedMode(mode=" + this.a + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandPluginLauncher.PluginMode.NumberedMode
 * JD-Core Version:    0.7.0.1
 */