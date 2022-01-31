import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.PluginRecord;

class bhjh
  extends bhic
{
  private bhjg jdField_a_of_type_Bhjg;
  
  public bhjh(bhjf parambhjf, bhjg parambhjg)
  {
    this.jdField_a_of_type_Bhjg = parambhjg;
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
    bhjg localbhjg = this.jdField_a_of_type_Bhjg;
    if ((localbhjg != null) && (localbhjg.jdField_a_of_type_Bhhw != null))
    {
      paramString = this.jdField_a_of_type_Bhjf.a(paramString);
      if ((paramString != null) && (paramString.mInstalledPath != null)) {
        localbhjg.jdField_a_of_type_Bhhx.c = paramString.mInstalledPath;
      }
      paramString = localbhjg.jdField_a_of_type_Bhhw;
      if (paramInt != 2) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.a(bool, localbhjg.jdField_a_of_type_AndroidContentContext, localbhjg.jdField_a_of_type_Bhhx);
      return;
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "onInstallFinish." + paramString);
    }
    paramString = this.jdField_a_of_type_Bhjg;
    if ((paramString != null) && (paramString.jdField_a_of_type_Bhhw != null))
    {
      PluginRecord localPluginRecord = bhjf.a(this.jdField_a_of_type_Bhjf).a(paramString.jdField_a_of_type_Bhhx.b);
      if ((localPluginRecord != null) && (localPluginRecord.mInstalledPath != null)) {
        paramString.jdField_a_of_type_Bhhx.c = localPluginRecord.mInstalledPath;
      }
      paramString.jdField_a_of_type_Bhhw.a(true, paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_Bhhx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhjh
 * JD-Core Version:    0.7.0.1
 */