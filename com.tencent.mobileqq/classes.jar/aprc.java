import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

public class aprc
  extends apqm
{
  Handler jdField_a_of_type_AndroidOsHandler;
  apqi jdField_a_of_type_Apqi;
  boolean jdField_a_of_type_Boolean = false;
  
  public aprc(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public int a()
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = new int[2];
      localObject[0] = 2;
      localObject[1] = 1;
      int i = bked.b(0, "ANY", "UTF-8");
      int j = bked.b((int[])localObject, localObject.length);
      localObject = bked.a();
      if (QLog.isColorLevel()) {
        QLog.d("QRSession.QRRecog", 2, String.format("initQbar time cost:%sms, initResult=%s readerResult=%s version=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Integer.valueOf(j), localObject }));
      }
      this.jdField_a_of_type_Boolean = true;
      return 0;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QRSession.QRRecog", 2, "initQbar fail!", localException);
      }
    }
    return -1;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        bked.b();
        this.jdField_a_of_type_Boolean = false;
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QRSession.QRRecog", 2, "unInitQbar fail!", localException);
    }
  }
  
  public void a(apqn paramapqn)
  {
    this.jdField_a_of_type_Apqi = ((apqi)paramapqn);
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramBoolean = false;
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    long l = System.currentTimeMillis();
    if (bked.b(paramArrayOfByte, paramInt1, paramInt2, 0) == 1)
    {
      bked.b(localStringBuilder1, localStringBuilder2);
      paramBoolean = true;
    }
    if (this.jdField_a_of_type_Apqi != null)
    {
      if (!paramBoolean) {
        break label131;
      }
      this.jdField_a_of_type_Apqi.a(localStringBuilder1.toString(), localStringBuilder2.toString(), false);
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        if (!paramBoolean) {
          break;
        }
        QLog.d("QRSession.QRRecog", 2, String.format("------> recognize QR suc. type=%s data=%s qrRecog minicode_timecost=%d", new Object[] { localStringBuilder1, localStringBuilder2, Long.valueOf(System.currentTimeMillis() - l) }));
      }
      return paramBoolean;
      label131:
      this.jdField_a_of_type_Apqi.a(false, 0.0F);
    }
    QLog.d("QRSession.QRRecog", 2, String.format("------> recognize QR failed. hasQR=%s qrAreaRatio=%s qrRecog minicode_timecost=%d", new Object[] { Boolean.valueOf(false), Float.valueOf(0.0F), Long.valueOf(System.currentTimeMillis() - l) }));
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aprc
 * JD-Core Version:    0.7.0.1
 */