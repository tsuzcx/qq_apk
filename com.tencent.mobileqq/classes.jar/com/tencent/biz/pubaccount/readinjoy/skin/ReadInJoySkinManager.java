package com.tencent.biz.pubaccount.readinjoy.skin;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import lwq;
import lwr;
import lws;
import lwt;
import lwu;
import lwv;
import lww;
import lwx;
import lwy;
import lwz;
import lxa;
import lxb;
import lxc;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ReadInJoySkinManager
  extends ReadInJoyBaseResManager
{
  protected int a;
  protected Handler a;
  protected SparseArray a;
  protected String a;
  protected ArrayList b = new ArrayList();
  
  public ReadInJoySkinManager(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    a(3, new BaseSkinRes[] { new BaseSkinRes(), new lwq(this) });
    a(2, new BaseSkinRes[] { new BaseSkinRes(), new lwv(this) });
    a(4, new BaseSkinRes[] { new lww(this), new lwx(this, paramAppInterface) });
    a(5, new BaseSkinRes[] { new lwy(this), new lwz(this, paramAppInterface) });
    a(6, new BaseSkinRes[] { new lxa(this), new lxb(this, paramAppInterface) });
    a(7, new BaseSkinRes[] { new lxc(this), new lwr(this, paramAppInterface) });
    a(8, new BaseSkinRes[] { new lws(this), new lwt(this) });
  }
  
  public static String b()
  {
    return AppConstants.aJ + ".readInjoy/skin_guide/";
  }
  
  public static String b(String paramString)
  {
    return b() + paramString;
  }
  
  private void b(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_Int != paramInt) || (!this.jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_JavaLangString = paramString;
      CommonSkinRes.a(this.jdField_a_of_type_JavaLangString);
      paramInt = 0;
      while (paramInt < this.b.size())
      {
        ((ReadInJoySkinManager.OnSkinChangedListener)this.b.get(paramInt)).B_();
        paramInt += 1;
      }
    }
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
    paramContext = SharedPreUtils.s(paramContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
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
  
  public ErrorMessage a(int paramInt, String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    if ((!CommonSkinRes.a(paramString1)) && (!TextUtils.isEmpty(paramString1)))
    {
      QLog.i("ReadInJoySkinManager", 1, "skin is not valid skinId:" + paramString1 + " skinName:" + paramString2);
      return new ErrorMessage(-2, "please download skin first");
    }
    paramString2 = null;
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = new SkinData(paramString1, paramString3, paramLong1, (int)paramLong2, (int)paramLong3);
      paramLong1 = System.currentTimeMillis() / 1000L;
      if (paramLong1 < paramLong2)
      {
        QLog.i("ReadInJoySkinManager", 1, "current:" + paramLong1 + " startTime:" + paramLong2);
        return new ErrorMessage(-1, "time error");
      }
      if (paramLong1 >= paramLong3)
      {
        QLog.i("ReadInJoySkinManager", 1, "current:" + paramLong1 + " endTime:" + paramLong3);
        return new ErrorMessage(-1, "the skin is expired");
      }
    }
    boolean bool = SharedPreUtils.v(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    if ((this.jdField_a_of_type_JavaLangString.equals(paramString1)) && (paramBoolean == bool)) {
      return new ErrorMessage(-1, "your are already set the skin");
    }
    paramString3 = (ReadInJoyRefreshManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(269);
    Object localObject = paramString3.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext());
    int i = (int)(System.currentTimeMillis() / 1000L);
    if ("".equals(paramString1))
    {
      if (localObject != null)
      {
        ((RefreshData)localObject).isShown = true;
        SharedPreUtils.v(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), ((RefreshData)localObject).toJson().toString());
        if ((i >= ((RefreshData)localObject).beginTime) && (i <= ((RefreshData)localObject).endTime))
        {
          paramString3.a(1, ((RefreshData)localObject).id);
          paramString3.a(true);
        }
      }
      SharedPreUtils.r(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramBoolean);
      paramString3 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext();
      localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      if (paramString2 == null) {
        break label542;
      }
    }
    label542:
    for (paramString2 = paramString2.toJson().toString();; paramString2 = null)
    {
      SharedPreUtils.u(paramString3, (String)localObject, paramString2);
      a(paramInt, paramString1);
      return new ErrorMessage();
      if (localObject == null) {
        break;
      }
      ((RefreshData)localObject).isShown = false;
      SharedPreUtils.v(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), ((RefreshData)localObject).toJson().toString());
      if ((i < ((RefreshData)localObject).beginTime) || (i > ((RefreshData)localObject).endTime)) {
        break;
      }
      paramString3.a(1, ((RefreshData)localObject).id);
      paramString3.a(false);
      break;
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
      return b();
    }
    return b();
  }
  
  public String a(String paramString1, String paramString2)
  {
    if ("skin".equals(paramString1)) {
      return CommonSkinRes.a(paramString2);
    }
    if ("guide".equals(paramString1)) {
      return b(paramString2);
    }
    return b(paramString2);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      b(paramInt, paramString);
      return;
    }
    ThreadManager.getUIHandler().post(new lwu(this, paramInt, paramString));
  }
  
  public void a(int paramInt, BaseSkinRes... paramVarArgs)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramVarArgs);
  }
  
  public void a(Context paramContext, String paramString, BaseResData paramBaseResData)
  {
    SharedPreUtils.h(paramContext, paramString, paramBaseResData.seq);
  }
  
  public void a(ReadInJoySkinManager.OnSkinChangedListener paramOnSkinChangedListener)
  {
    this.b.add(paramOnSkinChangedListener);
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
  
  public void b(ReadInJoySkinManager.OnSkinChangedListener paramOnSkinChangedListener)
  {
    this.b.remove(paramOnSkinChangedListener);
  }
  
  public void b(String paramString, BaseResData paramBaseResData)
  {
    SharedPreUtils.w(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramBaseResData.id);
    SharedPreUtils.H(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
  }
  
  public boolean b(String paramString, BaseResData paramBaseResData)
  {
    return (a() != 1) || (!paramBaseResData.id.equals(a()));
  }
  
  public boolean c(String paramString, BaseResData paramBaseResData)
  {
    paramString = a(paramString, paramBaseResData.id);
    long l1 = SharedPreUtils.i(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()) / 86400000L;
    long l2 = System.currentTimeMillis() / 86400000L;
    return (SceneBuilder.a(new File(paramString))) && (CommonSkinRes.a(paramBaseResData.id)) && (!SharedPreUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramBaseResData.id)) && (l2 > l1);
  }
  
  public void onDestroy()
  {
    this.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager
 * JD-Core Version:    0.7.0.1
 */