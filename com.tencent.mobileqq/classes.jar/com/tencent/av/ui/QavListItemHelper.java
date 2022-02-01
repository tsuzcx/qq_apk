package com.tencent.av.ui;

import android.content.Context;
import com.tencent.av.business.manager.EffectConfigBase.IEffectConfigCallback;
import com.tencent.av.business.manager.pendant.EffectPendantBase;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
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
    this.jdField_a_of_type_JavaLangString = ("QavListItemHelper" + paramInt);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase = paramEffectPendantBase;
  }
  
  public static QavListItemBase.ItemInfo a(int paramInt, PendantItem paramPendantItem)
  {
    QavListItemBase.ItemInfo localItemInfo = new QavListItemBase.ItemInfo();
    localItemInfo.jdField_a_of_type_Int = paramInt;
    localItemInfo.jdField_a_of_type_JavaLangString = paramPendantItem.getId();
    localItemInfo.jdField_c_of_type_JavaLangString = paramPendantItem.getDesc();
    localItemInfo.b = paramPendantItem.getIconurl();
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
    ((QavListItemBase.ItemInfo)localObject).b = String.valueOf(2130842368);
    ((QavListItemBase.ItemInfo)localObject).jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_Int == 4)
    {
      ((QavListItemBase.ItemInfo)localObject).jdField_d_of_type_Boolean = true;
      ((QavListItemBase.ItemInfo)localObject).jdField_c_of_type_JavaLangString = paramContext.getString(2131695384);
    }
    for (((QavListItemBase.ItemInfo)localObject).jdField_d_of_type_JavaLangString = paramContext.getString(2131695385);; ((QavListItemBase.ItemInfo)localObject).jdField_d_of_type_JavaLangString = paramContext.getString(2131695384))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase == null) {
        break;
      }
      paramContext = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase.a(null);
      localObject = (PendantItem)this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase.a();
      if ((localObject != null) && (!paramContext.contains(localObject))) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase.a(l, null);
      }
      if ((paramContext == null) || (paramContext.size() <= 0)) {
        break;
      }
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
      ((QavListItemBase.ItemInfo)localObject).jdField_d_of_type_Boolean = false;
      ((QavListItemBase.ItemInfo)localObject).jdField_c_of_type_JavaLangString = paramContext.getString(2131695384);
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(long paramLong, PendantItem paramPendantItem)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "onItemSelectedChanged, seq[" + paramLong + "], current[" + paramPendantItem + "]");
    }
  }
  
  public void a(long paramLong, PendantItem paramPendantItem, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "onDownloadFinish, seq[" + paramLong + "], isSuc[" + paramBoolean + "], info[" + paramPendantItem + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter != null) {
      this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.a(paramLong, paramPendantItem.getId(), paramBoolean);
    }
  }
  
  public void a(PendantItem paramPendantItem, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter != null) {
      this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.a(paramPendantItem.getId(), paramInt);
    }
  }
  
  public void a(QAVPtvTemplateAdapter paramQAVPtvTemplateAdapter)
  {
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter = paramQAVPtvTemplateAdapter;
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, QavListItemBase.ItemInfo paramItemInfo, QavListItemBase.IDownloadCallback paramIDownloadCallback)
  {
    paramAppInterface = null;
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase != null) {
      paramAppInterface = (PendantItem)this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase.a(paramItemInfo.jdField_a_of_type_JavaLangString);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "startDownloadTemplate, seq[" + paramLong + "], item[" + paramAppInterface + "]");
    }
    if (paramAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantBase.a(paramLong, paramAppInterface);
      return;
    }
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "startDownloadTemplate, item为空, seq[" + paramLong + "]");
    paramIDownloadCallback.a(paramLong, paramItemInfo.jdField_a_of_type_JavaLangString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.QavListItemHelper
 * JD-Core Version:    0.7.0.1
 */