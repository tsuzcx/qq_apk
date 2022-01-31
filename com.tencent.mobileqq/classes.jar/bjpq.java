import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.PluginRecord;

class bjpq
  extends bjol
{
  private bjpp jdField_a_of_type_Bjpp;
  
  public bjpq(bjpo parambjpo, bjpp parambjpp)
  {
    this.jdField_a_of_type_Bjpp = parambjpp;
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
    bjpp localbjpp = this.jdField_a_of_type_Bjpp;
    if ((localbjpp != null) && (localbjpp.jdField_a_of_type_Bjof != null))
    {
      paramString = this.jdField_a_of_type_Bjpo.a(paramString);
      if ((paramString != null) && (paramString.mInstalledPath != null)) {
        localbjpp.jdField_a_of_type_Bjog.c = paramString.mInstalledPath;
      }
      paramString = localbjpp.jdField_a_of_type_Bjof;
      if (paramInt != 2) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.a(bool, localbjpp.jdField_a_of_type_AndroidContentContext, localbjpp.jdField_a_of_type_Bjog);
      return;
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "onInstallFinish." + paramString);
    }
    paramString = this.jdField_a_of_type_Bjpp;
    if ((paramString != null) && (paramString.jdField_a_of_type_Bjof != null))
    {
      PluginRecord localPluginRecord = bjpo.a(this.jdField_a_of_type_Bjpo).a(paramString.jdField_a_of_type_Bjog.b);
      if ((localPluginRecord != null) && (localPluginRecord.mInstalledPath != null)) {
        paramString.jdField_a_of_type_Bjog.c = localPluginRecord.mInstalledPath;
      }
      paramString.jdField_a_of_type_Bjof.a(true, paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_Bjog);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjpq
 * JD-Core Version:    0.7.0.1
 */