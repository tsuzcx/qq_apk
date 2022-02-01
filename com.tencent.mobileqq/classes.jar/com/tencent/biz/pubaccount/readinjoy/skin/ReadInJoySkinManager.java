package com.tencent.biz.pubaccount.readinjoy.skin;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class ReadInJoySkinManager
  extends ReadInJoyBaseResManager
{
  protected int a;
  protected Handler a;
  protected SparseArray<BaseSkinRes[]> a;
  protected String a;
  protected ArrayList<ReadInJoySkinManager.OnSkinChangedListener> b = new ArrayList();
  
  public ReadInJoySkinManager(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    a(3, new BaseSkinRes[] { new BaseSkinRes(), new ReadInJoySkinManager.1(this) });
    a(2, new BaseSkinRes[] { new BaseSkinRes(), new ReadInJoySkinManager.2(this) });
    a(4, new BaseSkinRes[] { new ReadInJoySkinManager.3(this), new ReadInJoySkinManager.4(this, paramAppInterface) });
    a(5, new BaseSkinRes[] { new ReadInJoySkinManager.5(this), new ReadInJoySkinManager.6(this, paramAppInterface) });
    a(6, new BaseSkinRes[] { new ReadInJoySkinManager.7(this), new ReadInJoySkinManager.8(this, paramAppInterface) });
    a(7, new BaseSkinRes[] { new ReadInJoySkinManager.9(this), new ReadInJoySkinManager.10(this, paramAppInterface) });
    a(8, new BaseSkinRes[] { new ReadInJoySkinManager.11(this), new ReadInJoySkinManager.12(this) });
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public BaseSkinRes a(int paramInt)
  {
    BaseSkinRes[] arrayOfBaseSkinRes = (BaseSkinRes[])this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((arrayOfBaseSkinRes != null) && (this.jdField_a_of_type_Int < arrayOfBaseSkinRes.length)) {
      return arrayOfBaseSkinRes[this.jdField_a_of_type_Int];
    }
    return null;
  }
  
  public SkinData a(Context paramContext)
  {
    SkinData localSkinData = null;
    paramContext = SharedPreUtils.q(paramContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = new JSONObject(paramContext);
        if (paramContext != null) {
          localSkinData = new SkinData(paramContext);
        }
        return localSkinData;
      }
      catch (Exception paramContext)
      {
        paramContext = null;
        continue;
      }
      paramContext = null;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString)
  {
    if ("skin".equals(paramString)) {
      return CommonSkinRes.a();
    }
    if ("guide".equals(paramString)) {
      return CommonSkinRes.c();
    }
    return CommonSkinRes.c();
  }
  
  public String a(String paramString1, String paramString2)
  {
    if ("skin".equals(paramString1)) {
      return CommonSkinRes.a(paramString2);
    }
    if ("guide".equals(paramString1)) {
      return CommonSkinRes.b(paramString2);
    }
    return CommonSkinRes.b(paramString2);
  }
  
  public void a(int paramInt, BaseSkinRes... paramVarArgs)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramVarArgs);
  }
  
  public void a(Context paramContext, String paramString, BaseResData paramBaseResData)
  {
    SharedPreUtils.g(paramContext, paramString, paramBaseResData.seq);
  }
  
  public void a(ReadInJoySkinManager.OnSkinChangedListener paramOnSkinChangedListener)
  {
    synchronized (this.b)
    {
      if (!this.b.contains(paramOnSkinChangedListener)) {
        this.b.add(paramOnSkinChangedListener);
      }
      return;
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    ReportController.b(null, "dc00899", "BizTechReport", "", "skin_download", "skin_guide", 0, 0, paramArrayOfString[0], paramArrayOfString[1], paramArrayOfString[2], String.valueOf(NetworkUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication())));
  }
  
  public boolean a(GuideData paramGuideData)
  {
    return super.a("guide", paramGuideData);
  }
  
  public boolean a(SkinData paramSkinData)
  {
    return super.a("skin", paramSkinData);
  }
  
  public boolean a(String paramString)
  {
    paramString = (String)this.jdField_a_of_type_JavaUtilHashMap.remove("skin_" + paramString);
    if (paramString != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a(false, paramString);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, BaseResData paramBaseResData)
  {
    if ((paramBaseResData instanceof GuideData)) {
      return a((GuideData)paramBaseResData) & true & a(((GuideData)paramBaseResData).skinData);
    }
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, DownloadListener paramDownloadListener)
  {
    paramString1 = new SkinData(paramString1, paramString3, paramLong1, (int)paramLong2, (int)paramLong3);
    paramString2 = a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext());
    if ((paramString2 != null) && (paramString2.id.equals(paramString1.id)) && (paramString2.seq != paramString1.seq) && (!this.jdField_a_of_type_JavaLangString.equals(paramString1.id))) {
      FileUtils.a(CommonSkinRes.a(paramString2.id));
    }
    a(paramDownloadListener);
    return super.a("skin", paramString1, 3);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public void b(ReadInJoySkinManager.OnSkinChangedListener paramOnSkinChangedListener)
  {
    synchronized (this.b)
    {
      this.b.remove(paramOnSkinChangedListener);
      return;
    }
  }
  
  public void b(String paramString, BaseResData paramBaseResData)
  {
    SharedPreUtils.t(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramBaseResData.id);
    SharedPreUtils.B(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
  }
  
  public boolean b(String paramString, BaseResData paramBaseResData)
  {
    return (a() != 1) || (!paramBaseResData.id.equals(a()));
  }
  
  public boolean c(String paramString, BaseResData paramBaseResData)
  {
    paramString = a(paramString, paramBaseResData.id);
    long l1 = SharedPreUtils.h(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()) / 86400000L;
    long l2 = System.currentTimeMillis() / 86400000L;
    return (SceneBuilder.a(new File(paramString))) && (CommonSkinRes.a(paramBaseResData.id)) && (!SharedPreUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramBaseResData.id)) && (l2 > l1);
  }
  
  public void onDestroy()
  {
    this.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager
 * JD-Core Version:    0.7.0.1
 */