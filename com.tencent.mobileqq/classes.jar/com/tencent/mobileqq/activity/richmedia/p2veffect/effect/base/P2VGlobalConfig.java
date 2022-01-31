package com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base;

import android.os.Environment;
import common.config.service.QzoneConfig;
import java.io.File;

public class P2VGlobalConfig
{
  public static final int COLUMN_COUNT = 3;
  public static String CONCAT_FINAL_MP3;
  public static final String DEFAULT_BYGONE_BUMPS = "http://dl.stream.qqmusic.qq.com/C100004eoXLb0lKq6P.m4a?fromtag=1";
  public static final String DEFAULT_BYGONE_BUMPS_ID = "201401670";
  public static final String DEFAULT_BYGONE_BUMPS_TITLE = "Bygone Bumps";
  public static final String DEFAULT_GOLDEN_SKIES = "http://dl.stream.qqmusic.qq.com/C100002xUbdh1WNIlH.m4a?fromtag=1";
  public static final String DEFAULT_GOLDEN_SKIES_ID = "108805100";
  public static final String DEFAULT_GOLDEN_SKIES_TITLE = "Golden Skies";
  public static final String DEFAULT_HAVING_LIVED = "http://dl.stream.qqmusic.qq.com/C100001IsOUk1Z0D16.m4a?fromtag=1";
  public static final String DEFAULT_HAVING_LIVED_ID = "202468810";
  public static final String DEFAULT_HAVING_LIVED_TITLE = "Having Lived";
  public static final String DEFAULT_I_HOPE_YOU_FIND_PEACE = "http://dl.stream.qqmusic.qq.com/C100002PzIKz2xBTvu.m4a?fromtag=1";
  public static final String DEFAULT_I_HOPE_YOU_FIND_PEACE_ID = "103091927";
  public static final String DEFAULT_I_HOPE_YOU_FIND_PEACE_TITLE = "I Hope You Find Peace";
  public static final String DEFAULT_XIA_MU_YOU_REN = "http://dl.stream.qqmusic.qq.com/C100002XecyN1bmIBb.m4a?fromtag=1";
  public static final String DEFAULT_XIA_MU_YOU_REN_ID = "1799404";
  public static final String DEFAULT_XIA_MU_YOU_REN_TITLE = "春を知らせるもの";
  public static final int ERR_ASYNC_REFRESHPREPARE = 4;
  public static final int ERR_FAST_RENDER_START = 10;
  public static final int ERR_GENERATOR_PREPARE = 6;
  public static final int ERR_GET_DIMENS = 2;
  public static final int ERR_INVALID_DURATION = 3;
  public static final int ERR_MATERIAL_PARSE = 1;
  public static final int ERR_MIX_MUSIC = 11;
  public static final int ERR_ONFRAME_AVAILABLE = 9;
  public static final int ERR_REFRESH_CONTROLLER_REFRESH = 7;
  public static final int ERR_SAVE_IMG = 8;
  public static final int ERR_SYNC_REFRESHPREPARE = 5;
  public static final String KEY_FILL_COLOR_B = "fillColorB";
  public static final String KEY_FILL_COLOR_G = "fillColorG";
  public static final String KEY_FILL_COLOR_R = "fillColorR";
  public static final String KEY_FILL_TYPE = "fillType";
  public static final String KEY_LYRICS = "lyrics";
  public static final String KEY_VIDEO_DURATION = "videoDuration";
  public static final String KEY_VIDEO_HEIGHT = "videoHeight";
  public static final String KEY_VIDEO_PATH = "videoPath";
  public static final String KEY_VIDEO_WIDTH = "videoWidth";
  public static final int MAX_P2V_RECOMMEND_INT;
  public static final int MAX_P2V_RECOMMEND_VIDEO = QzoneConfig.getInstance().getConfig("p2v_config_main_key", "p2v_max_recommend_video_int", 3);
  public static String NO_AUDIO_MP4 = P2V_VIDEO_CACHE_ROOT + "no_audio.mp4";
  public static final int OUTPUT_VIDEO_BIT_RATE = 960000;
  public static final int OUTPUT_VIDEO_FPS = 25;
  public static final int OUTPUT_VIDEO_HEIGHT = 720;
  public static final int OUTPUT_VIDEO_WIDTH = 1280;
  public static final String P2V_CAN_UPLOAD_LIMIT_MS_SECONDARY_KEY = "p2v_can_upload_limit_ms_secondary_key";
  public static final String P2V_CONFIG_MAIN_KEY = "p2v_config_main_key";
  public static final long P2V_DEFAULT_VIDEO_CAN_UPLOAD_LIMIT_MS = 15000L;
  public static final String P2V_EFFECT_DEFAILY_NAME = "DEFAULT_NAME";
  public static final String P2V_EFFECT_DEFAULT_ID = "DEFAULT";
  public static String P2V_MATERIAL_DUMMY_VIDEO_NAME;
  public static String P2V_MATERIAL_ROOT;
  public static String P2V_MATERIAL_WATER_MARKER_PNG_NAME;
  public static final int P2V_MAX_RECOMMEND_INT_DEFAULT = 30;
  public static final String P2V_MAX_RECOMMEND_INT_SECONDARY_KEY = "p2v_max_recommend_int";
  public static final int P2V_MAX_RECOMMEND_VIDEO_INT_DEFAULT = 3;
  public static final String P2V_MAX_RECOMMEND_VIDEO_INT_SECONDARY_KEY = "p2v_max_recommend_video_int";
  public static final long P2V_PIC_DURING = 2000L;
  public static final float P2V_PIC_EFFECT_DURING = 2000.0F;
  public static String P2V_VIDEO_CACHE_ROOT;
  public static String P2V_VIDEO_ROOT;
  public static final long VIDEO_CAN_UPLOAD_LIMIT_MS;
  public static final float VIEW_SCLE = 0.5625F;
  public static final float WATER_MARKER_BG_COLOR_ALPHA_END = 0.1F;
  public static final float WATER_MARKER_BG_COLOR_ALPHA_START = 0.0F;
  public static final int WATER_MARKER_BLUR_FADE_DURATION = 640;
  public static final int WATER_MARKER_DURATION = 2000;
  public static final int WATER_MARKER_HEIGHT = 252;
  public static final int WATER_MARKER_LOGO_FADE_END_TIME = 1000;
  public static final int WATER_MARKER_LOGO_FADE_START_TIME = 320;
  public static final int WATER_MARKER_WATER_MARKER_BLUR_RADIUS_END = 5;
  public static final int WATER_MARKER_WATER_MARKER_BLUR_RADIUS_START = 1;
  public static final int WATER_MARKER_WIDTH = 490;
  
