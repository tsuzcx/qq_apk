package com.tencent.ark;

final class ArkTextureViewImpl$1
  implements Runnable
{
  ArkTextureViewImpl$1(ArkTextureViewImpl.ViewContext paramViewContext) {}
  
  public void run()
  {
    ArkTextureViewImpl.ENV.logI(ArkTextureViewImpl.TAG, String.format("releaseContext.run.model.%h.context.%h.queue.%s", new Object[] { this.val$viewContext.viewModel, this.val$viewContext.contextHolder, this.val$viewContext.viewModel.getQueueKey() }));
    this.val$viewContext.viewModel.destroyDrawTarget();
    if (this.val$viewContext.contextHolder != null)
    {
      this.val$viewContext.contextHolder.release();
      this.val$viewContext.contextHolder = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.ArkTextureViewImpl.1
 * JD-Core Version:    0.7.0.1
 */