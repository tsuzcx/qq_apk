package com.tencent.mobileqq.activity.aio.pluspanel.filter;

import com.tencent.av.core.VcSystemInfo;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.PlusPanelAppLoader;
import com.tencent.mobileqq.app.QQAppInterface;

public class SharpAudioSupportFilter
  implements AppInfoFilter
{
  public void a(PlusPanelAppLoader paramPlusPanelAppLoader, QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (!VcSystemInfo.isSupportSharpAudio())
    {
      paramPlusPanelAppLoader.b(202);
      paramPlusPanelAppLoader.b(201);
      paramPlusPanelAppLoader.b(1200000007);
      paramPlusPanelAppLoader.b(100719166);
      paramPlusPanelAppLoader.b(101847385);
      paramPlusPanelAppLoader.b(1104651886);
      paramPlusPanelAppLoader.b(1106658188);
    }
    if ((paramInt != 0) && (paramInt != 1025) && (paramInt != 1024) && (!ChatActivityUtils.a(paramQQAppInterface, paramString)))
    {
      paramPlusPanelAppLoader.b(202);
      paramPlusPanelAppLoader.b(201);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.filter.SharpAudioSupportFilter
 * JD-Core Version:    0.7.0.1
 */