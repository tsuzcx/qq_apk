package com.tencent.mobileqq.apollo;

import airz;
import aisn;
import aixk;
import ajfj;
import ajkk;
import ajlq;
import ajou;
import android.os.Message;
import bbqp;
import bfnk;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class SettingMeApolloViewController$RefreshApolloTask
  implements Runnable
{
  private WeakReference<QQSettingMe> a;
  private WeakReference<SettingMeApolloViewController> b;
  
  public SettingMeApolloViewController$RefreshApolloTask(QQSettingMe paramQQSettingMe, SettingMeApolloViewController paramSettingMeApolloViewController)
  {
    this.a = new WeakReference(paramQQSettingMe);
    this.b = new WeakReference(paramSettingMeApolloViewController);
  }
  
  public void run()
  {
    if ((this.a == null) || (this.a.get() == null)) {}
    Object localObject1;
    int i;
    Object localObject3;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject1 = (QQSettingMe)this.a.get();
          } while (localObject1 == null);
          localObject2 = ((QQSettingMe)localObject1).a();
        } while (localObject2 == null);
        localObject1 = (SettingMeApolloViewController)this.b.get();
      } while (localObject1 == null);
      ajou.b("drawer_pre");
      i = ajfj.b(1);
      ajlq.a(i);
      ajlq.a(i, 1);
      ajlq.a(i, 10);
      localObject3 = (airz)((QQAppInterface)localObject2).getManager(153);
      ((airz)localObject3).a();
      localObject3 = ((airz)localObject3).b(((QQAppInterface)localObject2).getCurrentAccountUin());
      if ((localObject3 != null) && (((ApolloBaseInfo)localObject3).apolloLocalTS != ((ApolloBaseInfo)localObject3).apolloServerTS)) {
        ((bbqp)((QQAppInterface)localObject2).a(71)).a("qqSettingMe");
      }
      localObject3 = aixk.a((QQAppInterface)localObject2, ((QQAppInterface)localObject2).c(), (ApolloBaseInfo)localObject3, 1);
      if ((localObject3 == null) || (((aisn)localObject3).a))
      {
        QLog.w("SettingMeApolloViewController", 1, "checkDrawerRoleDressInfo not ready");
        return;
      }
      if (ajkk.a((QQAppInterface)localObject2, 11)) {
        break;
      }
      ajlq.a(((aisn)localObject3).e, 10, 110, new Object[] { "role 0 not ready" });
    } while (!QLog.isColorLevel());
    QLog.w("SettingMeApolloViewController", 2, "checkDrawerBasicApolloAction up and down not ready");
    return;
    ajlq.a(((aisn)localObject3).e, 10, 0, new Object[] { "switch done" });
    ajlq.a(i, 11);
    Object localObject2 = ((SettingMeApolloViewController)localObject1).a.obtainMessage(65536);
    ((Message)localObject2).obj = localObject3;
    ((SettingMeApolloViewController)localObject1).b = ((aisn)localObject3).c;
    ((SettingMeApolloViewController)localObject1).a.sendMessageAtFrontOfQueue((Message)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.SettingMeApolloViewController.RefreshApolloTask
 * JD-Core Version:    0.7.0.1
 */