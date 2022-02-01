package com.tencent.biz.pubaccount.readinjoy.video.bandwidth;

class DoubleMoveAvgPredictor
  extends IBandwidthPredictor
{
  private final int jdField_a_of_type_Int;
  private final MoveAvgPredictor jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoBandwidthMoveAvgPredictor;
  private final MoveAvgPredictor b;
  
  public long a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoBandwidthMoveAvgPredictor.a(paramLong);
    paramLong = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoBandwidthMoveAvgPredictor.b;
    this.b.a(paramLong);
    long l = this.b.b;
    float f = 2.0F / (Math.max(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoBandwidthMoveAvgPredictor.a(), 2) - 1);
    return ((float)(paramLong - l) * f + (float)(2L * paramLong - l));
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoBandwidthMoveAvgPredictor.a();
    this.b.a();
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoBandwidthMoveAvgPredictor.b();
    this.b.b();
  }
  
  public String toString()
  {
    return "DoubleMoveAvgPredictor(" + this.jdField_a_of_type_Int + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.bandwidth.DoubleMoveAvgPredictor
 * JD-Core Version:    0.7.0.1
 */