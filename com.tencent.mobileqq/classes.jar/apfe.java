import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.List;

public class apfe
  extends apfi
{
  public CharSequence c()
  {
    Object localObject = (FileManagerEntity)this.a.get(0);
    String str1 = apvw.b(((FileManagerEntity)localObject).srvTime);
    String str2 = apug.b((FileManagerEntity)localObject);
    localObject = apvd.a(((FileManagerEntity)localObject).fileSize);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str2).append("  ").append(str1).append("  ").append((String)localObject);
    this.b = localStringBuilder;
    return localStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apfe
 * JD-Core Version:    0.7.0.1
 */