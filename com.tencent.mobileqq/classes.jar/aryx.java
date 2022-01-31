import com.tencent.qphone.base.util.QLog;

class aryx
  implements atpa
{
  aryx(aryq paramaryq, aryl paramaryl) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aryl.a != null)
    {
      String str = this.jdField_a_of_type_Aryq.a(this.jdField_a_of_type_Aryl.a.a);
      arym localarym = this.jdField_a_of_type_Aryq.a(str);
      if ((localarym != null) && (!localarym.a))
      {
        localarym.c = (paramInt / 100);
        this.jdField_a_of_type_Aryq.a(str, localarym);
        aryq.a(this.jdField_a_of_type_Aryq, localarym, paramInt / 100);
      }
    }
  }
  
  public void a(atpb paramatpb)
  {
    int i = 0;
    String str = "";
    int k;
    if (paramatpb != null)
    {
      k = paramatpb.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq result = " + k);
      }
      j = k;
      if (paramatpb.jdField_a_of_type_Atpr != null)
      {
        i = paramatpb.jdField_a_of_type_Atpr.jdField_a_of_type_Int;
        str = paramatpb.jdField_a_of_type_Atpr.b;
      }
    }
    for (int j = k;; j = 0)
    {
      this.jdField_a_of_type_Aryq.a(this.jdField_a_of_type_Aryl, j, i, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aryx
 * JD-Core Version:    0.7.0.1
 */