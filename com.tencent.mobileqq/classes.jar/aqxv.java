import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.etrump.mixlayout.EMEmoticon;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import java.lang.ref.WeakReference;

public final class aqxv
  extends Handler
{
  public aqxv(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message arg1)
  {
    aqxx localaqxx;
    int i;
    ETEngine localETEngine;
    Object localObject1;
    switch (???.what)
    {
    case 259: 
    default: 
    case 258: 
      do
      {
        do
        {
          return;
          localaqxx = (aqxx)???.obj;
        } while (localaqxx == null);
        i = aqxx.a(localaqxx).getWidth();
        int j = aqxx.a(localaqxx).getHeight();
        if ((HiBoomTextView.a() != null) && ((HiBoomTextView.a().getWidth() < i) || (HiBoomTextView.a().getHeight() < j)))
        {
          HiBoomTextView.a().recycle();
          HiBoomTextView.a(null);
        }
        if (HiBoomTextView.a() != null) {
          break;
        }
        HiBoomTextView.a(Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888));
        localETEngine = aqxb.a().b;
        String str = aqxx.a(localaqxx) + aqxx.a(localaqxx).getId() + aqxx.a(localaqxx) + aqxx.a(localaqxx).getSize();
        localObject1 = (EMEmoticon)HiBoomTextView.a().get(str);
        ??? = (Message)localObject1;
        if (localObject1 == null)
        {
          localObject1 = EMEmoticon.createEmoticon(localETEngine, aqxx.a(localaqxx), aqxx.a(localaqxx), aqxx.a(localaqxx));
          ??? = (Message)localObject1;
          if (localObject1 != null)
          {
            HiBoomTextView.a().put(str, localObject1);
            ??? = (Message)localObject1;
          }
        }
      } while (??? == null);
      ???.gotoFrame(aqxx.b(localaqxx));
      ???.drawFrame(HiBoomTextView.a());
      localObject1 = aqxx.a(localaqxx);
      if (aqxx.a(localaqxx).get() == null) {
        break;
      }
    }
    for (;;)
    {
      synchronized (((HiBoomTextView)aqxx.a(localaqxx).get()).jdField_a_of_type_Aqxw)
      {
        if ((((Bitmap)localObject1).isRecycled()) || (HiBoomTextView.a((HiBoomTextView)aqxx.a(localaqxx).get()) != aqxx.a(localaqxx))) {
          break label417;
        }
        ((Bitmap)localObject1).eraseColor(0);
        localETEngine.native_cloneBitmap(HiBoomTextView.a(), (Bitmap)localObject1);
        i = 1;
        if (i == 0) {
          break;
        }
        new Message().what = 259;
        HiBoomTextView.jdField_a_of_type_Aqxy.obtainMessage(259, localaqxx).sendToTarget();
        return;
        HiBoomTextView.a().eraseColor(0);
      }
      if (HiBoomTextView.a() == null) {
        break;
      }
      HiBoomTextView.a().recycle();
      HiBoomTextView.a(null);
      return;
      label417:
      i = 0;
      continue;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqxv
 * JD-Core Version:    0.7.0.1
 */