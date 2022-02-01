package com.tencent.mobileqq.app.proxy;

import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.colornote.data.ColorNoteProxy;
import com.tencent.mobileqq.confess.ConfessProxy;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.qcall.QCallProxy;
import cooperation.qlink.ReliableReportProxy;

public class LazyProxyNewClassProvider
  implements Provider<Class[]>
{
  public Class[] a()
  {
    return new Class[] { DataLineMsgIpadProxy.class, DataLineMsgPcProxy.class, FileManagerProxy.class, ReliableReportProxy.class, MultiMsgProxy.class, ColorNoteProxy.class, QCallProxy.class, ConfessProxy.class };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.LazyProxyNewClassProvider
 * JD-Core Version:    0.7.0.1
 */