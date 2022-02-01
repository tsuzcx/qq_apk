import android.content.Context;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.debug.CmGameDebugView;
import com.tencent.mobileqq.apollo.process.ui.framework.CmGameFloatView;
import com.tencent.mobileqq.apollo.process.ui.framework.CmGameGuideView;
import com.tencent.mobileqq.apollo.process.ui.framework.FrameworkView;
import com.tencent.mobileqq.apollo.process.ui.framework.QzoneGameFloatView;

public class amtf
{
  public static FrameworkView a(Context paramContext, amrk paramamrk, bkgm parambkgm, amnt paramamnt, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    switch (paramStartCheckParam.src)
    {
    default: 
      if (paramStartCheckParam.mGameType == 5) {
        paramContext = new QzoneGameFloatView(paramContext, paramStartCheckParam);
      }
      break;
    }
    for (;;)
    {
      paramContext.a(paramamrk, parambkgm, paramamnt, paramStartCheckParam);
      return paramContext;
      paramContext = new QzoneGameFloatView(paramContext, paramStartCheckParam);
      continue;
      paramContext = new CmGameFloatView(paramContext, paramStartCheckParam);
    }
  }
  
  public static FrameworkView a(Context paramContext, amrk paramamrk, bkgm parambkgm, CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramContext = new CmGameGuideView(paramContext, paramStartCheckParam);
    }
    for (;;)
    {
      paramContext.a(paramamrk, parambkgm, null, paramStartCheckParam);
      return paramContext;
      paramContext = new CmGameGuideView(paramContext, paramStartCheckParam);
      continue;
      paramContext = new CmGameDebugView(paramContext, paramStartCheckParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtf
 * JD-Core Version:    0.7.0.1
 */