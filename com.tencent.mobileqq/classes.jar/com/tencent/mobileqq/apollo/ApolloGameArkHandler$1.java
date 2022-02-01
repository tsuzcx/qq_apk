package com.tencent.mobileqq.apollo;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.util.AvatarDownloadUtil;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;

class ApolloGameArkHandler$1
  implements Runnable
{
  ApolloGameArkHandler$1(ApolloGameArkHandler paramApolloGameArkHandler, String paramString) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.a)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = this.this$0.a();
        } while (localObject == null);
        localObject = ((QQAppInterface)localObject).getQQHeadSettingFromDB(this.a);
      } while ((localObject == null) || (TextUtils.isEmpty(((Setting)localObject).url)));
      localObject = MsfSdkUtils.insertMtype("QQHeadIcon", AvatarDownloadUtil.getQQAvatarDownLoadUrl(((Setting)localObject).url, ((Setting)localObject).bFaceFlags, ((Setting)localObject).bUsrType, 0));
    } while (TextUtils.isEmpty((CharSequence)localObject));
    this.this$0.a(this.a, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloGameArkHandler.1
 * JD-Core Version:    0.7.0.1
 */