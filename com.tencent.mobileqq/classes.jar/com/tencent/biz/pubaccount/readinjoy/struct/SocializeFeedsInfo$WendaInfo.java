package com.tencent.biz.pubaccount.readinjoy.struct;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.AnswerDetail;
import tencent.im.oidb.articlesummary.articlesummary.WendaInfo;

public class SocializeFeedsInfo$WendaInfo
{
  public int a;
  public AnswerDetailInfo a;
  public String a;
  public List<Integer> a;
  public boolean a;
  public int b;
  public String b;
  public List<String> b;
  public int c;
  public String c;
  public List<String> c;
  public int d;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  
  public SocializeFeedsInfo$WendaInfo()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAnswerDetailInfo = new AnswerDetailInfo();
  }
  
  private static WendaInfo b(articlesummary.WendaInfo paramWendaInfo)
  {
    boolean bool = true;
    WendaInfo localWendaInfo = new WendaInfo();
    if (paramWendaInfo.uint32_is_super_wenda.has()) {
      if (paramWendaInfo.uint32_is_super_wenda.get() != 1) {
        break label500;
      }
    }
    for (;;)
    {
      localWendaInfo.jdField_a_of_type_Boolean = bool;
      if (paramWendaInfo.bytes_question_rowkey.has()) {
        localWendaInfo.jdField_a_of_type_JavaLangString = paramWendaInfo.bytes_question_rowkey.get().toStringUtf8();
      }
      if (paramWendaInfo.bytes_question_desc.has()) {
        localWendaInfo.jdField_b_of_type_JavaLangString = paramWendaInfo.bytes_question_desc.get().toStringUtf8();
      }
      if (paramWendaInfo.bytes_question_pic_url.has()) {
        localWendaInfo.jdField_c_of_type_JavaLangString = paramWendaInfo.bytes_question_pic_url.get().toStringUtf8();
      }
      if (paramWendaInfo.bytes_wenda_url.has()) {
        localWendaInfo.jdField_d_of_type_JavaLangString = paramWendaInfo.bytes_wenda_url.get().toStringUtf8();
      }
      if (paramWendaInfo.uint32_follow_count.has()) {
        localWendaInfo.jdField_a_of_type_Int = paramWendaInfo.uint32_follow_count.get();
      }
      if (paramWendaInfo.uint32_answer_count.has()) {
        localWendaInfo.jdField_b_of_type_Int = paramWendaInfo.uint32_answer_count.get();
      }
      if (paramWendaInfo.bytes_icon_url.has()) {
        localWendaInfo.e = paramWendaInfo.bytes_icon_url.get().toStringUtf8();
      }
      if (paramWendaInfo.bytes_answer_url.has()) {
        localWendaInfo.f = paramWendaInfo.bytes_answer_url.get().toStringUtf8();
      }
      if (paramWendaInfo.channel_id.has()) {
        localWendaInfo.jdField_c_of_type_Int = paramWendaInfo.channel_id.get();
      }
      if (paramWendaInfo.channel_id_name.has()) {
        localWendaInfo.h = paramWendaInfo.channel_id_name.get();
      }
      if (paramWendaInfo.channel_second_id.has()) {
        localWendaInfo.jdField_d_of_type_Int = paramWendaInfo.channel_second_id.get();
      }
      if (paramWendaInfo.channel_second_id_name.has()) {
        localWendaInfo.i = paramWendaInfo.channel_second_id_name.get();
      }
      if (paramWendaInfo.tag_id.has()) {
        localWendaInfo.jdField_a_of_type_JavaUtilList = paramWendaInfo.tag_id.get();
      }
      if (paramWendaInfo.tag_id_name.has()) {
        localWendaInfo.jdField_b_of_type_JavaUtilList = paramWendaInfo.tag_id_name.get();
      }
      if (paramWendaInfo.author_nick.has()) {
        localWendaInfo.j = paramWendaInfo.author_nick.get();
      }
      if (paramWendaInfo.jump_url.has()) {
        localWendaInfo.k = paramWendaInfo.jump_url.get();
      }
      if (paramWendaInfo.images_url.has()) {
        localWendaInfo.jdField_c_of_type_JavaUtilList = paramWendaInfo.images_url.get();
      }
      if (paramWendaInfo.icon_name.has()) {
        localWendaInfo.l = paramWendaInfo.icon_name.get();
      }
      if (paramWendaInfo.icon_color.has()) {
        localWendaInfo.m = paramWendaInfo.icon_color.get();
      }
      if (paramWendaInfo.super_wenda_button_title.has()) {
        localWendaInfo.n = paramWendaInfo.super_wenda_button_title.get();
      }
      if (paramWendaInfo.answer_detail.has()) {
        localWendaInfo.a((articlesummary.AnswerDetail)paramWendaInfo.answer_detail.get());
      }
      return localWendaInfo;
      label500:
      bool = false;
    }
  }
  
  public articlesummary.WendaInfo a()
  {
    articlesummary.WendaInfo localWendaInfo = new articlesummary.WendaInfo();
    PBUInt32Field localPBUInt32Field = localWendaInfo.uint32_is_super_wenda;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      localPBUInt32Field.set(i1);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localWendaInfo.bytes_question_rowkey.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        localWendaInfo.bytes_question_desc.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        localWendaInfo.bytes_question_pic_url.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        localWendaInfo.bytes_wenda_url.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
      }
      localWendaInfo.uint32_follow_count.set(this.jdField_a_of_type_Int);
      localWendaInfo.uint32_answer_count.set(this.jdField_b_of_type_Int);
      if (!TextUtils.isEmpty(this.e)) {
        localWendaInfo.bytes_icon_url.set(ByteStringMicro.copyFromUtf8(this.e));
      }
      if (!TextUtils.isEmpty(this.f)) {
        localWendaInfo.bytes_answer_url.set(ByteStringMicro.copyFromUtf8(this.f));
      }
      localWendaInfo.channel_id.set(this.jdField_c_of_type_Int);
      if (!TextUtils.isEmpty(this.h)) {
        localWendaInfo.channel_id_name.set(this.h);
      }
      localWendaInfo.channel_second_id.set(this.jdField_d_of_type_Int);
      if (!TextUtils.isEmpty(this.i)) {
        localWendaInfo.channel_second_id_name.set(this.i);
      }
      localWendaInfo.tag_id.set(this.jdField_a_of_type_JavaUtilList);
      localWendaInfo.tag_id_name.set(this.jdField_b_of_type_JavaUtilList);
      if (!TextUtils.isEmpty(this.j)) {
        localWendaInfo.author_nick.set(this.j);
      }
      if (!TextUtils.isEmpty(this.k)) {
        localWendaInfo.jump_url.set(this.k);
      }
      localWendaInfo.images_url.set(this.jdField_c_of_type_JavaUtilList);
      if (!TextUtils.isEmpty(this.l)) {
        localWendaInfo.icon_name.set(this.l);
      }
      if (!TextUtils.isEmpty(this.m)) {
        localWendaInfo.icon_color.set(this.m);
      }
      if (!TextUtils.isEmpty(this.n)) {
        localWendaInfo.super_wenda_button_title.set(this.n);
      }
      localWendaInfo.answer_detail.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAnswerDetailInfo.a());
      return localWendaInfo;
    }
  }
  
  public void a(articlesummary.AnswerDetail paramAnswerDetail)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAnswerDetailInfo = AnswerDetailInfo.a(paramAnswerDetail);
  }
  
  public String toString()
  {
    return "isSuperWenda = " + this.jdField_a_of_type_Boolean + ", questionRowkey = " + this.jdField_a_of_type_JavaLangString + ", questionDes = " + this.jdField_b_of_type_JavaLangString + ", questionPicUrl = " + this.jdField_c_of_type_JavaLangString + ", wendaUrl = " + this.jdField_d_of_type_JavaLangString + ", followCount = " + this.jdField_a_of_type_Int + ", answerCount = " + this.jdField_b_of_type_Int + ", questionIconUrl = " + this.e + ", answerUrl = " + this.f + ", questionPicUrlForSmartCrop = " + this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.WendaInfo
 * JD-Core Version:    0.7.0.1
 */