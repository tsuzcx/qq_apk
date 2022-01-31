import QC.BubbleInfo;
import QC.BubbleRecommendRsp;
import QC.ItemBase;
import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hiboom.FontBubble;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class asrl
  implements asru<BubbleRecommendRsp>
{
  public int a()
  {
    return 4;
  }
  
  public String a(Context paramContext)
  {
    return bdtg.a(paramContext, "bubble", "mvip.gongneng.android.bubble.index_dynamic_tab");
  }
  
  public String a(FontBubble paramFontBubble)
  {
    return bdtg.a("bubblePreview").replace("[id]", Integer.toString(paramFontBubble.bubbleId));
  }
  
  public List<FontBubble> a(QQAppInterface paramQQAppInterface, BubbleRecommendRsp paramBubbleRecommendRsp)
  {
    int j = 0;
    paramQQAppInterface = ((alto)paramQQAppInterface.getManager(51)).a(paramQQAppInterface.getAccount());
    int i;
    if (paramQQAppInterface == null)
    {
      QLog.e("FontBubbleManager", 1, "BubbleController no ExtensionInfo");
      i = 0;
    }
    for (;;)
    {
      paramQQAppInterface = new ArrayList();
      if (paramBubbleRecommendRsp.vItems == null) {
        break;
      }
      paramBubbleRecommendRsp = paramBubbleRecommendRsp.vItems.iterator();
      while (paramBubbleRecommendRsp.hasNext())
      {
        BubbleInfo localBubbleInfo = (BubbleInfo)paramBubbleRecommendRsp.next();
        FontBubble localFontBubble = new FontBubble();
        localFontBubble.viewType = 1;
        localFontBubble.fontId = i;
        localFontBubble.engine = j;
        localFontBubble.bubbleId = localBubbleInfo.item.itemId;
        localFontBubble.name = localBubbleInfo.name;
        localFontBubble.feeType = localBubbleInfo.feeType;
        localFontBubble.payUrl = localBubbleInfo.payUrl;
        localFontBubble.title = localBubbleInfo.title;
        localFontBubble.msg = localBubbleInfo.msg;
        localFontBubble.btn = localBubbleInfo.btn;
        localFontBubble.picUrl = localBubbleInfo.strPicUrl;
        localFontBubble.panelType = 4;
        paramQQAppInterface.add(localFontBubble);
      }
      i = (int)paramQQAppInterface.uVipFont;
      j = paramQQAppInterface.vipFontType;
    }
    return paramQQAppInterface;
  }
  
  public void a(amca paramamca)
  {
    paramamca.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asrl
 * JD-Core Version:    0.7.0.1
 */