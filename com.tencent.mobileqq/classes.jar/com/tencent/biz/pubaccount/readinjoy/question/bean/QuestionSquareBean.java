package com.tencent.biz.pubaccount.readinjoy.question.bean;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import tencent.im.oidb.cmd0xbe7.oidb_cmd0xbe7.QuestionInfo;

public class QuestionSquareBean
  extends Entity
{
  public int answerNum;
  public int fanNum;
  public String rowKey;
  public int strategyId;
  public String title;
  public String uin = "";
  public String wendaUrl;
  
  public void convertPB2Info(String paramString, oidb_cmd0xbe7.QuestionInfo paramQuestionInfo)
  {
    if (paramQuestionInfo.bytes_rowkey.has())
    {
      if (paramQuestionInfo.bytes_rowkey.get() != null)
      {
        str = paramQuestionInfo.bytes_rowkey.get().toStringUtf8();
        this.rowKey = str;
      }
    }
    else
    {
      if (paramQuestionInfo.bytes_title.has())
      {
        if (paramQuestionInfo.bytes_title.get() == null) {
          break label166;
        }
        str = paramQuestionInfo.bytes_title.get().toStringUtf8();
        label67:
        this.title = str;
      }
      if (paramQuestionInfo.bytes_url.has()) {
        if (paramQuestionInfo.bytes_url.get() == null) {
          break label172;
        }
      }
    }
    label166:
    label172:
    for (String str = paramQuestionInfo.bytes_url.get().toStringUtf8();; str = "")
    {
      this.wendaUrl = str;
      if (paramQuestionInfo.uint32_answer_num.has()) {
        this.answerNum = paramQuestionInfo.uint32_answer_num.get();
      }
      if (paramQuestionInfo.uint32_fans_num.has()) {
        this.fanNum = paramQuestionInfo.uint32_fans_num.get();
      }
      if (paramString != null) {
        this.uin = paramString;
      }
      return;
      str = "";
      break;
      str = "";
      break label67;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.question.bean.QuestionSquareBean
 * JD-Core Version:    0.7.0.1
 */