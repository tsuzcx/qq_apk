package com.tencent.mobileqq.app;

import ajed;
import ajjj;
import ajnf;
import ajsd;
import ajse;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ListAdapter;
import axxj;
import bace;
import baog;
import baoh;
import baoi;
import baoj;
import batl;
import bato;
import batr;
import beez;
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
  public static ConcurrentHashMap<Integer, baoi> a;
  public static ConcurrentLinkedQueue<Runnable> a;
  private static Lock jdField_a_of_type_JavaUtilConcurrentLocksLock;
  public static boolean a;
  public static baoh[] a;
  private static baoi jdField_b_of_type_Baoi;
  public static final String b;
  public static int c;
  public static final String c;
  public static int d;
  public static final String d;
  public int a;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new ajsd(this);
  public Handler a;
  private axxj jdField_a_of_type_Axxj;
  public baoi a;
  batl jdField_a_of_type_Batl = new ajse(this);
  private batr jdField_a_of_type_Batr;
  public QQAppInterface a;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
  public MqqHandler a;
  public int b;
  private ConcurrentHashMap<String, RichStatus> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajed.aU + ".signatureTemplate/";
    jdField_b_of_type_JavaLangString = ajed.bN + "sign_tpl.json";
    jdField_c_of_type_JavaLangString = ajed.bN;
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
    this.jdField_a_of_type_Batr = ((bato)paramQQAppInterface.getManager(47)).a(1);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_MqqOsMqqHandler = new beez(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_Axxj = ((axxj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193));
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
  
  public static boolean a(baoi parambaoi)
  {
    boolean bool = false;
    if ((!TextUtils.isEmpty(parambaoi.a[0].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(parambaoi.a[1].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(parambaoi.a[2].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(parambaoi.a[3].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(parambaoi.a[4].jdField_a_of_type_JavaLangString))) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, RichStatus paramRichStatus)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if (((ajnf)paramQQAppInterface.getManager(34)).b(paramString)) {
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
    paramString = baog.a(paramString, "dynamic_aio");
    File localFile = new File(paramString);
    if ((localFile == null) || (!localFile.exists()) || (!localFile.isDirectory())) {}
    while (bace.a(paramString).size() <= 0) {
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
      Object localObject = ((ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
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
    jdField_a_of_type_ArrayOfBaoh = null;
    jdField_b_of_type_Baoi = null;
    a(null);
    if (this.jdField_a_of_type_Batr != null) {
      this.jdField_a_of_type_Batr.b();
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureManager
 * JD-Core Version:    0.7.0.1
 */