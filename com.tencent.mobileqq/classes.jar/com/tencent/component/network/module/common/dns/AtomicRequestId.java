package com.tencent.component.network.module.common.dns;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicRequestId
{
  private static final int initValue = 100;
  private static final int maxValue = 65535;
  private static AtomicRequestId reqId;
  private static AtomicInteger reqIdentity = new AtomicInteger(100);
  
  public static AtomicRequestId getInstance()
  {
    try
    {
      if (reqId == null) {
        reqId = new AtomicRequestId();
      }
      AtomicRequestId localAtomicRequestId = reqId;
      return localAtomicRequestId;
    }
    finally {}
  }
  
  public int getId()
  {
    try
    {
      int j = reqIdentity.getAndIncrement();
      int i = j;
      if (j >= 65535)
      {
        reqIdentity = new AtomicInteger(100);
        i = reqIdentity.getAndIncrement();
      }
      return i;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.module.common.dns.AtomicRequestId
 * JD-Core Version:    0.7.0.1
 */