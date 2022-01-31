class bkvt
  implements bkwg
{
  bkvt(bkvr parambkvr, bkwg parambkwg) {}
  
  public void a(bkvu parambkvu, int paramInt)
  {
    if (this.jdField_a_of_type_Bkwg != null) {
      this.jdField_a_of_type_Bkwg.a(parambkvu, paramInt);
    }
  }
  
  public void a(bkvu parambkvu, boolean paramBoolean)
  {
    bkvu localbkvu = bkvr.a(this.jdField_a_of_type_Bkvr, parambkvu);
    if (localbkvu != null) {
      localbkvu.d = bkvr.a(parambkvu);
    }
    if (this.jdField_a_of_type_Bkwg != null)
    {
      this.jdField_a_of_type_Bkwg.a(parambkvu, paramBoolean);
      if (localbkvu != null) {
        blfg.b("AEMaterialManager", "【END】onDownloadFinish :" + localbkvu.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkvt
 * JD-Core Version:    0.7.0.1
 */