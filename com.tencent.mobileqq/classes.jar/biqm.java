class biqm
  implements biqy
{
  biqm(biqk parambiqk, biqy parambiqy) {}
  
  public void a(biqn parambiqn, int paramInt)
  {
    if (this.jdField_a_of_type_Biqy != null) {
      this.jdField_a_of_type_Biqy.a(parambiqn, paramInt);
    }
  }
  
  public void a(biqn parambiqn, boolean paramBoolean)
  {
    biqn localbiqn = biqk.a(this.jdField_a_of_type_Biqk, parambiqn);
    if (localbiqn != null) {
      localbiqn.d = biqk.a(parambiqn);
    }
    if (this.jdField_a_of_type_Biqy != null)
    {
      this.jdField_a_of_type_Biqy.a(parambiqn, paramBoolean);
      if (localbiqn != null) {
        bizq.b("AEMaterialManager", "【END】onDownloadFinish :" + localbiqn.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biqm
 * JD-Core Version:    0.7.0.1
 */