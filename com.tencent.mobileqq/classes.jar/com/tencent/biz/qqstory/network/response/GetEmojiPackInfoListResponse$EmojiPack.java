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
  public final String a;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  public final String g;
  public final int h;
  public final int i;
  
  public GetEmojiPackInfoListResponse$EmojiPack(qqstory_struct.EmoticonPack paramEmoticonPack)
  {
    this.a = String.valueOf(paramEmoticonPack.pack_id.get());
    this.b = paramEmoticonPack.icon.get().toStringUtf8();
    this.d = paramEmoticonPack.name.get().toStringUtf8();
    this.e = paramEmoticonPack.download_url.get().toStringUtf8();
    this.f = paramEmoticonPack.md5.get().toStringUtf8();
    this.h = paramEmoticonPack.version.get();
    this.i = a(paramEmoticonPack.type.get());
    this.c = paramEmoticonPack.download_icon.get().toStringUtf8();
    this.g = paramEmoticonPack.config.get().toStringUtf8();
  }
  
  private int a(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2)) {
      return 1;
    }
    return paramInt;
  }
  
  public boolean a()
  {
    int j = this.i;
    boolean bool3 = false;
    boolean bool2 = false;
    if (j == 1)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.b))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(this.d))
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.e))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(this.f)) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    boolean bool1 = bool3;
    if (!TextUtils.isEmpty(this.b))
    {
      bool1 = bool3;
      if (!TextUtils.isEmpty(this.d)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (EmojiPack)paramObject;
      String str = this.a;
      if (str != null) {
        if (str.equals(paramObject.a)) {
          break label65;
        }
      } else if (paramObject.a == null) {
        return true;
      }
      bool = false;
      label65:
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.a;
    if (str != null) {
      return str.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EmojiPack{mPackId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mLogoUrl='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mPackName='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mPackDownloadUrl='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetEmojiPackInfoListResponse.EmojiPack
 * JD-Core Version:    0.7.0.1
 */