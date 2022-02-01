import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.BusinessObserver;

public class aqok
  implements BusinessObserver
{
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramObject = (Object[])paramObject;
      if ((paramObject != null) && (paramObject.length == 1))
      {
        aqoo localaqoo = aqop.a();
        if ((localaqoo == null) || (!localaqoo.a())) {
          break label135;
        }
      }
      break;
    }
    label135:
    for (paramInt = 1;; paramInt = 0)
    {
      if ((paramInt != 0) && (!((Boolean)paramObject[0]).booleanValue())) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        aqnr.c(paramBoolean);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ColorNoteObserver", 0, "onUpdate: TYPE_REQ_GET_COLOR_NOTE_RECENT_SWITCH");
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ColorNoteObserver", 0, "onUpdate: params == null || params.length != 1");
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ColorNoteObserver", 0, "onUpdate: TYPE_REQ_SET_COLOR_NOTE_RECENT_SWITCH");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqok
 * JD-Core Version:    0.7.0.1
 */