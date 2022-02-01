package com.tencent.biz.pubaccount.imagecollection;

import com.tencent.mobileqq.applets.NewPublicAccountObserver.ResponseResultListener;
import com.tencent.qphone.base.util.QLog;

class PublicAccountImageCollectionAdapter$5
  extends NewPublicAccountObserver.ResponseResultListener
{
  PublicAccountImageCollectionAdapter$5(PublicAccountImageCollectionAdapter paramPublicAccountImageCollectionAdapter) {}
  
  public int a()
  {
    return 0;
  }
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "follow success");
    }
    paramObject = this.a;
    paramObject.h = true;
    PublicAccountImageCollectionAdapter.d(paramObject);
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(Object paramObject)
  {
    PublicAccountImageCollectionAdapter.a(this.a, 2131892951);
  }
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionAdapter.5
 * JD-Core Version:    0.7.0.1
 */