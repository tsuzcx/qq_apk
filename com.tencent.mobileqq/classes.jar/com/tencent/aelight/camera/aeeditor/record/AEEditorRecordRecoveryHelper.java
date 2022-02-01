package com.tencent.aelight.camera.aeeditor.record;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.album.data.AEAlbumImageModel;
import com.tencent.aelight.camera.ae.album.data.AEAlbumMediaBaseModel;
import com.tencent.aelight.camera.ae.album.data.AEAlbumVideoModel;
import com.tencent.aelight.camera.ae.album.data.AEPhotoCropInfoWrapper;
import com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.aeeditor.AEEditorLauncher;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class AEEditorRecordRecoveryHelper
{
  private WeakReference<Activity> a;
  
  public AEEditorRecordRecoveryHelper(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    this.a = new WeakReference(paramActivity);
  }
  
  private Activity a()
  {
    WeakReference localWeakReference = this.a;
    if (localWeakReference == null) {
      return null;
    }
    return (Activity)localWeakReference.get();
  }
  
  private void a(Activity paramActivity, Intent paramIntent)
  {
    Object localObject1 = (IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class);
    int i = 0;
    localObject1 = ((IAECameraPrefsUtil)localObject1).getString("key_ae_editor_files", "", 0);
    ArrayList localArrayList1 = new ArrayList();
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        localObject3 = (ArrayList)AEEditorBaseRecord.a((JSONObject)localObject1, "mediaList", ArrayList.class);
        if (localObject3 != null)
        {
          localObject3 = ((ArrayList)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            localArrayList1.add(((AEAlbumMediaBaseModel)((Iterator)localObject3).next()).getOriginPath());
          }
        }
        localObject1 = (HashMap)AEEditorBaseRecord.a((JSONObject)localObject1, "mediaInfoMap", HashMap.class);
      }
      catch (Exception localException)
      {
        AEQLog.a("AEEditorRecordRecoveryHelper", "recoveryMixPhotoAndVideo", localException);
      }
    } else {
      localObject2 = null;
    }
    if (!a(paramActivity, paramIntent, localArrayList1)) {
      return;
    }
    ArrayList localArrayList2 = new ArrayList();
    new ArrayList();
    while (i < localArrayList1.size())
    {
      String str = (String)localArrayList1.get(i);
      if (localObject2 != null) {
        localObject3 = (LocalMediaInfo)((HashMap)localObject2).get(str);
      } else {
        localObject3 = null;
      }
      if ((localObject3 != null) && (QAlbumUtil.getMediaType((LocalMediaInfo)localObject3) == 1))
      {
        int j = AECirclePhotoListLogic.a((LocalMediaInfo)localObject3);
        if ((j != 2) && (j != 0))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("recoveryMixPhotoAndVideo, not supported video, drop it: ");
          ((StringBuilder)localObject3).append(str);
          AEQLog.d("AEEditorRecordRecoveryHelper", ((StringBuilder)localObject3).toString());
        }
        else
        {
          localObject3 = new AEAlbumVideoModel(str);
          ((AEAlbumVideoModel)localObject3).setOriginPath(str);
          localArrayList2.add(localObject3);
        }
      }
      else
      {
        localObject3 = new AEPhotoCropInfoWrapper();
        ((AEPhotoCropInfoWrapper)localObject3).a = AECirclePhotoListLogic.a(str);
        localObject3 = new AEAlbumImageModel(str, ((AEPhotoCropInfoWrapper)localObject3).a);
        ((AEAlbumImageModel)localObject3).setOriginPath(str);
        localArrayList2.add(localObject3);
      }
      i += 1;
    }
    if (AECameraEntryManager.o(paramIntent))
    {
      AEQLog.b("AEEditorRecordRecoveryHelper", "recoveryMixPhotoAndVideo, is additional pick case, setResult and finish");
      paramIntent = new Intent();
      paramIntent.putExtra("ae_album_selected_media_models", localArrayList2);
      paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap.recovery", (Serializable)localObject2);
      paramIntent.putExtra("key_qcircle_publish_back_edit", true);
      paramActivity.setResult(-1, paramIntent);
      paramActivity.finish();
      return;
    }
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putSerializable("ae_album_selected_media_models", localArrayList2);
    ((Bundle)localObject3).putSerializable("PeakConstants.selectedMediaInfoHashMap.recovery", (Serializable)localObject2);
    ((Bundle)localObject3).putBoolean("key_qcircle_publish_back_edit", true);
    i = AECameraEntry.y.a();
    if (AECameraEntryManager.m(paramIntent)) {
      i = AECameraEntry.A.a();
    }
    if (localArrayList2.size() == 1)
    {
      paramIntent = new ArrayList();
      localObject2 = localArrayList2.iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramIntent.add(((AEAlbumMediaBaseModel)((Iterator)localObject2).next()).getPath());
      }
      ((Bundle)localObject3).putStringArrayList("PhotoConst.SELECTED_PATHS", paramIntent);
      AEEditorLauncher.a(paramActivity, 1, (Bundle)localObject3, i);
      return;
    }
    AEEditorLauncher.a(paramActivity, 2, (Bundle)localObject3, i);
  }
  
  private boolean a(Activity paramActivity, Intent paramIntent, List<String> paramList)
  {
    boolean bool;
    if ((paramList != null) && (paramList.size() != 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (TextUtils.isEmpty(str)) {
          break label78;
        }
        if (!new File(str).exists()) {
          break label78;
        }
      }
      bool = true;
    }
    else
    {
      label78:
      bool = false;
    }
    if (!bool)
    {
      AEQLog.d("AEEditorRecordRecoveryHelper", "validSelectedMediaExist, media not valid");
      paramIntent.putExtra("key_qcircle_publish_back_edit", false);
      QQToast.a(paramActivity, 2064515183, 0).a();
    }
    return bool;
  }
  
  private void b(Activity paramActivity, Intent paramIntent)
  {
    ArrayList localArrayList2 = paramIntent.getStringArrayListExtra("key_qcircle_publish_out_imagepath");
    ArrayList localArrayList3 = new ArrayList();
    Object localObject1 = AEEditorRecordDataManager.a().a(localArrayList2);
    if (!a(paramActivity, paramIntent, (List)localObject1)) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      String str = (String)((List)localObject1).get(i);
      localArrayList3.add(AECirclePhotoListLogic.a(str));
      Object localObject2 = new AEPhotoCropInfoWrapper();
      ((AEPhotoCropInfoWrapper)localObject2).a = AECirclePhotoListLogic.a(str);
      localObject2 = new AEAlbumImageModel(str, ((AEPhotoCropInfoWrapper)localObject2).a);
      ((AEAlbumImageModel)localObject2).setOriginPath(str);
      localArrayList1.add(localObject2);
      i += 1;
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putSerializable("AEEditorConstants_CLIPPED_PIC_INFOS", localArrayList3);
    ((Bundle)localObject1).putSerializable("ae_album_selected_media_models", localArrayList1);
    ((Bundle)localObject1).putBoolean("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", paramIntent.getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", true));
    ((Bundle)localObject1).putBoolean("key_qcircle_publish_back_edit", true);
    if (localArrayList2 != null) {
      ((Bundle)localObject1).putStringArrayList("key_qcircle_publish_out_imagepath", localArrayList2);
    }
    i = AECameraEntry.y.a();
    if (AECameraEntryManager.m(paramIntent)) {
      i = AECameraEntry.A.a();
    }
    if (AECameraEntryManager.o(paramIntent))
    {
      paramIntent = new Intent();
      paramIntent.putExtra("ae_album_selected_media_models", localArrayList1);
      paramActivity.setResult(-1, paramIntent);
      paramActivity.finish();
      return;
    }
    AEEditorRecordDataManager.a().a(1);
    AEEditorLauncher.a(paramActivity, 0, (Bundle)localObject1, i);
  }
  
  public void a()
  {
    Activity localActivity = a();
    if (localActivity == null) {
      return;
    }
    Intent localIntent = localActivity.getIntent();
    if (localIntent == null) {
      return;
    }
    if ((!localIntent.getBooleanExtra("key_qcircle_publish_from_preview", false)) && (localIntent.getBooleanExtra("key_qcircle_publish_back_edit", false)))
    {
      long l = ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).getLong("key_ae_editor_record_type", 0L, 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recoveryAEEditorIfNeed, type=");
      localStringBuilder.append(l);
      AEQLog.b("AEEditorRecordRecoveryHelper", localStringBuilder.toString());
      if (l == 2L)
      {
        a(localActivity, localIntent);
        return;
      }
      if (l == 1L) {
        b(localActivity, localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.record.AEEditorRecordRecoveryHelper
 * JD-Core Version:    0.7.0.1
 */