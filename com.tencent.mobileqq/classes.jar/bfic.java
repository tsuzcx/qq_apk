import ConfigPush.DomainIpChannel;
import ConfigPush.DomainIpInfo;
import ConfigPush.DomainIpList;
import ConfigPush.FileStoragePushFSSvcList;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.Iterator;

public class bfic
{
  protected String a;
  protected String b;
  protected String c;
  
  public void a(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    int i;
    if (Build.VERSION.SDK_INT > 10)
    {
      i = 4;
      localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("QfavSrvAddrList", i);
      if (localObject != null) {
        break label32;
      }
    }
    label32:
    while ((paramFileStoragePushFSSvcList == null) || (paramFileStoragePushFSSvcList.domainIpChannel == null) || (paramFileStoragePushFSSvcList.domainIpChannel.vDomain_iplists == null))
    {
      return;
      i = 0;
      break;
    }
    paramFileStoragePushFSSvcList = paramFileStoragePushFSSvcList.domainIpChannel.vDomain_iplists.iterator();
    while (paramFileStoragePushFSSvcList.hasNext())
    {
      DomainIpList localDomainIpList = (DomainIpList)paramFileStoragePushFSSvcList.next();
      StringBuilder localStringBuilder = new StringBuilder();
      if ((localDomainIpList.uDomain_type == 4) || (localDomainIpList.uDomain_type == 5) || (localDomainIpList.uDomain_type == 6))
      {
        if ((localDomainIpList.vIplist != null) && (localDomainIpList.vIplist.size() != 0))
        {
          i = 0;
          while (i < localDomainIpList.vIplist.size())
          {
            DomainIpInfo localDomainIpInfo = (DomainIpInfo)localDomainIpList.vIplist.get(i);
            localStringBuilder.append(badq.a(localDomainIpInfo.uIp)).append(":").append(localDomainIpInfo.uPort);
            if (i < localDomainIpList.vIplist.size() - 1) {
              localStringBuilder.append("|");
            }
            i += 1;
          }
        }
      }
      else {
        switch (localDomainIpList.uDomain_type)
        {
        default: 
          break;
        case 4: 
          this.a = localStringBuilder.toString();
          ((SharedPreferences)localObject).edit().putString("QfavSrvAddrList_FavIp", this.a).commit();
          break;
        case 5: 
          this.c = localStringBuilder.toString();
          ((SharedPreferences)localObject).edit().putString("QfavSrvAddrList_UploadPicIp", this.c).commit();
          break;
        case 6: 
          this.b = localStringBuilder.toString();
          ((SharedPreferences)localObject).edit().putString("QfavSrvAddrList_PicPlatformIp", this.b).commit();
        }
      }
    }
    paramFileStoragePushFSSvcList = new Intent("com.tencent.receiver.qfav.srvaddr");
    paramFileStoragePushFSSvcList.putExtra("com.tencent.receiver.qfav.srvaddr.type", 0);
    BaseApplicationImpl.getApplication().sendBroadcast(paramFileStoragePushFSSvcList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfic
 * JD-Core Version:    0.7.0.1
 */