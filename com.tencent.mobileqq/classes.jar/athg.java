import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.QQLiveDrawable.OnStateListener;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import mqq.app.AppRuntime;

public class athg
{
  private static athg jdField_a_of_type_Athg;
  public static boolean a;
  private athh jdField_a_of_type_Athh;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public static athg a()
  {
    if (jdField_a_of_type_Athg == null) {
      jdField_a_of_type_Athg = new athg();
    }
    return jdField_a_of_type_Athg;
  }
  
  public static URLDrawable a(String paramString, int paramInt1, int paramInt2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = new apgg(-10065297, 100, 100);
    localURLDrawableOptions.mFailedDrawable = new apgg(-10065297, 100, 100);
    localURLDrawableOptions.mRequestHeight = paramInt2;
    localURLDrawableOptions.mRequestWidth = paramInt1;
    return URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions);
  }
  
  public static URLDrawable a(String paramString1, String paramString2, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt3, QQLiveDrawable.OnStateListener paramOnStateListener, URLDrawable paramURLDrawable)
  {
    QQLiveDrawable.QQLiveDrawableParams localQQLiveDrawableParams = new QQLiveDrawable.QQLiveDrawableParams();
    localQQLiveDrawableParams.mPreviewWidth = paramInt1;
    localQQLiveDrawableParams.mPreviewHeight = paramInt2;
    localQQLiveDrawableParams.mDataSourceType = 3;
    localQQLiveDrawableParams.mDataSource = paramString1;
    localQQLiveDrawableParams.mLoopback = paramBoolean1;
    localQQLiveDrawableParams.mMute = paramBoolean2;
    localQQLiveDrawableParams.mPlayPause = paramBoolean3;
    localQQLiveDrawableParams.mStartPosi = paramInt3;
    localQQLiveDrawableParams.mPlayType = 2;
    localQQLiveDrawableParams.mListener = paramOnStateListener;
    localQQLiveDrawableParams.msgUniseq = paramLong;
    localQQLiveDrawableParams.mCoverUrl = ShortVideoUtils.a(paramString2).toString();
    localQQLiveDrawableParams.mCoverLoadingDrawable = new apgg(-10065297, 100, 100);
    localQQLiveDrawableParams.mReportTag = "bus_type_aio_light_bubble";
    paramString1 = URLDrawable.URLDrawableOptions.obtain();
    paramString1.mExtraInfo = localQQLiveDrawableParams;
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL().getPath().equals(paramString2))) {}
    for (paramString1.mLoadingDrawable = paramURLDrawable;; paramString1.mLoadingDrawable = new apgg(-10065297, 100, 100))
    {
      paramString1.mRequestWidth = paramInt1;
      paramString1.mRequestHeight = paramInt2;
      return URLDrawable.getDrawable(afvt.a(paramLong), paramString1);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    ChatMessage localChatMessage = MediaPlayerManager.a(paramQQAppInterface).a();
    if (((localChatMessage == paramChatMessage) || (((localChatMessage instanceof MessageForLightVideo)) && (localChatMessage.uniseq == paramChatMessage.uniseq))) && (((MessageForLightVideo)paramChatMessage).videoStatus == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        MediaPlayerManager.a(paramQQAppInterface).a(true);
      }
      return bool;
    }
  }
  
  public void a(athh paramathh)
  {
    this.jdField_a_of_type_Athh = paramathh;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoPlayMgr", 2, "switchEarOrLoudspeaker:" + paramBoolean);
    }
    jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Athh != null) {
      this.jdField_a_of_type_Athh.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return MediaPlayerManager.a((QQAppInterface)localAppRuntime).b();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     athg
 * JD-Core Version:    0.7.0.1
 */