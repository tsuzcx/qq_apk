package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import android.text.Editable;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.IMsgSendListener;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.helper.SimpleUIAIOHelper;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;

public class SimpleMsgSendListener
  implements IMsgSendListener
{
  public boolean a(AIOContext paramAIOContext)
  {
    if (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeIsGuildChatContext(paramAIOContext)) {
      return false;
    }
    SimpleUIAIOHelper localSimpleUIAIOHelper = (SimpleUIAIOHelper)paramAIOContext.a(29);
    if ((paramAIOContext.p().d().f().a().length() <= 0) && (SimpleUIUtil.e()))
    {
      localSimpleUIAIOHelper.b(false);
      return true;
    }
    return false;
  }
  
  public void b(AIOContext paramAIOContext)
  {
    ((SimpleUIAIOHelper)paramAIOContext.a(29)).b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.SimpleMsgSendListener
 * JD-Core Version:    0.7.0.1
 */