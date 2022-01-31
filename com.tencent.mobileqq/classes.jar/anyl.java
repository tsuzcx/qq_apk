import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.text.TextUtils;
import mqq.util.WeakReference;

class anyl
  extends BroadcastReceiver
{
  anyl(anyk paramanyk) {}
  
  public void onReceive(Context arg1, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        int j;
        do
        {
          for (;;)
          {
            return;
            ??? = paramIntent.getAction();
            if (!TextUtils.isEmpty(???))
            {
              if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
                com.tencent.qphone.base.util.QLog.d("ColorNoteQIPCModule", 1, "action receive: " + ???);
              }
              if (???.equals("key_float_window_position"))
              {
                i = paramIntent.getIntExtra("key_float_window_position_x", 0);
                j = paramIntent.getIntExtra("key_float_window_position_y", 0);
                synchronized (anyk.a())
                {
                  anyk.a(this.a).set(i, j);
                  if (com.tencent.qphone.base.util.QLog.isColorLevel())
                  {
                    com.tencent.qphone.base.util.QLog.d("ColorNoteQIPCModule", 1, "KEY_FLOAT_WINDOW_POSITION receive: " + i + ", " + j);
                    return;
                  }
                }
              }
            }
          }
          if (!???.equals("key_delete_item_call")) {
            break;
          }
          anyk.a(this.a, paramIntent.getBooleanExtra("extra_can_add_colornote", true));
          ??? = paramIntent.getStringArrayExtra("key_color_note_servicetype_list");
          paramIntent = paramIntent.getStringArrayExtra("key_color_note_suptype_list");
        } while ((anyk.a(this.a) == null) || (??? == null) || (paramIntent == null) || (???.length != paramIntent.length));
        int i = 0;
        while ((paramIntent != null) && (i < paramIntent.length)) {
          try
          {
            j = Integer.valueOf(???[i]).intValue();
            if (j != -1)
            {
              anxq localanxq = (anxq)anyk.a(this.a).get();
              if (localanxq != null) {
                localanxq.onDeleteColorNote(j, paramIntent[i], false);
              }
            }
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              com.tencent.qphone.base.util.QLog.e("ColorNoteQIPCModule", 2, "integer cast error", localException);
              j = -1;
            }
          }
        }
      } while ((!???.equals("key_after_sync_msg")) || (anyk.b(this.a) == null));
      ??? = (aobe)anyk.b(this.a).get();
    } while (??? == null);
    boolean bool = paramIntent.getBooleanExtra("extra_after_sync_msg", true);
    ???.onServiceSyncSucc(bool);
    this.a.b(bool);
    com.tencent.TMG.utils.QLog.d("ColorNoteQIPCModule", 1, "invoke listener: " + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anyl
 * JD-Core Version:    0.7.0.1
 */