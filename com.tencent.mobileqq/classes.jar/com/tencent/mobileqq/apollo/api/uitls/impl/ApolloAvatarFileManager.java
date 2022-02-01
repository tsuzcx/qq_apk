package com.tencent.mobileqq.apollo.api.uitls.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.api.player.action.CMSCommonAction;
import com.tencent.mobileqq.apollo.api.player.action.CMSPanelAction;
import com.tencent.mobileqq.apollo.api.player.action.MODE;
import com.tencent.mobileqq.apollo.api.player.model.BusinessConfig;
import com.tencent.mobileqq.apollo.api.player.model.BusinessConfig.FrameType;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.player.CMSPlayer;
import com.tencent.mobileqq.apollo.utils.CmShowWnsUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ApolloAvatarFileManager
{
  private static volatile ApolloAvatarFileManager jdField_a_of_type_ComTencentMobileqqApolloApiUitlsImplApolloAvatarFileManager;
  private final int jdField_a_of_type_Int = (int)CmShowWnsUtils.a();
  private ConcurrentHashMap<Integer, List<String>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, String> b = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, String> c = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, String> d = new ConcurrentHashMap();
  
  public static ApolloAvatarFileManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqApolloApiUitlsImplApolloAvatarFileManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqApolloApiUitlsImplApolloAvatarFileManager == null) {
        jdField_a_of_type_ComTencentMobileqqApolloApiUitlsImplApolloAvatarFileManager = new ApolloAvatarFileManager();
      }
      return jdField_a_of_type_ComTencentMobileqqApolloApiUitlsImplApolloAvatarFileManager;
    }
    finally {}
  }
  
  public String a(int paramInt)
  {
    Object localObject = (String)this.b.get(Integer.valueOf(paramInt));
    if (localObject != null) {}
    String str;
    do
    {
      return localObject;
      str = BaseApplicationImpl.getApplication().getSharedPreferences("avatar_cmshow_face_file_path_sp", 0).getString("sp_key_avatar_cmshow_face_gif_path" + paramInt, null);
      localObject = str;
    } while (str != null);
    return null;
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
    }
    localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("avatar_cmshow_face_file_path_sp", 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString("sp_key_avatar_cmshow_face_frame_path" + paramInt, null);
    if (localObject2 != null) {}
    for (;;)
    {
      int i;
      try
      {
        localObject2 = new File((String)localObject2);
        if ((((File)localObject2).isDirectory()) && (((File)localObject2).listFiles().length > 0))
        {
          File[] arrayOfFile = ((File)localObject2).listFiles();
          int j = arrayOfFile.length;
          i = 0;
          if (i < j)
          {
            File localFile = arrayOfFile[i];
            if (localFile.isFile()) {
              localFile.delete();
            }
          }
          else
          {
            ((File)localObject2).delete();
          }
        }
        else
        {
          ((SharedPreferences)localObject1).edit().remove("sp_key_avatar_cmshow_face_frame_path" + paramInt).commit();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ApolloAvatarFileManager", 1, localException.getMessage());
        return;
      }
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, ApolloAvatarFileManager.OnGetFramePathListener paramOnGetFramePathListener)
  {
    Object localObject1 = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      paramOnGetFramePathListener.a(true, (List)localObject1, paramInt1);
      return;
    }
    localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("avatar_cmshow_face_file_path_sp", 0).getString("sp_key_avatar_cmshow_face_frame_path" + paramInt1, null);
    if (localObject1 != null)
    {
      localObject1 = new File((String)localObject1);
      if ((((File)localObject1).isDirectory()) && (((File)localObject1).listFiles().length > 0))
      {
        localObject1 = ((File)localObject1).listFiles();
        ArrayList localArrayList = new ArrayList();
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (localObject2.isFile()) {
            localArrayList.add(localObject2.getAbsolutePath());
          }
          i += 1;
        }
        if (localArrayList.size() > 0)
        {
          paramOnGetFramePathListener.a(true, localArrayList, paramInt1);
          return;
        }
      }
    }
    localObject1 = new CMSPlayer(paramInt3, paramInt4);
    paramString = new CMSCommonAction(paramInt1, paramInt2, paramString, "", "");
    paramString.a(MODE.ACTION_MODE_RECORD_GIF);
    paramString.a().b(ApolloConstant.c);
    ((CMSPlayer)localObject1).a(null, paramString, new ApolloAvatarFileManager.1(this, paramInt1, paramOnGetFramePathListener));
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, ApolloAvatarFileManager.OnGetFramePathListener paramOnGetFramePathListener)
  {
    b(paramInt1, paramInt2, paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, paramOnGetFramePathListener);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.b.put(Integer.valueOf(paramInt), paramString);
  }
  
  public void a(int paramInt, List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), paramList);
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject == null) {}
    do
    {
      return false;
      localObject = new File((String)localObject);
    } while ((!((File)localObject).exists()) && (((File)localObject).length() == 0L));
    return true;
  }
  
  public String b(int paramInt)
  {
    Object localObject = (String)this.c.get(Integer.valueOf(paramInt));
    if (localObject != null) {}
    String str;
    do
    {
      return localObject;
      str = BaseApplicationImpl.getApplication().getSharedPreferences("avatar_cmshow_face_file_path_sp", 0).getString("sp_key_avatar_cmshow_face_video_path" + paramInt, null);
      localObject = str;
    } while (str != null);
    return null;
  }
  
  public void b(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, ApolloAvatarFileManager.OnGetFramePathListener paramOnGetFramePathListener)
  {
    Object localObject1 = (String)this.d.get(Integer.valueOf(paramInt1));
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new File((String)localObject1);
      if ((((File)localObject2).isFile()) && (((File)localObject2).exists()))
      {
        localArrayList.add(localObject1);
        paramOnGetFramePathListener.a(true, localArrayList, paramInt1);
        return;
      }
    }
    localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("avatar_cmshow_face_file_path_sp", 0).getString("sp_key_avatar_cmshow_face_frame_path" + paramInt1, null);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new File((String)localObject1);
      if ((((File)localObject1).isFile()) && (((File)localObject1).exists()))
      {
        localArrayList.add(((File)localObject1).getAbsolutePath());
        paramOnGetFramePathListener.a(true, localArrayList, paramInt1);
        return;
      }
    }
    localObject1 = new CMSPlayer(paramInt3, paramInt4);
    Object localObject2 = new ApolloActionData();
    ((ApolloActionData)localObject2).actionId = paramInt1;
    ((ApolloActionData)localObject2).actionType = paramInt2;
    ((ApolloActionData)localObject2).isForPlayerAction = 1;
    ((ApolloActionData)localObject2).personNum = 0;
    ((ApolloActionData)localObject2).actionName = "avatar";
    paramString = new CMSPanelAction((ApolloActionData)localObject2, paramString);
    paramString.a().a(BusinessConfig.FrameType.JPEG);
    paramString.a().a(ApolloConstant.c);
    ((CMSPlayer)localObject1).a(paramString, CmShowWnsUtils.b(), new ApolloAvatarFileManager.2(this, paramInt1, localArrayList, paramOnGetFramePathListener));
  }
  
  public void b(int paramInt, String paramString)
  {
    this.c.put(Integer.valueOf(paramInt), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.uitls.impl.ApolloAvatarFileManager
 * JD-Core Version:    0.7.0.1
 */