class blva
  implements blvj
{
  blva(bluy parambluy, blvj paramblvj) {}
  
  public void onDownloadFinish(blvb paramblvb, boolean paramBoolean)
  {
    blvb localblvb = bluy.a(this.jdField_a_of_type_Bluy, paramblvb);
    if (localblvb != null) {
      localblvb.e = bluy.a(paramblvb);
    }
    if (this.jdField_a_of_type_Blvj != null)
    {
      this.jdField_a_of_type_Blvj.onDownloadFinish(paramblvb, paramBoolean);
      if (localblvb != null) {
        bmbx.b("AEMaterialManager", "【END】onDownloadFinish :" + localblvb.a);
      }
    }
  }
  
  public void onProgressUpdate(blvb paramblvb, int paramInt)
  {
    if (this.jdField_a_of_type_Blvj != null) {
      this.jdField_a_of_type_Blvj.onProgressUpdate(paramblvb, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blva
 * JD-Core Version:    0.7.0.1
 */