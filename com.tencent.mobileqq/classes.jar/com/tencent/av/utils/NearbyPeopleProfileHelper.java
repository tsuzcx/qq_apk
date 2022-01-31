package com.tencent.av.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;
import kfz;

public class NearbyPeopleProfileHelper
{
  private static volatile NearbyPeopleProfileHelper jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new kfz(this);
  Context jdField_a_of_type_AndroidContentContext = null;
  public VideoController a;
  public VideoAppInterface a;
  public NearbyPeopleProfileHelper.INearbyPeopleProfileCallBack a;
  public String a;
  public List a;
  
  private NearbyPeopleProfileHelper(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper$INearbyPeopleProfileCallBack = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = null;
    IntentFilter localIntentFilter = new IntentFilter("tencent.video.q2v.getNearByProfile");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp();
    this.jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
  }
  
  public static NearbyPeopleProfileHelper a(VideoAppInterface paramVideoAppInterface)
  {
    if (jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper == null) {
        jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper = new NearbyPeopleProfileHelper(paramVideoAppInterface);
      }
      return jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper$INearbyPeopleProfileCallBack = null;
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper = null;
  }
  
  /* Error */
  public void a(VideoAppInterface paramVideoAppInterface, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 88	com/tencent/av/SessionMgr:a	()Lcom/tencent/av/SessionMgr;
    //   5: aload_0
    //   6: getfield 33	com/tencent/av/utils/NearbyPeopleProfileHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9: invokevirtual 91	com/tencent/av/SessionMgr:a	(Ljava/lang/String;)Lcom/tencent/av/app/SessionInfo;
    //   12: astore_3
    //   13: aload_3
    //   14: ifnonnull +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield 31	com/tencent/av/utils/NearbyPeopleProfileHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   24: aload_2
    //   25: invokeinterface 95 2 0
    //   30: ifne -13 -> 17
    //   33: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +28 -> 64
    //   39: ldc 103
    //   41: iconst_2
    //   42: new 105	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   49: ldc 108
    //   51: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_2
    //   55: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_1
    //   65: aload_2
    //   66: invokevirtual 124	com/tencent/av/app/VideoAppInterface:b	(Ljava/lang/String;)Z
    //   69: ifeq -52 -> 17
    //   72: aload_0
    //   73: getfield 31	com/tencent/av/utils/NearbyPeopleProfileHelper:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   76: aload_2
    //   77: invokeinterface 127 2 0
    //   82: pop
    //   83: goto -66 -> 17
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	NearbyPeopleProfileHelper
    //   0	91	1	paramVideoAppInterface	VideoAppInterface
    //   0	91	2	paramString	String
    //   12	2	3	localSessionInfo	com.tencent.av.app.SessionInfo
    // Exception table:
    //   from	to	target	type
    //   2	13	86	finally
    //   20	64	86	finally
    //   64	83	86	finally
  }
  
  public void a(NearbyPeopleProfileHelper.INearbyPeopleProfileCallBack paramINearbyPeopleProfileCallBack)
  {
    this.jdField_a_of_type_ComTencentAvUtilsNearbyPeopleProfileHelper$INearbyPeopleProfileCallBack = paramINearbyPeopleProfileCallBack;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.NearbyPeopleProfileHelper
 * JD-Core Version:    0.7.0.1
 */