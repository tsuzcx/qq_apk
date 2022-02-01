package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/event/DownloadClickState;", "", "(Ljava/lang/String;I)V", "START_DOWNLOAD", "PAUSE_DOWNLOAD", "RESUME_DOWNLOAD", "OPEN_APP", "INSTALL_APP", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public enum DownloadClickState
{
  static
  {
    DownloadClickState localDownloadClickState1 = new DownloadClickState("START_DOWNLOAD", 0);
    START_DOWNLOAD = localDownloadClickState1;
    DownloadClickState localDownloadClickState2 = new DownloadClickState("PAUSE_DOWNLOAD", 1);
    PAUSE_DOWNLOAD = localDownloadClickState2;
    DownloadClickState localDownloadClickState3 = new DownloadClickState("RESUME_DOWNLOAD", 2);
    RESUME_DOWNLOAD = localDownloadClickState3;
    DownloadClickState localDownloadClickState4 = new DownloadClickState("OPEN_APP", 3);
    OPEN_APP = localDownloadClickState4;
    DownloadClickState localDownloadClickState5 = new DownloadClickState("INSTALL_APP", 4);
    INSTALL_APP = localDownloadClickState5;
    $VALUES = new DownloadClickState[] { localDownloadClickState1, localDownloadClickState2, localDownloadClickState3, localDownloadClickState4, localDownloadClickState5 };
  }
  
  private DownloadClickState() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.DownloadClickState
 * JD-Core Version:    0.7.0.1
 */