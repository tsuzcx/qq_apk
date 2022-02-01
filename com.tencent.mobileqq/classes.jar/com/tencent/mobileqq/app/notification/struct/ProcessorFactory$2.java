package com.tencent.mobileqq.app.notification.struct;

import aorr;
import aors;
import aort;
import aoru;
import aorv;
import aorx;
import aory;
import aorz;
import aosa;
import aosb;
import aosc;
import aosd;
import aose;
import aosf;
import aosg;
import aosh;
import aosk;
import aoso;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class ProcessorFactory$2
  extends HashMap<Integer, Class<? extends aosk>>
{
  public ProcessorFactory$2()
  {
    if ((aoso.a() != null) && (aoso.a().isEmpty())) {}
    Iterator localIterator = aoso.a().iterator();
    while (localIterator.hasNext()) {
      put((Integer)localIterator.next(), aort.class);
    }
    put(Integer.valueOf(3000), aors.class);
    put(Integer.valueOf(1), aoru.class);
    put(Integer.valueOf(7000), aosg.class);
    put(Integer.valueOf(6000), aory.class);
    put(Integer.valueOf(1010), aorz.class);
    put(Integer.valueOf(1001), aorz.class);
    put(Integer.valueOf(10002), aorz.class);
    put(Integer.valueOf(1032), aorx.class);
    put(Integer.valueOf(1037), aosd.class);
    put(Integer.valueOf(1044), aose.class);
    put(Integer.valueOf(1045), aose.class);
    put(Integer.valueOf(1008), aosf.class);
    put(Integer.valueOf(9002), aorv.class);
    put(Integer.valueOf(9501), aosa.class);
    put(Integer.valueOf(10007), aosh.class);
    put(Integer.valueOf(7220), aosc.class);
    put(Integer.valueOf(7225), aosb.class);
    put(Integer.valueOf(0), aorr.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.struct.ProcessorFactory.2
 * JD-Core Version:    0.7.0.1
 */