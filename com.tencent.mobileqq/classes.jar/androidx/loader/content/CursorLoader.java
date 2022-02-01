package androidx.loader.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.CancellationSignal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class CursorLoader
  extends AsyncTaskLoader<Cursor>
{
  CancellationSignal mCancellationSignal;
  Cursor mCursor;
  final Loader<Cursor>.ForceLoadContentObserver mObserver = new Loader.ForceLoadContentObserver(this);
  String[] mProjection;
  String mSelection;
  String[] mSelectionArgs;
  String mSortOrder;
  Uri mUri;
  
  public CursorLoader(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public CursorLoader(@NonNull Context paramContext, @NonNull Uri paramUri, @Nullable String[] paramArrayOfString1, @Nullable String paramString1, @Nullable String[] paramArrayOfString2, @Nullable String paramString2)
  {
    super(paramContext);
    this.mUri = paramUri;
    this.mProjection = paramArrayOfString1;
    this.mSelection = paramString1;
    this.mSelectionArgs = paramArrayOfString2;
    this.mSortOrder = paramString2;
  }
  
  public void cancelLoadInBackground()
  {
    super.cancelLoadInBackground();
    try
    {
      if (this.mCancellationSignal != null) {
        this.mCancellationSignal.cancel();
      }
      return;
    }
    finally {}
  }
  
  public void deliverResult(Cursor paramCursor)
  {
    if (isReset()) {
      if (paramCursor != null) {
        paramCursor.close();
      }
    }
    Cursor localCursor;
    do
    {
      return;
      localCursor = this.mCursor;
      this.mCursor = paramCursor;
      if (isStarted()) {
        super.deliverResult(paramCursor);
      }
    } while ((localCursor == null) || (localCursor == paramCursor) || (localCursor.isClosed()));
    localCursor.close();
  }
  
  @Deprecated
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mUri=");
    paramPrintWriter.println(this.mUri);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mProjection=");
    paramPrintWriter.println(Arrays.toString(this.mProjection));
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSelection=");
    paramPrintWriter.println(this.mSelection);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSelectionArgs=");
    paramPrintWriter.println(Arrays.toString(this.mSelectionArgs));
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSortOrder=");
    paramPrintWriter.println(this.mSortOrder);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mCursor=");
    paramPrintWriter.println(this.mCursor);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mContentChanged=");
    paramPrintWriter.println(this.mContentChanged);
  }
  
  @Nullable
  public String[] getProjection()
  {
    return this.mProjection;
  }
  
  @Nullable
  public String getSelection()
  {
    return this.mSelection;
  }
  
  @Nullable
  public String[] getSelectionArgs()
  {
    return this.mSelectionArgs;
  }
  
  @Nullable
  public String getSortOrder()
  {
    return this.mSortOrder;
  }
  
  @NonNull
  public Uri getUri()
  {
    return this.mUri;
  }
  
  /* Error */
  public Cursor loadInBackground()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 141	androidx/loader/content/CursorLoader:isLoadInBackgroundCanceled	()Z
    //   6: ifeq +16 -> 22
    //   9: new 143	androidx/core/os/OperationCanceledException
    //   12: dup
    //   13: invokespecial 145	androidx/core/os/OperationCanceledException:<init>	()V
    //   16: athrow
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: athrow
    //   22: aload_0
    //   23: new 54	androidx/core/os/CancellationSignal
    //   26: dup
    //   27: invokespecial 146	androidx/core/os/CancellationSignal:<init>	()V
    //   30: putfield 52	androidx/loader/content/CursorLoader:mCancellationSignal	Landroidx/core/os/CancellationSignal;
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_0
    //   36: invokevirtual 150	androidx/loader/content/CursorLoader:getContext	()Landroid/content/Context;
    //   39: invokevirtual 156	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   42: aload_0
    //   43: getfield 38	androidx/loader/content/CursorLoader:mUri	Landroid/net/Uri;
    //   46: aload_0
    //   47: getfield 40	androidx/loader/content/CursorLoader:mProjection	[Ljava/lang/String;
    //   50: aload_0
    //   51: getfield 42	androidx/loader/content/CursorLoader:mSelection	Ljava/lang/String;
    //   54: aload_0
    //   55: getfield 44	androidx/loader/content/CursorLoader:mSelectionArgs	[Ljava/lang/String;
    //   58: aload_0
    //   59: getfield 46	androidx/loader/content/CursorLoader:mSortOrder	Ljava/lang/String;
    //   62: aload_0
    //   63: getfield 52	androidx/loader/content/CursorLoader:mCancellationSignal	Landroidx/core/os/CancellationSignal;
    //   66: invokestatic 162	androidx/core/content/ContentResolverCompat:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroidx/core/os/CancellationSignal;)Landroid/database/Cursor;
    //   69: astore_1
    //   70: aload_1
    //   71: ifnull +20 -> 91
    //   74: aload_1
    //   75: invokeinterface 166 1 0
    //   80: pop
    //   81: aload_1
    //   82: aload_0
    //   83: getfield 32	androidx/loader/content/CursorLoader:mObserver	Landroidx/loader/content/Loader$ForceLoadContentObserver;
    //   86: invokeinterface 170 2 0
    //   91: aload_0
    //   92: monitorenter
    //   93: aload_0
    //   94: aconst_null
    //   95: putfield 52	androidx/loader/content/CursorLoader:mCancellationSignal	Landroidx/core/os/CancellationSignal;
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: areturn
    //   102: astore_2
    //   103: aload_1
    //   104: invokeinterface 68 1 0
    //   109: aload_2
    //   110: athrow
    //   111: astore_1
    //   112: aload_0
    //   113: monitorenter
    //   114: aload_0
    //   115: aconst_null
    //   116: putfield 52	androidx/loader/content/CursorLoader:mCancellationSignal	Landroidx/core/os/CancellationSignal;
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	CursorLoader
    //   17	4	1	localObject1	Object
    //   69	35	1	localCursor	Cursor
    //   111	11	1	localObject2	Object
    //   123	4	1	localObject3	Object
    //   128	4	1	localObject4	Object
    //   102	8	2	localRuntimeException	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   2	17	17	finally
    //   18	20	17	finally
    //   22	35	17	finally
    //   74	91	102	java/lang/RuntimeException
    //   35	70	111	finally
    //   74	91	111	finally
    //   103	111	111	finally
    //   93	100	123	finally
    //   124	126	123	finally
    //   114	121	128	finally
    //   129	131	128	finally
  }
  
  public void onCanceled(Cursor paramCursor)
  {
    if ((paramCursor != null) && (!paramCursor.isClosed())) {
      paramCursor.close();
    }
  }
  
  protected void onReset()
  {
    super.onReset();
    onStopLoading();
    if ((this.mCursor != null) && (!this.mCursor.isClosed())) {
      this.mCursor.close();
    }
    this.mCursor = null;
  }
  
  protected void onStartLoading()
  {
    if (this.mCursor != null) {
      deliverResult(this.mCursor);
    }
    if ((takeContentChanged()) || (this.mCursor == null)) {
      forceLoad();
    }
  }
  
  protected void onStopLoading()
  {
    cancelLoad();
  }
  
  public void setProjection(@Nullable String[] paramArrayOfString)
  {
    this.mProjection = paramArrayOfString;
  }
  
  public void setSelection(@Nullable String paramString)
  {
    this.mSelection = paramString;
  }
  
  public void setSelectionArgs(@Nullable String[] paramArrayOfString)
  {
    this.mSelectionArgs = paramArrayOfString;
  }
  
  public void setSortOrder(@Nullable String paramString)
  {
    this.mSortOrder = paramString;
  }
  
  public void setUri(@NonNull Uri paramUri)
  {
    this.mUri = paramUri;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.loader.content.CursorLoader
 * JD-Core Version:    0.7.0.1
 */