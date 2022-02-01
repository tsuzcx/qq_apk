package com.tencent.biz.pubaccount.readinjoy.comment;

import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.OnDataChangeListener;
import java.util.ArrayList;
import java.util.List;

public class RIJCommentResultDispatcher
{
  private static List<ReadInJoyCommentDataManager.OnDataChangeListener> a;
  
  private RIJCommentResultDispatcher()
  {
    a = new ArrayList();
  }
  
  public static RIJCommentResultDispatcher a()
  {
    return RIJCommentResultDispatcher.CommentControllerHolder.a();
  }
  
  public List<ReadInJoyCommentDataManager.OnDataChangeListener> a()
  {
    if (a == null) {
      return null;
    }
    return a;
  }
  
  public void a()
  {
    if (a != null) {
      a.clear();
    }
  }
  
  public void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    if ((paramOnDataChangeListener == null) || (a == null)) {}
    while (a.contains(paramOnDataChangeListener)) {
      return;
    }
    a.add(paramOnDataChangeListener);
  }
  
  public void b(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    if ((a == null) || (a.size() == 0)) {
      return;
    }
    a.remove(paramOnDataChangeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.RIJCommentResultDispatcher
 * JD-Core Version:    0.7.0.1
 */