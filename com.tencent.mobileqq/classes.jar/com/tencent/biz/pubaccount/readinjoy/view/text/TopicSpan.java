package com.tencent.biz.pubaccount.readinjoy.view.text;

import android.text.style.ForegroundColorSpan;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import sgy;
import sha;

public class TopicSpan
  extends ForegroundColorSpan
  implements sgy, sha
{
  private final TopicInfo a;
  
  public TopicSpan(TopicInfo paramTopicInfo)
  {
    super(-12084769);
    this.a = paramTopicInfo;
  }
  
  public TopicInfo a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.text.TopicSpan
 * JD-Core Version:    0.7.0.1
 */