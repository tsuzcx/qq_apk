package com.huawei.hms.support.api.transport;

import com.huawei.hms.support.api.client.ApiClient;

public abstract interface DatagramTransport
{
  public abstract void post(ApiClient paramApiClient, DatagramTransport.a parama);
  
  public abstract void send(ApiClient paramApiClient, DatagramTransport.a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.api.transport.DatagramTransport
 * JD-Core Version:    0.7.0.1
 */