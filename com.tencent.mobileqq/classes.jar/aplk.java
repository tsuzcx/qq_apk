import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class aplk
  extends apli
{
  public aplk(apkp paramapkp)
  {
    super(paramapkp);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aplk
 * JD-Core Version:    0.7.0.1
 */