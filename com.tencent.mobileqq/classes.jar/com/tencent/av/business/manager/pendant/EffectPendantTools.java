package com.tencent.av.business.manager.pendant;

import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.filter.EffectFilterTools;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.VideoFilterList;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQVideoMaterial;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.TemplateParser;
import com.tencent.mobileqq.shortvideo.ptvfilter.utils.VideoFilterUtil;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.ttpic.cache.ImageMemoryManager;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.DecryptListener;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import java.io.File;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import jii;
import jij;

public class EffectPendantTools
  extends EffectConfigBase
{
  private int jdField_a_of_type_Int;
  private EffectPendantTips jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips = null;
  private PendantItem jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem;
  private VideoFilterList jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList;
  final DecryptListener jdField_a_of_type_ComTencentTtpicUtilDecryptListener = new jii(this);
  private boolean jdField_a_of_type_Boolean = false;
  private int b;
  public String c;
  private String d;
  
  public EffectPendantTools(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private void a(PendantItem paramPendantItem)
  {
    ((EffectFilterTools)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1)).a(paramPendantItem);
  }
  
  public int a()
  {
    return 106;
  }
  
  public VideoFilterList a(int paramInt1, int paramInt2)
  {
    if (!EffectsRenderController.b()) {
      return null;
    }
    Object localObject = VideoController.a().a();
    PendantItem localPendantItem = (PendantItem)a();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      c();
    }
    if ((paramInt1 == 0) || (paramInt2 == 0) || (localPendantItem == null) || (TextUtils.isEmpty(localPendantItem.getId())))
    {
      if (!TextUtils.isEmpty(this.d))
      {
        ImageMemoryManager.getInstance().clear();
        this.d = null;
      }
      return null;
    }
    if ((this.jdField_a_of_type_Int != paramInt1) || (this.b != paramInt2)) {
      a(paramInt1, paramInt2);
    }
    String str1 = c(localPendantItem);
    String str2 = localPendantItem.getId();
    if ((str1.equals(this.d)) && (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) && (str2.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.getId()))) {
      return this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList;
    }
    long l = System.currentTimeMillis();
    if ((((SessionInfo)localObject).a.get(1)) && (!str1.equals(this.d))) {
      ImageMemoryManager.getInstance().clear();
    }
    QQVideoMaterial localQQVideoMaterial;
    if (localPendantItem.hasGesture())
    {
      AVLog.c("EffectPendantTools", String.format("getVideoPendant, mCurrentPendant do have Gesture", new Object[0]));
      localQQVideoMaterial = TemplateParser.a(str1, "params");
      localQQVideoMaterial.b = true;
      localObject = localQQVideoMaterial;
      if (!localPendantItem.hasFace()) {
        localQQVideoMaterial.jdField_a_of_type_Boolean = false;
      }
    }
    for (localObject = localQQVideoMaterial;; localObject = TemplateParser.a(str1, "params", false, this.jdField_a_of_type_ComTencentTtpicUtilDecryptListener))
    {
      ImageMemoryManager.getInstance().loadAllImages((VideoMaterial)localObject);
      localObject = VideoFilterUtil.a((QQVideoMaterial)localObject);
      this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = localPendantItem;
      this.d = str1;
      a((VideoFilterList)localObject);
      paramInt1 = VideoMaterialUtil.TRIGGER_TYPE.UNKNOW.value;
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips != null) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips.a(paramInt1);
      }
      AVLog.c("EffectPendantTools", String.format("getVideoPendant, patternPath[%s], id[%s], tempList[%s], cost[%s]", new Object[] { str1, str2, localObject, Long.valueOf(System.currentTimeMillis() - l) }));
      return localObject;
      AVLog.c("EffectPendantTools", String.format("getVideoPendant, mCurrentPendant not have Gesture", new Object[0]));
    }
  }
  
  protected Class a()
  {
    return PendantItem.class;
  }
  
  public String a(PendantItem paramPendantItem)
  {
    String str = null;
    if (paramPendantItem != null) {
      str = AppConstants.aK + "new_ptv_template" + File.separator + paramPendantItem.getMd5();
    }
    return str;
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
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    double d1 = paramInt1 / paramInt2;
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.a())) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.a(paramInt1, paramInt2, d1);
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      paramString1 = (PendantItem)a();
    } while ((paramString1 == null) || (TextUtils.isEmpty(paramString1.getId())));
    a(null);
  }
  
  public void a(EffectPendantTips paramEffectPendantTips)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantEffectPendantTips = paramEffectPendantTips;
  }
  
  void a(VideoFilterList paramVideoFilterList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.b();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList = null;
    }
    if ((paramVideoFilterList != null) && (paramVideoFilterList.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList = paramVideoFilterList;
      double d1 = this.jdField_a_of_type_Int / this.b;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.a(this.jdField_a_of_type_Int, this.b, d1);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.d();
    }
  }
  
  public boolean a(PendantItem paramPendantItem)
  {
    boolean bool = super.a(paramPendantItem);
    SessionInfo localSessionInfo = VideoController.a().a();
    a(paramPendantItem);
    if ((paramPendantItem != null) && (!TextUtils.isEmpty(paramPendantItem.getId())))
    {
      localSessionInfo.a.set(1);
      if (paramPendantItem != null) {
        break label88;
      }
    }
    label88:
    for (paramPendantItem = null;; paramPendantItem = paramPendantItem.getId())
    {
      AVLog.c("EffectPendantTools", "setCurrentItem : " + paramPendantItem);
      EffectPendantTools.DataReport.a(paramPendantItem);
      return bool;
      localSessionInfo.a.clear(1);
      break;
    }
  }
  
  protected boolean a(String paramString)
  {
    return ((EffectSupportManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(5)).a(2, "ptu_so");
  }
  
  public String b(PendantItem paramPendantItem)
  {
    if (paramPendantItem != null) {
      return CapturePtvTemplateManager.c + paramPendantItem.getMd5() + File.separator;
    }
    return "";
  }
  
  protected boolean b(PendantItem paramPendantItem)
  {
    boolean bool2;
    if ((a() <= 0) || (paramPendantItem == null) || (TextUtils.isEmpty(paramPendantItem.getId())))
    {
      AVLog.e("EffectPendantTools", "isTemplateUsable:" + a() + "|");
      bool2 = false;
    }
    Object localObject;
    File localFile;
    do
    {
      boolean bool1;
      do
      {
        return bool2;
        if (TextUtils.isEmpty(paramPendantItem.getResurl())) {
          return true;
        }
        localObject = new File(a(paramPendantItem));
        bool2 = ((File)localObject).exists();
        bool1 = bool2;
        if (!bool2)
        {
          String str = AppConstants.aK + "ptv_template" + File.separator + paramPendantItem.getName();
          localFile = new File(str);
          bool1 = bool2;
          localObject = localFile;
          if (localFile.exists())
          {
            l1 = System.currentTimeMillis();
            localObject = SecUtil.getFileMd5(str);
            long l2 = System.currentTimeMillis();
            str = paramPendantItem.getMd5();
            AVLog.c("EffectPendantTools", "isTemplateUsable :" + (String)localObject + "|" + str + "|" + (l2 - l1));
            bool1 = str.equalsIgnoreCase((String)localObject);
            localObject = localFile;
          }
        }
        bool2 = bool1;
      } while (!bool1);
      localFile = new File(c(paramPendantItem), "params.json");
      long l1 = localFile.length();
      if ((localFile.exists()) && (l1 < 1L)) {
        break;
      }
      bool2 = bool1;
    } while (localFile.exists());
    ThreadManager.post(new jij(this, (File)localObject, paramPendantItem), 5, null, false);
    return false;
  }
  
  public String c(PendantItem paramPendantItem)
  {
    String str = "";
    if (paramPendantItem != null)
    {
      str = b(paramPendantItem) + paramPendantItem.getName() + File.separator;
      if (!new File(str).exists()) {}
    }
    else
    {
      return str;
    }
    return AppConstants.aK + "ptv_template" + File.separator + paramPendantItem.getName() + File.separator;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.b();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList = null;
    }
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = null;
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.EffectPendantTools
 * JD-Core Version:    0.7.0.1
 */