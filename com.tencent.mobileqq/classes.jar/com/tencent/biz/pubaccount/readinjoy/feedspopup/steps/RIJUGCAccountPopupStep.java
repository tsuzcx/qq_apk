package com.tencent.biz.pubaccount.readinjoy.feedspopup.steps;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.BasePopupStep;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.RIJPopupAutomator;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSLiteSwitchManager;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils.RIJUGCAccountStatusCheckCallback;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class RIJUGCAccountPopupStep
  extends BasePopupStep
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "https://pub.idqqimg.com/pc/misc/files/20200416/3c376048a60b488d998e1ef31153db5e.png", "https://pub.idqqimg.com/pc/misc/files/20200416/54aaad879a4042899540fafd969395f6.png", "https://pub.idqqimg.com/pc/misc/files/20200416/8b787675714740eeb21c7fc5b15712c0.png", "https://pub.idqqimg.com/pc/misc/files/20200416/1263e35cec174f0db53e0fc3bb8e7df2.png", "https://pub.idqqimg.com/pc/misc/files/20200430/21b88f2ba3bd43919173a767982d649d.png", "https://pub.idqqimg.com/pc/misc/files/20201030/894f73da508f4e45b4defab92dfa40c2.png", "https://pub.idqqimg.com/pc/misc/files/20200430/eb40275894c9455f9ab438dd91081678.png" };
  private Activity jdField_a_of_type_AndroidAppActivity;
  private boolean jdField_a_of_type_Boolean = false;
  
  public RIJUGCAccountPopupStep(@NonNull RIJPopupAutomator paramRIJPopupAutomator, Activity paramActivity)
  {
    super(paramRIJPopupAutomator, "RIJUGCAccountPopupStep");
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    j();
  }
  
  private boolean b()
  {
    boolean bool2 = StudyModeManager.a();
    boolean bool3 = RIJUgcUtils.a();
    boolean bool4 = PTSLiteSwitchManager.a().a();
    if ((!bool2) && (bool3) && (bool4)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.i("RIJUGCAccountPopupStep", 2, "[handleUGCAccountCreate], isStudyMode = " + bool2 + "isPopupEnable = " + bool3 + ", isPtsLiteEnable = " + bool4);
      if (bool1) {
        RIJUgcUtils.a(this.jdField_a_of_type_AndroidAppActivity, new RIJUgcUtils.RIJUGCAccountStatusCheckCallback(this.jdField_a_of_type_AndroidAppActivity, 0));
      }
      return bool1;
    }
  }
  
  public static void i()
  {
    if (!RIJUgcUtils.a()) {
      return;
    }
    ReadInJoyUserInfoModule.a(ReadInJoyUtils.a(), null);
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject1 = arrayOfString[i];
      try
      {
        localObject1 = new URL((String)localObject1);
        if (localObject1 != null)
        {
          ImageRequest localImageRequest = new ImageRequest();
          localImageRequest.a = ((URL)localObject1);
          localImageRequest.b = true;
          ImageManager.a().a(localImageRequest, null);
          if ((QLog.isDebugVersion()) || (QLog.isColorLevel())) {
            QLog.i("RIJUGCAccountPopupStep", 2, "[preload] url = " + localObject1);
          }
        }
        i += 1;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          QLog.e("RIJUGCAccountPopupStep", 1, "[preload] error, e = " + localMalformedURLException);
          Object localObject2 = null;
        }
      }
    }
  }
  
  private void j()
  {
    if (!RIJUgcUtils.a()) {
      return;
    }
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject1 = arrayOfString[i];
      try
      {
        localObject1 = new URL((String)localObject1);
        if ((QLog.isDebugVersion()) || (QLog.isColorLevel())) {
          QLog.i("RIJUGCAccountPopupStep", 2, "[preloadResources] url = " + localObject1);
        }
        if (localObject1 != null)
        {
          ImageRequest localImageRequest = new ImageRequest();
          localImageRequest.a = ((URL)localObject1);
          ImageManager.a().a(localImageRequest, null);
        }
        i += 1;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          QLog.i("RIJUGCAccountPopupStep", 1, "[preloadResources] error, e = " + localMalformedURLException);
          Object localObject2 = null;
        }
      }
    }
  }
  
  public void g()
  {
    a(this.jdField_a_of_type_Boolean);
    QLog.i("RIJUGCAccountPopupStep", 1, "[doStepFromOnResume], needShow = " + this.jdField_a_of_type_Boolean);
  }
  
  public void h()
  {
    this.jdField_a_of_type_Boolean = b();
    a(this.jdField_a_of_type_Boolean);
    QLog.i("RIJUGCAccountPopupStep", 1, "[doStepFromOnShowSelf], needShow = " + this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJUGCAccountPopupStep
 * JD-Core Version:    0.7.0.1
 */