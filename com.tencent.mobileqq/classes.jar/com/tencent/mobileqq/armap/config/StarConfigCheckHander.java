package com.tencent.mobileqq.armap.config;

import abmt;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ResDownloadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StarConfigCheckHander
  extends BaseCheckHandler
{
  public ARMapConfig a;
  StarConfigCheckHander.Listener a;
  public List b;
  
  public StarConfigCheckHander(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public static List a(ARMapConfig paramARMapConfig)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramARMapConfig.starInfos != null)
    {
      paramARMapConfig = paramARMapConfig.starInfos.iterator();
      while (paramARMapConfig.hasNext())
      {
        ARMapConfig.ResInfo localResInfo = ((ARMapConfig.StarInfo)paramARMapConfig.next()).starResInfo;
        if (a(localResInfo)) {
          localArrayList.add(new BaseCheckHandler.ItemConfig(3, 12, localResInfo));
        }
      }
    }
    return localArrayList;
  }
  
  private void a(int paramInt, BaseCheckHandler.ItemConfig paramItemConfig)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander$Listener != null) {
        this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander$Listener.a(paramInt, paramItemConfig);
      }
      return;
    }
    finally
    {
      paramItemConfig = finally;
      throw paramItemConfig;
    }
  }
  
  int a()
  {
    return 3;
  }
  
  public String a()
  {
    return "StarConfigCheckHander";
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    if ((paramObject instanceof BaseCheckHandler.ItemConfig)) {}
    for (paramString2 = (BaseCheckHandler.ItemConfig)paramObject;; paramString2 = null)
    {
      if ((paramString2 != null) && (paramString2.jdField_a_of_type_Int == a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.d, 2, "starRes onDownloadFinish ,url:" + paramString1 + " errCode:" + paramInt);
        }
        a(paramInt, paramString2);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.postImmediately(new abmt(this, paramBoolean), null, true);
  }
  
  public boolean a(BaseCheckHandler.ItemConfig paramItemConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.d, 2, "checkItemConfig url:" + paramItemConfig.jdField_a_of_type_JavaLangString + ",md5:" + paramItemConfig.b);
    }
    if (new File(paramItemConfig.e).exists())
    {
      if (QLog.isColorLevel())
      {
        QLog.d(this.d, 2, "starRes checkItemConfig zipFile exist, unzip=" + true);
        return true;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.d, 2, "starRes checkItemConfig need download");
      }
      this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager.a(paramItemConfig.jdField_a_of_type_JavaLangString, paramItemConfig.b, "", false, 2, paramItemConfig);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.config.StarConfigCheckHander
 * JD-Core Version:    0.7.0.1
 */