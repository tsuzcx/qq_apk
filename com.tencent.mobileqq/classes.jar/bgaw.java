import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.PluginRecord;

class bgaw
  extends bfzr
{
  private bgav jdField_a_of_type_Bgav;
  
  public bgaw(bgau parambgau, bgav parambgav)
  {
    this.jdField_a_of_type_Bgav = parambgav;
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
    bgav localbgav = this.jdField_a_of_type_Bgav;
    if ((localbgav != null) && (localbgav.jdField_a_of_type_Bfzl != null))
    {
      paramString = this.jdField_a_of_type_Bgau.a(paramString);
      if ((paramString != null) && (paramString.mInstalledPath != null)) {
        localbgav.jdField_a_of_type_Bfzm.c = paramString.mInstalledPath;
      }
      paramString = localbgav.jdField_a_of_type_Bfzl;
      if (paramInt != 2) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.a(bool, localbgav.jdField_a_of_type_AndroidContentContext, localbgav.jdField_a_of_type_Bfzm);
      return;
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "onInstallFinish." + paramString);
    }
    paramString = this.jdField_a_of_type_Bgav;
    if ((paramString != null) && (paramString.jdField_a_of_type_Bfzl != null))
    {
      PluginRecord localPluginRecord = bgau.a(this.jdField_a_of_type_Bgau).a(paramString.jdField_a_of_type_Bfzm.b);
      if ((localPluginRecord != null) && (localPluginRecord.mInstalledPath != null)) {
        paramString.jdField_a_of_type_Bfzm.c = localPluginRecord.mInstalledPath;
      }
      paramString.jdField_a_of_type_Bfzl.a(true, paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_Bfzm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgaw
 * JD-Core Version:    0.7.0.1
 */