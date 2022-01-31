import com.tencent.qphone.base.util.QLog;

class auqj
  implements awiq
{
  auqj(auqc paramauqc, aupx paramaupx) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aupx.a != null)
    {
      String str = this.jdField_a_of_type_Auqc.a(this.jdField_a_of_type_Aupx.a.a);
      aupy localaupy = this.jdField_a_of_type_Auqc.a(str);
      if ((localaupy != null) && (!localaupy.a))
      {
        localaupy.c = (paramInt / 100);
        this.jdField_a_of_type_Auqc.a(str, localaupy);
        auqc.a(this.jdField_a_of_type_Auqc, localaupy, paramInt / 100);
      }
    }
  }
  
  public void a(awir paramawir)
  {
    int i = 0;
    String str = "";
    int k;
    if (paramawir != null)
    {
      k = paramawir.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq result = " + k);
      }
      j = k;
      if (paramawir.jdField_a_of_type_Awjh != null)
      {
        i = paramawir.jdField_a_of_type_Awjh.jdField_a_of_type_Int;
        str = paramawir.jdField_a_of_type_Awjh.b;
      }
    }
    for (int j = k;; j = 0)
    {
      this.jdField_a_of_type_Auqc.a(this.jdField_a_of_type_Aupx, j, i, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auqj
 * JD-Core Version:    0.7.0.1
 */