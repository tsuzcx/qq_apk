package com.tencent.TMG.sdk;

import com.tencent.TMG.utils.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AVQualityStats
{
  private static final String TAG = "AVQualityStats";
  public int audioCaptureChannelCount;
  public int audioCaptureSampleRate;
  public int audioCategory;
  public ArrayList<AudioDecodeParam> audioDecodeInfo = new ArrayList();
  public int audioDecodeNum;
  public int audioEncodeBR;
  public int audioEncodeType;
  public int audioEncodeVAD;
  public int audioQosAec;
  public int audioQosAgc;
  public int audioQosChannelCount;
  public int audioQosEncodeBR;
  public int audioQosEncodeType;
  public int audioQosFec;
  public int audioQosJitterDropScale;
  public int audioQosJitterMaxMaxDelay;
  public int audioQosJitterMinDelay;
  public int audioQosJitterMinMaxDelay;
  public int audioQosMtu;
  public int audioQosPackDuration;
  public int audioQosRecm;
  public int audioQosRecn;
  public int audioQosSampleRare;
  public int audioQosVad;
  public int audioRecvLossRate;
  public int audioRecvPlayDelay;
  public int audioSendBR;
  public int audioSendBRUdt;
  public int audioSendFEC;
  public int audioSendJitter;
  public int audioSendLossRate;
  public int captureFps;
  public int captureHeight;
  public int captureWidth;
  public String clientIp;
  public int dwKbpsRecv;
  public int dwKbpsSend;
  public int dwPktpsRecv;
  public int dwPktpsSend;
  public int dwRTT;
  public String interfaceIp;
  public int isAnchor;
  public int isTcp;
  public int majorEncMode;
  public int majorEncodeType;
  public int majorFecType;
  public int majorGop;
  public int majorGopType;
  public int majorHw;
  public int majorIFecMinPkg;
  public int majorIFecMinSize;
  public int majorIFecPrecent;
  public int majorIMtu;
  public int majorMaxQP;
  public int majorMinQP;
  public int majorPFecMinPkg;
  public int majorPFecMinSize;
  public int majorPFecPrecent;
  public int majorPMtu;
  public int majorSPFecMinPkg;
  public int majorSPFecMinSize;
  public int majorSPFecPrecent;
  public int majorSPMtu;
  public int majorVidBitrate;
  public int majorVidFPS;
  public int majorVidHeight;
  public int majorVidWidth;
  public int miniEncMode;
  public int miniEncodeType;
  public int miniFecType;
  public int miniGop;
  public int miniGopType;
  public int miniHw;
  public int miniIFecMinPkg;
  public int miniIFecMinSize;
  public int miniIFecPrecent;
  public int miniIMtu;
  public int miniMaxQP;
  public int miniMinQP;
  public int miniPFecMinPkg;
  public int miniPFecMinSize;
  public int miniPFecPrecent;
  public int miniPMtu;
  public int miniSPFecMinPkg;
  public int miniSPFecMinSize;
  public int miniSPFecPrecent;
  public int miniSPMtu;
  public int miniVidBitrate;
  public int miniVidFPS;
  public int miniVidHeight;
  public int miniVidWidth;
  public int port;
  public String sdkVersion;
  public long tickCountBegin;
  public long tickCountEnd;
  public int unsendUdt;
  public ArrayList<VideoDecodeParam> videoDecodeInfo = new ArrayList();
  public int videoDecodeNum;
  public ArrayList<VideoEncodeParam> videoEncodeInfo = new ArrayList();
  public int videoSendIFec;
  public int videoSendLossRate;
  public int videoSendPkt;
  public int videoSendSPFec;
  public int videoSendStnSBBreak;
  public int videoSendStnSBDecLoss;
  public int videoSendStnSBGain;
  public int wExeCpuRate;
  public int wLossRateRecv;
  public int wLossRateRecvUdt;
  public int wLossRateSend;
  public int wLossRateSendUdt;
  public int wSysCpuRate;
  
  public String toJsonString()
  {
    JSONObject localJSONObject1 = new JSONObject();
    Iterator localIterator;
    Object localObject2;
    JSONObject localJSONObject3;
    try
    {
      localJSONObject1.put("tickCountBegin", this.tickCountBegin);
      localJSONObject1.put("tickCountEnd", this.tickCountEnd);
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("cpu_rate_app", this.wExeCpuRate);
      localJSONObject2.put("cpu_rate_sys", this.wSysCpuRate);
      localJSONObject2.put("sdk_version", this.sdkVersion);
      localJSONObject1.put("basic_info", localJSONObject2);
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("client_ip", this.clientIp);
      localJSONObject2.put("interface_ip", this.interfaceIp);
      localJSONObject2.put("interface_port", this.port);
      localJSONObject2.put("is_tcp", this.isTcp);
      localJSONObject2.put("kbps_send", this.dwKbpsSend);
      localJSONObject2.put("packet_send", this.dwPktpsSend);
      localJSONObject2.put("loss_rate_send", this.wLossRateSend);
      localJSONObject2.put("loss_rate_send_udt", this.wLossRateSendUdt);
      localJSONObject2.put("kbps_recv", this.dwKbpsRecv);
      localJSONObject2.put("packet_recv", this.dwPktpsRecv);
      localJSONObject2.put("loss_rate_recv", this.wLossRateRecv);
      localJSONObject2.put("loss_rate_recv_udt", this.wLossRateRecvUdt);
      localJSONObject2.put("rtt", this.dwRTT);
      localJSONObject1.put("network", localJSONObject2);
      localJSONObject2 = new JSONObject();
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("video_capture_width", this.captureWidth);
      ((JSONObject)localObject1).put("video_capture_height", this.captureHeight);
      ((JSONObject)localObject1).put("video_capture_fps", this.captureFps);
      localJSONObject2.put("video_capture_param", localObject1);
      localJSONObject2.put("is_anchor", this.isAnchor);
      localObject1 = new JSONArray();
      localIterator = this.videoEncodeInfo.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        localObject2 = (VideoEncodeParam)localIterator.next();
        localJSONObject3 = new JSONObject();
        localJSONObject3.put("video_encode_view_type", ((VideoEncodeParam)localObject2).encVideoStrType);
        localJSONObject3.put("video_encode_view_witdh", ((VideoEncodeParam)localObject2).encWidth);
        localJSONObject3.put("video_encode_view_height", ((VideoEncodeParam)localObject2).encHeight);
        localJSONObject3.put("video_encode_fps", ((VideoEncodeParam)localObject2).encFPS);
        localJSONObject3.put("video_encode_br", ((VideoEncodeParam)localObject2).encBR);
        localJSONObject3.put("video_encode_angle", ((VideoEncodeParam)localObject2).angle);
        localJSONObject3.put("video_encode_type", ((VideoEncodeParam)localObject2).encType);
        localJSONObject3.put("video_encode_hw", ((VideoEncodeParam)localObject2).hw);
        ((JSONArray)localObject1).put(localJSONObject3);
        i += 1;
      }
      if (i > 0) {
        localJSONObject2.put("video_encode_params", localObject1);
      }
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("video_send_loss_rate", this.videoSendLossRate);
      ((JSONObject)localObject1).put("video_send_pkt", this.videoSendPkt);
      ((JSONObject)localObject1).put("video_send_i_fec", this.videoSendIFec);
      ((JSONObject)localObject1).put("video_send_sp_fec", this.videoSendSPFec);
      ((JSONObject)localObject1).put("video_send_stnsb_gain_loss", this.videoSendStnSBGain);
      ((JSONObject)localObject1).put("video_send_stnsb_decloss", this.videoSendStnSBDecLoss);
      ((JSONObject)localObject1).put("video_send_stnsb_break", this.videoSendStnSBBreak);
      localJSONObject2.put("video_send_param", localObject1);
      localObject1 = new JSONArray();
      localIterator = this.videoDecodeInfo.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (VideoDecodeParam)localIterator.next();
        localJSONObject3 = new JSONObject();
        localJSONObject3.put("video_decode_tiny_id", ((VideoDecodeParam)localObject2).senderUin);
        localJSONObject3.put("video_decode_view_type", ((VideoDecodeParam)localObject2).decVideoStrType);
        localJSONObject3.put("video_decode_view_witdh", ((VideoDecodeParam)localObject2).decWidth);
        localJSONObject3.put("video_decode_view_height", ((VideoDecodeParam)localObject2).decHeight);
        localJSONObject3.put("video_decode_fps", ((VideoDecodeParam)localObject2).decFPS);
        localJSONObject3.put("video_decode_br", ((VideoDecodeParam)localObject2).decBR);
        localJSONObject3.put("video_decode_type", ((VideoDecodeParam)localObject2).decType);
        localJSONObject3.put("video_decode_hw", ((VideoDecodeParam)localObject2).hw);
        localJSONObject3.put("video_recv_loss_rate", ((VideoDecodeParam)localObject2).recvLossRate);
        localJSONObject3.put("video_recv_loss_jitter", ((VideoDecodeParam)localObject2).recvJitter);
        localJSONObject3.put("video_recv_br", ((VideoDecodeParam)localObject2).recvBR);
        ((JSONArray)localObject1).put(localJSONObject3);
      }
      if (this.videoDecodeNum <= 0) {
        break label872;
      }
    }
    catch (JSONException localJSONException)
    {
      QLog.e("AVQualityStats", 0, "AVQualityJsonObj to json string error", localJSONException);
      return "";
    }
    localJSONObject2.put("video_decode_count", this.videoDecodeNum);
    localJSONObject2.put("video_decode_params", localObject1);
    label872:
    if (this.majorVidWidth > 0)
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("qos_width", this.majorVidWidth);
      ((JSONObject)localObject1).put("qos_height", this.majorVidHeight);
      ((JSONObject)localObject1).put("qos_fps", this.majorVidFPS);
      ((JSONObject)localObject1).put("qos_bitrate", this.majorVidBitrate);
      ((JSONObject)localObject1).put("qos_encode_type", this.majorEncodeType);
      ((JSONObject)localObject1).put("qos_min_qp", this.majorMinQP);
      ((JSONObject)localObject1).put("qos_max_qp", this.majorMaxQP);
      ((JSONObject)localObject1).put("qos_fectype", this.majorFecType);
      ((JSONObject)localObject1).put("qos_i_fec_precent", this.majorIFecMinPkg);
      ((JSONObject)localObject1).put("qos_sp_fec_precent", this.majorSPFecMinPkg);
      ((JSONObject)localObject1).put("qos_p_fec_precent", this.majorPFecMinPkg);
      ((JSONObject)localObject1).put("qos_i_mtu", this.majorIMtu);
      ((JSONObject)localObject1).put("qos_sp_mtu", this.majorSPMtu);
      ((JSONObject)localObject1).put("qos_p_mtu", this.majorPMtu);
      ((JSONObject)localObject1).put("qos_i_fec_min_pkg", this.majorIFecMinPkg);
      ((JSONObject)localObject1).put("qos_sp_fec_min_pkg", this.majorSPFecMinPkg);
      ((JSONObject)localObject1).put("qos_p_fec_min_pkg", this.majorPFecMinPkg);
      ((JSONObject)localObject1).put("qos_i_fec_min_size", this.majorIFecMinSize);
      ((JSONObject)localObject1).put("qos_sp_fec_min_size", this.majorSPFecMinSize);
      ((JSONObject)localObject1).put("qos_p_fec_min_size", this.majorPFecMinSize);
      ((JSONObject)localObject1).put("qos_gop_type", this.majorGopType);
      ((JSONObject)localObject1).put("qos_gop", this.majorGop);
      ((JSONObject)localObject1).put("qos_hw", this.majorHw);
      localJSONException.put("qos_main", localObject1);
    }
    if (this.miniVidWidth > 0)
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("qos_width", this.miniVidWidth);
      ((JSONObject)localObject1).put("qos_height", this.miniVidHeight);
      ((JSONObject)localObject1).put("qos_fps", this.miniVidFPS);
      ((JSONObject)localObject1).put("qos_bitrate", this.miniVidBitrate);
      ((JSONObject)localObject1).put("qos_encode_type", this.miniEncodeType);
      ((JSONObject)localObject1).put("qos_min_qp", this.miniMinQP);
      ((JSONObject)localObject1).put("qos_max_qp", this.miniMaxQP);
      ((JSONObject)localObject1).put("qos_fectype", this.miniFecType);
      ((JSONObject)localObject1).put("qos_i_fec_precent", this.miniIFecMinPkg);
      ((JSONObject)localObject1).put("qos_sp_fec_precent", this.miniSPFecMinPkg);
      ((JSONObject)localObject1).put("qos_p_fec_precent", this.miniPFecMinPkg);
      ((JSONObject)localObject1).put("qos_i_mtu", this.miniIMtu);
      ((JSONObject)localObject1).put("qos_sp_mtu", this.miniSPMtu);
      ((JSONObject)localObject1).put("qos_p_mtu", this.miniPMtu);
      ((JSONObject)localObject1).put("qos_i_fec_min_pkg", this.miniIFecMinPkg);
      ((JSONObject)localObject1).put("qos_i_sp_fec_min_pkg", this.miniSPFecMinPkg);
      ((JSONObject)localObject1).put("qos_p_fec_min_pkg", this.miniPFecMinPkg);
      ((JSONObject)localObject1).put("qos_i_fec_min_size", this.miniIFecMinSize);
      ((JSONObject)localObject1).put("qos_sp_fec_min_size", this.miniSPFecMinSize);
      ((JSONObject)localObject1).put("qos_p_fec_min_size", this.miniPFecMinSize);
      ((JSONObject)localObject1).put("qos_gop_type", this.miniGopType);
      ((JSONObject)localObject1).put("qos_gop", this.miniGop);
      ((JSONObject)localObject1).put("qos_hw", this.miniHw);
      localJSONObject2.put("qos_mini", localObject1);
    }
    if ((this.captureWidth > 0) || (this.videoDecodeNum > 0)) {
      localJSONException.put("video_param", localJSONObject2);
    }
    JSONObject localJSONObject2 = new JSONObject();
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("audio_capture_sample", this.audioCaptureSampleRate);
    ((JSONObject)localObject1).put("audio_capture_channel_count", this.audioCaptureChannelCount);
    localJSONObject2.put("audio_capture_param", localObject1);
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("audio_encode_type", this.audioEncodeType);
    ((JSONObject)localObject1).put("audio_encode_br", this.audioEncodeBR);
    ((JSONObject)localObject1).put("audio_encode_vad", this.audioEncodeVAD);
    localJSONObject2.put("audio_encode_param", localObject1);
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("audio_send_loss_rate", this.audioSendLossRate);
    ((JSONObject)localObject1).put("audio_send_fec", this.audioSendFEC);
    ((JSONObject)localObject1).put("audio_send_jitter", this.audioSendJitter);
    ((JSONObject)localObject1).put("audio_send_br", this.audioSendBR);
    ((JSONObject)localObject1).put("audio_send_br_udt", this.audioSendBRUdt);
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("qos_sample_rate", this.audioQosSampleRare);
    ((JSONObject)localObject1).put("qos_codec_type", this.audioQosEncodeType);
    ((JSONObject)localObject1).put("qos_channel_count", this.audioQosChannelCount);
    ((JSONObject)localObject1).put("qos_bitrate", this.audioQosEncodeBR);
    ((JSONObject)localObject1).put("qos_aec", this.audioQosAec);
    ((JSONObject)localObject1).put("qos_agc", this.audioQosAgc);
    ((JSONObject)localObject1).put("qos_fec", this.audioQosFec);
    ((JSONObject)localObject1).put("qos_vad", this.audioQosVad);
    ((JSONObject)localObject1).put("qos_pack_duration", this.audioQosPackDuration);
    ((JSONObject)localObject1).put("qos_recn", this.audioQosRecn);
    ((JSONObject)localObject1).put("qos_recm", this.audioQosRecm);
    ((JSONObject)localObject1).put("qos_mtu", this.audioQosMtu);
    ((JSONObject)localObject1).put("qos_jitter_min_delay", this.audioQosJitterMinDelay);
    ((JSONObject)localObject1).put("qos_jitter_min_max_delay", this.audioQosJitterMinMaxDelay);
    ((JSONObject)localObject1).put("qos_jitter_max_max_delay", this.audioQosJitterMaxMaxDelay);
    ((JSONObject)localObject1).put("qos_jitter_drop_scale", this.audioQosJitterDropScale);
    localJSONObject2.put("audio_qos_param", localObject1);
    if (this.audioDecodeNum > 0)
    {
      localObject1 = new JSONArray();
      localIterator = this.audioDecodeInfo.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (AudioDecodeParam)localIterator.next();
        localJSONObject3 = new JSONObject();
        localJSONObject3.put("audio_decode_tiny_id", ((AudioDecodeParam)localObject2).tinyId);
        localJSONObject3.put("audio_decode_type", ((AudioDecodeParam)localObject2).decodeType);
        localJSONObject3.put("audio_decode_sample_rate", ((AudioDecodeParam)localObject2).sampleRate);
        localJSONObject3.put("audio_decode_channel_count", ((AudioDecodeParam)localObject2).channelCount);
        ((JSONArray)localObject1).put(localJSONObject3);
      }
      localJSONObject2.put("audio_decode_param", localObject1);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("audio_recv_play_delay", this.audioRecvPlayDelay);
      ((JSONObject)localObject1).put("audio_recv_loss_rate", this.audioRecvLossRate);
      localJSONObject2.put("audio_recv_param", localObject1);
    }
    localJSONObject2.put("audio_category", this.audioCategory);
    if ((this.audioCaptureSampleRate > 0) || (this.audioDecodeNum > 0)) {
      localJSONException.put("audio_param", localJSONObject2);
    }
    return localJSONException.toString();
  }
  
  public static class AudioDecodeParam
  {
    public int channelCount;
    public int decodeType;
    public int sampleRate;
    public int tinyId;
  }
  
  public static class VideoDecodeParam
  {
    public int decBR;
    public int decFPS;
    public int decHeight;
    public int decType;
    public int decVideoStrType;
    public int decWidth;
    public int hw;
    public int hwDecDelay;
    public int recvBR;
    public int recvJitter;
    public int recvLossRate;
    public int senderUin;
  }
  
  public static class VideoEncodeParam
  {
    public int angle;
    public int encBR;
    public int encFPS;
    public int encHeight;
    public int encType;
    public int encVideoStrType;
    public int encWidth;
    public int hw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVQualityStats
 * JD-Core Version:    0.7.0.1
 */