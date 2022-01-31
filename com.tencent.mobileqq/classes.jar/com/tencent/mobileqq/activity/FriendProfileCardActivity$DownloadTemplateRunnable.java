package com.tencent.mobileqq.activity;

import android.os.Message;
import auvf;
import bbac;
import bbdx;
import bbkq;
import bbwu;
import bbww;
import bfob;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

class FriendProfileCardActivity$DownloadTemplateRunnable
  implements Runnable
{
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  WeakReference<FriendProfileCardActivity> jdField_a_of_type_JavaLangRefWeakReference;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  WeakReference<auvf> b;
  
  public FriendProfileCardActivity$DownloadTemplateRunnable(FriendProfileCardActivity paramFriendProfileCardActivity, auvf paramauvf, AtomicBoolean paramAtomicBoolean, String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFriendProfileCardActivity);
    this.b = new WeakReference(paramauvf);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = paramAtomicBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void run()
  {
    int j = 1;
    for (;;)
    {
      boolean bool2;
      try
      {
        FriendProfileCardActivity localFriendProfileCardActivity;
        Object localObject1;
        if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.b != null))
        {
          localFriendProfileCardActivity = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          localObject1 = (auvf)this.b.get();
          if ((localFriendProfileCardActivity != null) && (localObject1 != null))
          {
            localFriendProfileCardActivity.jdField_a_of_type_Bbkq.a("downloadTemplateStart", true);
            bool2 = bbac.a(localFriendProfileCardActivity.app);
            if ((this.jdField_a_of_type_Long != 160L) && (this.jdField_a_of_type_Long != 1600L)) {
              break label818;
            }
            bool1 = bbac.a(localFriendProfileCardActivity.app.getApplication(), this.jdField_a_of_type_JavaLangString);
            if (bool1) {
              break label811;
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.FrdProfileCard", 2, "start download background=" + this.jdField_a_of_type_JavaLangString + ",isExistBgResource=" + bool1);
            }
            localObject1 = new File(bbac.a(localFriendProfileCardActivity.app.getApplication(), this.jdField_a_of_type_JavaLangString));
            localObject1 = new bbwu(this.jdField_a_of_type_JavaLangString, (File)localObject1);
            ((bbwu)localObject1).f = "profileCardDownload";
            ((bbwu)localObject1).e = "VIP_profilecard";
            i = bbww.a((bbwu)localObject1, localFriendProfileCardActivity.app);
            if (i != 0) {
              QLog.e("Q.profilecard.FrdProfileCard", 1, "download BG fail code = " + i + " url = " + this.jdField_a_of_type_JavaLangString);
            }
            if ((i != 0) || (!bbac.a(localFriendProfileCardActivity.app.getApplication(), this.jdField_a_of_type_JavaLangString))) {
              break label831;
            }
            bool1 = true;
            break label824;
            bool1 = bool2;
            if (!bool2)
            {
              localObject1 = bbac.a(localFriendProfileCardActivity.app, -1L);
              bool1 = bool2;
              if ("http://imgcache.gtimg.cn/club/mobile/profile/template/android_common_583.zip" != null)
              {
                bool1 = bool2;
                if (localObject1 != null)
                {
                  localFile = new File((String)localObject1);
                  localObject2 = new File((String)localObject1 + File.separator + "config_black.json");
                  if ((!localFile.isDirectory()) || (!((File)localObject2).exists())) {
                    continue;
                  }
                  bool1 = true;
                }
              }
            }
            localFriendProfileCardActivity.jdField_a_of_type_Bbkq.a("downloadCommonEnd", "downloadBackgroundEnd", false);
            if (localFriendProfileCardActivity.jdField_a_of_type_Bfob != null)
            {
              localObject1 = localFriendProfileCardActivity.jdField_a_of_type_Bfob.obtainMessage();
              ((Message)localObject1).what = 7;
              if ((!bool1) || (m == 0)) {
                break label806;
              }
              i = j;
              ((Message)localObject1).arg1 = i;
              ((Message)localObject1).arg2 = 0;
              localFriendProfileCardActivity.jdField_a_of_type_Bfob.sendMessage((Message)localObject1);
            }
          }
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "start downloadCardTemplate path= " + (String)localObject1);
        }
        File localFile = new File((String)localObject1 + ".zip");
        if (localFile.exists()) {
          localFile.delete();
        }
        Object localObject2 = new bbwu("http://imgcache.gtimg.cn/club/mobile/profile/template/android_common_583.zip", localFile);
        ((bbwu)localObject2).f = "profileCardDownload";
        ((bbwu)localObject2).e = "VIP_profilecard";
        int k = bbww.a((bbwu)localObject2, localFriendProfileCardActivity.app);
        if (k != 0) {
          break label843;
        }
        i = 1;
        if (i != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard", 2, "common zip download success! size = " + localFile.length());
          }
          try
          {
            bbdx.a(localFile.getAbsolutePath(), (String)localObject1 + File.separator, false);
            bbac.a(localFriendProfileCardActivity.app, "common", "583");
            if (bbac.a(localFriendProfileCardActivity.app))
            {
              localFile.delete();
              if (!QLog.isColorLevel()) {
                break label837;
              }
              QLog.i("Q.profilecard.FrdProfileCard", 2, "downloadCardTemplate unzip success");
              break label837;
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.FrdProfileCard", 2, "downloadCardTemplate  success but unzip error");
            }
            bool1 = bool2;
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            bool1 = bool2;
          }
          continue;
        }
        QLog.e("Q.profilecard.FrdProfileCard", 1, "download template fail code = " + k + " url = " + "http://imgcache.gtimg.cn/club/mobile/profile/template/android_common_583.zip");
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        return;
      }
      boolean bool1 = bool2;
      continue;
      label806:
      int i = 0;
      continue;
      label811:
      int m = bool1;
      continue;
      label818:
      bool1 = true;
      continue;
      for (;;)
      {
        label824:
        m = bool1;
        break;
        label831:
        bool1 = false;
      }
      label837:
      bool1 = true;
      continue;
      label843:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.DownloadTemplateRunnable
 * JD-Core Version:    0.7.0.1
 */