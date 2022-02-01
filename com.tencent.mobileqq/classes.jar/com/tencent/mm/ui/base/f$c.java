package com.tencent.mm.ui.base;

import android.database.DataSetObserver;

class f$c
  extends DataSetObserver
{
  private f$c(f paramf) {}
  
  public void onChanged()
  {
    if (this.a.e()) {
      this.a.b();
    }
  }
  
  public void onInvalidated()
  {
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.f.c
 * JD-Core Version:    0.7.0.1
 */