import com.tencent.mobileqq.armap.sensor.rotation.Vector3;

public class apaz
{
  public static float a(double paramDouble)
  {
    return (float)(paramDouble - Math.floor(paramDouble / 360.0D) * 360.0D);
  }
  
  public static float a(float paramFloat1, float paramFloat2)
  {
    return (float)Math.asin(paramFloat1 / (2.0F * paramFloat2));
  }
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (float)(paramFloat1 * paramFloat2 * paramFloat3 / Math.sqrt((paramFloat1 + paramFloat2 + paramFloat3) * (paramFloat1 - paramFloat2 + paramFloat3) * (paramFloat1 + paramFloat2 - paramFloat3) * (paramFloat2 + paramFloat3 - paramFloat1)));
  }
  
  public static float a(Vector3 paramVector31, Vector3 paramVector32)
  {
    return (float)Math.sqrt((paramVector31.x - paramVector32.x) * (paramVector31.x - paramVector32.x) + (paramVector31.y - paramVector32.y) * (paramVector31.y - paramVector32.y) + (paramVector31.z - paramVector32.z) * (paramVector31.z - paramVector32.z));
  }
  
  public static float b(float paramFloat1, float paramFloat2)
  {
    return (float)Math.asin(Math.min(1.0F, Math.max(-1.0F, paramFloat1 / (2.0F * paramFloat2))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apaz
 * JD-Core Version:    0.7.0.1
 */