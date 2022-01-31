import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aohv
  extends aohw
{
  private int a;
  
  public aohv(int paramInt)
  {
    this.a = paramInt;
  }
  
  public Object a(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      paramObject = (ArrayList)paramObject;
      if (!(paramObject instanceof ArrayList))
      {
        QLog.e("ArkMsgReplyConfigMgr", 1, "getElement instance wrong");
        return null;
      }
    } while ((this.a < 0) || (this.a >= paramObject.size()));
    return paramObject.get(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aohv
 * JD-Core Version:    0.7.0.1
 */