package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import java.util.ArrayList;

public class ShareCompat$IntentReader
{
  private static final String TAG = "IntentReader";
  @Nullable
  private final ComponentName mCallingActivity;
  @Nullable
  private final String mCallingPackage;
  @NonNull
  private final Context mContext;
  @NonNull
  private final Intent mIntent;
  @Nullable
  private ArrayList<Uri> mStreams;
  
  private ShareCompat$IntentReader(@NonNull Context paramContext, @NonNull Intent paramIntent)
  {
    this.mContext = ((Context)Preconditions.checkNotNull(paramContext));
    this.mIntent = ((Intent)Preconditions.checkNotNull(paramIntent));
    this.mCallingPackage = ShareCompat.getCallingPackage(paramIntent);
    this.mCallingActivity = ShareCompat.getCallingActivity(paramIntent);
  }
  
  @NonNull
  public static IntentReader from(@NonNull Activity paramActivity)
  {
    return from((Context)Preconditions.checkNotNull(paramActivity), paramActivity.getIntent());
  }
  
  @NonNull
  private static IntentReader from(@NonNull Context paramContext, @NonNull Intent paramIntent)
  {
    return new IntentReader(paramContext, paramIntent);
  }
  
  private static void withinStyle(StringBuilder paramStringBuilder, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      char c = paramCharSequence.charAt(paramInt1);
      if (c == '<') {
        paramStringBuilder.append("&lt;");
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        if (c == '>')
        {
          paramStringBuilder.append("&gt;");
        }
        else if (c == '&')
        {
          paramStringBuilder.append("&amp;");
        }
        else if ((c > '~') || (c < ' '))
        {
          paramStringBuilder.append("&#").append(c).append(";");
        }
        else if (c == ' ')
        {
          while ((paramInt1 + 1 < paramInt2) && (paramCharSequence.charAt(paramInt1 + 1) == ' '))
          {
            paramStringBuilder.append("&nbsp;");
            paramInt1 += 1;
          }
          paramStringBuilder.append(' ');
        }
        else
        {
          paramStringBuilder.append(c);
        }
      }
    }
  }
  
  @Nullable
  public ComponentName getCallingActivity()
  {
    return this.mCallingActivity;
  }
  
  @Nullable
  public Drawable getCallingActivityIcon()
  {
    if (this.mCallingActivity == null) {
      return null;
    }
    Object localObject = this.mContext.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getActivityIcon(this.mCallingActivity);
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("IntentReader", "Could not retrieve icon for calling activity", localNameNotFoundException);
    }
    return null;
  }
  
  @Nullable
  public Drawable getCallingApplicationIcon()
  {
    if (this.mCallingPackage == null) {
      return null;
    }
    Object localObject = this.mContext.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getApplicationIcon(this.mCallingPackage);
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("IntentReader", "Could not retrieve icon for calling application", localNameNotFoundException);
    }
    return null;
  }
  
  @Nullable
  public CharSequence getCallingApplicationLabel()
  {
    if (this.mCallingPackage == null) {
      return null;
    }
    Object localObject = this.mContext.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getApplicationLabel(((PackageManager)localObject).getApplicationInfo(this.mCallingPackage, 0));
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("IntentReader", "Could not retrieve label for calling application", localNameNotFoundException);
    }
    return null;
  }
  
  @Nullable
  public String getCallingPackage()
  {
    return this.mCallingPackage;
  }
  
  @Nullable
  public String[] getEmailBcc()
  {
    return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
  }
  
  @Nullable
  public String[] getEmailCc()
  {
    return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
  }
  
  @Nullable
  public String[] getEmailTo()
  {
    return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
  }
  
  @Nullable
  public String getHtmlText()
  {
    Object localObject = this.mIntent.getStringExtra("android.intent.extra.HTML_TEXT");
    if (localObject == null)
    {
      CharSequence localCharSequence = getText();
      if ((localCharSequence instanceof Spanned)) {
        return Html.toHtml((Spanned)localCharSequence);
      }
      if (localCharSequence != null)
      {
        if (Build.VERSION.SDK_INT >= 16) {
          return Html.escapeHtml(localCharSequence);
        }
        localObject = new StringBuilder();
        withinStyle((StringBuilder)localObject, localCharSequence, 0, localCharSequence.length());
        return ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  @Nullable
  public Uri getStream()
  {
    return (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
  }
  
  @Nullable
  public Uri getStream(int paramInt)
  {
    if ((this.mStreams == null) && (isMultipleShare())) {
      this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
    }
    if (this.mStreams != null) {
      return (Uri)this.mStreams.get(paramInt);
    }
    if (paramInt == 0) {
      return (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
    }
    throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() + " index requested: " + paramInt);
  }
  
  public int getStreamCount()
  {
    if ((this.mStreams == null) && (isMultipleShare())) {
      this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
    }
    if (this.mStreams != null) {
      return this.mStreams.size();
    }
    if (this.mIntent.hasExtra("android.intent.extra.STREAM")) {
      return 1;
    }
    return 0;
  }
  
  @Nullable
  public String getSubject()
  {
    return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
  }
  
  @Nullable
  public CharSequence getText()
  {
    return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
  }
  
  @Nullable
  public String getType()
  {
    return this.mIntent.getType();
  }
  
  public boolean isMultipleShare()
  {
    return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
  }
  
  public boolean isShareIntent()
  {
    String str = this.mIntent.getAction();
    return ("android.intent.action.SEND".equals(str)) || ("android.intent.action.SEND_MULTIPLE".equals(str));
  }
  
  public boolean isSingleShare()
  {
    return "android.intent.action.SEND".equals(this.mIntent.getAction());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.app.ShareCompat.IntentReader
 * JD-Core Version:    0.7.0.1
 */