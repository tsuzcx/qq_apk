import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class aufe
  extends aufd
{
  public aufe(auei paramauei)
  {
    super(paramauei);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aufe
 * JD-Core Version:    0.7.0.1
 */