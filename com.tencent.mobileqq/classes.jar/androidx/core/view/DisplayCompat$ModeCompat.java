package androidx.core.view;

import android.graphics.Point;
import android.view.Display.Mode;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

public final class DisplayCompat$ModeCompat
{
  private final boolean mIsNative;
  private final Display.Mode mMode;
  private final Point mPhysicalDisplaySize;
  
  DisplayCompat$ModeCompat(@NonNull Point paramPoint)
  {
    Preconditions.checkNotNull(paramPoint, "physicalDisplaySize == null");
    this.mIsNative = true;
    this.mPhysicalDisplaySize = paramPoint;
    this.mMode = null;
  }
  
  @RequiresApi(23)
  DisplayCompat$ModeCompat(@NonNull Display.Mode paramMode, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramMode, "Display.Mode == null, can't wrap a null reference");
    this.mIsNative = paramBoolean;
    this.mPhysicalDisplaySize = new Point(paramMode.getPhysicalWidth(), paramMode.getPhysicalHeight());
    this.mMode = paramMode;
  }
  
  public int getPhysicalHeight()
  {
    return this.mPhysicalDisplaySize.y;
  }
  
  public int getPhysicalWidth()
  {
    return this.mPhysicalDisplaySize.x;
  }
  
  public boolean isNative()
  {
    return this.mIsNative;
  }
  
  @Nullable
  @RequiresApi(23)
  public Display.Mode toMode()
  {
    return this.mMode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.DisplayCompat.ModeCompat
 * JD-Core Version:    0.7.0.1
 */