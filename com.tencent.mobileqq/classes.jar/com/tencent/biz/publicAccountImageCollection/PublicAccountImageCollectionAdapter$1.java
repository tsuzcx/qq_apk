package com.tencent.biz.publicAccountImageCollection;

class PublicAccountImageCollectionAdapter$1
  implements PublicAccountImageCollectionListView.ListViewEventListener
{
  PublicAccountImageCollectionAdapter$1(PublicAccountImageCollectionAdapter paramPublicAccountImageCollectionAdapter) {}
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof PublicAccountImageCollectionAdapter.CoverHolder))
    {
      if (!this.a.b) {
        ((PublicAccountImageCollectionMainActivity)PublicAccountImageCollectionAdapter.a(this.a)).h();
      }
      this.a.b = true;
    }
    while ((paramObject instanceof PublicAccountImageCollectionAdapter.ImageItemHolder)) {
      if (PublicAccountImageCollectionAdapter.a(this.a))
      {
        this.a.d(true);
        return;
        ((PublicAccountImageCollectionMainActivity)PublicAccountImageCollectionAdapter.a(this.a)).g();
      }
      else
      {
        this.a.d(false);
        return;
      }
    }
    this.a.d(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionAdapter.1
 * JD-Core Version:    0.7.0.1
 */