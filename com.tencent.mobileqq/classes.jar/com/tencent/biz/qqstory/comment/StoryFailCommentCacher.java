package com.tencent.biz.qqstory.comment;

import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.SuperManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class StoryFailCommentCacher
{
  private static StoryFailCommentCacher jdField_a_of_type_ComTencentBizQqstoryCommentStoryFailCommentCacher;
  private static HashMap jdField_a_of_type_JavaUtilHashMap;
  private static HashSet jdField_a_of_type_JavaUtilHashSet;
  
  public static StoryFailCommentCacher a()
  {
    if (jdField_a_of_type_ComTencentBizQqstoryCommentStoryFailCommentCacher == null)
    {
      jdField_a_of_type_ComTencentBizQqstoryCommentStoryFailCommentCacher = new StoryFailCommentCacher();
      jdField_a_of_type_JavaUtilHashSet = new HashSet();
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
      Iterator localIterator = ((CommentManager)SuperManager.a(17)).a().iterator();
      while (localIterator.hasNext())
      {
        CommentEntry localCommentEntry = (CommentEntry)localIterator.next();
        if (!jdField_a_of_type_JavaUtilHashSet.contains(localCommentEntry.feedId))
        {
          jdField_a_of_type_JavaUtilHashSet.add(localCommentEntry.feedId);
          jdField_a_of_type_JavaUtilHashMap.put(localCommentEntry.feedId, Integer.valueOf(localCommentEntry.commentId));
        }
      }
    }
    return jdField_a_of_type_ComTencentBizQqstoryCommentStoryFailCommentCacher;
  }
  
  public void a()
  {
    jdField_a_of_type_JavaUtilHashSet.clear();
    jdField_a_of_type_JavaUtilHashMap.clear();
    jdField_a_of_type_ComTencentBizQqstoryCommentStoryFailCommentCacher = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.StoryFailCommentCacher
 * JD-Core Version:    0.7.0.1
 */