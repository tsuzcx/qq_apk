import com.tencent.qphone.base.util.QLog;

class assz
  extends aslz
{
  assz(assy paramassy) {}
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        int i;
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
            } while (assy.a(this.a) == null);
            assy.a(this.a).enterAio(str, paramObject);
            return;
          } while (paramObject == null);
          i = ((Integer)arrayOfObject[1]).intValue();
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendSendMsgHelper", 2, String.format("onGetSigBy0xb4cCode resetCode=%s", new Object[] { Integer.valueOf(i) }));
          }
          if (i != 20) {
            break;
          }
        } while (assy.a(this.a) == null);
        assy.a(this.a).showMatchCountDialog();
        return;
        if (i != 21) {
          break;
        }
      } while (assy.a(this.a) == null);
      assy.a(this.a).showToast(2131719155);
      return;
    } while (assy.a(this.a) == null);
    assy.a(this.a).showToast(2131719155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assz
 * JD-Core Version:    0.7.0.1
 */