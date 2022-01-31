package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import android.app.Activity;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import java.util.ArrayList;
import tij;
import ugh;
import uhu;
import uhw;
import urk;
import urp;

public class MemoriesVideoListSegment$2$1
  implements Runnable
{
  public MemoriesVideoListSegment$2$1(uhw paramuhw, ArrayList paramArrayList1, int paramInt, ArrayList paramArrayList2, QQUserUIItem paramQQUserUIItem) {}
  
  public void run()
  {
    Object localObject = new OpenPlayerBuilder(new MemoriesFeedPlayInfo(uhu.a(this.jdField_a_of_type_Uhw.jdField_a_of_type_Uhu).jdField_a_of_type_JavaLangString, (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int), this.jdField_a_of_type_Uhw.b, String.valueOf(uhu.a(this.jdField_a_of_type_Uhw.jdField_a_of_type_Uhu).hashCode()), this.b, uhu.a(this.jdField_a_of_type_Uhw.jdField_a_of_type_Uhu).b, 0), StoryMemoriesFragment.a(this.jdField_a_of_type_Uhw.jdField_a_of_type_Uhu.jdField_a_of_type_Int));
    ((OpenPlayerBuilder)localObject).a(uhu.a(this.jdField_a_of_type_Uhw.jdField_a_of_type_Uhu));
    ((OpenPlayerBuilder)localObject).c();
    tij.a((Activity)uhu.a(this.jdField_a_of_type_Uhw.jdField_a_of_type_Uhu), ((OpenPlayerBuilder)localObject).a(), this.jdField_a_of_type_Uhw.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null)
    {
      urk.d("Q.qqstory.memories.MemoriesVideoListSegment", "userManager returns null with id %s", new Object[] { uhu.a(this.jdField_a_of_type_Uhw.jdField_a_of_type_Uhu).jdField_a_of_type_JavaLangString });
      return;
    }
    int i = StoryMemoriesFragment.a(this.jdField_a_of_type_Uhw.jdField_a_of_type_Uhu.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()) {}
    for (localObject = "1";; localObject = "2")
    {
      urp.a("memory", "clk_video", i, 0, new String[] { localObject, "", "", this.jdField_a_of_type_Uhw.b });
      urk.b("Q.qqstory.memories.MemoriesVideoListSegment", "go to player , collection key = %s, feedIds = %s , vid = %s , keyIndex = %s , video pos = %d , keyList = %s", new Object[] { this.jdField_a_of_type_Uhw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Uhw.b, Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Uhw.jdField_a_of_type_Int), this.b });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment.2.1
 * JD-Core Version:    0.7.0.1
 */