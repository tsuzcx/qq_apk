package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo.Builder;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ReadInJoyUgcSearchTopicFragment$2
  extends ReadInJoyObserver
{
  ReadInJoyUgcSearchTopicFragment$2(ReadInJoyUgcSearchTopicFragment paramReadInJoyUgcSearchTopicFragment) {}
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    if ((0L != paramLong) && (!TextUtils.isEmpty(paramString))) {
      if ((ReadInJoyUgcSearchTopicFragment.a(this.a) != null) && (ReadInJoyUgcSearchTopicFragment.a(this.a).size() == 1))
      {
        TopicInfo localTopicInfo = (TopicInfo)ReadInJoyUgcSearchTopicFragment.a(this.a).get(0);
        long l = localTopicInfo.a();
        String str1 = localTopicInfo.a();
        String str2 = localTopicInfo.b();
        String str3 = localTopicInfo.c();
        localTopicInfo.d();
        localTopicInfo = TopicInfo.a().a(l).a("#" + str1).b(str2).c(str3).d(paramString).a();
        ReadInJoyUgcSearchTopicFragment.a(this.a, localTopicInfo);
        ReadInJoyUtils.a("0X800980A", ReadInJoyUgcSearchTopicFragment.a(this.a), paramLong, "1");
        RIJDeliverUGCReportUtil.a(String.valueOf(paramLong), "1");
      }
    }
    for (;;)
    {
      ReadInJoyUgcSearchTopicFragment.a(this.a, false);
      QLog.d("ReadInJoyUgcSearchTopicFragment", 1, "handle0xc16CreateTopic, topicID:" + paramLong + "  topicUrl:" + paramString + " result:" + paramInt);
      return;
      this.a.a(1, this.a.getString(2131718172));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyUgcSearchTopicFragment.2
 * JD-Core Version:    0.7.0.1
 */