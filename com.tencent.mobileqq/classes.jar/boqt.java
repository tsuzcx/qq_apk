class boqt
  implements borc
{
  boqt(boqr paramboqr, borc paramborc) {}
  
  public void a(boqu paramboqu, int paramInt)
  {
    if (this.jdField_a_of_type_Borc != null) {
      this.jdField_a_of_type_Borc.a(paramboqu, paramInt);
    }
  }
  
  public void a(boqu paramboqu, boolean paramBoolean)
  {
    boqu localboqu = boqr.a(this.jdField_a_of_type_Boqr, paramboqu);
    if (localboqu != null) {
      localboqu.e = boqr.a(paramboqu);
    }
    if (this.jdField_a_of_type_Borc != null)
    {
      this.jdField_a_of_type_Borc.a(paramboqu, paramBoolean);
      if (localboqu != null) {
        bpam.b("AEMaterialManager", "【END】onDownloadFinish :" + localboqu.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boqt
 * JD-Core Version:    0.7.0.1
 */