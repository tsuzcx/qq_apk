package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import android.app.Activity;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import java.util.ArrayList;
import xbp;
import xzn;
import yba;
import ybc;
import ykq;
import ykv;

public class MemoriesVideoListSegment$2$1
  implements Runnable
{
  public MemoriesVideoListSegment$2$1(ybc paramybc, ArrayList paramArrayList1, int paramInt, ArrayList paramArrayList2, QQUserUIItem paramQQUserUIItem) {}
  
  public void run()
  {
    Object localObject = new OpenPlayerBuilder(new MemoriesFeedPlayInfo(yba.a(this.jdField_a_of_type_Ybc.jdField_a_of_type_Yba).jdField_a_of_type_JavaLangString, (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int), this.jdField_a_of_type_Ybc.b, String.valueOf(yba.a(this.jdField_a_of_type_Ybc.jdField_a_of_type_Yba).hashCode()), this.b, yba.a(this.jdField_a_of_type_Ybc.jdField_a_of_type_Yba).b, 0), StoryMemoriesFragment.a(this.jdField_a_of_type_Ybc.jdField_a_of_type_Yba.jdField_a_of_type_Int));
    ((OpenPlayerBuilder)localObject).a(yba.a(this.jdField_a_of_type_Ybc.jdField_a_of_type_Yba));
    ((OpenPlayerBuilder)localObject).c();
    xbp.a((Activity)yba.a(this.jdField_a_of_type_Ybc.jdField_a_of_type_Yba), ((OpenPlayerBuilder)localObject).a(), this.jdField_a_of_type_Ybc.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null)
    {
      ykq.d("Q.qqstory.memories.MemoriesVideoListSegment", "userManager returns null with id %s", new Object[] { yba.a(this.jdField_a_of_type_Ybc.jdField_a_of_type_Yba).jdField_a_of_type_JavaLangString });
      return;
    }
    int i = StoryMemoriesFragment.a(this.jdField_a_of_type_Ybc.jdField_a_of_type_Yba.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()) {}
    for (localObject = "1";; localObject = "2")
    {
      ykv.a("memory", "clk_video", i, 0, new String[] { localObject, "", "", this.jdField_a_of_type_Ybc.b });
      ykq.b("Q.qqstory.memories.MemoriesVideoListSegment", "go to player , collection key = %s, feedIds = %s , vid = %s , keyIndex = %s , video pos = %d , keyList = %s", new Object[] { this.jdField_a_of_type_Ybc.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Ybc.b, Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Ybc.jdField_a_of_type_Int), this.b });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment.2.1
 * JD-Core Version:    0.7.0.1
 */