package com.tencent.mobileqq.apollo;

import aknx;
import akom;
import aktj;
import albi;
import algj;
import alhp;
import alku;
import android.os.Message;
import bdug;
import bhtd;
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
      alku.b("drawer_pre");
      i = albi.b(1);
      alhp.a(i);
      alhp.a(i, 1);
      alhp.a(i, 10);
      localObject3 = (aknx)((QQAppInterface)localObject2).getManager(153);
      ((aknx)localObject3).a();
      localObject3 = ((aknx)localObject3).b(((QQAppInterface)localObject2).getCurrentAccountUin());
      if ((localObject3 != null) && (((ApolloBaseInfo)localObject3).apolloLocalTS != ((ApolloBaseInfo)localObject3).apolloServerTS)) {
        ((bdug)((QQAppInterface)localObject2).a(71)).a("qqSettingMe");
      }
      localObject3 = aktj.a((QQAppInterface)localObject2, ((QQAppInterface)localObject2).c(), (ApolloBaseInfo)localObject3, 1);
      if ((localObject3 == null) || (((akom)localObject3).a))
      {
        QLog.w("SettingMeApolloViewController", 1, "checkDrawerRoleDressInfo not ready");
        return;
      }
      if (algj.a((QQAppInterface)localObject2, 11)) {
        break;
      }
      alhp.a(((akom)localObject3).e, 10, 110, new Object[] { "role 0 not ready" });
    } while (!QLog.isColorLevel());
    QLog.w("SettingMeApolloViewController", 2, "checkDrawerBasicApolloAction up and down not ready");
    return;
    alhp.a(((akom)localObject3).e, 10, 0, new Object[] { "switch done" });
    alhp.a(i, 11);
    Object localObject2 = ((SettingMeApolloViewController)localObject1).a.obtainMessage(65536);
    ((Message)localObject2).obj = localObject3;
    ((SettingMeApolloViewController)localObject1).b = ((akom)localObject3).c;
    ((SettingMeApolloViewController)localObject1).a.sendMessageAtFrontOfQueue((Message)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.SettingMeApolloViewController.RefreshApolloTask
 * JD-Core Version:    0.7.0.1
 */