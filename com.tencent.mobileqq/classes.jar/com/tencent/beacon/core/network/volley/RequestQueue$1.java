package com.tencent.beacon.core.network.volley;

class RequestQueue$1
  implements RequestQueue.RequestFilter
{
  RequestQueue$1(RequestQueue paramRequestQueue, Object paramObject) {}
  
  public boolean apply(Request<?> paramRequest)
  {
    return paramRequest.getTag() == this.val$tag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.RequestQueue.1
 * JD-Core Version:    0.7.0.1
 */