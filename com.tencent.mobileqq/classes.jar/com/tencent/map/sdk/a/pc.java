package com.tencent.map.sdk.a;

import android.content.Context;
import android.widget.TextView;

public final class pc
  extends TextView
{
  private boolean a;
  
  public pc(Context paramContext)
  {
    super(paramContext);
    if (!this.a)
    {
      this.a = true;
      paramContext = pb.a;
      if (paramContext != null) {
        setTypeface(paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.pc
 * JD-Core Version:    0.7.0.1
 */