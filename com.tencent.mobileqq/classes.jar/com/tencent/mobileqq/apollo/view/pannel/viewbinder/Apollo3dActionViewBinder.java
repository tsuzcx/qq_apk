package com.tencent.mobileqq.apollo.view.pannel.viewbinder;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.view.Apollo3DMainInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class Apollo3dActionViewBinder
  extends ApolloSecondaryViewBinder
{
  public Apollo3dActionViewBinder(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo);
  }
  
  public ApolloInfo a(String paramString)
  {
    return new Apollo3DMainInfo(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.viewbinder.Apollo3dActionViewBinder
 * JD-Core Version:    0.7.0.1
 */