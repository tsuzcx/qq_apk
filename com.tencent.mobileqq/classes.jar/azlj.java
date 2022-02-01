import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

public class azlj
{
  private volatile CameraPosition jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public void a(CameraPosition paramCameraPosition)
  {
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition = paramCameraPosition;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(10);
    localStringBuilder.append("mLastCameraPosition:").append(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelCameraPosition);
    localStringBuilder.append(" mMapZoomKey:").append(this.jdField_a_of_type_Boolean);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azlj
 * JD-Core Version:    0.7.0.1
 */