package com.tencent.mobileqq.ar.arengine;

import aadn;
import aado;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ARResourceManagerTools
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ARResourceDownload jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload;
  Object jdField_a_of_type_JavaLangObject = new Object();
  long b;
  
  public ARResourceManagerTools(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload = new ARResourceDownload(paramAppInterface);
  }
  
  private int a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_Long = Math.max(paramLong, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Int = Math.max(paramInt, this.jdField_a_of_type_Int);
    if (this.b == 0L) {
      return this.jdField_a_of_type_Int;
    }
    return Math.max((int)(100L * paramLong / this.b), this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload.a();
    }
  }
  
  public void a(ArrayList paramArrayList, ARResourceManagerTools.ARResourceCallback paramARResourceCallback)
  {
    QLog.i("AREngine_ARResourceManagerTools", 1, "startDowdLoad");
    this.b = 0L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    if (paramArrayList.size() < 1) {
      return;
    }
    Object localObject = paramArrayList.iterator();
    ARResourceDownload.DownloadInfo localDownloadInfo;
    while (((Iterator)localObject).hasNext())
    {
      localDownloadInfo = (ARResourceDownload.DownloadInfo)((Iterator)localObject).next();
      this.b = Math.max(this.b, localDownloadInfo.jdField_a_of_type_Long);
    }
    if (paramARResourceCallback != null) {
      paramARResourceCallback.a();
    }
    localObject = (ArrayList)paramArrayList.clone();
    int i = 0;
    label100:
    if (i < paramArrayList.size())
    {
      if (((ARResourceDownload.DownloadInfo)paramArrayList.get(i)).jdField_a_of_type_Int == 4) {
        break label158;
      }
      this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload.a((ARResourceDownload.DownloadInfo)paramArrayList.get(i), new aadn(this, paramARResourceCallback, paramArrayList, (ArrayList)localObject));
    }
    for (;;)
    {
      i += 1;
      break label100;
      break;
      label158:
      if (((ARResourceDownload.DownloadInfo)paramArrayList.get(i)).jdField_a_of_type_Int == 4)
      {
        HtmlOffline.a();
        localDownloadInfo = (ARResourceDownload.DownloadInfo)paramArrayList.get(i);
        HtmlOffline.a(((ARResourceDownload.DownloadInfo)paramArrayList.get(i)).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentCommonAppAppInterface, new aado(this, paramARResourceCallback, (ArrayList)localObject, localDownloadInfo), true, 0, true);
      }
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      a();
      return;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARResourceManagerTools
 * JD-Core Version:    0.7.0.1
 */