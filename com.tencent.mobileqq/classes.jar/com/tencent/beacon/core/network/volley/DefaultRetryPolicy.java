package com.tencent.beacon.core.network.volley;

public class DefaultRetryPolicy
  implements RetryPolicy
{
  public static final float DEFAULT_BACKOFF_MULT = 1.0F;
  public static final int DEFAULT_MAX_RETRIES = 1;
  public static final int DEFAULT_TIMEOUT_MS = 2500;
  private final float mBackoffMultiplier;
  private int mCurrentRetryCount;
  private int mCurrentTimeoutMs;
  private final int mMaxNumRetries;
  
  public DefaultRetryPolicy()
  {
    this(2500, 1, 1.0F);
  }
  
  public DefaultRetryPolicy(int paramInt1, int paramInt2, float paramFloat)
  {
    this.mCurrentTimeoutMs = paramInt1;
    this.mMaxNumRetries = paramInt2;
    this.mBackoffMultiplier = paramFloat;
  }
  
  public float getBackoffMultiplier()
  {
    return this.mBackoffMultiplier;
  }
  
  public int getCurrentRetryCount()
  {
    return this.mCurrentRetryCount;
  }
  
  public int getCurrentTimeout()
  {
    return this.mCurrentTimeoutMs;
  }
  
  protected boolean hasAttemptRemaining()
  {
    return this.mCurrentRetryCount <= this.mMaxNumRetries;
  }
  
  public void retry(VolleyError paramVolleyError)
  {
    this.mCurrentRetryCount += 1;
    int i = this.mCurrentTimeoutMs;
    this.mCurrentTimeoutMs = (i + (int)(i * this.mBackoffMultiplier));
    if (hasAttemptRemaining()) {
      return;
    }
    throw paramVolleyError;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.DefaultRetryPolicy
 * JD-Core Version:    0.7.0.1
 */