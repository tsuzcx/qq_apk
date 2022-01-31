import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.launcher.model.AppMode;

public final class beqv
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
        break label179;
      }
      bool1 = true;
      label37:
      localAppMode.b = bool1;
      if (paramParcel.readInt() != 1) {
        break label184;
      }
      bool1 = true;
      label53:
      localAppMode.c = bool1;
      if (paramParcel.readInt() != 1) {
        break label189;
      }
      bool1 = true;
      label69:
      localAppMode.d = bool1;
      if (paramParcel.readInt() != 1) {
        break label194;
      }
      bool1 = true;
      label85:
      localAppMode.e = bool1;
      if (paramParcel.readInt() != 1) {
        break label199;
      }
      bool1 = true;
      label101:
      localAppMode.f = bool1;
      if (paramParcel.readInt() != 1) {
        break label204;
      }
      bool1 = true;
      label117:
      localAppMode.g = bool1;
      if (paramParcel.readInt() != 1) {
        break label209;
      }
      bool1 = true;
      label133:
      localAppMode.h = bool1;
      if (paramParcel.readInt() != 1) {
        break label214;
      }
      bool1 = true;
      label149:
      localAppMode.i = bool1;
      if (paramParcel.readInt() != 1) {
        break label219;
      }
    }
    label179:
    label184:
    label189:
    label194:
    label199:
    label204:
    label209:
    label214:
    label219:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localAppMode.j = bool1;
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
      bool1 = false;
      break label149;
    }
  }
  
  public AppMode[] a(int paramInt)
  {
    return new AppMode[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beqv
 * JD-Core Version:    0.7.0.1
 */