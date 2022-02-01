package com.tencent.av.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.GVideoHandler;
import com.tencent.mobileqq.app.GVideoObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LongSparseArray;
import java.util.HashMap;
import java.util.Map;

public class GVideoGrayConfig
{
  private static GVideoGrayConfig jdField_a_of_type_ComTencentAvUtilsGVideoGrayConfig = new GVideoGrayConfig();
  public int a;
  private long jdField_a_of_type_Long;
  private GVideoGrayConfig.GVideoPreDownloadListener jdField_a_of_type_ComTencentAvUtilsGVideoGrayConfig$GVideoPreDownloadListener;
  private GVideoObserver jdField_a_of_type_ComTencentMobileqqAppGVideoObserver = new GVideoGrayConfig.1(this);
  private LongSparseArray<GVideoGrayConfig.GVideoGrayConfigListener> jdField_a_of_type_ComTencentUtilLongSparseArray = new LongSparseArray();
  private Map<String, GVideoGrayConfig.Record> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private GVideoGrayConfig()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public static GVideoGrayConfig a()
  {
    return jdField_a_of_type_ComTencentAvUtilsGVideoGrayConfig;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    DialogUtil.a(paramContext, 230, paramString1, paramString2, 2131695611, 2131695613, new GVideoGrayConfig.2(paramContext), paramOnClickListener).show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, int paramInt)
  {
    String str = paramIntent.getStringExtra("GroupId");
    a().a(paramQQAppInterface, str, new GVideoGrayConfig.3(paramQQAppInterface, paramContext, paramIntent, str));
  }
  
  private static void b(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, AboutActivity.class);
    if ((paramContext instanceof Activity))
    {
      if (!((Activity)paramContext).isFinishing()) {}
    }
    else {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvUtilsGVideoGrayConfig$GVideoPreDownloadListener = null;
  }
  
  public void a(AppInterface paramAppInterface, String paramString, GVideoGrayConfig.GVideoGrayConfigListener paramGVideoGrayConfigListener)
  {
    Object localObject = (GVideoGrayConfig.Record)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localObject != null) && (SystemClock.elapsedRealtime() - ((GVideoGrayConfig.Record)localObject).jdField_a_of_type_Long < 60000L))
    {
      paramGVideoGrayConfigListener.a(((GVideoGrayConfig.Record)localObject).jdField_a_of_type_Int, (GVideoGrayConfig.Record)localObject, 1000);
      return;
    }
    localObject = (GVideoHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.GVIDEO_HANDLER);
    if (localObject != null)
    {
      paramAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppGVideoObserver);
      long l = ((GVideoHandler)localObject).a(TroopMemberUtil.b(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramString), Long.parseLong(paramString));
      this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(l, paramGVideoGrayConfigListener);
      return;
    }
    paramGVideoGrayConfigListener.a(-1, null, -1);
    if (QLog.isColorLevel()) {
      QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "requestGVideoGrayConfig troopHandler is null!!");
    }
  }
  
  public void a(AppInterface paramAppInterface, String paramString, GVideoGrayConfig.GVideoPreDownloadListener paramGVideoPreDownloadListener)
  {
    this.jdField_a_of_type_ComTencentAvUtilsGVideoGrayConfig$GVideoPreDownloadListener = paramGVideoPreDownloadListener;
    if ((this.jdField_a_of_type_Int != -1) && (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long < 7200000L))
    {
      paramGVideoPreDownloadListener.a(this.jdField_a_of_type_Int);
      return;
    }
    paramGVideoPreDownloadListener = (GVideoHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.GVIDEO_HANDLER);
    if (paramGVideoPreDownloadListener != null)
    {
      paramAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppGVideoObserver);
      paramGVideoPreDownloadListener.a(TroopMemberUtil.b(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramString), Long.parseLong(paramString));
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAvUtilsGVideoGrayConfig$GVideoPreDownloadListener = null;
    this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.GVideoGrayConfig
 * JD-Core Version:    0.7.0.1
 */