import QC.BubbleRecommendRsp;
import QC.CommonRsp;
import QC.FontRecommendRsp;
import com.tencent.mobileqq.hiboom.FontBubblePanelView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aqcs
  extends ajrp
{
  public aqcs(FontBubblePanelView paramFontBubblePanelView) {}
  
  public void a(boolean paramBoolean, BubbleRecommendRsp paramBubbleRecommendRsp)
  {
    if (FontBubblePanelView.a(this.a) == 4)
    {
      if ((paramBoolean) && (paramBubbleRecommendRsp.vItems.size() > 0)) {
        FontBubblePanelView.a(this.a, paramBubbleRecommendRsp);
      }
    }
    else {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("onGetBubbleRecommend failed, ");
    if ((paramBubbleRecommendRsp != null) && (paramBubbleRecommendRsp.stRet != null))
    {
      localStringBuilder.append("ret:");
      localStringBuilder.append(paramBubbleRecommendRsp.stRet.ret);
      localStringBuilder.append("err:");
      localStringBuilder.append(paramBubbleRecommendRsp.stRet.err);
    }
    QLog.e("FontBubblePanelView", 1, localStringBuilder.toString());
  }
  
  public void a(boolean paramBoolean, FontRecommendRsp paramFontRecommendRsp)
  {
    if (FontBubblePanelView.a(this.a) == 3)
    {
      if ((paramBoolean) && (paramFontRecommendRsp.vItems.size() > 0)) {
        FontBubblePanelView.a(this.a, paramFontRecommendRsp);
      }
    }
    else {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("onGetFontRecommend failed, ");
    if ((paramFontRecommendRsp != null) && (paramFontRecommendRsp.stRet != null))
    {
      localStringBuilder.append("ret:");
      localStringBuilder.append(paramFontRecommendRsp.stRet.ret);
      localStringBuilder.append("err:");
      localStringBuilder.append(paramFontRecommendRsp.stRet.err);
    }
    QLog.e("FontBubblePanelView", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqcs
 * JD-Core Version:    0.7.0.1
 */