package com.tencent.biz.pubaccount.readinjoy.struct;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.articlesummary.KdLiveInfo;

public class KandianLiveInfo
{
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public static KandianLiveInfo a(articlesummary.KdLiveInfo paramKdLiveInfo)
  {
    KandianLiveInfo localKandianLiveInfo = new KandianLiveInfo();
    localKandianLiveInfo.jdField_a_of_type_Int = paramKdLiveInfo.uint32_style_type.get();
    localKandianLiveInfo.jdField_a_of_type_JavaLangString = paramKdLiveInfo.bytes_status_bg_url.get().toStringUtf8();
    localKandianLiveInfo.b = paramKdLiveInfo.bytes_status_icon_url.get().toStringUtf8();
    localKandianLiveInfo.c = paramKdLiveInfo.bytes_status_text.get().toStringUtf8();
    localKandianLiveInfo.d = paramKdLiveInfo.bytes_hot_icon_url.get().toStringUtf8();
    localKandianLiveInfo.e = paramKdLiveInfo.bytes_hot_text.get().toStringUtf8();
    localKandianLiveInfo.f = paramKdLiveInfo.bytes_title_jump_url.get().toStringUtf8();
    localKandianLiveInfo.g = paramKdLiveInfo.bytes_report_common_data.get().toStringUtf8();
    return localKandianLiveInfo;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n").append("style=").append(this.jdField_a_of_type_Int).append("\n").append("statusBgUrl=").append(this.jdField_a_of_type_JavaLangString).append("\n").append("statusIconUrl=").append(this.b).append("\n").append("statusText=").append(this.c).append("\n").append("hotIconUrl=").append(this.d).append("\n").append("hotText=").append(this.e).append("\n").append("titleJumpUrl=").append(this.f).append("\n").append("reportCommonData=").append(this.g).append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianLiveInfo
 * JD-Core Version:    0.7.0.1
 */