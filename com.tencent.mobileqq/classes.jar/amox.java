import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class amox
{
  public static void a(AppInterface paramAppInterface, String paramString1, amoz paramamoz, List<amow> paramList, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes");
    }
    if (paramAppInterface == null) {}
    label192:
    do
    {
      amow localamow;
      do
      {
        ArrayList localArrayList;
        do
        {
          do
          {
            do
            {
              return;
              localArrayList = new ArrayList();
              localamow = null;
              if (!TextUtils.isEmpty(paramString2))
              {
                localamow = new amow();
                localamow.jdField_a_of_type_JavaLangString = paramString2;
                localamow.jdField_a_of_type_Int = 6;
                localArrayList.add(localamow);
              }
              if (paramList != null) {
                localArrayList.addAll(paramList);
              }
              if (!localArrayList.isEmpty()) {
                break;
              }
              QLog.e("rscContent_CmShowRscDownloader", 1, "downloadApolloRes tasks is empty ");
            } while (paramamoz == null);
            paramamoz.a(false, paramString1, paramList, "");
            return;
            paramAppInterface = (bhyq)paramAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
          } while (paramAppInterface == null);
          paramAppInterface = paramAppInterface.a(3);
        } while (paramAppInterface == null);
        paramString2 = new AtomicInteger(localArrayList.size());
        AtomicInteger localAtomicInteger1 = new AtomicInteger(0);
        AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
        int k = localArrayList.size();
        int i = 0;
        if (i < k)
        {
          Object localObject = (amow)localArrayList.get(i);
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscDownloader", 2, "IdolRscItem:" + localObject);
          }
          int m = ((amow)localObject).jdField_a_of_type_Int;
          int n = ((amow)localObject).b;
          String str = ((amow)localObject).a();
          if (TextUtils.isEmpty(str))
          {
            if (QLog.isColorLevel()) {
              QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes url is empty resType->" + m + " id->" + n);
            }
            paramString2.decrementAndGet();
          }
          for (;;)
          {
            i += 1;
            break label192;
            File localFile = new File(((amow)localObject).b());
            if (!paramBoolean)
            {
              if ((localFile.exists()) && (((amow)localObject).b())) {}
              for (int j = 1;; j = 0)
              {
                if (j == 0) {
                  break label431;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("rscContent_CmShowRscDownloader", 2, "file exsit resType->" + m + " id->" + n);
                }
                paramString2.decrementAndGet();
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("rscContent_CmShowRscDownloader", 2, "file not exsit resType->" + m + " id->" + n);
              }
            }
            if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
            {
              if (paramamoz != null) {
                paramamoz.a(false, paramString1, paramList, "");
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes NetworkUtil.isNetworkAvailable is false!");
              return;
            }
            localFile.getParentFile().mkdirs();
            localObject = new bhyo(str, localFile);
            ((bhyo)localObject).p = true;
            ((bhyo)localObject).n = true;
            ((bhyo)localObject).f = "apollo_res";
            ((bhyo)localObject).b = 1;
            ((bhyo)localObject).q = true;
            ((bhyo)localObject).r = true;
            paramAppInterface.a((bhyo)localObject, new amoy(str, localFile, localAtomicInteger2, m, n, localAtomicInteger1, paramString2, paramamoz, localamow, paramString1, paramList), null);
          }
        }
      } while (paramString2.get() != 0);
      if (paramamoz != null)
      {
        paramAppInterface = "";
        if (localamow != null) {
          paramAppInterface = localamow.c();
        }
        paramamoz.a(true, paramString1, paramList, paramAppInterface);
      }
    } while (!QLog.isColorLevel());
    label431:
    QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes local dress ok uin:" + paramString1 + ", all cnt: " + paramString2.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amox
 * JD-Core Version:    0.7.0.1
 */