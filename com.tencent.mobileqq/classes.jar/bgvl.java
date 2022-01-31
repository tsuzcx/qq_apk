class bgvl
  implements bgvo
{
  bgvl(bgvi parambgvi, bgvn parambgvn) {}
  
  public void onInitApkgInfo(int paramInt, bgod parambgod, String paramString)
  {
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Bgvn != null) {
        this.jdField_a_of_type_Bgvn.a(parambgod, paramInt, paramString);
      }
    }
    while (this.jdField_a_of_type_Bgvn == null) {
      return;
    }
    this.jdField_a_of_type_Bgvn.a(null, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgvl
 * JD-Core Version:    0.7.0.1
 */