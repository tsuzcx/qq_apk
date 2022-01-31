package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.ListAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.SignatureView;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vas.SignatureTemplateConfig.SignatureTemplateType;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.DynamicItem;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.ImageItem;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqsharpP.QQSharpPUtil;
import com.tencent.sharpP.SharpPUtil;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import zmy;
import zmz;
import zna;
import znb;

public class SignatureManager
  implements Handler.Callback, Manager
{
  public static SignatureTemplateInfo.DynamicItem a;
  public static final String a;
  public static ConcurrentHashMap a;
  private static Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  public static boolean a;
  public static SignatureTemplateConfig.SignatureTemplateType[] a;
  private static SignatureTemplateInfo jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo;
  public static final String b;
  public static boolean b;
  public static final String c;
  public static final String d;
  public static String e;
  public int a;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new zmy(this);
  public Handler a;
  public QQAppInterface a;
  private PreDownloadController jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController;
  public SignatureTemplateInfo a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new zmz(this);
  private DownloaderInterface jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface;
  public AtomicInteger a;
  public MqqHandler a;
  public int b;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.aJ + ".signatureTemplate/";
    jdField_b_of_type_JavaLangString = AppConstants.bx + "sign_tpl.json";
    c = AppConstants.bx;
    d = c + "/temp";
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public SignatureManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = ((DownloaderFactory)paramQQAppInterface.getManager(46)).a(1);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController = ((PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(192));
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
  
  @TargetApi(4)
  public static Layout a(Resources paramResources, TextPaint paramTextPaint, StatusManager paramStatusManager, RichStatus paramRichStatus, QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt)
  {
    if (paramRichStatus == null) {
      return null;
    }
    int i = Color.parseColor("black");
    SpannableString localSpannableString = paramRichStatus.toSpannableString(null, i, i);
    if (paramBoolean)
    {
      i = paramInt - DisplayUtil.a(paramQQAppInterface.getApplication().getApplicationContext(), 40.0F);
      paramInt = DisplayUtil.a(paramQQAppInterface.getApplication().getApplicationContext(), 5.0F);
      if ((paramResources == null) || (TextUtils.isEmpty(paramRichStatus.actionText))) {
        break label276;
      }
      paramQQAppInterface = new SpannableStringBuilder(localSpannableString);
      paramQQAppInterface.insert(0, "[S] ");
      if (paramStatusManager == null) {
        break label252;
      }
      paramStatusManager = paramStatusManager.a(paramRichStatus.actionId, 200);
      label112:
      paramResources = new StatableBitmapDrawable(paramResources, paramStatusManager, false, false);
      int j = (int)(paramTextPaint.getTextSize() * 1.1F + 0.5F);
      paramResources.setBounds(0, 0, j, j);
      if ((Build.VERSION.SDK_INT < 4) || (Build.VERSION.SDK_INT >= 20)) {
        break label263;
      }
    }
    label263:
    for (paramResources = new OffsetableImageSpan(paramResources, 1);; paramResources = new OffsetableImageSpan(paramResources, 0))
    {
      paramResources.a(-0.1F);
      paramQQAppInterface.setSpan(paramResources, 0, "[S]".length(), 17);
      return new DynamicLayout(paramQQAppInterface, paramTextPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, paramInt, true);
      i = paramInt - DisplayUtil.a(paramQQAppInterface.getApplication().getApplicationContext(), 60.0F);
      paramInt = DisplayUtil.a(paramQQAppInterface.getApplication().getApplicationContext(), 2.0F);
      break;
      label252:
      paramStatusManager = BitmapManager.a(paramResources, 2130845456);
      break label112;
    }
    label276:
    return new StaticLayout(localSpannableString, paramTextPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, paramInt, true);
  }
  
  @TargetApi(4)
  public static CharSequence a(Resources paramResources, RichStatItemBuilder.Holder paramHolder, StatusManager paramStatusManager, RichStatus paramRichStatus, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramRichStatus == null) {
      paramQQAppInterface = new SpannableString("");
    }
    int i;
    SpannableString localSpannableString;
    do
    {
      do
      {
        do
        {
          return paramQQAppInterface;
          int j = Color.parseColor("black");
          if ((paramQQAppInterface == null) || (paramBoolean)) {
            break;
          }
          i = Color.parseColor(((SignatureManager)paramQQAppInterface.getManager(57)).a(Integer.toString(paramRichStatus.tplId)).jdField_e_of_type_JavaLangString);
          paramHolder.a.jdField_b_of_type_Int = i;
          localSpannableString = paramRichStatus.toSpannableString(null, i, j);
          paramQQAppInterface = localSpannableString;
        } while (paramRichStatus == null);
        paramQQAppInterface = localSpannableString;
      } while (paramResources == null);
      paramQQAppInterface = localSpannableString;
    } while (TextUtils.isEmpty(paramRichStatus.actionText));
    paramQQAppInterface = new SpannableStringBuilder(localSpannableString);
    paramQQAppInterface.insert(0, "[S] ");
    if (paramStatusManager != null)
    {
      paramStatusManager = paramStatusManager.a(paramRichStatus.actionId, 200);
      label150:
      paramResources = new StatableBitmapDrawable(paramResources, paramStatusManager, false, false);
      i = (int)(paramHolder.a.a * 1.1F + 0.5F);
      paramResources.setBounds(0, 0, i, i);
      if ((Build.VERSION.SDK_INT < 4) || (Build.VERSION.SDK_INT == 20)) {
        break label261;
      }
    }
    label261:
    for (paramResources = new OffsetableImageSpan(paramResources, 1);; paramResources = new OffsetableImageSpan(paramResources, 0))
    {
      paramResources.a(-0.1F);
      paramQQAppInterface.setSpan(paramResources, 0, "[S]".length(), 17);
      return paramQQAppInterface;
      i = Color.parseColor("#ffa8a8a8");
      break;
      paramStatusManager = BitmapManager.a(paramResources, 2130845456);
      break label150;
    }
  }
  
  private static String a(int paramInt, String paramString)
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt)) == null) {}
    while (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("http://gxh.vip.qq.com/xydata/");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, RichStatus paramRichStatus)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if (((NewFriendManager)paramQQAppInterface.getManager(33)).b(paramString)) {
      return false;
    }
    if (paramQQAppInterface.getCurrentAccountUin().equals(paramString)) {
      return true;
    }
    ThreadManager.post(new zna(paramRichStatus, paramQQAppInterface, paramString), 8, null, false);
    return true;
  }
  
  public static boolean a(SignatureTemplateInfo paramSignatureTemplateInfo)
  {
    if (paramSignatureTemplateInfo.jdField_e_of_type_Int == 1) {}
    do
    {
      for (;;)
      {
        return false;
        if ((!TextUtils.isEmpty(paramSignatureTemplateInfo.r)) && (!TextUtils.isEmpty(paramSignatureTemplateInfo.q)))
        {
          Object localObject = new Date(NetConnInfoCenter.getServerTimeMillis());
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
          localObject = localSimpleDateFormat.format((Date)localObject);
          try
          {
            localObject = localSimpleDateFormat.parse((String)localObject);
            Date localDate = localSimpleDateFormat.parse(paramSignatureTemplateInfo.r);
            paramSignatureTemplateInfo = localSimpleDateFormat.parse(paramSignatureTemplateInfo.q);
            if (((Date)localObject).compareTo(localDate) <= 0)
            {
              int i = ((Date)localObject).compareTo(paramSignatureTemplateInfo);
              if (i >= 0) {
                return true;
              }
            }
          }
          catch (ParseException paramSignatureTemplateInfo) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("SignatureManager", 2, paramSignatureTemplateInfo.toString());
    return false;
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
    QLog.d("SignatureManager", 2, paramString + " is not a picture");
    return false;
  }
  
  private boolean b(SignatureTemplateInfo paramSignatureTemplateInfo)
  {
    boolean bool = false;
    if ((!TextUtils.isEmpty(paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[1].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[2].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[3].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[4].jdField_a_of_type_JavaLangString))) {
      bool = true;
    }
    return bool;
  }
  
  public Drawable a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject4 = null;
    int m = 0;
    int k = 0;
    jdField_a_of_type_Boolean = false;
    Object localObject3 = Integer.toString(paramInt1);
    SignatureTemplateInfo localSignatureTemplateInfo = a((String)localObject3);
    if ((localSignatureTemplateInfo != null) && (localSignatureTemplateInfo.jdField_a_of_type_JavaLangString.equals("0"))) {}
    for (int j = 1;; j = 0)
    {
      jdField_e_of_type_JavaLangString = null;
      jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = null;
      boolean bool2;
      if (localSignatureTemplateInfo != null)
      {
        bool2 = b(localSignatureTemplateInfo);
        bool1 = bool2;
        if (bool2)
        {
          localSignatureTemplateInfo.getClass();
          jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = new SignatureTemplateInfo.DynamicItem(localSignatureTemplateInfo);
        }
      }
      for (boolean bool1 = bool2;; bool1 = false)
      {
        int i = k;
        Object localObject1;
        switch (paramInt2)
        {
        default: 
          i = k;
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
          localObject1 = null;
        }
        for (;;)
        {
          label199:
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
          {
            localObject3 = null;
            label209:
            return localObject3;
            if (j != 0)
            {
              j = 2130844212;
              label222:
              i = j;
              if (localSignatureTemplateInfo == null) {
                break label1478;
              }
              if (!TextUtils.isEmpty(localSignatureTemplateInfo.s)) {
                break label367;
              }
            }
            label367:
            for (localObject2 = localSignatureTemplateInfo.k;; localObject2 = localSignatureTemplateInfo.s)
            {
              i = j;
              localObject1 = localObject2;
              if (!bool1) {
                break label1475;
              }
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                jdField_e_of_type_JavaLangString = "dynamic_aio";
                jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0];
              }
              i = j;
              localObject1 = localObject2;
              if (TextUtils.isEmpty(localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString)) {
                break label1475;
              }
              i = j;
              localObject1 = localObject2;
              if (b((String)localObject3)) {
                break label1475;
              }
              a(localSignatureTemplateInfo.jdField_a_of_type_JavaLangString, localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString, 16);
              i = j;
              localObject1 = localObject2;
              break;
              j = 2130844211;
              break label222;
            }
            j = 2130844223;
            i = j;
            if (localSignatureTemplateInfo == null) {
              break;
            }
            localObject1 = localSignatureTemplateInfo.d;
            i = j;
            continue;
            if (localSignatureTemplateInfo == null) {
              break label1498;
            }
            localObject1 = localSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem.c;
            if (!bool1) {
              break label1490;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              jdField_e_of_type_JavaLangString = "dynamic_aio";
              jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0];
            }
            if ((TextUtils.isEmpty(localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString)) || (b((String)localObject3))) {
              break label1490;
            }
            a(localSignatureTemplateInfo.jdField_a_of_type_JavaLangString, localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString, 16);
            i = 2130844211;
            continue;
            if (j != 0)
            {
              j = 2130844212;
              if ((localSignatureTemplateInfo == null) || (localSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem == null)) {
                break label1484;
              }
            }
          }
          label513:
          label664:
          label809:
          label829:
          label1475:
          label1478:
          label1484:
          for (Object localObject2 = localSignatureTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem.jdField_a_of_type_JavaLangString;; localObject2 = null)
          {
            for (;;)
            {
              i = j;
              localObject1 = localObject2;
              if (!bool1) {
                break label1475;
              }
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                jdField_e_of_type_JavaLangString = "dynamic_aio";
                jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[4];
              }
              i = j;
              localObject1 = localObject2;
              if (TextUtils.isEmpty(localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString)) {
                break label1475;
              }
              i = j;
              localObject1 = localObject2;
              if (b((String)localObject3)) {
                break label1475;
              }
              a(localSignatureTemplateInfo.jdField_a_of_type_JavaLangString, localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString, 16);
              i = j;
              localObject1 = localObject2;
              break label199;
              j = 2130844211;
              break label513;
              if (j != 0)
              {
                j = 2130844212;
                i = j;
                if (localSignatureTemplateInfo == null) {
                  break label1478;
                }
                if (!TextUtils.isEmpty(localSignatureTemplateInfo.s)) {
                  break label809;
                }
              }
              for (localObject2 = localSignatureTemplateInfo.g;; localObject2 = localSignatureTemplateInfo.s)
              {
                i = j;
                localObject1 = localObject2;
                if (!bool1) {
                  break label1475;
                }
                if (!TextUtils.isEmpty((CharSequence)localObject2))
                {
                  jdField_e_of_type_JavaLangString = "dynamic_aio";
                  jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[1];
                }
                i = j;
                localObject1 = localObject2;
                if (TextUtils.isEmpty(localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString)) {
                  break label1475;
                }
                i = j;
                localObject1 = localObject2;
                if (b((String)localObject3)) {
                  break label1475;
                }
                a(localSignatureTemplateInfo.jdField_a_of_type_JavaLangString, localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString, 16);
                i = j;
                localObject1 = localObject2;
                break;
                j = 2130844211;
                break label664;
              }
              if (j != 0)
              {
                j = 2130844212;
                i = j;
                if (localSignatureTemplateInfo == null) {
                  break label1478;
                }
                if (!TextUtils.isEmpty(localSignatureTemplateInfo.s)) {
                  break label974;
                }
              }
              label974:
              for (localObject2 = localSignatureTemplateInfo.h;; localObject2 = localSignatureTemplateInfo.s)
              {
                i = j;
                localObject1 = localObject2;
                if (!bool1) {
                  break label1475;
                }
                if (!TextUtils.isEmpty((CharSequence)localObject2))
                {
                  jdField_e_of_type_JavaLangString = "dynamic_aio";
                  jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[2];
                }
                i = j;
                localObject1 = localObject2;
                if (TextUtils.isEmpty(localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString)) {
                  break label1475;
                }
                i = j;
                localObject1 = localObject2;
                if (b((String)localObject3)) {
                  break label1475;
                }
                a(localSignatureTemplateInfo.jdField_a_of_type_JavaLangString, localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString, 16);
                i = j;
                localObject1 = localObject2;
                break;
                j = 2130844211;
                break label829;
              }
              if (j != 0)
              {
                j = 2130844212;
                label994:
                i = j;
                if (localSignatureTemplateInfo == null) {
                  break label1478;
                }
                if (!TextUtils.isEmpty(localSignatureTemplateInfo.s)) {
                  break label1139;
                }
              }
              label1139:
              for (localObject2 = localSignatureTemplateInfo.i;; localObject2 = localSignatureTemplateInfo.s)
              {
                i = j;
                localObject1 = localObject2;
                if (!bool1) {
                  break label1475;
                }
                if (!TextUtils.isEmpty((CharSequence)localObject2))
                {
                  jdField_e_of_type_JavaLangString = "dynamic_aio";
                  jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[3];
                }
                i = j;
                localObject1 = localObject2;
                if (TextUtils.isEmpty(localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString)) {
                  break label1475;
                }
                i = j;
                localObject1 = localObject2;
                if (b((String)localObject3)) {
                  break label1475;
                }
                a(localSignatureTemplateInfo.jdField_a_of_type_JavaLangString, localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString, 16);
                i = j;
                localObject1 = localObject2;
                break;
                j = 2130844211;
                break label994;
              }
              if (localSignatureTemplateInfo != null)
              {
                localObject1 = localSignatureTemplateInfo.j;
                i = 2130844212;
                break label199;
                j = 2130844228;
                i = j;
                if (localSignatureTemplateInfo == null) {
                  break;
                }
                localObject1 = localSignatureTemplateInfo.l;
                i = j;
                break label199;
                j = 2130844229;
                i = j;
                if (localSignatureTemplateInfo == null) {
                  break;
                }
                localObject1 = localSignatureTemplateInfo.m;
                i = j;
                break label199;
                i = k;
                if (localSignatureTemplateInfo == null) {
                  break;
                }
                localObject1 = localSignatureTemplateInfo.h;
                i = m;
                break label199;
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getResources().getDrawable(i);
                if (paramInt2 == 9) {
                  localObject2 = new ColorDrawable(Color.parseColor("#dedede"));
                }
                localObject3 = localObject2;
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  break label209;
                }
                try
                {
                  localObject1 = new URL("sig_cover", (String)localObject1, Integer.toString(paramInt1));
                  localObject3 = localObject2;
                  if (localObject1 == null) {
                    break label209;
                  }
                  localObject3 = URLDrawable.URLDrawableOptions.obtain();
                  ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = paramInt3;
                  ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = paramInt4;
                  ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
                  ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
                  ((URLDrawable.URLDrawableOptions)localObject3).mUseSharpPImage = QQSharpPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
                  localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
                  ((URLDrawable)localObject1).addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                  if (((URLDrawable)localObject1).getStatus() == 2) {
                    ((URLDrawable)localObject1).restartDownload();
                  }
                  localObject3 = localObject1;
                  if (((URLDrawable)localObject1).getStatus() != 1) {
                    break label209;
                  }
                  jdField_a_of_type_Boolean = true;
                  return localObject1;
                }
                catch (MalformedURLException localMalformedURLException)
                {
                  for (;;)
                  {
                    localObject1 = localObject4;
                    if (QLog.isColorLevel())
                    {
                      QLog.d("SignatureManager", 2, localMalformedURLException.getMessage());
                      localObject1 = localObject4;
                    }
                  }
                }
              }
            }
            i = 2130844212;
            localObject1 = null;
            break label199;
            break label199;
            localObject1 = null;
            break label199;
          }
          label1490:
          i = 2130844211;
          continue;
          label1498:
          i = 2130844211;
          localObject1 = null;
        }
      }
    }
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
      Object localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
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
  
  public SignatureTemplateInfo a(String paramString)
  {
    int i = Integer.parseInt(paramString);
    Object localObject;
    if (i == 0)
    {
      localObject = new SignatureTemplateInfo("0");
      return localObject;
    }
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {}
    for (SignatureTemplateInfo localSignatureTemplateInfo = (SignatureTemplateInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));; localSignatureTemplateInfo = null)
    {
      localObject = localSignatureTemplateInfo;
      if (localSignatureTemplateInfo != null) {
        break;
      }
      localSignatureTemplateInfo = new SignatureTemplateInfo("0");
      if (i != this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("SignatureManager", 2, "getInfoByTemplateId reading template " + paramString + " from file");
        }
        ThreadManager.post(new znb(this, i), 8, null, true);
        return localSignatureTemplateInfo;
      }
      localObject = localSignatureTemplateInfo;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SignatureManager", 2, "getInfoByTemplateId is reading template " + paramString);
      return localSignatureTemplateInfo;
    }
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
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface == null) {}
    do
    {
      return;
      localObject = a(Integer.parseInt(paramString1), paramString2);
    } while (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a((String)localObject) != null);
    Object localObject = new DownloadTask((String)localObject, new File(SignatureTemplateConfig.a(paramString1, paramString2)));
    Bundle localBundle = new Bundle();
    localBundle.putInt("resType", 2);
    localBundle.putInt("dynamicType", paramInt);
    localBundle.putString("tplId", paramString1);
    localBundle.putString("fileName", paramString2);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
  }
  
  public void a(List paramList)
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
  
  public boolean b(String paramString)
  {
    paramString = SignatureTemplateConfig.a(paramString, "dynamic_aio");
    File localFile = new File(paramString);
    if ((localFile == null) || (!localFile.exists()) || (!localFile.isDirectory())) {}
    while (FileUtils.a(paramString).size() <= 0) {
      return false;
    }
    return true;
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
    jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType = null;
    jdField_b_of_type_ComTencentMobileqqVasSignatureTemplateInfo = null;
    a(null);
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureManager
 * JD-Core Version:    0.7.0.1
 */