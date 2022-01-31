package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import android.app.Activity;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import java.util.ArrayList;
import tvc;
import uta;
import uun;
import uup;
import ved;
import vei;

public class MemoriesVideoListSegment$2$1
  implements Runnable
{
  public MemoriesVideoListSegment$2$1(uup paramuup, ArrayList paramArrayList1, int paramInt, ArrayList paramArrayList2, QQUserUIItem paramQQUserUIItem) {}
  
  public void run()
  {
    Object localObject = new OpenPlayerBuilder(new MemoriesFeedPlayInfo(uun.a(this.jdField_a_of_type_Uup.jdField_a_of_type_Uun).jdField_a_of_type_JavaLangString, (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int), this.jdField_a_of_type_Uup.b, String.valueOf(uun.a(this.jdField_a_of_type_Uup.jdField_a_of_type_Uun).hashCode()), this.b, uun.a(this.jdField_a_of_type_Uup.jdField_a_of_type_Uun).b, 0), StoryMemoriesFragment.a(this.jdField_a_of_type_Uup.jdField_a_of_type_Uun.jdField_a_of_type_Int));
    ((OpenPlayerBuilder)localObject).a(uun.a(this.jdField_a_of_type_Uup.jdField_a_of_type_Uun));
    ((OpenPlayerBuilder)localObject).c();
    tvc.a((Activity)uun.a(this.jdField_a_of_type_Uup.jdField_a_of_type_Uun), ((OpenPlayerBuilder)localObject).a(), this.jdField_a_of_type_Uup.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null)
    {
      ved.d("Q.qqstory.memories.MemoriesVideoListSegment", "userManager returns null with id %s", new Object[] { uun.a(this.jdField_a_of_type_Uup.jdField_a_of_type_Uun).jdField_a_of_type_JavaLangString });
      return;
    }
    int i = StoryMemoriesFragment.a(this.jdField_a_of_type_Uup.jdField_a_of_type_Uun.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()) {}
    for (localObject = "1";; localObject = "2")
    {
      vei.a("memory", "clk_video", i, 0, new String[] { localObject, "", "", this.jdField_a_of_type_Uup.b });
      ved.b("Q.qqstory.memories.MemoriesVideoListSegment", "go to player , collection key = %s, feedIds = %s , vid = %s , keyIndex = %s , video pos = %d , keyList = %s", new Object[] { this.jdField_a_of_type_Uup.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Uup.b, Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Uup.jdField_a_of_type_Int), this.b });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment.2.1
 * JD-Core Version:    0.7.0.1
 */