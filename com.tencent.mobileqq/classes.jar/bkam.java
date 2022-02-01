import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.open.wadl.WadlJsBridgeDownloadInfo;

public final class bkam
  implements Parcelable.Creator<WadlJsBridgeDownloadInfo>
{
  public WadlJsBridgeDownloadInfo a(Parcel paramParcel)
  {
    boolean bool2 = true;
    WadlJsBridgeDownloadInfo localWadlJsBridgeDownloadInfo = new WadlJsBridgeDownloadInfo();
    localWadlJsBridgeDownloadInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localWadlJsBridgeDownloadInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localWadlJsBridgeDownloadInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
    localWadlJsBridgeDownloadInfo.d = paramParcel.readString();
    localWadlJsBridgeDownloadInfo.jdField_e_of_type_JavaLangString = paramParcel.readString();
    localWadlJsBridgeDownloadInfo.jdField_a_of_type_Long = paramParcel.readInt();
    localWadlJsBridgeDownloadInfo.f = paramParcel.readString();
    localWadlJsBridgeDownloadInfo.jdField_g_of_type_JavaLangString = paramParcel.readString();
    localWadlJsBridgeDownloadInfo.jdField_a_of_type_Int = paramParcel.readInt();
    localWadlJsBridgeDownloadInfo.j = paramParcel.readString();
    localWadlJsBridgeDownloadInfo.i = paramParcel.readInt();
    localWadlJsBridgeDownloadInfo.jdField_e_of_type_Int = paramParcel.readInt();
    localWadlJsBridgeDownloadInfo.jdField_b_of_type_Long = paramParcel.readLong();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      localWadlJsBridgeDownloadInfo.jdField_b_of_type_Boolean = bool1;
      localWadlJsBridgeDownloadInfo.l = paramParcel.readString();
      localWadlJsBridgeDownloadInfo.jdField_g_of_type_Int = paramParcel.readInt();
      localWadlJsBridgeDownloadInfo.h = paramParcel.readInt();
      localWadlJsBridgeDownloadInfo.m = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label203;
      }
    }
    label203:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localWadlJsBridgeDownloadInfo.jdField_c_of_type_Boolean = bool1;
      return localWadlJsBridgeDownloadInfo;
      bool1 = false;
      break;
    }
  }
  
  public WadlJsBridgeDownloadInfo[] a(int paramInt)
  {
    return new WadlJsBridgeDownloadInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkam
 * JD-Core Version:    0.7.0.1
 */