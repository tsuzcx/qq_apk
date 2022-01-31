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

public final class asoj
  extends Handler
{
  public asoj(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message arg1)
  {
    asol localasol;
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
          localasol = (asol)???.obj;
        } while (localasol == null);
        i = asol.a(localasol).getWidth();
        int j = asol.a(localasol).getHeight();
        if ((HiBoomTextView.a() != null) && ((HiBoomTextView.a().getWidth() < i) || (HiBoomTextView.a().getHeight() < j)))
        {
          HiBoomTextView.a().recycle();
          HiBoomTextView.a(null);
        }
        if (HiBoomTextView.a() != null) {
          break;
        }
        HiBoomTextView.a(Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888));
        localETEngine = asnp.a().b;
        String str = asol.a(localasol) + asol.a(localasol).getId() + asol.a(localasol) + asol.a(localasol).getSize();
        localObject1 = (EMEmoticon)HiBoomTextView.a().get(str);
        ??? = (Message)localObject1;
        if (localObject1 == null)
        {
          localObject1 = EMEmoticon.createEmoticon(localETEngine, asol.a(localasol), asol.a(localasol), asol.a(localasol));
          ??? = (Message)localObject1;
          if (localObject1 != null)
          {
            HiBoomTextView.a().put(str, localObject1);
            ??? = (Message)localObject1;
          }
        }
      } while (??? == null);
      ???.gotoFrame(asol.b(localasol));
      ???.drawFrame(HiBoomTextView.a());
      localObject1 = asol.a(localasol);
      if (asol.a(localasol).get() == null) {
        break;
      }
    }
    for (;;)
    {
      synchronized (((HiBoomTextView)asol.a(localasol).get()).jdField_a_of_type_Asok)
      {
        if ((((Bitmap)localObject1).isRecycled()) || (HiBoomTextView.a((HiBoomTextView)asol.a(localasol).get()) != asol.a(localasol))) {
          break label417;
        }
        ((Bitmap)localObject1).eraseColor(0);
        localETEngine.native_cloneBitmap(HiBoomTextView.a(), (Bitmap)localObject1);
        i = 1;
        if (i == 0) {
          break;
        }
        new Message().what = 259;
        HiBoomTextView.jdField_a_of_type_Asom.obtainMessage(259, localasol).sendToTarget();
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
 * Qualified Name:     asoj
 * JD-Core Version:    0.7.0.1
 */