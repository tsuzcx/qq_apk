package com.tencent.mobileqq.armap.config;

import android.text.TextUtils;
import android.util.Xml;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import org.xmlpull.v1.XmlPullParser;

public class POIModelConfig
{
  private static final String TAG = "POIModelConfig";
  public String animationPath = "";
  public String modelUrl = "";
  public String nodeId = "";
  public String particlePath = "";
  public String scenePath = "";
  
  public POIModelConfig() {}
  
  public POIModelConfig(String paramString1, String paramString2, String paramString3)
  {
    this.modelUrl = (paramString1 + "?md5=" + paramString2);
    paramString1 = "";
    paramString2 = "";
    Object localObject1 = "";
    Object localObject2 = paramString3 + File.separator + "model.config";
    Object localObject4 = localObject1;
    String str = paramString2;
    Object localObject3 = paramString1;
    label528:
    for (;;)
    {
      try
      {
        localXmlPullParser = Xml.newPullParser();
        localObject4 = localObject1;
        str = paramString2;
        localObject3 = paramString1;
        localXmlPullParser.setInput(new FileInputStream((String)localObject2), "UTF-8");
        localObject4 = localObject1;
        str = paramString2;
        localObject3 = paramString1;
        i = localXmlPullParser.getEventType();
        paramString1 = "";
        paramString2 = "";
        localObject1 = "";
        localObject2 = "";
      }
      catch (Exception localException1)
      {
        try
        {
          XmlPullParser localXmlPullParser;
          localObject3 = localXmlPullParser.getName();
          if ("poi".equals(localObject3))
          {
            localObject2 = localObject3;
            continue;
          }
          if (!"poi".equalsIgnoreCase((String)localObject2)) {
            break label528;
          }
          if ("nodeId".equalsIgnoreCase((String)localObject3))
          {
            this.nodeId = localXmlPullParser.nextText();
            continue;
          }
          if ("scene".equalsIgnoreCase((String)localObject3))
          {
            localObject3 = localXmlPullParser.nextText();
            localObject1 = localObject3;
            continue;
          }
          if ("animation".equalsIgnoreCase((String)localObject3))
          {
            localObject3 = localXmlPullParser.nextText();
            paramString2 = (String)localObject3;
            continue;
          }
          if (!"particle".equalsIgnoreCase((String)localObject3)) {
            break label528;
          }
          localObject3 = localXmlPullParser.nextText();
          paramString1 = (String)localObject3;
        }
        catch (Exception localException2)
        {
          continue;
        }
        localException1 = localException1;
        paramString1 = (String)localObject4;
        paramString2 = str;
        localObject1 = localObject3;
        localException1.printStackTrace();
        localObject3 = localObject1;
        str = paramString2;
        localObject4 = paramString1;
        this.scenePath = (paramString3 + File.separator + (String)localObject3);
        if (TextUtils.isEmpty(str)) {
          continue;
        }
        this.animationPath = (paramString3 + File.separator + str);
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          continue;
        }
        this.particlePath = (paramString3 + File.separator + (String)localObject4);
        return;
      }
      localObject4 = paramString1;
      str = paramString2;
      localObject3 = localObject1;
      int i = localXmlPullParser.next();
      break label477;
      continue;
      continue;
      label477:
      localObject4 = paramString1;
      str = paramString2;
      localObject3 = localObject1;
      if (i != 1) {
        switch (i)
        {
        }
      }
    }
  }
  
  public boolean isVaild()
  {
    boolean bool1 = true;
    if ((TextUtils.isEmpty(this.scenePath)) || (TextUtils.isEmpty(this.nodeId)) || (TextUtils.isEmpty(this.modelUrl)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("POIModelConfig", 2, "some path is null");
      }
      bool1 = false;
    }
    if (!new File(this.scenePath).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("POIModelConfig", 2, "scene not exists");
      }
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!TextUtils.isEmpty(this.animationPath))
    {
      bool2 = bool1;
      if (!new File(this.animationPath).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("POIModelConfig", 2, "anim not exists");
        }
        bool2 = false;
      }
    }
    if ((!TextUtils.isEmpty(this.particlePath)) && (!new File(this.particlePath).exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("POIModelConfig", 2, "particle not exists");
      }
      return false;
    }
    return bool2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("modelUrl:").append(this.modelUrl).append(",scenePath:").append(this.scenePath).append(",animPath:").append(this.animationPath).append(",nodeId:").append(this.nodeId).append(",particlePath:").append(this.particlePath);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.config.POIModelConfig
 * JD-Core Version:    0.7.0.1
 */