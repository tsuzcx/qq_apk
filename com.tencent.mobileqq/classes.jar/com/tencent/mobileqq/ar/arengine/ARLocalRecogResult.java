package com.tencent.mobileqq.ar.arengine;

public class ARLocalRecogResult
{
  public long a;
  public ARLocalFaceRecogResult a;
  public ARLocalMarkerRecogResult a;
  
  public ARLocalRecogResult()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult = null;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult = null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARLocalRecogResult{frameIdx = ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", markerResult = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult);
    localStringBuilder.append(", faceResult = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalRecogResult
 * JD-Core Version:    0.7.0.1
 */