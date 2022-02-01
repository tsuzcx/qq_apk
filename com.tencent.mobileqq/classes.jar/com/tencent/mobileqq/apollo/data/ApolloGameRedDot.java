package com.tencent.mobileqq.apollo.data;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;

public class ApolloGameRedDot
  extends Entity
  implements Comparable<ApolloGameRedDot>
{
  public static final int REDDOT_ID_GAME_ACTIVITY = 1001;
  public static final int REDDOT_ID_GAME_CENTER = 1000;
  public static final int REDDOT_ID_GAME_CLICK_DISSMISS = 2000;
  public static final int REDDOT_ID_GAME_TOOL = 1002;
  public static final int REDDOT_ID_HOTCHAT = 1003;
  public static final int REDDOT_ID_UPDATE = 1005;
  private static final String TAG = "ApolloGameRedDot";
  public String mActId;
  public int mDotId;
  public int mEndTime;
  public int mGameId;
  public boolean mIsShow;
  public boolean mIsShowForFolder;
  public int mPriority;
  public int mSpRegion;
  public int mStartTime;
  public String mTipsWording;
  public String mUrl;
  
  public static boolean isValidReddotId(int paramInt)
  {
    if ((paramInt == 1002) || (paramInt == 1001) || (paramInt == 1000) || (paramInt == 2000) || (paramInt == 1005))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameRedDot", 2, "apolloGameReddot isValidReddotId:" + paramInt);
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameRedDot", 2, "apolloGameReddot isValidReddotId:false," + paramInt);
    }
    return false;
  }
  
  public int compareTo(@NonNull ApolloGameRedDot paramApolloGameRedDot)
  {
    int i = 1;
    if ((paramApolloGameRedDot != null) && (isTimeValid()) && (paramApolloGameRedDot.isTimeValid()))
    {
      if (((this.mIsShow) && (paramApolloGameRedDot.mIsShow)) || ((!this.mIsShow) && (!paramApolloGameRedDot.mIsShow)))
      {
        j = paramApolloGameRedDot.mPriority - this.mPriority;
        i = j;
        if (j == 0)
        {
          j = paramApolloGameRedDot.mStartTime - this.mStartTime;
          i = j;
          if (j == 0)
          {
            i = j;
            if (!TextUtils.isEmpty(this.mActId))
            {
              i = j;
              if (TextUtils.isEmpty(paramApolloGameRedDot.mActId)) {}
            }
          }
        }
      }
      else
      {
        while ((this.mIsShow) && (!paramApolloGameRedDot.mIsShow)) {
          try
          {
            i = Integer.parseInt(this.mActId);
            int k = Integer.parseInt(paramApolloGameRedDot.mActId);
            i -= k;
            return i;
          }
          catch (Throwable localThrowable)
          {
            int j;
            QLog.e("ApolloGameRedDot", 1, localThrowable, new Object[] { this.mActId, paramApolloGameRedDot, this.mActId });
            return j;
          }
        }
        return -1;
      }
      return i;
    }
    return 0;
  }
  
  public boolean isTimeValid()
  {
    long l = System.currentTimeMillis() / 1000L;
    return (l >= this.mStartTime) && (this.mEndTime > l);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mGameId:").append(this.mGameId).append(",mDotId:").append(this.mDotId).append(",mStartTime:").append(this.mStartTime).append(",mEndTime:").append(this.mEndTime).append(",mTipsWording:").append(this.mTipsWording);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.data.ApolloGameRedDot
 * JD-Core Version:    0.7.0.1
 */