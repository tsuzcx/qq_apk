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
  static boolean k = false;
  FilterItem l = null;
  private FilterDesc m;
  
  public EffectFilterTools(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = k;
    if (bool) {
      return bool;
    }
    if (!EffectsRenderController.m())
    {
      AVLog.printColorLog("EffectFilterTools", "isSupport Error: 1");
      return false;
    }
    if (!EffectsRenderController.a(4, 1400000L)) {
      return false;
    }
    if ((paramContext != null) && (TextUtils.isEmpty(QAVConfig.b(132).b))) {
      return false;
    }
    paramContext = EffectFaceDeviceConfig.g();
    if ((paramContext != null) && (!paramContext.a()))
    {
      AVLog.printColorLog("EffectFilterTools", "  isSupportFilter false");
      return false;
    }
    k = true;
    return k;
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
  
  public static String d(String paramString)
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
  
  public String a(FilterItem paramFilterItem)
  {
    if ((paramFilterItem != null) && (!TextUtils.isEmpty(paramFilterItem.getResUrl())) && (!TextUtils.isEmpty(paramFilterItem.getId())))
    {
      String str = b(paramFilterItem);
      paramFilterItem = d(paramFilterItem.getResUrl());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(paramFilterItem);
      return localStringBuilder.toString();
    }
    return null;
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
      b(paramLong, (FilterItem)b(paramPendantItem.getFilterName()));
      return;
    }
    b(paramLong, this.l);
  }
  
  public boolean a(long paramLong, FilterItem paramFilterItem)
  {
    this.l = paramFilterItem;
    return b(paramLong, paramFilterItem);
  }
  
  protected boolean a(String paramString)
  {
    super.g();
    paramString = this.e;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      paramString = this.e.iterator();
      int i = 0;
      int j = 0;
      while (paramString.hasNext())
      {
        FilterItem localFilterItem = (FilterItem)paramString.next();
        long l1 = AudioHelper.c();
        if (AudioHelper.e())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("preDownloadResource, seq[");
          localStringBuilder.append(l1);
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
            b(l1, localFilterItem);
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
  
  public int b()
  {
    return 132;
  }
  
  protected void b(FilterItem paramFilterItem) {}
  
  boolean b(long paramLong, FilterItem paramFilterItem)
  {
    boolean bool = super.a(paramLong, paramFilterItem);
    SessionInfo localSessionInfo = VideoController.f().k();
    if (TextUtils.isEmpty(a(paramFilterItem)))
    {
      localSessionInfo.bG.clear(2);
      this.m = null;
    }
    else
    {
      localSessionInfo.bG.set(2);
      this.m = new FilterDesc(Integer.valueOf(paramFilterItem.getFilterId()).intValue(), paramFilterItem.getPredownload(), paramFilterItem.getResUrl(), paramFilterItem.getMd5(), paramFilterItem.getIconUrl(), paramFilterItem.getIconMd5(), paramFilterItem.getId(), 0, b(paramFilterItem));
      this.m.type = paramFilterItem.getFiltertype();
    }
    if (paramFilterItem != null) {
      EffectFilterTools.DataReport.a((FilterItem)c());
    }
    return bool;
  }
  
  public List<FilterItem> c(String paramString)
  {
    paramString = super.c(paramString);
    ArrayList localArrayList = new ArrayList();
    if (paramString != null) {
      localArrayList.addAll(paramString);
    }
    return localArrayList;
  }
  
  protected Class<?> i()
  {
    return FilterItem.class;
  }
  
  public FilterDesc j()
  {
    return this.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.filter.EffectFilterTools
 * JD-Core Version:    0.7.0.1
 */