import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.process.video.CmGameGdtVideoPlayer.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class anao
  implements anaz, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnVideoPreparedListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ISuperPlayer jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  private ISPlayerVideoView jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new CmGameGdtVideoPlayer.1(this);
  private CopyOnWriteArrayList<anay> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  private long b = 1000L;
  
  private void c()
  {
    if ((this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (this.jdField_a_of_type_AndroidOsHandler != null))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Long = (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs() - this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs());
      if (this.jdField_a_of_type_Long > 0L) {
        this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getVideoWidth();
    }
    return 0;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs();
    }
    return 0L;
  }
  
  public View a()
  {
    if ((this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView == null) || (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null)) {}
    try
    {
      QLog.i("CmGameGdtVideoPlayer", 1, "[createPlayerVideoView]");
      this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 110, this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCompletionListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoPreparedListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnErrorListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnInfoListener(this);
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView.addViewCallBack(new anap(this));
      return (View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("CmGameGdtVideoPlayer", 1, "getVideoContainer", localException);
        this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView = null;
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = null;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
    {
      QLog.i("CmGameGdtVideoPlayer", 1, "[resume]");
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
      this.jdField_a_of_type_Int = 3;
      c();
    }
  }
  
  public void a(anay paramanay)
  {
    a(paramanay, 1000L);
  }
  
  public void a(anay paramanay, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramanay))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramanay);
    }
    this.b = paramLong;
  }
  
  public void a(Context paramContext, AppInterface paramAppInterface) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
    {
      QLog.i("CmGameGdtVideoPlayer", 1, "[startPlay] url = " + paramString1);
      paramString1 = SuperPlayerFactory.createVideoInfoForUrl(paramString1, 104, null);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.openMediaPlayer(BaseApplicationImpl.getContext(), paramString1, paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
    {
      QLog.i("CmGameGdtVideoPlayer", 1, "setMute " + paramBoolean);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isOutputMute();
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getVideoHeight();
    }
    return 0;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs();
    }
    return 0L;
  }
  
  public void b()
  {
    QLog.i("CmGameGdtVideoPlayer", 1, "[release]");
    d();
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.release();
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = null;
      this.jdField_a_of_type_Int = 6;
    }
  }
  
  public void b(anay paramanay)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramanay))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramanay);
    }
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying()))
    {
      QLog.i("CmGameGdtVideoPlayer", 1, "[pause]");
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.pause();
      d();
      this.jdField_a_of_type_Int = 4;
      return true;
    }
    return false;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying();
    }
    return false;
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPausing();
    }
    return false;
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    QLog.i("CmGameGdtVideoPlayer", 1, "[onCompletion]");
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = 5;
    paramISuperPlayer = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (paramISuperPlayer.hasNext())
    {
      anay localanay = (anay)paramISuperPlayer.next();
      if (localanay != null) {
        localanay.e();
      }
    }
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QLog.i("CmGameGdtVideoPlayer", 1, "[onError]extra model = " + paramInt1 + ", errorType = " + paramInt2 + ", errorCode = " + paramInt3 + ", detailInfo = " + paramString);
    paramISuperPlayer = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (paramISuperPlayer.hasNext())
    {
      anay localanay = (anay)paramISuperPlayer.next();
      if (localanay != null) {
        localanay.a(paramInt1, paramInt2, paramInt2, paramString);
      }
    }
    d();
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    QLog.i("CmGameGdtVideoPlayer", 1, "what:" + paramInt);
    return false;
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    QLog.i("CmGameGdtVideoPlayer", 1, "[onVideoPrepared]");
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_Boolean = false;
    paramISuperPlayer = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (paramISuperPlayer.hasNext())
    {
      anay localanay = (anay)paramISuperPlayer.next();
      if (localanay != null) {
        localanay.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anao
 * JD-Core Version:    0.7.0.1
 */