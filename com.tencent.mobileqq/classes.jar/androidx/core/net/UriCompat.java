package androidx.core.net;

import android.net.Uri;
import androidx.annotation.NonNull;

public final class UriCompat
{
  @NonNull
  public static String toSafeString(@NonNull Uri paramUri)
  {
    String str = paramUri.getScheme();
    Object localObject = paramUri.getSchemeSpecificPart();
    if (str != null)
    {
      if ((str.equalsIgnoreCase("tel")) || (str.equalsIgnoreCase("sip")) || (str.equalsIgnoreCase("sms")) || (str.equalsIgnoreCase("smsto")) || (str.equalsIgnoreCase("mailto")) || (str.equalsIgnoreCase("nfc")))
      {
        paramUri = new StringBuilder(64);
        paramUri.append(str);
        paramUri.append(':');
        if (localObject != null)
        {
          int i = 0;
          if (i < ((String)localObject).length())
          {
            char c = ((String)localObject).charAt(i);
            if ((c == '-') || (c == '@') || (c == '.')) {
              paramUri.append(c);
            }
            for (;;)
            {
              i += 1;
              break;
              paramUri.append('x');
            }
          }
        }
        return paramUri.toString();
      }
      if ((str.equalsIgnoreCase("http")) || (str.equalsIgnoreCase("https")) || (str.equalsIgnoreCase("ftp")) || (str.equalsIgnoreCase("rtsp")))
      {
        StringBuilder localStringBuilder = new StringBuilder().append("//");
        if (paramUri.getHost() != null)
        {
          localObject = paramUri.getHost();
          localObject = localStringBuilder.append((String)localObject);
          if (paramUri.getPort() == -1) {
            break label334;
          }
          paramUri = ":" + paramUri.getPort();
        }
      }
    }
    label270:
    for (paramUri = paramUri + "/...";; paramUri = (Uri)localObject)
    {
      localObject = new StringBuilder(64);
      if (str != null)
      {
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(':');
      }
      if (paramUri != null) {
        ((StringBuilder)localObject).append(paramUri);
      }
      return ((StringBuilder)localObject).toString();
      localObject = "";
      break;
      label334:
      paramUri = "";
      break label270;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.net.UriCompat
 * JD-Core Version:    0.7.0.1
 */