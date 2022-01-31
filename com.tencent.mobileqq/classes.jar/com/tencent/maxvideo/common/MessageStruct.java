package com.tencent.maxvideo.common;

public class MessageStruct
{
  public static final int MSG_CANCEL = 2;
  public static final int MSG_ENCODE_BEGIN_CALLBACK = 50331650;
  public static final int MSG_ENCODE_CANCEL = 50331654;
  public static final int MSG_ENCODE_CMD = 50331649;
  public static final int MSG_ENCODE_FAIL = 50331653;
  public static final int MSG_ENCODE_PROGRESS_CALLBACK = 50331651;
  public static final int MSG_ENCODE_SUCCESS = 50331652;
  public static final int MSG_ERROR = -1;
  public static final int MSG_MATERIAL_GET_AVBATCH_MATERIAL_FRAME = 83886084;
  public static final int MSG_MATERIAL_GET_AVBATCH_MATERIAL_FRAME_RETURN = 83886085;
  public static final int MSG_MATERIAL_GET_MATERIAL_FRAME = 83886082;
  public static final int MSG_MATERIAL_GET_MATERIAL_FRAME_RETURN = 83886083;
  public static final int MSG_MATERIAL_PREPROCESS_CMD = 83886086;
  public static final int MSG_MATERIAL_UPDATE = 83886081;
  public static final int MSG_PROCESS_BEGIN = 4;
  public static final int MSG_PROCESS_END = 5;
  public static final int MSG_RECORD_BEGIN = 33554433;
  public static final int MSG_RECORD_BEGIN_SUCCESS_CALLBACK = 33554435;
  public static final int MSG_RECORD_CAPTURE_AUDIO = 33554437;
  public static final int MSG_RECORD_CAPTURE_QQ_VIDEO = 33554475;
  public static final int MSG_RECORD_CAPTURE_VIDEO = 33554438;
  public static final int MSG_RECORD_COPY_BUF = 33554442;
  public static final int MSG_RECORD_COPY_QQ_BUF = 33554474;
  public static final int MSG_RECORD_DEL_LAST_SEGMENT = 33554450;
  public static final int MSG_RECORD_DISCARD_DRAFT = 33554439;
  public static final int MSG_RECORD_END = 33554434;
  public static final int MSG_RECORD_GET_DRAFT_CALLBACK = 33554436;
  public static final int MSG_RECORD_RESET = 33554441;
  public static final int MSG_RECORD_SAVE_DRAFT = 33554440;
  public static final int MSG_RECORD_SEGMENT_END = 33554449;
  public static final int MSG_RECORD_SEGMENT_START = 33554448;
  public static final int MSG_RECORD_SUBMIT = 33554443;
  public static final int MSG_RECORD_SUBMIT_FINISH_CALLBACK = 33554451;
  public static final int MSG_SUCCESS = 1;
  public static final int MSG_THREAD_BEGIN = 16777217;
  public static final int MSG_THREAD_END = 16777218;
  public static final int MSG_THREAD_OPERATION_BEGIN = 16777219;
  public static final int MSG_THREAD_OPERATION_END = 16777220;
  public static final int MSG_THREAD_RUNLOOP_WAIT_BEGIN = 16777221;
  public static final int MSG_TIMEOUT = 3;
  public static final int MSG_TMMENGINE_INIT = 6;
  public static final int MSG_TMMENGINE_UNINIT = 7;
  public static final int MSG_VIDEOPLAYER_INIT_AUDIO_DEVICE = 67108866;
  public static final int MSG_VIDEOPLAYER_PAUSE_AUDIO = 67108870;
  public static final int MSG_VIDEOPLAYER_PCM_MIN_SIZE = 67108871;
  public static final int MSG_VIDEOPLAYER_PLAY_AUDIO = 67108867;
  public static final int MSG_VIDEOPLAYER_PLAY_BEGIN = 67108872;
  public static final int MSG_VIDEOPLAYER_PLAY_END = 67108873;
  public static final int MSG_VIDEOPLAYER_RENDER_FRAME = 67108865;
  public static final int MSG_VIDEOPLAYER_STOP_AUDIO = 67108869;
  public static final int MSG_VIDEOPLAYER_WRITE_AUDIO = 67108868;
  public int mId;
  MessageStruct.MessageCallBack mMsgCallBack;
  public String mName;
  public Object mObj0;
  public Object mObj1;
  public int mParam0;
  public int mParam1;
  
  public MessageStruct() {}
  
  public MessageStruct(int paramInt)
  {
    this.mId = paramInt;
  }
  
  public MessageStruct(int paramInt, String paramString)
  {
    this.mId = paramInt;
    this.mName = paramString;
  }
  
  public String toString()
  {
    return "{id:0x" + Integer.toHexString(this.mId).toUpperCase() + ", name=" + this.mName + ", param0:" + this.mParam0 + ", param1:" + this.mParam1 + ", obj0:" + this.mObj0 + ", obj1:" + this.mObj1 + ", msgCallBack:" + this.mMsgCallBack + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.maxvideo.common.MessageStruct
 * JD-Core Version:    0.7.0.1
 */