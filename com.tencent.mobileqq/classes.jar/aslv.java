import com.tencent.mobileqq.app.soso.LbsManagerService.OnLocationChangeListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class aslv
  extends LbsManagerService.OnLocationChangeListener
{
  aslv(aslo paramaslo, String paramString, boolean paramBoolean, assu paramassu)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoAsync onLocationFinish " + paramInt);
    }
    aslo localaslo;
    if (this.jdField_a_of_type_Assu != null)
    {
      localaslo = this.jdField_a_of_type_Aslo;
      if (paramInt != 0) {
        break label62;
      }
    }
    label62:
    for (boolean bool = true;; bool = false)
    {
      aslo.a(localaslo, bool, paramSosoLbsInfo, this.jdField_a_of_type_Assu);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aslv
 * JD-Core Version:    0.7.0.1
 */