package com.tencent.aelight.camera.ae.camera.ui.gallery;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler;
import com.tencent.aelight.camera.ae.config.CameraPeakServiceObserver;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PhotoListCustomizationAECapture
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.aelight.camera.ae.camera.ui.gallery.PhotoListCustomizationAECapture";
  private AppInterface i = QQStoryContext.k();
  private CameraPeakServiceHandler j = (CameraPeakServiceHandler)this.i.getBusinessHandler(PeakAppInterface.e);
  private CameraPeakServiceObserver k;
  private Dialog l;
  private int m;
  private int n;
  private boolean o;
  
  public PhotoListCustomizationAECapture(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
    paramAbstractPhotoListActivity = paramAbstractPhotoListActivity.getIntent();
    if (paramAbstractPhotoListActivity != null)
    {
      this.m = paramAbstractPhotoListActivity.getIntExtra("MaterialConfig.minImageWidth", 0);
      this.n = paramAbstractPhotoListActivity.getIntExtra("MaterialConfig.minImageHeight", 0);
      this.o = paramAbstractPhotoListActivity.getBooleanExtra("MaterialConfig.needFace", false);
    }
  }
  
  private void a(String paramString, boolean paramBoolean, int paramInt)
  {
    x();
    if ((this.h.o != null) && (this.h.o.getVisibility() == 0)) {
      this.h.o.setClickable(true);
    }
    if (paramBoolean)
    {
      if ((paramInt != 0) && (paramInt != -2))
      {
        if (paramInt == -1) {
          c(this.c.getString(2064187421));
        }
      }
      else {
        a(paramString);
      }
    }
    else
    {
      if (paramInt == -100)
      {
        if (!this.o)
        {
          a(paramString);
          return;
        }
        c(this.c.getString(2064187424));
        return;
      }
      c(this.c.getString(2064187422));
    }
  }
  
  private boolean a(@Nullable String paramString, @Nullable LocalMediaInfo paramLocalMediaInfo)
  {
    if ((paramString != null) && (paramString.endsWith(".gif"))) {
      return true;
    }
    return (paramLocalMediaInfo != null) && ("image/gif".equalsIgnoreCase(paramLocalMediaInfo.mMimeType));
  }
  
  private void b(String paramString)
  {
    if ((this.h.o != null) && (this.h.o.getVisibility() == 0)) {
      this.h.o.setClickable(false);
    }
    CameraPeakServiceObserver localCameraPeakServiceObserver = this.k;
    if (localCameraPeakServiceObserver != null) {
      this.i.removeObserver(localCameraPeakServiceObserver);
    }
    this.k = new PhotoListCustomizationAECapture.1(this, paramString);
    w();
    this.i.addObserver(this.k);
    this.j.b(paramString);
  }
  
  private void c(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.b.H >= 1000L)
    {
      this.b.H = l1;
      QQToast.makeText(this.c, paramString, 0).show();
    }
  }
  
  private boolean d()
  {
    return this.e.selectedPhotoList.size() < this.e.maxSelectNum;
  }
  
  private void w()
  {
    if ((this.c != null) && (!this.c.isFinishing()))
    {
      if (this.l == null)
      {
        this.l = new Dialog(this.c, 2131953338);
        this.l.setContentView(2131625585);
        ((TextView)this.l.findViewById(2131440191)).setText(2064187425);
        this.l.setCancelable(true);
        this.l.setCanceledOnTouchOutside(false);
        this.l.setOnDismissListener(new PhotoListCustomizationAECapture.2(this));
      }
      this.l.show();
    }
  }
  
  private void x()
  {
    if ((this.c != null) && (!this.c.isFinishing()))
    {
      Dialog localDialog = this.l;
      if ((localDialog != null) && (localDialog.isShowing())) {
        this.l.dismiss();
      }
    }
  }
  
  public void a()
  {
    super.a();
    String str = this.c.getString(2064187423);
    int i1 = this.e.selectedPhotoList.size();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(" ");
    localStringBuilder.append(i1);
    localStringBuilder.append("/");
    localStringBuilder.append(this.e.maxSelectNum);
    str = localStringBuilder.toString();
    this.h.o.setText(str);
    this.h.o.setEnabled(true);
    if (d())
    {
      this.h.o.setBackgroundResource(2130851880);
      return;
    }
    this.h.o.setBackgroundResource(2130837935);
  }
  
  public void a(View paramView)
  {
    if (d())
    {
      c(String.format(this.c.getString(2064187562), new Object[] { Integer.valueOf(this.e.maxSelectNum) }));
      return;
    }
    if (!NetworkUtils.a(this.c))
    {
      c(this.c.getString(2064187422));
      return;
    }
    paramView = (String)this.e.selectedPhotoList.get(0);
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.e.allMediaInfoHashMap.get(paramView);
    if ((this.m > 0) && (this.n > 0) && (localLocalMediaInfo != null) && ((localLocalMediaInfo.mediaWidth < this.m) || (localLocalMediaInfo.mediaHeight < this.n)))
    {
      c(String.format(this.c.getString(2064187420), new Object[] { Integer.valueOf(this.m), Integer.valueOf(this.n) }));
      return;
    }
    if (a(paramView, localLocalMediaInfo))
    {
      c(this.c.getString(2064187421));
      return;
    }
    b(paramView);
  }
  
  public void a(View paramView, int paramInt)
  {
    if (!NetworkUtils.a(this.c))
    {
      c(this.c.getString(2064187422));
      return;
    }
    paramView = this.h.t.a(paramInt);
    if ((this.m > 0) && (this.n > 0) && ((paramView.mediaWidth < this.m) || (paramView.mediaHeight < this.n)))
    {
      c(String.format(this.c.getString(2064187420), new Object[] { Integer.valueOf(this.m), Integer.valueOf(this.n) }));
      return;
    }
    if (a(paramView.path, paramView))
    {
      c(this.c.getString(2064187421));
      return;
    }
    b(paramView.path);
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    if ((!d()) && (this.h.t.a(paramInt).selectStatus != 1))
    {
      c(String.format(this.c.getString(2064187561), new Object[] { Integer.valueOf(this.e.maxSelectNum) }));
      return;
    }
    super.a(paramView, paramInt, paramCheckBox);
  }
  
  protected void a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", new ArrayList(Collections.singletonList(paramString)));
    this.c.setResult(-1, localIntent);
    this.c.finish();
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (paramLocalMediaInfo == null) {
      return false;
    }
    if ((paramLocalMediaInfo.selectStatus == 2) && (paramBoolean) && (!d()))
    {
      c(String.format(this.c.getString(2064187561), new Object[] { Integer.valueOf(this.e.maxSelectNum) }));
      return false;
    }
    return super.a(paramLocalMediaInfo, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.gallery.PhotoListCustomizationAECapture
 * JD-Core Version:    0.7.0.1
 */