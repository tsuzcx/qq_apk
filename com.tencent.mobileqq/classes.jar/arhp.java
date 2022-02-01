import com.tencent.mobileqq.app.soso.LbsManagerService.OnLocationChangeListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class arhp
  extends LbsManagerService.OnLocationChangeListener
{
  arhp(arhi paramarhi, String paramString, boolean paramBoolean, aroo paramaroo)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoAsync onLocationFinish " + paramInt);
    }
    arhi localarhi;
    if (this.jdField_a_of_type_Aroo != null)
    {
      localarhi = this.jdField_a_of_type_Arhi;
      if (paramInt != 0) {
        break label62;
      }
    }
    label62:
    for (boolean bool = true;; bool = false)
    {
      arhi.a(localarhi, bool, paramSosoLbsInfo, this.jdField_a_of_type_Aroo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arhp
 * JD-Core Version:    0.7.0.1
 */