import com.tencent.qphone.base.util.QLog;

class axjr
  implements azjj
{
  axjr(axjk paramaxjk, axjf paramaxjf) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Axjf.a != null)
    {
      String str = this.jdField_a_of_type_Axjk.a(this.jdField_a_of_type_Axjf.a.a);
      axjg localaxjg = this.jdField_a_of_type_Axjk.a(str);
      if ((localaxjg != null) && (!localaxjg.a))
      {
        localaxjg.c = (paramInt / 100);
        this.jdField_a_of_type_Axjk.a(str, localaxjg);
        axjk.a(this.jdField_a_of_type_Axjk, localaxjg, paramInt / 100);
      }
    }
  }
  
  public void a(azjk paramazjk)
  {
    int i = 0;
    String str = "";
    int k;
    if (paramazjk != null)
    {
      k = paramazjk.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq result = " + k);
      }
      j = k;
      if (paramazjk.jdField_a_of_type_Azkb != null)
      {
        i = paramazjk.jdField_a_of_type_Azkb.jdField_a_of_type_Int;
        str = paramazjk.jdField_a_of_type_Azkb.b;
      }
    }
    for (int j = k;; j = 0)
    {
      this.jdField_a_of_type_Axjk.a(this.jdField_a_of_type_Axjf, j, i, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axjr
 * JD-Core Version:    0.7.0.1
 */