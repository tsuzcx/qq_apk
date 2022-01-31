import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.launcher.model.AppMode;

public final class bdmm
  implements Parcelable.Creator<AppMode>
{
  public AppMode a(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMode localAppMode = new AppMode();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      localAppMode.a = bool1;
      if (paramParcel.readInt() != 1) {
        break label163;
      }
      bool1 = true;
      label37:
      localAppMode.b = bool1;
      if (paramParcel.readInt() != 1) {
        break label168;
      }
      bool1 = true;
      label53:
      localAppMode.c = bool1;
      if (paramParcel.readInt() != 1) {
        break label173;
      }
      bool1 = true;
      label69:
      localAppMode.d = bool1;
      if (paramParcel.readInt() != 1) {
        break label178;
      }
      bool1 = true;
      label85:
      localAppMode.e = bool1;
      if (paramParcel.readInt() != 1) {
        break label183;
      }
      bool1 = true;
      label101:
      localAppMode.f = bool1;
      if (paramParcel.readInt() != 1) {
        break label188;
      }
      bool1 = true;
      label117:
      localAppMode.g = bool1;
      if (paramParcel.readInt() != 1) {
        break label193;
      }
      bool1 = true;
      label133:
      localAppMode.h = bool1;
      if (paramParcel.readInt() != 1) {
        break label198;
      }
    }
    label163:
    label168:
    label173:
    label178:
    label183:
    label188:
    label193:
    label198:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localAppMode.i = bool1;
      return localAppMode;
      bool1 = false;
      break;
      bool1 = false;
      break label37;
      bool1 = false;
      break label53;
      bool1 = false;
      break label69;
      bool1 = false;
      break label85;
      bool1 = false;
      break label101;
      bool1 = false;
      break label117;
      bool1 = false;
      break label133;
    }
  }
  
  public AppMode[] a(int paramInt)
  {
    return new AppMode[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdmm
 * JD-Core Version:    0.7.0.1
 */