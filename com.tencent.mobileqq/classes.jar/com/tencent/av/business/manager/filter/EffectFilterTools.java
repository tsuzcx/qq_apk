package com.tencent.av.business.manager.filter;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.AVNetEngine;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.config.EffectFaceDeviceConfig;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.video.effect.filter.FilterRender;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetReq;
import java.io.File;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import jga;

public class EffectFilterTools
  extends EffectConfigBase
{
  static boolean jdField_a_of_type_Boolean;
  static boolean b;
  FilterItem jdField_a_of_type_ComTencentAvBusinessManagerFilterFilterItem = null;
  private FilterRender jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender;
  private volatile boolean c;
  
  public EffectFilterTools(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public static boolean a(Context paramContext)
  {
    if (jdField_a_of_type_Boolean) {
      return true;
    }
    if (!EffectsRenderController.b())
    {
      AVLog.c("EffectFilterTools", "isSupport Error: 1");
      return false;
    }
    if (!EffectsRenderController.a(4, 1400000L)) {
      return false;
    }
    if ((paramContext != null) && (TextUtils.isEmpty(a(paramContext, 132)))) {
      return false;
    }
    paramContext = EffectFaceDeviceConfig.a();
    if ((paramContext != null) && (!paramContext.a()))
    {
      AVLog.c("EffectFilterTools", "  isSupportFilter false");
      return false;
    }
    jdField_a_of_type_Boolean = true;
    return jdField_a_of_type_Boolean;
  }
  
  public static String b(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    int i;
    int j;
    do
    {
      return paramString;
      i = paramString.lastIndexOf(".");
      j = paramString.lastIndexOf(File.separator);
      if (j != -1) {
        break;
      }
    } while (i == -1);
    return paramString.substring(0, i);
    if (i == -1) {
      return paramString.substring(j + 1);
    }
    if (j < i) {}
    for (paramString = paramString.substring(j + 1, i);; paramString = paramString.substring(j + 1)) {
      return paramString;
    }
  }
  
  public static boolean b(Context paramContext)
  {
    if (b) {
      return true;
    }
    if ((!EffectsRenderController.a(8, 1400000L)) && (!EffectsRenderController.a(4, 2150000L))) {
      return false;
    }
    paramContext = EffectFaceDeviceConfig.a();
    if ((paramContext != null) && (!paramContext.b()))
    {
      AVLog.c("EffectFilterTools", "isSupportGesture false");
      return false;
    }
    b = true;
    return b;
  }
  
  public int a()
  {
    return 132;
  }
  
  public FilterRender a()
  {
    if (this.c)
    {
      AVLog.c("EffectFilterTools", "getFilterRender|destroy current filterRender.");
      if (this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender != null)
      {
        this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender.destroy();
        this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender = null;
      }
      this.c = false;
    }
    Object localObject = (FilterItem)a();
    if (localObject == null) {
      return null;
    }
    localObject = b((FilterItem)localObject);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender = new FilterRender(VideoController.a().a());
    }
    this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender.setFilterPath((String)localObject);
    return this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender;
  }
  
  protected Class a()
  {
    return FilterItem.class;
  }
  
  public String a(FilterItem paramFilterItem)
  {
    if ((paramFilterItem != null) && (!TextUtils.isEmpty(paramFilterItem.getIconurl())) && (!TextUtils.isEmpty(paramFilterItem.getId())))
    {
      String str = a(a());
      return str + paramFilterItem.getId() + ".png";
    }
    return null;
  }
  
  public List a(String paramString)
  {
    paramString = super.a(paramString);
    ArrayList localArrayList = new ArrayList();
    if (paramString != null) {
      localArrayList.addAll(paramString);
    }
    return localArrayList;
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(null);
  }
  
  protected void a(FilterItem paramFilterItem) {}
  
  public void a(PendantItem paramPendantItem)
  {
    if ((paramPendantItem != null) && (!TextUtils.isEmpty(paramPendantItem.getFilterName())))
    {
      b((FilterItem)a(paramPendantItem.getFilterName()));
      return;
    }
    b(this.jdField_a_of_type_ComTencentAvBusinessManagerFilterFilterItem);
  }
  
  public boolean a(FilterItem paramFilterItem)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerFilterFilterItem = paramFilterItem;
    return b(paramFilterItem);
  }
  
  protected boolean a(String paramString)
  {
    boolean bool2 = false;
    super.b();
    boolean bool1 = bool2;
    int j;
    int k;
    int i;
    int m;
    label278:
    int n;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      paramString = this.jdField_a_of_type_JavaUtilList.iterator();
      j = 0;
      k = 0;
      i = 0;
      if (paramString.hasNext())
      {
        FilterItem localFilterItem = (FilterItem)paramString.next();
        AVLog.c("EffectFilterTools", "preDownloadResource 00:" + localFilterItem.getResurl() + "|" + localFilterItem.getIconurl() + "|");
        if (localFilterItem.getPredownload() != 1) {
          break label388;
        }
        m = i + 1;
        if ((!TextUtils.isEmpty(localFilterItem.getIconurl())) && (!TextUtils.isEmpty(localFilterItem.getIconMd5())))
        {
          String str = a(localFilterItem);
          i = k;
          if (!TextUtils.isEmpty(str))
          {
            Object localObject = new File(str);
            AVLog.c("EffectFilterTools", "preDownloadResource 22:" + str + "|" + ((File)localObject).exists());
            if (!((File)localObject).exists())
            {
              localObject = new HttpNetReq();
              ((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new jga(this);
              ((HttpNetReq)localObject).jdField_a_of_type_JavaLangString = localFilterItem.getIconurl();
              ((HttpNetReq)localObject).jdField_a_of_type_Int = 0;
              ((HttpNetReq)localObject).c = str;
              ((HttpNetReq)localObject).a(localFilterItem);
              AVNetEngine.a().a((NetReq)localObject);
              i = k;
            }
          }
          else
          {
            if ((TextUtils.isEmpty(localFilterItem.getResurl())) || (localFilterItem.isUsable())) {
              break label346;
            }
            a(localFilterItem);
            n = j;
            k = m;
            j = i;
            i = n;
          }
        }
      }
    }
    for (;;)
    {
      m = k;
      k = j;
      j = i;
      i = m;
      break;
      i = k + 1;
      break label278;
      i = k + 1;
      break label278;
      label346:
      n = j + 1;
      j = i;
      k = m;
      i = n;
      continue;
      bool1 = bool2;
      if (k == i)
      {
        bool1 = bool2;
        if (j == i) {
          bool1 = true;
        }
      }
      return bool1;
      label388:
      m = i;
      i = j;
      j = k;
      k = m;
    }
  }
  
  public String b(FilterItem paramFilterItem)
  {
    if ((paramFilterItem != null) && (!TextUtils.isEmpty(paramFilterItem.getResurl())) && (!TextUtils.isEmpty(paramFilterItem.getId())))
    {
      String str = b(paramFilterItem);
      paramFilterItem = b(paramFilterItem.getResurl());
      return str + paramFilterItem;
    }
    return null;
  }
  
  boolean b(FilterItem paramFilterItem)
  {
    boolean bool = super.a(paramFilterItem);
    SessionInfo localSessionInfo = VideoController.a().a();
    String str = b(paramFilterItem);
    if (TextUtils.isEmpty(str)) {
      localSessionInfo.a.clear(2);
    }
    for (;;)
    {
      if (paramFilterItem != null)
      {
        EffectFilterTools.DataReport.a((FilterItem)a());
        AVLog.c("EffectFilterTools", "setCurrentItem :" + paramFilterItem.getId() + "|" + str + "|" + this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender);
      }
      return bool;
      localSessionInfo.a.set(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.filter.EffectFilterTools
 * JD-Core Version:    0.7.0.1
 */