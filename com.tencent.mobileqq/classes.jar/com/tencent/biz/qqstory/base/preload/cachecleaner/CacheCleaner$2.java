package com.tencent.biz.qqstory.base.preload.cachecleaner;

class CacheCleaner$2
  implements Runnable
{
  CacheCleaner$2(CacheCleaner paramCacheCleaner, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = new TimeCleanStep(CacheCleaner.c);
    CapacityCleanStep localCapacityCleanStep = new CapacityCleanStep(CacheCleaner.d);
    MyVideoCleanStep localMyVideoCleanStep = new MyVideoCleanStep(CacheCleaner.e);
    UploadTmpVideoCleanStep localUploadTmpVideoCleanStep = new UploadTmpVideoCleanStep(CacheCleaner.f);
    localCapacityCleanStep.a(localMyVideoCleanStep).a(localUploadTmpVideoCleanStep).a((AbsCleanStep)localObject);
    localObject = new AbsCleanStep.CleanContext();
    ((AbsCleanStep.CleanContext)localObject).a = this.a;
    ((AbsCleanStep.CleanContext)localObject).b = System.currentTimeMillis();
    localCapacityCleanStep.a((AbsCleanStep.CleanContext)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.cachecleaner.CacheCleaner.2
 * JD-Core Version:    0.7.0.1
 */