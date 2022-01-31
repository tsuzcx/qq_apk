import QC.UniBusiGetOneItemWithCheckRsp;
import com.tencent.qphone.base.util.QLog;

class auye
  implements ajtg
{
  auye(auxz paramauxz, auyg paramauyg) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    QLog.d("StickyNoteVasAdapter", 2, " type:" + paramInt + " isSuccess:" + paramBoolean);
    auyg localauyg;
    if (this.jdField_a_of_type_Auyg != null)
    {
      if (!(paramObject instanceof UniBusiGetOneItemWithCheckRsp)) {
        break label84;
      }
      localauyg = this.jdField_a_of_type_Auyg;
      if (((UniBusiGetOneItemWithCheckRsp)paramObject).ret != 0) {
        break label79;
      }
    }
    label79:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localauyg.a(paramBoolean, (UniBusiGetOneItemWithCheckRsp)paramObject);
      return;
    }
    label84:
    this.jdField_a_of_type_Auyg.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auye
 * JD-Core Version:    0.7.0.1
 */