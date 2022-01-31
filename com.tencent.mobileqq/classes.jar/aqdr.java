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

public final class aqdr
  extends Handler
{
  public aqdr(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message arg1)
  {
    aqdt localaqdt;
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
          localaqdt = (aqdt)???.obj;
        } while (localaqdt == null);
        i = aqdt.a(localaqdt).getWidth();
        int j = aqdt.a(localaqdt).getHeight();
        if ((HiBoomTextView.a() != null) && ((HiBoomTextView.a().getWidth() < i) || (HiBoomTextView.a().getHeight() < j)))
        {
          HiBoomTextView.a().recycle();
          HiBoomTextView.a(null);
        }
        if (HiBoomTextView.a() != null) {
          break;
        }
        HiBoomTextView.a(Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888));
        localETEngine = aqcx.a().b;
        String str = aqdt.a(localaqdt) + aqdt.a(localaqdt).getId() + aqdt.a(localaqdt) + aqdt.a(localaqdt).getSize();
        localObject1 = (EMEmoticon)HiBoomTextView.a().get(str);
        ??? = (Message)localObject1;
        if (localObject1 == null)
        {
          localObject1 = EMEmoticon.createEmoticon(localETEngine, aqdt.a(localaqdt), aqdt.a(localaqdt), aqdt.a(localaqdt));
          ??? = (Message)localObject1;
          if (localObject1 != null)
          {
            HiBoomTextView.a().put(str, localObject1);
            ??? = (Message)localObject1;
          }
        }
      } while (??? == null);
      ???.gotoFrame(aqdt.b(localaqdt));
      ???.drawFrame(HiBoomTextView.a());
      localObject1 = aqdt.a(localaqdt);
      if (aqdt.a(localaqdt).get() == null) {
        break;
      }
    }
    for (;;)
    {
      synchronized (((HiBoomTextView)aqdt.a(localaqdt).get()).jdField_a_of_type_Aqds)
      {
        if ((((Bitmap)localObject1).isRecycled()) || (HiBoomTextView.a((HiBoomTextView)aqdt.a(localaqdt).get()) != aqdt.a(localaqdt))) {
          break label417;
        }
        ((Bitmap)localObject1).eraseColor(0);
        localETEngine.native_cloneBitmap(HiBoomTextView.a(), (Bitmap)localObject1);
        i = 1;
        if (i == 0) {
          break;
        }
        new Message().what = 259;
        HiBoomTextView.jdField_a_of_type_Aqdu.obtainMessage(259, localaqdt).sendToTarget();
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
 * Qualified Name:     aqdr
 * JD-Core Version:    0.7.0.1
 */