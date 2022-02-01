package com.tencent.apkupdate.logic.protocol.a;

import android.os.Message;
import com.qq.taf.jce.JceStruct;
import com.tencent.apkupdate.b.b;
import com.tencent.apkupdate.b.i;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.apkupdate.logic.protocol.BaseHttpRequest;
import com.tencent.apkupdate.logic.protocol.jce.ApkDownUrl;
import com.tencent.apkupdate.logic.protocol.jce.AppInfoForUpdate;
import com.tencent.apkupdate.logic.protocol.jce.AppUpdateInfo;
import com.tencent.apkupdate.logic.protocol.jce.GetAppUpdateRequest;
import com.tencent.apkupdate.logic.protocol.jce.GetAppUpdateResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
  extends BaseHttpRequest
{
  private static String a = "CheckAppUpdateHttpRequest";
  private final List b;
  
  public a(List paramList)
  {
    this.b = paramList;
  }
  
  private static ApkUpdateDetail a(AppUpdateInfo paramAppUpdateInfo)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    if (paramAppUpdateInfo != null)
    {
      ApkUpdateDetail localApkUpdateDetail = new ApkUpdateDetail();
      localApkUpdateDetail.packageName = paramAppUpdateInfo.packageName;
      localApkUpdateDetail.versionname = paramAppUpdateInfo.versionName;
      localApkUpdateDetail.versioncode = paramAppUpdateInfo.versionCode;
      Object localObject4 = paramAppUpdateInfo.apkDownUrl;
      if ((localObject4 != null) && (((ArrayList)localObject4).size() > 0))
      {
        localObject1 = ((ArrayList)localObject4).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ApkDownUrl)((Iterator)localObject1).next();
          if ((localObject2 != null) && (((ApkDownUrl)localObject2).type == 2))
          {
            if (((ApkDownUrl)localObject2).urlList != null) {
              localObject1 = (String)((ApkDownUrl)localObject2).urlList.get(0);
            } else {
              localObject1 = "";
            }
            i = 1;
            localObject2 = localObject1;
            break label137;
          }
        }
      }
      Object localObject2 = null;
      int i = 0;
      label137:
      localObject1 = localObject3;
      if (i == 0)
      {
        localObject1 = localObject3;
        if (localObject4 != null)
        {
          localObject1 = localObject3;
          if (((ArrayList)localObject4).size() > 0)
          {
            localObject4 = ((ArrayList)localObject4).iterator();
            do
            {
              localObject1 = localObject3;
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              localObject1 = (ApkDownUrl)((Iterator)localObject4).next();
            } while ((localObject1 == null) || (((ApkDownUrl)localObject1).type != 1));
            if (((ApkDownUrl)localObject1).urlList != null) {
              localObject1 = (String)((ApkDownUrl)localObject1).urlList.get(0);
            } else {
              localObject1 = "";
            }
          }
        }
      }
      if (i != 0)
      {
        localApkUpdateDetail.updatemethod = 4;
        localApkUpdateDetail.url = ((String)localObject2);
      }
      else
      {
        localApkUpdateDetail.updatemethod = 2;
        localApkUpdateDetail.url = ((String)localObject1);
      }
      localApkUpdateDetail.newapksize = ((int)paramAppUpdateInfo.fileSize);
      localApkUpdateDetail.patchsize = ((int)paramAppUpdateInfo.diffFileSize);
      localApkUpdateDetail.fileMd5 = paramAppUpdateInfo.diffApkMd5;
      localApkUpdateDetail.sigMd5 = paramAppUpdateInfo.signatureMd5;
      localApkUpdateDetail.newFeature = paramAppUpdateInfo.newFeature;
      localObject1 = localApkUpdateDetail;
    }
    return localObject1;
  }
  
  protected final void onDataReceiveFailed()
  {
    Message localMessage = com.tencent.apkupdate.logic.a.a().obtainMessage();
    localMessage.what = 2;
    localMessage.sendToTarget();
  }
  
  protected final void onFinished(JceStruct paramJceStruct1, JceStruct paramJceStruct2)
  {
    if ((paramJceStruct2 != null) && ((paramJceStruct2 instanceof GetAppUpdateResponse)))
    {
      Object localObject2 = (GetAppUpdateResponse)paramJceStruct2;
      paramJceStruct1 = new StringBuffer("CheckAppUpdateHttpRequest:checkupdate from server; response=  [");
      paramJceStruct2 = new StringBuilder("ret=");
      paramJceStruct2.append(((GetAppUpdateResponse)localObject2).ret);
      paramJceStruct2.append("| ");
      paramJceStruct1.append(paramJceStruct2.toString());
      if (((GetAppUpdateResponse)localObject2).ret == 0)
      {
        Object localObject1 = new ArrayList();
        paramJceStruct2 = new ArrayList();
        localObject2 = ((GetAppUpdateResponse)localObject2).appUpdateInfoGroup;
        Object localObject4;
        int j;
        int i;
        Object localObject5;
        Object localObject6;
        if ((localObject2 != null) && (((Map)localObject2).size() > 0))
        {
          localObject2 = ((Map)localObject2).values();
          if ((localObject2 != null) && (((Collection)localObject2).size() > 0))
          {
            localObject2 = ((Collection)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (ArrayList)((Iterator)localObject2).next();
              if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
              {
                localObject3 = ((ArrayList)localObject3).iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (AppUpdateInfo)((Iterator)localObject3).next();
                  j = ((AppUpdateInfo)localObject4).flag & 0x1;
                  if (j == 1) {
                    i = 1;
                  } else {
                    i = 0;
                  }
                  if (i != 0) {
                    paramJceStruct2.add(localObject4);
                  }
                  localObject5 = new StringBuilder("pkgname=");
                  ((StringBuilder)localObject5).append(((AppUpdateInfo)localObject4).packageName);
                  ((StringBuilder)localObject5).append(";versionCode=");
                  ((StringBuilder)localObject5).append(((AppUpdateInfo)localObject4).versionCode);
                  ((StringBuilder)localObject5).append(";uploadFlag=");
                  boolean bool;
                  if (j == 1) {
                    bool = true;
                  } else {
                    bool = false;
                  }
                  ((StringBuilder)localObject5).append(bool);
                  ((StringBuilder)localObject5).append("| \n\r");
                  paramJceStruct1.append(((StringBuilder)localObject5).toString());
                  localObject4 = a((AppUpdateInfo)localObject4);
                  if (localObject4 != null)
                  {
                    localObject5 = com.tencent.apkupdate.logic.protocol.a.a().b(((ApkUpdateDetail)localObject4).packageName);
                    if ((b.a().b() != null) && (b.a(b.a().b(), ((ApkUpdateDetail)localObject4).packageName) == ((ApkUpdateDetail)localObject4).versioncode)) {
                      i = 1;
                    } else {
                      i = 0;
                    }
                    if ((((String)localObject5).compareToIgnoreCase(((ApkUpdateDetail)localObject4).sigMd5) != 0) || (i != 0)) {
                      ((ApkUpdateDetail)localObject4).updatemethod = 1;
                    }
                    localObject5 = a;
                    localObject6 = new StringBuilder("packageName: ");
                    ((StringBuilder)localObject6).append(((ApkUpdateDetail)localObject4).packageName);
                    i.a((String)localObject5, ((StringBuilder)localObject6).toString());
                    localObject5 = a;
                    localObject6 = new StringBuilder("updatemethod: ");
                    ((StringBuilder)localObject6).append(((ApkUpdateDetail)localObject4).updatemethod);
                    i.a((String)localObject5, ((StringBuilder)localObject6).toString());
                    localObject5 = a;
                    localObject6 = new StringBuilder("newapksize: ");
                    ((StringBuilder)localObject6).append(((ApkUpdateDetail)localObject4).newapksize);
                    i.a((String)localObject5, ((StringBuilder)localObject6).toString());
                    localObject5 = a;
                    localObject6 = new StringBuilder("patchsize: ");
                    ((StringBuilder)localObject6).append(((ApkUpdateDetail)localObject4).patchsize);
                    i.a((String)localObject5, ((StringBuilder)localObject6).toString());
                    localObject5 = a;
                    localObject6 = new StringBuilder("url: ");
                    ((StringBuilder)localObject6).append(((ApkUpdateDetail)localObject4).url);
                    i.a((String)localObject5, ((StringBuilder)localObject6).toString());
                    ((ArrayList)localObject1).add(localObject4);
                  }
                }
              }
            }
          }
        }
        localObject2 = a;
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramJceStruct1.toString());
        ((StringBuilder)localObject3).append("]");
        i.a((String)localObject2, ((StringBuilder)localObject3).toString());
        localObject2 = new ArrayList();
        paramJceStruct1 = this.b;
        if (paramJceStruct1 != null)
        {
          localObject3 = paramJceStruct1.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            paramJceStruct1 = (AppInfoForUpdate)((Iterator)localObject3).next();
            localObject4 = paramJceStruct1.packageName;
            j = paramJceStruct1.versionCode;
            localObject5 = paramJceStruct1.versionName;
            localObject6 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject6).hasNext())
            {
              paramJceStruct1 = (ApkUpdateDetail)((Iterator)localObject6).next();
              String str = paramJceStruct1.packageName;
              if ((localObject4 != null) && (str != null) && (((String)localObject4).equals(str)))
              {
                i = 1;
                break label782;
              }
            }
            i = 0;
            paramJceStruct1 = null;
            label782:
            if (i != 0)
            {
              ((ArrayList)localObject2).add(paramJceStruct1);
            }
            else
            {
              paramJceStruct1 = new ApkUpdateDetail();
              paramJceStruct1.packageName = ((String)localObject4);
              paramJceStruct1.versionname = ((String)localObject5);
              paramJceStruct1.versioncode = j;
              paramJceStruct1.updatemethod = 1;
              ((ArrayList)localObject2).add(paramJceStruct1);
            }
          }
        }
        paramJceStruct1 = new StringBuffer("CheckAppUpdateHttpRequest:checkupdate from server; returnSuceessList response= [");
        localObject1 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (ApkUpdateDetail)((Iterator)localObject1).next();
          localObject4 = new StringBuilder("pkgname=");
          ((StringBuilder)localObject4).append(((ApkUpdateDetail)localObject3).packageName);
          ((StringBuilder)localObject4).append(";versionCode=");
          ((StringBuilder)localObject4).append(((ApkUpdateDetail)localObject3).versioncode);
          ((StringBuilder)localObject4).append("| \n\r");
          paramJceStruct1.append(((StringBuilder)localObject4).toString());
        }
        localObject1 = a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramJceStruct1.toString());
        ((StringBuilder)localObject3).append("]");
        i.a((String)localObject1, ((StringBuilder)localObject3).toString());
        paramJceStruct1 = com.tencent.apkupdate.logic.a.a().obtainMessage();
        paramJceStruct1.what = 1;
        paramJceStruct1.obj = localObject2;
        paramJceStruct1.sendToTarget();
        paramJceStruct1 = new StringBuffer("CheckAppUpdateHttpRequest:NeedUpdateApk from server; needUpdateApkInfos response= [");
        localObject1 = paramJceStruct2.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (AppUpdateInfo)((Iterator)localObject1).next();
          localObject3 = new StringBuilder("pkgname=");
          ((StringBuilder)localObject3).append(((AppUpdateInfo)localObject2).packageName);
          ((StringBuilder)localObject3).append(";versionCode=");
          ((StringBuilder)localObject3).append(((AppUpdateInfo)localObject2).versionCode);
          ((StringBuilder)localObject3).append(";grayVersionCode=");
          ((StringBuilder)localObject3).append(((AppUpdateInfo)localObject2).grayVersionCode);
          ((StringBuilder)localObject3).append("| \n\r");
          paramJceStruct1.append(((StringBuilder)localObject3).toString());
        }
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramJceStruct1.toString());
        ((StringBuilder)localObject2).append("]");
        i.a((String)localObject1, ((StringBuilder)localObject2).toString());
        if (paramJceStruct2.size() > 0)
        {
          paramJceStruct1 = com.tencent.apkupdate.logic.a.a().obtainMessage();
          paramJceStruct1.what = 7;
          paramJceStruct1.obj = paramJceStruct2;
          paramJceStruct1.sendToTarget();
        }
        return;
      }
      onDataReceiveFailed();
      return;
    }
  }
  
  protected final void prepareData()
  {
    super.prepareData();
    if (this.b != null)
    {
      GetAppUpdateRequest localGetAppUpdateRequest = new GetAppUpdateRequest();
      localGetAppUpdateRequest.appInfoForUpdateList = ((ArrayList)this.b);
      localGetAppUpdateRequest.flag = 0;
      StringBuffer localStringBuffer = new StringBuffer("CheckAppUpdateHttpRequest:prepareData to server; appInfoForUpdateList= [");
      Object localObject1 = this.b.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AppInfoForUpdate)((Iterator)localObject1).next();
        StringBuilder localStringBuilder = new StringBuilder("pkgname=");
        localStringBuilder.append(((AppInfoForUpdate)localObject2).packageName);
        localStringBuilder.append(";versionCode=");
        localStringBuilder.append(((AppInfoForUpdate)localObject2).versionCode);
        localStringBuilder.append(";targetVersionCode=");
        localStringBuilder.append(((AppInfoForUpdate)localObject2).targetVersionCode);
        localStringBuilder.append(";targetGrayVersionCode=");
        localStringBuilder.append(((AppInfoForUpdate)localObject2).targetGrayVersionCode);
        localStringBuilder.append("| \n\r");
        localStringBuffer.append(localStringBuilder.toString());
      }
      localObject1 = a;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localStringBuffer.toString());
      ((StringBuilder)localObject2).append("]");
      i.a((String)localObject1, ((StringBuilder)localObject2).toString());
      setData(localGetAppUpdateRequest);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.a.a
 * JD-Core Version:    0.7.0.1
 */