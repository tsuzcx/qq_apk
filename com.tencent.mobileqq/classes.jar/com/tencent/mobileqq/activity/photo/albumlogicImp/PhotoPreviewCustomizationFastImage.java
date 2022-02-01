package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPresenter;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.pic.IPresendPicMgr.Stub;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;

public class PhotoPreviewCustomizationFastImage
  extends PhotoPreviewCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationFastImage";
  boolean b;
  int j = 1037;
  
  protected PhotoPreviewCustomizationFastImage(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
  }
  
  public void a()
  {
    super.a();
    s().o.setText(2131892579);
    s().m.setVisibility(8);
    s().n.setVisibility(8);
  }
  
  public void a(Intent paramIntent)
  {
    this.d.g = true;
    super.a(paramIntent);
    Object localObject = (BinderWarpper)paramIntent.getParcelableExtra("binder_presendService");
    if (localObject != null)
    {
      if (PresendPicMgr.a(null) != null) {
        PresendPicMgr.a(null).c();
      }
      localObject = PresendPicMgr.b(IPresendPicMgr.Stub.a(((BinderWarpper)localObject).a));
      String str = (String)paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS").get(0);
      if (this.i.b(str) != 1)
      {
        ((PresendPicMgr)localObject).a(str, this.j, 10);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("  initData , presendMgr = ");
          localStringBuilder.append(localObject);
          localStringBuilder.append(",picpath = ");
          localStringBuilder.append(str);
          localStringBuilder.append(",from = ");
          localStringBuilder.append(this.d.A);
          localStringBuilder.append(",mBusiType = ");
          localStringBuilder.append(this.j);
          QLog.d("QQAlbum", 2, localStringBuilder.toString());
        }
      }
    }
    this.b = paramIntent.getBooleanExtra("callFromFastImage", false);
    if ("FromFastImage".equals(this.d.A)) {
      StatisticConstants.c();
    }
    if ("FromCamera".equals(this.d.A)) {
      StatisticConstants.a();
    }
    if (paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false))
    {
      paramIntent.removeExtra("PhotoConst.SEND_FLAG");
      localObject = PresendPicMgr.a(null);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQAlbum", 2, "Photo+ send pic,cancel presend!");
        }
        ((PresendPicMgr)localObject).a(1003);
      }
      PhotoUtils.sendPhoto(this.c, paramIntent, this.f.selectedPhotoList, ((PhotoOtherData)this.g).d, true);
    }
  }
  
  protected void a(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    if (this.d.m != null)
    {
      ReportController.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      if (this.b) {
        ReportController.b(null, "CliOper", "", "", "0X8004D95", "0X8004D95", 0, 0, "", "", "", "");
      }
    }
    if (this.d.r) {
      this.c.getIntent().putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
    }
    super.a(paramView, paramInt1, paramBundle, paramInt2, paramIntent);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d.r = paramBoolean;
    if (paramBoolean)
    {
      s().j.setChecked(paramBoolean ^ true);
      s().k.setTextColor(2147483647);
      return;
    }
    s().k.setTextColor(-1);
    if (this.c.popup != null) {
      this.c.popup.dismiss();
    }
  }
  
  public void i()
  {
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
    if (localPresendPicMgr != null)
    {
      int i;
      if ("FromCamera".equals(this.d.A)) {
        i = 1016;
      } else {
        i = 1017;
      }
      localPresendPicMgr.a(i);
    }
    this.c.finish();
  }
  
  protected void j()
  {
    if ("FromFastImage".equals(this.d.A))
    {
      ReportController.b(null, "CliOper", "", "", "0X8004D93", "0X8004D93", 0, 0, "", "", "", "");
      StatisticConstants.d();
    }
    if ("FromCamera".equals(this.d.A)) {
      StatisticConstants.b();
    }
    if (this.d.r) {
      this.c.getIntent().putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
    }
    super.j();
    ReportController.b(null, "CliOper", "", "", "0X8005147", "0X8005147", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationFastImage
 * JD-Core Version:    0.7.0.1
 */