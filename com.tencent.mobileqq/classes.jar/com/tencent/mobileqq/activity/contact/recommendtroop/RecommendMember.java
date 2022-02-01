package com.tencent.mobileqq.activity.contact.recommendtroop;

import android.graphics.Color;
import com.tencent.mobileqq.data.RecommendLabel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xe3b.oidb_0xe3b.Color;
import tencent.im.oidb.cmd0xe3b.oidb_0xe3b.Label;
import tencent.im.oidb.cmd0xe3b.oidb_0xe3b.RecommendPerson;

public class RecommendMember
{
  public int a;
  public String a;
  public ArrayList<RecommendLabel> a;
  public int b;
  public String b;
  public String c;
  
  public static RecommendMember a(oidb_0xe3b.RecommendPerson paramRecommendPerson)
  {
    int j = -1;
    RecommendMember localRecommendMember = new RecommendMember();
    localRecommendMember.jdField_a_of_type_JavaLangString = String.valueOf(paramRecommendPerson.uint64_uin.get());
    Object localObject;
    label74:
    int i;
    label98:
    oidb_0xe3b.Label localLabel;
    label173:
    RecommendLabel localRecommendLabel;
    if (paramRecommendPerson.bytes_title.has())
    {
      localObject = paramRecommendPerson.bytes_title.get().toStringUtf8();
      localRecommendMember.jdField_b_of_type_JavaLangString = ((String)localObject);
      if (!paramRecommendPerson.bytes_reason.has()) {
        break label404;
      }
      localObject = paramRecommendPerson.bytes_reason.get().toStringUtf8();
      localRecommendMember.c = ((String)localObject);
      if (!paramRecommendPerson.uint32_age.has()) {
        break label410;
      }
      i = paramRecommendPerson.uint32_age.get();
      localRecommendMember.jdField_a_of_type_Int = i;
      i = j;
      if (paramRecommendPerson.uint32_gender.has()) {
        i = paramRecommendPerson.uint32_gender.get();
      }
      localRecommendMember.jdField_b_of_type_Int = i;
      if (!paramRecommendPerson.rpt_msg_label.has()) {
        break label421;
      }
      paramRecommendPerson = paramRecommendPerson.rpt_msg_label.get();
      localRecommendMember.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramRecommendPerson.size());
      localObject = paramRecommendPerson.iterator();
      if (!((Iterator)localObject).hasNext()) {
        break label421;
      }
      localLabel = (oidb_0xe3b.Label)((Iterator)localObject).next();
      localRecommendLabel = new RecommendLabel();
      if (!localLabel.bytes_name.has()) {
        break label415;
      }
    }
    label404:
    label410:
    label415:
    for (paramRecommendPerson = localLabel.bytes_name.get().toStringUtf8();; paramRecommendPerson = "")
    {
      localRecommendLabel.bytes_name = paramRecommendPerson;
      localRecommendLabel.uint32_label_type = localLabel.uint32_label_type.get();
      if (localLabel.text_color.has()) {
        localRecommendLabel.text_color = Color.rgb(((oidb_0xe3b.Color)localLabel.text_color.get()).uint32_r.get(), ((oidb_0xe3b.Color)localLabel.text_color.get()).uint32_g.get(), ((oidb_0xe3b.Color)localLabel.text_color.get()).uint32_b.get());
      }
      if (localLabel.edging_color.has()) {
        localRecommendLabel.edging_color = Color.rgb(((oidb_0xe3b.Color)localLabel.edging_color.get()).uint32_r.get(), ((oidb_0xe3b.Color)localLabel.edging_color.get()).uint32_g.get(), ((oidb_0xe3b.Color)localLabel.edging_color.get()).uint32_b.get());
      }
      localRecommendMember.jdField_a_of_type_JavaUtilArrayList.add(localRecommendLabel);
      break label173;
      localObject = "";
      break;
      localObject = "";
      break label74;
      i = -1;
      break label98;
    }
    label421:
    return localRecommendMember;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.recommendtroop.RecommendMember
 * JD-Core Version:    0.7.0.1
 */