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
      paramPlusPanelAppLoader.c(202);
      paramPlusPanelAppLoader.c(201);
      paramPlusPanelAppLoader.c(1200000007);
      paramPlusPanelAppLoader.c(100719166);
      paramPlusPanelAppLoader.c(101847385);
      paramPlusPanelAppLoader.c(1104651886);
      paramPlusPanelAppLoader.c(1106658188);
    }
    if ((paramInt != 0) && (paramInt != 1025) && (paramInt != 1024) && (!ChatActivityUtils.a(paramQQAppInterface, paramString)))
    {
      paramPlusPanelAppLoader.c(202);
      paramPlusPanelAppLoader.c(201);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.filter.SharpAudioSupportFilter
 * JD-Core Version:    0.7.0.1
 */