import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class asrp
  extends asrn
{
  public asrp(asqs paramasqs)
  {
    super(paramasqs);
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
 * Qualified Name:     asrp
 * JD-Core Version:    0.7.0.1
 */