import com.tencent.qphone.base.util.QLog;

class aqhj
  extends aqbl
{
  aqhj(aqhi paramaqhi) {}
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        Object[] arrayOfObject;
        do
        {
          String str;
          do
          {
            return;
            arrayOfObject = (Object[])paramObject;
            str = (String)arrayOfObject[0];
            if (QLog.isColorLevel()) {
              QLog.d("ExtendFriendSendMsgHelper", 2, String.format("onGetSigBy0xb4cCode success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
            }
            if (!paramBoolean) {
              break;
            }
            paramObject = (String)arrayOfObject[1];
          } while (aqhi.a(this.a) == null);
          aqhi.a(this.a).a(str, paramObject);
          return;
        } while (paramObject == null);
        int i = ((Integer)arrayOfObject[1]).intValue();
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendSendMsgHelper", 2, String.format("onGetSigBy0xb4cCode resetCode=%s", new Object[] { Integer.valueOf(i) }));
        }
        if (i != 20) {
          break;
        }
      } while (aqhi.a(this.a) == null);
      aqhi.a(this.a).a();
      return;
    } while (aqhi.a(this.a) == null);
    aqhi.a(this.a).a(2131720551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqhj
 * JD-Core Version:    0.7.0.1
 */