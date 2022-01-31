import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.PluginRecord;

class bhjy
  extends bhit
{
  private bhjx jdField_a_of_type_Bhjx;
  
  public bhjy(bhjw parambhjw, bhjx parambhjx)
  {
    this.jdField_a_of_type_Bhjx = parambhjx;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "onInstallBegin." + paramString);
    }
  }
  
  public void a(String paramString, float paramFloat, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "onInstallDownloadProgress." + paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "onInstallError." + paramString + "," + paramInt);
    }
    bhjx localbhjx = this.jdField_a_of_type_Bhjx;
    if ((localbhjx != null) && (localbhjx.jdField_a_of_type_Bhin != null))
    {
      paramString = this.jdField_a_of_type_Bhjw.a(paramString);
      if ((paramString != null) && (paramString.mInstalledPath != null)) {
        localbhjx.jdField_a_of_type_Bhio.c = paramString.mInstalledPath;
      }
      paramString = localbhjx.jdField_a_of_type_Bhin;
      if (paramInt != 2) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.a(bool, localbhjx.jdField_a_of_type_AndroidContentContext, localbhjx.jdField_a_of_type_Bhio);
      return;
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "onInstallFinish." + paramString);
    }
    paramString = this.jdField_a_of_type_Bhjx;
    if ((paramString != null) && (paramString.jdField_a_of_type_Bhin != null))
    {
      PluginRecord localPluginRecord = bhjw.a(this.jdField_a_of_type_Bhjw).a(paramString.jdField_a_of_type_Bhio.b);
      if ((localPluginRecord != null) && (localPluginRecord.mInstalledPath != null)) {
        paramString.jdField_a_of_type_Bhio.c = localPluginRecord.mInstalledPath;
      }
      paramString.jdField_a_of_type_Bhin.a(true, paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_Bhio);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhjy
 * JD-Core Version:    0.7.0.1
 */