class bnkd
  implements bnkq
{
  bnkd(bnkb parambnkb, bnkq parambnkq) {}
  
  public void onDownloadFinish(bnke parambnke, boolean paramBoolean)
  {
    bnke localbnke = bnkb.a(this.jdField_a_of_type_Bnkb, parambnke);
    if (localbnke != null) {
      localbnke.e = bnkb.a(parambnke);
    }
    if (this.jdField_a_of_type_Bnkq != null)
    {
      this.jdField_a_of_type_Bnkq.onDownloadFinish(parambnke, paramBoolean);
      if (localbnke != null) {
        bnrh.b("AEMaterialManager", "【END】onDownloadFinish :" + localbnke.a);
      }
    }
  }
  
  public void onProgressUpdate(bnke parambnke, int paramInt)
  {
    if (this.jdField_a_of_type_Bnkq != null) {
      this.jdField_a_of_type_Bnkq.onProgressUpdate(parambnke, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnkd
 * JD-Core Version:    0.7.0.1
 */