package com.tencent.av.video.effect.core;

import com.tencent.av.video.effect.utils.NativeLoader;

public class ShaderManager
{
  public static final int QAV_3x3TSF_VERTEX_SHADER = 14;
  public static final int QAV_BEAUTY_EXPOSURE_AND_OVERLAY_FRAGMENT_SHADER = 1;
  public static final int QAV_BEAUTY_HIGH_PASS_FRAGMENT_SHADER = 2;
  public static final int QAV_BEAUTY_SHARPEN_AND_EXPOSURE_FRAGMENT_SHADER = 4;
  public static final int QAV_BEAUTY_SHARPEN_AND_EXPOSURE_VERTEX_SHADER = 3;
  public static final int QAV_BEAUTY_SKIN_CURVE_AND_COMPOSE_FRAGMENT_SHADER = 5;
  public static final int QAV_CAF_FRAGMENT_SHADER = 9;
  public static final int QAV_CBF_FRAGMENT_SHADER = 10;
  public static final int QAV_CF_VERTEX_SHADER = 15;
  public static final int QAV_CHLF_FRAGMENT_SHADER = 11;
  public static final int QAV_DDBF_FRAGMENT_SHADER = 16;
  public static final int QAV_DENOISE_RGB_2_YUV_FRAGMENT_SHADER = 26;
  public static final int QAV_DENOISE_VDCAL_AND_PRED_FRAGMENT_SHADER = 27;
  public static final int QAV_DENOISE_YUV_2_RGB_FRAGMENT_SHADER = 28;
  public static final int QAV_ExFF_FRAGMENT_SHADER = 17;
  public static final int QAV_FOUR_INPUT_FILTER_VERTEX_SHADER = 29;
  public static final int QAV_GBLF_FRAGMENT_SHADER = 21;
  public static final int QAV_GBLF_VERTEX_SHADER = 20;
  public static final int QAV_GSF_FRAGMENT_SHADER = 22;
  public static final int QAV_IMAGE_BLACK_NOISE_FRAGMENT_SHADER = 36;
  public static final int QAV_IMAGE_COLOR_EFFECT_FILTER_FRAGMENT_SHADER = 8;
  public static final int QAV_IMAGE_COLOR_EFFECT_NEW_FILTER_FRAGMENT_SHADER = 34;
  public static final int QAV_IMAGE_COLOR_EFFECT_SHIFTER_FRAGMENT_SHADER = 35;
  public static final int QAV_LOW_LIGHT_CORE_FRAGMENT_SHADER = 7;
  public static final int QAV_LOW_LIGHT_CORE_VERTEX_SHADER = 6;
  public static final int QAV_SHADER_NONE = 0;
  public static final int QAV_SPECIAL_HEAVYFEELING_FRAGMENT_SHADER = 31;
  public static final int QAV_SPECIAL_KLEINBLUE_FRAGMENT_FILTER = 33;
  public static final int QAV_SPECIAL_PURPLEORANGE_FRAGMENT_SHADER = 32;
  public static final int QAV_SPECIAL_STRONG_FRAGMENT_SHADER = 37;
  public static final int QAV_SPECIAL_TEATIME_FRAGMENT_SHADER = 30;
  public static final int QAV_SPF_FRAGMENT_SHADER = 25;
  public static final int QAV_STNF_FRAGMENT_SHADER = 12;
  public static final int QAV_ShFF_VERTEX_SHADER = 18;
  public static final int QAV_TCFF_FRAGMENT_SHADER = 23;
  public static final int QAV_THREE_INPUT_FILTER_VERTEX_SHADER = 13;
  public static final int QAV_TIFV_VERTEX_SHADER = 24;
  public static final int QAV_TNF_FRAGMENT_SHADER = 19;
  
  static
  {
    if (!NativeLoader.mIsSoLoaded) {
      NativeLoader.loadSo();
    }
  }
  
  public static native void nativeGLShaderSource(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.core.ShaderManager
 * JD-Core Version:    0.7.0.1
 */