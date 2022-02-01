package com.tencent.mobileqq.antiphing;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;

public class AntiphishingUrlConfig
{
  private String a = "antiphishingConfig";
  private int b = 0;
  private ArrayList<String> c = null;
  private long d = 0L;
  private int e = 0;
  private boolean f = false;
  private int g = 1;
  private int h = 2;
  private String i = null;
  private Context j = null;
  private Handler k = new AntiphishingUrlConfig.1(this, Looper.getMainLooper());
  
  public static long c()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getAvailableBlocks() * l;
  }
  
  private String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    localStringBuilder.append("/Tencent/com/tencent/mobileqq/antiphishingconfig.xml");
    localStringBuilder.toString();
    return this.i;
  }
  
  public ArrayList<String> a()
  {
    if ((this.c == null) && (!this.f)) {
      b();
    }
    return this.c;
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Context paramContext)
  {
    if (paramInt <= this.b)
    {
      paramString1 = this.a;
      paramString2 = new StringBuilder();
      paramString2.append("nNewVersion:");
      paramString2.append(paramInt);
      paramString2.append("nLocalConfigVer:");
      paramString2.append(this.b);
      paramString2.append("Do not Need Update!");
      QLog.d(paramString1, 4, paramString2.toString());
      return;
    }
    if ((this.d != 0L) && (this.e == paramInt) && (System.currentTimeMillis() - this.d < 7200000L))
    {
      QLog.d(this.a, 1, "Config Updata, Frequence limited!");
      return;
    }
    this.d = System.currentTimeMillis();
    this.e = paramInt;
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("filehash:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("downloadurl:");
    localStringBuilder.append(paramString1);
    QLog.d(str, 1, localStringBuilder.toString());
    ThreadManager.post(new AntiphishingUrlConfig.2(this, paramContext, paramString1, paramString2), 5, null, true);
  }
  
  public void a(String paramString, Context paramContext)
  {
    this.i = paramString;
    this.j = paramContext;
  }
  
  public boolean b()
  {
    QLog.d(this.a, 2, "Parase Config!");
    Object localObject = d();
    if (localObject == null) {
      return false;
    }
    localObject = new File((String)localObject);
    SAXForHandler localSAXForHandler = new SAXForHandler();
    try
    {
      SAXParserFactory.newInstance().newSAXParser().parse(new InputSource(new InputStreamReader(new FileInputStream((File)localObject), "UTF-8")), localSAXForHandler);
      this.b = localSAXForHandler.a();
      this.c = localSAXForHandler.b();
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.antiphing.AntiphishingUrlConfig
 * JD-Core Version:    0.7.0.1
 */