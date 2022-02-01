package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class InputConnectionCompat
{
  private static final String COMMIT_CONTENT_ACTION = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
  private static final String COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
  private static final String COMMIT_CONTENT_CONTENT_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
  private static final String COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
  private static final String COMMIT_CONTENT_DESCRIPTION_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
  private static final String COMMIT_CONTENT_FLAGS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
  private static final String COMMIT_CONTENT_FLAGS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
  private static final String COMMIT_CONTENT_INTEROP_ACTION = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
  private static final String COMMIT_CONTENT_LINK_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
  private static final String COMMIT_CONTENT_LINK_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
  private static final String COMMIT_CONTENT_OPTS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
  private static final String COMMIT_CONTENT_OPTS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
  private static final String COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
  private static final String COMMIT_CONTENT_RESULT_RECEIVER_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
  public static final int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;
  
  public static boolean commitContent(@NonNull InputConnection paramInputConnection, @NonNull EditorInfo paramEditorInfo, @NonNull InputContentInfoCompat paramInputContentInfoCompat, int paramInt, @Nullable Bundle paramBundle)
  {
    Object localObject = paramInputContentInfoCompat.getDescription();
    String[] arrayOfString = EditorInfoCompat.getContentMimeTypes(paramEditorInfo);
    int k = arrayOfString.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      if (((ClipDescription)localObject).hasMimeType(arrayOfString[i]))
      {
        i = 1;
        break label61;
      }
      i += 1;
    }
    i = 0;
    label61:
    if (i == 0) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 25) {
      return paramInputConnection.commitContent((InputContentInfo)paramInputContentInfoCompat.unwrap(), paramInt, paramBundle);
    }
    k = EditorInfoCompat.getProtocol(paramEditorInfo);
    if (k != 2)
    {
      i = j;
      if (k != 3)
      {
        i = j;
        if (k != 4) {
          return false;
        }
      }
    }
    else
    {
      i = 1;
    }
    localObject = new Bundle();
    if (i != 0) {
      paramEditorInfo = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    } else {
      paramEditorInfo = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    }
    ((Bundle)localObject).putParcelable(paramEditorInfo, paramInputContentInfoCompat.getContentUri());
    if (i != 0) {
      paramEditorInfo = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    } else {
      paramEditorInfo = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    }
    ((Bundle)localObject).putParcelable(paramEditorInfo, paramInputContentInfoCompat.getDescription());
    if (i != 0) {
      paramEditorInfo = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    } else {
      paramEditorInfo = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    }
    ((Bundle)localObject).putParcelable(paramEditorInfo, paramInputContentInfoCompat.getLinkUri());
    if (i != 0) {
      paramEditorInfo = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    } else {
      paramEditorInfo = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    }
    ((Bundle)localObject).putInt(paramEditorInfo, paramInt);
    if (i != 0) {
      paramEditorInfo = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    } else {
      paramEditorInfo = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    }
    ((Bundle)localObject).putParcelable(paramEditorInfo, paramBundle);
    if (i != 0) {
      paramEditorInfo = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    } else {
      paramEditorInfo = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    }
    return paramInputConnection.performPrivateCommand(paramEditorInfo, (Bundle)localObject);
  }
  
  @NonNull
  public static InputConnection createWrapper(@NonNull InputConnection paramInputConnection, @NonNull EditorInfo paramEditorInfo, @NonNull InputConnectionCompat.OnCommitContentListener paramOnCommitContentListener)
  {
    if (paramInputConnection != null)
    {
      if (paramEditorInfo != null)
      {
        if (paramOnCommitContentListener != null)
        {
          if (Build.VERSION.SDK_INT >= 25) {
            return new InputConnectionCompat.1(paramInputConnection, false, paramOnCommitContentListener);
          }
          if (EditorInfoCompat.getContentMimeTypes(paramEditorInfo).length == 0) {
            return paramInputConnection;
          }
          return new InputConnectionCompat.2(paramInputConnection, false, paramOnCommitContentListener);
        }
        throw new IllegalArgumentException("onCommitContentListener must be non-null");
      }
      throw new IllegalArgumentException("editorInfo must be non-null");
    }
    throw new IllegalArgumentException("inputConnection must be non-null");
  }
  
  static boolean handlePerformPrivateCommand(@Nullable String paramString, @NonNull Bundle paramBundle, @NonNull InputConnectionCompat.OnCommitContentListener paramOnCommitContentListener)
  {
    int j = 0;
    if (paramBundle == null) {
      return false;
    }
    int i;
    if (TextUtils.equals("androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", paramString))
    {
      i = 0;
    }
    else
    {
      if (!TextUtils.equals("android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", paramString)) {
        break label237;
      }
      i = 1;
    }
    if (i != 0) {
      paramString = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    }
    for (;;)
    {
      label237:
      try
      {
        ResultReceiver localResultReceiver = (ResultReceiver)paramBundle.getParcelable(paramString);
        if (i != 0)
        {
          paramString = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
          try
          {
            Uri localUri1 = (Uri)paramBundle.getParcelable(paramString);
            if (i == 0) {
              break label251;
            }
            paramString = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
            ClipDescription localClipDescription = (ClipDescription)paramBundle.getParcelable(paramString);
            if (i == 0) {
              break label257;
            }
            paramString = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
            Uri localUri2 = (Uri)paramBundle.getParcelable(paramString);
            if (i == 0) {
              break label263;
            }
            paramString = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
            int k = paramBundle.getInt(paramString);
            if (i == 0) {
              break label269;
            }
            paramString = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
            paramString = (Bundle)paramBundle.getParcelable(paramString);
            boolean bool;
            if ((localUri1 != null) && (localClipDescription != null)) {
              bool = paramOnCommitContentListener.onCommitContent(new InputContentInfoCompat(localUri1, localClipDescription, localUri2), k, paramString);
            } else {
              bool = false;
            }
            if (localResultReceiver != null)
            {
              i = j;
              if (bool) {
                i = 1;
              }
              localResultReceiver.send(i, null);
            }
            return bool;
          }
          finally
          {
            paramString = localResultReceiver;
          }
        }
      }
      finally
      {
        paramString = null;
        if (paramString != null) {
          paramString.send(0, null);
        }
      }
      paramString = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
      continue;
      label251:
      paramString = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
      continue;
      label257:
      paramString = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
      continue;
      label263:
      paramString = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
      continue;
      label269:
      paramString = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.inputmethod.InputConnectionCompat
 * JD-Core Version:    0.7.0.1
 */