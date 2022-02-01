package com.tencent.falco.base.libapi.network;

import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface NetworkStateInterface
  extends ServiceBaseInterface
{
  public abstract void addListener(OnNetworkListener paramOnNetworkListener);
  
  public abstract void init(NetworkStateAdapter paramNetworkStateAdapter);
  
  public abstract void removeListener(OnNetworkListener paramOnNetworkListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.network.NetworkStateInterface
 * JD-Core Version:    0.7.0.1
 */