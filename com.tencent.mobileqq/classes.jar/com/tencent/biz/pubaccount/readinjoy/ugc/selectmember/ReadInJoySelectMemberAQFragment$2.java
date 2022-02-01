package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember;

import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class ReadInJoySelectMemberAQFragment$2
  extends ReadInJoyObserver
{
  ReadInJoySelectMemberAQFragment$2(ReadInJoySelectMemberAQFragment paramReadInJoySelectMemberAQFragment) {}
  
  public void e(String paramString, int paramInt)
  {
    if (("OidbSvc.0xbd4_1".equals(paramString)) && (this.a.getActivity() != null))
    {
      this.a.a = true;
      this.a.a();
      if (paramInt == 0)
      {
        ReadInJoySelectMemberAQFragment.a(this.a, 0);
        ReadInJoySelectMemberAQFragment.a(this.a, false);
        this.a.c();
        this.a.getActivity().finish();
        ReadInJoySelectMemberAQFragment.a(this.a, true);
      }
    }
    else
    {
      return;
    }
    ReadInJoySelectMemberAQFragment.a(this.a, true);
    ReadInJoySelectMemberAQFragment.a(this.a, 2);
    ReadInJoySelectMemberAQFragment.a(this.a, HardCodeUtil.a(2131712721) + paramInt);
    QQToast.a(this.a.getActivity(), 1, this.a.getString(2131718361), 0).b(ReadInJoySelectMemberAQFragment.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberAQFragment.2
 * JD-Core Version:    0.7.0.1
 */