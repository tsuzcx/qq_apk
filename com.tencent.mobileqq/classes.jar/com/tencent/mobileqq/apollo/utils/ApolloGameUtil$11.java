package com.tencent.mobileqq.apollo.utils;

import com.tencent.mobileqq.webview.util.WebProcessStartListener;
import com.tencent.qphone.base.util.QLog;

final class ApolloGameUtil$11
  implements WebProcessStartListener
{
  public void onResult(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("preload webprocess, itembuilder, isProcessExist: ");
      if (paramBoolean) {
        break label40;
      }
    }
    label40:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("cmgame_process.", 2, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.11
 * JD-Core Version:    0.7.0.1
 */