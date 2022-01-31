package com.tencent.mobileqq.armap.config;

import abml;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConfigCheckHander
  extends BaseCheckHandler
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  ConfigCheckHander.Listener jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander$Listener;
  public List b;
  public boolean b;
  
  public ConfigCheckHander(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public static List a(ARMapConfig paramARMapConfig)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramARMapConfig == null) {
      return localArrayList;
    }
    if (a(paramARMapConfig.mapConfig)) {
      localArrayList.add(new BaseCheckHandler.ItemConfig(0, 0, paramARMapConfig.mapConfig));
    }
    if (a(paramARMapConfig.mapDaySkin)) {
      localArrayList.add(new BaseCheckHandler.ItemConfig(0, 1, paramARMapConfig.mapDaySkin));
    }
    if (a(paramARMapConfig.mapNightSkin)) {
      localArrayList.add(new BaseCheckHandler.ItemConfig(0, 2, paramARMapConfig.mapNightSkin));
    }
    if (a(paramARMapConfig.skySkin)) {
      localArrayList.add(new BaseCheckHandler.ItemConfig(0, 4, paramARMapConfig.skySkin));
    }
    if (a(paramARMapConfig.treeSkin)) {
      localArrayList.add(new BaseCheckHandler.ItemConfig(0, 3, paramARMapConfig.treeSkin));
    }
    if (a(paramARMapConfig.commonRes)) {
      localArrayList.add(new BaseCheckHandler.ItemConfig(0, 6, paramARMapConfig.commonRes));
    }
    if (a(paramARMapConfig.openBoxRes)) {
      localArrayList.add(new BaseCheckHandler.ItemConfig(0, 10, paramARMapConfig.openBoxRes));
    }
    if (localArrayList.size() < 7)
    {
      QLog.d("ConfigCheckHandler", 1, "checkItemList less than 9\n" + localArrayList);
      return null;
    }
    if (a(paramARMapConfig.bgMusic)) {
      localArrayList.add(new BaseCheckHandler.ItemConfig(0, 9, paramARMapConfig.bgMusic));
    }
    ARMapConfig.ResInfo localResInfo;
    if ((paramARMapConfig.wealthGodConfig != null) && (!TextUtils.isEmpty(paramARMapConfig.wealthGodConfig.resUrl)) && (!TextUtils.isEmpty(paramARMapConfig.wealthGodConfig.resMd5)))
    {
      localResInfo = new ARMapConfig.ResInfo();
      localResInfo.url = paramARMapConfig.wealthGodConfig.resUrl;
      localResInfo.md5 = paramARMapConfig.wealthGodConfig.resMd5;
      localArrayList.add(0, new BaseCheckHandler.ItemConfig(0, 11, localResInfo));
    }
    if ((paramARMapConfig.poiModels != null) && (!paramARMapConfig.poiModels.isEmpty()))
    {
      paramARMapConfig = paramARMapConfig.poiModels.iterator();
      while (paramARMapConfig.hasNext())
      {
        localResInfo = (ARMapConfig.ResInfo)paramARMapConfig.next();
        if (a(localResInfo))
        {
          BaseCheckHandler.ItemConfig localItemConfig = new BaseCheckHandler.ItemConfig(0, 7, localResInfo);
          localItemConfig.c = localResInfo.isPreload;
          localArrayList.add(localItemConfig);
        }
      }
    }
    return localArrayList;
  }
  
  private void a(int paramInt)
  {
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Int += paramInt;
      if (this.jdField_a_of_type_Int >= 100) {
        this.jdField_a_of_type_Int = 99;
      }
      if (this.jdField_a_of_type_Int < 0) {
        this.jdField_a_of_type_Int = 0;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander$Listener == null);
    this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander$Listener.a(this.jdField_a_of_type_Int);
  }
  
  /* Error */
  private void b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 17	com/tencent/mobileqq/armap/config/ConfigCheckHander:jdField_b_of_type_Boolean	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 164	com/tencent/mobileqq/armap/config/ConfigCheckHander:jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos	Lcom/tencent/mobileqq/armap/config/BaseCheckHandler$ExistsDirInfos;
    //   18: ifnull +11 -> 29
    //   21: aload_0
    //   22: aload_0
    //   23: getfield 164	com/tencent/mobileqq/armap/config/ConfigCheckHander:jdField_a_of_type_ComTencentMobileqqArmapConfigBaseCheckHandler$ExistsDirInfos	Lcom/tencent/mobileqq/armap/config/BaseCheckHandler$ExistsDirInfos;
    //   26: invokevirtual 167	com/tencent/mobileqq/armap/config/ConfigCheckHander:a	(Lcom/tencent/mobileqq/armap/config/BaseCheckHandler$ExistsDirInfos;)V
    //   29: aload_0
    //   30: getfield 154	com/tencent/mobileqq/armap/config/ConfigCheckHander:jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander$Listener	Lcom/tencent/mobileqq/armap/config/ConfigCheckHander$Listener;
    //   33: ifnull +17 -> 50
    //   36: aload_0
    //   37: getfield 154	com/tencent/mobileqq/armap/config/ConfigCheckHander:jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander$Listener	Lcom/tencent/mobileqq/armap/config/ConfigCheckHander$Listener;
    //   40: iload_1
    //   41: aload_0
    //   42: getfield 169	com/tencent/mobileqq/armap/config/ConfigCheckHander:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   45: invokeinterface 172 3 0
    //   50: aload_0
    //   51: iconst_0
    //   52: invokevirtual 175	com/tencent/mobileqq/armap/config/ConfigCheckHander:a	(Z)V
    //   55: goto -44 -> 11
    //   58: astore_3
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_3
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	ConfigCheckHander
    //   0	63	1	paramInt	int
    //   6	2	2	bool	boolean
    //   58	4	3	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	7	58	finally
    //   14	29	58	finally
    //   29	50	58	finally
    //   50	55	58	finally
  }
  
  private void b(BaseCheckHandler.ItemConfig paramItemConfig)
  {
    try
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        BaseCheckHandler.ItemConfig localItemConfig = (BaseCheckHandler.ItemConfig)localIterator.next();
        if (localItemConfig.b.equalsIgnoreCase(paramItemConfig.b)) {
          localItemConfig.a = true;
        }
      }
      paramItemConfig = this.jdField_b_of_type_JavaUtilList.iterator();
    }
    finally {}
    do
    {
      if (!paramItemConfig.hasNext()) {
        break;
      }
    } while (((BaseCheckHandler.ItemConfig)paramItemConfig.next()).a);
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.d, 2, "markItemConfigChecked all config check finished ");
        }
        a(10);
        b(0);
      }
      for (;;)
      {
        return;
        a(10);
      }
    }
  }
  
  int a()
  {
    return 0;
  }
  
  public String a()
  {
    return "ConfigCheckHander";
  }
  
  protected void a(BaseCheckHandler.ItemConfig paramItemConfig, int paramInt)
  {
    super.a(paramItemConfig, paramInt);
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty()) || (!this.jdField_b_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.d, 2, "onItemCheckFinished return");
      }
      b(1);
      return;
    }
    if (paramInt == 0)
    {
      b(paramItemConfig);
      return;
    }
    b(paramInt);
  }
  
  public void a(ConfigCheckHander.Listener paramListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander$Listener = paramListener;
  }
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +30 -> 35
    //   8: aload_0
    //   9: getfield 191	com/tencent/mobileqq/armap/config/ConfigCheckHander:d	Ljava/lang/String;
    //   12: iconst_2
    //   13: new 72	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   20: ldc 206
    //   22: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload_1
    //   26: invokevirtual 209	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: iload_1
    //   37: putfield 17	com/tencent/mobileqq/armap/config/ConfigCheckHander:jdField_b_of_type_Boolean	Z
    //   40: iload_1
    //   41: ifeq +13 -> 54
    //   44: aload_0
    //   45: invokestatic 215	java/lang/System:currentTimeMillis	()J
    //   48: putfield 217	com/tencent/mobileqq/armap/config/ConfigCheckHander:jdField_a_of_type_Long	J
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: invokestatic 215	java/lang/System:currentTimeMillis	()J
    //   57: lstore_2
    //   58: aload_0
    //   59: getfield 217	com/tencent/mobileqq/armap/config/ConfigCheckHander:jdField_a_of_type_Long	J
    //   62: lstore 4
    //   64: aload_0
    //   65: getfield 191	com/tencent/mobileqq/armap/config/ConfigCheckHander:d	Ljava/lang/String;
    //   68: iconst_1
    //   69: ldc 219
    //   71: iconst_1
    //   72: anewarray 221	java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: lload_2
    //   78: lload 4
    //   80: lsub
    //   81: invokestatic 227	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   84: aastore
    //   85: invokestatic 231	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   88: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: goto -40 -> 51
    //   94: astore 6
    //   96: aload_0
    //   97: monitorexit
    //   98: aload 6
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	ConfigCheckHander
    //   0	101	1	paramBoolean	boolean
    //   57	21	2	l1	long
    //   62	17	4	l2	long
    //   94	5	6	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	35	94	finally
    //   35	40	94	finally
    //   44	51	94	finally
    //   54	91	94	finally
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b(boolean paramBoolean)
  {
    ThreadManager.postImmediately(new abml(this, paramBoolean), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.config.ConfigCheckHander
 * JD-Core Version:    0.7.0.1
 */