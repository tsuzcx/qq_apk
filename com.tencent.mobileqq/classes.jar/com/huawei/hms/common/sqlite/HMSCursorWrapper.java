package com.huawei.hms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;

public class HMSCursorWrapper
  extends CursorWrapper
  implements CrossProcessCursor
{
  private AbstractWindowedCursor mCursor;
  
  public HMSCursorWrapper(Cursor paramCursor)
  {
    super(paramCursor);
    if (paramCursor != null)
    {
      if ((paramCursor instanceof CursorWrapper))
      {
        paramCursor = ((CursorWrapper)paramCursor).getWrappedCursor();
        if (paramCursor != null)
        {
          if ((paramCursor instanceof AbstractWindowedCursor))
          {
            this.mCursor = ((AbstractWindowedCursor)paramCursor);
            return;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getWrappedCursor:");
          localStringBuilder.append(paramCursor);
          localStringBuilder.append(" is not a subclass for CursorWrapper");
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
        throw new IllegalArgumentException("getWrappedCursor cannot be null");
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cursor:");
      localStringBuilder.append(paramCursor);
      localStringBuilder.append(" is not a subclass for CursorWrapper");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    throw new IllegalArgumentException("cursor cannot be null");
  }
  
  public void fillWindow(int paramInt, CursorWindow paramCursorWindow)
  {
    this.mCursor.fillWindow(paramInt, paramCursorWindow);
  }
  
  public CursorWindow getWindow()
  {
    return this.mCursor.getWindow();
  }
  
  public Cursor getWrappedCursor()
  {
    return this.mCursor;
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    return this.mCursor.onMove(paramInt1, paramInt2);
  }
  
  public void setWindow(CursorWindow paramCursorWindow)
  {
    this.mCursor.setWindow(paramCursorWindow);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.sqlite.HMSCursorWrapper
 * JD-Core Version:    0.7.0.1
 */