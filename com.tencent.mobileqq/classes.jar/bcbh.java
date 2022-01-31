import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.webview.WebViewTitleStyle;

public final class bcbh
  implements Parcelable.Creator<WebViewTitleStyle>
{
  public WebViewTitleStyle a(Parcel paramParcel)
  {
    return new WebViewTitleStyle(paramParcel);
  }
  
  public WebViewTitleStyle[] a(int paramInt)
  {
    return new WebViewTitleStyle[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcbh
 * JD-Core Version:    0.7.0.1
 */