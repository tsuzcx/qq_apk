package com.tencent.biz.pubaccount.readinjoy.struct;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.articlesummary.articlesummary.HotWordItem;

public class HotWordItem
{
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  
  public HotWordItem()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static HotWordItem a(articlesummary.HotWordItem paramHotWordItem)
  {
    HotWordItem localHotWordItem = new HotWordItem();
    if (paramHotWordItem.hot_word.has()) {
      localHotWordItem.jdField_a_of_type_JavaLangString = paramHotWordItem.hot_word.get().toStringUtf8();
    }
    if (paramHotWordItem.jump_url.has()) {
      localHotWordItem.b = paramHotWordItem.jump_url.get().toStringUtf8();
    }
    if (paramHotWordItem.index_word_color.has()) {
      localHotWordItem.c = paramHotWordItem.index_word_color.get().toStringUtf8();
    }
    if (paramHotWordItem.index_bg_color.has()) {
      localHotWordItem.d = paramHotWordItem.index_bg_color.get().toStringUtf8();
    }
    return localHotWordItem;
  }
  
  public articlesummary.HotWordItem a()
  {
    articlesummary.HotWordItem localHotWordItem = new articlesummary.HotWordItem();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localHotWordItem.hot_word.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    }
    if (!TextUtils.isEmpty(this.d)) {
      localHotWordItem.index_bg_color.set(ByteStringMicro.copyFromUtf8(this.d));
    }
    if (!TextUtils.isEmpty(this.c)) {
      localHotWordItem.index_word_color.set(ByteStringMicro.copyFromUtf8(this.c));
    }
    if (!TextUtils.isEmpty(this.b)) {
      localHotWordItem.jump_url.set(ByteStringMicro.copyFromUtf8(this.b));
    }
    return localHotWordItem;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof HotWordItem)) {
      return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(((HotWordItem)paramObject).jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.b)) && (this.b.equals(((HotWordItem)paramObject).b));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.HotWordItem
 * JD-Core Version:    0.7.0.1
 */