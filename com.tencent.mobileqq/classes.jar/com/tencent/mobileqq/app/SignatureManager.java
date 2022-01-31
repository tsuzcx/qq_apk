package com.tencent.mobileqq.app;

import alof;
import alto;
import alxr;
import amcr;
import amcs;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ListAdapter;
import bbaa;
import bdhb;
import bdtt;
import bdtu;
import bdtv;
import bdtw;
import bead;
import beag;
import beaj;
import bhsl;
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
  public static ConcurrentHashMap<Integer, bdtv> a;
  public static ConcurrentLinkedQueue<Runnable> a;
  private static Lock jdField_a_of_type_JavaUtilConcurrentLocksLock;
  public static boolean a;
  public static bdtu[] a;
  private static bdtv jdField_b_of_type_Bdtv;
  public static final String b;
  public static int c;
  public static final String c;
  public static int d;
  public static final String d;
  public int a;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new amcr(this);
  public Handler a;
  private bbaa jdField_a_of_type_Bbaa;
  public bdtv a;
  bead jdField_a_of_type_Bead = new amcs(this);
  private beaj jdField_a_of_type_Beaj;
  public QQAppInterface a;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
  public MqqHandler a;
  public int b;
  private ConcurrentHashMap<String, RichStatus> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  static
  {
    jdField_a_of_type_JavaLangString = alof.aX + ".signatureTemplate/";
    jdField_b_of_type_JavaLangString = alof.bW + "sign_tpl.json";
    jdField_c_of_type_JavaLangString = alof.bW;
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
    this.jdField_a_of_type_Beaj = ((beag)paramQQAppInterface.getManager(47)).a(1);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_MqqOsMqqHandler = new bhsl(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_Bbaa = ((bbaa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193));
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
  
  public static boolean a(bdtv parambdtv)
  {
    boolean bool = false;
    if ((!TextUtils.isEmpty(parambdtv.a[0].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(parambdtv.a[1].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(parambdtv.a[2].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(parambdtv.a[3].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(parambdtv.a[4].jdField_a_of_type_JavaLangString))) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, RichStatus paramRichStatus)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if (((alxr)paramQQAppInterface.getManager(34)).b(paramString)) {
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
    paramString = bdtt.a(paramString, "dynamic_aio");
    File localFile = new File(paramString);
    if ((localFile == null) || (!localFile.exists()) || (!localFile.isDirectory())) {}
    while (bdhb.a(paramString).size() <= 0) {
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
      Object localObject = ((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
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
    jdField_a_of_type_ArrayOfBdtu = null;
    jdField_b_of_type_Bdtv = null;
    a(null);
    if (this.jdField_a_of_type_Beaj != null) {
      this.jdField_a_of_type_Beaj.b();
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureManager
 * JD-Core Version:    0.7.0.1
 */