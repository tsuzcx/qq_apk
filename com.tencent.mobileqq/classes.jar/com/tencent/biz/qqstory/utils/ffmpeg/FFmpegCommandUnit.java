package com.tencent.biz.qqstory.utils.ffmpeg;

import android.text.TextUtils;
import java.util.ArrayList;

public class FFmpegCommandUnit
{
  public static final int CMDTYPE_CHANGE_ORIENTATION = 12;
  public static final int CMDTYPE_CLIP_AUDIO = 3;
  public static final int CMDTYPE_COMBINE_DOODLE = 15;
  public static final int CMDTYPE_COMBINE_VIDEO_AUDIO = 4;
  public static final int CMDTYPE_COMPRESS_VIDEO = 11;
  public static final int CMDTYPE_CONCAT_DIFF_VIDEO = 8;
  public static final int CMDTYPE_CONCAT_TS = 6;
  public static final int CMDTYPE_CONCAT_VIDEO = 2;
  public static final int CMDTYPE_CONCAT_VIDEO_BY_TS = 7;
  public static final int CMDTYPE_CONVERT_PIC_TO_VIDEO = 9;
  public static final int CMDTYPE_CONVERT_PIC_TO_VIDEO_WITH_DURATION = 20;
  public static final int CMDTYPE_DETECT_INFO_VOLUME = 22;
  public static final int CMDTYPE_EMPTY = 14;
  public static final int CMDTYPE_HFLIP_VIDEO = 10;
  public static final int CMDTYPE_MP4_TO_TS = 5;
  public static final int CMDTYPE_SET_TIMESTAMP = 13;
  public static final int CMDTYPE_TRANSCODE_AUDIO = 21;
  public static final int CMDTYPE_WARTERMARK = 1;
  public static final int CMPTYPE_GET_AUDIO_FROM_MP4 = 18;
  public static final int CMPTYPE_GET_VIDEO_FROM_MP4 = 19;
  public static final int CMPTYPE_MIX_AUDIO = 17;
  public static final int CMPTYPE_MP4_TO_MP3 = 16;
  public ArrayList<Object> arguments;
  public FFmpegExecuteResponseCallback callback;
  public String[] cmd;
  public int cmdType;
  public String output;
  
  public FFmpegCommandUnit() {}
  
  public FFmpegCommandUnit(String[] paramArrayOfString, String paramString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    this.output = paramString;
    this.cmd = paramArrayOfString;
    this.callback = paramFFmpegExecuteResponseCallback;
  }
  
  public String toString()
  {
    String str1;
    if (this.cmd == null)
    {
      str1 = "null";
      if (this.arguments != null) {
        break label86;
      }
    }
    label86:
    for (String str2 = "null";; str2 = TextUtils.join(",", this.arguments.toArray()))
    {
      return "FFmpegCommandUnit{ cmdType :" + this.cmdType + "\n cmd: " + str1 + "\n output: " + this.output + "\n arguments: " + str2;
      str1 = TextUtils.join(" ", this.cmd);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandUnit
 * JD-Core Version:    0.7.0.1
 */