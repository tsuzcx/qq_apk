package com.tencent.mobileqq.avatar.dynamicavatar;

class SelectCoverActivity$2
  implements Runnable
{
  SelectCoverActivity$2(SelectCoverActivity paramSelectCoverActivity) {}
  
  public void run()
  {
    if (this.this$0.F) {
      return;
    }
    if (this.this$0.a())
    {
      if (this.this$0.F) {
        return;
      }
      int i = 0;
      while (i < this.this$0.k)
      {
        if (!this.this$0.F) {
          this.this$0.b(i);
        }
        i += 1;
      }
      if ((this.this$0.x == 1) || (this.this$0.x == 3)) {
        SelectCoverActivity.a(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.2
 * JD-Core Version:    0.7.0.1
 */