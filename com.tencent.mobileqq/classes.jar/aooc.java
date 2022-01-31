import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aooc
  extends aokh<aoob>
{
  public int a()
  {
    return 598;
  }
  
  @NonNull
  public aoob a(int paramInt)
  {
    return new aoob();
  }
  
  @Nullable
  public aoob a(aoko[] paramArrayOfaoko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaRedTouchSwitchProcessor", 2, "[onParsed] config");
    }
    return aoob.a(paramArrayOfaoko);
  }
  
  public Class<aoob> a()
  {
    return aoob.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("LebaRedTouchSwitchProcessor", 1, "[onReqFailed] failCode=" + paramInt);
  }
  
  public void a(aoob paramaoob)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaRedTouchSwitchProcessor", 2, "[onUpdate]");
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aooc
 * JD-Core Version:    0.7.0.1
 */