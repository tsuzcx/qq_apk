package com.tencent.biz.qqcircle.widgets.pick;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.widget.Adapter;

public class AdapterView$AdapterDataSetObserver
  extends DataSetObserver
{
  private Parcelable b = null;
  
  public AdapterView$AdapterDataSetObserver(AdapterView paramAdapterView) {}
  
  public void onChanged()
  {
    AdapterView localAdapterView = this.a;
    localAdapterView.w = true;
    localAdapterView.C = localAdapterView.B;
    localAdapterView = this.a;
    localAdapterView.B = localAdapterView.getAdapter().getCount();
    if ((this.a.getAdapter().hasStableIds()) && (this.b != null) && (this.a.C == 0) && (this.a.B > 0))
    {
      AdapterView.a(this.a, this.b);
      this.b = null;
    }
    else
    {
      this.a.j();
    }
    this.a.e();
    this.a.requestLayout();
  }
  
  public void onInvalidated()
  {
    AdapterView localAdapterView = this.a;
    localAdapterView.w = true;
    if (localAdapterView.getAdapter().hasStableIds()) {
      this.b = AdapterView.a(this.a);
    }
    localAdapterView = this.a;
    localAdapterView.C = localAdapterView.B;
    localAdapterView = this.a;
    localAdapterView.B = 0;
    localAdapterView.z = -1;
    localAdapterView.A = -9223372036854775808L;
    localAdapterView.x = -1;
    localAdapterView.y = -9223372036854775808L;
    localAdapterView.p = false;
    localAdapterView.e();
    this.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.pick.AdapterView.AdapterDataSetObserver
 * JD-Core Version:    0.7.0.1
 */