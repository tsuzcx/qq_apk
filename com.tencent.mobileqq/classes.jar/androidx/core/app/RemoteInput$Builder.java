package androidx.core.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;

public final class RemoteInput$Builder
{
  private boolean mAllowFreeFormTextInput = true;
  private final Set<String> mAllowedDataTypes = new HashSet();
  private CharSequence[] mChoices;
  private int mEditChoicesBeforeSending = 0;
  private final Bundle mExtras = new Bundle();
  private CharSequence mLabel;
  private final String mResultKey;
  
  public RemoteInput$Builder(@NonNull String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Result key can't be null");
    }
    this.mResultKey = paramString;
  }
  
  @NonNull
  public Builder addExtras(@NonNull Bundle paramBundle)
  {
    if (paramBundle != null) {
      this.mExtras.putAll(paramBundle);
    }
    return this;
  }
  
  @NonNull
  public RemoteInput build()
  {
    return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormTextInput, this.mEditChoicesBeforeSending, this.mExtras, this.mAllowedDataTypes);
  }
  
  @NonNull
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  @NonNull
  public Builder setAllowDataType(@NonNull String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mAllowedDataTypes.add(paramString);
      return this;
    }
    this.mAllowedDataTypes.remove(paramString);
    return this;
  }
  
  @NonNull
  public Builder setAllowFreeFormInput(boolean paramBoolean)
  {
    this.mAllowFreeFormTextInput = paramBoolean;
    return this;
  }
  
  @NonNull
  public Builder setChoices(@Nullable CharSequence[] paramArrayOfCharSequence)
  {
    this.mChoices = paramArrayOfCharSequence;
    return this;
  }
  
  @NonNull
  public Builder setEditChoicesBeforeSending(int paramInt)
  {
    this.mEditChoicesBeforeSending = paramInt;
    return this;
  }
  
  @NonNull
  public Builder setLabel(@Nullable CharSequence paramCharSequence)
  {
    this.mLabel = paramCharSequence;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.app.RemoteInput.Builder
 * JD-Core Version:    0.7.0.1
 */