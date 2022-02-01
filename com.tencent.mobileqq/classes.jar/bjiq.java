import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.open.appcommon.now.download.DownloadCenterImpl.3;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class bjiq
{
  private static bjiq jdField_a_of_type_Bjiq;
  private INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new bjir(this);
  private DownloadListener jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = new bjis(this);
  private ArrayList<bjit> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bjiq()
  {
    bjna.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
    AppNetConnInfo.registerNetChangeReceiver(bizw.a().a(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
  }
  
  public static bjiq a()
  {
    if (jdField_a_of_type_Bjiq == null) {
      jdField_a_of_type_Bjiq = new bjiq();
    }
    return jdField_a_of_type_Bjiq;
  }
  
  public int a(DownloadInfo paramDownloadInfo)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
    int i = 1;
    int j = 0;
    Object localObject1;
    if (bjlo.a(paramDownloadInfo.e))
    {
      if ((paramDownloadInfo.jdField_b_of_type_Int != 0) && (paramDownloadInfo.jdField_b_of_type_Int > bjlo.a("com.tencent.now"))) {}
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
          ((bjit)((Iterator)localObject1).next()).a(paramDownloadInfo, i);
        }
      }
    }
    DownloadInfo localDownloadInfo = bjna.a().a(paramDownloadInfo.jdField_c_of_type_JavaLangString);
    boolean bool;
    if ("com.tencent.now".equals(paramDownloadInfo.e))
    {
      bool = avus.a(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.e);
      if (localDownloadInfo == null)
      {
        i = j;
        if (bool)
        {
          i = bjlo.b(avus.b());
          if ((paramDownloadInfo.jdField_b_of_type_Int != 0) && (paramDownloadInfo.jdField_b_of_type_Int > i)) {
            break label277;
          }
          localObject1 = new DownloadInfo(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.jdField_d_of_type_JavaLangString, paramDownloadInfo.e, paramDownloadInfo.f, paramDownloadInfo.h, null, paramDownloadInfo.m, paramDownloadInfo.jdField_c_of_type_Boolean);
          ((DownloadInfo)localObject1).a(4);
          ((DownloadInfo)localObject1).l = avus.b();
          ((DownloadInfo)localObject1).jdField_b_of_type_Boolean = paramDownloadInfo.jdField_b_of_type_Boolean;
          bjna.a().e((DownloadInfo)localObject1);
          i = 1;
        }
      }
    }
    for (;;)
    {
      paramDownloadInfo.a(13);
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((bjit)((Iterator)localObject1).next()).a(paramDownloadInfo, i);
      }
      label277:
      avus.a(avus.b());
      i = j;
      continue;
      localObject1 = localDownloadInfo.l;
      if ((avus.b((String)localObject1)) || (bool))
      {
        if (bool)
        {
          i = bjlo.b(avus.b());
          label321:
          if ((paramDownloadInfo.jdField_b_of_type_Int != 0) && (paramDownloadInfo.jdField_b_of_type_Int > i)) {
            break label427;
          }
          if (bool) {
            break label399;
          }
          if (avus.a((String)localObject1, paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.e))
          {
            avus.a((String)localObject1);
            localDownloadInfo.l = avus.b();
          }
        }
        for (;;)
        {
          localDownloadInfo.a(4);
          bjna.a().e(localDownloadInfo);
          i = 1;
          break;
          i = bjlo.b((String)localObject1);
          break label321;
          label399:
          if (!avus.b().equals(localObject1))
          {
            avus.a((String)localObject1);
            localDownloadInfo.l = avus.b();
          }
        }
        label427:
        bjna.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString, true);
        avus.a(avus.b());
        avus.a((String)localObject1);
        i = j;
      }
      else
      {
        i = j;
        if (localDownloadInfo.a() == 4)
        {
          bjna.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString, true);
          i = j;
          continue;
          if (localDownloadInfo != null)
          {
            Object localObject2 = "";
            TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
            if (TextUtils.isEmpty(localDownloadInfo.l)) {
              if (localDownloadInfo.jdField_c_of_type_Int == 0)
              {
                localTMAssistantDownloadTaskInfo2 = bjna.a().a(localDownloadInfo.jdField_d_of_type_JavaLangString);
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
                  localTMAssistantDownloadTaskInfo1 = bjna.a().a(localDownloadInfo);
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
                  bjna.a().e(localDownloadInfo);
                }
              }
            }
            for (localObject2 = localObject1;; localObject2 = localDownloadInfo.l)
            {
              if ((!StringUtil.isEmpty((String)localObject2)) && (avus.b((String)localObject2))) {
                break label747;
              }
              i = 0;
              break;
              localTMAssistantDownloadTaskInfo2 = bjna.a().a(localDownloadInfo);
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
              localTMAssistantDownloadTaskInfo1 = bjna.a().a(localDownloadInfo.jdField_d_of_type_JavaLangString);
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
      bjko.a("DownloadCenterImpl", "getDownloadProgressById infos == null");
      return -1;
    }
    ThreadManager.getSubThreadHandler().post(new DownloadCenterImpl.3(this, paramArrayList));
    return 0;
  }
  
  public DownloadInfo a(String paramString)
  {
    return bjna.a().a(paramString);
  }
  
  public void a(bjit parambjit)
  {
    if ((parambjit != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(parambjit))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(parambjit);
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    if (avus.a(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.e))
    {
      paramDownloadInfo.a(4);
      paramDownloadInfo.l = avus.b();
      bjna.a().e(paramDownloadInfo);
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener.onDownloadFinish(paramDownloadInfo);
      return;
    }
    bjna.a().a(paramDownloadInfo);
  }
  
  public void a(DownloadInfo paramDownloadInfo, ApkUpdateDetail paramApkUpdateDetail)
  {
    bjna.a().a(paramDownloadInfo, paramApkUpdateDetail);
  }
  
  public void a(String paramString)
  {
    bjna.a().a(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    DownloadInfo localDownloadInfo = bjna.a().a(paramString1);
    paramString1 = localDownloadInfo;
    if (localDownloadInfo == null) {
      paramString1 = bjna.a().b(paramString2);
    }
    if (paramString1 != null)
    {
      paramString1.g = 5;
      paramString1.jdField_c_of_type_Int = 0;
      paramString1.jdField_d_of_type_Int = 0;
      bjna.a().c(paramString1);
    }
  }
  
  public void b(bjit parambjit)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(parambjit);
    }
  }
  
  public void b(String paramString)
  {
    DownloadInfo localDownloadInfo = bjna.a().a(paramString);
    bjna.a().a(paramString, true);
    bjna.a().a(10, localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjiq
 * JD-Core Version:    0.7.0.1
 */