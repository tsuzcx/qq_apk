package com.tencent.av.ui;

import android.content.Context;
import com.tencent.av.business.manager.EffectConfigBase.IEffectConfigCallback;
import com.tencent.av.business.manager.pendant.EffectPendantBase;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.utils.AudioHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QavListItemHelper
  implements EffectConfigBase.IEffectConfigCallback<PendantItem>, QAVPtvTemplateAdapter.IItemDownloadMgr
{
  private final int jdField_a_of_type_Int;
  private final EffectPendantBase jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase;
  private QAVPtvTemplateAdapter jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter = null;
  private final String jdField_a_of_type_JavaLangString;
  private final ArrayList<QavListItemBase.ItemInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  
  public QavListItemHelper(int paramInt, EffectPendantBase paramEffectPendantBase)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QavListItemHelper");
    localStringBuilder.append(paramInt);
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase = paramEffectPendantBase;
  }
  
  public static QavListItemBase.ItemInfo a(int paramInt, PendantItem paramPendantItem)
  {
    QavListItemBase.ItemInfo localItemInfo = new QavListItemBase.ItemInfo();
    localItemInfo.jdField_a_of_type_Int = paramInt;
    localItemInfo.jdField_a_of_type_JavaLangString = paramPendantItem.getId();
    localItemInfo.jdField_c_of_type_JavaLangString = paramPendantItem.getDesc();
    localItemInfo.b = paramPendantItem.getIconUrl();
    localItemInfo.jdField_d_of_type_JavaLangString = paramPendantItem.getDesc();
    localItemInfo.jdField_c_of_type_Boolean = false;
    localItemInfo.jdField_a_of_type_Boolean = paramPendantItem.isUsable();
    localItemInfo.jdField_a_of_type_JavaLangObject = paramPendantItem;
    if (paramInt == 4) {
      localItemInfo.jdField_d_of_type_Boolean = true;
    }
    return localItemInfo;
  }
  
  public ArrayList<QavListItemBase.ItemInfo> a(Context paramContext)
  {
    long l = AudioHelper.b();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_Int == 5)
    {
      localObject = new QavListItemBase.ItemInfo();
      ((QavListItemBase.ItemInfo)localObject).jdField_d_of_type_Boolean = false;
      ((QavListItemBase.ItemInfo)localObject).jdField_a_of_type_JavaLangString = "-1";
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    }
    Object localObject = new QavListItemBase.ItemInfo();
    ((QavListItemBase.ItemInfo)localObject).jdField_a_of_type_JavaLangString = "0";
    ((QavListItemBase.ItemInfo)localObject).b = String.valueOf(2130842266);
    ((QavListItemBase.ItemInfo)localObject).jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_Int == 4)
    {
      ((QavListItemBase.ItemInfo)localObject).jdField_d_of_type_Boolean = true;
      ((QavListItemBase.ItemInfo)localObject).jdField_c_of_type_JavaLangString = paramContext.getString(2131695394);
      ((QavListItemBase.ItemInfo)localObject).jdField_d_of_type_JavaLangString = paramContext.getString(2131695395);
    }
    else
    {
      ((QavListItemBase.ItemInfo)localObject).jdField_d_of_type_Boolean = false;
      ((QavListItemBase.ItemInfo)localObject).jdField_c_of_type_JavaLangString = paramContext.getString(2131695394);
      ((QavListItemBase.ItemInfo)localObject).jdField_d_of_type_JavaLangString = paramContext.getString(2131695394);
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    paramContext = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase;
    if (paramContext != null)
    {
      paramContext = paramContext.a(null);
      localObject = (PendantItem)this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase.a();
      if ((localObject != null) && (!paramContext.contains(localObject))) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase.a(l, null);
      }
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          localObject = (PendantItem)paramContext.next();
          if (localObject != null)
          {
            localObject = a(this.jdField_a_of_type_Int, (PendantItem)localObject);
            if (localObject != null) {
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
            }
          }
        }
      }
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(long paramLong, PendantItem paramPendantItem)
  {
    if (QLog.isDevelopLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
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
      localObject = this.jdField_a_of_type_JavaLangString;
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
    Object localObject = this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter;
    if (localObject != null) {
      ((QAVPtvTemplateAdapter)localObject).a(paramLong, paramPendantItem.getId(), paramBoolean);
    }
  }
  
  public void a(PendantItem paramPendantItem, int paramInt)
  {
    QAVPtvTemplateAdapter localQAVPtvTemplateAdapter = this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter;
    if (localQAVPtvTemplateAdapter != null) {
      localQAVPtvTemplateAdapter.a(paramPendantItem.getId(), paramInt);
    }
  }
  
  public void a(QAVPtvTemplateAdapter paramQAVPtvTemplateAdapter)
  {
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter = paramQAVPtvTemplateAdapter;
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, QavListItemBase.ItemInfo paramItemInfo, QavListItemBase.IDownloadCallback paramIDownloadCallback)
  {
    paramAppInterface = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase;
    if (paramAppInterface != null) {
      paramAppInterface = (PendantItem)paramAppInterface.a(paramItemInfo.jdField_a_of_type_JavaLangString);
    } else {
      paramAppInterface = null;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
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
      this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase.a(paramLong, paramAppInterface);
      return;
    }
    paramAppInterface = this.jdField_a_of_type_JavaLangString;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startDownloadTemplate, item为空, seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    QLog.w(paramAppInterface, 1, ((StringBuilder)localObject).toString());
    paramIDownloadCallback.a(paramLong, paramItemInfo.jdField_a_of_type_JavaLangString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavListItemHelper
 * JD-Core Version:    0.7.0.1
 */