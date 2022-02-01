package com.tencent.biz.pubaccount.weishi_new.player.wrapper.superplayer;

import com.tencent.biz.pubaccount.weishi_new.player.wrapper.AbsWSPlayerInfo;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerPreDownloader;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerPreDownloader.Listener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.ISPlayerPreDownloader.Listener;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;

public class SuperPlayerPreDownloader
  implements IWSPlayerPreDownloader<Object, SuperPlayerVideoInfo>, ISPlayerPreDownloader.Listener
{
  private IWSPlayerPreDownloader.Listener jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader$Listener;
  private ISPlayerPreDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
  
  public SuperPlayerPreDownloader(ISPlayerPreDownloader paramISPlayerPreDownloader)
  {
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader = paramISPlayerPreDownloader;
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.setOnPreDownloadListener(this);
    }
  }
  
  public void a()
  {
    ISPlayerPreDownloader localISPlayerPreDownloader = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
    if (localISPlayerPreDownloader == null) {
      return;
    }
    localISPlayerPreDownloader.stopAllPreDownload();
  }
  
  public void a(AbsWSPlayerInfo<Object, SuperPlayerVideoInfo> paramAbsWSPlayerInfo)
  {
    ISPlayerPreDownloader localISPlayerPreDownloader = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
    if ((localISPlayerPreDownloader == null) || (paramAbsWSPlayerInfo == null)) {
      return;
    }
    localISPlayerPreDownloader.startPreDownload((SuperPlayerVideoInfo)paramAbsWSPlayerInfo.d(), paramAbsWSPlayerInfo.b, 2000L);
  }
  
  public void a(IWSPlayerPreDownloader.Listener paramListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader$Listener = paramListener;
  }
  
  public boolean a(AbsWSPlayerInfo<Object, SuperPlayerVideoInfo> paramAbsWSPlayerInfo)
  {
    return false;
  }
  
  public void b()
  {
    ISPlayerPreDownloader localISPlayerPreDownloader = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
    if (localISPlayerPreDownloader == null) {
      return;
    }
    localISPlayerPreDownloader.destory();
  }
  
  public void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2) {}
  
  public void onPrepareError(int paramInt)
  {
    IWSPlayerPreDownloader.Listener localListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader$Listener;
    if (localListener == null) {
      return;
    }
    localListener.a("", 0, "");
  }
  
  public void onPrepareSuccess(int paramInt)
  {
    WSLog.b("SuperPlayerPreDownloader", "[SuperPlayerPreDownloader.java][onPrepareSuccess] taskId:" + paramInt);
    IWSPlayerPreDownloader.Listener localListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSPlayerPreDownloader$Listener;
    if (localListener == null) {
      return;
    }
    localListener.a("", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.wrapper.superplayer.SuperPlayerPreDownloader
 * JD-Core Version:    0.7.0.1
 */