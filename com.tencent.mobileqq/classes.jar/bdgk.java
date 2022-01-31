import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.open.appcommon.now.download.DownloadCenterImpl.3;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class bdgk
{
  private static bdgk jdField_a_of_type_Bdgk;
  private bdld jdField_a_of_type_Bdld = new bdgm(this);
  private INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new bdgl(this);
  private ArrayList<bdgn> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bdgk()
  {
    bdle.a().a(this.jdField_a_of_type_Bdld);
    AppNetConnInfo.registerNetChangeReceiver(bcyb.a().a(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
  }
  
  public static bdgk a()
  {
    if (jdField_a_of_type_Bdgk == null) {
      jdField_a_of_type_Bdgk = new bdgk();
    }
    return jdField_a_of_type_Bdgk;
  }
  
  public int a(DownloadInfo paramDownloadInfo)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
    int i = 1;
    int j = 0;
    Object localObject1;
    if (bdjl.a(paramDownloadInfo.e))
    {
      if ((paramDownloadInfo.jdField_b_of_type_Int != 0) && (paramDownloadInfo.jdField_b_of_type_Int > bdjl.a("com.tencent.now"))) {}
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
          ((bdgn)((Iterator)localObject1).next()).a(paramDownloadInfo, i);
        }
      }
    }
    DownloadInfo localDownloadInfo = bdle.a().a(paramDownloadInfo.jdField_c_of_type_JavaLangString);
    boolean bool;
    if ("com.tencent.now".equals(paramDownloadInfo.e))
    {
      bool = arif.a(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.e);
      if (localDownloadInfo == null)
      {
        i = j;
        if (bool)
        {
          i = bdjl.b(arif.b());
          if ((paramDownloadInfo.jdField_b_of_type_Int != 0) && (paramDownloadInfo.jdField_b_of_type_Int > i)) {
            break label277;
          }
          localObject1 = new DownloadInfo(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.jdField_d_of_type_JavaLangString, paramDownloadInfo.e, paramDownloadInfo.f, paramDownloadInfo.h, null, paramDownloadInfo.m, paramDownloadInfo.jdField_c_of_type_Boolean);
          ((DownloadInfo)localObject1).a(4);
          ((DownloadInfo)localObject1).l = arif.b();
          ((DownloadInfo)localObject1).jdField_b_of_type_Boolean = paramDownloadInfo.jdField_b_of_type_Boolean;
          bdle.a().e((DownloadInfo)localObject1);
          i = 1;
        }
      }
    }
    for (;;)
    {
      paramDownloadInfo.a(13);
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((bdgn)((Iterator)localObject1).next()).a(paramDownloadInfo, i);
      }
      label277:
      arif.a(arif.b());
      i = j;
      continue;
      localObject1 = localDownloadInfo.l;
      if ((arif.b((String)localObject1)) || (bool))
      {
        if (bool)
        {
          i = bdjl.b(arif.b());
          label321:
          if ((paramDownloadInfo.jdField_b_of_type_Int != 0) && (paramDownloadInfo.jdField_b_of_type_Int > i)) {
            break label427;
          }
          if (bool) {
            break label399;
          }
          if (arif.a((String)localObject1, paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.e))
          {
            arif.a((String)localObject1);
            localDownloadInfo.l = arif.b();
          }
        }
        for (;;)
        {
          localDownloadInfo.a(4);
          bdle.a().e(localDownloadInfo);
          i = 1;
          break;
          i = bdjl.b((String)localObject1);
          break label321;
          label399:
          if (!arif.b().equals(localObject1))
          {
            arif.a((String)localObject1);
            localDownloadInfo.l = arif.b();
          }
        }
        label427:
        bdle.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString, true);
        arif.a(arif.b());
        arif.a((String)localObject1);
        i = j;
      }
      else
      {
        i = j;
        if (localDownloadInfo.a() == 4)
        {
          bdle.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString, true);
          i = j;
          continue;
          if (localDownloadInfo != null)
          {
            Object localObject2 = "";
            TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
            if (TextUtils.isEmpty(localDownloadInfo.l)) {
              if (localDownloadInfo.jdField_c_of_type_Int == 0)
              {
                localTMAssistantDownloadTaskInfo2 = bdle.a().a(localDownloadInfo.jdField_d_of_type_JavaLangString);
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
                  localTMAssistantDownloadTaskInfo1 = bdle.a().a(localDownloadInfo);
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
                  bdle.a().e(localDownloadInfo);
                }
              }
            }
            for (localObject2 = localObject1;; localObject2 = localDownloadInfo.l)
            {
              if ((!bbkk.a((String)localObject2)) && (arif.b((String)localObject2))) {
                break label747;
              }
              i = 0;
              break;
              localTMAssistantDownloadTaskInfo2 = bdle.a().a(localDownloadInfo);
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
              localTMAssistantDownloadTaskInfo1 = bdle.a().a(localDownloadInfo.jdField_d_of_type_JavaLangString);
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
      bdii.a("DownloadCenterImpl", "getDownloadProgressById infos == null");
      return -1;
    }
    ThreadManager.getSubThreadHandler().post(new DownloadCenterImpl.3(this, paramArrayList));
    return 0;
  }
  
  public DownloadInfo a(String paramString)
  {
    return bdle.a().a(paramString);
  }
  
  public void a(bdgn parambdgn)
  {
    if ((parambdgn != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(parambdgn))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(parambdgn);
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    if (arif.a(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.e))
    {
      paramDownloadInfo.a(4);
      paramDownloadInfo.l = arif.b();
      bdle.a().e(paramDownloadInfo);
      this.jdField_a_of_type_Bdld.onDownloadFinish(paramDownloadInfo);
      return;
    }
    bdle.a().a(paramDownloadInfo);
  }
  
  public void a(DownloadInfo paramDownloadInfo, ApkUpdateDetail paramApkUpdateDetail)
  {
    bdle.a().a(paramDownloadInfo, paramApkUpdateDetail);
  }
  
  public void a(String paramString)
  {
    bdle.a().a(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    DownloadInfo localDownloadInfo = bdle.a().a(paramString1);
    paramString1 = localDownloadInfo;
    if (localDownloadInfo == null) {
      paramString1 = bdle.a().b(paramString2);
    }
    if (paramString1 != null)
    {
      paramString1.g = 5;
      paramString1.jdField_c_of_type_Int = 0;
      paramString1.jdField_d_of_type_Int = 0;
      bdle.a().c(paramString1);
    }
  }
  
  public void b(bdgn parambdgn)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(parambdgn);
    }
  }
  
  public void b(String paramString)
  {
    DownloadInfo localDownloadInfo = bdle.a().a(paramString);
    bdle.a().a(paramString, true);
    bdle.a().a(10, localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdgk
 * JD-Core Version:    0.7.0.1
 */