package com.tencent.mobileqq.app.notification.struct;

import anoy;
import anoz;
import anpa;
import anpb;
import anpc;
import anpe;
import anpf;
import anpg;
import anph;
import anpi;
import anpj;
import anpk;
import anpl;
import anpm;
import anpn;
import anpo;
import anpr;
import anpv;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class ProcessorFactory$2
  extends HashMap<Integer, Class<? extends anpr>>
{
  public ProcessorFactory$2()
  {
    if ((anpv.a() != null) && (anpv.a().isEmpty())) {}
    Iterator localIterator = anpv.a().iterator();
    while (localIterator.hasNext()) {
      put((Integer)localIterator.next(), anpa.class);
    }
    put(Integer.valueOf(3000), anoz.class);
    put(Integer.valueOf(1), anpb.class);
    put(Integer.valueOf(7000), anpn.class);
    put(Integer.valueOf(6000), anpf.class);
    put(Integer.valueOf(1010), anpg.class);
    put(Integer.valueOf(1001), anpg.class);
    put(Integer.valueOf(10002), anpg.class);
    put(Integer.valueOf(1032), anpe.class);
    put(Integer.valueOf(1037), anpk.class);
    put(Integer.valueOf(1044), anpl.class);
    put(Integer.valueOf(1045), anpl.class);
    put(Integer.valueOf(1008), anpm.class);
    put(Integer.valueOf(9002), anpc.class);
    put(Integer.valueOf(9501), anph.class);
    put(Integer.valueOf(10007), anpo.class);
    put(Integer.valueOf(7220), anpj.class);
    put(Integer.valueOf(7225), anpi.class);
    put(Integer.valueOf(0), anoy.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.struct.ProcessorFactory.2
 * JD-Core Version:    0.7.0.1
 */