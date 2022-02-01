import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.wordsegment.WordSegment.ILogCallback;

final class apwx
  implements WordSegment.ILogCallback
{
  public void OnLog(String paramString1, String paramString2)
  {
    ArkAppCenter.c("ArkApp.Dict.WordSegment." + paramString1, String.format("%s", new Object[] { paramString2 }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apwx
 * JD-Core Version:    0.7.0.1
 */