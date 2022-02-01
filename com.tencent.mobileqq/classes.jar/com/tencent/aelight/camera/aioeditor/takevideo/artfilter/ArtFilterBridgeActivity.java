package com.tencent.aelight.camera.aioeditor.takevideo.artfilter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPictureActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.params.EditLocalPhotoSource;
import com.tencent.mobileqq.editor.params.EditTakePhotoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.editor.params.EditVideoParams.EditSource;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ArtFilterBridgeActivity
  extends BaseActivity
{
  int a = 0;
  volatile int b = 200;
  
  private void a()
  {
    QLog.d("ArtFilterBridgeActivity", 1, "doStartEditPic");
    Intent localIntent = new Intent(getIntent());
    long l = localIntent.getLongExtra("TEMP_PARAM", 0L);
    boolean bool1;
    if (getIntent().getIntExtra("camera_type", -1) != -1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int i = localIntent.getIntExtra("EDIT_BUSI", 2);
    int j = localIntent.getIntExtra("qq_sub_business_id", 0);
    int k = localIntent.getIntExtra("entrance_type", 99);
    String str = localIntent.getStringExtra("PATH");
    Bundle localBundle = new Bundle();
    localBundle.putInt("qq_sub_business_id", j);
    if (i != 3) {
      localBundle.putAll(getIntent().getExtras());
    }
    localBundle.putInt("entrance_type", k);
    localBundle.putInt("pic_entrance_type", localIntent.getIntExtra("pic_entrance_type", 0));
    boolean bool2 = localIntent.getBooleanExtra("go_publish_activity", false);
    if (bool2) {
      localBundle.putString("extra_publish_text", HardCodeUtil.a(2131700974));
    }
    if (localIntent.hasExtra("troop_uin")) {
      localBundle.putString("troop_uin", localIntent.getStringExtra("troop_uin"));
    }
    if (localIntent.hasExtra("extra_enable_flash_pic")) {
      localBundle.putBoolean("extra_enable_flash_pic", localIntent.getBooleanExtra("extra_enable_flash_pic", false));
    }
    if (localIntent.hasExtra("key_enable_edit_title_bar")) {
      localBundle.putBoolean("key_enable_edit_title_bar", localIntent.getBooleanExtra("key_enable_edit_title_bar", false));
    }
    if (localIntent.hasExtra("key_multi_edit_pic")) {
      localBundle.putBoolean("key_multi_edit_pic", localIntent.getBooleanExtra("key_multi_edit_pic", false));
    }
    localBundle.putParcelable("edit_send_session_info", localIntent.getParcelableExtra("edit_send_session_info"));
    localBundle.putString("extra_text_filter_text", localIntent.getStringExtra("extra_text_filter_text"));
    Parcelable localParcelable;
    try
    {
      localObject2 = (LocalMediaInfo)localIntent.getParcelableExtra("media_info");
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        HashMap localHashMap = (HashMap)localIntent.getSerializableExtra("user_params");
        localObject1 = localObject2;
        if (localHashMap != null) {
          localObject1 = (LocalMediaInfo)localHashMap.get("param_localmediainfo");
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new LocalMediaInfo();
      }
      k = (int)l;
      if (bool1) {
        localObject1 = new EditTakePhotoSource(str);
      } else {
        localObject1 = new EditLocalPhotoSource(str, (LocalMediaInfo)localObject2);
      }
      localObject1 = new EditVideoParams(i, k, (EditVideoParams.EditSource)localObject1, localBundle);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" Can not find file by sourcePath: busiType=");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" isTakePhoto:");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(" subBusinessId:");
      ((StringBuilder)localObject2).append(j);
      QLog.d("ArtFilterBridgeActivity", 2, ((StringBuilder)localObject2).toString(), localIllegalArgumentException);
      localParcelable = null;
    }
    if (localParcelable != null) {
      localIntent.putExtra(EditVideoParams.class.getName(), localParcelable);
    }
    if (!bool2) {
      localIntent.setClass(this, EditPicActivity.class);
    }
    if (i == 3) {
      localIntent.setClass(this, QzoneEditPictureActivity.class);
    }
    localIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", getIntent().getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false));
    startActivityForResult(localIntent, 88);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    ThreadManager.excute(new ArtFilterBridgeActivity.1(this), 64, null, true);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("mark_from_artfilter_bridge_activity", true);
    super.setResult(paramInt2, localIntent);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.artfilter.ArtFilterBridgeActivity
 * JD-Core Version:    0.7.0.1
 */