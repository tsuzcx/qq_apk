package com.tencent.beacon.core.event;

import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.protocol.event.EventRecord;
import com.tencent.beacon.core.protocol.event.EventRecordPackage;
import java.util.ArrayList;
import java.util.List;

final class b$a
  implements b.b
{
  public final byte[] a(List<RDBean> paramList, List<Long> paramList1)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        try
        {
          RDBean localRDBean = (RDBean)paramList.get(i);
          if ((localRDBean.getEMap() == null) || (!"UA".equals(localRDBean.getTP()))) {
            break label203;
          }
          b.f("[event] pack eName: %s", new Object[] { localRDBean.getEN() });
          EventRecord localEventRecord = j.a(localRDBean);
          if (localEventRecord != null) {
            localArrayList.add(localEventRecord);
          } else {
            paramList1.add(Long.valueOf(localRDBean.getCid()));
          }
        }
        catch (Throwable paramList)
        {
          b.d("[event] encode2MixPackage error.", new Object[0]);
          b.a(paramList);
        }
      }
      else
      {
        do
        {
          return null;
          b.b("[event] up erList:" + localArrayList.size(), new Object[0]);
        } while (localArrayList.size() <= 0);
        paramList = new EventRecordPackage();
        paramList.list = localArrayList;
        paramList = paramList.toByteArray();
        return paramList;
      }
      label203:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.b.a
 * JD-Core Version:    0.7.0.1
 */