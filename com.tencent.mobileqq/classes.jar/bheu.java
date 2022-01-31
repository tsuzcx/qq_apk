import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.runtime.audiorecorder.LameMp3EncodeThread;
import java.lang.ref.WeakReference;

class bheu
  extends Handler
{
  int jdField_a_of_type_Int = 1;
  private final WeakReference<bher> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bheu(bher parambher)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambher);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    bher localbher;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      localbher = (bher)this.jdField_a_of_type_JavaLangRefWeakReference.get();
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
                          if ((!TextUtils.isEmpty(paramMessage)) && (bher.a(localbher) != null)) {
                            bher.a(localbher).onErrorInfo(paramMessage);
                          }
                        } while (!hasMessages(4));
                        removeMessages(4);
                        return;
                        paramMessage = (String)paramMessage.obj;
                        if ((!TextUtils.isEmpty(paramMessage)) && (bher.a(localbher) != null)) {
                          bher.a(localbher).onErrorInfo(paramMessage);
                        }
                        if (hasMessages(104)) {
                          removeMessages(104);
                        }
                        if ((!TextUtils.isEmpty(paramMessage)) && (bher.a(localbher) != null)) {
                          bher.a(localbher).onErrorInfo(paramMessage);
                        }
                      } while (!hasMessages(104));
                      removeMessages(104);
                      return;
                      if (bher.a(localbher) != null) {
                        bher.a(localbher).onRecordStart();
                      }
                    } while (hasMessages(4));
                    sendEmptyMessage(4);
                    return;
                    if (bher.a(localbher) != null) {
                      bher.a(localbher).onRecordPause();
                    }
                  } while (!hasMessages(4));
                  removeMessages(4);
                  return;
                  if (bher.a(localbher) != null) {
                    bher.a(localbher).onRecordResume();
                  }
                } while (bher.a(localbher).hasMessages(4));
                bher.a(localbher).sendEmptyMessage(4);
                return;
                if (bher.a(localbher) != null) {
                  bher.a(localbher).onRecordStop(localbher.a(), localbher.a(), localbher.b());
                }
              } while (!hasMessages(4));
              removeMessages(4);
              return;
            } while (bher.a(localbher) == null);
            byte[] arrayOfByte = (byte[])paramMessage.obj;
            if (paramMessage.arg1 == 1) {}
            for (;;)
            {
              bher.a(localbher).onRecordFrame(arrayOfByte, bool);
              return;
              bool = false;
            }
            if (hasMessages(4)) {
              removeMessages(4);
            }
            int i = localbher.c();
            int j = localbher.b();
            if (bher.a(localbher) != null) {
              bher.a(localbher).onRecordUpdate(j, i);
            }
            if (i == bher.a(localbher))
            {
              bher.a(localbher).c();
              return;
            }
            sendEmptyMessageDelayed(4, localbher.a());
            return;
            if (hasMessages(104)) {
              removeMessages(104);
            }
            i = (int)(System.currentTimeMillis() - bher.a(localbher));
            this.jdField_a_of_type_Int += 1;
            if (this.jdField_a_of_type_Int > 5) {
              this.jdField_a_of_type_Int = 1;
            }
            if (bher.a(localbher) != null) {
              bher.a(localbher).onPlayUpdate(this.jdField_a_of_type_Int, i / 1000);
            }
            sendEmptyMessageDelayed(104, localbher.a());
            return;
            if (bher.a(localbher) != null) {
              bher.a(localbher).onPlayStart();
            }
            bher.a(localbher, System.currentTimeMillis());
            sendEmptyMessageDelayed(104, localbher.a());
            return;
            if (bher.a(localbher) != null) {
              bher.a(localbher).onPlayPause();
            }
          } while (!hasMessages(104));
          removeMessages(104);
          return;
          if (bher.a(localbher) != null) {
            bher.a(localbher).onPlayResume();
          }
        } while (hasMessages(104));
        sendEmptyMessage(104);
        return;
        if (bher.a(localbher) != null) {
          bher.a(localbher).onPlayStop();
        }
      } while (!hasMessages(104));
      removeMessages(104);
      return;
      if (bher.a(localbher) != null) {
        bher.a(localbher).onPlayFinish();
      }
    } while (!hasMessages(104));
    removeMessages(104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bheu
 * JD-Core Version:    0.7.0.1
 */