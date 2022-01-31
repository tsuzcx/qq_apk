import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.api.HighwayConfBean;
import com.tencent.qphone.base.util.QLog;

public class bapj
  extends aofy<HighwayConfBean>
{
  public int a()
  {
    return 15;
  }
  
  @NonNull
  public HighwayConfBean a(int paramInt)
  {
    HighwayConfBean localHighwayConfBean = new HighwayConfBean();
    if (QLog.isColorLevel()) {
      QLog.d("HighwayConfProcessor", 2, "migrateOldOrDefaultContent " + paramInt);
    }
    return localHighwayConfBean;
  }
  
  @Nullable
  public HighwayConfBean a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      HighwayConfBean localHighwayConfBean = HighwayConfBean.parse(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("HighwayConfProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localHighwayConfBean;
    }
    return null;
  }
  
  public Class<HighwayConfBean> a()
  {
    return HighwayConfBean.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HighwayConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(HighwayConfBean paramHighwayConfBean)
  {
    HighwayConfBean.updateHighwayConf((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramHighwayConfBean);
  }
  
  public boolean a()
  {
    return false;
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
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bapj
 * JD-Core Version:    0.7.0.1
 */