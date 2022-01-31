package com.tencent.av.redpacket.config;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.RemoteException;
import bbdx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import lui;
import lwf;
import mnm;
import mnp;
import mnq;
import mpv;

public class AVRedPacketConfigManager$2
  implements Runnable
{
  public AVRedPacketConfigManager$2(lui paramlui, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3) {}
  
  public void run()
  {
    boolean bool2 = false;
    QLog.d("AVRedPacketConfigManger", 1, "onDownloadFinish,subHandler runnable start,threadName = " + Thread.currentThread().getName());
    boolean bool1;
    Object localObject;
    SharedPreferences localSharedPreferences;
    if (this.jdField_a_of_type_Int == 0)
    {
      bool1 = true;
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("avredpacket_sp", 4);
      if ((bool1) && (((File)localObject).exists()))
      {
        long l1 = localSharedPreferences.getLong(this.jdField_b_of_type_JavaLangString, -1L);
        long l2 = ((File)localObject).lastModified();
        if ((l1 != -1L) && (l1 != l2)) {
          localSharedPreferences.edit().putInt("pcm_" + this.jdField_b_of_type_JavaLangString, 0).commit();
        }
        if ((this.jdField_b_of_type_Int == 2) && (l1 != l2))
        {
          mnm localmnm = mnm.a();
          if ((localmnm == null) || (localmnm.g != 1) || (!mnq.a(this.jdField_b_of_type_JavaLangString))) {
            break label689;
          }
          lui.a(this.this$0).removeMessages(100);
          lui.a(this.this$0).sendEmptyMessageDelayed(100, 60000L);
          l2 = System.currentTimeMillis();
          mnq.a(this.jdField_a_of_type_JavaLangString);
          long l3 = System.currentTimeMillis();
          lui.a(this.this$0).removeMessages(100);
          mnp.a(l3 - l2);
        }
        label264:
        l2 = ((File)localObject).lastModified();
        localSharedPreferences.edit().putLong(this.jdField_b_of_type_JavaLangString, l2).commit();
        if (QLog.isColorLevel()) {
          QLog.d("AVRedPacketConfigManger", 2, "onDownloadFinish,url =   " + this.c + ",md5 = " + this.jdField_b_of_type_JavaLangString + ",errCode = " + this.jdField_a_of_type_Int + ",path = " + this.jdField_a_of_type_JavaLangString + ",modifyTime = " + l2 + ", spModifiedTime=" + l1);
        }
      }
      if (this.this$0.jdField_b_of_type_Lwf != null)
      {
        if (this.jdField_b_of_type_Int != 1) {
          break label700;
        }
        this.this$0.jdField_b_of_type_Boolean = true;
        this.this$0.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketConfigManger", 2, "onDownloadFinish,url =   " + this.c + ",md5 = " + this.jdField_b_of_type_JavaLangString + ",errCode = " + this.jdField_a_of_type_Int + ",path = " + this.jdField_a_of_type_JavaLangString + ",downloadBgMusicFinish = " + this.this$0.c + ",downloadResFinish = " + this.this$0.jdField_b_of_type_Boolean + ",downloadCallBack = " + this.this$0.jdField_b_of_type_Lwf);
      }
      if ((this.this$0.jdField_b_of_type_Boolean) && (this.this$0.c)) {}
      for (;;)
      {
        try
        {
          mpv.a(this.this$0.jdField_a_of_type_JavaLangString);
          localObject = mpv.b();
          if (bbdx.b(this.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          QLog.w("AVRedPacketConfigManger", 1, "onDownloadFinish, !exist, mp4[" + (String)localObject + "]");
          bool1 = bool2;
        }
        catch (RemoteException localRemoteException1)
        {
          localRemoteException1.printStackTrace();
          continue;
          continue;
        }
        try
        {
          this.this$0.jdField_b_of_type_Lwf.a(bool1, this.this$0.jdField_a_of_type_JavaLangString, this.this$0.jdField_b_of_type_JavaLangString);
          if (bool1) {
            localSharedPreferences.edit().putBoolean("res_exist", true).commit();
          }
          this.this$0.jdField_b_of_type_Lwf = null;
          this.this$0.a("onDownloadFinish");
          return;
        }
        catch (RemoteException localRemoteException2) {}
      }
      bool1 = false;
      break;
      label689:
      QLog.i("AVRedPacketConfigManger", 1, "convertMp3ToPcm dpc != 1 or is rubbish device");
      break label264;
      label700:
      if (this.jdField_b_of_type_Int == 2)
      {
        this.this$0.c = true;
        this.this$0.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.redpacket.config.AVRedPacketConfigManager.2
 * JD-Core Version:    0.7.0.1
 */