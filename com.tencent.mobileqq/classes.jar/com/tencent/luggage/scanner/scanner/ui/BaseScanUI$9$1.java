package com.tencent.luggage.scanner.scanner.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.qbar.QBar.QBarResult;
import com.tencent.qbar.QbarNative.QBarReportMsg;
import java.util.List;

class BaseScanUI$9$1
  implements Runnable
{
  BaseScanUI$9$1(BaseScanUI.9 param9, List paramList1, List paramList2) {}
  
  public void run()
  {
    Object localObject1 = this.c.b;
    int j = 0;
    BaseScanUI.b((BaseScanUI)localObject1, false);
    localObject1 = this.a;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("result_content", ((QBar.QBarResult)this.a.get(0)).data);
      ((Bundle)localObject1).putInt("result_code_format", ((QBar.QBarResult)this.a.get(0)).typeID);
      ((Bundle)localObject1).putString("result_code_name", ((QBar.QBarResult)this.a.get(0)).typeName);
      Object localObject2 = ((QBar.QBarResult)this.a.get(0)).rawData;
      if (localObject2 != null) {
        ((Bundle)localObject1).putByteArray("result_raw_data", (byte[])localObject2);
      }
      localObject2 = this.b;
      int i = j;
      if (localObject2 != null)
      {
        i = j;
        if (!((List)localObject2).isEmpty()) {
          i = ((QbarNative.QBarReportMsg)this.b.get(0)).qrcodeVersion;
        }
      }
      ((Bundle)localObject1).putInt("result_code_version", i);
      if (BaseScanUI.d(this.c.b))
      {
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("key_scan_result", ((Bundle)localObject1).getString("result_content"));
        ((Intent)localObject2).putExtra("key_scan_result_raw", ((Bundle)localObject1).getByteArray("result_raw_data"));
        ((Intent)localObject2).putExtra("key_scan_result_code_name", ((Bundle)localObject1).getString("result_code_name"));
        ((Intent)localObject2).putExtra("key_scan_result_code_version", i);
        this.c.b.setResult(-1, (Intent)localObject2);
        this.c.b.finish();
        BaseScanUI.f(this.c.b);
        return;
      }
      ((Bundle)localObject1).putInt("qbar_string_scan_source", 1);
      BaseScanUI.f(this.c.b);
      return;
    }
    BaseScanUI.b(this.c.b, true);
    BaseScanUI.c(this.c.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.BaseScanUI.9.1
 * JD-Core Version:    0.7.0.1
 */