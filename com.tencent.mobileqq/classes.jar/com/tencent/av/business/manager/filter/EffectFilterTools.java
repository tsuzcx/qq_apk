package com.tencent.av.business.manager.filter;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.ManageConfig.QAVConfItem;
import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.config.EffectFaceDeviceConfig;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

public class EffectFilterTools
  extends EffectConfigBase<FilterItem>
{
  static boolean jdField_a_of_type_Boolean = false;
  FilterItem jdField_a_of_type_ComTencentAvBusinessManagerFilterFilterItem = null;
  private FilterDesc jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc;
  
  public EffectFilterTools(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      if (paramString.equals("")) {
        return paramString;
      }
      int i = paramString.lastIndexOf(".");
      int j = paramString.lastIndexOf(File.separator);
      if (j == -1)
      {
        if (i == -1) {
          return paramString;
        }
        return paramString.substring(0, i);
      }
      if (i == -1) {
        return paramString.substring(j + 1);
      }
      if (j < i) {
        return paramString.substring(j + 1, i);
      }
      str = paramString.substring(j + 1);
    }
    return str;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = jdField_a_of_type_Boolean;
    if (bool) {
      return bool;
    }
    if (!EffectsRenderController.f())
    {
      AVLog.printColorLog("EffectFilterTools", "isSupport Error: 1");
      return false;
    }
    if (!EffectsRenderController.a(4, 1400000L)) {
      return false;
    }
    if ((paramContext != null) && (TextUtils.isEmpty(QAVConfig.b(132).a))) {
      return false;
    }
    paramContext = EffectFaceDeviceConfig.a();
    if ((paramContext != null) && (!paramContext.a()))
    {
      AVLog.printColorLog("EffectFilterTools", "  isSupportFilter false");
      return false;
    }
    jdField_a_of_type_Boolean = true;
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(PendantItem paramPendantItem)
  {
    if (paramPendantItem == null) {
      return false;
    }
    boolean bool = PendantItem.isOnlySupportOldFilter(paramPendantItem.getKind()) ^ true;
    if (QLog.isColorLevel()) {
      QLog.i("EffectFilterTools", 2, String.format("isSupportFilter, support[%s], kind[%s], id[%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramPendantItem.getKind()), paramPendantItem.getId() }));
    }
    return bool;
  }
  
  public int a()
  {
    return 132;
  }
  
  public FilterDesc a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc;
  }
  
  protected Class<?> a()
  {
    return FilterItem.class;
  }
  
  public String a(FilterItem paramFilterItem)
  {
    if ((paramFilterItem != null) && (!TextUtils.isEmpty(paramFilterItem.getResUrl())) && (!TextUtils.isEmpty(paramFilterItem.getId())))
    {
      String str = b(paramFilterItem);
      paramFilterItem = a(paramFilterItem.getResUrl());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(paramFilterItem);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public List<FilterItem> a(String paramString)
  {
    paramString = super.a(paramString);
    ArrayList localArrayList = new ArrayList();
    if (paramString != null) {
      localArrayList.addAll(paramString);
    }
    return localArrayList;
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt != 2) && (paramInt != 3)) {
      return;
    }
    a(paramLong, null);
  }
  
  public void a(long paramLong, PendantItem paramPendantItem)
  {
    if ((paramPendantItem != null) && (!TextUtils.isEmpty(paramPendantItem.getFilterName())))
    {
      b(paramLong, (FilterItem)a(paramPendantItem.getFilterName()));
      return;
    }
    b(paramLong, this.jdField_a_of_type_ComTencentAvBusinessManagerFilterFilterItem);
  }
  
  protected void a(FilterItem paramFilterItem) {}
  
  public boolean a(long paramLong, FilterItem paramFilterItem)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerFilterFilterItem = paramFilterItem;
    return b(paramLong, paramFilterItem);
  }
  
  protected boolean a(String paramString)
  {
    super.c();
    paramString = this.jdField_a_of_type_JavaUtilList;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      paramString = this.jdField_a_of_type_JavaUtilList.iterator();
      int i = 0;
      int j = 0;
      while (paramString.hasNext())
      {
        FilterItem localFilterItem = (FilterItem)paramString.next();
        long l = AudioHelper.b();
        if (AudioHelper.b())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("preDownloadResource, seq[");
          localStringBuilder.append(l);
          localStringBuilder.append("], res[");
          localStringBuilder.append(localFilterItem.getResUrl());
          localStringBuilder.append("], icon[");
          localStringBuilder.append(localFilterItem.getIconUrl());
          localStringBuilder.append("]");
          QLog.w("EffectFilterTools", 1, localStringBuilder.toString());
        }
        if (localFilterItem.getPredownload() == 1)
        {
          j += 1;
          if ((!TextUtils.isEmpty(localFilterItem.getResUrl())) && (!localFilterItem.isUsable())) {
            a(l, localFilterItem);
          } else {
            i += 1;
          }
        }
      }
      bool1 = bool2;
      if (i == j) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  boolean b(long paramLong, FilterItem paramFilterItem)
  {
    boolean bool = super.a(paramLong, paramFilterItem);
    SessionInfo localSessionInfo = VideoController.a().a();
    if (TextUtils.isEmpty(a(paramFilterItem)))
    {
      localSessionInfo.a.clear(2);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = null;
    }
    else
    {
      localSessionInfo.a.set(2);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = new FilterDesc(Integer.valueOf(paramFilterItem.getFilterId()).intValue(), paramFilterItem.getPredownload(), paramFilterItem.getResUrl(), paramFilterItem.getMd5(), paramFilterItem.getIconUrl(), paramFilterItem.getIconMd5(), paramFilterItem.getId(), 0, b(paramFilterItem));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.type = paramFilterItem.getFiltertype();
    }
    if (paramFilterItem != null) {
      EffectFilterTools.DataReport.a((FilterItem)a());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.filter.EffectFilterTools
 * JD-Core Version:    0.7.0.1
 */