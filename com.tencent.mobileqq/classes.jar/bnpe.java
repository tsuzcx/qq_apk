class bnpe
  implements bnpq
{
  bnpe(bnpc parambnpc, bnpq parambnpq) {}
  
  public void a(bnpf parambnpf, int paramInt)
  {
    if (this.jdField_a_of_type_Bnpq != null) {
      this.jdField_a_of_type_Bnpq.a(parambnpf, paramInt);
    }
  }
  
  public void a(bnpf parambnpf, boolean paramBoolean)
  {
    bnpf localbnpf = bnpc.a(this.jdField_a_of_type_Bnpc, parambnpf);
    if (localbnpf != null) {
      localbnpf.e = bnpc.a(parambnpf);
    }
    if (this.jdField_a_of_type_Bnpq != null)
    {
      this.jdField_a_of_type_Bnpq.a(parambnpf, paramBoolean);
      if (localbnpf != null) {
        bnzb.b("AEMaterialManager", "【END】onDownloadFinish :" + localbnpf.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpe
 * JD-Core Version:    0.7.0.1
 */