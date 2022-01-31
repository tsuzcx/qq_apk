package com.tencent.mobileqq.armap.config;

import aaym;
import aayn;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class POICheckHander
  extends BaseCheckHandler
{
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aaym(this);
  POICheckHander.Listener jdField_a_of_type_ComTencentMobileqqArmapConfigPOICheckHander$Listener;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this.jdField_a_of_type_AndroidOsHandler$Callback);
  public List b = new ArrayList();
  
  public POICheckHander(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void b(BaseCheckHandler.ItemConfig paramItemConfig, int paramInt)
  {
    if (paramItemConfig == null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.d, 2, "notifyResult itemConfig is null");
      }
      return;
    }
    finally {}
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigPOICheckHander$Listener != null)
    {
      if (paramItemConfig.jdField_b_of_type_Int != 7) {
        break label209;
      }
      if (paramInt == 0)
      {
        localObject1 = new POIModelConfig(paramItemConfig.jdField_a_of_type_JavaLangString, paramItemConfig.jdField_b_of_type_JavaLangString, paramItemConfig.c);
        this.jdField_a_of_type_ComTencentMobileqqArmapConfigPOICheckHander$Listener.a((POIModelConfig)localObject1, ((Long)paramItemConfig.jdField_a_of_type_JavaLangObject).longValue());
        if (QLog.isColorLevel()) {
          QLog.d(this.d, 2, "notifyResult POIModel:" + localObject1);
        }
      }
    }
    label209:
    while ((paramItemConfig.jdField_b_of_type_Int != 8) || (paramInt != 0))
    {
      paramItemConfig = paramItemConfig.jdField_a_of_type_JavaLangString + "?md5=" + paramItemConfig.jdField_b_of_type_JavaLangString;
      this.b.remove(paramItemConfig);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.d, 2, "remove key:" + paramItemConfig + " ,errorCode:" + paramInt);
      break;
    }
    Pair localPair = (Pair)paramItemConfig.jdField_a_of_type_JavaLangObject;
    Object localObject1 = new File(paramItemConfig.c, "logo.png");
    Object localObject2 = new File(paramItemConfig.c, "2d.png");
    if (((File)localObject1).exists()) {}
    for (localObject1 = ((File)localObject1).getAbsolutePath();; localObject1 = "")
    {
      if (((File)localObject2).exists()) {}
      for (localObject2 = ((File)localObject2).getAbsolutePath();; localObject2 = "")
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.d, 2, "onPOICheckResult logoPath:" + (String)localObject1 + " far2dPath:" + (String)localObject2);
        }
        this.jdField_a_of_type_ComTencentMobileqqArmapConfigPOICheckHander$Listener.a((String)localObject1, (String)localObject2, (String)localPair.first, ((Long)localPair.second).longValue());
        break;
      }
    }
  }
  
  int a()
  {
    return 1;
  }
  
  public String a()
  {
    return "POICheckHander";
  }
  
  public void a()
  {
    this.b.clear();
  }
  
  protected void a(BaseCheckHandler.ItemConfig paramItemConfig, int paramInt)
  {
    super.a(paramItemConfig, paramInt);
    b(paramItemConfig, paramInt);
  }
  
  public void a(POICheckHander.Listener paramListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapConfigPOICheckHander$Listener = paramListener;
  }
  
  public void a(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.d(this.d, 2, "modelUrl is empty");
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(0, new Object[] { paramString, Long.valueOf(paramLong) }).sendToTarget();
  }
  
  public void b(BaseCheckHandler.ItemConfig paramItemConfig)
  {
    ThreadManager.postImmediately(new aayn(this, paramItemConfig), null, false);
  }
  
  public void b(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.d(this.d, 2, "logoUrl is empty");
    }
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = paramString;
    arrayOfObject[1] = Long.valueOf(paramLong);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1, arrayOfObject).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.config.POICheckHander
 * JD-Core Version:    0.7.0.1
 */