package com.tencent.mobileqq.activity.photo;

import ageh;
import ahug;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import android.widget.TextView;
import atpg;
import atpl;
import atpv;
import atqd;
import avau;
import awrn;
import azke;
import baae;
import baaf;
import bace;
import badi;
import bfcq;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import xrh;
import xvo;
import xvq;

public class SendPhotoActivity$sendPhotoTask
  implements Runnable
{
  int jdField_a_of_type_Int;
  public long a;
  public ProgressDialog a;
  Intent jdField_a_of_type_AndroidContentIntent;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public String a;
  WeakReference<BaseActivity> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  HashMap<Integer, SendVideoActivity.SendVideoInfo> jdField_a_of_type_JavaUtilHashMap;
  boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int;
  ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<String, PhotoSendParams> jdField_b_of_type_JavaUtilHashMap;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  ArrayList<String> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int = 0;
  ArrayList<CompressInfo> jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  
  public SendPhotoActivity$sendPhotoTask(BaseActivity paramBaseActivity, Intent paramIntent)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_AndroidContentIntent = paramBaseActivity.getIntent();
    if (paramIntent != null) {
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("PicContants.NEED_COMPRESS", true);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("uintype", 1003);
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("send_in_background", false);
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    this.jdField_a_of_type_JavaUtilHashMap = ((HashMap)this.jdField_a_of_type_AndroidContentIntent.getSerializableExtra("PhotoConst.VIDEO_INFOS"));
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin");
    this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("key_confess_topicid", 0);
    this.jdField_b_of_type_JavaUtilHashMap = ((HashMap)this.jdField_a_of_type_AndroidContentIntent.getSerializableExtra("PhotoConst.photo_send_pic_type"));
    if (this.jdField_b_of_type_JavaUtilHashMap == null) {
      this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    }
    if (QLog.isColorLevel()) {
      QLog.d(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, " sendPhotoTask(),  mBusiType :" + this.jdField_a_of_type_Int + ", mNeedCompress:" + this.jdField_a_of_type_Boolean + ", mCurType:" + this.jdField_b_of_type_Int + ",mIsWaitForResult:" + this.jdField_b_of_type_Boolean + ",picQualityType: " + this.jdField_d_of_type_Int + ",mSendBackground = " + this.jdField_c_of_type_Boolean + "mPaths :" + Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray()) + ", PhotoTypeSize:" + this.jdField_b_of_type_JavaUtilHashMap.size());
    }
    a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131629444);
  }
  
  private void a(BaseActivity paramBaseActivity, atpv paramatpv)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    int i = -1;
    if (paramatpv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, "sendPhoto,sendReq is null,return!");
      }
      return;
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app != null) && (!TextUtils.isEmpty(paramatpv.jdField_a_of_type_Atqd.jdField_g_of_type_JavaLangString))) {
      ((avau)((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app.getManager(326)).a(this.jdField_a_of_type_JavaLangString, paramatpv.jdField_a_of_type_Atqd.jdField_g_of_type_JavaLangString);
    }
    Object localObject;
    ArrayList localArrayList;
    if (paramatpv.jdField_a_of_type_Atqd.jdField_b_of_type_Int == 9501)
    {
      localObject = (xvq)paramBaseActivity.app.a(49);
      localArrayList = new ArrayList();
      localArrayList.add(paramatpv.jdField_a_of_type_Atqd.jdField_g_of_type_JavaLangString);
      xrh localxrh = (xrh)paramBaseActivity.app.a(51);
      if ((localxrh.c(Long.parseLong(paramatpv.jdField_a_of_type_Atqd.c))) && (localxrh.a(Long.parseLong(paramatpv.jdField_a_of_type_Atqd.c), 17))) {}
      for (bool1 = bool2; !Boolean.valueOf(bool1).booleanValue(); bool1 = false)
      {
        ((xvq)localObject).a().a(xvq.d, paramatpv.jdField_a_of_type_Atqd.c, localArrayList);
        return;
      }
      ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).runOnUiThread(new SendPhotoActivity.sendPhotoTask.2(this, localxrh, paramatpv, paramBaseActivity));
      return;
    }
    int j;
    if (((paramatpv.jdField_a_of_type_Int == 2) || (paramatpv.jdField_a_of_type_Int == 4)) && ((paramatpv.jdField_a_of_type_Atqd.jdField_b_of_type_Int == 9500) || (paramatpv.jdField_a_of_type_Atqd.jdField_b_of_type_Int == 9501)))
    {
      localObject = paramBaseActivity.getIntent();
      this.jdField_a_of_type_AndroidContentIntent.removeExtra("PhotoConst.SEND_BUSINESS_TYPE");
      ((Intent)localObject).setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.ChatActivity");
      ((Intent)localObject).putExtra("uin", paramatpv.jdField_a_of_type_Atqd.c);
      ((Intent)localObject).putExtra("key_confess_topicid", paramatpv.jdField_a_of_type_Atqd.o);
      localArrayList = new ArrayList();
      localArrayList.add(paramatpv.jdField_a_of_type_Atqd.jdField_g_of_type_JavaLangString);
      ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      ((Intent)localObject).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localArrayList.get(0));
      ((Intent)localObject).putExtra("PhotoConst.SEND_SIZE_SPEC", 2);
      ((Intent)localObject).addFlags(603979776);
      ((Intent)localObject).putExtra("param_compressInitTime", System.currentTimeMillis());
      j = ((Intent)localObject).getIntExtra(baae.h, -1);
      if ((j != 80) && (j != 82)) {
        ((Intent)localObject).putExtra(baae.h, 82);
      }
      paramBaseActivity.startActivityForResult((Intent)localObject, 2);
    }
    for (;;)
    {
      try
      {
        localObject = new String[this.jdField_a_of_type_JavaUtilArrayList.size()];
        this.jdField_a_of_type_JavaUtilArrayList.toArray((Object[])localObject);
        bool2 = paramBaseActivity.getIntent().getBooleanExtra("PhotoConst.IS_FORWARD", false);
        if (bool2) {
          i = paramBaseActivity.getIntent().getIntExtra("forward_source_uin_type", -1);
        }
        if (paramatpv.jdField_a_of_type_Atqd == null) {
          break;
        }
        j = this.jdField_b_of_type_Int;
        if (paramatpv.jdField_a_of_type_Atqd.h != 2) {
          break label619;
        }
        ageh.a((String[])localObject, j, bool1, bool2, i, paramBaseActivity.app);
        return;
      }
      catch (Exception paramBaseActivity)
      {
        return;
      }
      if (paramBaseActivity == null)
      {
        QLog.e(SendPhotoActivity.jdField_a_of_type_JavaLangString, 1, "activity null");
      }
      else
      {
        atpl.a(paramatpv, paramBaseActivity.app);
        continue;
        label619:
        bool1 = false;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_c_of_type_Boolean) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, "TestPicSend finish compress,currentTime = " + System.currentTimeMillis());
      }
    } while ((this.jdField_a_of_type_AndroidAppProgressDialog == null) || (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()));
    this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
  }
  
  void a(Context paramContext, int paramInt)
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidAppProgressDialog != null)
        {
          a();
          if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
            break;
          }
          this.jdField_a_of_type_AndroidAppProgressDialog.show();
          return;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        atpg.b("PIC_TAG_ERROR", "SendPhotoActivity.showProgressDialog", paramContext.toString());
        return;
      }
      this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(paramContext, 2131690181);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131493818);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131305861));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Long > 0L) {
      awrn.a(BaseApplication.getContext()).a(null, "actSendPhotoIdleCost", false, this.jdField_a_of_type_Long, 0L, null, "");
    }
    if (QLog.isColorLevel()) {
      QLog.d(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, "SendPhoto, current pid=" + Process.myPid() + "," + this.jdField_a_of_type_JavaLangRefWeakReference + ", idleCost" + this.jdField_a_of_type_Long);
    }
    long l3 = System.currentTimeMillis();
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, "sendPhotoTask, mPaths.size() : " + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    long l2 = 0L;
    int i = 0;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      long l1;
      if (!bace.b((String)localObject1))
      {
        QLog.e(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, "sendPhotoTask. path invalid,path:" + (String)localObject1);
        l1 = l2;
      }
      for (;;)
      {
        i += 1;
        l2 = l1;
        break;
        if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)) != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, "sendPhotoTask, send Video : " + (String)localObject1);
          }
          localObject2 = (SendVideoActivity.SendVideoInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra("file_send_path", (String)localObject1);
          ((Intent)localObject3).putExtra("file_send_size", ((SendVideoActivity.SendVideoInfo)localObject2).fileSize);
          ((Intent)localObject3).putExtra("file_send_duration", ((SendVideoActivity.SendVideoInfo)localObject2).duration);
          ((Intent)localObject3).putExtra("uin", this.jdField_a_of_type_JavaLangString);
          ((Intent)localObject3).putExtra("uintype", this.jdField_b_of_type_Int);
          ((Intent)localObject3).putExtra("file_source", "album_flow");
          ((Intent)localObject3).putExtra("send_in_background", true);
          ((Intent)localObject3).putExtra("PhotoConst.SEND_SIZE_SPEC", this.jdField_d_of_type_Int);
          localObject1 = new ahug((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (Intent)localObject3);
          ((ahug)localObject1).a();
          ((ahug)localObject1).a();
          l1 = l2;
        }
        else if (this.jdField_a_of_type_AndroidContentIntent.hasExtra("presend_handler"))
        {
          l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.d(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, "presendPic ,sendPhotoTask return directly!");
            l1 = l2;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, "sendPhotoTask, send Photo : " + (String)localObject1);
          }
          this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.PHOTO_SEND_PATH", (String)localObject1);
          this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.PHOTO_SEND_PATH_INDEX", i);
          localObject2 = atpl.a(2, this.jdField_a_of_type_Int);
          ((atpv)localObject2).jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("KEY_MSG_FORWARD_ID", -1);
          localObject3 = atpl.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentIntent);
          if (!((atpv)localObject2).a((atqd)localObject3))
          {
            QLog.e(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, "sendPhotoTask. failed to bind the UpInfo to the sendReq");
            l1 = l2;
          }
          else if (this.jdField_a_of_type_Boolean)
          {
            localObject4 = atpl.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentIntent);
            if (localObject4 == null)
            {
              QLog.e(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, "sendPhotoTask. compressInfo is null!");
              l1 = l2;
            }
            else
            {
              ((CompressInfo)localObject4).j = this.jdField_b_of_type_Int;
              ((CompressInfo)localObject4).jdField_g_of_type_Boolean = true;
              if (QLog.isColorLevel()) {
                QLog.d(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, "SendPhoto,compressInfo.uinType" + ((CompressInfo)localObject4).j);
              }
              if (QLog.isColorLevel()) {
                QLog.d(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, "sendPhotoTask, compress start.compressInfo.src = " + ((CompressInfo)localObject4).c);
              }
              RichmediaService.a((CompressInfo)localObject4);
              ((atqd)localObject3).jdField_g_of_type_JavaLangString = ((CompressInfo)localObject4).jdField_e_of_type_JavaLangString;
              if (QLog.isColorLevel()) {
                QLog.d(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, "sendPhotoTask,  compress finish, upInfo.localPath = " + ((atqd)localObject3).jdField_g_of_type_JavaLangString);
              }
              if ((((CompressInfo)localObject4).jdField_g_of_type_Int != 2) && (bfcq.a(((CompressInfo)localObject4).jdField_e_of_type_JavaLangString))) {
                badi.a();
              }
              try
              {
                ((atqd)localObject3).jdField_a_of_type_JavaUtilArrayList = bfcq.a(((CompressInfo)localObject4).jdField_e_of_type_JavaLangString);
                if ((((atqd)localObject3).jdField_a_of_type_JavaUtilArrayList != null) && (QLog.isColorLevel())) {
                  QLog.d("peak_pgjpeg", 2, "@SendPhotoActivity.sendPhotoTask:" + ((atqd)localObject3).jdField_a_of_type_JavaUtilArrayList.toString());
                }
                badi.a("peak_pgjpeg", "@PeakUtils.getSliceInfos(" + ((CompressInfo)localObject4).jdField_e_of_type_JavaLangString + ")");
                this.jdField_b_of_type_JavaUtilArrayList.add(localObject1);
                this.jdField_d_of_type_JavaUtilArrayList.add(localObject4);
                if (((CompressInfo)localObject4).jdField_e_of_type_Boolean)
                {
                  ((atqd)localObject3).jdField_g_of_type_Int = 1;
                  atpg.a(localObject3, "fixProtocolType", "sendReq.upInfo.protocolType");
                  a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (atpv)localObject2);
                  l1 = l2;
                  if (localObject2 == null) {
                    continue;
                  }
                  this.jdField_c_of_type_JavaUtilArrayList.add(localObject1);
                  l1 = ((atpv)localObject2).jdField_a_of_type_Atqd.jdField_a_of_type_Long;
                }
              }
              catch (OutOfMemoryError localOutOfMemoryError)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.w("peak_pgjpeg", 2, "@OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + ((CompressInfo)localObject4).jdField_e_of_type_JavaLangString + "'s size is " + bace.a(((CompressInfo)localObject4).jdField_e_of_type_JavaLangString));
                  }
                }
              }
              catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
              {
                for (;;)
                {
                  if (QLog.isColorLevel())
                  {
                    QLog.w("peak_pgjpeg", 2, "@ArrayIndexOutOfBoundsException occurred in PeakUtils.getSliceInfos， " + ((CompressInfo)localObject4).jdField_e_of_type_JavaLangString);
                    continue;
                    ((atqd)localObject3).jdField_g_of_type_Int = ((atqd)localObject3).a();
                  }
                }
              }
            }
          }
          else
          {
            ((atqd)localObject3).jdField_g_of_type_JavaLangString = ((String)localObject1);
            this.jdField_b_of_type_JavaUtilArrayList.add(localObject1);
            a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (atpv)localObject2);
            l1 = l2;
            if (localObject2 != null)
            {
              this.jdField_c_of_type_JavaUtilArrayList.add(localObject1);
              l1 = ((atpv)localObject2).jdField_a_of_type_Atqd.jdField_a_of_type_Long;
            }
          }
        }
      }
    }
    if ((this.jdField_c_of_type_JavaUtilArrayList.size() >= 5) && (this.jdField_b_of_type_Int == 1))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          QLog.d(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, "sendPhotoTask,  mSendPaths path=" + (String)localObject2);
        }
        QLog.d(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, "sendPhotoTask,  lastMessageUniseq=" + l2);
      }
      azke.a(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app, this.jdField_a_of_type_JavaLangString, ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app.c(), this.jdField_c_of_type_JavaUtilArrayList, l2);
      this.jdField_c_of_type_JavaUtilArrayList.clear();
      if (this.jdField_b_of_type_JavaUtilHashMap.size() > 0) {
        localObject2 = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
      }
    }
    else
    {
      for (;;)
      {
        label1357:
        if (!((Iterator)localObject2).hasNext()) {
          break label1716;
        }
        localObject4 = (String)((Iterator)localObject2).next();
        localObject1 = (PhotoSendParams)this.jdField_b_of_type_JavaUtilHashMap.get(localObject4);
        if ((!bace.b((String)localObject4)) || (localObject1 == null) || (TextUtils.isEmpty(((PhotoSendParams)localObject1).rawMd5)) || (((PhotoSendParams)localObject1).fileSize <= 0L) || (TextUtils.isEmpty(((PhotoSendParams)localObject1).rawDownloadUrl)))
        {
          localObject3 = SendPhotoActivity.jdField_a_of_type_JavaLangString;
          localObject4 = new StringBuilder().append("sendPhotoTask. path invalid, path:").append((String)localObject4).append(", params:");
          if (localObject1 != null) {}
          for (localObject1 = ((PhotoSendParams)localObject1).toString();; localObject1 = "")
          {
            QLog.e((String)localObject3, 2, (String)localObject1);
            break label1357;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, "sendPhotoTask,  mSendPaths size=" + this.jdField_c_of_type_JavaUtilArrayList.size());
            break;
          }
        }
        this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.PHOTO_SEND_PATH", (String)localObject4);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.photo_send_qzone_pic_file_params", (Parcelable)localObject1);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1045);
        localObject3 = atpl.a(2, 1045);
        atqd localatqd = atpl.a(1045, this.jdField_a_of_type_AndroidContentIntent);
        if (!((atpv)localObject3).a(localatqd))
        {
          QLog.e(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, "sendPhotoTask. failed to bind the UpInfo to the sendReq");
        }
        else
        {
          localatqd.jdField_g_of_type_JavaLangString = null;
          this.jdField_b_of_type_JavaUtilArrayList.add(localObject4);
          a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (atpv)localObject3);
          if (QLog.isColorLevel()) {
            QLog.i(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, "sendPhotoTask Qzone path:" + (String)localObject4 + ", photoMd5:" + ((PhotoSendParams)localObject1).rawMd5);
          }
        }
      }
    }
    label1716:
    atpg.b("PIC_TAG_COST", "launch req ", "time cost:" + (System.currentTimeMillis() - l3));
    SendPhotoActivity.a();
    SendPhotoActivity.a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_b_of_type_JavaUtilArrayList);
    int j;
    if (this.jdField_d_of_type_Int == 2)
    {
      j = this.jdField_b_of_type_JavaUtilArrayList.size();
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        break label1833;
      }
    }
    label1833:
    for (i = this.jdField_a_of_type_JavaUtilHashMap.size();; i = 0)
    {
      baaf.a(j, i);
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
        break label1838;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, "mActivity.get() == null");
      return;
    }
    label1838:
    ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).runOnUiThread(new SendPhotoActivity.sendPhotoTask.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SendPhotoActivity.sendPhotoTask
 * JD-Core Version:    0.7.0.1
 */