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

public final class asss
  extends Handler
{
  public asss(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message arg1)
  {
    assu localassu;
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
          localassu = (assu)???.obj;
        } while (localassu == null);
        i = assu.a(localassu).getWidth();
        int j = assu.a(localassu).getHeight();
        if ((HiBoomTextView.a() != null) && ((HiBoomTextView.a().getWidth() < i) || (HiBoomTextView.a().getHeight() < j)))
        {
          HiBoomTextView.a().recycle();
          HiBoomTextView.a(null);
        }
        if (HiBoomTextView.a() != null) {
          break;
        }
        HiBoomTextView.a(Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888));
        localETEngine = asry.a().b;
        String str = assu.a(localassu) + assu.a(localassu).getId() + assu.a(localassu) + assu.a(localassu).getSize();
        localObject1 = (EMEmoticon)HiBoomTextView.a().get(str);
        ??? = (Message)localObject1;
        if (localObject1 == null)
        {
          localObject1 = EMEmoticon.createEmoticon(localETEngine, assu.a(localassu), assu.a(localassu), assu.a(localassu));
          ??? = (Message)localObject1;
          if (localObject1 != null)
          {
            HiBoomTextView.a().put(str, localObject1);
            ??? = (Message)localObject1;
          }
        }
      } while (??? == null);
      ???.gotoFrame(assu.b(localassu));
      ???.drawFrame(HiBoomTextView.a());
      localObject1 = assu.a(localassu);
      if (assu.a(localassu).get() == null) {
        break;
      }
    }
    for (;;)
    {
      synchronized (((HiBoomTextView)assu.a(localassu).get()).jdField_a_of_type_Asst)
      {
        if ((((Bitmap)localObject1).isRecycled()) || (HiBoomTextView.a((HiBoomTextView)assu.a(localassu).get()) != assu.a(localassu))) {
          break label417;
        }
        ((Bitmap)localObject1).eraseColor(0);
        localETEngine.native_cloneBitmap(HiBoomTextView.a(), (Bitmap)localObject1);
        i = 1;
        if (i == 0) {
          break;
        }
        new Message().what = 259;
        HiBoomTextView.jdField_a_of_type_Assv.obtainMessage(259, localassu).sendToTarget();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asss
 * JD-Core Version:    0.7.0.1
 */