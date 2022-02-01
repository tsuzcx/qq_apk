import com.tencent.qphone.base.util.QLog;

class asmm
  extends asgf
{
  asmm(asml paramasml) {}
  
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
          } while (asml.a(this.a) == null);
          asml.a(this.a).a(str, paramObject);
          return;
        } while (paramObject == null);
        int i = ((Integer)arrayOfObject[1]).intValue();
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendSendMsgHelper", 2, String.format("onGetSigBy0xb4cCode resetCode=%s", new Object[] { Integer.valueOf(i) }));
        }
        if (i != 20) {
          break;
        }
      } while (asml.a(this.a) == null);
      asml.a(this.a).a();
      return;
    } while (asml.a(this.a) == null);
    asml.a(this.a).a(2131718381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmm
 * JD-Core Version:    0.7.0.1
 */