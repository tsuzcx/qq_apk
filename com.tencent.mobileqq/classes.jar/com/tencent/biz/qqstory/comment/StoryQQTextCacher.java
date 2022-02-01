package com.tencent.biz.qqstory.comment;

import android.support.v4.util.LruCache;
import com.tencent.biz.qqstory.database.CommentEntry;
import java.util.HashMap;

public class StoryQQTextCacher
{
  private static LruCache<String, CharSequence> b;
  private static StoryQQTextCacher c;
  private static HashMap<String, Integer> d;
  public String a = "";
  
  public static StoryQQTextCacher a()
  {
    if (c == null)
    {
      c = new StoryQQTextCacher();
      b = new LruCache(150);
      d = new HashMap();
    }
    return c;
  }
  
  public static void b()
  {
    LruCache localLruCache = b;
    if (localLruCache != null) {
      localLruCache.evictAll();
    }
  }
  
  public CharSequence a(String paramString)
  {
    return (CharSequence)b.get(paramString);
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    if (paramCommentEntry == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramCommentEntry.feedId);
    localStringBuilder.append(paramCommentEntry.replyTime);
    paramCommentEntry = localStringBuilder.toString();
    if (d.get(paramCommentEntry) == null)
    {
      d.put(paramCommentEntry, Integer.valueOf(1));
      return;
    }
    int i = ((Integer)d.get(paramCommentEntry)).intValue();
    d.put(paramCommentEntry, Integer.valueOf(i + 1));
  }
  
  public void a(String paramString, CharSequence paramCharSequence)
  {
    if (a(paramString) == null) {
      b.put(paramString, paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.StoryQQTextCacher
 * JD-Core Version:    0.7.0.1
 */