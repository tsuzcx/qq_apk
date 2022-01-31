import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.manager.EngineVersion;
import com.tencent.qqmini.sdk.manager.InstalledEngine;

public final class beur
  implements Parcelable.Creator<InstalledEngine>
{
  public InstalledEngine a(Parcel paramParcel)
  {
    boolean bool2 = true;
    InstalledEngine localInstalledEngine = new InstalledEngine();
    localInstalledEngine.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localInstalledEngine.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localInstalledEngine.jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion = ((EngineVersion)paramParcel.readParcelable(EngineVersion.class.getClassLoader()));
    localInstalledEngine.jdField_a_of_type_Int = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      localInstalledEngine.jdField_a_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label102;
      }
    }
    label102:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localInstalledEngine.jdField_b_of_type_Boolean = bool1;
      localInstalledEngine.jdField_b_of_type_Int = paramParcel.readInt();
      return localInstalledEngine;
      bool1 = false;
      break;
    }
  }
  
  public InstalledEngine[] a(int paramInt)
  {
    return new InstalledEngine[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beur
 * JD-Core Version:    0.7.0.1
 */