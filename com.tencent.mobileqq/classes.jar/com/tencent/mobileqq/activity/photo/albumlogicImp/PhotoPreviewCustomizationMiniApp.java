package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPresenter;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import java.util.ArrayList;
import java.util.HashMap;

public class PhotoPreviewCustomizationMiniApp
  extends PhotoPreviewCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationMiniApp";
  private int b = 0;
  
  public PhotoPreviewCustomizationMiniApp(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (s().getItem(paramInt).baseData.getType() == 101) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      s().j.setVisibility(8);
      s().k.setVisibility(8);
      return;
    }
    s().j.setVisibility(0);
    s().k.setVisibility(0);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.b = paramIntent.getIntExtra("from_miniapp_cur_sizetype", 0);
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int i1 = 0;
    int j = 0;
    int i = 0;
    int n = 0;
    while (i1 < paramArrayList.size())
    {
      Object localObject = (String)paramArrayList.get(i1);
      if (!ImageManager.isNetworkUrl((String)localObject))
      {
        int k = this.i.b((String)localObject);
        localObject = this.i.c((String)localObject);
        int m;
        if (k == 1)
        {
          k = j;
          m = i;
          if (localObject != null)
          {
            localHashMap.put(Integer.valueOf(n), localObject);
            k = j + 1;
            m = i;
          }
        }
        else
        {
          m = i + 1;
          k = j;
        }
        n += 1;
        i = m;
        j = k;
      }
      i1 += 1;
    }
    if (!localHashMap.isEmpty()) {
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", localHashMap);
    }
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", ((PhotoOtherData)this.g).d);
    paramIntent.putExtra("from_miniapp_cur_sizetype", this.b);
    paramArrayList = new StringBuilder();
    paramArrayList.append("sendImage:");
    paramArrayList.append(i);
    paramArrayList.append("  sendVideo:");
    paramArrayList.append(j);
    QLog.d("PhotoListCustomizationMiniApp", 2, paramArrayList.toString());
    paramIntent.setComponent(null);
    paramIntent.setAction(paramIntent.getStringExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME"));
    paramIntent.setFlags(paramIntent.getFlags() & 0xDFFFFFFF & 0xFBFFFFFF);
    try
    {
      this.c.sendBroadcast(paramIntent);
      this.c.finish();
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.d("PhotoListCustomizationMiniApp", 1, "sendPhoto fail!", paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationMiniApp
 * JD-Core Version:    0.7.0.1
 */