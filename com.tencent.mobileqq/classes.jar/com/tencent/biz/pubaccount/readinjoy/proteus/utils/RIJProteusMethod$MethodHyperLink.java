package com.tencent.biz.pubaccount.readinjoy.proteus.utils;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.topic.RIJCommentTopicUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister.CustomMethodInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class RIJProteusMethod$MethodHyperLink
  implements CustomMethodsRegister.CustomMethodInterface
{
  private static boolean a(View paramView, String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramView != null) && (paramString.endsWith("#comment_topic")))
    {
      RIJCommentTopicUtil.a(paramView, paramString);
      return true;
    }
    return false;
  }
  
  private static boolean a(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramString.startsWith("more-")))
    {
      ReadInJoyLogicEngineEventDispatcher.a().a(paramString);
      return true;
    }
    return false;
  }
  
  private static boolean b(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramString.endsWith("#native_article_topic_tag")))
    {
      ReadInJoyLogicEngineEventDispatcher.a().b(paramString);
      return true;
    }
    return false;
  }
  
  public Object invoke(String paramString, Object... paramVarArgs)
  {
    Object localObject;
    if ((paramVarArgs != null) && (paramVarArgs.length >= 1))
    {
      localObject = paramVarArgs[0];
      QLog.d("RIJProteusMethod", 1, "MethodHyperLink invoke,s=" + paramString + " firstObject=" + localObject);
      localObject = String.valueOf(localObject);
      if ((paramVarArgs.length < 2) || (!(paramVarArgs[1] instanceof View))) {
        break label120;
      }
    }
    label120:
    for (paramString = (View)paramVarArgs[1];; paramString = null)
    {
      boolean bool = a((String)localObject, false) | false;
      bool |= b((String)localObject, bool);
      if (!(a(paramString, (String)localObject, bool) | bool)) {
        RIJJumpUtils.a(BaseApplication.getContext(), (String)localObject);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.utils.RIJProteusMethod.MethodHyperLink
 * JD-Core Version:    0.7.0.1
 */