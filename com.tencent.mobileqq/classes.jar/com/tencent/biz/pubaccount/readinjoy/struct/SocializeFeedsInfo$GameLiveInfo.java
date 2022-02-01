package com.tencent.biz.pubaccount.readinjoy.struct;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.articlesummary.GameLiveInfo;

public class SocializeFeedsInfo$GameLiveInfo
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  private static GameLiveInfo b(articlesummary.GameLiveInfo paramGameLiveInfo)
  {
    GameLiveInfo localGameLiveInfo = new GameLiveInfo();
    if (paramGameLiveInfo.bytes_play_bill_id.has()) {
      localGameLiveInfo.jdField_a_of_type_JavaLangString = paramGameLiveInfo.bytes_play_bill_id.get().toStringUtf8();
    }
    if (paramGameLiveInfo.uint32_status.has()) {
      localGameLiveInfo.jdField_a_of_type_Int = paramGameLiveInfo.uint32_status.get();
    }
    if (paramGameLiveInfo.uint32_audience_count.has()) {
      localGameLiveInfo.jdField_b_of_type_Int = paramGameLiveInfo.uint32_audience_count.get();
    }
    if (paramGameLiveInfo.bytes_game_name.has()) {
      localGameLiveInfo.d = paramGameLiveInfo.bytes_game_name.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_play_url.has()) {
      localGameLiveInfo.c = paramGameLiveInfo.bytes_play_url.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_tips_wording.has()) {
      localGameLiveInfo.e = paramGameLiveInfo.bytes_tips_wording.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_status.has()) {
      localGameLiveInfo.f = paramGameLiveInfo.bytes_status.get().toStringUtf8();
    }
    if (paramGameLiveInfo.bytes_status_icon_url.has()) {
      localGameLiveInfo.g = paramGameLiveInfo.bytes_status_icon_url.get().toStringUtf8();
    }
    return localGameLiveInfo;
  }
  
  private static articlesummary.GameLiveInfo b(GameLiveInfo paramGameLiveInfo)
  {
    articlesummary.GameLiveInfo localGameLiveInfo = new articlesummary.GameLiveInfo();
    if (!TextUtils.isEmpty(paramGameLiveInfo.jdField_a_of_type_JavaLangString)) {
      localGameLiveInfo.bytes_play_bill_id.set(ByteStringMicro.copyFromUtf8(paramGameLiveInfo.jdField_a_of_type_JavaLangString));
    }
    localGameLiveInfo.uint32_status.set(paramGameLiveInfo.jdField_a_of_type_Int);
    localGameLiveInfo.uint32_audience_count.set(paramGameLiveInfo.jdField_b_of_type_Int);
    if (!TextUtils.isEmpty(paramGameLiveInfo.d)) {
      localGameLiveInfo.bytes_game_name.set(ByteStringMicro.copyFromUtf8(paramGameLiveInfo.d));
    }
    if (!TextUtils.isEmpty(paramGameLiveInfo.c)) {
      localGameLiveInfo.bytes_play_url.set(ByteStringMicro.copyFromUtf8(paramGameLiveInfo.c));
    }
    if (!TextUtils.isEmpty(paramGameLiveInfo.e)) {
      localGameLiveInfo.bytes_tips_wording.set(ByteStringMicro.copyFromUtf8(paramGameLiveInfo.e));
    }
    if (!TextUtils.isEmpty(paramGameLiveInfo.f)) {
      localGameLiveInfo.bytes_status.set(ByteStringMicro.copyFromUtf8(paramGameLiveInfo.f));
    }
    if (!TextUtils.isEmpty(paramGameLiveInfo.g)) {
      localGameLiveInfo.bytes_status_icon_url.set(ByteStringMicro.copyFromUtf8(paramGameLiveInfo.g));
    }
    return localGameLiveInfo;
  }
  
  public String toString()
  {
    return "GameLiveInfo{playBillId=" + this.jdField_a_of_type_JavaLangString + ", status=" + this.jdField_a_of_type_Int + ", audienceCount=" + this.jdField_b_of_type_Int + ", audiences=" + this.jdField_b_of_type_JavaLangString + ", playUrl=" + this.c + ", gameName=" + this.d + ", tipsWording=" + this.e + ", liveStatus=" + this.f + ", statusIconUrl=" + this.g + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.GameLiveInfo
 * JD-Core Version:    0.7.0.1
 */