package com.tencent.component.network.utils;

public final class NetworkUtils$DNS
{
  public String primary;
  public String secondary;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.primary);
    localStringBuilder.append(",");
    localStringBuilder.append(this.secondary);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.NetworkUtils.DNS
 * JD-Core Version:    0.7.0.1
 */