import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class asgb
  extends aoou
{
  asgb(asfu paramasfu, String paramString, boolean paramBoolean, asmh paramasmh)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoAsync onLocationFinish " + paramInt);
    }
    asfu localasfu;
    if (this.jdField_a_of_type_Asmh != null)
    {
      localasfu = this.jdField_a_of_type_Asfu;
      if (paramInt != 0) {
        break label62;
      }
    }
    label62:
    for (boolean bool = true;; bool = false)
    {
      asfu.a(localasfu, bool, paramSosoLbsInfo, this.jdField_a_of_type_Asmh);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgb
 * JD-Core Version:    0.7.0.1
 */