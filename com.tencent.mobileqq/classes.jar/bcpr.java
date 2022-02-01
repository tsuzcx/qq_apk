import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

public class bcpr
  implements BusinessObserver
{
  public final String b = "ModifyPwdTopBarObserver";
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    if (a(paramObject))
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, new bcps(this, ((Long)paramObject[0]).longValue(), ((Boolean)paramObject[1]).booleanValue(), (String)paramObject[2], (String)paramObject[3], ((Integer)paramObject[4]).intValue()));
      return;
    }
    QLog.e("ModifyPwdTopBarObserver", 2, "onUpdateDisplayInfo error");
  }
  
  private boolean a(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof Object[])) && (((Object[])paramObject).length == 5);
  }
  
  public void a(boolean paramBoolean, bcps parambcps) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcpr
 * JD-Core Version:    0.7.0.1
 */