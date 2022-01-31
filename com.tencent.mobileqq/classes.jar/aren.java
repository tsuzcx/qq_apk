import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class aren
  extends arel
{
  public aren(ardq paramardq)
  {
    super(paramardq);
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
 * Qualified Name:     aren
 * JD-Core Version:    0.7.0.1
 */