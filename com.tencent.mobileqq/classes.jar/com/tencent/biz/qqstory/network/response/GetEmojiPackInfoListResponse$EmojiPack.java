package com.tencent.biz.qqstory.network.response;

import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.EmoticonPack;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetEmojiPackInfoListResponse$EmojiPack
  implements Cloneable
{
  public final int a;
  public final String a;
  public final int b;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  public final String g;
  
  public GetEmojiPackInfoListResponse$EmojiPack(qqstory_struct.EmoticonPack paramEmoticonPack)
  {
    this.jdField_a_of_type_JavaLangString = String.valueOf(paramEmoticonPack.pack_id.get());
    this.jdField_b_of_type_JavaLangString = paramEmoticonPack.icon.get().toStringUtf8();
    this.d = paramEmoticonPack.name.get().toStringUtf8();
    this.e = paramEmoticonPack.download_url.get().toStringUtf8();
    this.f = paramEmoticonPack.md5.get().toStringUtf8();
    this.jdField_a_of_type_Int = paramEmoticonPack.version.get();
    this.jdField_b_of_type_Int = a(paramEmoticonPack.type.get());
    this.c = paramEmoticonPack.download_icon.get().toStringUtf8();
    this.g = paramEmoticonPack.config.get().toStringUtf8();
  }
  
  private int a(int paramInt)
  {
    int i = paramInt;
    switch (paramInt)
    {
    default: 
      i = 1;
    }
    return i;
  }
  
  public boolean a()
  {
    if (this.jdField_b_of_type_Int == 1) {
      if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(this.d)) || (TextUtils.isEmpty(this.e)) || (TextUtils.isEmpty(this.f))) {}
    }
    while ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.d)))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (EmojiPack)paramObject;
      if (this.jdField_a_of_type_JavaLangString == null) {
        break;
      }
    } while (this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString));
    while (paramObject.jdField_a_of_type_JavaLangString != null) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaLangString != null) {
      return this.jdField_a_of_type_JavaLangString.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    return "EmojiPack{mPackId=" + this.jdField_a_of_type_JavaLangString + ", mLogoUrl='" + this.jdField_b_of_type_JavaLangString + '\'' + ", mPackName='" + this.d + '\'' + ", mPackDownloadUrl='" + this.e + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetEmojiPackInfoListResponse.EmojiPack
 * JD-Core Version:    0.7.0.1
 */