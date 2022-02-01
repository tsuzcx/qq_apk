import com.tencent.TMG.utils.QLog;

public class aqcu
  implements anil
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
        aqcy localaqcy = aqcz.a();
        if ((localaqcy == null) || (!localaqcy.a())) {
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
        aqcb.c(paramBoolean);
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
 * Qualified Name:     aqcu
 * JD-Core Version:    0.7.0.1
 */