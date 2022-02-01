package com.tencent.biz.pubaccount.readinjoy.video.bandwidth;

class DoubleExponentialPredictor
  extends IBandwidthPredictor
{
  private final float jdField_a_of_type_Float;
  private final ExponentialPredictor jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoBandwidthExponentialPredictor;
  private final ExponentialPredictor b;
  
  public long a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoBandwidthExponentialPredictor.a(paramLong);
    paramLong = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoBandwidthExponentialPredictor.b;
    this.b.a(paramLong);
    long l = this.b.b;
    float f = this.jdField_a_of_type_Float / (1.0F - this.jdField_a_of_type_Float);
    return ((float)(paramLong - l) * f + (float)(2L * paramLong - l));
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoBandwidthExponentialPredictor.a();
    this.b.a();
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoBandwidthExponentialPredictor.b();
    this.b.b();
  }
  
  public String toString()
  {
    return "DoubleExponentialPredictor(" + this.jdField_a_of_type_Float + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.bandwidth.DoubleExponentialPredictor
 * JD-Core Version:    0.7.0.1
 */