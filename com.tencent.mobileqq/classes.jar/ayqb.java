import QC.SuixintieCheckInfo;
import QC.SuixintieCheckItem;
import com.qq.taf.jce.JceInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class ayqb
{
  public static SuixintieCheckInfo a(String paramString)
  {
    SuixintieCheckInfo localSuixintieCheckInfo = new SuixintieCheckInfo();
    localSuixintieCheckInfo.readFrom(new JceInputStream(bhmx.a(paramString, 0)));
    if (localSuixintieCheckInfo.vSuixintieCheckList != null) {
      return localSuixintieCheckInfo;
    }
    return null;
  }
  
  public static SuixintieCheckItem a(SuixintieCheckInfo paramSuixintieCheckInfo, int paramInt)
  {
    if (paramSuixintieCheckInfo.vSuixintieCheckList != null)
    {
      paramSuixintieCheckInfo = paramSuixintieCheckInfo.vSuixintieCheckList.iterator();
      while (paramSuixintieCheckInfo.hasNext())
      {
        SuixintieCheckItem localSuixintieCheckItem = (SuixintieCheckItem)paramSuixintieCheckInfo.next();
        if (localSuixintieCheckItem.appid == paramInt) {
          return localSuixintieCheckItem;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqb
 * JD-Core Version:    0.7.0.1
 */