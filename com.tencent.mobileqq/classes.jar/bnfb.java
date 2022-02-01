import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.PluginRecord;

class bnfb
  extends bndw
{
  private bnfa jdField_a_of_type_Bnfa;
  
  public bnfb(bnez parambnez, bnfa parambnfa)
  {
    this.jdField_a_of_type_Bnfa = parambnfa;
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
    bnfa localbnfa = this.jdField_a_of_type_Bnfa;
    if ((localbnfa != null) && (localbnfa.jdField_a_of_type_Bndq != null))
    {
      paramString = this.jdField_a_of_type_Bnez.a(paramString);
      if ((paramString != null) && (paramString.mInstalledPath != null)) {
        localbnfa.jdField_a_of_type_Bndr.c = paramString.mInstalledPath;
      }
      paramString = localbnfa.jdField_a_of_type_Bndq;
      if (paramInt != 2) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.a(bool, localbnfa.jdField_a_of_type_AndroidContentContext, localbnfa.jdField_a_of_type_Bndr);
      return;
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginManger", 2, "onInstallFinish." + paramString);
    }
    paramString = this.jdField_a_of_type_Bnfa;
    if ((paramString != null) && (paramString.jdField_a_of_type_Bndq != null))
    {
      PluginRecord localPluginRecord = bnez.a(this.jdField_a_of_type_Bnez).a(paramString.jdField_a_of_type_Bndr.b);
      if ((localPluginRecord != null) && (localPluginRecord.mInstalledPath != null)) {
        paramString.jdField_a_of_type_Bndr.c = localPluginRecord.mInstalledPath;
      }
      paramString.jdField_a_of_type_Bndq.a(true, paramString.jdField_a_of_type_AndroidContentContext, paramString.jdField_a_of_type_Bndr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfb
 * JD-Core Version:    0.7.0.1
 */