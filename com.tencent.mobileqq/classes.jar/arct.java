import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arct
  extends aqwt<arcs>
{
  public static boolean a()
  {
    arcs localarcs = (arcs)aqxe.a().a(675);
    if (localarcs != null) {}
    for (boolean bool = localarcs.a();; bool = true)
    {
      QLog.d("OpenSdkIFrameProcessor", 1, new Object[] { "isEnableIFrame = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  @NonNull
  public arcs a(int paramInt)
  {
    return new arcs();
  }
  
  @Nullable
  public arcs a(aqxa[] paramArrayOfaqxa)
  {
    int i = 0;
    if (paramArrayOfaqxa == null) {}
    for (;;)
    {
      QLog.d("OpenSdkIFrameProcessor", 1, new Object[] { "onParsed confFiles.length=", Integer.valueOf(i) });
      if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0)) {
        break;
      }
      new arcs();
      return arcs.a(paramArrayOfaqxa);
      i = paramArrayOfaqxa.length;
    }
    return null;
  }
  
  public void a(arcs paramarcs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkIFrameProcessor", 2, "onUpdate " + paramarcs.toString());
    }
  }
  
  public Class<arcs> clazz()
  {
    return arcs.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 675;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arct
 * JD-Core Version:    0.7.0.1
 */