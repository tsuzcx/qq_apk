package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember;

import com.tencent.mobileqq.widget.QQToast;

class ReadInJoySelectMemberAQFragment$1
  implements Runnable
{
  ReadInJoySelectMemberAQFragment$1(ReadInJoySelectMemberAQFragment paramReadInJoySelectMemberAQFragment, int paramInt) {}
  
  public void run()
  {
    if ((this.this$0.a) || (this.this$0.getActivity() == null)) {
      return;
    }
    this.this$0.a();
    QQToast.a(this.this$0.getActivity(), 1, this.this$0.getString(this.a), 0).b(ReadInJoySelectMemberAQFragment.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberAQFragment.1
 * JD-Core Version:    0.7.0.1
 */