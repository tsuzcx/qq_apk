package com.tencent.map.sdk.a;

import android.content.Context;
import android.widget.ListView;

public final class ik
  extends ListView
{
  private ik.a a;
  
  public ik(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void handleDataChanged()
  {
    super.handleDataChanged();
    if (this.a != null) {
      this.a.b();
    }
  }
  
  public final void setOnDataChangedListener(ik.a parama)
  {
    this.a = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ik
 * JD-Core Version:    0.7.0.1
 */