package com.tencent.mobileqq.app;

import ajsd;
import ajxl;
import akbn;
import akgm;
import akgn;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ListAdapter;
import ayxs;
import bbdx;
import bbqq;
import bbqr;
import bbqs;
import bbqt;
import bbwt;
import bbww;
import bbwz;
import bfnk;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class SignatureManager
  implements Handler.Callback, Manager
{
  public static final String a;
  public static ConcurrentHashMap<Integer, bbqs> a;
  public static ConcurrentLinkedQueue<Runnable> a;
  private static Lock jdField_a_of_type_JavaUtilConcurrentLocksLock;
  public static boolean a;
  public static bbqr[] a;
  private static bbqs jdField_b_of_type_Bbqs;
  public static final String b;
  public static int c;
  public static final String c;
  public static int d;
  public static final String d;
  public int a;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new akgm(this);
  public Handler a;
  private ayxs jdField_a_of_type_Ayxs;
  public bbqs a;
  bbwt jdField_a_of_type_Bbwt = new akgn(this);
  private bbwz jdField_a_of_type_Bbwz;
  public QQAppInterface a;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
  public MqqHandler a;
  public int b;
  private ConcurrentHashMap<String, RichStatus> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajsd.aW + ".signatureTemplate/";
    jdField_b_of_type_JavaLangString = ajsd.bV + "sign_tpl.json";
    jdField_c_of_type_JavaLangString = ajsd.bV;
    jdField_d_of_type_JavaLangString = jdField_c_of_type_JavaLangString + "/temp";
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
    jdField_c_of_type_Int = 1;
    jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  }
  
  public SignatureManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bbwz = ((bbww)paramQQAppInterface.getManager(47)).a(1);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_MqqOsMqqHandler = new bfnk(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_Ayxs = ((ayxs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193));
  }
  
  public static int a(String paramString, ListAdapter paramListAdapter)
  {
    int i = 0;
    while (i < paramListAdapter.getCount())
    {
      Object localObject = paramListAdapter.getItem(i);
      if (((localObject instanceof RichStatus)) && (((RichStatus)localObject).feedsId.equals(paramString))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      jdField_d_of_type_Int -= 1;
      if ((jdField_d_of_type_Int < jdField_c_of_type_Int) && (!jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()))
      {
        ThreadManagerV2.excute((Runnable)jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll(), 32, null, true);
        jdField_d_of_type_Int += 1;
      }
      return;
    }
    finally {}
  }
  
  public static boolean a(bbqs parambbqs)
  {
    boolean bool = false;
    if ((!TextUtils.isEmpty(parambbqs.a[0].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(parambbqs.a[1].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(parambbqs.a[2].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(parambbqs.a[3].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(parambbqs.a[4].jdField_a_of_type_JavaLangString))) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, RichStatus paramRichStatus)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if (((akbn)paramQQAppInterface.getManager(34)).b(paramString)) {
      return false;
    }
    if (paramQQAppInterface.getCurrentAccountUin().equals(paramString)) {
      return true;
    }
    paramQQAppInterface = new SignatureManager.3(paramRichStatus, paramString);
    jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramQQAppInterface);
    a(false);
    return true;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if (SharpPUtil.isSharpPFile(new File(paramString))) {
        return true;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      if ((localOptions.outWidth != -1) && (localOptions.outHeight != -1)) {
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Signature", 2, paramString + " is not a picture");
    return false;
  }
  
  public static boolean b(String paramString)
  {
    paramString = bbqq.a(paramString, "dynamic_aio");
    File localFile = new File(paramString);
    if ((localFile == null) || (!localFile.exists()) || (!localFile.isDirectory())) {}
    while (bbdx.a(paramString).size() <= 0) {
      return false;
    }
    return true;
  }
  
  public RichStatus a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {}
    try
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      Object localObject = ((ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      if (localObject != null)
      {
        localObject = ((ExtensionInfo)localObject).getRichStatus();
        if (localObject != null) {
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(((RichStatus)localObject).feedsId, localObject);
        }
      }
      return (RichStatus)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      if (paramString != null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = null;
  }
  
  public void a(List<RichStatus> paramList)
  {
    if (paramList != null) {
      try
      {
        if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          RichStatus localRichStatus = (RichStatus)paramList.next();
          if (!TextUtils.isEmpty(localRichStatus.feedsId)) {
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localRichStatus.feedsId, localRichStatus);
          }
        }
        return;
      }
      finally {}
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    return true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    jdField_a_of_type_ArrayOfBbqr = null;
    jdField_b_of_type_Bbqs = null;
    a(null);
    if (this.jdField_a_of_type_Bbwz != null) {
      this.jdField_a_of_type_Bbwz.b();
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureManager
 * JD-Core Version:    0.7.0.1
 */