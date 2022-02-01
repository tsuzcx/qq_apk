package com.tencent.biz.publicAccountImageCollection;

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
    this.a.a = true;
    PublicAccountImageCollectionAdapter.a(this.a);
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(Object paramObject)
  {
    PublicAccountImageCollectionAdapter.a(this.a, 2131695222);
  }
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionAdapter.5
 * JD-Core Version:    0.7.0.1
 */