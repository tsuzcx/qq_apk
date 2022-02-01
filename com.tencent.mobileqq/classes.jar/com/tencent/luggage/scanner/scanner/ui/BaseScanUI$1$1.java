package com.tencent.luggage.scanner.scanner.ui;

import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.scanner.qbar.d;
import com.tencent.luggage.scanner.scanner.ui.widget.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;

class BaseScanUI$1$1
  implements c
{
  BaseScanUI$1$1(BaseScanUI.1 param1, ArrayList paramArrayList, int paramInt, long paramLong, Bundle paramBundle) {}
  
  public void a(int paramInt, @Nullable View paramView)
  {
    o.d("Luggage.ScanUI", "alvinluo onScanSuccess onClick mark index: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt < this.a.size()) && (this.b > 1))
    {
      BaseScanUI.b(this.e.a, false);
      BaseScanUI.a(this.e.a, this.c, this.d, (d)this.a.get(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.BaseScanUI.1.1
 * JD-Core Version:    0.7.0.1
 */