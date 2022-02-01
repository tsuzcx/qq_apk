package com.tencent.biz.pubaccount.imagecollection;

import com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl;

class PublicAccountImageCollectionAdapter$1
  implements PublicAccountImageCollectionListView.ListViewEventListener
{
  PublicAccountImageCollectionAdapter$1(PublicAccountImageCollectionAdapter paramPublicAccountImageCollectionAdapter) {}
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof PublicAccountImageCollectionAdapter.CoverHolder))
    {
      if (!this.a.i) {
        ((PublicAccountImageCollectionMainActivityImpl)PublicAccountImageCollectionAdapter.a(this.a)).showUserGuide();
      }
      this.a.i = true;
    }
    else
    {
      ((PublicAccountImageCollectionMainActivityImpl)PublicAccountImageCollectionAdapter.a(this.a)).hideUserGuide();
    }
    if ((paramObject instanceof PublicAccountImageCollectionAdapter.ImageItemHolder))
    {
      if (PublicAccountImageCollectionAdapter.b(this.a))
      {
        this.a.d(true);
        return;
      }
      this.a.d(false);
      return;
    }
    this.a.d(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionAdapter.1
 * JD-Core Version:    0.7.0.1
 */