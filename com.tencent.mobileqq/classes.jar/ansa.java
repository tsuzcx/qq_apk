import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import java.util.Comparator;

class ansa
  implements Comparator<BaseAddress>
{
  ansa(anrz paramanrz) {}
  
  public int a(BaseAddress paramBaseAddress1, BaseAddress paramBaseAddress2)
  {
    int j = paramBaseAddress1.pinyinFirst.compareTo(paramBaseAddress2.pinyinFirst);
    int i = j;
    if (j == 0) {
      i = paramBaseAddress1.pinyinAll.compareTo(paramBaseAddress2.pinyinAll);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ansa
 * JD-Core Version:    0.7.0.1
 */