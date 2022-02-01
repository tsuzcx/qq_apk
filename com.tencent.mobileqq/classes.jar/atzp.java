import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.List;

public class atzp
  extends atzt
{
  public CharSequence c()
  {
    Object localObject = (FileManagerEntity)this.a.get(0);
    String str1 = auoy.b(((FileManagerEntity)localObject).srvTime);
    String str2 = aunj.b((FileManagerEntity)localObject);
    localObject = auog.a(((FileManagerEntity)localObject).fileSize);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str2).append("  ").append(str1).append("  ").append((String)localObject);
    this.b = localStringBuilder;
    return localStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzp
 * JD-Core Version:    0.7.0.1
 */