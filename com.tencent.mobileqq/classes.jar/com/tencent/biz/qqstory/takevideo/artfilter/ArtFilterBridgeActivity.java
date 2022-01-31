package com.tencent.biz.qqstory.takevideo.artfilter;

import ajyc;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditPicActivity;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import vka;

public class ArtFilterBridgeActivity
  extends BaseActivity
{
  private void a()
  {
    QLog.d("ArtFilterBridgeActivity", 1, "doStartEditPic");
    Intent localIntent = new Intent(getIntent());
    int j = localIntent.getIntExtra("TEMP_PARAM", 0);
    int k = 0;
    int i = k;
    Object localObject1;
    Object localObject3;
    if (getIntent().getBooleanExtra("USE_FILTER", false))
    {
      localObject1 = vka.a();
      i = k;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = vka.b();
        i = k;
        if (localObject3 != null)
        {
          i = 1;
          localIntent.putExtra("FILTER_STRING", (String)localObject1);
          localIntent.putExtra("FILTER_MAXSIDE", ArtFilterManager.a());
          localIntent.putExtra("FILTER_LOADING_PATH", (String)localObject3);
        }
      }
    }
    if (i != 0) {}
    for (i = j | 0x10;; i = j)
    {
      if (getIntent().getIntExtra("camera_type", -1) != -1) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        j = localIntent.getIntExtra("EDIT_BUSI", 2);
        k = localIntent.getIntExtra("sub_business_id", 0);
        int m = localIntent.getIntExtra("entrance_type", 99);
        String str = localIntent.getStringExtra("PATH");
        localObject3 = EditVideoParams.a(k);
        if (localObject3 == null) {
          localObject3 = new Bundle();
        }
        for (;;)
        {
          ((Bundle)localObject3).putString("mCurrentTemplatePath", localIntent.getStringExtra("mCurrentTemplatePath"));
          ((Bundle)localObject3).putInt("entrance_type", m);
          ((Bundle)localObject3).putInt("pic_entrance_type", localIntent.getIntExtra("pic_entrance_type", 0));
          if (localIntent.hasExtra("extra_publish_text")) {
            ((Bundle)localObject3).putString("extra_publish_text", localIntent.getStringExtra("extra_publish_text"));
          }
          boolean bool2 = localIntent.getBooleanExtra("go_publish_activity", false);
          if (bool2) {
            ((Bundle)localObject3).putString("extra_publish_text", ajyc.a(2131700742));
          }
          if (localIntent.hasExtra("troop_uin")) {
            ((Bundle)localObject3).putString("troop_uin", localIntent.getStringExtra("troop_uin"));
          }
          double d1 = getIntent().getDoubleExtra("key_latitude", 4.9E-324D);
          double d2 = getIntent().getDoubleExtra("key_longtitude", 4.9E-324D);
          localObject1 = (HashMap)localIntent.getSerializableExtra("user_params");
          if (localObject1 != null) {}
          Object localObject2;
          for (localObject1 = (LocalMediaInfo)((HashMap)localObject1).get("param_localmediainfo");; localObject2 = null)
          {
            Object localObject4 = localObject1;
            if (localObject1 == null) {
              localObject4 = new LocalMediaInfo();
            }
            if (bool1) {}
            for (;;)
            {
              try
              {
                localObject1 = new EditTakePhotoSource(str, 2, 0, 0, d2, d1);
                localObject1 = new EditVideoParams(j, i, (EditVideoParams.EditSource)localObject1, (Bundle)localObject3);
              }
              catch (IllegalArgumentException localIllegalArgumentException)
              {
                localIllegalArgumentException.printStackTrace();
                QLog.d("ArtFilterBridgeActivity", 2, " Can not find file by sourcePath: busiType=" + j + " isTakePhoto:" + bool1 + " subBusinessId:" + k);
                localObject2 = null;
                continue;
              }
              if (localObject1 != null) {
                localIntent.putExtra(EditVideoParams.class.getName(), (Parcelable)localObject1);
              }
              if (!bool2) {
                localIntent.setClass(this, EditPicActivity.class);
              }
              localIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", getIntent().getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false));
              startActivityForResult(localIntent, 88);
              return;
              localObject1 = new EditLocalPhotoSource(str, (LocalMediaInfo)localObject4);
            }
          }
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    ThreadManager.post(new ArtFilterBridgeActivity.1(this), 8, null, true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.setResult(paramInt2, paramIntent);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterBridgeActivity
 * JD-Core Version:    0.7.0.1
 */