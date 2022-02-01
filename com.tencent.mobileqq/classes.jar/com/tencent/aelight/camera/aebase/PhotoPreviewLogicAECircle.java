package com.tencent.aelight.camera.aebase;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.tencent.aelight.camera.util.api.IAEEditorJumpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.preview.PhotoPreviewBaseData;
import com.tencent.mobileqq.activity.photo.album.preview.PhotoPreviewCustomizationBase;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewPictureData;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewVideoData;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPresenter;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import java.util.ArrayList;
import java.util.HashMap;

public class PhotoPreviewLogicAECircle
  extends PhotoPreviewCustomizationBase
{
  public static final String a = "com.tencent.aelight.camera.aebase.PhotoPreviewLogicAECircle";
  private int b;
  private int c;
  private int d;
  private Dialog j;
  private String k;
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    return (paramLocalMediaInfo != null) && ("image/gif".equals(paramLocalMediaInfo.mMimeType));
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.e != null) && (!this.e.isFinishing()))
    {
      if (paramBoolean)
      {
        if (this.j == null)
        {
          this.j = new Dialog(this.e, 2131953338);
          this.j.setCancelable(false);
          this.j.setCanceledOnTouchOutside(false);
          this.j.setContentView(2131625585);
        }
        this.j.show();
        return;
      }
      Dialog localDialog = this.j;
      if ((localDialog != null) && (localDialog.isShowing())) {
        this.j.dismiss();
      }
    }
  }
  
  private void d()
  {
    if (this.f.selectedPhotoList.size() == 0)
    {
      if (a(this.i.c(this.k)))
      {
        QQToast.makeText(this.e, HardCodeUtil.a(2131886369), 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
        return;
      }
      this.f.selectedPhotoList.add(this.k);
    }
    ((IAEEditorJumpUtil)QRoute.api(IAEEditorJumpUtil.class)).picChooseJump(this.d, this.e, this.f, false);
    this.e.finish();
    b(false);
  }
  
  public void a()
  {
    super.a();
    s().n.setVisibility(8);
    s().l.setOnClickListener(new PhotoPreviewLogicAECircle.1(this));
  }
  
  public void a(int paramInt)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = s().getItem(paramInt);
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null))
    {
      if (localRichMediaBrowserInfo.baseData.getType() == 100)
      {
        str = ((PreviewPictureData)localRichMediaBrowserInfo.baseData).filePath;
        break label81;
      }
      if (localRichMediaBrowserInfo.baseData.getType() == 101)
      {
        str = ((PreviewVideoData)localRichMediaBrowserInfo.baseData).filePath;
        break label81;
      }
    }
    String str = null;
    label81:
    this.k = str;
    int i;
    if (localRichMediaBrowserInfo.baseData.getType() == 100) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      s().n.setVisibility(8);
    } else {
      s().n.setVisibility(0);
    }
    super.a(paramInt);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.b = paramIntent.getIntExtra("choosed_num", 0);
    this.c = paramIntent.getIntExtra("BUNDLE_KEY_INITIAL_PICKED_NUM", 0);
  }
  
  public void a(View paramView)
  {
    int i = s().m();
    String str;
    if (i != -1) {
      str = (String)this.h.y.get(i);
    } else {
      str = "";
    }
    LocalMediaInfo localLocalMediaInfo = this.i.c(str);
    int m = AlbumUtil.getMediaType(localLocalMediaInfo);
    if (!this.f.selectedIndex.contains(Integer.valueOf(i)))
    {
      this.f.selectedMediaInfoHashMap.put(str, localLocalMediaInfo);
      if (this.b + this.c == 9)
      {
        paramView = BaseApplicationImpl.sApplication.getResources().getString(2131886370, new Object[] { Integer.valueOf(9 - this.c) });
        QQToast.makeText(this.e, paramView, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
        return;
      }
      if (a(localLocalMediaInfo))
      {
        QQToast.makeText(this.e, HardCodeUtil.a(2131886369), 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
        return;
      }
      if ((m == 1) && (this.b + this.c != 0)) {
        QQToast.makeText(this.e, HardCodeUtil.a(2131886371), 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
      }
    }
    else
    {
      this.f.selectedMediaInfoHashMap.remove(str);
    }
    super.a(paramView);
    this.b = this.f.selectedPhotoList.size();
  }
  
  public void b()
  {
    s().l.setClickable(true);
    s().l.setBackgroundResource(2130837935);
    super.b();
  }
  
  public void c()
  {
    super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.PhotoPreviewLogicAECircle
 * JD-Core Version:    0.7.0.1
 */