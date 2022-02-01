package com.tencent.luggage.scanner.scanner.ui;

import android.os.Bundle;
import com.tencent.luggage.scanner.qbar.c;
import com.tencent.luggage.scanner.qbar.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.qbar.QBar.QBarResult;
import com.tencent.qbar.QbarNative.QBarPoint;
import com.tencent.qbar.QbarNative.QBarReportMsg;
import java.util.ArrayList;
import java.util.List;

class a$2$2
  implements Runnable
{
  a$2$2(a.2 param2, long paramLong, List paramList1, List paramList2, List paramList3, Bundle paramBundle) {}
  
  public void run()
  {
    long l1 = a.f(this.f.a);
    long l2 = this.a;
    if ((l1 == l2) && (l2 != 0L))
    {
      this.f.a.d();
      Object localObject1 = new ArrayList();
      Object localObject2 = this.b;
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        o.d("Luggage.ScanUIRectView", "alvinluo onDecodeSuccess result size: %d", new Object[] { Integer.valueOf(this.b.size()) });
        int i = 0;
        int k;
        for (int j = 0; i < this.b.size(); j = k)
        {
          localObject2 = (QBar.QBarResult)this.b.get(i);
          localObject2 = new d(((QBar.QBarResult)localObject2).typeID, ((QBar.QBarResult)localObject2).typeName, ((QBar.QBarResult)localObject2).data, ((QBar.QBarResult)localObject2).rawData, ((QBar.QBarResult)localObject2).charset, ((QBar.QBarResult)localObject2).priorityLevel);
          o.d("Luggage.ScanUIRectView", "alvinluo onDecodeSuccess result index: %d, format: %d, content:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(((d)localObject2).typeID), ((d)localObject2).data });
          Object localObject3 = this.c;
          if ((localObject3 != null) && (((List)localObject3).size() >= i + 1))
          {
            localObject3 = (QbarNative.QBarReportMsg)this.c.get(i);
            if (localObject3 != null) {
              ((d)localObject2).a = ((QbarNative.QBarReportMsg)localObject3).qrcodeVersion;
            }
          }
          localObject3 = this.d;
          k = j;
          if (localObject3 != null)
          {
            k = j;
            if (((List)localObject3).size() >= i + 1)
            {
              localObject3 = (QbarNative.QBarPoint)this.d.get(i);
              k = j;
              if (localObject3 != null)
              {
                ((d)localObject2).b = new c((QbarNative.QBarPoint)localObject3);
                k = j + 1;
              }
            }
          }
          ((ArrayList)localObject1).add(localObject2);
          i += 1;
        }
        localObject2 = new Bundle();
        ((Bundle)localObject2).putParcelableArrayList("result_qbar_result_list", (ArrayList)localObject1);
        ((Bundle)localObject2).putInt("result_code_point_count", j);
        localObject1 = this.e;
        if (localObject1 != null) {
          ((Bundle)localObject2).putAll((Bundle)localObject1);
        }
        this.f.a.o();
        if (a.g(this.f.a) != null) {
          a.g(this.f.a).a(a.f(this.f.a), (Bundle)localObject2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.a.2.2
 * JD-Core Version:    0.7.0.1
 */