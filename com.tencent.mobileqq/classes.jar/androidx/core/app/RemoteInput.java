package androidx.core.app;

import android.app.RemoteInput.Builder;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Landroid.net.Uri;>;
import java.util.Set;

public final class RemoteInput
{
  public static final int EDIT_CHOICES_BEFORE_SENDING_AUTO = 0;
  public static final int EDIT_CHOICES_BEFORE_SENDING_DISABLED = 1;
  public static final int EDIT_CHOICES_BEFORE_SENDING_ENABLED = 2;
  private static final String EXTRA_DATA_TYPE_RESULTS_DATA = "android.remoteinput.dataTypeResultsData";
  public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
  private static final String EXTRA_RESULTS_SOURCE = "android.remoteinput.resultsSource";
  public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
  public static final int SOURCE_CHOICE = 1;
  public static final int SOURCE_FREE_FORM_INPUT = 0;
  private static final String TAG = "RemoteInput";
  private final boolean mAllowFreeFormTextInput;
  private final Set<String> mAllowedDataTypes;
  private final CharSequence[] mChoices;
  private final int mEditChoicesBeforeSending;
  private final Bundle mExtras;
  private final CharSequence mLabel;
  private final String mResultKey;
  
  RemoteInput(String paramString, CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence, boolean paramBoolean, int paramInt, Bundle paramBundle, Set<String> paramSet)
  {
    this.mResultKey = paramString;
    this.mLabel = paramCharSequence;
    this.mChoices = paramArrayOfCharSequence;
    this.mAllowFreeFormTextInput = paramBoolean;
    this.mEditChoicesBeforeSending = paramInt;
    this.mExtras = paramBundle;
    this.mAllowedDataTypes = paramSet;
    if (getEditChoicesBeforeSending() == 2)
    {
      if (getAllowFreeFormInput()) {
        return;
      }
      throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
    }
  }
  
