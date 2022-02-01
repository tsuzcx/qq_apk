import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.open.appcommon.now.download.DownloadCenterImpl.3;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class bjrz
{
  private static bjrz jdField_a_of_type_Bjrz;
  private INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new bjsa(this);
  private DownloadListener jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = new bjsb(this);
  private ArrayList<bjsc> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bjrz()
  {
    bjwq.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
    AppNetConnInfo.registerNetChangeReceiver(bjjo.a().a(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
  }
  
  public static bjrz a()
  {
    if (jdField_a_of_type_Bjrz == null) {
      jdField_a_of_type_Bjrz = new bjrz();
    }
    return jdField_a_of_type_Bjrz;
  }
  
  public int a(DownloadInfo paramDownloadInfo)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
    int i = 1;
    int j = 0;
    Object localObject1;
    if (bjva.a(paramDownloadInfo.e))
    {
      if ((paramDownloadInfo.jdField_b_of_type_Int != 0) && (paramDownloadInfo.jdField_b_of_type_Int > bjva.a("com.tencent.now"))) {}
      for (i = 0;; i = 1)
      {
        paramDownloadInfo.a(13);
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          ((bjsc)((Iterator)localObject1).next()).a(paramDownloadInfo, i);
        }
      }
    }
    DownloadInfo localDownloadInfo = bjwq.a().a(paramDownloadInfo.jdField_c_of_type_JavaLangString);
    boolean bool;
    if ("com.tencent.now".equals(paramDownloadInfo.e))
    {
      bool = awbx.a(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.e);
      if (localDownloadInfo == null)
      {
        i = j;
        if (bool)
        {
          i = bjva.b(awbx.b());
          if ((paramDownloadInfo.jdField_b_of_type_Int != 0) && (paramDownloadInfo.jdField_b_of_type_Int > i)) {
            break label277;
          }
          localObject1 = new DownloadInfo(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.jdField_d_of_type_JavaLangString, paramDownloadInfo.e, paramDownloadInfo.f, paramDownloadInfo.h, null, paramDownloadInfo.m, paramDownloadInfo.jdField_c_of_type_Boolean);
          ((DownloadInfo)localObject1).a(4);
          ((DownloadInfo)localObject1).l = awbx.b();
          ((DownloadInfo)localObject1).jdField_b_of_type_Boolean = paramDownloadInfo.jdField_b_of_type_Boolean;
          bjwq.a().e((DownloadInfo)localObject1);
          i = 1;
        }
      }
    }
    for (;;)
    {
      paramDownloadInfo.a(13);
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((bjsc)((Iterator)localObject1).next()).a(paramDownloadInfo, i);
      }
      label277:
      awbx.a(awbx.b());
      i = j;
      continue;
      localObject1 = localDownloadInfo.l;
      if ((awbx.b((String)localObject1)) || (bool))
      {
        if (bool)
        {
          i = bjva.b(awbx.b());
          label321:
          if ((paramDownloadInfo.jdField_b_of_type_Int != 0) && (paramDownloadInfo.jdField_b_of_type_Int > i)) {
            break label427;
          }
          if (bool) {
            break label399;
          }
          if (awbx.a((String)localObject1, paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.e))
          {
            awbx.a((String)localObject1);
            localDownloadInfo.l = awbx.b();
          }
        }
        for (;;)
        {
          localDownloadInfo.a(4);
          bjwq.a().e(localDownloadInfo);
          i = 1;
          break;
          i = bjva.b((String)localObject1);
          break label321;
          label399:
          if (!awbx.b().equals(localObject1))
          {
            awbx.a((String)localObject1);
            localDownloadInfo.l = awbx.b();
          }
        }
        label427:
        bjwq.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString, true);
        awbx.a(awbx.b());
        awbx.a((String)localObject1);
        i = j;
      }
      else
      {
        i = j;
        if (localDownloadInfo.a() == 4)
        {
          bjwq.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString, true);
          i = j;
          continue;
          if (localDownloadInfo != null)
          {
            Object localObject2 = "";
            TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
            if (TextUtils.isEmpty(localDownloadInfo.l)) {
              if (localDownloadInfo.jdField_c_of_type_Int == 0)
              {
                localTMAssistantDownloadTaskInfo2 = bjwq.a().a(localDownloadInfo.jdField_d_of_type_JavaLangString);
                localObject1 = localObject2;
                if (localTMAssistantDownloadTaskInfo2 != null)
                {
                  localObject1 = localObject2;
                  if (localTMAssistantDownloadTaskInfo2.mState == 4) {
                    localObject1 = localTMAssistantDownloadTaskInfo2.mSavePath;
                  }
                }
                localObject2 = localObject1;
                if (TextUtils.isEmpty((CharSequence)localObject1))
                {
                  localTMAssistantDownloadTaskInfo1 = bjwq.a().a(localDownloadInfo);
                  localObject2 = localObject1;
                }
                label581:
                localObject1 = localObject2;
                if (localTMAssistantDownloadTaskInfo1 != null)
                {
                  localObject1 = localObject2;
                  if (localTMAssistantDownloadTaskInfo1.mState == 4) {
                    localObject1 = localTMAssistantDownloadTaskInfo1.mSavePath;
                  }
                }
                localObject2 = localObject1;
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                {
                  localDownloadInfo.l = ((String)localObject1);
                  localDownloadInfo.a(4);
                  bjwq.a().e(localDownloadInfo);
                }
              }
            }
            for (localObject2 = localObject1;; localObject2 = localDownloadInfo.l)
            {
              if ((!bhsr.a((String)localObject2)) && (awbx.b((String)localObject2))) {
                break label747;
              }
              i = 0;
              break;
              localTMAssistantDownloadTaskInfo2 = bjwq.a().a(localDownloadInfo);
              localObject1 = localObject2;
              if (localTMAssistantDownloadTaskInfo2 != null)
              {
                localObject1 = localObject2;
                if (localTMAssistantDownloadTaskInfo2.mState == 4) {
                  localObject1 = localTMAssistantDownloadTaskInfo2.mSavePath;
                }
              }
              localObject2 = localObject1;
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                break label581;
              }
              localTMAssistantDownloadTaskInfo1 = bjwq.a().a(localDownloadInfo.jdField_d_of_type_JavaLangString);
              localObject2 = localObject1;
              break label581;
            }
          }
          else
          {
            label747:
            i = 0;
          }
        }
      }
    }
    j = i;
    return j;
  }
  
  public int a(ArrayList<DownloadInfo> paramArrayList)
  {
    if (paramArrayList == null)
    {
      bjtx.a("DownloadCenterImpl", "getDownloadProgressById infos == null");
      return -1;
    }
    ThreadManager.getSubThreadHandler().post(new DownloadCenterImpl.3(this, paramArrayList));
    return 0;
  }
  
  public DownloadInfo a(String paramString)
  {
    return bjwq.a().a(paramString);
  }
  
  public void a(bjsc parambjsc)
  {
    if ((parambjsc != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(parambjsc))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(parambjsc);
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    if (awbx.a(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.e))
    {
      paramDownloadInfo.a(4);
      paramDownloadInfo.l = awbx.b();
      bjwq.a().e(paramDownloadInfo);
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener.onDownloadFinish(paramDownloadInfo);
      return;
    }
    bjwq.a().a(paramDownloadInfo);
  }
  
  public void a(DownloadInfo paramDownloadInfo, ApkUpdateDetail paramApkUpdateDetail)
  {
    bjwq.a().a(paramDownloadInfo, paramApkUpdateDetail);
  }
  
  public void a(String paramString)
  {
    bjwq.a().a(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    DownloadInfo localDownloadInfo = bjwq.a().a(paramString1);
    paramString1 = localDownloadInfo;
    if (localDownloadInfo == null) {
      paramString1 = bjwq.a().b(paramString2);
    }
    if (paramString1 != null)
    {
      paramString1.g = 5;
      paramString1.jdField_c_of_type_Int = 0;
      paramString1.jdField_d_of_type_Int = 0;
      bjwq.a().c(paramString1);
    }
  }
  
  public void b(bjsc parambjsc)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(parambjsc);
    }
  }
  
  public void b(String paramString)
  {
    DownloadInfo localDownloadInfo = bjwq.a().a(paramString);
    bjwq.a().a(paramString, true);
    bjwq.a().a(10, localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjrz
 * JD-Core Version:    0.7.0.1
 */