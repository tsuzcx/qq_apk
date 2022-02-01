import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class atvv
  extends atvu
{
  public atvv(atuz paramatuz)
  {
    super(paramatuz);
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
 * Qualified Name:     atvv
 * JD-Core Version:    0.7.0.1
 */