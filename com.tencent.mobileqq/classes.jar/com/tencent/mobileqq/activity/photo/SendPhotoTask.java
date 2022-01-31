package com.tencent.mobileqq.activity.photo;

import aips;
import akcv;
import android.content.Intent;
import android.os.Handler;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import awiw;
import awjb;
import awjl;
import awju;
import axwx;
import azri;
import bcor;
import bdez;
import bdfa;
import bdhb;
import bdif;
import bdmu;
import biqe;
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
import java.util.List;
import java.util.Set;
import ztp;
import zxx;
import zxz;

public class SendPhotoTask
  implements Runnable
{
  int jdField_a_of_type_Int;
  public long a;
  Intent jdField_a_of_type_AndroidContentIntent;
  Handler jdField_a_of_type_AndroidOsHandler = null;
  public String a;
  WeakReference<BaseActivity> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  HashMap<Integer, SendVideoActivity.SendVideoInfo> jdField_a_of_type_JavaUtilHashMap;
  boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = 0L;
  ArrayList<String> jdField_b_of_type_JavaUtilArrayList;
  HashMap<String, PhotoSendParams> jdField_b_of_type_JavaUtilHashMap;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  ArrayList<CompressInfo> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_c_of_type_Boolean;
  int d = 0;
  
  public SendPhotoTask(BaseActivity paramBaseActivity, Intent paramIntent, Handler paramHandler)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_AndroidContentIntent = paramBaseActivity.getIntent();
    if (paramIntent != null) {
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    }
    a(this.jdField_a_of_type_AndroidContentIntent);
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) && ((this.jdField_b_of_type_JavaUtilHashMap == null) || (this.jdField_b_of_type_JavaUtilHashMap.isEmpty())) && ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.isEmpty()))) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_AndroidContentIntent.hasExtra("presend_handler"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPhotoTask", 2, "presendPic ,sendPhotoTask return directly!");
      }
      return true;
    }
    return false;
  }
  
  protected CompressInfo a(int paramInt, Intent paramIntent)
  {
    return awjb.a(paramInt, paramIntent);
  }
  
  protected ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (a((String)localObject)) {
        QLog.e("SendPhotoTask", 2, "sendPhotoTask. path invalid,path:" + (String)localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((!a(i, (String)localObject)) && (!a()) && (a((String)localObject, i)))
        {
          localArrayList.add(localObject);
          if (QLog.isColorLevel()) {
            QLog.d("SendPhotoTask", 2, "sendPhotoTask, send Photo : " + (String)localObject);
          }
        }
      }
    }
    if ((localArrayList.size() >= 5) && (this.jdField_b_of_type_Int == 1))
    {
      if (QLog.isColorLevel())
      {
        localObject = localArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          QLog.d("SendPhotoTask", 2, new Object[] { "sendPhotoTask,  mSendPaths path=", (String)((Iterator)localObject).next() });
        }
        QLog.d("SendPhotoTask", 2, new Object[] { "sendPhotoTask,  lastMessageUniseq=", Long.valueOf(this.jdField_b_of_type_Long) });
      }
      a(localArrayList);
    }
    while (!QLog.isColorLevel()) {
      return localArrayList;
    }
    QLog.d("SendPhotoTask", 2, new Object[] { "sendPhotoTask,  mSendPaths size=", Integer.valueOf(localArrayList.size()) });
    return localArrayList;
  }
  
  protected ArrayList<Integer> a(CompressInfo paramCompressInfo)
  {
    return biqe.a(paramCompressInfo.jdField_e_of_type_JavaLangString);
  }
  
  protected void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PicContants.NEED_COMPRESS", true);
      this.jdField_b_of_type_Int = paramIntent.getIntExtra("uintype", 1003);
      this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
      this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("send_in_background", false);
      this.jdField_a_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      this.jdField_b_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE");
      this.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.VIDEO_INFOS"));
      this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
      this.d = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      this.jdField_c_of_type_Int = paramIntent.getIntExtra("key_confess_topicid", 0);
      this.jdField_b_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.photo_send_pic_type"));
      if (this.jdField_b_of_type_JavaUtilHashMap == null) {
        this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
      }
    } while (!QLog.isColorLevel());
    QLog.d("SendPhotoTask", 2, " sendPhotoTask(),  mBusiType :" + this.jdField_a_of_type_Int + ", mNeedCompress:" + this.jdField_a_of_type_Boolean + ", mCurType:" + this.jdField_b_of_type_Int + ",mIsWaitForResult:" + this.jdField_b_of_type_Boolean + ",picQualityType: " + this.d + ",mSendBackground = " + this.jdField_c_of_type_Boolean + "mPaths :" + Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray()) + ", PhotoTypeSize:" + this.jdField_b_of_type_JavaUtilHashMap.size());
  }
  
  protected void a(awjl paramawjl, QQAppInterface paramQQAppInterface)
  {
    awjb.a(paramawjl, paramQQAppInterface);
  }
  
  protected void a(BaseActivity paramBaseActivity, awjl paramawjl)
  {
    boolean bool1 = false;
    int i = -1;
    if ((paramBaseActivity == null) || (paramBaseActivity.app == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("SendPhotoTask", 2, "sendPhoto,activity or app is null,return!");
      }
    }
    do
    {
      return;
      if ((paramawjl != null) && (paramawjl.jdField_a_of_type_Awju != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SendPhotoTask", 2, "sendPhoto,sendReq is null,return!");
    return;
    a(paramBaseActivity.app, this.jdField_a_of_type_JavaLangString, paramawjl.jdField_a_of_type_Awju.jdField_g_of_type_JavaLangString);
    if (paramawjl.jdField_a_of_type_Awju.jdField_b_of_type_Int == 9501)
    {
      b(paramBaseActivity, paramawjl);
      return;
    }
    Object localObject;
    int j;
    if ((paramawjl.jdField_a_of_type_Awju.jdField_b_of_type_Int == 9500) && ((paramawjl.jdField_a_of_type_Int == 2) || (paramawjl.jdField_a_of_type_Int == 4)))
    {
      localObject = paramBaseActivity.getIntent();
      this.jdField_a_of_type_AndroidContentIntent.removeExtra("PhotoConst.SEND_BUSINESS_TYPE");
      ((Intent)localObject).setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.ChatActivity");
      ((Intent)localObject).putExtra("uin", paramawjl.jdField_a_of_type_Awju.c);
      ((Intent)localObject).putExtra("key_confess_topicid", paramawjl.jdField_a_of_type_Awju.o);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramawjl.jdField_a_of_type_Awju.jdField_g_of_type_JavaLangString);
      ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      ((Intent)localObject).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localArrayList.get(0));
      ((Intent)localObject).putExtra("PhotoConst.SEND_SIZE_SPEC", 2);
      ((Intent)localObject).addFlags(603979776);
      ((Intent)localObject).putExtra("param_compressInitTime", System.currentTimeMillis());
      j = ((Intent)localObject).getIntExtra(bdez.h, -1);
      if ((j != 80) && (j != 82)) {
        ((Intent)localObject).putExtra(bdez.h, 82);
      }
      paramBaseActivity.startActivityForResult((Intent)localObject, 2);
    }
    for (;;)
    {
      try
      {
        localObject = new String[this.jdField_a_of_type_JavaUtilArrayList.size()];
        this.jdField_a_of_type_JavaUtilArrayList.toArray((Object[])localObject);
        boolean bool2 = paramBaseActivity.getIntent().getBooleanExtra("PhotoConst.IS_FORWARD", false);
        if (bool2) {
          i = paramBaseActivity.getIntent().getIntExtra("forward_source_uin_type", -1);
        }
        if (paramawjl.jdField_a_of_type_Awju == null) {
          break;
        }
        j = this.jdField_b_of_type_Int;
        if (paramawjl.jdField_a_of_type_Awju.h == 2) {
          bool1 = true;
        }
        aips.a((String[])localObject, j, bool1, bool2, i, paramBaseActivity.app);
        return;
      }
      catch (Exception paramBaseActivity)
      {
        return;
      }
      a(paramawjl, paramBaseActivity.app);
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    ((axwx)paramQQAppInterface.getManager(326)).a(paramString1, paramString2);
  }
  
  protected void a(CompressInfo paramCompressInfo)
  {
    RichmediaService.a(paramCompressInfo);
  }
  
  protected void a(List<String> paramList)
  {
    bcor.a(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app, this.jdField_a_of_type_JavaLangString, ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app.c(), paramList, this.jdField_b_of_type_Long);
  }
  
  protected boolean a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)) != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPhotoTask", 2, "sendPhotoTask, send Video : " + paramString);
      }
      SendVideoActivity.SendVideoInfo localSendVideoInfo = (SendVideoActivity.SendVideoInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      Intent localIntent = new Intent();
      localIntent.putExtra("file_send_path", paramString);
      localIntent.putExtra("file_send_size", localSendVideoInfo.fileSize);
      localIntent.putExtra("file_send_duration", localSendVideoInfo.duration);
      localIntent.putExtra("uin", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("uintype", this.jdField_b_of_type_Int);
      localIntent.putExtra("file_source", "album_flow");
      localIntent.putExtra("send_in_background", true);
      localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", this.d);
      b(localIntent);
      return true;
    }
    return false;
  }
  
  protected boolean a(awjl paramawjl, awju paramawju)
  {
    if (!paramawjl.a(paramawju))
    {
      QLog.e("SendPhotoTask", 2, "sendPhotoTask. failed to bind the UpInfo to the sendReq");
      return false;
    }
    return true;
  }
  
  protected boolean a(awju paramawju)
  {
    CompressInfo localCompressInfo = a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentIntent);
    if (localCompressInfo == null)
    {
      QLog.e("SendPhotoTask", 2, "sendPhotoTask. compressInfo is null!");
      return false;
    }
    localCompressInfo.j = this.jdField_b_of_type_Int;
    localCompressInfo.jdField_g_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("SendPhotoTask", 2, "SendPhoto,compressInfo.uinType" + localCompressInfo.j);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendPhotoTask", 2, "sendPhotoTask, compress start.compressInfo.src = " + localCompressInfo.c);
    }
    a(localCompressInfo);
    paramawju.jdField_g_of_type_JavaLangString = localCompressInfo.jdField_e_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("SendPhotoTask", 2, "sendPhotoTask,  compress finish, upInfo.localPath = " + paramawju.jdField_g_of_type_JavaLangString);
    }
    if ((localCompressInfo.jdField_g_of_type_Int != 2) && (b(localCompressInfo.jdField_e_of_type_JavaLangString))) {
      bdif.a();
    }
    try
    {
      paramawju.jdField_a_of_type_JavaUtilArrayList = a(localCompressInfo);
      if ((paramawju.jdField_a_of_type_JavaUtilArrayList != null) && (QLog.isColorLevel())) {
        QLog.d("peak_pgjpeg", 2, "@SendPhotoActivity.sendPhotoTask:" + paramawju.jdField_a_of_type_JavaUtilArrayList.toString());
      }
      bdif.a("peak_pgjpeg", "@PeakUtils.getSliceInfos(" + localCompressInfo.jdField_e_of_type_JavaLangString + ")");
      this.jdField_c_of_type_JavaUtilArrayList.add(localCompressInfo);
      if (localCompressInfo.jdField_e_of_type_Boolean)
      {
        paramawju.jdField_g_of_type_Int = 1;
        awiw.a(paramawju, "fixProtocolType", "sendReq.upInfo.protocolType");
        return true;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("peak_pgjpeg", 2, "@OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + localCompressInfo.jdField_e_of_type_JavaLangString + "'s size is " + bdhb.a(localCompressInfo.jdField_e_of_type_JavaLangString));
        }
      }
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("peak_pgjpeg", 2, "@ArrayIndexOutOfBoundsException occurred in PeakUtils.getSliceInfos， " + localCompressInfo.jdField_e_of_type_JavaLangString);
        }
      }
      paramawju.jdField_g_of_type_Int = paramawju.a();
    }
    return true;
  }
  
  protected boolean a(String paramString)
  {
    return !bdhb.b(paramString);
  }
  
  protected boolean a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.PHOTO_SEND_PATH", paramString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.PHOTO_SEND_PATH_INDEX", paramInt);
    awjl localawjl = awjb.a(2, this.jdField_a_of_type_Int);
    localawjl.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("KEY_MSG_FORWARD_ID", -1);
    awju localawju = awjb.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentIntent);
    if (!a(localawjl, localawju)) {}
    do
    {
      return false;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!a(localawju));
    for (;;)
    {
      a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localawjl);
      this.jdField_b_of_type_Long = localawju.jdField_a_of_type_Long;
      return true;
      localawju.jdField_g_of_type_JavaLangString = paramString;
    }
  }
  
  protected boolean a(String paramString, Parcelable paramParcelable)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.PHOTO_SEND_PATH", paramString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.photo_send_qzone_pic_file_params", paramParcelable);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1045);
    paramString = awjb.a(2, 1045);
    paramParcelable = awjb.a(1045, this.jdField_a_of_type_AndroidContentIntent);
    if (!a(paramString, paramParcelable)) {
      return false;
    }
    if (paramParcelable != null) {
      paramParcelable.jdField_g_of_type_JavaLangString = null;
    }
    a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString);
    return true;
  }
  
  protected ArrayList<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_b_of_type_JavaUtilHashMap.size() > 0)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        Object localObject1 = (PhotoSendParams)this.jdField_b_of_type_JavaUtilHashMap.get(localObject2);
        if ((a((String)localObject2)) || (localObject1 == null) || (TextUtils.isEmpty(((PhotoSendParams)localObject1).rawMd5)) || (((PhotoSendParams)localObject1).fileSize <= 0L) || (TextUtils.isEmpty(((PhotoSendParams)localObject1).rawDownloadUrl)))
        {
          localObject2 = new StringBuilder().append("sendPhotoTask. path invalid, path:").append((String)localObject2).append(", params:");
          if (localObject1 != null) {}
          for (localObject1 = ((PhotoSendParams)localObject1).toString();; localObject1 = "")
          {
            QLog.e("SendPhotoTask", 2, (String)localObject1);
            break;
          }
        }
        if (a((String)localObject2, (Parcelable)localObject1))
        {
          localArrayList.add(localObject2);
          if (QLog.isColorLevel()) {
            QLog.i("SendPhotoTask", 2, "sendPhotoTask Qzone path:" + (String)localObject2 + ", photoMd5:" + ((PhotoSendParams)localObject1).rawMd5);
          }
        }
      }
    }
    return localArrayList;
  }
  
  protected void b(Intent paramIntent)
  {
    paramIntent = new akcv((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramIntent);
    paramIntent.a();
    paramIntent.a();
  }
  
  protected void b(BaseActivity paramBaseActivity, awjl paramawjl)
  {
    Object localObject = (ztp)paramBaseActivity.app.a(51);
    if ((((ztp)localObject).c(Long.parseLong(paramawjl.jdField_a_of_type_Awju.c))) && (((ztp)localObject).a(Long.parseLong(paramawjl.jdField_a_of_type_Awju.c), 17))) {}
    for (boolean bool = true; !Boolean.valueOf(bool).booleanValue(); bool = false)
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramawjl.jdField_a_of_type_Awju.jdField_g_of_type_JavaLangString);
      ((zxz)paramBaseActivity.app.a(49)).a().a(zxz.d, paramawjl.jdField_a_of_type_Awju.c, (List)localObject);
      return;
    }
    paramBaseActivity.runOnUiThread(new SendPhotoTask.1(this, (ztp)localObject, paramawjl, paramBaseActivity));
  }
  
  protected boolean b(String paramString)
  {
    return biqe.a(paramString);
  }
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_Long > 0L) {
      azri.a(BaseApplication.getContext()).a(null, "actSendPhotoIdleCost", false, this.jdField_a_of_type_Long, 0L, null, "");
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendPhotoTask", 2, "SendPhoto, current pid=" + Process.myPid() + "," + this.jdField_a_of_type_JavaLangRefWeakReference + ", idleCost" + this.jdField_a_of_type_Long);
    }
    long l = System.currentTimeMillis();
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty())) {
      bdmu.a(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app, this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SendPhotoTask", 2, "sendPhotoTask, mPaths.size() : " + this.jdField_a_of_type_JavaUtilArrayList.size());
      }
      ArrayList localArrayList1 = a();
      ArrayList localArrayList2 = b();
      awiw.b("PIC_TAG_COST", "launch req ", "time cost:" + (System.currentTimeMillis() - l));
      ArrayList localArrayList3 = new ArrayList();
      localArrayList3.addAll(localArrayList1);
      localArrayList3.addAll(localArrayList2);
      if (localArrayList3.size() > 0) {
        this.jdField_a_of_type_AndroidContentIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList3);
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("param_selNum", localArrayList3.size());
      if (this.d == 2)
      {
        int j = localArrayList3.size();
        if (this.jdField_a_of_type_JavaUtilHashMap != null) {
          i = this.jdField_a_of_type_JavaUtilHashMap.size();
        }
        bdfa.a(j, i);
      }
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SendPhotoTask
 * JD-Core Version:    0.7.0.1
 */