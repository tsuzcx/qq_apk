import android.os.Handler;
import android.os.Message;
import com.etrump.mixlayout.EMEmoticon;
import com.etrump.mixlayout.ETFont;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import java.lang.ref.WeakReference;

public class avkw
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    avkv localavkv = (avkv)paramMessage.obj;
    if (localavkv == null) {}
    label277:
    label299:
    label322:
    label344:
    label377:
    label380:
    label381:
    for (;;)
    {
      return;
      HiBoomTextView localHiBoomTextView = (HiBoomTextView)avkv.a(localavkv).get();
      if ((localHiBoomTextView != null) && (HiBoomTextView.a(localHiBoomTextView) != null)) {
        switch (paramMessage.what)
        {
        case 258: 
        default: 
          return;
        case 257: 
          if ((localHiBoomTextView.getVisibility() == 0) && (HiBoomTextView.jdField_a_of_type_AndroidOsHandler != null))
          {
            HiBoomTextView.jdField_a_of_type_AndroidOsHandler.obtainMessage(258, avkv.a(localHiBoomTextView)).sendToTarget();
            return;
          }
          break;
        case 259: 
          if ((localHiBoomTextView != null) && (HiBoomTextView.a(localHiBoomTextView) != null) && (localHiBoomTextView.getVisibility() == 0) && (localavkv != null) && (HiBoomTextView.a(localHiBoomTextView) == avkv.a(localavkv)) && (localHiBoomTextView.jdField_a_of_type_Avku.a() == avkv.a(localavkv)) && (HiBoomTextView.a(localHiBoomTextView).currentFrameIndex() == avkv.b(localavkv)) && (HiBoomTextView.a(localHiBoomTextView) != null) && (HiBoomTextView.a(localHiBoomTextView).equals(avkv.a(localavkv))))
          {
            localHiBoomTextView.invalidate();
            boolean bool;
            int i;
            if ((HiBoomTextView.b(localHiBoomTextView)) && (!HiBoomTextView.c(localHiBoomTextView)) && (HiBoomTextView.c()))
            {
              bool = true;
              if (!bool) {
                break label380;
              }
              paramMessage = HiBoomTextView.a(localHiBoomTextView);
              if (!paramMessage.nextFrame()) {
                break label344;
              }
              i = paramMessage.getFrameDelay();
              long l = System.currentTimeMillis() - avkv.b(localavkv);
              if (l <= 0L) {
                break label377;
              }
              i = (int)(i - l);
              if (i > 1) {
                break label322;
              }
              sendMessage(obtainMessage(257, avkv.a(localHiBoomTextView)));
              bool = true;
            }
            for (;;)
            {
              if (localHiBoomTextView.d()) {
                break label381;
              }
              HiBoomTextView.b(localHiBoomTextView, bool);
              return;
              bool = false;
              break;
              sendMessageDelayed(obtainMessage(257, avkv.a(localHiBoomTextView)), i);
              break label299;
              HiBoomTextView.a(localHiBoomTextView, true);
              HiBoomTextView.b(localHiBoomTextView, false);
              if (localHiBoomTextView.d()) {
                localHiBoomTextView.a(true);
              }
              bool = false;
              continue;
              break label277;
            }
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avkw
 * JD-Core Version:    0.7.0.1
 */