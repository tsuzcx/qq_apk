package com.etrump.mixlayout;

public class EMCollection
{
  private ETEngine jdField_a_of_type_ComEtrumpMixlayoutETEngine;
  private int[] jdField_a_of_type_ArrayOfInt;
  
  public EMCollection(ETEngine paramETEngine)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETEngine = paramETEngine;
  }
  
  public int a(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfInt != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_ArrayOfInt.length)) {
      return this.jdField_a_of_type_ArrayOfInt[paramInt];
    }
    return -1;
  }
  
  public boolean a(String paramString, ETFont paramETFont)
  {
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETEngine != null) && (paramString != null) && (paramETFont != null)) {
      this.jdField_a_of_type_ArrayOfInt = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_emoticonRetrieveCollection(paramString, paramETFont);
    }
    return this.jdField_a_of_type_ArrayOfInt != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.etrump.mixlayout.EMCollection
 * JD-Core Version:    0.7.0.1
 */