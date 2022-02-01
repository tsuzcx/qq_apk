package com.tencent.av.ui.effect.interfaces;

import com.tencent.av.ui.QavListItemBase.IDownloadCallback;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.common.app.AppInterface;

public abstract interface IItemDownloadMgr
{
  public abstract void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, QavListItemBase.ItemInfo paramItemInfo, QavListItemBase.IDownloadCallback paramIDownloadCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.interfaces.IItemDownloadMgr
 * JD-Core Version:    0.7.0.1
 */