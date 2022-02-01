package com.tencent.beacon.core.network.volley;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface RequestQueue$RequestEvent
{
  public static final int REQUEST_CACHE_LOOKUP_FINISHED = 2;
  public static final int REQUEST_CACHE_LOOKUP_STARTED = 1;
  public static final int REQUEST_FINISHED = 5;
  public static final int REQUEST_NETWORK_DISPATCH_FINISHED = 4;
  public static final int REQUEST_NETWORK_DISPATCH_STARTED = 3;
  public static final int REQUEST_QUEUED = 0;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.RequestQueue.RequestEvent
 * JD-Core Version:    0.7.0.1
 */