import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.PluginRecord;

class bjlj
  extends bjke
{
  private bjli jdField_a_of_type_Bjli;
  
  public bjlj(bjlh parambjlh, bjli parambjli)
  {
    this.jdField_a_of_type_Bjli = parambjli;
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
    bjli localbjli = this.jdField_a_of_type_Bjli;
    if ((localbjli != null) && (localbjli.jdField_a_of_type_Bjjy != null))
    {
      paramString = this.jdField_a_of_type_Bjlh.a(paramString);
      if ((paramString != null) && (paramString.mInstalledPath != null)) {
        localbjli.jdField_a_of_type_Bjjz.c = paramString.mInstalledPath;
      }
      paramString = localbjli.jdField_a_of_type_Bjjy;
      if (paramInt != 2) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.a(bool, localbjli.jdField_a_of_type_AndroidContentContext, localbjli.jdField_a_of_type_Bjjz);
      return;
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "onInstallFinish." + paramString);
    }
    paramString = this.jdField_a_of_type_Bjli;
    if ((paramString != null) && (paramString.jdField_a_of_type_Bjjy != null))
    {
      PluginRecord localPluginRecord = bjlh.a(this.jdField_a_of_type_Bjlh).a(paramString.jdField_a_of_type_Bjjz.b);
      if ((localPluginRecord != null) && (localPluginRecord.mInstalledPath != null)) {
        paramString.jdField_a_of_type_Bjjz.c = localPluginRecord.mInstalledPath;
      }
      paramString.jdField_a_of_type_Bjjy.a(true, paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_Bjjz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjlj
 * JD-Core Version:    0.7.0.1
 */