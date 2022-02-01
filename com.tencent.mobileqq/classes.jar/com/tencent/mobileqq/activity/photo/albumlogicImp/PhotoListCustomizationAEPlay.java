package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.aelight.camera.play.api.IAETemplateInfo;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class PhotoListCustomizationAEPlay
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAEPlay";
  
  PhotoListCustomizationAEPlay(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  private void a(String paramString)
  {
    long l = System.currentTimeMillis();
    if (l - this.b.H >= 1000L)
    {
      this.b.H = l;
      QQToast.makeText(this.c, paramString, 0).show();
    }
  }
  
  private boolean d()
  {
    NewPhotoListActivity localNewPhotoListActivity = this.c;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localNewPhotoListActivity != null)
    {
      bool1 = bool2;
      if (this.c.getIntent() != null) {
        bool1 = this.c.getIntent().getBooleanExtra("pic_back_type_result", false);
      }
    }
    return bool1;
  }
  
  private void g(Intent paramIntent)
  {
    this.c.setResult(-1, paramIntent);
    this.c.finish();
  }
  
  private boolean w()
  {
    return this.e.selectedPhotoList.size() < this.e.maxSelectNum;
  }
  
  public void a()
  {
    super.a();
    String str = this.c.getString(2131914046);
    int i = this.e.selectedPhotoList.size();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(" ");
    localStringBuilder.append(i);
    localStringBuilder.append("/");
    localStringBuilder.append(this.e.maxSelectNum);
    str = localStringBuilder.toString();
    this.h.o.setText(str);
    this.h.o.setEnabled(true);
    if (w())
    {
      this.h.o.setBackgroundResource(2130851880);
      return;
    }
    this.h.o.setBackgroundResource(2130837935);
  }
  
  public void a(View paramView)
  {
    if (w())
    {
      a(String.format(this.c.getString(2131886358), new Object[] { Integer.valueOf(this.e.maxSelectNum) }));
      return;
    }
    this.h.o.setClickable(false);
    paramView = new Intent();
    paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.e.selectedPhotoList);
    paramView.putExtra("pic_choose_in_node_id", this.c.getIntent().getIntExtra("pic_choose_in_node_id", 0));
    paramView.putExtra("pic_result_back_type", 0);
    ((IAETemplateInfo)QRoute.api(IAETemplateInfo.class)).sendPickedPhotosToMe(this.c, paramView);
    ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportPicChooseNextBtn();
    g(paramView);
  }
  
  public void a(View paramView, int paramInt)
  {
    LocalMediaInfo localLocalMediaInfo = this.h.t.a(paramInt);
    Intent localIntent = new Intent();
    boolean bool = d();
    paramView = "";
    if (bool)
    {
      if (localLocalMediaInfo != null) {
        paramView = localLocalMediaInfo.path;
      }
      localIntent.putExtra("PhotoConst.SELECTED_PATHS", paramView);
    }
    else
    {
      if (localLocalMediaInfo != null) {
        paramView = localLocalMediaInfo.path;
      }
      localIntent.putExtra("PhotoConst.SELECTED_PATHS", paramView);
      localIntent.putExtra("pic_choose_in_node_id", this.c.getIntent().getIntExtra("pic_choose_in_node_id", 0));
      localIntent.putExtra("pic_result_back_type", 1);
      ((IAETemplateInfo)QRoute.api(IAETemplateInfo.class)).sendPickedPhotosToMe(this.c, localIntent);
    }
    g(localIntent);
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    if ((!w()) && (this.h.t.a(paramInt).selectStatus != 1))
    {
      a(String.format(this.c.getString(2131886357), new Object[] { Integer.valueOf(this.e.maxSelectNum) }));
      return;
    }
    super.a(paramView, paramInt, paramCheckBox);
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (paramLocalMediaInfo == null) {
      return false;
    }
    if ((paramLocalMediaInfo.selectStatus == 2) && (paramBoolean) && (!w()))
    {
      a(String.format(this.c.getString(2131886357), new Object[] { Integer.valueOf(this.e.maxSelectNum) }));
      return false;
    }
    return super.a(paramLocalMediaInfo, paramBoolean);
  }
  
  public void c(View paramView)
  {
    super.c(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAEPlay
 * JD-Core Version:    0.7.0.1
 */