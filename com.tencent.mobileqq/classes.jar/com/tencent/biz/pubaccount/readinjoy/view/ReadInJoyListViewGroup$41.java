package com.tencent.biz.pubaccount.readinjoy.view;

class ReadInJoyListViewGroup$41
  implements Runnable
{
  ReadInJoyListViewGroup$41(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      int i = this.this$0.a.getFirstVisiblePosition();
      this.this$0.a.setAdapter(ReadInJoyListViewGroup.a(this.this$0));
      this.this$0.a.post(new ReadInJoyListViewGroup.41.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.41
 * JD-Core Version:    0.7.0.1
 */