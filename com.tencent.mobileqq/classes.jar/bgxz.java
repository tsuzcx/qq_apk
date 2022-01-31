class bgxz
  implements bgxw
{
  bgxz(bgxx parambgxx, bgxw parambgxw) {}
  
  public void a(bgya parambgya, int paramInt)
  {
    if (this.jdField_a_of_type_Bgxw != null) {
      this.jdField_a_of_type_Bgxw.a(parambgya, paramInt);
    }
  }
  
  public void a(bgya parambgya, boolean paramBoolean)
  {
    bgya localbgya = bgxx.a(this.jdField_a_of_type_Bgxx, parambgya);
    if (localbgya != null) {
      localbgya.d = bgxx.a(parambgya);
    }
    if (this.jdField_a_of_type_Bgxw != null)
    {
      this.jdField_a_of_type_Bgxw.a(parambgya, paramBoolean);
      bhcs.a("AEMaterialManager", 1, "【END】onDownloadFinish :" + localbgya.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bgxz
 * JD-Core Version:    0.7.0.1
 */