import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.runtime.audiorecorder.LameMp3EncodeThread;
import java.lang.ref.WeakReference;

class bhan
  extends Handler
{
  int jdField_a_of_type_Int = 1;
  private final WeakReference<bhak> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bhan(bhak parambhak)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambhak);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    bhak localbhak;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      localbhak = (bhak)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      switch (paramMessage.what)
      {
      }
    }
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
                          paramMessage = (String)paramMessage.obj;
                          if ((!TextUtils.isEmpty(paramMessage)) && (bhak.a(localbhak) != null)) {
                            bhak.a(localbhak).onErrorInfo(paramMessage);
                          }
                        } while (!hasMessages(4));
                        removeMessages(4);
                        return;
                        paramMessage = (String)paramMessage.obj;
                        if ((!TextUtils.isEmpty(paramMessage)) && (bhak.a(localbhak) != null)) {
                          bhak.a(localbhak).onErrorInfo(paramMessage);
                        }
                        if (hasMessages(104)) {
                          removeMessages(104);
                        }
                        if ((!TextUtils.isEmpty(paramMessage)) && (bhak.a(localbhak) != null)) {
                          bhak.a(localbhak).onErrorInfo(paramMessage);
                        }
                      } while (!hasMessages(104));
                      removeMessages(104);
                      return;
                      if (bhak.a(localbhak) != null) {
                        bhak.a(localbhak).onRecordStart();
                      }
                    } while (hasMessages(4));
                    sendEmptyMessage(4);
                    return;
                    if (bhak.a(localbhak) != null) {
                      bhak.a(localbhak).onRecordPause();
                    }
                  } while (!hasMessages(4));
                  removeMessages(4);
                  return;
                  if (bhak.a(localbhak) != null) {
                    bhak.a(localbhak).onRecordResume();
                  }
                } while (bhak.a(localbhak).hasMessages(4));
                bhak.a(localbhak).sendEmptyMessage(4);
                return;
                if (bhak.a(localbhak) != null) {
                  bhak.a(localbhak).onRecordStop(localbhak.a(), localbhak.a(), localbhak.b());
                }
              } while (!hasMessages(4));
              removeMessages(4);
              return;
            } while (bhak.a(localbhak) == null);
            byte[] arrayOfByte = (byte[])paramMessage.obj;
            if (paramMessage.arg1 == 1) {}
            for (;;)
            {
              bhak.a(localbhak).onRecordFrame(arrayOfByte, bool);
              return;
              bool = false;
            }
            if (hasMessages(4)) {
              removeMessages(4);
            }
            int i = localbhak.c();
            int j = localbhak.b();
            if (bhak.a(localbhak) != null) {
              bhak.a(localbhak).onRecordUpdate(j, i);
            }
            if (i == bhak.a(localbhak))
            {
              bhak.a(localbhak).c();
              return;
            }
            sendEmptyMessageDelayed(4, localbhak.a());
            return;
            if (hasMessages(104)) {
              removeMessages(104);
            }
            i = (int)(System.currentTimeMillis() - bhak.a(localbhak));
            this.jdField_a_of_type_Int += 1;
            if (this.jdField_a_of_type_Int > 5) {
              this.jdField_a_of_type_Int = 1;
            }
            if (bhak.a(localbhak) != null) {
              bhak.a(localbhak).onPlayUpdate(this.jdField_a_of_type_Int, i / 1000);
            }
            sendEmptyMessageDelayed(104, localbhak.a());
            return;
            if (bhak.a(localbhak) != null) {
              bhak.a(localbhak).onPlayStart();
            }
            bhak.a(localbhak, System.currentTimeMillis());
            sendEmptyMessageDelayed(104, localbhak.a());
            return;
            if (bhak.a(localbhak) != null) {
              bhak.a(localbhak).onPlayPause();
            }
          } while (!hasMessages(104));
          removeMessages(104);
          return;
          if (bhak.a(localbhak) != null) {
            bhak.a(localbhak).onPlayResume();
          }
        } while (hasMessages(104));
        sendEmptyMessage(104);
        return;
        if (bhak.a(localbhak) != null) {
          bhak.a(localbhak).onPlayStop();
        }
      } while (!hasMessages(104));
      removeMessages(104);
      return;
      if (bhak.a(localbhak) != null) {
        bhak.a(localbhak).onPlayFinish();
      }
    } while (!hasMessages(104));
    removeMessages(104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhan
 * JD-Core Version:    0.7.0.1
 */