package com.tencent.mobileqq.app.face;

import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class FaceDownloader$3
  implements Runnable
{
  FaceDownloader$3(FaceDownloader paramFaceDownloader) {}
  
  public void run()
  {
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1|1|999|4|1|0_2|1");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initDPCFlag headWapConn:");
      localStringBuilder.append((String)localObject);
      QLog.i("Q.qqhead.FaceDownloader", 2, localStringBuilder.toString());
    }
    localObject = ((String)localObject).split("\\|");
    if (localObject.length > 7) {
      try
      {
        FaceDownloader.access$502(Integer.parseInt(localObject[7]));
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("initDPCFlag DPC_WAP_DIRECT_CONNECT=");
          ((StringBuilder)localObject).append(FaceDownloader.access$500());
          QLog.i("Q.qqhead.FaceDownloader", 2, ((StringBuilder)localObject).toString());
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqhead.FaceDownloader", 2, "initDPCFlag error :", localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDownloader.3
 * JD-Core Version:    0.7.0.1
 */