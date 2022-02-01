package com.tencent.av.business.manager.material;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.BusinessManager;
import com.tencent.av.business.manager.pendant.ItemBase;
import com.tencent.av.business.processor.BaseConfigFileProcessor;
import com.tencent.av.business.processor.FaceConfigFileProcessor;
import com.tencent.av.business.processor.PendantConfigFileProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class EffectMaterialManager
  extends BusinessManager
{
  private HashMap<Integer, BaseConfigFileProcessor<? extends ItemBase>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  
  public EffectMaterialManager(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), new PendantConfigFileProcessor());
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), new FaceConfigFileProcessor());
    this.jdField_a_of_type_Boolean = true;
  }
  
  public BaseConfigFileProcessor<? extends ItemBase> a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      b();
    }
    BaseConfigFileProcessor localBaseConfigFileProcessor = (BaseConfigFileProcessor)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localBaseConfigFileProcessor == null) {
      QLog.e("EffectMaterialManager", 1, "getConfigFileProcessor: invalid processor");
    }
    return localBaseConfigFileProcessor;
  }
  
  protected void a()
  {
    b();
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.material.EffectMaterialManager
 * JD-Core Version:    0.7.0.1
 */