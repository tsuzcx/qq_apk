package com.tencent.biz.qqcircle.flutter.animation.unzip;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class QCircleFlutterZipFileFactory
{
  private static volatile QCircleFlutterZipFileFactory a;
  private Map<String, QCircleFlutterZipFileFactory.OnZipFileListener> b = null;
  
  public static QCircleFlutterZipFileFactory a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QCircleFlutterZipFileFactory();
        }
      }
      finally {}
    }
    return a;
  }
  
  private List<File> a(File paramFile)
  {
    LinkedList localLinkedList = new LinkedList();
    if ((paramFile.exists()) && (paramFile.isDirectory()))
    {
      paramFile = paramFile.listFiles(new QCircleFlutterZipFileFactory.3(this));
      if (paramFile == null) {
        return localLinkedList;
      }
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = paramFile[i];
        if (localFile.exists()) {
          if (localFile.isDirectory()) {
            localLinkedList.addAll(a(localFile));
          } else {
            localLinkedList.add(localFile);
          }
        }
        i += 1;
      }
    }
    return localLinkedList;
  }
  
  private void a(QCircleFlutterZipOption paramQCircleFlutterZipOption, String[] paramArrayOfString)
  {
    RFThreadManager.getUIHandler().post(new QCircleFlutterZipFileFactory.2(this, paramQCircleFlutterZipOption, paramArrayOfString));
  }
  
  public void a(QCircleFlutterZipOption paramQCircleFlutterZipOption, QCircleFlutterZipFileFactory.OnZipFileListener paramOnZipFileListener)
  {
    String str = paramQCircleFlutterZipOption.b();
    if (TextUtils.isEmpty(str))
    {
      QLog.d("QCircleFlutterZipFileFactory", 2, "[zip] current zip file path is empty.");
      return;
    }
    this.b.put(str, paramOnZipFileListener);
    RFThreadManager.execute(new QCircleFlutterZipFileFactory.1(this, paramQCircleFlutterZipOption));
  }
  
  public String[] a(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      QLog.i("QCircleFlutterZipFileFactory", 2, "[getListFilePath] exist Animation Pic!");
      paramString = a(paramString);
      if (paramString.size() > 0)
      {
        paramString = (File[])paramString.toArray(new File[0]);
        if ((paramString != null) && (paramString.length > 0))
        {
          Arrays.sort(paramString, new QCircleFlutterZipFileFactory.4(this));
          ArrayList localArrayList = new ArrayList();
          int j = paramString.length;
          int i = 0;
          while (i < j)
          {
            localArrayList.add(paramString[i].getPath());
            i += 1;
          }
          return (String[])localArrayList.toArray(new String[0]);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.animation.unzip.QCircleFlutterZipFileFactory
 * JD-Core Version:    0.7.0.1
 */