package com.tencent.av.ui;

import android.content.Context;
import com.tencent.av.business.manager.EffectConfigBase.IEffectConfigCallback;
import com.tencent.av.business.manager.avatar2d.Avatar2dItem;
import com.tencent.av.business.manager.pendant.EffectPendantBase;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.ui.effect.interfaces.IItemDownloadMgr;
import com.tencent.av.utils.AudioHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QavListItemHelper
  implements EffectConfigBase.IEffectConfigCallback<PendantItem>, IItemDownloadMgr
{
  private final ArrayList<QavListItemBase.ItemInfo> a = new ArrayList(10);
  private final String b;
  private final int c;
  private final EffectPendantBase d;
  private QAVPtvTemplateAdapter e = null;
  
  public QavListItemHelper(int paramInt, EffectPendantBase paramEffectPendantBase)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QavListItemHelper");
    localStringBuilder.append(paramInt);
    this.b = localStringBuilder.toString();
    this.c = paramInt;
    this.d = paramEffectPendantBase;
  }
  
  public static QavListItemBase.ItemInfo a(int paramInt, Avatar2dItem paramAvatar2dItem, boolean paramBoolean)
  {
    QavListItemBase.ItemInfo localItemInfo = new QavListItemBase.ItemInfo();
    localItemInfo.f = paramInt;
    localItemInfo.a = paramAvatar2dItem.getId();
    localItemInfo.c = paramAvatar2dItem.getDesc();
    localItemInfo.b = paramAvatar2dItem.getIconUrl();
    localItemInfo.k = paramAvatar2dItem.getDesc();
    localItemInfo.h = false;
    localItemInfo.d = paramAvatar2dItem.isUsable();
    localItemInfo.m = paramAvatar2dItem;
    localItemInfo.n = paramBoolean;
    localItemInfo.l = paramAvatar2dItem.e();
    return localItemInfo;
  }
  
  public static QavListItemBase.ItemInfo a(int paramInt, PendantItem paramPendantItem)
  {
    QavListItemBase.ItemInfo localItemInfo = new QavListItemBase.ItemInfo();
    localItemInfo.f = paramInt;
    localItemInfo.a = paramPendantItem.getId();
    localItemInfo.c = paramPendantItem.getDesc();
    localItemInfo.b = paramPendantItem.getIconUrl();
    localItemInfo.k = paramPendantItem.getDesc();
    localItemInfo.h = false;
    localItemInfo.d = paramPendantItem.isUsable();
    localItemInfo.m = paramPendantItem;
    if (paramInt == 4) {
      localItemInfo.n = true;
    }
    return localItemInfo;
  }
  
  public ArrayList<QavListItemBase.ItemInfo> a(Context paramContext)
  {
    long l = AudioHelper.c();
    this.a.clear();
    if (this.c == 5)
    {
      localObject = new QavListItemBase.ItemInfo();
      ((QavListItemBase.ItemInfo)localObject).n = false;
      ((QavListItemBase.ItemInfo)localObject).a = "-1";
      this.a.add(localObject);
    }
    Object localObject = new QavListItemBase.ItemInfo();
    ((QavListItemBase.ItemInfo)localObject).a = "0";
    ((QavListItemBase.ItemInfo)localObject).b = String.valueOf(2130843204);
    ((QavListItemBase.ItemInfo)localObject).h = false;
    int i = this.c;
    ((QavListItemBase.ItemInfo)localObject).f = i;
    if (i == 4)
    {
      ((QavListItemBase.ItemInfo)localObject).n = true;
      ((QavListItemBase.ItemInfo)localObject).c = paramContext.getString(2131893140);
      ((QavListItemBase.ItemInfo)localObject).k = paramContext.getString(2131893141);
    }
    else
    {
      ((QavListItemBase.ItemInfo)localObject).n = false;
      ((QavListItemBase.ItemInfo)localObject).c = paramContext.getString(2131893140);
      ((QavListItemBase.ItemInfo)localObject).k = paramContext.getString(2131893140);
    }
    this.a.add(localObject);
    paramContext = this.d;
    if (paramContext != null)
    {
      paramContext = paramContext.c(null);
      localObject = (PendantItem)this.d.c();
      if ((localObject != null) && (!paramContext.contains(localObject))) {
        this.d.a(l, null);
      }
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          localObject = (PendantItem)paramContext.next();
          if (localObject != null)
          {
            localObject = a(this.c, (PendantItem)localObject);
            if (localObject != null) {
              this.a.add(localObject);
            }
          }
        }
      }
    }
    return this.a;
  }
  
  public void a(long paramLong, PendantItem paramPendantItem)
  {
    if (QLog.isDevelopLevel())
    {
      String str = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onItemSelectedChanged, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], current[");
      localStringBuilder.append(paramPendantItem);
      localStringBuilder.append("]");
      QLog.i(str, 4, localStringBuilder.toString());
    }
  }
  
  public void a(long paramLong, PendantItem paramPendantItem, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadFinish, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], isSuc[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], info[");
      localStringBuilder.append(paramPendantItem);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 4, localStringBuilder.toString());
    }
    Object localObject = this.e;
    if (localObject != null) {
      ((QAVPtvTemplateAdapter)localObject).a(paramLong, paramPendantItem.getId(), paramBoolean);
    }
  }
  
  public void a(PendantItem paramPendantItem, int paramInt)
  {
    QAVPtvTemplateAdapter localQAVPtvTemplateAdapter = this.e;
    if (localQAVPtvTemplateAdapter != null) {
      localQAVPtvTemplateAdapter.a(paramPendantItem.getId(), paramInt);
    }
  }
  
  public void a(QAVPtvTemplateAdapter paramQAVPtvTemplateAdapter)
  {
    this.e = paramQAVPtvTemplateAdapter;
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, QavListItemBase.ItemInfo paramItemInfo, QavListItemBase.IDownloadCallback paramIDownloadCallback)
  {
    paramAppInterface = this.d;
    if (paramAppInterface != null) {
      paramAppInterface = (PendantItem)paramAppInterface.b(paramItemInfo.a);
    } else {
      paramAppInterface = null;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startDownloadTemplate, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], item[");
      localStringBuilder.append(paramAppInterface);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 4, localStringBuilder.toString());
    }
    if (paramAppInterface != null)
    {
      this.d.b(paramLong, paramAppInterface);
      return;
    }
    paramAppInterface = this.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startDownloadTemplate, item为空, seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    QLog.w(paramAppInterface, 1, ((StringBuilder)localObject).toString());
    paramIDownloadCallback.a(paramLong, paramItemInfo.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavListItemHelper
 * JD-Core Version:    0.7.0.1
 */