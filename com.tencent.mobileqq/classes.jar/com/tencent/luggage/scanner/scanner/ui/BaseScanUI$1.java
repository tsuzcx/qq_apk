package com.tencent.luggage.scanner.scanner.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.scanner.qbar.d;
import com.tencent.luggage.scanner.qbar.e;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;

class BaseScanUI$1
  implements a.a
{
  BaseScanUI$1(BaseScanUI paramBaseScanUI) {}
  
  public void a(long paramLong, Bundle paramBundle)
  {
    boolean bool2 = BaseScanUI.a(this.a);
    boolean bool1 = false;
    if (!bool2)
    {
      o.c("Luggage.ScanUI", "alvinluo onScanSuccess can not process code result currentMode: %d", new Object[] { Integer.valueOf(BaseScanUI.b(this.a)) });
      return;
    }
    if (paramBundle != null)
    {
      o.d("Luggage.ScanUI", "scan code cost time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - BaseScanUI.c(this.a)) });
      Object localObject1 = paramBundle.getParcelableArrayList("result_qbar_result_list");
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        int i = paramBundle.getInt("result_code_point_count", 0);
        long l = paramBundle.getLong("decode_success_cost_time", 0L);
        d locald = (d)((ArrayList)localObject1).get(0);
        Object localObject2;
        if (BaseScanUI.d(this.a))
        {
          if (locald == null)
          {
            o.c("Luggage.ScanUI", "first Qbar result is null");
            return;
          }
          paramBundle = locald.typeName;
          localObject1 = locald.data;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_scan_result", (String)localObject1);
          ((Intent)localObject2).putExtra("key_scan_result_raw", locald.rawData);
          ((Intent)localObject2).putExtra("key_scan_result_code_name", paramBundle);
          ((Intent)localObject2).putExtra("key_scan_result_code_version", locald.a);
          this.a.setResult(-1, (Intent)localObject2);
          this.a.finish();
          return;
        }
        paramBundle.putInt("qbar_string_scan_source", 0);
        if ((i > 0) && (BaseScanUI.e(this.a) != null))
        {
          o.d("Luggage.ScanUI", "scanCode cost: %d", new Object[] { Long.valueOf(l) });
          localObject2 = (e)paramBundle.getParcelable("decode_success_frame_data");
          if (localObject2 != null) {
            BaseScanUI.e(this.a).setDecodeSuccessFrameData((e)localObject2);
          }
          localObject2 = this.a;
          if (i > 1) {
            bool1 = true;
          }
          BaseScanUI.a((BaseScanUI)localObject2, bool1);
          if (i > 1) {
            BaseScanUI.a(this.a, true, null);
          }
          BaseScanUI.b(this.a, true);
          BaseScanUI.e(this.a).setSuccessMarkClickListener(new BaseScanUI.1.1(this, (ArrayList)localObject1, i, paramLong, paramBundle));
          BaseScanUI.f(this.a);
          BaseScanUI.e(this.a).a(localObject1, new BaseScanUI.1.2(this, i, (ArrayList)localObject1, paramLong, paramBundle, locald));
          return;
        }
        BaseScanUI.a(this.a, paramLong, paramBundle, locald);
        return;
      }
      o.c("Luggage.ScanUI", "alvinluo onScanSuccess qbarResult invalid");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.BaseScanUI.1
 * JD-Core Version:    0.7.0.1
 */