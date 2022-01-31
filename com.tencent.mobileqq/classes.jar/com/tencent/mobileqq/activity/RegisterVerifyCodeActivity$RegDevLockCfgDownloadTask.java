package com.tencent.mobileqq.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class RegisterVerifyCodeActivity$RegDevLockCfgDownloadTask
  extends AsyncTask
{
  WeakReference a = null;
  
  public RegisterVerifyCodeActivity$RegDevLockCfgDownloadTask(RegisterVerifyCodeActivity paramRegisterVerifyCodeActivity)
  {
    this.a = new WeakReference(paramRegisterVerifyCodeActivity);
  }
  
  protected Void a(Void... paramVarArgs)
  {
    boolean bool3 = true;
    File localFile = new File(BaseApplication.getContext().getFilesDir(), "RegDevLockCfg.xml");
    if (!HttpDownloadUtil.a(null, "http://dldir1.qq.com/qqfile/qd/RegDevLockCfg.xml?mType=ConfigCheck", localFile))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RegisterVerifyCodeActivity", 2, "download cfg file failed.");
      }
      return null;
    }
    paramVarArgs = DocumentBuilderFactory.newInstance();
    label534:
    label540:
    label546:
    label552:
    label557:
    label563:
    label568:
    label573:
    for (;;)
    {
      try
      {
        localObject3 = paramVarArgs.newDocumentBuilder().parse(localFile).getDocumentElement();
        paramVarArgs = ((Element)localObject3).getElementsByTagName("Enable");
        if (paramVarArgs.getLength() <= 0) {
          break label563;
        }
        if (Integer.parseInt(((Text)((Element)paramVarArgs.item(0)).getChildNodes().item(0)).getNodeValue()) == 1)
        {
          bool1 = true;
          break label568;
          paramVarArgs = ((Element)localObject3).getElementsByTagName("EnableVersion");
          if (paramVarArgs.getLength() <= 0) {
            break label557;
          }
          paramVarArgs = ((Text)((Element)paramVarArgs.item(0)).getChildNodes().item(0)).getNodeValue();
          localObject1 = ((Element)localObject3).getElementsByTagName("CheckBoxDefStatus");
          if (((NodeList)localObject1).getLength() <= 0) {
            break label552;
          }
          if (Integer.parseInt(((Text)((Element)((NodeList)localObject1).item(0)).getChildNodes().item(0)).getNodeValue()) == 1)
          {
            bool1 = bool3;
            break label573;
            localObject1 = ((Element)localObject3).getElementsByTagName("CheckBoxWording");
            if (((NodeList)localObject1).getLength() <= 0) {
              break label546;
            }
            localObject1 = ((Text)((Element)((NodeList)localObject1).item(0)).getChildNodes().item(0)).getNodeValue();
            localObject2 = ((Element)localObject3).getElementsByTagName("CheckBoxHighlightWording");
            if (((NodeList)localObject2).getLength() <= 0) {
              break label540;
            }
            localObject2 = ((Text)((Element)((NodeList)localObject2).item(0)).getChildNodes().item(0)).getNodeValue();
            localObject3 = ((Element)localObject3).getElementsByTagName("IntroductionURL");
            if (((NodeList)localObject3).getLength() <= 0) {
              break label534;
            }
            localObject3 = ((Text)((Element)((NodeList)localObject3).item(0)).getChildNodes().item(0)).getNodeValue();
            Bundle localBundle = new Bundle();
            localBundle.putBoolean("visibility", bool2);
            localBundle.putString("enableVersion", paramVarArgs);
            localBundle.putBoolean("checked", bool1);
            localBundle.putString("openDevLockText", (String)localObject1);
            localBundle.putString("openDevLockHelpText", (String)localObject2);
            localBundle.putString("openDevLockHelpURL", (String)localObject3);
            paramVarArgs = (RegisterVerifyCodeActivity)this.a.get();
            if (paramVarArgs != null) {
              paramVarArgs.a(localBundle);
            }
            return null;
          }
        }
        else
        {
          bool1 = false;
          break label568;
        }
        bool1 = false;
      }
      catch (Exception paramVarArgs)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RegisterVerifyCodeActivity", 2, "parse cfg file failed.");
        }
        paramVarArgs.printStackTrace();
        return null;
      }
      finally
      {
        localFile.delete();
      }
      Object localObject3 = null;
      continue;
      Object localObject2 = null;
      continue;
      Object localObject1 = null;
      continue;
      boolean bool1 = false;
      continue;
      paramVarArgs = "";
      continue;
      boolean bool2 = false;
      continue;
      bool2 = bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterVerifyCodeActivity.RegDevLockCfgDownloadTask
 * JD-Core Version:    0.7.0.1
 */