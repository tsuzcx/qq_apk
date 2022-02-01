package com.tencent.mobileqq.apollo.store;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

class ApolloGuestsPresenter$1
  extends ApolloExtensionObserver
{
  ApolloGuestsPresenter$1(ApolloGuestsPresenter paramApolloGuestsPresenter) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
    {
      QLog.e("[cmshow]ApolloGuestsPresenter", 1, "ApolloDressChange fail");
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ApolloDressChange uin=");
      localStringBuilder.append(paramObject);
      QLog.d("[cmshow]ApolloGuestsPresenter", 2, localStringBuilder.toString());
    }
    if (ApolloGuestsPresenter.b(this.a) != null) {
      ApolloGuestsPresenter.b(this.a).onDressChange();
    }
    this.a.c();
  }
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  protected void g(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
    {
      QLog.e("[cmshow]ApolloGuestsPresenter", 1, "get zanCount fail ");
      return;
    }
    if ((paramObject != null) && (ApolloGuestsPresenter.b(this.a) != null))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("get zanCount = ");
        ((StringBuilder)localObject1).append(paramObject);
        QLog.d("[cmshow]ApolloGuestsPresenter", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("cmshow_zan", 0);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("apollo_zan_count");
      ((StringBuilder)localObject2).append(ApolloGuestsPresenter.c(this.a));
      int i = ((SharedPreferences)localObject1).getInt(((StringBuilder)localObject2).toString(), 0);
      localObject1 = ((SharedPreferences)localObject1).edit();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("apollo_zan_count");
      ((StringBuilder)localObject2).append(ApolloGuestsPresenter.c(this.a));
      String str = ((StringBuilder)localObject2).toString();
      localObject2 = (Integer)paramObject;
      ((SharedPreferences.Editor)localObject1).putInt(str, ((Integer)localObject2).intValue()).commit();
      if (((Integer)localObject2).intValue() > 99999) {
        paramObject = Integer.valueOf(99999);
      }
      localObject2 = String.valueOf(paramObject);
      localObject1 = paramObject;
      if (((Integer)paramObject).intValue() >= 99999)
      {
        localObject1 = Integer.valueOf(99999);
        paramObject = new StringBuilder();
        paramObject.append(localObject1);
        paramObject.append("+");
        localObject2 = paramObject.toString();
      }
      ApolloGuestsPresenter.b(this.a).onApprovalGet((String)localObject2, i, ((Integer)localObject1).intValue());
      return;
    }
    QLog.e("[cmshow]ApolloGuestsPresenter", 1, "get zanCount data is null");
  }
  
  protected void h(boolean paramBoolean, Object paramObject)
  {
    Object localObject1;
    if ((paramObject != null) && (ApolloGuestsPresenter.a(this.a) != null))
    {
      if (ApolloGuestsPresenter.b(this.a) == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("set zanCount = ");
        ((StringBuilder)localObject1).append(paramObject);
        QLog.d("[cmshow]ApolloGuestsPresenter", 2, ((StringBuilder)localObject1).toString());
      }
      if (paramBoolean) {}
      try
      {
        localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("cmshow_zan", 0);
        localObject1 = Calendar.getInstance();
        localObject2 = ((SharedPreferences)localObject2).edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(ApolloGuestsPresenter.a(this.a).getCurrentAccountUin());
        localStringBuilder.append("apollo_today_has_vote");
        localStringBuilder.append(ApolloGuestsPresenter.c(this.a));
        localStringBuilder.append(((Calendar)localObject1).get(1));
        localStringBuilder.append(((Calendar)localObject1).get(2));
        localStringBuilder.append(((Calendar)localObject1).get(5));
        ((SharedPreferences.Editor)localObject2).putBoolean(localStringBuilder.toString(), true).commit();
        localObject1 = paramObject;
        if (((Integer)paramObject).intValue() > 99999) {
          localObject1 = Integer.valueOf(99999);
        }
        ApolloGuestsPresenter.b(this.a).onApprovalSet(((Integer)localObject1).intValue());
        return;
      }
      catch (Exception paramObject)
      {
        Object localObject2;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("set zanCount error= ");
        ((StringBuilder)localObject1).append(paramObject.toString());
        QLog.e("[cmshow]ApolloGuestsPresenter", 1, ((StringBuilder)localObject1).toString());
      }
      if (((Long)paramObject).longValue() == -501010L)
      {
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("today has vote to ");
          paramObject.append(ApolloGuestsPresenter.c(this.a));
          QLog.d("[cmshow]ApolloGuestsPresenter", 2, paramObject.toString());
        }
        localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("cmshow_zan", 0);
        paramObject = Calendar.getInstance();
        localObject1 = ((SharedPreferences)localObject1).edit();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(ApolloGuestsPresenter.a(this.a).getCurrentAccountUin());
        ((StringBuilder)localObject2).append("apollo_today_has_vote");
        ((StringBuilder)localObject2).append(ApolloGuestsPresenter.c(this.a));
        ((StringBuilder)localObject2).append(paramObject.get(1));
        ((StringBuilder)localObject2).append(paramObject.get(2));
        ((StringBuilder)localObject2).append(paramObject.get(5));
        ((SharedPreferences.Editor)localObject1).putBoolean(((StringBuilder)localObject2).toString(), true).commit();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGuestsPresenter.1
 * JD-Core Version:    0.7.0.1
 */