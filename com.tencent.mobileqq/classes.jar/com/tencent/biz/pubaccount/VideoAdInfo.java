package com.tencent.biz.pubaccount;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kzx;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.AdInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.NegFeedback;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PosAdInfo;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.AdInfo;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.VideoPlayInfo;

public class VideoAdInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new kzx();
  public int a;
  public long a;
  public String a;
  public ArrayList a;
  public int b;
  public long b;
  public String b;
  public ArrayList b;
  public int c;
  public long c;
  public String c;
  public ArrayList c;
  public int d;
  public long d;
  public String d;
  public ArrayList d;
  public int e;
  public long e;
  public String e;
  public ArrayList e;
  public int f;
  public long f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public String t;
  public String u;
  
  public VideoAdInfo()
  {
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public VideoAdInfo(long paramLong, oidb_0x6cf.PosAdInfo paramPosAdInfo)
  {
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
    if ((paramPosAdInfo == null) || (paramPosAdInfo.int32_ret.get() != 0) || (!paramPosAdInfo.msg_ad_info.has()) || (paramPosAdInfo.msg_ad_info.get() == null)) {
      return;
    }
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramPosAdInfo.enum_pos_layout.get();
    this.jdField_b_of_type_Long = paramPosAdInfo.uint64_pos_id.get();
    paramPosAdInfo = (oidb_0x6cf.AdInfo)paramPosAdInfo.msg_ad_info.get();
    this.jdField_c_of_type_Long = paramPosAdInfo.uint64_channel_id.get();
    this.jdField_b_of_type_Int = paramPosAdInfo.int32_kd_pos.get();
    this.jdField_a_of_type_JavaLangString = paramPosAdInfo.bytes_cl.get().toStringUtf8();
    this.jdField_b_of_type_JavaLangString = paramPosAdInfo.bytes_img.get().toStringUtf8();
    this.jdField_c_of_type_JavaLangString = paramPosAdInfo.bytes_img_s.get().toStringUtf8();
    this.jdField_d_of_type_JavaLangString = paramPosAdInfo.bytes_txt.get().toStringUtf8();
    this.jdField_e_of_type_JavaLangString = paramPosAdInfo.bytes_desc.get().toStringUtf8();
    this.jdField_f_of_type_JavaLangString = paramPosAdInfo.bytes_rl.get().toStringUtf8();
    this.jdField_g_of_type_JavaLangString = paramPosAdInfo.bytes_apurl.get().toStringUtf8();
    this.jdField_h_of_type_JavaLangString = paramPosAdInfo.bytes_trace_id.get().toStringUtf8();
    this.jdField_i_of_type_JavaLangString = paramPosAdInfo.bytes_product_id.get().toStringUtf8();
    this.jdField_c_of_type_Int = paramPosAdInfo.int32_product_type.get();
    this.jdField_d_of_type_Int = paramPosAdInfo.uint32_ad_type.get();
    this.jdField_j_of_type_JavaLangString = paramPosAdInfo.bytes_landing_page.get().toStringUtf8();
    this.jdField_k_of_type_JavaLangString = paramPosAdInfo.bytes_price.get().toStringUtf8();
    this.l = paramPosAdInfo.bytes_button_txt.get().toStringUtf8();
    this.m = paramPosAdInfo.bytes_view_id.get().toStringUtf8();
    this.n = paramPosAdInfo.bytes_customized_invoke_url.get().toStringUtf8();
    this.o = paramPosAdInfo.bytes_corporation_name.get().toStringUtf8();
    this.p = paramPosAdInfo.bytes_corporate_image_name.get().toStringUtf8();
    this.q = paramPosAdInfo.bytes_corporate_logo.get().toStringUtf8();
    this.jdField_d_of_type_Long = paramPosAdInfo.uint64_ad_uin.get();
    this.r = paramPosAdInfo.bytes_ext.get().toStringUtf8();
    this.s = paramPosAdInfo.bytes_video_url.get().toStringUtf8();
    this.jdField_e_of_type_Int = paramPosAdInfo.uint32_cost_type.get();
    Iterator localIterator;
    ByteStringMicro localByteStringMicro;
    if ((paramPosAdInfo.bytes_title_list.has()) && (paramPosAdInfo.bytes_title_list.get() != null))
    {
      localIterator = paramPosAdInfo.bytes_title_list.get().iterator();
      while (localIterator.hasNext())
      {
        localByteStringMicro = (ByteStringMicro)localIterator.next();
        this.jdField_b_of_type_JavaUtilArrayList.add(localByteStringMicro.toStringUtf8());
      }
    }
    if ((paramPosAdInfo.bytes_image_list.has()) && (paramPosAdInfo.bytes_image_list.get() != null))
    {
      localIterator = paramPosAdInfo.bytes_image_list.get().iterator();
      while (localIterator.hasNext())
      {
        localByteStringMicro = (ByteStringMicro)localIterator.next();
        this.jdField_c_of_type_JavaUtilArrayList.add(localByteStringMicro.toStringUtf8());
      }
    }
    if ((paramPosAdInfo.bytes_url_list.has()) && (paramPosAdInfo.bytes_url_list.get() != null))
    {
      localIterator = paramPosAdInfo.bytes_url_list.get().iterator();
      while (localIterator.hasNext())
      {
        localByteStringMicro = (ByteStringMicro)localIterator.next();
        this.jdField_d_of_type_JavaUtilArrayList.add(localByteStringMicro.toStringUtf8());
      }
    }
    this.jdField_e_of_type_Long = paramPosAdInfo.uint64_aid.get();
    this.jdField_f_of_type_Int = paramPosAdInfo.enum_ad_layout.get();
    this.jdField_g_of_type_Int = paramPosAdInfo.uint32_ad_material_id.get();
    this.jdField_h_of_type_Int = paramPosAdInfo.uint32_ad_material_width.get();
    this.jdField_i_of_type_Int = paramPosAdInfo.uint32_ad_material_height.get();
    this.t = paramPosAdInfo.bytes_via.get().toStringUtf8();
    this.jdField_j_of_type_Int = paramPosAdInfo.uint32_dis_channel.get();
    this.u = paramPosAdInfo.bytes_button_url.get().toStringUtf8();
    this.jdField_k_of_type_Int = paramPosAdInfo.uint32_duration.get();
  }
  
  public VideoAdInfo(Parcel paramParcel)
  {
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.jdField_g_of_type_JavaLangString = paramParcel.readString();
    this.jdField_h_of_type_JavaLangString = paramParcel.readString();
    this.jdField_i_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaUtilArrayList = paramParcel.readArrayList(VideoAdInfo.class.getClassLoader());
    this.jdField_j_of_type_JavaLangString = paramParcel.readString();
    this.jdField_k_of_type_JavaLangString = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.n = paramParcel.readString();
    this.o = paramParcel.readString();
    this.p = paramParcel.readString();
    this.q = paramParcel.readString();
    this.jdField_d_of_type_Long = paramParcel.readLong();
    this.r = paramParcel.readString();
    this.s = paramParcel.readString();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    paramParcel.readStringList(this.jdField_b_of_type_JavaUtilArrayList);
    paramParcel.readStringList(this.jdField_c_of_type_JavaUtilArrayList);
    paramParcel.readStringList(this.jdField_d_of_type_JavaUtilArrayList);
    this.jdField_e_of_type_Long = paramParcel.readLong();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.jdField_g_of_type_Int = paramParcel.readInt();
    this.jdField_h_of_type_Int = paramParcel.readInt();
    this.jdField_i_of_type_Int = paramParcel.readInt();
    this.t = paramParcel.readString();
    this.jdField_j_of_type_Int = paramParcel.readInt();
    this.u = paramParcel.readString();
    this.jdField_k_of_type_Int = paramParcel.readInt();
  }
  
  public oidb_cmd0x886.AdInfo a(int paramInt, Bundle paramBundle)
  {
    oidb_cmd0x886.AdInfo localAdInfo = new oidb_cmd0x886.AdInfo();
    localAdInfo.bytes_trace_id.set(ByteStringMicro.copyFromUtf8(this.jdField_h_of_type_JavaLangString));
    localAdInfo.uint64_pull_time.set(this.jdField_a_of_type_Long);
    localAdInfo.enum_report_type.set(paramInt);
    localAdInfo.bytes_apurl.set(ByteStringMicro.copyFromUtf8(this.jdField_g_of_type_JavaLangString));
    localAdInfo.bytes_rl.set(ByteStringMicro.copyFromUtf8(this.jdField_f_of_type_JavaLangString));
    localAdInfo.bytes_view_id.set(ByteStringMicro.copyFromUtf8(this.m));
    if (paramInt == 3) {
      localAdInfo.uint64_neg_fb_type_id.set(this.jdField_f_of_type_Long);
    }
    localAdInfo.uint64_pos_id.set(this.jdField_b_of_type_Long);
    localAdInfo.uint64_channel_id.set(this.jdField_c_of_type_Long);
    localAdInfo.int32_kd_pos.set(this.jdField_b_of_type_Int);
    localAdInfo.bytes_cl.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    localAdInfo.enum_pos_layout.set(this.jdField_a_of_type_Int);
    localAdInfo.bytes_product_id.set(ByteStringMicro.copyFromUtf8(this.jdField_i_of_type_JavaLangString));
    localAdInfo.int32_product_type.set(this.jdField_c_of_type_Int);
    localAdInfo.uint32_ad_type.set(this.jdField_d_of_type_Int);
    localAdInfo.bytes_price.set(ByteStringMicro.copyFromUtf8(this.jdField_k_of_type_JavaLangString));
    localAdInfo.bytes_customized_invoke_url.set(ByteStringMicro.copyFromUtf8(this.n));
    localAdInfo.bytes_corporation_name.set(ByteStringMicro.copyFromUtf8(this.o));
    localAdInfo.bytes_corporate_image_name.set(ByteStringMicro.copyFromUtf8(this.p));
    localAdInfo.bytes_corporate_logo.set(ByteStringMicro.copyFromUtf8(this.q));
    localAdInfo.uint64_ad_uin.set(this.jdField_d_of_type_Long);
    localAdInfo.bytes_ext.set(ByteStringMicro.copyFromUtf8(this.r));
    localAdInfo.bytes_video_url.set(ByteStringMicro.copyFromUtf8(this.s));
    localAdInfo.uint32_cost_type.set(this.jdField_e_of_type_Int);
    localAdInfo.uint64_aid.set(this.jdField_e_of_type_Long);
    localAdInfo.bytes_img.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    localAdInfo.bytes_img_s.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
    localAdInfo.bytes_txt.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
    localAdInfo.bytes_desc.set(ByteStringMicro.copyFromUtf8(this.jdField_e_of_type_JavaLangString));
    localAdInfo.enum_ad_layout.set(this.jdField_f_of_type_Int);
    localAdInfo.uint32_ad_material_id.set(this.jdField_g_of_type_Int);
    localAdInfo.bytes_via.set(ByteStringMicro.copyFromUtf8(this.t));
    localAdInfo.uint32_dis_channel.set(this.jdField_j_of_type_Int);
    localAdInfo.bytes_button_url.set(ByteStringMicro.copyFromUtf8(this.u));
    if (paramBundle != null)
    {
      oidb_cmd0x886.VideoPlayInfo localVideoPlayInfo = new oidb_cmd0x886.VideoPlayInfo();
      localVideoPlayInfo.uint32_bt.set(paramBundle.getInt("arg_video_bt"));
      localVideoPlayInfo.uint32_et.set(paramBundle.getInt("arg_video_et"));
      localVideoPlayInfo.uint32_bf.set(paramBundle.getInt("arg_video_bf"));
      localVideoPlayInfo.uint32_ef.set(paramBundle.getInt("arg_video_ef"));
      localVideoPlayInfo.uint32_pp.set(paramBundle.getInt("arg_video_pp"));
      localVideoPlayInfo.uint32_pa.set(paramBundle.getInt("arg_video_pa"));
      localVideoPlayInfo.uint32_pb.set(paramBundle.getInt("arg_video_pb"));
      localAdInfo.msg_video_play_info.set(localVideoPlayInfo);
    }
    localAdInfo.uint32_duration.set(this.jdField_k_of_type_Int);
    return localAdInfo;
  }
  
  public void a(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        oidb_0x6cf.NegFeedback localNegFeedback = (oidb_0x6cf.NegFeedback)paramList.next();
        this.jdField_e_of_type_JavaUtilArrayList.add(new VideoAdInfo.NegFeedback(this, localNegFeedback));
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Int == 12;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("[\n");
    localStringBuilder.append("    kd_pos=").append(this.jdField_b_of_type_Int).append(", pull_time=").append(this.jdField_a_of_type_Long).append("\n");
    localStringBuilder.append("    img=").append(this.jdField_b_of_type_JavaLangString).append("\n");
    localStringBuilder.append("    rl=").append(this.jdField_f_of_type_JavaLangString).append("\n");
    localStringBuilder.append("    txt=").append(this.jdField_d_of_type_JavaLangString).append(", trace_id=").append(this.jdField_h_of_type_JavaLangString).append("\n");
    localStringBuilder.append("    button_txt=").append(this.l).append(", corporation_name=").append(this.o).append("\n");
    localStringBuilder.append("    corporate_logo=").append(this.q).append("\n");
    localStringBuilder.append("    video_url=").append(this.s).append("\n");
    localStringBuilder.append("    aid=").append(this.jdField_e_of_type_Long).append(", duration=").append(this.jdField_k_of_type_Int).append("\n");
    localStringBuilder.append("    material_id=").append(this.jdField_g_of_type_Int).append(", material_width=").append(this.jdField_h_of_type_Int).append(", material_height=").append(this.jdField_i_of_type_Int).append("\n");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_h_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_i_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeString(this.jdField_j_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_k_of_type_JavaLangString);
    paramParcel.writeString(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeString(this.o);
    paramParcel.writeString(this.p);
    paramParcel.writeString(this.q);
    paramParcel.writeLong(this.jdField_d_of_type_Long);
    paramParcel.writeString(this.r);
    paramParcel.writeString(this.s);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeStringList(this.jdField_b_of_type_JavaUtilArrayList);
    paramParcel.writeStringList(this.jdField_c_of_type_JavaUtilArrayList);
    paramParcel.writeStringList(this.jdField_d_of_type_JavaUtilArrayList);
    paramParcel.writeLong(this.jdField_e_of_type_Long);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    paramParcel.writeInt(this.jdField_h_of_type_Int);
    paramParcel.writeInt(this.jdField_i_of_type_Int);
    paramParcel.writeString(this.t);
    paramParcel.writeInt(this.jdField_j_of_type_Int);
    paramParcel.writeString(this.u);
    paramParcel.writeInt(this.jdField_k_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoAdInfo
 * JD-Core Version:    0.7.0.1
 */