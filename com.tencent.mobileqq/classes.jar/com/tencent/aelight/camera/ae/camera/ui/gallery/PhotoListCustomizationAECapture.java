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
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private CameraPeakServiceHandler jdField_a_of_type_ComTencentAelightCameraAeConfigCameraPeakServiceHandler = (CameraPeakServiceHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(PeakAppInterface.d);
  private CameraPeakServiceObserver jdField_a_of_type_ComTencentAelightCameraAeConfigCameraPeakServiceObserver;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = QQStoryContext.a();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public PhotoListCustomizationAECapture(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
    paramAbstractPhotoListActivity = paramAbstractPhotoListActivity.getIntent();
    if (paramAbstractPhotoListActivity != null)
    {
      this.jdField_a_of_type_Int = paramAbstractPhotoListActivity.getIntExtra("MaterialConfig.minImageWidth", 0);
      this.b = paramAbstractPhotoListActivity.getIntExtra("MaterialConfig.minImageHeight", 0);
      this.jdField_a_of_type_Boolean = paramAbstractPhotoListActivity.getBooleanExtra("MaterialConfig.needFace", false);
    }
  }
  
  private void a(String paramString, boolean paramBoolean, int paramInt)
  {
    k();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    }
    if (paramBoolean)
    {
      if ((paramInt != 0) && (paramInt != -2))
      {
        if (paramInt == -1) {
          c(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getString(2064515091));
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
        if (!this.jdField_a_of_type_Boolean)
        {
          a(paramString);
          return;
        }
        c(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getString(2064515094));
        return;
      }
      c(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getString(2064515092));
    }
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum;
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
    }
    CameraPeakServiceObserver localCameraPeakServiceObserver = this.jdField_a_of_type_ComTencentAelightCameraAeConfigCameraPeakServiceObserver;
    if (localCameraPeakServiceObserver != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(localCameraPeakServiceObserver);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeConfigCameraPeakServiceObserver = new PhotoListCustomizationAECapture.1(this, paramString);
    d();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentAelightCameraAeConfigCameraPeakServiceObserver);
    this.jdField_a_of_type_ComTencentAelightCameraAeConfigCameraPeakServiceHandler.b(paramString);
  }
  
  private void c(String paramString)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.b >= 1000L)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.b = l;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, paramString, 0).a();
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.isFinishing()))
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, 2131756189);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559561);
        ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372646)).setText(2064515095);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new PhotoListCustomizationAECapture.2(this));
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.isFinishing()))
    {
      Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
      if ((localDialog != null) && (localDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
    }
  }
  
  public void a()
  {
    super.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getString(2064515093);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(" ");
    localStringBuilder.append(i);
    localStringBuilder.append("/");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum);
    str = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton.setText(str);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    if (a())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130850104);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837911);
  }
  
  public void a(View paramView)
  {
    if (a())
    {
      c(String.format(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getString(2064515215), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) }));
      return;
    }
    if (!NetworkUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity))
    {
      c(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getString(2064515092));
      return;
    }
    paramView = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.get(0);
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap.get(paramView);
    if ((this.jdField_a_of_type_Int > 0) && (this.b > 0) && (localLocalMediaInfo != null) && ((localLocalMediaInfo.mediaWidth < this.jdField_a_of_type_Int) || (localLocalMediaInfo.mediaHeight < this.b)))
    {
      c(String.format(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getString(2064515090), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b) }));
      return;
    }
    if (a(paramView, localLocalMediaInfo))
    {
      c(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getString(2064515091));
      return;
    }
    b(paramView);
  }
  
  public void a(View paramView, int paramInt)
  {
    if (!NetworkUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity))
    {
      c(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getString(2064515092));
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(paramInt);
    if ((this.jdField_a_of_type_Int > 0) && (this.b > 0) && ((paramView.mediaWidth < this.jdField_a_of_type_Int) || (paramView.mediaHeight < this.b)))
    {
      c(String.format(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getString(2064515090), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b) }));
      return;
    }
    if (a(paramView.path, paramView))
    {
      c(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getString(2064515091));
      return;
    }
    b(paramView.path);
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    if ((!a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(paramInt).selectStatus != 1))
    {
      c(String.format(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getString(2064515214), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) }));
      return;
    }
    super.a(paramView, paramInt, paramCheckBox);
  }
  
  protected void a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", new ArrayList(Collections.singletonList(paramString)));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (paramLocalMediaInfo == null) {
      return false;
    }
    if ((paramLocalMediaInfo.selectStatus == 2) && (paramBoolean) && (!a()))
    {
      c(String.format(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getString(2064515214), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) }));
      return false;
    }
    return super.a(paramLocalMediaInfo, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.gallery.PhotoListCustomizationAECapture
 * JD-Core Version:    0.7.0.1
 */