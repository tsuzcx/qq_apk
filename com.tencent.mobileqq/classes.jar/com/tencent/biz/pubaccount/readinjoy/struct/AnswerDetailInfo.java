package com.tencent.biz.pubaccount.readinjoy.struct;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.articlesummary.AnswerDetail;

public class AnswerDetailInfo
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c = "";
  
  public AnswerDetailInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public static AnswerDetailInfo a(articlesummary.AnswerDetail paramAnswerDetail)
  {
    AnswerDetailInfo localAnswerDetailInfo = new AnswerDetailInfo();
    if (paramAnswerDetail.question_rowkey.has()) {
      localAnswerDetailInfo.jdField_a_of_type_JavaLangString = paramAnswerDetail.question_rowkey.get();
    }
    if (paramAnswerDetail.question_title.has()) {
      localAnswerDetailInfo.jdField_b_of_type_JavaLangString = paramAnswerDetail.question_title.get();
    }
    if (paramAnswerDetail.answer_content.has()) {
      localAnswerDetailInfo.c = paramAnswerDetail.answer_content.get();
    }
    if (paramAnswerDetail.agreed_num.has()) {
      localAnswerDetailInfo.jdField_a_of_type_Int = paramAnswerDetail.agreed_num.get();
    }
    if (paramAnswerDetail.card_style.has()) {
      localAnswerDetailInfo.jdField_b_of_type_Int = paramAnswerDetail.card_style.get();
    }
    return localAnswerDetailInfo;
  }
  
  public articlesummary.AnswerDetail a()
  {
    articlesummary.AnswerDetail localAnswerDetail = new articlesummary.AnswerDetail();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localAnswerDetail.question_rowkey.set(this.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localAnswerDetail.question_title.set(this.jdField_b_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.c)) {
      localAnswerDetail.answer_content.set(this.c);
    }
    localAnswerDetail.agreed_num.set(this.jdField_a_of_type_Int);
    localAnswerDetail.card_style.set(this.jdField_b_of_type_Int);
    return localAnswerDetail;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.AnswerDetailInfo
 * JD-Core Version:    0.7.0.1
 */