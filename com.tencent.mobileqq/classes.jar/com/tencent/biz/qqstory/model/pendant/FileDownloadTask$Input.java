package com.tencent.biz.qqstory.model.pendant;

public class FileDownloadTask$Input
{
  public final String a;
  public final String b;
  public final String c;
  
  public FileDownloadTask$Input(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      return;
    }
    throw new IllegalArgumentException("both downloadUrl and downloadLocalPath should not be null");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (Input)paramObject;
      if (!this.a.equals(paramObject.a)) {
        return false;
      }
      if (!this.b.equals(paramObject.b)) {
        return false;
      }
      String str = this.c;
      if (str != null) {
        if (str.equals(paramObject.c)) {
          break label97;
        }
      } else if (paramObject.c == null) {
        return true;
      }
      bool = false;
      label97:
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = this.a.hashCode();
    int k = this.b.hashCode();
    String str = this.c;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Input{downloadUrl='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", downloadLocalPath='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", downloadFileMd5='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.pendant.FileDownloadTask.Input
 * JD-Core Version:    0.7.0.1
 */