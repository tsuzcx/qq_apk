package com.tencent.liteav.videodecoder;

import android.util.Log;
import com.tencent.liteav.basic.log.TXCLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class d
{
  private boolean a = false;
  private boolean b = false;
  
  private void a(c paramc)
  {
    int j = paramc.a("SPS: cpb_cnt_minus1");
    paramc.b(4, "HRD: bit_rate_scale");
    paramc.b(4, "HRD: cpb_size_scale");
    int i = 0;
    while (i <= j)
    {
      paramc.b("HRD: bit_rate_value_minus1");
      paramc.b("HRD: cpb_size_value_minus1");
      paramc.b(1, "HRD: cbr_flag");
      i += 1;
    }
    paramc.b(5, "HRD: initial_cpb_removal_delay_length_minus1");
    paramc.b(5, "HRD: cpb_removal_delay_length_minus1");
    paramc.b(5, "HRD: dpb_output_delay_length_minus1");
    paramc.b(5, "HRD: time_offset_length");
  }
  
  private boolean b(c paramc)
  {
    if ((paramc.d("VUI: aspect_ratio_info_present_flag")) && ((int)paramc.a(8, "VUI: aspect_ratio") == 255))
    {
      paramc.b(16, "VUI: sar_width");
      paramc.b(16, "VUI: sar_height");
    }
    if (paramc.d("VUI: overscan_info_present_flag")) {
      paramc.b(1, "VUI: overscan_appropriate_flag");
    }
    if (paramc.d("VUI: video_signal_type_present_flag"))
    {
      paramc.b(3, "VUI: video_format");
      paramc.b(1, "VUI: video_full_range_flag");
      if (paramc.d("VUI: colour_description_present_flag"))
      {
        paramc.b(8, "VUI: colour_primaries");
        paramc.b(8, "VUI: transfer_characteristics");
        paramc.b(8, "VUI: matrix_coefficients");
      }
    }
    if (paramc.d("VUI: chroma_loc_info_present_flag"))
    {
      paramc.b("VUI chroma_sample_loc_type_top_field");
      paramc.b("VUI chroma_sample_loc_type_bottom_field");
    }
    if (paramc.d("VUI: timing_info_present_flag"))
    {
      paramc.b(32, "VUI: num_units_in_tick");
      paramc.b(32, "VUI: time_scale");
      paramc.b(1, "VUI: fixed_frame_rate_flag");
    }
    boolean bool1 = paramc.d("VUI: nal_hrd_parameters_present_flag");
    if (bool1) {
      a(paramc);
    }
    boolean bool2 = paramc.d("VUI: vcl_hrd_parameters_present_flag");
    if (bool2) {
      a(paramc);
    }
    if ((bool1) || (bool2)) {
      paramc.b(1, "VUI: low_delay_hrd_flag");
    }
    paramc.b(1, "VUI: pic_struct_present_flag");
    if (paramc.e("VUI: bitstream_restriction_flag"))
    {
      if (this.a) {
        Log.d("[H264SPSModifier]", "steve:VUI has bs restriction!!");
      }
      paramc.a(true, "VUI: set bitstream_restriction_flag");
      paramc.d("VUI: motion_vectors_over_pic_boundaries_flag");
      paramc.b("VUI max_bytes_per_pic_denom");
      paramc.b("VUI max_bits_per_mb_denom");
      paramc.b("VUI log2_max_mv_length_horizontal");
      paramc.b("VUI log2_max_mv_length_vertical");
      paramc.b("VUI num_reorder_frames");
      if (!this.b)
      {
        int i = paramc.c(false);
        paramc = new StringBuilder();
        paramc.append("decode: do not add max_dec_frame_buffering when it is ");
        paramc.append(i);
        TXCLog.w("[H264SPSModifier]", paramc.toString());
        this.b = true;
      }
      return false;
    }
    if (this.a) {
      Log.d("[H264SPSModifier]", "steve:VUI has NO bs restriction!!");
    }
    paramc.a(true, "VUI: set bitstream_restriction_flag");
    paramc.a(true, "VUI: motion_vectors_over_pic_boundaries_flag");
    paramc.c(0, "VUI: max_bytes_per_pic_denom");
    paramc.c(0, "VUI: max_bits_per_mb_denom");
    paramc.c(10, "VUI: log2_max_mv_length_horizontal");
    paramc.c(10, "VUI: log2_max_mv_length_vertical");
    paramc.c(0, "VUI: num_reorder_frames");
    paramc.c(1, "VUI: max_dec_frame_buffering");
    if (!this.b)
    {
      TXCLog.w("[H264SPSModifier]", "decode: add max_dec_frame_buffering 1 when it is no exist");
      this.b = true;
    }
    return true;
  }
  
  public byte[] a(InputStream paramInputStream)
  {
    Object localObject1 = new ByteArrayOutputStream();
    paramInputStream = new c(paramInputStream, (OutputStream)localObject1);
    paramInputStream.b(8, "NALU type");
    int i = (int)paramInputStream.a(8, "SPS: profile_idc");
    paramInputStream.b(8, "SPS: constraint_set_0-3_flag and reserved_zero_4bits");
    paramInputStream.a(8, "SPS: level_idc");
    paramInputStream.b("SPS: seq_parameter_set_id");
    int j = 0;
    if ((i == 100) || (i == 110) || (i == 122) || (i == 144))
    {
      if (paramInputStream.a("SPS: chroma_format_idc") == 3) {
        paramInputStream.b(1, "SPS: residual_color_transform_flag");
      }
      paramInputStream.b("SPS: bit_depth_luma_minus8");
      paramInputStream.b("SPS: bit_depth_chroma_minus8");
      paramInputStream.b(1, "SPS: qpprime_y_zero_transform_bypass_flag");
      if (paramInputStream.d("SPS: seq_scaling_matrix_present_lag"))
      {
        i = 0;
        while (i < 8)
        {
          if (paramInputStream.d("SPS: seqScalingListPresentFlag")) {
            if (i < 6) {
              paramInputStream.c(16);
            } else {
              paramInputStream.c(64);
            }
          }
          i += 1;
        }
      }
    }
    paramInputStream.b("SPS: log2_max_frame_num_minus4");
    i = paramInputStream.a("SPS: pic_order_cnt_type");
    Object localObject2;
    if (i == 0)
    {
      paramInputStream.b("SPS: log2_max_pic_order_cnt_lsb_minus4");
    }
    else if (i == 1)
    {
      paramInputStream.b(1, "SPS: delta_pic_order_always_zero_flag");
      paramInputStream.b("SPS: offset_for_non_ref_pic");
      paramInputStream.b("SPS: offset_for_top_to_bottom_field");
      int k = paramInputStream.a("SPS: num_ref_frames_in_pic_order_cnt_cycle");
      i = 0;
      while (i < k)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("SPS: offsetForRefFrame [");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("]");
        paramInputStream.b(((StringBuilder)localObject2).toString());
        i += 1;
      }
    }
    i = paramInputStream.a("SPS: num_ref_frames");
    if (this.a)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("SPS: num_ref_frames: ");
      ((StringBuilder)localObject2).append(i);
      Log.d("[H264SPSModifier]", ((StringBuilder)localObject2).toString());
    }
    paramInputStream.b(1, "SPS: gaps_in_frame_num_value_allowed_flag");
    paramInputStream.b("SPS: pic_width_in_mbs_minus1");
    paramInputStream.b("SPS: pic_height_in_map_units_minus1");
    if (!paramInputStream.d("SPS: frame_mbs_only_flag")) {
      paramInputStream.b(1, "SPS: mb_adaptive_frame_field_flag");
    }
    paramInputStream.b(1, "SPS: direct_8x8_inference_flag");
    if (paramInputStream.d("SPS: frame_cropping_flag"))
    {
      paramInputStream.b("SPS: frame_crop_left_offset");
      paramInputStream.b("SPS: frame_crop_right_offset");
      paramInputStream.b("SPS: frame_crop_top_offset");
      paramInputStream.b("SPS: frame_crop_bottom_offset");
    }
    if (paramInputStream.e("SPS: vui_parameters_present_flag"))
    {
      if (this.a) {
        Log.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! modify max_dec_frame_buffering");
      }
      paramInputStream.a(true, "VUI set 1: ");
      if (!b(paramInputStream)) {
        return null;
      }
    }
    else
    {
      if (this.a) {
        Log.d("[H264SPSModifier]", "vui_parameters_present_flag NOT exist!! add max_dec_frame_buffering");
      }
      paramInputStream.a(true, "VUI set 1: ");
      paramInputStream.a(false, "VUI: aspect_ratio_info_present_flag");
      paramInputStream.a(false, "VUI: overscan_info_present_flag");
      paramInputStream.a(false, "VUI: video_signal_type_present_flag");
      paramInputStream.a(false, "VUI: chroma_loc_info_present_flag");
      paramInputStream.a(false, "VUI: timing_info_present_flag");
      paramInputStream.a(false, "VUI: nal_hrd_parameters_present_flag");
      paramInputStream.a(false, "VUI: vcl_hrd_parameters_present_flag");
      paramInputStream.a(false, "VUI: pic_struct_present_flag");
      paramInputStream.a(true, "VUI: bitstream_restriction_flag");
      paramInputStream.a(true, "VUI: motion_vectors_over_pic_boundaries_flag");
      paramInputStream.c(0, "VUI: max_bytes_per_pic_denom");
      paramInputStream.c(0, "VUI: max_bits_per_mb_denom");
      paramInputStream.c(10, "VUI: log2_max_mv_length_horizontal");
      paramInputStream.c(10, "VUI: log2_max_mv_length_vertical");
      paramInputStream.c(0, "VUI: num_reorder_frames");
      paramInputStream.c(1, "VUI: max_dec_frame_buffering");
      if (!this.b)
      {
        TXCLog.w("[H264SPSModifier]", "decode: add max_dec_frame_buffering 1 when vui is no exist");
        this.b = true;
      }
    }
    paramInputStream.c();
    byte[] arrayOfByte = ((ByteArrayOutputStream)localObject1).toByteArray();
    if (this.a)
    {
      paramInputStream = "";
      i = j;
      while (i < arrayOfByte.length)
      {
        localObject2 = Integer.toHexString(arrayOfByte[i] & 0xFF);
        localObject1 = localObject2;
        if (((String)localObject2).length() == 1)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("0");
          ((StringBuilder)localObject1).append((String)localObject2);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramInputStream);
        ((StringBuilder)localObject2).append(" ");
        ((StringBuilder)localObject2).append((String)localObject1);
        paramInputStream = ((StringBuilder)localObject2).toString();
        i += 1;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("new SPS:");
      ((StringBuilder)localObject1).append(paramInputStream);
      Log.d("[H264SPSModifier]", ((StringBuilder)localObject1).toString());
    }
    return arrayOfByte;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    if (this.a)
    {
      int i = 0;
      String str = "";
      while (i < paramArrayOfByte.length)
      {
        Object localObject2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
        localObject1 = localObject2;
        if (((String)localObject2).length() == 1)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("0");
          ((StringBuilder)localObject1).append((String)localObject2);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(" ");
        ((StringBuilder)localObject2).append((String)localObject1);
        str = ((StringBuilder)localObject2).toString();
        i += 1;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("old SPS:");
      ((StringBuilder)localObject1).append(str);
      Log.d("[H264SPSModifier]", ((StringBuilder)localObject1).toString());
    }
    return a(new ByteArrayInputStream(paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.d
 * JD-Core Version:    0.7.0.1
 */