import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager.1;
import dov.com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager.2;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;

public class bnem
  implements bnbb
{
  private static bnem jdField_a_of_type_Bnem;
  private int jdField_a_of_type_Int = 2;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<bneo> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(1);
  private bnep jdField_a_of_type_Bnep;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new bnen(this);
  private PtvTemplateManager.PtvTemplateInfo jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  private bnem(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      throw new RuntimeException("new LbsFilterStatusManager app==null");
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = ThreadManager.getUIHandlerV2();
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1, bneo.a());
    AppNetConnInfo.registerConnectionChangeReceiver(VideoEnvironment.a(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public static bnem a(AppInterface paramAppInterface)
  {
    try
    {
      if (jdField_a_of_type_Bnem == null)
      {
        jdField_a_of_type_Bnem = new bnem(paramAppInterface);
        bnax.a(paramAppInterface).a(jdField_a_of_type_Bnem);
      }
      paramAppInterface = jdField_a_of_type_Bnem;
      return paramAppInterface;
    }
    finally {}
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "LBS_FILTER_UNINIT_KIND";
    case 1: 
      return "LBS_FILTER_LOADING_KIND";
    case 2: 
      return "LBS_FILTER_NOMAL_KIND";
    }
    return "LBS_FILTER_SPECIAL_KIND";
  }
  
  public static void a()
  {
    try
    {
      if (jdField_a_of_type_Bnem != null)
      {
        jdField_a_of_type_Bnem.c();
        jdField_a_of_type_Bnem = null;
      }
      bnax.a();
      return;
    }
    finally {}
  }
  
  private void a(int paramInt)
  {
    String str = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.getLbsActivityType(paramInt);
    a("sendLoadingFilterMsg", String.format("[%s]acitvityName=%s", new Object[] { this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name, str }), null);
    if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable) && (a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType)) && (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType == paramInt))
    {
      boolean bool = b(paramInt);
      a("sendLoadingFilterMsg", String.format("needRefresh=%s", new Object[] { "" + bool }), null);
      if ((this.jdField_a_of_type_Bnep != null) && (bool))
      {
        a("sendLoadingFilterMsg", "refreshed filterName=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name, null);
        this.jdField_a_of_type_Bnep.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name);
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.i("LbsFilterStatusManager", 2, paramString1 + "_" + paramString2, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.i("LbsFilterStatusManager", 2, paramString1 + "_" + paramString2);
  }
  
  private boolean a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null;
  }
  
  private void b()
  {
    bneo localbneo = (bneo)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType);
    a("startLocationUsingActivity", String.format("activityType=%s", new Object[] { this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.getLbsActivityType(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType) }), null);
    if ((localbneo == null) || (!this.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      a("startLocationUsingActivity", String.format("mRequestStatus=%s", new Object[] { localbneo.a() }), null);
    } while (localbneo.jdField_a_of_type_Int != 3);
    a("startLocationUsingActivity", String.format("mRequestBeginTime=%s", new Object[] { "" + localbneo.jdField_a_of_type_Long }), null);
    if (localbneo.jdField_a_of_type_Long > 0L)
    {
      long l = System.currentTimeMillis() - localbneo.jdField_a_of_type_Long;
      a("startLocationUsingActivity", String.format("diffTime=%s", new Object[] { "" + l }), null);
      if (l >= 30000L) {}
    }
    for (boolean bool = false;; bool = true)
    {
      a("startLocationUsingActivity", String.format("timeOK=%s", new Object[] { "" + bool }), null);
      if (!bool) {
        break;
      }
      localbneo.c();
      localbneo.b();
      localbneo.jdField_a_of_type_Int = 1;
      localbneo.jdField_a_of_type_Long = System.currentTimeMillis();
      bnax.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType);
      return;
    }
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    bneo localbneo = (bneo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbneo != null)
    {
      a("processLocationPermission", String.format("[%s]acitvityName=%s", new Object[] { "" + paramBoolean, this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.getLbsActivityType(paramInt) }), null);
      if (localbneo.jdField_a_of_type_Int == 3) {
        break label98;
      }
      localbneo.jdField_a_of_type_Boolean = paramBoolean;
      if (paramBoolean) {
        localbneo.jdField_a_of_type_Int = 2;
      }
    }
    else
    {
      return;
    }
    localbneo.jdField_a_of_type_Int = 3;
    a(paramInt);
    return;
    label98:
    a("processLocationPermission", String.format("[Error]Status=%s", new Object[] { localbneo.a() }), null);
    localbneo.jdField_a_of_type_Boolean = paramBoolean;
    localbneo.jdField_a_of_type_JavaUtilArrayList.clear();
    localbneo.jdField_a_of_type_Bneo.jdField_a_of_type_JavaUtilArrayList.clear();
    a(paramInt);
  }
  
  private void b(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    bneo localbneo = (bneo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbneo != null)
    {
      a("processLocationForTemplate", String.format("[%s]acitvityName=%s", new Object[] { "" + paramBoolean, this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.getLbsActivityType(paramInt) }), null);
      if (localbneo.jdField_a_of_type_Int != 3)
      {
        if (paramBoolean)
        {
          localbneo.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
          a("processLocationForTemplate", String.format("templateIds= %s", new Object[] { paramArrayList.toString() }), null);
        }
        localbneo.jdField_a_of_type_Int = 3;
        a(paramInt);
      }
    }
    else
    {
      return;
    }
    a("processLocationForTemplate", String.format("[Error]templateIds= %s,Status=%s", new Object[] { paramArrayList.toString(), localbneo.a() }), null);
  }
  
  private boolean b(int paramInt)
  {
    bneo localbneo = (bneo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((localbneo.jdField_a_of_type_Boolean) && (localbneo.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id))) {}
    for (paramInt = 3;; paramInt = 2)
    {
      a("filterNeedRefresh", String.format("newKindName=%s,currentKindName=%s", new Object[] { a(paramInt), a(this.jdField_a_of_type_Int) }), null);
      if (paramInt == this.jdField_a_of_type_Int) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private void c()
  {
    this.b = false;
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null)
    {
      a("processMobile2WifiNet", String.format("activityType=%s", new Object[] { this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.getLbsActivityType(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.activityType) }), null);
      if (!this.b) {
        b();
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      b(paramInt, paramBoolean);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new LbsFilterStatusManager.1(this, paramInt, paramBoolean));
  }
  
  public void a(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    Thread.currentThread().getId();
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      b(paramInt, paramBoolean, paramArrayList);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new LbsFilterStatusManager.2(this, paramInt, paramBoolean, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnem
 * JD-Core Version:    0.7.0.1
 */