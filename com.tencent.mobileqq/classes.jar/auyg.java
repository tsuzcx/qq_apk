import QC.UniBusiGetOneItemWithCheckRsp;
import com.tencent.qphone.base.util.QLog;

class auyg
  implements ajte
{
  auyg(auyb paramauyb, auyi paramauyi) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    QLog.d("StickyNoteVasAdapter", 2, " type:" + paramInt + " isSuccess:" + paramBoolean);
    auyi localauyi;
    if (this.jdField_a_of_type_Auyi != null)
    {
      if (!(paramObject instanceof UniBusiGetOneItemWithCheckRsp)) {
        break label84;
      }
      localauyi = this.jdField_a_of_type_Auyi;
      if (((UniBusiGetOneItemWithCheckRsp)paramObject).ret != 0) {
        break label79;
      }
    }
    label79:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localauyi.a(paramBoolean, (UniBusiGetOneItemWithCheckRsp)paramObject);
      return;
    }
    label84:
    this.jdField_a_of_type_Auyi.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auyg
 * JD-Core Version:    0.7.0.1
 */