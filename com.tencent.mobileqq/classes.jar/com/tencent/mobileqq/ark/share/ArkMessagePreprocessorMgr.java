package com.tencent.mobileqq.ark.share;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class ArkMessagePreprocessorMgr
{
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<String, IArkMessagePreprocessor> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public ArkMessagePreprocessorMgr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public IArkMessagePreprocessor a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkMessagePreprocessorMgr", 2, "AAShare.getPreprocessor in valid param");
      }
      return null;
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      paramString = (IArkMessagePreprocessor)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      return paramString;
    }
  }
  
  public void a(String paramString, IArkMessagePreprocessor paramIArkMessagePreprocessor)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramIArkMessagePreprocessor == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkMessagePreprocessorMgr", 2, "AAShare.setPreprocessor in valid param");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ArkApp.ArkMessagePreprocessorMgr", 2, new Object[] { "AAShare.setPreprocessor app=", paramString });
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramIArkMessagePreprocessor);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.share.ArkMessagePreprocessorMgr
 * JD-Core Version:    0.7.0.1
 */