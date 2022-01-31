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

public class bffi
{
  private static bffi jdField_a_of_type_Bffi;
  private bfka jdField_a_of_type_Bfka = new bffk(this);
  private INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new bffj(this);
  private ArrayList<bffl> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bffi()
  {
    bfkb.a().a(this.jdField_a_of_type_Bfka);
    AppNetConnInfo.registerNetChangeReceiver(bexd.a().a(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
  }
  
  public static bffi a()
  {
    if (jdField_a_of_type_Bffi == null) {
      jdField_a_of_type_Bffi = new bffi();
    }
    return jdField_a_of_type_Bffi;
  }
  
  public int a(DownloadInfo paramDownloadInfo)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
    int i = 1;
    int j = 0;
    Object localObject1;
    if (bfij.a(paramDownloadInfo.e))
    {
      if ((paramDownloadInfo.jdField_b_of_type_Int != 0) && (paramDownloadInfo.jdField_b_of_type_Int > bfij.a("com.tencent.now"))) {}
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
          ((bffl)((Iterator)localObject1).next()).a(paramDownloadInfo, i);
        }
      }
    }
    DownloadInfo localDownloadInfo = bfkb.a().a(paramDownloadInfo.jdField_c_of_type_JavaLangString);
    boolean bool;
    if ("com.tencent.now".equals(paramDownloadInfo.e))
    {
      bool = asyt.a(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.e);
      if (localDownloadInfo == null)
      {
        i = j;
        if (bool)
        {
          i = bfij.b(asyt.b());
          if ((paramDownloadInfo.jdField_b_of_type_Int != 0) && (paramDownloadInfo.jdField_b_of_type_Int > i)) {
            break label277;
          }
          localObject1 = new DownloadInfo(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.jdField_d_of_type_JavaLangString, paramDownloadInfo.e, paramDownloadInfo.f, paramDownloadInfo.h, null, paramDownloadInfo.m, paramDownloadInfo.jdField_c_of_type_Boolean);
          ((DownloadInfo)localObject1).a(4);
          ((DownloadInfo)localObject1).l = asyt.b();
          ((DownloadInfo)localObject1).jdField_b_of_type_Boolean = paramDownloadInfo.jdField_b_of_type_Boolean;
          bfkb.a().e((DownloadInfo)localObject1);
          i = 1;
        }
      }
    }
    for (;;)
    {
      paramDownloadInfo.a(13);
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((bffl)((Iterator)localObject1).next()).a(paramDownloadInfo, i);
      }
      label277:
      asyt.a(asyt.b());
      i = j;
      continue;
      localObject1 = localDownloadInfo.l;
      if ((asyt.b((String)localObject1)) || (bool))
      {
        if (bool)
        {
          i = bfij.b(asyt.b());
          label321:
          if ((paramDownloadInfo.jdField_b_of_type_Int != 0) && (paramDownloadInfo.jdField_b_of_type_Int > i)) {
            break label427;
          }
          if (bool) {
            break label399;
          }
          if (asyt.a((String)localObject1, paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.e))
          {
            asyt.a((String)localObject1);
            localDownloadInfo.l = asyt.b();
          }
        }
        for (;;)
        {
          localDownloadInfo.a(4);
          bfkb.a().e(localDownloadInfo);
          i = 1;
          break;
          i = bfij.b((String)localObject1);
          break label321;
          label399:
          if (!asyt.b().equals(localObject1))
          {
            asyt.a((String)localObject1);
            localDownloadInfo.l = asyt.b();
          }
        }
        label427:
        bfkb.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString, true);
        asyt.a(asyt.b());
        asyt.a((String)localObject1);
        i = j;
      }
      else
      {
        i = j;
        if (localDownloadInfo.a() == 4)
        {
          bfkb.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString, true);
          i = j;
          continue;
          if (localDownloadInfo != null)
          {
            Object localObject2 = "";
            TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
            if (TextUtils.isEmpty(localDownloadInfo.l)) {
              if (localDownloadInfo.jdField_c_of_type_Int == 0)
              {
                localTMAssistantDownloadTaskInfo2 = bfkb.a().a(localDownloadInfo.jdField_d_of_type_JavaLangString);
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
                  localTMAssistantDownloadTaskInfo1 = bfkb.a().a(localDownloadInfo);
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
                  bfkb.a().e(localDownloadInfo);
                }
              }
            }
            for (localObject2 = localObject1;; localObject2 = localDownloadInfo.l)
            {
              if ((!bdje.a((String)localObject2)) && (asyt.b((String)localObject2))) {
                break label747;
              }
              i = 0;
              break;
              localTMAssistantDownloadTaskInfo2 = bfkb.a().a(localDownloadInfo);
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
              localTMAssistantDownloadTaskInfo1 = bfkb.a().a(localDownloadInfo.jdField_d_of_type_JavaLangString);
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
      bfhg.a("DownloadCenterImpl", "getDownloadProgressById infos == null");
      return -1;
    }
    ThreadManager.getSubThreadHandler().post(new DownloadCenterImpl.3(this, paramArrayList));
    return 0;
  }
  
  public DownloadInfo a(String paramString)
  {
    return bfkb.a().a(paramString);
  }
  
  public void a(bffl parambffl)
  {
    if ((parambffl != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(parambffl))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(parambffl);
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    if (asyt.a(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.e))
    {
      paramDownloadInfo.a(4);
      paramDownloadInfo.l = asyt.b();
      bfkb.a().e(paramDownloadInfo);
      this.jdField_a_of_type_Bfka.onDownloadFinish(paramDownloadInfo);
      return;
    }
    bfkb.a().a(paramDownloadInfo);
  }
  
  public void a(DownloadInfo paramDownloadInfo, ApkUpdateDetail paramApkUpdateDetail)
  {
    bfkb.a().a(paramDownloadInfo, paramApkUpdateDetail);
  }
  
  public void a(String paramString)
  {
    bfkb.a().a(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    DownloadInfo localDownloadInfo = bfkb.a().a(paramString1);
    paramString1 = localDownloadInfo;
    if (localDownloadInfo == null) {
      paramString1 = bfkb.a().b(paramString2);
    }
    if (paramString1 != null)
    {
      paramString1.g = 5;
      paramString1.jdField_c_of_type_Int = 0;
      paramString1.jdField_d_of_type_Int = 0;
      bfkb.a().c(paramString1);
    }
  }
  
  public void b(bffl parambffl)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(parambffl);
    }
  }
  
  public void b(String paramString)
  {
    DownloadInfo localDownloadInfo = bfkb.a().a(paramString);
    bfkb.a().a(paramString, true);
    bfkb.a().a(10, localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bffi
 * JD-Core Version:    0.7.0.1
 */