import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pic.ReportInfo;

public final class awkc
  implements Parcelable.Creator<ReportInfo>
{
  public ReportInfo a(Parcel paramParcel)
  {
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.jdField_a_of_type_Int = paramParcel.readInt();
    localReportInfo.jdField_b_of_type_Int = paramParcel.readInt();
    localReportInfo.jdField_c_of_type_Int = paramParcel.readInt();
    localReportInfo.f = paramParcel.readInt();
    localReportInfo.d = paramParcel.readInt();
    localReportInfo.e = paramParcel.readInt();
    localReportInfo.jdField_a_of_type_Long = paramParcel.readLong();
    localReportInfo.jdField_b_of_type_Long = paramParcel.readLong();
    localReportInfo.jdField_c_of_type_Long = paramParcel.readLong();
    return localReportInfo;
  }
  
  public ReportInfo[] a(int paramInt)
  {
    return new ReportInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awkc
 * JD-Core Version:    0.7.0.1
 */