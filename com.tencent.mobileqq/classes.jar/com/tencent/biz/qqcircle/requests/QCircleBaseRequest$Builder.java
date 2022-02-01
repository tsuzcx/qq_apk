package com.tencent.biz.qqcircle.requests;

public abstract class QCircleBaseRequest$Builder<R extends QCircleBaseRequest>
{
  protected R a;
  private boolean b = false;
  
  protected abstract R b();
  
  public Builder<R> c()
  {
    this.b = true;
    return this;
  }
  
  public R d()
  {
    this.a = b();
    this.a.setEnableCache(this.b);
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleBaseRequest.Builder
 * JD-Core Version:    0.7.0.1
 */