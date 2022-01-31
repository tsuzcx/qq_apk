package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import android.app.Activity;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import java.util.ArrayList;
import vod;
import wmb;
import wno;
import wnq;
import wxe;
import wxj;

public class MemoriesVideoListSegment$2$1
  implements Runnable
{
  public MemoriesVideoListSegment$2$1(wnq paramwnq, ArrayList paramArrayList1, int paramInt, ArrayList paramArrayList2, QQUserUIItem paramQQUserUIItem) {}
  
  public void run()
  {
    Object localObject = new OpenPlayerBuilder(new MemoriesFeedPlayInfo(wno.a(this.jdField_a_of_type_Wnq.jdField_a_of_type_Wno).jdField_a_of_type_JavaLangString, (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int), this.jdField_a_of_type_Wnq.b, String.valueOf(wno.a(this.jdField_a_of_type_Wnq.jdField_a_of_type_Wno).hashCode()), this.b, wno.a(this.jdField_a_of_type_Wnq.jdField_a_of_type_Wno).b, 0), StoryMemoriesFragment.a(this.jdField_a_of_type_Wnq.jdField_a_of_type_Wno.jdField_a_of_type_Int));
    ((OpenPlayerBuilder)localObject).a(wno.a(this.jdField_a_of_type_Wnq.jdField_a_of_type_Wno));
    ((OpenPlayerBuilder)localObject).c();
    vod.a((Activity)wno.a(this.jdField_a_of_type_Wnq.jdField_a_of_type_Wno), ((OpenPlayerBuilder)localObject).a(), this.jdField_a_of_type_Wnq.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null)
    {
      wxe.d("Q.qqstory.memories.MemoriesVideoListSegment", "userManager returns null with id %s", new Object[] { wno.a(this.jdField_a_of_type_Wnq.jdField_a_of_type_Wno).jdField_a_of_type_JavaLangString });
      return;
    }
    int i = StoryMemoriesFragment.a(this.jdField_a_of_type_Wnq.jdField_a_of_type_Wno.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()) {}
    for (localObject = "1";; localObject = "2")
    {
      wxj.a("memory", "clk_video", i, 0, new String[] { localObject, "", "", this.jdField_a_of_type_Wnq.b });
      wxe.b("Q.qqstory.memories.MemoriesVideoListSegment", "go to player , collection key = %s, feedIds = %s , vid = %s , keyIndex = %s , video pos = %d , keyList = %s", new Object[] { this.jdField_a_of_type_Wnq.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Wnq.b, Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Wnq.jdField_a_of_type_Int), this.b });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment.2.1
 * JD-Core Version:    0.7.0.1
 */