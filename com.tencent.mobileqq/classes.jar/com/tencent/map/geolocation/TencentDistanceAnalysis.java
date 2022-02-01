package com.tencent.map.geolocation;

public abstract interface TencentDistanceAnalysis
{
  public abstract double getConfidence();
  
  public abstract int getGpsCount();
  
  public abstract int getNetworkCount();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.geolocation.TencentDistanceAnalysis
 * JD-Core Version:    0.7.0.1
 */