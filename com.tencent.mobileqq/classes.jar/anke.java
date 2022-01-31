import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.IPSiteModel.Book;
import com.tencent.mobileqq.data.IPSiteModel.Comic;
import com.tencent.mobileqq.data.IPSiteModel.Game;
import com.tencent.mobileqq.data.IPSiteModel.Goods;
import com.tencent.mobileqq.data.IPSiteModel.Gxzb;
import com.tencent.mobileqq.data.IPSiteModel.Video;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import java.util.ArrayList;
import java.util.List;

public final class anke
  implements Parcelable.Creator
{
  public VipIPSiteInfo a(Parcel paramParcel)
  {
    VipIPSiteInfo localVipIPSiteInfo = new VipIPSiteInfo();
    localVipIPSiteInfo.ipID = paramParcel.readInt();
    localVipIPSiteInfo.ipName = paramParcel.readString();
    localVipIPSiteInfo.ipDesc = paramParcel.readString();
    localVipIPSiteInfo.ipUrl = paramParcel.readString();
    localVipIPSiteInfo.itemSize = paramParcel.readInt();
    localVipIPSiteInfo.strType = paramParcel.readString();
    localVipIPSiteInfo.extId = paramParcel.readInt();
    localVipIPSiteInfo.extStr = paramParcel.readString();
    localVipIPSiteInfo.ipLogo = paramParcel.readString();
    localVipIPSiteInfo.ipContent = paramParcel.readString();
    if (localVipIPSiteInfo.ipList == null) {
      localVipIPSiteInfo.ipList = new ArrayList();
    }
    localVipIPSiteInfo.ipList.clear();
    if ("gxzb".equals(localVipIPSiteInfo.strType)) {
      paramParcel.readList(localVipIPSiteInfo.ipList, IPSiteModel.Gxzb.class.getClassLoader());
    }
    do
    {
      return localVipIPSiteInfo;
      if ("game".equals(localVipIPSiteInfo.strType))
      {
        paramParcel.readList(localVipIPSiteInfo.ipList, IPSiteModel.Game.class.getClassLoader());
        return localVipIPSiteInfo;
      }
      if ("goods".equals(localVipIPSiteInfo.strType))
      {
        paramParcel.readList(localVipIPSiteInfo.ipList, IPSiteModel.Goods.class.getClassLoader());
        return localVipIPSiteInfo;
      }
      if ("video".equals(localVipIPSiteInfo.strType))
      {
        paramParcel.readList(localVipIPSiteInfo.ipList, IPSiteModel.Video.class.getClassLoader());
        return localVipIPSiteInfo;
      }
      if ("book".equals(localVipIPSiteInfo.strType))
      {
        paramParcel.readList(localVipIPSiteInfo.ipList, IPSiteModel.Book.class.getClassLoader());
        return localVipIPSiteInfo;
      }
    } while (!"comic".equals(localVipIPSiteInfo.strType));
    paramParcel.readList(localVipIPSiteInfo.ipList, IPSiteModel.Comic.class.getClassLoader());
    return localVipIPSiteInfo;
  }
  
  public VipIPSiteInfo[] a(int paramInt)
  {
    return new VipIPSiteInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anke
 * JD-Core Version:    0.7.0.1
 */