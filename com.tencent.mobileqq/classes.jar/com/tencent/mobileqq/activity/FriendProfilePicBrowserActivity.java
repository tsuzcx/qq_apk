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
  Handler a = new Handler();
  FriendProfileCardPicScene b;
  int c;
  ArrayList<String> d;
  private Button e;
  private ImageView f;
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
    finish();
  }
  
  private void c()
  {
    Object localObject = getIntent().getExtras();
    this.c = ((Bundle)localObject).getInt("fromType", 0);
    this.mIndex = ((Bundle)localObject).getInt("index", 0);
    if (this.mIndex < 0) {
      this.mIndex = 0;
    }
    this.mPicInfos = null;
    this.mPicInfos = ((Bundle)localObject).getParcelableArrayList("picInfos");
    int i = this.c;
    if (i == 1)
    {
      localObject = ((DynamicAvatarManager)this.app.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).a(this.app.getCurrentAccountUin());
      PicInfo localPicInfo = new PicInfo();
      if (localObject != null) {
        if (!TextUtils.isEmpty(((DynamicAvatar)localObject).basicBigUrl)) {
          localPicInfo.e = ((DynamicAvatar)localObject).basicBigUrl;
        } else if (!TextUtils.isEmpty(((DynamicAvatar)localObject).basicSmallUrl)) {
          localPicInfo.e = ((DynamicAvatar)localObject).basicSmallUrl;
        }
      }
      if (!TextUtils.isEmpty(localPicInfo.e))
      {
        this.mPicInfos = new ArrayList();
        this.mPicInfos.add(localPicInfo);
      }
    }
    else if (i == 2)
    {
      this.d = ((Bundle)localObject).getStringArrayList("fileIdList");
    }
  }
  
  private boolean d()
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
  
  private File e()
  {
    PicInfo localPicInfo = this.b.F();
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
    if (!TextUtils.isEmpty(localPicInfo.d)) {
      return new File(localPicInfo.d);
    }
    return AbsDownloader.getFile(localPicInfo.b);
  }
  
  private void f()
  {
    File localFile = e();
    if (localFile == null) {
      return;
    }
    ProfileCardUtil.a(localFile.getAbsolutePath(), this);
  }
  
  private void g()
  {
    File localFile = e();
    if (localFile == null) {
      return;
    }
    ProfileCardUtil.a(localFile.getAbsolutePath(), this.app, this);
  }
  
  private void h()
  {
    File localFile = e();
    if (localFile == null) {
      return;
    }
    ProfileCardUtil.b(localFile.getAbsolutePath(), this.app, this);
  }
  
  private void i()
  {
    File localFile = e();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfilePicBrowserActivity", 2, "savePic, file is null");
      }
      return;
    }
    AIOGalleryUtils.a(this, localFile, Utils.Crc64String(localFile.getAbsolutePath()));
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfilePicBrowserActivity", 2, "deletePic");
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 0);
    localQQCustomDialog.setMessage(getString(2131888424)).setCancelable(true);
    localQQCustomDialog.setNegativeButton(2131887648, new FriendProfilePicBrowserActivity.2(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButton(2131887629, new FriendProfilePicBrowserActivity.3(this, localQQCustomDialog));
    if (!isFinishing()) {
      localQQCustomDialog.show();
    }
  }
  
  private String k()
  {
    Object localObject = this.b;
    int i;
    if (localObject != null) {
      i = ((FriendProfileCardPicScene)localObject).G();
    } else {
      i = -1;
    }
    if ((i >= 0) && (i < this.d.size())) {
      localObject = (String)this.d.get(i);
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
  
  public void a()
  {
    Object localObject = this.e;
    if (localObject != null) {
      ((Button)localObject).setVisibility(8);
    }
    localObject = this.f;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    FriendProfileCardPicScene localFriendProfileCardPicScene = this.b;
    if ((localFriendProfileCardPicScene != null) && (localFriendProfileCardPicScene.G() == paramInt1)) {
      this.e.setEnabled(false);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    FriendProfileCardPicScene localFriendProfileCardPicScene = this.b;
    if ((localFriendProfileCardPicScene != null) && (localFriendProfileCardPicScene.G() == paramInt)) {
      this.e.setEnabled(true);
    }
  }
  
  public void b()
  {
    boolean bool = this.b.f();
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
    ((ActionSheet)localObject).addButton(2131890804);
    ((ActionSheet)localObject).addButton(2131889841);
    ((ActionSheet)localObject).addButton(HardCodeUtil.a(2131902913));
    ((ActionSheet)localObject).addButton(2131889837);
    if (this.c == 2) {
      ((ActionSheet)localObject).addButton(HardCodeUtil.a(2131902873), 3);
    }
    ((ActionSheet)localObject).addCancelButton(HardCodeUtil.a(2131898212));
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
    boolean bool = d();
    int j = 0;
    if (!bool)
    {
      finish();
      return false;
    }
    getWindow().setFlags(1024, 1024);
    this.mGalleryManager = new FriendProfilePicBrowserActivity.FriendProfileGalleryManager(this);
    super.doOnCreate(paramBundle);
    this.e = ((Button)findViewById(2131445711));
    this.e.setOnClickListener(this);
    this.e.setEnabled(false);
    this.f = ((ImageView)findViewById(2131433940));
    this.f.setContentDescription(HardCodeUtil.a(2131902917));
    this.f.setOnClickListener(this);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.b.a(false);
    int i = this.c;
    if (i == 1)
    {
      this.e.setVisibility(4);
      i = j;
      if (this.mPicInfos != null)
      {
        i = j;
        if (this.mPicInfos.size() > 0)
        {
          i = j;
          if (!TextUtils.isEmpty(((PicInfo)this.mPicInfos.get(0)).e))
          {
            this.f.setVisibility(4);
            this.b.a(true);
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
    FriendProfileCardPicScene localFriendProfileCardPicScene = this.b;
    if (localFriendProfileCardPicScene != null) {
      localFriendProfileCardPicScene.H();
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
    if (i != 2131433940)
    {
      if (i == 2131445711)
      {
        Intent localIntent = getIntent();
        localIntent.putExtra("setHead_fileid", k());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfilePicBrowserActivity
 * JD-Core Version:    0.7.0.1
 */