import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.comment.DanmuItemBean;

public final class amld
  implements Parcelable.Creator<DanmuItemBean>
{
  public DanmuItemBean a(Parcel paramParcel)
  {
    boolean bool = true;
    DanmuItemBean localDanmuItemBean = new DanmuItemBean();
    localDanmuItemBean.jdField_a_of_type_Long = paramParcel.readLong();
    localDanmuItemBean.jdField_b_of_type_Long = paramParcel.readLong();
    localDanmuItemBean.d = paramParcel.readLong();
    localDanmuItemBean.jdField_c_of_type_Long = paramParcel.readLong();
    localDanmuItemBean.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localDanmuItemBean.jdField_b_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      localDanmuItemBean.jdField_a_of_type_Boolean = bool;
      localDanmuItemBean.jdField_c_of_type_JavaLangString = paramParcel.readString();
      localDanmuItemBean.jdField_a_of_type_Int = paramParcel.readInt();
      return localDanmuItemBean;
      bool = false;
    }
  }
  
  public DanmuItemBean[] a(int paramInt)
  {
    return new DanmuItemBean[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amld
 * JD-Core Version:    0.7.0.1
 */