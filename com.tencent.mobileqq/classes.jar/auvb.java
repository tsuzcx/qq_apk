import android.graphics.Bitmap;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyIconDecoder.1;
import java.util.ArrayList;
import java.util.List;

public class auvb
  implements Handler.Callback, aybk, bdcg
{
  NearbyAppInterface a;
  public List<bdch> a;
  List<String> b;
  List<String> c;
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    auwz.a("NearbyIconDecoder", "notifyGetIcon", new Object[] { paramString, paramBitmap });
    this.a.runOnUiThread(new NearbyIconDecoder.1(this, paramString, paramBitmap));
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, int paramInt)
  {
    auwz.a("NearbyIconDecoder", "onDecodeBitmap", new Object[] { paramString1, paramString2, paramBitmap, Integer.valueOf(paramInt) });
    if (paramString1 == null) {}
    while (paramBitmap == null) {
      return;
    }
    a(paramString1, paramBitmap);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    auwz.a("NearbyIconDecoder", "MSG_GET_ICON_URL", new Object[] { Integer.valueOf(this.b.size()), Integer.valueOf(this.c.size()) });
    paramMessage = new ArrayList(this.b.size());
    synchronized (this.b)
    {
      paramMessage.addAll(this.b);
      this.b.clear();
    }
    synchronized (this.c)
    {
      this.c.addAll(paramMessage);
      this.a.a().a(paramMessage);
      return false;
      paramMessage = finally;
      throw paramMessage;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auvb
 * JD-Core Version:    0.7.0.1
 */