  static
  {
    MAX_P2V_RECOMMEND_INT = QzoneConfig.getInstance().getConfig("p2v_config_main_key", "p2v_max_recommend_int", 30);
    VIDEO_CAN_UPLOAD_LIMIT_MS = QzoneConfig.getInstance().getConfig("p2v_config_main_key", "p2v_can_upload_limit_ms_secondary_key", 15000L);
    P2V_VIDEO_CACHE_ROOT = Environment.getExternalStorageDirectory().toString() + File.separator + "tencent" + File.separator + "dynamic_video_cache" + File.separator;
    P2V_VIDEO_ROOT = Environment.getExternalStorageDirectory().toString() + File.separator + "qzone_dynamic_video" + File.separator;
    CONCAT_FINAL_MP3 = P2V_VIDEO_CACHE_ROOT + "concat_final.mp3";
    P2V_MATERIAL_ROOT = P2V_VIDEO_CACHE_ROOT + "p2v_material" + File.separator;
    P2V_MATERIAL_WATER_MARKER_PNG_NAME = P2V_MATERIAL_ROOT + "qzone_p2v_watermark.png";
    P2V_MATERIAL_DUMMY_VIDEO_NAME = P2V_MATERIAL_ROOT + "resizeddummy.mp4";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig
 * JD-Core Version:    0.7.0.1
 */