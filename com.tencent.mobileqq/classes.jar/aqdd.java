import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class aqdd
  extends BroadcastReceiver
{
  aqdd(aqdc paramaqdc) {}
  
  public void onReceive(Context arg1, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        do
        {
          int i;
          int j;
          for (;;)
          {
            return;
            ??? = paramIntent.getAction();
            if (!TextUtils.isEmpty(???))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ColorNoteQIPCModule", 1, "action receive: " + ???);
              }
              if (???.equals("key_float_window_position"))
              {
                i = paramIntent.getIntExtra("key_float_window_position_x", 0);
                j = paramIntent.getIntExtra("key_float_window_position_y", 0);
                synchronized (aqdc.a())
                {
                  aqdc.a(this.a).set(i, j);
                  if (QLog.isColorLevel())
                  {
                    QLog.d("ColorNoteQIPCModule", 1, "KEY_FLOAT_WINDOW_POSITION receive: " + i + ", " + j);
                    return;
                  }
                }
              }
            }
          }
          if (!???.equals("key_delete_item_call")) {
            break;
          }
          aqdc.a(this.a, paramIntent.getBooleanExtra("extra_can_add_colornote", true));
          ??? = paramIntent.getStringArrayExtra("key_color_note_servicetype_list");
          paramIntent = paramIntent.getStringArrayExtra("key_color_note_suptype_list");
          if ((aqdc.a(this.a) != null) && (??? != null) && (paramIntent != null) && (???.length == paramIntent.length))
          {
            i = 0;
            for (;;)
            {
              if ((paramIntent != null) && (i < paramIntent.length)) {
                try
                {
                  j = Integer.valueOf(???[i]).intValue();
                  if (j != -1)
                  {
                    aqce localaqce = (aqce)aqdc.a(this.a).get();
                    if (localaqce != null) {
                      localaqce.onDeleteColorNote(j, paramIntent[i], false);
                    }
                  }
                  i += 1;
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    QLog.e("ColorNoteQIPCModule", 2, "integer cast error", localException);
                    j = -1;
                  }
                }
              }
            }
          }
        } while (!QLog.isColorLevel());
        aqda.a("ColorNoteQIPCModule", "[onReceive->ACTION_DELETE_ITEM_CALL]\n[mCanAddColorNote]: " + aqdc.a(this.a) + "\n");
        return;
      } while ((!???.equals("key_after_sync_msg")) || (aqdc.b(this.a) == null));
      ??? = (aqfx)aqdc.b(this.a).get();
    } while (??? == null);
    boolean bool = paramIntent.getBooleanExtra("extra_after_sync_msg", true);
    ???.onServiceSyncSucc(bool);
    this.a.b(bool);
    QLog.d("ColorNoteQIPCModule", 1, "invoke listener: " + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqdd
 * JD-Core Version:    0.7.0.1
 */