import com.tencent.qphone.base.util.QLog;

class arot
  extends arht
{
  arot(aros paramaros) {}
  
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
            } while (aros.a(this.a) == null);
            aros.a(this.a).enterAio(str, paramObject);
            return;
          } while (paramObject == null);
          i = ((Integer)arrayOfObject[1]).intValue();
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendSendMsgHelper", 2, String.format("onGetSigBy0xb4cCode resetCode=%s", new Object[] { Integer.valueOf(i) }));
          }
          if (i != 20) {
            break;
          }
        } while (aros.a(this.a) == null);
        aros.a(this.a).showMatchCountDialog();
        return;
        if (i != 21) {
          break;
        }
      } while (aros.a(this.a) == null);
      aros.a(this.a).showToast(2131718765);
      return;
    } while (aros.a(this.a) == null);
    aros.a(this.a).showToast(2131718765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arot
 * JD-Core Version:    0.7.0.1
 */