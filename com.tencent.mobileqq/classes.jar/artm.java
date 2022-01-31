import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.List;

public class artm
  extends Handler
{
  private final WeakReference<QQMusicPlayService> a;
  
  public artm(QQMusicPlayService paramQQMusicPlayService, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramQQMusicPlayService);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    int k = 0;
    Object localObject = (QQMusicPlayService)this.a.get();
    if (localObject == null) {
      super.handleMessage(paramMessage);
    }
    label108:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                return;
                                try
                                {
                                  switch (paramMessage.what)
                                  {
                                  case 2: 
                                  case 3: 
                                  case 4: 
                                  case 5: 
                                    super.handleMessage(paramMessage);
                                    return;
                                  }
                                }
                                catch (Throwable paramMessage)
                                {
                                  paramMessage.printStackTrace();
                                  QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->handleMessage exception==>", paramMessage);
                                  return;
                                }
                                paramMessage = (artp)paramMessage.obj;
                              } while (paramMessage == null);
                              if (QLog.isColorLevel()) {
                                QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("--->handleMessage[MSG_FROM_SERVICE_RELEASE] [%s]", new Object[] { QQMusicPlayService.a() }));
                              }
                              QQMusicPlayService.a((QQMusicPlayService)localObject).clear();
                              if (paramMessage.a != null)
                              {
                                paramMessage.a.release();
                                if (QQMusicPlayService.a() == paramMessage.a) {
                                  QQMusicPlayService.a(null);
                                }
                              }
                              getLooper().quit();
                              return;
                              if (QLog.isColorLevel()) {
                                QLog.i("QQMusicPlay.QQMusicPlayService", 2, "--->handleMessage[MSG_FROM_CLIENT]");
                              }
                              paramMessage = paramMessage.replyTo;
                            } while (paramMessage == null);
                            QQMusicPlayService.a((QQMusicPlayService)localObject, paramMessage);
                            localObject = Message.obtain(null, 0);
                            ((Message)localObject).setData(new Bundle());
                            try
                            {
                              paramMessage.send((Message)localObject);
                              return;
                            }
                            catch (RemoteException paramMessage) {}
                          } while (!QLog.isColorLevel());
                          QLog.i("QQMusicPlay.QQMusicPlayService", 2, "--->handleMessage[MSG_FROM_CLIENT] sendToClient excepiton", paramMessage);
                          return;
                          if (QQMusicPlayService.a() != null) {
                            break;
                          }
                        } while (!QLog.isColorLevel());
                        QLog.e("QQMusicPlay.QQMusicPlayService", 2, "--->handleMessage[MSG_FROM_CLIENT_START_PLAY], sPlayer is null");
                        return;
                        paramMessage = paramMessage.getData();
                        paramMessage.setClassLoader(ISong.class.getClassLoader());
                        paramMessage = (ISong)paramMessage.getParcelable("key_song");
                        if ((paramMessage != null) && (paramMessage.a() != null) && (paramMessage.a().size() != 0)) {
                          break;
                        }
                      } while (!QLog.isColorLevel());
                      QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("--->handleMessage[MSG_FROM_CLIENT_START_PLAY] err url is null [%s]", new Object[] { paramMessage }));
                      return;
                      if (QLog.isColorLevel()) {
                        QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("--->handleMessage[MSG_FROM_CLIENT_START_PLAY] [%s]", new Object[] { paramMessage }));
                      }
                      if ((paramMessage.equals(QQMusicPlayService.a())) && ((QQMusicPlayService.d() == 2) || (QQMusicPlayService.d() == 1)))
                      {
                        int m = QQMusicPlayService.a();
                        if (m < 0) {}
                        for (i = -1;; i = Math.abs(m - paramMessage.a()))
                        {
                          int j = k;
                          if (QQMusicPlayService.d() == 2) {
                            if (m >= 0)
                            {
                              j = k;
                              if (Math.abs(m - paramMessage.a()) <= 3000) {}
                            }
                            else
                            {
                              QQMusicPlayService.e();
                              QQMusicPlayService.a((QQMusicPlayService)localObject, paramMessage.a());
                              j = 1;
                            }
                          }
                          QLog.i("ListenTogether.Seek", 1, "player start play player seek: " + m + " music seek: " + paramMessage.a() + " currentTime: " + System.currentTimeMillis());
                          if (j == 0) {
                            break;
                          }
                          artk.a(i, bbev.b((Context)localObject));
                          return;
                        }
                      }
                      if (QQMusicPlayService.a().isPlaying())
                      {
                        if (QLog.isColorLevel()) {
                          QLog.i("QQMusicPlay.QQMusicPlayService", 2, "------------stopped-------------");
                        }
                        QQMusicPlayService.a().stop();
                        artk.b(QQMusicPlayService.b(), QQMusicPlayService.c());
                      }
                      QQMusicPlayService.a((QQMusicPlayService)localObject, QQMusicPlayService.b(), 0);
                      QQMusicPlayService.a((QQMusicPlayService)localObject, false);
                      QQMusicPlayService.a((QQMusicPlayService)localObject, paramMessage);
                      QQMusicPlayService.b((QQMusicPlayService)localObject, paramMessage);
                    } while (paramMessage.a() <= 0);
                    QQMusicPlayService.a((QQMusicPlayService)localObject, paramMessage.a());
                    return;
                    if (QQMusicPlayService.a() != null) {
                      break;
                    }
                  } while (!QLog.isColorLevel());
                  QLog.e("QQMusicPlay.QQMusicPlayService", 2, "--->handleMessage[MSG_FROM_CLIENT_PAUSE_PLAY], sPlayer is null");
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.i("QQMusicPlay.QQMusicPlayService", 2, "--->handleMessage[MSG_FROM_CLIENT_PAUSE_PLAY]");
                  }
                } while ((QQMusicPlayService.d() != 2) && ((QQMusicPlayService.d() != 1) || (QQMusicPlayService.a() == null)));
                ((AudioManager)((QQMusicPlayService)localObject).getSystemService("audio")).abandonAudioFocus(QQMusicPlayService.a((QQMusicPlayService)localObject));
                if (QQMusicPlayService.a().isPlaying()) {
                  QQMusicPlayService.a().pause();
                }
                QQMusicPlayService.a((QQMusicPlayService)localObject, true);
                QQMusicPlayService.a((QQMusicPlayService)localObject, QQMusicPlayService.b(), 3);
                return;
                if (QQMusicPlayService.a() != null) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.e("QQMusicPlay.QQMusicPlayService", 2, "--->handleMessage[MSG_FROM_CLIENT_RESUME_PLAY], sPlayer is null");
              return;
              if (QLog.isColorLevel()) {
                QLog.i("QQMusicPlay.QQMusicPlayService", 2, "--->handleMessage[MSG_FROM_CLIENT_RESUME_PLAY]");
              }
              if ((QQMusicPlayService.d() != 3) || (QQMusicPlayService.a() == null)) {
                break;
              }
              QQMusicPlayService.a((QQMusicPlayService)localObject, false);
              paramMessage = (AudioManager)((QQMusicPlayService)localObject).getSystemService("audio");
              int i = paramMessage.requestAudioFocus(QQMusicPlayService.a((QQMusicPlayService)localObject), 3, 1);
              bool1 = paramMessage.isMusicActive();
              if (QLog.isColorLevel()) {
                QLog.d("QQMusicPlay.QQMusicPlayService", 2, "resumePlay requestAudioFocus,result:" + i + " isMusicActive:" + bool1);
              }
              if (i == 1)
              {
                QQMusicPlayService.a().start();
                QQMusicPlayService.a((QQMusicPlayService)localObject, QQMusicPlayService.b(), 2);
                return;
              }
              QQMusicPlayService.a((QQMusicPlayService)localObject, QQMusicPlayService.b(), 7);
            } while (QQMusicPlayService.a((QQMusicPlayService)localObject) == null);
            QQMusicPlayService.a((QQMusicPlayService)localObject).sendEmptyMessage(11);
            return;
            if ((QQMusicPlayService.d() != 6) && (QQMusicPlayService.d() != 7)) {
              break;
            }
          } while (!bbev.g(((QQMusicPlayService)localObject).getApplicationContext()));
          if (QLog.isColorLevel()) {
            QLog.d("QQMusicPlay.QQMusicPlayService", 2, String.format("resume from network interrupt, start play %s", new Object[] { QQMusicPlayService.a() }));
          }
          QQMusicPlayService.a((QQMusicPlayService)localObject, false);
          QQMusicPlayService.b((QQMusicPlayService)localObject, QQMusicPlayService.a());
          return;
        } while (QQMusicPlayService.d() != 5);
        QQMusicPlayService.a((QQMusicPlayService)localObject, false);
        QQMusicPlayService.b((QQMusicPlayService)localObject, QQMusicPlayService.a());
        return;
        if (QQMusicPlayService.a() != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      if (paramMessage.what == 10) {
        bool1 = true;
      }
      QLog.e("QQMusicPlay.QQMusicPlayService", 2, String.format("--->handleMessage[MSG_FROM_CLIENT_STOP_PLAY=%b],sPlayer is null", new Object[] { Boolean.valueOf(bool1) }));
      return;
      if (QLog.isColorLevel())
      {
        bool1 = bool2;
        if (paramMessage.what == 10) {
          bool1 = true;
        }
        QLog.d("QQMusicPlay.QQMusicPlayService", 2, String.format("--->handleMessage[MSG_FROM_CLIENT_STOP_PLAY=%b]", new Object[] { Boolean.valueOf(bool1) }));
      }
      if ((QQMusicPlayService.a() != null) && (QQMusicPlayService.a().isPlaying()))
      {
        QQMusicPlayService.a().stop();
        artk.b(QQMusicPlayService.b(), QQMusicPlayService.c());
      }
      ((AudioManager)((QQMusicPlayService)localObject).getSystemService("audio")).abandonAudioFocus(QQMusicPlayService.a((QQMusicPlayService)localObject));
      QQMusicPlayService.a((QQMusicPlayService)localObject, true);
      QQMusicPlayService.a((QQMusicPlayService)localObject, QQMusicPlayService.b(), 4);
      ((QQMusicPlayService)localObject).stopSelf();
      return;
      QQMusicPlayService.b((QQMusicPlayService)localObject, paramMessage.getData().getBoolean("key_mute", false));
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("--->handleMessage[MSG_FROM_CLIENT_MUTE_PLAY] %b", new Object[] { Boolean.valueOf(QQMusicPlayService.a((QQMusicPlayService)localObject)) }));
      }
    } while (QQMusicPlayService.a() == null);
    if (QQMusicPlayService.a((QQMusicPlayService)localObject)) {}
    for (float f = 0.0F;; f = 1.0F)
    {
      QQMusicPlayService.a().setVolume(f, f);
      return;
      if (QQMusicPlayService.d() == 2)
      {
        QQMusicPlayService.a((QQMusicPlayService)localObject).sendEmptyMessageDelayed(14, 500L);
        label1316:
        if ((QLog.isColorLevel()) && (paramMessage.what == 13)) {
          if (paramMessage.what != 13) {
            break label1401;
          }
        }
      }
      label1401:
      for (bool1 = true;; bool1 = false)
      {
        QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("--->handleMessage[MSG_FROM_CLIENT_SYNC_PROGRESS=%b]", new Object[] { Boolean.valueOf(bool1) }));
        if (QQMusicPlayService.a() == null) {
          break;
        }
        QQMusicPlayService.a((QQMusicPlayService)localObject, QQMusicPlayService.b(), QQMusicPlayService.a(), QQMusicPlayService.f());
        return;
        QQMusicPlayService.a((QQMusicPlayService)localObject).removeMessages(14);
        break label1316;
      }
      break label108;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     artm
 * JD-Core Version:    0.7.0.1
 */