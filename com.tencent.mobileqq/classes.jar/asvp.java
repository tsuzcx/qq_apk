import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class asvp
  extends apck
{
  asvp(asvi paramasvi, String paramString, boolean paramBoolean, atcg paramatcg)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoAsync onLocationFinish " + paramInt);
    }
    asvi localasvi;
    if (this.jdField_a_of_type_Atcg != null)
    {
      localasvi = this.jdField_a_of_type_Asvi;
      if (paramInt != 0) {
        break label62;
      }
    }
    label62:
    for (boolean bool = true;; bool = false)
    {
      asvi.a(localasvi, bool, paramSosoLbsInfo, this.jdField_a_of_type_Atcg);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvp
 * JD-Core Version:    0.7.0.1
 */