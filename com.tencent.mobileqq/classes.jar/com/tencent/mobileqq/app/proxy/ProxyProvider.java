package com.tencent.mobileqq.app.proxy;

import android.util.SparseArray;
import com.tencent.imcore.message.ConversationProxy;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.MsgProxy;
import com.tencent.imcore.message.MsgProxyContainer;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.confess.ConfessProxy;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgProxy;
import com.tencent.mobileqq.qcall.QCallProxy;
import com.tencent.mobileqq.statistics.ReportProxyAdapter;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataBaseProxy;
import cooperation.qlink.ReliableReportProxy;
import mqq.app.AppRuntime;

public class ProxyProvider
  implements Provider<SparseArray<BaseProxy>>
{
  private SparseArray<BaseProxy> a = new SparseArray();
  
  ProxyProvider(AppRuntime paramAppRuntime, BaseProxyManager paramBaseProxyManager)
  {
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      a(0, new MsgProxyContainer(paramAppRuntime, paramBaseProxyManager, new MsgPool()));
      a(1, new MsgProxy(paramAppRuntime, paramBaseProxyManager, new MsgPool()));
      a(2, new MultiMsgProxy(paramAppRuntime, paramBaseProxyManager));
      a(3, new DataLineMsgPcProxy(paramAppRuntime, paramBaseProxyManager));
      a(4, new DataLineMsgIpadProxy(paramAppRuntime, paramBaseProxyManager));
      a(5, new MpfileTaskProxy(paramAppRuntime, paramBaseProxyManager));
      a(6, new FileManagerProxy(paramAppRuntime, paramBaseProxyManager));
      a(7, new TroopFileDataBaseProxy(paramAppRuntime, paramBaseProxyManager));
      a(9, new ReportProxyAdapter(paramAppRuntime, paramBaseProxyManager));
      a(10, new ReliableReportProxy(paramAppRuntime, paramBaseProxyManager));
      a(11, new ConversationProxy(paramAppRuntime, paramBaseProxyManager));
      a(12, new QCallProxy(paramAppRuntime, paramBaseProxyManager));
      a(13, new ConfessProxy(paramAppRuntime, paramBaseProxyManager));
      a(14, new MsgBackupMsgProxy(paramAppRuntime, paramBaseProxyManager));
    }
  }
  
  private void a(int paramInt, BaseProxy paramBaseProxy)
  {
    this.a.put(paramInt, paramBaseProxy);
  }
  
  public SparseArray<BaseProxy> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.ProxyProvider
 * JD-Core Version:    0.7.0.1
 */