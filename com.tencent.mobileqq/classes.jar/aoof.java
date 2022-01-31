import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.List;

public class aoof
  extends aooj
{
  public CharSequence c()
  {
    Object localObject = (FileManagerEntity)this.a.get(0);
    String str1 = apea.b(((FileManagerEntity)localObject).srvTime);
    String str2 = apck.b((FileManagerEntity)localObject);
    localObject = apdh.a(((FileManagerEntity)localObject).fileSize);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str2).append("  ").append(str1).append("  ").append((String)localObject);
    this.b = localStringBuilder;
    return localStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoof
 * JD-Core Version:    0.7.0.1
 */