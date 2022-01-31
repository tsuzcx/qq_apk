import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aojt
  extends aofy<aojs>
{
  public int a()
  {
    return 598;
  }
  
  @NonNull
  public aojs a(int paramInt)
  {
    return new aojs();
  }
  
  @Nullable
  public aojs a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaRedTouchSwitchProcessor", 2, "[onParsed] config");
    }
    return aojs.a(paramArrayOfaogf);
  }
  
  public Class<aojs> a()
  {
    return aojs.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("LebaRedTouchSwitchProcessor", 1, "[onReqFailed] failCode=" + paramInt);
  }
  
  public void a(aojs paramaojs)
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
 * Qualified Name:     aojt
 * JD-Core Version:    0.7.0.1
 */