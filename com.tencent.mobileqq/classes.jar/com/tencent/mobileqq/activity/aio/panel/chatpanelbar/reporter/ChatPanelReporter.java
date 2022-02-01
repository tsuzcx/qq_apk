package com.tencent.mobileqq.activity.aio.panel.chatpanelbar.reporter;

import android.view.View;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarController;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.reporter.AudioPanelBizReporter;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.reporter.CmGamePanelBizReporter;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.reporter.HongbaoPanelBizReporter;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.reporter.HotPicPanelBizReporter;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.reporter.PtvPanelBizReporter;
import com.tencent.mobileqq.pluspanel.AIOPanelIconItem;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.jetbrains.annotations.NotNull;

public class ChatPanelReporter
  implements IChatPanelReporter
{
  private IChatPanelBarController jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarController;
  private IChatPanelBarData jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarData;
  Map<Integer, IPanelBizReporter> jdField_a_of_type_JavaUtilMap = new TreeMap();
  
  public ChatPanelReporter()
  {
    a();
  }
  
  public ChatPanelReporter(IChatPanelBarController paramIChatPanelBarController)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarController = paramIChatPanelBarController;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(40), new CmGamePanelBizReporter());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2), new AudioPanelBizReporter());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(6), new PtvPanelBizReporter(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarController));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(24), new HotPicPanelBizReporter(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarController));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(10), new HongbaoPanelBizReporter());
  }
  
  public void a(@NotNull IChatPanelBarData paramIChatPanelBarData)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarData = paramIChatPanelBarData;
  }
  
  public void a(List<AIOPanelIconItem> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        AIOPanelIconItem localAIOPanelIconItem = (AIOPanelIconItem)paramList.next();
        IPanelBizReporter localIPanelBizReporter = (IPanelBizReporter)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(localAIOPanelIconItem.d));
        if (localIPanelBizReporter != null) {
          localIPanelBizReporter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarData, localAIOPanelIconItem);
        }
      }
    }
  }
  
  public boolean a(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof Integer))
    {
      int i = ((Integer)localObject).intValue();
      localObject = (IPanelBizReporter)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
      if (localObject != null) {}
    }
    else
    {
      return false;
    }
    ((IPanelBizReporter)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarData, paramView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.reporter.ChatPanelReporter
 * JD-Core Version:    0.7.0.1
 */