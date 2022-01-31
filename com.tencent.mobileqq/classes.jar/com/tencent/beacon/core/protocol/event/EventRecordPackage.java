package com.tencent.beacon.core.protocol.event;

import com.tencent.beacon.core.wup.JceStruct;
import com.tencent.beacon.core.wup.a;
import com.tencent.beacon.core.wup.b;
import java.util.ArrayList;

public final class EventRecordPackage
  extends JceStruct
  implements Cloneable
{
  static ArrayList<EventRecord> cache_list;
  public ArrayList<EventRecord> list = null;
  
  public final void readFrom(a parama)
  {
    if (cache_list == null)
    {
      cache_list = new ArrayList();
      EventRecord localEventRecord = new EventRecord();
      cache_list.add(localEventRecord);
    }
    this.list = ((ArrayList)parama.a(cache_list, 0, true));
  }
  
  public final void writeTo(b paramb)
  {
    paramb.a(this.list, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.protocol.event.EventRecordPackage
 * JD-Core Version:    0.7.0.1
 */