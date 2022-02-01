package com.tencent.beacon.core.network.volley;

class ExecutorDelivery$ResponseDeliveryRunnable
  implements Runnable
{
  private final Request mRequest;
  private final Response mResponse;
  private final Runnable mRunnable;
  
  public ExecutorDelivery$ResponseDeliveryRunnable(Request paramRequest, Response paramResponse, Runnable paramRunnable)
  {
    this.mRequest = paramRequest;
    this.mResponse = paramResponse;
    this.mRunnable = paramRunnable;
  }
  
  public void run()
  {
    if (this.mRequest.isCanceled())
    {
      this.mRequest.finish("canceled-at-delivery");
      return;
    }
    if (this.mResponse.isSuccess())
    {
      this.mRequest.deliverResponse(this.mResponse.result);
      label44:
      if (!this.mResponse.intermediate) {
        break label96;
      }
      this.mRequest.addMarker("intermediate-response");
    }
    for (;;)
    {
      Runnable localRunnable = this.mRunnable;
      if (localRunnable == null) {
        break;
      }
      localRunnable.run();
      return;
      this.mRequest.deliverError(this.mResponse.error);
      break label44;
      label96:
      this.mRequest.finish("done");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.ExecutorDelivery.ResponseDeliveryRunnable
 * JD-Core Version:    0.7.0.1
 */