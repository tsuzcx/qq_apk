public class amxq
{
  public float a;
  public float b;
  public float c;
  
  public amxq(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ApolloRoleInfo:").append("scale:").append(this.a).append(",xPos:").append(this.b).append(",yPos:").append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxq
 * JD-Core Version:    0.7.0.1
 */