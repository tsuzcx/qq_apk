import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.PluginRecord;

class bmdz
  extends bmcu
{
  private bmdy jdField_a_of_type_Bmdy;
  
  public bmdz(bmdx parambmdx, bmdy parambmdy)
  {
    this.jdField_a_of_type_Bmdy = parambmdy;
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
    bmdy localbmdy = this.jdField_a_of_type_Bmdy;
    if ((localbmdy != null) && (localbmdy.jdField_a_of_type_Bmco != null))
    {
      paramString = this.jdField_a_of_type_Bmdx.a(paramString);
      if ((paramString != null) && (paramString.mInstalledPath != null)) {
        localbmdy.jdField_a_of_type_Bmcp.c = paramString.mInstalledPath;
      }
      paramString = localbmdy.jdField_a_of_type_Bmco;
      if (paramInt != 2) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.a(bool, localbmdy.jdField_a_of_type_AndroidContentContext, localbmdy.jdField_a_of_type_Bmcp);
      return;
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "onInstallFinish." + paramString);
    }
    paramString = this.jdField_a_of_type_Bmdy;
    if ((paramString != null) && (paramString.jdField_a_of_type_Bmco != null))
    {
      PluginRecord localPluginRecord = bmdx.a(this.jdField_a_of_type_Bmdx).a(paramString.jdField_a_of_type_Bmcp.b);
      if ((localPluginRecord != null) && (localPluginRecord.mInstalledPath != null)) {
        paramString.jdField_a_of_type_Bmcp.c = localPluginRecord.mInstalledPath;
      }
      paramString.jdField_a_of_type_Bmco.a(true, paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_Bmcp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdz
 * JD-Core Version:    0.7.0.1
 */