package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import android.app.Activity;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import java.util.ArrayList;
import wmu;
import xks;
import xmf;
import xmh;
import xvv;
import xwa;

public class MemoriesVideoListSegment$2$1
  implements Runnable
{
  public MemoriesVideoListSegment$2$1(xmh paramxmh, ArrayList paramArrayList1, int paramInt, ArrayList paramArrayList2, QQUserUIItem paramQQUserUIItem) {}
  
  public void run()
  {
    Object localObject = new OpenPlayerBuilder(new MemoriesFeedPlayInfo(xmf.a(this.jdField_a_of_type_Xmh.jdField_a_of_type_Xmf).jdField_a_of_type_JavaLangString, (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int), this.jdField_a_of_type_Xmh.b, String.valueOf(xmf.a(this.jdField_a_of_type_Xmh.jdField_a_of_type_Xmf).hashCode()), this.b, xmf.a(this.jdField_a_of_type_Xmh.jdField_a_of_type_Xmf).b, 0), StoryMemoriesFragment.a(this.jdField_a_of_type_Xmh.jdField_a_of_type_Xmf.jdField_a_of_type_Int));
    ((OpenPlayerBuilder)localObject).a(xmf.a(this.jdField_a_of_type_Xmh.jdField_a_of_type_Xmf));
    ((OpenPlayerBuilder)localObject).c();
    wmu.a((Activity)xmf.a(this.jdField_a_of_type_Xmh.jdField_a_of_type_Xmf), ((OpenPlayerBuilder)localObject).a(), this.jdField_a_of_type_Xmh.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null)
    {
      xvv.d("Q.qqstory.memories.MemoriesVideoListSegment", "userManager returns null with id %s", new Object[] { xmf.a(this.jdField_a_of_type_Xmh.jdField_a_of_type_Xmf).jdField_a_of_type_JavaLangString });
      return;
    }
    int i = StoryMemoriesFragment.a(this.jdField_a_of_type_Xmh.jdField_a_of_type_Xmf.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()) {}
    for (localObject = "1";; localObject = "2")
    {
      xwa.a("memory", "clk_video", i, 0, new String[] { localObject, "", "", this.jdField_a_of_type_Xmh.b });
      xvv.b("Q.qqstory.memories.MemoriesVideoListSegment", "go to player , collection key = %s, feedIds = %s , vid = %s , keyIndex = %s , video pos = %d , keyList = %s", new Object[] { this.jdField_a_of_type_Xmh.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Xmh.b, Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Xmh.jdField_a_of_type_Int), this.b });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment.2.1
 * JD-Core Version:    0.7.0.1
 */