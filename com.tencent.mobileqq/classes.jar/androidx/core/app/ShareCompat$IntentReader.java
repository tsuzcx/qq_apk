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
    while (paramInt1 < paramInt2)
    {
      char c = paramCharSequence.charAt(paramInt1);
      if (c == '<')
      {
        paramStringBuilder.append("&lt;");
      }
      else if (c == '>')
      {
        paramStringBuilder.append("&gt;");
      }
      else if (c == '&')
      {
        paramStringBuilder.append("&amp;");
      }
      else if ((c <= '~') && (c >= ' '))
      {
        if (c == ' ')
        {
          for (;;)
          {
            int i = paramInt1 + 1;
            if ((i >= paramInt2) || (paramCharSequence.charAt(i) != ' ')) {
              break;
            }
            paramStringBuilder.append("&nbsp;");
            paramInt1 = i;
          }
          paramStringBuilder.append(' ');
        }
        else
        {
          paramStringBuilder.append(c);
        }
      }
      else
      {
        paramStringBuilder.append("&#");
        paramStringBuilder.append(c);
        paramStringBuilder.append(";");
      }
      paramInt1 += 1;
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
    String str = this.mIntent.getStringExtra("android.intent.extra.HTML_TEXT");
    Object localObject = str;
    if (str == null)
    {
      CharSequence localCharSequence = getText();
      if ((localCharSequence instanceof Spanned)) {
        return Html.toHtml((Spanned)localCharSequence);
      }
      localObject = str;
      if (localCharSequence != null)
      {
        if (Build.VERSION.SDK_INT >= 16) {
          return Html.escapeHtml(localCharSequence);
        }
        localObject = new StringBuilder();
        withinStyle((StringBuilder)localObject, localCharSequence, 0, localCharSequence.length());
        localObject = ((StringBuilder)localObject).toString();
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
    Object localObject = this.mStreams;
    if (localObject != null) {
      return (Uri)((ArrayList)localObject).get(paramInt);
    }
    if (paramInt == 0) {
      return (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Stream items available: ");
    ((StringBuilder)localObject).append(getStreamCount());
    ((StringBuilder)localObject).append(" index requested: ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
  }
  
  public int getStreamCount()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.ShareCompat.IntentReader
 * JD-Core Version:    0.7.0.1
 */