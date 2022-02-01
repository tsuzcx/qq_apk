package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.os.Looper;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.HashMap;

public class VideoExtractFrameTask
{
  private static String jdField_a_of_type_JavaLangString = VideoExtractFrameTask.class.getSimpleName();
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private VideoExtractFrameTask.Callback jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoExtractFrameTask$Callback = null;
  private VideoExtractFrameTask.TaskHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoExtractFrameTask$TaskHandler;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private HashMap<Integer, VideoExtractFrameTask.FrameInfo> jdField_a_of_type_JavaUtilHashMap;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  
  public VideoExtractFrameTask(Context paramContext, String paramString, HashMap<Integer, VideoExtractFrameTask.FrameInfo> paramHashMap, long paramLong)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void c()
  {
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, "", "");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(new VideoExtractFrameTask.1(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new VideoExtractFrameTask.2(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new VideoExtractFrameTask.3(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(new VideoExtractFrameTask.4(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnExtractFrameListener(new VideoExtractFrameTask.5(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_JavaLangString, 0L, 0L, localTVK_PlayerVideoInfo);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(this.jdField_a_of_type_AndroidContentContext, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoExtractFrameTask$TaskHandler = new VideoExtractFrameTask.TaskHandler(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoExtractFrameTask$TaskHandler.sendEmptyMessageDelayed(1, this.jdField_a_of_type_Long);
    c();
  }
  
  public void a(VideoExtractFrameTask.Callback paramCallback)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoExtractFrameTask$Callback = paramCallback;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoExtractFrameTask$TaskHandler != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoExtractFrameTask$TaskHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoExtractFrameTask$TaskHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoExtractFrameTask$Callback = null;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoExtractFrameTask
 * JD-Core Version:    0.7.0.1
 */