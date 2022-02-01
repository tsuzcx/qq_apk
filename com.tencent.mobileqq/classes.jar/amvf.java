import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.CmShowRscUpdateHandler.1;
import com.tencent.mobileqq.apollo.CmShowRscUpdateHandler.2;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.base.BspatchUtil;
import com.tencent.pb.clubcontent.CmShowContentUpdate.STContInfo;
import com.tencent.pb.clubcontent.CmShowContentUpdate.STContUpdReq;
import com.tencent.pb.clubcontent.CmShowContentUpdate.STContUpdRsp;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class amvf
  implements BusinessObserver
{
  private static int jdField_a_of_type_Int = 180;
  private static amvf jdField_a_of_type_Amvf;
  private final SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("cmshow_rsc_update_sp", 4);
  private final SparseArray<WeakReference<amvj>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private List<amvi> jdField_a_of_type_JavaUtilList;
  
  private amvf()
  {
    int i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("json_content_update_interval", 0);
    if (i >= 10) {
      jdField_a_of_type_Int = i;
    }
    QLog.i("rscContent_CmShowRscUpdateHandler", 1, "RscContentUpdateHandler sJsonContentUpdateInterval:" + jdField_a_of_type_Int);
  }
  
  public static amvf a()
  {
    try
    {
      if (jdField_a_of_type_Amvf == null) {
        jdField_a_of_type_Amvf = new amvf();
      }
      amvf localamvf = jdField_a_of_type_Amvf;
      return localamvf;
    }
    finally {}
  }
  
  private void a(int paramInt)
  {
    WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      ((amvj)localWeakReference.get()).a(false, null);
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    }
    QLog.i("rscContent_CmShowRscUpdateHandler", 1, "onContentCheckFailed requestId:" + paramInt);
  }
  
  private void a(int paramInt, amvi paramamvi)
  {
    if (paramamvi == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "onContentCheckSuccess result" + paramamvi);
    }
    if ((paramamvi.jdField_a_of_type_Int == 100) && (paramamvi.jdField_a_of_type_Long == 1L))
    {
      if (1 == BaseApplicationImpl.sProcessId) {
        break label293;
      }
      if ("all_room3D".equals(paramamvi.jdField_a_of_type_JavaLangString)) {
        amva.a().a();
      }
    }
    else
    {
      label79:
      a(paramamvi, paramamvi.jdField_b_of_type_Int);
      if (paramamvi.jdField_b_of_type_Boolean)
      {
        if (paramamvi.jdField_d_of_type_Int <= 0) {
          break label417;
        }
        if (jdField_a_of_type_Int == paramamvi.jdField_d_of_type_Int) {
          break label380;
        }
        jdField_a_of_type_Int = paramamvi.jdField_d_of_type_Int;
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("json_content_update_interval", paramamvi.jdField_d_of_type_Int).commit();
        QLog.i("rscContent_CmShowRscUpdateHandler", 1, "onContentCheckSuccess interval != result.mCheckServerInterval:" + paramamvi.jdField_d_of_type_Int);
      }
    }
    label417:
    for (;;)
    {
      for (;;)
      {
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          this.jdField_a_of_type_JavaUtilList.remove(paramamvi);
          if (this.jdField_a_of_type_JavaUtilList.isEmpty())
          {
            this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("last_json_content_update_ts", System.currentTimeMillis()).commit();
            QLog.i("rscContent_CmShowRscUpdateHandler", 1, "onContentCheckSuccess save lastCheckContentUpdateTS");
          }
        }
        Object localObject = (WeakReference)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        if ((localObject == null) || (((WeakReference)localObject).get() == null)) {
          break;
        }
        ((amvj)((WeakReference)localObject).get()).a(true, paramamvi);
        this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
        return;
        QLog.i("rscContent_CmShowRscUpdateHandler", 1, "check update from QQ process");
        break label79;
        label293:
        if (!anbd.a(BaseApplicationImpl.getContext())) {
          break label79;
        }
        localObject = new Intent();
        ((Intent)localObject).setAction("com.tencent.mobileqq.webprocess.launch_cmgame");
        ((Intent)localObject).putExtra("action_apollo_cmshow_content_update", true);
        ((Intent)localObject).putExtra("key_content_update_zip_name", "all_room3D");
        ((Intent)localObject).setPackage(BaseApplicationImpl.getContext().getPackageName());
        try
        {
          QLog.i("rscContent_CmShowRscUpdateHandler", 1, "send sendBroadcast contentUpdate");
          BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
        }
        catch (Throwable localThrowable)
        {
          QLog.e("rscContent_CmShowRscUpdateHandler", 1, localThrowable, new Object[0]);
        }
      }
      break label79;
      label380:
      if (QLog.isColorLevel())
      {
        QLog.d("rscContent_CmShowRscUpdateHandler", 2, "onContentCheckSuccess interval == result.mCheckServerInterval:" + paramamvi.jdField_d_of_type_Int);
        continue;
        QLog.i("rscContent_CmShowRscUpdateHandler", 1, "onContentCheckSuccess result.mCheckServerInterval <= 0" + paramamvi.jdField_d_of_type_Int);
      }
    }
  }
  
  private void a(int paramInt, CmShowContentUpdate.STContUpdRsp paramSTContUpdRsp, boolean paramBoolean)
  {
    if (paramSTContUpdRsp != null) {
      ThreadManager.post(new CmShowRscUpdateHandler.2(this, paramSTContUpdRsp, paramBoolean, paramInt), 5, null, false);
    }
  }
  
  private void a(int paramInt, List<amvi> paramList)
  {
    if (paramList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("rscContent_CmShowRscUpdateHandler", 2, "updateResource checkResults:" + paramList.size());
      }
      if (paramList.isEmpty()) {}
      for (;;)
      {
        return;
        Object localObject = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null)
        {
          localObject = (bihw)((AppInterface)localObject).getManager(47);
          if ((localObject != null) && (((bihw)localObject).a(3) != null))
          {
            paramList = paramList.iterator();
            while (paramList.hasNext())
            {
              amvi localamvi = (amvi)paramList.next();
              if (localamvi != null)
              {
                localObject = new File(localamvi.c());
                ((File)localObject).getParentFile().mkdirs();
                if (((File)localObject).exists()) {
                  ((File)localObject).delete();
                }
                String str1 = localamvi.e();
                if ((localamvi.jdField_a_of_type_Boolean) && (!new File(str1).exists()))
                {
                  localamvi.jdField_a_of_type_Boolean = false;
                  QLog.e("rscContent_CmShowRscUpdateHandler", 1, "updateResource old version File no exist :" + str1);
                }
                if (localamvi.jdField_a_of_type_Boolean)
                {
                  if (localamvi.jdField_a_of_type_ArrayOfByte != null)
                  {
                    String str2 = localamvi.d();
                    if (bhmi.a(localamvi.jdField_a_of_type_ArrayOfByte, str2))
                    {
                      if (BspatchUtil.a(str1, str2, ((File)localObject).getAbsolutePath()))
                      {
                        QLog.d("rscContent_CmShowRscUpdateHandler", 2, "BspatchUtil.patch success path:" + ((File)localObject).getAbsolutePath());
                        try
                        {
                          str1 = bjtz.a(((File)localObject).getAbsolutePath());
                          if (QLog.isColorLevel()) {
                            QLog.d("rscContent_CmShowRscUpdateHandler", 2, " updateResource onDone dstMd5:" + str1 + " result.mMd5:" + localamvi.jdField_d_of_type_JavaLangString);
                          }
                          if (!b(localamvi, str1)) {
                            break label640;
                          }
                          if (b(localamvi))
                          {
                            nof.a((File)localObject, ((File)localObject).getParent() + File.separator);
                            if (QLog.isColorLevel()) {
                              QLog.d("rscContent_CmShowRscUpdateHandler", 2, "updateResource unZipFile ok file dstpath:" + ((File)localObject).getAbsolutePath());
                            }
                            a(localamvi.jdField_e_of_type_Int, localamvi);
                          }
                        }
                        catch (Exception localException)
                        {
                          for (;;)
                          {
                            ((File)localObject).delete();
                            if (QLog.isColorLevel()) {
                              QLog.d("rscContent_CmShowRscUpdateHandler", 2, "updateResource unZipFile file error path->" + ((File)localObject).getAbsolutePath() + localException.getMessage());
                            }
                            a(paramInt);
                            break;
                            boolean bool = bhmi.d(((File)localObject).getAbsolutePath(), localException.b() + localException.jdField_e_of_type_JavaLangString);
                            QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip no need unzip copy:" + bool);
                          }
                        }
                        catch (OutOfMemoryError localOutOfMemoryError)
                        {
                          ((File)localObject).delete();
                        }
                        if (QLog.isColorLevel())
                        {
                          QLog.d("rscContent_CmShowRscUpdateHandler", 2, "updateResource unZipFile file error path->" + ((File)localObject).getAbsolutePath() + localOutOfMemoryError.getMessage());
                          continue;
                          label640:
                          QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
                          b(localOutOfMemoryError);
                        }
                      }
                      else
                      {
                        QLog.e("rscContent_CmShowRscUpdateHandler", 1, "BspatchUtil.patch failed path:" + ((File)localObject).getAbsolutePath());
                        b(localOutOfMemoryError);
                      }
                    }
                    else {
                      b(localOutOfMemoryError);
                    }
                  }
                  else
                  {
                    a(localOutOfMemoryError);
                  }
                }
                else {
                  b(localOutOfMemoryError);
                }
              }
            }
          }
        }
      }
    }
    a(paramInt, null);
  }
  
  private void a(amvi paramamvi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch result:" + paramamvi);
    }
    if (paramamvi == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while (localObject == null);
        localObject = (bihw)((AppInterface)localObject).getManager(47);
      } while (localObject == null);
      localObject = ((bihw)localObject).a(3);
    } while (localObject == null);
    if (TextUtils.isEmpty(paramamvi.c))
    {
      QLog.e("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch result.mDownloadPatchFileUrl is empty result:" + paramamvi);
      return;
    }
    File localFile = new File(paramamvi.d());
    localFile.getParentFile().mkdirs();
    if (localFile.exists()) {
      localFile.delete();
    }
    bihu localbihu = new bihu(paramamvi.c, localFile);
    localbihu.p = true;
    localbihu.n = true;
    localbihu.f = "apollo_res";
    localbihu.jdField_b_of_type_Int = 1;
    localbihu.q = true;
    localbihu.r = true;
    localbihu.jdField_a_of_type_JavaLangString = (paramamvi.jdField_b_of_type_JavaLangString + "_" + paramamvi.jdField_a_of_type_JavaLangString);
    ((bihz)localObject).a(localbihu, new amvg(this, localFile, paramamvi), null);
  }
  
  private void b(amvi paramamvi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip result:" + paramamvi);
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (paramamvi == null)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while (localObject == null);
        localObject = (bihw)((AppInterface)localObject).getManager(47);
      } while (localObject == null);
      localObject = ((bihw)localObject).a(3);
    } while (localObject == null);
    if (TextUtils.isEmpty(paramamvi.jdField_b_of_type_JavaLangString))
    {
      QLog.e("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip result.mDownloadFileUrl is empty result:" + paramamvi);
      return;
    }
    File localFile = new File(paramamvi.c());
    localFile.getParentFile().mkdirs();
    if (localFile.exists()) {
      localFile.delete();
    }
    bihu localbihu = new bihu(paramamvi.jdField_b_of_type_JavaLangString, localFile);
    localbihu.p = true;
    localbihu.n = true;
    localbihu.f = "apollo_res";
    localbihu.jdField_b_of_type_Int = 1;
    localbihu.q = true;
    localbihu.r = true;
    localbihu.jdField_a_of_type_JavaLangString = (paramamvi.jdField_b_of_type_JavaLangString + "_" + paramamvi.jdField_a_of_type_JavaLangString);
    ((bihz)localObject).a(localbihu, new amvh(this, localFile, paramamvi), null);
  }
  
  private static boolean b(amvi paramamvi)
  {
    if (paramamvi == null) {}
    while ((TextUtils.isEmpty(paramamvi.jdField_e_of_type_JavaLangString)) || (!paramamvi.jdField_e_of_type_JavaLangString.endsWith(".zip"))) {
      return false;
    }
    return true;
  }
  
  private static boolean b(amvi paramamvi, String paramString)
  {
    if (paramamvi == null) {}
    do
    {
      return false;
      if (TextUtils.isEmpty(paramamvi.jdField_d_of_type_JavaLangString)) {
        return true;
      }
    } while ((paramString == null) || (!paramString.equalsIgnoreCase(paramamvi.jdField_d_of_type_JavaLangString)));
    return true;
  }
  
  public int a(int paramInt, long paramLong, String paramString)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(paramInt + "_" + paramLong + "_" + paramString, 0);
  }
  
  public void a(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(paramInt1 + "_" + paramLong + "_" + paramString, paramInt2).commit();
  }
  
  public void a(int paramInt, amvj paramamvj)
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, new WeakReference(paramamvj));
      return;
    }
  }
  
  public void a(amvi paramamvi, int paramInt)
  {
    if (paramamvi != null)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(paramamvi.a(), paramInt).commit();
      QLog.i("rscContent_CmShowRscUpdateHandler", 1, "saveContentVersion version:" + paramInt);
    }
  }
  
  public void a(AppInterface paramAppInterface)
  {
    ThreadManagerV2.excute(new CmShowRscUpdateHandler.1(this, paramAppInterface), 16, null, false);
  }
  
  public void a(AppInterface paramAppInterface, int paramInt, boolean paramBoolean)
  {
    QLog.i("rscContent_CmShowRscUpdateHandler", 1, "checkCmShowContentUpdate forceCheck:" + paramBoolean);
    if (paramAppInterface == null) {}
    do
    {
      return;
      if (!amvi.a(100, 1L, "all_room3D", "all_room3D.json"))
      {
        a(100, 1L, "all_room3D", 0);
        paramBoolean = true;
      }
      if (!paramBoolean)
      {
        long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("last_json_content_update_ts", 0L);
        if (System.currentTimeMillis() - l < jdField_a_of_type_Int * 1000)
        {
          QLog.i("rscContent_CmShowRscUpdateHandler", 1, "checkCmShowContentUpdate in sJsonContentUpdateInterval:" + jdField_a_of_type_Int);
          return;
        }
      }
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
      Object localObject1 = new CmShowContentUpdate.STContUpdReq();
      ((CmShowContentUpdate.STContUpdReq)localObject1).app_id.set(1);
      Object localObject2 = new ArrayList();
      Object localObject3 = new CmShowContentUpdate.STContInfo();
      ((CmShowContentUpdate.STContInfo)localObject3).biz_id.set(100);
      ((CmShowContentUpdate.STContInfo)localObject3).item_id.set(1L);
      ((CmShowContentUpdate.STContInfo)localObject3).name.set(ByteStringMicro.copyFromUtf8("all_room3D"));
      ((CmShowContentUpdate.STContInfo)localObject3).ver.set(a(100, 1L, "all_room3D"));
      ((List)localObject2).add(localObject3);
      ((CmShowContentUpdate.STContUpdReq)localObject1).cont_list.set((List)localObject2);
      try
      {
        localObject3 = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject3).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject3).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject3).mqqver.set("8.4.5");
        localObject2 = new WebSSOAgent.UniSsoServerReq();
        ((WebSSOAgent.UniSsoServerReq)localObject2).comm.set((MessageMicro)localObject3);
        ((WebSSOAgent.UniSsoServerReq)localObject2).pbReqData.set(ByteStringMicro.copyFrom(((CmShowContentUpdate.STContUpdReq)localObject1).toByteArray()));
        localObject1 = new NewIntent(BaseApplicationImpl.getContext(), awjk.class);
        ((NewIntent)localObject1).putExtra("extra_cmd", "cmshowar_content_update.check");
        ((NewIntent)localObject1).putExtra("extra_data", ((WebSSOAgent.UniSsoServerReq)localObject2).toByteArray());
        ((NewIntent)localObject1).putExtra("extra_callbackid", String.valueOf(paramInt));
        ((NewIntent)localObject1).setObserver(this);
        paramAppInterface.startServlet((NewIntent)localObject1);
        return;
      }
      catch (Exception paramAppInterface) {}
    } while (!QLog.isColorLevel());
    QLog.e("rscContent_CmShowRscUpdateHandler", 2, "OpenPandora failed ", paramAppInterface);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str;
    for (;;)
    {
      return;
      paramInt = paramBundle.getInt("extra_result_code");
      Object localObject = paramBundle.getString("extra_cmd");
      str = paramBundle.getString("extra_callbackid");
      QLog.i("rscContent_CmShowRscUpdateHandler", 1, "isSuccess:" + paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("rscContent_CmShowRscUpdateHandler", 2, "svrRet:" + paramInt + " cmd:" + (String)localObject + " requestIdStr:" + str);
      }
      if (!paramBoolean) {
        break label281;
      }
      try
      {
        byte[] arrayOfByte = paramBundle.getByteArray("extra_data");
        paramBundle = new WebSSOAgent.UniSsoServerRsp();
        paramBundle.mergeFrom(arrayOfByte);
        long l = paramBundle.ret.get();
        if (QLog.isColorLevel()) {
          QLog.d("rscContent_CmShowRscUpdateHandler", 2, "retCode:" + l + " isSuccess:" + paramBoolean + " cmd:" + (String)localObject);
        }
        if ("cmshowar_content_update.check".equals(localObject)) {
          if (l == 0L)
          {
            localObject = new CmShowContentUpdate.STContUpdRsp();
            ((CmShowContentUpdate.STContUpdRsp)localObject).mergeFrom(paramBundle.pbRsqData.get().toByteArray());
            a(ApolloUtil.b(str), (CmShowContentUpdate.STContUpdRsp)localObject, true);
            return;
          }
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("rscContent_CmShowRscUpdateHandler", 1, paramBundle, new Object[0]);
        return;
      }
    }
    a(ApolloUtil.b(str));
    return;
    label281:
    a(ApolloUtil.b(str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvf
 * JD-Core Version:    0.7.0.1
 */