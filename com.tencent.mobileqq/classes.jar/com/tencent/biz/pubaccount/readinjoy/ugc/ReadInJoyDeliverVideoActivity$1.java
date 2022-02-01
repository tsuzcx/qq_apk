package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.os.Bundle;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.KingMomentInfo;

class ReadInJoyDeliverVideoActivity$1
  extends ReadInJoyObserver
{
  ReadInJoyDeliverVideoActivity$1(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void a(int paramInt, KingMomentInfo paramKingMomentInfo)
  {
    if ((paramInt == 0) && (ReadInJoyDeliverVideoActivity.a(this.a)))
    {
      ReadInJoyDeliverVideoActivity.a(this.a, new Bundle());
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_video_cover_url", paramKingMomentInfo.h);
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_video_url", paramKingMomentInfo.g);
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_video_title", paramKingMomentInfo.jdField_d_of_type_JavaLangString);
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_video_uuid", paramKingMomentInfo.f);
      ReadInJoyDeliverVideoActivity.a(this.a).putLong("arg_video_duration", paramKingMomentInfo.jdField_a_of_type_Long);
      ReadInJoyDeliverVideoActivity.a(this.a).putInt("arg_video_cover_width", paramKingMomentInfo.c);
      ReadInJoyDeliverVideoActivity.a(this.a).putInt("arg_video_cover_height", paramKingMomentInfo.jdField_b_of_type_Int);
      ReadInJoyDeliverVideoActivity.a(this.a).putInt("arg_video_width", paramKingMomentInfo.e);
      ReadInJoyDeliverVideoActivity.a(this.a).putInt("arg_video_height", paramKingMomentInfo.jdField_d_of_type_Int);
      ReadInJoyDeliverVideoActivity.a(this.a).putString("arg_topic_id", paramKingMomentInfo.jdField_a_of_type_Int + "");
      ReadInJoyDeliverVideoActivity.a(this.a).setHint("#" + paramKingMomentInfo.jdField_a_of_type_JavaLangString + "#");
      ReadInJoyDeliverVideoActivity.a(this.a, paramKingMomentInfo.jdField_b_of_type_JavaLangString);
      ReadInJoyDeliverVideoActivity.a(this.a, true);
      ReadInJoyDeliverVideoActivity.a(this.a, paramKingMomentInfo.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity.1
 * JD-Core Version:    0.7.0.1
 */