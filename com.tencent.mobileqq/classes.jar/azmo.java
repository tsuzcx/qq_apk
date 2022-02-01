class azmo
{
  final String a;
  final String b;
  
  azmo(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String toString()
  {
    return String.format("CopyItem{mMenuTitle=%s mCopyContent=%s}", new Object[] { this.a, this.b });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azmo
 * JD-Core Version:    0.7.0.1
 */