import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class auff
  extends aufd
{
  public auff(auei paramauei)
  {
    super(paramauei);
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
 * Qualified Name:     auff
 * JD-Core Version:    0.7.0.1
 */