package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import android.app.Activity;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import java.util.ArrayList;
import tvf;
import utd;
import uuq;
import uus;
import veg;
import vel;

public class MemoriesVideoListSegment$2$1
  implements Runnable
{
  public MemoriesVideoListSegment$2$1(uus paramuus, ArrayList paramArrayList1, int paramInt, ArrayList paramArrayList2, QQUserUIItem paramQQUserUIItem) {}
  
  public void run()
  {
    Object localObject = new OpenPlayerBuilder(new MemoriesFeedPlayInfo(uuq.a(this.jdField_a_of_type_Uus.jdField_a_of_type_Uuq).jdField_a_of_type_JavaLangString, (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int), this.jdField_a_of_type_Uus.b, String.valueOf(uuq.a(this.jdField_a_of_type_Uus.jdField_a_of_type_Uuq).hashCode()), this.b, uuq.a(this.jdField_a_of_type_Uus.jdField_a_of_type_Uuq).b, 0), StoryMemoriesFragment.a(this.jdField_a_of_type_Uus.jdField_a_of_type_Uuq.jdField_a_of_type_Int));
    ((OpenPlayerBuilder)localObject).a(uuq.a(this.jdField_a_of_type_Uus.jdField_a_of_type_Uuq));
    ((OpenPlayerBuilder)localObject).c();
    tvf.a((Activity)uuq.a(this.jdField_a_of_type_Uus.jdField_a_of_type_Uuq), ((OpenPlayerBuilder)localObject).a(), this.jdField_a_of_type_Uus.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null)
    {
      veg.d("Q.qqstory.memories.MemoriesVideoListSegment", "userManager returns null with id %s", new Object[] { uuq.a(this.jdField_a_of_type_Uus.jdField_a_of_type_Uuq).jdField_a_of_type_JavaLangString });
      return;
    }
    int i = StoryMemoriesFragment.a(this.jdField_a_of_type_Uus.jdField_a_of_type_Uuq.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()) {}
    for (localObject = "1";; localObject = "2")
    {
      vel.a("memory", "clk_video", i, 0, new String[] { localObject, "", "", this.jdField_a_of_type_Uus.b });
      veg.b("Q.qqstory.memories.MemoriesVideoListSegment", "go to player , collection key = %s, feedIds = %s , vid = %s , keyIndex = %s , video pos = %d , keyList = %s", new Object[] { this.jdField_a_of_type_Uus.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Uus.b, Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Uus.jdField_a_of_type_Int), this.b });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment.2.1
 * JD-Core Version:    0.7.0.1
 */