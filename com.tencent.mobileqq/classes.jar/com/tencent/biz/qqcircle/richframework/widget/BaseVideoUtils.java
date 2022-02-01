package com.tencent.biz.qqcircle.richframework.widget;

import java.util.HashMap;

public class BaseVideoUtils
{
  public static final HashMap<Integer, String> a = new HashMap();
  
  static
  {
    HashMap localHashMap = a;
    Integer localInteger = Integer.valueOf(0);
    localHashMap.put(localInteger, "PLAYER_INFO_UNKNOW");
    a.put(Integer.valueOf(100), "PLAYER_INFO_FIRST_CLIP_OPENED");
    a.put(Integer.valueOf(101), "PLAYER_INFO_PACKET_READ");
    a.put(Integer.valueOf(102), "PLAYER_INFO_FIRST_AUDIO_DECODER_START");
    a.put(Integer.valueOf(104), "PLAYER_INFO_FIRST_AUDIO_FRAME_RENDERED");
    a.put(Integer.valueOf(105), "PLAYER_INFO_FIRST_VIDEO_FRAME_RENDERED");
    a.put(Integer.valueOf(106), "PLAYER_INFO_FIRST_PACKET_READ");
    a.put(Integer.valueOf(107), "PLAYER_INFO_CURRENT_LOOP_START");
    a.put(Integer.valueOf(108), "PLAYER_INFO_CURRENT_LOOP_END");
    a.put(Integer.valueOf(109), "PLAYER_INFO_CLIP_EOS");
    a.put(Integer.valueOf(110), "PLAYER_INFO_EOS");
    a.put(Integer.valueOf(111), "PLAYER_INFO_SWITCH_DEFINITION");
    a.put(Integer.valueOf(112), "PLAYER_INFO_BUFFERING_START");
    a.put(Integer.valueOf(113), "PLAYER_INFO_BUFFERING_END");
    a.put(Integer.valueOf(114), "PLAYER_INFO_AUDIO_DECODER_TYPE");
    a.put(Integer.valueOf(115), "PLAYER_INFO_VIDEO_DECODER_TYPE");
    a.put(Integer.valueOf(116), "PLAYER_INFO_AUDIO_SW_DECODING_SLOW");
    a.put(Integer.valueOf(117), "PLAYER_INFO_AUDIO_HW_DECODING_SLOW");
    a.put(Integer.valueOf(118), "PLAYER_INFO_VIDEO_SW_DECODING_SLOW");
    a.put(Integer.valueOf(119), "PLAYER_INFO_VIDEO_HW_DECODING_SLOW");
    a.put(Integer.valueOf(121), "PLAYER_INFO_NEED_TO_ROTATE_SURFACE");
    a.put(Integer.valueOf(122), "PLAYER_INFO_MEDIACODEC_VIDEO_CROP");
    a.put(Integer.valueOf(123), "PLAYER_INFO_PRIVATE_HLS_TAG");
    a.put(Integer.valueOf(124), "PLAYER_INFO_PLAYER_TYPE");
    a.put(Integer.valueOf(200), "PLAYER_INFO_RETRY_PLAYER");
    a.put(Integer.valueOf(201), "PLAYER_INFO_ALL_DOWNLOAD_FINISH");
    a.put(Integer.valueOf(203), "PLAYER_INFO_OBJECT_PLAY_CDN_URL_CHANGED");
    a.put(Integer.valueOf(204), "PLAYER_INFO_OBJECT_PLAY_CDN_INFO_UPDATE");
    a.put(Integer.valueOf(205), "PLAYER_INFO_PROTOCOL_UPDATE");
    a.put(Integer.valueOf(206), "PLAYER_INFO_DOWNLOAD_STATUS_UPDATE");
    a.put(Integer.valueOf(207), "TP_PLAYER_INFO_OBJECT_DOWNLOAD_PROGRESS_UPDATE");
    a.put(Integer.valueOf(208), "PLAYER_INFO_OBJECT_MEDIA_CODEC_INFO");
    a.put(Integer.valueOf(209), "PLAYER_INFO_VIDEO_FRAME_CHECK_INFO");
    a.put(Integer.valueOf(250), "TP_PLAYER_INFO_STRING_DOWNLOAD_QUIC_STATUS_UPDATE");
    a.put(localInteger, "PLAYER_INFO_UNKNOW");
  }
  
  public static String a(int paramInt)
  {
    String str = (String)a.get(Integer.valueOf(paramInt));
    if (str == null) {
      return String.valueOf(paramInt);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.BaseVideoUtils
 * JD-Core Version:    0.7.0.1
 */