package com.tencent.biz.pubaccount.readinjoy.imageopt;

import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;

public class RIJImageOptMonitor
{
  public static void a()
  {
    Object localObject = ImageManager.a().a();
    if (localObject != null)
    {
      QLog.d("RIJImageOptMonitor", 1, "executing jobs size: " + ((CopyOnWriteArrayList)localObject).size());
      if (((CopyOnWriteArrayList)localObject).size() > 0)
      {
        localObject = ((CopyOnWriteArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          QLog.d("RIJImageOptMonitor", 1, new Object[] { (ImageRequest)((Iterator)localObject).next() });
        }
      }
    }
  }
  
  public static void a(ImageRequest paramImageRequest)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new RIJImageOptMonitor.1(paramImageRequest), RIJImageOptConfig.a.a());
  }
  
  public static String[] a(String paramString)
  {
    try
    {
      InetAddress[] arrayOfInetAddress = InetAddress.getAllByName(paramString);
      if ((arrayOfInetAddress != null) && (arrayOfInetAddress.length > 0))
      {
        String[] arrayOfString = new String[arrayOfInetAddress.length];
        int i = 0;
        for (;;)
        {
          paramString = arrayOfString;
          if (i >= arrayOfInetAddress.length) {
            break;
          }
          arrayOfString[i] = arrayOfInetAddress[i].getHostAddress();
          i += 1;
        }
        return paramString;
      }
    }
    catch (UnknownHostException paramString)
    {
      QLog.e("RIJImageOptMonitor", 1, paramString.getMessage());
      paramString = null;
    }
    return null;
  }
  
  public static void b(ImageRequest paramImageRequest)
  {
    ThreadManager.post(new RIJImageOptMonitor.2(paramImageRequest), 2, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptMonitor
 * JD-Core Version:    0.7.0.1
 */