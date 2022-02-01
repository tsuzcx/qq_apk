package com.tencent.beacon.core.network.volley;

abstract interface Request$NetworkRequestCompleteListener
{
  public abstract void onNoUsableResponseReceived(Request<?> paramRequest);
  
  public abstract void onResponseReceived(Request<?> paramRequest, Response<?> paramResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.Request.NetworkRequestCompleteListener
 * JD-Core Version:    0.7.0.1
 */