package com.google.android.exoplayer2.source.chunk;

import android.util.Log;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException;

public final class ChunkedTrackBlacklistUtil
{
  public static final long DEFAULT_TRACK_BLACKLIST_MS = 60000L;
  private static final String TAG = "ChunkedTrackBlacklist";
  
  public static boolean maybeBlacklistTrack(TrackSelection paramTrackSelection, int paramInt, Exception paramException)
  {
    return maybeBlacklistTrack(paramTrackSelection, paramInt, paramException, 60000L);
  }
  
  public static boolean maybeBlacklistTrack(TrackSelection paramTrackSelection, int paramInt, Exception paramException, long paramLong)
  {
    if (shouldBlacklist(paramException))
    {
      boolean bool = paramTrackSelection.blacklist(paramInt, paramLong);
      int i = ((HttpDataSource.InvalidResponseCodeException)paramException).responseCode;
      if (bool)
      {
        paramException = new StringBuilder();
        paramException.append("Blacklisted: duration=");
        paramException.append(paramLong);
        paramException.append(", responseCode=");
        paramException.append(i);
        paramException.append(", format=");
        paramException.append(paramTrackSelection.getFormat(paramInt));
        Log.w("ChunkedTrackBlacklist", paramException.toString());
        return bool;
      }
      paramException = new StringBuilder();
      paramException.append("Blacklisting failed (cannot blacklist last enabled track): responseCode=");
      paramException.append(i);
      paramException.append(", format=");
      paramException.append(paramTrackSelection.getFormat(paramInt));
      Log.w("ChunkedTrackBlacklist", paramException.toString());
      return bool;
    }
    return false;
  }
  
  public static boolean shouldBlacklist(Exception paramException)
  {
    boolean bool3 = paramException instanceof HttpDataSource.InvalidResponseCodeException;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      int i = ((HttpDataSource.InvalidResponseCodeException)paramException).responseCode;
      if (i != 404)
      {
        bool1 = bool2;
        if (i != 410) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil
 * JD-Core Version:    0.7.0.1
 */