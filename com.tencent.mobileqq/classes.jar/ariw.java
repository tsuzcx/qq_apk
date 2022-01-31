import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class ariw
  extends ariu
{
  public ariw(arhz paramarhz)
  {
    super(paramarhz);
  }
  
  public boolean a(String paramString)
  {
    FileManagerEntity localFileManagerEntity = this.a.a();
    if (localFileManagerEntity == null) {}
    while ((localFileManagerEntity.strTroopFilePath == null) || (!localFileManagerEntity.strTroopFilePath.equalsIgnoreCase(paramString))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ariw
 * JD-Core Version:    0.7.0.1
 */