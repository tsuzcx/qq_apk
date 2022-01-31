import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqfy
  extends aokh<aqgf>
{
  public static aqgf a()
  {
    return (aqgf)aoks.a().a(532);
  }
  
  public int a()
  {
    return 532;
  }
  
  @NonNull
  public aqgf a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LimitChatOnPlusConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aqgf();
  }
  
  @Nullable
  public aqgf a(aoko[] paramArrayOfaoko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatOnPlusConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatOnPlusConfProcessor", 2, "onParsed " + paramArrayOfaoko.length);
      }
      return aqgf.a(paramArrayOfaoko[0]);
    }
    return null;
  }
  
  public Class<aqgf> a()
  {
    return aqgf.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LimitChatOnPlusConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aqgf paramaqgf)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaqgf == null) {
        break label73;
      }
    }
    label73:
    for (paramaqgf = paramaqgf.toString();; paramaqgf = " empty")
    {
      QLog.d("LimitChatOnPlusConfProcessor", 2, paramaqgf);
      paramaqgf = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramaqgf instanceof QQAppInterface)) {
        ((aqbg)((QQAppInterface)paramaqgf).getManager(264)).b();
      }
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqfy
 * JD-Core Version:    0.7.0.1
 */