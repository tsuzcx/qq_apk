package com.tencent.beacon.core.event;

import com.tencent.beacon.core.e.d;
import com.tencent.beacon.core.protocol.event.EventRecordPackage;
import com.tencent.beacon.core.wup.JceStruct;
import java.util.ArrayList;
import java.util.List;

class e$a
  implements e.b
{
  public byte[] a(List<RDBean> paramList, List<Long> paramList1)
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
          Object localObject = localRDBean.getEMap();
          if (localObject == null) {
            break label216;
          }
          boolean bool = "UA".equals(localRDBean.getTP());
          if (!bool) {
            break label216;
          }
          d.f("[event] pack eName: %s", new Object[] { localRDBean.getEN() });
          localObject = s.a(localRDBean);
          if (localObject != null) {
            localArrayList.add(localObject);
          } else {
            paramList1.add(Long.valueOf(localRDBean.getCid()));
          }
        }
        catch (Throwable paramList)
        {
          d.b("[event] encode2MixPackage error.", new Object[0]);
          d.a(paramList);
        }
      }
      else
      {
        do
        {
          return null;
          paramList = new StringBuilder();
          d.a("[event] up erList:" + localArrayList.size(), new Object[0]);
        } while (localArrayList.size() <= 0);
        paramList = new EventRecordPackage();
        paramList.list = localArrayList;
        paramList = paramList.toByteArray();
        return paramList;
      }
      label216:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.e.a
 * JD-Core Version:    0.7.0.1
 */