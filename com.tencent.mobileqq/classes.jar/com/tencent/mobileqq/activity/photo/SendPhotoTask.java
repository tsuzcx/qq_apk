package com.tencent.mobileqq.activity.photo;

import abgm;
import abku;
import abkw;
import aklj;
import amad;
import android.content.Intent;
import android.os.Handler;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import azjq;
import azjv;
import azke;
import azkn;
import bbob;
import bglc;
import bhcc;
import bhfd;
import bhhm;
import blvp;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
    return azjv.a(paramInt, paramIntent);
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
    return blvp.a(paramCompressInfo.jdField_e_of_type_JavaLangString);
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
  
  protected void a(azke paramazke, QQAppInterface paramQQAppInterface)
  {
    azjv.a(paramazke, paramQQAppInterface);
  }
  
  protected void a(BaseActivity paramBaseActivity, azke paramazke)
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
      if ((paramazke != null) && (paramazke.jdField_a_of_type_Azkn != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SendPhotoTask", 2, "sendPhoto,sendReq is null,return!");
    return;
    a(paramBaseActivity.app, this.jdField_a_of_type_JavaLangString, paramazke.jdField_a_of_type_Azkn.jdField_g_of_type_JavaLangString);
    if (paramazke.jdField_a_of_type_Azkn.jdField_b_of_type_Int == 9501)
    {
      b(paramBaseActivity, paramazke);
      return;
    }
    Object localObject;
    int j;
    if ((paramazke.jdField_a_of_type_Azkn.jdField_b_of_type_Int == 9500) && ((paramazke.jdField_a_of_type_Int == 2) || (paramazke.jdField_a_of_type_Int == 4)))
    {
      localObject = paramBaseActivity.getIntent();
      this.jdField_a_of_type_AndroidContentIntent.removeExtra("PhotoConst.SEND_BUSINESS_TYPE");
      ((Intent)localObject).setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.ChatActivity");
      ((Intent)localObject).putExtra("uin", paramazke.jdField_a_of_type_Azkn.c);
      ((Intent)localObject).putExtra("key_confess_topicid", paramazke.jdField_a_of_type_Azkn.o);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramazke.jdField_a_of_type_Azkn.jdField_g_of_type_JavaLangString);
      ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      ((Intent)localObject).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localArrayList.get(0));
      ((Intent)localObject).putExtra("PhotoConst.SEND_SIZE_SPEC", 2);
      ((Intent)localObject).addFlags(603979776);
      ((Intent)localObject).putExtra("param_compressInitTime", System.currentTimeMillis());
      j = ((Intent)localObject).getIntExtra(bhcc.h, -1);
      if ((j != 80) && (j != 82)) {
        ((Intent)localObject).putExtra(bhcc.h, 82);
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
        if (paramazke.jdField_a_of_type_Azkn == null) {
          break;
        }
        j = this.jdField_b_of_type_Int;
        if (paramazke.jdField_a_of_type_Azkn.h == 2) {
          bool1 = true;
        }
        aklj.a((String[])localObject, j, bool1, bool2, i, paramBaseActivity.app);
        return;
      }
      catch (Exception paramBaseActivity)
      {
        return;
      }
      a(paramazke, paramBaseActivity.app);
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    ((bbob)paramQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a(paramString1, paramString2);
  }
  
  protected void a(CompressInfo paramCompressInfo)
  {
    RichmediaService.a(paramCompressInfo);
  }
  
  protected void a(List<String> paramList)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app != null)) {
      bglc.a(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app, this.jdField_a_of_type_JavaLangString, ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app.getCurrentUin(), paramList, this.jdField_b_of_type_Long);
    }
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
  
  protected boolean a(azke paramazke, azkn paramazkn)
  {
    if (!paramazke.a(paramazkn))
    {
      QLog.e("SendPhotoTask", 2, "sendPhotoTask. failed to bind the UpInfo to the sendReq");
      return false;
    }
    return true;
  }
  
  protected boolean a(azkn paramazkn)
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
    paramazkn.jdField_g_of_type_JavaLangString = localCompressInfo.jdField_e_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("SendPhotoTask", 2, "sendPhotoTask,  compress finish, upInfo.localPath = " + paramazkn.jdField_g_of_type_JavaLangString);
    }
    if ((localCompressInfo.jdField_g_of_type_Int != 2) && (b(localCompressInfo.jdField_e_of_type_JavaLangString))) {
      bhfd.a();
    }
    try
    {
      paramazkn.jdField_a_of_type_JavaUtilArrayList = a(localCompressInfo);
      if ((paramazkn.jdField_a_of_type_JavaUtilArrayList != null) && (QLog.isColorLevel())) {
        QLog.d("peak_pgjpeg", 2, "@SendPhotoActivity.sendPhotoTask:" + paramazkn.jdField_a_of_type_JavaUtilArrayList.toString());
      }
      bhfd.a("peak_pgjpeg", "@PeakUtils.getSliceInfos(" + localCompressInfo.jdField_e_of_type_JavaLangString + ")");
      this.jdField_c_of_type_JavaUtilArrayList.add(localCompressInfo);
      if (localCompressInfo.jdField_e_of_type_Boolean)
      {
        paramazkn.jdField_g_of_type_Int = 1;
        azjq.a(paramazkn, "fixProtocolType", "sendReq.upInfo.protocolType");
        return true;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("peak_pgjpeg", 2, "@OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + localCompressInfo.jdField_e_of_type_JavaLangString + "'s size is " + FileUtils.getFileSizes(localCompressInfo.jdField_e_of_type_JavaLangString));
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
      paramazkn.jdField_g_of_type_Int = paramazkn.a();
    }
    return true;
  }
  
  protected boolean a(String paramString)
  {
    return !FileUtils.fileExistsAndNotEmpty(paramString);
  }
  
  protected boolean a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.PHOTO_SEND_PATH", paramString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.PHOTO_SEND_PATH_INDEX", paramInt);
    azke localazke = azjv.a(2, this.jdField_a_of_type_Int);
    localazke.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("KEY_MSG_FORWARD_ID", -1);
    azkn localazkn = azjv.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentIntent);
    if (!a(localazke, localazkn)) {}
    do
    {
      return false;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!a(localazkn));
    for (;;)
    {
      a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localazke);
      this.jdField_b_of_type_Long = localazkn.jdField_a_of_type_Long;
      return true;
      localazkn.jdField_g_of_type_JavaLangString = paramString;
    }
  }
  
  protected boolean a(String paramString, Parcelable paramParcelable)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.PHOTO_SEND_PATH", paramString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.photo_send_qzone_pic_file_params", paramParcelable);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1045);
    paramString = azjv.a(2, 1045);
    paramParcelable = azjv.a(1045, this.jdField_a_of_type_AndroidContentIntent);
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
    paramIntent = new amad((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramIntent);
    paramIntent.a();
    paramIntent.a();
  }
  
  protected void b(BaseActivity paramBaseActivity, azke paramazke)
  {
    Object localObject = (abgm)paramBaseActivity.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    if ((((abgm)localObject).c(Long.parseLong(paramazke.jdField_a_of_type_Azkn.c))) && (((abgm)localObject).a(Long.parseLong(paramazke.jdField_a_of_type_Azkn.c), 17))) {}
    for (boolean bool = true; !Boolean.valueOf(bool).booleanValue(); bool = false)
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramazke.jdField_a_of_type_Azkn.jdField_g_of_type_JavaLangString);
      ((abkw)paramBaseActivity.app.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(abkw.d, paramazke.jdField_a_of_type_Azkn.c, (List)localObject);
      return;
    }
    paramBaseActivity.runOnUiThread(new SendPhotoTask.1(this, (abgm)localObject, paramazke, paramBaseActivity));
  }
  
  protected boolean b(String paramString)
  {
    return blvp.a(paramString);
  }
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_Long > 0L) {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSendPhotoIdleCost", false, this.jdField_a_of_type_Long, 0L, null, "");
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendPhotoTask", 2, "SendPhoto, current pid=" + Process.myPid() + "," + this.jdField_a_of_type_JavaLangRefWeakReference + ", idleCost" + this.jdField_a_of_type_Long);
    }
    long l = System.currentTimeMillis();
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty())) {
      bhhm.a(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app, this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int);
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
      azjq.b("PIC_TAG_COST", "launch req ", "time cost:" + (System.currentTimeMillis() - l));
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
        AlbumUtil.reportRawPicAndVideo(j, i);
      }
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SendPhotoTask
 * JD-Core Version:    0.7.0.1
 */