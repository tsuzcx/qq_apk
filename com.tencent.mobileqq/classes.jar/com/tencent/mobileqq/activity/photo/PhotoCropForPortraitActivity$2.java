package com.tencent.mobileqq.activity.photo;

import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.PortraitImageview;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;

class PhotoCropForPortraitActivity$2
  extends Handler
{
  boolean a;
  
  PhotoCropForPortraitActivity$2(PhotoCropForPortraitActivity paramPhotoCropForPortraitActivity, ExtensionInfo paramExtensionInfo, String paramString) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (1000 == paramMessage.what) {
      this.a = true;
    } else if (!this.a) {
      return;
    }
    int j = this.d.c.getClipWidth();
    int i = this.d.c.getClipHeight();
    double d1 = j;
    Double.isNaN(d1);
    j = (int)(d1 * 1.257D);
    d1 = i;
    Double.isNaN(d1);
    paramMessage = new RelativeLayout.LayoutParams(j, (int)(d1 * 1.481D));
    paramMessage.addRule(14);
    d1 = this.d.b.getHeight() * 0.5F;
    double d2 = i * 0.5F;
    Double.isNaN(d2);
    Double.isNaN(d1);
    paramMessage.topMargin = ((int)(d1 - d2 * 1.705D));
    if (this.d.F == null)
    {
      PhotoCropForPortraitActivity localPhotoCropForPortraitActivity = this.d;
      localPhotoCropForPortraitActivity.F = new URLImageView(localPhotoCropForPortraitActivity);
      this.d.b.addView(this.d.F, paramMessage);
    }
    else
    {
      this.d.F.setLayoutParams(paramMessage);
    }
    ((AvatarPendantManager)this.d.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a(this.b.pendantId).a(this.d.F, 6, PendantInfo.f, this.c, this.b.pendantDiyId);
    this.d.F.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity.2
 * JD-Core Version:    0.7.0.1
 */