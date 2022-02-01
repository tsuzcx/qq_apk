package androidx.core.net;

import android.net.Uri;
import androidx.annotation.NonNull;

public final class UriCompat
{
  @NonNull
  public static String toSafeString(@NonNull Uri paramUri)
  {
    String str2 = paramUri.getScheme();
    String str1 = paramUri.getSchemeSpecificPart();
    Object localObject = str1;
    if (str2 != null) {
      if ((!str2.equalsIgnoreCase("tel")) && (!str2.equalsIgnoreCase("sip")) && (!str2.equalsIgnoreCase("sms")) && (!str2.equalsIgnoreCase("smsto")) && (!str2.equalsIgnoreCase("mailto")) && (!str2.equalsIgnoreCase("nfc")))
      {
        if ((!str2.equalsIgnoreCase("http")) && (!str2.equalsIgnoreCase("https")) && (!str2.equalsIgnoreCase("ftp")))
        {
          localObject = str1;
          if (!str2.equalsIgnoreCase("rtsp")) {}
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("//");
          localObject = paramUri.getHost();
          str1 = "";
          if (localObject != null) {
            localObject = paramUri.getHost();
          } else {
            localObject = "";
          }
          localStringBuilder.append((String)localObject);
          localObject = str1;
          if (paramUri.getPort() != -1)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(":");
            ((StringBuilder)localObject).append(paramUri.getPort());
            localObject = ((StringBuilder)localObject).toString();
          }
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("/...");
          localObject = localStringBuilder.toString();
        }
      }
      else
      {
        paramUri = new StringBuilder(64);
        paramUri.append(str2);
        paramUri.append(':');
        if (str1 != null)
        {
          int i = 0;
          while (i < str1.length())
          {
            char c = str1.charAt(i);
            if ((c != '-') && (c != '@') && (c != '.')) {
              paramUri.append('x');
            } else {
              paramUri.append(c);
            }
            i += 1;
          }
        }
        return paramUri.toString();
      }
    }
    paramUri = new StringBuilder(64);
    if (str2 != null)
    {
      paramUri.append(str2);
      paramUri.append(':');
    }
    if (localObject != null) {
      paramUri.append((String)localObject);
    }
    return paramUri.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.net.UriCompat
 * JD-Core Version:    0.7.0.1
 */