package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault;
import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import java.util.HashMap;

public class PhotoPreviewLogicMiniApp
  extends PhotoPreviewLogicDefault
{
  private int a = 0;
  
  public PhotoPreviewLogicMiniApp(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int i1 = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    while (i1 < paramArrayList.size())
    {
      Object localObject = (String)paramArrayList.get(i1);
      int m;
      if (ImageManager.isNetworkUrl((String)localObject))
      {
        m = k;
        k = i;
        i = m;
        i1 += 1;
        m = k;
        k = i;
        i = m;
      }
      else
      {
        m = ((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)localObject);
        localObject = ((NewPhotoPreviewActivity)this.mActivity).getMediaInfo((String)localObject);
        int n;
        if (m == 1)
        {
          n = j;
          m = i;
          if (localObject != null)
          {
            localHashMap.put(Integer.valueOf(k), localObject);
            m = i + 1;
            n = j;
          }
        }
        for (;;)
        {
          i = k + 1;
          j = n;
          k = m;
          break;
          n = j + 1;
          m = i;
        }
      }
    }
    if (!localHashMap.isEmpty()) {
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", localHashMap);
    }
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.mPhotoCommonData.currentQualityType);
    paramIntent.putExtra("from_miniapp_cur_sizetype", this.a);
    QLog.d("PhotoListLogicMiniApp", 2, "sendImage:" + j + "  sendVideo:" + i);
    paramIntent.setComponent(null);
    paramIntent.setAction(paramIntent.getStringExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME"));
    paramIntent.setFlags(paramIntent.getFlags() & 0xDFFFFFFF & 0xFBFFFFFF);
    try
    {
      ((NewPhotoPreviewActivity)this.mActivity).sendBroadcast(paramIntent);
      ((NewPhotoPreviewActivity)this.mActivity).finish();
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.d("PhotoListLogicMiniApp", 1, "sendPhoto fail!", paramIntent);
    }
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.a = paramIntent.getIntExtra("from_miniapp_cur_sizetype", 0);
  }
  
  public void onGalleryItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onGalleryItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    paramAdapterView = ((NewPhotoPreviewActivity)this.mActivity).adapter.getItem(paramInt);
    if (((NewPhotoPreviewActivity)this.mActivity).getMediaType(paramAdapterView) == 1) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(8);
      ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(8);
      return;
    }
    ((NewPhotoPreviewActivity)this.mActivity).qualityCheckBox.setVisibility(0);
    ((NewPhotoPreviewActivity)this.mActivity).qualityTv.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewLogicMiniApp
 * JD-Core Version:    0.7.0.1
 */