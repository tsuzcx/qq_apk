package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.Html;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.util.Preconditions;
import java.util.ArrayList;

public class ShareCompat$IntentBuilder
{
  @Nullable
  private ArrayList<String> mBccAddresses;
  @Nullable
  private ArrayList<String> mCcAddresses;
  @Nullable
  private CharSequence mChooserTitle;
  @NonNull
  private final Context mContext;
  @NonNull
  private final Intent mIntent;
  @Nullable
  private ArrayList<Uri> mStreams;
  @Nullable
  private ArrayList<String> mToAddresses;
  
  private ShareCompat$IntentBuilder(@NonNull Context paramContext, @Nullable ComponentName paramComponentName)
  {
    this.mContext = ((Context)Preconditions.checkNotNull(paramContext));
    this.mIntent = new Intent().setAction("android.intent.action.SEND");
    this.mIntent.putExtra("androidx.core.app.EXTRA_CALLING_PACKAGE", paramContext.getPackageName());
    this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", paramContext.getPackageName());
    this.mIntent.putExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY", paramComponentName);
    this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", paramComponentName);
    this.mIntent.addFlags(524288);
  }
  
  private void combineArrayExtra(String paramString, ArrayList<String> paramArrayList)
  {
    String[] arrayOfString1 = this.mIntent.getStringArrayExtra(paramString);
    if (arrayOfString1 != null) {}
    for (int i = arrayOfString1.length;; i = 0)
    {
      String[] arrayOfString2 = new String[paramArrayList.size() + i];
      paramArrayList.toArray(arrayOfString2);
      if (arrayOfString1 != null) {
        System.arraycopy(arrayOfString1, 0, arrayOfString2, paramArrayList.size(), i);
      }
      this.mIntent.putExtra(paramString, arrayOfString2);
      return;
    }
  }
  
  private void combineArrayExtra(@Nullable String paramString, @NonNull String[] paramArrayOfString)
  {
    Intent localIntent = getIntent();
    String[] arrayOfString1 = localIntent.getStringArrayExtra(paramString);
    if (arrayOfString1 != null) {}
    for (int i = arrayOfString1.length;; i = 0)
    {
      String[] arrayOfString2 = new String[paramArrayOfString.length + i];
      if (arrayOfString1 != null) {
        System.arraycopy(arrayOfString1, 0, arrayOfString2, 0, i);
      }
      System.arraycopy(paramArrayOfString, 0, arrayOfString2, i, paramArrayOfString.length);
      localIntent.putExtra(paramString, arrayOfString2);
      return;
    }
  }
  
  @NonNull
  public static IntentBuilder from(@NonNull Activity paramActivity)
  {
    return from((Context)Preconditions.checkNotNull(paramActivity), paramActivity.getComponentName());
  }
  
  @NonNull
  private static IntentBuilder from(@NonNull Context paramContext, @Nullable ComponentName paramComponentName)
  {
    return new IntentBuilder(paramContext, paramComponentName);
  }
  
  @NonNull
  public IntentBuilder addEmailBcc(@NonNull String paramString)
  {
    if (this.mBccAddresses == null) {
      this.mBccAddresses = new ArrayList();
    }
    this.mBccAddresses.add(paramString);
    return this;
  }
  
  @NonNull
  public IntentBuilder addEmailBcc(@NonNull String[] paramArrayOfString)
  {
    combineArrayExtra("android.intent.extra.BCC", paramArrayOfString);
    return this;
  }
  
  @NonNull
  public IntentBuilder addEmailCc(@NonNull String paramString)
  {
    if (this.mCcAddresses == null) {
      this.mCcAddresses = new ArrayList();
    }
    this.mCcAddresses.add(paramString);
    return this;
  }
  
  @NonNull
  public IntentBuilder addEmailCc(@NonNull String[] paramArrayOfString)
  {
    combineArrayExtra("android.intent.extra.CC", paramArrayOfString);
    return this;
  }
  
  @NonNull
  public IntentBuilder addEmailTo(@NonNull String paramString)
  {
    if (this.mToAddresses == null) {
      this.mToAddresses = new ArrayList();
    }
    this.mToAddresses.add(paramString);
    return this;
  }
  
  @NonNull
  public IntentBuilder addEmailTo(@NonNull String[] paramArrayOfString)
  {
    combineArrayExtra("android.intent.extra.EMAIL", paramArrayOfString);
    return this;
  }
  
