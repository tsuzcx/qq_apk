import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.statistics.UEC.UECItem;

public final class azno
  implements Parcelable.Creator<UEC.UECItem>
{
  public UEC.UECItem a(Parcel paramParcel)
  {
    UEC.UECItem localUECItem = new UEC.UECItem();
    localUECItem.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localUECItem.jdField_a_of_type_Int = paramParcel.readInt();
    localUECItem.jdField_a_of_type_Long = paramParcel.readLong();
    localUECItem.jdField_b_of_type_Int = paramParcel.readInt();
    localUECItem.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localUECItem.c = paramParcel.readString();
    localUECItem.d = paramParcel.readString();
    localUECItem.e = paramParcel.readString();
    localUECItem.f = paramParcel.readString();
    return localUECItem;
  }
  
  public UEC.UECItem[] a(int paramInt)
  {
    return new UEC.UECItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azno
 * JD-Core Version:    0.7.0.1
 */