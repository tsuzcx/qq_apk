package com.tencent.biz.pubaccount.readinjoy.video.bandwidth;

class MaxPredictor
  extends IBandwidthPredictor
{
  long a(long paramLong)
  {
    return Math.max(paramLong, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.bandwidth.MaxPredictor
 * JD-Core Version:    0.7.0.1
 */