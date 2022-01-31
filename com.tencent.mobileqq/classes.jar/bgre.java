class bgre
  implements bgrh
{
  bgre(bgrb parambgrb, bgrg parambgrg) {}
  
  public void onInitApkgInfo(int paramInt, bgjw parambgjw, String paramString)
  {
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Bgrg != null) {
        this.jdField_a_of_type_Bgrg.a(parambgjw, paramInt, paramString);
      }
    }
    while (this.jdField_a_of_type_Bgrg == null) {
      return;
    }
    this.jdField_a_of_type_Bgrg.a(null, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgre
 * JD-Core Version:    0.7.0.1
 */