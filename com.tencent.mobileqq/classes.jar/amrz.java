import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.IPSiteModel.Comic;
import com.tencent.mobileqq.data.IPSiteModel.ComicRich;
import java.util.ArrayList;
import java.util.List;

public final class amrz
  implements Parcelable.Creator
{
  public IPSiteModel.Comic a(Parcel paramParcel)
  {
    IPSiteModel.Comic localComic = new IPSiteModel.Comic();
    localComic.comicType = paramParcel.readInt();
    localComic.cover = paramParcel.readString();
    localComic.desc = paramParcel.readString();
    localComic.id = paramParcel.readString();
    localComic.jumpUrl = paramParcel.readString();
    localComic.name = paramParcel.readString();
    localComic.recommDesc = paramParcel.readString();
    localComic.typeName = paramParcel.readString();
    if (localComic.comicRiches == null) {
      localComic.comicRiches = new ArrayList();
    }
    localComic.comicRiches.clear();
    paramParcel.readList(localComic.comicRiches, IPSiteModel.ComicRich.class.getClassLoader());
    return localComic;
  }
  
  public IPSiteModel.Comic[] a(int paramInt)
  {
    return new IPSiteModel.Comic[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     amrz
 * JD-Core Version:    0.7.0.1
 */