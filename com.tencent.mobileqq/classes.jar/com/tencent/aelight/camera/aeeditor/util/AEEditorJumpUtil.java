package com.tencent.aelight.camera.aeeditor.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.aeeditor.AEEditorLauncher;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.qcircle.tavcut.bean.Size;
import java.util.ArrayList;
import java.util.HashMap;

public class AEEditorJumpUtil
{
  private static String a(int paramInt)
  {
    if ((paramInt != AECameraEntry.x.a()) && (paramInt != AECameraEntry.z.a())) {
      return "album";
    }
    return "camera";
  }
  
  public static void a(int paramInt, @Nullable Activity paramActivity, @Nullable PhotoCommonBaseData paramPhotoCommonBaseData, boolean paramBoolean)
  {
    if (paramActivity != null)
    {
      if (paramPhotoCommonBaseData == null) {
        return;
      }
      ArrayList localArrayList = new ArrayList(paramPhotoCommonBaseData.selectedPhotoList);
      if ((Build.VERSION.SDK_INT >= 21) && (paramBoolean))
      {
        a(paramInt, paramPhotoCommonBaseData.albumName, paramPhotoCommonBaseData.albumId, paramActivity, localArrayList, paramPhotoCommonBaseData.selectedMediaInfoHashMap);
        return;
      }
      int i = AECameraEntry.y.a();
      if (AECameraEntryManager.r(paramActivity.getIntent())) {
        i = AECameraEntry.A.a();
      }
      if (paramInt == 1)
      {
        a(paramActivity, localArrayList, paramPhotoCommonBaseData.selectedMediaInfoHashMap, i);
        return;
      }
      a(paramActivity, localArrayList, paramPhotoCommonBaseData.selectedMediaInfoHashMap, i, null);
    }
  }
  
  private static void a(int paramInt, @Nullable String paramString1, @Nullable String paramString2, @Nullable Activity paramActivity, @Nullable ArrayList<String> paramArrayList, @Nullable HashMap<String, LocalMediaInfo> paramHashMap)
  {
    if ((paramActivity != null) && (paramArrayList != null))
    {
      if (paramHashMap == null) {
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putStringArrayList("PhotoConst.SELECTED_PATHS", paramArrayList);
      localBundle.putString("albumName", paramString1);
      localBundle.putString("albumId", paramString2);
      localBundle.putSerializable("PeakConstants.selectedMediaInfoHashMap", paramHashMap);
      int i = AECameraEntry.y.a();
      if (AECameraEntryManager.r(paramActivity.getIntent())) {
        i = AECameraEntry.A.a();
      }
      if (paramInt == 0)
      {
        AEEditorLauncher.a(paramActivity, 0, localBundle, i);
        return;
      }
      if (paramInt == 1) {
        AEEditorLauncher.a(paramActivity, 1, localBundle, i);
      }
    }
  }
  
  public static void a(@Nullable Activity paramActivity, @Nullable ArrayList<String> paramArrayList, @Nullable HashMap<String, LocalMediaInfo> paramHashMap, int paramInt)
  {
    if ((paramActivity != null) && (paramArrayList != null))
    {
      if (paramHashMap == null) {
        return;
      }
      Intent localIntent1 = new Intent();
      if ((paramActivity instanceof Activity))
      {
        Intent localIntent2 = paramActivity.getIntent();
        if ((localIntent2 != null) && (localIntent2.getExtras() != null)) {
          localIntent1.putExtras(localIntent2.getExtras());
        }
      }
      localIntent1.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
      localIntent1.putExtra("PeakConstants.selectedMediaInfoHashMap", paramHashMap);
      localIntent1.putExtra("video_photo_from", paramInt);
      localIntent1.putExtra("key_ae_editor_from_photo_picker_tab", a(paramInt));
      localIntent1.addFlags(268435456);
      paramActivity.setResult(-1, localIntent1);
    }
  }
  
  private static void a(@Nullable Context paramContext, @Nullable String paramString, @Nullable LocalMediaInfo paramLocalMediaInfo, int paramInt, @Nullable HashMap<String, String> paramHashMap)
  {
    if ((paramContext != null) && (paramString != null))
    {
      if (paramLocalMediaInfo == null) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      HashMap localHashMap = new HashMap();
      localHashMap.put(paramString, paramLocalMediaInfo);
      paramString = new Intent();
      boolean bool = paramContext instanceof Activity;
      if (bool)
      {
        paramLocalMediaInfo = ((Activity)paramContext).getIntent();
        if ((paramLocalMediaInfo != null) && (paramLocalMediaInfo.getExtras() != null)) {
          paramString.putExtras(paramLocalMediaInfo.getExtras());
        }
      }
      paramString.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      paramString.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap);
      paramString.putExtra("video_photo_from", paramInt);
      paramString.putExtra("key_ae_editor_from_photo_picker_tab", a(paramInt));
      paramString.putExtra("key_image_sucai_info", paramHashMap);
      paramString.addFlags(268435456);
      if (bool)
      {
        ((Activity)paramContext).setResult(-1, paramString);
        return;
      }
      AEQLog.d("AEEditorJumpUtil", "jumpToCirclePublishWithNoVideo activity is not Activity");
    }
  }
  
  public static void a(@Nullable Context paramContext, @Nullable String paramString1, @Nullable String paramString2, @Nullable Size paramSize, @Nullable ArrayList paramArrayList, @Nullable LocalMediaInfo paramLocalMediaInfo, int paramInt, @Nullable HashMap<String, String> paramHashMap)
  {
    if ((paramContext != null) && (paramString1 != null))
    {
      if (paramSize == null) {
        return;
      }
      if (paramArrayList != null) {
        paramLocalMediaInfo.aiTextLabel = paramArrayList;
      }
      a(paramContext, paramString1, paramLocalMediaInfo, paramInt, paramHashMap);
    }
  }
  
  public static void a(@Nullable Context paramContext, @Nullable ArrayList<String> paramArrayList, @Nullable HashMap<String, LocalMediaInfo> paramHashMap, int paramInt, @Nullable HashMap<String, String> paramHashMap1)
  {
    if ((paramContext != null) && (paramArrayList != null))
    {
      if (paramHashMap == null) {
        return;
      }
      Intent localIntent1 = new Intent();
      boolean bool = paramContext instanceof Activity;
      if (bool)
      {
        Intent localIntent2 = ((Activity)paramContext).getIntent();
        if ((localIntent2 != null) && (localIntent2.getExtras() != null)) {
          localIntent1.putExtras(localIntent2.getExtras());
        }
      }
      localIntent1.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
      localIntent1.putExtra("PeakConstants.selectedMediaInfoHashMap", paramHashMap);
      localIntent1.putExtra("key_image_sucai_info", paramHashMap1);
      localIntent1.putExtra("video_photo_from", paramInt);
      localIntent1.putExtra("key_ae_editor_from_photo_picker_tab", a(paramInt));
      localIntent1.addFlags(268435456);
      if (bool)
      {
        ((Activity)paramContext).setResult(-1, localIntent1);
        return;
      }
      AEQLog.d("AEEditorJumpUtil", "sendPicToCirclePublish activity is not Activity");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.util.AEEditorJumpUtil
 * JD-Core Version:    0.7.0.1
 */