import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.PendantInfo.AnimationLruCache;
import java.util.Collection;
import java.util.Iterator;

public class bhnv
  extends bkyc
{
  public bhnv(PendantInfo paramPendantInfo, Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper, paramCallback);
  }
  
  public void handleMessage(Message paramMessage)
  {
    long l;
    Drawable localDrawable;
    if (paramMessage.what == 16)
    {
      l = paramMessage.getData().getLong("targetId");
      if (PendantInfo.g == l)
      {
        paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.values().iterator();
        while (paramMessage.hasNext())
        {
          localDrawable = (Drawable)paramMessage.next();
          if (localDrawable != null) {
            localDrawable.invalidateSelf();
          }
        }
      }
      paramMessage = (Drawable)this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(l));
      if (paramMessage != null) {
        paramMessage.invalidateSelf();
      }
    }
    label324:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (paramMessage.what == 17)
          {
            PendantInfo.a(this.a, paramMessage);
            return;
          }
          if (paramMessage.what == 18)
          {
            if ((!this.a.jdField_a_of_type_Boolean) && (this.a.o == 2) && (this.a.r > 0))
            {
              this.a.b(paramMessage.getData().getLong("targetId"));
              return;
            }
            if ((!this.a.jdField_a_of_type_Boolean) && (this.a.o == 1)) {
              this.a.d();
            }
          }
          else
          {
            if (paramMessage.what != 19) {
              break label324;
            }
            l = paramMessage.getData().getLong("targetId");
            if (PendantInfo.g != l) {
              break;
            }
            paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.values().iterator();
            while (paramMessage.hasNext())
            {
              localDrawable = (Drawable)paramMessage.next();
              if (localDrawable != null) {
                this.a.a(localDrawable, true, 0L);
              }
            }
          }
        }
        paramMessage = (Drawable)this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(l));
      } while (paramMessage == null);
      this.a.a(paramMessage, false, 0L);
      return;
    } while (paramMessage.what != 20);
    PendantInfo.b(this.a, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhnv
 * JD-Core Version:    0.7.0.1
 */