import com.tencent.mobileqq.video.VipVideoPlayActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnControllerClickListener;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo.RecommadInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;

public class bihk
  implements TVK_IMediaPlayer.OnControllerClickListener
{
  public bihk(VipVideoPlayActivity paramVipVideoPlayActivity) {}
  
  public void onAttationClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo) {}
  
  public void onBackClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipVideoPlayActivity", 2, "video player onBackClick");
    }
    this.a.setResult(0);
    this.a.finish();
  }
  
  public void onBackOnFullScreenClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipVideoPlayActivity", 2, "video player onBackOnFullScreenClick");
    }
    if (this.a.getRequestedOrientation() == 0)
    {
      this.a.setRequestedOrientation(1);
      return;
    }
    this.a.setResult(0);
    this.a.finish();
  }
  
  public void onCacheClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo) {}
  
  public void onFeedbackClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo) {}
  
  public void onFullScreenClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipVideoPlayActivity", 2, "video player onFullScreenClick--------------");
    }
    this.a.setRequestedOrientation(0);
  }
  
  public void onReopenClick(TVK_NetVideoInfo.RecommadInfo paramRecommadInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bihk
 * JD-Core Version:    0.7.0.1
 */