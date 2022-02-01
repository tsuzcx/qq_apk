package com.tencent.biz;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class PoiMapActivity$12
  implements Runnable
{
  PoiMapActivity$12(PoiMapActivity paramPoiMapActivity, boolean paramBoolean1, String paramString1, String paramString2, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2) {}
  
  public void run()
  {
    boolean bool2 = this.this$0.Z;
    boolean bool1 = true;
    PoiMapActivity localPoiMapActivity;
    if (bool2)
    {
      if (this.a)
      {
        this.this$0.a("rec_locate", "call_foursquare", "", "", "", "");
        QLog.d("PoiMapActivity", 1, "hasPoiListForFoursquareFinal: true");
        this.this$0.X.setVisibility(8);
      }
      else
      {
        this.this$0.X.setVisibility(8);
      }
      if (this.this$0.an != null) {
        this.this$0.an.setVisibility(8);
      }
      if (!this.b.equals(this.this$0.am[0]))
      {
        localPoiMapActivity = this.this$0;
        localPoiMapActivity.r = 0;
        localPoiMapActivity.d[0].b(true);
      }
    }
    else
    {
      this.this$0.X.setVisibility(8);
      if (this.this$0.an != null) {
        this.this$0.an.setVisibility(0);
      }
    }
    if (!TextUtils.isEmpty(this.c))
    {
      if (this.c.equals(this.this$0.F))
      {
        localPoiMapActivity = this.this$0;
        String str = this.c;
        ArrayList localArrayList = this.d;
        if (this.e <= 0) {
          bool1 = false;
        }
        localPoiMapActivity.a(str, localArrayList, bool1);
      }
    }
    else {
      this.this$0.a(this.d, this.f, this.g, this.b, this.e, this.h, this.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.12
 * JD-Core Version:    0.7.0.1
 */