package com.tencent.beacon.base.net.adapter;

import com.tencent.beacon.base.net.a.b;
import com.tencent.beacon.base.net.a.f;
import com.tencent.beacon.base.net.a.k;

public abstract class a
{
  protected static final int CONNECT_TIMEOUT = 30000;
  protected static final int READ_TIMEOUT = 10000;
  
  public abstract void request(f paramf, b<com.tencent.beacon.base.net.a> paramb);
  
  public abstract void request(k paramk, b<byte[]> paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.adapter.a
 * JD-Core Version:    0.7.0.1
 */