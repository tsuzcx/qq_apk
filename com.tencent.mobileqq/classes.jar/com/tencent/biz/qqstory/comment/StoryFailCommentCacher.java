package com.tencent.biz.qqstory.comment;

import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class StoryFailCommentCacher
{
  private static HashSet<String> a;
  private static HashMap<String, Integer> b;
  private static StoryFailCommentCacher c;
  
  public static StoryFailCommentCacher a()
  {
    if (c == null)
    {
      c = new StoryFailCommentCacher();
      a = new HashSet();
      b = new HashMap();
      Iterator localIterator = ((CommentManager)SuperManager.a(17)).c().iterator();
      while (localIterator.hasNext())
      {
        CommentEntry localCommentEntry = (CommentEntry)localIterator.next();
        if (!a.contains(localCommentEntry.feedId))
        {
          a.add(localCommentEntry.feedId);
          b.put(localCommentEntry.feedId, Integer.valueOf(localCommentEntry.commentId));
        }
      }
    }
    return c;
  }
  
  public int a(String paramString)
  {
    paramString = (Integer)b.get(paramString);
    if (paramString == null) {
      return -1;
    }
    return paramString.intValue();
  }
  
  public void b()
  {
    a.clear();
    b.clear();
    Iterator localIterator = ((CommentManager)SuperManager.a(17)).c().iterator();
    while (localIterator.hasNext())
    {
      CommentEntry localCommentEntry = (CommentEntry)localIterator.next();
      if (!a.contains(localCommentEntry.feedId))
      {
        a.add(localCommentEntry.feedId);
        b.put(localCommentEntry.feedId, Integer.valueOf(localCommentEntry.commentId));
      }
    }
    SLog.d("StoryFailCommentCacher", "update failed comments. size = %d.", new Object[] { Integer.valueOf(a.size()) });
  }
  
  public void c()
  {
    a.clear();
    b.clear();
    c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.StoryFailCommentCacher
 * JD-Core Version:    0.7.0.1
 */