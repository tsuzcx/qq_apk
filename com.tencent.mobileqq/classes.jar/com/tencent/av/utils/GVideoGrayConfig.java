package com.tencent.av.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LongSparseArray;
import java.util.HashMap;
import java.util.Map;
import kgi;
import kgj;
import kgk;

public class GVideoGrayConfig
{
  private static GVideoGrayConfig jdField_a_of_type_ComTencentAvUtilsGVideoGrayConfig = new GVideoGrayConfig();
  public int a;
  private long jdField_a_of_type_Long;
  private GVideoGrayConfig.GVideoPreDownloadListener jdField_a_of_type_ComTencentAvUtilsGVideoGrayConfig$GVideoPreDownloadListener;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new kgi(this);
  private LongSparseArray jdField_a_of_type_ComTencentUtilLongSparseArray = new LongSparseArray();
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  
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
    DialogUtil.b(paramContext, 230, paramString1, paramString2, 2131429502, 2131429503, new kgj(paramContext), paramOnClickListener).show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, int paramInt)
  {
    String str = paramIntent.getStringExtra("GroupId");
    a().a(paramQQAppInterface, str, new kgk(paramQQAppInterface, paramContext, paramIntent, str));
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
  
  public void a(GVideoGrayConfig.GVideoGrayConfigListener paramGVideoGrayConfigListener)
  {
    int i = this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(paramGVideoGrayConfigListener);
    if (i != -1) {
      this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(i);
    }
  }
  
  public void a(AppInterface paramAppInterface, String paramString, GVideoGrayConfig.GVideoGrayConfigListener paramGVideoGrayConfigListener)
  {
    Object localObject = (GVideoGrayConfig.Record)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localObject != null) && (SystemClock.elapsedRealtime() - ((GVideoGrayConfig.Record)localObject).jdField_a_of_type_Long < 60000L)) {
      paramGVideoGrayConfigListener.a(((GVideoGrayConfig.Record)localObject).jdField_a_of_type_Int, (GVideoGrayConfig.Record)localObject, 1000);
    }
    do
    {
      return;
      localObject = (TroopHandler)paramAppInterface.getBusinessHandler(20);
      if (localObject != null)
      {
        paramAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        long l = ((TroopHandler)localObject).a(TroopMemberUtil.b(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramString), Long.parseLong(paramString));
        this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(l, paramGVideoGrayConfigListener);
        return;
      }
      paramGVideoGrayConfigListener.a(-1, null, -1);
    } while (!QLog.isColorLevel());
    QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "requestGVideoGrayConfig troopHandler is null!!");
  }
  
  public void a(AppInterface paramAppInterface, String paramString, GVideoGrayConfig.GVideoPreDownloadListener paramGVideoPreDownloadListener)
  {
    this.jdField_a_of_type_ComTencentAvUtilsGVideoGrayConfig$GVideoPreDownloadListener = paramGVideoPreDownloadListener;
    if ((this.jdField_a_of_type_Int != -1) && (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long < 7200000L)) {
      paramGVideoPreDownloadListener.a(this.jdField_a_of_type_Int);
    }
    do
    {
      return;
      paramGVideoPreDownloadListener = (TroopHandler)paramAppInterface.getBusinessHandler(20);
    } while (paramGVideoPreDownloadListener == null);
    paramAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    paramGVideoPreDownloadListener.a(TroopMemberUtil.b(paramAppInterface, paramAppInterface.getCurrentAccountUin(), paramString), Long.parseLong(paramString));
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAvUtilsGVideoGrayConfig$GVideoPreDownloadListener = null;
    this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.GVideoGrayConfig
 * JD-Core Version:    0.7.0.1
 */