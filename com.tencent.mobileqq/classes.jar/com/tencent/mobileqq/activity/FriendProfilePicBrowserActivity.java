package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.picbrowser.PicBrowserActivity;
import com.tencent.mobileqq.picbrowser.PicBrowserImage.OnLoadListener;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.profile.FriendProfileCardPicScene;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.util.ArrayList;

public class FriendProfilePicBrowserActivity
  extends PicBrowserActivity
  implements DialogInterface.OnCancelListener, View.OnClickListener, PicBrowserImage.OnLoadListener
{
  int jdField_a_of_type_Int;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  FriendProfileCardPicScene jdField_a_of_type_ComTencentMobileqqProfileFriendProfileCardPicScene;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  
  private File a()
  {
    PicInfo localPicInfo = this.jdField_a_of_type_ComTencentMobileqqProfileFriendProfileCardPicScene.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurPicPathUrl, curPicInfo=");
      localStringBuilder.append(localPicInfo);
      QLog.d("FriendProfilePicBrowserActivity", 2, localStringBuilder.toString());
    }
    if (localPicInfo == null) {
      return null;
    }
    if (!TextUtils.isEmpty(localPicInfo.c)) {
      return new File(localPicInfo.c);
    }
    return AbsDownloader.getFile(localPicInfo.a);
  }
  
  private String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfileFriendProfileCardPicScene;
    int i;
    if (localObject != null) {
      i = ((FriendProfileCardPicScene)localObject).a();
    } else {
      i = -1;
    }
    if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
    } else {
      localObject = "";
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurrFileId, index=");
      localStringBuilder.append(i);
      localStringBuilder.append(",fileId=");
      localStringBuilder.append((String)localObject);
      QLog.d("FriendProfilePicBrowserActivity", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
    finish();
  }
  
  private boolean a()
  {
    Object localObject = getIntent().getExtras();
    int j = 0;
    int i = ((Bundle)localObject).getInt("fromType", 0);
    int k = ((Bundle)localObject).getInt("index", 0);
    ArrayList localArrayList = ((Bundle)localObject).getParcelableArrayList("picInfos");
    localObject = ((Bundle)localObject).getStringArrayList("fileIdList");
    boolean bool = true;
    if (i == 1 ? (localArrayList != null) && (localArrayList.size() == 1) : (i != 2) || (localArrayList == null) || (localArrayList.size() <= 0) || (localObject == null) || (((ArrayList)localObject).size() <= 0) || (localArrayList.size() != ((ArrayList)localObject).size())) {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkData: ");
    localStringBuilder.append(bool);
    localStringBuilder.append(",");
    localStringBuilder.append(i);
    localStringBuilder.append(",");
    localStringBuilder.append(k);
    localStringBuilder.append(",");
    if (localArrayList == null) {
      i = 0;
    } else {
      i = localArrayList.size();
    }
    localStringBuilder.append(i);
    localStringBuilder.append(",");
    if (localObject == null) {
      i = j;
    } else {
      i = ((ArrayList)localObject).size();
    }
    localStringBuilder.append(i);
    QLog.d("FriendProfilePicBrowserActivity", 2, localStringBuilder.toString());
    return bool;
  }
  
  private void c()
  {
    Object localObject = getIntent().getExtras();
    this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("fromType", 0);
    this.mIndex = ((Bundle)localObject).getInt("index", 0);
    if (this.mIndex < 0) {
      this.mIndex = 0;
    }
    this.mPicInfos = null;
    this.mPicInfos = ((Bundle)localObject).getParcelableArrayList("picInfos");
    int i = this.jdField_a_of_type_Int;
    if (i == 1)
    {
      localObject = ((DynamicAvatarManager)this.app.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).a(this.app.getCurrentAccountUin());
      PicInfo localPicInfo = new PicInfo();
      if (localObject != null) {
        if (!TextUtils.isEmpty(((DynamicAvatar)localObject).basicBigUrl)) {
          localPicInfo.d = ((DynamicAvatar)localObject).basicBigUrl;
        } else if (!TextUtils.isEmpty(((DynamicAvatar)localObject).basicSmallUrl)) {
          localPicInfo.d = ((DynamicAvatar)localObject).basicSmallUrl;
        }
      }
      if (!TextUtils.isEmpty(localPicInfo.d))
      {
        this.mPicInfos = new ArrayList();
        this.mPicInfos.add(localPicInfo);
      }
    }
    else if (i == 2)
    {
      this.jdField_a_of_type_JavaUtilArrayList = ((Bundle)localObject).getStringArrayList("fileIdList");
    }
  }
  
  private void d()
  {
    File localFile = a();
    if (localFile == null) {
      return;
    }
    ProfileCardUtil.a(localFile.getAbsolutePath(), this);
  }
  
  private void e()
  {
    File localFile = a();
    if (localFile == null) {
      return;
    }
    ProfileCardUtil.a(localFile.getAbsolutePath(), this.app, this);
  }
  
  private void f()
  {
    File localFile = a();
    if (localFile == null) {
      return;
    }
    ProfileCardUtil.b(localFile.getAbsolutePath(), this.app, this);
  }
  
  private void g()
  {
    File localFile = a();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfilePicBrowserActivity", 2, "savePic, file is null");
      }
      return;
    }
    AIOGalleryUtils.a(this, localFile, Utils.Crc64String(localFile.getAbsolutePath()));
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfilePicBrowserActivity", 2, "deletePic");
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 0);
    localQQCustomDialog.setMessage(getString(2131691466)).setCancelable(true);
    localQQCustomDialog.setNegativeButton(2131690728, new FriendProfilePicBrowserActivity.2(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButton(2131690709, new FriendProfilePicBrowserActivity.3(this, localQQCustomDialog));
    if (!isFinishing()) {
      localQQCustomDialog.show();
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetButton;
    if (localObject != null) {
      ((Button)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    FriendProfileCardPicScene localFriendProfileCardPicScene = this.jdField_a_of_type_ComTencentMobileqqProfileFriendProfileCardPicScene;
    if ((localFriendProfileCardPicScene != null) && (localFriendProfileCardPicScene.a() == paramInt1)) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    FriendProfileCardPicScene localFriendProfileCardPicScene = this.jdField_a_of_type_ComTencentMobileqqProfileFriendProfileCardPicScene;
    if ((localFriendProfileCardPicScene != null) && (localFriendProfileCardPicScene.a() == paramInt)) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    }
  }
  
  public void b()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqProfileFriendProfileCardPicScene.f();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showActionSheet, ,forbid=");
      ((StringBuilder)localObject).append(bool);
      QLog.d("FriendProfilePicBrowserActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (bool) {
      return;
    }
    Object localObject = ActionSheet.createFullScreenDialog(this, false);
    ((ActionSheet)localObject).addButton(2131693256);
    ((ActionSheet)localObject).addButton(2131692770);
    ((ActionSheet)localObject).addButton(HardCodeUtil.a(2131705022));
    ((ActionSheet)localObject).addButton(2131692766);
    if (this.jdField_a_of_type_Int == 2) {
      ((ActionSheet)localObject).addButton(HardCodeUtil.a(2131704982), 3);
    }
    ((ActionSheet)localObject).addCancelButton(HardCodeUtil.a(2131705023));
    ((ActionSheet)localObject).setOnButtonClickListener(new FriendProfilePicBrowserActivity.1(this, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
    ReportController.b(this.app, "dc00898", "", "", "0X8007C13", "0X8007C13", 0, 0, "", "", "", "");
    ReportController.b(this.app, "dc00898", "", "", "0X800A8C9", "0X800A8C9", 0, 0, "1", "", "", "");
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 21)) {
      a(paramIntent.getExtras());
    }
  }
  
  public void doOnBackPressed()
  {
    a();
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = a();
    int j = 0;
    if (!bool)
    {
      finish();
      return false;
    }
    getWindow().setFlags(1024, 1024);
    this.mGalleryManager = new FriendProfilePicBrowserActivity.FriendProfileGalleryManager(this);
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131377323));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367437));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131705027));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.jdField_a_of_type_ComTencentMobileqqProfileFriendProfileCardPicScene.a(false);
    int i = this.jdField_a_of_type_Int;
    if (i == 1)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      i = j;
      if (this.mPicInfos != null)
      {
        i = j;
        if (this.mPicInfos.size() > 0)
        {
          i = j;
          if (!TextUtils.isEmpty(((PicInfo)this.mPicInfos.get(0)).d))
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
            this.jdField_a_of_type_ComTencentMobileqqProfileFriendProfileCardPicScene.a(true);
            i = 1;
          }
        }
      }
      QQAppInterface localQQAppInterface = this.app;
      if (i != 0) {
        paramBundle = "1";
      } else {
        paramBundle = "0";
      }
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8007103", "0X8007103", 0, 0, paramBundle, "", "", "");
      return true;
    }
    if (i == 2) {
      ReportController.b(this.app, "dc00898", "", "", "0X8007C11", "0X8007C11", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    FriendProfileCardPicScene localFriendProfileCardPicScene = this.jdField_a_of_type_ComTencentMobileqqProfileFriendProfileCardPicScene;
    if (localFriendProfileCardPicScene != null) {
      localFriendProfileCardPicScene.u();
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    finish();
  }
  
  protected void doOnPause()
  {
    AbstractGifImage.pauseAll();
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    AbstractGifImage.resumeAll();
    super.doOnResume();
  }
  
  protected void initData()
  {
    super.initData();
    c();
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    finish();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131367437)
    {
      if (i == 2131377323)
      {
        Intent localIntent = getIntent();
        localIntent.putExtra("setHead_fileid", a());
        setResult(-1, localIntent);
        finish();
        ReportController.b(this.app, "dc00898", "", "", "0X8007C12", "0X8007C12", 0, 0, "", "", "", "");
      }
    }
    else {
      b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfilePicBrowserActivity
 * JD-Core Version:    0.7.0.1
 */