  public static void addDataResultToIntent(RemoteInput paramRemoteInput, Intent paramIntent, Map<String, Uri> paramMap)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      android.app.RemoteInput.addDataResultToIntent(fromCompat(paramRemoteInput), paramIntent, paramMap);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      Object localObject2 = getClipDataIntentFromIntent(paramIntent);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Intent();
      }
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        String str = (String)paramMap.getKey();
        Uri localUri = (Uri)paramMap.getValue();
        if (str != null)
        {
          localObject2 = ((Intent)localObject1).getBundleExtra(getExtraResultsKeyForData(str));
          paramMap = (Map<String, Uri>)localObject2;
          if (localObject2 == null) {
            paramMap = new Bundle();
          }
          paramMap.putString(paramRemoteInput.getResultKey(), localUri.toString());
          ((Intent)localObject1).putExtra(getExtraResultsKeyForData(str), paramMap);
        }
      }
      paramIntent.setClipData(ClipData.newIntent("android.remoteinput.results", (Intent)localObject1));
    }
  }
  
  public static void addResultsToIntent(RemoteInput[] paramArrayOfRemoteInput, Intent paramIntent, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      android.app.RemoteInput.addResultsToIntent(fromCompat(paramArrayOfRemoteInput), paramIntent, paramBundle);
      return;
    }
    int j = Build.VERSION.SDK_INT;
    int i = 0;
    Object localObject1;
    Object localObject2;
    if (j >= 20)
    {
      localObject1 = getResultsFromIntent(paramIntent);
      j = getResultsSource(paramIntent);
      if (localObject1 != null)
      {
        ((Bundle)localObject1).putAll(paramBundle);
        paramBundle = (Bundle)localObject1;
      }
      int k = paramArrayOfRemoteInput.length;
      i = 0;
      while (i < k)
      {
        localObject1 = paramArrayOfRemoteInput[i];
        localObject2 = getDataResultsFromIntent(paramIntent, ((RemoteInput)localObject1).getResultKey());
        android.app.RemoteInput.addResultsToIntent(fromCompat(new RemoteInput[] { localObject1 }), paramIntent, paramBundle);
        if (localObject2 != null) {
          addDataResultToIntent((RemoteInput)localObject1, paramIntent, (Map)localObject2);
        }
        i += 1;
      }
      setResultsSource(paramIntent, j);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      localObject2 = getClipDataIntentFromIntent(paramIntent);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Intent();
      }
      Object localObject3 = ((Intent)localObject1).getBundleExtra("android.remoteinput.resultsData");
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new Bundle();
      }
      j = paramArrayOfRemoteInput.length;
      while (i < j)
      {
        localObject3 = paramArrayOfRemoteInput[i];
        Object localObject4 = paramBundle.get(((RemoteInput)localObject3).getResultKey());
        if ((localObject4 instanceof CharSequence)) {
          ((Bundle)localObject2).putCharSequence(((RemoteInput)localObject3).getResultKey(), (CharSequence)localObject4);
        }
        i += 1;
      }
      ((Intent)localObject1).putExtra("android.remoteinput.resultsData", (Bundle)localObject2);
      paramIntent.setClipData(ClipData.newIntent("android.remoteinput.results", (Intent)localObject1));
    }
  }
  
  @RequiresApi(20)
  static android.app.RemoteInput fromCompat(RemoteInput paramRemoteInput)
  {
    RemoteInput.Builder localBuilder = new RemoteInput.Builder(paramRemoteInput.getResultKey()).setLabel(paramRemoteInput.getLabel()).setChoices(paramRemoteInput.getChoices()).setAllowFreeFormInput(paramRemoteInput.getAllowFreeFormInput()).addExtras(paramRemoteInput.getExtras());
    if (Build.VERSION.SDK_INT >= 29) {
      localBuilder.setEditChoicesBeforeSending(paramRemoteInput.getEditChoicesBeforeSending());
    }
    return localBuilder.build();
  }
  
  @RequiresApi(20)
  static android.app.RemoteInput[] fromCompat(RemoteInput[] paramArrayOfRemoteInput)
  {
    if (paramArrayOfRemoteInput == null) {
      return null;
    }
    android.app.RemoteInput[] arrayOfRemoteInput = new android.app.RemoteInput[paramArrayOfRemoteInput.length];
    int i = 0;
    while (i < paramArrayOfRemoteInput.length)
    {
      arrayOfRemoteInput[i] = fromCompat(paramArrayOfRemoteInput[i]);
      i += 1;
    }
    return arrayOfRemoteInput;
  }
  
  @RequiresApi(16)
  private static Intent getClipDataIntentFromIntent(Intent paramIntent)
  {
    paramIntent = paramIntent.getClipData();
    if (paramIntent == null) {
      return null;
    }
    ClipDescription localClipDescription = paramIntent.getDescription();
    if (!localClipDescription.hasMimeType("text/vnd.android.intent")) {
      return null;
    }
    if (!localClipDescription.getLabel().toString().contentEquals("android.remoteinput.results")) {
      return null;
    }
    return paramIntent.getItemAt(0).getIntent();
  }
  
  public static Map<String, Uri> getDataResultsFromIntent(Intent paramIntent, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return android.app.RemoteInput.getDataResultsFromIntent(paramIntent, paramString);
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramIntent = getClipDataIntentFromIntent(paramIntent);
      if (paramIntent == null) {
        return null;
      }
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramIntent.getExtras().keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (str2.startsWith("android.remoteinput.dataTypeResultsData"))
        {
          String str1 = str2.substring(39);
          if (!str1.isEmpty())
          {
            str2 = paramIntent.getBundleExtra(str2).getString(paramString);
            if ((str2 != null) && (!str2.isEmpty())) {
              localHashMap.put(str1, Uri.parse(str2));
            }
          }
        }
      }
      paramIntent = localHashMap;
      if (localHashMap.isEmpty()) {
        paramIntent = null;
      }
      return paramIntent;
    }
    return null;
  }
  
  private static String getExtraResultsKeyForData(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("android.remoteinput.dataTypeResultsData");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static Bundle getResultsFromIntent(Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return android.app.RemoteInput.getResultsFromIntent(paramIntent);
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramIntent = getClipDataIntentFromIntent(paramIntent);
      if (paramIntent == null) {
        return null;
      }
      return (Bundle)paramIntent.getExtras().getParcelable("android.remoteinput.resultsData");
    }
    return null;
  }
  
  public static int getResultsSource(@NonNull Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return android.app.RemoteInput.getResultsSource(paramIntent);
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramIntent = getClipDataIntentFromIntent(paramIntent);
      if (paramIntent == null) {
        return 0;
      }
      return paramIntent.getExtras().getInt("android.remoteinput.resultsSource", 0);
    }
    return 0;
  }
  
  public static void setResultsSource(@NonNull Intent paramIntent, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      android.app.RemoteInput.setResultsSource(paramIntent, paramInt);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      Intent localIntent2 = getClipDataIntentFromIntent(paramIntent);
      Intent localIntent1 = localIntent2;
      if (localIntent2 == null) {
        localIntent1 = new Intent();
      }
      localIntent1.putExtra("android.remoteinput.resultsSource", paramInt);
      paramIntent.setClipData(ClipData.newIntent("android.remoteinput.results", localIntent1));
    }
  }
  
  public boolean getAllowFreeFormInput()
  {
    return this.mAllowFreeFormTextInput;
  }
  
  public Set<String> getAllowedDataTypes()
  {
    return this.mAllowedDataTypes;
  }
  
  public CharSequence[] getChoices()
  {
    return this.mChoices;
  }
  
  public int getEditChoicesBeforeSending()
  {
    return this.mEditChoicesBeforeSending;
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public CharSequence getLabel()
  {
    return this.mLabel;
  }
  
  public String getResultKey()
  {
    return this.mResultKey;
  }
  
  public boolean isDataOnly()
  {
    return (!getAllowFreeFormInput()) && ((getChoices() == null) || (getChoices().length == 0)) && (getAllowedDataTypes() != null) && (!getAllowedDataTypes().isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.RemoteInput
 * JD-Core Version:    0.7.0.1
 */