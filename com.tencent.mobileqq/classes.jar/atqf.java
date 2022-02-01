import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import java.util.List;

public class atqf
  extends atqj
{
  public CharSequence c()
  {
    Object localObject = (FileManagerEntity)this.a.get(0);
    String str1 = aufn.b(((FileManagerEntity)localObject).srvTime);
    String str2 = auea.b((FileManagerEntity)localObject);
    localObject = FileUtil.filesizeToString(((FileManagerEntity)localObject).fileSize);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str2).append("  ").append(str1).append("  ").append((String)localObject);
    this.b = localStringBuilder;
    return localStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atqf
 * JD-Core Version:    0.7.0.1
 */