package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class PhotoPreviewLogicAEPlay
  extends PhotoPreviewLogicDefault
{
  PhotoPreviewLogicAEPlay(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  private void c(String paramString)
  {
    long l = System.currentTimeMillis();
    if (l - this.a.lastTimeShowToast >= 700L)
    {
      this.a.lastTimeShowToast = l;
      QQToast.a(this.mActivity, paramString, 0).b(((NewPhotoPreviewActivity)this.mActivity).getResources().getDimensionPixelSize(2131299166));
    }
  }
  
  private boolean c()
  {
    return this.mPhotoCommonData.selectedPhotoList.size() < this.mPhotoCommonData.maxSelectNum;
  }
  
  public void initUI()
  {
    super.initUI();
    ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setOnClickListener(new PhotoPreviewLogicAEPlay.1(this));
  }
  
  public void onSelectClick(View paramView)
  {
    if ((!this.mPhotoCommonData.selectedIndex.contains(Integer.valueOf(((NewPhotoPreviewActivity)this.mActivity).getCurrentSelectedPostion()))) && (this.mPhotoCommonData.selectedPhotoList.size() >= this.mPhotoCommonData.maxSelectNum))
    {
      c(String.format(((NewPhotoPreviewActivity)this.mActivity).getString(2131689784), new Object[] { Integer.valueOf(this.mPhotoCommonData.maxSelectNum) }));
      return;
    }
    super.onSelectClick(paramView);
  }
  
  public void updateButton()
  {
    super.updateButton();
    String str = ((NewPhotoPreviewActivity)this.mActivity).getString(2131716930);
    int i = this.mPhotoCommonData.selectedPhotoList.size();
    str = str + " " + i + "/" + this.mPhotoCommonData.maxSelectNum;
    ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setText(str);
    ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setEnabled(true);
    if (c())
    {
      ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setBackgroundResource(2130850177);
      return;
    }
    ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setBackgroundResource(2130838064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewLogicAEPlay
 * JD-Core Version:    0.7.0.1
 */