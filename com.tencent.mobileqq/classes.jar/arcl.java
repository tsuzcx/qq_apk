import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.List;

public class arcl
  extends arcp
{
  public CharSequence c()
  {
    Object localObject = (FileManagerEntity)this.a.get(0);
    String str1 = arth.b(((FileManagerEntity)localObject).srvTime);
    String str2 = arrr.b((FileManagerEntity)localObject);
    localObject = arso.a(((FileManagerEntity)localObject).fileSize);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str2).append("  ").append(str1).append("  ").append((String)localObject);
    this.b = localStringBuilder;
    return localStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arcl
 * JD-Core Version:    0.7.0.1
 */