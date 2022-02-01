package com.tencent.mobileqq.ar.arengine;

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
    long l = this.b;
    if (l == 0L) {
      return this.jdField_a_of_type_Int;
    }
    return Math.max((int)(paramLong * 100L / l), this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    ARResourceDownload localARResourceDownload = this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload;
    if (localARResourceDownload != null) {
      localARResourceDownload.a();
    }
  }
  
  public void a(ArrayList<ARResourceDownload.DownloadInfo> paramArrayList, ARResourceManagerTools.ARResourceCallback paramARResourceCallback)
  {
    QLog.i("AREngine_ARResourceManagerTools", 1, "startDowdLoad");
    this.b = 0L;
    this.jdField_a_of_type_Long = 0L;
    int i = 0;
    this.jdField_a_of_type_Int = 0;
    if (paramArrayList.size() < 1) {
      return;
    }
    Object localObject1 = paramArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ARResourceDownload.DownloadInfo)((Iterator)localObject1).next();
      this.b = Math.max(this.b, ((ARResourceDownload.DownloadInfo)localObject2).jdField_a_of_type_Long);
    }
    if (paramARResourceCallback != null) {
      paramARResourceCallback.a();
    }
    localObject1 = (ArrayList)paramArrayList.clone();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("startDowdLoad size is ");
    ((StringBuilder)localObject2).append(((ArrayList)localObject1).size());
    QLog.i("AREngine_ARResourceManagerTools", 1, ((StringBuilder)localObject2).toString());
    while (i < paramArrayList.size())
    {
      if (((ARResourceDownload.DownloadInfo)paramArrayList.get(i)).jdField_a_of_type_Int != 4)
      {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload.a((ARResourceDownload.DownloadInfo)paramArrayList.get(i), new ARResourceManagerTools.1(this, paramARResourceCallback, paramArrayList, (ArrayList)localObject1));
      }
      else if (((ARResourceDownload.DownloadInfo)paramArrayList.get(i)).jdField_a_of_type_Int == 4)
      {
        HtmlOffline.a();
        localObject2 = (ARResourceDownload.DownloadInfo)paramArrayList.get(i);
        HtmlOffline.a(((ARResourceDownload.DownloadInfo)paramArrayList.get(i)).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentCommonAppAppInterface, new ARResourceManagerTools.2(this, paramARResourceCallback, (ArrayList)localObject1, (ARResourceDownload.DownloadInfo)localObject2), true, 0, true);
      }
      i += 1;
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
    ARResourceDownload localARResourceDownload = this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceDownload;
    if (localARResourceDownload != null) {
      localARResourceDownload.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARResourceManagerTools
 * JD-Core Version:    0.7.0.1
 */