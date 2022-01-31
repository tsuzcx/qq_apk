import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.IPSiteModel.Goods;

public final class anik
  implements Parcelable.Creator
{
  public IPSiteModel.Goods a(Parcel paramParcel)
  {
    IPSiteModel.Goods localGoods = new IPSiteModel.Goods();
    localGoods.cover = paramParcel.readString();
    localGoods.goodsTags = paramParcel.readString();
    localGoods.id = paramParcel.readString();
    localGoods.name = paramParcel.readString();
    localGoods.price = paramParcel.readString();
    localGoods.saleTags = paramParcel.readString();
    localGoods.svipPrice = paramParcel.readString();
    localGoods.url = paramParcel.readString();
    localGoods.moreUrl = paramParcel.readString();
    localGoods.saleNum = paramParcel.readString();
    return localGoods;
  }
  
  public IPSiteModel.Goods[] a(int paramInt)
  {
    return new IPSiteModel.Goods[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anik
 * JD-Core Version:    0.7.0.1
 */