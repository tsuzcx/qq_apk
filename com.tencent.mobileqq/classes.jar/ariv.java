import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class ariv
  extends ariu
{
  public ariv(arhz paramarhz)
  {
    super(paramarhz);
  }
  
  public boolean a(String paramString)
  {
    FileManagerEntity localFileManagerEntity = this.a.a();
    if (localFileManagerEntity == null) {
      return false;
    }
    return paramString.equals(String.valueOf(localFileManagerEntity.nSessionId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ariv
 * JD-Core Version:    0.7.0.1
 */