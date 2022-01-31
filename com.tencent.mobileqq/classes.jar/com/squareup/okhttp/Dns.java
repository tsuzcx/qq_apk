package com.squareup.okhttp;

import java.net.InetAddress;
import java.util.List;

public abstract interface Dns
{
  public static final Dns SYSTEM = new Dns.1();
  
  public abstract List<InetAddress> lookup(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.Dns
 * JD-Core Version:    0.7.0.1
 */