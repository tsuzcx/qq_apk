package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.database.StoryEntry;
import com.tencent.mobileqq.persistence.EntityManager;
import wte;

public class StoryManager$2
  implements Runnable
{
  public StoryManager$2(wte paramwte, EntityManager paramEntityManager, StoryEntry paramStoryEntry, String paramString, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseStoryEntry, StoryEntry.getUidSelectionNoArg(), new String[] { String.valueOf(this.jdField_a_of_type_JavaLangString), String.valueOf(this.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.StoryManager.2
 * JD-Core Version:    0.7.0.1
 */