  @NonNull
  public IntentBuilder addStream(@NonNull Uri paramUri)
  {
    Uri localUri = (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
    if ((this.mStreams == null) && (localUri == null)) {
      return setStream(paramUri);
    }
    if (this.mStreams == null) {
      this.mStreams = new ArrayList();
    }
    if (localUri != null)
    {
      this.mIntent.removeExtra("android.intent.extra.STREAM");
      this.mStreams.add(localUri);
    }
    this.mStreams.add(paramUri);
    return this;
  }
  
  @NonNull
  public Intent createChooserIntent()
  {
    return Intent.createChooser(getIntent(), this.mChooserTitle);
  }
  
  @NonNull
  Context getContext()
  {
    return this.mContext;
  }
  
  @NonNull
  public Intent getIntent()
  {
    if (this.mToAddresses != null)
    {
      combineArrayExtra("android.intent.extra.EMAIL", this.mToAddresses);
      this.mToAddresses = null;
    }
    if (this.mCcAddresses != null)
    {
      combineArrayExtra("android.intent.extra.CC", this.mCcAddresses);
      this.mCcAddresses = null;
    }
    if (this.mBccAddresses != null)
    {
      combineArrayExtra("android.intent.extra.BCC", this.mBccAddresses);
      this.mBccAddresses = null;
    }
    int i;
    if ((this.mStreams != null) && (this.mStreams.size() > 1))
    {
      i = 1;
      boolean bool = "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
      if ((i == 0) && (bool))
      {
        this.mIntent.setAction("android.intent.action.SEND");
        if ((this.mStreams == null) || (this.mStreams.isEmpty())) {
          break label219;
        }
        this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable)this.mStreams.get(0));
        label155:
        this.mStreams = null;
      }
      if ((i != 0) && (!bool))
      {
        this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
        if ((this.mStreams == null) || (this.mStreams.isEmpty())) {
          break label231;
        }
        this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
      }
    }
    for (;;)
    {
      return this.mIntent;
      i = 0;
      break;
      label219:
      this.mIntent.removeExtra("android.intent.extra.STREAM");
      break label155;
      label231:
      this.mIntent.removeExtra("android.intent.extra.STREAM");
    }
  }
  
  @NonNull
  public IntentBuilder setChooserTitle(@StringRes int paramInt)
  {
    return setChooserTitle(this.mContext.getText(paramInt));
  }
  
  @NonNull
  public IntentBuilder setChooserTitle(@Nullable CharSequence paramCharSequence)
  {
    this.mChooserTitle = paramCharSequence;
    return this;
  }
  
  @NonNull
  public IntentBuilder setEmailBcc(@Nullable String[] paramArrayOfString)
  {
    this.mIntent.putExtra("android.intent.extra.BCC", paramArrayOfString);
    return this;
  }
  
  @NonNull
  public IntentBuilder setEmailCc(@Nullable String[] paramArrayOfString)
  {
    this.mIntent.putExtra("android.intent.extra.CC", paramArrayOfString);
    return this;
  }
  
  @NonNull
  public IntentBuilder setEmailTo(@Nullable String[] paramArrayOfString)
  {
    if (this.mToAddresses != null) {
      this.mToAddresses = null;
    }
    this.mIntent.putExtra("android.intent.extra.EMAIL", paramArrayOfString);
    return this;
  }
  
  @NonNull
  public IntentBuilder setHtmlText(@Nullable String paramString)
  {
    this.mIntent.putExtra("android.intent.extra.HTML_TEXT", paramString);
    if (!this.mIntent.hasExtra("android.intent.extra.TEXT")) {
      setText(Html.fromHtml(paramString));
    }
    return this;
  }
  
  @NonNull
  public IntentBuilder setStream(@Nullable Uri paramUri)
  {
    if (!"android.intent.action.SEND".equals(this.mIntent.getAction())) {
      this.mIntent.setAction("android.intent.action.SEND");
    }
    this.mStreams = null;
    this.mIntent.putExtra("android.intent.extra.STREAM", paramUri);
    return this;
  }
  
  @NonNull
  public IntentBuilder setSubject(@Nullable String paramString)
  {
    this.mIntent.putExtra("android.intent.extra.SUBJECT", paramString);
    return this;
  }
  
  @NonNull
  public IntentBuilder setText(@Nullable CharSequence paramCharSequence)
  {
    this.mIntent.putExtra("android.intent.extra.TEXT", paramCharSequence);
    return this;
  }
  
  @NonNull
  public IntentBuilder setType(@Nullable String paramString)
  {
    this.mIntent.setType(paramString);
    return this;
  }
  
  public void startChooser()
  {
    this.mContext.startActivity(createChooserIntent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.app.ShareCompat.IntentBuilder
 * JD-Core Version:    0.7.0.1
 */