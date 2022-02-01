import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import mqq.util.WeakReference;

class apkp
  extends Handler
{
  private WeakReference<apko> a;
  
  apkp(apko paramapko)
  {
    this.a = new WeakReference(paramapko);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Object localObject1 = (apko)this.a.get();
    if (localObject1 == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject1 = apko.a((apko)localObject1);
            switch (paramMessage.what)
            {
            case 7: 
            case 8: 
            default: 
              return;
            }
          } while (localObject1 == null);
          localObject2 = (Bundle)paramMessage.obj;
          if (paramMessage.what == 3) {}
          for (bool1 = true;; bool1 = false)
          {
            ((apkq)localObject1).onAddColorNote((Bundle)localObject2, bool1);
            return;
          }
        } while (localObject1 == null);
        try
        {
          localObject2 = (Pair)paramMessage.obj;
          int i = ((Integer)((Pair)localObject2).first).intValue();
          localObject2 = (String)((Pair)localObject2).second;
          if (paramMessage.what != 5)
          {
            ((apkq)localObject1).onDeleteColorNote(i, (String)localObject2, bool1);
            return;
          }
        }
        catch (ClassCastException paramMessage)
        {
          for (;;)
          {
            QLog.e("ColorNoteCurd", 2, paramMessage, new Object[0]);
            return;
            bool1 = false;
          }
        }
        catch (Exception paramMessage)
        {
          QLog.e("ColorNoteCurd", 2, paramMessage, new Object[0]);
          return;
        }
      } while ((localObject1 == null) || (paramMessage.obj == null));
      paramMessage = (Bundle)paramMessage.obj;
      ((apkq)localObject1).onUpdateColorNoteState(paramMessage.getInt("key_service_type"), paramMessage.getString("key_sub_type"), paramMessage);
      return;
    } while ((localObject1 == null) || (paramMessage.obj == null));
    Object localObject2 = (ColorNote)paramMessage.obj;
    if (paramMessage.what == 10) {}
    for (bool1 = bool2;; bool1 = false)
    {
      ((apkq)localObject1).onUpdateColorNote((ColorNote)localObject2, bool1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apkp
 * JD-Core Version:    0.7.0.1
 */