package com.tencent.mobileqq.activity;

import abhd;
import abhe;
import abhf;
import abhg;
import actn;
import aehy;
import ajyc;
import alyz;
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
import atod;
import ausv;
import axqw;
import ayog;
import bazo;
import bbcv;
import bbgg;
import bfol;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class FriendProfilePicBrowserActivity
  extends PicBrowserActivity
  implements DialogInterface.OnCancelListener, View.OnClickListener, atod
{
  public int a;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public ausv a;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  
  private File a()
  {
    PicInfo localPicInfo = this.jdField_a_of_type_Ausv.a();
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfilePicBrowserActivity", 2, "getCurPicPathUrl, curPicInfo=" + localPicInfo);
    }
    if (localPicInfo == null) {
      return null;
    }
    if (!TextUtils.isEmpty(localPicInfo.c)) {
      return new File(localPicInfo.c);
    }
    return ayog.a(localPicInfo.a);
  }
  
  private String a()
  {
    int i = -1;
    String str2 = "";
    if (this.jdField_a_of_type_Ausv != null) {
      i = this.jdField_a_of_type_Ausv.a();
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
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = actn.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
    finish();
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
      localObject = ((alyz)this.app.getManager(180)).a(this.app.getCurrentAccountUin());
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
    File localFile = a();
    if (localFile == null) {
      return;
    }
    bazo.a(localFile.getAbsolutePath(), this);
  }
  
  private void h()
  {
    File localFile = a();
    if (localFile == null) {
      return;
    }
    bazo.a(localFile.getAbsolutePath(), this.app, this);
  }
  
  private void i()
  {
    File localFile = a();
    if (localFile == null) {
      return;
    }
    bazo.b(localFile.getAbsolutePath(), this.app, this);
  }
  
  private void j()
  {
    File localFile = a();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfilePicBrowserActivity", 2, "savePic, file is null");
      }
      return;
    }
    aehy.a(this, localFile, Utils.Crc64String(localFile.getAbsolutePath()));
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfilePicBrowserActivity", 2, "deletePic");
    }
    bbgg localbbgg = bbcv.a(this, 0);
    localbbgg.setMessage(getString(2131691490)).setCancelable(true);
    localbbgg.setNegativeButton(2131690596, new abhe(this, localbbgg));
    localbbgg.setPositiveButton(2131690575, new abhf(this, localbbgg));
    if (!isFinishing()) {
      localbbgg.show();
    }
  }
  
  public void a()
  {
    super.a();
    f();
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Ausv != null) && (this.jdField_a_of_type_Ausv.a() == paramInt1)) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Ausv != null) && (this.jdField_a_of_type_Ausv.a() == paramInt)) {
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
    boolean bool = this.jdField_a_of_type_Ausv.f();
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfilePicBrowserActivity", 2, "showActionSheet, ,forbid=" + bool);
    }
    if (bool) {
      return;
    }
    bfol localbfol = bfol.a(this, false);
    localbfol.b(2131693383);
    localbfol.b(2131692909);
    localbfol.c(ajyc.a(2131704920));
    localbfol.b(2131692905);
    if (this.jdField_a_of_type_Int == 2) {
      localbfol.a(ajyc.a(2131704879), 3);
    }
    localbfol.d(ajyc.a(2131704921));
    localbfol.a(new abhd(this, localbfol));
    localbfol.show();
    axqw.b(this.app, "dc00898", "", "", "0X8007C13", "0X8007C13", 0, 0, "", "", "", "");
    axqw.b(this.app, "dc00898", "", "", "0X800A8C9", "0X800A8C9", 0, 0, "1", "", "", "");
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 21)) {
      a(paramIntent.getExtras());
    }
  }
  
  public void doOnBackPressed()
  {
    b();
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (!a())
    {
      finish();
      return false;
    }
    getWindow().setFlags(1024, 1024);
    this.jdField_a_of_type_Xpz = new abhg(this);
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131375958));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366902));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajyc.a(2131704925));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.jdField_a_of_type_Ausv.a(false);
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) || (TextUtils.isEmpty(((PicInfo)this.jdField_b_of_type_JavaUtilArrayList.get(0)).d))) {
        break label287;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_Ausv.a(true);
    }
    label287:
    for (int i = 1;; i = 0)
    {
      QQAppInterface localQQAppInterface = this.app;
      if (i != 0)
      {
        paramBundle = "1";
        axqw.b(localQQAppInterface, "dc00898", "", "", "0X8007103", "0X8007103", 0, 0, paramBundle, "", "", "");
      }
      for (;;)
      {
        return true;
        paramBundle = "0";
        break;
        if (this.jdField_a_of_type_Int == 2) {
          axqw.b(this.app, "dc00898", "", "", "0X8007C11", "0X8007C11", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Ausv != null) {
      this.jdField_a_of_type_Ausv.u();
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    finish();
  }
  
  public void doOnPause()
  {
    AbstractGifImage.pauseAll();
    super.doOnPause();
  }
  
  public void doOnResume()
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
    case 2131375958: 
      paramView = getIntent();
      paramView.putExtra("setHead_fileid", a());
      setResult(-1, paramView);
      finish();
      axqw.b(this.app, "dc00898", "", "", "0X8007C12", "0X8007C12", 0, 0, "", "", "", "");
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfilePicBrowserActivity
 * JD-Core Version:    0.7.0.1
 */