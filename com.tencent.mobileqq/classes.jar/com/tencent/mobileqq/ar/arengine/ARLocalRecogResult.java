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
    return "ARLocalRecogResult{frameIdx = " + this.jdField_a_of_type_Long + ", markerResult = " + this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult + ", faceResult = " + this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalRecogResult
 * JD-Core Version:    0.7.0.1
 */