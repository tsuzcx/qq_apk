package com.tencent.mobileqq.activity.aio.item;

class QQStoryItemBuilder$8$1
  implements Runnable
{
  QQStoryItemBuilder$8$1(QQStoryItemBuilder.8 param8) {}
  
  public void run()
  {
    Long localLong = (Long)this.a.b.c.getTag();
    if (localLong != null)
    {
      if (localLong.longValue() != this.a.c) {
        return;
      }
      QQStoryItemBuilder.a(this.a.b.c, this.a.d, this.a.this$0.z, this.a.this$0.A, this.a.this$0.x);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.8.1
 * JD-Core Version:    0.7.0.1
 */