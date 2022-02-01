package com.tencent.mobileqq.apollo.utils.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.meme.MemeHelper;
import com.tencent.mobileqq.apollo.meme.action.MODE;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.meme.action.MemeCommonAction;
import com.tencent.mobileqq.apollo.meme.action.MemePanelAction;
import com.tencent.mobileqq.apollo.meme.model.BusinessConfig;
import com.tencent.mobileqq.apollo.meme.model.BusinessConfig.FrameType;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController.INSTANCE;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager;
import com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager.OnGetFramePathListener;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ApolloAvatarFileManagerImpl
  implements IApolloAvatarFileManager
{
  private static final String TAG = "[cmshow]ApolloAvatarFileManagerImpl";
  private static final String VIDEO_DIR_PATH = "/video/";
  private ConcurrentHashMap<Integer, String> mActionCoverMap = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, List<String>> mActionFramesMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> mActionGifsMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> mActionKeyMap = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, String> mActionVideoMap = new ConcurrentHashMap();
  
  private String genActionKey(MemeAction paramMemeAction)
  {
    String str3 = genKey(paramMemeAction.m(), paramMemeAction.c().j);
    String str2 = (String)this.mActionKeyMap.get(str3);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = paramMemeAction.a(null, null);
      this.mActionKeyMap.put(str3, str1);
    }
    paramMemeAction = new StringBuilder();
    paramMemeAction.append("genActionKey actionKey: ");
    paramMemeAction.append(str1);
    QLog.i("[cmshow]ApolloAvatarFileManagerImpl", 2, paramMemeAction.toString());
    return str1;
  }
  
  private String genKey(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("genKey actionId: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" uin: ");
    localStringBuilder.append(paramString);
    QLog.i("[cmshow]ApolloAvatarFileManagerImpl", 2, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public void delAllFrameFiles(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("delAllFrameFiles start actionId: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" uin: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("[cmshow]ApolloAvatarFileManagerImpl", 2, ((StringBuilder)localObject).toString());
    localObject = (List)this.mActionFramesMap.get(Integer.valueOf(paramInt1));
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      this.mActionFramesMap.remove(Integer.valueOf(paramInt1));
    }
    MemeCommonAction localMemeCommonAction = new MemeCommonAction(paramInt1, paramInt2, paramString, "", "");
    String str = genKey(paramInt1, paramString);
    localObject = (String)this.mActionKeyMap.get(str);
    paramString = (String)localObject;
    if (localObject == null)
    {
      paramString = localMemeCommonAction.a(null, null);
      this.mActionKeyMap.put(str, paramString);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ApolloConstant.h);
    ((StringBuilder)localObject).append(paramString);
    paramString = ((StringBuilder)localObject).toString();
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("delAllFrameFiles frameFilePath: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("[cmshow]ApolloAvatarFileManagerImpl", 2, ((StringBuilder)localObject).toString());
      FileUtils.deleteFile(new File(paramString));
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("[cmshow]ApolloAvatarFileManagerImpl", 1, paramString.getMessage());
    }
  }
  
  public void delAllGifCache()
  {
    QLog.i("[cmshow]ApolloAvatarFileManagerImpl", 2, "delAllGifFiles start");
    if (this.mActionGifsMap.size() > 0) {
      this.mActionGifsMap.clear();
    }
    if (this.mActionKeyMap.size() > 0) {
      this.mActionKeyMap.clear();
    }
  }
  
  public void getAllFrameFiles(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, IApolloAvatarFileManager.OnGetFramePathListener paramOnGetFramePathListener)
  {
    Object localObject1 = (List)this.mActionFramesMap.get(Integer.valueOf(paramInt1));
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      paramString = new StringBuilder();
      paramString.append("getAllFrameFiles filePathList: ");
      paramString.append(((List)localObject1).size());
      QLog.i("[cmshow]ApolloAvatarFileManagerImpl", 2, paramString.toString());
      paramOnGetFramePathListener.a(true, (List)localObject1, paramInt1);
      return;
    }
    localObject1 = new MemeCommonAction(paramInt1, paramInt2, paramString, "", "");
    String str = genActionKey((MemeAction)localObject1);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(ApolloConstant.h);
    ((StringBuilder)localObject2).append(str);
    str = ((StringBuilder)localObject2).toString();
    localObject2 = new File(str);
    if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory()))
    {
      File[] arrayOfFile = ((File)localObject2).listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        localObject2 = new ArrayList();
        paramInt3 = arrayOfFile.length;
        paramInt2 = 0;
        while (paramInt2 < paramInt3)
        {
          File localFile = arrayOfFile[paramInt2];
          if (localFile.isFile()) {
            ((List)localObject2).add(localFile.getAbsolutePath());
          }
          paramInt2 += 1;
        }
        if (((List)localObject2).size() > 0)
        {
          paramString = new StringBuilder();
          paramString.append("getAllFrameFiles fileList: ");
          paramString.append(((List)localObject2).size());
          QLog.i("[cmshow]ApolloAvatarFileManagerImpl", 2, paramString.toString());
          putAction2FrameFilePath(paramInt1, (List)localObject2);
          paramString = new StringBuilder();
          paramString.append(str);
          paramString.append("/video/");
          putAction2VideoFilePath(paramInt1, paramString.toString());
          paramOnGetFramePathListener.a(true, (List)localObject2, paramInt1);
        }
      }
      else
      {
        QLog.e("[cmshow]ApolloAvatarFileManagerImpl", 1, "getAllFrameFiles files is null");
      }
    }
    ((MemeAction)localObject1).a(MODE.ACTION_MODE_RECORD_GIF);
    ((MemeAction)localObject1).j().b(ApolloConstant.l);
    MemeHelper.a.a(null, (MemeAction)localObject1, new ApolloAvatarFileManagerImpl.1(this, paramInt1, paramString, paramOnGetFramePathListener));
    QLog.i("[cmshow]ApolloAvatarFileManagerImpl", 2, "getAllFrameFiles CMSPlayer_recordAction");
  }
  
  public String getGifFilePath(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = (String)this.mActionGifsMap.get(genKey(paramInt1, paramString));
    if (localObject != null) {
      return localObject;
    }
    localObject = genActionKey(new MemeCommonAction(paramInt1, paramInt2, paramString, "", ""));
    localObject = ApolloScreenshotController.a.a((String)localObject);
    if (localObject != null)
    {
      localObject = ((File)localObject).getAbsolutePath();
      putAction2GifFilePath(paramInt1, paramString, (String)localObject);
      return localObject;
    }
    return null;
  }
  
  public String getSingleFrameFile(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, IApolloAvatarFileManager.OnGetFramePathListener paramOnGetFramePathListener)
  {
    Object localObject1 = (String)this.mActionCoverMap.get(Integer.valueOf(paramInt1));
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new File((String)localObject1);
      if ((((File)localObject2).isFile()) && (((File)localObject2).exists()))
      {
        localArrayList.add(localObject1);
        if (paramOnGetFramePathListener != null) {
          paramOnGetFramePathListener.a(true, localArrayList, paramInt1);
        }
        return localObject1;
      }
    }
    localObject1 = new ApolloActionData();
    ((ApolloActionData)localObject1).actionId = paramInt1;
    ((ApolloActionData)localObject1).actionType = paramInt2;
    ((ApolloActionData)localObject1).isForPlayerAction = 1;
    ((ApolloActionData)localObject1).personNum = 0;
    ((ApolloActionData)localObject1).actionName = "avatar";
    Object localObject2 = new MemePanelAction((ApolloActionData)localObject1, paramString);
    String str = genKey(paramInt1, paramString);
    localObject1 = (String)this.mActionKeyMap.get(str);
    paramString = (String)localObject1;
    if (localObject1 == null)
    {
      paramString = ((MemeAction)localObject2).a(null, null);
      this.mActionKeyMap.put(str, paramString);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(ApolloConstant.h);
    ((StringBuilder)localObject1).append(paramString);
    paramString = ((StringBuilder)localObject1).toString();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new File(paramString);
      if ((paramString.isFile()) && (paramString.exists()))
      {
        localArrayList.add(paramString.getAbsolutePath());
        if (paramOnGetFramePathListener != null) {
          paramOnGetFramePathListener.a(true, localArrayList, paramInt1);
        }
        return paramString.getAbsolutePath();
      }
    }
    ((MemeAction)localObject2).j().a(BusinessConfig.FrameType.JPEG);
    ((MemeAction)localObject2).j().a(ApolloConstant.l);
    MemeHelper.a.a((MemeAction)localObject2, CmShowWnsUtils.j(), new ApolloAvatarFileManagerImpl.2(this, paramInt1, localArrayList, paramOnGetFramePathListener));
    return "";
  }
  
  public String getSingleFrameFile(int paramInt1, int paramInt2, String paramString, IApolloAvatarFileManager.OnGetFramePathListener paramOnGetFramePathListener)
  {
    int i = (int)CmShowWnsUtils.ag();
    return getSingleFrameFile(paramInt1, paramInt2, paramString, i, i, paramOnGetFramePathListener);
  }
  
  public String getVideoFilePath(int paramInt)
  {
    Object localObject = (String)this.mActionVideoMap.get(Integer.valueOf(paramInt));
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getVideoFilePath actionId:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("videopath is null");
    QLog.e("[cmshow]ApolloAvatarFileManagerImpl", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  public boolean isHasGif(int paramInt1, int paramInt2, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isHasGif actionId: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" actionType: ");
    localStringBuilder.append(paramInt2);
    QLog.i("[cmshow]ApolloAvatarFileManagerImpl", 2, localStringBuilder.toString());
    paramString = getGifFilePath(paramInt1, paramInt2, paramString);
    if (paramString == null)
    {
      QLog.e("[cmshow]ApolloAvatarFileManagerImpl", 1, "isHasGif fasle, filePath is null");
      return false;
    }
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.length() != 0L)) {
      return true;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("isHasGif false, file exists: ");
    localStringBuilder.append(paramString.exists());
    localStringBuilder.append("file.length(): ");
    localStringBuilder.append(paramString.length());
    QLog.e("[cmshow]ApolloAvatarFileManagerImpl", 1, localStringBuilder.toString());
    return false;
  }
  
  public boolean isHasVideo(int paramInt)
  {
    Object localObject = getVideoFilePath(paramInt);
    if (localObject == null) {
      return false;
    }
    localObject = new File((String)localObject);
    return (((File)localObject).exists()) && (((File)localObject).length() != 0L);
  }
  
  public void putAction2FrameFilePath(int paramInt, List<String> paramList)
  {
    this.mActionFramesMap.put(Integer.valueOf(paramInt), paramList);
  }
  
  public void putAction2GifFilePath(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = genKey(paramInt, paramString1);
    this.mActionGifsMap.put(paramString1, paramString2);
  }
  
  public void putAction2VideoFilePath(int paramInt, String paramString)
  {
    this.mActionVideoMap.put(Integer.valueOf(paramInt), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloAvatarFileManagerImpl
 * JD-Core Version:    0.7.0.1
 */