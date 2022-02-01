import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class atnj
  extends atni
{
  public atnj(atmn paramatmn)
  {
    super(paramatmn);
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
 * Qualified Name:     atnj
 * JD-Core Version:    0.7.0.1
 */