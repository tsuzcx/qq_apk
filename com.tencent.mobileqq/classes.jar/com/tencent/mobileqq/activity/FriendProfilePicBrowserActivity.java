package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserImage.OnLoadListener;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.profile.FriendProfileCardPicScene;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.util.ArrayList;
import sqq;
import sqr;
import sqs;
import sqt;

public class FriendProfilePicBrowserActivity
  extends PicBrowserActivity
  implements DialogInterface.OnCancelListener, View.OnClickListener, PicBrowserImage.OnLoadListener
{
  public int a;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public FriendProfileCardPicScene a;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  private String a()
  {
    int i = -1;
    String str2 = "";
    if (this.jdField_a_of_type_ComTencentMobileqqProfileFriendProfileCardPicScene != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqProfileFriendProfileCardPicScene.a();
    }
    String str1 = str2;
    if (i >= 0)
    {
      str1 = str2;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
        str1 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfilePicBrowserActivity", 2, "getCurrFileId, index=" + i + ",fileId=" + str1);
    }
    return str1;
  }
  
  private boolean a()
  {
    boolean bool = true;
    int j = 0;
    Object localObject2 = getIntent().getExtras();
    int i = ((Bundle)localObject2).getInt("fromType", 0);
    int k = ((Bundle)localObject2).getInt("index", 0);
    Object localObject1 = ((Bundle)localObject2).getParcelableArrayList("picInfos");
    localObject2 = ((Bundle)localObject2).getStringArrayList("fileIdList");
    if (i == 1)
    {
      if ((localObject1 == null) || (((ArrayList)localObject1).size() != 1)) {
        break label200;
      }
      StringBuilder localStringBuilder = new StringBuilder().append("checkData: ").append(bool).append(",").append(i).append(",").append(k).append(",");
      if (localObject1 != null) {
        break label206;
      }
      i = 0;
      label118:
      localObject1 = localStringBuilder.append(i).append(",");
      if (localObject2 != null) {
        break label215;
      }
    }
    label200:
    label206:
    label215:
    for (i = j;; i = ((ArrayList)localObject2).size())
    {
      QLog.d("FriendProfilePicBrowserActivity", 2, i);
      return bool;
      if ((i == 2) && (localObject1 != null) && (((ArrayList)localObject1).size() > 0) && (localObject2 != null) && (((ArrayList)localObject2).size() > 0) && (((ArrayList)localObject1).size() == ((ArrayList)localObject2).size())) {
        break;
      }
      bool = false;
      break;
      i = ((ArrayList)localObject1).size();
      break label118;
    }
  }
  
  private void f()
  {
    Object localObject = getIntent().getExtras();
    this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("fromType", 0);
    this.jdField_b_of_type_Int = ((Bundle)localObject).getInt("index", 0);
    if (this.jdField_b_of_type_Int < 0) {
      this.jdField_b_of_type_Int = 0;
    }
    this.jdField_b_of_type_JavaUtilArrayList = null;
    this.jdField_b_of_type_JavaUtilArrayList = ((Bundle)localObject).getParcelableArrayList("picInfos");
    if (this.jdField_a_of_type_Int == 1)
    {
      localObject = ((DynamicAvatarManager)this.app.getManager(179)).a(this.app.getCurrentAccountUin());
      localPicInfo = new PicInfo();
      if (localObject != null)
      {
        if (TextUtils.isEmpty(((DynamicAvatar)localObject).basicBigUrl)) {
          break label150;
        }
        localPicInfo.d = ((DynamicAvatar)localObject).basicBigUrl;
      }
    }
    label150:
    while (this.jdField_a_of_type_Int != 2)
    {
      PicInfo localPicInfo;
      for (;;)
      {
        if (!TextUtils.isEmpty(localPicInfo.d))
        {
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
          this.jdField_b_of_type_JavaUtilArrayList.add(localPicInfo);
        }
        return;
        if (!TextUtils.isEmpty(((DynamicAvatar)localObject).basicSmallUrl)) {
          localPicInfo.d = ((DynamicAvatar)localObject).basicSmallUrl;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList = ((Bundle)localObject).getStringArrayList("fileIdList");
  }
  
  private void g()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfileFriendProfileCardPicScene.a();
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfilePicBrowserActivity", 2, "savePic, curPicInfo=" + localObject);
    }
    if (localObject == null) {
      return;
    }
    if (!TextUtils.isEmpty(((PicInfo)localObject).c)) {
      String str = ((PicInfo)localObject).c;
    }
    for (localObject = new File(((PicInfo)localObject).c);; localObject = AbsDownloader.a(((PicInfo)localObject).a))
    {
      if (localObject != null) {
        break label109;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FriendProfilePicBrowserActivity", 2, "savePic, file is null");
      return;
      AbsDownloader.d(((PicInfo)localObject).a);
    }
    label109:
    AIOGalleryUtils.a(this, (File)localObject, Utils.Crc64String(((File)localObject).getAbsolutePath()));
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfilePicBrowserActivity", 2, "deletePic");
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 0);
    localQQCustomDialog.setMessage(getString(2131435916)).setCancelable(true);
    localQQCustomDialog.setNegativeButton(2131432998, new sqr(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButton(2131433680, new sqs(this, localQQCustomDialog));
    if (!isFinishing()) {
      localQQCustomDialog.show();
    }
  }
  
  protected void a()
  {
    super.a();
    f();
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileFriendProfileCardPicScene != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileFriendProfileCardPicScene.a() == paramInt1)) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileFriendProfileCardPicScene != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileFriendProfileCardPicScene.a() == paramInt)) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void c()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqProfileFriendProfileCardPicScene.f();
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfilePicBrowserActivity", 2, "showActionSheet, ,forbid=" + bool);
    }
    if (bool) {
      return;
    }
    ActionSheet localActionSheet = ActionSheet.a(this, false);
    localActionSheet.c("保存到手机");
    if (this.jdField_a_of_type_Int == 2) {
      localActionSheet.a("删除照片", 3);
    }
    localActionSheet.d("取消");
    localActionSheet.a(new sqq(this, localActionSheet));
    localActionSheet.show();
    ReportController.b(this.app, "dc00898", "", "", "0X8007C13", "0X8007C13", 0, 0, "", "", "", "");
  }
  
  public void doOnBackPressed()
  {
    b();
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (!a())
    {
      finish();
      return false;
    }
    getWindow().setFlags(1024, 1024);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager = new sqt(this);
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131371035));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369052));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("更多");
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.jdField_a_of_type_ComTencentMobileqqProfileFriendProfileCardPicScene.a(false);
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) || (TextUtils.isEmpty(((PicInfo)this.jdField_b_of_type_JavaUtilArrayList.get(0)).d))) {
        break label284;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqProfileFriendProfileCardPicScene.a(true);
    }
    label284:
    for (int i = 1;; i = 0)
    {
      QQAppInterface localQQAppInterface = this.app;
      if (i != 0)
      {
        paramBundle = "1";
        ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8007103", "0X8007103", 0, 0, paramBundle, "", "", "");
      }
      for (;;)
      {
        return true;
        paramBundle = "0";
        break;
        if (this.jdField_a_of_type_Int == 2) {
          ReportController.b(this.app, "dc00898", "", "", "0X8007C11", "0X8007C11", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqProfileFriendProfileCardPicScene != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileFriendProfileCardPicScene.s();
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
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131371035: 
      paramView = getIntent();
      paramView.putExtra("setHead_fileid", a());
      setResult(-1, paramView);
      finish();
      ReportController.b(this.app, "dc00898", "", "", "0X8007C12", "0X8007C12", 0, 0, "", "", "", "");
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfilePicBrowserActivity
 * JD-Core Version:    0.7.0.1
 */